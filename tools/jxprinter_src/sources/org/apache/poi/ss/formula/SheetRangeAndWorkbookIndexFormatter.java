package org.apache.poi.ss.formula;

import org.apache.logging.log4j.util.Chars;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SheetRangeAndWorkbookIndexFormatter {
    private SheetRangeAndWorkbookIndexFormatter() {
    }

    private static boolean anySheetNameNeedsEscaping(String str, String str2) {
        return SheetNameFormatter.needsDelimiting(str) | SheetNameFormatter.needsDelimiting(str2);
    }

    public static String format(StringBuilder sb, int i5, String str, String str2) {
        return anySheetNameNeedsEscaping(str, str2) ? formatWithDelimiting(sb, i5, str, str2) : formatWithoutDelimiting(sb, i5, str, str2);
    }

    private static String formatWithDelimiting(StringBuilder sb, int i5, String str, String str2) {
        sb.append(Chars.QUOTE);
        if (i5 >= 0) {
            sb.append('[');
            sb.append(i5);
            sb.append(']');
        }
        SheetNameFormatter.appendAndEscape(sb, str);
        if (str2 != null) {
            sb.append(NameUtil.COLON);
            SheetNameFormatter.appendAndEscape(sb, str2);
        }
        sb.append(Chars.QUOTE);
        return sb.toString();
    }

    private static String formatWithoutDelimiting(StringBuilder sb, int i5, String str, String str2) {
        if (i5 >= 0) {
            sb.append('[');
            sb.append(i5);
            sb.append(']');
        }
        sb.append(str);
        if (str2 != null) {
            sb.append(NameUtil.COLON);
            sb.append(str2);
        }
        return sb.toString();
    }
}
