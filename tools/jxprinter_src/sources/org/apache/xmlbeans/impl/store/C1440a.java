package org.apache.xmlbeans.impl.store;

import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1440a implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7408a;

    public /* synthetic */ C1440a(int i5) {
        this.f7408a = i5;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7408a) {
            case 0:
                return CharUtil.lambda$static$0();
            default:
                return Locale.lambda$static$7();
        }
    }
}
