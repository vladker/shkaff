package okhttp3.internal.http2;

import A4.InterfaceC0171n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class D implements E {
    @Override // okhttp3.internal.http2.E
    public boolean onData(int i5, InterfaceC0171n interfaceC0171n, int i6, boolean z6) {
        interfaceC0171n.skip(i6);
        return true;
    }
}
