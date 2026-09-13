package io.reactivex.internal.schedulers;

import io.reactivex.InterfaceC0679f;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class G extends AtomicReference implements p011b3.c {
    public G() {
        super(I.e);
    }

    public abstract p011b3.c a(io.reactivex.M m6, InterfaceC0679f interfaceC0679f);

    @Override // p011b3.c
    public final void dispose() {
        p011b3.c cVar;
        p011b3.c cVar2 = I.f5340f;
        do {
            cVar = (p011b3.c) get();
            if (cVar == I.f5340f) {
                return;
            }
        } while (!compareAndSet(cVar, cVar2));
        if (cVar != I.e) {
            cVar.dispose();
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return ((p011b3.c) get()).e();
    }
}
