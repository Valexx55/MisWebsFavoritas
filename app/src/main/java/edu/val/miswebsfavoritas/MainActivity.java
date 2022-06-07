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

import java.util.List;

public class MainActivity extends AppCompatActivity {

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
        List<LinearLayout> linearLayouts;
        linearLayouts = List.of(this.linearWeb1,this.linearWeb2,this.linearWeb3, this.linearWeb4, this.linearWeb5, this.linearWeb6 );


        WebFavorita webFavorita = new WebFavorita("Chic", "https://www.libertaddigital.com/chic/", R.drawable.logochic);
        WebFavorita webFavorita2 = new WebFavorita("SoloBoxeo", "https://www.soloboxeo.com", R.drawable.logosoloboxeo);
        WebFavorita webFavorita3 = new WebFavorita("Jaleos", "https://www.elespanol.com/corazon/", R.drawable.logojaleos);
        WebFavorita webFavorita4 = new WebFavorita("Linkedin", "https://www.linkedin.com", R.drawable.linkedin);
        WebFavorita webFavorita5 = new WebFavorita("Marca", "https://www.marca.com", R.drawable.marca);
        WebFavorita webFavorita6 = new WebFavorita("As", "https://www.as.com", R.drawable.logo_as);

        List<WebFavorita> webFavoritaList = List.of(webFavorita, webFavorita2, webFavorita3, webFavorita4, webFavorita5, webFavorita6);

        int contador_web =0;
        //FOR EACH de JAVA
        for (LinearLayout linearActual : linearLayouts)
        {
            ImageView imageView = (ImageView) linearActual.getChildAt(0);
            WebFavorita web_actual = webFavoritaList.get(contador_web);
            imageView.setImageResource(web_actual.getLogo_web());
            imageView.setOnClickListener(this::imagenTocada);
            imageView.setTag(web_actual);//asocio a cada imagen, la información de la web asociada WEB FAVORITA
            //y así, cuando toque la imagen, ya voy a saber qué url VISITAR
            contador_web++;
        }
        //TODO HACER EL LAYOUT-LAND landscape apaisado

    }

    public void imagenTocada (View view)
    {
         WebFavorita webFavorita = (WebFavorita) view.getTag();//de la imagen, obtengo la webFavorita asociada
        String web = webFavorita.getUrl_sitio();
        Log.d("ETIQUETA_LOG", "QUIERE VISITAR " + web);
        Intent intent_implicito_web = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
        if (intent_implicito_web.resolveActivity(getPackageManager())!=null)
        {
            startActivity(intent_implicito_web);
        }
    }
}