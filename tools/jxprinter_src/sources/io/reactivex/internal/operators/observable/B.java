package io.reactivex.internal.operators.observable;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class B implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4872a;
    public final Collection b;
    public final /* synthetic */ C c;

    public /* synthetic */ B(C c, Collection collection, int i5) {
        this.f4872a = i5;
        this.c = c;
        this.b = collection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4872a) {
            case 0:
                synchronized (this.c) {
                    this.c.f4882l.remove(this.b);
                    break;
                }
                C c = this.c;
                c.g(this.b, c.f4881k);
                return;
            default:
                synchronized (this.c) {
                    this.c.f4882l.remove(this.b);
                    break;
                }
                C c6 = this.c;
                c6.g(this.b, c6.f4881k);
                return;
        }
    }
}
