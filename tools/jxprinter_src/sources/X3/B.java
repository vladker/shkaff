package X3;

import A3.AbstractC0132b;
import A3.C0130a;
import java.util.Iterator;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class B extends AbstractC0132b implements InterfaceC0256w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C f841a;

    public B(C c) {
        this.f841a = c;
    }

    @Override // A3.AbstractC0132b
    public final int b() {
        return C.a(this.f841a).groupCount() + 1;
    }

    @Override // A3.AbstractC0132b, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof C0254u) {
            return super.contains((C0254u) obj);
        }
        return false;
    }

    @Override // X3.InterfaceC0256w, X3.InterfaceC0255v
    public final C0254u get(int i5) {
        C c = this.f841a;
        Matcher matcherA = C.a(c);
        U3.q qVarUntil = U3.B.until(matcherA.start(i5), matcherA.end(i5));
        if (qVarUntil.getStart().intValue() < 0) {
            return null;
        }
        String strGroup = C.a(c).group(i5);
        kotlin.jvm.internal.E.e(strGroup, "group(...)");
        return new C0254u(strGroup, qVarUntil);
    }

    @Override // A3.AbstractC0132b, java.util.Collection
    public final boolean isEmpty() {
        return false;
    }

    @Override // A3.AbstractC0132b, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return W3.L.map(A3.T.asSequence(A3.I.getIndices(this)), new C0130a(this, 10)).iterator();
    }

    @Override // X3.InterfaceC0256w
    public final C0254u get(String name) {
        kotlin.jvm.internal.E.f(name, "name");
        return I3.c.IMPLEMENTATIONS.getMatchResultNamedGroup(C.a(this.f841a), name);
    }
}
