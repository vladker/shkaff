package p072m4;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f6171a;
    private final String serialName;

    public F(String serialName, r original) {
        E.f(serialName, "serialName");
        E.f(original, "original");
        this.f6171a = original;
        this.serialName = serialName;
    }

    @Override // p072m4.r
    public final boolean a() {
        return this.f6171a.a();
    }

    @Override // p072m4.r
    public final int b() {
        return this.f6171a.b();
    }

    @Override // p072m4.r
    public List<Annotation> getAnnotations() {
        return this.f6171a.getAnnotations();
    }

    @Override // p072m4.r
    public List<Annotation> getElementAnnotations(int i5) {
        return this.f6171a.getElementAnnotations(i5);
    }

    @Override // p072m4.r
    public r getElementDescriptor(int i5) {
        return this.f6171a.getElementDescriptor(i5);
    }

    @Override // p072m4.r
    public int getElementIndex(String name) {
        E.f(name, "name");
        return this.f6171a.getElementIndex(name);
    }

    @Override // p072m4.r
    public String getElementName(int i5) {
        return this.f6171a.getElementName(i5);
    }

    @Override // p072m4.r
    public z getKind() {
        return this.f6171a.getKind();
    }

    @Override // p072m4.r
    public String getSerialName() {
        return this.serialName;
    }

    @Override // p072m4.r
    public boolean isElementOptional(int i5) {
        return this.f6171a.isElementOptional(i5);
    }

    @Override // p072m4.r
    public final boolean isInline() {
        return this.f6171a.isInline();
    }
}
