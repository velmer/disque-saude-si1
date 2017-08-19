package exceptions;

public class OpcaoNaoExistenteException extends OperacaoInvalidaException {

    private static final String OPCAO_NAO_EXISTENTE = "Opção não existente!";

    public OpcaoNaoExistenteException() {
        super(OPCAO_NAO_EXISTENTE);
    }

    public OpcaoNaoExistenteException(String erro) {
        super(erro);
    }
}
