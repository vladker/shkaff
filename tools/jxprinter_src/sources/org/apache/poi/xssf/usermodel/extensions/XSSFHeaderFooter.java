package org.apache.poi.xssf.usermodel.extensions;

import org.apache.poi.ss.usermodel.HeaderFooter;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.helpers.HeaderFooterHelper;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class XSSFHeaderFooter implements HeaderFooter {
    private final CTHeaderFooter headerFooter;
    private final HeaderFooterHelper helper = new HeaderFooterHelper();
    private boolean stripFields;

    public XSSFHeaderFooter(CTHeaderFooter cTHeaderFooter) {
        this.headerFooter = cTHeaderFooter;
    }

    public static String stripFields(String str) {
        return org.apache.poi.hssf.usermodel.HeaderFooter.stripFields(str);
    }

    public boolean areFieldsStripped() {
        return this.stripFields;
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public String getCenter() {
        String centerSection = this.helper.getCenterSection(getText());
        return this.stripFields ? stripFields(centerSection) : centerSection;
    }

    @Internal
    public CTHeaderFooter getHeaderFooter() {
        return this.headerFooter;
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public String getLeft() {
        String leftSection = this.helper.getLeftSection(getText());
        return this.stripFields ? stripFields(leftSection) : leftSection;
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public String getRight() {
        String rightSection = this.helper.getRightSection(getText());
        return this.stripFields ? stripFields(rightSection) : rightSection;
    }

    public abstract String getText();

    public String getValue() {
        String text = getText();
        return text == null ? "" : text;
    }

    public void setAreFieldsStripped(boolean z6) {
        this.stripFields = z6;
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public void setCenter(String str) {
        setText(this.helper.setCenterSection(getText(), str));
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public void setLeft(String str) {
        setText(this.helper.setLeftSection(getText(), str));
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public void setRight(String str) {
        setText(this.helper.setRightSection(getText(), str));
    }

    public abstract void setText(String str);
}
