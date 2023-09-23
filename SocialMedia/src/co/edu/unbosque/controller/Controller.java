package co.edu.unbosque.controller;

import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.model.persistence.UsuarioDAO;
import co.edu.unbosque.util.Texto;
import co.edu.unbosque.util.simple.MyLinkedList;
import co.edu.unbosque.view.Console;

public class Controller {
	
	
	private Console console;
	private UsuarioDAO usuarios;
	
	public Controller() {
		console = new Console();
		usuarios = new UsuarioDAO();
	}
	
	public void run() {
		
		
		
		inicio();
		
		titulo();
		
		while(true) {
			opciones();

			
			int opc = console.readInt();
			switch (opc) {
			case 1: {
				console.next();
				addUser();
				break;
			}case 2: {
				deleteUser();
				
				break;
			}case 3: {
				
				break;
			}case 4:{
				console.print(usuarios.showUsers());
				break;
			}case 5: {
				
				System.exit(1);
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opc);
			}
			
			
			
			
		}
		
	}
	
	public void inicio() {
		console.print("Oprime 1 si de desa crear su propios usuarios de "
				+ "lo contrario ingrese cualquier otro caracter");
		console.print("1) Crear mis propios usarios");
		console.print("2) usar usuarios almacenados en la persistencia");
		int n = console.readInt();
		if (n == 1) {
			usuarios.setUsuarios(new MyLinkedList<UsuarioDTO>());
		}else {
			
		}
	}
	
	
	public void titulo() {
		console.print(Texto.YELLOW_BACKGROUND
				+""+Texto.MAGENTA
				+ "░░░░░██████╗░███████╗██████╗░  ░██████╗░█████╗░░█████╗░██╗░█████╗░██╗░░░░░\n"
				+ "░░░░░██╔══██╗██╔════╝██╔══██╗  ██╔════╝██╔══██╗██╔══██╗██║██╔══██╗██║░░░░░\n"
				+ "░░░░░██████╔╝█████╗░░██║░░██║  ╚█████╗░██║░░██║██║░░╚═╝██║███████║██║░░░░░\n"
				+ "░░░░░██╔══██╗██╔══╝░░██║░░██║  ░╚═══██╗██║░░██║██║░░██╗██║██╔══██║██║░░░░░\n"
				+ "░░░░░██║░░██║███████╗██████╔╝  ██████╔╝╚█████╔╝╚█████╔╝██║██║░░██║███████╗\n"
				+ "░░░░░╚═╝░░╚═╝╚══════╝╚═════╝░  ╚═════╝░░╚════╝░░╚════╝░╚═╝╚═╝░░╚═╝╚══════╝"
				+Texto.RESET);
		
	}
	public void opciones() {
		console.print("1) Crear Usuario Nuevo");
		console.print("2) Eliminar Usuario");
		console.print("3) Actualizar Usuario");
		console.print("4) Mostrar Usuarios");
		console.print("5) Salir");
	}
	
	public void addUser() {
		
		console.print(Texto.CYAN_BACKGROUND+"Ingrese su nombre"+Texto.RESET);
		String name = console.read();
		console.print(Texto.CYAN_BACKGROUND+"Ingrese un nombre de usuario"+Texto.RESET);
		String user = console.read();
		console.print(Texto.CYAN_BACKGROUND+"Ingrese una contraseña"+Texto.RESET);
		String password = console.read();
		UsuarioDTO usuario = new UsuarioDTO(name, user, password, new MyLinkedList<UsuarioDTO>());
		usuarios.addUser(usuario);
		
	}
	
	public void deleteUser() {
		console.print(usuarios.showUsersList());
		console.print("Ingrese el numero del usuario que desea eliminar");
		int n = console.readInt();
		usuarios.deleteUser(n-1);
		
	}

}
