package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ColumnInfoRecord extends StandardRecord {
    public static final short sid = 125;
    private int _colWidth;
    private int _firstCol;
    private int _lastCol;
    private int _options;
    private int _xfIndex;
    private int field_6_reserved;
    private static final BitField hidden = BitFieldFactory.getInstance(1);
    private static final BitField outlevel = BitFieldFactory.getInstance(1792);
    private static final BitField collapsed = BitFieldFactory.getInstance(4096);

    public ColumnInfoRecord() {
        setColumnWidth(2275);
        this._options = 2;
        this._xfIndex = 15;
        this.field_6_reserved = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Integer.valueOf(this._options);
    }

    public boolean containsColumn(int i5) {
        return this._firstCol <= i5 && i5 <= this._lastCol;
    }

    public boolean formatMatches(ColumnInfoRecord columnInfoRecord) {
        return this._xfIndex == columnInfoRecord._xfIndex && this._options == columnInfoRecord._options && this._colWidth == columnInfoRecord._colWidth;
    }

    public boolean getCollapsed() {
        return collapsed.isSet(this._options);
    }

    public int getColumnWidth() {
        return this._colWidth;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 12;
    }

    public int getFirstColumn() {
        return this._firstCol;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier() { // from class: org.apache.poi.hssf.record.o
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.getFirstColumn());
                    case 1:
                        return Integer.valueOf(this.getLastColumn());
                    case 2:
                        return Integer.valueOf(this.getColumnWidth());
                    case 3:
                        return Integer.valueOf(this.getXFIndex());
                    case 4:
                        return this.lambda$getGenericProperties$0();
                    case 5:
                        return Boolean.valueOf(this.getHidden());
                    case 6:
                        return Integer.valueOf(this.getOutlineLevel());
                    default:
                        return Boolean.valueOf(this.getCollapsed());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier() { // from class: org.apache.poi.hssf.record.o
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.getFirstColumn());
                    case 1:
                        return Integer.valueOf(this.getLastColumn());
                    case 2:
                        return Integer.valueOf(this.getColumnWidth());
                    case 3:
                        return Integer.valueOf(this.getXFIndex());
                    case 4:
                        return this.lambda$getGenericProperties$0();
                    case 5:
                        return Boolean.valueOf(this.getHidden());
                    case 6:
                        return Integer.valueOf(this.getOutlineLevel());
                    default:
                        return Boolean.valueOf(this.getCollapsed());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier() { // from class: org.apache.poi.hssf.record.o
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.getFirstColumn());
                    case 1:
                        return Integer.valueOf(this.getLastColumn());
                    case 2:
                        return Integer.valueOf(this.getColumnWidth());
                    case 3:
                        return Integer.valueOf(this.getXFIndex());
                    case 4:
                        return this.lambda$getGenericProperties$0();
                    case 5:
                        return Boolean.valueOf(this.getHidden());
                    case 6:
                        return Integer.valueOf(this.getOutlineLevel());
                    default:
                        return Boolean.valueOf(this.getCollapsed());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier() { // from class: org.apache.poi.hssf.record.o
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.getFirstColumn());
                    case 1:
                        return Integer.valueOf(this.getLastColumn());
                    case 2:
                        return Integer.valueOf(this.getColumnWidth());
                    case 3:
                        return Integer.valueOf(this.getXFIndex());
                    case 4:
                        return this.lambda$getGenericProperties$0();
                    case 5:
                        return Boolean.valueOf(this.getHidden());
                    case 6:
                        return Integer.valueOf(this.getOutlineLevel());
                    default:
                        return Boolean.valueOf(this.getCollapsed());
                }
            }
        };
        final int i9 = 4;
        Supplier supplier5 = new Supplier() { // from class: org.apache.poi.hssf.record.o
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.getFirstColumn());
                    case 1:
                        return Integer.valueOf(this.getLastColumn());
                    case 2:
                        return Integer.valueOf(this.getColumnWidth());
                    case 3:
                        return Integer.valueOf(this.getXFIndex());
                    case 4:
                        return this.lambda$getGenericProperties$0();
                    case 5:
                        return Boolean.valueOf(this.getHidden());
                    case 6:
                        return Integer.valueOf(this.getOutlineLevel());
                    default:
                        return Boolean.valueOf(this.getCollapsed());
                }
            }
        };
        final int i10 = 5;
        Supplier supplier6 = new Supplier() { // from class: org.apache.poi.hssf.record.o
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Integer.valueOf(this.getFirstColumn());
                    case 1:
                        return Integer.valueOf(this.getLastColumn());
                    case 2:
                        return Integer.valueOf(this.getColumnWidth());
                    case 3:
                        return Integer.valueOf(this.getXFIndex());
                    case 4:
                        return this.lambda$getGenericProperties$0();
                    case 5:
                        return Boolean.valueOf(this.getHidden());
                    case 6:
                        return Integer.valueOf(this.getOutlineLevel());
                    default:
                        return Boolean.valueOf(this.getCollapsed());
                }
            }
        };
        final int i11 = 6;
        final int i12 = 7;
        return GenericRecordUtil.getGenericProperties("firstColumn", supplier, "lastColumn", supplier2, "columnWidth", supplier3, "xfIndex", supplier4, "options", supplier5, CellUtil.HIDDEN, supplier6, "outlineLevel", new Supplier() { // from class: org.apache.poi.hssf.record.o
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Integer.valueOf(this.getFirstColumn());
                    case 1:
                        return Integer.valueOf(this.getLastColumn());
                    case 2:
                        return Integer.valueOf(this.getColumnWidth());
                    case 3:
                        return Integer.valueOf(this.getXFIndex());
                    case 4:
                        return this.lambda$getGenericProperties$0();
                    case 5:
                        return Boolean.valueOf(this.getHidden());
                    case 6:
                        return Integer.valueOf(this.getOutlineLevel());
                    default:
                        return Boolean.valueOf(this.getCollapsed());
                }
            }
        }, "collapsed", new Supplier() { // from class: org.apache.poi.hssf.record.o
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return Integer.valueOf(this.getFirstColumn());
                    case 1:
                        return Integer.valueOf(this.getLastColumn());
                    case 2:
                        return Integer.valueOf(this.getColumnWidth());
                    case 3:
                        return Integer.valueOf(this.getXFIndex());
                    case 4:
                        return this.lambda$getGenericProperties$0();
                    case 5:
                        return Boolean.valueOf(this.getHidden());
                    case 6:
                        return Integer.valueOf(this.getOutlineLevel());
                    default:
                        return Boolean.valueOf(this.getCollapsed());
                }
            }
        });
    }

    public boolean getHidden() {
        return hidden.isSet(this._options);
    }

    public int getLastColumn() {
        return this._lastCol;
    }

    public int getOutlineLevel() {
        return outlevel.getValue(this._options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 125;
    }

    public int getXFIndex() {
        return this._xfIndex;
    }

    public boolean isAdjacentBefore(ColumnInfoRecord columnInfoRecord) {
        return this._lastCol == columnInfoRecord._firstCol - 1;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getFirstColumn());
        littleEndianOutput.writeShort(getLastColumn());
        littleEndianOutput.writeShort(getColumnWidth());
        littleEndianOutput.writeShort(getXFIndex());
        littleEndianOutput.writeShort(this._options);
        littleEndianOutput.writeShort(this.field_6_reserved);
    }

    public void setCollapsed(boolean z6) {
        this._options = collapsed.setBoolean(this._options, z6);
    }

    public void setColumnWidth(int i5) {
        this._colWidth = i5;
    }

    public void setFirstColumn(int i5) {
        this._firstCol = i5;
    }

    public void setHidden(boolean z6) {
        this._options = hidden.setBoolean(this._options, z6);
    }

    public void setLastColumn(int i5) {
        this._lastCol = i5;
    }

    public void setOutlineLevel(int i5) {
        this._options = outlevel.setValue(this._options, i5);
    }

    public void setXFIndex(int i5) {
        this._xfIndex = i5;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.COLUMN_INFO;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public ColumnInfoRecord copy() {
        return new ColumnInfoRecord(this);
    }

    public ColumnInfoRecord(ColumnInfoRecord columnInfoRecord) {
        super(columnInfoRecord);
        this._firstCol = columnInfoRecord._firstCol;
        this._lastCol = columnInfoRecord._lastCol;
        this._colWidth = columnInfoRecord._colWidth;
        this._xfIndex = columnInfoRecord._xfIndex;
        this._options = columnInfoRecord._options;
        this.field_6_reserved = columnInfoRecord.field_6_reserved;
    }

    public ColumnInfoRecord(RecordInputStream recordInputStream) {
        this._firstCol = recordInputStream.readUShort();
        this._lastCol = recordInputStream.readUShort();
        this._colWidth = recordInputStream.readUShort();
        this._xfIndex = recordInputStream.readUShort();
        this._options = recordInputStream.readUShort();
        int iRemaining = recordInputStream.remaining();
        if (iRemaining == 0) {
            this.field_6_reserved = 0;
            return;
        }
        if (iRemaining == 1) {
            this.field_6_reserved = recordInputStream.readByte();
        } else {
            if (iRemaining == 2) {
                this.field_6_reserved = recordInputStream.readUShort();
                return;
            }
            throw new IllegalArgumentException("Unusual record size remaining=(" + recordInputStream.remaining() + ")");
        }
    }
}
