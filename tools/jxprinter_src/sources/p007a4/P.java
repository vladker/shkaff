package p007a4;

import E3.g;
import E3.l;
import H3.a;
import H3.b;
import O3.p;
import p147z3.C1937q;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P {
    public static final P ATOMIC;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final P f943a;
    public static final P b;
    public static final P c;
    public static final /* synthetic */ P[] d;
    public static final /* synthetic */ a e;

    static {
        P p6 = new P("DEFAULT", 0);
        f943a = p6;
        P p7 = new P("LAZY", 1);
        b = p7;
        P p8 = new P("ATOMIC", 2);
        ATOMIC = p8;
        P p9 = new P("UNDISPATCHED", 3);
        c = p9;
        P[] pArr = {p6, p7, p8, p9};
        d = pArr;
        e = b.enumEntries(pArr);
    }

    public static a getEntries() {
        return e;
    }

    public static P valueOf(String str) {
        return (P) Enum.valueOf(P.class, str);
    }

    public static P[] values() {
        return (P[]) d.clone();
    }

    public final <R, T> void invoke(p pVar, R r6, g<? super T> gVar) {
        int i5 = O.f942a[ordinal()];
        if (i5 == 1) {
            p034f4.a.startCoroutineCancellable(pVar, r6, gVar);
            return;
        }
        if (i5 == 2) {
            l.startCoroutine(pVar, r6, gVar);
        } else if (i5 == 3) {
            p034f4.b.startCoroutineUndispatched(pVar, r6, gVar);
        } else if (i5 != 4) {
            throw new C1937q();
        }
    }

    public static /* synthetic */ void isLazy$annotations() {
    }
}
