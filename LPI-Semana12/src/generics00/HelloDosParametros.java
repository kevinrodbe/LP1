package generics00;

public class HelloDosParametros<T, K> {
	T t;
	K k;
	public HelloDosParametros(T t, K k) {
		this.t = t;
		this.k = k;
	}

	public String toString() {
		return t.toString() + "- " + k.toString();
	}
}
