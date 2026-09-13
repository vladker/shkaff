package A4;

import A3.AbstractC0157z;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import p147z3.AbstractC1926f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class m0 extends AbstractC0180x {
    private static final l0 Companion = new l0();

    @Deprecated
    private static final V ROOT = V.Companion.get(PackagingURIHelper.FORWARD_SLASH_STRING, false);
    private final String comment;
    private final Map<V, B4.o> entries;
    private final AbstractC0180x fileSystem;
    private final V zipPath;

    public m0(V zipPath, AbstractC0180x fileSystem, Map<V, B4.o> entries, String str) {
        kotlin.jvm.internal.E.f(zipPath, "zipPath");
        kotlin.jvm.internal.E.f(fileSystem, "fileSystem");
        kotlin.jvm.internal.E.f(entries, "entries");
        this.zipPath = zipPath;
        this.fileSystem = fileSystem;
        this.entries = entries;
        this.comment = str;
    }

    @Override // A4.AbstractC0180x
    public f0 appendingSink(V file, boolean z6) throws IOException {
        kotlin.jvm.internal.E.f(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // A4.AbstractC0180x
    public void atomicMove(V source, V target) throws IOException {
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    public final List b(V v6, boolean z6) throws IOException {
        B4.o oVar = this.entries.get(ROOT.resolve(v6, true));
        if (oVar != null) {
            return A3.T.toList(oVar.getChildren());
        }
        if (z6) {
            throw new IOException(AbstractC0157z.m("not a directory: ", v6));
        }
        return null;
    }

    @Override // A4.AbstractC0180x
    public V canonicalize(V path) throws FileNotFoundException {
        kotlin.jvm.internal.E.f(path, "path");
        V vResolve = ROOT.resolve(path, true);
        if (this.entries.containsKey(vResolve)) {
            return vResolve;
        }
        throw new FileNotFoundException(String.valueOf(path));
    }

    @Override // A4.AbstractC0180x
    public void createDirectory(V dir, boolean z6) throws IOException {
        kotlin.jvm.internal.E.f(dir, "dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override // A4.AbstractC0180x
    public void createSymlink(V source, V target) throws IOException {
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // A4.AbstractC0180x
    public void delete(V path, boolean z6) throws IOException {
        kotlin.jvm.internal.E.f(path, "path");
        throw new IOException("zip file systems are read-only");
    }

    @Override // A4.AbstractC0180x
    public List<V> list(V dir) throws IOException {
        kotlin.jvm.internal.E.f(dir, "dir");
        List<V> listB = b(dir, true);
        kotlin.jvm.internal.E.c(listB);
        return listB;
    }

    @Override // A4.AbstractC0180x
    public List<V> listOrNull(V dir) {
        kotlin.jvm.internal.E.f(dir, "dir");
        return b(dir, false);
    }

    @Override // A4.AbstractC0180x
    public C0178v metadataOrNull(V path) throws Throwable {
        InterfaceC0171n interfaceC0171nBuffer;
        kotlin.jvm.internal.E.f(path, "path");
        B4.o oVar = this.entries.get(ROOT.resolve(path, true));
        Throwable th = null;
        if (oVar == null) {
            return null;
        }
        long j6 = oVar.e;
        boolean z6 = oVar.f112a;
        C0178v c0178v = new C0178v(!z6, z6, null, z6 ? null : Long.valueOf(oVar.c), null, oVar.getLastModifiedAtMillis(), null);
        if (j6 == -1) {
            return c0178v;
        }
        AbstractC0177u abstractC0177uOpenReadOnly = this.fileSystem.openReadOnly(this.zipPath);
        try {
            interfaceC0171nBuffer = N.buffer(abstractC0177uOpenReadOnly.source(j6));
            try {
                abstractC0177uOpenReadOnly.close();
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            if (abstractC0177uOpenReadOnly != null) {
                try {
                    abstractC0177uOpenReadOnly.close();
                } catch (Throwable th4) {
                    AbstractC1926f.addSuppressed(th3, th4);
                }
            }
            interfaceC0171nBuffer = null;
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        kotlin.jvm.internal.E.c(interfaceC0171nBuffer);
        return B4.t.readLocalHeader(interfaceC0171nBuffer, c0178v);
    }

    @Override // A4.AbstractC0180x
    public AbstractC0177u openReadOnly(V file) {
        kotlin.jvm.internal.E.f(file, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // A4.AbstractC0180x
    public AbstractC0177u openReadWrite(V file, boolean z6, boolean z7) throws IOException {
        kotlin.jvm.internal.E.f(file, "file");
        throw new IOException("zip entries are not writable");
    }

    @Override // A4.AbstractC0180x
    public f0 sink(V file, boolean z6) throws IOException {
        kotlin.jvm.internal.E.f(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // A4.AbstractC0180x
    public h0 source(V file) throws Throwable {
        InterfaceC0171n interfaceC0171nBuffer;
        kotlin.jvm.internal.E.f(file, "file");
        B4.o oVar = this.entries.get(ROOT.resolve(file, true));
        if (oVar == null) {
            throw new FileNotFoundException(AbstractC0157z.m("no such file: ", file));
        }
        long j6 = oVar.c;
        AbstractC0177u abstractC0177uOpenReadOnly = this.fileSystem.openReadOnly(this.zipPath);
        Throwable th = null;
        try {
            interfaceC0171nBuffer = N.buffer(abstractC0177uOpenReadOnly.source(oVar.e));
            try {
                abstractC0177uOpenReadOnly.close();
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            if (abstractC0177uOpenReadOnly != null) {
                try {
                    abstractC0177uOpenReadOnly.close();
                } catch (Throwable th4) {
                    AbstractC1926f.addSuppressed(th3, th4);
                }
            }
            interfaceC0171nBuffer = null;
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        kotlin.jvm.internal.E.c(interfaceC0171nBuffer);
        B4.t.skipLocalHeader(interfaceC0171nBuffer);
        return oVar.d == 0 ? new B4.j(interfaceC0171nBuffer, j6, true) : new B4.j(new G(new B4.j(interfaceC0171nBuffer, oVar.b, true), new Inflater(true)), j6, false);
    }
}
