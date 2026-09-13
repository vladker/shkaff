package org.apache.poi.ss.formula.ptg;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AreaPtgBase extends OperandPtg implements AreaI {
    private int field_1_first_row;
    private int field_2_last_row;
    private int field_3_first_column;
    private int field_4_last_column;
    private static final BitField rowRelative = BitFieldFactory.getInstance(32768);
    private static final BitField colRelative = BitFieldFactory.getInstance(16384);
    private static final BitField columnMask = BitFieldFactory.getInstance(16383);

    public AreaPtgBase() {
    }

    public final String formatReferenceAsString() {
        CellReference cellReference = new CellReference(getFirstRow(), getFirstColumn(), !isFirstRowRelative(), !isFirstColRelative());
        CellReference cellReference2 = new CellReference(getLastRow(), getLastColumn(), !isLastRowRelative(), !isLastColRelative());
        SpreadsheetVersion spreadsheetVersion = SpreadsheetVersion.EXCEL97;
        if (AreaReference.isWholeColumnReference(spreadsheetVersion, cellReference, cellReference2)) {
            return new AreaReference(cellReference, cellReference2, spreadsheetVersion).formatAsString();
        }
        SpreadsheetVersion spreadsheetVersion2 = SpreadsheetVersion.EXCEL2007;
        if (AreaReference.isWholeColumnReference(spreadsheetVersion2, cellReference, cellReference2)) {
            return new AreaReference(cellReference, cellReference2, spreadsheetVersion2).formatAsString();
        }
        return cellReference.formatAsString() + ParameterizedMessage.ERROR_MSG_SEPARATOR + cellReference2.formatAsString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getDefaultOperandClass() {
        return (byte) 0;
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaI
    public final int getFirstColumn() {
        return columnMask.getValue(this.field_3_first_column);
    }

    public final short getFirstColumnRaw() {
        return (short) this.field_3_first_column;
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaI
    public final int getFirstRow() {
        return this.field_1_first_row;
    }

    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.e
            public final /* synthetic */ AreaPtgBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Boolean.valueOf(this.b.isFirstRowRelative());
                    case 2:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 3:
                        return Boolean.valueOf(this.b.isFirstColRelative());
                    case 4:
                        return Integer.valueOf(this.b.getLastRow());
                    case 5:
                        return Boolean.valueOf(this.b.isLastRowRelative());
                    case 6:
                        return Integer.valueOf(this.b.getLastColumn());
                    case 7:
                        return Boolean.valueOf(this.b.isLastColRelative());
                    default:
                        return this.b.formatReferenceAsString();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.e
            public final /* synthetic */ AreaPtgBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Boolean.valueOf(this.b.isFirstRowRelative());
                    case 2:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 3:
                        return Boolean.valueOf(this.b.isFirstColRelative());
                    case 4:
                        return Integer.valueOf(this.b.getLastRow());
                    case 5:
                        return Boolean.valueOf(this.b.isLastRowRelative());
                    case 6:
                        return Integer.valueOf(this.b.getLastColumn());
                    case 7:
                        return Boolean.valueOf(this.b.isLastColRelative());
                    default:
                        return this.b.formatReferenceAsString();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.e
            public final /* synthetic */ AreaPtgBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Boolean.valueOf(this.b.isFirstRowRelative());
                    case 2:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 3:
                        return Boolean.valueOf(this.b.isFirstColRelative());
                    case 4:
                        return Integer.valueOf(this.b.getLastRow());
                    case 5:
                        return Boolean.valueOf(this.b.isLastRowRelative());
                    case 6:
                        return Integer.valueOf(this.b.getLastColumn());
                    case 7:
                        return Boolean.valueOf(this.b.isLastColRelative());
                    default:
                        return this.b.formatReferenceAsString();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.e
            public final /* synthetic */ AreaPtgBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Boolean.valueOf(this.b.isFirstRowRelative());
                    case 2:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 3:
                        return Boolean.valueOf(this.b.isFirstColRelative());
                    case 4:
                        return Integer.valueOf(this.b.getLastRow());
                    case 5:
                        return Boolean.valueOf(this.b.isLastRowRelative());
                    case 6:
                        return Integer.valueOf(this.b.getLastColumn());
                    case 7:
                        return Boolean.valueOf(this.b.isLastColRelative());
                    default:
                        return this.b.formatReferenceAsString();
                }
            }
        };
        final int i9 = 4;
        Supplier supplier5 = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.e
            public final /* synthetic */ AreaPtgBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Boolean.valueOf(this.b.isFirstRowRelative());
                    case 2:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 3:
                        return Boolean.valueOf(this.b.isFirstColRelative());
                    case 4:
                        return Integer.valueOf(this.b.getLastRow());
                    case 5:
                        return Boolean.valueOf(this.b.isLastRowRelative());
                    case 6:
                        return Integer.valueOf(this.b.getLastColumn());
                    case 7:
                        return Boolean.valueOf(this.b.isLastColRelative());
                    default:
                        return this.b.formatReferenceAsString();
                }
            }
        };
        final int i10 = 5;
        Supplier supplier6 = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.e
            public final /* synthetic */ AreaPtgBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Boolean.valueOf(this.b.isFirstRowRelative());
                    case 2:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 3:
                        return Boolean.valueOf(this.b.isFirstColRelative());
                    case 4:
                        return Integer.valueOf(this.b.getLastRow());
                    case 5:
                        return Boolean.valueOf(this.b.isLastRowRelative());
                    case 6:
                        return Integer.valueOf(this.b.getLastColumn());
                    case 7:
                        return Boolean.valueOf(this.b.isLastColRelative());
                    default:
                        return this.b.formatReferenceAsString();
                }
            }
        };
        final int i11 = 6;
        final int i12 = 7;
        final int i13 = 8;
        return GenericRecordUtil.getGenericProperties("firstRow", supplier, "firstRowRelative", supplier2, "firstColumn", supplier3, "firstColRelative", supplier4, "lastRow", supplier5, "lastRowRelative", supplier6, "lastColumn", new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.e
            public final /* synthetic */ AreaPtgBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Boolean.valueOf(this.b.isFirstRowRelative());
                    case 2:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 3:
                        return Boolean.valueOf(this.b.isFirstColRelative());
                    case 4:
                        return Integer.valueOf(this.b.getLastRow());
                    case 5:
                        return Boolean.valueOf(this.b.isLastRowRelative());
                    case 6:
                        return Integer.valueOf(this.b.getLastColumn());
                    case 7:
                        return Boolean.valueOf(this.b.isLastColRelative());
                    default:
                        return this.b.formatReferenceAsString();
                }
            }
        }, "lastColRelative", new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.e
            public final /* synthetic */ AreaPtgBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Boolean.valueOf(this.b.isFirstRowRelative());
                    case 2:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 3:
                        return Boolean.valueOf(this.b.isFirstColRelative());
                    case 4:
                        return Integer.valueOf(this.b.getLastRow());
                    case 5:
                        return Boolean.valueOf(this.b.isLastRowRelative());
                    case 6:
                        return Integer.valueOf(this.b.getLastColumn());
                    case 7:
                        return Boolean.valueOf(this.b.isLastColRelative());
                    default:
                        return this.b.formatReferenceAsString();
                }
            }
        }, "formatReference", new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.e
            public final /* synthetic */ AreaPtgBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i13) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Boolean.valueOf(this.b.isFirstRowRelative());
                    case 2:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 3:
                        return Boolean.valueOf(this.b.isFirstColRelative());
                    case 4:
                        return Integer.valueOf(this.b.getLastRow());
                    case 5:
                        return Boolean.valueOf(this.b.isLastRowRelative());
                    case 6:
                        return Integer.valueOf(this.b.getLastColumn());
                    case 7:
                        return Boolean.valueOf(this.b.isLastColRelative());
                    default:
                        return this.b.formatReferenceAsString();
                }
            }
        });
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaI
    public final int getLastColumn() {
        return columnMask.getValue(this.field_4_last_column);
    }

    public final short getLastColumnRaw() {
        return (short) this.field_4_last_column;
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaI
    public final int getLastRow() {
        return this.field_2_last_row;
    }

    public final boolean isFirstColRelative() {
        return colRelative.isSet(this.field_3_first_column);
    }

    public final boolean isFirstRowRelative() {
        return rowRelative.isSet(this.field_3_first_column);
    }

    public final boolean isLastColRelative() {
        return colRelative.isSet(this.field_4_last_column);
    }

    public final boolean isLastRowRelative() {
        return rowRelative.isSet(this.field_4_last_column);
    }

    public final void readCoordinates(LittleEndianInput littleEndianInput) {
        this.field_1_first_row = littleEndianInput.readUShort();
        this.field_2_last_row = littleEndianInput.readUShort();
        this.field_3_first_column = littleEndianInput.readUShort();
        this.field_4_last_column = littleEndianInput.readUShort();
    }

    public final void setFirstColRelative(boolean z6) {
        this.field_3_first_column = colRelative.setBoolean(this.field_3_first_column, z6);
    }

    public final void setFirstColumn(int i5) {
        this.field_3_first_column = columnMask.setValue(this.field_3_first_column, i5);
    }

    public final void setFirstColumnRaw(int i5) {
        this.field_3_first_column = i5;
    }

    public final void setFirstRow(int i5) {
        this.field_1_first_row = i5;
    }

    public final void setFirstRowRelative(boolean z6) {
        this.field_3_first_column = rowRelative.setBoolean(this.field_3_first_column, z6);
    }

    public final void setLastColRelative(boolean z6) {
        this.field_4_last_column = colRelative.setBoolean(this.field_4_last_column, z6);
    }

    public final void setLastColumn(int i5) {
        this.field_4_last_column = columnMask.setValue(this.field_4_last_column, i5);
    }

    public final void setLastColumnRaw(short s6) {
        this.field_4_last_column = s6;
    }

    public final void setLastRow(int i5) {
        this.field_2_last_row = i5;
    }

    public final void setLastRowRelative(boolean z6) {
        this.field_4_last_column = rowRelative.setBoolean(this.field_4_last_column, z6);
    }

    public void sortTopLeftToBottomRight() {
        if (getFirstRow() > getLastRow()) {
            int firstRow = getFirstRow();
            boolean zIsFirstRowRelative = isFirstRowRelative();
            setFirstRow(getLastRow());
            setFirstRowRelative(isLastRowRelative());
            setLastRow(firstRow);
            setLastRowRelative(zIsFirstRowRelative);
        }
        if (getFirstColumn() > getLastColumn()) {
            int firstColumn = getFirstColumn();
            boolean zIsFirstColRelative = isFirstColRelative();
            setFirstColumn(getLastColumn());
            setFirstColRelative(isLastColRelative());
            setLastColumn(firstColumn);
            setLastColRelative(zIsFirstColRelative);
        }
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        return formatReferenceAsString();
    }

    public final void writeCoordinates(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_first_row);
        littleEndianOutput.writeShort(this.field_2_last_row);
        littleEndianOutput.writeShort(this.field_3_first_column);
        littleEndianOutput.writeShort(this.field_4_last_column);
    }

    public AreaPtgBase(AreaPtgBase areaPtgBase) {
        super(areaPtgBase);
        this.field_1_first_row = areaPtgBase.field_1_first_row;
        this.field_2_last_row = areaPtgBase.field_2_last_row;
        this.field_3_first_column = areaPtgBase.field_3_first_column;
        this.field_4_last_column = areaPtgBase.field_4_last_column;
    }

    public AreaPtgBase(AreaReference areaReference) {
        CellReference firstCell = areaReference.getFirstCell();
        CellReference lastCell = areaReference.getLastCell();
        setFirstRow(firstCell.getRow());
        setFirstColumn(firstCell.getCol() == -1 ? (short) 0 : firstCell.getCol());
        setLastRow(lastCell.getRow());
        setLastColumn(lastCell.getCol() == -1 ? (short) 255 : lastCell.getCol());
        setFirstColRelative(!firstCell.isColAbsolute());
        setLastColRelative(!lastCell.isColAbsolute());
        setFirstRowRelative(!firstCell.isRowAbsolute());
        setLastRowRelative(!lastCell.isRowAbsolute());
    }

    public AreaPtgBase(int i5, int i6, int i7, int i8, boolean z6, boolean z7, boolean z8, boolean z9) {
        if (i6 >= i5) {
            setFirstRow(i5);
            setLastRow(i6);
            setFirstRowRelative(z6);
            setLastRowRelative(z7);
        } else {
            setFirstRow(i6);
            setLastRow(i5);
            setFirstRowRelative(z7);
            setLastRowRelative(z6);
        }
        if (i8 >= i7) {
            setFirstColumn(i7);
            setLastColumn(i8);
            setFirstColRelative(z8);
            setLastColRelative(z9);
            return;
        }
        setFirstColumn(i8);
        setLastColumn(i7);
        setFirstColRelative(z9);
        setLastColRelative(z8);
    }
}
