package org.apache.poi.hssf.record.pivottable;

import java.util.function.Supplier;
import org.apache.poi.hssf.record.StandardRecord;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7110a;
    public final /* synthetic */ StandardRecord b;

    public /* synthetic */ c(StandardRecord standardRecord, int i5) {
        this.f7110a = i5;
        this.b = standardRecord;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7110a) {
            case 0:
                return ((PageItemRecord) this.b).lambda$getGenericProperties$1();
            case 1:
                return ((StreamIDRecord) this.b).lambda$getGenericProperties$0();
            default:
                return ((ViewSourceRecord) this.b).lambda$getGenericProperties$0();
        }
    }
}
