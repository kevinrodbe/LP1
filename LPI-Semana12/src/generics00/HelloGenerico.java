package generics00;

public class HelloGenerico<T> {
	T t;

	public HelloGenerico(T t) {
		this.t = t;
	}

	public String toString() {
		return t.toString();
	}

	
}