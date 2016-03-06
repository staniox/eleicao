import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class Utilitarios {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Lê textos inseridos pelo usuário através do teclado.
     * @return
     */
    public static String lerStringTeclado() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Lê informações inseridas no teclado, convertendo a entrada para um número inteiro.
     * @return
     */
    public static int lerInteiroTelado() {
        String linha = lerStringTeclado();

        try {
            return Integer.valueOf(linha);
        } catch (NumberFormatException e) {
            System.out.print("Número inválido. Tente novamente. > ");
            return lerInteiroTelado();
        }
    }

    /**
     * Pausa a execução do programa.
     * @param segundos Quantidade de segundos que o programa deve ficar parado.
     */
    public static void pausarPrograma(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            // Caso esta exeção seja disparada, significa que o sistema operacional não pode pausar a execução
            // da thread atual.
            // No caso deste programa, simplesmente ignoramos a exceção e prosseguimos com a execução normal.
        }
    }
}
