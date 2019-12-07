package com.a4455jkjh.text;

import android.app.Activity;
import android.os.Bundle;
import com.a4455jkjh.text.highlighting.SmaliHighlighting;

public class MainActivity extends Activity {
  private TextView textView;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    textView = new EditText(this);
    textView.setHighlighting(new SmaliHighlighting());
    setContentView(textView);
  }
  
}
