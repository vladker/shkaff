package org.apache.commons.codec.binary;

import A3.AbstractC0157z;
import com.google.common.base.Ascii;
import java.math.BigInteger;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.poi.hssf.record.PaletteRecord;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.AreaErrPtg;
import org.apache.poi.ss.formula.ptg.DeletedArea3DPtg;
import org.apache.poi.ss.formula.ptg.DeletedRef3DPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.Ref3DPtg;
import org.apache.poi.ss.formula.ptg.RefErrorPtg;
import org.apache.poi.ss.formula.ptg.RefNPtg;
import org.apache.poi.ss.formula.ptg.RefPtg;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Base64 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 6;
    private static final int BYTES_PER_ENCODED_BLOCK = 4;
    private static final int BYTES_PER_UNENCODED_BLOCK = 3;
    private static final int MASK_2BITS = 3;
    private static final int MASK_4BITS = 15;
    private static final int MASK_6BITS = 63;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;
    private static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, 98, 99, 100, 101, 102, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, PaletteRecord.STANDARD_PALETTE_SIZE, 57, AreaErrPtg.sid, 47};
    private static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, 98, 99, 100, 101, 102, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, PaletteRecord.STANDARD_PALETTE_SIZE, 57, 45, 95};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, PaletteRecord.STANDARD_PALETTE_SIZE, 57, Ref3DPtg.sid, Area3DPtg.sid, DeletedRef3DPtg.sid, DeletedArea3DPtg.sid, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, Ascii.CAN, 25, -1, -1, -1, -1, 63, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, 29, 30, 31, 32, 33, 34, 35, RefPtg.sid, 37, 38, 39, 40, MemFuncPtg.sid, RefErrorPtg.sid, AreaErrPtg.sid, RefNPtg.sid, 45, 46, 47, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR};

    public Base64() {
        this(0);
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return new Base64().decode(bArr);
    }

    public static BigInteger decodeInteger(byte[] bArr) {
        return new BigInteger(1, decodeBase64(bArr));
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public static String encodeBase64String(byte[] bArr) {
        return StringUtils.newStringUsAscii(encodeBase64(bArr, false));
    }

    public static byte[] encodeBase64URLSafe(byte[] bArr) {
        return encodeBase64(bArr, false, true);
    }

    public static String encodeBase64URLSafeString(byte[] bArr) {
        return StringUtils.newStringUsAscii(encodeBase64(bArr, false, true));
    }

    public static byte[] encodeInteger(BigInteger bigInteger) {
        Objects.requireNonNull(bigInteger, "bigInteger");
        return encodeBase64(toIntegerBytes(bigInteger), false);
    }

    @Deprecated
    public static boolean isArrayByteBase64(byte[] bArr) {
        return isBase64(bArr);
    }

    public static boolean isBase64(byte b) {
        if (b == 61) {
            return true;
        }
        if (b < 0) {
            return false;
        }
        byte[] bArr = DECODE_TABLE;
        return b < bArr.length && bArr[b] != -1;
    }

    public static byte[] toIntegerBytes(BigInteger bigInteger) {
        int iBitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i5 = 1;
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == iBitLength / 8) {
            return byteArray;
        }
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
        } else {
            i5 = 0;
        }
        int i6 = iBitLength / 8;
        int i7 = i6 - length;
        byte[] bArr = new byte[i6];
        System.arraycopy(byteArray, i5, bArr, i7, length);
        return bArr;
    }

    private void validateCharacter(int i5, BaseNCodec.Context context) {
        if (isStrictDecoding() && (i5 & context.ibitWorkArea) != 0) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.");
        }
    }

    private void validateTrailingCharacter() {
        if (isStrictDecoding()) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Decoding requires at least two trailing 6-bit characters to create bytes.");
        }
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void decode(byte[] bArr, int i5, int i6, BaseNCodec.Context context) {
        byte b;
        if (context.eof) {
            return;
        }
        if (i6 < 0) {
            context.eof = true;
        }
        int i7 = 0;
        while (i7 < i6) {
            byte[] bArrEnsureBufferSize = ensureBufferSize(this.decodeSize, context);
            int i8 = i5 + 1;
            byte b6 = bArr[i5];
            if (b6 == this.pad) {
                context.eof = true;
                break;
            }
            if (b6 >= 0) {
                byte[] bArr2 = DECODE_TABLE;
                if (b6 < bArr2.length && (b = bArr2[b6]) >= 0) {
                    int i9 = (context.modulus + 1) % 4;
                    context.modulus = i9;
                    int i10 = (context.ibitWorkArea << 6) + b;
                    context.ibitWorkArea = i10;
                    if (i9 == 0) {
                        int i11 = context.pos;
                        int i12 = i11 + 1;
                        context.pos = i12;
                        bArrEnsureBufferSize[i11] = (byte) ((i10 >> 16) & 255);
                        int i13 = i11 + 2;
                        context.pos = i13;
                        bArrEnsureBufferSize[i12] = (byte) ((i10 >> 8) & 255);
                        context.pos = i11 + 3;
                        bArrEnsureBufferSize[i13] = (byte) (i10 & 255);
                    }
                }
            }
            i7++;
            i5 = i8;
        }
        if (!context.eof || context.modulus == 0) {
            return;
        }
        byte[] bArrEnsureBufferSize2 = ensureBufferSize(this.decodeSize, context);
        int i14 = context.modulus;
        if (i14 == 1) {
            validateTrailingCharacter();
            return;
        }
        if (i14 == 2) {
            validateCharacter(15, context);
            int i15 = context.ibitWorkArea >> 4;
            context.ibitWorkArea = i15;
            int i16 = context.pos;
            context.pos = i16 + 1;
            bArrEnsureBufferSize2[i16] = (byte) (i15 & 255);
            return;
        }
        if (i14 != 3) {
            throw new IllegalStateException("Impossible modulus " + context.modulus);
        }
        validateCharacter(3, context);
        int i17 = context.ibitWorkArea;
        int i18 = i17 >> 2;
        context.ibitWorkArea = i18;
        int i19 = context.pos;
        int i20 = i19 + 1;
        context.pos = i20;
        bArrEnsureBufferSize2[i19] = (byte) ((i17 >> 10) & 255);
        context.pos = i19 + 2;
        bArrEnsureBufferSize2[i20] = (byte) (i18 & 255);
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void encode(byte[] bArr, int i5, int i6, BaseNCodec.Context context) {
        if (context.eof) {
            return;
        }
        if (i6 >= 0) {
            int i7 = 0;
            while (i7 < i6) {
                byte[] bArrEnsureBufferSize = ensureBufferSize(this.encodeSize, context);
                int i8 = (context.modulus + 1) % 3;
                context.modulus = i8;
                int i9 = i5 + 1;
                int i10 = bArr[i5];
                if (i10 < 0) {
                    i10 += 256;
                }
                int i11 = (context.ibitWorkArea << 8) + i10;
                context.ibitWorkArea = i11;
                if (i8 == 0) {
                    int i12 = context.pos;
                    int i13 = i12 + 1;
                    context.pos = i13;
                    byte[] bArr2 = this.encodeTable;
                    bArrEnsureBufferSize[i12] = bArr2[(i11 >> 18) & 63];
                    int i14 = i12 + 2;
                    context.pos = i14;
                    bArrEnsureBufferSize[i13] = bArr2[(i11 >> 12) & 63];
                    int i15 = i12 + 3;
                    context.pos = i15;
                    bArrEnsureBufferSize[i14] = bArr2[(i11 >> 6) & 63];
                    int i16 = i12 + 4;
                    context.pos = i16;
                    bArrEnsureBufferSize[i15] = bArr2[i11 & 63];
                    int i17 = context.currentLinePos + 4;
                    context.currentLinePos = i17;
                    int i18 = this.lineLength;
                    if (i18 > 0 && i18 <= i17) {
                        byte[] bArr3 = this.lineSeparator;
                        System.arraycopy(bArr3, 0, bArrEnsureBufferSize, i16, bArr3.length);
                        context.pos += this.lineSeparator.length;
                        context.currentLinePos = 0;
                    }
                }
                i7++;
                i5 = i9;
            }
            return;
        }
        context.eof = true;
        if (context.modulus == 0 && this.lineLength == 0) {
            return;
        }
        byte[] bArrEnsureBufferSize2 = ensureBufferSize(this.encodeSize, context);
        int i19 = context.pos;
        int i20 = context.modulus;
        if (i20 != 0) {
            if (i20 == 1) {
                int i21 = i19 + 1;
                context.pos = i21;
                byte[] bArr4 = this.encodeTable;
                int i22 = context.ibitWorkArea;
                bArrEnsureBufferSize2[i19] = bArr4[(i22 >> 2) & 63];
                int i23 = i19 + 2;
                context.pos = i23;
                bArrEnsureBufferSize2[i21] = bArr4[(i22 << 4) & 63];
                if (bArr4 == STANDARD_ENCODE_TABLE) {
                    int i24 = i19 + 3;
                    context.pos = i24;
                    byte b = this.pad;
                    bArrEnsureBufferSize2[i23] = b;
                    context.pos = i19 + 4;
                    bArrEnsureBufferSize2[i24] = b;
                }
            } else {
                if (i20 != 2) {
                    throw new IllegalStateException("Impossible modulus " + context.modulus);
                }
                int i25 = i19 + 1;
                context.pos = i25;
                byte[] bArr5 = this.encodeTable;
                int i26 = context.ibitWorkArea;
                bArrEnsureBufferSize2[i19] = bArr5[(i26 >> 10) & 63];
                int i27 = i19 + 2;
                context.pos = i27;
                bArrEnsureBufferSize2[i25] = bArr5[(i26 >> 4) & 63];
                int i28 = i19 + 3;
                context.pos = i28;
                bArrEnsureBufferSize2[i27] = bArr5[(i26 << 2) & 63];
                if (bArr5 == STANDARD_ENCODE_TABLE) {
                    context.pos = i19 + 4;
                    bArrEnsureBufferSize2[i28] = this.pad;
                }
            }
        }
        int i29 = context.currentLinePos;
        int i30 = context.pos;
        int i31 = (i30 - i19) + i29;
        context.currentLinePos = i31;
        if (this.lineLength <= 0 || i31 <= 0) {
            return;
        }
        byte[] bArr6 = this.lineSeparator;
        System.arraycopy(bArr6, 0, bArrEnsureBufferSize2, i30, bArr6.length);
        context.pos += this.lineSeparator.length;
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public boolean isInAlphabet(byte b) {
        if (b < 0) {
            return false;
        }
        byte[] bArr = this.decodeTable;
        return b < bArr.length && bArr[b] != -1;
    }

    public boolean isUrlSafe() {
        return this.encodeTable == URL_SAFE_ENCODE_TABLE;
    }

    public Base64(boolean z6) {
        this(76, BaseNCodec.CHUNK_SEPARATOR, z6);
    }

    public static byte[] decodeBase64(String str) {
        return new Base64().decode(str);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z6) {
        return encodeBase64(bArr, z6, false);
    }

    public static boolean isBase64(byte[] bArr) {
        for (int i5 = 0; i5 < bArr.length; i5++) {
            if (!isBase64(bArr[i5]) && !BaseNCodec.isWhiteSpace(bArr[i5])) {
                return false;
            }
        }
        return true;
    }

    public Base64(int i5) {
        this(i5, BaseNCodec.CHUNK_SEPARATOR);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z6, boolean z7) {
        return encodeBase64(bArr, z6, z7, Integer.MAX_VALUE);
    }

    public Base64(int i5, byte[] bArr) {
        this(i5, bArr, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z6, boolean z7, int i5) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Base64 base64 = z6 ? new Base64(z7) : new Base64(0, BaseNCodec.CHUNK_SEPARATOR, z7);
        long encodedLength = base64.getEncodedLength(bArr);
        if (encodedLength <= i5) {
            return base64.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + encodedLength + ") than the specified maximum size of " + i5);
    }

    public static boolean isBase64(String str) {
        return isBase64(StringUtils.getBytesUtf8(str));
    }

    public Base64(int i5, byte[] bArr, boolean z6) {
        this(i5, bArr, z6, BaseNCodec.DECODING_POLICY_DEFAULT);
    }

    public Base64(int i5, byte[] bArr, boolean z6, CodecPolicy codecPolicy) {
        super(3, 4, i5, bArr == null ? 0 : bArr.length, DeletedArea3DPtg.sid, codecPolicy);
        this.decodeTable = DECODE_TABLE;
        if (bArr != null) {
            if (containsAlphabetOrPad(bArr)) {
                throw new IllegalArgumentException(AbstractC0157z.o("lineSeparator must not contain base64 characters: [", StringUtils.newStringUtf8(bArr), "]"));
            }
            if (i5 > 0) {
                this.encodeSize = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.lineSeparator = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.encodeSize = 4;
                this.lineSeparator = null;
            }
        } else {
            this.encodeSize = 4;
            this.lineSeparator = null;
        }
        this.decodeSize = this.encodeSize - 1;
        this.encodeTable = z6 ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
    }
}
