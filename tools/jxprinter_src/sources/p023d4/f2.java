package p023d4;

import E3.q;
import p018c4.EnumC0368b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f2 {
    public final q context;
    public final int extraBufferCapacity;
    public final EnumC0368b onBufferOverflow;
    public final InterfaceC0612o upstream;

    public f2(InterfaceC0612o interfaceC0612o, int i5, EnumC0368b enumC0368b, q qVar) {
        this.upstream = interfaceC0612o;
        this.extraBufferCapacity = i5;
        this.onBufferOverflow = enumC0368b;
        this.context = qVar;
    }
}
