package org.apache.poi.ss.formula.ptg;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.WorkbookDependentFormula;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class NameXPtg extends OperandPtg implements WorkbookDependentFormula {
    private static final int SIZE = 7;
    public static final short sid = 57;
    private final int _nameNumber;
    private final int _reserved;
    private final int _sheetRefIndex;

    private NameXPtg(int i5, int i6, int i7) {
        this._sheetRefIndex = i5;
        this._nameNumber = i6;
        this._reserved = i7;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg, org.apache.poi.ss.formula.ptg.Ptg, org.apache.poi.common.Duplicatable
    public NameXPtg copy() {
        return this;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getDefaultOperandClass() {
        return (byte) 32;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("sheetRefIndex", new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.o
            public final /* synthetic */ NameXPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int sheetRefIndex;
                switch (i5) {
                    case 0:
                        sheetRefIndex = this.b.getSheetRefIndex();
                        break;
                    default:
                        sheetRefIndex = this.b.getNameIndex();
                        break;
                }
                return Integer.valueOf(sheetRefIndex);
            }
        }, "nameIndex", new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.o
            public final /* synthetic */ NameXPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int sheetRefIndex;
                switch (i6) {
                    case 0:
                        sheetRefIndex = this.b.getSheetRefIndex();
                        break;
                    default:
                        sheetRefIndex = this.b.getNameIndex();
                        break;
                }
                return Integer.valueOf(sheetRefIndex);
            }
        });
    }

    public int getNameIndex() {
        return this._nameNumber - 1;
    }

    public int getSheetRefIndex() {
        return this._sheetRefIndex;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return (byte) 57;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 7;
    }

    @Override // org.apache.poi.ss.formula.WorkbookDependentFormula
    public String toFormulaString(FormulaRenderingWorkbook formulaRenderingWorkbook) {
        return formulaRenderingWorkbook.resolveNameXText(this);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 57);
        littleEndianOutput.writeShort(this._sheetRefIndex);
        littleEndianOutput.writeShort(this._nameNumber);
        littleEndianOutput.writeShort(this._reserved);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        throw new RuntimeException("3D references need a workbook to determine formula text");
    }

    public NameXPtg(int i5, int i6) {
        this(i5, i6 + 1, 0);
    }

    public NameXPtg(LittleEndianInput littleEndianInput) {
        this(littleEndianInput.readUShort(), littleEndianInput.readUShort(), littleEndianInput.readUShort());
    }
}
