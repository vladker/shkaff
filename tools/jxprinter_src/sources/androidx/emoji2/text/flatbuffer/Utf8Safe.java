package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class Utf8Safe extends Utf8 {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i5, int i6) {
            super(androidx.collection.a.h(i5, i6, "Unpaired surrogate at index ", " of "));
        }
    }

    private static int computeEncodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i5 = 0;
        while (i5 < length && charSequence.charAt(i5) < 128) {
            i5++;
        }
        int iEncodedLengthGeneral = length;
        while (i5 < length) {
            char cCharAt = charSequence.charAt(i5);
            if (cCharAt >= 2048) {
                iEncodedLengthGeneral += encodedLengthGeneral(charSequence, i5);
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

    public static String decodeUtf8Array(byte[] bArr, int i5, int i6) {
        if ((i5 | i6 | ((bArr.length - i5) - i6)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)));
        }
        int i7 = i5 + i6;
        char[] cArr = new char[i6];
        int i8 = 0;
        while (i5 < i7) {
            byte b = bArr[i5];
            if (!Utf8.DecodeUtil.isOneByte(b)) {
                break;
            }
            i5++;
            Utf8.DecodeUtil.handleOneByte(b, cArr, i8);
            i8++;
        }
        int i9 = i8;
        while (i5 < i7) {
            int i10 = i5 + 1;
            byte b6 = bArr[i5];
            if (Utf8.DecodeUtil.isOneByte(b6)) {
                int i11 = i9 + 1;
                Utf8.DecodeUtil.handleOneByte(b6, cArr, i9);
                int i12 = i10;
                while (i12 < i7) {
                    byte b7 = bArr[i12];
                    if (!Utf8.DecodeUtil.isOneByte(b7)) {
                        break;
                    }
                    i12++;
                    Utf8.DecodeUtil.handleOneByte(b7, cArr, i11);
                    i11++;
                }
                i9 = i11;
                i5 = i12;
            } else if (Utf8.DecodeUtil.isTwoBytes(b6)) {
                if (i10 >= i7) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                i5 += 2;
                Utf8.DecodeUtil.handleTwoBytes(b6, bArr[i10], cArr, i9);
                i9++;
            } else if (Utf8.DecodeUtil.isThreeBytes(b6)) {
                if (i10 >= i7 - 1) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i13 = i5 + 2;
                i5 += 3;
                Utf8.DecodeUtil.handleThreeBytes(b6, bArr[i10], bArr[i13], cArr, i9);
                i9++;
            } else {
                if (i10 >= i7 - 2) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                byte b8 = bArr[i10];
                int i14 = i5 + 3;
                byte b9 = bArr[i5 + 2];
                i5 += 4;
                Utf8.DecodeUtil.handleFourBytes(b6, b8, b9, bArr[i14], cArr, i9);
                i9 += 2;
            }
        }
        return new String(cArr, 0, i9);
    }

    public static String decodeUtf8Buffer(ByteBuffer byteBuffer, int i5, int i6) {
        if ((i5 | i6 | ((byteBuffer.limit() - i5) - i6)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i5), Integer.valueOf(i6)));
        }
        int i7 = i5 + i6;
        char[] cArr = new char[i6];
        int i8 = 0;
        while (i5 < i7) {
            byte b = byteBuffer.get(i5);
            if (!Utf8.DecodeUtil.isOneByte(b)) {
                break;
            }
            i5++;
            Utf8.DecodeUtil.handleOneByte(b, cArr, i8);
            i8++;
        }
        int i9 = i8;
        while (i5 < i7) {
            int i10 = i5 + 1;
            byte b6 = byteBuffer.get(i5);
            if (Utf8.DecodeUtil.isOneByte(b6)) {
                int i11 = i9 + 1;
                Utf8.DecodeUtil.handleOneByte(b6, cArr, i9);
                int i12 = i10;
                while (i12 < i7) {
                    byte b7 = byteBuffer.get(i12);
                    if (!Utf8.DecodeUtil.isOneByte(b7)) {
                        break;
                    }
                    i12++;
                    Utf8.DecodeUtil.handleOneByte(b7, cArr, i11);
                    i11++;
                }
                i9 = i11;
                i5 = i12;
            } else if (Utf8.DecodeUtil.isTwoBytes(b6)) {
                if (i10 >= i7) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                i5 += 2;
                Utf8.DecodeUtil.handleTwoBytes(b6, byteBuffer.get(i10), cArr, i9);
                i9++;
            } else if (Utf8.DecodeUtil.isThreeBytes(b6)) {
                if (i10 >= i7 - 1) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i13 = i5 + 2;
                i5 += 3;
                Utf8.DecodeUtil.handleThreeBytes(b6, byteBuffer.get(i10), byteBuffer.get(i13), cArr, i9);
                i9++;
            } else {
                if (i10 >= i7 - 2) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                byte b8 = byteBuffer.get(i10);
                int i14 = i5 + 3;
                byte b9 = byteBuffer.get(i5 + 2);
                i5 += 4;
                Utf8.DecodeUtil.handleFourBytes(b6, b8, b9, byteBuffer.get(i14), cArr, i9);
                i9 += 2;
            }
        }
        return new String(cArr, 0, i9);
    }

    private static int encodeUtf8Array(CharSequence charSequence, byte[] bArr, int i5, int i6) {
        int i7;
        int i8;
        char cCharAt;
        int length = charSequence.length();
        int i9 = i6 + i5;
        int i10 = 0;
        while (i10 < length && (i8 = i10 + i5) < i9 && (cCharAt = charSequence.charAt(i10)) < 128) {
            bArr[i8] = (byte) cCharAt;
            i10++;
        }
        if (i10 == length) {
            return i5 + length;
        }
        int i11 = i5 + i10;
        while (i10 < length) {
            char cCharAt2 = charSequence.charAt(i10);
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
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i7 = i10 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i7)))) {
                            throw new UnpairedSurrogateException(i10, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i11);
                    }
                    int i13 = i10 + 1;
                    if (i13 != charSequence.length()) {
                        char cCharAt3 = charSequence.charAt(i13);
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

    private static void encodeUtf8Buffer(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int iPosition = byteBuffer.position();
        int i5 = 0;
        while (i5 < length) {
            try {
                char cCharAt = charSequence.charAt(i5);
                if (cCharAt >= 128) {
                    break;
                }
                byteBuffer.put(iPosition + i5, (byte) cCharAt);
                i5++;
            } catch (IndexOutOfBoundsException unused) {
            }
        }
        if (i5 == length) {
            byteBuffer.position(iPosition + i5);
            return;
        }
        iPosition += i5;
        while (i5 < length) {
            char cCharAt2 = charSequence.charAt(i5);
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
                            char cCharAt3 = charSequence.charAt(i7);
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
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i5) + " at index " + (Math.max(i5, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position()));
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
        byteBuffer.position(iPosition);
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        int i6 = 0;
        while (i5 < length) {
            char cCharAt = charSequence.charAt(i5);
            if (cCharAt < 2048) {
                i6 += (127 - cCharAt) >>> 31;
            } else {
                i6 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i5) < 65536) {
                        throw new UnpairedSurrogateException(i5, length);
                    }
                    i5++;
                }
            }
            i5++;
        }
        return i6;
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer byteBuffer, int i5, int i6) {
        return byteBuffer.hasArray() ? decodeUtf8Array(byteBuffer.array(), byteBuffer.arrayOffset() + i5, i6) : decodeUtf8Buffer(byteBuffer, i5, i6);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            encodeUtf8Buffer(charSequence, byteBuffer);
        } else {
            int iArrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(encodeUtf8Array(charSequence, byteBuffer.array(), byteBuffer.position() + iArrayOffset, byteBuffer.remaining()) - iArrayOffset);
        }
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence charSequence) {
        return computeEncodedLength(charSequence);
    }
}
