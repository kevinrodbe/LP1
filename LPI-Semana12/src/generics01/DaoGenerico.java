package generics01;

public interface DaoGenerico<T> {

	public abstract int inserta(T obj);

	public abstract int elimina(T obj);
}
