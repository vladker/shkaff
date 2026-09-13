package io.reactivex.internal.schedulers;

import io.reactivex.AbstractC0676c;
import io.reactivex.AbstractC0979l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I extends io.reactivex.N implements p011b3.c {
    public static final H e = new H();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final p011b3.c f5340f = p011b3.d.disposed();
    public final io.reactivex.N b;
    public final p123v3.a c;
    public final p011b3.c d;

    public I(p027e3.o oVar, io.reactivex.N n6) {
        this.b = n6;
        p123v3.a serialized = p123v3.d.create().toSerialized();
        this.c = serialized;
        try {
            this.d = ((AbstractC0676c) oVar.apply(serialized)).subscribe();
        } catch (Throwable th) {
            throw p100r3.g.d(th);
        }
    }

    @Override // io.reactivex.N
    public io.reactivex.M createWorker() {
        io.reactivex.M mCreateWorker = this.b.createWorker();
        p123v3.a serialized = p123v3.d.create().toSerialized();
        AbstractC0979l map = serialized.map(new C(mCreateWorker));
        F f6 = new F(serialized, mCreateWorker);
        this.c.onNext(map);
        return f6;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.d.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.d.e();
    }
}
