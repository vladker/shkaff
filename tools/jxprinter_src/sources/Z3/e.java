package Z3;

import A3.AbstractC0157z;
import X3.AbstractC0245k;
import com.google.common.primitives.UnsignedBytes;
import kotlin.jvm.internal.E;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends d {
    public static final void a(int i5, String str) {
        if (str.charAt(i5) == '-') {
            return;
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Expected '-' (hyphen) at index ", ", but was '");
        sbT.append(str.charAt(i5));
        sbT.append(Chars.QUOTE);
        throw new IllegalArgumentException(sbT.toString().toString());
    }

    public static final void b(long j6, byte[] bArr, int i5, int i6) {
        int i7 = (i6 * 2) + i5;
        for (int i8 = 0; i8 < i6; i8++) {
            int i9 = AbstractC0245k.getBYTE_TO_LOWER_CASE_HEX_DIGITS()[(int) (255 & j6)];
            bArr[i7 - 1] = (byte) i9;
            i7 -= 2;
            bArr[i7] = (byte) (i9 >> 8);
            j6 >>= 8;
        }
    }

    public static final long c(byte[] bArr, int i5) {
        return (((long) bArr[i5 + 7]) & 255) | ((((long) bArr[i5]) & 255) << 56) | ((((long) bArr[i5 + 1]) & 255) << 48) | ((((long) bArr[i5 + 2]) & 255) << 40) | ((((long) bArr[i5 + 3]) & 255) << 32) | ((((long) bArr[i5 + 4]) & 255) << 24) | ((((long) bArr[i5 + 5]) & 255) << 16) | ((((long) bArr[i5 + 6]) & 255) << 8);
    }

    public static final c uuidFromRandomBytes(byte[] randomBytes) {
        E.f(randomBytes, "randomBytes");
        byte b = (byte) (randomBytes[6] & 15);
        randomBytes[6] = b;
        randomBytes[6] = (byte) (b | 64);
        byte b6 = (byte) (randomBytes[8] & 63);
        randomBytes[8] = b6;
        randomBytes[8] = (byte) (b6 | UnsignedBytes.MAX_POWER_OF_TWO);
        return c.Companion.fromByteArray(randomBytes);
    }
}
