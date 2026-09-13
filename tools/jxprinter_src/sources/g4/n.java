package g4;

import E3.q;
import p007a4.F;
import p028e4.AbstractC0659m;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends F {
    public static final n INSTANCE = new n();

    @Override // p007a4.F
    /* JADX INFO: renamed from: dispatch */
    public void mo1035dispatch(q qVar, Runnable runnable) {
        f.INSTANCE.dispatchWithContext$kotlinx_coroutines_core(runnable, true, false);
    }

    @Override // p007a4.F
    public void dispatchYield(q qVar, Runnable runnable) {
        f.INSTANCE.dispatchWithContext$kotlinx_coroutines_core(runnable, true, true);
    }

    @Override // p007a4.F
    public F limitedParallelism(int i5, String str) {
        AbstractC0659m.a(i5);
        return i5 >= m.MAX_POOL_SIZE ? AbstractC0659m.namedOrThis(this, str) : super.limitedParallelism(i5, str);
    }

    @Override // p007a4.F
    public String toString() {
        return "Dispatchers.IO";
    }
}
