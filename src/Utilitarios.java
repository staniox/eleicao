import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class Utilitarios {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * L� textos inseridos pelo usu�rio atrav�s do teclado.
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
     * L� informa��es inseridas no teclado, convertendo a entrada para um n�mero inteiro.
     * @return
     */
    public static int lerInteiroTelado() {
        String linha = lerStringTeclado();

        try {
            return Integer.valueOf(linha);
        } catch (NumberFormatException e) {
            System.out.print("N�mero inv�lido. Tente novamente. > ");
            return lerInteiroTelado();
        }
    }

    /**
     * Pausa a execu��o do programa.
     * @param segundos Quantidade de segundos que o programa deve ficar parado.
     */
    public static void pausarPrograma(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            // Caso esta exe��o seja disparada, significa que o sistema operacional n�o pode pausar a execu��o
            // da thread atual.
            // No caso deste programa, simplesmente ignoramos a exce��o e prosseguimos com a execu��o normal.
        }
    }
}
