package org.apache.poi.hssf.record;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class MergeCellsRecord extends StandardRecord {
    public static final short sid = 229;
    private final int _numberOfRegions;
    private final CellRangeAddress[] _regions;
    private final int _startIndex;

    public MergeCellsRecord(MergeCellsRecord mergeCellsRecord) {
        super(mergeCellsRecord);
        CellRangeAddress[] cellRangeAddressArr = mergeCellsRecord._regions;
        this._regions = cellRangeAddressArr == null ? null : (CellRangeAddress[]) Stream.of((Object[]) cellRangeAddressArr).map(new G(3)).toArray(new C1434x0(3));
        this._startIndex = mergeCellsRecord._startIndex;
        this._numberOfRegions = mergeCellsRecord._numberOfRegions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        CellRangeAddress[] cellRangeAddressArr = this._regions;
        int i5 = this._startIndex;
        return (CellRangeAddress[]) Arrays.copyOfRange(cellRangeAddressArr, i5, this._numberOfRegions + i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CellRangeAddress[] lambda$new$0(int i5) {
        return new CellRangeAddress[i5];
    }

    public CellRangeAddress getAreaAt(int i5) {
        return this._regions[this._startIndex + i5];
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return CellRangeAddressList.getEncodedSize(this._numberOfRegions);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("numRegions", new Supplier(this) { // from class: org.apache.poi.hssf.record.i0
            public final /* synthetic */ MergeCellsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getNumAreas());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        }, "regions", new Supplier(this) { // from class: org.apache.poi.hssf.record.i0
            public final /* synthetic */ MergeCellsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getNumAreas());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
    }

    public short getNumAreas() {
        return (short) this._numberOfRegions;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._numberOfRegions);
        for (int i5 = 0; i5 < this._numberOfRegions; i5++) {
            this._regions[this._startIndex + i5].serialize(littleEndianOutput);
        }
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.MERGE_CELLS;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public MergeCellsRecord copy() {
        return new MergeCellsRecord(this);
    }

    public MergeCellsRecord(CellRangeAddress[] cellRangeAddressArr, int i5, int i6) {
        this._regions = cellRangeAddressArr;
        this._startIndex = i5;
        this._numberOfRegions = i6;
    }

    public MergeCellsRecord(RecordInputStream recordInputStream) {
        int uShort = recordInputStream.readUShort();
        CellRangeAddress[] cellRangeAddressArr = new CellRangeAddress[uShort];
        for (int i5 = 0; i5 < uShort; i5++) {
            cellRangeAddressArr[i5] = new CellRangeAddress(recordInputStream);
        }
        this._numberOfRegions = uShort;
        this._startIndex = 0;
        this._regions = cellRangeAddressArr;
    }
}
