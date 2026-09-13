package retrofit2;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class S extends i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f8107a;

    public S(i0 i0Var) {
        this.f8107a = i0Var;
    }

    @Override // retrofit2.i0
    public void apply(o0 o0Var, Object obj) {
        if (obj == null) {
            return;
        }
        int length = Array.getLength(obj);
        for (int i5 = 0; i5 < length; i5++) {
            this.f8107a.apply(o0Var, Array.get(obj, i5));
        }
    }
}
