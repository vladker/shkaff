package p007a4;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class J0 extends X0 implements InterfaceC0310x {
    public final boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J0(H0 h1) {
        X0 job;
        super(true);
        boolean z6 = true;
        initParentJob(h1);
        r parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        C0300s c0300s = parentHandle$kotlinx_coroutines_core instanceof C0300s ? (C0300s) parentHandle$kotlinx_coroutines_core : null;
        if (c0300s == null || (job = c0300s.getJob()) == null) {
            z6 = false;
            break;
        }
        while (!job.i()) {
            r parentHandle$kotlinx_coroutines_core2 = job.getParentHandle$kotlinx_coroutines_core();
            C0300s c0300s2 = parentHandle$kotlinx_coroutines_core2 instanceof C0300s ? (C0300s) parentHandle$kotlinx_coroutines_core2 : null;
            if (c0300s2 == null || (job = c0300s2.getJob()) == null) {
                z6 = false;
                break;
            }
        }
        this.c = z6;
    }

    @Override // p007a4.InterfaceC0310x
    public boolean completeExceptionally(Throwable th) {
        return makeCompleting$kotlinx_coroutines_core(new C0314z(th, false));
    }

    @Override // p007a4.X0
    public final boolean i() {
        return this.c;
    }

    @Override // p007a4.X0
    public final boolean j() {
        return true;
    }
}
