package com.a4455jkjh.text;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Scroller;
import org.eclipse.jface.text.DocumentAdapter;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextChangeListener;
import org.eclipse.jface.text.TextChangingEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TextView extends View implements TextChangeListener {
  private static ExecutorService fExecutorService = Executors.newSingleThreadExecutor();
  private Runnable highlight = new Runnable(){
    @Override
    public void run() {
      first = mHighlighting.highlighhting(fDocumentAdapter.getText());
      postInvalidate();
    }
  };
  protected DocumentAdapter fDocumentAdapter;
  private GestureListener fGestureListener;
  private GestureDetector fGestureDetector;
  private ScaleGestureDetector fScaleGestureDetector;
  private TextStyle style;
  private Paint paint;
  private float lineHeight;
  private float lineNumberWidth;
  private float spaceWidth;
  private float descent;
  private Span first;
  Scroller fScroller;
	protected Selection fSelection;
  protected Caret caret;
  private EditorActionModeCallback fActionModeCallback;
  private boolean showSelectionBar;
  private ActionMode fActionMode;
  private Highlighting mHighlighting;

  private int textSize;

  public TextView(Context ctx) {
    super(ctx);
    init(ctx);
  }

  public TextView(Context ctx, AttributeSet a) {
    super(ctx, a);
    init(ctx);
  }

  @Override
  public void textChanging(TextChangingEvent event) {
    int pos = caret.pos;
    int start = event.start;
    int end = start + event.replaceCharCount;
    if (pos > end)
      pos = pos - event.replaceCharCount + event.newCharCount;
    else if (pos >= start)
      pos = start + event.newCharCount;
    caret.pos = pos;

  }

  @Override
  public void textChanged() {
    compute();
    invalidate();
  }

  @Override
  public void textSet() {
    resetView();
  }
  public IDocument getDocument() {
    return fDocumentAdapter.getDocument();
  }

  public void showMessage(String title, String localizedMessage) {
    // TODO: Implement this method
  }

  protected void init(Context ctx) {
    mHighlighting = Highlighting.DefaultHighlighting.INSTANCE;
    showSelectionBar = false;
    fActionMode = null;
    setVerticalScrollBarEnabled(true);
    setVerticalScrollbarPosition(SCROLLBAR_POSITION_RIGHT);
    setScrollBarStyle(SCROLLBARS_INSIDE_OVERLAY);
    fScroller = new Scroller(ctx);
    textSize = 14;
    fActionModeCallback = new EditorActionModeCallback();
    clipboard = (ClipboardManager) ctx.getSystemService(Context.CLIPBOARD_SERVICE);
    caret = new Caret();
		fSelection = new Selection();
    fDocumentAdapter = new DocumentAdapter();
    fDocumentAdapter.setText(EditorSettings.text_text);
    fDocumentAdapter.addTextChangeListener(this);
    style = TextStyle.DEFAULT_THEME;
    paint = EditorSettings.newPaint(14);
    fGestureListener = new GestureListener();
    setLongClickable(true);
		setOnLongClickListener(fGestureListener);
    fGestureDetector = new GestureDetector(ctx, fGestureListener);
    fScaleGestureDetector = new ScaleGestureDetector(ctx, new ScaleGestureListener());
    updatePaint();
    resetView();
  }
  public void setTextSize(int textSize) {
    textSize = Math.max(textSize, 8);
    textSize = Math.min(72, textSize);
    if (textSize == this.textSize)
      return;
    this.textSize = textSize;
    float size = EditorSettings.getTextSize(textSize);
    paint.setTextSize(size);
    paint.setStrokeWidth(size / 20f);
    float y = getScrollY() / lineHeight;
    float x = getScrollX() / spaceWidth;
    updatePaint();
    float tx = x * spaceWidth;
    float ty = y * lineHeight;
    updateBars();
    scrollTo((int)tx, (int)ty);
    invalidate();
  }

  private void resetView() {
    first = Span.DEFAULT_SPAN;
    moveCaret(0);
    fSelection.reset();
    compute();
    scrollTo(0,0);
  }

  private void compute() {
    int lineCount = fDocumentAdapter.getLineCount();
    if (EditorSettings.showLineNumber) {
      lineNumberWidth = (String.valueOf(lineCount).length() + 1) * spaceWidth;
    }
    fGestureListener.maxHeight = lineCount * lineHeight;
    highlight();
    moveCaret(caret.pos);
  }
  protected void highlight() {
    fExecutorService.execute(highlight);
  }
  @Override
  public boolean onTouchEvent(MotionEvent event) {
    fScaleGestureDetector.onTouchEvent(event);
    return fGestureDetector.onTouchEvent(event);
  }

  private void updatePaint() {
    Paint.FontMetrics metrics = paint.getFontMetrics();
    float height = metrics.bottom - metrics.top;
    lineHeight = height;
    descent = metrics.descent;
    spaceWidth = paint.measureText("W");
    compute();
  }
  public void setHighlighting(Highlighting mHighlighting) {
    this.mHighlighting = mHighlighting;
    highlight();
  }
  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    TextStyle style = this.style;
    canvas.drawColor(style.getBackgroundColor());
    float t = getScrollY();
    float l = getScrollX();
    float b = t + getHeight();
    float r = l + getWidth();
    int lineCount = fDocumentAdapter.getLineCount();
    int line = (int)(t / lineHeight);
    float top = line * lineHeight;
    float bottom = top + lineHeight;
    Span span = first;
    float w = 0;
    Paint paint = this.paint;
    while (line < lineCount) { 
      int off = fDocumentAdapter.getOffsetAtLine(line);
      span = Span.findSpanAtIndex(span, off);
      float w1 = drawLine(canvas, paint, top - 1, bottom, line, off, span, r, l);
      w = Math.max(w, w1);
      if (bottom > b)
        break;
      top = bottom;
      bottom = top + lineHeight;
      line++;
    }
    paint.setColor(style.getCaretColor());
    fSelection.draw(canvas, paint);
    fGestureListener.maxWidth = w;

  }

  @Override
  public void computeScroll() {
    Scroller scroller = this.fScroller;
    if (scroller.computeScrollOffset())
      scrollTo(scroller.getCurrX(), scroller.getCurrY());
  }
  protected boolean isBatchEdit() {
    return false;
  }
  private float drawLine(Canvas canvas, Paint paint, float top, float bottom, int line, int off, Span span, float r, float l) {
    TextStyle style = this.style;
    float x = 0;
    float y = bottom - descent;
    if (EditorSettings.showLineNumber) {
      x = lineNumberWidth;
      String text = String.valueOf(line + 1);
      paint.setColor(style.getLineNumberColor());
      canvas.drawText(text, 0, y, paint);
    }
    char[] cs = new char[2];
    String text = fDocumentAdapter.getLine(line);
    if (text == null)
      return 0;
    int col = 0;
    int len = text.length();
    int end = -1;
    int color = style.getForegroundColor();
		Selection fSelection = this.fSelection;
    if (line == caret.line && onCheckIsTextEditor() && !fSelection.isInSelection()) {
      paint.setColor(style.getCaretLineColor());
      canvas.drawRect(x, top, r, bottom, paint);
    }
    while (col <= len) {
      if (off > end) {
        end = span.stop;
        color = span.style.gerColor(style);
        paint.setFakeBoldText(span.style.isBold);
        span = span.next;
      }
      if (caret.show(off) && !fSelection.isInSelection()) {
        paint.setColor(style.getForegroundColor());
        canvas.drawLine(x, top, x, bottom, paint);
      }
      int count = 1;
      float w = spaceWidth;
      if (col == len)
        cs[0] = ' ';
      else {
        char ch = text.charAt(col);
        cs[0] = ch;
        if (ch != ' ') {
          if (Character.isHighSurrogate(ch) &&
              col + 1 < len) {
            ch = text.charAt(col + 1);
            if (Character.isLowSurrogate(ch)) {
              cs[1] = ch;
              count = 2;
            }
          }
        }
        w = paint.measureText(cs, 0, count);
      }
      float right = x + w;
			if (off >= fSelection.start() && off < fSelection.end()) {
				paint.setColor(style.getselectionColor());
				canvas.drawRect(x, top, right, bottom, paint);
				paint.setColor(style.getBackgroundColor());
			} else
				paint.setColor(color);
      if (right > l && x < r)
        canvas.drawText(cs, 0, count, x, y, paint);
      x = right;
      col += count;
      off += count;
    }
    return x;
  }
  public void onTouchDown(float x, float y) {
    if (fScroller.computeScrollOffset())
      fScroller.abortAnimation();
    x = x + getScrollX();
    y = y + getScrollY();
    fSelection.touchDown(x, y);
    caret.touchDown(x, y);
  }
  private void updateBars() {
    Position p = getPosition(fSelection.a.pos);
    fSelection.setA(p);
    p = getPosition(fSelection.b.pos);
    fSelection.setB(p);
    p = getPosition(caret.pos);
    caret.set(p);
  }
	protected Position getCursorPos(float x, float y) {
		int line = (int) ((y + getScrollY()) / lineHeight);
    line = Math.max(0, line);
    line = Math.min(line, fDocumentAdapter.getLineCount() - 1);
    x = x + getScrollX();
		Position p = new Position();
		int col = setX(p, line, -1, x);
		int pos = fDocumentAdapter.getOffsetAtLine(line);
    p.y = (1 + line) * lineHeight;
		p.line = line;
		p.column = col;
		p.pos = pos + col;
		return p;
	}

	protected void longPress(Position position) {
		String text = fDocumentAdapter.getLine(position.line);
		int column = position.column;
		if (column == text.length())
      return;
    int start = column - 1;
    for (; start >= 0; start--) {
      char ch = text.charAt(start);
      if (!Character.isJavaIdentifierPart(ch)) {
        start++;
        break;
      }
    }
    for (; column < text.length(); column++) {
      if (!Character.isJavaIdentifierPart(text.charAt(column)))
        break;
    }
    if (start < 0)
      start = 0;
    int off = fDocumentAdapter.getOffsetAtLine(position.line);
    showSelectionBar = true;
    setSelection(off + start, off + column);
	}
  public void setSelection(int start, int end) {
    Position p = getPosition(start);
    fSelection.setA(p);
    p = getPosition(end);
    fSelection.setB(p);
    postInvalidate();
    if (fSelection.isInSelection())
      fActionMode = startActionMode(fActionModeCallback, ActionMode.TYPE_PRIMARY);
  }
  Position getPosition(int pos) {
    Position p = new Position();
    int line = fDocumentAdapter.getLineAtOffset(pos);
    int col = fDocumentAdapter.getOffsetAtLine(line);
    col = pos - col;
    p.pos = pos;
    p.line = line;
    p.column = col;
    p.y = (1 + line) * lineHeight;
    setX(p, line, col, Float.MAX_VALUE);
    return p;
  }

  private int setX(TextView.Position p, int l, int length, float max) {
    int col = 0;
    float x = 0;
    String line = fDocumentAdapter.getLine(l);
    if (EditorSettings.showLineNumber)
      x += lineNumberWidth;
    if (length == -1)
      length = line.length();
    while (col < length) {
      int c = 1;
      if (Character.isHighSurrogate(line.charAt(col))) {
        int col2 = col + 1;
        if (col2 < length &&
            Character.isLowSurrogate(line.charAt(col2)))
          c = 2;

      }
      float w = paint.measureText(line, col, col + c);
      if (x + w / 2f > max)
        break;
      x += w;
      col += c;
    }
    p.x = x;
    return col;
	}
  protected boolean scroll(float x, float y) {
    if (fSelection.scroll(x, y))
      return true;
    if (caret.scroll(x, y))
      return true;
    return false;
  }
  public void moveCaret(int pos) {
    moveCaret(getPosition(pos));
  }
  private void moveCaret(Position position) {
    fSelection.setA(position);
    fSelection.setB(position);
    if (fActionMode != null)
      fActionMode.finish();
    showPosition(caret);
  }

  public IRegion getSelectionRegion() {
    int start = fSelection.start();
    int length = fSelection.end() - start;
    return new Region(start, length);
  }

  class ScaleGestureListener implements ScaleGestureDetector.OnScaleGestureListener {
    float cx, cy, x, y;
    @Override
    public boolean onScale(ScaleGestureDetector dector) {
      float scaleFactor = dector.getScaleFactor() - 1;
      if (Math.abs(scaleFactor) < 0.01f)
        return false;
      int size = textSize;
      if (scaleFactor > 0)
        size++;
      else
        size--;
      setTextSize(size);
      float tx = x * spaceWidth - cx;
      float ty = y * lineHeight - cy;
      tx = Math.max(0, tx);
      ty = Math.max(0, ty);
      scrollTo((int)tx, (int)ty);
      return true;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector p1) {
      cx = p1.getFocusX();
      cy = p1.getFocusY();
      x = (cx + getScrollX()) / spaceWidth;
      y = (cy + getScrollY()) / lineHeight;
      fGestureListener.isScale = true;
      return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector p1) {
      fGestureListener.isScale = false;
    }

  }
  protected void singleTapUp(float x, float y) {
    Position position = getCursorPos(x, y);
    moveCaret(position);
    caret.updateClick();
  }
  class GestureListener implements GestureDetector.OnGestureListener, View.OnLongClickListener {
    float maxWidth;
    float maxHeight;
    int scrollState;
    boolean isScale;
    GestureListener() {
      maxHeight = 0;
      maxWidth = 0;
      scrollState = 0;
      isScale = false;
    }

    @Override
    public boolean onDown(MotionEvent p1) {
      onTouchDown(p1.getX(), p1.getY());
      scrollState = 0;
      return true;
    }

    @Override
    public void onShowPress(MotionEvent p1) {
      // TODO: Implement this method
    }

    @Override
    public boolean onSingleTapUp(MotionEvent p1) {
      singleTapUp(p1.getX(), p1.getY());
      return true;
    }

    @Override
    public boolean onScroll(MotionEvent p1, MotionEvent p2, float dx, float dy) {
      if (isScale)
        return true;
      if (scroll(p2.getX(), p2.getY()))
        return true;
      if (scrollState == 0)
        setState(dx, dy);
      if (scrollState == 1)
        dy = 0;
      else
        dx = 0;
      float max = getMaxWidth();
      float toX = getScrollX() + dx;
      if (toX < 0)
        toX = 0;
      if (toX > max)
        toX = max;
      max = getMaxHeight();
      float toY = getScrollY() + dy;
      if (toY < 0)
        toY = 0;
      if (toY > max)
        toY = max;
      scrollTo((int)toX, (int)toY);
      return true;
    }
    private void setState(float dx, float dy) {
      if (Math.abs(dx) > Math.abs(dy))
        scrollState = 1;
      else
        scrollState = 2;
    }

    private float getMaxWidth() {
      int w = getWidth();
      float max = maxWidth;
      if (max < w)
        return 0;
      return max - w / 2;
    }
    private float getMaxHeight() {
      int h = getHeight();
      float max = maxHeight;
      if (max < h)
        return 0;
      return max - h / 2;
    }
    @Override
    public void onLongPress(MotionEvent p1) {
      performLongClick();
			Position position = getCursorPos(p1.getX(), p1.getY());
			longPress(position);
    }

    @Override
    public boolean onLongClick(View p1) {
      // TODO: Implement this method
      return true;
    }


    @Override
    public boolean onFling(MotionEvent p1, MotionEvent p2, float dx, float dy) {
      int x = getScrollX();
      fScroller.fling(
				getScrollX(), getScrollY(),
				0, (int)-dy,
				x, 0,
				x, (int)getMaxHeight());
      postInvalidate();
      return true;
    }
  }
  protected void showPosition(Position position) {
    float t = getScrollY();
    float l = getScrollX();
    float b = t + getHeight();
    float r = l + getWidth();
    float x = position.x;
    float y = position.y;
    float toX = l;
    float toY = t;
    if (x < l)
      toX = x - spaceWidth;
    else if (x > r)
      toX = x + spaceWidth - getWidth();
    if (y < t)
      toY = y - lineHeight;
    else if (y > b)
      toY = y + lineHeight - getHeight();
    if (toX != l || toY != t)
      scrollTo((int)toX, (int)toY);
    else
      invalidate();
  }

  class Selection {
		Position a;
		Position b;
    RectF rectA, rectB;
    Path pathA, pathB;
    boolean moveA, moveB;
    Selection() {
      rectA = new RectF();
      pathA = new Path();
      rectB = new RectF();
      pathB = new Path();
      a = new Position();
      b = new Position();
      reset();
    }

    void reset() {
      moveA = false;
      moveB = false;
    }
    void touchDown(float x, float y) {
      moveA = rectA.contains(x, y);
      moveB = rectB.contains(x, y);
    }
    public void draw(Canvas canvas, Paint paint) {
      if (isInSelection()) {
        if (showSelectionBar) {
          canvas.drawPath(pathA, paint);
          canvas.drawPath(pathB, paint);
        }
      } else
        caret.draw(canvas, paint);
    }

    void setB(TextView.Position p) {
      b.set(p);
      float sw = spaceWidth;
      float sw2 = sw * 2f;
      float x = p.x;
      float y = p.y;
      rectB.set(x, y, x + sw2, y + sw2);
      Path path = pathB;
      path.reset();
      path.moveTo(x, y);
      path.lineTo(x + sw, y);
      path.arcTo(rectB, -90, 270);
      path.close();
    }

    void setA(TextView.Position p) {
      caret.set(p);
      a.set(p);
      float sw = spaceWidth;
      float sw2 = sw * 2f;
      float x = p.x;
      float y = p.y;
      rectA.set(x - sw2, y, x, y + sw2);
      Path path = pathA;
      path.reset();
      path.moveTo(x, y);
      path.lineTo(x, y + sw);
      path.arcTo(rectA, 0, 270);
      path.close();
    }

		int start() {
			return Math.min(a.pos, b.pos);
		}
		int end() {
			return Math.max(a.pos, b.pos);
		}
    boolean isInSelection() {
      return a.pos != b.pos;
    }
    boolean scroll(float x, float y) {
      if (isInSelection() && showSelectionBar) {
        if (moveA) {
          Position p = getCursorPos(x, y - spaceWidth);
          setA(p);
          showPosition(p);
        } else if (moveB) {
          Position p = getCursorPos(x, y - spaceWidth);
          setB(p);
          showPosition(p);
        } else
          return false;
      } else
        return false;
      invalidate();
      return true;
    }
  }
	protected static class Position {
		public int line;
		public int column;
		public int pos;
    public float x, y;
    Position() {
      line = 0;
      column = 0;
      pos = 0;
    }
    void set(Position src) {
      line = src.line;
      column = src.column;
      pos = src.pos;
      x = src.x;
      y = src.y;
    }
    @Override
    public String toString() {
      return String.format("l:%d c:%d p:%d", line, column, pos);
    }
	}
  protected class Caret extends Position {
    RectF rect;
    Path path;
    boolean move;
    boolean showCaret = true;
    public long lastClickTime;

    Caret() {
      rect = new RectF();
      path = new Path();
      move = false;
    }

    public boolean show(int off) {
      return showCaret && onCheckIsTextEditor() && off == pos;
    }
    public long reset() {
      long t = System.currentTimeMillis() - lastClickTime;
      if (t < 1000) {
        showCaret = true;
        return 1000 - t;
      }
      showCaret = !showCaret;
      return 500;
    }
    public void updateClick() {
      lastClickTime = System.currentTimeMillis();
      showCaret = true;
    }
    void set() {
      float sw = spaceWidth;
      float sw2 = sw * 2f;
      float x = this.x;
      float y1 = this.y;
      float y = y1 + sw2 / 2f;
      float l = x - sw;
      float r = x + sw;
      rect.set(l, y, r, y + sw2);
      Path p = path;
      p.reset();
      p.moveTo(x, y1);
      float y3 = y + sw / 2f;
      p.quadTo(r, y3, r, y + sw);
      p.arcTo(rect, 0, 180);
      p.quadTo(l, y3, x, y1);
    }
    public void move() {
      lastClickTime = System.currentTimeMillis();
      showCaret = true;
    }
    void draw(Canvas c, Paint p) {
      if (onCheckIsTextEditor() &&
          System.currentTimeMillis() - lastClickTime < 3000)
        c.drawPath(path, p);
    }

    @Override
    void set(TextView.Position src) {
      super.set(src);
      set();
    }
    void touchDown(float x, float y) {
      move = System.currentTimeMillis() - lastClickTime < 3000 &&
        rect.contains(x, y);
    }
    boolean scroll(float x, float y) {
      if (move) {
        Position p = getCursorPos(x, y - spaceWidth);
        set(p);
        showPosition(p);
        updateClick();
        return true;
      }
      return false;
    }
  }
  protected IRegion copy() {
    IRegion region = getSelectionRegion();
    String text = fDocumentAdapter.
      getTextRange(region.getOffset(), region.getLength());
    ClipData plain = ClipData.newPlainText(null, text);
    clipboard.setPrimaryClip(plain);
    moveCaret(caret);
    return region;
  }
  protected void cut() {
    IRegion region = copy();
    fDocumentAdapter.replaceTextRange(region.getOffset(), region.getLength(), "");
  }
  protected void paste() {
    ClipData data = clipboard.getPrimaryClip();
    if (data.getItemCount() == 0)
      return;
    IRegion region = getSelectionRegion();
    String text = data.getItemAt(0).coerceToText(getContext()).toString();
    fDocumentAdapter.replaceTextRange(
      region.getOffset(), region.getLength(), text);
  }

  private ClipboardManager clipboard;
  class EditorActionModeCallback implements ActionMode.Callback {

    @Override
    public boolean onCreateActionMode(ActionMode p1, Menu p2) {
      p1.getMenuInflater().
        inflate(R.menu.editor_context, p2);
      return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode p1, Menu menu) {
      boolean onCheckIsTextEditor = onCheckIsTextEditor();
      menu.findItem(R.id.cut).setVisible(onCheckIsTextEditor);
      return true;
    }

    @Override
    public boolean onActionItemClicked(ActionMode p1, MenuItem menu) {
      switch (menu.getItemId()) {
        case R.id.copy:
          copy();
          break;
        case R.id.cut:
          cut();
          break;
      }
      p1.finish();
      return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode p1) {
      showSelectionBar = false;
    }
  }
}
