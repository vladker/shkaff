package p007a4;

import java.util.concurrent.Future;

/* JADX INFO: renamed from: a4.g0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0278g0 implements InterfaceC0280h0 {
    private final Future<?> future;

    public C0278g0(Future<?> future) {
        this.future = future;
    }

    @Override // p007a4.InterfaceC0280h0
    public final void dispose() {
        this.future.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.future + ']';
    }
}
