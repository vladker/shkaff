package p084o4;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.E;
import p072m4.p;
import p072m4.q;
import p072m4.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M0 implements r {
    private final p kind;
    private final String serialName;

    public M0(String serialName, p kind) {
        E.f(serialName, "serialName");
        E.f(kind, "kind");
        this.serialName = serialName;
        this.kind = kind;
    }

    @Override // p072m4.r
    public final boolean a() {
        return q.isNullable(this);
    }

    @Override // p072m4.r
    public final int b() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof M0)) {
            return false;
        }
        M0 m6 = (M0) obj;
        return E.a(getSerialName(), m6.getSerialName()) && E.a(getKind(), m6.getKind());
    }

    @Override // p072m4.r
    public List<Annotation> getAnnotations() {
        return q.getAnnotations(this);
    }

    @Override // p072m4.r
    public List<Annotation> getElementAnnotations(int i5) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // p072m4.r
    public r getElementDescriptor(int i5) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // p072m4.r
    public int getElementIndex(String name) {
        E.f(name, "name");
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // p072m4.r
    public String getElementName(int i5) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // p072m4.r
    public String getSerialName() {
        return this.serialName;
    }

    public final int hashCode() {
        return (getKind().hashCode() * 31) + getSerialName().hashCode();
    }

    @Override // p072m4.r
    public final boolean isElementOptional(int i5) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // p072m4.r
    public final boolean isInline() {
        return q.isInline(this);
    }

    public String toString() {
        return "PrimitiveDescriptor(" + getSerialName() + ')';
    }

    @Override // p072m4.r
    public p getKind() {
        return this.kind;
    }
}
