package conjuntos;

public class Auto  implements Comparable<Auto>{

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
		return modelo.compareTo(o.getModelo());
	}

	@Override
	public String toString() {
		return "Auto [id=" + id + ", marca=" + marca + ", modelo=" + modelo	+ ", precio=" + precio + "]";
	}

	@Override
	public int hashCode() {
		if(modelo == null)
			return 31;
		else
			return 31 + modelo.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auto other = (Auto) obj;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		return true;
	}



}
