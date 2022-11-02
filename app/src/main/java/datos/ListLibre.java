package datos;

public class ListLibre {

    public String nombre;
    public String numero;
    public String email;
    public int img;

    public ListLibre(String nombre, String numero, String email, int img) {
        this.nombre = nombre;
        this.numero = numero;
        this.email = email;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
