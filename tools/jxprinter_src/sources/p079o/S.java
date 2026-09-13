package p079o;

import com.google.common.primitives.UnsignedBytes;
import java.lang.reflect.Type;
import org.apache.logging.log4j.util.Chars;
import p096r.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class S implements Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final S f6342a = new S();

    @Override // p079o.Q, p079o.InterfaceC1290t
    public final void write(G g6, Object obj, Object obj2, Type type, int i5) {
        b0 b0Var = g6.f6325j;
        if (obj == null) {
            b0Var.p(c0.WriteNullListAsEmpty);
            return;
        }
        int i6 = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            b0Var.write(91);
            while (i6 < iArr.length) {
                if (i6 != 0) {
                    b0Var.write(44);
                }
                b0Var.l(iArr[i6]);
                i6++;
            }
            b0Var.write(93);
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            b0Var.write(91);
            while (i6 < sArr.length) {
                if (i6 != 0) {
                    b0Var.write(44);
                }
                b0Var.l(sArr[i6]);
                i6++;
            }
            b0Var.write(93);
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            b0Var.write(91);
            while (i6 < jArr.length) {
                if (i6 != 0) {
                    b0Var.write(44);
                }
                b0Var.m(jArr[i6]);
                i6++;
            }
            b0Var.write(93);
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            b0Var.write(91);
            while (i6 < zArr.length) {
                if (i6 != 0) {
                    b0Var.write(44);
                }
                if (zArr[i6]) {
                    b0Var.write("true");
                } else {
                    b0Var.write("false");
                }
                i6++;
            }
            b0Var.write(93);
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            b0Var.write(91);
            while (i6 < fArr.length) {
                if (i6 != 0) {
                    b0Var.write(44);
                }
                float f6 = fArr[i6];
                if (Float.isNaN(f6)) {
                    b0Var.n();
                } else {
                    b0Var.a(Float.toString(f6));
                }
                i6++;
            }
            b0Var.write(93);
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            b0Var.write(91);
            while (i6 < dArr.length) {
                if (i6 != 0) {
                    b0Var.write(44);
                }
                double d = dArr[i6];
                if (Double.isNaN(d)) {
                    b0Var.n();
                } else {
                    b0Var.a(Double.toString(d));
                }
                i6++;
            }
            b0Var.write(93);
            return;
        }
        if (!(obj instanceof byte[])) {
            b0Var.q(new String((char[]) obj));
            return;
        }
        byte[] bArr = (byte[]) obj;
        b0Var.getClass();
        int length = bArr.length;
        boolean z6 = b0Var.d;
        char c = z6 ? Chars.QUOTE : Chars.DQUOTE;
        if (length == 0) {
            b0Var.write(z6 ? "''" : "\"\"");
            return;
        }
        char[] cArr = e.f7909p;
        int i7 = (length / 3) * 3;
        int i8 = length - 1;
        int i9 = b0Var.b;
        int i10 = (((i8 / 3) + 1) << 2) + i9;
        int i11 = i10 + 2;
        if (i11 > b0Var.f6369a.length) {
            b0Var.c(i11);
        }
        b0Var.b = i11;
        int i12 = i9 + 1;
        b0Var.f6369a[i9] = c;
        int i13 = 0;
        while (i13 < i7) {
            int i14 = i13 + 2;
            int i15 = ((bArr[i13 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i13] & UnsignedBytes.MAX_VALUE) << 16);
            i13 += 3;
            int i16 = i15 | (bArr[i14] & UnsignedBytes.MAX_VALUE);
            char[] cArr2 = b0Var.f6369a;
            cArr2[i12] = cArr[(i16 >>> 18) & 63];
            cArr2[i12 + 1] = cArr[(i16 >>> 12) & 63];
            int i17 = i12 + 3;
            cArr2[i12 + 2] = cArr[(i16 >>> 6) & 63];
            i12 += 4;
            cArr2[i17] = cArr[i16 & 63];
        }
        int i18 = length - i7;
        if (i18 > 0) {
            int i19 = ((bArr[i7] & UnsignedBytes.MAX_VALUE) << 10) | (i18 == 2 ? (bArr[i8] & UnsignedBytes.MAX_VALUE) << 2 : 0);
            char[] cArr3 = b0Var.f6369a;
            cArr3[i10 - 3] = cArr[i19 >> 12];
            cArr3[i10 - 2] = cArr[(i19 >>> 6) & 63];
            cArr3[i10 - 1] = i18 == 2 ? cArr[i19 & 63] : '=';
            cArr3[i10] = Chars.EQ;
        }
        b0Var.f6369a[i10 + 1] = c;
    }
}
