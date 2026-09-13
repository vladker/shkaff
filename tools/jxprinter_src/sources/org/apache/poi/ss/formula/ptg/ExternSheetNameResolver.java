package org.apache.poi.ss.formula.ptg;

import org.apache.logging.log4j.util.Chars;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class ExternSheetNameResolver {
    private ExternSheetNameResolver() {
    }

    public static String prependSheetName(FormulaRenderingWorkbook formulaRenderingWorkbook, int i5, String str) {
        StringBuilder sb;
        EvaluationWorkbook.ExternalSheet externalSheet = formulaRenderingWorkbook.getExternalSheet(i5);
        if (externalSheet != null) {
            String workbookName = externalSheet.getWorkbookName();
            String sheetName = externalSheet.getSheetName();
            if (workbookName != null) {
                sb = new StringBuilder(str.length() + workbookName.length() + (sheetName == null ? 0 : sheetName.length()) + 4);
                SheetNameFormatter.appendFormat(sb, workbookName, sheetName);
            } else {
                sb = new StringBuilder(str.length() + sheetName.length() + 4);
                SheetNameFormatter.appendFormat(sb, sheetName);
            }
            if (externalSheet instanceof EvaluationWorkbook.ExternalSheetRange) {
                EvaluationWorkbook.ExternalSheetRange externalSheetRange = (EvaluationWorkbook.ExternalSheetRange) externalSheet;
                if (!externalSheetRange.getFirstSheetName().equals(externalSheetRange.getLastSheetName())) {
                    sb.append(NameUtil.COLON);
                    StringBuilder sb2 = new StringBuilder();
                    SheetNameFormatter.appendFormat(sb2, externalSheetRange.getLastSheetName());
                    if (sb2.charAt(0) == '\'') {
                        sb.insert(0, Chars.QUOTE);
                        sb.append(sb2.substring(1));
                    } else {
                        sb.append((CharSequence) sb2);
                    }
                }
            }
        } else {
            String sheetFirstNameByExternSheet = formulaRenderingWorkbook.getSheetFirstNameByExternSheet(i5);
            String sheetLastNameByExternSheet = formulaRenderingWorkbook.getSheetLastNameByExternSheet(i5);
            sb = new StringBuilder(str.length() + sheetFirstNameByExternSheet.length() + 4);
            if (sheetFirstNameByExternSheet.length() < 1) {
                sb.append("#REF");
            } else {
                SheetNameFormatter.appendFormat(sb, sheetFirstNameByExternSheet);
                if (!sheetFirstNameByExternSheet.equals(sheetLastNameByExternSheet)) {
                    sb.append(NameUtil.COLON);
                    sb.append(sheetLastNameByExternSheet);
                }
            }
        }
        sb.append('!');
        sb.append(str);
        return sb.toString();
    }
}
