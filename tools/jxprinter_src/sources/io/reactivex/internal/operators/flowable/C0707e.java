package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.Iterator;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0707e implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4596a;
    public final AbstractC0979l b;

    public /* synthetic */ C0707e(AbstractC0979l abstractC0979l, int i5) {
        this.f4596a = i5;
        this.b = abstractC0979l;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f4596a) {
            case 0:
                C0701d c0701d = new C0701d();
                AbstractC0979l.fromPublisher(this.b).materialize().subscribe((InterfaceC0984q) c0701d);
                return c0701d;
            default:
                return new C0731i(this.b, new C0737j(), 0);
        }
    }
}
