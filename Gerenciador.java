package Interface;

import exception.ReservaInvalidaException;

public interface Gerenciador<T> {
    void cadastrar(T entidade) throws ReservaInvalidaException;
    T buscarPorId(String id) throws Exception;
    void editar(T entidade) throws Exception;
    void exibirTodos();
}

