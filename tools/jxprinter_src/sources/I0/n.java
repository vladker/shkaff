package I0;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class n implements f, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f344a;
    public volatile m b;
    public volatile d c;

    @GuardedBy("requestLock")
    private e fullState;

    @GuardedBy("requestLock")
    private boolean isRunningDuringBegin;

    @Nullable
    private final f parent;

    @GuardedBy("requestLock")
    private e thumbState;

    public n(Object obj, @Nullable f fVar) {
        e eVar = e.CLEARED;
        this.fullState = eVar;
        this.thumbState = eVar;
        this.f344a = obj;
        this.parent = fVar;
    }

    @GuardedBy("requestLock")
    private boolean parentCanNotifyCleared() {
        f fVar = this.parent;
        return fVar == null || fVar.h(this);
    }

    @GuardedBy("requestLock")
    private boolean parentCanNotifyStatusChanged() {
        f fVar = this.parent;
        return fVar == null || fVar.i(this);
    }

    @GuardedBy("requestLock")
    private boolean parentCanSetImage() {
        f fVar = this.parent;
        return fVar == null || fVar.c(this);
    }

    @Override // I0.f, I0.d
    public final boolean a() {
        boolean z6;
        synchronized (this.f344a) {
            try {
                z6 = this.c.a() || this.b.a();
            } catch (Throwable th) {
                throw th;
            }
        }
        return z6;
    }

    @Override // I0.d
    public final boolean b() {
        boolean z6;
        synchronized (this.f344a) {
            z6 = this.fullState == e.CLEARED;
        }
        return z6;
    }

    @Override // I0.f
    public final boolean c(d dVar) {
        boolean z6;
        synchronized (this.f344a) {
            try {
                z6 = parentCanSetImage() && (dVar.equals(this.b) || this.fullState != e.SUCCESS);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z6;
    }

    @Override // I0.d
    public final void clear() {
        synchronized (this.f344a) {
            this.isRunningDuringBegin = false;
            e eVar = e.CLEARED;
            this.fullState = eVar;
            this.thumbState = eVar;
            this.c.clear();
            this.b.clear();
        }
    }

    @Override // I0.f
    public final void d(d dVar) {
        synchronized (this.f344a) {
            try {
                if (dVar.equals(this.c)) {
                    this.thumbState = e.SUCCESS;
                    return;
                }
                this.fullState = e.SUCCESS;
                f fVar = this.parent;
                if (fVar != null) {
                    fVar.d(this);
                }
                if (!this.thumbState.f328a) {
                    this.c.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // I0.d
    public final void e() {
        synchronized (this.f344a) {
            try {
                this.isRunningDuringBegin = true;
                try {
                    if (this.fullState != e.SUCCESS) {
                        e eVar = this.thumbState;
                        e eVar2 = e.RUNNING;
                        if (eVar != eVar2) {
                            this.thumbState = eVar2;
                            this.c.e();
                        }
                    }
                    if (this.isRunningDuringBegin) {
                        e eVar3 = this.fullState;
                        e eVar4 = e.RUNNING;
                        if (eVar3 != eVar4) {
                            this.fullState = eVar4;
                            this.b.e();
                        }
                    }
                    this.isRunningDuringBegin = false;
                } catch (Throwable th) {
                    this.isRunningDuringBegin = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // I0.f
    public final void f(d dVar) {
        synchronized (this.f344a) {
            try {
                if (!dVar.equals(this.b)) {
                    this.thumbState = e.FAILED;
                    return;
                }
                this.fullState = e.FAILED;
                f fVar = this.parent;
                if (fVar != null) {
                    fVar.f(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // I0.d
    public final boolean g() {
        boolean z6;
        synchronized (this.f344a) {
            z6 = this.fullState == e.SUCCESS;
        }
        return z6;
    }

    @Override // I0.f
    public final f getRoot() {
        f root;
        synchronized (this.f344a) {
            try {
                f fVar = this.parent;
                root = fVar != null ? fVar.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // I0.f
    public final boolean h(d dVar) {
        boolean z6;
        synchronized (this.f344a) {
            try {
                z6 = parentCanNotifyCleared() && dVar.equals(this.b) && this.fullState != e.PAUSED;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z6;
    }

    @Override // I0.f
    public final boolean i(d dVar) {
        boolean z6;
        synchronized (this.f344a) {
            try {
                z6 = parentCanNotifyStatusChanged() && dVar.equals(this.b) && !a();
            } catch (Throwable th) {
                throw th;
            }
        }
        return z6;
    }

    @Override // I0.d
    public final boolean isRunning() {
        boolean z6;
        synchronized (this.f344a) {
            z6 = this.fullState == e.RUNNING;
        }
        return z6;
    }

    @Override // I0.d
    public final boolean j(d dVar) {
        if (!(dVar instanceof n)) {
            return false;
        }
        n nVar = (n) dVar;
        if (this.b == null) {
            if (nVar.b != null) {
                return false;
            }
        } else if (!this.b.j(nVar.b)) {
            return false;
        }
        if (this.c == null) {
            return nVar.c == null;
        }
        return this.c.j(nVar.c);
    }

    @Override // I0.d
    public final void pause() {
        synchronized (this.f344a) {
            try {
                if (!this.thumbState.f328a) {
                    this.thumbState = e.PAUSED;
                    this.c.pause();
                }
                if (!this.fullState.f328a) {
                    this.fullState = e.PAUSED;
                    this.b.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
