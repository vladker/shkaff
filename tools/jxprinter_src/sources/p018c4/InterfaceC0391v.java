package p018c4;

import E3.g;
import O3.l;
import java.util.concurrent.CancellationException;
import p044h4.h;
import p044h4.j;

/* JADX INFO: renamed from: c4.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC0391v extends D0, B0 {
    public static final String DEFAULT_BUFFER_PROPERTY_NAME = "kotlinx.coroutines.channels.defaultBuffer";
    public static final C0390u Factory = C0390u.f1188a;

    /* synthetic */ void cancel();

    /* synthetic */ void cancel(CancellationException cancellationException);

    /* synthetic */ boolean cancel(Throwable th);

    @Override // p018c4.D0
    /* synthetic */ boolean close(Throwable th);

    /* synthetic */ h getOnReceive();

    /* synthetic */ h getOnReceiveCatching();

    /* synthetic */ h getOnReceiveOrNull();

    @Override // p018c4.D0
    /* synthetic */ j getOnSend();

    @Override // p018c4.D0
    /* synthetic */ void invokeOnClose(l lVar);

    /* synthetic */ InterfaceC0395z iterator();

    @Override // p018c4.D0
    /* synthetic */ boolean offer(Object obj);

    /* synthetic */ Object poll();

    /* synthetic */ Object receive(g gVar);

    /* JADX INFO: renamed from: receiveCatching-JP2dKIU */
    /* synthetic */ Object mo1006receiveCatchingJP2dKIU(g gVar);

    /* synthetic */ Object receiveOrNull(g gVar);

    @Override // p018c4.D0
    /* synthetic */ Object send(Object obj, g gVar);

    /* JADX INFO: renamed from: tryReceive-PtdJZtk */
    /* synthetic */ Object mo1007tryReceivePtdJZtk();

    @Override // p018c4.D0
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    /* synthetic */ Object mo1011trySendJP2dKIU(Object obj);
}
