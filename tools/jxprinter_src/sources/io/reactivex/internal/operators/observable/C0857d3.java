package io.reactivex.internal.operators.observable;

import java.util.ArrayDeque;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.d3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0857d3 extends ArrayDeque implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = 7240042530241604978L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5175a;
    public final int b;
    public p011b3.c c;
    public volatile boolean d;

    public C0857d3(io.reactivex.I i5, int i6) {
        this.f5175a = i5;
        this.b = i6;
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.c.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.d;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        io.reactivex.I i5 = this.f5175a;
        while (!this.d) {
            Object objPoll = poll();
            if (objPoll == null) {
                if (this.d) {
                    return;
                }
                i5.onComplete();
                return;
            }
            i5.onNext(objPoll);
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f5175a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.b == size()) {
            poll();
        }
        offer(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.c, cVar)) {
            this.c = cVar;
            this.f5175a.onSubscribe(this);
        }
    }
}
