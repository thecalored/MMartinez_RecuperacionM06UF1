package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ex1 {
	static ArrayList<videojuego> arrayVideojuego;
	static int numeroJuegos=0;
	public static void main(String[] args)throws IOException, ClassNotFoundException {
		//creamos el ficheor dat con los datos.
		crearFciheroBinario();
	
	        boolean salir = false;
	        int opcion; //Guardaremos la opcion del usuario
	 //un menu para modificar y eliminar.
	        while (!salir) {
	 
	            System.out.println("1. Modificar");
	            System.out.println("2. eliminar");
	            System.out.println("3. Salir");
	 
	            try {
	 
	                System.out.println("Escribe una de las opciones");
	                opcion = leerI();
	 
	                switch (opcion) {
	                    case 1:
	                    	modificarFichero();
	                        break;
	                    case 2:
	                        eliminarDato();
	                        break;
	                    case 3:
	                        salir = true;
	                        break;
	                    default:
	                        System.out.println("Solo números entre 1 y 3");
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Debes insertar un número");
	                leerI();
	            }
	        }
		

	}
	public static void eliminarDato() throws IOException {
		 FileInputStream fis=null;
		 DataInputStream entrada = null; 
		 FileOutputStream fos = null;
		 DataOutputStream salida = null;
		 arrayVideojuego.clear();
		 boolean existe=false;
		 videojuego vj = new videojuego();
		 int idJuego;
		 try {
			 //abrimos fichero
			 fis= new FileInputStream("..\\MMartinez_RecuperacionM06UF1\\src\\main\\videojocs.dat");
			 entrada = new  DataInputStream(fis);
			System.out.println("todos los datos:");
			//rellenamos la array con los datos.
			for(int i =0;i<numeroJuegos;i++) {
				vj = new videojuego(entrada.readInt(), entrada.readUTF(), entrada.readUTF(), entrada.readDouble());
				arrayVideojuego.add(vj);
				System.out.println(vj.toString());
			}
			//pedimos la id y si existe  pone true.
			System.out.println("introduce la numeor de juego a modificar:");
			idJuego = leerI();
			for (videojuego videojuego : arrayVideojuego) {
				if(videojuego.getNumeroVidiojuego()==idJuego) {
					existe=true;
					
			}
			}
			if(existe==true) {
				//recorremos la array para borrar el juego
				for (videojuego videojuego : arrayVideojuego) {
					if(videojuego.getNumeroVidiojuego()==idJuego) {
						arrayVideojuego.remove(videojuego);
				}	
				}
				//escribimos el fichero con los datos nuevos o modificados.
				fos = new FileOutputStream("..\\MMartinez_RecuperacionM06UF1\\src\\main\\videojocs.dat");
				salida = new DataOutputStream(fos);
				for (videojuego videojuego : arrayVideojuego) {
					salida.writeInt(videojuego.getNumeroVidiojuego());
					salida.writeUTF(videojuego.getNombreVidiojuego());
					salida.writeUTF(videojuego.getPlataforma());
					salida.writeDouble(videojuego.getPrecio());
					
				}
				System.out.println("juego eliminado.");
				for (videojuego videojuego : arrayVideojuego) {
					System.out.println(videojuego.toString());
				}
			}else {
			System.out.println("la id de ese juego no sido encontrada");
			}
		}   catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				fis.close();
			}if( entrada!=null) {
				entrada.close();
			}
			if(fos!=null) {
				fos.close();
			}if(salida!=null) {
				salida.close();
			}
			
		}
		 
	}
	public static void modificarFichero() throws IOException, ClassNotFoundException{
		 FileInputStream fis=null;
		  DataInputStream entrada = null; 
		  FileOutputStream fos = null;
			DataOutputStream salida = null;
		 arrayVideojuego.clear();
		 videojuego vj = new videojuego();
		 videojuego vj2 = new videojuego();
		 boolean existe=false;
		 String SioNo;
		 String nuevoNombre = null;
		 String nuevoPlataforma= null;
		 Double nuevoPrecio= null;
		 arrayVideojuego = new ArrayList<videojuego>();
		 int idJuego;
		 try {
			 //leemos el fichero.
			 fis= new FileInputStream("..\\MMartinez_RecuperacionM06UF1\\src\\main\\videojocs.dat");
			 entrada = new  DataInputStream(fis);
			System.out.println("introduce la numeor de juego a modificar:");
			idJuego = leerI();
			//rellenamos datos en la array.
			for(int i =0;i<numeroJuegos;i++) {
				vj = new videojuego(entrada.readInt(), entrada.readUTF(), entrada.readUTF(), entrada.readDouble());
				arrayVideojuego.add(vj);
			}
			//comprovar q la id existe dentor de la array y pone true.
			for (videojuego videojuego : arrayVideojuego) {
				if(videojuego.getNumeroVidiojuego()==idJuego) {
					existe=true;
					vj2=videojuego;
			}
			}
			//comprobaciones de si quiere cambiar los datos
			//CAMBIAR EL NOMBRE
			if(existe==true) {
				System.out.println("el juego existe");
				System.out.println("quieres cambiar nombre?SI o NO");
				 SioNo= leerS();
				if(SioNo.equalsIgnoreCase("si")) {
					System.out.println("introduce el nuevo nombre:");
					nuevoNombre=leerS();
					vj2.setNombreVidiojuego(nuevoNombre);
				}else if(SioNo.equalsIgnoreCase("No")) {
						System.out.println("no se cambiara el nombre.");
						nuevoNombre=vj2.getNombreVidiojuego();
				}else {
					System.out.println("no has introducido bien los datos.");
					nuevoNombre=vj2.getNombreVidiojuego();
				}
			}else {
				System.out.println("el juego no existe");
			}
			//cambiar plataforma 
			if(existe==true) {
				System.out.println("quieres cambiar plataforma?SI o NO");
				 SioNo= leerS();
				if(SioNo.equalsIgnoreCase("si")) {
					System.out.println("introduce la nueva plataforma:");
					nuevoPlataforma=leerS();
					vj2.setPlataforma(nuevoPlataforma);
				}else if(SioNo.equalsIgnoreCase("No")) {
						System.out.println("no se cambiara la plataforma.");
						nuevoPlataforma= vj2.getPlataforma();
				}else {
					System.out.println("no has introducido bien los datos.");
					nuevoPlataforma= vj2.getPlataforma();
				}
			}else {
				System.out.println("el juego no existe");
			}
			//cambiar precio
			if(existe==true) {
				System.out.println("quieres cambiar precio?SI o NO");
				 SioNo= leerS();
				if(SioNo.equalsIgnoreCase("si")) {
					System.out.println("introduce el nueva precio:");
					nuevoPrecio=leerD();
					vj2.setPrecio(nuevoPrecio);
				}else if(SioNo.equalsIgnoreCase("No")) {
						System.out.println("no se cambiara el precio.");
						nuevoPrecio = vj2.getPrecio();
				}else {
					System.out.println("no has introducido bien los datos.");
					nuevoPrecio = vj2.getPrecio();
				}
			}else {
				System.out.println("el juego no existe");
			}
			// datos antriguos y los vieojos por pantalla
			System.out.println("DATOS ANTIGUOS:");
			for (videojuego videojuego : arrayVideojuego) {
				if(videojuego.getNumeroVidiojuego()==vj2.getNumeroVidiojuego()) {
					System.out.println(videojuego.toString());
				}
			}
			System.out.println("DATOS NUEVOS:");
			for (videojuego videojuego : arrayVideojuego) {
				if(videojuego.getNumeroVidiojuego()== vj2.getNumeroVidiojuego()) {
					videojuego=vj2;
					System.out.println(videojuego.toString());
				}
			}
			// escribimos en el fichero los datos modificados.
			fos = new FileOutputStream("..\\MMartinez_RecuperacionM06UF1\\src\\main\\videojocs.dat");
			salida = new DataOutputStream(fos);
			for (videojuego videojuego : arrayVideojuego) {
				salida.writeInt(videojuego.getNumeroVidiojuego());
				salida.writeUTF(videojuego.getNombreVidiojuego());
				salida.writeUTF(videojuego.getPlataforma());
				salida.writeDouble(videojuego.getPrecio());
				
			}
			System.out.println("fichero modificado.");
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				fis.close();
			}if( entrada!=null) {
				entrada.close();
			}
			if(fos!=null) {
				fos.close();
			}if(salida!=null) {
				salida.close();
			}
			
		}
	}
	
	public static void crearFciheroBinario() throws IOException {
		FileOutputStream fos = null;
		DataOutputStream salida = null;
		//creamos los videojuegos y los añadimos a la array
		videojuego vj1 = new videojuego(1,"world of warcraft", "PC", 14.45) ;
		videojuego vj2 = new videojuego(2, "fornite", "PS4", 10.00) ;
		videojuego vj3 = new videojuego(3, "pokemon espada", "switch", 59.99) ;
		arrayVideojuego = new ArrayList<videojuego>();
		arrayVideojuego.add(vj1);
		arrayVideojuego.add(vj2);
		arrayVideojuego.add(vj3);
		
		try {
			//escribimos los datos dentro del fichero.
			fos = new FileOutputStream("..\\MMartinez_RecuperacionM06UF1\\src\\main\\videojocs.dat");
			salida = new DataOutputStream(fos);
			for (videojuego videojuego : arrayVideojuego) {
				salida.writeInt(videojuego.getNumeroVidiojuego());
				salida.writeUTF(videojuego.getNombreVidiojuego());
				salida.writeUTF(videojuego.getPlataforma());
				salida.writeDouble(videojuego.getPrecio());
				numeroJuegos++;
			}
			System.out.println("fichero .dat creado.");
			fos.close();
			salida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

	//metodos para leer por teclado.
	public static String leerS() {
		 Scanner sc= new Scanner(System.in);
		 return sc.nextLine();
	}
	public static int leerI() {
		 Scanner sc= new Scanner(System.in);
		 return sc.nextInt();
	}
	public static char leerC() {
		 Scanner sc= new Scanner(System.in);
		 return sc.next().charAt(0);
	}
	public static double leerD() {
		 Scanner sc= new Scanner(System.in);
		 return sc.nextDouble();
	}
}
