package X3;

/* JADX INFO: renamed from: X3.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0254u {
    private final U3.q range;
    private final String value;

    public C0254u(String value, U3.q range) {
        kotlin.jvm.internal.E.f(value, "value");
        kotlin.jvm.internal.E.f(range, "range");
        this.value = value;
        this.range = range;
    }

    public final String component1() {
        return this.value;
    }

    public final U3.q component2() {
        return this.range;
    }

    public final C0254u copy(String value, U3.q range) {
        kotlin.jvm.internal.E.f(value, "value");
        kotlin.jvm.internal.E.f(range, "range");
        return new C0254u(value, range);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0254u)) {
            return false;
        }
        C0254u c0254u = (C0254u) obj;
        return kotlin.jvm.internal.E.a(this.value, c0254u.value) && kotlin.jvm.internal.E.a(this.range, c0254u.range);
    }

    public final U3.q getRange() {
        return this.range;
    }

    public final String getValue() {
        return this.value;
    }

    public final int hashCode() {
        return this.range.hashCode() + (this.value.hashCode() * 31);
    }

    public String toString() {
        return "MatchGroup(value=" + this.value + ", range=" + this.range + ')';
    }
}
