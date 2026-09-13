package io.reactivex.internal.operators.observable;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class W0 extends p048i3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5124a;
    public final Iterator b;
    public volatile boolean c;
    public boolean d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5125f;

    public W0(io.reactivex.I i5, Iterator it) {
        this.f5124a = i5;
        this.b = it;
    }

    @Override // p043h3.f
    public final int c(int i5) {
        this.d = true;
        return 1;
    }

    @Override // p043h3.j
    public final void clear() {
        this.e = true;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.c = true;
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.c;
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.e;
    }

    @Override // p048i3.c, p043h3.e, p043h3.f, p043h3.j
    public Object poll() {
        if (this.e) {
            return null;
        }
        boolean z6 = this.f5125f;
        Iterator it = this.b;
        if (!z6) {
            this.f5125f = true;
        } else if (!it.hasNext()) {
            this.e = true;
            return null;
        }
        Object next = it.next();
        p039g3.A.b(next, "The iterator returned a null value");
        return next;
    }
}
