package p079o;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Locale;
import org.jsoup.nodes.i;
import org.jsoup.nodes.s;
import org.jsoup.parser.C1467b;
import org.jsoup.parser.E;
import p024d5.e;
import p029e5.a;

/* JADX INFO: renamed from: o.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1282k implements Z {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        String str2 = a.b().d;
        if ("keep".equals(str2)) {
            return str;
        }
        return "upper".equals(str2) ? str.toUpperCase(Locale.US) : str.toLowerCase(Locale.US);
    }

    public static void b(String... strArr) {
        int length;
        if (strArr == null || (length = strArr.length) <= 0) {
            return;
        }
        int i5 = 0;
        String strSubstring = strArr[0];
        if (!TextUtils.isEmpty(strSubstring) && !TextUtils.isEmpty("?")) {
            int iIndexOf = strSubstring.indexOf("?");
            while (iIndexOf != -1) {
                i5++;
                strSubstring = strSubstring.substring(iIndexOf + 1);
                iIndexOf = strSubstring.indexOf("?");
            }
        }
        if (length != i5 + 1) {
            throw new e("The parameters in conditions are incorrect.");
        }
    }

    public static boolean c(String str, ArrayList arrayList) {
        if (str == null) {
            return arrayList.contains(null);
        }
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            if (str.equalsIgnoreCase((String) obj)) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(String str) {
        return "java.lang.String".equals(str) || "java.lang.Integer".equals(str) || "java.lang.Float".equals(str) || "java.lang.Double".equals(str) || "java.lang.Long".equals(str) || "java.lang.Short".equals(str) || "java.lang.Boolean".equals(str) || "java.lang.Character".equals(str);
    }

    public static E e(s sVar) {
        E e;
        i iVarOwnerDocument = sVar.ownerDocument();
        return (iVarOwnerDocument == null || (e = iVarOwnerDocument.f7472h) == null) ? new E(new C1467b()) : e;
    }

    public static /* synthetic */ String f(int i5, String str) {
        return str + i5;
    }
}
