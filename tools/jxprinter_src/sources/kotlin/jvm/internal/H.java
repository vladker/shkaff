package kotlin.jvm.internal;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H implements r {
    private final Class<?> jClass;
    private final String moduleName;

    public H(Class<?> jClass, String moduleName) {
        E.f(jClass, "jClass");
        E.f(moduleName, "moduleName");
        this.jClass = jClass;
        this.moduleName = moduleName;
    }

    public boolean equals(Object obj) {
        return (obj instanceof H) && E.a(getJClass(), ((H) obj).getJClass());
    }

    @Override // kotlin.jvm.internal.r
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Override // kotlin.jvm.internal.r, V3.f
    public Collection<V3.b> getMembers() {
        throw new N3.b();
    }

    public final int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        return getJClass() + " (Kotlin reflection is not available)";
    }
}
