package org.apache.poi.ss.util;

import A3.AbstractC0157z;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class WorkbookUtil {
    public static String createSafeSheetName(String str) {
        return createSafeSheetName(str, Chars.SPACE);
    }

    public static void validateSheetName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("sheetName must not be null");
        }
        int length = str.length();
        if (length < 1 || length > 31) {
            throw new IllegalArgumentException(AbstractC0157z.o("sheetName '", str, "' is invalid - character count MUST be greater than or equal to 1 and less than or equal to 31"));
        }
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = str.charAt(i5);
            if (cCharAt != '*' && cCharAt != '/' && cCharAt != ':' && cCharAt != '?') {
                switch (cCharAt) {
                    case '[':
                    case '\\':
                    case ']':
                        break;
                    default:
                        break;
                }
            }
            StringBuilder sb = new StringBuilder("Invalid char (");
            sb.append(cCharAt);
            sb.append(") found at index (");
            sb.append(i5);
            sb.append(") in sheet name '");
            throw new IllegalArgumentException(AbstractC0157z.s(sb, str, "'"));
        }
        if (str.charAt(0) == '\'' || str.charAt(length - 1) == '\'') {
            throw new IllegalArgumentException(AbstractC0157z.o("Invalid sheet name '", str, "'. Sheet names must not begin or end with (')."));
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0050  */
    public static String createSafeSheetName(String str, char c) {
        if (str == null) {
            return AbstractC1127c.NULL;
        }
        if (str.length() < 1) {
            return "empty";
        }
        int iMin = Math.min(31, str.length());
        StringBuilder sb = new StringBuilder(str.substring(0, iMin));
        for (int i5 = 0; i5 < iMin; i5++) {
            char cCharAt = sb.charAt(i5);
            if (cCharAt == 0 || cCharAt == 3) {
                sb.setCharAt(i5, c);
            } else if (cCharAt != '\'') {
                if (cCharAt != '*' && cCharAt != '/' && cCharAt != ':' && cCharAt != '?') {
                    switch (cCharAt) {
                        case '[':
                        case '\\':
                        case ']':
                            sb.setCharAt(i5, c);
                            break;
                    }
                } else {
                    sb.setCharAt(i5, c);
                }
            } else if (i5 == 0 || i5 == iMin - 1) {
                sb.setCharAt(i5, c);
            }
        }
        return sb.toString();
    }
}
