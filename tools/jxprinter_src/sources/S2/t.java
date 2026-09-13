package S2;

import java.io.BufferedInputStream;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.T;
import kotlinx.coroutines.flow.internal.E;
import p007a4.M;
import p018c4.B;
import p018c4.B0;
import p018c4.D;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class t extends G3.m implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f656a = 1;
    public final /* synthetic */ T b;
    public /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(T t6, B0 b1, E3.g gVar) {
        super(2, gVar);
        this.b = t6;
        this.d = b1;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        switch (this.f656a) {
            case 0:
                return new t(this.b, (byte[]) this.d, (T) this.c, gVar);
            default:
                t tVar = new t(this.b, (B0) this.d, gVar);
                tVar.c = obj;
                return tVar;
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f656a) {
            case 0:
                return ((t) create((M) obj, (E3.g) obj2)).invokeSuspend(Q.INSTANCE);
            default:
                return ((t) create(B.b(((B) obj).c()), (E3.g) obj2)).invokeSuspend(Q.INSTANCE);
        }
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i5 = this.f656a;
        F3.i.getCOROUTINE_SUSPENDED();
        switch (i5) {
            case 0:
                p147z3.v.throwOnFailure(obj);
                try {
                    return G3.b.boxInt(((BufferedInputStream) this.b.f5689a).read((byte[]) this.d));
                } catch (Exception e) {
                    ((T) this.c).f5689a = e;
                    return null;
                }
            default:
                p147z3.v.throwOnFailure(obj);
                Object objC = ((B) this.c).c();
                boolean z6 = objC instanceof D;
                T t6 = this.b;
                if (!z6) {
                    t6.f5689a = objC;
                }
                B0 b1 = (B0) this.d;
                if (z6) {
                    Throwable thM1003exceptionOrNullimpl = B.m1003exceptionOrNullimpl(objC);
                    if (thM1003exceptionOrNullimpl != null) {
                        throw thM1003exceptionOrNullimpl;
                    }
                    b1.cancel((CancellationException) new kotlinx.coroutines.flow.internal.q());
                    t6.f5689a = E.DONE;
                }
                return Q.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(T t6, byte[] bArr, T t7, E3.g gVar) {
        super(2, gVar);
        this.b = t6;
        this.d = bArr;
        this.c = t7;
    }
}
