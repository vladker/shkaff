package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class m5 extends AtomicReference implements InterfaceC0984q {
    private static final long serialVersionUID = 3256684027868224024L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l5 f4706a;
    public final int b;
    public boolean c;

    public m5(l5 l5Var, int i5) {
        this.f4706a = l5Var;
        this.b = i5;
    }

    @Override // t5.c
    public final void onComplete() {
        l5 l5Var = this.f4706a;
        int i5 = this.b;
        if (this.c) {
            l5Var.getClass();
            return;
        }
        l5Var.f4700h = true;
        p094q3.g.a(l5Var.e);
        l5Var.a(i5);
        com.android.billingclient.api.v1.g(l5Var.f4697a, l5Var, l5Var.f4699g);
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        l5 l5Var = this.f4706a;
        int i5 = this.b;
        l5Var.f4700h = true;
        p094q3.g.a(l5Var.e);
        l5Var.a(i5);
        com.android.billingclient.api.v1.i(l5Var.f4697a, th, l5Var, l5Var.f4699g);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (!this.c) {
            this.c = true;
        }
        this.f4706a.d.set(this.b, obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.d(this, dVar, LocationRequestCompat.PASSIVE_INTERVAL);
    }
}
