package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import io.reactivex.internal.operators.observable.C0858e;
import java.util.Iterator;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0725h implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4635a;
    public final Object b;
    public final Object c;

    public /* synthetic */ C0725h(Object obj, Object obj2, int i5) {
        this.f4635a = i5;
        this.c = obj;
        this.b = obj2;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f4635a) {
            case 0:
                Object obj = this.b;
                C0719g c0719g = new C0719g();
                c0719g.b = obj;
                ((AbstractC0979l) this.c).subscribe((InterfaceC0984q) c0719g);
                return new C0713f(c0719g, 0);
            default:
                Object obj2 = this.b;
                C0858e c0858e = new C0858e();
                c0858e.b = obj2;
                ((io.reactivex.B) this.c).subscribe(c0858e);
                return new C0713f(c0858e, 1);
        }
    }
}
