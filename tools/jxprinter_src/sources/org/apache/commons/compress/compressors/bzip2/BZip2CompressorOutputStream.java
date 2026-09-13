package org.apache.commons.compress.compressors.bzip2;

import A3.AbstractC0157z;
import androidx.collection.a;
import androidx.core.view.InputDeviceCompat;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BZip2CompressorOutputStream extends CompressorOutputStream implements BZip2Constants {
    private static final int GREATER_ICOST = 15;
    private static final int LESSER_ICOST = 0;
    public static final int MAX_BLOCKSIZE = 9;
    public static final int MIN_BLOCKSIZE = 1;
    private final int allowableBlockSize;
    private int blockCRC;
    private final int blockSize100k;
    private BlockSort blockSorter;
    private int bsBuff;
    private int bsLive;
    private volatile boolean closed;
    private int combinedCRC;
    private final CRC crc;
    private int currentChar;
    private Data data;
    private int last;
    private int nInUse;
    private int nMTF;
    private OutputStream out;
    private int runLength;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Data {
        final byte[] block;
        final int[] fmap;
        final int[] heap;
        int origPtr;
        final int[] parent;
        final byte[] sendMTFValues2_pos;
        final int[][] sendMTFValues_code;
        final short[] sendMTFValues_cost;
        final int[] sendMTFValues_fave;
        final int[][] sendMTFValues_rfreq;
        final boolean[] sentMTFValues4_inUse16;
        final char[] sfmap;
        final int[] weight;
        final boolean[] inUse = new boolean[256];
        final byte[] unseqToSeq = new byte[256];
        final int[] mtfFreq = new int[258];
        final byte[] selector = new byte[BZip2Constants.MAX_SELECTORS];
        final byte[] selectorMtf = new byte[BZip2Constants.MAX_SELECTORS];
        final byte[] generateMTFValues_yy = new byte[256];
        final byte[][] sendMTFValues_len = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 6, 258);

        public Data(int i5) {
            Class cls = Integer.TYPE;
            this.sendMTFValues_rfreq = (int[][]) Array.newInstance((Class<?>) cls, 6, 258);
            this.sendMTFValues_fave = new int[6];
            this.sendMTFValues_cost = new short[6];
            this.sendMTFValues_code = (int[][]) Array.newInstance((Class<?>) cls, 6, 258);
            this.sendMTFValues2_pos = new byte[6];
            this.sentMTFValues4_inUse16 = new boolean[16];
            this.heap = new int[260];
            this.weight = new int[Videoio.CAP_PROP_XI_LENS_FOCAL_LENGTH];
            this.parent = new int[Videoio.CAP_PROP_XI_LENS_FOCAL_LENGTH];
            int i6 = BZip2Constants.BASEBLOCKSIZE * i5;
            this.block = new byte[i6 + 21];
            this.fmap = new int[i6];
            this.sfmap = new char[i5 * 200000];
        }
    }

    public BZip2CompressorOutputStream(OutputStream outputStream) {
        this(outputStream, 9);
    }

    private void blockSort() {
        this.blockSorter.blockSort(this.data, this.last);
    }

    private void bsFinishedWithStream() throws IOException {
        while (this.bsLive > 0) {
            this.out.write(this.bsBuff >> 24);
            this.bsBuff <<= 8;
            this.bsLive -= 8;
        }
    }

    private void bsPutInt(int i5) throws IOException {
        bsW(8, (i5 >> 24) & 255);
        bsW(8, (i5 >> 16) & 255);
        bsW(8, (i5 >> 8) & 255);
        bsW(8, i5 & 255);
    }

    private void bsPutUByte(int i5) throws IOException {
        bsW(8, i5);
    }

    private void bsW(int i5, int i6) throws IOException {
        OutputStream outputStream = this.out;
        int i7 = this.bsLive;
        int i8 = this.bsBuff;
        while (i7 >= 8) {
            outputStream.write(i8 >> 24);
            i8 <<= 8;
            i7 -= 8;
        }
        this.bsBuff = (i6 << ((32 - i7) - i5)) | i8;
        this.bsLive = i7 + i5;
    }

    public static int chooseBlockSize(long j6) {
        if (j6 > 0) {
            return (int) Math.min((j6 / 132000) + 1, 9L);
        }
        return 9;
    }

    private void endBlock() throws IOException {
        int finalCRC = this.crc.getFinalCRC();
        this.blockCRC = finalCRC;
        int i5 = this.combinedCRC;
        this.combinedCRC = finalCRC ^ ((i5 >>> 31) | (i5 << 1));
        if (this.last == -1) {
            return;
        }
        blockSort();
        bsPutUByte(49);
        bsPutUByte(65);
        bsPutUByte(89);
        bsPutUByte(38);
        bsPutUByte(83);
        bsPutUByte(89);
        bsPutInt(this.blockCRC);
        bsW(1, 0);
        moveToFrontCodeAndSend();
    }

    private void endCompression() throws IOException {
        bsPutUByte(23);
        bsPutUByte(114);
        bsPutUByte(69);
        bsPutUByte(56);
        bsPutUByte(80);
        bsPutUByte(144);
        bsPutInt(this.combinedCRC);
        bsFinishedWithStream();
    }

    private void generateMTFValues() {
        int i5 = this.last;
        Data data = this.data;
        boolean[] zArr = data.inUse;
        byte[] bArr = data.block;
        int[] iArr = data.fmap;
        char[] cArr = data.sfmap;
        int[] iArr2 = data.mtfFreq;
        byte[] bArr2 = data.unseqToSeq;
        byte[] bArr3 = data.generateMTFValues_yy;
        char c = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < 256; i7++) {
            if (zArr[i7]) {
                bArr2[i7] = (byte) i6;
                i6++;
            }
        }
        this.nInUse = i6;
        int i8 = i6 + 1;
        for (int i9 = i8; i9 >= 0; i9--) {
            iArr2[i9] = 0;
        }
        while (true) {
            i6--;
            if (i6 < 0) {
                break;
            } else {
                bArr3[i6] = (byte) i6;
            }
        }
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 <= i5) {
            byte b = bArr2[bArr[iArr[i10]] & UnsignedBytes.MAX_VALUE];
            char c6 = c;
            byte b6 = bArr3[c];
            int i13 = c6;
            while (b != b6) {
                i13++;
                byte b7 = bArr3[i13];
                bArr3[i13] = b6;
                b6 = b7;
            }
            bArr3[c6] = b6;
            if (i13 == 0) {
                i11++;
            } else {
                if (i11 > 0) {
                    int i14 = i11 - 1;
                    while (true) {
                        if ((i14 & 1) == 0) {
                            cArr[i12] = c6;
                            i12++;
                            iArr2[c6] = iArr2[c6] + 1;
                        } else {
                            cArr[i12] = 1;
                            i12++;
                            iArr2[1] = iArr2[1] + 1;
                        }
                        if (i14 < 2) {
                            break;
                        } else {
                            i14 = (i14 - 2) >> 1;
                        }
                    }
                    i11 = c6;
                }
                int i15 = i13 + 1;
                cArr[i12] = (char) i15;
                i12++;
                iArr2[i15] = iArr2[i15] + 1;
            }
            i10++;
            c = c6;
        }
        char c7 = c;
        if (i11 > 0) {
            int i16 = i11 - 1;
            while (true) {
                if ((i16 & 1) == 0) {
                    cArr[i12] = c7;
                    i12++;
                    iArr2[c7] = iArr2[c7] + 1;
                } else {
                    cArr[i12] = 1;
                    i12++;
                    iArr2[1] = iArr2[1] + 1;
                }
                if (i16 < 2) {
                    break;
                } else {
                    i16 = (i16 - 2) >> 1;
                }
            }
        }
        cArr[i12] = (char) i8;
        iArr2[i8] = iArr2[i8] + 1;
        this.nMTF = i12 + 1;
    }

    private static void hbAssignCodes(int[] iArr, byte[] bArr, int i5, int i6, int i7) {
        int i8 = 0;
        while (i5 <= i6) {
            for (int i9 = 0; i9 < i7; i9++) {
                if ((bArr[i9] & 255) == i5) {
                    iArr[i9] = i8;
                    i8++;
                }
            }
            i8 <<= 1;
            i5++;
        }
    }

    private static void hbMakeCodeLengths(byte[] bArr, int[] iArr, Data data, int i5, int i6) {
        int i7;
        int i8;
        int[] iArr2 = data.heap;
        int[] iArr3 = data.weight;
        int[] iArr4 = data.parent;
        int i9 = i5;
        while (true) {
            int i10 = i9 - 1;
            i7 = 1;
            if (i10 < 0) {
                break;
            }
            int i11 = iArr[i10];
            if (i11 != 0) {
                i7 = i11;
            }
            iArr3[i9] = i7 << 8;
            i9 = i10;
        }
        int i12 = 1;
        while (i12 != 0) {
            iArr2[0] = 0;
            iArr3[0] = 0;
            iArr4[0] = -2;
            int i13 = 0;
            for (int i14 = i7; i14 <= i5; i14++) {
                iArr4[i14] = -1;
                i13++;
                iArr2[i13] = i14;
                int i15 = i13;
                while (true) {
                    int i16 = iArr3[i14];
                    int i17 = i15 >> 1;
                    int i18 = iArr2[i17];
                    if (i16 < iArr3[i18]) {
                        iArr2[i15] = i18;
                        i15 = i17;
                    }
                }
                iArr2[i15] = i14;
            }
            int i19 = i5;
            while (i13 > i7) {
                int i20 = iArr2[i7];
                int i21 = iArr2[i13];
                iArr2[i7] = i21;
                int i22 = i13 - 1;
                int i23 = i7;
                while (true) {
                    int i24 = i23 << 1;
                    if (i24 > i22) {
                        break;
                    }
                    if (i24 < i22) {
                        int i25 = i24 + 1;
                        if (iArr3[iArr2[i25]] < iArr3[iArr2[i24]]) {
                            i24 = i25;
                        }
                    }
                    int i26 = iArr3[i21];
                    int i27 = iArr2[i24];
                    if (i26 < iArr3[i27]) {
                        break;
                    }
                    iArr2[i23] = i27;
                    i23 = i24;
                }
                iArr2[i23] = i21;
                int i28 = iArr2[i7];
                int i29 = iArr2[i22];
                iArr2[i7] = i29;
                int i30 = i13 - 2;
                int i31 = i7;
                while (true) {
                    int i32 = i31 << 1;
                    if (i32 > i30) {
                        i8 = i7;
                        break;
                    }
                    if (i32 < i30) {
                        int i33 = i32 + 1;
                        i8 = i7;
                        if (iArr3[iArr2[i33]] < iArr3[iArr2[i32]]) {
                            i32 = i33;
                        }
                    } else {
                        i8 = i7;
                    }
                    int i34 = iArr3[i29];
                    int i35 = iArr2[i32];
                    if (i34 < iArr3[i35]) {
                        break;
                    }
                    iArr2[i31] = i35;
                    i7 = i8;
                    i31 = i32;
                }
                iArr2[i31] = i29;
                i19++;
                iArr4[i28] = i19;
                iArr4[i20] = i19;
                int i36 = iArr3[i20];
                int i37 = iArr3[i28];
                int i38 = (i36 & InputDeviceCompat.SOURCE_ANY) + (i37 & InputDeviceCompat.SOURCE_ANY);
                int i39 = i36 & 255;
                int i40 = i37 & 255;
                if (i39 <= i40) {
                    i39 = i40;
                }
                iArr3[i19] = i38 | (i39 + 1);
                iArr4[i19] = -1;
                i13--;
                iArr2[i13] = i19;
                int i41 = iArr3[i19];
                int i42 = i13;
                while (true) {
                    int i43 = i42 >> 1;
                    int i44 = iArr2[i43];
                    if (i41 < iArr3[i44]) {
                        iArr2[i42] = i44;
                        i42 = i43;
                    }
                }
                iArr2[i42] = i19;
                i7 = i8;
            }
            int i45 = i7;
            i12 = 0;
            for (int i46 = i45; i46 <= i5; i46++) {
                int i47 = i46;
                int i48 = 0;
                while (true) {
                    i47 = iArr4[i47];
                    if (i47 < 0) {
                        break;
                    } else {
                        i48++;
                    }
                }
                bArr[i46 - 1] = (byte) i48;
                if (i48 > i6) {
                    i12 = i45;
                }
            }
            if (i12 != 0) {
                for (int i49 = i45; i49 < i5; i49++) {
                    iArr3[i49] = ((iArr3[i49] >> 9) + 1) << 8;
                }
            }
            i7 = i45;
        }
    }

    private void init() throws IOException {
        bsPutUByte(66);
        bsPutUByte(90);
        Data data = new Data(this.blockSize100k);
        this.data = data;
        this.blockSorter = new BlockSort(data);
        bsPutUByte(104);
        bsPutUByte(this.blockSize100k + 48);
        this.combinedCRC = 0;
        initBlock();
    }

    private void initBlock() {
        this.crc.initializeCRC();
        this.last = -1;
        boolean[] zArr = this.data.inUse;
        int i5 = 256;
        while (true) {
            i5--;
            if (i5 < 0) {
                return;
            } else {
                zArr[i5] = false;
            }
        }
    }

    private void moveToFrontCodeAndSend() throws IOException {
        bsW(24, this.data.origPtr);
        generateMTFValues();
        sendMTFValues();
    }

    private void sendMTFValues() throws IOException {
        byte[][] bArr = this.data.sendMTFValues_len;
        int i5 = 2;
        int i6 = this.nInUse + 2;
        int i7 = 6;
        while (true) {
            i7--;
            if (i7 < 0) {
                break;
            }
            byte[] bArr2 = bArr[i7];
            int i8 = i6;
            while (true) {
                i8--;
                if (i8 >= 0) {
                    bArr2[i8] = 15;
                }
            }
        }
        int i9 = this.nMTF;
        if (i9 >= 200) {
            if (i9 < 600) {
                i5 = 3;
            } else if (i9 < 1200) {
                i5 = 4;
            } else {
                i5 = i9 < 2400 ? 5 : 6;
            }
        }
        sendMTFValues0(i5, i6);
        int iSendMTFValues1 = sendMTFValues1(i5, i6);
        sendMTFValues2(i5, iSendMTFValues1);
        sendMTFValues3(i5, i6);
        sendMTFValues4();
        sendMTFValues5(i5, iSendMTFValues1);
        sendMTFValues6(i5, i6);
        sendMTFValues7();
    }

    private void sendMTFValues0(int i5, int i6) {
        Data data = this.data;
        byte[][] bArr = data.sendMTFValues_len;
        int[] iArr = data.mtfFreq;
        int i7 = this.nMTF;
        int i8 = 0;
        for (int i9 = i5; i9 > 0; i9--) {
            int i10 = i7 / i9;
            int i11 = i8 - 1;
            int i12 = i6 - 1;
            int i13 = 0;
            while (i13 < i10 && i11 < i12) {
                i11++;
                i13 += iArr[i11];
            }
            if (i11 > i8 && i9 != i5 && i9 != 1 && (1 & (i5 - i9)) != 0) {
                i13 -= iArr[i11];
                i11--;
            }
            byte[] bArr2 = bArr[i9 - 1];
            int i14 = i6;
            while (true) {
                i14--;
                if (i14 >= 0) {
                    if (i14 < i8 || i14 > i11) {
                        bArr2[i14] = 15;
                    } else {
                        bArr2[i14] = 0;
                    }
                }
            }
            i8 = i11 + 1;
            i7 -= i13;
        }
    }

    private int sendMTFValues1(int i5, int i6) {
        int[][] iArr;
        Data data = this.data;
        int[][] iArr2 = data.sendMTFValues_rfreq;
        int[] iArr3 = data.sendMTFValues_fave;
        short[] sArr = data.sendMTFValues_cost;
        char[] cArr = data.sfmap;
        byte[] bArr = data.selector;
        byte[][] bArr2 = data.sendMTFValues_len;
        byte[] bArr3 = bArr2[0];
        byte[] bArr4 = bArr2[1];
        byte[] bArr5 = bArr2[2];
        char c = 3;
        byte[] bArr6 = bArr2[3];
        int i7 = 4;
        byte[] bArr7 = bArr2[4];
        byte[] bArr8 = bArr2[5];
        int i8 = this.nMTF;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i7) {
            int i11 = i5;
            while (true) {
                i11--;
                if (i11 < 0) {
                    break;
                }
                iArr3[i11] = 0;
                int[] iArr4 = iArr2[i11];
                int i12 = i6;
                while (true) {
                    i12--;
                    if (i12 >= 0) {
                        iArr4[i12] = 0;
                    }
                }
            }
            int i13 = i7;
            char c6 = c;
            int i14 = 0;
            i10 = 0;
            while (i14 < this.nMTF) {
                byte[][] bArr9 = bArr2;
                int iMin = Math.min(i14 + 49, i8 - 1);
                if (i5 == 6) {
                    int i15 = i14;
                    short s6 = 0;
                    short s7 = 0;
                    short s8 = 0;
                    short s9 = 0;
                    short s10 = 0;
                    short s11 = 0;
                    while (i15 <= iMin) {
                        char c7 = cArr[i15];
                        s6 = (short) (s6 + (bArr3[c7] & UnsignedBytes.MAX_VALUE));
                        s7 = (short) (s7 + (bArr4[c7] & UnsignedBytes.MAX_VALUE));
                        s8 = (short) (s8 + (bArr5[c7] & UnsignedBytes.MAX_VALUE));
                        s9 = (short) (s9 + (bArr6[c7] & UnsignedBytes.MAX_VALUE));
                        s10 = (short) (s10 + (bArr7[c7] & UnsignedBytes.MAX_VALUE));
                        i15++;
                        s11 = (short) (s11 + (bArr8[c7] & UnsignedBytes.MAX_VALUE));
                        iArr2 = iArr2;
                    }
                    iArr = iArr2;
                    sArr[0] = s6;
                    sArr[1] = s7;
                    sArr[2] = s8;
                    sArr[c6] = s9;
                    sArr[i13] = s10;
                    sArr[5] = s11;
                } else {
                    iArr = iArr2;
                    int i16 = i5;
                    while (true) {
                        i16--;
                        if (i16 < 0) {
                            break;
                        }
                        sArr[i16] = 0;
                    }
                    int i17 = i14;
                    while (i17 <= iMin) {
                        char c8 = cArr[i17];
                        int i18 = i5;
                        while (true) {
                            i18--;
                            if (i18 >= 0) {
                                sArr[i18] = (short) (sArr[i18] + (bArr9[i18][c8] & UnsignedBytes.MAX_VALUE));
                                i17 = i17;
                            }
                        }
                        i17++;
                    }
                }
                short s12 = 999999999;
                int i19 = i5;
                int[] iArr5 = iArr3;
                int i20 = -1;
                while (true) {
                    i19--;
                    if (i19 < 0) {
                        break;
                    }
                    short[] sArr2 = sArr;
                    short s13 = sArr2[i19];
                    if (s13 < s12) {
                        s12 = s13;
                        i20 = i19;
                    }
                    sArr = sArr2;
                }
                short[] sArr3 = sArr;
                iArr5[i20] = iArr5[i20] + 1;
                bArr[i10] = (byte) i20;
                i10++;
                int[] iArr6 = iArr[i20];
                while (i14 <= iMin) {
                    char c9 = cArr[i14];
                    iArr6[c9] = iArr6[c9] + 1;
                    i14++;
                }
                i14 = iMin + 1;
                bArr2 = bArr9;
                iArr3 = iArr5;
                sArr = sArr3;
                iArr2 = iArr;
            }
            byte[][] bArr10 = bArr2;
            int[][] iArr7 = iArr2;
            int[] iArr8 = iArr3;
            short[] sArr4 = sArr;
            for (int i21 = 0; i21 < i5; i21++) {
                hbMakeCodeLengths(bArr10[i21], iArr7[i21], this.data, i6, 20);
            }
            i9++;
            i7 = i13;
            c = c6;
            bArr2 = bArr10;
            iArr3 = iArr8;
            sArr = sArr4;
            iArr2 = iArr7;
        }
        return i10;
    }

    private void sendMTFValues2(int i5, int i6) {
        Data data = this.data;
        byte[] bArr = data.sendMTFValues2_pos;
        while (true) {
            i5--;
            if (i5 < 0) {
                break;
            } else {
                bArr[i5] = (byte) i5;
            }
        }
        for (int i7 = 0; i7 < i6; i7++) {
            byte b = data.selector[i7];
            byte b6 = bArr[0];
            int i8 = 0;
            while (b != b6) {
                i8++;
                byte b7 = bArr[i8];
                bArr[i8] = b6;
                b6 = b7;
            }
            bArr[0] = b6;
            data.selectorMtf[i7] = (byte) i8;
        }
    }

    private void sendMTFValues3(int i5, int i6) {
        Data data = this.data;
        int[][] iArr = data.sendMTFValues_code;
        byte[][] bArr = data.sendMTFValues_len;
        for (int i7 = 0; i7 < i5; i7++) {
            byte[] bArr2 = bArr[i7];
            int i8 = 32;
            int i9 = i6;
            int i10 = 0;
            while (true) {
                i9--;
                if (i9 >= 0) {
                    int i11 = bArr2[i9] & UnsignedBytes.MAX_VALUE;
                    if (i11 > i10) {
                        i10 = i11;
                    }
                    if (i11 < i8) {
                        i8 = i11;
                    }
                }
            }
            hbAssignCodes(iArr[i7], bArr[i7], i8, i10, i6);
        }
    }

    private void sendMTFValues4() throws IOException {
        Data data = this.data;
        boolean[] zArr = data.inUse;
        boolean[] zArr2 = data.sentMTFValues4_inUse16;
        int i5 = 16;
        while (true) {
            i5--;
            if (i5 < 0) {
                break;
            }
            zArr2[i5] = false;
            int i6 = i5 * 16;
            int i7 = 16;
            while (true) {
                i7--;
                if (i7 >= 0) {
                    if (zArr[i6 + i7]) {
                        zArr2[i5] = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        for (int i8 = 0; i8 < 16; i8++) {
            bsW(1, zArr2[i8] ? 1 : 0);
        }
        OutputStream outputStream = this.out;
        int i9 = this.bsLive;
        int i10 = this.bsBuff;
        for (int i11 = 0; i11 < 16; i11++) {
            if (zArr2[i11]) {
                int i12 = i11 * 16;
                for (int i13 = 0; i13 < 16; i13++) {
                    while (i9 >= 8) {
                        outputStream.write(i10 >> 24);
                        i10 <<= 8;
                        i9 -= 8;
                    }
                    if (zArr[i12 + i13]) {
                        i10 |= 1 << (31 - i9);
                    }
                    i9++;
                }
            }
        }
        this.bsBuff = i10;
        this.bsLive = i9;
    }

    private void sendMTFValues5(int i5, int i6) throws IOException {
        bsW(3, i5);
        bsW(15, i6);
        OutputStream outputStream = this.out;
        byte[] bArr = this.data.selectorMtf;
        int i7 = this.bsLive;
        int i8 = this.bsBuff;
        for (int i9 = 0; i9 < i6; i9++) {
            int i10 = bArr[i9] & UnsignedBytes.MAX_VALUE;
            for (int i11 = 0; i11 < i10; i11++) {
                while (i7 >= 8) {
                    outputStream.write(i8 >> 24);
                    i8 <<= 8;
                    i7 -= 8;
                }
                i8 |= 1 << (31 - i7);
                i7++;
            }
            while (i7 >= 8) {
                outputStream.write(i8 >> 24);
                i8 <<= 8;
                i7 -= 8;
            }
            i7++;
        }
        this.bsBuff = i8;
        this.bsLive = i7;
    }

    private void sendMTFValues6(int i5, int i6) throws IOException {
        byte[][] bArr = this.data.sendMTFValues_len;
        OutputStream outputStream = this.out;
        int i7 = this.bsLive;
        int i8 = this.bsBuff;
        for (int i9 = 0; i9 < i5; i9++) {
            byte[] bArr2 = bArr[i9];
            int i10 = bArr2[0] & UnsignedBytes.MAX_VALUE;
            while (i7 >= 8) {
                outputStream.write(i8 >> 24);
                i8 <<= 8;
                i7 -= 8;
            }
            i8 |= i10 << (27 - i7);
            i7 += 5;
            for (int i11 = 0; i11 < i6; i11++) {
                int i12 = bArr2[i11] & UnsignedBytes.MAX_VALUE;
                while (i10 < i12) {
                    while (i7 >= 8) {
                        outputStream.write(i8 >> 24);
                        i8 <<= 8;
                        i7 -= 8;
                    }
                    i8 |= 2 << (30 - i7);
                    i7 += 2;
                    i10++;
                }
                while (i10 > i12) {
                    while (i7 >= 8) {
                        outputStream.write(i8 >> 24);
                        i8 <<= 8;
                        i7 -= 8;
                    }
                    i8 |= 3 << (30 - i7);
                    i7 += 2;
                    i10--;
                }
                while (i7 >= 8) {
                    outputStream.write(i8 >> 24);
                    i8 <<= 8;
                    i7 -= 8;
                }
                i7++;
            }
        }
        this.bsBuff = i8;
        this.bsLive = i7;
    }

    private void sendMTFValues7() throws IOException {
        Data data = this.data;
        byte[][] bArr = data.sendMTFValues_len;
        int[][] iArr = data.sendMTFValues_code;
        OutputStream outputStream = this.out;
        byte[] bArr2 = data.selector;
        char[] cArr = data.sfmap;
        int i5 = this.nMTF;
        int i6 = this.bsLive;
        int i7 = this.bsBuff;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i5) {
            int iMin = Math.min(i8 + 49, i5 - 1);
            int i10 = bArr2[i9] & UnsignedBytes.MAX_VALUE;
            int[] iArr2 = iArr[i10];
            byte[] bArr3 = bArr[i10];
            while (i8 <= iMin) {
                char c = cArr[i8];
                while (i6 >= 8) {
                    outputStream.write(i7 >> 24);
                    i7 <<= 8;
                    i6 -= 8;
                }
                int i11 = bArr3[c] & UnsignedBytes.MAX_VALUE;
                i7 |= iArr2[c] << ((32 - i6) - i11);
                i6 += i11;
                i8++;
            }
            i8 = iMin + 1;
            i9++;
        }
        this.bsBuff = i7;
        this.bsLive = i6;
    }

    private void write0(int i5) throws IOException {
        int i6 = this.currentChar;
        if (i6 == -1) {
            this.currentChar = i5 & 255;
            this.runLength++;
            return;
        }
        int i7 = i5 & 255;
        if (i6 != i7) {
            writeRun();
            this.runLength = 1;
            this.currentChar = i7;
            return;
        }
        int i8 = this.runLength + 1;
        this.runLength = i8;
        if (i8 > 254) {
            writeRun();
            this.currentChar = -1;
            this.runLength = 0;
        }
    }

    private void writeRun() throws IOException {
        int i5 = this.last;
        if (i5 >= this.allowableBlockSize) {
            endBlock();
            initBlock();
            writeRun();
            return;
        }
        int i6 = this.currentChar;
        Data data = this.data;
        data.inUse[i6] = true;
        byte b = (byte) i6;
        int i7 = this.runLength;
        this.crc.updateCRC(i6, i7);
        if (i7 == 1) {
            data.block[i5 + 2] = b;
            this.last = i5 + 1;
            return;
        }
        if (i7 == 2) {
            byte[] bArr = data.block;
            int i8 = i5 + 2;
            bArr[i8] = b;
            bArr[i5 + 3] = b;
            this.last = i8;
            return;
        }
        if (i7 == 3) {
            byte[] bArr2 = data.block;
            bArr2[i5 + 2] = b;
            int i9 = i5 + 3;
            bArr2[i9] = b;
            bArr2[i5 + 4] = b;
            this.last = i9;
            return;
        }
        int i10 = i7 - 4;
        data.inUse[i10] = true;
        byte[] bArr3 = data.block;
        bArr3[i5 + 2] = b;
        bArr3[i5 + 3] = b;
        bArr3[i5 + 4] = b;
        int i11 = i5 + 5;
        bArr3[i11] = b;
        bArr3[i5 + 6] = (byte) i10;
        this.last = i11;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        OutputStream outputStream = this.out;
        try {
            finish();
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public void finalize() throws Throwable {
        if (!this.closed) {
            System.err.println("Unclosed BZip2CompressorOutputStream detected, will *not* close it");
        }
        super.finalize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        try {
            if (this.runLength > 0) {
                writeRun();
            }
            this.currentChar = -1;
            endBlock();
            endCompression();
        } finally {
            this.out = null;
            this.blockSorter = null;
            this.data = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        OutputStream outputStream = this.out;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    public final int getBlockSize() {
        return this.blockSize100k;
    }

    @Override // java.io.OutputStream
    public void write(int i5) throws IOException {
        if (this.closed) {
            throw new IOException("Closed");
        }
        write0(i5);
    }

    public BZip2CompressorOutputStream(OutputStream outputStream, int i5) throws IOException {
        this.crc = new CRC();
        this.currentChar = -1;
        if (i5 < 1) {
            throw new IllegalArgumentException(a.i(i5, "blockSize(", ") < 1"));
        }
        if (i5 > 9) {
            throw new IllegalArgumentException(a.i(i5, "blockSize(", ") > 9"));
        }
        this.blockSize100k = i5;
        this.out = outputStream;
        this.allowableBlockSize = (i5 * BZip2Constants.BASEBLOCKSIZE) - 20;
        init();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) throws IOException {
        if (i5 < 0) {
            throw new IndexOutOfBoundsException(a.i(i5, "offs(", ") < 0."));
        }
        if (i6 >= 0) {
            int i7 = i5 + i6;
            if (i7 <= bArr.length) {
                if (this.closed) {
                    throw new IOException("Stream closed");
                }
                while (i5 < i7) {
                    write0(bArr[i5]);
                    i5++;
                }
                return;
            }
            throw new IndexOutOfBoundsException(AbstractC0157z.l(").", bArr.length, a.s("offs(", i5, i6, ") + len(", ") > buf.length(")));
        }
        throw new IndexOutOfBoundsException(a.i(i6, "len(", ") < 0."));
    }
}
