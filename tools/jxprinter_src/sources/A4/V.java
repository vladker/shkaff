package A4;

import com.alibaba.android.arouter.utils.Consts;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class V implements Comparable {
    public static final U Companion = new U();
    public static final String DIRECTORY_SEPARATOR;
    private final C0173p bytes;

    static {
        String separator = File.separator;
        kotlin.jvm.internal.E.e(separator, "separator");
        DIRECTORY_SEPARATOR = separator;
    }

    public V(C0173p bytes) {
        kotlin.jvm.internal.E.f(bytes, "bytes");
        this.bytes = bytes;
    }

    public static final V get(File file) {
        return Companion.get(file);
    }

    public boolean equals(Object obj) {
        return (obj instanceof V) && kotlin.jvm.internal.E.a(((V) obj).getBytes$okio(), getBytes$okio());
    }

    public final C0173p getBytes$okio() {
        return this.bytes;
    }

    public final V getRoot() {
        int iG = B4.g.g(this);
        if (iG == -1) {
            return null;
        }
        return new V(getBytes$okio().substring(0, iG));
    }

    public final List<String> getSegments() {
        ArrayList arrayList = new ArrayList();
        int iG = B4.g.g(this);
        int i5 = 0;
        if (iG == -1) {
            iG = 0;
        } else if (iG < getBytes$okio().size() && getBytes$okio().getByte(iG) == 92) {
            iG++;
        }
        int size = getBytes$okio().size();
        int i6 = iG;
        while (iG < size) {
            if (getBytes$okio().getByte(iG) == 47 || getBytes$okio().getByte(iG) == 92) {
                arrayList.add(getBytes$okio().substring(i6, iG));
                i6 = iG + 1;
            }
            iG++;
        }
        if (i6 < getBytes$okio().size()) {
            arrayList.add(getBytes$okio().substring(i6, getBytes$okio().size()));
        }
        ArrayList arrayList2 = new ArrayList(A3.J.collectionSizeOrDefault(arrayList, 10));
        int size2 = arrayList.size();
        while (i5 < size2) {
            Object obj = arrayList.get(i5);
            i5++;
            arrayList2.add(((C0173p) obj).utf8());
        }
        return arrayList2;
    }

    public final List<C0173p> getSegmentsBytes() {
        ArrayList arrayList = new ArrayList();
        int iG = B4.g.g(this);
        if (iG == -1) {
            iG = 0;
        } else if (iG < getBytes$okio().size() && getBytes$okio().getByte(iG) == 92) {
            iG++;
        }
        int size = getBytes$okio().size();
        int i5 = iG;
        while (iG < size) {
            if (getBytes$okio().getByte(iG) == 47 || getBytes$okio().getByte(iG) == 92) {
                arrayList.add(getBytes$okio().substring(i5, iG));
                i5 = iG + 1;
            }
            iG++;
        }
        if (i5 < getBytes$okio().size()) {
            arrayList.add(getBytes$okio().substring(i5, getBytes$okio().size()));
        }
        return arrayList;
    }

    public final int hashCode() {
        return getBytes$okio().hashCode();
    }

    public final String name() {
        return nameBytes().utf8();
    }

    public final C0173p nameBytes() {
        int iD = B4.g.d(this);
        if (iD != -1) {
            return C0173p.c(iD + 1, getBytes$okio(), 0, 2);
        }
        return (volumeLetter() == null || getBytes$okio().size() != 2) ? getBytes$okio() : C0173p.EMPTY;
    }

    public final V normalized() {
        return Companion.get(toString(), true);
    }

    public final V parent() {
        if (kotlin.jvm.internal.E.a(getBytes$okio(), B4.g.DOT) || kotlin.jvm.internal.E.a(getBytes$okio(), B4.g.SLASH) || kotlin.jvm.internal.E.a(getBytes$okio(), B4.g.BACKSLASH) || B4.g.f(this)) {
            return null;
        }
        int iD = B4.g.d(this);
        if (iD == 2 && volumeLetter() != null) {
            if (getBytes$okio().size() == 3) {
                return null;
            }
            return new V(C0173p.c(0, getBytes$okio(), 3, 1));
        }
        if (iD == 1 && getBytes$okio().startsWith(B4.g.BACKSLASH)) {
            return null;
        }
        if (iD != -1 || volumeLetter() == null) {
            if (iD == -1) {
                return new V(B4.g.DOT);
            }
            return iD == 0 ? new V(C0173p.c(0, getBytes$okio(), 1, 1)) : new V(C0173p.c(0, getBytes$okio(), iD, 1));
        }
        if (getBytes$okio().size() == 2) {
            return null;
        }
        return new V(C0173p.c(0, getBytes$okio(), 2, 1));
    }

    public final V relativeTo(V other) {
        kotlin.jvm.internal.E.f(other, "other");
        if (!kotlin.jvm.internal.E.a(getRoot(), other.getRoot())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
        }
        List<C0173p> segmentsBytes = getSegmentsBytes();
        List<C0173p> segmentsBytes2 = other.getSegmentsBytes();
        int iMin = Math.min(segmentsBytes.size(), segmentsBytes2.size());
        int i5 = 0;
        while (i5 < iMin && kotlin.jvm.internal.E.a(segmentsBytes.get(i5), segmentsBytes2.get(i5))) {
            i5++;
        }
        if (i5 == iMin && getBytes$okio().size() == other.getBytes$okio().size()) {
            return Companion.get(Consts.DOT, false);
        }
        if (segmentsBytes2.subList(i5, segmentsBytes2.size()).indexOf(B4.g.DOT_DOT) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        C0169l c0169l = new C0169l();
        C0173p c0173pH = B4.g.h(other);
        if (c0173pH == null && (c0173pH = B4.g.h(this)) == null) {
            c0173pH = B4.g.j(DIRECTORY_SEPARATOR);
        }
        int size = segmentsBytes2.size();
        for (int i6 = i5; i6 < size; i6++) {
            c0169l.write(B4.g.DOT_DOT);
            c0169l.write(c0173pH);
        }
        int size2 = segmentsBytes.size();
        while (i5 < size2) {
            c0169l.write(segmentsBytes.get(i5));
            c0169l.write(c0173pH);
            i5++;
        }
        return B4.g.toPath(c0169l, false);
    }

    public final V resolve(V child) {
        kotlin.jvm.internal.E.f(child, "child");
        return B4.g.commonResolve(this, child, false);
    }

    public final File toFile() {
        return new File(toString());
    }

    public final Path toNioPath() {
        Path path = Paths.get(toString(), new String[0]);
        kotlin.jvm.internal.E.e(path, "get(toString())");
        return path;
    }

    public String toString() {
        return getBytes$okio().utf8();
    }

    public final Character volumeLetter() {
        if (getBytes$okio().indexOf(B4.g.SLASH, 0) != -1 || getBytes$okio().size() < 2 || getBytes$okio().getByte(1) != 58) {
            return null;
        }
        char c = (char) getBytes$okio().getByte(0);
        if (('a' > c || c >= '{') && ('A' > c || c >= '[')) {
            return null;
        }
        return Character.valueOf(c);
    }

    public static final V get(File file, boolean z6) {
        return Companion.get(file, z6);
    }

    @Override // java.lang.Comparable
    public int compareTo(V other) {
        kotlin.jvm.internal.E.f(other, "other");
        return getBytes$okio().compareTo(other.getBytes$okio());
    }

    public final V resolve(V child, boolean z6) {
        kotlin.jvm.internal.E.f(child, "child");
        return B4.g.commonResolve(this, child, z6);
    }

    public static final V get(String str) {
        return Companion.get(str);
    }

    public final V resolve(String child) {
        kotlin.jvm.internal.E.f(child, "child");
        return B4.g.commonResolve(this, B4.g.toPath(new C0169l().writeUtf8(child), false), false);
    }

    public static final V get(String str, boolean z6) {
        return Companion.get(str, z6);
    }

    public static final V get(Path path) {
        return Companion.get(path);
    }

    public static final V get(Path path, boolean z6) {
        return Companion.get(path, z6);
    }

    public final V resolve(C0173p child) {
        kotlin.jvm.internal.E.f(child, "child");
        return B4.g.commonResolve(this, B4.g.toPath(new C0169l().write(child), false), false);
    }

    public final V resolve(String child, boolean z6) {
        kotlin.jvm.internal.E.f(child, "child");
        return B4.g.commonResolve(this, B4.g.toPath(new C0169l().writeUtf8(child), false), z6);
    }

    public final V resolve(C0173p child, boolean z6) {
        kotlin.jvm.internal.E.f(child, "child");
        return B4.g.commonResolve(this, B4.g.toPath(new C0169l().write(child), false), z6);
    }
}
