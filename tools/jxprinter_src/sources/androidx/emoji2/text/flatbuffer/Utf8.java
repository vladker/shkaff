package androidx.emoji2.text.flatbuffer;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Utf8 {
    private static Utf8 DEFAULT;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DecodeUtil {
        public static void handleFourBytes(byte b, byte b6, byte b7, byte b8, char[] cArr, int i5) {
            if (!isNotTrailingByte(b6)) {
                if ((((b6 + 112) + (b << Ascii.FS)) >> 30) == 0 && !isNotTrailingByte(b7) && !isNotTrailingByte(b8)) {
                    int iTrailingByteValue = ((b & 7) << 18) | (trailingByteValue(b6) << 12) | (trailingByteValue(b7) << 6) | trailingByteValue(b8);
                    cArr[i5] = highSurrogate(iTrailingByteValue);
                    cArr[i5 + 1] = lowSurrogate(iTrailingByteValue);
                    return;
                }
            }
            throw new IllegalArgumentException("Invalid UTF-8");
        }

        public static void handleOneByte(byte b, char[] cArr, int i5) {
            cArr[i5] = (char) b;
        }

        public static void handleThreeBytes(byte b, byte b6, byte b7, char[] cArr, int i5) {
            if (isNotTrailingByte(b6) || ((b == -32 && b6 < -96) || ((b == -19 && b6 >= -96) || isNotTrailingByte(b7)))) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            cArr[i5] = (char) (((b & 15) << 12) | (trailingByteValue(b6) << 6) | trailingByteValue(b7));
        }

        public static void handleTwoBytes(byte b, byte b6, char[] cArr, int i5) {
            if (b < -62) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
            }
            if (isNotTrailingByte(b6)) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
            }
            cArr[i5] = (char) (((b & 31) << 6) | trailingByteValue(b6));
        }

        private static char highSurrogate(int i5) {
            return (char) ((i5 >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b) {
            return b > -65;
        }

        public static boolean isOneByte(byte b) {
            return b >= 0;
        }

        public static boolean isThreeBytes(byte b) {
            return b < -16;
        }

        public static boolean isTwoBytes(byte b) {
            return b < -32;
        }

        private static char lowSurrogate(int i5) {
            return (char) ((i5 & IEEEDouble.EXPONENT_BIAS) + 56320);
        }

        private static int trailingByteValue(byte b) {
            return b & 63;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i5, int i6) {
            super(androidx.collection.a.h(i5, i6, "Unpaired surrogate at index ", " of "));
        }
    }

    public static Utf8 getDefault() {
        if (DEFAULT == null) {
            DEFAULT = new Utf8Safe();
        }
        return DEFAULT;
    }

    public static void setDefault(Utf8 utf8) {
        DEFAULT = utf8;
    }

    public abstract String decodeUtf8(ByteBuffer byteBuffer, int i5, int i6);

    public abstract void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer);

    public abstract int encodedLength(CharSequence charSequence);
}
