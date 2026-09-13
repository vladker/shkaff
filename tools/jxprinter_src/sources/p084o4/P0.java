package p084o4;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.E;
import p072m4.r;
import p072m4.z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P0 implements r, InterfaceC1323n {
    private final r original;
    private final String serialName;
    private final Set<String> serialNames;

    public P0(r original) {
        E.f(original, "original");
        this.original = original;
        this.serialName = original.getSerialName() + '?';
        this.serialNames = D0.cachedSerialNames(original);
    }

    @Override // p072m4.r
    public final boolean a() {
        return true;
    }

    @Override // p072m4.r
    public final int b() {
        return this.original.b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof P0) && E.a(this.original, ((P0) obj).original);
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

    public final r getOriginal$kotlinx_serialization_core() {
        return this.original;
    }

    @Override // p072m4.r
    public String getSerialName() {
        return this.serialName;
    }

    @Override // p084o4.InterfaceC1323n
    public Set<String> getSerialNames() {
        return this.serialNames;
    }

    public final int hashCode() {
        return this.original.hashCode() * 31;
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
        StringBuilder sb = new StringBuilder();
        sb.append(this.original);
        sb.append('?');
        return sb.toString();
    }
}
