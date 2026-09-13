package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0676c;
import io.reactivex.AbstractC0979l;
import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0682i;
import io.reactivex.InterfaceC0988v;
import p077n3.C1260n;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.u2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0805u2 extends AbstractC0985s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4803a;
    public final Object b;

    public /* synthetic */ C0805u2(Object obj, int i5) {
        this.f4803a = i5;
        this.b = obj;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        switch (this.f4803a) {
            case 0:
                ((AbstractC0979l) this.b).subscribe((t5.c) new C0799t2(interfaceC0988v));
                break;
            case 1:
                interfaceC0988v.onSubscribe(p011b3.d.disposed());
                interfaceC0988v.onError((Throwable) this.b);
                break;
            case 2:
                ((AbstractC0676c) ((InterfaceC0682i) this.b)).subscribe(new p053j3.r(interfaceC0988v, 2));
                break;
            default:
                ((io.reactivex.O) ((io.reactivex.V) this.b)).subscribe(new C1260n(interfaceC0988v, 2));
                break;
        }
    }
}
