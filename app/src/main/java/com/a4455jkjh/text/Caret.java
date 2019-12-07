package com.a4455jkjh.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

public class Caret {
  private Path path;
  private RectF bar;
  public float x, y, lineHeight;
  private long lastClickTime;
  public boolean showCursor = true;
  //光标位置，行 列
  public int line, col, pos;
  public boolean isMoveing;
  public Caret() {
    path = new Path();
    bar = new RectF();
    lastClickTime = 0;
    pos = 0;
    isMoveing = false;
  }
  public void update(float x, float y, float lineHeight, float spaceWidth) {
    this.x = x;
    this.y = y;
    this.lineHeight = lineHeight;
    path.reset();
    path.moveTo(x, y);
    float l = x - spaceWidth;
    float r = x + spaceWidth;
    float b = y + lineHeight + spaceWidth;
    float t = y + lineHeight - spaceWidth;
    bar.set(l, y, r, b);
    float y2 = y + (lineHeight / 2);
    path.cubicTo(x, y2, r, y2, r, y + lineHeight);
    path.arcTo(l, t, r, b, 0, 180, false);
    path.cubicTo(l, y2, x, y2, x, y);
  }
  public void updateClick() {
    lastClickTime = System.currentTimeMillis();
    showCursor = true;
  }
  public void draw(Canvas c, Paint p) {
    if (System.currentTimeMillis() - lastClickTime < 3000)
      c.drawPath(path, p);
  }
  public long reset() {
    long t = System.currentTimeMillis() - lastClickTime;
    if(t<1000){
      showCursor=true;
      return 1000-t;
    }
    showCursor = !showCursor;
    return 500;
  }
  public boolean contains(float x, float y) {
    if (System.currentTimeMillis() - lastClickTime > 3000)
      return false;
    return bar.contains(x, y);
  }
  public void startMove() {
    isMoveing = true;
    updateClick();
  }
  public void endMove() {
    isMoveing = false;
  }
}
