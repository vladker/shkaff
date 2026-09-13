package org.apache.poi.ss.formula;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class SheetNameFormatter {
    private static final Pattern CELL_REF_PATTERN = Pattern.compile("([A-Za-z]+)([0-9]+)");
    private static final char DELIMITER = '\'';

    private SheetNameFormatter() {
    }

    public static void appendAndEscape(Appendable appendable, String str) {
        try {
            if (str == null) {
                appendable.append("#REF");
                return;
            }
            int length = str.length();
            for (int i5 = 0; i5 < length; i5++) {
                char cCharAt = str.charAt(i5);
                if (cCharAt == '\'') {
                    appendable.append('\'');
                }
                appendable.append(cCharAt);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void appendFormat(Appendable appendable, String str) {
        try {
            if (!needsDelimiting(str)) {
                appendAndEscape(appendable, str);
                return;
            }
            appendable.append('\'');
            appendAndEscape(appendable, str);
            appendable.append('\'');
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void appendOrREF(Appendable appendable, String str) throws IOException {
        if (str == null) {
            appendable.append("#REF");
        } else {
            appendable.append(str);
        }
    }

    public static boolean cellReferenceIsWithinRange(String str, String str2) {
        return CellReference.cellReferenceIsWithinRange(str, str2, SpreadsheetVersion.EXCEL97);
    }

    public static String format(String str) {
        StringBuilder sb = new StringBuilder((str == null ? 0 : str.length()) + 2);
        appendFormat(sb, str);
        return sb.toString();
    }

    public static boolean isSpecialChar(char c) {
        if (Character.isLetterOrDigit(c)) {
            return false;
        }
        if (c != '\t' && c != '\n' && c != '\r') {
            return (c == '.' || c == '_') ? false : true;
        }
        throw new RuntimeException("Illegal character (0x" + Integer.toHexString(c) + ") found in sheet name");
    }

    private static boolean nameLooksLikeBooleanLiteral(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt != 'F') {
            if (cCharAt != 'T') {
                if (cCharAt != 'f') {
                    if (cCharAt != 't') {
                        return false;
                    }
                }
            }
            return "TRUE".equalsIgnoreCase(str);
        }
        return "FALSE".equalsIgnoreCase(str);
    }

    public static boolean nameLooksLikePlainCellReference(String str) {
        Matcher matcher = CELL_REF_PATTERN.matcher(str);
        if (matcher.matches()) {
            return cellReferenceIsWithinRange(matcher.group(1), matcher.group(2));
        }
        return false;
    }

    public static boolean needsDelimiting(String str) {
        int length;
        if (str == null || (length = str.length()) < 1) {
            return false;
        }
        if (Character.isDigit(str.charAt(0))) {
            return true;
        }
        for (int i5 = 0; i5 < length; i5++) {
            if (isSpecialChar(str.charAt(i5))) {
                return true;
            }
        }
        return (Character.isLetter(str.charAt(0)) && Character.isDigit(str.charAt(length - 1)) && nameLooksLikePlainCellReference(str)) || nameLooksLikeBooleanLiteral(str);
    }

    public static void appendFormat(Appendable appendable, String str, String str2) {
        try {
            if (!needsDelimiting(str) && !needsDelimiting(str2)) {
                appendable.append('[');
                appendOrREF(appendable, str);
                appendable.append(']');
                appendOrREF(appendable, str2);
                return;
            }
            appendable.append('\'');
            appendable.append('[');
            appendAndEscape(appendable, str.replace('[', '(').replace(']', ')'));
            appendable.append(']');
            appendAndEscape(appendable, str2);
            appendable.append('\'');
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
