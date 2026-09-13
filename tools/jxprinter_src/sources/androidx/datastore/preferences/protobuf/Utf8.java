package androidx.datastore.preferences.protobuf;

import androidx.collection.a;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import org.apache.poi.ss.util.IEEEDouble;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    static final int COMPLETE = 0;
    static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DecodeUtil {
        private DecodeUtil() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleFourBytes(byte b, byte b6, byte b7, byte b8, char[] cArr, int i5) throws InvalidProtocolBufferException {
            if (!isNotTrailingByte(b6)) {
                if ((((b6 + 112) + (b << Ascii.FS)) >> 30) == 0 && !isNotTrailingByte(b7) && !isNotTrailingByte(b8)) {
                    int iTrailingByteValue = ((b & 7) << 18) | (trailingByteValue(b6) << 12) | (trailingByteValue(b7) << 6) | trailingByteValue(b8);
                    cArr[i5] = highSurrogate(iTrailingByteValue);
                    cArr[i5 + 1] = lowSurrogate(iTrailingByteValue);
                    return;
                }
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleOneByte(byte b, char[] cArr, int i5) {
            cArr[i5] = (char) b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleThreeBytes(byte b, byte b6, byte b7, char[] cArr, int i5) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b6) || ((b == -32 && b6 < -96) || ((b == -19 && b6 >= -96) || isNotTrailingByte(b7)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i5] = (char) (((b & 15) << 12) | (trailingByteValue(b6) << 6) | trailingByteValue(b7));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleTwoBytes(byte b, byte b6, char[] cArr, int i5) throws InvalidProtocolBufferException {
            if (b < -62 || isNotTrailingByte(b6)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i5] = (char) (((b & 31) << 6) | trailingByteValue(b6));
        }

        private static char highSurrogate(int i5) {
            return (char) ((i5 >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b) {
            return b > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isOneByte(byte b) {
            return b >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isThreeBytes(byte b) {
            return b < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
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
    public static abstract class Processor {
        public final String decodeUtf8(ByteBuffer byteBuffer, int i5, int i6) {
            if (byteBuffer.hasArray()) {
                return decodeUtf8(byteBuffer.array(), byteBuffer.arrayOffset() + i5, i6);
            }
            return byteBuffer.isDirect() ? decodeUtf8Direct(byteBuffer, i5, i6) : decodeUtf8Default(byteBuffer, i5, i6);
        }

        public abstract String decodeUtf8(byte[] bArr, int i5, int i6);

        public final String decodeUtf8Default(ByteBuffer byteBuffer, int i5, int i6) throws InvalidProtocolBufferException {
            if ((i5 | i6 | ((byteBuffer.limit() - i5) - i6)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i5), Integer.valueOf(i6)));
            }
            int i7 = i5 + i6;
            char[] cArr = new char[i6];
            int i8 = 0;
            while (i5 < i7) {
                byte b = byteBuffer.get(i5);
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                i5++;
                DecodeUtil.handleOneByte(b, cArr, i8);
                i8++;
            }
            int i9 = i8;
            while (i5 < i7) {
                int i10 = i5 + 1;
                byte b6 = byteBuffer.get(i5);
                if (DecodeUtil.isOneByte(b6)) {
                    int i11 = i9 + 1;
                    DecodeUtil.handleOneByte(b6, cArr, i9);
                    int i12 = i10;
                    while (i12 < i7) {
                        byte b7 = byteBuffer.get(i12);
                        if (!DecodeUtil.isOneByte(b7)) {
                            break;
                        }
                        i12++;
                        DecodeUtil.handleOneByte(b7, cArr, i11);
                        i11++;
                    }
                    i9 = i11;
                    i5 = i12;
                } else if (DecodeUtil.isTwoBytes(b6)) {
                    if (i10 >= i7) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i5 += 2;
                    DecodeUtil.handleTwoBytes(b6, byteBuffer.get(i10), cArr, i9);
                    i9++;
                } else if (DecodeUtil.isThreeBytes(b6)) {
                    if (i10 >= i7 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i13 = i5 + 2;
                    i5 += 3;
                    DecodeUtil.handleThreeBytes(b6, byteBuffer.get(i10), byteBuffer.get(i13), cArr, i9);
                    i9++;
                } else {
                    if (i10 >= i7 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b8 = byteBuffer.get(i10);
                    int i14 = i5 + 3;
                    byte b9 = byteBuffer.get(i5 + 2);
                    i5 += 4;
                    DecodeUtil.handleFourBytes(b6, b8, b9, byteBuffer.get(i14), cArr, i9);
                    i9 += 2;
                }
            }
            return new String(cArr, 0, i9);
        }

        public abstract String decodeUtf8Direct(ByteBuffer byteBuffer, int i5, int i6);

        public abstract int encodeUtf8(String str, byte[] bArr, int i5, int i6);

        public final void encodeUtf8(String str, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int iArrayOffset = byteBuffer.arrayOffset();
                Java8Compatibility.position(byteBuffer, Utf8.encode(str, byteBuffer.array(), byteBuffer.position() + iArrayOffset, byteBuffer.remaining()) - iArrayOffset);
            } else if (byteBuffer.isDirect()) {
                encodeUtf8Direct(str, byteBuffer);
            } else {
                encodeUtf8Default(str, byteBuffer);
            }
        }

        public final void encodeUtf8Default(String str, ByteBuffer byteBuffer) {
            int length = str.length();
            int iPosition = byteBuffer.position();
            int i5 = 0;
            while (i5 < length) {
                try {
                    char cCharAt = str.charAt(i5);
                    if (cCharAt >= 128) {
                        break;
                    }
                    byteBuffer.put(iPosition + i5, (byte) cCharAt);
                    i5++;
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            if (i5 == length) {
                Java8Compatibility.position(byteBuffer, iPosition + i5);
                return;
            }
            iPosition += i5;
            while (i5 < length) {
                char cCharAt2 = str.charAt(i5);
                if (cCharAt2 < 128) {
                    byteBuffer.put(iPosition, (byte) cCharAt2);
                } else if (cCharAt2 < 2048) {
                    int i6 = iPosition + 1;
                    try {
                        byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> 6) | 192));
                        byteBuffer.put(i6, (byte) ((cCharAt2 & '?') | 128));
                        iPosition = i6;
                    } catch (IndexOutOfBoundsException unused2) {
                        iPosition = i6;
                    }
                } else {
                    if (cCharAt2 >= 55296 && 57343 >= cCharAt2) {
                        int i7 = i5 + 1;
                        if (i7 != length) {
                            try {
                                char cCharAt3 = str.charAt(i7);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    int i8 = iPosition + 1;
                                    try {
                                        byteBuffer.put(iPosition, (byte) ((codePoint >>> 18) | 240));
                                        int i9 = iPosition + 2;
                                        try {
                                            byteBuffer.put(i8, (byte) (((codePoint >>> 12) & 63) | 128));
                                            iPosition += 3;
                                            byteBuffer.put(i9, (byte) (((codePoint >>> 6) & 63) | 128));
                                            byteBuffer.put(iPosition, (byte) ((codePoint & 63) | 128));
                                            i5 = i7;
                                        } catch (IndexOutOfBoundsException unused3) {
                                            i5 = i7;
                                            iPosition = i9;
                                        }
                                    } catch (IndexOutOfBoundsException unused4) {
                                        iPosition = i8;
                                        i5 = i7;
                                    }
                                } else {
                                    i5 = i7;
                                }
                            } catch (IndexOutOfBoundsException unused5) {
                            }
                            i5 = i7;
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(i5) + " at index " + (Math.max(i5, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position()));
                        }
                        throw new UnpairedSurrogateException(i5, length);
                    }
                    int i10 = iPosition + 1;
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> '\f') | 224));
                    iPosition += 2;
                    byteBuffer.put(i10, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 & '?') | 128));
                }
                i5++;
                iPosition++;
            }
            Java8Compatibility.position(byteBuffer, iPosition);
        }

        public abstract void encodeUtf8Direct(String str, ByteBuffer byteBuffer);

        public final boolean isValidUtf8(byte[] bArr, int i5, int i6) {
            return partialIsValidUtf8(0, bArr, i5, i6) == 0;
        }

        public final int partialIsValidUtf8(int i5, ByteBuffer byteBuffer, int i6, int i7) {
            if (!byteBuffer.hasArray()) {
                return byteBuffer.isDirect() ? partialIsValidUtf8Direct(i5, byteBuffer, i6, i7) : partialIsValidUtf8Default(i5, byteBuffer, i6, i7);
            }
            int iArrayOffset = byteBuffer.arrayOffset();
            return partialIsValidUtf8(i5, byteBuffer.array(), i6 + iArrayOffset, iArrayOffset + i7);
        }

        public abstract int partialIsValidUtf8(int i5, byte[] bArr, int i6, int i7);

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            if (r8.get(r9) > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
        
            if (r8.get(r9) > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008f, code lost:
        
            if (r8.get(r7) > (-65)) goto L53;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int partialIsValidUtf8Default(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L92
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1e
                r7 = -62
                if (r0 < r7) goto L1d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
                goto L1d
            L1a:
                r9 = r7
                goto L92
            L1d:
                return r2
            L1e:
                r4 = -16
                if (r0 >= r4) goto L4f
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L38
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L35
                int r7 = androidx.datastore.preferences.protobuf.Utf8.access$000(r0, r9)
                return r7
            L35:
                r5 = r9
                r9 = r7
                r7 = r5
            L38:
                if (r7 > r3) goto L4e
                r4 = -96
                if (r0 != r1) goto L40
                if (r7 < r4) goto L4e
            L40:
                r1 = -19
                if (r0 != r1) goto L46
                if (r7 >= r4) goto L4e
            L46:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
            L4e:
                return r2
            L4f:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L64
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L62
                int r7 = androidx.datastore.preferences.protobuf.Utf8.access$000(r0, r1)
                return r7
            L62:
                r9 = 0
                goto L6a
            L64:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L6a:
                if (r9 != 0) goto L7c
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r9 < r10) goto L79
                int r7 = androidx.datastore.preferences.protobuf.Utf8.access$100(r0, r1, r7)
                return r7
            L79:
                r5 = r9
                r9 = r7
                r7 = r5
            L7c:
                if (r1 > r3) goto L91
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L91
                if (r9 > r3) goto L91
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r7 <= r3) goto L92
            L91:
                return r2
            L92:
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.Processor.partialIsValidUtf8Default(int, java.nio.ByteBuffer, int, int):int");
        }

        public abstract int partialIsValidUtf8Direct(int i5, ByteBuffer byteBuffer, int i6, int i7);

        public final boolean isValidUtf8(ByteBuffer byteBuffer, int i5, int i6) {
            return partialIsValidUtf8(0, byteBuffer, i5, i6) == 0;
        }

        private static int partialIsValidUtf8(ByteBuffer byteBuffer, int i5, int i6) {
            int iEstimateConsecutiveAscii = i5 + Utf8.estimateConsecutiveAscii(byteBuffer, i5, i6);
            while (iEstimateConsecutiveAscii < i6) {
                int i7 = iEstimateConsecutiveAscii + 1;
                byte b = byteBuffer.get(iEstimateConsecutiveAscii);
                if (b >= 0) {
                    iEstimateConsecutiveAscii = i7;
                } else if (b < -32) {
                    if (i7 >= i6) {
                        return b;
                    }
                    if (b < -62 || byteBuffer.get(i7) > -65) {
                        return -1;
                    }
                    iEstimateConsecutiveAscii += 2;
                } else {
                    if (b >= -16) {
                        if (i7 >= i6 - 2) {
                            return Utf8.incompleteStateFor(byteBuffer, b, i7, i6 - i7);
                        }
                        int i8 = iEstimateConsecutiveAscii + 2;
                        byte b6 = byteBuffer.get(i7);
                        if (b6 <= -65) {
                            if ((((b6 + 112) + (b << Ascii.FS)) >> 30) == 0) {
                                int i9 = iEstimateConsecutiveAscii + 3;
                                if (byteBuffer.get(i8) <= -65) {
                                    iEstimateConsecutiveAscii += 4;
                                    if (byteBuffer.get(i9) > -65) {
                                    }
                                }
                            }
                        }
                        return -1;
                    }
                    if (i7 >= i6 - 1) {
                        return Utf8.incompleteStateFor(byteBuffer, b, i7, i6 - i7);
                    }
                    int i10 = iEstimateConsecutiveAscii + 2;
                    byte b7 = byteBuffer.get(i7);
                    if (b7 > -65 || ((b == -32 && b7 < -96) || ((b == -19 && b7 >= -96) || byteBuffer.get(i10) > -65))) {
                        return -1;
                    }
                    iEstimateConsecutiveAscii += 3;
                }
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i5, int i6) {
            super(a.h(i5, i6, "Unpaired surrogate at index ", " of "));
        }
    }

    static {
        processor = (!UnsafeProcessor.isAvailable() || Android.isOnAndroidDevice()) ? new SafeProcessor() : new UnsafeProcessor();
    }

    private Utf8() {
    }

    public static String decodeUtf8(ByteBuffer byteBuffer, int i5, int i6) {
        return processor.decodeUtf8(byteBuffer, i5, i6);
    }

    public static int encode(String str, byte[] bArr, int i5, int i6) {
        return processor.encodeUtf8(str, bArr, i5, i6);
    }

    public static void encodeUtf8(String str, ByteBuffer byteBuffer) {
        processor.encodeUtf8(str, byteBuffer);
    }

    public static int encodedLength(String str) {
        int length = str.length();
        int i5 = 0;
        while (i5 < length && str.charAt(i5) < 128) {
            i5++;
        }
        int iEncodedLengthGeneral = length;
        while (i5 < length) {
            char cCharAt = str.charAt(i5);
            if (cCharAt >= 2048) {
                iEncodedLengthGeneral += encodedLengthGeneral(str, i5);
                break;
            }
            iEncodedLengthGeneral += (127 - cCharAt) >>> 31;
            i5++;
        }
        if (iEncodedLengthGeneral >= length) {
            return iEncodedLengthGeneral;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iEncodedLengthGeneral) + 4294967296L));
    }

    private static int encodedLengthGeneral(String str, int i5) {
        int length = str.length();
        int i6 = 0;
        while (i5 < length) {
            char cCharAt = str.charAt(i5);
            if (cCharAt < 2048) {
                i6 += (127 - cCharAt) >>> 31;
            } else {
                i6 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(str, i5) < 65536) {
                        throw new UnpairedSurrogateException(i5, length);
                    }
                    i5++;
                }
            }
            i5++;
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int estimateConsecutiveAscii(ByteBuffer byteBuffer, int i5, int i6) {
        int i7 = i6 - 7;
        int i8 = i5;
        while (i8 < i7 && (byteBuffer.getLong(i8) & (-9187201950435737472L)) == 0) {
            i8 += 8;
        }
        return i8 - i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i5) {
        if (i5 > -12) {
            return -1;
        }
        return i5;
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return processor.isValidUtf8(bArr, 0, bArr.length);
    }

    public static int partialIsValidUtf8(int i5, byte[] bArr, int i6, int i7) {
        return processor.partialIsValidUtf8(i5, bArr, i6, i7);
    }

    public static String decodeUtf8(byte[] bArr, int i5, int i6) {
        return processor.decodeUtf8(bArr, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i5, int i6) {
        if (i5 > -12 || i6 > -65) {
            return -1;
        }
        return i5 ^ (i6 << 8);
    }

    public static boolean isValidUtf8(byte[] bArr, int i5, int i6) {
        return processor.isValidUtf8(bArr, i5, i6);
    }

    public static int partialIsValidUtf8(int i5, ByteBuffer byteBuffer, int i6, int i7) {
        return processor.partialIsValidUtf8(i5, byteBuffer, i6, i7);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class UnsafeProcessor extends Processor {
        public static boolean isAvailable() {
            return UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bArr, long j6, int i5) {
            int i6 = 0;
            if (i5 < 16) {
                return 0;
            }
            int i7 = 8 - (((int) j6) & 7);
            while (i6 < i7) {
                long j7 = 1 + j6;
                if (UnsafeUtil.getByte(bArr, j6) < 0) {
                    return i6;
                }
                i6++;
                j6 = j7;
            }
            while (true) {
                int i8 = i6 + 8;
                if (i8 > i5 || (UnsafeUtil.getLong((Object) bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j6) & (-9187201950435737472L)) != 0) {
                    break;
                }
                j6 += 8;
                i6 = i8;
            }
            while (i6 < i5) {
                long j8 = j6 + 1;
                if (UnsafeUtil.getByte(bArr, j6) < 0) {
                    return i6;
                }
                i6++;
                j6 = j8;
            }
            return i5;
        }

        private static int unsafeIncompleteStateFor(byte[] bArr, int i5, long j6, int i6) {
            if (i6 == 0) {
                return Utf8.incompleteStateFor(i5);
            }
            if (i6 == 1) {
                return Utf8.incompleteStateFor(i5, UnsafeUtil.getByte(bArr, j6));
            }
            if (i6 == 2) {
                return Utf8.incompleteStateFor(i5, UnsafeUtil.getByte(bArr, j6), UnsafeUtil.getByte(bArr, j6 + 1));
            }
            throw new AssertionError();
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] bArr, int i5, int i6) throws InvalidProtocolBufferException {
            Charset charset = Internal.UTF_8;
            String str = new String(bArr, i5, i6, charset);
            if (str.indexOf(65533) >= 0 && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i5, i6 + i5))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            return str;
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i5, int i6) throws InvalidProtocolBufferException {
            if ((i5 | i6 | ((byteBuffer.limit() - i5) - i6)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i5), Integer.valueOf(i6)));
            }
            long jAddressOffset = UnsafeUtil.addressOffset(byteBuffer) + ((long) i5);
            long j6 = ((long) i6) + jAddressOffset;
            char[] cArr = new char[i6];
            int i7 = 0;
            while (jAddressOffset < j6) {
                byte b = UnsafeUtil.getByte(jAddressOffset);
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                jAddressOffset++;
                DecodeUtil.handleOneByte(b, cArr, i7);
                i7++;
            }
            int i8 = i7;
            while (jAddressOffset < j6) {
                long j7 = jAddressOffset + 1;
                byte b6 = UnsafeUtil.getByte(jAddressOffset);
                if (DecodeUtil.isOneByte(b6)) {
                    int i9 = i8 + 1;
                    DecodeUtil.handleOneByte(b6, cArr, i8);
                    long j8 = j7;
                    while (j8 < j6) {
                        byte b7 = UnsafeUtil.getByte(j8);
                        if (!DecodeUtil.isOneByte(b7)) {
                            break;
                        }
                        j8++;
                        DecodeUtil.handleOneByte(b7, cArr, i9);
                        i9++;
                    }
                    i8 = i9;
                    jAddressOffset = j8;
                } else if (DecodeUtil.isTwoBytes(b6)) {
                    if (j7 >= j6) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    jAddressOffset += 2;
                    DecodeUtil.handleTwoBytes(b6, UnsafeUtil.getByte(j7), cArr, i8);
                    i8++;
                } else if (DecodeUtil.isThreeBytes(b6)) {
                    if (j7 >= j6 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    long j9 = 2 + jAddressOffset;
                    jAddressOffset += 3;
                    DecodeUtil.handleThreeBytes(b6, UnsafeUtil.getByte(j7), UnsafeUtil.getByte(j9), cArr, i8);
                    i8++;
                } else {
                    if (j7 >= j6 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b8 = UnsafeUtil.getByte(j7);
                    long j10 = jAddressOffset + 3;
                    byte b9 = UnsafeUtil.getByte(2 + jAddressOffset);
                    jAddressOffset += 4;
                    DecodeUtil.handleFourBytes(b6, b8, b9, UnsafeUtil.getByte(j10), cArr, i8);
                    i8 += 2;
                }
            }
            return new String(cArr, 0, i8);
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public int encodeUtf8(String str, byte[] bArr, int i5, int i6) {
            long j6;
            long j7;
            long j8;
            int i7;
            char cCharAt;
            long j9 = i5;
            long j10 = ((long) i6) + j9;
            int length = str.length();
            if (length > i6 || bArr.length - i6 < i5) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(length - 1) + " at index " + (i5 + i6));
            }
            int i8 = 0;
            while (true) {
                j6 = 1;
                if (i8 >= length || (cCharAt = str.charAt(i8)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(bArr, j9, (byte) cCharAt);
                i8++;
                j9 = 1 + j9;
            }
            if (i8 == length) {
                return (int) j9;
            }
            while (i8 < length) {
                char cCharAt2 = str.charAt(i8);
                if (cCharAt2 < 128 && j9 < j10) {
                    UnsafeUtil.putByte(bArr, j9, (byte) cCharAt2);
                    j8 = j10;
                    j7 = j6;
                    j9 += j6;
                } else if (cCharAt2 >= 2048 || j9 > j10 - 2) {
                    j7 = j6;
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j9 > j10 - 3) {
                        j8 = j10;
                        if (j9 > j8 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i7 = i8 + 1) == length || !Character.isSurrogatePair(cCharAt2, str.charAt(i7)))) {
                                throw new UnpairedSurrogateException(i8, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + j9);
                        }
                        int i9 = i8 + 1;
                        if (i9 != length) {
                            char cCharAt3 = str.charAt(i9);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                UnsafeUtil.putByte(bArr, j9, (byte) ((codePoint >>> 18) | 240));
                                UnsafeUtil.putByte(bArr, j9 + j7, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j11 = j9 + 3;
                                UnsafeUtil.putByte(bArr, j9 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                j9 += 4;
                                UnsafeUtil.putByte(bArr, j11, (byte) ((codePoint & 63) | 128));
                                i8 = i9;
                            } else {
                                i8 = i9;
                            }
                        }
                        throw new UnpairedSurrogateException(i8 - 1, length);
                    }
                    UnsafeUtil.putByte(bArr, j9, (byte) ((cCharAt2 >>> '\f') | Videoio.CAP_PROP_XI_CC_MATRIX_01));
                    long j12 = j9 + 2;
                    j8 = j10;
                    UnsafeUtil.putByte(bArr, j9 + j7, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    j9 += 3;
                    UnsafeUtil.putByte(bArr, j12, (byte) ((cCharAt2 & '?') | 128));
                } else {
                    j7 = j6;
                    long j13 = j9 + j7;
                    UnsafeUtil.putByte(bArr, j9, (byte) ((cCharAt2 >>> 6) | 960));
                    j9 += 2;
                    UnsafeUtil.putByte(bArr, j13, (byte) ((cCharAt2 & '?') | 128));
                    j8 = j10;
                }
                i8++;
                j6 = j7;
                j10 = j8;
            }
            return (int) j9;
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public void encodeUtf8Direct(String str, ByteBuffer byteBuffer) {
            long j6;
            char c;
            long j7;
            int i5;
            char c6;
            char cCharAt;
            long jAddressOffset = UnsafeUtil.addressOffset(byteBuffer);
            long jPosition = ((long) byteBuffer.position()) + jAddressOffset;
            long jLimit = ((long) byteBuffer.limit()) + jAddressOffset;
            int length = str.length();
            if (length > jLimit - jPosition) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(length - 1) + " at index " + byteBuffer.limit());
            }
            int i6 = 0;
            while (true) {
                j6 = 1;
                c = 128;
                if (i6 >= length || (cCharAt = str.charAt(i6)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(jPosition, (byte) cCharAt);
                i6++;
                jPosition = 1 + jPosition;
            }
            if (i6 == length) {
                Java8Compatibility.position(byteBuffer, (int) (jPosition - jAddressOffset));
                return;
            }
            while (i6 < length) {
                char cCharAt2 = str.charAt(i6);
                if (cCharAt2 >= c || jPosition >= jLimit) {
                    j7 = j6;
                    if (cCharAt2 < 2048 && jPosition <= jLimit - 2) {
                        long j8 = jPosition + j7;
                        UnsafeUtil.putByte(jPosition, (byte) ((cCharAt2 >>> 6) | 960));
                        jPosition += 2;
                        UnsafeUtil.putByte(j8, (byte) ((cCharAt2 & '?') | 128));
                    } else {
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || jPosition > jLimit - 3) {
                            jAddressOffset = jAddressOffset;
                            jLimit = jLimit;
                            if (jPosition > jLimit - 4) {
                                if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i5 = i6 + 1) == length || !Character.isSurrogatePair(cCharAt2, str.charAt(i5)))) {
                                    throw new UnpairedSurrogateException(i6, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + jPosition);
                            }
                            int i7 = i6 + 1;
                            if (i7 != length) {
                                char cCharAt3 = str.charAt(i7);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    UnsafeUtil.putByte(jPosition, (byte) ((codePoint >>> 18) | 240));
                                    c6 = 128;
                                    UnsafeUtil.putByte(jPosition + j7, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j9 = jPosition + 3;
                                    UnsafeUtil.putByte(jPosition + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    jPosition += 4;
                                    UnsafeUtil.putByte(j9, (byte) ((codePoint & 63) | 128));
                                    i6 = i7;
                                } else {
                                    i6 = i7;
                                }
                            }
                            throw new UnpairedSurrogateException(i6 - 1, length);
                        }
                        UnsafeUtil.putByte(jPosition, (byte) ((cCharAt2 >>> '\f') | Videoio.CAP_PROP_XI_CC_MATRIX_01));
                        long j10 = jPosition + 2;
                        UnsafeUtil.putByte(jPosition + j7, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                        jPosition += 3;
                        UnsafeUtil.putByte(j10, (byte) ((cCharAt2 & '?') | 128));
                    }
                    c6 = 128;
                } else {
                    UnsafeUtil.putByte(jPosition, (byte) cCharAt2);
                    jAddressOffset = jAddressOffset;
                    jLimit = jLimit;
                    c6 = c;
                    jPosition += j6;
                    j7 = j6;
                }
                i6++;
                c = c6;
                j6 = j7;
                jAddressOffset = jAddressOffset;
                jLimit = jLimit;
            }
            Java8Compatibility.position(byteBuffer, (int) (jPosition - jAddressOffset));
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0058, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r12, r0) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009e, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r12, r0) > (-65)) goto L59;
         */
        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int partialIsValidUtf8(int r11, byte[] r12, int r13, int r14) {
            /*
                r10 = this;
                r0 = r13 | r14
                int r1 = r12.length
                int r1 = r1 - r14
                r0 = r0 | r1
                if (r0 < 0) goto La8
                long r0 = (long) r13
                long r13 = (long) r14
                if (r11 == 0) goto La1
                int r2 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
                if (r2 < 0) goto L10
                return r11
            L10:
                byte r2 = (byte) r11
                r3 = -32
                r4 = -1
                r5 = -65
                r6 = 1
                if (r2 >= r3) goto L2a
                r11 = -62
                if (r2 < r11) goto L29
                long r6 = r6 + r0
                byte r11 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r12, r0)
                if (r11 <= r5) goto L26
                goto L29
            L26:
                r0 = r6
                goto La1
            L29:
                return r4
            L2a:
                r8 = -16
                if (r2 >= r8) goto L5e
                int r11 = r11 >> 8
                int r11 = ~r11
                byte r11 = (byte) r11
                if (r11 != 0) goto L44
                long r8 = r0 + r6
                byte r11 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r12, r0)
                int r0 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r0 < 0) goto L43
                int r11 = androidx.datastore.preferences.protobuf.Utf8.access$000(r2, r11)
                return r11
            L43:
                r0 = r8
            L44:
                if (r11 > r5) goto L5d
                r8 = -96
                if (r2 != r3) goto L4c
                if (r11 < r8) goto L5d
            L4c:
                r3 = -19
                if (r2 != r3) goto L52
                if (r11 >= r8) goto L5d
            L52:
                long r2 = r0 + r6
                byte r11 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r12, r0)
                if (r11 <= r5) goto L5b
                goto L5d
            L5b:
                r0 = r2
                goto La1
            L5d:
                return r4
            L5e:
                int r3 = r11 >> 8
                int r3 = ~r3
                byte r3 = (byte) r3
                if (r3 != 0) goto L76
                long r8 = r0 + r6
                byte r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r12, r0)
                int r11 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r11 < 0) goto L73
                int r11 = androidx.datastore.preferences.protobuf.Utf8.access$000(r2, r3)
                return r11
            L73:
                r11 = 0
                r0 = r8
                goto L79
            L76:
                int r11 = r11 >> 16
                byte r11 = (byte) r11
            L79:
                if (r11 != 0) goto L8b
                long r8 = r0 + r6
                byte r11 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r12, r0)
                int r0 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r0 < 0) goto L8a
                int r11 = androidx.datastore.preferences.protobuf.Utf8.access$100(r2, r3, r11)
                return r11
            L8a:
                r0 = r8
            L8b:
                if (r3 > r5) goto La0
                int r2 = r2 << 28
                int r3 = r3 + 112
                int r3 = r3 + r2
                int r2 = r3 >> 30
                if (r2 != 0) goto La0
                if (r11 > r5) goto La0
                long r2 = r0 + r6
                byte r11 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r12, r0)
                if (r11 <= r5) goto L5b
            La0:
                return r4
            La1:
                long r13 = r13 - r0
                int r11 = (int) r13
                int r11 = partialIsValidUtf8(r12, r0, r11)
                return r11
            La8:
                java.lang.ArrayIndexOutOfBoundsException r11 = new java.lang.ArrayIndexOutOfBoundsException
                int r12 = r12.length
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                java.lang.Object[] r12 = new java.lang.Object[]{r12, r13, r14}
                java.lang.String r13 = "Array length=%d, index=%d, limit=%d"
                java.lang.String r12 = java.lang.String.format(r13, r12)
                r11.<init>(r12)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r0) > (-65)) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0061, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r0) > (-65)) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a3, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r0) > (-65)) goto L57;
         */
        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int partialIsValidUtf8Direct(int r10, java.nio.ByteBuffer r11, int r12, int r13) {
            /*
                Method dump skipped, instruction units count: 205
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8Direct(int, java.nio.ByteBuffer, int, int):int");
        }

        private static int unsafeEstimateConsecutiveAscii(long j6, int i5) {
            if (i5 < 16) {
                return 0;
            }
            int i6 = (int) ((-j6) & 7);
            int i7 = i6;
            while (i7 > 0) {
                long j7 = 1 + j6;
                if (UnsafeUtil.getByte(j6) < 0) {
                    return i6 - i7;
                }
                i7--;
                j6 = j7;
            }
            int i8 = i5 - i6;
            while (i8 >= 8 && (UnsafeUtil.getLong(j6) & (-9187201950435737472L)) == 0) {
                j6 += 8;
                i8 -= 8;
            }
            return i5 - i8;
        }

        private static int unsafeIncompleteStateFor(long j6, int i5, int i6) {
            if (i6 == 0) {
                return Utf8.incompleteStateFor(i5);
            }
            if (i6 == 1) {
                return Utf8.incompleteStateFor(i5, UnsafeUtil.getByte(j6));
            }
            if (i6 == 2) {
                return Utf8.incompleteStateFor(i5, UnsafeUtil.getByte(j6), UnsafeUtil.getByte(j6 + 1));
            }
            throw new AssertionError();
        }

        private static int partialIsValidUtf8(byte[] bArr, long j6, int i5) {
            int iUnsafeEstimateConsecutiveAscii = unsafeEstimateConsecutiveAscii(bArr, j6, i5);
            int i6 = i5 - iUnsafeEstimateConsecutiveAscii;
            long j7 = j6 + ((long) iUnsafeEstimateConsecutiveAscii);
            while (true) {
                byte b = 0;
                while (i6 > 0) {
                    long j8 = j7 + 1;
                    b = UnsafeUtil.getByte(bArr, j7);
                    if (b < 0) {
                        j7 = j8;
                        break;
                    }
                    i6--;
                    j7 = j8;
                }
                if (i6 == 0) {
                    return 0;
                }
                int i7 = i6 - 1;
                if (b < -32) {
                    if (i7 == 0) {
                        return b;
                    }
                    i6 -= 2;
                    if (b >= -62) {
                        long j9 = 1 + j7;
                        if (UnsafeUtil.getByte(bArr, j7) <= -65) {
                            j7 = j9;
                        }
                    }
                    return -1;
                }
                if (b < -16) {
                    if (i7 < 2) {
                        return unsafeIncompleteStateFor(bArr, b, j7, i7);
                    }
                    i6 -= 3;
                    long j10 = 1 + j7;
                    byte b6 = UnsafeUtil.getByte(bArr, j7);
                    if (b6 <= -65 && ((b != -32 || b6 >= -96) && (b != -19 || b6 < -96))) {
                        j7 += 2;
                        if (UnsafeUtil.getByte(bArr, j10) > -65) {
                        }
                    }
                    return -1;
                }
                if (i7 < 3) {
                    return unsafeIncompleteStateFor(bArr, b, j7, i7);
                }
                i6 -= 4;
                long j11 = 1 + j7;
                byte b7 = UnsafeUtil.getByte(bArr, j7);
                if (b7 <= -65) {
                    if ((((b7 + 112) + (b << Ascii.FS)) >> 30) == 0) {
                        long j12 = 2 + j7;
                        if (UnsafeUtil.getByte(bArr, j11) <= -65) {
                            j7 += 3;
                            if (UnsafeUtil.getByte(bArr, j12) > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
        }

        private static int partialIsValidUtf8(long j6, int i5) {
            int iUnsafeEstimateConsecutiveAscii = unsafeEstimateConsecutiveAscii(j6, i5);
            long j7 = j6 + ((long) iUnsafeEstimateConsecutiveAscii);
            int i6 = i5 - iUnsafeEstimateConsecutiveAscii;
            while (true) {
                byte b = 0;
                while (i6 > 0) {
                    long j8 = j7 + 1;
                    b = UnsafeUtil.getByte(j7);
                    if (b < 0) {
                        j7 = j8;
                        break;
                    }
                    i6--;
                    j7 = j8;
                }
                if (i6 == 0) {
                    return 0;
                }
                int i7 = i6 - 1;
                if (b < -32) {
                    if (i7 == 0) {
                        return b;
                    }
                    i6 -= 2;
                    if (b >= -62) {
                        long j9 = 1 + j7;
                        if (UnsafeUtil.getByte(j7) <= -65) {
                            j7 = j9;
                        }
                    }
                    return -1;
                }
                if (b < -16) {
                    if (i7 < 2) {
                        return unsafeIncompleteStateFor(j7, b, i7);
                    }
                    i6 -= 3;
                    long j10 = 1 + j7;
                    byte b6 = UnsafeUtil.getByte(j7);
                    if (b6 <= -65 && ((b != -32 || b6 >= -96) && (b != -19 || b6 < -96))) {
                        j7 += 2;
                        if (UnsafeUtil.getByte(j10) > -65) {
                        }
                    }
                    return -1;
                }
                if (i7 < 3) {
                    return unsafeIncompleteStateFor(j7, b, i7);
                }
                i6 -= 4;
                long j11 = 1 + j7;
                byte b7 = UnsafeUtil.getByte(j7);
                if (b7 <= -65) {
                    if ((((b7 + 112) + (b << Ascii.FS)) >> 30) == 0) {
                        long j12 = 2 + j7;
                        if (UnsafeUtil.getByte(j11) <= -65) {
                            j7 += 3;
                            if (UnsafeUtil.getByte(j12) > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i5, int i6, int i7) {
        if (i5 > -12 || i6 > -65 || i7 > -65) {
            return -1;
        }
        return (i5 ^ (i6 << 8)) ^ (i7 << 16);
    }

    public static boolean isValidUtf8(ByteBuffer byteBuffer) {
        return processor.isValidUtf8(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bArr, int i5, int i6) {
        byte b = bArr[i5 - 1];
        int i7 = i6 - i5;
        if (i7 == 0) {
            return incompleteStateFor(b);
        }
        if (i7 == 1) {
            return incompleteStateFor(b, bArr[i5]);
        }
        if (i7 == 2) {
            return incompleteStateFor(b, bArr[i5], bArr[i5 + 1]);
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(ByteBuffer byteBuffer, int i5, int i6, int i7) {
        if (i7 == 0) {
            return incompleteStateFor(i5);
        }
        if (i7 == 1) {
            return incompleteStateFor(i5, byteBuffer.get(i6));
        }
        if (i7 == 2) {
            return incompleteStateFor(i5, byteBuffer.get(i6), byteBuffer.get(i6 + 1));
        }
        throw new AssertionError();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SafeProcessor extends Processor {
        private static int partialIsValidUtf8NonAscii(byte[] bArr, int i5, int i6) {
            while (i5 < i6) {
                int i7 = i5 + 1;
                byte b = bArr[i5];
                if (b < 0) {
                    if (b < -32) {
                        if (i7 >= i6) {
                            return b;
                        }
                        if (b >= -62) {
                            i5 += 2;
                            if (bArr[i7] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b < -16) {
                        if (i7 >= i6 - 1) {
                            return Utf8.incompleteStateFor(bArr, i7, i6);
                        }
                        int i8 = i5 + 2;
                        byte b6 = bArr[i7];
                        if (b6 <= -65 && ((b != -32 || b6 >= -96) && (b != -19 || b6 < -96))) {
                            i5 += 3;
                            if (bArr[i8] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i7 >= i6 - 2) {
                        return Utf8.incompleteStateFor(bArr, i7, i6);
                    }
                    int i9 = i5 + 2;
                    byte b7 = bArr[i7];
                    if (b7 <= -65) {
                        if ((((b7 + 112) + (b << Ascii.FS)) >> 30) == 0) {
                            int i10 = i5 + 3;
                            if (bArr[i9] <= -65) {
                                i5 += 4;
                                if (bArr[i10] > -65) {
                                }
                            }
                        }
                    }
                    return -1;
                }
                i5 = i7;
            }
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] bArr, int i5, int i6) throws InvalidProtocolBufferException {
            if ((i5 | i6 | ((bArr.length - i5) - i6)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)));
            }
            int i7 = i5 + i6;
            char[] cArr = new char[i6];
            int i8 = 0;
            while (i5 < i7) {
                byte b = bArr[i5];
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                i5++;
                DecodeUtil.handleOneByte(b, cArr, i8);
                i8++;
            }
            int i9 = i8;
            while (i5 < i7) {
                int i10 = i5 + 1;
                byte b6 = bArr[i5];
                if (DecodeUtil.isOneByte(b6)) {
                    int i11 = i9 + 1;
                    DecodeUtil.handleOneByte(b6, cArr, i9);
                    int i12 = i10;
                    while (i12 < i7) {
                        byte b7 = bArr[i12];
                        if (!DecodeUtil.isOneByte(b7)) {
                            break;
                        }
                        i12++;
                        DecodeUtil.handleOneByte(b7, cArr, i11);
                        i11++;
                    }
                    i9 = i11;
                    i5 = i12;
                } else if (DecodeUtil.isTwoBytes(b6)) {
                    if (i10 >= i7) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i5 += 2;
                    DecodeUtil.handleTwoBytes(b6, bArr[i10], cArr, i9);
                    i9++;
                } else if (DecodeUtil.isThreeBytes(b6)) {
                    if (i10 >= i7 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i13 = i5 + 2;
                    i5 += 3;
                    DecodeUtil.handleThreeBytes(b6, bArr[i10], bArr[i13], cArr, i9);
                    i9++;
                } else {
                    if (i10 >= i7 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b8 = bArr[i10];
                    int i14 = i5 + 3;
                    byte b9 = bArr[i5 + 2];
                    i5 += 4;
                    DecodeUtil.handleFourBytes(b6, b8, b9, bArr[i14], cArr, i9);
                    i9 += 2;
                }
            }
            return new String(cArr, 0, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i5, int i6) {
            return decodeUtf8Default(byteBuffer, i5, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public int encodeUtf8(String str, byte[] bArr, int i5, int i6) {
            int i7;
            int i8;
            char cCharAt;
            int length = str.length();
            int i9 = i6 + i5;
            int i10 = 0;
            while (i10 < length && (i8 = i10 + i5) < i9 && (cCharAt = str.charAt(i10)) < 128) {
                bArr[i8] = (byte) cCharAt;
                i10++;
            }
            if (i10 == length) {
                return i5 + length;
            }
            int i11 = i5 + i10;
            while (i10 < length) {
                char cCharAt2 = str.charAt(i10);
                if (cCharAt2 < 128 && i11 < i9) {
                    bArr[i11] = (byte) cCharAt2;
                    i11++;
                } else if (cCharAt2 < 2048 && i11 <= i9 - 2) {
                    int i12 = i11 + 1;
                    bArr[i11] = (byte) ((cCharAt2 >>> 6) | 960);
                    i11 += 2;
                    bArr[i12] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i11 > i9 - 3) {
                        if (i11 > i9 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i7 = i10 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i7)))) {
                                throw new UnpairedSurrogateException(i10, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i11);
                        }
                        int i13 = i10 + 1;
                        if (i13 != str.length()) {
                            char cCharAt3 = str.charAt(i13);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                bArr[i11] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i11 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i14 = i11 + 3;
                                bArr[i11 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i11 += 4;
                                bArr[i14] = (byte) ((codePoint & 63) | 128);
                                i10 = i13;
                            } else {
                                i10 = i13;
                            }
                        }
                        throw new UnpairedSurrogateException(i10 - 1, length);
                    }
                    bArr[i11] = (byte) ((cCharAt2 >>> '\f') | Videoio.CAP_PROP_XI_CC_MATRIX_01);
                    int i15 = i11 + 2;
                    bArr[i11 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i11 += 3;
                    bArr[i15] = (byte) ((cCharAt2 & '?') | 128);
                }
                i10++;
            }
            return i11;
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public void encodeUtf8Direct(String str, ByteBuffer byteBuffer) {
            encodeUtf8Default(str, byteBuffer);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r8[r9] > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
        
            if (r8[r9] > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0083, code lost:
        
            if (r8[r7] > (-65)) goto L53;
         */
        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int partialIsValidUtf8(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L86
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1c
                r7 = -62
                if (r0 < r7) goto L1b
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
                goto L1b
            L18:
                r9 = r7
                goto L86
            L1b:
                return r2
            L1c:
                r4 = -16
                if (r0 >= r4) goto L49
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L34
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r7 < r10) goto L31
                int r7 = androidx.datastore.preferences.protobuf.Utf8.access$000(r0, r9)
                return r7
            L31:
                r5 = r9
                r9 = r7
                r7 = r5
            L34:
                if (r7 > r3) goto L48
                r4 = -96
                if (r0 != r1) goto L3c
                if (r7 < r4) goto L48
            L3c:
                r1 = -19
                if (r0 != r1) goto L42
                if (r7 >= r4) goto L48
            L42:
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
            L48:
                return r2
            L49:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L5c
                int r7 = r9 + 1
                r1 = r8[r9]
                if (r7 < r10) goto L5a
                int r7 = androidx.datastore.preferences.protobuf.Utf8.access$000(r0, r1)
                return r7
            L5a:
                r9 = 0
                goto L62
            L5c:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L62:
                if (r9 != 0) goto L72
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r9 < r10) goto L6f
                int r7 = androidx.datastore.preferences.protobuf.Utf8.access$100(r0, r1, r7)
                return r7
            L6f:
                r5 = r9
                r9 = r7
                r7 = r5
            L72:
                if (r1 > r3) goto L85
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L85
                if (r9 > r3) goto L85
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r7 <= r3) goto L86
            L85:
                return r2
            L86:
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.SafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public int partialIsValidUtf8Direct(int i5, ByteBuffer byteBuffer, int i6, int i7) {
            return partialIsValidUtf8Default(i5, byteBuffer, i6, i7);
        }

        private static int partialIsValidUtf8(byte[] bArr, int i5, int i6) {
            while (i5 < i6 && bArr[i5] >= 0) {
                i5++;
            }
            if (i5 >= i6) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bArr, i5, i6);
        }
    }
}
