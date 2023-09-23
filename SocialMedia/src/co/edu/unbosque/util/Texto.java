package co.edu.unbosque.util;

public enum Texto {
	
	BLACK("\u001B[30m"),
	RED("\u001B[31m"),
	GREEN("\u001B[32m"),
	YELLOW("\u001B[33m"),
	BLUE("\u001B[34m"),
	MAGENTA("\u001B[35m"),
	CYAN("\u001B[36m"),
	BLACK_BACKGROUND("\u001B[40m"),
	RED_BACKGROUND("\u001B[41m"),
	GREEN_BACKGROUND("\u001B[42m"),
	YELLOW_BACKGROUND("\u001B[43m"),
	BLUE_BACKGROUND("\u001B[44m"),
	MAGENTA_BACKGROUND("\u001B[45m"),
	CYAN_BACKGROUND("\u001B[46m"),
	RESET("\u001B[0m");
	
	private String unicode;
	
	private Texto(String unicode) {
		this.unicode = unicode;
	}



	public String getUnicode() {
		return unicode;
	}
	
	@Override
	public String toString() {
		return this.unicode;
	}
	
	
	

}
