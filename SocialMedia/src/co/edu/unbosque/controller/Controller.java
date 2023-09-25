package co.edu.unbosque.controller;

import co.edu.unbosque.model.AmigoDTO;
import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.model.persistence.UsuarioDAO;
import co.edu.unbosque.util.Texto;
import co.edu.unbosque.util.grafo.algoritmos.DepthFirstSearch;
import co.edu.unbosque.util.grafo.generico.Edge;
import co.edu.unbosque.util.grafo.generico.Graph;
import co.edu.unbosque.util.grafo.generico.Vertex;
import co.edu.unbosque.util.simple.MyLinkedList;
import co.edu.unbosque.view.Console;

public class Controller {
	
	
	private Console console;
	private UsuarioDAO usuarios;
	private Graph g1;
	private MyLinkedList<Vertex> personas;
	
	public Controller() {
		console = new Console();
		usuarios = new UsuarioDAO();
	}
	
	public void run() {

		titulo();
		inicio();

		while (true) {
			opciones();

			int opc = console.readInt();
			switch (opc) {
			case 1:
				console.next();
				addUser();
				break;

			case 2:
				deleteUser();

				break;

			case 3:
				updateUser();

				break;

			case 4:
				console.print(usuarios.showUsers());
				break;
			case 5:
				console.read();
				console.print("ingrese usuario");
				String adminUser = console.read(); //el usuario es 1234
				console.print("ingrese contraseña");
				String adminPassword = console.read(); //la contraseña es 1234

				console.print(usuarios.showUsersAdmin(adminUser, adminPassword));
				break;
			case 6:
				
				friendshipUser();
				break;
			case 7:
				break;
			case 8:
				showFriendshipUser();
				break;

			case 9:

				System.exit(1);

			default:
				throw new IllegalArgumentException("Unexpected value: " + opc);
			}

		}

	}
		
	public void inicio() {
		console.print("Oprime 1 si de desa crear su propios usuarios de "
				+ "lo contrario ingrese cualquier otro caracter");
		console.print("1) Crear mis propios usarios");
		console.print("2) usar usuarios almacenados");
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
		console.print("");
		console.print("1) Crear Usuario Nuevo");
		console.print("2) Eliminar Usuario");
		console.print("3) Actualizar Usuario");
		console.print("4) Mostrar Usuarios");
		console.print("5) Mostrar Usuarios (administrador)");
		console.print("6) añadir amigos");
		console.print("7) Mostrar usuarios desconexos(admin)");
		console.print("8) Mostrar amigos");
		console.print("9) Salir");
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
	
	public void updateUser() {
		console.print(usuarios.showUsersList());
		console.print("Ingrese el numero del usuario que desea actualizar");
		int n = console.readInt();
		usuarios.updateUser(n);
	
		
	}
	
	public void friendshipUser() {
		console.print(usuarios.showUsersList());
		console.print("Ingrese el numero del primer usuario");
		int userIndex1 = console.readInt(); 
		userIndex1=userIndex1-1;
		console.print("Ingrese el numero del otro usuario");
		int userIndex2 = console.readInt(); 
		userIndex2=userIndex2-1;
	    if (userIndex1 < 0 || userIndex1 >= usuarios.getUsuarios().size() ||
	        userIndex2 < 0 || userIndex2 >= usuarios.getUsuarios().size()) {
	        console.print(Texto.RED_BACKGROUND + "Usuarios no válidos." + Texto.RESET);
	        return;
	    }

	    usuarios.getAmigos().addLast(new AmigoDTO(userIndex1, userIndex2));
	    usuarios.writeFriend();

		
	    UsuarioDTO user1 = usuarios.getUsuarios().get(userIndex1).getInfo();
	    UsuarioDTO user2 = usuarios.getUsuarios().get(userIndex2).getInfo();


	    console.print(Texto.GREEN_BACKGROUND + "Amistad creada entre " + user1.getName() +
	                  " y " + user2.getName() + "." + Texto.RESET);
	}
	public void showFriendshipUser() {
		console.print(usuarios.showUsersList());
		console.print("Ingrese el numero del usuario que desea encontrar el grado de amistad");
		console.print("Ingrese el numero del primer usuario");
		int userIndex1 = console.readInt(); 
		userIndex1=userIndex1-1;
		console.print("Ingrese el numero del otro usuario");
		int userIndex2 = console.readInt(); 
		userIndex2=userIndex2-1;
	    if (userIndex1 < 0 || userIndex1 >= usuarios.getUsuarios().size() ||
	        userIndex2 < 0 || userIndex2 >= usuarios.getUsuarios().size()) {
	        console.print(Texto.RED_BACKGROUND + "Usuarios no válidos." + Texto.RESET);
	        return;
	    }

	    
	    verifyFriends();
	    
	    DepthFirstSearch dfss = new DepthFirstSearch(usuarios.getPersonas().get(userIndex1).getInfo(),
	    		usuarios.getPersonas().get(userIndex2).getInfo());
		if (dfss.runSearch()) {
			System.out.println("destino alcanzado");
		} else {
			System.out.println("el destino no es alcanzable");

		}
	    
	}
	public void verifyFriends() {
		g1 = new Graph();
		personas=new MyLinkedList<Vertex>();
		for (int l=0; l<usuarios.getUsuarios().size();l++) {
			personas.addLast(new Vertex (usuarios.getUsuarios().get(l).getInfo().getUser()));
		}
		for (int i=0; i<usuarios.getUsuarios().size();i++) {
			int a1=usuarios.getAmigos().get(i).getInfo().getAmigo1();
			int a2=usuarios.getAmigos().get(i).getInfo().getAmigo2();
			if(usuarios.getUsuarios().get(a1).getInfo()!=null&&usuarios.getUsuarios().get(a2).getInfo()!=null) {
				Vertex vertex1=personas.get(a1).getInfo();
				Vertex vertex2=personas.get(a2).getInfo();
				vertex1.addEdge(new Edge(vertex1, vertex2, 1));
				vertex2.addEdge(new Edge(vertex2, vertex1, 1));
				g1.addVertex(vertex1);
				g1.addVertex(vertex2);
				

			}
		}		
	}
public void disconnectedUsers() {
	    
	    boolean[] visited = new boolean[usuarios.getUsuarios().size()];
	    
	    for (int i = 0; i < usuarios.getUsuarios().size(); i++) {
	        if (!visited[i]) {
	            
	            MyLinkedList<UsuarioDTO> disconnected = new MyLinkedList<>();
	            dfsDisconnected(i, visited, disconnected);
	            
	            
	            console.print("Disconnected Users Group:");
	            
	            for (int user = 0; user < disconnected.size(); user++) {
	            	console.print("->"+ disconnected.get(i).getInfo().getName());
					
				}
	        }
	    }
	}

private void dfsDisconnected(int userIndex, boolean[] visited, MyLinkedList<UsuarioDTO> disconnected) {
    visited[userIndex] = true;
    UsuarioDTO currentUser = usuarios.getUsuarios().get(userIndex).getInfo();
    disconnected.addLast(currentUser);
    
    for (int i = 0; i < currentUser.getFriends().size(); i++) {
    	UsuarioDTO friend = currentUser.getFriends().get(i).getInfo();
    	  int friendIndex = usuarios.getUsuarios().get2(friend);
          if (friendIndex != -1 && !visited[friendIndex]) {
              dfsDisconnected(friendIndex, visited, disconnected);
          }
		
	}
    
}
	
	

}
