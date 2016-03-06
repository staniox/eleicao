
import java.util.ArrayList;

public class Eleicao {

    /**
     * Lista de candidatos. Armazena todos os candidatos na memória.
     */
    ArrayList<Candidato> candidatos = new ArrayList<Candidato>();

    /**
     * Cadastra um novo candidato.
     * @param candidato Candidato a ser cadastrado.
     * @return true caso o candidato seja cadastrado. false caso contrário.
     */
    public boolean cadastrarCandidato(Candidato candidato) {
        if(candidato.numero <= 0) {
            System.out.println("O número do candidato deve ser maior do que zero.");
            return false;
        }

        if(candidato.nome == null || candidato.nome.trim().length() == 0) {
            System.out.println("O nome do candidato não pode ser vazio.");
            return false;
        }

        if(candidato.partido == null || candidato.partido.trim().length() == 0) {
            System.out.println("O nome/sigla do partido não pode ser vazio.");
            return false;
        }

        if(buscarCandidatoPorNumero(candidato.numero) == null) {
            // Não encontrou nenhum candidato com o mesmo número. Portanto, podemos adicionar o novo candidato à lista.
            candidatos.add(candidato);
            return true;
        }
        else {
            System.out.println("Já existe um candidato com o número " + candidato.numero + " cadastrado.");
        }

        return false;
    }

    /**
     * Busca um candidato pelo número.
     * @param numero Número de identificação do candidato nas eleições.
     * @return Candidato encontrado. Retorna null quando nenhum candidato for encontrado com o número fornecido.
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
     * Lista todos os candidatos cadastrados nas eleições.
     */
    public void listarCandidatos() {
        for(int i = 0; i < candidatos.size(); i++) {
            Candidato candidato = candidatos.get(i);

            System.out.println("Candidato: {número=" + candidato.numero + "; nome=" + candidato.nome + "; partido=" + candidato.partido + "}");
        }
    }

    /**
     * Exclui um candidato do banco de dados das eleições, usando seu número como referência.
     * @param numero Número do candidato a ser excluído.
     * @return true caso o candidato seja excluído. false caso contrário.
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
