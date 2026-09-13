package retrofit2;

import A4.AbstractC0182z;
import A4.C0169l;
import A4.InterfaceC0171n;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class K extends AbstractC0182z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ L f8100a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(L l6, InterfaceC0171n interfaceC0171n) {
        super(interfaceC0171n);
        this.f8100a = l6;
    }

    @Override // A4.AbstractC0182z, A4.h0
    public long read(C0169l c0169l, long j6) throws IOException {
        try {
            return super.read(c0169l, j6);
        } catch (IOException e) {
            this.f8100a.thrownException = e;
            throw e;
        }
    }
}
