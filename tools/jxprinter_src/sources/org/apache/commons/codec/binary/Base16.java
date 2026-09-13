package org.apache.commons.codec.binary;

import A3.AbstractC0157z;
import com.google.common.primitives.UnsignedBytes;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.poi.hssf.record.PaletteRecord;
import org.apache.poi.ss.formula.ptg.DeletedArea3DPtg;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Base16 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 4;
    private static final int BYTES_PER_ENCODED_BLOCK = 2;
    private static final int BYTES_PER_UNENCODED_BLOCK = 1;
    private static final int MASK_4BITS = 15;
    private final byte[] decodeTable;
    private final byte[] encodeTable;
    private static final byte[] UPPER_CASE_DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15};
    private static final byte[] UPPER_CASE_ENCODE_TABLE = {TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, PaletteRecord.STANDARD_PALETTE_SIZE, 57, 65, 66, 67, 68, 69, 70};
    private static final byte[] LOWER_CASE_DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15};
    private static final byte[] LOWER_CASE_ENCODE_TABLE = {TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, PaletteRecord.STANDARD_PALETTE_SIZE, 57, 97, 98, 99, 100, 101, 102};

    public Base16() {
        this(false);
    }

    private int decodeOctet(byte b) {
        int i5 = b & UnsignedBytes.MAX_VALUE;
        byte[] bArr = this.decodeTable;
        byte b6 = i5 < bArr.length ? bArr[b] : (byte) -1;
        if (b6 != -1) {
            return b6;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(b, "Invalid octet in encoded value: "));
    }

    private void validateTrailingCharacter() {
        if (isStrictDecoding()) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character is a valid base 16 alphabetcharacter but not a possible encoding. Decoding requires at least two characters to create one byte.");
        }
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void decode(byte[] bArr, int i5, int i6, BaseNCodec.Context context) {
        if (context.eof || i6 < 0) {
            context.eof = true;
            if (context.ibitWorkArea != 0) {
                validateTrailingCharacter();
                return;
            }
            return;
        }
        int iMin = Math.min(bArr.length - i5, i6);
        int i7 = 0;
        int i8 = (context.ibitWorkArea != 0 ? 1 : 0) + iMin;
        if (i8 == 1 && i8 == iMin) {
            context.ibitWorkArea = decodeOctet(bArr[i5]) + 1;
            return;
        }
        int i9 = i8 % 2 == 0 ? i8 : i8 - 1;
        byte[] bArrEnsureBufferSize = ensureBufferSize(i9 / 2, context);
        if (iMin < i8) {
            int i10 = i5 + 1;
            int iDecodeOctet = decodeOctet(bArr[i5]) | ((context.ibitWorkArea - 1) << 4);
            int i11 = context.pos;
            context.pos = i11 + 1;
            bArrEnsureBufferSize[i11] = (byte) iDecodeOctet;
            context.ibitWorkArea = 0;
            i7 = 2;
            i5 = i10;
        }
        while (i7 < i9) {
            int i12 = i5 + 1;
            int iDecodeOctet2 = decodeOctet(bArr[i5]) << 4;
            i5 += 2;
            int iDecodeOctet3 = decodeOctet(bArr[i12]) | iDecodeOctet2;
            i7 += 2;
            int i13 = context.pos;
            context.pos = i13 + 1;
            bArrEnsureBufferSize[i13] = (byte) iDecodeOctet3;
        }
        if (i7 < iMin) {
            context.ibitWorkArea = decodeOctet(bArr[i7]) + 1;
        }
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void encode(byte[] bArr, int i5, int i6, BaseNCodec.Context context) {
        if (context.eof) {
            return;
        }
        if (i6 < 0) {
            context.eof = true;
            return;
        }
        int i7 = i6 * 2;
        if (i7 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i6, "Input length exceeds maximum size for encoded data: "));
        }
        byte[] bArrEnsureBufferSize = ensureBufferSize(i7, context);
        int i8 = i6 + i5;
        while (i5 < i8) {
            byte b = bArr[i5];
            int i9 = context.pos;
            int i10 = i9 + 1;
            context.pos = i10;
            byte[] bArr2 = this.encodeTable;
            bArrEnsureBufferSize[i9] = bArr2[(b >> 4) & 15];
            context.pos = i9 + 2;
            bArrEnsureBufferSize[i10] = bArr2[b & 15];
            i5++;
        }
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public boolean isInAlphabet(byte b) {
        int i5 = b & UnsignedBytes.MAX_VALUE;
        byte[] bArr = this.decodeTable;
        return i5 < bArr.length && bArr[b] != -1;
    }

    public Base16(boolean z6) {
        this(z6, BaseNCodec.DECODING_POLICY_DEFAULT);
    }

    public Base16(boolean z6, CodecPolicy codecPolicy) {
        super(1, 2, 0, 0, DeletedArea3DPtg.sid, codecPolicy);
        if (z6) {
            this.encodeTable = LOWER_CASE_ENCODE_TABLE;
            this.decodeTable = LOWER_CASE_DECODE_TABLE;
        } else {
            this.encodeTable = UPPER_CASE_ENCODE_TABLE;
            this.decodeTable = UPPER_CASE_DECODE_TABLE;
        }
    }
}
