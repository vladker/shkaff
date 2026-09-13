package p018c4;

import E3.g;
import java.util.concurrent.CancellationException;
import p044h4.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface B0 {
    /* synthetic */ void cancel();

    void cancel(CancellationException cancellationException);

    /* synthetic */ boolean cancel(Throwable th);

    h getOnReceive();

    h getOnReceiveCatching();

    h getOnReceiveOrNull();

    InterfaceC0395z iterator();

    Object poll();

    Object receive(g<Object> gVar);

    /* JADX INFO: renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    Object mo1006receiveCatchingJP2dKIU(g<? super B> gVar);

    Object receiveOrNull(g<Object> gVar);

    /* JADX INFO: renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    Object mo1007tryReceivePtdJZtk();
}
