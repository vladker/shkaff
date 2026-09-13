package org.apache.poi.util;

import A3.AbstractC0157z;
import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class HexDump {
    public static final String EOL = System.getProperty("line.separator");
    public static final Charset UTF8 = StandardCharsets.UTF_8;

    private HexDump() {
    }

    public static String byteToHex(int i5) {
        StringBuilder sb = new StringBuilder(4);
        writeHex(sb, ((long) i5) & 255, 2, "0x");
        return sb.toString();
    }

    public static void dump(byte[] bArr, long j6, OutputStream outputStream, int i5, int i6) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("cannot write to nullstream");
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, UTF8);
        outputStreamWriter.write(dump(bArr, j6, i5, i6));
        outputStreamWriter.flush();
    }

    public static String intToHex(int i5) {
        StringBuilder sb = new StringBuilder(10);
        writeHex(sb, ((long) i5) & KeyboardMap.kValueMask, 8, "0x");
        return sb.toString();
    }

    public static String longToHex(long j6) {
        StringBuilder sb = new StringBuilder(18);
        writeHex(sb, j6, 16, "0x");
        return sb.toString();
    }

    public static String shortToHex(int i5) {
        StringBuilder sb = new StringBuilder(6);
        writeHex(sb, ((long) i5) & 65535, 4, "0x");
        return sb.toString();
    }

    public static char toAscii(int i5) {
        char c = (char) (i5 & 255);
        if (Character.isISOControl(c) || c == 221 || c == 255) {
            return '.';
        }
        return c;
    }

    public static String toHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder("[");
        if (bArr != null && bArr.length > 0) {
            for (int i5 = 0; i5 < bArr.length; i5++) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(toHex(bArr[i5]));
            }
        }
        sb.append(']');
        return sb.toString();
    }

    private static void writeHex(StringBuilder sb, long j6, int i5, String str) {
        sb.append(str);
        char[] cArr = new char[i5];
        for (int i6 = i5 - 1; i6 >= 0; i6--) {
            int intExact = Math.toIntExact(15 & j6);
            cArr[i6] = (char) (intExact < 10 ? intExact + 48 : intExact + 55);
            j6 >>>= 4;
        }
        sb.append(cArr);
    }

    public static synchronized void dump(byte[] bArr, long j6, OutputStream outputStream, int i5) {
        dump(bArr, j6, outputStream, i5, Integer.MAX_VALUE);
    }

    public static String dump(byte[] bArr, long j6, int i5) {
        return dump(bArr, j6, i5, Integer.MAX_VALUE);
    }

    public static String dump(byte[] bArr, long j6, int i5, int i6) {
        int length;
        int i7;
        if (bArr != null && bArr.length != 0) {
            if (i6 != Integer.MAX_VALUE && i6 >= 0 && (i7 = i6 + i5) >= 0) {
                length = Math.min(bArr.length, i7);
            } else {
                length = bArr.length;
            }
            if (i5 >= 0 && i5 < bArr.length) {
                long j7 = j6 + ((long) i5);
                StringBuilder sb = new StringBuilder(74);
                while (i5 < length) {
                    int i8 = length - i5;
                    if (i8 > 16) {
                        i8 = 16;
                    }
                    writeHex(sb, j7, 8, "");
                    for (int i9 = 0; i9 < 16; i9++) {
                        if (i9 < i8) {
                            writeHex(sb, bArr[i9 + i5], 2, " ");
                        } else {
                            sb.append("   ");
                        }
                    }
                    sb.append(Chars.SPACE);
                    for (int i10 = 0; i10 < i8; i10++) {
                        sb.append(toAscii(bArr[i10 + i5]));
                    }
                    sb.append(EOL);
                    j7 += (long) i8;
                    i5 += 16;
                }
                return sb.toString();
            }
            StringBuilder sbT = AbstractC0157z.t(i5, "illegal index: ", " into array of length ");
            sbT.append(bArr.length);
            throw new ArrayIndexOutOfBoundsException(sbT.toString());
        }
        return "No Data" + EOL;
    }

    public static String toHex(short s6) {
        StringBuilder sb = new StringBuilder(4);
        writeHex(sb, s6 & 65535, 4, "");
        return sb.toString();
    }

    public static String toHex(byte b) {
        StringBuilder sb = new StringBuilder(2);
        writeHex(sb, b & UnsignedBytes.MAX_VALUE, 2, "");
        return sb.toString();
    }

    public static String toHex(int i5) {
        StringBuilder sb = new StringBuilder(8);
        writeHex(sb, ((long) i5) & KeyboardMap.kValueMask, 8, "");
        return sb.toString();
    }

    public static String toHex(long j6) {
        StringBuilder sb = new StringBuilder(16);
        writeHex(sb, j6, 16, "");
        return sb.toString();
    }
}
