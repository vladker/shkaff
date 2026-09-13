package E3;

import java.io.Serializable;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements q, Serializable {
    private final o element;
    private final q left;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class a implements Serializable {
        public static final e Companion = new e();
        private static final long serialVersionUID = 0;
        private final q[] elements;

        public a(q[] elements) {
            E.f(elements, "elements");
            this.elements = elements;
        }

        private final Object readResolve() {
            q[] qVarArr = this.elements;
            q qVarPlus = r.INSTANCE;
            for (q qVar : qVarArr) {
                qVarPlus = qVarPlus.plus(qVar);
            }
            return qVarPlus;
        }

        public final q[] getElements() {
            return this.elements;
        }
    }

    public f(q left, o element) {
        E.f(left, "left");
        E.f(element, "element");
        this.left = left;
        this.element = element;
    }

    private final Object writeReplace() {
        int iA = a();
        q[] qVarArr = new q[iA];
        Q q6 = new Q();
        fold(p147z3.Q.INSTANCE, new c(qVarArr, q6, 0));
        if (q6.f5687a == iA) {
            return new a(qVarArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    public final int a() {
        int i5 = 2;
        f fVar = this;
        while (true) {
            q qVar = fVar.left;
            fVar = qVar instanceof f ? (f) qVar : null;
            if (fVar == null) {
                return i5;
            }
            i5++;
        }
    }

    public boolean equals(Object obj) {
        boolean zA;
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.a() == a()) {
                f fVar2 = this;
                while (true) {
                    o oVar = fVar2.element;
                    if (!E.a(fVar.get(oVar.getKey()), oVar)) {
                        zA = false;
                        break;
                    }
                    q qVar = fVar2.left;
                    if (!(qVar instanceof f)) {
                        E.d(qVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        o oVar2 = (o) qVar;
                        zA = E.a(fVar.get(oVar2.getKey()), oVar2);
                        break;
                    }
                    fVar2 = (f) qVar;
                }
                if (zA) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // E3.q
    public <R> R fold(R r6, O3.p operation) {
        E.f(operation, "operation");
        return (R) operation.invoke(this.left.fold(r6, operation), this.element);
    }

    @Override // E3.q
    public <E extends o> E get(p key) {
        E.f(key, "key");
        f fVar = this;
        while (true) {
            E e = (E) fVar.element.get(key);
            if (e != null) {
                return e;
            }
            q qVar = fVar.left;
            if (!(qVar instanceof f)) {
                return (E) qVar.get(key);
            }
            fVar = (f) qVar;
        }
    }

    public final int hashCode() {
        return this.element.hashCode() + this.left.hashCode();
    }

    @Override // E3.q
    public q minusKey(p key) {
        E.f(key, "key");
        if (this.element.get(key) != null) {
            return this.left;
        }
        q qVarMinusKey = this.left.minusKey(key);
        if (qVarMinusKey == this.left) {
            return this;
        }
        return qVarMinusKey == r.INSTANCE ? this.element : new f(qVarMinusKey, this.element);
    }

    @Override // E3.q
    public q plus(q qVar) {
        return m.plus(this, qVar);
    }

    public String toString() {
        return androidx.collection.a.f(']', (String) fold("", new d(0)), new StringBuilder("["));
    }
}
