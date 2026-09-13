package org.apache.poi.hssf.eventusermodel;

import E4.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HSSFRequest {
    private final Map<Short, List<HSSFListener>> _records = new HashMap(50);

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$addListener$0(Short sh) {
        return new ArrayList(1);
    }

    public void addListener(HSSFListener hSSFListener, short s6) {
        this._records.computeIfAbsent(Short.valueOf(s6), new b(1)).add(hSSFListener);
    }

    public void addListenerForAllRecords(HSSFListener hSSFListener) {
        for (short s6 : RecordFactory.getAllKnownRecordSIDs()) {
            addListener(hSSFListener, s6);
        }
    }

    public short processRecord(Record record) {
        List<HSSFListener> list = this._records.get(Short.valueOf(record.getSid()));
        short sAbortableProcessRecord = 0;
        if (list != null) {
            for (HSSFListener hSSFListener : list) {
                if (hSSFListener instanceof AbortableHSSFListener) {
                    sAbortableProcessRecord = ((AbortableHSSFListener) hSSFListener).abortableProcessRecord(record);
                    if (sAbortableProcessRecord != 0) {
                        return sAbortableProcessRecord;
                    }
                } else {
                    hSSFListener.processRecord(record);
                }
            }
        }
        return sAbortableProcessRecord;
    }
}
