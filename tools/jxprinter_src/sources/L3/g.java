package L3;

import A3.T;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private final File root;
    private final List<File> segments;

    /* JADX WARN: Multi-variable type inference failed */
    public g(File root, List<? extends File> segments) {
        E.f(root, "root");
        E.f(segments, "segments");
        this.root = root;
        this.segments = segments;
    }

    public final int a() {
        return this.segments.size();
    }

    public final boolean b() {
        String path = this.root.getPath();
        E.e(path, "getPath(...)");
        return path.length() > 0;
    }

    public final File component1() {
        return this.root;
    }

    public final List<File> component2() {
        return this.segments;
    }

    public final g copy$kotlin_stdlib(File root, List<? extends File> segments) {
        E.f(root, "root");
        E.f(segments, "segments");
        return new g(root, segments);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return E.a(this.root, gVar.root) && E.a(this.segments, gVar.segments);
    }

    public final File getRoot() {
        return this.root;
    }

    public final String getRootName() {
        String path = this.root.getPath();
        E.e(path, "getPath(...)");
        return path;
    }

    public final List<File> getSegments() {
        return this.segments;
    }

    public final int hashCode() {
        return this.segments.hashCode() + (this.root.hashCode() * 31);
    }

    public final File subPath(int i5, int i6) {
        if (i5 < 0 || i5 > i6 || i6 > this.segments.size()) {
            throw new IllegalArgumentException();
        }
        List<File> listSubList = this.segments.subList(i5, i6);
        String separator = File.separator;
        E.e(separator, "separator");
        return new File(T.g(listSubList, separator, null, null, null, 62));
    }

    public String toString() {
        return "FilePathComponents(root=" + this.root + ", segments=" + this.segments + ')';
    }
}
