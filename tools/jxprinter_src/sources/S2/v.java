package S2;

import kotlin.jvm.internal.T;
import p007a4.AbstractC0272e;
import p007a4.M;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends G3.m implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f659a;
    public Object b;
    public A c;
    public long d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ A f660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f661g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ O3.l f662h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(A a6, long j6, O3.l lVar, E3.g gVar) {
        super(2, gVar);
        this.f660f = a6;
        this.f661g = j6;
        this.f662h = lVar;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        return new v(this.f660f, this.f661g, this.f662h, gVar);
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        return ((v) create((M) obj, (E3.g) obj2)).invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00bd A[Catch: all -> 0x002d, PHI: r1 r4 r6 r9
  0x00bd: PHI (r1v8 i4.b) = (r1v7 i4.b), (r1v15 i4.b) binds: [B:30:0x00ba, B:15:0x0038] A[DONT_GENERATE, DONT_INLINE]
  0x00bd: PHI (r4v1 long) = (r4v0 long), (r4v3 long) binds: [B:30:0x00ba, B:15:0x0038] A[DONT_GENERATE, DONT_INLINE]
  0x00bd: PHI (r6v1 S2.A) = (r6v0 S2.A), (r6v4 S2.A) binds: [B:30:0x00ba, B:15:0x0038] A[DONT_GENERATE, DONT_INLINE]
  0x00bd: PHI (r9v4 kotlin.jvm.internal.T) = (r9v3 kotlin.jvm.internal.T), (r9v7 kotlin.jvm.internal.T) binds: [B:30:0x00ba, B:15:0x0038] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {all -> 0x002d, blocks: (B:9:0x0027, B:36:0x00d4, B:38:0x00d8, B:39:0x00e8, B:41:0x00ec, B:42:0x0103, B:44:0x010a, B:45:0x0125, B:32:0x00bd), top: B:50:0x0013 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d8 A[Catch: all -> 0x002d, TryCatch #0 {all -> 0x002d, blocks: (B:9:0x0027, B:36:0x00d4, B:38:0x00d8, B:39:0x00e8, B:41:0x00ec, B:42:0x0103, B:44:0x010a, B:45:0x0125, B:32:0x00bd), top: B:50:0x0013 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00e8 A[Catch: all -> 0x002d, TryCatch #0 {all -> 0x002d, blocks: (B:9:0x0027, B:36:0x00d4, B:38:0x00d8, B:39:0x00e8, B:41:0x00ec, B:42:0x0103, B:44:0x010a, B:45:0x0125, B:32:0x00bd), top: B:50:0x0013 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00ec A[Catch: all -> 0x002d, TryCatch #0 {all -> 0x002d, blocks: (B:9:0x0027, B:36:0x00d4, B:38:0x00d8, B:39:0x00e8, B:41:0x00ec, B:42:0x0103, B:44:0x010a, B:45:0x0125, B:32:0x00bd), top: B:50:0x0013 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0103 A[Catch: all -> 0x002d, TryCatch #0 {all -> 0x002d, blocks: (B:9:0x0027, B:36:0x00d4, B:38:0x00d8, B:39:0x00e8, B:41:0x00ec, B:42:0x0103, B:44:0x010a, B:45:0x0125, B:32:0x00bd), top: B:50:0x0013 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x010a A[Catch: all -> 0x002d, TryCatch #0 {all -> 0x002d, blocks: (B:9:0x0027, B:36:0x00d4, B:38:0x00d8, B:39:0x00e8, B:41:0x00ec, B:42:0x0103, B:44:0x010a, B:45:0x0125, B:32:0x00bd), top: B:50:0x0013 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0125 A[Catch: all -> 0x002d, TRY_LEAVE, TryCatch #0 {all -> 0x002d, blocks: (B:9:0x0027, B:36:0x00d4, B:38:0x00d8, B:39:0x00e8, B:41:0x00ec, B:42:0x0103, B:44:0x010a, B:45:0x0125, B:32:0x00bd), top: B:50:0x0013 }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        T t6;
        Object request;
        T t7;
        U2.f fVar;
        p049i4.b bVar;
        Object request2;
        A a6;
        T t8;
        U2.f fVar2;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        ?? r6 = this.e;
        O3.l lVar = this.f662h;
        long j6 = this.f661g;
        A a7 = this.f660f;
        try {
            if (r6 == 0) {
                p147z3.v.throwOnFailure(obj);
                t6 = new T();
                U2.e eVar = a7.activeRequests;
                this.f659a = t6;
                this.e = 1;
                request = eVar.getRequest(j6, this);
                if (request != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (r6 == 1) {
                t6 = this.f659a;
                p147z3.v.throwOnFailure(obj);
                request = obj;
            } else {
                if (r6 == 2) {
                    fVar = (U2.f) this.b;
                    t7 = this.f659a;
                    p147z3.v.throwOnFailure(obj);
                    T2.a.tryUnlock(fVar.getNextChunkLock());
                    p049i4.b chunkResultLock = fVar.getChunkResultLock();
                    this.f659a = t7;
                    this.b = chunkResultLock;
                    this.c = a7;
                    this.d = j6;
                    this.e = 3;
                    bVar = (p049i4.g) chunkResultLock;
                    if (bVar.lock(null, this) != coroutine_suspended) {
                        U2.e eVar2 = a7.activeRequests;
                        this.f659a = t7;
                        this.b = bVar;
                        this.c = a7;
                        this.d = j6;
                        this.e = 4;
                        request2 = eVar2.getRequest(j6, this);
                        if (request2 != coroutine_suspended) {
                            a6 = a7;
                            t8 = t7;
                        }
                    }
                    return coroutine_suspended;
                }
                if (r6 == 3) {
                    j6 = this.d;
                    a7 = this.c;
                    bVar = (p049i4.b) this.b;
                    t7 = this.f659a;
                    p147z3.v.throwOnFailure(obj);
                    U2.e eVar3 = a7.activeRequests;
                    this.f659a = t7;
                    this.b = bVar;
                    this.c = a7;
                    this.d = j6;
                    this.e = 4;
                    request2 = eVar3.getRequest(j6, this);
                    if (request2 != coroutine_suspended) {
                        a6 = a7;
                        t8 = t7;
                    }
                    return coroutine_suspended;
                }
                if (r6 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j6 = this.d;
                a6 = this.c;
                bVar = (p049i4.b) this.b;
                t8 = this.f659a;
                p147z3.v.throwOnFailure(obj);
                request2 = obj;
            }
            fVar2 = (U2.f) request2;
            if (fVar2 == null) {
                t8.f5689a = p147z3.u.m1361constructorimpl(p147z3.v.createFailure(new Exception("Request not found")));
            } else if (fVar2.b) {
                t8.f5689a = p147z3.u.m1361constructorimpl(new c(null, true, null));
                a6.getClass();
                AbstractC0272e.b(a6, null, 3, new m(a6, j6, null));
            } else if (fVar2.getError() != null) {
                t8.f5689a = p147z3.u.m1361constructorimpl(new c(null, false, fVar2.getError()));
                a6.getClass();
                AbstractC0272e.b(a6, null, 3, new m(a6, j6, null));
            } else {
                t8.f5689a = p147z3.u.m1361constructorimpl(new c(a6.activeRequests.removeReadChunk(j6), false, null));
            }
            ((p049i4.g) bVar).unlock(null);
            lVar.invoke(p147z3.u.a(t8.f5689a));
            return Q.INSTANCE;
            U2.f fVar3 = (U2.f) request;
            if (fVar3 == null) {
                lVar.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(new Exception("Request not found")))));
                return Q.INSTANCE;
            }
            p049i4.b chunkResultLock2 = fVar3.getChunkResultLock();
            this.f659a = t6;
            this.b = fVar3;
            this.e = 2;
            if (((p049i4.g) chunkResultLock2).lock(null, this) != coroutine_suspended) {
                t7 = t6;
                fVar = fVar3;
                T2.a.tryUnlock(fVar.getNextChunkLock());
                p049i4.b chunkResultLock3 = fVar.getChunkResultLock();
                this.f659a = t7;
                this.b = chunkResultLock3;
                this.c = a7;
                this.d = j6;
                this.e = 3;
                bVar = (p049i4.g) chunkResultLock3;
                if (bVar.lock(null, this) != coroutine_suspended) {
                    U2.e eVar4 = a7.activeRequests;
                    this.f659a = t7;
                    this.b = bVar;
                    this.c = a7;
                    this.d = j6;
                    this.e = 4;
                    request2 = eVar4.getRequest(j6, this);
                    if (request2 != coroutine_suspended) {
                        a6 = a7;
                        t8 = t7;
                        fVar2 = (U2.f) request2;
                        if (fVar2 == null) {
                            t8.f5689a = p147z3.u.m1361constructorimpl(p147z3.v.createFailure(new Exception("Request not found")));
                        } else if (fVar2.b) {
                            t8.f5689a = p147z3.u.m1361constructorimpl(new c(null, true, null));
                            a6.getClass();
                            AbstractC0272e.b(a6, null, 3, new m(a6, j6, null));
                        } else if (fVar2.getError() != null) {
                            t8.f5689a = p147z3.u.m1361constructorimpl(new c(null, false, fVar2.getError()));
                            a6.getClass();
                            AbstractC0272e.b(a6, null, 3, new m(a6, j6, null));
                        } else {
                            t8.f5689a = p147z3.u.m1361constructorimpl(new c(a6.activeRequests.removeReadChunk(j6), false, null));
                        }
                        ((p049i4.g) bVar).unlock(null);
                        lVar.invoke(p147z3.u.a(t8.f5689a));
                        return Q.INSTANCE;
                    }
                }
            }
            return coroutine_suspended;
        } catch (Throwable th) {
            ((p049i4.g) r6).unlock(null);
            throw th;
        }
    }
}
