/**
 * Classe principal da aplica��o.
 */
public class Principal {

    private static Eleicao eleicao = new Eleicao();

    /**
     * M�todo main.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println("== Elei��es 2016 - Sistema de Controle");
        System.out.println("============================================================");
        exibirMenuOpcoes();

        int opcao = Utilitarios.lerInteiroTelado();

        while(opcao != 5) {
            switch (Integer.valueOf(opcao)) {
                case 1:
                    executarCadastroCandidato();
                    break;

                case 2:
                    executarBuscaCandidatoPeloNumero();
                    break;

                case 3:
                    executarListagemCandidatos();
                    break;

                case 4:
                    executarAcaoExcluirCandidato();
                    break;
            }

            exibirMenuOpcoes();
            opcao = Utilitarios.lerInteiroTelado();
        }

        System.out.println();
        System.out.println("ENCERRANDO O PROGRAMA.");
        System.out.println(">>> OBRIGADO POR UTILIZAR. (PT FOREVER) <<<");
    }

    /**
     * Exibe o menu com as op��es dispon�veis para o usu�rio.
     */
    public static void exibirMenuOpcoes() {
        System.out.println("");
        System.out.println(">> Escolha um op��o. Digite o n�mero da op��o e pressione ENTER:");
        System.out.println("1 - Cadastrar Candidato; ");
        System.out.println("2 - Buscar candidato pelo n�mero; ");
        System.out.println("3 - Listar candidatos; ");
        System.out.println("4 - Excluir candidato; ");
        System.out.println("----------------------------------");
        System.out.println("5 - Sair do programa; ");
    }

    /**
     * Solicita as informa��es para cadastrar um novo candidato.
     */
    private static void executarCadastroCandidato() {
        Candidato candidato = new Candidato();

        System.out.print("Digite o n�mero do candidato. > ");
        candidato.numero = Utilitarios.lerInteiroTelado();

        System.out.print("Digite o nome do candidato. > ");
        candidato.nome = Utilitarios.lerStringTeclado();

        System.out.print("Digite o nome/sigla do partido do candidato. > ");
        candidato.partido = Utilitarios.lerStringTeclado();

        if(eleicao.cadastrarCandidato(candidato)) {
            System.out.println(">>> CANDIDATO CADASTRADO COM SUCESSO! <<<");
        } else {
            System.out.println("<<< CANDIDATO N�O CADASTRADO. >>>");
        }

        Utilitarios.pausarPrograma(2); // Pausa o programa por 2 segundos.
        System.out.println();
    }

    /**
     * Executa a a��o da op��o de busca de candidato.
     */
    private static void executarBuscaCandidatoPeloNumero() {
        System.out.print("Digite o n�mero do candidato. > ");
        int numero = Utilitarios.lerInteiroTelado();

        Candidato candidato = eleicao.buscarCandidatoPorNumero(numero);

        if(candidato == null) {
            System.out.println("<<< CANDIDATO COM O N�MERO " + numero + " N�O ENCONTRADO. >>>");
            eleicao.listarCandidatos();
            Utilitarios.pausarPrograma(2);
            return;
        }

        System.out.println(">>> CANDIDATO ENCONTRADO. <<<");
        System.out.println("N�mero: " + candidato.numero);
        System.out.println("Nome: " + candidato.nome);
        System.out.println("Partido: " + candidato.partido);

        Utilitarios.pausarPrograma(2); // Pausa o programa por 2 segundos.
        System.out.println();
    }

    /**
     * Executa a a��o da op��o de listagem de candidatos.
     */
    private static void executarListagemCandidatos() {
        if(eleicao.candidatos.size() == 0) {
            System.out.println("<<< NENHUM CANDIDATO FOI CADASTRADO AT� O MOMENTO. >>>");
            Utilitarios.pausarPrograma(2);
            System.out.println();
            return;
        }

        System.out.println(">>> CANDIDATOS CADASTRADOS AT� O MOMENTO. <<<");
        eleicao.listarCandidatos();
        Utilitarios.pausarPrograma(2);
        System.out.println();
    }

    /**
     * Executa a a��o da op��o de exclus�o de candidatos.
     */
    private static void executarAcaoExcluirCandidato() {
        System.out.print("Digite o n�mero do candidato. > ");
        int numero = Utilitarios.lerInteiroTelado();

        if(eleicao.buscarCandidatoPorNumero(numero) == null) {
            System.out.println("<<< CANDIDATO COM N�MERO " + numero + " N�O ENCONTRADO. >>>");
            eleicao.listarCandidatos();
            Utilitarios.pausarPrograma(2);
            return;
        }

        if(eleicao.excluirCandidatoPorNumero(numero)) {
            System.out.println(">>> CANDIDATO EXCLU�DO COM SUCESSO. <<<");
        } else {
            System.out.println("<<< CANDIDATO N�O EXCLU�DO. >>>");
        }

        eleicao.listarCandidatos();
        Utilitarios.pausarPrograma(2);
    }
}
