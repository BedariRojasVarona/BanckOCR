package de.java.bankocr;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CuentaNum {

    private static final int NUMBER_OF_DIGIT_COLS = 3;
    private static final int NUMBER_OF_DIGIT_ROWS = 3;
    private static final int NUMBER_OF_DIGITS = 9;

    public static List<String> getCuentaNum(File cuentaNumFile) throws IOException {

        List<String> cuentaNum = new ArrayList<>();
        List<String> content = Files.readAllLines(cuentaNumFile.toPath());

        for (int lineIndex = 0; lineIndex < content.size(); lineIndex += NUMBER_OF_DIGIT_ROWS + 1) {

            char[][] accountEntry = new char[NUMBER_OF_DIGIT_ROWS][NUMBER_OF_DIGIT_COLS];
            accountEntry[0] = content.get(lineIndex).toCharArray();
            accountEntry[1] = content.get(lineIndex + 1).toCharArray();
            accountEntry[2] = content.get(lineIndex + 2).toCharArray();
            cuentaNum.add(parseCuentaNum(accountEntry));
        }

        return cuentaNum;
    }

    protected static String parseCuentaNum(char[][] cuentaNum) {

        StringBuilder sb = new StringBuilder();

        for (int digitIndex = 0; digitIndex < NUMBER_OF_DIGITS; digitIndex++) {
            char[][] digito = new char[NUMBER_OF_DIGIT_ROWS][NUMBER_OF_DIGIT_COLS];

            int digitStartIndex = digitIndex * NUMBER_OF_DIGIT_COLS;
            int digitEndIndex = digitStartIndex + NUMBER_OF_DIGIT_COLS;

            for (int rowIndex = 0; rowIndex < NUMBER_OF_DIGIT_ROWS; rowIndex++) {
                digito[rowIndex] = Arrays.copyOfRange(cuentaNum[rowIndex], digitStartIndex, digitEndIndex);
            }

            sb.append(parseDigito(digito));
        }

        return sb.toString();
    }

    protected static char parseDigito(char[][] digito) {

        if (Arrays.deepEquals(digito, Digitos.ZERO)) {
            return '0';
        } else if (Arrays.deepEquals(digito, Digitos.ONE)) {
            return '1';
        } else if (Arrays.deepEquals(digito, Digitos.TWO)) {
            return '2';
        } else if (Arrays.deepEquals(digito, Digitos.THREE)) {
            return '3';
        } else if (Arrays.deepEquals(digito, Digitos.FOUR)) {
            return '4';
        } else if (Arrays.deepEquals(digito, Digitos.FIVE)) {
            return '5';
        } else if (Arrays.deepEquals(digito, Digitos.SIX)) {
            return '6';
        } else if (Arrays.deepEquals(digito, Digitos.SEVEN)) {
            return '7';
        } else if (Arrays.deepEquals(digito, Digitos.EIGHT)) {
            return '8';
        } else if (Arrays.deepEquals(digito, Digitos.NINE)) {
            return '9';
        } else {
            throw new IllegalArgumentException("No se puede analizar el dígito" + Arrays.deepToString(digito));
        }
    }
}

class Digitos {

    final static char[][] ZERO = new char[][] {
            { ' ', '_', ' ' },
            { '|', ' ', '|' },
            { '|', '_', '|' }
    };

    final static char[][] ONE = new char[][] {
            { ' ', ' ', ' ' },
            { ' ', ' ', '|' },
            { ' ', ' ', '|' },
    };

    final static char[][] TWO = new char[][] {
            { ' ', '_', ' ' },
            { ' ', '_', '|' },
            { '|', '_', ' ' },
    };

    final static char[][] THREE = new char[][] {
            { ' ', '_', ' ' },
            { ' ', '_', '|' },
            { ' ', '_', '|' },
    };

    final static char[][] FOUR = new char[][] {
            { ' ', ' ', ' ' },
            { '|', '_', '|' },
            { ' ', ' ', '|' },
    };

    final static char[][] FIVE = new char[][] {
            { ' ', '_', ' ' },
            { '|', '_', ' ' },
            { ' ', '_', '|' },
    };

    final static char[][] SIX = new char[][] {
            { ' ', '_', ' ' },
            { '|', '_', ' ' },
            { '|', '_', '|' },
    };

    final static char[][] SEVEN = new char[][] {
            { ' ', '_', ' ' },
            { ' ', ' ', '|' },
            { ' ', ' ', '|' },
    };

    final static char[][] EIGHT = new char[][] {
            { ' ', '_', ' ' },
            { '|', '_', '|' },
            { '|', '_', '|' },
    };

    final static char[][] NINE = new char[][] {
            { ' ', '_', ' ' },
            { '|', '_', '|' },
            { ' ', '_', '|' },
    };
}