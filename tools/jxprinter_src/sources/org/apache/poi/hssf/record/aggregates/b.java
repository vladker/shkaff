package org.apache.poi.hssf.record.aggregates;

import java.util.function.Consumer;
import org.apache.poi.hssf.record.DVRecord;
import org.apache.poi.hssf.record.Record;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7037a;
    public final /* synthetic */ RecordAggregate.RecordVisitor b;

    public /* synthetic */ b(RecordAggregate.RecordVisitor recordVisitor, int i5) {
        this.f7037a = i5;
        this.b = recordVisitor;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        RecordAggregate.RecordVisitor recordVisitor;
        Record record;
        switch (this.f7037a) {
            case 0:
                recordVisitor = this.b;
                record = (DVRecord) obj;
                break;
            default:
                recordVisitor = this.b;
                record = (Record) obj;
                break;
        }
        recordVisitor.visitRecord(record);
    }
}
