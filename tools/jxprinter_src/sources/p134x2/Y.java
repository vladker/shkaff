package p134x2;

import X3.AbstractC0239e;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import kotlin.jvm.internal.E;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Y {
    public static final Y INSTANCE = new Y();

    public static final byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
        E.f(byte_1, "byte_1");
        E.f(byte_2, "byte_2");
        byte[] bArr = new byte[byte_1.length + byte_2.length];
        System.arraycopy(byte_1, 0, bArr, 0, byte_1.length);
        System.arraycopy(byte_2, 0, bArr, byte_1.length, byte_2.length);
        return bArr;
    }

    public static final String bytesToHexString(byte[] byteArray) {
        E.f(byteArray, "byteArray");
        StringBuilder sb = new StringBuilder();
        for (byte b : byteArray) {
            String hexString = Integer.toHexString(b & UnsignedBytes.MAX_VALUE);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
            sb.append(Chars.SPACE);
        }
        String string = sb.toString();
        E.e(string, "toString(...)");
        return string;
    }

    public static final byte[] hexStringToBytes(String hexString) {
        E.f(hexString, "hexString");
        int length = hexString.length() / 2;
        byte[] bArr = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = i5 * 2;
            String strSubstring = hexString.substring(i6, i6 + 2);
            E.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            bArr[i5] = ((Byte) Integer.valueOf(Integer.parseInt(strSubstring, AbstractC0239e.checkRadix(16)))).byteValue();
        }
        return bArr;
    }

    public static final byte[] jxDeviceCheck() {
        return new byte[]{Ascii.ESC, 35, 35, TarConstants.LF_GNUTYPE_SPARSE, 69, TarConstants.LF_GNUTYPE_LONGNAME, 70};
    }

    public static final byte[] jxDeviceReset() {
        return new byte[]{Ascii.ESC, 35, 35, 82, 84, 70, 65};
    }

    public static final byte[] jxDeviceState() {
        return new byte[]{29, 97, 0};
    }

    public static final byte[] jxig() {
        return new byte[]{Ascii.ESC, 35, 35, 74, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 73, 71};
    }

    public static final byte[] jxis(P0 printerInfo) {
        E.f(printerInfo, "printerInfo");
        byte[] bArrByteMerger = byteMerger(new byte[]{Ascii.ESC, 35, 35, 74, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 73, TarConstants.LF_GNUTYPE_SPARSE}, printerInfo.getSettingData());
        System.out.println((Object) bytesToHexString(bArrByteMerger));
        return bArrByteMerger;
    }
}
