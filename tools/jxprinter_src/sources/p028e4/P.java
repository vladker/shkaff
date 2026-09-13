package p028e4;

import E3.q;
import kotlin.jvm.internal.E;
import p007a4.L;
import p007a4.o1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3938a;
    public final q context;
    private final o1[] elements;
    private final Object[] values;

    public P(q qVar, int i5) {
        this.context = qVar;
        this.values = new Object[i5];
        this.elements = new o1[i5];
    }

    public final void append(o1 o1Var, Object obj) {
        Object[] objArr = this.values;
        int i5 = this.f3938a;
        objArr[i5] = obj;
        o1[] o1VarArr = this.elements;
        this.f3938a = i5 + 1;
        E.d(o1Var, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        o1VarArr[i5] = o1Var;
    }

    public final void restore(q qVar) {
        int length = this.elements.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i5 = length - 1;
            o1 o1Var = this.elements[length];
            E.c(o1Var);
            ((L) o1Var).a(qVar, this.values[length]);
            if (i5 < 0) {
                return;
            } else {
                length = i5;
            }
        }
    }
}
