package X3;

import A3.AbstractC0139g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A extends AbstractC0139g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C f840a;

    public A(C c) {
        this.f840a = c;
    }

    @Override // A3.AbstractC0132b
    public final int b() {
        return C.a(this.f840a).groupCount() + 1;
    }

    @Override // A3.AbstractC0132b, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof String) {
            return super.contains((String) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        String strGroup = C.a(this.f840a).group(i5);
        return strGroup == null ? "" : strGroup;
    }

    @Override // A3.AbstractC0139g, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof String) {
            return super.indexOf((String) obj);
        }
        return -1;
    }

    @Override // A3.AbstractC0139g, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof String) {
            return super.lastIndexOf((String) obj);
        }
        return -1;
    }
}
