package p118u4;

import java.util.List;
import okhttp3.A;
import okhttp3.InterfaceC1353f;
import okhttp3.InterfaceC1364j;
import okhttp3.M;
import okhttp3.T;
import okhttp3.z;
import t4.e;
import t4.o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f8737a;
    public final o b;
    public final int c;
    public final M d;
    public final InterfaceC1353f e;
    private final e exchange;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f8739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f8740h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8741i;

    public f(List<A> list, o oVar, e eVar, int i5, M m6, InterfaceC1353f interfaceC1353f, int i6, int i7, int i8) {
        this.f8737a = list;
        this.b = oVar;
        this.exchange = eVar;
        this.c = i5;
        this.d = m6;
        this.e = interfaceC1353f;
        this.f8738f = i6;
        this.f8739g = i7;
        this.f8740h = i8;
    }

    public final e a() {
        e eVar = this.exchange;
        if (eVar != null) {
            return eVar;
        }
        throw new IllegalStateException();
    }

    @Override // okhttp3.z
    public InterfaceC1364j connection() {
        e eVar = this.exchange;
        if (eVar != null) {
            return eVar.d.connection();
        }
        return null;
    }

    @Override // okhttp3.z
    public T proceed(M m6) {
        return proceed(m6, this.b, this.exchange);
    }

    public T proceed(M m6, o oVar, e eVar) {
        M m7;
        List list = this.f8737a;
        int size = list.size();
        int i5 = this.c;
        if (i5 >= size) {
            throw new AssertionError();
        }
        this.f8741i++;
        e eVar2 = this.exchange;
        if (eVar2 != null) {
            m7 = m6;
            if (!eVar2.d.connection().d(m7.f6539a)) {
                throw new IllegalStateException("network interceptor " + list.get(i5 - 1) + " must retain the same host and port");
            }
        } else {
            m7 = m6;
        }
        if (this.exchange != null && this.f8741i > 1) {
            throw new IllegalStateException("network interceptor " + list.get(i5 - 1) + " must call proceed() exactly once");
        }
        int i6 = i5 + 1;
        f fVar = new f(this.f8737a, oVar, eVar, i6, m7, this.e, this.f8738f, this.f8739g, this.f8740h);
        A a6 = (A) list.get(i5);
        T tIntercept = a6.intercept(fVar);
        if (eVar != null && i6 < list.size() && fVar.f8741i != 1) {
            throw new IllegalStateException("network interceptor " + a6 + " must call proceed() exactly once");
        }
        if (tIntercept == null) {
            throw new NullPointerException("interceptor " + a6 + " returned null");
        }
        if (tIntercept.body() != null) {
            return tIntercept;
        }
        throw new IllegalStateException("interceptor " + a6 + " returned a response with no body");
    }
}
