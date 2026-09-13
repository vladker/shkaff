package okhttp3;

import A3.AbstractC0157z;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: renamed from: okhttp3.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1376w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f6677a;

    public C1376w(C1375v c1375v) {
        ArrayList arrayList = c1375v.f6676a;
        this.f6677a = (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static void a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = str.charAt(i5);
            if (cCharAt <= ' ' || cCharAt >= 127) {
                Object[] objArr = {Integer.valueOf(cCharAt), Integer.valueOf(i5), str};
                byte[] bArr = p107s4.d.f8235a;
                throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in header name: %s", objArr));
            }
        }
    }

    public static void b(String str, String str2) {
        if (str == null) {
            throw new NullPointerException(AbstractC0157z.o("value for name ", str2, " == null"));
        }
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = str.charAt(i5);
            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                Object[] objArr = {Integer.valueOf(cCharAt), Integer.valueOf(i5), str2, str};
                byte[] bArr = p107s4.d.f8235a;
                throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in %s value: %s", objArr));
            }
        }
    }

    public static C1376w e(String... strArr) {
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i5 = 0; i5 < strArr2.length; i5++) {
            String str = strArr2[i5];
            if (str == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i5] = str.trim();
        }
        for (int i6 = 0; i6 < strArr2.length; i6 += 2) {
            String str2 = strArr2[i6];
            String str3 = strArr2[i6 + 1];
            a(str2);
            b(str3, str2);
        }
        return new C1376w(strArr2);
    }

    public final String c(int i5) {
        return this.f6677a[i5 * 2];
    }

    public final C1375v d() {
        C1375v c1375v = new C1375v();
        Collections.addAll(c1375v.f6676a, this.f6677a);
        return c1375v;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1376w) && Arrays.equals(((C1376w) obj).f6677a, this.f6677a);
    }

    public final int f() {
        return this.f6677a.length / 2;
    }

    public final String g(int i5) {
        return this.f6677a[(i5 * 2) + 1];
    }

    public String get(String str) {
        return get(this.f6677a, str);
    }

    public Date getDate(String str) {
        String str2 = get(str);
        if (str2 == null) {
            return null;
        }
        S1.a aVar = p118u4.d.f8736a;
        if (str2.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = ((DateFormat) p118u4.d.f8736a.get()).parse(str2, parsePosition);
        if (parsePosition.getIndex() == str2.length()) {
            return date;
        }
        String[] strArr = p118u4.d.b;
        synchronized (strArr) {
            try {
                int length = strArr.length;
                for (int i5 = 0; i5 < length; i5++) {
                    DateFormat[] dateFormatArr = p118u4.d.c;
                    DateFormat simpleDateFormat = dateFormatArr[i5];
                    if (simpleDateFormat == null) {
                        simpleDateFormat = new SimpleDateFormat(p118u4.d.b[i5], Locale.US);
                        simpleDateFormat.setTimeZone(p107s4.d.f8238h);
                        dateFormatArr[i5] = simpleDateFormat;
                    }
                    parsePosition.setIndex(0);
                    Date date2 = simpleDateFormat.parse(str2, parsePosition);
                    if (parsePosition.getIndex() != 0) {
                        return date2;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @IgnoreJRERequirement
    public Instant getInstant(String str) {
        Date date = getDate(str);
        if (date != null) {
            return date.toInstant();
        }
        return null;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f6677a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int iF = f();
        for (int i5 = 0; i5 < iF; i5++) {
            sb.append(c(i5));
            sb.append(": ");
            sb.append(g(i5));
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String get(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public C1376w(String[] strArr) {
        this.f6677a = strArr;
    }
}
