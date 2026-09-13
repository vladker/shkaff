package S3;

import U3.q;
import U3.v;
import androidx.core.location.LocationRequestCompat;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g {
    public static final f Random(int i5) {
        return new j(i5, i5 >> 31);
    }

    public static final String boundsErrorMessage(Object from, Object until) {
        E.f(from, "from");
        E.f(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final int nextInt(f fVar, q range) {
        E.f(fVar, "<this>");
        E.f(range, "range");
        int i5 = range.f732a;
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        int i6 = range.b;
        if (i6 < Integer.MAX_VALUE) {
            return fVar.e(i5, i6 + 1);
        }
        return i5 > Integer.MIN_VALUE ? fVar.e(i5 - 1, i6) + 1 : fVar.c();
    }

    public static final long nextLong(f fVar, v range) {
        E.f(fVar, "<this>");
        E.f(range, "range");
        long j6 = range.f734a;
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        long j7 = range.b;
        if (j7 < LocationRequestCompat.PASSIVE_INTERVAL) {
            return fVar.g(j6, j7 + 1);
        }
        return j6 > Long.MIN_VALUE ? fVar.g(j6 - 1, j7) + 1 : fVar.f();
    }

    public static final f Random(long j6) {
        return new j((int) j6, (int) (j6 >> 32));
    }
}
