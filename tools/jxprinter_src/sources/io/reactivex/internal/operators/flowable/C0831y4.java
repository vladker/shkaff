package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.y4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0831y4 extends AbstractC0683a {
    public final long c;
    public final long d;
    public final TimeUnit e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final io.reactivex.N f4844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f4845g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f4846h;

    public C0831y4(AbstractC0979l abstractC0979l, long j6, long j7, TimeUnit timeUnit, io.reactivex.N n6, int i5, boolean z6) {
        super(abstractC0979l);
        this.c = j6;
        this.d = j7;
        this.e = timeUnit;
        this.f4844f = n6;
        this.f4845g = i5;
        this.f4846h = z6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        this.b.subscribe((InterfaceC0984q) new C0825x4(cVar, this.c, this.d, this.e, this.f4844f, this.f4845g, this.f4846h));
    }
}
