package E3;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements o {
    private final p key;

    public a(p key) {
        E.f(key, "key");
        this.key = key;
    }

    @Override // E3.o, E3.q
    public <R> R fold(R r6, O3.p pVar) {
        return (R) n.fold(this, r6, pVar);
    }

    @Override // E3.o, E3.q
    public <E extends o> E get(p pVar) {
        return (E) n.get(this, pVar);
    }

    @Override // E3.o
    public p getKey() {
        return this.key;
    }

    @Override // E3.o, E3.q
    public q minusKey(p pVar) {
        return n.minusKey(this, pVar);
    }

    @Override // E3.o, E3.q
    public q plus(q qVar) {
        return n.plus(this, qVar);
    }
}
