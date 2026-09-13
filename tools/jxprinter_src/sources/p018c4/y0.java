package p018c4;

import p007a4.B1;
import p007a4.C0289m;
import p028e4.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class y0 implements B1 {
    public final C0289m cont;

    public y0(C0289m c0289m) {
        this.cont = c0289m;
    }

    @Override // p007a4.B1
    public void invokeOnCancellation(E e, int i5) {
        this.cont.invokeOnCancellation(e, i5);
    }
}
