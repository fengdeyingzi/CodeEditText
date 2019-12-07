package com.a4455jkjh.text;
import android.app.Application;

public class App extends Application
{

  @Override
  public void onCreate() {
    super.onCreate();
    EditorSettings.init(this);
  }
  
}
