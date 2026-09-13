package B4;

import A3.AbstractC0157z;
import A3.J;
import A3.O;
import A3.T;
import A4.C0169l;
import A4.C0172o;
import A4.C0173p;
import A4.V;
import com.alibaba.android.arouter.utils.Consts;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.E;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class g {
    private static final C0173p ANY_SLASH;
    private static final C0173p BACKSLASH;
    private static final C0173p DOT;
    private static final C0173p DOT_DOT;
    private static final C0173p SLASH;

    static {
        C0172o c0172o = C0173p.Companion;
        SLASH = c0172o.encodeUtf8(PackagingURIHelper.FORWARD_SLASH_STRING);
        BACKSLASH = c0172o.encodeUtf8("\\");
        ANY_SLASH = c0172o.encodeUtf8("/\\");
        DOT = c0172o.encodeUtf8(Consts.DOT);
        DOT_DOT = c0172o.encodeUtf8("..");
    }

    public static final int commonCompareTo(V v6, V other) {
        E.f(v6, "<this>");
        E.f(other, "other");
        return v6.getBytes$okio().compareTo(other.getBytes$okio());
    }

    public static final boolean commonEquals(V v6, Object obj) {
        E.f(v6, "<this>");
        return (obj instanceof V) && E.a(((V) obj).getBytes$okio(), v6.getBytes$okio());
    }

    public static final int commonHashCode(V v6) {
        E.f(v6, "<this>");
        return v6.getBytes$okio().hashCode();
    }

    public static final boolean commonIsAbsolute(V v6) {
        E.f(v6, "<this>");
        return g(v6) != -1;
    }

    public static final boolean commonIsRelative(V v6) {
        E.f(v6, "<this>");
        return g(v6) == -1;
    }

    public static final boolean commonIsRoot(V v6) {
        E.f(v6, "<this>");
        return g(v6) == v6.getBytes$okio().size();
    }

    public static final String commonName(V v6) {
        E.f(v6, "<this>");
        return v6.nameBytes().utf8();
    }

    public static final C0173p commonNameBytes(V v6) {
        E.f(v6, "<this>");
        int iD = d(v6);
        if (iD != -1) {
            return C0173p.c(iD + 1, v6.getBytes$okio(), 0, 2);
        }
        return (v6.volumeLetter() == null || v6.getBytes$okio().size() != 2) ? v6.getBytes$okio() : C0173p.EMPTY;
    }

    public static final V commonNormalized(V v6) {
        E.f(v6, "<this>");
        return V.Companion.get(v6.toString(), true);
    }

    public static final V commonParent(V v6) {
        E.f(v6, "<this>");
        C0173p bytes$okio = v6.getBytes$okio();
        C0173p c0173p = DOT;
        if (E.a(bytes$okio, c0173p) || E.a(v6.getBytes$okio(), SLASH)) {
            return null;
        }
        C0173p bytes$okio2 = v6.getBytes$okio();
        C0173p c0173p2 = BACKSLASH;
        if (E.a(bytes$okio2, c0173p2) || f(v6)) {
            return null;
        }
        int iD = d(v6);
        if (iD == 2 && v6.volumeLetter() != null) {
            if (v6.getBytes$okio().size() == 3) {
                return null;
            }
            return new V(C0173p.c(0, v6.getBytes$okio(), 3, 1));
        }
        if (iD == 1 && v6.getBytes$okio().startsWith(c0173p2)) {
            return null;
        }
        if (iD != -1 || v6.volumeLetter() == null) {
            if (iD == -1) {
                return new V(c0173p);
            }
            return iD == 0 ? new V(C0173p.c(0, v6.getBytes$okio(), 1, 1)) : new V(C0173p.c(0, v6.getBytes$okio(), iD, 1));
        }
        if (v6.getBytes$okio().size() == 2) {
            return null;
        }
        return new V(C0173p.c(0, v6.getBytes$okio(), 2, 1));
    }

    public static final V commonRelativeTo(V v6, V other) {
        E.f(v6, "<this>");
        E.f(other, "other");
        if (!E.a(v6.getRoot(), other.getRoot())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + v6 + " and " + other).toString());
        }
        List<C0173p> segmentsBytes = v6.getSegmentsBytes();
        List<C0173p> segmentsBytes2 = other.getSegmentsBytes();
        int iMin = Math.min(segmentsBytes.size(), segmentsBytes2.size());
        int i5 = 0;
        while (i5 < iMin && E.a(segmentsBytes.get(i5), segmentsBytes2.get(i5))) {
            i5++;
        }
        if (i5 == iMin && v6.getBytes$okio().size() == other.getBytes$okio().size()) {
            return V.Companion.get(Consts.DOT, false);
        }
        if (segmentsBytes2.subList(i5, segmentsBytes2.size()).indexOf(DOT_DOT) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + v6 + " and " + other).toString());
        }
        C0169l c0169l = new C0169l();
        C0173p c0173pH = h(other);
        if (c0173pH == null && (c0173pH = h(v6)) == null) {
            c0173pH = j(V.DIRECTORY_SEPARATOR);
        }
        int size = segmentsBytes2.size();
        for (int i6 = i5; i6 < size; i6++) {
            c0169l.write(DOT_DOT);
            c0169l.write(c0173pH);
        }
        int size2 = segmentsBytes.size();
        while (i5 < size2) {
            c0169l.write(segmentsBytes.get(i5));
            c0169l.write(c0173pH);
            i5++;
        }
        return toPath(c0169l, false);
    }

    public static final V commonResolve(V v6, V child, boolean z6) {
        E.f(v6, "<this>");
        E.f(child, "child");
        if (g(child) != -1 || child.volumeLetter() != null) {
            return child;
        }
        C0173p c0173pH = h(v6);
        if (c0173pH == null && (c0173pH = h(child)) == null) {
            c0173pH = j(V.DIRECTORY_SEPARATOR);
        }
        C0169l c0169l = new C0169l();
        c0169l.write(v6.getBytes$okio());
        if (c0169l.size() > 0) {
            c0169l.write(c0173pH);
        }
        c0169l.write(child.getBytes$okio());
        return toPath(c0169l, z6);
    }

    public static final V commonRoot(V v6) {
        E.f(v6, "<this>");
        int iG = g(v6);
        if (iG == -1) {
            return null;
        }
        return new V(v6.getBytes$okio().substring(0, iG));
    }

    public static final List<String> commonSegments(V v6) {
        E.f(v6, "<this>");
        ArrayList arrayList = new ArrayList();
        int iG = g(v6);
        int i5 = 0;
        if (iG == -1) {
            iG = 0;
        } else if (iG < v6.getBytes$okio().size() && v6.getBytes$okio().getByte(iG) == 92) {
            iG++;
        }
        int size = v6.getBytes$okio().size();
        int i6 = iG;
        while (iG < size) {
            if (v6.getBytes$okio().getByte(iG) == 47 || v6.getBytes$okio().getByte(iG) == 92) {
                arrayList.add(v6.getBytes$okio().substring(i6, iG));
                i6 = iG + 1;
            }
            iG++;
        }
        if (i6 < v6.getBytes$okio().size()) {
            arrayList.add(v6.getBytes$okio().substring(i6, v6.getBytes$okio().size()));
        }
        ArrayList arrayList2 = new ArrayList(J.collectionSizeOrDefault(arrayList, 10));
        int size2 = arrayList.size();
        while (i5 < size2) {
            Object obj = arrayList.get(i5);
            i5++;
            arrayList2.add(((C0173p) obj).utf8());
        }
        return arrayList2;
    }

    public static final List<C0173p> commonSegmentsBytes(V v6) {
        E.f(v6, "<this>");
        ArrayList arrayList = new ArrayList();
        int iG = g(v6);
        if (iG == -1) {
            iG = 0;
        } else if (iG < v6.getBytes$okio().size() && v6.getBytes$okio().getByte(iG) == 92) {
            iG++;
        }
        int size = v6.getBytes$okio().size();
        int i5 = iG;
        while (iG < size) {
            if (v6.getBytes$okio().getByte(iG) == 47 || v6.getBytes$okio().getByte(iG) == 92) {
                arrayList.add(v6.getBytes$okio().substring(i5, iG));
                i5 = iG + 1;
            }
            iG++;
        }
        if (i5 < v6.getBytes$okio().size()) {
            arrayList.add(v6.getBytes$okio().substring(i5, v6.getBytes$okio().size()));
        }
        return arrayList;
    }

    public static final V commonToPath(String str, boolean z6) {
        E.f(str, "<this>");
        return toPath(new C0169l().writeUtf8(str), z6);
    }

    public static final String commonToString(V v6) {
        E.f(v6, "<this>");
        return v6.getBytes$okio().utf8();
    }

    public static final Character commonVolumeLetter(V v6) {
        E.f(v6, "<this>");
        if (v6.getBytes$okio().indexOf(SLASH, 0) != -1 || v6.getBytes$okio().size() < 2 || v6.getBytes$okio().getByte(1) != 58) {
            return null;
        }
        char c = (char) v6.getBytes$okio().getByte(0);
        if (('a' > c || c >= '{') && ('A' > c || c >= '[')) {
            return null;
        }
        return Character.valueOf(c);
    }

    public static final int d(V v6) {
        int iLastIndexOf = v6.getBytes$okio().lastIndexOf(SLASH, -1234567890);
        return iLastIndexOf != -1 ? iLastIndexOf : v6.getBytes$okio().lastIndexOf(BACKSLASH, -1234567890);
    }

    public static final boolean f(V v6) {
        return v6.getBytes$okio().endsWith(DOT_DOT) && (v6.getBytes$okio().size() == 2 || v6.getBytes$okio().rangeEquals(v6.getBytes$okio().size() + (-3), SLASH, 0, 1) || v6.getBytes$okio().rangeEquals(v6.getBytes$okio().size() + (-3), BACKSLASH, 0, 1));
    }

    public static final int g(V v6) {
        if (v6.getBytes$okio().size() != 0) {
            if (v6.getBytes$okio().getByte(0) != 47) {
                if (v6.getBytes$okio().getByte(0) == 92) {
                    if (v6.getBytes$okio().size() > 2 && v6.getBytes$okio().getByte(1) == 92) {
                        int iIndexOf = v6.getBytes$okio().indexOf(BACKSLASH, 2);
                        return iIndexOf == -1 ? v6.getBytes$okio().size() : iIndexOf;
                    }
                } else if (v6.getBytes$okio().size() > 2 && v6.getBytes$okio().getByte(1) == 58 && v6.getBytes$okio().getByte(2) == 92) {
                    char c = (char) v6.getBytes$okio().getByte(0);
                    if ('a' <= c && c < '{') {
                        return 3;
                    }
                    if ('A' <= c && c < '[') {
                        return 3;
                    }
                }
            }
            return 1;
        }
        return -1;
    }

    public static final C0173p h(V v6) {
        C0173p bytes$okio = v6.getBytes$okio();
        C0173p c0173p = SLASH;
        if (bytes$okio.indexOf(c0173p, 0) != -1) {
            return c0173p;
        }
        C0173p bytes$okio2 = v6.getBytes$okio();
        C0173p c0173p2 = BACKSLASH;
        if (bytes$okio2.indexOf(c0173p2, 0) != -1) {
            return c0173p2;
        }
        return null;
    }

    public static final C0173p i(byte b) {
        if (b == 47) {
            return SLASH;
        }
        if (b == 92) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(b, "not a directory separator: "));
    }

    public static final C0173p j(String str) {
        if (E.a(str, PackagingURIHelper.FORWARD_SLASH_STRING)) {
            return SLASH;
        }
        if (E.a(str, "\\")) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException(AbstractC0157z.n("not a directory separator: ", str));
    }

    public static final V toPath(C0169l c0169l, boolean z6) throws EOFException {
        C0173p c0173p;
        char c;
        C0173p byteString;
        E.f(c0169l, "<this>");
        C0169l c0169l2 = new C0169l();
        C0173p c0173pI = null;
        int i5 = 0;
        while (true) {
            if (!c0169l.rangeEquals(0L, SLASH)) {
                c0173p = BACKSLASH;
                if (!c0169l.rangeEquals(0L, c0173p)) {
                    break;
                }
            }
            byte b = c0169l.readByte();
            if (c0173pI == null) {
                c0173pI = i(b);
            }
            i5++;
        }
        boolean z7 = i5 >= 2 && E.a(c0173pI, c0173p);
        if (z7) {
            E.c(c0173pI);
            c0169l2.write(c0173pI);
            c0169l2.write(c0173pI);
        } else if (i5 > 0) {
            E.c(c0173pI);
            c0169l2.write(c0173pI);
        } else {
            long jIndexOfElement = c0169l.indexOfElement(ANY_SLASH);
            if (c0173pI == null) {
                c0173pI = jIndexOfElement == -1 ? j(V.DIRECTORY_SEPARATOR) : i(c0169l.getByte(jIndexOfElement));
            }
            if (E.a(c0173pI, c0173p) && c0169l.size() >= 2 && c0169l.getByte(1L) == 58 && (('a' <= (c = (char) c0169l.getByte(0L)) && c < '{') || ('A' <= c && c < '['))) {
                if (jIndexOfElement == 2) {
                    c0169l2.write(c0169l, 3L);
                } else {
                    c0169l2.write(c0169l, 2L);
                }
            }
        }
        boolean z8 = c0169l2.size() > 0;
        ArrayList arrayList = new ArrayList();
        while (!c0169l.exhausted()) {
            long jIndexOfElement2 = c0169l.indexOfElement(ANY_SLASH);
            if (jIndexOfElement2 == -1) {
                byteString = c0169l.readByteString();
            } else {
                byteString = c0169l.readByteString(jIndexOfElement2);
                c0169l.readByte();
            }
            C0173p c0173p2 = DOT_DOT;
            if (E.a(byteString, c0173p2)) {
                if (!z8 || !arrayList.isEmpty()) {
                    if (!z6 || (!z8 && (arrayList.isEmpty() || E.a(T.last((List) arrayList), c0173p2)))) {
                        arrayList.add(byteString);
                    } else if (!z7 || arrayList.size() != 1) {
                        O.removeLastOrNull(arrayList);
                    }
                }
            } else if (!E.a(byteString, DOT) && !E.a(byteString, C0173p.EMPTY)) {
                arrayList.add(byteString);
            }
        }
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (i6 > 0) {
                c0169l2.write(c0173pI);
            }
            c0169l2.write((C0173p) arrayList.get(i6));
        }
        if (c0169l2.size() == 0) {
            c0169l2.write(DOT);
        }
        return new V(c0169l2.readByteString());
    }

    public static final V commonResolve(V v6, String child, boolean z6) {
        E.f(v6, "<this>");
        E.f(child, "child");
        return commonResolve(v6, toPath(new C0169l().writeUtf8(child), false), z6);
    }

    public static final V commonResolve(V v6, C0173p child, boolean z6) {
        E.f(v6, "<this>");
        E.f(child, "child");
        return commonResolve(v6, toPath(new C0169l().write(child), false), z6);
    }

    public static final V commonResolve(V v6, C0169l child, boolean z6) {
        E.f(v6, "<this>");
        E.f(child, "child");
        return commonResolve(v6, toPath(child, false), z6);
    }
}
