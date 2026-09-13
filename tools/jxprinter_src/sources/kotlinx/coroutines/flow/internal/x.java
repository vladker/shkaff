package kotlinx.coroutines.flow.internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class x implements E3.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ E3.q f5724a;
    public final Throwable e;

    public x(Throwable th, E3.q qVar) {
        this.f5724a = qVar;
        this.e = th;
    }

    @Override // E3.q
    public <R> R fold(R r6, O3.p pVar) {
        return (R) this.f5724a.fold(r6, pVar);
    }

    @Override // E3.q
    public <E extends E3.o> E get(E3.p pVar) {
        return (E) this.f5724a.get(pVar);
    }

    @Override // E3.q
    public E3.q minusKey(E3.p pVar) {
        return this.f5724a.minusKey(pVar);
    }

    @Override // E3.q
    public E3.q plus(E3.q qVar) {
        return this.f5724a.plus(qVar);
    }
}
