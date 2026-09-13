package p033f3;

import io.reactivex.internal.schedulers.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import p011b3.c;
import p017c3.d;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements c, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedList f3971a;
    public volatile boolean b;

    @Override // p033f3.c
    public final boolean add(c cVar) {
        if (!this.b) {
            synchronized (this) {
                try {
                    if (!this.b) {
                        LinkedList linkedList = this.f3971a;
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            this.f3971a = linkedList;
                        }
                        linkedList.add(cVar);
                        return true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        cVar.dispose();
        return false;
    }

    @Override // p033f3.c
    public final boolean delete(c cVar) {
        if (this.b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.b) {
                    return false;
                }
                LinkedList linkedList = this.f3971a;
                if (linkedList != null && linkedList.remove(cVar)) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                LinkedList linkedList = this.f3971a;
                ArrayList arrayList = null;
                this.f3971a = null;
                if (linkedList == null) {
                    return;
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    try {
                        ((c) it.next()).dispose();
                    } catch (Throwable th) {
                        d.throwIfFatal(th);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th);
                    }
                }
                if (arrayList != null) {
                    if (arrayList.size() != 1) {
                        throw new p017c3.c(arrayList);
                    }
                    throw g.d((Throwable) arrayList.get(0));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.b;
    }

    @Override // p033f3.c
    public final boolean remove(c cVar) {
        if (!delete(cVar)) {
            return false;
        }
        ((x) cVar).dispose();
        return true;
    }
}
