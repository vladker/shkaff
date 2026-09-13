package p147z3;

import A3.I;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class A {
    public static final <A, B> C1938s to(A a6, B b) {
        return new C1938s(a6, b);
    }

    public static final <T> List<T> toList(C1938s c1938s) {
        E.f(c1938s, "<this>");
        return I.listOf(c1938s.f9134a, c1938s.b);
    }

    public static final <T> List<T> toList(z zVar) {
        E.f(zVar, "<this>");
        return I.listOf(zVar.f9136a, zVar.b, zVar.c);
    }
}
