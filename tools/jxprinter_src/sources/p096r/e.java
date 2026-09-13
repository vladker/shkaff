package p096r;

import androidx.datastore.preferences.protobuf.DescriptorProtos;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.AccessController;
import java.util.Arrays;
import java.util.Properties;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Properties f7898a = new Properties();
    public static final Charset b = Charset.forName("UTF-8");
    public static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final boolean[] d = new boolean[256];
    public static final boolean[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f7899f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f7900g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean[] f7901h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean[] f7902i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final char[] f7903j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final char[] f7904k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final char[] f7905l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final char[] f7906m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final char[] f7907n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f7908o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final char[] f7909p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f7910q;

    static {
        char c6 = 0;
        while (true) {
            boolean[] zArr = d;
            if (c6 >= zArr.length) {
                break;
            }
            if (c6 >= 'A' && c6 <= 'Z') {
                zArr[c6] = true;
            } else if (c6 >= 'a' && c6 <= 'z') {
                zArr[c6] = true;
            } else if (c6 == '_') {
                zArr[c6] = true;
            }
            c6 = (char) (c6 + 1);
        }
        e = new boolean[256];
        char c7 = 0;
        while (true) {
            boolean[] zArr2 = e;
            if (c7 < zArr2.length) {
                if (c7 >= 'A' && c7 <= 'Z') {
                    zArr2[c7] = true;
                } else if (c7 >= 'a' && c7 <= 'z') {
                    zArr2[c7] = true;
                } else if (c7 == '_') {
                    zArr2[c7] = true;
                } else if (c7 >= '0' && c7 <= '9') {
                    zArr2[c7] = true;
                }
                c7 = (char) (c7 + 1);
            } else {
                try {
                    break;
                } catch (Throwable unused) {
                }
            }
        }
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new a(1));
        if (inputStream != null) {
            f7898a.load(inputStream);
            inputStream.close();
        }
        byte[] bArr = new byte[161];
        f7899f = bArr;
        byte[] bArr2 = new byte[161];
        f7900g = bArr2;
        f7901h = new boolean[161];
        f7902i = new boolean[161];
        f7903j = new char[93];
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i5 = 14; i5 <= 31; i5++) {
            f7899f[i5] = 4;
            f7900g[i5] = 4;
        }
        for (int i6 = 127; i6 < 160; i6++) {
            f7899f[i6] = 4;
            f7900g[i6] = 4;
        }
        for (int i7 = 0; i7 < 161; i7++) {
            f7901h[i7] = f7899f[i7] != 0;
            f7902i[i7] = f7900g[i7] != 0;
        }
        char[] cArr = f7903j;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = Chars.DQUOTE;
        cArr[39] = Chars.QUOTE;
        cArr[47] = '/';
        cArr[92] = IOUtils.DIR_SEPARATOR_WINDOWS;
        f7904k = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
        f7905l = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        f7906m = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        f7907n = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        f7908o = new int[]{9, 99, 999, 9999, DescriptorProtos.Edition.EDITION_99999_TEST_ONLY_VALUE, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        f7909p = charArray;
        int[] iArr = new int[256];
        f7910q = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i8 = 0; i8 < length; i8++) {
            f7910q[f7909p[i8]] = i8;
        }
        f7910q[61] = 0;
    }

    public static void a(long j6, int i5, char[] cArr) {
        char c6;
        char[] cArr2;
        char[] cArr3;
        if (j6 < 0) {
            j6 = -j6;
            c6 = '-';
        } else {
            c6 = 0;
        }
        while (true) {
            cArr2 = f7906m;
            cArr3 = f7907n;
            if (j6 <= 2147483647L) {
                break;
            }
            long j7 = j6 / 100;
            int i6 = (int) (j6 - (((j7 << 6) + (j7 << 5)) + (j7 << 2)));
            cArr[i5 - 1] = cArr3[i6];
            i5 -= 2;
            cArr[i5] = cArr2[i6];
            j6 = j7;
        }
        int i7 = (int) j6;
        while (i7 >= 65536) {
            int i8 = i7 / 100;
            int i9 = i7 - (((i8 << 6) + (i8 << 5)) + (i8 << 2));
            cArr[i5 - 1] = cArr3[i9];
            i5 -= 2;
            cArr[i5] = cArr2[i9];
            i7 = i8;
        }
        while (true) {
            int i10 = (52429 * i7) >>> 19;
            int i11 = i5 - 1;
            cArr[i11] = f7905l[i7 - ((i10 << 3) + (i10 << 1))];
            if (i10 == 0) {
                break;
            }
            i7 = i10;
            i5 = i11;
        }
        if (c6 != 0) {
            cArr[i5 - 2] = c6;
        }
    }

    public static void b(char[] cArr, int i5, int i6) {
        char c6;
        if (i5 < 0) {
            i5 = -i5;
            c6 = '-';
        } else {
            c6 = 0;
        }
        while (i5 >= 65536) {
            int i7 = i5 / 100;
            int i8 = i5 - (((i7 << 6) + (i7 << 5)) + (i7 << 2));
            cArr[i6 - 1] = f7907n[i8];
            i6 -= 2;
            cArr[i6] = f7906m[i8];
            i5 = i7;
        }
        while (true) {
            int i9 = (52429 * i5) >>> 19;
            int i10 = i6 - 1;
            cArr[i10] = f7905l[i5 - ((i9 << 3) + (i9 << 1))];
            if (i9 == 0) {
                break;
            }
            i5 = i9;
            i6 = i10;
        }
        if (c6 != 0) {
            cArr[i6 - 2] = c6;
        }
    }

    public static String c(String str) {
        String property;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        return property == null ? f7898a.getProperty(str) : property;
    }

    public static int d(int i5) {
        int i6 = 0;
        while (i5 > f7908o[i6]) {
            i6++;
        }
        return i6 + 1;
    }

    public static int e(long j6) {
        long j7 = 10;
        for (int i5 = 1; i5 < 19; i5++) {
            if (j6 < j7) {
                return i5;
            }
            j7 *= 10;
        }
        return 19;
    }
}
