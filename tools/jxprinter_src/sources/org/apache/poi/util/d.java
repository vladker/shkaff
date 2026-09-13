package org.apache.poi.util;

import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class d implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7247a;
    public final /* synthetic */ Supplier b;
    public final /* synthetic */ int[] c;
    public final /* synthetic */ String[] d;

    public /* synthetic */ d(Supplier supplier, int[] iArr, String[] strArr, int i5) {
        this.f7247a = i5;
        this.b = supplier;
        this.c = iArr;
        this.d = strArr;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7247a) {
            case 0:
                return GenericRecordUtil.lambda$getBitsAsString$2(this.b, this.c, this.d);
            case 1:
                return GenericRecordUtil.lambda$getBitsAsString$1(this.b, this.c, this.d);
            default:
                return GenericRecordUtil.lambda$getEnumBitsAsString$3(this.b, this.c, this.d);
        }
    }
}
