package U2;

import E3.g;
import O3.l;
import java.util.HashMap;
import p049i4.i;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private final HashMap<Long, f> activeRequests = new HashMap<>();
    private final p049i4.b activeRequestsLock = i.Mutex(false);

    public final boolean a(long j6) {
        return this.activeRequests.containsKey(Long.valueOf(j6));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object deleteRequest(long j6, g<? super f> gVar) throws Throwable {
        a aVar;
        e eVar;
        p049i4.b bVar;
        if (gVar instanceof a) {
            aVar = (a) gVar;
            int i5 = aVar.f714f;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                aVar.f714f = i5 - Integer.MIN_VALUE;
            } else {
                aVar = new a(this, gVar);
            }
        } else {
            aVar = new a(this, gVar);
        }
        Object obj = aVar.d;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = aVar.f714f;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            p049i4.b bVar2 = this.activeRequestsLock;
            aVar.f713a = this;
            aVar.b = bVar2;
            aVar.c = j6;
            aVar.f714f = 1;
            p049i4.g gVar2 = (p049i4.g) bVar2;
            if (gVar2.lock(null, aVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            eVar = this;
            bVar = gVar2;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j6 = aVar.c;
            bVar = aVar.b;
            eVar = aVar.f713a;
            v.throwOnFailure(obj);
        }
        try {
            return eVar.activeRequests.remove(G3.b.boxLong(j6));
        } finally {
            ((p049i4.g) bVar).unlock(null);
        }
    }

    public final p049i4.b getChunkResultLock(long j6) {
        f fVar = this.activeRequests.get(Long.valueOf(j6));
        if (fVar != null) {
            return fVar.getChunkResultLock();
        }
        return null;
    }

    public final p049i4.b getNextChunkLock(long j6) {
        f fVar = this.activeRequests.get(Long.valueOf(j6));
        if (fVar != null) {
            return fVar.getNextChunkLock();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getRequest(long j6, g<? super f> gVar) throws Throwable {
        b bVar;
        e eVar;
        p049i4.b bVar2;
        if (gVar instanceof b) {
            bVar = (b) gVar;
            int i5 = bVar.f716f;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                bVar.f716f = i5 - Integer.MIN_VALUE;
            } else {
                bVar = new b(this, gVar);
            }
        } else {
            bVar = new b(this, gVar);
        }
        Object obj = bVar.d;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = bVar.f716f;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            p049i4.b bVar3 = this.activeRequestsLock;
            bVar.f715a = this;
            bVar.b = bVar3;
            bVar.c = j6;
            bVar.f716f = 1;
            p049i4.g gVar2 = (p049i4.g) bVar3;
            if (gVar2.lock(null, bVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            eVar = this;
            bVar2 = gVar2;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j6 = bVar.c;
            bVar2 = bVar.b;
            eVar = bVar.f715a;
            v.throwOnFailure(obj);
        }
        try {
            return eVar.activeRequests.get(G3.b.boxLong(j6));
        } finally {
            ((p049i4.g) bVar2).unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object registerRequest(long j6, f fVar, g<? super Q> gVar) throws Throwable {
        c cVar;
        p049i4.b bVar;
        e eVar;
        if (gVar instanceof c) {
            cVar = (c) gVar;
            int i5 = cVar.f719g;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                cVar.f719g = i5 - Integer.MIN_VALUE;
            } else {
                cVar = new c(this, gVar);
            }
        } else {
            cVar = new c(this, gVar);
        }
        Object obj = cVar.e;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = cVar.f719g;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            p049i4.b bVar2 = this.activeRequestsLock;
            cVar.f717a = this;
            cVar.b = fVar;
            cVar.c = bVar2;
            cVar.d = j6;
            cVar.f719g = 1;
            bVar = (p049i4.g) bVar2;
            if (bVar.lock(null, cVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            eVar = this;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j6 = cVar.d;
            p049i4.b bVar3 = cVar.c;
            f fVar2 = cVar.b;
            eVar = cVar.f717a;
            v.throwOnFailure(obj);
            bVar = bVar3;
            fVar = fVar2;
        }
        try {
            eVar.activeRequests.put(G3.b.boxLong(j6), fVar);
            return Q.INSTANCE;
        } finally {
            ((p049i4.g) bVar).unlock(null);
        }
    }

    public final byte[] removeReadChunk(long j6) {
        f fVar = this.activeRequests.get(Long.valueOf(j6));
        if (fVar == null) {
            return null;
        }
        byte[] readChunk = fVar.getReadChunk();
        this.activeRequests.put(Long.valueOf(j6), f.a(fVar, null, null, 47));
        return readChunk;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object updateRequest(long j6, l lVar, g<? super Q> gVar) throws Throwable {
        d dVar;
        p049i4.b bVar;
        e eVar;
        if (gVar instanceof d) {
            dVar = (d) gVar;
            int i5 = dVar.f722g;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                dVar.f722g = i5 - Integer.MIN_VALUE;
            } else {
                dVar = new d(this, gVar);
            }
        } else {
            dVar = new d(this, gVar);
        }
        Object obj = dVar.e;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = dVar.f722g;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            p049i4.b bVar2 = this.activeRequestsLock;
            dVar.f720a = this;
            dVar.b = lVar;
            dVar.c = bVar2;
            dVar.d = j6;
            dVar.f722g = 1;
            bVar = (p049i4.g) bVar2;
            if (bVar.lock(null, dVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            eVar = this;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j6 = dVar.d;
            p049i4.b bVar3 = dVar.c;
            l lVar2 = dVar.b;
            eVar = dVar.f720a;
            v.throwOnFailure(obj);
            bVar = bVar3;
            lVar = lVar2;
        }
        try {
            f fVar = eVar.activeRequests.get(G3.b.boxLong(j6));
            if (fVar != null) {
                eVar.activeRequests.put(G3.b.boxLong(j6), (f) lVar.invoke(fVar));
            }
            return Q.INSTANCE;
        } finally {
            ((p049i4.g) bVar).unlock(null);
        }
    }
}
