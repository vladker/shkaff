package org.apache.poi.hssf.record;

import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.poi.hssf.record.a0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C1380a0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7034a;
    public final /* synthetic */ HyperlinkRecord b;

    public /* synthetic */ C1380a0(HyperlinkRecord hyperlinkRecord, int i5) {
        this.f7034a = i5;
        this.b = hyperlinkRecord;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7034a) {
            case 0:
                return Integer.valueOf(this.b.getLinkOptions());
            case 1:
                return this.b.lambda$getGenericProperties$0();
            case 2:
                return this.b.getGuid();
            case 3:
                return this.b.lambda$getGenericProperties$1();
            case 4:
                return this.b.getLabel();
            case 5:
                return this.b.getTargetFrame();
            case 6:
                return this.b.getMoniker();
            case 7:
                return this.b.getTextMark();
            default:
                return this.b.getAddress();
        }
    }
}
