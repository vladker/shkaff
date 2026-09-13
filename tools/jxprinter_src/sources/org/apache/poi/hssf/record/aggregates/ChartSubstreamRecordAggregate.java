package org.apache.poi.hssf.record.aggregates;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.EOFRecord;
import org.apache.poi.hssf.record.HeaderFooterRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ChartSubstreamRecordAggregate extends RecordAggregate {
    private final BOFRecord _bofRec;
    private PageSettingsBlock _psBlock;
    private final List<RecordBase> _recs;

    public ChartSubstreamRecordAggregate(RecordStream recordStream) {
        this._bofRec = (BOFRecord) recordStream.getNext();
        ArrayList arrayList = new ArrayList();
        while (recordStream.peekNextClass() != EOFRecord.class) {
            if (!PageSettingsBlock.isComponentRecord(recordStream.peekNextSid())) {
                arrayList.add(recordStream.getNext());
            } else if (this._psBlock == null) {
                PageSettingsBlock pageSettingsBlock = new PageSettingsBlock(recordStream);
                this._psBlock = pageSettingsBlock;
                arrayList.add(pageSettingsBlock);
            } else {
                if (recordStream.peekNextSid() != 2204) {
                    throw new IllegalStateException("Found more than one PageSettingsBlock in chart sub-stream, had sid: " + recordStream.peekNextSid());
                }
                this._psBlock.addLateHeaderFooter((HeaderFooterRecord) recordStream.getNext());
            }
        }
        this._recs = arrayList;
        if (!(recordStream.getNext() instanceof EOFRecord)) {
            throw new IllegalStateException("Bad chart EOF");
        }
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        if (this._recs.isEmpty()) {
            return;
        }
        recordVisitor.visitRecord(this._bofRec);
        for (RecordBase recordBase : this._recs) {
            if (recordBase instanceof RecordAggregate) {
                ((RecordAggregate) recordBase).visitContainedRecords(recordVisitor);
            } else {
                recordVisitor.visitRecord((Record) recordBase);
            }
        }
        recordVisitor.visitRecord(EOFRecord.instance);
    }
}
