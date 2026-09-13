package p145z1;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9110a;

    public l(int i5) {
        this.f9110a = i5;
    }

    public final l copy(int i5) {
        return new l(i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l) && this.f9110a == ((l) obj).f9110a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f9110a);
    }

    public String toString() {
        return AbstractC0157z.p(new StringBuilder("RotateOption(angle="), this.f9110a, ')');
    }
}
