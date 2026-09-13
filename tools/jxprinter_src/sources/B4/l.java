package B4;

import A3.T;
import A4.AbstractC0180x;
import A4.U;
import A4.V;
import X3.W;
import X3.b0;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import kotlin.jvm.internal.E;
import org.apache.commons.io.IOUtils;
import p147z3.A;
import p147z3.C1938s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class l {
    public static final boolean a(l lVar, V v6) {
        lVar.getClass();
        return !W.endsWith(v6.name(), ".class", true);
    }

    public final V getROOT() {
        return n.ROOT;
    }

    public final V removeBase(V v6, V base) {
        E.f(v6, "<this>");
        E.f(base, "base");
        return getROOT().resolve(W.replace(b0.removePrefix(v6.toString(), (CharSequence) base.toString()), IOUtils.DIR_SEPARATOR_WINDOWS, '/', false));
    }

    public final List<C1938s> toClasspathRoots(ClassLoader classLoader) throws IOException {
        E.f(classLoader, "<this>");
        Enumeration<URL> resources = classLoader.getResources("");
        E.e(resources, "getResources(\"\")");
        ArrayList list = Collections.list(resources);
        E.e(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            Object obj = list.get(i6);
            i6++;
            URL it = (URL) obj;
            l lVar = n.Companion;
            E.e(it, "it");
            C1938s fileRoot = lVar.toFileRoot(it);
            if (fileRoot != null) {
                arrayList.add(fileRoot);
            }
        }
        Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
        E.e(resources2, "getResources(\"META-INF/MANIFEST.MF\")");
        ArrayList list2 = Collections.list(resources2);
        E.e(list2, "list(this)");
        ArrayList arrayList2 = new ArrayList();
        int size2 = list2.size();
        while (i5 < size2) {
            Object obj2 = list2.get(i5);
            i5++;
            URL it2 = (URL) obj2;
            l lVar2 = n.Companion;
            E.e(it2, "it");
            C1938s jarRoot = lVar2.toJarRoot(it2);
            if (jarRoot != null) {
                arrayList2.add(jarRoot);
            }
        }
        return T.plus((Collection) arrayList, (Iterable) arrayList2);
    }

    public final C1938s toFileRoot(URL url) {
        E.f(url, "<this>");
        if (E.a(url.getProtocol(), Constants.FILE)) {
            return A.to(AbstractC0180x.SYSTEM, V.Companion.get(new File(url.toURI()), false));
        }
        return null;
    }

    public final C1938s toJarRoot(URL url) {
        int iG;
        E.f(url, "<this>");
        String string = url.toString();
        E.e(string, "toString()");
        if (!W.startsWith(string, "jar:file:", false) || (iG = b0.g("!", 0, 6, string)) == -1) {
            return null;
        }
        U u6 = V.Companion;
        String strSubstring = string.substring(4, iG);
        E.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return A.to(t.openZip(u6.get(new File(URI.create(strSubstring)), false), AbstractC0180x.SYSTEM, k.f110a), getROOT());
    }
}
