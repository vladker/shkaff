package p089p4;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.E;
import p066l4.a;
import p072m4.r;
import p072m4.z;

/* JADX INFO: renamed from: p4.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1522g implements r {
    public static final C1522g INSTANCE = new C1522g();
    private static final String serialName = "kotlinx.serialization.json.JsonArray";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f7757a = a.ListSerializer(o.INSTANCE).getDescriptor();

    @Override // p072m4.r
    public final boolean a() {
        return this.f7757a.a();
    }

    @Override // p072m4.r
    public final int b() {
        return this.f7757a.b();
    }

    @Override // p072m4.r
    public List<Annotation> getAnnotations() {
        return this.f7757a.getAnnotations();
    }

    @Override // p072m4.r
    public List<Annotation> getElementAnnotations(int i5) {
        return this.f7757a.getElementAnnotations(i5);
    }

    @Override // p072m4.r
    public r getElementDescriptor(int i5) {
        return this.f7757a.getElementDescriptor(i5);
    }

    @Override // p072m4.r
    public int getElementIndex(String name) {
        E.f(name, "name");
        return this.f7757a.getElementIndex(name);
    }

    @Override // p072m4.r
    public String getElementName(int i5) {
        return this.f7757a.getElementName(i5);
    }

    @Override // p072m4.r
    public z getKind() {
        return this.f7757a.getKind();
    }

    @Override // p072m4.r
    public String getSerialName() {
        return serialName;
    }

    @Override // p072m4.r
    public boolean isElementOptional(int i5) {
        return this.f7757a.isElementOptional(i5);
    }

    @Override // p072m4.r
    public final boolean isInline() {
        return this.f7757a.isInline();
    }

    public static /* synthetic */ void getSerialName$annotations() {
    }
}
