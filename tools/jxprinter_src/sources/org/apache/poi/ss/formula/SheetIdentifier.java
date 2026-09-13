package org.apache.poi.ss.formula;

import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SheetIdentifier {
    private final String _bookName;
    private final NameIdentifier _sheetIdentifier;

    public SheetIdentifier(String str, NameIdentifier nameIdentifier) {
        this._bookName = str;
        this._sheetIdentifier = nameIdentifier;
    }

    public void asFormulaString(StringBuilder sb) {
        if (this._bookName != null) {
            sb.append(" [");
            sb.append(this._sheetIdentifier.getName());
            sb.append("]");
        }
        if (!this._sheetIdentifier.isQuoted()) {
            sb.append(this._sheetIdentifier.getName());
            return;
        }
        sb.append(Chars.QUOTE);
        sb.append(this._sheetIdentifier.getName());
        sb.append("'");
    }

    public String getBookName() {
        return this._bookName;
    }

    public NameIdentifier getSheetIdentifier() {
        return this._sheetIdentifier;
    }

    public String toString() {
        return getClass().getName() + " [" + asFormulaString() + "]";
    }

    public String asFormulaString() {
        StringBuilder sb = new StringBuilder(32);
        asFormulaString(sb);
        return sb.toString();
    }
}
