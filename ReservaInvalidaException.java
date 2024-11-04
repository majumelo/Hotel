package exception;

public class ReservaInvalidaException extends Exception {
    public ReservaInvalidaException(String message) {
        super("\"Desculpe, não há quartos disponíveis para as datas selecionadas.\"");
        
    }
}
