package p118u4;

import A4.C0173p;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import okhttp3.C1367m;
import okhttp3.C1368n;
import okhttp3.C1376w;
import okhttp3.C1378y;
import okhttp3.T;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e {
    static {
        C0173p.encodeUtf8("\"\\");
        C0173p.encodeUtf8("\t ,=");
    }

    public static long a(T t6) {
        String str = t6.e.get(HttpHeaders.CONTENT_LENGTH);
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static boolean b(T t6) {
        if (t6.f6544a.b.equals("HEAD")) {
            return false;
        }
        int i5 = t6.c;
        return (((i5 >= 100 && i5 < 200) || i5 == 204 || i5 == 304) && a(t6) == -1 && !"chunked".equalsIgnoreCase(t6.header(HttpHeaders.TRANSFER_ENCODING))) ? false : true;
    }

    public static int c(int i5, String str) {
        try {
            long j6 = Long.parseLong(str);
            if (j6 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j6 < 0) {
                return 0;
            }
            return (int) j6;
        } catch (NumberFormatException unused) {
            return i5;
        }
    }

    public static void d(C1368n c1368n, C1378y c1378y, C1376w c1376w) {
        if (c1368n == C1368n.f6669a) {
            return;
        }
        Pattern pattern = C1367m.f6660j;
        int iF = c1376w.f();
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (int i5 = 0; i5 < iF; i5++) {
            if (HttpHeaders.SET_COOKIE.equalsIgnoreCase(c1376w.c(i5))) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(2);
                }
                arrayList2.add(c1376w.g(i5));
            }
        }
        List listUnmodifiableList = arrayList2 != null ? Collections.unmodifiableList(arrayList2) : Collections.EMPTY_LIST;
        int size = listUnmodifiableList.size();
        for (int i6 = 0; i6 < size; i6++) {
            C1367m c1367m = C1367m.parse(c1378y, (String) listUnmodifiableList.get(i6));
            if (c1367m != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(c1367m);
            }
        }
        if ((arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.EMPTY_LIST).isEmpty()) {
            return;
        }
        c1368n.getClass();
    }

    public static int e(int i5, String str, String str2) {
        while (i5 < str.length() && str2.indexOf(str.charAt(i5)) == -1) {
            i5++;
        }
        return i5;
    }
}
