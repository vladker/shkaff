package p107s4;

import A3.AbstractC0157z;
import A4.C0169l;
import A4.C0173p;
import A4.InterfaceC0171n;
import A4.S;
import A4.h0;
import I4.a;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.location.LocationRequestCompat;
import com.alibaba.android.arouter.utils.Consts;
import com.google.common.primitives.UnsignedBytes;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.B;
import okhttp3.C1375v;
import okhttp3.C1376w;
import okhttp3.C1378y;
import okhttp3.F;
import okhttp3.Q;
import okhttp3.W;
import okhttp3.internal.http2.C1359c;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f8235a;
    public static final String[] b = new String[0];
    public static final C1376w c = C1376w.e(new String[0]);
    public static final W d;
    public static final S e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f8236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Charset f8237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final TimeZone f8238h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f8239i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Method f8240j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f8241k;

    static {
        byte[] bArr = new byte[0];
        f8235a = bArr;
        Method declaredMethod = null;
        d = W.create((B) null, bArr);
        Q.create((B) null, bArr);
        e = S.of(C0173p.decodeHex("efbbbf"), C0173p.decodeHex("feff"), C0173p.decodeHex("fffe"), C0173p.decodeHex("0000ffff"), C0173p.decodeHex("ffff0000"));
        f8236f = Charset.forName("UTF-32BE");
        f8237g = Charset.forName("UTF-32LE");
        f8238h = TimeZone.getTimeZone("GMT");
        f8239i = new a(27);
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        f8240j = declaredMethod;
        f8241k = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static String a(String str) {
        int i5;
        int i6 = -1;
        int i7 = 0;
        if (!str.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR)) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                for (0; i5 < lowerCase.length(); i5 + 1) {
                    char cCharAt = lowerCase.charAt(i5);
                    i5 = (cCharAt > 31 && cCharAt < 127 && " #%/:?@[\\]".indexOf(cCharAt) == -1) ? i5 + 1 : 0;
                    i7 = 1;
                }
                if (i7 != 0) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressDecodeIpv6 = (str.startsWith("[") && str.endsWith("]")) ? decodeIpv6(str, 1, str.length() - 1) : decodeIpv6(str, 0, str.length());
        if (inetAddressDecodeIpv6 == null) {
            return null;
        }
        byte[] address = inetAddressDecodeIpv6.getAddress();
        if (address.length != 16) {
            if (address.length == 4) {
                return inetAddressDecodeIpv6.getHostAddress();
            }
            throw new AssertionError(AbstractC0157z.o("Invalid IPv6 address: '", str, "'"));
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < address.length) {
            int i10 = i8;
            while (i10 < 16 && address[i10] == 0 && address[i10 + 1] == 0) {
                i10 += 2;
            }
            int i11 = i10 - i8;
            if (i11 > i9 && i11 >= 4) {
                i6 = i8;
                i9 = i11;
            }
            i8 = i10 + 2;
        }
        C0169l c0169l = new C0169l();
        while (i7 < address.length) {
            if (i7 == i6) {
                c0169l.writeByte(58);
                i7 += i9;
                if (i7 == 16) {
                    c0169l.writeByte(58);
                }
            } else {
                if (i7 > 0) {
                    c0169l.writeByte(58);
                }
                c0169l.writeHexadecimalUnsignedLong(((address[i7] & UnsignedBytes.MAX_VALUE) << 8) | (address[i7 + 1] & UnsignedBytes.MAX_VALUE));
                i7 += 2;
            }
        }
        return c0169l.readUtf8();
    }

    public static int b(long j6, TimeUnit timeUnit) {
        if (j6 < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        long millis = timeUnit.toMillis(j6);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException("timeout too large.");
        }
        if (millis != 0 || j6 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException("timeout too small.");
    }

    public static Charset bomAwareCharset(InterfaceC0171n interfaceC0171n, Charset charset) {
        int iSelect = interfaceC0171n.select(e);
        if (iSelect == -1) {
            return charset;
        }
        if (iSelect == 0) {
            return StandardCharsets.UTF_8;
        }
        if (iSelect == 1) {
            return StandardCharsets.UTF_16BE;
        }
        if (iSelect == 2) {
            return StandardCharsets.UTF_16LE;
        }
        if (iSelect == 3) {
            return f8236f;
        }
        if (iSelect == 4) {
            return f8237g;
        }
        throw new AssertionError();
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e6) {
                throw e6;
            } catch (Exception unused) {
            }
        }
    }

    public static void d(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e6) {
                if (!k(e6)) {
                    throw e6;
                }
            } catch (RuntimeException e7) {
                throw e7;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bb A[LOOP:1: B:59:0x00ae->B:63:0x00bb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:90:0x00c1 A[EDGE_INSN: B:90:0x00c1->B:64:0x00c1 BREAK  A[LOOP:1: B:59:0x00ae->B:63:0x00bb], SYNTHETIC] */
    private static InetAddress decodeIpv6(String str, int i5, int i6) {
        InetAddress inetAddress;
        InetAddress inetAddress2;
        int i7;
        int i8;
        int iE;
        byte[] bArr = new byte[16];
        int i9 = i5;
        int i10 = 0;
        int i11 = -1;
        int i12 = -1;
        while (true) {
            InetAddress inetAddress3 = null;
            if (i9 >= i6) {
                inetAddress = null;
                break;
            }
            if (i10 == 16) {
                return null;
            }
            int i13 = i9 + 2;
            if (i13 <= i6 && str.regionMatches(i9, "::", 0, 2)) {
                if (i11 != -1) {
                    return null;
                }
                i10 += 2;
                i11 = i10;
                inetAddress = null;
                if (i13 == i6) {
                    break;
                }
                i12 = i13;
                i7 = 0;
                i9 = i12;
                while (i9 < i6) {
                    iE = e(str.charAt(i9));
                    if (iE == -1) {
                        break;
                        break;
                    }
                    i7 = (i7 << 4) + iE;
                    i9++;
                }
                i8 = i9 - i12;
                if (i8 != 0) {
                }
                return inetAddress;
            }
            if (i10 == 0) {
                inetAddress = null;
                i12 = i9;
            } else {
                if (!str.regionMatches(i9, ParameterizedMessage.ERROR_MSG_SEPARATOR, 0, 1)) {
                    if (!str.regionMatches(i9, Consts.DOT, 0, 1)) {
                        return null;
                    }
                    int i14 = i10 - 2;
                    int i15 = i14;
                    while (i12 < i6) {
                        if (i15 != 16) {
                            if (i15 != i14) {
                                if (str.charAt(i12) == '.') {
                                    i12++;
                                }
                            }
                            int i16 = 0;
                            int i17 = i12;
                            while (true) {
                                if (i17 >= i6) {
                                    inetAddress2 = inetAddress3;
                                    break;
                                }
                                char cCharAt = str.charAt(i17);
                                inetAddress2 = inetAddress3;
                                if (cCharAt < '0' || cCharAt > '9') {
                                    break;
                                }
                                if ((i16 == 0 && i12 != i17) || (i16 = ((i16 * 10) + cCharAt) - 48) > 255) {
                                    return inetAddress2;
                                }
                                i17++;
                                inetAddress3 = inetAddress2;
                            }
                            if (i17 - i12 == 0) {
                                return inetAddress2;
                            }
                            bArr[i15] = (byte) i16;
                            inetAddress3 = inetAddress2;
                            i15++;
                            i12 = i17;
                        }
                        return inetAddress3;
                    }
                    inetAddress = inetAddress3;
                    if (i15 == i10 + 2) {
                        i10 += 2;
                        break;
                    }
                    return inetAddress;
                }
                i12 = i9 + 1;
                inetAddress = null;
            }
            i7 = 0;
            i9 = i12;
            while (i9 < i6) {
                iE = e(str.charAt(i9));
                if (iE == -1) {
                    break;
                }
                i7 = (i7 << 4) + iE;
                i9++;
            }
            i8 = i9 - i12;
            if (i8 != 0 || i8 > 4) {
                return inetAddress;
            }
            int i18 = i10 + 1;
            bArr[i10] = (byte) (255 & (i7 >>> 8));
            i10 += 2;
            bArr[i18] = (byte) (i7 & 255);
        }
        if (i10 != 16) {
            if (i11 == -1) {
                return inetAddress;
            }
            int i19 = i10 - i11;
            System.arraycopy(bArr, i11, bArr, 16 - i19, i19);
            Arrays.fill(bArr, i11, (16 - i10) + i11, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    public static int e(char c6) {
        if (c6 >= '0' && c6 <= '9') {
            return c6 - '0';
        }
        if (c6 >= 'a' && c6 <= 'f') {
            return c6 - 'W';
        }
        if (c6 < 'A' || c6 > 'F') {
            return -1;
        }
        return c6 - '7';
    }

    public static int f(int i5, int i6, String str, String str2) {
        while (i5 < i6) {
            if (str2.indexOf(str.charAt(i5)) != -1) {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    public static int g(String str, int i5, int i6, char c6) {
        while (i5 < i6) {
            if (str.charAt(i5) == c6) {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            String property = System.getProperty(str);
            return property != null ? property : str2;
        } catch (AccessControlException unused) {
        }
    }

    public static String h(C1378y c1378y, boolean z6) {
        String strO = c1378y.d;
        int i5 = c1378y.e;
        if (strO.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR)) {
            strO = AbstractC0157z.o("[", strO, "]");
        }
        if (!z6 && i5 == C1378y.a(c1378y.f6680a)) {
            return strO;
        }
        return strO + ParameterizedMessage.ERROR_MSG_SEPARATOR + i5;
    }

    public static List i(List list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    @SafeVarargs
    public static <T> List<T> immutableList(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static String[] j(Comparator comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    arrayList.add(str);
                    break;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean k(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean l(Comparator comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean m(C1378y c1378y, C1378y c1378y2) {
        return c1378y.d.equals(c1378y2.d) && c1378y.e == c1378y2.e && c1378y.f6680a.equals(c1378y2.f6680a);
    }

    public static int n(int i5, int i6, String str) {
        while (i5 < i6) {
            char cCharAt = str.charAt(i5);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    public static int o(int i5, int i6, String str) {
        for (int i7 = i6 - 1; i7 >= i5; i7--) {
            char cCharAt = str.charAt(i7);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i7 + 1;
            }
        }
        return i5;
    }

    public static C1376w p(List list) {
        C1375v c1375v = new C1375v();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1359c c1359c = (C1359c) it.next();
            F f6 = a.f8232a;
            String strUtf8 = c1359c.f6604a.utf8();
            String strUtf9 = c1359c.b.utf8();
            f6.getClass();
            c1375v.b(strUtf8, strUtf9);
        }
        return new C1376w(c1375v);
    }

    public static boolean skipAll(h0 h0Var, int i5, TimeUnit timeUnit) {
        long jNanoTime = System.nanoTime();
        long jA = h0Var.timeout().b() ? h0Var.timeout().a() - jNanoTime : Long.MAX_VALUE;
        h0Var.timeout().deadlineNanoTime(Math.min(jA, timeUnit.toNanos(i5)) + jNanoTime);
        try {
            C0169l c0169l = new C0169l();
            while (h0Var.read(c0169l, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                c0169l.a();
            }
            if (jA == LocationRequestCompat.PASSIVE_INTERVAL) {
                h0Var.timeout().clearDeadline();
                return true;
            }
            h0Var.timeout().deadlineNanoTime(jNanoTime + jA);
            return true;
        } catch (InterruptedIOException unused) {
            if (jA == LocationRequestCompat.PASSIVE_INTERVAL) {
                h0Var.timeout().clearDeadline();
                return false;
            }
            h0Var.timeout().deadlineNanoTime(jNanoTime + jA);
            return false;
        } catch (Throwable th) {
            if (jA == LocationRequestCompat.PASSIVE_INTERVAL) {
                h0Var.timeout().clearDeadline();
            } else {
                h0Var.timeout().deadlineNanoTime(jNanoTime + jA);
            }
            throw th;
        }
    }
}
