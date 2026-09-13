package S3;

import U3.L;
import io.flutter.embedding.android.KeyboardMap;
import kotlin.jvm.internal.E;
import p147z3.G;
import p147z3.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h {
    public static final byte[] nextUBytes(f fVar, int i5) {
        E.f(fVar, "<this>");
        return p147z3.E.m1179constructorimpl(fVar.nextBytes(i5));
    }

    /* JADX INFO: renamed from: nextUBytes-EVgfTAA, reason: not valid java name */
    public static final byte[] m816nextUBytesEVgfTAA(f nextUBytes, byte[] array) {
        E.f(nextUBytes, "$this$nextUBytes");
        E.f(array, "array");
        nextUBytes.nextBytes(array);
        return array;
    }

    /* JADX INFO: renamed from: nextUBytes-Wvrt4B4, reason: not valid java name */
    public static final byte[] m817nextUBytesWvrt4B4(f nextUBytes, byte[] array, int i5, int i6) {
        E.f(nextUBytes, "$this$nextUBytes");
        E.f(array, "array");
        nextUBytes.nextBytes(array, i5, i6);
        return array;
    }

    public static final int nextUInt(f fVar) {
        E.f(fVar, "<this>");
        return G.m1188constructorimpl(fVar.c());
    }

    /* JADX INFO: renamed from: nextUInt-a8DCA5k, reason: not valid java name */
    public static final int m818nextUInta8DCA5k(f nextUInt, int i5, int i6) {
        E.f(nextUInt, "$this$nextUInt");
        if (Integer.compareUnsigned(i6, i5) > 0) {
            return G.m1188constructorimpl(nextUInt.e(i5 ^ Integer.MIN_VALUE, i6 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
        }
        throw new IllegalArgumentException(g.boundsErrorMessage(G.a(i5), G.a(i6)).toString());
    }

    /* JADX INFO: renamed from: nextUInt-qCasIEU, reason: not valid java name */
    public static final int m819nextUIntqCasIEU(f nextUInt, int i5) {
        E.f(nextUInt, "$this$nextUInt");
        return m818nextUInta8DCA5k(nextUInt, 0, i5);
    }

    public static final long nextULong(f fVar) {
        E.f(fVar, "<this>");
        return J.m1247constructorimpl(fVar.f());
    }

    /* JADX INFO: renamed from: nextULong-V1Xi4fY, reason: not valid java name */
    public static final long m820nextULongV1Xi4fY(f nextULong, long j6) {
        E.f(nextULong, "$this$nextULong");
        return m821nextULongjmpaWc(nextULong, 0L, j6);
    }

    /* JADX INFO: renamed from: nextULong-jmpaW-c, reason: not valid java name */
    public static final long m821nextULongjmpaWc(f nextULong, long j6, long j7) {
        E.f(nextULong, "$this$nextULong");
        if (Long.compareUnsigned(j7, j6) > 0) {
            return J.m1247constructorimpl(nextULong.g(j6 ^ Long.MIN_VALUE, j7 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
        }
        throw new IllegalArgumentException(g.boundsErrorMessage(J.a(j6), J.a(j7)).toString());
    }

    public static final int nextUInt(f fVar, U3.G range) {
        E.f(fVar, "<this>");
        E.f(range, "range");
        int i5 = range.f724a;
        int i6 = range.b;
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        if (Integer.compareUnsigned(i6, -1) < 0) {
            return m818nextUInta8DCA5k(fVar, i5, G.m1188constructorimpl(i6 + 1));
        }
        return Integer.compareUnsigned(i5, 0) > 0 ? G.m1188constructorimpl(m818nextUInta8DCA5k(fVar, G.m1188constructorimpl(i5 - 1), i6) + 1) : nextUInt(fVar);
    }

    public static final long nextULong(f fVar, L range) {
        E.f(fVar, "<this>");
        E.f(range, "range");
        long j6 = range.f726a;
        long j7 = range.b;
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        if (Long.compareUnsigned(j7, -1L) < 0) {
            return m821nextULongjmpaWc(fVar, j6, J.m1247constructorimpl(J.m1247constructorimpl(KeyboardMap.kValueMask & ((long) 1)) + j7));
        }
        if (Long.compareUnsigned(j6, 0L) <= 0) {
            return nextULong(fVar);
        }
        long j8 = KeyboardMap.kValueMask & ((long) 1);
        return J.m1247constructorimpl(J.m1247constructorimpl(j8) + m821nextULongjmpaWc(fVar, J.m1247constructorimpl(j6 - J.m1247constructorimpl(j8)), j7));
    }
}
