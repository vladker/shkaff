package p007a4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class R0 implements B0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f944a = AtomicIntegerFieldUpdater.newUpdater(R0.class, "_isCompleting$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(R0.class, Object.class, "_rootCause$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(R0.class, Object.class, "_exceptionsHolder$volatile");
    private volatile /* synthetic */ Object _exceptionsHolder$volatile;
    private volatile /* synthetic */ int _isCompleting$volatile;
    private volatile /* synthetic */ Object _rootCause$volatile;
    private final C0268c1 list;

    public R0(C0268c1 c0268c1, boolean z6, Throwable th) {
        this.list = c0268c1;
        this._isCompleting$volatile = z6 ? 1 : 0;
        this._rootCause$volatile = th;
    }

    public final boolean a() {
        return getRootCause() != null;
    }

    public final void addExceptionLocked(Throwable th) {
        Throwable rootCause = getRootCause();
        if (rootCause == null) {
            setRootCause(th);
            return;
        }
        if (th == rootCause) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            atomicReferenceFieldUpdater.set(this, th);
            return;
        }
        if (!(obj instanceof Throwable)) {
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(th);
                return;
            } else {
                throw new IllegalStateException(("State is " + obj).toString());
            }
        }
        if (th == obj) {
            return;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(th);
        atomicReferenceFieldUpdater.set(this, arrayList);
    }

    @Override // p007a4.B0
    public C0268c1 getList() {
        return this.list;
    }

    public final Throwable getRootCause() {
        return (Throwable) b.get(this);
    }

    @Override // p007a4.B0
    public final boolean isActive() {
        return getRootCause() == null;
    }

    public final List<Throwable> sealLocked(Throwable th) {
        ArrayList arrayList;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            arrayList = new ArrayList(4);
        } else if (obj instanceof Throwable) {
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(obj);
            arrayList = arrayList2;
        } else {
            if (!(obj instanceof ArrayList)) {
                throw new IllegalStateException(("State is " + obj).toString());
            }
            arrayList = (ArrayList) obj;
        }
        Throwable rootCause = getRootCause();
        if (rootCause != null) {
            arrayList.add(0, rootCause);
        }
        if (th != null && !th.equals(rootCause)) {
            arrayList.add(th);
        }
        atomicReferenceFieldUpdater.set(this, Y0.SEALED);
        return arrayList;
    }

    public final void setRootCause(Throwable th) {
        b.set(this, th);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Finishing[cancelling=");
        sb.append(a());
        sb.append(", completing=");
        sb.append(f944a.get(this) != 0);
        sb.append(", rootCause=");
        sb.append(getRootCause());
        sb.append(", exceptions=");
        sb.append(c.get(this));
        sb.append(", list=");
        sb.append(getList());
        sb.append(']');
        return sb.toString();
    }
}
