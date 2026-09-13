package S2;

import java.io.InputStream;
import java.io.Serializable;
import kotlin.jvm.internal.T;
import p007a4.M;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends G3.m implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f644a;
    public final /* synthetic */ Serializable b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(Serializable serializable, E3.g gVar, int i5) {
        super(2, gVar);
        this.f644a = i5;
        this.b = serializable;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        switch (this.f644a) {
            case 0:
                return new o((T) this.b, gVar, 0);
            default:
                return new o((String) this.b, gVar, 1);
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        M m6 = (M) obj;
        E3.g gVar = (E3.g) obj2;
        switch (this.f644a) {
            case 0:
                break;
        }
        return ((o) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i5 = this.f644a;
        F3.i.getCOROUTINE_SUSPENDED();
        switch (i5) {
            case 0:
                p147z3.v.throwOnFailure(obj);
                InputStream inputStream = (InputStream) ((T) this.b).f5689a;
                if (inputStream == null) {
                    return null;
                }
                inputStream.close();
                return Q.INSTANCE;
            default:
                p147z3.v.throwOnFailure(obj);
                p042h2.d.a((String) this.b);
                return Q.INSTANCE;
        }
    }
}
