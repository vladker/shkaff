package y5;

import io.reactivex.B;
import io.reactivex.EnumC0675b;
import io.reactivex.N;
import java.lang.reflect.Type;
import retrofit2.InterfaceC1613k;
import retrofit2.InterfaceC1615m;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class h implements InterfaceC1615m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f9049a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f9050f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f9051g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f9052h;
    private final N scheduler;

    public h(Type type, N n6, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12) {
        this.f9049a = type;
        this.scheduler = n6;
        this.b = z6;
        this.c = z7;
        this.d = z8;
        this.e = z9;
        this.f9050f = z10;
        this.f9051g = z11;
        this.f9052h = z12;
    }

    @Override // retrofit2.InterfaceC1615m
    public final Type a() {
        return this.f9049a;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002c  */
    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    /* JADX WARN: Code duplicated, block: B:20:0x003b  */
    /* JADX WARN: Code duplicated, block: B:22:0x003f  */
    /* JADX WARN: Code duplicated, block: B:24:0x0044  */
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:28:0x004d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0051  */
    /* JADX WARN: Code duplicated, block: B:32:0x0056 A[RETURN] */
    @Override // retrofit2.InterfaceC1615m
    public final Object c(InterfaceC1613k interfaceC1613k) {
        b bVar;
        N n6;
        B dVar = this.b ? new d(interfaceC1613k, 0) : new d(interfaceC1613k, 1);
        if (!this.c) {
            if (this.d) {
                bVar = new b(dVar, 0);
            }
            n6 = this.scheduler;
            if (n6 != null) {
                dVar = dVar.subscribeOn(n6);
            }
            if (this.e) {
                return dVar.toFlowable(EnumC0675b.f4175a);
            }
            if (this.f9050f) {
                return dVar.singleOrError();
            }
            if (this.f9051g) {
                return dVar.singleElement();
            }
            if (this.f9052h) {
                return dVar.ignoreElements();
            }
            return dVar;
        }
        bVar = new b(dVar, 1);
        dVar = bVar;
        n6 = this.scheduler;
        if (n6 != null) {
            dVar = dVar.subscribeOn(n6);
        }
        if (this.e) {
            return dVar.toFlowable(EnumC0675b.f4175a);
        }
        if (this.f9050f) {
            return dVar.singleOrError();
        }
        if (this.f9051g) {
            return dVar.singleElement();
        }
        if (this.f9052h) {
            return dVar.ignoreElements();
        }
        return dVar;
    }
}
