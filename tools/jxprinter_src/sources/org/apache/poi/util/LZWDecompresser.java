package org.apache.poi.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LZWDecompresser {
    private static final int DEFAULT_MAX_RECORD_LENGTH = 1000000;
    public static final int DICT_MASK = 4095;
    public static final int DICT_SIZE = 4096;
    private static int MAX_RECORD_LENGTH = 1000000;
    private final int codeLengthIncrease;
    private final boolean maskMeansCompressed;
    private final boolean positionIsBigEndian;

    public LZWDecompresser(boolean z6, int i5, boolean z7) {
        this.maskMeansCompressed = z6;
        this.codeLengthIncrease = i5;
        this.positionIsBigEndian = z7;
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    public abstract int adjustDictionaryOffset(int i5);

    public byte[] decompress(InputStream inputStream) throws IOException {
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
        decompress(inputStream, unsynchronizedByteArrayOutputStream);
        return unsynchronizedByteArrayOutputStream.toByteArray();
    }

    public abstract int populateDictionary(byte[] bArr);

    public void decompress(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i5;
        byte[] bArr = new byte[4096];
        int iPopulateDictionary = populateDictionary(bArr);
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(((long) this.codeLengthIncrease) + 16, MAX_RECORD_LENGTH);
        while (true) {
            int i6 = inputStream.read();
            if (i6 == -1) {
                return;
            }
            for (int i7 = 1; i7 < 256; i7 <<= 1) {
                if (((i6 & i7) > 0) ^ this.maskMeansCompressed) {
                    int i8 = inputStream.read();
                    if (i8 != -1) {
                        bArr[iPopulateDictionary & 4095] = (byte) i8;
                        outputStream.write(i8);
                        iPopulateDictionary++;
                    }
                } else {
                    int i9 = inputStream.read();
                    int i10 = inputStream.read();
                    if (i9 == -1 || i10 == -1) {
                        break;
                    }
                    int i11 = (i10 & 15) + this.codeLengthIncrease;
                    if (this.positionIsBigEndian) {
                        i9 <<= 4;
                        i5 = i10 >>> 4;
                    } else {
                        i5 = (i10 & 240) << 4;
                    }
                    int iAdjustDictionaryOffset = adjustDictionaryOffset(i9 + i5);
                    for (int i12 = 0; i12 < i11; i12++) {
                        byte b = bArr[(iAdjustDictionaryOffset + i12) & 4095];
                        bArrSafelyAllocate[i12] = b;
                        bArr[(iPopulateDictionary + i12) & 4095] = b;
                    }
                    outputStream.write(bArrSafelyAllocate, 0, i11);
                    iPopulateDictionary += i11;
                }
            }
        }
    }
}
