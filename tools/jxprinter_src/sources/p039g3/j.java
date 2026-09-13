package p039g3;

import p027e3.q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3996a;

    public j(Object obj) {
        this.f3996a = obj;
    }

    @Override // p027e3.q
    public boolean test(Object obj) {
        return A.a(obj, this.f3996a);
    }
}
