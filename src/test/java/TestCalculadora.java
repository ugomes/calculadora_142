import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import com.iterasys.*;

public class TestCalculadora {

    @Test
    @DisplayName("Teste de soma")
    public void testSomar() {
        float num1 = 5;
        float num2 = 3;
        float resultadoEsperado = 8;
        float resultadoObtido = Main.somar(num1, num2);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    @Test
    @DisplayName("Teste de subtração")
    public void testSubtrair() {
        float num1 = 5;
        float num2 = 3;
        float resultadoEsperado = 2;
        float resultadoObtido = Main.subtrair(num1, num2);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    @Test
    @DisplayName("Teste de multiplicação")
    public void testMultiplicar() {
        float num1 = 5;
        float num2 = 3;
        float resultadoEsperado = 15;
        float resultadoObtido = Main.multiplicar(num1, num2);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    @Test
    @DisplayName("Teste de divisão")
    public void testDividir() {
        float num1 = 6;
        float num2 = 3;
        float resultadoEsperado = 2;
        float resultadoObtido = Main.dividir(num1, num2);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    @Test
    @DisplayName("Teste de divisão por zero")
    public void testDividirPorZero() {
        int num1 = 6;
        int num2 = 0;
        String resultadoEsperado = "Divisão por zero não é permitida.";
        String resultadoObtido = Main.dividirTry(num1, num2);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

     // DDT: Data Driven Testing --> Teste orientado a dados
    // Teste com Massa
@ParameterizedTest
@CsvSource(value = {
    "5, 3, 8",
    "10, 2, 12",
    "7, 5, 12",
    "-5, -3, -8",
    "-7, 3, -4",
    "-1, -1, -2"
}, delimiter = ',')
@DisplayName("Teste de soma com massa de dados")
public void testSomarComMassa(float num1, float num2, float resultadoEsperado) {
    float resultadoObtido = Main.somar(num1, num2);
    assertEquals(resultadoEsperado, resultadoObtido);
}
    @ParameterizedTest
    @CsvSource(value = {
        "5, 3, 2",
        "10, 2, 8",
        "7, 5, 2",
        "-5, -3, -2",
        "-7, 3, -10",
        "-1, -1, 0"
    }, delimiter = ',')
    @DisplayName("Teste de subtração com massa de dados")
    public void testSubtrairComMassa(float num1, float num2, float resultadoEsperado) {
        float resultadoObtido = Main.subtrair(num1, num2);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    @ParameterizedTest
    @CsvSource(value = {
        "5, 3, 15",
        "10, 2, 20",
        "7, 5, 35",
        "-5, -3, 15",
        "-7, 3, -21",
        "-1, -1, 1"
    }, delimiter = ',')
    @DisplayName("Teste de multiplicação com massa de dados")
    public void testMultiplicarComMassa(float num1, float num2, float resultadoEsperado) {
        float resultadoObtido = Main.multiplicar(num1, num2);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    @ParameterizedTest
    @CsvSource(value = {
        "6, 3, 2",
        "10, 2, 5",
        "7, 5, 1.4",
        "-6, -3, 2",
        "-10, 2, -5",
        "-1, -1, 1"
    }, delimiter = ',')     
    @DisplayName("Teste de divisão com massa de dados")
    public void testDividirComMassa(float num1, float num2, float resultadoEsperado) {
        float resultadoObtido = Main.dividir(num1, num2);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    @ParameterizedTest
    @CsvSource(value = {    
        "6, 0, 'Divisão por zero não é permitida.'",
        "10, 0, 'Divisão por zero não é permitida.'",
        "7, 0, 'Divisão por zero não é permitida.'",
        "-6, 0, 'Divisão por zero não é permitida.'",
        "-10, 0, 'Divisão por zero não é permitida.'",
        "-1, 0, 'Divisão por zero não é permitida.'"
    }, delimiter = ',')
    @DisplayName("Teste de divisão por zero com massa de dados")
    public void testDividirPorZeroComMassa(float num1, float num2, String resultadoEsperado) {
        String resultadoObtido = Main.dividirTry((int) num1, (int) num2);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "csv/somar.csv", numLinesToSkip = 1, delimiter = ',')
    @DisplayName("Teste de soma usando massa de dados do arquivo CSV")
    public void testSomarCSV(float num1, float num2, float resultadoEsperado) {
        float resultadoObtido = Main.somar(num1, num2);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "csv/subtrair.csv", numLinesToSkip = 1, delimiter = ',')
    @DisplayName("Teste de subtração usando massa de dados do arquivo CSV")
    public void testSubtrairCSV(float num1, float num2, float resultadoEsperado) {
        float resultadoObtido = Main.subtrair(num1, num2);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "csv/multiplicar.csv", numLinesToSkip = 1, delimiter = ',')
    @DisplayName("Teste de multiplicação usando massa de dados do arquivo CSV")
    public void testMultiplicarCSV(float num1, float num2, float resultadoEsperado) {
        float resultadoObtido = Main.multiplicar(num1, num2);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "csv/dividir.csv", numLinesToSkip = 1, delimiter = ',')
    @DisplayName("Teste de divisão usando massa de dados do arquivo CSV")
    public void testDividirCSV(float num1, float num2, float resultadoEsperado) {
        float resultadoObtido = Main.dividir(num1, num2);
        assertEquals(resultadoEsperado, resultadoObtido);


    }
    @ParameterizedTest
    @CsvFileSource(resources = "csv/dividirporzero.csv", numLinesToSkip = 1, delimiter = ',')
    @DisplayName("Teste de divisão por zero usando massa de dados do arquivo CSV")
    public void testDividirPorZeroCSV(float num1, float num2, String resultadoEsperado) {
        String resultadoObtido = Main.dividirTry((int) num1, (int) num2);
        assertEquals(resultadoEsperado, resultadoObtido);   
    }

}

