package com.vector.nazus.vector;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends FragmentActivity implements OnMapReadyCallback {
    String mapp[];
    String cj[];
    int cnn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);
       // cj=getResources().getStringArray(R.array.colleges);
        Intent it=getIntent();
        mapp=it.getStringArrayExtra("mapl");
        cnn=it.getIntExtra("cn",0);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap map) {
        // Add a marker in Sydney, Australia, and move the camera.
        int j=cnn*2;
        double l1,l2;
        l1=Double.parseDouble(mapp[j]);
        l2=Double.parseDouble(mapp[j+1]);
        LatLng col= new LatLng(l1,l2);
        // map.moveCamera( CameraUpdateFactory.newLatLngZoom(sydney , 14.0f) );
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.addMarker(new MarkerOptions().position(col));//.title(cj[cnn]));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(col, 14.8f));;
    }
}