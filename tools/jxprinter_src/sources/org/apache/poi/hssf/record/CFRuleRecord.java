package org.apache.poi.hssf.record;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class CFRuleRecord extends CFRuleBase {
    public static final short sid = 433;

    public CFRuleRecord(CFRuleRecord cFRuleRecord) {
        super(cFRuleRecord);
    }

    public static CFRuleRecord create(HSSFSheet hSSFSheet, String str) {
        return new CFRuleRecord((byte) 2, (byte) 0, CFRuleBase.parseFormula(str, hSSFSheet), null);
    }

    private void setDefaults() {
        int value = CFRuleBase.modificationBits.setValue(this.formatting_options, -1);
        this.formatting_options = value;
        int value2 = CFRuleBase.fmtBlockBits.setValue(value, 0);
        this.formatting_options = value2;
        this.formatting_options = CFRuleBase.undocumented.clear(value2);
        this.formatting_not_used = (short) -32766;
        this._fontFormatting = null;
        this._borderFormatting = null;
        this._patternFormatting = null;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return CFRuleBase.getFormulaSize(getFormula2()) + CFRuleBase.getFormulaSize(getFormula1()) + getFormattingBlockSize() + 6;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        int formulaSize = CFRuleBase.getFormulaSize(getFormula1());
        int formulaSize2 = CFRuleBase.getFormulaSize(getFormula2());
        littleEndianOutput.writeByte(getConditionType());
        littleEndianOutput.writeByte(getComparisonOperation());
        littleEndianOutput.writeShort(formulaSize);
        littleEndianOutput.writeShort(formulaSize2);
        serializeFormattingBlock(littleEndianOutput);
        getFormula1().serializeTokens(littleEndianOutput);
        getFormula2().serializeTokens(littleEndianOutput);
    }

    private CFRuleRecord(byte b, byte b6, Ptg[] ptgArr, Ptg[] ptgArr2) {
        super(b, b6, ptgArr, ptgArr2);
        setDefaults();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CF_RULE;
    }

    public static CFRuleRecord create(HSSFSheet hSSFSheet, byte b, String str, String str2) {
        return new CFRuleRecord((byte) 1, b, CFRuleBase.parseFormula(str, hSSFSheet), CFRuleBase.parseFormula(str2, hSSFSheet));
    }

    public CFRuleRecord(RecordInputStream recordInputStream) {
        setConditionType(recordInputStream.readByte());
        setComparisonOperation(recordInputStream.readByte());
        int uShort = recordInputStream.readUShort();
        int uShort2 = recordInputStream.readUShort();
        readFormatOptions(recordInputStream);
        setFormula1(Formula.read(uShort, recordInputStream));
        setFormula2(Formula.read(uShort2, recordInputStream));
    }

    @Override // org.apache.poi.hssf.record.CFRuleBase, org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public CFRuleRecord copy() {
        return new CFRuleRecord(this);
    }
}
