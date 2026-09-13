package p039g3;

import p027e3.q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f3994a;

    public g(Class cls) {
        this.f3994a = cls;
    }

    @Override // p027e3.q
    public boolean test(Object obj) {
        return this.f3994a.isInstance(obj);
    }
}
