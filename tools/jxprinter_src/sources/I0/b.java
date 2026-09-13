package I0;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements f, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f325a;
    public volatile d b;
    public volatile d c;

    @GuardedBy("requestLock")
    private e errorState;

    @Nullable
    private final f parent;

    @GuardedBy("requestLock")
    private e primaryState;

    public b(Object obj, @Nullable f fVar) {
        e eVar = e.CLEARED;
        this.primaryState = eVar;
        this.errorState = eVar;
        this.f325a = obj;
        this.parent = fVar;
    }

    @GuardedBy("requestLock")
    private boolean isValidRequestForStatusChanged(d dVar) {
        e eVar = this.primaryState;
        e eVar2 = e.FAILED;
        if (eVar != eVar2) {
            return dVar.equals(this.b);
        }
        if (!dVar.equals(this.c)) {
            return false;
        }
        e eVar3 = this.errorState;
        return eVar3 == e.SUCCESS || eVar3 == eVar2;
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
        synchronized (this.f325a) {
            try {
                z6 = this.b.a() || this.c.a();
            } catch (Throwable th) {
                throw th;
            }
        }
        return z6;
    }

    @Override // I0.d
    public final boolean b() {
        boolean z6;
        synchronized (this.f325a) {
            try {
                e eVar = this.primaryState;
                e eVar2 = e.CLEARED;
                z6 = eVar == eVar2 && this.errorState == eVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z6;
    }

    @Override // I0.f
    public final boolean c(d dVar) {
        boolean zParentCanSetImage;
        synchronized (this.f325a) {
            zParentCanSetImage = parentCanSetImage();
        }
        return zParentCanSetImage;
    }

    @Override // I0.d
    public final void clear() {
        synchronized (this.f325a) {
            try {
                e eVar = e.CLEARED;
                this.primaryState = eVar;
                this.b.clear();
                if (this.errorState != eVar) {
                    this.errorState = eVar;
                    this.c.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // I0.f
    public final void d(d dVar) {
        synchronized (this.f325a) {
            try {
                if (dVar.equals(this.b)) {
                    this.primaryState = e.SUCCESS;
                } else if (dVar.equals(this.c)) {
                    this.errorState = e.SUCCESS;
                }
                f fVar = this.parent;
                if (fVar != null) {
                    fVar.d(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // I0.d
    public final void e() {
        synchronized (this.f325a) {
            try {
                e eVar = this.primaryState;
                e eVar2 = e.RUNNING;
                if (eVar != eVar2) {
                    this.primaryState = eVar2;
                    this.b.e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // I0.f
    public final void f(d dVar) {
        synchronized (this.f325a) {
            try {
                if (dVar.equals(this.c)) {
                    this.errorState = e.FAILED;
                    f fVar = this.parent;
                    if (fVar != null) {
                        fVar.f(this);
                    }
                    return;
                }
                this.primaryState = e.FAILED;
                e eVar = this.errorState;
                e eVar2 = e.RUNNING;
                if (eVar != eVar2) {
                    this.errorState = eVar2;
                    this.c.e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // I0.d
    public final boolean g() {
        boolean z6;
        synchronized (this.f325a) {
            try {
                e eVar = this.primaryState;
                e eVar2 = e.SUCCESS;
                z6 = eVar == eVar2 || this.errorState == eVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z6;
    }

    @Override // I0.f
    public final f getRoot() {
        f root;
        synchronized (this.f325a) {
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
        synchronized (this.f325a) {
            try {
                z6 = parentCanNotifyCleared() && dVar.equals(this.b);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z6;
    }

    @Override // I0.f
    public final boolean i(d dVar) {
        boolean z6;
        synchronized (this.f325a) {
            try {
                z6 = parentCanNotifyStatusChanged() && isValidRequestForStatusChanged(dVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z6;
    }

    @Override // I0.d
    public final boolean isRunning() {
        boolean z6;
        synchronized (this.f325a) {
            try {
                e eVar = this.primaryState;
                e eVar2 = e.RUNNING;
                z6 = eVar == eVar2 || this.errorState == eVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z6;
    }

    @Override // I0.d
    public final boolean j(d dVar) {
        if (dVar instanceof b) {
            b bVar = (b) dVar;
            if (this.b.j(bVar.b) && this.c.j(bVar.c)) {
                return true;
            }
        }
        return false;
    }

    @Override // I0.d
    public final void pause() {
        synchronized (this.f325a) {
            try {
                e eVar = this.primaryState;
                e eVar2 = e.RUNNING;
                if (eVar == eVar2) {
                    this.primaryState = e.PAUSED;
                    this.b.pause();
                }
                if (this.errorState == eVar2) {
                    this.errorState = e.PAUSED;
                    this.c.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
