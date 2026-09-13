package org.apache.poi.hssf.eventmodel;

import java.io.InputStream;
import java.util.Arrays;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordFactory;
import org.apache.poi.hssf.record.RecordInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class EventRecordFactory {
    private final ERFListener _listener;
    private final short[] _sids;

    public EventRecordFactory(ERFListener eRFListener, short[] sArr) {
        this._listener = eRFListener;
        if (sArr == null) {
            this._sids = null;
            return;
        }
        short[] sArr2 = (short[]) sArr.clone();
        this._sids = sArr2;
        Arrays.sort(sArr2);
    }

    private boolean isSidIncluded(short s6) {
        short[] sArr = this._sids;
        return sArr == null || Arrays.binarySearch(sArr, s6) >= 0;
    }

    private boolean processRecord(Record record) {
        if (isSidIncluded(record.getSid())) {
            return this._listener.processRecord(record);
        }
        return true;
    }

    public void processRecords(InputStream inputStream) {
        RecordInputStream recordInputStream = new RecordInputStream(inputStream);
        Record record = null;
        while (recordInputStream.hasNextRecord()) {
            recordInputStream.nextRecord();
            Record[] recordArrCreateRecord = RecordFactory.createRecord(recordInputStream);
            int i5 = 0;
            if (recordArrCreateRecord.length > 1) {
                int length = recordArrCreateRecord.length;
                while (i5 < length) {
                    Record record2 = recordArrCreateRecord[i5];
                    if (record != null && !processRecord(record)) {
                        return;
                    }
                    i5++;
                    record = record2;
                }
            } else {
                Record record3 = recordArrCreateRecord[0];
                if (record3 == null) {
                    continue;
                } else if (record != null && !processRecord(record)) {
                    return;
                } else {
                    record = record3;
                }
            }
        }
        if (record != null) {
            processRecord(record);
        }
    }
}
