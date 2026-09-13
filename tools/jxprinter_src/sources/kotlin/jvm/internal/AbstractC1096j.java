package kotlin.jvm.internal;

import A3.e0;
import A3.f0;
import A3.y0;

/* JADX INFO: renamed from: kotlin.jvm.internal.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1096j {
    public static final A3.E iterator(byte[] array) {
        E.f(array, "array");
        return new C1089c(array);
    }

    public static final A3.F iterator(char[] array) {
        E.f(array, "array");
        return new C1090d(array);
    }

    public static final y0 iterator(short[] array) {
        E.f(array, "array");
        return new C1098l(array);
    }

    public static final e0 iterator(int[] array) {
        E.f(array, "array");
        return new C1093g(array);
    }

    public static final f0 iterator(long[] array) {
        E.f(array, "array");
        return new C1097k(array);
    }

    public static final A3.Z iterator(float[] array) {
        E.f(array, "array");
        return new C1092f(array);
    }

    public static final A3.U iterator(double[] array) {
        E.f(array, "array");
        return new C1091e(array);
    }

    public static final A3.D iterator(boolean[] array) {
        E.f(array, "array");
        return new C1088b(array);
    }
}
