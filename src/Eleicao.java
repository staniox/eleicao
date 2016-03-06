
import java.util.ArrayList;

public class Eleicao {

    /**
     * Lista de candidatos. Armazena todos os candidatos na mem�ria.
     */
    ArrayList<Candidato> candidatos = new ArrayList<Candidato>();

    /**
     * Cadastra um novo candidato.
     * @param candidato Candidato a ser cadastrado.
     * @return true caso o candidato seja cadastrado. false caso contr�rio.
     */
    public boolean cadastrarCandidato(Candidato candidato) {
        if(candidato.numero <= 0) {
            System.out.println("O n�mero do candidato deve ser maior do que zero.");
            return false;
        }

        if(candidato.nome == null || candidato.nome.trim().length() == 0) {
            System.out.println("O nome do candidato n�o pode ser vazio.");
            return false;
        }

        if(candidato.partido == null || candidato.partido.trim().length() == 0) {
            System.out.println("O nome/sigla do partido n�o pode ser vazio.");
            return false;
        }

        if(buscarCandidatoPorNumero(candidato.numero) == null) {
            // N�o encontrou nenhum candidato com o mesmo n�mero. Portanto, podemos adicionar o novo candidato � lista.
            candidatos.add(candidato);
            return true;
        }
        else {
            System.out.println("J� existe um candidato com o n�mero " + candidato.numero + " cadastrado.");
        }

        return false;
    }

    /**
     * Busca um candidato pelo n�mero.
     * @param numero N�mero de identifica��o do candidato nas elei��es.
     * @return Candidato encontrado. Retorna null quando nenhum candidato for encontrado com o n�mero fornecido.
     */
    public Candidato buscarCandidatoPorNumero(int numero) {
        for(int i = 0; i < candidatos.size(); i++) {
            Candidato candidato = candidatos.get(i);

            if(candidato.numero == numero) {
                return candidato;
            }
        }

        return null;
    }

    /**
     * Lista todos os candidatos cadastrados nas elei��es.
     */
    public void listarCandidatos() {
        for(int i = 0; i < candidatos.size(); i++) {
            Candidato candidato = candidatos.get(i);

            System.out.println("Candidato: {n�mero=" + candidato.numero + "; nome=" + candidato.nome + "; partido=" + candidato.partido + "}");
        }
    }

    /**
     * Exclui um candidato do banco de dados das elei��es, usando seu n�mero como refer�ncia.
     * @param numero N�mero do candidato a ser exclu�do.
     * @return true caso o candidato seja exclu�do. false caso contr�rio.
     */
    public boolean excluirCandidatoPorNumero(int numero) {
        for(int i = 0; i < candidatos.size(); i++) {
            Candidato candidato = candidatos.get(i);

            if(candidato.numero == numero) {
                candidatos.remove(i);
                return true;
            }
        }

        return false;
    }

}
