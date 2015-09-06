package com.vector.nazus.vector;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
/**
 * Created by NAZUS on 7/29/2015.
 * list of clollege shown here,
 */
public class Collges extends Fragment implements AdapterView.OnItemClickListener{
    String [][] colz =new String[20][20];
    String [][] info=new String[20][20];
    Activity ac;
    Bundle bd;
    Intent it;
    private  int ucolz_no;
    private  String s;
    ListView clv;
    int pp;
    TextView ts;
    @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle g= getArguments();
        ucolz_no=g.getInt("uposit");
        s=g.getString("check");
        ac=getActivity();
        View v = Fragment_function(container);
        return v;
    }
     View Fragment_function(ViewGroup vg) {
         View vi;
         int i=ucolz_no;

              if(i==0)
              {
                  getActivity().setTitle("TRIBHUWAN UNIVERSITY");
                  colz[i] = getResources().getStringArray(R.array.colleges);
              }
              if(i==2) {
                  getActivity().setTitle("POKHARA UNIVERSITY");
                  colz[i] = getResources().getStringArray(R.array.po_colleges);
              }
              if(i==3)
                 {
                     getActivity().setTitle("PURWANCHAL UNIVERSITY");
                  colz[i] = getResources().getStringArray(R.array.pcollege);
                 }
             LayoutInflater inflate = ac.getLayoutInflater();
             vi= inflate.inflate(R.layout.college, vg, false);
             clv = (ListView) vi.findViewById(R.id.c_listview);
             lcollege lc = new lcollege(ac,colz[i]);
             clv.setAdapter(lc);
             clv.setDivider(new ColorDrawable(Color.parseColor("#BD050505")));
             clv.setDividerHeight(10);
             clv.setOnItemClickListener(this);
             return vi;
     }
    @Override
    public void onItemClick(AdapterView<?> parent, View v_c, int position, long id)
    {
        {
            pp=position;
            it=new Intent("android.intent.action.in");
            bd =new Bundle();
            bd.putInt("cln",pp);
            bd.putInt("univ", ucolz_no);
            it.putExtras(bd);
            startActivity(it);
        }
    }
}
 class lcollege extends ArrayAdapter<String>
{
    private final String [] lists;
    private final Activity ct;

 public lcollege(Activity acc,String []st)
 {
     super(acc, R.layout.list_college, st);
     lists=st;
     ct=acc;
 }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater lf=ct.getLayoutInflater();
        View vc=lf.inflate(R.layout.list_college, parent, false);
        TextView tvc=(TextView)vc.findViewById(R.id.clist);
        tvc.setText(lists[position]);
       return  vc;
    }
}