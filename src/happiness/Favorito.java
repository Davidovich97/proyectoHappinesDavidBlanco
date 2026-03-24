package Happiness;
public class Favorito {
    private String correoUsuario;
    private int idEvento;
 
    public Favorito(String correoUsuario, int idEvento) {
        this.correoUsuario = correoUsuario;
        this.idEvento = idEvento;
    }
 
    // Getters
    public String getCorreoUsuario() 
        { return correoUsuario; }
    public int getIdEvento() 
        { return idEvento; }

    // Setters    
    public void setCorreoUsuario(String correoUsuario) 
        { this.correoUsuario = correoUsuario; }
    
    public void setIdEvento(int idEvento)
         { this.idEvento = idEvento; }
 
    
    @Override
    public String toString() {
        return  correoUsuario+ idEvento;
    }
}