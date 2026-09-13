package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import io.reactivex.internal.operators.observable.C0843b;
import java.util.Iterator;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0695c implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4575a;
    public final int b;
    public final Object c;

    public /* synthetic */ C0695c(Object obj, int i5, int i6) {
        this.f4575a = i6;
        this.c = obj;
        this.b = i5;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f4575a) {
            case 0:
                RunnableC0689b runnableC0689b = new RunnableC0689b(this.b);
                ((AbstractC0979l) this.c).subscribe((InterfaceC0984q) runnableC0689b);
                return runnableC0689b;
            default:
                C0843b c0843b = new C0843b(this.b);
                ((io.reactivex.B) this.c).subscribe(c0843b);
                return c0843b;
        }
    }
}
