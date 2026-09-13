package p147z3;

import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: z3.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1932l implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9132a = 131328;
    public static final C1931k Companion = new C1931k();
    public static final C1932l CURRENT = C1933m.get();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        C1932l c1932l = obj instanceof C1932l ? (C1932l) obj : null;
        return c1932l != null && this.f9132a == c1932l.f9132a;
    }

    public final int hashCode() {
        return this.f9132a;
    }

    public String toString() {
        return "2.1.0";
    }

    @Override // java.lang.Comparable
    public int compareTo(C1932l other) {
        E.f(other, "other");
        return this.f9132a - other.f9132a;
    }
}
