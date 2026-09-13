package p028e4;

import O3.l;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3944a = AtomicReferenceFieldUpdater.newUpdater(r.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile = new u(8, false);

    public final void a() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3944a;
            u uVar = (u) atomicReferenceFieldUpdater.get(this);
            if (uVar.a()) {
                return;
            }
            u next = uVar.next();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, uVar, next) && atomicReferenceFieldUpdater.get(this) == uVar) {
            }
        }
    }

    public final boolean addLast(Object obj) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3944a;
            u uVar = (u) atomicReferenceFieldUpdater.get(this);
            int iAddLast = uVar.addLast(obj);
            if (iAddLast == 0) {
                return true;
            }
            if (iAddLast == 1) {
                u next = uVar.next();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, uVar, next) && atomicReferenceFieldUpdater.get(this) == uVar) {
                }
            } else if (iAddLast == 2) {
                return false;
            }
        }
    }

    public final int b() {
        u uVar = (u) f3944a.get(this);
        uVar.getClass();
        long j6 = u.f3945f.get(uVar);
        return (((int) ((j6 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j6))) & 1073741823;
    }

    public final <R> List<R> map(l lVar) {
        return ((u) f3944a.get(this)).map(lVar);
    }

    public final Object removeFirstOrNull() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3944a;
            u uVar = (u) atomicReferenceFieldUpdater.get(this);
            Object objRemoveFirstOrNull = uVar.removeFirstOrNull();
            if (objRemoveFirstOrNull != u.REMOVE_FROZEN) {
                return objRemoveFirstOrNull;
            }
            u next = uVar.next();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, uVar, next) && atomicReferenceFieldUpdater.get(this) == uVar) {
            }
        }
    }
}
