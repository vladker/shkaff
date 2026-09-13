package org.apache.poi.ss.formula.ptg;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class RefPtgBase extends OperandPtg {
    private int field_1_row;
    private int field_2_col;
    private static final BitField column = BitFieldFactory.getInstance(16383);
    private static final BitField rowRelative = BitFieldFactory.getInstance(32768);
    private static final BitField colRelative = BitFieldFactory.getInstance(16384);

    public RefPtgBase() {
    }

    public String formatReferenceAsString() {
        return new CellReference(getRow(), getColumn(), !isRowRelative(), !isColRelative()).formatAsString();
    }

    public final int getColumn() {
        return column.getValue(this.field_2_col);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final byte getDefaultOperandClass() {
        return (byte) 0;
    }

    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.s
            public final /* synthetic */ RefPtgBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Boolean.valueOf(this.b.isRowRelative());
                    case 2:
                        return Integer.valueOf(this.b.getColumn());
                    case 3:
                        return Boolean.valueOf(this.b.isColRelative());
                    default:
                        return this.b.formatReferenceAsString();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.s
            public final /* synthetic */ RefPtgBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Boolean.valueOf(this.b.isRowRelative());
                    case 2:
                        return Integer.valueOf(this.b.getColumn());
                    case 3:
                        return Boolean.valueOf(this.b.isColRelative());
                    default:
                        return this.b.formatReferenceAsString();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.s
            public final /* synthetic */ RefPtgBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Boolean.valueOf(this.b.isRowRelative());
                    case 2:
                        return Integer.valueOf(this.b.getColumn());
                    case 3:
                        return Boolean.valueOf(this.b.isColRelative());
                    default:
                        return this.b.formatReferenceAsString();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.s
            public final /* synthetic */ RefPtgBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Boolean.valueOf(this.b.isRowRelative());
                    case 2:
                        return Integer.valueOf(this.b.getColumn());
                    case 3:
                        return Boolean.valueOf(this.b.isColRelative());
                    default:
                        return this.b.formatReferenceAsString();
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("row", supplier, "rowRelative", supplier2, "column", supplier3, "colRelative", supplier4, "formatReference", new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.s
            public final /* synthetic */ RefPtgBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Boolean.valueOf(this.b.isRowRelative());
                    case 2:
                        return Integer.valueOf(this.b.getColumn());
                    case 3:
                        return Boolean.valueOf(this.b.isColRelative());
                    default:
                        return this.b.formatReferenceAsString();
                }
            }
        });
    }

    public final int getRow() {
        return this.field_1_row;
    }

    public final boolean isColRelative() {
        return colRelative.isSet(this.field_2_col);
    }

    public final boolean isRowRelative() {
        return rowRelative.isSet(this.field_2_col);
    }

    public final void readCoordinates(LittleEndianInput littleEndianInput) {
        this.field_1_row = littleEndianInput.readUShort();
        this.field_2_col = littleEndianInput.readUShort();
    }

    public final void setColRelative(boolean z6) {
        this.field_2_col = colRelative.setBoolean(this.field_2_col, z6);
    }

    public final void setColumn(int i5) {
        this.field_2_col = column.setValue(this.field_2_col, i5);
    }

    public final void setRow(int i5) {
        this.field_1_row = i5;
    }

    public final void setRowRelative(boolean z6) {
        this.field_2_col = rowRelative.setBoolean(this.field_2_col, z6);
    }

    public final void writeCoordinates(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_row);
        littleEndianOutput.writeShort(this.field_2_col);
    }

    public RefPtgBase(RefPtgBase refPtgBase) {
        super(refPtgBase);
        this.field_1_row = refPtgBase.field_1_row;
        this.field_2_col = refPtgBase.field_2_col;
    }

    public RefPtgBase(CellReference cellReference) {
        setRow(cellReference.getRow());
        setColumn(cellReference.getCol());
        setColRelative(!cellReference.isColAbsolute());
        setRowRelative(!cellReference.isRowAbsolute());
    }
}
