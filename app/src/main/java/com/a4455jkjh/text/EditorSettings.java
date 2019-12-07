package com.a4455jkjh.text;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import com.a4455jkjh.text.R;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class EditorSettings {
  public static Typeface typeface;
  public static boolean showLineNumber;
  public static boolean drawCaretLine;
  private static float sp;
  public static String text_text;

  public static float getTextSize(int textSize) {
    return textSize * sp;
  }
  public static Paint newPaint(int textSize) {
    Paint p = new Paint();
    p.setAntiAlias(true);
    p.setTypeface(typeface);
    float size = textSize * sp;
    p.setTextSize(size);
    p.setStrokeWidth(sp);
    return p;
  }
  public static void init(Context ctx) {
    Resources res = ctx.getResources();
    sp = res.getDimension(R.dimen.sp);
    AssetManager a = ctx.getAssets();
    try {
      InputStream i = a.open("a.txt");
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      byte[] bytes = new byte[1024];
      int num;
      while ((num = i.read(bytes)) > 0) {
        baos.write(bytes, 0, num);
      }
      text_text = baos.toString();
      i.close();
      baos.reset();
      baos.close();
    } catch (IOException e) {
      text_text = e.toString();
      e.printStackTrace();
    }
  }
  static {
    typeface = Typeface.MONOSPACE;
    showLineNumber = true;
    drawCaretLine = true;
  }
}
