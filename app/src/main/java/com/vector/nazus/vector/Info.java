package com.vector.nazus.vector;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by NAZUS on 7/30/2015.
 */
public class Info extends Activity
{
   int x;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        Intent iit=getIntent();
        x=iit.getIntExtra("pos",0);
        if(x!=1) {
            Collges c = new Collges();
            Bundle b = new Bundle();
            b.putString("check", "colz_list");
            b.putInt("uposit", x);
            c.setArguments(b);
            // Toast.makeText(getApplicationContext(),"IOE COLLEGES", Toast.LENGTH_SHORT).show();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fg, c);
            ft.commit();
        }
        else
        {
           Intent ni=new Intent("android.intent.action.in");
           Bundle bdd =new Bundle();
            bdd.putInt("cln",0);
            bdd.putInt("univ",x);
            ni.putExtras(bdd);
            startActivity(ni);
            this.finish();
        }

    }
}
