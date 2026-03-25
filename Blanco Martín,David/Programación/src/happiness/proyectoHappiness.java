package Happiness;
import java.time.LocalDate;
import java.util.*;

public class proyectoHappiness {
    public static void main(String[] args) {
        System.out.println("Inserte un dato");
        Scanner teclado = new Scanner(System.in);
        
        // HashMaps
        
        HashMap<String, Usuario> mapaUsuarios = new HashMap<>(); 
        HashMap<Integer, Evento> mapaEventos = new HashMap<>();   
        ArrayList<Favorito> listaFavoritos = new ArrayList<>();

        // Contadores necesarios para los ID
        int contadorIdsEventos=0;
        int contadorIdsGalerias=0;
        int idEvento;

        // Variable para poner la respuesta del menu
        int opcionMenu;
        
        //Creamos 6 eventos para que se puedan realizar todos los casos del menu
        mapaEventos.put(contadorIdsEventos, new Evento(contadorIdsEventos++, LocalDate.parse("2023-05-10"), "Concierto Rock", "Madrid", "Gran concierto de musica."));
        mapaEventos.put(contadorIdsEventos, new Evento(contadorIdsEventos++, LocalDate.parse("2023-11-15"), "Feria del Libro", "Barcelona", "Muchos libros y autores."));
        mapaEventos.put(contadorIdsEventos, new Evento(contadorIdsEventos++, LocalDate.parse("2024-01-20"), "Exposición Arte", "Sevilla", "Cuadros del siglo XIX."));
        mapaEventos.put(contadorIdsEventos, new Evento(contadorIdsEventos++, LocalDate.parse("2025-07-15"), "Festival Verano", "Valencia", "Música junto al mar."));
        mapaEventos.put(contadorIdsEventos, new Evento(contadorIdsEventos++, LocalDate.parse("2025-12-01"), "Congreso Java", "Malaga", "Todo sobre programación."));
        mapaEventos.put(contadorIdsEventos, new Evento(contadorIdsEventos++, LocalDate.parse("2026-03-22"), "Hackathon 48h", "Bilbao", "Competencia de codigo."));

        // También metemos un usuario para poder usar directamente Eliminar Usuario sin tener que crear uno
        mapaUsuarios.put("primerusuario@gmail.com", new Usuario("Juanito", "primerusuario@gmail.com", "1234"));



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
                        System.out.println("El usuario ya existe");

                //Si no existe lo guardamos con .put en el HashMap de usuarios guardando el email nuevo como clave y el usuario nuevo como el valor
                    } else {
                        mapaUsuarios.put(emailNuevo, new Usuario(nombreNuevo, emailNuevo, passNuevo));
                        System.out.println("Usuario creado correctamente");
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
                
            //Añadir Evento
             case 3: 

                //Pasamos la fecha al formato AAAA-MM-DD
                
                System.out.print("Formato de Fecha (AAAA-MM-DD): ");
                System.out.println("Introduce la Fecha"); 
                String fechaTexto = teclado.nextLine();
                //Guardamos la fecha introducida
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
                    
            //Eliminar Evento
             case 4:
                //Primero vamos a mostrar con un bucle for los IDs para que el usuario los vea de manera bonita
                    for (Evento IDs : mapaEventos.values()) {
                    System.out.println(IDs);}
                    
                // Pedimos el ID del evento que desea eliminar
                System.out.print("\n Introduce el ID del evento que deseas eliminar ");
                int idEliminar = teclado.nextInt();
                teclado.nextLine(); // Limpieza de buffer

                // Verificamos si el evento existe y si existe lo eliminamos
                if (mapaEventos.containsKey(idEliminar)) {
                    mapaEventos.remove(idEliminar);
                    System.out.println("Evento eliminado correctamente.");
                } else {
                    // Si el evento no existe mostramos un mensaje que nos informe
                    System.out.println("El evento no existe.");
                }
                break;
                
            //Añadir galería
             case 5:
                System.out.println("Lista de IDs Eventos");
                for (Evento IDs : mapaEventos.values()) {
                    System.out.println(IDs);
                }
                
                System.out.print("\nIntroduce el ID del evento para crear la galería: ");
                idEvento = teclado.nextInt();
                teclado.nextLine(); //Limpiamos buffer
                
                
                //Comprobamos si existe el evento al que queremos asignarle la nueva galeria
                if (!mapaEventos.containsKey(idEvento)) {
                    System.out.println("ID de evento incorrecto.");
                } else {
                    System.out.print("Introduce el Título de la galería: ");
                    String tituloGal = teclado.nextLine();
                    
                    //Creamos el objeto Galeria con el contador el título y el ID
                    Galeria nuevaGaleria = new Galeria(contadorIdsGalerias, tituloGal, idEvento);
                    
                    //Añadimos a la colección de galerías del evento específico usando el Id de la galeria
                    //Obtenemos la lista del arrayList de la galeria y añadimos el nuevo objeto creado.
                    mapaEventos.get(idEvento).getGaleriaList().add(nuevaGaleria);
                    
                    //Mostramos que se haya creado correctamente y el ID
                    System.out.println("Galería creada correctamente, el ID asignado es: " + contadorIdsGalerias);
                    contadorIdsGalerias++;
                }
                break;
                
            //Eliminar Galería
             case 6:
                 /*Volvemos a usar el for para que nos muestre los IDs, nos lo pasa a toString sin 
                 tener que llamarlo ya que si lo encuentra en la clase lo utiliza*/
                 for (Evento IDs : mapaEventos.values()) {
                    System.out.println(IDs);
                }
                System.out.print("\n Introduce el ID del evento donde quieres eliminar una galeria ");
                idEvento = teclado.nextInt();
                teclado.nextLine(); //Limpiamos buffer
                
                //Comprobamos si el evento existe
                if (!mapaEventos.containsKey(idEvento)) {
                    System.out.println("El evento no existe.");
                } else {
                    //Si existe usamos la clave idEvento para conseguir los valores de dicho evento y lo guardamos
                    Evento eventoSeleccionado = mapaEventos.get(idEvento);
                    
                    //Mostramos las galerías que tiene ese evento por título
                    System.out.println("Galerías del evento " + eventoSeleccionado.getTitulo());
                    
                    //Si la lista está vacía, avisamos, usamos el .isEmpty para comprovar esto
                    if (eventoSeleccionado.getGaleriaList().isEmpty()) {
                        System.out.println("Este evento no tiene ninguna galería");
                    } else {
                    // Mostramos la lista de galerias del evento
                        for (Galeria g : eventoSeleccionado.getGaleriaList()) {
                            System.out.println(g); // Usa el toString() de Galeria si lo tenemos creado
                        }

                        System.out.print("\nIntroduce el ID de la galería que quieres eliminar: ");
                        int idGalEliminar = teclado.nextInt();
                        teclado.nextLine();
                        
                        /*Usamos una nueva variable inicializada estando vacía, si el ID de g al recorrer
                        la liosta es el mismo que hemos escrito para eliminar lo guarda en la variable galeriaEncontrada*/
                        Galeria galeriaEncontrada = null;
                        for (Galeria g : eventoSeleccionado.getGaleriaList()) {
                            if (g.getId() == idGalEliminar) {
                                galeriaEncontrada = g; 
                                break; // Cuando coincide salimos del bucle
                            }
                        }

                        //Una vez encontrada obtenemos la lista y la borramos
                        if (galeriaEncontrada != null) {
                            eventoSeleccionado.getGaleriaList().remove(galeriaEncontrada);
                            System.out.println("Galería eliminada correctamente.");
                        } else {
                            System.out.println("No se ha encontrado ninguna galería con ese ID en este evento.");
                        }
                        
                    }
                }
                break;
            
            //Añadir Favorito    
             case 7: 
                 
                System.out.println("Vamos a añadir un evento a favoritos");
                
                //Mostramos el ID y el título de los eventos al usuario para que escoja uno
                System.out.println("Eventos disponibles:");
                for (Evento eventos : mapaEventos.values()) {
                    System.out.println("ID: " + eventos.getId() + " titulo " + eventos.getTitulo());
                }

                //Pedimos el ID del evento y luego el Email del usuario, que son las claves
                System.out.print("\nIntroduce el ID del evento: ");
                idEvento = teclado.nextInt();
                teclado.nextLine(); // Limpiar buffer

                System.out.print("\nIntroduce el Email del usuario: ");
                String emailFav = teclado.nextLine();

               
                // Verificamos si existen el evento y el usuario con .containsKey()
                if (mapaEventos.containsKey(idEvento) && mapaUsuarios.containsKey(emailFav)) {
                    
                    //Si existen creamos el objeto Favorito con los datos introducidos de Usuario(email) y Evento(ID)
                    Favorito nuevoFav = new Favorito(emailFav, idEvento);
                    
                    //Lo guardamos en la lista de favoritos
                    listaFavoritos.add(nuevoFav);
                    
                    System.out.println("Favorito creado correctamente");
                } else {
                    // Si nos da error
                    System.out.println("El ID de evento o el Email de usuario son incorrectos");
                }
                break;
            
            //Eliminar Favorito    
             case 8:  
                 
                System.out.println("Lista de Favoritos:");
                
                //Mostramos los favoritos que existen
                if (listaFavoritos.isEmpty()) {
                    System.out.println("No hay ningún favorito registrado.");
                } else {
                    for (Favorito f : listaFavoritos) {
                        System.out.println(f); // Usa el toString de la clase para poder mostrarlo
                    }
                }

                //Pedimos los datos para encontrar el favorito, para ello necesitamos las claves, el correo y el ID de evento
                System.out.print("\nIntroduce el correo del usuario: ");
                String emailBorrar = teclado.nextLine();
                
                System.out.print("Introduce el ID del evento: ");
                idEvento = teclado.nextInt();
                teclado.nextLine(); // Limpiamos buffer

                //Bucle para buscar el favorito
                Favorito favEliminar = null;
                for (Favorito f : listaFavoritos) {
                    // Verificamos si coinciden ambos datos y si coinciden lo guardamos en favEliminar
                    if (f.getCorreoUsuario().equals(emailBorrar) && f.getIdEvento() == idEvento) {
                        favEliminar = f;
                        break; 
                    }
                }

                //Usamos un if para eliminar el favorito si lo ha guardado y un mensaje de error por si da problemas
                if (favEliminar != null) {
                    listaFavoritos.remove(favEliminar);
                    System.out.println("Favorito eliminado correctamente");
                } else {
                    System.out.println("El favorito no existe");
                }
                break;
            
            //Salir del menu
             case 9:
                 System.out.println("Usted esta saliendo del menu");
                 
                break;
                  
        
          }
         }
        

        while (opcionMenu!=9);

        
    
    }}