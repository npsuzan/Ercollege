package com.vector.nazus.vector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by NAZUS on 7/29/2015.
 */
public class Main_class extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        next t=new next();
        t.start();
     }
    public class next extends Thread
    {
        public next(){}
        public void run()
        {
          try{
              Thread.sleep(2000);
          }
          catch(InterruptedException e){

           }
          finally
          {
              Intent i=new Intent("android.intent.action.university");
              startActivity(i);
              // finish();
          }
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
