package p089p4;

import O3.a;
import java.util.List;
import kotlin.jvm.internal.E;
import p072m4.q;
import p072m4.r;
import p072m4.z;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class p implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1934n f7767a;

    public p(a aVar) {
        this.f7767a = AbstractC1935o.lazy(aVar);
    }

    @Override // p072m4.r
    public final boolean a() {
        return q.isNullable(this);
    }

    @Override // p072m4.r
    public final int b() {
        return c().b();
    }

    public final r c() {
        return (r) this.f7767a.getValue();
    }

    @Override // p072m4.r
    public final List getAnnotations() {
        return q.getAnnotations(this);
    }

    @Override // p072m4.r
    public final List getElementAnnotations(int i5) {
        return c().getElementAnnotations(i5);
    }

    @Override // p072m4.r
    public final r getElementDescriptor(int i5) {
        return c().getElementDescriptor(i5);
    }

    @Override // p072m4.r
    public final int getElementIndex(String name) {
        E.f(name, "name");
        return c().getElementIndex(name);
    }

    @Override // p072m4.r
    public final String getElementName(int i5) {
        return c().getElementName(i5);
    }

    @Override // p072m4.r
    public final z getKind() {
        return c().getKind();
    }

    @Override // p072m4.r
    public final String getSerialName() {
        return c().getSerialName();
    }

    @Override // p072m4.r
    public final boolean isElementOptional(int i5) {
        return c().isElementOptional(i5);
    }

    @Override // p072m4.r
    public final boolean isInline() {
        return q.isInline(this);
    }
}
