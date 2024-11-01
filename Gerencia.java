package Main;

public interface Gerencia <T> {
	void adicionar(T item);

	void atualizar(T item);

	void remover(T item);
}