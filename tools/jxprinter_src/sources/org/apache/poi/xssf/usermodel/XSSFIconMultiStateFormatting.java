package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
import org.apache.poi.ss.usermodel.IconMultiStateFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfvo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STIconSetType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFIconMultiStateFormatting implements IconMultiStateFormatting {
    CTIconSet _iconset;

    public XSSFIconMultiStateFormatting(CTIconSet cTIconSet) {
        this._iconset = cTIconSet;
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public IconMultiStateFormatting.IconSet getIconSet() {
        return IconMultiStateFormatting.IconSet.byName(this._iconset.getIconSet().toString());
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public boolean isIconOnly() {
        if (this._iconset.isSetShowValue()) {
            return !this._iconset.getShowValue();
        }
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public boolean isReversed() {
        if (this._iconset.isSetReverse()) {
            return this._iconset.getReverse();
        }
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public void setIconOnly(boolean z6) {
        this._iconset.setShowValue(!z6);
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public void setIconSet(IconMultiStateFormatting.IconSet iconSet) {
        this._iconset.setIconSet(STIconSetType.Enum.forString(iconSet.name));
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public void setReversed(boolean z6) {
        this._iconset.setReverse(z6);
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public void setThresholds(ConditionalFormattingThreshold[] conditionalFormattingThresholdArr) {
        CTCfvo[] cTCfvoArr = new CTCfvo[conditionalFormattingThresholdArr.length];
        for (int i5 = 0; i5 < conditionalFormattingThresholdArr.length; i5++) {
            cTCfvoArr[i5] = ((XSSFConditionalFormattingThreshold) conditionalFormattingThresholdArr[i5]).getCTCfvo();
        }
        this._iconset.setCfvoArray(cTCfvoArr);
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public XSSFConditionalFormattingThreshold createThreshold() {
        return new XSSFConditionalFormattingThreshold(this._iconset.addNewCfvo());
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public XSSFConditionalFormattingThreshold[] getThresholds() {
        CTCfvo[] cfvoArray = this._iconset.getCfvoArray();
        XSSFConditionalFormattingThreshold[] xSSFConditionalFormattingThresholdArr = new XSSFConditionalFormattingThreshold[cfvoArray.length];
        for (int i5 = 0; i5 < cfvoArray.length; i5++) {
            xSSFConditionalFormattingThresholdArr[i5] = new XSSFConditionalFormattingThreshold(cfvoArray[i5]);
        }
        return xSSFConditionalFormattingThresholdArr;
    }
}
