package edu.val.miswebsfavoritas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class ActividadWeb extends AppCompatActivity {

    private WebView webView;//vista para representar una web HTML
    private static final String WEB_LOCAL = "file:///android_asset/aviso.html";
    private static final String WEB_REMOTA = "https://www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_web);
        this.webView = findViewById(R.id.webview);
        //CARGAR la página local aviso que hay en assets
        //this.webView.loadUrl(WEB_LOCAL);
        //CARGAR UNA WEB REMOTA
        this.webView.loadUrl(WEB_REMOTA);//para poder cargar una web remota, necesito darle el permiso de conexión a internet


    }
}