package com.google.common.util.concurrent;

import com.google.common.base.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3461a;
    public final /* synthetic */ int b;

    public /* synthetic */ k(int i5, int i6) {
        this.f3461a = i6;
        this.b = i5;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        switch (this.f3461a) {
            case 0:
                return Striped.lambda$semaphore$1(this.b);
            default:
                return Striped.lambda$lazyWeakSemaphore$2(this.b);
        }
    }
}
