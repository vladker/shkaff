package org.apache.poi.hssf.record.aggregates;

import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class RecordAggregate extends RecordBase {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class PositionTrackingVisitor implements RecordVisitor {
        private int _position;
        private final RecordVisitor _rv;

        public PositionTrackingVisitor(RecordVisitor recordVisitor, int i5) {
            this._rv = recordVisitor;
            this._position = i5;
        }

        public int getPosition() {
            return this._position;
        }

        public void setPosition(int i5) {
            this._position = i5;
        }

        @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate.RecordVisitor
        public void visitRecord(Record record) {
            this._position = record.getRecordSize() + this._position;
            this._rv.visitRecord(record);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class RecordSizingVisitor implements RecordVisitor {
        private int _totalSize = 0;

        public int getTotalSize() {
            return this._totalSize;
        }

        @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate.RecordVisitor
        public void visitRecord(Record record) {
            this._totalSize = record.getRecordSize() + this._totalSize;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface RecordVisitor {
        void visitRecord(Record record);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SerializingRecordVisitor implements RecordVisitor {
        private int _countBytesWritten = 0;
        private final byte[] _data;
        private final int _startOffset;

        public SerializingRecordVisitor(byte[] bArr, int i5) {
            this._data = bArr;
            this._startOffset = i5;
        }

        public int countBytesWritten() {
            return this._countBytesWritten;
        }

        @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate.RecordVisitor
        public void visitRecord(Record record) {
            int i5 = this._startOffset;
            int i6 = this._countBytesWritten;
            this._countBytesWritten = record.serialize(i5 + i6, this._data) + i6;
        }
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        RecordSizingVisitor recordSizingVisitor = new RecordSizingVisitor();
        visitContainedRecords(recordSizingVisitor);
        return recordSizingVisitor.getTotalSize();
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public final int serialize(int i5, byte[] bArr) {
        SerializingRecordVisitor serializingRecordVisitor = new SerializingRecordVisitor(bArr, i5);
        visitContainedRecords(serializingRecordVisitor);
        return serializingRecordVisitor.countBytesWritten();
    }

    public abstract void visitContainedRecords(RecordVisitor recordVisitor);
}
