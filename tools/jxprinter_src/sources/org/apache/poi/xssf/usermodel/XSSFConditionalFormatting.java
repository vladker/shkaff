package org.apache.poi.xssf.usermodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.util.CellRangeAddress;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFConditionalFormatting implements ConditionalFormatting {
    private final CTConditionalFormatting _cf;
    private final XSSFSheet _sh;

    public XSSFConditionalFormatting(XSSFSheet xSSFSheet) {
        this._cf = CTConditionalFormatting.Factory.newInstance();
        this._sh = xSSFSheet;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public void addRule(ConditionalFormattingRule conditionalFormattingRule) {
        this._cf.addNewCfRule().set(((XSSFConditionalFormattingRule) conditionalFormattingRule).getCTCfRule());
    }

    public CTConditionalFormatting getCTConditionalFormatting() {
        return this._cf;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public CellRangeAddress[] getFormattingRanges() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this._cf.getSqref().iterator();
        while (true) {
            if (!it.hasNext()) {
                return (CellRangeAddress[]) arrayList.toArray(new CellRangeAddress[0]);
            }
            for (String str : it.next().toString().split(" ")) {
                arrayList.add(CellRangeAddress.valueOf(str));
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public int getNumberOfRules() {
        return this._cf.sizeOfCfRuleArray();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public void setFormattingRanges(CellRangeAddress[] cellRangeAddressArr) {
        if (cellRangeAddressArr == null) {
            throw new IllegalArgumentException("cellRanges must not be null");
        }
        StringBuilder sb = new StringBuilder();
        boolean z6 = true;
        for (CellRangeAddress cellRangeAddress : cellRangeAddressArr) {
            if (z6) {
                z6 = false;
            } else {
                sb.append(Chars.SPACE);
            }
            sb.append(cellRangeAddress.formatAsString());
        }
        this._cf.setSqref(Collections.singletonList(sb.toString()));
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public void setRule(int i5, ConditionalFormattingRule conditionalFormattingRule) {
        this._cf.getCfRuleArray(i5).set(((XSSFConditionalFormattingRule) conditionalFormattingRule).getCTCfRule());
    }

    public String toString() {
        return this._cf.toString();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public XSSFConditionalFormattingRule getRule(int i5) {
        return new XSSFConditionalFormattingRule(this._sh, this._cf.getCfRuleArray(i5));
    }

    public XSSFConditionalFormatting(XSSFSheet xSSFSheet, CTConditionalFormatting cTConditionalFormatting) {
        this._cf = cTConditionalFormatting;
        this._sh = xSSFSheet;
    }
}
