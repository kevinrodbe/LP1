package listas;

public class Auto implements Comparable<Auto> {

	private Integer id;
	private String modelo;
	private String marca;
	private Double precio;

	public Auto(Integer id, String modelo, String marca, Double precio) {
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public int compareTo(Auto o) {
		return modelo.compareToIgnoreCase(o.getModelo());
	}

	@Override
	public String toString() {
		return getId() + "-" + getModelo() + "-" + getMarca() + "-"	+ getPrecio();
	}

}
