package E3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface j extends o {
    public static final i Key = i.f229a;

    @Override // E3.o, E3.q
    /* synthetic */ Object fold(Object obj, O3.p pVar);

    @Override // E3.o, E3.q
    <E extends o> E get(p pVar);

    @Override // E3.o
    /* synthetic */ p getKey();

    <T> g<T> interceptContinuation(g<? super T> gVar);

    @Override // E3.o, E3.q
    q minusKey(p pVar);

    @Override // E3.o, E3.q
    /* synthetic */ q plus(q qVar);

    void releaseInterceptedContinuation(g<?> gVar);
}
