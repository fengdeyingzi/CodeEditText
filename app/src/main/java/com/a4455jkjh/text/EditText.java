package com.a4455jkjh.text;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import org.eclipse.jface.text.IRegion;

public class EditText extends TextView {
//  UndoManager fUndoManager;
  private static final String TAG = "EditText";
  private boolean isShiftPressed;
  public EditText(Context ctx) {
    super(ctx);
  }

  public EditText(Context ctx, AttributeSet a) {
    super(ctx, a);
  }

  @Override
  protected void init(Context ctx) {
    super.init(ctx);
    isShiftPressed = false;
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
//    fUndoManager = new UndoManager(500);
    try {
//      fUndoManager.connect(this);
    } catch (Exception e) {
      e.printStackTrace();
      Log.e(TAG, "init: "+e.toString());
    }
  }

  @Override
  public boolean onCheckIsTextEditor() {
    return true;
  }

  @Override
  public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
    if (fTextInputConnection == null)
      fTextInputConnection = new TextInputConnection(this);
    return fTextInputConnection;
  }
  private TextInputConnection fTextInputConnection;

  @Override
  public void onTouchDown(float x, float y) {
//    fUndoManager.commit();
    super.onTouchDown(x, y);
  }
  public void showIME(boolean show) {
    InputMethodManager im = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
    if (show) {
      im.showSoftInput(this, 0);
    } else {
      im.hideSoftInputFromWindow(this.getWindowToken(), 0);
    }
  }

  @Override
  protected void singleTapUp(float x, float y) {
    super.singleTapUp(x, y);
    showIME(true);
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    showPosition(caret);
    super.onSizeChanged(w, h, oldw, oldh);
  }
  protected void insert(String text) {
    IRegion region = getSelectionRegion();
    fDocumentAdapter.replaceTextRange(region.getOffset(), region.getLength(), text);
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    int cp = event.getUnicodeChar();
    if (cp != 0) {
      char[] chars = Character.toChars(cp);
      insert(new String(chars));
    } else {
      switch (keyCode) {
        case KeyEvent.KEYCODE_DEL:
          delete();
          break;
        case KeyEvent.KEYCODE_DPAD_UP:
          moveCaretUp();
          break;
        case KeyEvent.KEYCODE_DPAD_DOWN:
          moveCaretDown();
          break;
        case KeyEvent.KEYCODE_DPAD_LEFT:
          moveCaretLeft();
          break;
        case KeyEvent.KEYCODE_DPAD_RIGHT:
          moveCaretRight();
          break;
        case KeyEvent.KEYCODE_SHIFT_LEFT:
        case KeyEvent.KEYCODE_SHIFT_RIGHT:
          isShiftPressed = true;
          break;
        case KeyEvent.KEYCODE_HOME:
          moveCaret(0);
          break;
        case KeyEvent.KEYCODE_ENDCALL:
          moveCaret(fDocumentAdapter.getLineCount());
          break;
        default:
          return super.onKeyDown(keyCode, event);
      }
    }
    return true;
  }

  @Override
  public boolean onKeyUp(int keyCode, KeyEvent event) {
    switch (keyCode) {
      case KeyEvent.KEYCODE_SHIFT_LEFT:
      case KeyEvent.KEYCODE_SHIFT_RIGHT:
        isShiftPressed = false;
        break;
      default:
        return super.onKeyUp(keyCode, event);
    }
    return true;
  }

  private void moveCaretRight() {
    int pos = caret.pos;
    int charCount = fDocumentAdapter.getCharCount();
    if (pos == charCount)
      return;
    if (pos + 1 == charCount)
      pos = charCount;
    else {
      String t = fDocumentAdapter.getTextRange(pos, 2);
      if ((Character.isHighSurrogate(t.charAt(0)) &&
          Character.isLowSurrogate(t.charAt(1))) ||
          t.equals("\r\n"))
        pos += 2;
      else
        pos += 1;
    }
    moveCaret(pos);
  }

  @Override
  public void moveCaret(int pos) {
    if (isShiftPressed) {
      Position p = getPosition(pos);
      caret.set(p);
      fSelection.setA(p);
      showPosition(p);
      return;
    }
    caret.move();
    super.moveCaret(pos);
  }

  private void moveCaretLeft() {
    int pos = caret.pos;
    if (pos == 0)
      return;
    if (pos == 1)
      pos = 0;
    else {
      String t = fDocumentAdapter.getTextRange(pos - 2, 2);
      int length = 1;
      if ((Character.isLowSurrogate(t.charAt(1)) &&
          Character.isHighSurrogate(t.charAt(0))) ||
          t.equals("\r\n"))
        length = 2;
      pos = pos - length;
    }
    moveCaret(pos);
  }

  private void moveCaretDown() {
//    fUndoManager.commit();
    int line = caret.line + 1;
    if (line == fDocumentAdapter.getLineCount())
      return;
    int col = caret.column;
    int offset = fDocumentAdapter.getOffsetAtLine(line);
    String text = fDocumentAdapter.getLine(line);
    int l = Math.min(col, text.length());
    moveCaret(offset + l);
    caret.column = col;
  }

  private void moveCaretUp() {
//    fUndoManager.commit();
    int line = caret.line;
    if (line == 0)
      return;
    line--;
    int col = caret.column;
    int offset = fDocumentAdapter.getOffsetAtLine(line);
    String text = fDocumentAdapter.getLine(line);
    int l = Math.min(col, text.length());
    moveCaret(offset + l);
    caret.column = col;
  }

  private void delete() {
    IRegion region = getSelectionRegion();
    int start, length;
    if (region.getLength() > 0) {
      start = region.getOffset();
      length = region.getLength();
    } else {
      int pos = caret.pos;
      if (pos == 0)
        return;
      if (pos == 1) {
        start = 0;
        length = 1;
      } else {
        String t = fDocumentAdapter.getTextRange(pos - 2, 2);
        length = 1;
        if ((Character.isLowSurrogate(t.charAt(1)) &&
            Character.isHighSurrogate(t.charAt(0))) ||
            t.equals("\r\n"))
          length = 2;
        start = pos - length;
      }
    }
    fDocumentAdapter.replaceTextRange(start, length, "");
  }
  public void clearMetaKeyStates(int states) {
    if ((states & KeyEvent.META_SHIFT_ON) > 0)
      isShiftPressed = false;
  }

  Refresher cursorTimer = new Refresher();

  @Override
  public void onWindowFocusChanged(boolean hasWindowFocus) {
    super.onWindowFocusChanged(hasWindowFocus);
    //Toast.makeText(getContext(), String.valueOf(hasWindowFocus), 0).show();
    cursorTimer.cancel(!hasWindowFocus);
  }
  class Refresher implements Runnable {
    boolean cancel = false;
    @Override
    public void run() {
      if (cancel)
        return;
     long time = caret.reset();
      invalidate();
      postDelayed(this, time);
    }
    void cancel(boolean cancel) {
      this.cancel = cancel;
      run();
    }
  }

  @Override
  protected void highlight() {
    if (fTextInputConnection != null && fTextInputConnection.isBatchEdit)
      return;
    super.highlight();
  }

  static class TextInputConnection extends BaseInputConnection {
    EditText fEditText;
    boolean isBatchEdit = false;

    public TextInputConnection(EditText fEditText) {
      super(fEditText, true);
      this.fEditText = fEditText;
    }

    @Override
    public boolean beginBatchEdit() {
//      fEditText.fUndoManager.beginCompoundChange();
      isBatchEdit = true;
      return super.beginBatchEdit();
    }

    @Override
    public boolean endBatchEdit() {
//      fEditText.fUndoManager.endCompoundChange();
      isBatchEdit = false;
      fEditText.highlight();
      return super.endBatchEdit();
    }

    @Override
    public boolean commitText(CharSequence text, int newCursorPosition) {
      fEditText.insert(text.toString());
      return true;
    }

    @Override
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
      ExtractedText text = new ExtractedText();
      text.text = "text";
      text.selectionStart = 1;
      if (fEditText.getSelectionRegion().getLength() > 0)
        text.selectionEnd = 2;
      else
        text.selectionEnd = 1;
      return text;
    }

    @Override
    public boolean clearMetaKeyStates(int states) {
      fEditText.clearMetaKeyStates(states);
      return true;
    }

    @Override
    public boolean performContextMenuAction(int id) {
      switch (id) {
        case android.R.id.copy:
          fEditText.copy();
          break;
        case android.R.id.cut:
          fEditText.cut();
          break;
        case android.R.id.paste:
          fEditText.paste();
          break;
      }
      return true;
    }

  }
}
