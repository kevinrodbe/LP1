package repaso.bean;

public class EventoBean {
	private int idEvento;
	private int idLocal;
	private String nombre;
	private String fechaInicio;
	private String fechaFin;
	private int capacidad;
	private String url;
	private String emailContacto;

	private String nombreLocal;

	public int getIdEvento() {
		return idEvento;
	}

	public int getIdLocal() {
		return idLocal;
	}

	public String getNombre() {
		return nombre;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public String getUrl() {
		return url;
	}

	public String getEmailContacto() {
		return emailContacto;
	}

	public String getNombreLocal() {
		return nombreLocal;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setEmailContacto(String emailContacto) {
		this.emailContacto = emailContacto;
	}

	public void setNombreLocal(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}

}
