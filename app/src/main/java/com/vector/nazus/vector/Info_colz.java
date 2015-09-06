package com.vector.nazus.vector;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.fitness.data.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NAZUS on 8/11/2015.
 */
public class Info_colz extends Activity implements OnItemSelectedListener , View.OnClickListener {
    int x,y;
    String pcm[],pca[],pcn[],links[],map_loc[],pocm[],poa[],pon[],cadd[],cn[],kum[],tuc[],pucc[],ku,pocc[];
    String kua,kulink,kun;
    //String [] splist={"CIVIL","ELECTRONICS","COMPUTER","ELECTRICAL"};
    TextView tvt, tvr,tvp,tvpr,ca;
    Button bt;
    String [][] s= new String[100][100];
    String [][] poc= new String[100][100];
    String [][] puc= new String[100][100];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_college);
        Intent ig=getIntent();
        Bundle b=ig.getExtras();
        y=b.getInt("cln");
        x=b.getInt("univ");
        bt=(Button)findViewById(R.id.mapbt);
        bt.setOnClickListener(this);
        tuc=getResources().getStringArray(R.array.colleges);
        pucc=getResources().getStringArray(R.array.pcollege);
        pocc=getResources().getStringArray(R.array.po_colleges);
        ku="KU";
        kum=getResources().getStringArray(R.array.ku_map);
        pcm=getResources().getStringArray(R.array.pc_map);
        pocm=getResources().getStringArray(R.array.po_map);
        map_loc=getResources().getStringArray(R.array.maploc);
        cadd=getResources().getStringArray(R.array.cinfo);
        cn=getResources().getStringArray(R.array.cphone);
        Spinner sp=(Spinner)findViewById(R.id.spinner);
        List<String> categories = new ArrayList<String>();
        categories.add("SELECT FACULTIES");
        categories.add("CIVIL");
        categories.add("COMPUTER");
        if(x==1){
            categories.add("ELECTRL & ELECTRONICS ");
            categories.add("CHEMICAL ENGG.");
        }
        else {
            categories.add("ELECTRONICS ");
            categories.add("ELECTRICAL");
        }
        if(x==2||x==3) {
            categories.add("SOFTWARE ENGG.");
        }
        else {
            categories.add("MECHANICAL");
        }
        categories.add("INDUSTRIAL");
        categories.add("AGRICULTURE");
        categories.add("ARCHITECTURE");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
       // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        //attaching data adapter to spinner
        sp.setAdapter(dataAdapter);
        sp.setOnItemSelectedListener(this);
        //sp.setBackgroundColor(Color.parseColor("#7ca8e893"));
        tvt=(TextView)findViewById(R.id.total);
        tvr=(TextView)findViewById(R.id.regular);
        tvpr=(TextView)findViewById(R.id.fee);
        tvp=(TextView)findViewById(R.id.partial);
        ca=(TextView)findViewById(R.id.c_add);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (x == 0) {
            setTitle(tuc[y]);
            s[0] = getResources().getStringArray(R.array.c);
            s[1] = getResources().getStringArray(R.array.acem);
            s[2] = getResources().getStringArray(R.array.thapathali);
            s[3] = getResources().getStringArray(R.array.wrc);
            s[4] = getResources().getStringArray(R.array.kec);
            s[5] = getResources().getStringArray(R.array.kecd);
            s[6] = getResources().getStringArray(R.array.national);
            s[7] = getResources().getStringArray(R.array.himalayan);
            s[8] = getResources().getStringArray(R.array.sagarmatha);
            s[9] = getResources().getStringArray(R.array.lec);
            s[10] = getResources().getStringArray(R.array.janakpur);
            s[11] = getResources().getStringArray(R.array.erc);
            s[12] = getResources().getStringArray(R.array.kat);
            s[13] = getResources().getStringArray(R.array.khowpa);
            links = getResources().getStringArray(R.array.Tu_link);
            int j = position;
            j = j * 4;
            tvt.setText(s[y][j + 0]);
            tvr.setText(s[y][j + 1]);
            tvp.setText(s[y][j + 2]);
            tvpr.setText(s[y][j + 3]);
            ca.setText(cadd[y] + System.getProperty("line.separator") + cn[y] + System.getProperty("line.separator") + links[y]);
        }
        if (x == 1) {
            setTitle(ku);
            kua = getResources().getString(R.string.kuadd);
            kun = getResources().getString(R.string.kun);
            s[0] = getResources().getStringArray(R.array.ku);
            kulink = getResources().getString(R.string.ku_link);
            int j = position;
            j = j * 4;
            tvt.setText(s[y][j + 0]);
            tvr.setText(s[y][j + 1]);
            tvp.setText(s[y][j + 2]);
            tvpr.setText(s[y][j + 3]);
            ca.setText(kua + System.getProperty("line.separator") + kun + System.getProperty("line.separator") + kulink);
        }
            if (x == 2) {
                setTitle(pocc[y]);
                poa = getResources().getStringArray(R.array.po_add);
                pon = getResources().getStringArray(R.array.po_no);
                s[0] = getResources().getStringArray(R.array.po1);
                s[1] = getResources().getStringArray(R.array.po2);
                s[2] = getResources().getStringArray(R.array.pou);
                s[2+1] = getResources().getStringArray(R.array.po3);
                s[3+1] = getResources().getStringArray(R.array.po4);
                s[4+1] = getResources().getStringArray(R.array.po5);
                s[5+1] = getResources().getStringArray(R.array.po6);
                s[6+1] = getResources().getStringArray(R.array.po7);
                s[7+1] = getResources().getStringArray(R.array.po8);
                links = getResources().getStringArray(R.array.po_link);
                int j = position;
                j = j * 4;
                tvt.setText(s[y][j + 0]);
                tvr.setText(s[y][j + 1]);
                tvp.setText(s[y][j + 2]);
                tvpr.setText(s[y][j + 3]);
                ca.setText(poa[y] + System.getProperty("line.separator") + pon[y] + System.getProperty("line.separator") + links[y]);
            }
            if (x == 3) {
                setTitle(pucc[y]);
                pca = getResources().getStringArray(R.array.pc_add);
                pcn = getResources().getStringArray(R.array.pc_no);
                s[0] = getResources().getStringArray(R.array.p1);
                s[1] = getResources().getStringArray(R.array.p2);
                s[2] = getResources().getStringArray(R.array.p3);
                s[3] = getResources().getStringArray(R.array.p4);
                s[4] = getResources().getStringArray(R.array.p5);
                s[5] = getResources().getStringArray(R.array.p6);
                s[6] = getResources().getStringArray(R.array.p7);
                s[7] = getResources().getStringArray(R.array.p8);
                s[8] = getResources().getStringArray(R.array.p9);
                s[9] = getResources().getStringArray(R.array.p10);
                links = getResources().getStringArray(R.array.pc_links);
                int j = position;
                j = j * 4;
                tvt.setText(s[y][j + 0]);
                tvr.setText(s[y][j + 1]);
                tvp.setText(s[y][j + 2]);
                tvpr.setText(s[y][j + 3]);
                ca.setText(pca[y] + System.getProperty("line.separator") + pcn[y] + System.getProperty("line.separator") + links[y]);
            }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
       //////////////
    }

    @Override
    public void onClick(View v) {
        if(x==0)
        {
        Intent itt= new Intent("android.intent.action.map");
            itt.putExtra("mapl",map_loc);
            itt.putExtra("cn",y);
        startActivity(itt);
        }
        if(x==1)
        {
            Intent itt= new Intent("android.intent.action.map");
            itt.putExtra("mapl",kum);
            itt.putExtra("cn",0);
            startActivity(itt);
        }
        if(x==2)
        {
            Intent itt= new Intent("android.intent.action.map");
            itt.putExtra("mapl",pocm);
            itt.putExtra("cn",y);
            startActivity(itt);
        }
        if(x==3)
        {
            Intent itt= new Intent("android.intent.action.map");
            itt.putExtra("mapl",pcm);
            itt.putExtra("cn",y);
            startActivity(itt);
        }
    }
}
