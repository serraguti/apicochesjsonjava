package models;

public class Coche {

    private int idCoche;
    private String marca;
    private String modelo;
    private String conductor;
    private String imagen;

    public Coche() {
    }

    public Coche(int idCoche, String marca, String modelo, String conductor, String imagen) {
        this.idCoche = idCoche;
        this.marca = marca;
        this.modelo = modelo;
        this.conductor = conductor;
        this.imagen = imagen;
    }

    public int getIdCoche() {
        return idCoche;
    }

    public void setIdCoche(int idCoche) {
        this.idCoche = idCoche;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
