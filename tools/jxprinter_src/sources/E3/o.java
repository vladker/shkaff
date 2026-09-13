package E3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface o extends q {
    @Override // E3.q
    <R> R fold(R r6, O3.p pVar);

    @Override // E3.q
    <E extends o> E get(p pVar);

    p getKey();

    @Override // E3.q
    q minusKey(p pVar);

    @Override // E3.q
    /* synthetic */ q plus(q qVar);
}
