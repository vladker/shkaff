package kotlinx.coroutines.flow.internal;

import p018c4.D0;
import p023d4.InterfaceC0615p;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J implements InterfaceC0615p {
    private final D0 channel;

    public J(D0 d1) {
        this.channel = d1;
    }

    @Override // p023d4.InterfaceC0615p
    public Object emit(Object obj, E3.g<? super Q> gVar) {
        Object objSend = this.channel.send(obj, gVar);
        return objSend == F3.i.getCOROUTINE_SUSPENDED() ? objSend : Q.INSTANCE;
    }
}
