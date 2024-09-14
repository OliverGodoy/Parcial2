package umg.progra2.baseDatos.Model;

public class ModeloTelefonico {
    private int id;
    private String marca;
    private Integer camaraPrincipal;  // Integer para manejar valores nulos
    private Integer camaraFrontal;
    private String paisOrigen;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getCamaraPrincipal() {
        return camaraPrincipal;
    }

    public void setCamaraPrincipal(Integer camaraPrincipal) {
        this.camaraPrincipal = camaraPrincipal;
    }

    public Integer getCamaraFrontal() {
        return camaraFrontal;
    }

    public void setCamaraFrontal(Integer camaraFrontal) {
        this.camaraFrontal = camaraFrontal;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
}
