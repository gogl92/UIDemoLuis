package com.ajay.freelancer.uidemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapDetailActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private List<Messages> messagesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.BLACK);
        }
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

       // this.requestWindowFeature(Window.FEATURE_NO_TITLE);

//Remove notification bar
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        overridePendingTransition(R.anim.pull_in_from_left, R.anim.hold);

        setContentView(R.layout.content_map_detail);
        ImageView close=(ImageView)findViewById(R.id.close);
        ImageView navigation=(ImageView)findViewById(R.id.navigation);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.pull_in_from_left, R.anim.hold);

            }
        });

        navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr=20.344,34.34&daddr=20.5666,45.345"));
                startActivity(intent);
            }
        });
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        ListView rv = (ListView)findViewById(R.id.list);
        initializeData();
        MapDetailListAdapter adapter = new MapDetailListAdapter(messagesList,this);

        rv.setAdapter(adapter);

        new ShowcaseView.Builder(this)
            //   .withMaterialShowcase()
                .setTarget(new ViewTarget(R.id.navigation, this))
                .setContentTitle("Feature title")
                .setContentText("Learn more about this feature in a sentence or two. Its great!")
                .setStyle(R.style.CustomShowcaseTheme2)
                .build();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //  55.680419, 12.579727
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(55.680419, 12.579727);
        mMap.addMarker(new MarkerOptions().position(sydney).title("").icon(BitmapDescriptorFactory.fromResource(R.drawable.mappin)));
        // mMap.
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 16.0f));

        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney),12.0f);
    }
    private void initializeData(){
        messagesList = new ArrayList<>();
        messagesList.add(new Messages("Restaurant Mos Eisley", "Mos Eisley, Tatooine","", R.drawable.grey_map_marker));
        messagesList.add(new Messages("+385 01 2345 678", "","", R.drawable.grey_call));
        messagesList.add(new Messages("contact@example.com", "","", R.drawable.grey_msg));
        messagesList.add(new Messages("Today 08:00 - 21:00", "","", R.drawable.grey_time));

    }
}
