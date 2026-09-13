package org.apache.poi.xssf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class XSSFLineBreak extends XSSFTextRun {
    private final CTTextCharacterProperties _brProps;

    public XSSFLineBreak(CTRegularTextRun cTRegularTextRun, XSSFTextParagraph xSSFTextParagraph, CTTextCharacterProperties cTTextCharacterProperties) {
        super(cTRegularTextRun, xSSFTextParagraph);
        this._brProps = cTTextCharacterProperties;
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFTextRun
    public CTTextCharacterProperties getRPr() {
        return this._brProps;
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFTextRun
    public void setText(String str) {
        throw new IllegalStateException("You cannot change text of a line break, it is always '\\n'");
    }
}
