package com.example.venkatesh.pyrolam;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;


import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Divyank on 22-04-2017.
 */

/*
public class FireFighterHomePage extends AppCompatActivity implements OnMapReadyCallback {
    Double lat,longi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_demo);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                lat = null;
                longi=null;
            } else {
                lat = extras.getDouble("lat");
                longi = extras.getDouble("longi");
            }
        }


        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    */

/**
 * This is where we can add markers or lines, add listeners or move the camera. In this case,
 * we
 * just add a marker near Africa.
 *//*

    @Override
    public void onMapReady(GoogleMap map) {

        LatLng place = new LatLng(lat, longi);
        map.addMarker(new MarkerOptions().position(place).title("Marker"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(place,15.0f));

    }


}
*/



    public class FireFighterHomePage extends FragmentActivity {

        private List<Marker> markers = new ArrayList<Marker>();
        private GoogleMap googleMap;
        private final Handler mHandler = new Handler();
        private Marker selectedMarker;
        private Animator animator = new Animator();
        public Button start, stop, ResetMarker;
        Double lat, longi;
        LatLng latLng, place;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            try {
                PlacePicker.IntentBuilder intentBuilder =
                        new PlacePicker.IntentBuilder();
                Intent intent = intentBuilder.build(this);
                // Start the intent by requesting a result,
                // identified by a request code.
                startActivityForResult(intent, 1);

            } catch (GooglePlayServicesRepairableException e) {
                // ...
            } catch (GooglePlayServicesNotAvailableException e) {
                // ...
            }

            setContentView(R.layout.basic_demo);
            loadMap();
            clearMarkers();


        /*if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                latLng = null;
            } else {
                latLng = extras.getParcelable("latLong");

            }
        }*/

            //addMarkerToMap(latLng);

            latLng = new LatLng(-37.259959 , 148.739794);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259912 , 148.739829);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259792 , 148.739845);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259805 , 148.739907);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259801 , 148.73996);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259833 , 148.740035);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259831 , 148.740111);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259856 , 148.740156);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259741 , 148.74021);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259786 , 148.740255);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259797 , 148.740312);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259788 , 148.740403);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259814 , 148.74047);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259837 , 148.74054);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259837 , 148.74054);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259912 , 148.740575);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259797 , 148.74062);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259827 , 148.740714);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259724 , 148.740768);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259799 , 148.740805);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259777 , 148.740888);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259765 , 148.740998);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259829 , 148.740993);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259797 , 148.74106);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259852 , 148.741052);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259805 , 148.741127);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259743 , 148.74125);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259696 , 148.741342);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259750 , 148.741334);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259701 , 148.74143);addMarkerToMap(latLng);
            latLng = new LatLng(-37.259669 , 148.741519);addMarkerToMap(latLng);


            animator.startAnimation(false);
        /*googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place,25.0f));*/


        /*animator.startAnimation(false);*/

        /*start = (Button) findViewById(R.id.btn_play);
        stop = (Button) findViewById(R.id.btn_stop);
        ResetMarker = (Button) findViewById(R.id.btn_clearmarker);

        ResetMarker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearMarkers();
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator.startAnimation(false);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator.stopAnimation();
            }
        });

        loadMap();
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng latLng) {
                addMarkerToMap(latLng);
                animator.startAnimation(false);
            }
        });*/
        }

        public void clearMarkers() {
            googleMap.clear();
            markers.clear();
        }

        protected void removeSelectedMarker() {
            this.markers.remove(this.selectedMarker);
            this.selectedMarker.remove();
        }

        protected void addMarkerToMap(LatLng latLng) {
            Marker marker = googleMap.addMarker(new MarkerOptions().position(latLng).title("Fire Direction"));
            marker.setVisible(false);
            marker.setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.fire_1));
            markers.add(marker);
        }

        public class Animator implements Runnable {
            private static final int ANIMATE_SPEEED = 5000;
            private static final int ANIMATE_SPEEED_TURN = 7500;
            private static final int BEARING_OFFSET = 20;
            private final Interpolator interpolator = new LinearInterpolator();
            int currentIndex = 0;
            float tilt = 90;
            float zoom = 10.5f;
            boolean upward = true;
            long start = SystemClock.uptimeMillis();
            LatLng endLatLng = null;
            LatLng beginLatLng = null;
            boolean showPolyline = false;
            private Marker trackingMarker;

            public void reset() {
                resetMarkers();
                start = SystemClock.uptimeMillis();
                currentIndex = 0;
                endLatLng = getEndLatLng();
                beginLatLng = getBeginLatLng();

            }

            private void resetMarkers() {
                for (Marker marker : markers) {
                    marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                }
            }

            public void stop() {
                trackingMarker.remove();
                mHandler.removeCallbacks(animator);
            }

            private void highLightMarker(int index) {
                highLightMarker(markers.get(index));
            }

            private void highLightMarker(Marker marker) {
                marker.setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.fire_1));
                marker.showInfoWindow();
                marker.setVisible(true);
                selectedMarker = marker;
            }

            public void initialize(boolean showPolyLine) {
                reset();
                this.showPolyline = showPolyLine;
                highLightMarker(0);
                if (showPolyLine) {
                    polyLine = initializePolyLine();
                }
                // We first need to put the camera in the correct position for the first run (we need 2 markers for this).....
                LatLng markerPos = markers.get(0).getPosition();
                LatLng secondPos = markers.get(1).getPosition();
                setupCameraPositionForMovement(markerPos, secondPos);
            }

            private void setupCameraPositionForMovement(LatLng markerPos, LatLng secondPos) {
                float bearing = bearingBetweenLatLngs(markerPos, secondPos);
                trackingMarker = googleMap.addMarker(new MarkerOptions().position(markerPos)
                        .title("title")
                        .snippet("snippet"));
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(markerPos)
                        .bearing(bearing + BEARING_OFFSET)
                        .tilt(90)
                        .zoom(googleMap.getCameraPosition().zoom >= 25 ? googleMap.getCameraPosition().zoom : 25)
                        .build();
                trackingMarker.setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.fire_1));

                googleMap.animateCamera(
                        CameraUpdateFactory.newCameraPosition(cameraPosition),
                        ANIMATE_SPEEED_TURN,
                        new GoogleMap.CancelableCallback() {
                            @Override
                            public void onFinish() {
                                System.out.println("finished camera");
                                Log.e("animator before reset", animator + "");
                                animator.reset();
                                Log.e("animator after reset", animator + "");
                                Handler handler = new Handler();
                                handler.post(animator);
                            }

                            @Override
                            public void onCancel() {
                                System.out.println("cancelling camera");
                            }
                        });
            }

            public void navigateToPoint(LatLng latLng, boolean animate) {
                CameraPosition position = new CameraPosition.Builder().target(latLng).build();
                changeCameraPosition(position, animate);
            }

            private void changeCameraPosition(CameraPosition cameraPosition, boolean animate) {
                CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
                if (animate) {
                    googleMap.animateCamera(cameraUpdate);
                } else {
                    googleMap.moveCamera(cameraUpdate);
                }
            }

            private Location convertLatLngToLocation(LatLng latLng) {
                Location loc = new Location("someLoc");
                loc.setLatitude(latLng.latitude);
                loc.setLongitude(latLng.longitude);
                return loc;
            }

            private float bearingBetweenLatLngs(LatLng begin, LatLng end) {
                Location beginL = convertLatLngToLocation(begin);
                Location endL = convertLatLngToLocation(end);
                return beginL.bearingTo(endL);
            }

            public void toggleStyle() {
                if (GoogleMap.MAP_TYPE_NORMAL == googleMap.getMapType()) {
                    googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                } else {
                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
            }

            private Polyline polyLine;
            private PolylineOptions rectOptions = new PolylineOptions();

            private Polyline initializePolyLine() {
                rectOptions.add(markers.get(0).getPosition());
                return googleMap.addPolyline(rectOptions);
            }

            /**
             * Add the marker to the polyline.
             */
            private void updatePolyLine(LatLng latLng) {
                List<LatLng> points = polyLine.getPoints();
                points.add(latLng);
                polyLine.setPoints(points);
            }

            public void stopAnimation() {
                animator.stop();
            }

            public void startAnimation(boolean showPolyLine) {
                if (markers.size() > 2) {
                    animator.initialize(showPolyLine);
                }
            }

            @Override
            public void run() {
                long elapsed = SystemClock.uptimeMillis() - start;
                double t = interpolator.getInterpolation((float) elapsed / ANIMATE_SPEEED);
                Log.w("interpolator", t + "");
                double lat = t * endLatLng.latitude + (1 - t) * beginLatLng.latitude;
                double lng = t * endLatLng.longitude + (1 - t) * beginLatLng.longitude;
                Log.w("lat. lng", lat + "," + lng + "");
                LatLng newPosition = new LatLng(lat, lng);
                Log.w("newPosition", newPosition + "");

                trackingMarker.setPosition(newPosition);
                if (showPolyline) {
                    updatePolyLine(newPosition);
                }

                // It's not possible to move the marker + center it through a cameraposition update while another camerapostioning was already happening.
                //navigateToPoint(newPosition,tilt,bearing,currentZoom,false);
                //navigateToPoint(newPosition,false);

                if (t < 1) {
                    mHandler.postDelayed(this, 16);
                } else {
                    System.out.println("Move to next marker.... current = " + currentIndex + " and size = " + markers.size());
                    // imagine 5 elements -  0|1|2|3|4 currentindex must be smaller than 4
                    if (currentIndex < markers.size() - 2) {
                        currentIndex++;
                        endLatLng = getEndLatLng();
                        beginLatLng = getBeginLatLng();
                        start = SystemClock.uptimeMillis();
                        LatLng begin = getBeginLatLng();
                        LatLng end = getEndLatLng();
                        float bearingL = bearingBetweenLatLngs(begin, end);
                        highLightMarker(currentIndex);
                        CameraPosition cameraPosition = new CameraPosition.Builder()
                                .target(end) // changed this...
                                .bearing(bearingL + BEARING_OFFSET)
                                .tilt(tilt)
                                .zoom(googleMap.getCameraPosition().zoom)
                                .build();
                        googleMap.animateCamera(
                                CameraUpdateFactory.newCameraPosition(cameraPosition),
                                ANIMATE_SPEEED_TURN,
                                null
                        );
                        start = SystemClock.uptimeMillis();
                        mHandler.postDelayed(animator, 16);
                    } else {
                        currentIndex++;
                        highLightMarker(currentIndex);
                        stopAnimation();
                    }
                }
            }

            private LatLng getEndLatLng() {
                return markers.get(currentIndex + 1).getPosition();
            }

            private LatLng getBeginLatLng() {
                return markers.get(currentIndex).getPosition();
            }

            private void adjustCameraPosition() {
                if (upward) {
                    if (tilt < 90) {
                        tilt++;
                        zoom -= 0.01f;
                    } else {
                        upward = false;
                    }
                } else {
                    if (tilt > 0) {
                        tilt--;
                        zoom += 0.01f;
                    } else {
                        upward = true;
                    }
                }
            }
        }

        ;

        private void loadMap() {
            try {
                googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
                googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                googleMap.setMyLocationEnabled(true);
                googleMap.getUiSettings().setZoomControlsEnabled(true);
            } catch (Exception e) {
                e.toString();
            }
        }
    }
