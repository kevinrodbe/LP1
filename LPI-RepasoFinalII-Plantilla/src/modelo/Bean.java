package modelo;

public class Bean {
	private int codigo;
	private String decripcion;
	private int stock;
	private double precio;
	private int codmarca;
	private String nombremarca;
	
	public Bean(int codigo, String decripcion, int stock, double precio,
			int codmarca, String nombremarca) {
		this.codigo = codigo;
		this.decripcion = decripcion;
		this.stock = stock;
		this.precio = precio;
		this.codmarca = codmarca;
		this.nombremarca = nombremarca;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDecripcion() {
		return decripcion;
	}
	public void setDecripcion(String decripcion) {
		this.decripcion = decripcion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCodmarca() {
		return codmarca;
	}
	public void setCodmarca(int codmarca) {
		this.codmarca = codmarca;
	}
	public String getNombremarca() {
		return nombremarca;
	}
	public void setNombremarca(String nombremarca) {
		this.nombremarca = nombremarca;
	}
	
	

}
