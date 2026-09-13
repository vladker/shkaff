package p134x2;

import A3.AbstractC0157z;
import X3.g0;
import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.collection.a;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a1 {
    public static final a1 INSTANCE = new a1();
    public static final String TAG = "TSCCommand";
    private static String charsetName = "gbk";
    private static String lineEndStr = "\n";

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        E.c(bArr);
        int length = bArr.length;
        E.c(bArr2);
        byte[] bArr3 = new byte[length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] b(int[] iArr, int i5, int i6, int i7) {
        int i8 = 8;
        byte[] bArr = new byte[((i5 + 7) / 8) * i6];
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i6) {
            int i12 = i9;
            while (i12 < i5) {
                int[] iArr2 = new int[i8];
                // fill-array-data instruction
                iArr2[0] = -1;
                iArr2[1] = -1;
                iArr2[2] = -1;
                iArr2[3] = -1;
                iArr2[4] = -1;
                iArr2[5] = -1;
                iArr2[6] = -1;
                iArr2[7] = -1;
                int i13 = i10 * i5;
                int i14 = i13 + i12;
                System.arraycopy(iArr, i14, iArr2, i9, ((int) Math.min(i14 + 8, i13 + i5)) - i14);
                StringBuilder sb = new StringBuilder();
                int i15 = i9;
                while (i15 < i8) {
                    if (((Color.blue(iArr2[i15]) * 11) + ((Color.green(iArr2[i15]) * 59) + (Color.red(iArr2[i15]) * 30))) / 100 > i7) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                    i15++;
                    i8 = 8;
                }
                String string = sb.toString();
                E.e(string, "toString(...)");
                bArr[i11] = g0.toUByte(string, 2);
                i11++;
                i12 += 8;
                i8 = 8;
                i9 = 0;
            }
            i10++;
            i8 = 8;
            i9 = 0;
        }
        return bArr;
    }

    public static final byte[] bitmap(int i5, int i6, int i7, Bitmap sourceBitmap, int i8) {
        E.f(sourceBitmap, "sourceBitmap");
        int width = (sourceBitmap.getWidth() + 7) / 8;
        int height = sourceBitmap.getHeight();
        StringBuilder sbS = a.s("BITMAP ", i5, i6, ",", ",");
        androidx.exifinterface.media.a.y(sbS, width, ",", height, ",");
        String strL = AbstractC0157z.l(",", i7, sbS);
        INSTANCE.getClass();
        byte[] bArrC = c(strL);
        byte[] bArrC2 = c(lineEndStr);
        int width2 = sourceBitmap.getWidth();
        int height2 = sourceBitmap.getHeight();
        int[] iArr = new int[width2 * height2];
        sourceBitmap.getPixels(iArr, 0, width2, 0, 0, width2, height2);
        return a(a(bArrC, b(iArr, width2, height2, i8)), bArrC2);
    }

    public static final byte[] bitmapByPerLine(int i5, int i6, int i7, Bitmap sourceBitmap, int i8) {
        int i9;
        E.f(sourceBitmap, "sourceBitmap");
        int width = (sourceBitmap.getWidth() + 7) / 8;
        int height = sourceBitmap.getHeight();
        int width2 = sourceBitmap.getWidth();
        int height2 = sourceBitmap.getHeight();
        int[] iArr = new int[width2 * height2];
        sourceBitmap.getPixels(iArr, 0, width2, 0, 0, width2, height2);
        INSTANCE.getClass();
        byte[] bArrB = b(iArr, width2, height2, i8);
        int length = bArrB.length;
        byte[][] bArr = new byte[height][];
        for (int i10 = 0; i10 < height; i10++) {
            int i11 = i10 * width;
            bArr[i10] = Arrays.copyOfRange(bArrB, i11, (int) Math.min(i11 + width, length));
        }
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < height; i12++) {
            int i13 = 0;
            while (true) {
                i9 = -1;
                if (i13 >= width) {
                    i13 = -1;
                    break;
                }
                byte[] bArr2 = bArr[i12];
                E.c(bArr2);
                if (bArr2[i13] != -1) {
                    break;
                }
                i13++;
            }
            if (i13 != -1) {
                for (int i14 = width - 1; -1 < i14; i14--) {
                    byte[] bArr3 = bArr[i12];
                    E.c(bArr3);
                    if (bArr3[i14] != -1) {
                        i9 = i14;
                        break;
                    }
                }
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr[i12], i13, i9 + 1);
                arrayList.add(new P((i13 * 8) + i5, i6 + i12, bArrCopyOfRange.length, bArrCopyOfRange));
            }
        }
        byte[] bArrA = new byte[0];
        int size = arrayList.size();
        int i15 = 0;
        while (i15 < size) {
            Object obj = arrayList.get(i15);
            i15++;
            P p6 = (P) obj;
            a1 a1Var = INSTANCE;
            String str = String.format("BITMAP %d,%d,%d,%d,%d,", Arrays.copyOf(new Object[]{Integer.valueOf(p6.f8861a), Integer.valueOf(p6.b), Integer.valueOf(p6.c), 1, 0}, 5));
            a1Var.getClass();
            bArrA = a(a(a(bArrA, c(str)), p6.getData()), c(lineEndStr));
        }
        return bArrA;
    }

    public static final byte[] bitmapByZLib(int i5, int i6, Bitmap sourceBitmap, int i7) {
        E.f(sourceBitmap, "sourceBitmap");
        int i8 = 8;
        int width = (sourceBitmap.getWidth() + 7) / 8;
        int height = sourceBitmap.getHeight();
        int width2 = sourceBitmap.getWidth();
        int height2 = sourceBitmap.getHeight();
        int[] iArr = new int[width2 * height2];
        sourceBitmap.getPixels(iArr, 0, width2, 0, 0, width2, height2);
        INSTANCE.getClass();
        int i9 = ((width2 + 7) / 8) * height2;
        byte[] bArr = new byte[i9];
        int i10 = 0;
        int i11 = 0;
        while (i10 < height2) {
            int i12 = 0;
            while (i12 < width2) {
                int[] iArr2 = new int[i8];
                // fill-array-data instruction
                iArr2[0] = -1;
                iArr2[1] = -1;
                iArr2[2] = -1;
                iArr2[3] = -1;
                iArr2[4] = -1;
                iArr2[5] = -1;
                iArr2[6] = -1;
                iArr2[7] = -1;
                int i13 = i10 * width2;
                int i14 = i13 + i12;
                int i15 = height;
                int i16 = i10;
                System.arraycopy(iArr, i14, iArr2, 0, ((int) Math.min(i14 + 8, i13 + width2)) - i14);
                StringBuilder sb = new StringBuilder();
                int i17 = 0;
                while (i17 < 8) {
                    int i18 = i12;
                    if (((double) ((Color.blue(iArr2[i17]) * 11) + ((Color.green(iArr2[i17]) * 59) + (Color.red(iArr2[i17]) * 30)))) / ((double) 100) > i7) {
                        sb.append("0");
                    } else {
                        sb.append("1");
                    }
                    i17++;
                    i12 = i18;
                }
                String string = sb.toString();
                E.e(string, "toString(...)");
                bArr[i11] = g0.toUByte(string, 2);
                i11++;
                i12 += 8;
                i10 = i16;
                height = i15;
                i8 = 8;
            }
            i10++;
            i8 = 8;
        }
        O o6 = O.INSTANCE;
        o6.i(TAG, "原数据大小：" + i9);
        byte[] bArrCompress = e1.INSTANCE.compress(bArr);
        o6.i(TAG, "压缩后数据大小：" + bArrCompress.length);
        int length = bArrCompress.length;
        StringBuilder sbS = a.s("BITMAP ", i5, i6, ",", ",");
        androidx.exifinterface.media.a.y(sbS, width, ",", height, ",3,");
        String strL = AbstractC0157z.l(",", length, sbS);
        INSTANCE.getClass();
        return a(a(c(strL), bArrCompress), c(lineEndStr));
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

    public static byte[] c(String str) {
        try {
            Charset charsetForName = Charset.forName("utf-8");
            E.e(charsetForName, "forName(charsetName)");
            byte[] bytes = str.getBytes(charsetForName);
            E.e(bytes, "this as java.lang.String).getBytes(charset)");
            String str2 = charsetName;
            if ((str2 == null) | (str2 == "")) {
                charsetName = "gbk";
            }
            Charset charsetForName2 = Charset.forName("utf-8");
            E.e(charsetForName2, "forName(charsetName)");
            String str3 = new String(bytes, charsetForName2);
            String str4 = charsetName;
            E.c(str4);
            Charset charsetForName3 = Charset.forName(str4);
            E.e(charsetForName3, "forName(charsetName)");
            byte[] bytes2 = str3.getBytes(charsetForName3);
            E.e(bytes2, "this as java.lang.String).getBytes(charset)");
            return bytes2;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final byte[] cls() {
        String strN = AbstractC0157z.n("CLS", lineEndStr);
        INSTANCE.getClass();
        return c(strN);
    }

    public static final byte[] density(int i5) {
        String strI = a.i(i5, "DENSITY ", lineEndStr);
        INSTANCE.getClass();
        return c(strI);
    }

    public static final byte[] direction(int i5) {
        String strI = a.i(i5, "DIRECTION ", lineEndStr);
        INSTANCE.getClass();
        return c(strI);
    }

    public static final byte[] gapBymm(int i5, int i6) {
        String str = lineEndStr;
        StringBuilder sbS = a.s("GAP ", i5, i6, " mm,", " mm");
        sbS.append(str);
        String string = sbS.toString();
        INSTANCE.getClass();
        return c(string);
    }

    public static final byte[] print(int i5) {
        String strI = a.i(i5, "PRINT 1,", lineEndStr);
        INSTANCE.getClass();
        return c(strI);
    }

    public static final void setCharsetName(String charset) {
        E.f(charset, "charset");
        charsetName = charset;
    }

    public static final byte[] sizeBymm(int i5, int i6) {
        String str = lineEndStr;
        StringBuilder sbS = a.s("SIZE ", i5, i6, " mm,", " mm");
        sbS.append(str);
        String string = sbS.toString();
        INSTANCE.getClass();
        return c(string);
    }

    public static final byte[] speed(String speed) {
        E.f(speed, "speed");
        String strO = AbstractC0157z.o("SPEED ", speed, lineEndStr);
        INSTANCE.getClass();
        return c(strO);
    }

    public static final byte[] text(int i5, int i6, String font, int i7, int i8, int i9, String content) {
        E.f(font, "font");
        E.f(content, "content");
        String str = lineEndStr;
        StringBuilder sbS = a.s("TEXT ", i5, i6, ",", ",\"");
        sbS.append(font);
        sbS.append("\",");
        sbS.append(i7);
        sbS.append(",");
        androidx.exifinterface.media.a.y(sbS, i8, ",", i9, ",\"");
        String strR = androidx.exifinterface.media.a.r(sbS, content, "\"", str);
        INSTANCE.getClass();
        return c(strR);
    }

    public final String getLineEndStr() {
        return lineEndStr;
    }

    public final void setLineEndStr(String str) {
        E.f(str, "<set-?>");
        lineEndStr = str;
    }
}
