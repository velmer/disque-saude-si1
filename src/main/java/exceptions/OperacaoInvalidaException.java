package exceptions;

public class OperacaoInvalidaException extends Exception {

    private static final String OPERACAO_INVALIDA = "Operação inválida! ";

    public OperacaoInvalidaException(String erro) {
        super(OPERACAO_INVALIDA + erro);
    }
}
