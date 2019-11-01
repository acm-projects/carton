package com.example.cartonlogintest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONObject;

public class HomeActivity extends AppCompatActivity {
    RequestQueue requestQueue;
    Cache cache;
    Network network;

    Button logout;
    Button serverTest;
    FirebaseAuth mFirebaseAuth;
    String url = "http://polyblox.ddns.net/TestACM.php";
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cache = new DiskBasedCache(getCacheDir(),1024*1024);
        network = new BasicNetwork(new HurlStack());
        //requestQueue = Volley.newRequestQueue(this);
        requestQueue = new RequestQueue(cache,network);
        requestQueue.start();

        serverTest = findViewById(R.id.serverButton);
        serverTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObjectRequest jsonObject = new JsonObjectRequest
                        (Request.Method.POST,url,null, new Response.Listener<JSONObject>(){

                            @Override
                            public void onResponse(JSONObject response) {
                                serverTest.setText(response.toString());
                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                serverTest.setText(error.toString());
                            }
                        });
                requestQueue.add(jsonObject);
            }
        });

        logout = findViewById(R.id.btnLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent inToMain = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(inToMain);
            }
        });
    }
}
