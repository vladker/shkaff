package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.CFRule12Record;
import org.apache.poi.hssf.record.CFRuleBase;
import org.apache.poi.hssf.record.CFRuleRecord;
import org.apache.poi.hssf.record.aggregates.CFRecordsAggregate;
import org.apache.poi.hssf.record.aggregates.ConditionalFormattingTable;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.ExtendedColor;
import org.apache.poi.ss.usermodel.IconMultiStateFormatting;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFSheetConditionalFormatting implements SheetConditionalFormatting {
    private final ConditionalFormattingTable _conditionalFormattingTable;
    private final HSSFSheet _sheet;

    public HSSFSheetConditionalFormatting(HSSFSheet hSSFSheet) {
        this._sheet = hSSFSheet;
        this._conditionalFormattingTable = hSSFSheet.getSheet().getConditionalFormattingTable();
    }

    public int addConditionalFormatting(HSSFConditionalFormatting hSSFConditionalFormatting) {
        return this._conditionalFormattingTable.add(hSSFConditionalFormatting.getCFRecordsAggregate().cloneCFAggregate());
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public int getNumConditionalFormattings() {
        return this._conditionalFormattingTable.size();
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public void removeConditionalFormatting(int i5) {
        this._conditionalFormattingTable.remove(i5);
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public HSSFConditionalFormattingRule createConditionalFormattingColorScaleRule() {
        return new HSSFConditionalFormattingRule(this._sheet, CFRule12Record.createColorScale(this._sheet));
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public HSSFConditionalFormatting getConditionalFormattingAt(int i5) {
        CFRecordsAggregate cFRecordsAggregate = this._conditionalFormattingTable.get(i5);
        if (cFRecordsAggregate == null) {
            return null;
        }
        return new HSSFConditionalFormatting(this._sheet, cFRecordsAggregate);
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public int addConditionalFormatting(ConditionalFormatting conditionalFormatting) {
        return addConditionalFormatting((HSSFConditionalFormatting) conditionalFormatting);
    }

    public int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, HSSFConditionalFormattingRule[] hSSFConditionalFormattingRuleArr) {
        if (cellRangeAddressArr != null) {
            for (CellRangeAddress cellRangeAddress : cellRangeAddressArr) {
                cellRangeAddress.validate(SpreadsheetVersion.EXCEL97);
            }
            if (hSSFConditionalFormattingRuleArr != null) {
                if (hSSFConditionalFormattingRuleArr.length != 0) {
                    if (hSSFConditionalFormattingRuleArr.length <= 3) {
                        CFRuleBase[] cFRuleBaseArr = new CFRuleBase[hSSFConditionalFormattingRuleArr.length];
                        for (int i5 = 0; i5 != hSSFConditionalFormattingRuleArr.length; i5++) {
                            cFRuleBaseArr[i5] = hSSFConditionalFormattingRuleArr[i5].getCfRuleRecord();
                        }
                        return this._conditionalFormattingTable.add(new CFRecordsAggregate(cellRangeAddressArr, cFRuleBaseArr));
                    }
                    throw new IllegalArgumentException("Number of rules must not exceed 3");
                }
                throw new IllegalArgumentException("cfRules must not be empty");
            }
            throw new IllegalArgumentException("cfRules must not be null");
        }
        throw new IllegalArgumentException("regions must not be null");
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public HSSFConditionalFormattingRule createConditionalFormattingRule(byte b, String str, String str2) {
        return new HSSFConditionalFormattingRule(this._sheet, CFRuleRecord.create(this._sheet, b, str, str2));
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public HSSFConditionalFormattingRule createConditionalFormattingRule(byte b, String str) {
        return new HSSFConditionalFormattingRule(this._sheet, CFRuleRecord.create(this._sheet, b, str, null));
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public HSSFConditionalFormattingRule createConditionalFormattingRule(String str) {
        return new HSSFConditionalFormattingRule(this._sheet, CFRuleRecord.create(this._sheet, str));
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public HSSFConditionalFormattingRule createConditionalFormattingRule(IconMultiStateFormatting.IconSet iconSet) {
        return new HSSFConditionalFormattingRule(this._sheet, CFRule12Record.create(this._sheet, iconSet));
    }

    public HSSFConditionalFormattingRule createConditionalFormattingRule(HSSFExtendedColor hSSFExtendedColor) {
        return new HSSFConditionalFormattingRule(this._sheet, CFRule12Record.create(this._sheet, hSSFExtendedColor.getExtendedColor()));
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, ConditionalFormattingRule[] conditionalFormattingRuleArr) {
        HSSFConditionalFormattingRule[] hSSFConditionalFormattingRuleArr;
        if (conditionalFormattingRuleArr instanceof HSSFConditionalFormattingRule[]) {
            hSSFConditionalFormattingRuleArr = (HSSFConditionalFormattingRule[]) conditionalFormattingRuleArr;
        } else {
            int length = conditionalFormattingRuleArr.length;
            HSSFConditionalFormattingRule[] hSSFConditionalFormattingRuleArr2 = new HSSFConditionalFormattingRule[length];
            System.arraycopy(conditionalFormattingRuleArr, 0, hSSFConditionalFormattingRuleArr2, 0, length);
            hSSFConditionalFormattingRuleArr = hSSFConditionalFormattingRuleArr2;
        }
        return addConditionalFormatting(cellRangeAddressArr, hSSFConditionalFormattingRuleArr);
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public HSSFConditionalFormattingRule createConditionalFormattingRule(ExtendedColor extendedColor) {
        return createConditionalFormattingRule((HSSFExtendedColor) extendedColor);
    }

    public int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, HSSFConditionalFormattingRule hSSFConditionalFormattingRule) {
        return addConditionalFormatting(cellRangeAddressArr, hSSFConditionalFormattingRule == null ? null : new HSSFConditionalFormattingRule[]{hSSFConditionalFormattingRule});
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, ConditionalFormattingRule conditionalFormattingRule) {
        return addConditionalFormatting(cellRangeAddressArr, (HSSFConditionalFormattingRule) conditionalFormattingRule);
    }

    public int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, HSSFConditionalFormattingRule hSSFConditionalFormattingRule, HSSFConditionalFormattingRule hSSFConditionalFormattingRule2) {
        return addConditionalFormatting(cellRangeAddressArr, new HSSFConditionalFormattingRule[]{hSSFConditionalFormattingRule, hSSFConditionalFormattingRule2});
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, ConditionalFormattingRule conditionalFormattingRule, ConditionalFormattingRule conditionalFormattingRule2) {
        return addConditionalFormatting(cellRangeAddressArr, (HSSFConditionalFormattingRule) conditionalFormattingRule, (HSSFConditionalFormattingRule) conditionalFormattingRule2);
    }
}
