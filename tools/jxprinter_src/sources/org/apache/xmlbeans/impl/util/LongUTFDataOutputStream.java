package org.apache.xmlbeans.impl.util;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class LongUTFDataOutputStream extends DataOutputStream {
    static final int MAX_UNSIGNED_SHORT = 65534;

    public LongUTFDataOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public static int countUTF(String str) {
        int length = str.length();
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char cCharAt = str.charAt(i6);
            i5 = (cCharAt < 1 || cCharAt > 127) ? cCharAt > 2047 ? i5 + 3 : i5 + 2 : i5 + 1;
        }
        return i5;
    }

    public void writeLongUTF(String str) throws IOException {
        int i5;
        int i6;
        writeShortOrInt(countUTF(str));
        byte[] bArr = new byte[4096];
        int length = str.length();
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            if (i7 >= 4093) {
                write(bArr, 0, i7);
                i7 = 0;
            }
            char cCharAt = str.charAt(i8);
            if (cCharAt < 1 || cCharAt > 127) {
                if (cCharAt > 2047) {
                    int i9 = i7 + 1;
                    bArr[i7] = (byte) (((cCharAt >> '\f') & 15) | 224);
                    i5 = i7 + 2;
                    bArr[i9] = (byte) (((cCharAt >> 6) & 63) | 128);
                } else {
                    bArr[i7] = (byte) (((cCharAt >> 6) & 31) | 192);
                    i5 = i7 + 1;
                }
                i6 = i5 + 1;
                bArr[i5] = (byte) ((cCharAt & '?') | 128);
            } else {
                i6 = i7 + 1;
                bArr[i7] = (byte) cCharAt;
            }
            i7 = i6;
        }
        write(bArr, 0, i7);
    }

    public void writeShortOrInt(int i5) throws IOException {
        writeShortOrInt(this, i5);
    }

    public static void writeShortOrInt(DataOutputStream dataOutputStream, int i5) throws IOException {
        if (i5 < MAX_UNSIGNED_SHORT) {
            dataOutputStream.writeShort(i5);
        } else {
            dataOutputStream.writeShort(MAX_UNSIGNED_SHORT);
            dataOutputStream.writeInt(i5);
        }
    }
}
