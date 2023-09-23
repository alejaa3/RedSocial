package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Iterator;

import co.edu.unbosque.util.simple.MyLinkedList;

public class UsuarioDTO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -290097685518605313L;
	private String name;
	private String user;
	private String password;
	private MyLinkedList<UsuarioDTO> friends;
	
	
	public UsuarioDTO() {
		
	}


	public UsuarioDTO(String name, String user, String password, MyLinkedList<UsuarioDTO> friends) {
		super();
		this.name = name;
		this.user = user;
		this.password = password;
		this.friends = friends;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public MyLinkedList<UsuarioDTO> getFriends() {
		return friends;
	}


	public void setFriends(MyLinkedList<UsuarioDTO> friends) {
		this.friends = friends;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Usuario\n");
		sb.append("Name: "+this.name+"\n");
		sb.append("user: "+this.user+"\n");
		sb.append("password: "+this.password+"\n");
		for (int i = 0; i < this.friends.size(); i++) {
			sb.append(this.friends.get(i).getInfo().getName());
		}
		return sb.toString(); 
	}
	
	
	
	
	

}
