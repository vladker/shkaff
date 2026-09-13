package L3;

import A3.I;
import A3.J;
import X3.b0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.E;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o {
    public static final int a(String str) {
        int iD;
        char c = File.separatorChar;
        int iD2 = b0.d(str, c, 0, false, 4);
        if (iD2 == 0) {
            if (str.length() <= 1 || str.charAt(1) != c || (iD = b0.d(str, c, 2, false, 4)) < 0) {
                return 1;
            }
            int iD3 = b0.d(str, c, iD + 1, false, 4);
            return iD3 >= 0 ? iD3 + 1 : str.length();
        }
        if (iD2 > 0 && str.charAt(iD2 - 1) == ':') {
            return iD2 + 1;
        }
        if (iD2 == -1 && b0.endsWith((CharSequence) str, NameUtil.COLON, false)) {
            return str.length();
        }
        return 0;
    }

    public static final File getRoot(File file) {
        E.f(file, "<this>");
        return new File(getRootName(file));
    }

    public static final String getRootName(File file) {
        E.f(file, "<this>");
        String path = file.getPath();
        E.e(path, "getPath(...)");
        String path2 = file.getPath();
        E.e(path2, "getPath(...)");
        String strSubstring = path.substring(0, a(path2));
        E.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean isRooted(File file) {
        E.f(file, "<this>");
        String path = file.getPath();
        E.e(path, "getPath(...)");
        return a(path) > 0;
    }

    public static final File subPath(File file, int i5, int i6) {
        E.f(file, "<this>");
        return toComponents(file).subPath(i5, i6);
    }

    public static final g toComponents(File file) {
        List listEmptyList;
        E.f(file, "<this>");
        String path = file.getPath();
        E.c(path);
        int iA = a(path);
        String strSubstring = path.substring(0, iA);
        E.e(strSubstring, "substring(...)");
        String strSubstring2 = path.substring(iA);
        E.e(strSubstring2, "substring(...)");
        if (strSubstring2.length() == 0) {
            listEmptyList = I.emptyList();
        } else {
            List<String> listSplit = b0.split((CharSequence) strSubstring2, new char[]{File.separatorChar}, false, 0);
            ArrayList arrayList = new ArrayList(J.collectionSizeOrDefault(listSplit, 10));
            Iterator<T> it = listSplit.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            listEmptyList = arrayList;
        }
        return new g(new File(strSubstring), listEmptyList);
    }
}
