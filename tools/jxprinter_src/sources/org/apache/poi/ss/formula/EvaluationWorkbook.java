package org.apache.poi.ss.formula;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.ptg.NamePtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public interface EvaluationWorkbook {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ExternalName {
        private final int _ix;
        private final String _nameName;
        private final int _nameNumber;

        public ExternalName(String str, int i5, int i6) {
            this._nameName = str;
            this._nameNumber = i5;
            this._ix = i6;
        }

        public int getIx() {
            return this._ix;
        }

        public String getName() {
            return this._nameName;
        }

        public int getNumber() {
            return this._nameNumber;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ExternalSheet {
        private final String _sheetName;
        private final String _workbookName;

        public ExternalSheet(String str, String str2) {
            this._workbookName = str;
            this._sheetName = str2;
        }

        public String getSheetName() {
            return this._sheetName;
        }

        public String getWorkbookName() {
            return this._workbookName;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ExternalSheetRange extends ExternalSheet {
        private final String _lastSheetName;

        public ExternalSheetRange(String str, String str2, String str3) {
            super(str, str2);
            this._lastSheetName = str3;
        }

        public String getFirstSheetName() {
            return getSheetName();
        }

        public String getLastSheetName() {
            return this._lastSheetName;
        }
    }

    void clearAllCachedResultValues();

    int convertFromExternSheetIndex(int i5);

    ExternalName getExternalName(int i5, int i6);

    ExternalName getExternalName(String str, String str2, int i5);

    ExternalSheet getExternalSheet(int i5);

    ExternalSheet getExternalSheet(String str, String str2, int i5);

    Ptg[] getFormulaTokens(EvaluationCell evaluationCell);

    EvaluationName getName(String str, int i5);

    EvaluationName getName(NamePtg namePtg);

    EvaluationSheet getSheet(int i5);

    int getSheetIndex(String str);

    int getSheetIndex(EvaluationSheet evaluationSheet);

    String getSheetName(int i5);

    SpreadsheetVersion getSpreadsheetVersion();

    UDFFinder getUDFFinder();

    String resolveNameXText(NameXPtg nameXPtg);
}
