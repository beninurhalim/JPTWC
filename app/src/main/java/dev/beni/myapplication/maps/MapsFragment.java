package dev.beni.myapplication.maps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import dev.beni.myapplication.R;
import dev.beni.myapplication.adapter.ViewPagerAdapter;

public class MapsFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_maps, container, false);
        return  view;
    }

    public void onViewCreated(View view,
                              Bundle savedInstanceState){
        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Borobudur and move the camera
        LatLng borobudur = new LatLng(-7.607355, 110.203804);
        mMap.addMarker(new MarkerOptions().position(borobudur).title("Marker in Borobudur"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom (borobudur, 12.0f));

//        LatLngBounds newarkBounds = new LatLngBounds(
//                new LatLng(-7.6102541,110.2053006),       // South west corner
//                new LatLng(-7.6014555,110.1988772));      // North east corner
//        GroundOverlayOptions newarkMap = new GroundOverlayOptions()
//                .image(BitmapDescriptorFactory.fromResource(R.drawable.borobudur))
//                .positionFromBounds(newarkBounds);
//        mMap.addGroundOverlay(newarkMap);

        GroundOverlayOptions newarkMap = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.borobudur))
                .position(borobudur, 8600f, 6500f);
        mMap.addGroundOverlay(newarkMap);

    }
}

