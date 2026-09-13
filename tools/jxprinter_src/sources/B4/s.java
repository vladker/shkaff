package B4;

import A4.InterfaceC0171n;
import java.io.IOException;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.T;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class s extends F implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0171n f117a;
    public final /* synthetic */ T b;
    public final /* synthetic */ T c;
    public final /* synthetic */ T d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(InterfaceC0171n interfaceC0171n, T t6, T t7, T t8) {
        super(2);
        this.f117a = interfaceC0171n;
        this.b = t6;
        this.c = t7;
        this.d = t8;
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) throws IOException {
        int iIntValue = ((Number) obj).intValue();
        long jLongValue = ((Number) obj2).longValue();
        if (iIntValue == 21589) {
            if (jLongValue < 1) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            InterfaceC0171n interfaceC0171n = this.f117a;
            byte b = interfaceC0171n.readByte();
            boolean z6 = (b & 1) == 1;
            boolean z7 = (b & 2) == 2;
            boolean z8 = (b & 4) == 4;
            long j6 = z6 ? 5L : 1L;
            if (z7) {
                j6 += 4;
            }
            if (z8) {
                j6 += 4;
            }
            if (jLongValue < j6) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            if (z6) {
                this.b.f5689a = Long.valueOf(((long) interfaceC0171n.readIntLe()) * 1000);
            }
            if (z7) {
                this.c.f5689a = Long.valueOf(((long) interfaceC0171n.readIntLe()) * 1000);
            }
            if (z8) {
                this.d.f5689a = Long.valueOf(((long) interfaceC0171n.readIntLe()) * 1000);
            }
        }
        return Q.INSTANCE;
    }
}
