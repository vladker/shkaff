package p072m4;

import V3.c;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: m4.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1243c implements r {
    public final c kClass;
    private final r original;
    private final String serialName;

    public C1243c(r original, c kClass) {
        E.f(original, "original");
        E.f(kClass, "kClass");
        this.original = original;
        this.kClass = kClass;
        this.serialName = original.getSerialName() + '<' + kClass.getSimpleName() + '>';
    }

    @Override // p072m4.r
    public final boolean a() {
        return this.original.a();
    }

    @Override // p072m4.r
    public final int b() {
        return this.original.b();
    }

    public boolean equals(Object obj) {
        C1243c c1243c = obj instanceof C1243c ? (C1243c) obj : null;
        return c1243c != null && E.a(this.original, c1243c.original) && E.a(c1243c.kClass, this.kClass);
    }

    @Override // p072m4.r
    public List<Annotation> getAnnotations() {
        return this.original.getAnnotations();
    }

    @Override // p072m4.r
    public List<Annotation> getElementAnnotations(int i5) {
        return this.original.getElementAnnotations(i5);
    }

    @Override // p072m4.r
    public r getElementDescriptor(int i5) {
        return this.original.getElementDescriptor(i5);
    }

    @Override // p072m4.r
    public int getElementIndex(String name) {
        E.f(name, "name");
        return this.original.getElementIndex(name);
    }

    @Override // p072m4.r
    public String getElementName(int i5) {
        return this.original.getElementName(i5);
    }

    @Override // p072m4.r
    public z getKind() {
        return this.original.getKind();
    }

    @Override // p072m4.r
    public String getSerialName() {
        return this.serialName;
    }

    public final int hashCode() {
        return getSerialName().hashCode() + (this.kClass.hashCode() * 31);
    }

    @Override // p072m4.r
    public boolean isElementOptional(int i5) {
        return this.original.isElementOptional(i5);
    }

    @Override // p072m4.r
    public final boolean isInline() {
        return this.original.isInline();
    }

    public String toString() {
        return "ContextDescriptor(kClass: " + this.kClass + ", original: " + this.original + ')';
    }
}
