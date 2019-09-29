package com.example.googlemap;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;





public class MainActivity extends AppCompatActivity {


    private WebView webView;
    private GoogleMap map;
    private EditText src;
    private EditText des;
    private Button getlocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webView = (WebView) findViewById(R.id.webview);
        src=(EditText)findViewById(R.id.editText);
        des=(EditText)findViewById(R.id.editText2);
        getlocation=(Button) findViewById(R.id.button);

        webView.setWebViewClient(new WebViewClient());

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webView.loadUrl("https://directionsdebug.firebaseapp.com/embed.html?origin=Bup&destination=Bup&mode=driving");

        getlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String SRC = src.getText().toString().trim();
               String DES = des.getText().toString().trim();

               locationmap(SRC,DES);


            }
        });



    }
    public void locationmap(String SRC,String DES)
    {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webView.loadUrl("https://directionsdebug.firebaseapp.com/embed.html?origin=" + SRC + "&destination=" + DES + "&mode=driving");

    }

}
