package org.apache.poi.hssf.record;

import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class K implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7002a;

    public /* synthetic */ K(int i5) {
        this.f7002a = i5;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7002a) {
            case 0:
                return ExternalNameRecord.lambda$getGenericProperties$1();
            default:
                return IndexRecord.lambda$getGenericProperties$0();
        }
    }
}
