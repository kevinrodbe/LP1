package generics00;


import generics03.Documento;

public class HelloEspecial<T extends Documento> {
	T t;

	public HelloEspecial(T t) {
		this.t = t;
	}

	public String toString() {
		return t.toString();
	}
}
