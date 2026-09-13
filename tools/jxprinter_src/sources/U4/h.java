package U4;

import A3.AbstractC0157z;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import kotlin.jvm.internal.D;
import org.jsoup.nodes.m;
import org.jsoup.nodes.s;
import org.jsoup.parser.C;
import org.jsoup.parser.C1467b;
import org.jsoup.parser.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class h {
    public static V4.g a(String str) {
        String externalForm;
        V4.g gVar = new V4.g();
        V4.h.notEmpty(str, "Must supply a valid URL");
        try {
            V4.e eVar = gVar.f783a;
            try {
                externalForm = V4.g.a(new URL(str)).toExternalForm();
            } catch (Exception unused) {
                externalForm = str;
            }
            URL url = new URL(externalForm);
            eVar.getClass();
            V4.h.notNull(url, "URL must not be null");
            eVar.f767a = V4.g.b(url);
            return gVar;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(AbstractC0157z.n("Malformed URL: ", str), e);
        }
    }

    public static org.jsoup.nodes.i b(String str, String str2) {
        org.jsoup.nodes.i iVarW = org.jsoup.nodes.i.W(str2);
        m mVarT = iVarW.T();
        C1467b c1467b = new C1467b();
        List<s> fragment = c1467b.parseFragment(str, mVarT, str2, new E(c1467b));
        s[] sVarArr = (s[]) fragment.toArray(new s[0]);
        for (int length = sVarArr.length - 1; length > 0; length--) {
            sVarArr[length].u();
        }
        for (s sVar : sVarArr) {
            mVarT.z(sVar);
        }
        return iVarW;
    }

    @Deprecated
    public static String clean(String str, String str2, X4.b bVar) {
        org.jsoup.nodes.i iVarB = b(str, str2);
        X4.a aVar = new X4.a();
        V4.h.notNull(iVarB);
        org.jsoup.nodes.i iVarW = org.jsoup.nodes.i.W(iVarB.i());
        m mVarT = iVarB.T();
        D.c(new p096r.f(aVar, mVarT, iVarW.T()), mVarT);
        org.jsoup.nodes.h hVarClone = iVarB.f7471g.clone();
        V4.h.notNull(hVarClone);
        iVarW.f7471g = hVarClone;
        return iVarW.T().J();
    }

    @Deprecated
    public static boolean isValid(String str, X4.b bVar) {
        X4.a aVar = new X4.a();
        org.jsoup.nodes.i iVarW = org.jsoup.nodes.i.W("");
        org.jsoup.nodes.i iVarW2 = org.jsoup.nodes.i.W("");
        C c = new C(16, 1);
        m mVarT = iVarW2.T();
        C1467b c1467b = new C1467b();
        E e = new E(c1467b);
        e.b = c;
        iVarW2.T().M(0, c1467b.parseFragment(str, mVarT, "", e));
        m mVarT2 = iVarW2.T();
        p096r.f fVar = new p096r.f(aVar, mVarT2, iVarW.T());
        D.c(fVar, mVarT2);
        return fVar.f7911a == 0 && c.isEmpty();
    }

    public static org.jsoup.nodes.i parse(URL url, int i5) {
        V4.g gVar = new V4.g();
        V4.e eVar = gVar.f783a;
        eVar.getClass();
        V4.h.notNull(url, "URL must not be null");
        eVar.f767a = V4.g.b(url);
        V4.e eVar2 = gVar.f783a;
        eVar2.getClass();
        V4.h.a("Timeout milliseconds must be 0 (infinite) or greater", i5 >= 0);
        eVar2.f768f = i5;
        return gVar.get();
    }

    public static org.jsoup.nodes.i parse(File file, String str, String str2) {
        return V4.c.load(file, str, str2);
    }

    public static org.jsoup.nodes.i parse(File file, String str) {
        return V4.c.load(file, str, file.getAbsolutePath());
    }

    public static org.jsoup.nodes.i parse(File file, String str, String str2, E e) {
        return V4.c.load(file, str, str2, e);
    }

    @Deprecated
    public static String clean(String str, X4.b bVar) {
        org.jsoup.nodes.i iVarB = b(str, "");
        X4.a aVar = new X4.a();
        V4.h.notNull(iVarB);
        org.jsoup.nodes.i iVarW = org.jsoup.nodes.i.W(iVarB.i());
        m mVarT = iVarB.T();
        D.c(new p096r.f(aVar, mVarT, iVarW.T()), mVarT);
        org.jsoup.nodes.h hVarClone = iVarB.f7471g.clone();
        V4.h.notNull(hVarClone);
        iVarW.f7471g = hVarClone;
        return iVarW.T().J();
    }

    public static org.jsoup.nodes.i parse(InputStream inputStream, String str, String str2) {
        return V4.c.load(inputStream, str, str2);
    }

    public static org.jsoup.nodes.i parse(InputStream inputStream, String str, String str2, E e) {
        return V4.c.load(inputStream, str, str2, e);
    }

    @Deprecated
    public static String clean(String str, String str2, X4.b bVar, org.jsoup.nodes.h hVar) {
        org.jsoup.nodes.i iVarB = b(str, str2);
        X4.a aVar = new X4.a();
        V4.h.notNull(iVarB);
        org.jsoup.nodes.i iVarW = org.jsoup.nodes.i.W(iVarB.i());
        m mVarT = iVarB.T();
        D.c(new p096r.f(aVar, mVarT, iVarW.T()), mVarT);
        org.jsoup.nodes.h hVarClone = iVarB.f7471g.clone();
        V4.h.notNull(hVarClone);
        iVarW.f7471g = hVarClone;
        V4.h.notNull(hVar);
        iVarW.f7471g = hVar;
        return iVarW.T().J();
    }
}
