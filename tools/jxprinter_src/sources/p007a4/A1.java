package p007a4;

import E3.n;
import E3.o;
import E3.p;
import E3.q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A1 implements o, p {
    public static final A1 INSTANCE = new A1();

    @Override // E3.o, E3.q
    public <R> R fold(R r6, O3.p pVar) {
        return (R) n.fold(this, r6, pVar);
    }

    @Override // E3.o, E3.q
    public <E extends o> E get(p pVar) {
        return (E) n.get(this, pVar);
    }

    @Override // E3.o, E3.q
    public q minusKey(p pVar) {
        return n.minusKey(this, pVar);
    }

    @Override // E3.o, E3.q
    public q plus(q qVar) {
        return n.plus(this, qVar);
    }

    @Override // E3.o
    public p getKey() {
        return this;
    }
}
