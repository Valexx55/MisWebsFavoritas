package edu.val.miswebsfavoritas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
       // this.webView.loadUrl(WEB_REMOTA);//para poder cargar una web remota, necesito darle el permiso de conexión a internet
        //CARGAR LA WEB QUE TRAE EL INTENT
        //para activar el JS en el webview
        this.webView.getSettings().setJavaScriptEnabled(true);
        Intent intent = getIntent();
        Uri uri = intent.getData();
        Log.d("ETIQUETA_LOG" , "la web que hay que cargar es " + uri.toString());
        this.webView.loadUrl(uri.toString());//CHROMIUM VERSIÓN LIGERA DE CHROME
        this.webView.setWebViewClient(new MyWebViewClient());

    }

    //personalizando el navegador
    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //si la url que quiere vistar, es una de las nuestras, me quedo en la app
            if ("www.marca.com".equals(Uri.parse(url).getHost()))
            {
                //si es una web de marca, la veo aquíç
                Log.d("ETIQUETA_LOG" , "quiere ver una web de marca, lo veo aquí");
                return false;
            }
            //si no, solicitamos abrirlo con el navegador

            Log.d("ETIQUETA_LOG" , "quiere ver una web de fuera, la veo en el navegador");
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);

            return true;
        }
    }

}