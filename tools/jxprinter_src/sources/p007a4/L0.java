package p007a4;

import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class L0 {
    public static final void cancelFutureOnCancellation(InterfaceC0285k interfaceC0285k, Future<?> future) {
        AbstractC0293o.invokeOnCancellation(interfaceC0285k, new g1(future));
    }
}
