package W4;

import A3.AbstractC0157z;
import V4.h;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;
import java.util.regex.Pattern;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f830a = {"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    "};
    public static final Pattern b = Pattern.compile("^/((\\.{1,2}/)+)");
    public static final Pattern c = Pattern.compile("^[a-zA-Z][a-zA-Z0-9+-.]*:");
    public static final S1.a d = new S1.a(4);

    public static void a(StringBuilder sb, String str, boolean z6) {
        int length = str.length();
        int iCharCount = 0;
        boolean z7 = false;
        boolean z8 = false;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt == 32 || iCodePointAt == 9 || iCodePointAt == 10 || iCodePointAt == 12 || iCodePointAt == 13 || iCodePointAt == 160) {
                if ((!z6 || z7) && !z8) {
                    sb.append(Chars.SPACE);
                    z8 = true;
                }
            } else if (iCodePointAt != 8203 && iCodePointAt != 173) {
                sb.appendCodePoint(iCodePointAt);
                z8 = false;
                z7 = true;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
    }

    public static StringBuilder b() {
        Stack stack = (Stack) d.get();
        return stack.empty() ? new StringBuilder(8192) : (StringBuilder) stack.pop();
    }

    public static boolean c(String str, String[] strArr) {
        return Arrays.binarySearch(strArr, str) >= 0;
    }

    public static boolean d(String str) {
        if (str != null && str.length() != 0) {
            int length = str.length();
            for (int i5 = 0; i5 < length; i5++) {
                if (!e(str.codePointAt(i5))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean e(int i5) {
        return i5 == 32 || i5 == 9 || i5 == 10 || i5 == 12 || i5 == 13;
    }

    public static String f(Collection collection, String str) {
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return "";
        }
        String string = it.next().toString();
        if (!it.hasNext()) {
            return string;
        }
        StringBuilder sbB = b();
        h.notNull(sbB);
        sbB.append((Object) string);
        while (it.hasNext()) {
            Object next = it.next();
            h.notNull(sbB);
            sbB.append(str);
            sbB.append(next);
        }
        return g(sbB);
    }

    public static String g(StringBuilder sb) {
        h.notNull(sb);
        String string = sb.toString();
        if (sb.length() > 8192) {
            sb = new StringBuilder(8192);
        } else {
            sb.delete(0, sb.length());
        }
        Stack stack = (Stack) d.get();
        stack.push(sb);
        while (stack.size() > 8) {
            stack.pop();
        }
        return string;
    }

    public static URL resolve(URL url, String str) {
        if (str.startsWith("?")) {
            str = url.getPath() + str;
        }
        URL url2 = new URL(url, str);
        String strReplaceFirst = b.matcher(url2.getFile()).replaceFirst(PackagingURIHelper.FORWARD_SLASH_STRING);
        if (url2.getRef() != null) {
            StringBuilder sbX = AbstractC0157z.x(strReplaceFirst, "#");
            sbX.append(url2.getRef());
            strReplaceFirst = sbX.toString();
        }
        return new URL(url2.getProtocol(), url2.getHost(), url2.getPort(), strReplaceFirst);
    }
}
