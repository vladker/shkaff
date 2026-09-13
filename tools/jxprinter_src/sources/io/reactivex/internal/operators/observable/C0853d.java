package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.flowable.C0731i;
import java.util.Iterator;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0853d implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5163a;
    public final io.reactivex.B b;

    public /* synthetic */ C0853d(io.reactivex.B b, int i5) {
        this.f5163a = i5;
        this.b = b;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f5163a) {
            case 0:
                C0848c c0848c = new C0848c();
                io.reactivex.B.wrap(this.b).materialize().subscribe(c0848c);
                return c0848c;
            default:
                return new C0731i(this.b, new C0863f(), 1);
        }
    }
}
