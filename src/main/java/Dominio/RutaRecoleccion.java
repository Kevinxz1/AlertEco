package Dominio;

public class RutaRecoleccion {
    private int idRuta;
    private String sector;
    private String coordenadasMapa;
    private String frecuenciaSemanal;
    private String horaEstimada;

    //sin parametros
    public RutaRecoleccion(){

    }

    public RutaRecoleccion(int idRuta, String sector, String coordenadasMapa, String frecuenciaSemanal, String horaEstimada) {
        this.idRuta = idRuta;
        this.sector = sector;
        this.coordenadasMapa = coordenadasMapa;
        this.frecuenciaSemanal = frecuenciaSemanal;
        this.horaEstimada = horaEstimada;
    }

    // Get
    public int getIdRuta(){
        return idRuta;
    }
    public String getSector(){
        return sector;
    }
    public String getCoordenadasMapa(){
        return coordenadasMapa;
    }
    public String getFrecuenciaSemanal(){
        return frecuenciaSemanal;
    }
    public String getHoraEstimada(){
        return horaEstimada;
    }

    //Setters
    public void setIdRuta(int idRuta){
        // Validación interna
        if (idRuta > 0) {
            this.idRuta = idRuta;
        } else {
            System.out.println("Error: El ID de la ruta debe ser positivo.");
        }
    }
    public void setSector(String sector){
        this.sector = sector;
    }
    public void setCoordenadasMapa(String coordenadasMapa){
        this.coordenadasMapa = coordenadasMapa;
    }
    public void setFrecuenciaSemanal(String frecuenciaSemanal){
        this.frecuenciaSemanal = frecuenciaSemanal;
    }
    public void setHoraEstimada(String horaEstimada){
        this.horaEstimada = horaEstimada;
    }

    @Override
    public String toString() {
        return "Ruta [" + idRuta + "]: Sector " + sector + ", Frecuencia: " + frecuenciaSemanal + " a las " + horaEstimada;
    }
}