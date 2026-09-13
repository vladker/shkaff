package W3;

import java.util.Iterator;
import p147z3.InterfaceC1927g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class w extends G3.l implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f820a = 0;
    public Iterator b;
    public Object c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0233q f821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ InterfaceC1927g f823h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(InterfaceC0233q interfaceC0233q, O3.p pVar, O3.l lVar, E3.g gVar) {
        super(2, gVar);
        this.f821f = interfaceC0233q;
        this.f822g = pVar;
        this.f823h = lVar;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        switch (this.f820a) {
            case 0:
                w wVar = new w(this.f821f, (O3.p) this.f822g, (O3.l) this.f823h, gVar);
                wVar.c = obj;
                return wVar;
            default:
                w wVar2 = new w(this.f821f, (O3.q) this.f823h, gVar);
                wVar2.f822g = obj;
                return wVar2;
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        AbstractC0234s abstractC0234s = (AbstractC0234s) obj;
        E3.g gVar = (E3.g) obj2;
        switch (this.f820a) {
            case 0:
                break;
        }
        return ((w) create(abstractC0234s, gVar)).invokeSuspend(p147z3.Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        AbstractC0234s abstractC0234s;
        int i5;
        Iterator<Object> it;
        AbstractC0234s abstractC0234s2;
        Iterator<Object> it2;
        Object next;
        switch (this.f820a) {
            case 0:
                Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
                int i6 = this.e;
                if (i6 == 0) {
                    p147z3.v.throwOnFailure(obj);
                    abstractC0234s = (AbstractC0234s) this.c;
                    i5 = 0;
                    it = this.f821f.iterator();
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i7 = this.d;
                    it = this.b;
                    abstractC0234s = (AbstractC0234s) this.c;
                    p147z3.v.throwOnFailure(obj);
                    i5 = i7;
                }
                while (it.hasNext()) {
                    Object next2 = it.next();
                    O3.p pVar = (O3.p) this.f822g;
                    int i8 = i5 + 1;
                    if (i5 < 0) {
                        A3.I.throwIndexOverflow();
                    }
                    Iterator<Object> it3 = (Iterator) ((O3.l) this.f823h).invoke(pVar.invoke(G3.b.boxInt(i5), next2));
                    this.c = abstractC0234s;
                    this.b = it;
                    this.d = i8;
                    this.e = 1;
                    if (abstractC0234s.yieldAll(it3, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i5 = i8;
                }
                return p147z3.Q.INSTANCE;
            default:
                Object coroutine_suspended2 = F3.i.getCOROUTINE_SUSPENDED();
                int i9 = this.e;
                int i10 = 1;
                if (i9 == 0) {
                    p147z3.v.throwOnFailure(obj);
                    abstractC0234s2 = (AbstractC0234s) this.f822g;
                    it2 = this.f821f.iterator();
                    if (it2.hasNext()) {
                        next = it2.next();
                        this.f822g = abstractC0234s2;
                        this.b = it2;
                        this.c = next;
                        this.e = 1;
                        if (abstractC0234s2.yield(next, this) == coroutine_suspended2) {
                            return coroutine_suspended2;
                        }
                    }
                    return p147z3.Q.INSTANCE;
                }
                if (i9 == 1) {
                    next = this.c;
                    it2 = this.b;
                    abstractC0234s2 = (AbstractC0234s) this.f822g;
                    p147z3.v.throwOnFailure(obj);
                } else {
                    if (i9 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i11 = this.d;
                    Object obj2 = this.c;
                    it2 = this.b;
                    abstractC0234s2 = (AbstractC0234s) this.f822g;
                    p147z3.v.throwOnFailure(obj);
                    i10 = i11;
                    next = obj2;
                }
                while (it2.hasNext()) {
                    O3.q qVar = (O3.q) this.f823h;
                    int i12 = i10 + 1;
                    if (i10 < 0) {
                        A3.I.throwIndexOverflow();
                    }
                    Object objInvoke = qVar.invoke(G3.b.boxInt(i10), next, it2.next());
                    this.f822g = abstractC0234s2;
                    this.b = it2;
                    this.c = objInvoke;
                    this.d = i12;
                    this.e = 2;
                    if (abstractC0234s2.yield(objInvoke, this) == coroutine_suspended2) {
                        return coroutine_suspended2;
                    }
                    next = objInvoke;
                    i10 = i12;
                }
                return p147z3.Q.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(InterfaceC0233q interfaceC0233q, O3.q qVar, E3.g gVar) {
        super(2, gVar);
        this.f821f = interfaceC0233q;
        this.f823h = qVar;
    }
}
