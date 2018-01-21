package com.cs342.projtwo;


/**
import android.content.Intent;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.content.Context;
import android.content.Intent;
import android.location.Geocoder;
//THE LINE BELOW IS SUPER SUPER IMPORTANT!!! IT WONT WORK UNLESS YOU MANUALLY ENTER THIS LINE.
//OTHEWISE IT WILL AUTOMATICALLY IMPLEMENT A WRONG VERSION OF ADDRESS AND YOU WILL PULL ALL YOUR HAIR OUT
import android.location.Address; //<--- this one
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.vision.barcode.Barcode;

import java.io.IOException;
import java.util.List;


import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.vision.barcode.Barcode;

public class MyMapLocationActivity extends AppCompatActivity {

    EditText from;
    EditText to;
    String f1;
    String t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_map_location);
    }

    public void GoTo1(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void GoTo2(View view) {
        from = (EditText) findViewById(R.id.at1);
        to = (EditText) findViewById(R.id.at2);

        f1 = from.getText().toString();
        t1 = to.getText().toString();

        if (f1 != null && !f1.isEmpty() && t1 != null && !t1.isEmpty()) {


            {
                Intent intent = new Intent(this, MapsActivity2.class);
                startActivity(intent);
            }

        } else { // will say sth like: please enter location (we can be more precise n check each)//
             }
    }


}

*/