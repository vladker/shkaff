package org.apache.poi.ss.formula.function;

import A3.AbstractC0157z;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.poi.util.IOUtils;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class FunctionMetadataReader {
    private static final int DEFAULT_MAX_RECORD_LENGTH = 100000;
    private static final String[] DIGIT_ENDING_FUNCTION_NAMES;
    private static final Set<String> DIGIT_ENDING_FUNCTION_NAMES_SET;
    private static final String ELLIPSIS = "...";
    private static int MAX_RECORD_LENGTH = 100000;
    private static final String METADATA_FILE_NAME = "functionMetadata.txt";
    private static final String METADATA_FILE_NAME_CETAB = "functionMetadataCetab.txt";
    private static final Pattern TAB_DELIM_PATTERN = Pattern.compile("\t");
    private static final Pattern SPACE_DELIM_PATTERN = Pattern.compile(" ");
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    static {
        String[] strArr = {"LOG10", "ATAN2", "DAYS360", "SUMXMY2", "SUMX2MY2", "SUMX2PY2", "A1.R1C1"};
        DIGIT_ENDING_FUNCTION_NAMES = strArr;
        DIGIT_ENDING_FUNCTION_NAMES_SET = new HashSet(Arrays.asList(strArr));
    }

    public static FunctionMetadataRegistry createRegistry() {
        FunctionDataBuilder functionDataBuilder = new FunctionDataBuilder(Videoio.CAP_PVAPI);
        readResourceFile(functionDataBuilder, METADATA_FILE_NAME);
        return functionDataBuilder.build();
    }

    public static FunctionMetadataRegistry createRegistryCetab() {
        FunctionDataBuilder functionDataBuilder = new FunctionDataBuilder(Videoio.CAP_PVAPI);
        readResourceFile(functionDataBuilder, METADATA_FILE_NAME_CETAB);
        return functionDataBuilder.build();
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    private static boolean isDash(String str) {
        return str.length() == 1 && str.charAt(0) == '-';
    }

    private static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new RuntimeException(AbstractC0157z.o("Value '", str, "' could not be parsed as an integer"));
        }
    }

    private static byte parseOperandTypeCode(String str) {
        if (str.length() != 1) {
            throw new RuntimeException(AbstractC0157z.o("Bad operand type code format '", str, "' expected single char"));
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == 'A') {
            return (byte) 64;
        }
        if (cCharAt == 'R') {
            return (byte) 0;
        }
        if (cCharAt == 'V') {
            return (byte) 32;
        }
        StringBuilder sbY = AbstractC0157z.y("Unexpected operand type code '", str, "' (");
        sbY.append((int) str.charAt(0));
        sbY.append(")");
        throw new IllegalArgumentException(sbY.toString());
    }

    private static byte[] parseOperandTypeCodes(String str) {
        if (str.length() < 1) {
            return EMPTY_BYTE_ARRAY;
        }
        if (isDash(str)) {
            return EMPTY_BYTE_ARRAY;
        }
        String[] strArrSplit = SPACE_DELIM_PATTERN.split(str);
        int length = strArrSplit.length;
        if (ELLIPSIS.equals(strArrSplit[length - 1])) {
            length--;
        }
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(length, MAX_RECORD_LENGTH);
        for (int i5 = 0; i5 < length; i5++) {
            bArrSafelyAllocate[i5] = parseOperandTypeCode(strArrSplit[i5]);
        }
        return bArrSafelyAllocate;
    }

    private static byte parseReturnTypeCode(String str) {
        if (str.length() == 0) {
            return (byte) 0;
        }
        return parseOperandTypeCode(str);
    }

    private static void processLine(FunctionDataBuilder functionDataBuilder, String str) {
        String[] strArrSplit = TAB_DELIM_PATTERN.split(str, -2);
        if (strArrSplit.length != 8) {
            StringBuilder sbY = AbstractC0157z.y("Bad line format '", str, "' - expected 8 data fields delimited by tab, but had ");
            sbY.append(strArrSplit.length);
            sbY.append(": ");
            sbY.append(Arrays.toString(strArrSplit));
            throw new RuntimeException(sbY.toString());
        }
        int i5 = parseInt(strArrSplit[0]);
        String str2 = strArrSplit[1];
        int i6 = parseInt(strArrSplit[2]);
        int i7 = parseInt(strArrSplit[3]);
        byte returnTypeCode = parseReturnTypeCode(strArrSplit[4]);
        byte[] operandTypeCodes = parseOperandTypeCodes(strArrSplit[5]);
        boolean z6 = strArrSplit[7].length() > 0;
        validateFunctionName(str2);
        functionDataBuilder.add(i5, str2, i6, i7, returnTypeCode, operandTypeCodes, z6);
    }

    private static void readResourceFile(FunctionDataBuilder functionDataBuilder, String str) {
        try {
            InputStream resourceAsStream = FunctionMetadataReader.class.getResourceAsStream(str);
            try {
                if (resourceAsStream == null) {
                    throw new RuntimeException("resource '" + str + "' not found");
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            bufferedReader.close();
                            resourceAsStream.close();
                            return;
                        } else if (line.length() >= 1 && line.charAt(0) != '#' && line.trim().length() >= 1) {
                            processLine(functionDataBuilder, line);
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        if (resourceAsStream != null) {
                            try {
                                resourceAsStream.close();
                            } catch (Throwable th5) {
                                th.addSuppressed(th5);
                            }
                        }
                        throw th4;
                    }
                }
            } catch (Throwable th6) {
                throw th6;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        throw new RuntimeException(e);
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    private static void validateFunctionName(String str) {
        int length = str.length() - 1;
        if (Character.isDigit(str.charAt(length))) {
            while (length >= 0 && Character.isDigit(str.charAt(length))) {
                length--;
            }
            if (!DIGIT_ENDING_FUNCTION_NAMES_SET.contains(str)) {
                throw new RuntimeException(AbstractC0157z.o("Invalid function name '", str, "' (is footnote number incorrectly appended)"));
            }
        }
    }
}
