package B4;

import A3.C0144l;
import A4.AbstractC0180x;
import A4.V;
import W3.AbstractC0234s;
import java.util.Iterator;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class e extends G3.l implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0144l f105a;
    public Iterator b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ V e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AbstractC0180x f106f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f107g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(V v6, AbstractC0180x abstractC0180x, boolean z6, E3.g gVar) {
        super(2, gVar);
        this.e = v6;
        this.f106f = abstractC0180x;
        this.f107g = z6;
    }

    @Override // G3.a
    public final E3.g<Q> create(Object obj, E3.g<?> gVar) {
        e eVar = new e(this.e, this.f106f, this.f107g, gVar);
        eVar.d = obj;
        return eVar;
    }

    @Override // O3.p
    public final Object invoke(AbstractC0234s abstractC0234s, E3.g<? super Q> gVar) {
        return ((e) create(abstractC0234s, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        C0144l c0144l;
        Iterator<V> it;
        AbstractC0234s abstractC0234s;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i5 = this.c;
        AbstractC0180x abstractC0180x = this.f106f;
        if (i5 == 0) {
            v.throwOnFailure(obj);
            AbstractC0234s abstractC0234s2 = (AbstractC0234s) this.d;
            C0144l c0144l2 = new C0144l();
            V v6 = this.e;
            c0144l2.addLast(v6);
            c0144l = c0144l2;
            it = abstractC0180x.list(v6).iterator();
            abstractC0234s = abstractC0234s2;
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = this.b;
            C0144l c0144l3 = this.f105a;
            AbstractC0234s abstractC0234s3 = (AbstractC0234s) this.d;
            v.throwOnFailure(obj);
            c0144l = c0144l3;
            abstractC0234s = abstractC0234s3;
        }
        while (it.hasNext()) {
            V next = it.next();
            this.d = abstractC0234s;
            this.f105a = c0144l;
            this.b = it;
            this.c = 1;
            if (f.collectRecursively(abstractC0234s, abstractC0180x, c0144l, next, this.f107g, false, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Q.INSTANCE;
    }
}
