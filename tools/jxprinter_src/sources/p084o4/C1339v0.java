package p084o4;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.E;
import p072m4.D;
import p072m4.q;
import p072m4.r;
import p072m4.z;

/* JADX INFO: renamed from: o4.v0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1339v0 implements r {
    public static final C1339v0 INSTANCE = new C1339v0();
    private static final z kind = D.INSTANCE;
    private static final String serialName = "kotlin.Nothing";

    @Override // p072m4.r
    public final boolean a() {
        return q.isNullable(this);
    }

    @Override // p072m4.r
    public final int b() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // p072m4.r
    public List<Annotation> getAnnotations() {
        return q.getAnnotations(this);
    }

    @Override // p072m4.r
    public List<Annotation> getElementAnnotations(int i5) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // p072m4.r
    public r getElementDescriptor(int i5) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // p072m4.r
    public int getElementIndex(String name) {
        E.f(name, "name");
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // p072m4.r
    public String getElementName(int i5) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // p072m4.r
    public z getKind() {
        return kind;
    }

    @Override // p072m4.r
    public String getSerialName() {
        return serialName;
    }

    public final int hashCode() {
        return (getKind().hashCode() * 31) + getSerialName().hashCode();
    }

    @Override // p072m4.r
    public final boolean isElementOptional(int i5) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // p072m4.r
    public final boolean isInline() {
        return q.isInline(this);
    }

    public String toString() {
        return "NothingSerialDescriptor";
    }
}
