package co.edu.unbosque.model.persistence;

import java.io.File;
import java.util.Iterator;

import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.util.Texto;
import co.edu.unbosque.util.simple.MyLinkedList;
import co.edu.unbosque.view.Console;

public class UsuarioDAO {
	
	private MyLinkedList<UsuarioDTO> usuarios;
	private File archivo;
	private Console console;
	
	public UsuarioDAO() {
		console = new Console();
		archivo = new File("usuarios.bin");
		if(FileHandler.isEmpty(archivo)) {
			usuarios = new MyLinkedList<UsuarioDTO>();
		}else {
			usuarios = (MyLinkedList<UsuarioDTO>) FileHandler.readObject(archivo);
		}
	}
	public void addUser(UsuarioDTO user) {
		if(user != null) {
			usuarios.addLast(user);
			FileHandler.writeObject(usuarios, archivo);
			console.print(Texto.GREEN_BACKGROUND+"Usuario agregado con Exito"+Texto.RESET);
		}
	}
	
	public void deleteUser(int n){
		UsuarioDTO eliminado = new UsuarioDTO();
		if(n == 0) {
			eliminado = usuarios.extract();
			FileHandler.writeObject(usuarios, archivo);
			console.print(Texto.GREEN_BACKGROUND+"El usuario "+eliminado.getName()+" fue eliminado con exito"+Texto.RESET);
			
		}else if (n < usuarios.size() && n > 0) {
			eliminado = usuarios.extract(usuarios.get(n-1));
			FileHandler.writeObject(usuarios, archivo);
			console.print(Texto.GREEN_BACKGROUND+"El usuario "+eliminado.getName()+" fue eliminado con exito"+Texto.RESET);
			
		}else {
			console.print(Texto.RED_BACKGROUND+"El usuario no fue encontrado"+Texto.RESET);
		}
		
		
	}
	public String showUsers() {
		StringBuilder sb = new StringBuilder();
		Texto[] colores = Texto.values();
		for (int i = 0; i < usuarios.size(); i++) {
			UsuarioDTO user = usuarios.get(i).getInfo();
			//sb.append(colores[i] + "\nUsuario numero: "+ (i+1) + "\n");
			sb.append(colores[i] + "\n "+ (i+1) + ") ");
			sb.append("Nombre: "+user.getName() + ", ");
			sb.append("Usuario: "+user.getUser() + ", ");
			//sb.append("Contraseña: "+user.getPassword() + "\n" + Texto.RESET);
		}
		return sb.toString();
		
	}
	public String showUsersAdmin(String user1, String password) {
		StringBuilder sb = new StringBuilder();
		if(user1.equals("1234")&&password.equals("1234")) {
		Texto[] colores = Texto.values();
		for (int i = 0; i < usuarios.size(); i++) {
			UsuarioDTO user = usuarios.get(i).getInfo();
			//sb.append(colores[i] + "\nUsuario numero: "+ (i+1) + "\n");
			sb.append(colores[i] + "\n "+ (i+1) + ") ");
			sb.append("Nombre: "+user.getName() + ", ");
			sb.append("Usuario: "+user.getUser() + ", ");
			sb.append("Contraseña: "+user.getPassword() + ", " + Texto.RESET);
		}
		}else {
			sb.append("usuario o contraseña incorrecta");
		}
		return sb.toString();
		
	}
	public String showUsersList() {
		StringBuilder sb = new StringBuilder();
		Texto[] colores = Texto.values();
		sb.append("Usuarios:\n");
		for (int i = 0; i < usuarios.size(); i++) {
			UsuarioDTO user = usuarios.get(i).getInfo();
			sb.append((i+1)+")"+user.getName()+"\n");
		}
		return sb.toString();
		
	}
	
	public void updateUser(int n) {
		
		UsuarioDTO antiguo = usuarios.get(n).getInfo();
		console.print(Texto.CYAN_BACKGROUND+"Ingrese su nuevo nombre"+Texto.RESET);
		String name = console.read();
		console.print(Texto.CYAN_BACKGROUND+"Ingrese su nuevo usuario"+Texto.RESET);
		String user = console.read();
		console.print(Texto.CYAN_BACKGROUND+"Ingrese su nueva contraseña"+Texto.RESET);
		String password = console.read();
		usuarios.get(n).setInfo(new UsuarioDTO(name, user, password, antiguo.getFriends()));
		
		console.print(Texto.CYAN_BACKGROUND+"Usuario Actualizado con exito"+Texto.RESET);
		
	}
	public MyLinkedList<UsuarioDTO> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(MyLinkedList<UsuarioDTO> usuarios) {
		this.usuarios = usuarios;
	}
	public File getArchivo() {
		return archivo;
	}
	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}
	

}
