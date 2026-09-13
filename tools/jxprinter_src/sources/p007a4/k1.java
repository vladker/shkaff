package p007a4;

import E3.q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class k1 extends AbstractC0260a {
    public k1(q qVar, boolean z6) {
        super(qVar, true, z6);
    }

    @Override // p007a4.X0
    public boolean handleJobException(Throwable th) {
        J.handleCoroutineException(getContext(), th);
        return true;
    }
}
