package B4;

import A4.V;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f112a;
    public final long b;
    public final long c;
    private final V canonicalPath;
    private final List<V> children;
    private final String comment;
    public final int d;
    public final long e;
    private final Long lastModifiedAtMillis;

    public /* synthetic */ o(V v6) {
        this(v6, true, "", -1L, -1L, -1L, -1, null, -1L);
    }

    public final V getCanonicalPath() {
        return this.canonicalPath;
    }

    public final List<V> getChildren() {
        return this.children;
    }

    public final String getComment() {
        return this.comment;
    }

    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    public o(V canonicalPath, boolean z6, String comment, long j6, long j7, long j8, int i5, Long l6, long j9) {
        E.f(canonicalPath, "canonicalPath");
        E.f(comment, "comment");
        this.canonicalPath = canonicalPath;
        this.f112a = z6;
        this.comment = comment;
        this.b = j7;
        this.c = j8;
        this.d = i5;
        this.lastModifiedAtMillis = l6;
        this.e = j9;
        this.children = new ArrayList();
    }
}
