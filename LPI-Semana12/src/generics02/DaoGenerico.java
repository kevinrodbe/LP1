package generics02;

public interface DaoGenerico<T extends Documento> {

	public abstract int inserta(T obj);

	public abstract int elimina(T obj);
}