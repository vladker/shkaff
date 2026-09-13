package androidx.core.util;

import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f6, S s6) {
        this.first = f6;
        this.second = s6;
    }

    public static <A, B> Pair<A, B> create(A a6, B b) {
        return new Pair<>(a6, b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return ObjectsCompat.equals(pair.first, this.first) && ObjectsCompat.equals(pair.second, this.second);
    }

    public int hashCode() {
        F f6 = this.first;
        int iHashCode = f6 == null ? 0 : f6.hashCode();
        S s6 = this.second;
        return iHashCode ^ (s6 != null ? s6.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.first + " " + this.second + VectorFormat.DEFAULT_SUFFIX;
    }
}
