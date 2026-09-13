package A4;

import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: renamed from: A4.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C0178v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f83a;
    public final boolean b;
    private final Long createdAtMillis;
    private final Map<V3.c, Object> extras;
    private final Long lastAccessedAtMillis;
    private final Long lastModifiedAtMillis;
    private final Long size;
    private final V symlinkTarget;

    public C0178v(boolean z6, boolean z7, V v6, Long l6, Long l7, Long l8, Long l9, Map<V3.c, ? extends Object> extras) {
        kotlin.jvm.internal.E.f(extras, "extras");
        this.f83a = z6;
        this.b = z7;
        this.symlinkTarget = v6;
        this.size = l6;
        this.createdAtMillis = l7;
        this.lastModifiedAtMillis = l8;
        this.lastAccessedAtMillis = l9;
        this.extras = A3.k0.toMap(extras);
    }

    public final C0178v copy(boolean z6, boolean z7, V v6, Long l6, Long l7, Long l8, Long l9, Map<V3.c, ? extends Object> extras) {
        kotlin.jvm.internal.E.f(extras, "extras");
        return new C0178v(z6, z7, v6, l6, l7, l8, l9, extras);
    }

    public final <T> T extra(V3.c type) {
        kotlin.jvm.internal.E.f(type, "type");
        Object obj = this.extras.get(type);
        if (obj == null) {
            return null;
        }
        return (T) V3.d.cast(type, obj);
    }

    public final Long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    public final Map<V3.c, Object> getExtras() {
        return this.extras;
    }

    public final Long getLastAccessedAtMillis() {
        return this.lastAccessedAtMillis;
    }

    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    public final Long getSize() {
        return this.size;
    }

    public final V getSymlinkTarget() {
        return this.symlinkTarget;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f83a) {
            arrayList.add("isRegularFile");
        }
        if (this.b) {
            arrayList.add("isDirectory");
        }
        if (this.size != null) {
            arrayList.add("byteCount=" + this.size);
        }
        if (this.createdAtMillis != null) {
            arrayList.add("createdAt=" + this.createdAtMillis);
        }
        if (this.lastModifiedAtMillis != null) {
            arrayList.add("lastModifiedAt=" + this.lastModifiedAtMillis);
        }
        if (this.lastAccessedAtMillis != null) {
            arrayList.add("lastAccessedAt=" + this.lastAccessedAtMillis);
        }
        if (!this.extras.isEmpty()) {
            arrayList.add("extras=" + this.extras);
        }
        return A3.T.g(arrayList, ", ", "FileMetadata(", ")", null, 56);
    }

    public /* synthetic */ C0178v(boolean z6, boolean z7, V v6, Long l6, Long l7, Long l8, Long l9) {
        this(z6, z7, v6, l6, l7, l8, l9, A3.k0.emptyMap());
    }
}
