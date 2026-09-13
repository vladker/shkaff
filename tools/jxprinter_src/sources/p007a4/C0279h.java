package p007a4;

import java.util.concurrent.Future;

/* JADX INFO: renamed from: a4.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0279h implements InterfaceC0283j {
    private final Future<?> future;

    public C0279h(Future<?> future) {
        this.future = future;
    }

    @Override // p007a4.InterfaceC0283j
    public void invoke(Throwable th) {
        this.future.cancel(false);
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.future + ']';
    }
}
