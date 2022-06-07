package edu.val.miswebsfavoritas;

public class WebFavorita {

    private String nombre_sitio;
    private String url_sitio;
    private int logo_web;

    public WebFavorita(String nombre_sitio, String url_sitio, int logo_web) {
        //this es la nueva web- EN EL CONSTRUCTOR, THIS repsesenta a la instancia nueva, la que se está creando
        this.nombre_sitio = nombre_sitio;
        this.url_sitio = url_sitio;
        this.logo_web = logo_web;
    }

    public String getNombre_sitio() {
        //cuando aparece THIS en otro método que no sea el constructor
        //es el objeto llamante/llamador
        return this.nombre_sitio;
    }

    public void setNombre_sitio(String nombre_sitio) {
        this.nombre_sitio = nombre_sitio;
    }

    public String getUrl_sitio() {
        return this.url_sitio;
    }

    public void setUrl_sitio(String url_sitio) {
        this.url_sitio = url_sitio;
    }

    public int getLogo_web() {
        return this.logo_web;
    }

    public void setLogo_web(int logo_web) {
        this.logo_web = logo_web;
    }
}
