package edu.val.miswebsfavoritas;

//JAVA BEAN - POJO - BEAN
//es una clase sencillita, que tiene: sus atributos, el constructor y los métodos de acceso
public class WebFavorita {

    private String nombre_sitio;
    private String url_sitio;
    private int logo_web;

    public WebFavorita(String nombre_sitio, String url_sitio, int logo_web) {
        this.nombre_sitio = nombre_sitio;
        this.url_sitio = url_sitio;
        this.logo_web = logo_web;
    }

    public String getNombre_sitio() {
        return nombre_sitio;
    }

    public void setNombre_sitio(String nombre_sitio) {
        this.nombre_sitio = nombre_sitio;
    }

    public String getUrl_sitio() {
        return url_sitio;
    }

    public void setUrl_sitio(String url_sitio) {
        this.url_sitio = url_sitio;
    }

    public int getLogo_web() {
        return logo_web;
    }

    public void setLogo_web(int logo_web) {
        this.logo_web = logo_web;
    }
}
