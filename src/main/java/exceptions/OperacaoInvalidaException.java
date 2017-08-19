package exceptions;

public class OperacaoInvalidaException extends Exception {

    private static final String OPERACAO_INVALIDA = "Operação inválida!";

    public OperacaoInvalidaException() {
        super(OPERACAO_INVALIDA);
    }

    public OperacaoInvalidaException(String erro) {
        super(erro);
    }
}
