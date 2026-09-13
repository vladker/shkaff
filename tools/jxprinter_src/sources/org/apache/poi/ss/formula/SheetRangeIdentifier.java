package org.apache.poi.ss.formula;

import org.apache.logging.log4j.util.Chars;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SheetRangeIdentifier extends SheetIdentifier {
    private final NameIdentifier _lastSheetIdentifier;

    public SheetRangeIdentifier(String str, NameIdentifier nameIdentifier, NameIdentifier nameIdentifier2) {
        super(str, nameIdentifier);
        this._lastSheetIdentifier = nameIdentifier2;
    }

    @Override // org.apache.poi.ss.formula.SheetIdentifier
    public void asFormulaString(StringBuilder sb) {
        super.asFormulaString(sb);
        sb.append(NameUtil.COLON);
        if (!this._lastSheetIdentifier.isQuoted()) {
            sb.append(this._lastSheetIdentifier.getName());
            return;
        }
        sb.append(Chars.QUOTE);
        sb.append(this._lastSheetIdentifier.getName());
        sb.append("'");
    }

    public NameIdentifier getFirstSheetIdentifier() {
        return super.getSheetIdentifier();
    }

    public NameIdentifier getLastSheetIdentifier() {
        return this._lastSheetIdentifier;
    }
}
