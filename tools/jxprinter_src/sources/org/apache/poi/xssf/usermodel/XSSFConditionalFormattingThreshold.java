package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfvo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCfvoType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFConditionalFormattingThreshold implements ConditionalFormattingThreshold {
    private final CTCfvo cfvo;

    public XSSFConditionalFormattingThreshold(CTCfvo cTCfvo) {
        this.cfvo = cTCfvo;
    }

    public CTCfvo getCTCfvo() {
        return this.cfvo;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingThreshold
    public String getFormula() {
        if (this.cfvo.getType() == STCfvoType.FORMULA) {
            return this.cfvo.getVal();
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingThreshold
    public ConditionalFormattingThreshold.RangeType getRangeType() {
        return ConditionalFormattingThreshold.RangeType.byName(this.cfvo.getType().toString());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingThreshold
    public Double getValue() {
        if (this.cfvo.getType() == STCfvoType.FORMULA || this.cfvo.getType() == STCfvoType.MIN || this.cfvo.getType() == STCfvoType.MAX || !this.cfvo.isSetVal()) {
            return null;
        }
        return Double.valueOf(Double.parseDouble(this.cfvo.getVal()));
    }

    public boolean isGte() {
        return this.cfvo.getGte();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingThreshold
    public void setFormula(String str) {
        this.cfvo.setVal(str);
    }

    public void setGte(boolean z6) {
        this.cfvo.setGte(z6);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingThreshold
    public void setRangeType(ConditionalFormattingThreshold.RangeType rangeType) {
        this.cfvo.setType(STCfvoType.Enum.forString(rangeType.name));
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingThreshold
    public void setValue(Double d) {
        if (d == null) {
            this.cfvo.unsetVal();
        } else {
            this.cfvo.setVal(d.toString());
        }
    }
}
