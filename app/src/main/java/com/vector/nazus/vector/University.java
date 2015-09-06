package com.vector.nazus.vector;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by NAZUS on 7/29/2015.
 * listing universities.
 */
public class University extends Activity implements AdapterView.OnItemClickListener
{
    String [] uname={"TRIBHUWAN UNIVERSITY ","KATHMANDU UNIVERSITY","POKHARA UNIVERSITY","PURWANCHAL UNIVERSITY"};
    ListView lv;
    private View pv;
    private PopupWindow pw;
    public University() {
          }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universites);
        lv=(ListView)findViewById(R.id.listview);
        Ulists u=new Ulists(this,uname);
        lv.setAdapter(u);
        lv.setDivider(new ColorDrawable(Color.TRANSPARENT));
        lv.setDividerHeight(12);
        lv.setOnItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mf=getMenuInflater();
        mf.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
             about(item);
                         return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
        String Slecteditem = uname[+position];
        Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
        Intent it=new Intent("android.intent.action.info");
        it.putExtra("pos",position);
        startActivity(it);
    }
    void about(MenuItem item)
    {
        PopupWindow popup = new PopupWindow(University.this);
        View layout = getLayoutInflater().inflate(R.layout.about, null);
        popup.setContentView(layout);
        // Set content width and height
        popup.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popup.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        // Closes the popup window when touch outside of it - when looses focus
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        // Show anchored to button
     //   popup.setBackgroundDrawable(new BitmapDrawable());
        popup.showAtLocation(layout, Gravity.CENTER, 0, 0);

    }
 }

class Ulists extends ArrayAdapter<String>
{
    private final Activity c;
    private final String [] unames;
    public Ulists(Activity co,String[] st) {
        super(co, R.layout.list_university, st);
        this.c = co;
        this.unames=st;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater l=c.getLayoutInflater();
        View v=l.inflate(R.layout.list_university, null, true);
        TextView tv=(TextView)v.findViewById(R.id.ulist);
        tv.setText(unames[position]);
        return v;
    }
}
