package B4;

import A3.AbstractC0157z;
import A3.J;
import A3.O;
import A3.T;
import A4.AbstractC0177u;
import A4.AbstractC0180x;
import A4.C0178v;
import A4.V;
import A4.f0;
import A4.h0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.E;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import p147z3.AbstractC1935o;
import p147z3.C1938s;
import p147z3.InterfaceC1934n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class n extends AbstractC0180x {
    private static final l Companion = new l();

    @Deprecated
    private static final V ROOT = V.Companion.get(PackagingURIHelper.FORWARD_SLASH_STRING, false);
    private final InterfaceC1934n roots$delegate;

    public n(ClassLoader classLoader, boolean z6) {
        E.f(classLoader, "classLoader");
        this.roots$delegate = AbstractC1935o.lazy(new m(classLoader));
        if (z6) {
            c().size();
        }
    }

    public static String d(V v6) {
        V v7 = ROOT;
        return v7.resolve(v6, true).relativeTo(v7).toString();
    }

    @Override // A4.AbstractC0180x
    public f0 appendingSink(V file, boolean z6) throws IOException {
        E.f(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // A4.AbstractC0180x
    public void atomicMove(V source, V target) throws IOException {
        E.f(source, "source");
        E.f(target, "target");
        throw new IOException(this + " is read-only");
    }

    public final List c() {
        return (List) this.roots$delegate.getValue();
    }

    @Override // A4.AbstractC0180x
    public V canonicalize(V path) {
        E.f(path, "path");
        return ROOT.resolve(path, true);
    }

    @Override // A4.AbstractC0180x
    public void createDirectory(V dir, boolean z6) throws IOException {
        E.f(dir, "dir");
        throw new IOException(this + " is read-only");
    }

    @Override // A4.AbstractC0180x
    public void createSymlink(V source, V target) throws IOException {
        E.f(source, "source");
        E.f(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // A4.AbstractC0180x
    public void delete(V path, boolean z6) throws IOException {
        E.f(path, "path");
        throw new IOException(this + " is read-only");
    }

    @Override // A4.AbstractC0180x
    public List<V> list(V dir) throws FileNotFoundException {
        E.f(dir, "dir");
        String strD = d(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z6 = false;
        for (C1938s c1938s : c()) {
            AbstractC0180x abstractC0180x = (AbstractC0180x) c1938s.f9134a;
            V v6 = (V) c1938s.b;
            try {
                List<V> list = abstractC0180x.list(v6.resolve(strD));
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (l.a(Companion, (V) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(J.collectionSizeOrDefault(arrayList, 10));
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj2 = arrayList.get(i5);
                    i5++;
                    arrayList2.add(Companion.removeBase((V) obj2, v6));
                }
                O.addAll(linkedHashSet, arrayList2);
                z6 = true;
            } catch (IOException unused) {
            }
        }
        if (z6) {
            return T.toList(linkedHashSet);
        }
        throw new FileNotFoundException(AbstractC0157z.m("file not found: ", dir));
    }

    @Override // A4.AbstractC0180x
    public List<V> listOrNull(V dir) {
        E.f(dir, "dir");
        String strD = d(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = c().iterator();
        boolean z6 = false;
        while (true) {
            ArrayList arrayList = null;
            if (!it.hasNext()) {
                break;
            }
            C1938s c1938s = (C1938s) it.next();
            AbstractC0180x abstractC0180x = (AbstractC0180x) c1938s.f9134a;
            V v6 = (V) c1938s.b;
            List<V> listListOrNull = abstractC0180x.listOrNull(v6.resolve(strD));
            if (listListOrNull != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listListOrNull) {
                    if (l.a(Companion, (V) obj)) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList(J.collectionSizeOrDefault(arrayList2, 10));
                int size = arrayList2.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj2 = arrayList2.get(i5);
                    i5++;
                    arrayList3.add(Companion.removeBase((V) obj2, v6));
                }
                arrayList = arrayList3;
            }
            if (arrayList != null) {
                O.addAll(linkedHashSet, arrayList);
                z6 = true;
            }
        }
        if (z6) {
            return T.toList(linkedHashSet);
        }
        return null;
    }

    @Override // A4.AbstractC0180x
    public C0178v metadataOrNull(V path) {
        E.f(path, "path");
        if (!l.a(Companion, path)) {
            return null;
        }
        String strD = d(path);
        for (C1938s c1938s : c()) {
            C0178v c0178vMetadataOrNull = ((AbstractC0180x) c1938s.f9134a).metadataOrNull(((V) c1938s.b).resolve(strD));
            if (c0178vMetadataOrNull != null) {
                return c0178vMetadataOrNull;
            }
        }
        return null;
    }

    @Override // A4.AbstractC0180x
    public AbstractC0177u openReadOnly(V file) throws FileNotFoundException {
        E.f(file, "file");
        if (!l.a(Companion, file)) {
            throw new FileNotFoundException(AbstractC0157z.m("file not found: ", file));
        }
        String strD = d(file);
        for (C1938s c1938s : c()) {
            try {
                return ((AbstractC0180x) c1938s.f9134a).openReadOnly(((V) c1938s.b).resolve(strD));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException(AbstractC0157z.m("file not found: ", file));
    }

    @Override // A4.AbstractC0180x
    public AbstractC0177u openReadWrite(V file, boolean z6, boolean z7) throws IOException {
        E.f(file, "file");
        throw new IOException("resources are not writable");
    }

    @Override // A4.AbstractC0180x
    public f0 sink(V file, boolean z6) throws IOException {
        E.f(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // A4.AbstractC0180x
    public h0 source(V file) throws FileNotFoundException {
        E.f(file, "file");
        if (!l.a(Companion, file)) {
            throw new FileNotFoundException(AbstractC0157z.m("file not found: ", file));
        }
        String strD = d(file);
        for (C1938s c1938s : c()) {
            try {
                return ((AbstractC0180x) c1938s.f9134a).source(((V) c1938s.b).resolve(strD));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException(AbstractC0157z.m("file not found: ", file));
    }
}
