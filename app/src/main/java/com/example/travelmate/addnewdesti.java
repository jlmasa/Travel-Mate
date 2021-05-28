package com.example.travelmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class addnewdesti extends AppCompatActivity {
    EditText destination, address, latitude, longitude,feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewdesti);

        destination = (EditText) findViewById(R.id.edDestination);
        address = (EditText) findViewById(R.id.edaddress);
        latitude = (EditText) findViewById(R.id.edlat);
        longitude = (EditText) findViewById(R.id.edlong);
        feedback = (EditText)findViewById(R.id.edFeedback);

    }

    public void cancel(View view) {
        Intent cancel = new Intent(addnewdesti.this, MapsActivity.class);
        startActivity(cancel);
    }

    public void SAVE (View view){
        RequestQueue queue = Volley.newRequestQueue(this);

        //connection from the webserver
        String url = "http://masaclouddatabase.x10host.com/travelmate/_insert(1).php";

        //use stringrequest for sending values (id, name and age)
        //POST-data are secured while GET method-data are displayed on a address bar
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            Toast.makeText(getApplicationContext(), obj.getString("response"), Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        // response
                        Log.d("Response", response);

                    }
                },
                new Response.ErrorListener()
                {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.toString());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();

                //parameters to insert?

                params.put("destination",destination.getText().toString());
                params.put("address",address.getText().toString());
                params.put("latitude",latitude.getText().toString());
                params.put("longitude",longitude.getText().toString());
                params.put("feedback",feedback.getText().toString());


                return params;
            }

        };

        queue.add(postRequest);


    }
}

