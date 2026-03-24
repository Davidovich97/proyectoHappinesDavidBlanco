package Happiness;
public class Usuario {
    private String nombre;
    private String email;
    private String password;
 
    public Usuario(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }
 
    // Getters
    public String getNombre()
     { return nombre; }
    public void setNombre(String nombre)
     { this.nombre = nombre; }
    public String getEmail() 
    { return email; }

    // Setters
    public void setEmail(String email) 
    { this.email = email; }
    public String getPassword()
     { return password; }
    public void setPassword(String password)
     { this.password = password; }
 
    //Metodo toString
    @Override
   public String toString() {
    return nombre + email;
}
}