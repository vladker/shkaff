package B4;

import A4.InterfaceC0171n;
import io.flutter.embedding.android.KeyboardMap;
import java.io.IOException;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.P;
import kotlin.jvm.internal.S;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class r extends F implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ P f115a;
    public final /* synthetic */ long b;
    public final /* synthetic */ S c;
    public final /* synthetic */ InterfaceC0171n d;
    public final /* synthetic */ S e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ S f116f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(P p6, long j6, S s6, InterfaceC0171n interfaceC0171n, S s7, S s8) {
        super(2);
        this.f115a = p6;
        this.b = j6;
        this.c = s6;
        this.d = interfaceC0171n;
        this.e = s7;
        this.f116f = s8;
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) throws IOException {
        int iIntValue = ((Number) obj).intValue();
        long jLongValue = ((Number) obj2).longValue();
        if (iIntValue == 1) {
            P p6 = this.f115a;
            if (p6.f5686a) {
                throw new IOException("bad zip: zip64 extra repeated");
            }
            p6.f5686a = true;
            if (jLongValue < this.b) {
                throw new IOException("bad zip: zip64 extra too short");
            }
            S s6 = this.c;
            long longLe = s6.f5688a;
            InterfaceC0171n interfaceC0171n = this.d;
            if (longLe == KeyboardMap.kValueMask) {
                longLe = interfaceC0171n.readLongLe();
            }
            s6.f5688a = longLe;
            S s7 = this.e;
            s7.f5688a = s7.f5688a == KeyboardMap.kValueMask ? interfaceC0171n.readLongLe() : 0L;
            S s8 = this.f116f;
            s8.f5688a = s8.f5688a == KeyboardMap.kValueMask ? interfaceC0171n.readLongLe() : 0L;
        }
        return Q.INSTANCE;
    }
}
