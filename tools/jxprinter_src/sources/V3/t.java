package V3;

import androidx.webkit.ProxyConfig;
import kotlin.jvm.internal.E;
import p147z3.C1937q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class t {
    public static final r Companion = new r();
    public static final t star = new t(null, null);
    private final p type;
    private final u variance;

    public t(u uVar, p pVar) {
        String str;
        this.variance = uVar;
        this.type = pVar;
        if ((uVar == null) == (pVar == null)) {
            return;
        }
        if (uVar == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + uVar + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public static final t contravariant(p pVar) {
        return Companion.contravariant(pVar);
    }

    public static final t covariant(p pVar) {
        return Companion.covariant(pVar);
    }

    public static final t invariant(p pVar) {
        return Companion.invariant(pVar);
    }

    public final u component1() {
        return this.variance;
    }

    public final p component2() {
        return this.type;
    }

    public final t copy(u uVar, p pVar) {
        return new t(uVar, pVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.variance == tVar.variance && E.a(this.type, tVar.type);
    }

    public final p getType() {
        return this.type;
    }

    public final u getVariance() {
        return this.variance;
    }

    public final int hashCode() {
        u uVar = this.variance;
        int iHashCode = (uVar == null ? 0 : uVar.hashCode()) * 31;
        p pVar = this.type;
        return iHashCode + (pVar != null ? pVar.hashCode() : 0);
    }

    public String toString() {
        u uVar = this.variance;
        int i5 = uVar == null ? -1 : s.f761a[uVar.ordinal()];
        if (i5 == -1) {
            return ProxyConfig.MATCH_ALL_SCHEMES;
        }
        if (i5 == 1) {
            return String.valueOf(this.type);
        }
        if (i5 == 2) {
            return "in " + this.type;
        }
        if (i5 != 3) {
            throw new C1937q();
        }
        return "out " + this.type;
    }
}
