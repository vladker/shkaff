package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class MulBlankRecord extends StandardRecord {
    public static final short sid = 190;
    private final int _firstCol;
    private final int _lastCol;
    private final int _row;
    private final short[] _xfs;

    public MulBlankRecord(int i5, int i6, short[] sArr) {
        this._row = i5;
        this._firstCol = i6;
        this._xfs = sArr;
        this._lastCol = (i6 + sArr.length) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return this._xfs;
    }

    private static short[] parseXFs(RecordInputStream recordInputStream) {
        int iRemaining = (recordInputStream.remaining() - 2) / 2;
        short[] sArr = new short[iRemaining];
        for (int i5 = 0; i5 < iRemaining; i5++) {
            sArr[i5] = recordInputStream.readShort();
        }
        return sArr;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public MulBlankRecord copy() {
        return this;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this._xfs.length * 2) + 6;
    }

    public int getFirstColumn() {
        return this._firstCol;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.j0
            public final /* synthetic */ MulBlankRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 2:
                        return Integer.valueOf(this.b.getLastColumn());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.j0
            public final /* synthetic */ MulBlankRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 2:
                        return Integer.valueOf(this.b.getLastColumn());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.j0
            public final /* synthetic */ MulBlankRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 2:
                        return Integer.valueOf(this.b.getLastColumn());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        };
        final int i8 = 3;
        return GenericRecordUtil.getGenericProperties("row", supplier, "firstColumn", supplier2, "lastColumn", supplier3, "xf", new Supplier(this) { // from class: org.apache.poi.hssf.record.j0
            public final /* synthetic */ MulBlankRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 2:
                        return Integer.valueOf(this.b.getLastColumn());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        });
    }

    public int getLastColumn() {
        return this._lastCol;
    }

    public int getNumColumns() {
        return (this._lastCol - this._firstCol) + 1;
    }

    public int getRow() {
        return this._row;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 190;
    }

    public short getXFAt(int i5) {
        return this._xfs[i5];
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._row);
        littleEndianOutput.writeShort(this._firstCol);
        for (short s6 : this._xfs) {
            littleEndianOutput.writeShort(s6);
        }
        littleEndianOutput.writeShort(this._lastCol);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.MUL_BLANK;
    }

    public MulBlankRecord(RecordInputStream recordInputStream) {
        this._row = recordInputStream.readUShort();
        this._firstCol = recordInputStream.readShort();
        this._xfs = parseXFs(recordInputStream);
        this._lastCol = recordInputStream.readShort();
    }
}
