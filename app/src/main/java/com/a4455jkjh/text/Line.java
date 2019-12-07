package com.a4455jkjh.text;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Line extends View {
  public Line(Context ctx) {
    super(ctx);
  }

  public Line(Context ctx, AttributeSet a) {
    super(ctx, a);
  }
  Paint p = new Paint();
  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    p.setTextSize(40);
    p.setAntiAlias(true);
    Paint.FontMetrics m = p.getFontMetrics();
    float h = m.bottom - m.top;
    float y = h - m.descent;
    
    for (int i = 0; i < 100; i++) {
      canvas.drawText(String.valueOf(i + 1), 0, y, p);
      y+=h;
    }
  }

}
