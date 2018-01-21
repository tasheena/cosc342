package com.cs342.projtwo;

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

public class MapEnterLocationActivity extends AppCompatActivity {


    EditText fromEdit;
    EditText toEdit;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_enter_location);

        fromEdit = (EditText) findViewById(R.id.fromInput);
        toEdit = (EditText) findViewById(R.id.toInput);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void openMapsActivityWithLocations(View view) {


        Intent mapIntent = new Intent(this, MapsActivity2.class);
        String toStr = toEdit.getText().toString();
        String fromStr = fromEdit.getText().toString();
        if (toStr.equals("") || fromStr.equals("")) { //any other catch cases?
            toEdit.setText("please enter two valid locations");
        }
        else {
            LatLng toLoc = getLocationFromAddress(this.getApplicationContext(), toStr);
            LatLng fromLoc = getLocationFromAddress(this.getApplicationContext(), fromStr);
            double[] doubleArray = {fromLoc.latitude, fromLoc.longitude, toLoc.latitude, toLoc.longitude};
            mapIntent.putExtra("ARRAY", doubleArray);
            startActivity(mapIntent);
        }
    }

    public void GoTo1(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }


    public LatLng getLocationFromAddress(Context context, String strAddress) {

        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng p1 = null;

        try {
            // May throw an IOException
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1 = new LatLng(location.getLatitude(), location.getLongitude());

        } catch (IOException ex) {
            //maybe we put error messages here? in case the LatLongs are bad
            ex.printStackTrace();
        }
        //Log.d("latlong", p1.toString());
        return p1;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("MapEnterLocation Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}

