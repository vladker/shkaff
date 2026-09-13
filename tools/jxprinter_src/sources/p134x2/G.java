package p134x2;

import X3.AbstractC0240f;
import X3.g0;
import android.graphics.Bitmap;
import android.graphics.Color;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.jvm.internal.E;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G {
    public static final G INSTANCE = new G();
    public static final String TAG = "ESCCommand";

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] b(int[] iArr, int i5, int i6) {
        byte[] bArr = new byte[((i5 + 7) / 8) * i6];
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            for (int i9 = 0; i9 < i5; i9 += 8) {
                int[] iArr2 = {-1, -1, -1, -1, -1, -1, -1, -1};
                int i10 = i8 * i5;
                int i11 = i10 + i9;
                System.arraycopy(iArr, i11, iArr2, 0, ((int) Math.min(i11 + 8, i10 + i5)) - i11);
                StringBuilder sb = new StringBuilder();
                for (int i12 = 0; i12 < 8; i12++) {
                    if (((Color.blue(iArr2[i12]) * 11) + ((Color.green(iArr2[i12]) * 59) + (Color.red(iArr2[i12]) * 30))) / 100 > 128.0d) {
                        sb.append("0");
                    } else {
                        sb.append("1");
                    }
                }
                String string = sb.toString();
                E.e(string, "toString(...)");
                bArr[i7] = g0.toUByte(string, 2);
                i7++;
            }
        }
        return bArr;
    }

    public static final String bytesToHex(byte[] bytes) {
        E.f(bytes, "bytes");
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1)));
        }
        String string = sb.toString();
        E.e(string, "toString(...)");
        return string;
    }

    public static final byte[] centerAligned() {
        return new byte[]{Ascii.ESC, 97, 1};
    }

    public static final byte[] end() {
        return new byte[]{29, 12};
    }

    public static final byte[] hexToBytes(String hexString) {
        E.f(hexString, "hexString");
        int length = hexString.length();
        byte[] bArr = new byte[length / 2];
        for (int i5 = 0; i5 < length; i5 += 2) {
            int i6 = i5 / 2;
            Integer numDigitToIntOrNull = AbstractC0240f.digitToIntOrNull(hexString.charAt(i5), 16);
            int iIntValue = numDigitToIntOrNull != null ? numDigitToIntOrNull.intValue() : -16;
            Integer numDigitToIntOrNull2 = AbstractC0240f.digitToIntOrNull(hexString.charAt(i5 + 1), 16);
            E.c(numDigitToIntOrNull2);
            bArr[i6] = (byte) (numDigitToIntOrNull2.intValue() + iIntValue);
        }
        return bArr;
    }

    public static final byte[] rasterBmpToSendData(Bitmap bitmap) {
        E.f(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        INSTANCE.getClass();
        byte[] bArrB = b(iArr, width, height);
        int i5 = (width + 7) / 8;
        return a(new byte[]{29, 118, TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, (byte) (i5 % 256), (byte) (i5 / 256), (byte) (height % 256), (byte) (height / 256)}, bArrB);
    }

    public static final byte[] rasterBmpToSendDataByZLib(Bitmap bitmap) {
        E.f(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        INSTANCE.getClass();
        byte[] bArrB = b(iArr, width, height);
        int i5 = (width + 7) / 8;
        byte[] bArr = {Ascii.ESC, 35, 33, (byte) (i5 / 256), (byte) (i5 % 256), (byte) (height / 256), (byte) (height % 256)};
        O o6 = O.INSTANCE;
        o6.i(TAG, "原数据大小：" + bArrB.length);
        byte[] bArrCompress = e1.INSTANCE.compress(bArrB, 10);
        if (bArrCompress == null) {
            return null;
        }
        o6.i(TAG, "压缩后数据大小：" + bArrCompress.length);
        byte[] bArrArray = ByteBuffer.allocate(4).putInt(bArrCompress.length).array();
        E.c(bArrArray);
        return a(a(bArr, bArrArray), bArrCompress);
    }

    public static final byte[] start() {
        return new byte[]{Ascii.ESC, 64};
    }
}
