package p018c4;

import E3.g;
import E3.q;
import O3.l;
import p007a4.M;
import p044h4.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface x0 extends M, D0 {
    @Override // p018c4.D0
    /* synthetic */ boolean close(Throwable th);

    D0 getChannel();

    @Override // p007a4.M
    /* synthetic */ q getCoroutineContext();

    @Override // p018c4.D0
    /* synthetic */ j getOnSend();

    @Override // p018c4.D0
    /* synthetic */ void invokeOnClose(l lVar);

    @Override // p018c4.D0
    /* synthetic */ boolean offer(Object obj);

    @Override // p018c4.D0
    /* synthetic */ Object send(Object obj, g gVar);

    @Override // p018c4.D0
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    /* synthetic */ Object mo1011trySendJP2dKIU(Object obj);
}
