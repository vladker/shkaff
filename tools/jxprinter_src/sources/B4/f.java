package B4;

import A3.AbstractC0157z;
import A3.C0144l;
import A4.AbstractC0180x;
import A4.C0178v;
import A4.InterfaceC0170m;
import A4.N;
import A4.V;
import A4.h0;
import W3.InterfaceC0233q;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import kotlin.jvm.internal.E;
import p147z3.AbstractC1926f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class f {
    /* JADX WARN: Code duplicated, block: B:50:0x00db A[Catch: all -> 0x0118, TRY_LEAVE, TryCatch #1 {all -> 0x0118, blocks: (B:48:0x00d5, B:50:0x00db, B:47:0x00cd), top: B:75:0x00cd }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0110  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0110 -> B:19:0x0053). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object collectRecursively(W3.AbstractC0234s r15, A4.AbstractC0180x r16, A3.C0144l r17, A4.V r18, boolean r19, boolean r20, E3.g<? super p147z3.Q> r21) {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B4.f.collectRecursively(W3.s, A4.x, A3.l, A4.V, boolean, boolean, E3.g):java.lang.Object");
    }

    public static final void commonCopy(AbstractC0180x abstractC0180x, V source, V target) {
        Long lValueOf;
        Throwable th;
        Long lValueOf2;
        E.f(abstractC0180x, "<this>");
        E.f(source, "source");
        E.f(target, "target");
        h0 h0VarSource = abstractC0180x.source(source);
        Throwable th2 = null;
        try {
            InterfaceC0170m interfaceC0170mBuffer = N.buffer(abstractC0180x.sink(target));
            try {
                lValueOf2 = Long.valueOf(interfaceC0170mBuffer.writeAll(h0VarSource));
                if (interfaceC0170mBuffer != null) {
                    try {
                        interfaceC0170mBuffer.close();
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                th = null;
            } catch (Throwable th4) {
                if (interfaceC0170mBuffer != null) {
                    try {
                        interfaceC0170mBuffer.close();
                    } catch (Throwable th5) {
                        AbstractC1926f.addSuppressed(th4, th5);
                    }
                }
                th = th4;
                lValueOf2 = null;
            }
            if (th != null) {
                throw th;
            }
            E.c(lValueOf2);
            lValueOf = Long.valueOf(lValueOf2.longValue());
            if (h0VarSource != null) {
                try {
                    h0VarSource.close();
                } catch (Throwable th6) {
                    th2 = th6;
                }
            }
            if (th2 != null) {
                throw th2;
            }
            E.c(lValueOf);
        } catch (Throwable th7) {
            if (h0VarSource != null) {
                try {
                    h0VarSource.close();
                } catch (Throwable th8) {
                    AbstractC1926f.addSuppressed(th7, th8);
                }
            }
            th2 = th7;
            lValueOf = null;
        }
    }

    public static final void commonCreateDirectories(AbstractC0180x abstractC0180x, V dir, boolean z6) {
        E.f(abstractC0180x, "<this>");
        E.f(dir, "dir");
        C0144l c0144l = new C0144l();
        for (V vParent = dir; vParent != null && !abstractC0180x.exists(vParent); vParent = vParent.parent()) {
            c0144l.addFirst(vParent);
        }
        if (z6 && c0144l.isEmpty()) {
            throw new IOException(dir + " already exist.");
        }
        Iterator<E> it = c0144l.iterator();
        while (it.hasNext()) {
            abstractC0180x.createDirectory((V) it.next());
        }
    }

    public static final void commonDeleteRecursively(AbstractC0180x abstractC0180x, V fileOrDirectory, boolean z6) {
        E.f(abstractC0180x, "<this>");
        E.f(fileOrDirectory, "fileOrDirectory");
        Iterator<Object> it = W3.t.sequence(new d(abstractC0180x, fileOrDirectory, null)).iterator();
        while (it.hasNext()) {
            abstractC0180x.delete((V) it.next(), z6 && !it.hasNext());
        }
    }

    public static final boolean commonExists(AbstractC0180x abstractC0180x, V path) {
        E.f(abstractC0180x, "<this>");
        E.f(path, "path");
        return abstractC0180x.metadataOrNull(path) != null;
    }

    public static final InterfaceC0233q commonListRecursively(AbstractC0180x abstractC0180x, V dir, boolean z6) {
        E.f(abstractC0180x, "<this>");
        E.f(dir, "dir");
        return W3.t.sequence(new e(dir, abstractC0180x, z6, null));
    }

    public static final C0178v commonMetadata(AbstractC0180x abstractC0180x, V path) throws FileNotFoundException {
        E.f(abstractC0180x, "<this>");
        E.f(path, "path");
        C0178v c0178vMetadataOrNull = abstractC0180x.metadataOrNull(path);
        if (c0178vMetadataOrNull != null) {
            return c0178vMetadataOrNull;
        }
        throw new FileNotFoundException(AbstractC0157z.m("no such file: ", path));
    }

    public static final V symlinkTarget(AbstractC0180x abstractC0180x, V path) {
        E.f(abstractC0180x, "<this>");
        E.f(path, "path");
        V symlinkTarget = abstractC0180x.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        V vParent = path.parent();
        E.c(vParent);
        return vParent.resolve(symlinkTarget);
    }
}
