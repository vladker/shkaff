package org.apache.commons.io;

import A3.AbstractC0157z;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HexDump {
    public static final String EOL = System.getProperty("line.separator");
    private static final char[] _hexcodes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final int[] _shifts = {28, 24, 20, 16, 12, 8, 4, 0};

    public static void dump(byte[] bArr, long j6, OutputStream outputStream, int i5) throws IOException {
        if (i5 < 0 || i5 >= bArr.length) {
            StringBuilder sbT = AbstractC0157z.t(i5, "illegal index: ", " into array of length ");
            sbT.append(bArr.length);
            throw new ArrayIndexOutOfBoundsException(sbT.toString());
        }
        if (outputStream == null) {
            throw new IllegalArgumentException("cannot write to nullstream");
        }
        long j7 = j6 + ((long) i5);
        StringBuilder sb = new StringBuilder(74);
        while (i5 < bArr.length) {
            int length = bArr.length - i5;
            if (length > 16) {
                length = 16;
            }
            dump(sb, j7).append(Chars.SPACE);
            for (int i6 = 0; i6 < 16; i6++) {
                if (i6 < length) {
                    dump(sb, bArr[i6 + i5]);
                } else {
                    sb.append("  ");
                }
                sb.append(Chars.SPACE);
            }
            for (int i7 = 0; i7 < length; i7++) {
                byte b = bArr[i7 + i5];
                if (b < 32 || b >= 127) {
                    sb.append('.');
                } else {
                    sb.append((char) b);
                }
            }
            sb.append(EOL);
            outputStream.write(sb.toString().getBytes(Charset.defaultCharset()));
            outputStream.flush();
            sb.setLength(0);
            j7 += (long) length;
            i5 += 16;
        }
    }

    private static StringBuilder dump(StringBuilder sb, long j6) {
        for (int i5 = 0; i5 < 8; i5++) {
            sb.append(_hexcodes[((int) (j6 >> _shifts[i5])) & 15]);
        }
        return sb;
    }

    private static StringBuilder dump(StringBuilder sb, byte b) {
        for (int i5 = 0; i5 < 2; i5++) {
            sb.append(_hexcodes[(b >> _shifts[i5 + 6]) & 15]);
        }
        return sb;
    }
}
