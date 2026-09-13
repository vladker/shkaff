package org.apache.xmlbeans.impl.util;

import A3.AbstractC0157z;
import com.google.common.primitives.UnsignedBytes;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UTFDataFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class LongUTFDataInputStream extends DataInputStream {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface IOCall {
        byte onebyte(int[] iArr, int[] iArr2, int[] iArr3);
    }

    public LongUTFDataInputStream(InputStream inputStream) {
        super(inputStream);
    }

    private /* synthetic */ byte lambda$readLongUTF$0(int i5, byte[] bArr, int[] iArr, int[] iArr2, int[] iArr3) throws IOException {
        int i6 = iArr3[0];
        if (i6 + 1 > i5) {
            throw new UTFDataFormatException("malformed input: partial character at end");
        }
        if (iArr[0] >= iArr2[0]) {
            int iMin = Math.min(bArr.length, i5 - i6);
            iArr2[0] = iMin;
            readFully(bArr, 0, iMin);
            iArr[0] = 0;
        }
        iArr3[0] = iArr3[0] + 1;
        int i7 = iArr[0];
        iArr[0] = i7 + 1;
        return bArr[i7];
    }

    public String readLongUTF() {
        int unsignedShortOrInt = readUnsignedShortOrInt();
        StringBuilder sb = new StringBuilder(unsignedShortOrInt / 2);
        byte[] bArr = new byte[4096];
        int[] iArr = {0};
        int[] iArr2 = {0};
        int[] iArr3 = {0};
        while (iArr[0] < unsignedShortOrInt) {
            byte bLambda$readLongUTF$0 = lambda$readLongUTF$0(unsignedShortOrInt, bArr, iArr2, iArr3, iArr);
            int i5 = bLambda$readLongUTF$0 & UnsignedBytes.MAX_VALUE;
            switch (i5 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    sb.append((char) i5);
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    throw new UTFDataFormatException("malformed input around byte " + iArr[0]);
                case 12:
                case 13:
                    byte bLambda$readLongUTF$1 = lambda$readLongUTF$0(unsignedShortOrInt, bArr, iArr2, iArr3, iArr);
                    if ((bLambda$readLongUTF$1 & 192) != 128) {
                        throw new UTFDataFormatException("malformed input around byte " + iArr[0]);
                    }
                    sb.append((char) (((bLambda$readLongUTF$0 & 31) << 6) | (bLambda$readLongUTF$1 & 63)));
                    break;
                    break;
                case 14:
                    byte bLambda$readLongUTF$2 = lambda$readLongUTF$0(unsignedShortOrInt, bArr, iArr2, iArr3, iArr);
                    byte bLambda$readLongUTF$3 = lambda$readLongUTF$0(unsignedShortOrInt, bArr, iArr2, iArr3, iArr);
                    if ((bLambda$readLongUTF$2 & 192) != 128 || (bLambda$readLongUTF$3 & 192) != 128) {
                        throw new UTFDataFormatException(AbstractC0157z.q(new StringBuilder("malformed input around byte "), iArr[0], 1));
                    }
                    sb.append((char) (((bLambda$readLongUTF$0 & 15) << 12) | ((bLambda$readLongUTF$2 & 63) << 6) | (bLambda$readLongUTF$3 & 63)));
                    break;
                    break;
            }
        }
        return sb.toString();
    }

    public int readUnsignedShortOrInt() {
        return readUnsignedShortOrInt(this);
    }

    public static int readUnsignedShortOrInt(DataInputStream dataInputStream) throws IOException {
        int unsignedShort = dataInputStream.readUnsignedShort();
        return unsignedShort == 65534 ? dataInputStream.readInt() : unsignedShort;
    }
}
