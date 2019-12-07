package com.a4455jkjh.text;

import android.view.KeyEvent;
import java.util.EventListener;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.undo.DocumentUndoEvent;
import org.eclipse.text.undo.DocumentUndoManagerRegistry;
import org.eclipse.text.undo.IDocumentUndoListener;
import org.eclipse.text.undo.IDocumentUndoManager;

public class UndoManager {


  /**
   * Internal document undo listener.
   */
  private class DocumentUndoListener implements IDocumentUndoListener {

    @Override
    public void documentUndoNotification(DocumentUndoEvent event) {
      if (!isConnected()) return;

      /*int eventType= event.getEventType();
       if (((eventType & DocumentUndoEvent.ABOUT_TO_UNDO) != 0) || ((eventType & DocumentUndoEvent.ABOUT_TO_REDO) != 0))  {
       fTextViewer.getTextWidget().getDisplay().syncExec(new Runnable() {
       @Override
       public void run() {
       if (fTextViewer instanceof TextViewer)
       ((TextViewer)fTextViewer).ignoreAutoEditStrategies(true);
       }
       });

       } else if (((eventType & DocumentUndoEvent.UNDONE) != 0) || ((eventType & DocumentUndoEvent.REDONE) != 0))  {
       fTextViewer.getView().post(new Runnable() {
       @Override
       public void run() {
       if (fTextViewer instanceof TextViewer)
       ((TextViewer)fTextViewer).ignoreAutoEditStrategies(false);
       }
       });
       if (event.isCompound()) {
       ITextViewerExtension extension= null;
       if (fTextViewer instanceof ITextViewerExtension)
       extension= (ITextViewerExtension) fTextViewer;

       if (extension != null)
       extension.setRedraw(true);
       }

       // Reveal the change if this manager's viewer has the focus.
       if (fTextViewer != null) {
       StyledText widget= fTextViewer.getTextWidget();
       if (widget != null && !widget.isDisposed() && (widget.isFocusControl()))// || fTextViewer.getTextWidget() == control))
       selectAndReveal(event.getOffset(), event.getText() == null ? 0 : event.getText().length());
       }
       }*/
    }

  }


  /** The text viewer the undo manager is connected to */
  private TextView fTextView;

  /** The undo level */
  private int fUndoLevel;

  /** The document undo manager that is active. */
  private IDocumentUndoManager fDocumentUndoManager;

  /** The document that is active. */
  private IDocument fDocument;

  /** The document undo listener */
  private IDocumentUndoListener fDocumentUndoListener;

  /**
   * Creates a new undo manager who remembers the specified number of edit commands.
   *
   * @param undoLevel the length of this manager's history
   */
  public UndoManager(int undoLevel) {
    fUndoLevel = undoLevel;
  }
  
  public void commit() {
    if (isConnected())
      fDocumentUndoManager.commit();
  }

  /**
   * Returns whether this undo manager is connected to a text viewer.
   *
   * @return <code>true</code> if connected, <code>false</code> otherwise
   */
  private boolean isConnected() {
    return fTextView != null && fDocumentUndoManager != null;
  }

  /*
   * @see IUndoManager#beginCompoundChange
   */
  public void beginCompoundChange() {
    if (isConnected()) {
      fDocumentUndoManager.beginCompoundChange();
    }
  }


  /*
   * @see IUndoManager#endCompoundChange
   */
  public void endCompoundChange() {
    if (isConnected()) {
      fDocumentUndoManager.endCompoundChange();
    }
  }

  /**
   * Shows the given exception in an error dialog.
   *
   * @param title the dialog title
   * @param ex the exception
   */
  private void openErrorDialog(final String title, final Exception ex) {
    fTextView.showMessage(title, ex.getLocalizedMessage());
  }
  public void setMaximalUndoLevel(int undoLevel) {
    fUndoLevel = Math.max(0, undoLevel);
    if (isConnected()) {
      fDocumentUndoManager.setMaximalUndoLevel(fUndoLevel);
    }
  }

  public void connect(TextView textView) {
    if (fTextView == null && textView != null) {
      fTextView = textView;
    }
    IDocument doc= fTextView.getDocument();
    connectDocumentUndoManager(doc);
  }

  public void disconnect() {
    if (fTextView != null) {
      fTextView = null;
    }
    disconnectDocumentUndoManager();
  }

  public void reset() {
    if (isConnected())
      fDocumentUndoManager.reset();

  }

  public boolean redoable() {
    if (isConnected())
      return fDocumentUndoManager.redoable();
    return false;
  }

  public boolean undoable() {
    if (isConnected())
      return fDocumentUndoManager.undoable();
    return false;
  }

  public void redo() {
    if (isConnected()) {
      try {
        fDocumentUndoManager.redo();
      } catch (ExecutionException ex) {
        openErrorDialog("Redo Failed", ex); //$NON-NLS-1$
      }
    }
  }

  public void undo() {
    if (isConnected()) {
      try {
        fDocumentUndoManager.undo();
      } catch (ExecutionException ex) {
        openErrorDialog("Undo Failed", ex); //$NON-NLS-1$
      }
    }
  }

  public IUndoContext getUndoContext() {
    if (isConnected()) {
      return fDocumentUndoManager.getUndoContext();
    }
    return null;
  }

  public void connectDocumentUndoManager(IDocument document) {
    disconnectDocumentUndoManager();
    if (document != null) {
      fDocument = document;
      DocumentUndoManagerRegistry.connect(fDocument);
      fDocumentUndoManager = DocumentUndoManagerRegistry.getDocumentUndoManager(fDocument);
      fDocumentUndoManager.connect(this);
      setMaximalUndoLevel(fUndoLevel);
      fDocumentUndoListener = new DocumentUndoListener();
      fDocumentUndoManager.addDocumentUndoListener(fDocumentUndoListener);
      reset();
    }
  }

  public void disconnectDocumentUndoManager() {
    if (fDocumentUndoManager != null) {
      fDocumentUndoManager.disconnect(this);
      DocumentUndoManagerRegistry.disconnect(fDocument);
      fDocumentUndoManager.removeDocumentUndoListener(fDocumentUndoListener);
      fDocumentUndoListener = null;
      fDocumentUndoManager = null;
    }
  }
}
