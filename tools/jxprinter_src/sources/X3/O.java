package X3;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class O extends M {
    public static final String prependIndent(String str, String indent) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(indent, "indent");
        return W3.L.joinToString(W3.L.map(b0.lineSequence(str), new N(indent, 0)), "\n", "", "", -1, "...", null);
    }

    public static final String replaceIndent(String str, String newIndent) {
        String str2;
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(newIndent, "newIndent");
        List<String> listLines = b0.lines(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listLines) {
            if (!b0.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(A3.J.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            Object obj2 = arrayList.get(i6);
            i6++;
            String str3 = (String) obj2;
            int length = str3.length();
            int length2 = 0;
            while (true) {
                if (length2 >= length) {
                    length2 = -1;
                    break;
                }
                if (!AbstractC0239e.a(str3.charAt(length2))) {
                    break;
                }
                length2++;
            }
            if (length2 == -1) {
                length2 = str3.length();
            }
            arrayList2.add(Integer.valueOf(length2));
        }
        Integer num = (Integer) A3.T.minOrNull((Iterable) arrayList2);
        int iIntValue = num != null ? num.intValue() : 0;
        int size2 = (listLines.size() * newIndent.length()) + str.length();
        O3.l lVar = newIndent.length() == 0 ? new S2.l(6) : new N(newIndent, 1);
        int lastIndex = A3.I.getLastIndex(listLines);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : listLines) {
            int i7 = i5 + 1;
            if (i5 < 0) {
                A3.I.throwIndexOverflow();
            }
            String str4 = (String) obj3;
            if ((i5 == 0 || i5 == lastIndex) && b0.isBlank(str4)) {
                str4 = null;
            } else {
                String strDrop = e0.drop(str4, iIntValue);
                if (strDrop != null && (str2 = (String) lVar.invoke(strDrop)) != null) {
                    str4 = str2;
                }
            }
            if (str4 != null) {
                arrayList3.add(str4);
            }
            i5 = i7;
        }
        return ((StringBuilder) A3.T.joinTo(arrayList3, new StringBuilder(size2), "\n", "", "", -1, "...", null)).toString();
    }

    public static final String replaceIndentByMargin(String str, String newIndent, String marginPrefix) {
        String str2;
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(newIndent, "newIndent");
        kotlin.jvm.internal.E.f(marginPrefix, "marginPrefix");
        if (b0.isBlank(marginPrefix)) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        List<String> listLines = b0.lines(str);
        int size = (listLines.size() * newIndent.length()) + str.length();
        O3.l lVar = newIndent.length() == 0 ? new S2.l(6) : new N(newIndent, 1);
        int lastIndex = A3.I.getLastIndex(listLines);
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        for (Object obj : listLines) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                A3.I.throwIndexOverflow();
            }
            String str3 = (String) obj;
            String strSubstring = null;
            if ((i5 == 0 || i5 == lastIndex) && b0.isBlank(str3)) {
                str3 = null;
            } else {
                int length = str3.length();
                int i7 = 0;
                while (true) {
                    if (i7 >= length) {
                        i7 = -1;
                        break;
                    }
                    if (!AbstractC0239e.a(str3.charAt(i7))) {
                        break;
                    }
                    i7++;
                }
                if (i7 != -1 && W.startsWith(str3, marginPrefix, i7, false)) {
                    strSubstring = str3.substring(marginPrefix.length() + i7);
                    kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
                }
                if (strSubstring != null && (str2 = (String) lVar.invoke(strSubstring)) != null) {
                    str3 = str2;
                }
            }
            if (str3 != null) {
                arrayList.add(str3);
            }
            i5 = i6;
        }
        return ((StringBuilder) A3.T.joinTo(arrayList, new StringBuilder(size), "\n", "", "", -1, "...", null)).toString();
    }

    public static String trimIndent(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return replaceIndent(str, "");
    }

    public static final String trimMargin(String str, String marginPrefix) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(marginPrefix, "marginPrefix");
        return replaceIndentByMargin(str, "", marginPrefix);
    }
}
