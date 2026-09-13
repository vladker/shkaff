package org.apache.commons.codec.binary;

import A3.AbstractC0157z;
import androidx.collection.a;
import com.google.common.base.Ascii;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.poi.hssf.record.PaletteRecord;
import org.apache.poi.ss.formula.ptg.DeletedArea3DPtg;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Base32 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 5;
    private static final int BYTES_PER_ENCODED_BLOCK = 8;
    private static final int BYTES_PER_UNENCODED_BLOCK = 5;
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, Ascii.CAN, 25, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, Ascii.CAN, 25};
    private static final byte[] ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG};
    private static final byte[] HEX_DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, Ascii.CAN, 25, Ascii.SUB, Ascii.ESC, Ascii.FS, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, Ascii.CAN, 25, Ascii.SUB, Ascii.ESC, Ascii.FS, 29, 30, 31};
    private static final byte[] HEX_ENCODE_TABLE = {TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, PaletteRecord.STANDARD_PALETTE_SIZE, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86};
    private static final long MASK_1BITS = 1;
    private static final long MASK_2BITS = 3;
    private static final long MASK_3BITS = 7;
    private static final long MASK_4BITS = 15;
    private static final int MASK_5BITS = 31;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    public Base32() {
        this(false);
    }

    private void validateCharacter(long j6, BaseNCodec.Context context) {
        if (isStrictDecoding() && (j6 & context.lbitWorkArea) != 0) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 32 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.");
        }
    }

    private void validateTrailingCharacters() {
        if (isStrictDecoding()) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character(s) (before the paddings if any) are valid base 32 alphabet but not a possible encoding. Decoding requires either 2, 4, 5, or 7 trailing 5-bit characters to create bytes.");
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0092  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v21, types: [int] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v22 */
    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void decode(byte[] bArr, int i5, int i6, BaseNCodec.Context context) {
        ?? r15;
        byte b;
        if (context.eof) {
            return;
        }
        ?? r6 = 1;
        if (i6 < 0) {
            context.eof = true;
        }
        int i7 = 0;
        int i8 = i5;
        while (i7 < i6) {
            int i9 = i8 + 1;
            byte b6 = bArr[i8];
            if (b6 == this.pad) {
                context.eof = r6;
                break;
            }
            byte[] bArrEnsureBufferSize = ensureBufferSize(this.decodeSize, context);
            if (b6 >= 0) {
                byte[] bArr2 = this.decodeTable;
                if (b6 >= bArr2.length || (b = bArr2[b6]) < 0) {
                    r15 = r6;
                } else {
                    int i10 = (context.modulus + r6) % 8;
                    context.modulus = i10;
                    r15 = r6;
                    long j6 = (context.lbitWorkArea << 5) + ((long) b);
                    context.lbitWorkArea = j6;
                    if (i10 == 0) {
                        int i11 = context.pos;
                        int i12 = i11 + 1;
                        context.pos = i12;
                        bArrEnsureBufferSize[i11] = (byte) ((j6 >> 32) & 255);
                        int i13 = i11 + 2;
                        context.pos = i13;
                        bArrEnsureBufferSize[i12] = (byte) ((j6 >> 24) & 255);
                        int i14 = i11 + 3;
                        context.pos = i14;
                        bArrEnsureBufferSize[i13] = (byte) ((j6 >> 16) & 255);
                        int i15 = i11 + 4;
                        context.pos = i15;
                        bArrEnsureBufferSize[i14] = (byte) ((j6 >> 8) & 255);
                        context.pos = i11 + 5;
                        bArrEnsureBufferSize[i15] = (byte) (j6 & 255);
                    }
                }
            } else {
                r15 = r6;
            }
            i7++;
            i8 = i9;
            r6 = r15;
        }
        ?? r16 = r6;
        if (!context.eof || context.modulus <= 0) {
            return;
        }
        byte[] bArrEnsureBufferSize2 = ensureBufferSize(this.decodeSize, context);
        switch (context.modulus) {
            case 1:
                validateTrailingCharacters();
                break;
            case 2:
                break;
            case 3:
                validateTrailingCharacters();
                int i16 = context.pos;
                context.pos = i16 + 1;
                bArrEnsureBufferSize2[i16] = (byte) ((context.lbitWorkArea >> MASK_3BITS) & 255);
                return;
            case 4:
                validateCharacter(MASK_4BITS, context);
                long j7 = context.lbitWorkArea;
                long j8 = j7 >> 4;
                context.lbitWorkArea = j8;
                int i17 = context.pos;
                int i18 = i17 + 1;
                context.pos = i18;
                bArrEnsureBufferSize2[i17] = (byte) ((j7 >> 12) & 255);
                context.pos = i17 + 2;
                bArrEnsureBufferSize2[i18] = (byte) (j8 & 255);
                return;
            case 5:
                validateCharacter(1L, context);
                long j9 = context.lbitWorkArea;
                long j10 = j9 >> (r16 == true ? 1L : 0L);
                context.lbitWorkArea = j10;
                int i19 = context.pos;
                int i20 = i19 + 1;
                context.pos = i20;
                bArrEnsureBufferSize2[i19] = (byte) ((j9 >> 17) & 255);
                int i21 = i19 + 2;
                context.pos = i21;
                bArrEnsureBufferSize2[i20] = (byte) ((j9 >> 9) & 255);
                context.pos = i19 + 3;
                bArrEnsureBufferSize2[i21] = (byte) (j10 & 255);
                return;
            case 6:
                validateTrailingCharacters();
                long j11 = context.lbitWorkArea;
                long j12 = j11 >> 6;
                context.lbitWorkArea = j12;
                int i22 = context.pos;
                int i23 = i22 + 1;
                context.pos = i23;
                bArrEnsureBufferSize2[i22] = (byte) ((j11 >> 22) & 255);
                int i24 = i22 + 2;
                context.pos = i24;
                bArrEnsureBufferSize2[i23] = (byte) ((j11 >> 14) & 255);
                context.pos = i22 + 3;
                bArrEnsureBufferSize2[i24] = (byte) (j12 & 255);
                return;
            case 7:
                validateCharacter(MASK_3BITS, context);
                long j13 = context.lbitWorkArea;
                long j14 = j13 >> 3;
                context.lbitWorkArea = j14;
                int i25 = context.pos;
                int i26 = i25 + 1;
                context.pos = i26;
                bArrEnsureBufferSize2[i25] = (byte) ((j13 >> 27) & 255);
                int i27 = i25 + 2;
                context.pos = i27;
                bArrEnsureBufferSize2[i26] = (byte) ((j13 >> 19) & 255);
                int i28 = i25 + 3;
                context.pos = i28;
                bArrEnsureBufferSize2[i27] = (byte) ((j13 >> 11) & 255);
                context.pos = i25 + 4;
                bArrEnsureBufferSize2[i28] = (byte) (j14 & 255);
                return;
            default:
                throw new IllegalStateException("Impossible modulus " + context.modulus);
        }
        validateCharacter(3L, context);
        int i29 = context.pos;
        context.pos = i29 + 1;
        bArrEnsureBufferSize2[i29] = (byte) ((context.lbitWorkArea >> 2) & 255);
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void encode(byte[] bArr, int i5, int i6, BaseNCodec.Context context) {
        int i7;
        if (context.eof) {
            return;
        }
        int i8 = 1;
        if (i6 >= 0) {
            int i9 = i5;
            int i10 = 0;
            while (i10 < i6) {
                byte[] bArrEnsureBufferSize = ensureBufferSize(this.encodeSize, context);
                int i11 = (context.modulus + i8) % 5;
                context.modulus = i11;
                int i12 = i9 + 1;
                int i13 = bArr[i9];
                if (i13 < 0) {
                    i13 += 256;
                }
                long j6 = (context.lbitWorkArea << 8) + ((long) i13);
                context.lbitWorkArea = j6;
                if (i11 == 0) {
                    int i14 = context.pos;
                    int i15 = i14 + 1;
                    context.pos = i15;
                    byte[] bArr2 = this.encodeTable;
                    bArrEnsureBufferSize[i14] = bArr2[((int) (j6 >> 35)) & 31];
                    int i16 = i14 + 2;
                    context.pos = i16;
                    i7 = i12;
                    bArrEnsureBufferSize[i15] = bArr2[((int) (j6 >> 30)) & 31];
                    int i17 = i14 + 3;
                    context.pos = i17;
                    bArrEnsureBufferSize[i16] = bArr2[((int) (j6 >> 25)) & 31];
                    int i18 = i14 + 4;
                    context.pos = i18;
                    bArrEnsureBufferSize[i17] = bArr2[((int) (j6 >> 20)) & 31];
                    int i19 = i14 + 5;
                    context.pos = i19;
                    bArrEnsureBufferSize[i18] = bArr2[((int) (j6 >> MASK_4BITS)) & 31];
                    int i20 = i14 + 6;
                    context.pos = i20;
                    bArrEnsureBufferSize[i19] = bArr2[((int) (j6 >> 10)) & 31];
                    int i21 = i14 + 7;
                    context.pos = i21;
                    bArrEnsureBufferSize[i20] = bArr2[((int) (j6 >> 5)) & 31];
                    int i22 = i14 + 8;
                    context.pos = i22;
                    bArrEnsureBufferSize[i21] = bArr2[((int) j6) & 31];
                    int i23 = context.currentLinePos + 8;
                    context.currentLinePos = i23;
                    int i24 = this.lineLength;
                    if (i24 > 0 && i24 <= i23) {
                        byte[] bArr3 = this.lineSeparator;
                        System.arraycopy(bArr3, 0, bArrEnsureBufferSize, i22, bArr3.length);
                        context.pos += this.lineSeparator.length;
                        context.currentLinePos = 0;
                    }
                } else {
                    i7 = i12;
                }
                i10++;
                i9 = i7;
                i8 = 1;
            }
            return;
        }
        context.eof = true;
        if (context.modulus == 0 && this.lineLength == 0) {
            return;
        }
        byte[] bArrEnsureBufferSize2 = ensureBufferSize(this.encodeSize, context);
        int i25 = context.pos;
        int i26 = context.modulus;
        if (i26 != 0) {
            if (i26 == 1) {
                int i27 = i25 + 1;
                context.pos = i27;
                byte[] bArr4 = this.encodeTable;
                long j7 = context.lbitWorkArea;
                bArrEnsureBufferSize2[i25] = bArr4[((int) (j7 >> 3)) & 31];
                int i28 = i25 + 2;
                context.pos = i28;
                bArrEnsureBufferSize2[i27] = bArr4[((int) (j7 << 2)) & 31];
                int i29 = i25 + 3;
                context.pos = i29;
                byte b = this.pad;
                bArrEnsureBufferSize2[i28] = b;
                int i30 = i25 + 4;
                context.pos = i30;
                bArrEnsureBufferSize2[i29] = b;
                int i31 = i25 + 5;
                context.pos = i31;
                bArrEnsureBufferSize2[i30] = b;
                int i32 = i25 + 6;
                context.pos = i32;
                bArrEnsureBufferSize2[i31] = b;
                int i33 = i25 + 7;
                context.pos = i33;
                bArrEnsureBufferSize2[i32] = b;
                context.pos = i25 + 8;
                bArrEnsureBufferSize2[i33] = b;
            } else if (i26 == 2) {
                int i34 = i25 + 1;
                context.pos = i34;
                byte[] bArr5 = this.encodeTable;
                long j8 = context.lbitWorkArea;
                bArrEnsureBufferSize2[i25] = bArr5[((int) (j8 >> 11)) & 31];
                int i35 = i25 + 2;
                context.pos = i35;
                bArrEnsureBufferSize2[i34] = bArr5[((int) (j8 >> 6)) & 31];
                int i36 = i25 + 3;
                context.pos = i36;
                bArrEnsureBufferSize2[i35] = bArr5[((int) (j8 >> 1)) & 31];
                int i37 = i25 + 4;
                context.pos = i37;
                bArrEnsureBufferSize2[i36] = bArr5[((int) (j8 << 4)) & 31];
                int i38 = i25 + 5;
                context.pos = i38;
                byte b6 = this.pad;
                bArrEnsureBufferSize2[i37] = b6;
                int i39 = i25 + 6;
                context.pos = i39;
                bArrEnsureBufferSize2[i38] = b6;
                int i40 = i25 + 7;
                context.pos = i40;
                bArrEnsureBufferSize2[i39] = b6;
                context.pos = i25 + 8;
                bArrEnsureBufferSize2[i40] = b6;
            } else if (i26 == 3) {
                int i41 = i25 + 1;
                context.pos = i41;
                byte[] bArr6 = this.encodeTable;
                long j9 = context.lbitWorkArea;
                bArrEnsureBufferSize2[i25] = bArr6[((int) (j9 >> 19)) & 31];
                int i42 = i25 + 2;
                context.pos = i42;
                bArrEnsureBufferSize2[i41] = bArr6[((int) (j9 >> 14)) & 31];
                int i43 = i25 + 3;
                context.pos = i43;
                bArrEnsureBufferSize2[i42] = bArr6[((int) (j9 >> 9)) & 31];
                int i44 = i25 + 4;
                context.pos = i44;
                bArrEnsureBufferSize2[i43] = bArr6[((int) (j9 >> 4)) & 31];
                int i45 = i25 + 5;
                context.pos = i45;
                bArrEnsureBufferSize2[i44] = bArr6[((int) (j9 << 1)) & 31];
                int i46 = i25 + 6;
                context.pos = i46;
                byte b7 = this.pad;
                bArrEnsureBufferSize2[i45] = b7;
                int i47 = i25 + 7;
                context.pos = i47;
                bArrEnsureBufferSize2[i46] = b7;
                context.pos = i25 + 8;
                bArrEnsureBufferSize2[i47] = b7;
            } else {
                if (i26 != 4) {
                    throw new IllegalStateException("Impossible modulus " + context.modulus);
                }
                int i48 = i25 + 1;
                context.pos = i48;
                byte[] bArr7 = this.encodeTable;
                long j10 = context.lbitWorkArea;
                bArrEnsureBufferSize2[i25] = bArr7[((int) (j10 >> 27)) & 31];
                int i49 = i25 + 2;
                context.pos = i49;
                bArrEnsureBufferSize2[i48] = bArr7[((int) (j10 >> 22)) & 31];
                int i50 = i25 + 3;
                context.pos = i50;
                bArrEnsureBufferSize2[i49] = bArr7[((int) (j10 >> 17)) & 31];
                int i51 = i25 + 4;
                context.pos = i51;
                bArrEnsureBufferSize2[i50] = bArr7[((int) (j10 >> 12)) & 31];
                int i52 = i25 + 5;
                context.pos = i52;
                bArrEnsureBufferSize2[i51] = bArr7[((int) (j10 >> MASK_3BITS)) & 31];
                int i53 = i25 + 6;
                context.pos = i53;
                bArrEnsureBufferSize2[i52] = bArr7[((int) (j10 >> 2)) & 31];
                int i54 = i25 + 7;
                context.pos = i54;
                bArrEnsureBufferSize2[i53] = bArr7[((int) (j10 << 3)) & 31];
                context.pos = i25 + 8;
                bArrEnsureBufferSize2[i54] = this.pad;
            }
        }
        int i55 = context.currentLinePos;
        int i56 = context.pos;
        int i57 = (i56 - i25) + i55;
        context.currentLinePos = i57;
        if (this.lineLength <= 0 || i57 <= 0) {
            return;
        }
        byte[] bArr8 = this.lineSeparator;
        System.arraycopy(bArr8, 0, bArrEnsureBufferSize2, i56, bArr8.length);
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

    public Base32(boolean z6) {
        this(0, null, z6, DeletedArea3DPtg.sid);
    }

    public Base32(boolean z6, byte b) {
        this(0, null, z6, b);
    }

    public Base32(byte b) {
        this(false, b);
    }

    public Base32(int i5) {
        this(i5, BaseNCodec.CHUNK_SEPARATOR);
    }

    public Base32(int i5, byte[] bArr) {
        this(i5, bArr, false, DeletedArea3DPtg.sid);
    }

    public Base32(int i5, byte[] bArr, boolean z6) {
        this(i5, bArr, z6, DeletedArea3DPtg.sid);
    }

    public Base32(int i5, byte[] bArr, boolean z6, byte b) {
        this(i5, bArr, z6, b, BaseNCodec.DECODING_POLICY_DEFAULT);
    }

    public Base32(int i5, byte[] bArr, boolean z6, byte b, CodecPolicy codecPolicy) {
        super(5, 8, i5, bArr == null ? 0 : bArr.length, b, codecPolicy);
        if (z6) {
            this.encodeTable = HEX_ENCODE_TABLE;
            this.decodeTable = HEX_DECODE_TABLE;
        } else {
            this.encodeTable = ENCODE_TABLE;
            this.decodeTable = DECODE_TABLE;
        }
        if (i5 <= 0) {
            this.encodeSize = 8;
            this.lineSeparator = null;
        } else if (bArr != null) {
            if (!containsAlphabetOrPad(bArr)) {
                this.encodeSize = bArr.length + 8;
                byte[] bArr2 = new byte[bArr.length];
                this.lineSeparator = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                throw new IllegalArgumentException(AbstractC0157z.o("lineSeparator must not contain Base32 characters: [", StringUtils.newStringUtf8(bArr), "]"));
            }
        } else {
            throw new IllegalArgumentException(a.i(i5, "lineLength ", " > 0, but lineSeparator is null"));
        }
        this.decodeSize = this.encodeSize - 1;
        if (isInAlphabet(b) || BaseNCodec.isWhiteSpace(b)) {
            throw new IllegalArgumentException("pad must not be in alphabet or whitespace");
        }
    }
}
