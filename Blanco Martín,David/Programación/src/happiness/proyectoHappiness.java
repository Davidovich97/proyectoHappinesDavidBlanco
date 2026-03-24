package Happiness;
import java.time.LocalDate;
import java.util.*;

public class proyectoHappiness {
    public static void main(String[] args) {
        System.out.println("Inserte un dato");
        Scanner teclado = new Scanner(System.in);
        
        // HashMaps
        // Prueba
        HashMap<String, Usuario> mapaUsuarios = new HashMap<>(); 
        HashMap<Integer, Evento> mapaEventos = new HashMap<>();   
        ArrayList<Favorito> listaFavoritos = new ArrayList<>();

        // Contadores necesarios para los ID
        int contadorIdsEventos=0;
        int contadorIdsGalerias=0;

        // Variable para poner la respuesta del menu
        int opcionMenu;

        // Bucle para escoger opcion del menu

        do {System.out.println("\n MENU HAPPINESS&Co\n");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Eliminar usuario");
            System.out.println("3. Añadir evento");
            System.out.println("4. Eliminar evento");
            System.out.println("5. Añadir galería a evento");
            System.out.println("6. Eliminar galería de evento");
            System.out.println("7. Añadir favorito");
            System.out.println("8. Eliminar favorito");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
        opcionMenu=teclado.nextInt();
        teclado.nextLine();

        // Switch con las opciones del menu

        switch(opcionMenu){

            //Añadir Usuario
             case 1: 

                    System.out.print("Introduce Nombre: ");
                String nombreNuevo = teclado.nextLine();
                    System.out.print("Introduce Email: "); 
                String emailNuevo = teclado.nextLine();
                    System.out.print("Introduce Password: "); 
                String passNuevo = teclado.nextLine();
                
                //Verificamos si ya tenemos el usuario creado teniendo en cuenta el email que es la Clave
                if (mapaUsuarios.containsKey(emailNuevo)) {
                        System.out.println("El usuario ya existe.");

                //Si no existe lo guardamos con .put en el HashMap de usuarios guardando el email nuevo como clave y el usuario nuevo como el valor
                    } else {
                        mapaUsuarios.put(emailNuevo, new Usuario(nombreNuevo, emailNuevo, passNuevo));
                        System.out.println("Usuario creado correctamente.");
                    }
                    break;
                    
            //Eliminar Usuario 
             case 2:

                System.out.print("Introduce el email del usuario que quieres eliminar: ");
                //creamos una variable para guardar el email que queremos borrar
                    String emailEliminar = teclado.nextLine();

                //Comprobamos con .containsKey si el email que queremos eliminar esta guardado y si existe lo borramos con el .remove   
                if (mapaUsuarios.containsKey(emailEliminar)) {
                        mapaUsuarios.remove(emailEliminar);
                            System.out.println("Usuario eliminado correctamente.");
                                }           
                //Si no existe ponemos un mensaje para aclararlo
                else {
                System.out.println("El usuario no existe.");
                     }
                    break;
                
            // Añadir Evento
             case 3: 

                //Limpiamos el buffer y pasamos el formato de la fecha a String;
                
                System.out.print("Formato de Fecha (AAAA-MM-DD): ");
                System.out.println("Introduce la Fecha"); 
                String fechaTexto = teclado.nextLine();
                LocalDate fecha = LocalDate.parse(fechaTexto);       
                    System.out.print("Introduce el Título: "); 
                        String titulo = teclado.nextLine();
                        
                    System.out.print("Introduce la Ubicación: "); 
                        String ubicacion = teclado.nextLine();
                    System.out.print("Introduce la Descripción: "); 
                        String descripcion = teclado.nextLine();

                //Creamos el evento con los datos introducidos y lo guardamos en el HashMap
                    Evento nuevoEvento = new Evento(contadorIdsEventos, fecha, titulo, ubicacion, descripcion);
                    mapaEventos.put(contadorIdsEventos, nuevoEvento);
                    System.out.println("Evento creado con ID: " + contadorIdsEventos);
                    contadorIdsEventos++;
                    break;
        }
            }

        while (opcionMenu!=9);

        
    
    }

}