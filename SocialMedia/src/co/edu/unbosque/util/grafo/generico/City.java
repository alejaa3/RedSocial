package co.edu.unbosque.util.grafo.generico;

public class City {
	private String name;
	private long population;
	
	public City() {
		// TODO Auto-generated constructor stub
	}

	public City(String name, long population) {
		super();
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", population=" + population + "]";
	}
	


}
