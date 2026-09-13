package p039g3;

import p027e3.c;
import p027e3.o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f3989a;

    public b(c cVar) {
        this.f3989a = cVar;
    }

    @Override // p027e3.o
    public Object apply(Object[] objArr) {
        if (objArr.length == 2) {
            return this.f3989a.apply(objArr[0], objArr[1]);
        }
        throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
    }
}
