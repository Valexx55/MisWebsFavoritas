package edu.val.miswebsfavoritas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout linearWeb1;
    private LinearLayout linearWeb2;
    private LinearLayout linearWeb3;
    private LinearLayout linearWeb4;
    private LinearLayout linearWeb5;
    private LinearLayout linearWeb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.linearWeb1 = findViewById(R.id.linearweb1);
        this.linearWeb2 = findViewById(R.id.linearweb2);
        this.linearWeb3 = findViewById(R.id.linearweb3);
        this.linearWeb4 = findViewById(R.id.linearweb4);
        this.linearWeb5 = findViewById(R.id.linearweb5);
        this.linearWeb6 = findViewById(R.id.linearweb6);

        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        //{

        //}

        //para cada cajita, le vamos a asociar su información correspondiente
        //recorrer los layouts e ir asignándole su WebFavorita (favicon, url, texto)
        List<LinearLayout> linearLayouts;
        linearLayouts = List.of(this.linearWeb1,this.linearWeb2,this.linearWeb3, this.linearWeb4, this.linearWeb5, this.linearWeb6 );

        /*ArrayList<LinearLayout> lista_linears = new ArrayList<LinearLayout>();
        lista_linears.add(linearWeb1);
        lista_linears.add(linearWeb2);
        lista_linears.add(linearWeb3);
        lista_linears.add(linearWeb4);
        lista_linears.add(linearWeb5);
        lista_linears.add(linearWeb6);*/


        WebFavorita webFavorita = new WebFavorita("Chic", "https://www.libertaddigital.com/chic/", R.drawable.logochic);
        WebFavorita webFavorita2 = new WebFavorita("SoloBoxeo", "https://www.soloboxeo.com", R.drawable.logosoloboxeo);
        WebFavorita webFavorita3 = new WebFavorita("Jaleos", "https://www.elespanol.com/corazon/", R.drawable.logojaleos);
        WebFavorita webFavorita4 = new WebFavorita("Linkedin", "https://www.linkedin.com", R.drawable.linkedin);
        WebFavorita webFavorita5 = new WebFavorita("Marca", "https://www.marca.com", R.drawable.marca);
        WebFavorita webFavorita6 = new WebFavorita("As", "https://www.as.com", R.drawable.logo_as);

        List<WebFavorita> webFavoritaList = List.of(webFavorita, webFavorita2, webFavorita3, webFavorita4, webFavorita5, webFavorita6);

        int contador_web =0;//índice, que me sirve para ir accediendo a los elementos de la otra lista
        //FOR EACH de JAVA: para cada linear, que haya en la lista de layotus
        //automáticamente, JAVA, va poniendo en la variable linearActual, el elemento de la lista que toca

        for (LinearLayout linearActual : linearLayouts)//aquí linearActual va a ser cada vez un elemento distinto de linearLayouts
        {
            ImageView imageView = (ImageView) linearActual.getChildAt(0);
            WebFavorita web_actual = webFavoritaList.get(contador_web);
            //web_actual.logo_web;
            imageView.setImageResource(web_actual.getLogo_web());
            //imageView.setOnClickListener(this);//onCLikc
            imageView.setOnClickListener(this::imagenTocada);//programar el listener: cuando te toquen, vas a llamar al método imangeTocada definido en esta clase this
            /*imageView.setOnClickListener(vista->{
                Log.d("ETIQUETA_LOG", "imagenTocada2");
            });*/
            imageView.setTag(web_actual);//asocio a cada imagen, la información de la web asociada WEB FAVORITA
            //y así, cuando toque la imagen, ya voy a saber qué url VISITAR
            contador_web++;
        }
        //TODO HACER EL LAYOUT-LAND landscape apaisado
        //TODO ABRIR LA WEB DESDE NUESTRA APP CON WEBVIEW
        //A Y 35 VOLVEMOS

    }

    public void imagenTocada (View view)
    {
        Log.d("ETIQUETA_LOG", "imagenTocada");
         WebFavorita webFavorita = (WebFavorita) view.getTag();//de la imagen, obtengo la webFavorita asociada
        String web = webFavorita.getUrl_sitio();
        Log.d("ETIQUETA_LOG", "QUIERE VISITAR " + web);
        Intent intent_implicito_web = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
        if (intent_implicito_web.resolveActivity(getPackageManager())!=null)
        {
            startActivity(intent_implicito_web);
        }
    }

    @Override
    public void onClick(View view) {
        Log.d("ETIQUETA_LOG", "ON CLICK");
    }
}