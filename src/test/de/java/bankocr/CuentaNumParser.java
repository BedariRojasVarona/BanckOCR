import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CuentaNumParser {

        @Test
        public static void main(String[] args) throws IOException {

                File testFile = getTestFile("numeros.txt");
                List<String> cuentanum = CuentaNumParser.getCuentaNum(testFile);
                assertEquals("No se puede analizar el número de cuenta", "123456789", cuentanum.get(0));
        }

        @Test
        public void testGetCuentaNum_NumberSet() throws IOException {

                File testFile = getTestFile("numeros.txt");
                List<String> cuentanum = CuentaNumParser.getCuentaNum(testFile);
                assertEquals("No se pueden analizar todos los números de cuenta", 12, cuentanum.size());
                assertEquals("No se puede analizar el número de cuenta", "000000000", cuentanum.get(0));
                assertEquals("No se puede analizar el número de cuenta", "000000051",
                                cuentanum.get(cuentanum.size() - 1));
        }

        private File getTestFile(String fileName) {

                URL testFileUrl = ClassLoader.getSystemResource(fileName);
                return new File(testFileUrl.getPath());
        }

        @Test
        public void testParseCuentaNum() {

                char[][] testCuentaNum = {
                                { ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', '_',
                                                ' ', ' ', '_',
                                                ' ', ' ', '_', ' ', ' ', '_', ' ' },
                                { '|', ' ', '|', '|', ' ', '|', '|', ' ', '|', '|', ' ', '|', '|', ' ', '|', '|', ' ',
                                                '|', '|', ' ',
                                                '|', '|', ' ', '|', '|', ' ', '|' },
                                { '|', '_', '|', '|', '_', '|', '|', '_', '|', '|', '_', '|', '|', '_', '|', '|', '_',
                                                '|', '|', '_',
                                                '|', '|', '_', '|', '|', '_', '|' }
                };

                String cuentanum = CuentaNumParser.parseCuentaNum(testCuentaNum);
                assertEquals("No se puede analizar el número de cuenta", "000000000", cuentanum);
        }

        @Test
        public void testParseDigito() {

                List<char[][]> testDigitos = getDigitos();

                assertEquals("No se puede analizar el dígito", '0', CuentaNumParser.parseDigito(testDigitos.get(0)));
                assertEquals("No se puede analizar el dígito", '1', CuentaNumParser.parseDigito(testDigitos.get(1)));
                assertEquals("No se puede analizar el dígito", '2', CuentaNumParser.parseDigito(testDigitos.get(2)));
                assertEquals("No se puede analizar el dígito", '3', CuentaNumParser.parseDigito(testDigitos.get(3)));
                assertEquals("No se puede analizar el dígito", '4', CuentaNumParser.parseDigito(testDigitos.get(4)));
                assertEquals("No se puede analizar el dígito", '5', CuentaNumParser.parseDigito(testDigitos.get(5)));
                assertEquals("No se puede analizar el dígito", '6', CuentaNumParser.parseDigito(testDigitos.get(6)));
                assertEquals("No se puede analizar el dígito", '7', CuentaNumParser.parseDigito(testDigitos.get(7)));
                assertEquals("No se puede analizar el dígito", '8', CuentaNumParser.parseDigito(testDigitos.get(8)));
                assertEquals("No se puede analizar el dígito", '9', CuentaNumParser.parseDigito(testDigitos.get(9)));
        }

        private List<char[][]> getDigitos() {

                char[][] Digito0 = new char[][] {
                                { ' ', '_', ' ' },
                                { '|', ' ', '|' },
                                { '|', '_', '|' },
                };

                char[][] Digito1 = new char[][] {
                                { ' ', ' ', ' ' },
                                { ' ', ' ', '|' },
                                { ' ', ' ', '|' },
                };

                char[][] Digito2 = new char[][] {
                                { ' ', '_', ' ' },
                                { ' ', '_', '|' },
                                { '|', '_', ' ' },
                };

                char[][] Digito3 = new char[][] {
                                { ' ', '_', ' ' },
                                { ' ', '_', '|' },
                                { ' ', '_', '|' },
                };

                char[][] Digito4 = new char[][] {
                                { ' ', ' ', ' ' },
                                { '|', '_', '|' },
                                { ' ', ' ', '|' },
                };

                char[][] Digito5 = new char[][] {
                                { ' ', '_', ' ' },
                                { '|', '_', ' ' },
                                { ' ', '_', '|' },
                };

                char[][] Digito6 = new char[][] {
                                { ' ', '_', ' ' },
                                { '|', '_', ' ' },
                                { '|', '_', '|' },
                };

                char[][] Digito7 = new char[][] {
                                { ' ', '_', ' ' },
                                { ' ', ' ', '|' },
                                { ' ', ' ', '|' },
                };

                char[][] Digito8 = new char[][] {
                                { ' ', '_', ' ' },
                                { '|', '_', '|' },
                                { '|', '_', '|' },
                };

                char[][] Digito9 = new char[][] {
                                { ' ', '_', ' ' },
                                { '|', '_', '|' },
                                { ' ', '_', '|' },
                };

                List<char[][]> Digitos = new ArrayList<>();
                Digitos.add(Digito0);
                Digitos.add(Digito1);
                Digitos.add(Digito2);
                Digitos.add(Digito3);
                Digitos.add(Digito4);
                Digitos.add(Digito5);
                Digitos.add(Digito6);
                Digitos.add(Digito7);
                Digitos.add(Digito8);
                Digitos.add(Digito9);

                return Digitos;
        }

        @Test(expected = IllegalArgumentException.class)
        public void testParseDigito_failure() {

                char[][] Digito = new char[][] {
                                { ' ', '_', ' ' },
                                { '|', '?', '|' },
                                { '|', '_', '|' },
                };

                CuentaNumParser.parseDigito(Digito);
        }
}
