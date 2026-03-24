package Happiness;
public class Galeria {
    private int id;
    private String titulo;
    private int idEvento;
 
    public Galeria(int id, String titulo, int idEvento) {
        this.id = id;
        this.titulo = titulo;
        this.idEvento = idEvento;
    }
 
    // Getters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getIdEvento() { return idEvento; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setIdEvento(int idEvento) { this.idEvento = idEvento; }
 
    @Override
    public String toString() {
        return "id" + id + " titulo" + titulo + " idEvento" + idEvento;
    }
}