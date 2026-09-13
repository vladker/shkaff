package org.apache.commons.compress.compressors.bzip2;

import A3.AbstractC0157z;
import androidx.collection.a;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.BitInputStream;
import org.apache.commons.compress.utils.CloseShieldFilterInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BZip2CompressorInputStream extends CompressorInputStream implements BZip2Constants, InputStreamStatistics {
    private static final int EOF = 0;
    private static final int NO_RAND_PART_A_STATE = 5;
    private static final int NO_RAND_PART_B_STATE = 6;
    private static final int NO_RAND_PART_C_STATE = 7;
    private static final int RAND_PART_A_STATE = 2;
    private static final int RAND_PART_B_STATE = 3;
    private static final int RAND_PART_C_STATE = 4;
    private static final int START_BLOCK_STATE = 1;
    private BitInputStream bin;
    private boolean blockRandomised;
    private int blockSize100k;
    private int computedBlockCRC;
    private int computedCombinedCRC;
    private final CRC crc;
    private int currentState;
    private Data data;
    private final boolean decompressConcatenated;
    private int last;
    private int nInUse;
    private int origPtr;
    private int storedBlockCRC;
    private int storedCombinedCRC;
    private int su_ch2;
    private int su_chPrev;
    private int su_count;
    private int su_i2;
    private int su_j2;
    private int su_rNToGo;
    private int su_rTPos;
    private int su_tPos;
    private char su_z;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Data {
        final int[][] base;
        final int[] cftab;
        final char[] getAndMoveToFrontDecode_yy;
        final int[][] limit;
        final byte[] ll8;
        final int[] minLens;
        final int[][] perm;
        final byte[] recvDecodingTables_pos;
        final char[][] temp_charArray2d;
        int[] tt;
        final boolean[] inUse = new boolean[256];
        final byte[] seqToUnseq = new byte[256];
        final byte[] selector = new byte[BZip2Constants.MAX_SELECTORS];
        final byte[] selectorMtf = new byte[BZip2Constants.MAX_SELECTORS];
        final int[] unzftab = new int[256];

        public Data(int i5) {
            Class cls = Integer.TYPE;
            this.limit = (int[][]) Array.newInstance((Class<?>) cls, 6, 258);
            this.base = (int[][]) Array.newInstance((Class<?>) cls, 6, 258);
            this.perm = (int[][]) Array.newInstance((Class<?>) cls, 6, 258);
            this.minLens = new int[6];
            this.cftab = new int[257];
            this.getAndMoveToFrontDecode_yy = new char[256];
            this.temp_charArray2d = (char[][]) Array.newInstance((Class<?>) Character.TYPE, 6, 258);
            this.recvDecodingTables_pos = new byte[6];
            this.ll8 = new byte[i5 * BZip2Constants.BASEBLOCKSIZE];
        }

        public int[] initTT(int i5) {
            int[] iArr = this.tt;
            if (iArr != null && iArr.length >= i5) {
                return iArr;
            }
            int[] iArr2 = new int[i5];
            this.tt = iArr2;
            return iArr2;
        }
    }

    public BZip2CompressorInputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    private static boolean bsGetBit(BitInputStream bitInputStream) {
        return bsR(bitInputStream, 1) != 0;
    }

    private static int bsGetInt(BitInputStream bitInputStream) {
        return bsR(bitInputStream, 32);
    }

    private static char bsGetUByte(BitInputStream bitInputStream) {
        return (char) bsR(bitInputStream, 8);
    }

    private static int bsR(BitInputStream bitInputStream, int i5) throws IOException {
        long bits = bitInputStream.readBits(i5);
        if (bits >= 0) {
            return (int) bits;
        }
        throw new IOException("Unexpected end of stream");
    }

    private static void checkBounds(int i5, int i6, String str) throws IOException {
        if (i5 < 0) {
            throw new IOException(AbstractC0157z.o("Corrupted input, ", str, " value negative"));
        }
        if (i5 >= i6) {
            throw new IOException(AbstractC0157z.o("Corrupted input, ", str, " value too big"));
        }
    }

    private boolean complete() throws IOException {
        int iBsGetInt = bsGetInt(this.bin);
        this.storedCombinedCRC = iBsGetInt;
        this.currentState = 0;
        this.data = null;
        if (iBsGetInt == this.computedCombinedCRC) {
            return (this.decompressConcatenated && init(false)) ? false : true;
        }
        throw new IOException("BZip2 CRC error");
    }

    private void createHuffmanDecodingTables(int i5, int i6) throws IOException {
        Data data = this.data;
        char[][] cArr = data.temp_charArray2d;
        int[] iArr = data.minLens;
        int[][] iArr2 = data.limit;
        int[][] iArr3 = data.base;
        int[][] iArr4 = data.perm;
        for (int i7 = 0; i7 < i6; i7++) {
            char[] cArr2 = cArr[i7];
            char c = 0;
            char c6 = ' ';
            int i8 = i5;
            while (true) {
                i8--;
                if (i8 >= 0) {
                    char c7 = cArr2[i8];
                    if (c7 > c) {
                        c = c7;
                    }
                    if (c7 < c6) {
                        c6 = c7;
                    }
                }
            }
            hbCreateDecodeTables(iArr2[i7], iArr3[i7], iArr4[i7], cArr[i7], c6, c, i5);
            iArr[i7] = c6;
        }
    }

    private void endBlock() throws IOException {
        int finalCRC = this.crc.getFinalCRC();
        this.computedBlockCRC = finalCRC;
        int i5 = this.storedBlockCRC;
        if (i5 == finalCRC) {
            int i6 = this.computedCombinedCRC;
            this.computedCombinedCRC = finalCRC ^ ((i6 >>> 31) | (i6 << 1));
        } else {
            int i7 = this.storedCombinedCRC;
            this.computedCombinedCRC = ((i7 >>> 31) | (i7 << 1)) ^ i5;
            throw new IOException("BZip2 CRC error");
        }
    }

    private void getAndMoveToFrontDecode() throws IOException {
        char[] cArr;
        int i5;
        BitInputStream bitInputStream = this.bin;
        this.origPtr = bsR(bitInputStream, 24);
        recvDecodingTables();
        Data data = this.data;
        byte[] bArr = data.ll8;
        int[] iArr = data.unzftab;
        byte[] bArr2 = data.selector;
        byte[] bArr3 = data.seqToUnseq;
        char[] cArr2 = data.getAndMoveToFrontDecode_yy;
        int[] iArr2 = data.minLens;
        int[][] iArr3 = data.limit;
        int[][] iArr4 = data.base;
        int[][] iArr5 = data.perm;
        int i6 = this.blockSize100k * BZip2Constants.BASEBLOCKSIZE;
        int i7 = 256;
        while (true) {
            i7--;
            if (i7 < 0) {
                break;
            }
            cArr2[i7] = (char) i7;
            iArr[i7] = 0;
        }
        int i8 = this.nInUse + 1;
        int andMoveToFrontDecode0 = getAndMoveToFrontDecode0();
        int i9 = 0;
        int i10 = bArr2[0] & UnsignedBytes.MAX_VALUE;
        checkBounds(i10, 6, "zt");
        int[] iArr6 = iArr4[i10];
        int[] iArr7 = iArr3[i10];
        int[] iArr8 = iArr5[i10];
        int i11 = iArr2[i10];
        int i12 = andMoveToFrontDecode0;
        int i13 = 0;
        int i14 = 49;
        int i15 = -1;
        while (i12 != i8) {
            iArr = iArr;
            bArr2 = bArr2;
            String str = "groupNo";
            bArr3 = bArr3;
            iArr2 = iArr2;
            iArr3 = iArr3;
            iArr4 = iArr4;
            if (i12 == 0 || i12 == 1) {
                int i16 = i8;
                int i17 = 1;
                int i18 = -1;
                while (true) {
                    if (i12 != 0) {
                        cArr = cArr2;
                        if (i12 != 1) {
                            break;
                        } else {
                            i18 += i17 << 1;
                        }
                    } else {
                        i18 += i17;
                        cArr = cArr2;
                    }
                    if (i14 == 0) {
                        int i19 = i13 + 1;
                        checkBounds(i19, BZip2Constants.MAX_SELECTORS, str);
                        int i20 = bArr2[i19] & UnsignedBytes.MAX_VALUE;
                        checkBounds(i20, 6, "zt");
                        iArr6 = iArr4[i20];
                        iArr7 = iArr3[i20];
                        iArr8 = iArr5[i20];
                        i11 = iArr2[i20];
                        i13 = i19;
                        i14 = 49;
                    } else {
                        i14--;
                    }
                    checkBounds(i11, 258, "zn");
                    int iBsR = bsR(bitInputStream, i11);
                    int i21 = i11;
                    while (iBsR > iArr7[i21]) {
                        int i22 = i21 + 1;
                        checkBounds(i22, 258, "zn");
                        iBsR = (iBsR << 1) | bsR(bitInputStream, 1);
                        i21 = i22;
                        str = str;
                    }
                    int i23 = iBsR - iArr6[i21];
                    checkBounds(i23, 258, "zvec");
                    i12 = iArr8[i23];
                    i17 <<= 1;
                    cArr2 = cArr;
                    str = str;
                }
                checkBounds(i18, this.data.ll8.length, "s");
                i9 = 0;
                char c = cArr[0];
                checkBounds(c, 256, "yy");
                byte b = bArr3[c];
                int i24 = b & UnsignedBytes.MAX_VALUE;
                iArr[i24] = i18 + 1 + iArr[i24];
                int i25 = i15 + 1;
                int i26 = i25 + i18;
                checkBounds(i26, this.data.ll8.length, "lastShadow");
                Arrays.fill(bArr, i25, i26 + 1, b);
                if (i26 >= i6) {
                    throw new IOException(a.h(i26, i6, "Block overrun while expanding RLE in MTF, ", " exceeds "));
                }
                i15 = i26;
                i8 = i16;
                cArr2 = cArr;
            } else {
                i15++;
                if (i15 >= i6) {
                    throw new IOException(a.h(i15, i6, "Block overrun in MTF, ", " exceeds "));
                }
                checkBounds(i12, 257, "nextSym");
                int i27 = i12 - 1;
                char c6 = cArr2[i27];
                int i28 = i8;
                checkBounds(c6, 256, "yy");
                byte b6 = bArr3[c6];
                int i29 = b6 & UnsignedBytes.MAX_VALUE;
                iArr[i29] = iArr[i29] + 1;
                bArr[i15] = b6;
                if (i12 <= 16) {
                    while (i27 > 0) {
                        int i30 = i27 - 1;
                        cArr2[i27] = cArr2[i30];
                        i27 = i30;
                    }
                    i5 = i9;
                } else {
                    i5 = i9;
                    System.arraycopy(cArr2, i5, cArr2, 1, i27);
                }
                cArr2[i5] = c6;
                if (i14 == 0) {
                    int i31 = i13 + 1;
                    checkBounds(i31, BZip2Constants.MAX_SELECTORS, "groupNo");
                    int i32 = bArr2[i31] & UnsignedBytes.MAX_VALUE;
                    checkBounds(i32, 6, "zt");
                    int[] iArr9 = iArr4[i32];
                    int[] iArr10 = iArr3[i32];
                    int[] iArr11 = iArr5[i32];
                    i11 = iArr2[i32];
                    i13 = i31;
                    iArr6 = iArr9;
                    iArr7 = iArr10;
                    iArr8 = iArr11;
                    i14 = 49;
                } else {
                    i14--;
                }
                checkBounds(i11, 258, "zn");
                int iBsR2 = bsR(bitInputStream, i11);
                int i33 = i11;
                while (iBsR2 > iArr7[i33]) {
                    i33++;
                    checkBounds(i33, 258, "zn");
                    iBsR2 = (iBsR2 << 1) | bsR(bitInputStream, 1);
                }
                int i34 = iBsR2 - iArr6[i33];
                checkBounds(i34, 258, "zvec");
                i12 = iArr8[i34];
                i8 = i28;
                i9 = 0;
            }
        }
        this.last = i15;
    }

    private int getAndMoveToFrontDecode0() throws IOException {
        Data data = this.data;
        int i5 = data.selector[0] & UnsignedBytes.MAX_VALUE;
        checkBounds(i5, 6, "zt");
        int[] iArr = data.limit[i5];
        int i6 = data.minLens[i5];
        checkBounds(i6, 258, "zn");
        int iBsR = bsR(this.bin, i6);
        while (iBsR > iArr[i6]) {
            i6++;
            checkBounds(i6, 258, "zn");
            iBsR = (iBsR << 1) | bsR(this.bin, 1);
        }
        int i7 = iBsR - data.base[i5][i6];
        checkBounds(i7, 258, "zvec");
        return data.perm[i5][i7];
    }

    private static void hbCreateDecodeTables(int[] iArr, int[] iArr2, int[] iArr3, char[] cArr, int i5, int i6, int i7) throws IOException {
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i5; i10 <= i6; i10++) {
            for (int i11 = 0; i11 < i7; i11++) {
                if (cArr[i11] == i10) {
                    iArr3[i9] = i11;
                    i9++;
                }
            }
        }
        int i12 = 23;
        while (true) {
            i12--;
            if (i12 <= 0) {
                break;
            }
            iArr2[i12] = 0;
            iArr[i12] = 0;
        }
        for (int i13 = 0; i13 < i7; i13++) {
            char c = cArr[i13];
            checkBounds(c, 258, "length");
            int i14 = c + 1;
            iArr2[i14] = iArr2[i14] + 1;
        }
        int i15 = iArr2[0];
        for (int i16 = 1; i16 < 23; i16++) {
            i15 += iArr2[i16];
            iArr2[i16] = i15;
        }
        int i17 = iArr2[i5];
        int i18 = i5;
        while (i18 <= i6) {
            int i19 = i18 + 1;
            int i20 = iArr2[i19];
            int i21 = (i20 - i17) + i8;
            iArr[i18] = i21 - 1;
            i8 = i21 << 1;
            i18 = i19;
            i17 = i20;
        }
        for (int i22 = i5 + 1; i22 <= i6; i22++) {
            iArr2[i22] = ((iArr[i22 - 1] + 1) << 1) - iArr2[i22];
        }
    }

    private boolean init(boolean z6) throws IOException {
        BitInputStream bitInputStream = this.bin;
        if (bitInputStream == null) {
            throw new IOException("No InputStream");
        }
        if (!z6) {
            bitInputStream.clearBitCache();
        }
        int nextByte = readNextByte(this.bin);
        if (nextByte == -1 && !z6) {
            return false;
        }
        int nextByte2 = readNextByte(this.bin);
        int nextByte3 = readNextByte(this.bin);
        if (nextByte != 66 || nextByte2 != 90 || nextByte3 != 104) {
            throw new IOException(z6 ? "Stream is not in the BZip2 format" : "Garbage after a valid BZip2 stream");
        }
        int nextByte4 = readNextByte(this.bin);
        if (nextByte4 < 49 || nextByte4 > 57) {
            throw new IOException("BZip2 block size is invalid");
        }
        this.blockSize100k = nextByte4 - 48;
        this.computedCombinedCRC = 0;
        return true;
    }

    private void initBlock() throws IOException {
        BitInputStream bitInputStream = this.bin;
        do {
            char cBsGetUByte = bsGetUByte(bitInputStream);
            char cBsGetUByte2 = bsGetUByte(bitInputStream);
            char cBsGetUByte3 = bsGetUByte(bitInputStream);
            char cBsGetUByte4 = bsGetUByte(bitInputStream);
            char cBsGetUByte5 = bsGetUByte(bitInputStream);
            char cBsGetUByte6 = bsGetUByte(bitInputStream);
            if (cBsGetUByte != 23 || cBsGetUByte2 != 'r' || cBsGetUByte3 != 'E' || cBsGetUByte4 != '8' || cBsGetUByte5 != 'P' || cBsGetUByte6 != 144) {
                if (cBsGetUByte != '1' || cBsGetUByte2 != 'A' || cBsGetUByte3 != 'Y' || cBsGetUByte4 != '&' || cBsGetUByte5 != 'S' || cBsGetUByte6 != 'Y') {
                    this.currentState = 0;
                    throw new IOException("Bad block header");
                }
                this.storedBlockCRC = bsGetInt(bitInputStream);
                this.blockRandomised = bsR(bitInputStream, 1) == 1;
                if (this.data == null) {
                    this.data = new Data(this.blockSize100k);
                }
                getAndMoveToFrontDecode();
                this.crc.initializeCRC();
                this.currentState = 1;
                return;
            }
        } while (!complete());
    }

    private void makeMaps() {
        Data data = this.data;
        boolean[] zArr = data.inUse;
        byte[] bArr = data.seqToUnseq;
        int i5 = 0;
        for (int i6 = 0; i6 < 256; i6++) {
            if (zArr[i6]) {
                bArr[i5] = (byte) i6;
                i5++;
            }
        }
        this.nInUse = i5;
    }

    public static boolean matches(byte[] bArr, int i5) {
        return i5 >= 3 && bArr[0] == 66 && bArr[1] == 90 && bArr[2] == 104;
    }

    private int read0() {
        switch (this.currentState) {
            case 0:
                return -1;
            case 1:
                return setupBlock();
            case 2:
                throw new IllegalStateException();
            case 3:
                return setupRandPartB();
            case 4:
                return setupRandPartC();
            case 5:
                throw new IllegalStateException();
            case 6:
                return setupNoRandPartB();
            case 7:
                return setupNoRandPartC();
            default:
                throw new IllegalStateException();
        }
    }

    private int readNextByte(BitInputStream bitInputStream) {
        return (int) bitInputStream.readBits(8);
    }

    private void recvDecodingTables() throws IOException {
        BitInputStream bitInputStream = this.bin;
        Data data = this.data;
        boolean[] zArr = data.inUse;
        byte[] bArr = data.recvDecodingTables_pos;
        byte[] bArr2 = data.selector;
        byte[] bArr3 = data.selectorMtf;
        int i5 = 0;
        for (int i6 = 0; i6 < 16; i6++) {
            if (bsGetBit(bitInputStream)) {
                i5 |= 1 << i6;
            }
        }
        Arrays.fill(zArr, false);
        for (int i7 = 0; i7 < 16; i7++) {
            if (((1 << i7) & i5) != 0) {
                int i8 = i7 << 4;
                for (int i9 = 0; i9 < 16; i9++) {
                    if (bsGetBit(bitInputStream)) {
                        zArr[i8 + i9] = true;
                    }
                }
            }
        }
        makeMaps();
        int i10 = this.nInUse + 2;
        int iBsR = bsR(bitInputStream, 3);
        int iBsR2 = bsR(bitInputStream, 15);
        if (iBsR2 < 0) {
            throw new IOException("Corrupted input, nSelectors value negative");
        }
        checkBounds(i10, 259, "alphaSize");
        checkBounds(iBsR, 7, "nGroups");
        for (int i11 = 0; i11 < iBsR2; i11++) {
            int i12 = 0;
            while (bsGetBit(bitInputStream)) {
                i12++;
            }
            if (i11 < 18002) {
                bArr3[i11] = (byte) i12;
            }
        }
        if (iBsR2 > 18002) {
            iBsR2 = 18002;
        }
        int i13 = iBsR;
        while (true) {
            i13--;
            if (i13 < 0) {
                break;
            } else {
                bArr[i13] = (byte) i13;
            }
        }
        for (int i14 = 0; i14 < iBsR2; i14++) {
            int i15 = bArr3[i14] & UnsignedBytes.MAX_VALUE;
            checkBounds(i15, 6, "selectorMtf");
            byte b = bArr[i15];
            while (i15 > 0) {
                bArr[i15] = bArr[i15 - 1];
                i15--;
            }
            bArr[0] = b;
            bArr2[i14] = b;
        }
        char[][] cArr = data.temp_charArray2d;
        for (int i16 = 0; i16 < iBsR; i16++) {
            int iBsR3 = bsR(bitInputStream, 5);
            char[] cArr2 = cArr[i16];
            for (int i17 = 0; i17 < i10; i17++) {
                while (bsGetBit(bitInputStream)) {
                    iBsR3 += bsGetBit(bitInputStream) ? -1 : 1;
                }
                cArr2[i17] = (char) iBsR3;
            }
        }
        createHuffmanDecodingTables(i10, iBsR);
    }

    private int setupBlock() throws IOException {
        Data data;
        if (this.currentState == 0 || (data = this.data) == null) {
            return -1;
        }
        int[] iArr = data.cftab;
        int i5 = this.last + 1;
        int[] iArrInitTT = data.initTT(i5);
        Data data2 = this.data;
        byte[] bArr = data2.ll8;
        iArr[0] = 0;
        System.arraycopy(data2.unzftab, 0, iArr, 1, 256);
        int i6 = iArr[0];
        for (int i7 = 1; i7 <= 256; i7++) {
            i6 += iArr[i7];
            iArr[i7] = i6;
        }
        int i8 = this.last;
        for (int i9 = 0; i9 <= i8; i9++) {
            int i10 = bArr[i9] & UnsignedBytes.MAX_VALUE;
            int i11 = iArr[i10];
            iArr[i10] = i11 + 1;
            checkBounds(i11, i5, "tt index");
            iArrInitTT[i11] = i9;
        }
        int i12 = this.origPtr;
        if (i12 < 0 || i12 >= iArrInitTT.length) {
            throw new IOException("Stream corrupted");
        }
        this.su_tPos = iArrInitTT[i12];
        this.su_count = 0;
        this.su_i2 = 0;
        this.su_ch2 = 256;
        if (!this.blockRandomised) {
            return setupNoRandPartA();
        }
        this.su_rNToGo = 0;
        this.su_rTPos = 0;
        return setupRandPartA();
    }

    private int setupNoRandPartA() throws IOException {
        if (this.su_i2 > this.last) {
            this.currentState = 5;
            endBlock();
            initBlock();
            return setupBlock();
        }
        this.su_chPrev = this.su_ch2;
        Data data = this.data;
        byte[] bArr = data.ll8;
        int i5 = this.su_tPos;
        int i6 = bArr[i5] & UnsignedBytes.MAX_VALUE;
        this.su_ch2 = i6;
        checkBounds(i5, data.tt.length, "su_tPos");
        this.su_tPos = this.data.tt[this.su_tPos];
        this.su_i2++;
        this.currentState = 6;
        this.crc.updateCRC(i6);
        return i6;
    }

    private int setupNoRandPartB() throws IOException {
        if (this.su_ch2 != this.su_chPrev) {
            this.su_count = 1;
            return setupNoRandPartA();
        }
        int i5 = this.su_count + 1;
        this.su_count = i5;
        if (i5 < 4) {
            return setupNoRandPartA();
        }
        checkBounds(this.su_tPos, this.data.ll8.length, "su_tPos");
        Data data = this.data;
        byte[] bArr = data.ll8;
        int i6 = this.su_tPos;
        this.su_z = (char) (bArr[i6] & UnsignedBytes.MAX_VALUE);
        this.su_tPos = data.tt[i6];
        this.su_j2 = 0;
        return setupNoRandPartC();
    }

    private int setupNoRandPartC() {
        if (this.su_j2 >= this.su_z) {
            this.su_i2++;
            this.su_count = 0;
            return setupNoRandPartA();
        }
        int i5 = this.su_ch2;
        this.crc.updateCRC(i5);
        this.su_j2++;
        this.currentState = 7;
        return i5;
    }

    private int setupRandPartA() throws IOException {
        if (this.su_i2 > this.last) {
            endBlock();
            initBlock();
            return setupBlock();
        }
        this.su_chPrev = this.su_ch2;
        Data data = this.data;
        byte[] bArr = data.ll8;
        int i5 = this.su_tPos;
        int i6 = bArr[i5] & UnsignedBytes.MAX_VALUE;
        checkBounds(i5, data.tt.length, "su_tPos");
        this.su_tPos = this.data.tt[this.su_tPos];
        int i7 = this.su_rNToGo;
        if (i7 == 0) {
            this.su_rNToGo = Rand.rNums(this.su_rTPos) - 1;
            int i8 = this.su_rTPos + 1;
            this.su_rTPos = i8;
            if (i8 == 512) {
                this.su_rTPos = 0;
            }
        } else {
            this.su_rNToGo = i7 - 1;
        }
        int i9 = i6 ^ (this.su_rNToGo == 1 ? 1 : 0);
        this.su_ch2 = i9;
        this.su_i2++;
        this.currentState = 3;
        this.crc.updateCRC(i9);
        return i9;
    }

    private int setupRandPartB() throws IOException {
        if (this.su_ch2 != this.su_chPrev) {
            this.currentState = 2;
            this.su_count = 1;
            return setupRandPartA();
        }
        int i5 = this.su_count + 1;
        this.su_count = i5;
        if (i5 < 4) {
            this.currentState = 2;
            return setupRandPartA();
        }
        Data data = this.data;
        byte[] bArr = data.ll8;
        int i6 = this.su_tPos;
        this.su_z = (char) (bArr[i6] & UnsignedBytes.MAX_VALUE);
        checkBounds(i6, data.tt.length, "su_tPos");
        this.su_tPos = this.data.tt[this.su_tPos];
        int i7 = this.su_rNToGo;
        if (i7 == 0) {
            this.su_rNToGo = Rand.rNums(this.su_rTPos) - 1;
            int i8 = this.su_rTPos + 1;
            this.su_rTPos = i8;
            if (i8 == 512) {
                this.su_rTPos = 0;
            }
        } else {
            this.su_rNToGo = i7 - 1;
        }
        this.su_j2 = 0;
        this.currentState = 4;
        if (this.su_rNToGo == 1) {
            this.su_z = (char) (this.su_z ^ 1);
        }
        return setupRandPartC();
    }

    private int setupRandPartC() {
        if (this.su_j2 < this.su_z) {
            this.crc.updateCRC(this.su_ch2);
            this.su_j2++;
            return this.su_ch2;
        }
        this.currentState = 2;
        this.su_i2++;
        this.su_count = 0;
        return setupRandPartA();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        BitInputStream bitInputStream = this.bin;
        if (bitInputStream != null) {
            try {
                bitInputStream.close();
            } finally {
                this.data = null;
                this.bin = null;
            }
        }
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.bin.getBytesRead();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.bin == null) {
            throw new IOException("Stream closed");
        }
        int i5 = read0();
        count(i5 < 0 ? -1 : 1);
        return i5;
    }

    public BZip2CompressorInputStream(InputStream inputStream, boolean z6) throws IOException {
        this.crc = new CRC();
        this.currentState = 1;
        this.bin = new BitInputStream(inputStream == System.in ? new CloseShieldFilterInputStream(inputStream) : inputStream, ByteOrder.BIG_ENDIAN);
        this.decompressConcatenated = z6;
        init(true);
        initBlock();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        if (i5 < 0) {
            throw new IndexOutOfBoundsException(a.i(i5, "offs(", ") < 0."));
        }
        if (i6 >= 0) {
            int i7 = i5 + i6;
            if (i7 <= bArr.length) {
                if (this.bin == null) {
                    throw new IOException("Stream closed");
                }
                if (i6 == 0) {
                    return 0;
                }
                int i8 = i5;
                while (i8 < i7) {
                    int i9 = read0();
                    if (i9 < 0) {
                        break;
                    }
                    bArr[i8] = (byte) i9;
                    count(1);
                    i8++;
                }
                if (i8 == i5) {
                    return -1;
                }
                return i8 - i5;
            }
            throw new IndexOutOfBoundsException(AbstractC0157z.l(").", bArr.length, a.s("offs(", i5, i6, ") + len(", ") > dest.length(")));
        }
        throw new IndexOutOfBoundsException(a.i(i6, "len(", ") < 0."));
    }
}
