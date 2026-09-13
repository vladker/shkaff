package p011b3;

import java.util.ArrayList;
import p017c3.d;
import p033f3.c;
import p039g3.A;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements c, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p061l.c f1087a;
    public volatile boolean b;

    public b(c... cVarArr) {
        A.b(cVarArr, "disposables is null");
        this.f1087a = new p061l.c(cVarArr.length + 1, 0);
        for (c cVar : cVarArr) {
            A.b(cVar, "A Disposable in the disposables array is null");
            this.f1087a.a(cVar);
        }
    }

    public static void a(p061l.c cVar) {
        if (cVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : (Object[]) cVar.d) {
            if (obj instanceof c) {
                try {
                    ((c) obj).dispose();
                } catch (Throwable th) {
                    d.throwIfFatal(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new p017c3.c(arrayList);
            }
            throw g.d((Throwable) arrayList.get(0));
        }
    }

    @Override // p033f3.c
    public boolean add(c cVar) {
        A.b(cVar, "disposable is null");
        if (!this.b) {
            synchronized (this) {
                try {
                    if (!this.b) {
                        p061l.c cVar2 = this.f1087a;
                        if (cVar2 == null) {
                            cVar2 = new p061l.c();
                            this.f1087a = cVar2;
                        }
                        cVar2.a(cVar);
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

    public boolean addAll(c... cVarArr) {
        A.b(cVarArr, "disposables is null");
        if (!this.b) {
            synchronized (this) {
                try {
                    if (!this.b) {
                        p061l.c cVar = this.f1087a;
                        if (cVar == null) {
                            cVar = new p061l.c(cVarArr.length + 1, 0);
                            this.f1087a = cVar;
                        }
                        for (c cVar2 : cVarArr) {
                            A.b(cVar2, "A Disposable in the disposables array is null");
                            cVar.a(cVar2);
                        }
                        return true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        for (c cVar3 : cVarArr) {
            cVar3.dispose();
        }
        return false;
    }

    public final int b() {
        if (this.b) {
            return 0;
        }
        synchronized (this) {
            try {
                if (this.b) {
                    return 0;
                }
                p061l.c cVar = this.f1087a;
                return cVar != null ? cVar.b : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p033f3.c
    public boolean delete(c cVar) {
        Object obj;
        A.b(cVar, "disposables is null");
        if (this.b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.b) {
                    return false;
                }
                p061l.c cVar2 = this.f1087a;
                if (cVar2 != null) {
                    Object[] objArr = (Object[]) cVar2.d;
                    int i5 = cVar2.f5763a;
                    int iHashCode = cVar.hashCode() * (-1640531527);
                    int i6 = (iHashCode ^ (iHashCode >>> 16)) & i5;
                    Object obj2 = objArr[i6];
                    if (obj2 != null) {
                        if (obj2.equals(cVar)) {
                            cVar2.b(i6, i5, objArr);
                        } else {
                            do {
                                i6 = (i6 + 1) & i5;
                                obj = objArr[i6];
                                if (obj == null) {
                                }
                            } while (!obj.equals(cVar));
                            cVar2.b(i6, i5, objArr);
                        }
                        return true;
                    }
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
                p061l.c cVar = this.f1087a;
                this.f1087a = null;
                a(cVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.b;
    }

    @Override // p033f3.c
    public boolean remove(c cVar) {
        if (!delete(cVar)) {
            return false;
        }
        cVar.dispose();
        return true;
    }

    public b(Iterable<? extends c> iterable) {
        A.b(iterable, "disposables is null");
        this.f1087a = new p061l.c();
        for (c cVar : iterable) {
            A.b(cVar, "A Disposable item in the disposables sequence is null");
            this.f1087a.a(cVar);
        }
    }
}
