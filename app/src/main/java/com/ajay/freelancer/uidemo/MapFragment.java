package com.ajay.freelancer.uidemo;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (rootView == null)
            {
                rootView = inflater.inflate(R.layout.activity_map, container, false);
            }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
//        GoogleMap map = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
//        GoogleMap mGoogleMap = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map)).getMap();

        return rootView;
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
      //  55.680419, 12.579727
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(55.680419, 12.579727);
        mMap.addMarker(new MarkerOptions().position(sydney).title("").icon(BitmapDescriptorFactory.fromResource(R.drawable.mappin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(55.682105, 12.580765)).title("").icon(BitmapDescriptorFactory.fromResource(R.drawable.mappin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(55.682057, 12.581280)).title("").icon(BitmapDescriptorFactory.fromResource(R.drawable.mappin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(55.682777, 12.580797)).title("").icon(BitmapDescriptorFactory.fromResource(R.drawable.mappin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(55.680557, 12.587503)).title("").icon(BitmapDescriptorFactory.fromResource(R.drawable.mappin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(55.681549, 12.575272)).title("").icon(BitmapDescriptorFactory.fromResource(R.drawable.mappin)));
        // mMap.
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 14.0f));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

            @Override
            public boolean onMarkerClick(Marker arg0) {
                Intent intent=new Intent(getActivity(),MapDetailActivity.class);
                getActivity().startActivity(intent);
                      return true;
            }

        });
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney),12.0f);
    }
}
