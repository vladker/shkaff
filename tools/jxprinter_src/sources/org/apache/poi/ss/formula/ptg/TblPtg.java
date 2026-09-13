package org.apache.poi.ss.formula.ptg;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class TblPtg extends ControlPtg {
    private static final int SIZE = 5;
    public static final short sid = 2;
    private final int field_1_first_row;
    private final int field_2_first_col;

    public TblPtg(LittleEndianInput littleEndianInput) {
        this.field_1_first_row = littleEndianInput.readUShort();
        this.field_2_first_col = littleEndianInput.readUShort();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg, org.apache.poi.common.Duplicatable
    public TblPtg copy() {
        return this;
    }

    public int getColumn() {
        return this.field_2_first_col;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("row", new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.t
            public final /* synthetic */ TblPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int row;
                switch (i5) {
                    case 0:
                        row = this.b.getRow();
                        break;
                    default:
                        row = this.b.getColumn();
                        break;
                }
                return Integer.valueOf(row);
            }
        }, "column", new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.t
            public final /* synthetic */ TblPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int row;
                switch (i6) {
                    case 0:
                        row = this.b.getRow();
                        break;
                    default:
                        row = this.b.getColumn();
                        break;
                }
                return Integer.valueOf(row);
            }
        });
    }

    public int getRow() {
        return this.field_1_first_row;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return (byte) 2;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 5;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        throw new RuntimeException("Table and Arrays are not yet supported");
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 2);
        littleEndianOutput.writeShort(this.field_1_first_row);
        littleEndianOutput.writeShort(this.field_2_first_col);
    }
}
