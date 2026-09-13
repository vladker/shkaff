package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import io.reactivex.N;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p011b3.b;
import p045i.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class O extends AbstractC0676c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0676c f5420a;
    public final long b;
    public final TimeUnit c;
    public final N d;
    public final InterfaceC0682i e;

    public O(AbstractC0676c abstractC0676c, long j6, TimeUnit timeUnit, N n6, InterfaceC0682i interfaceC0682i) {
        this.f5420a = abstractC0676c;
        this.b = j6;
        this.c = timeUnit;
        this.d = n6;
        this.e = interfaceC0682i;
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        b bVar = new b();
        interfaceC0679f.onSubscribe(bVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        bVar.add(this.d.scheduleDirect(new a(this, atomicBoolean, bVar, interfaceC0679f), this.b, this.c));
        this.f5420a.subscribe(new N(bVar, interfaceC0679f, atomicBoolean));
    }
}
