package p018c4;

import E3.g;
import E3.q;
import F3.i;
import O3.l;
import java.util.concurrent.CancellationException;
import p007a4.AbstractC0260a;
import p007a4.I0;
import p044h4.h;
import p044h4.j;
import p147z3.Q;

/* JADX INFO: renamed from: c4.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class C0392w extends AbstractC0260a implements InterfaceC0391v {
    private final InterfaceC0391v _channel;

    public C0392w(q qVar, InterfaceC0391v interfaceC0391v, boolean z6, boolean z7) {
        super(qVar, z6, z7);
        this._channel = interfaceC0391v;
    }

    @Override // p018c4.D0
    public final boolean c() {
        return this._channel.c();
    }

    @Override // p007a4.X0, p007a4.H0
    public final void cancel(CancellationException cancellationException) {
        if (b()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new I0(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }

    @Override // p007a4.X0
    public void cancelInternal(Throwable th) {
        CancellationException cancellationException = toCancellationException(th, null);
        this._channel.cancel(cancellationException);
        cancelCoroutine(cancellationException);
    }

    @Override // p018c4.InterfaceC0391v, p018c4.D0
    public boolean close(Throwable th) {
        return this._channel.close(th);
    }

    public final InterfaceC0391v getChannel() {
        return this;
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    public h getOnReceive() {
        return this._channel.getOnReceive();
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    public h getOnReceiveCatching() {
        return this._channel.getOnReceiveCatching();
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    public h getOnReceiveOrNull() {
        return this._channel.getOnReceiveOrNull();
    }

    @Override // p018c4.InterfaceC0391v, p018c4.D0
    public j getOnSend() {
        return this._channel.getOnSend();
    }

    public final InterfaceC0391v get_channel() {
        return this._channel;
    }

    @Override // p018c4.InterfaceC0391v, p018c4.D0
    public void invokeOnClose(l lVar) {
        this._channel.invokeOnClose(lVar);
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    public InterfaceC0395z iterator() {
        return this._channel.iterator();
    }

    @Override // p018c4.InterfaceC0391v, p018c4.D0
    public boolean offer(Object obj) {
        return this._channel.offer(obj);
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    public Object poll() {
        return this._channel.poll();
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    public Object receive(g<Object> gVar) {
        return this._channel.receive(gVar);
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU */
    public Object mo1006receiveCatchingJP2dKIU(g<? super B> gVar) {
        Object objMo1006receiveCatchingJP2dKIU = this._channel.mo1006receiveCatchingJP2dKIU(gVar);
        i.getCOROUTINE_SUSPENDED();
        return objMo1006receiveCatchingJP2dKIU;
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    public Object receiveOrNull(g<Object> gVar) {
        return this._channel.receiveOrNull(gVar);
    }

    @Override // p018c4.InterfaceC0391v, p018c4.D0
    public Object send(Object obj, g<? super Q> gVar) {
        return this._channel.send(obj, gVar);
    }

    @Override // p018c4.InterfaceC0391v, p018c4.B0
    /* JADX INFO: renamed from: tryReceive-PtdJZtk */
    public Object mo1007tryReceivePtdJZtk() {
        return this._channel.mo1007tryReceivePtdJZtk();
    }

    @Override // p018c4.InterfaceC0391v, p018c4.D0
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo1011trySendJP2dKIU(Object obj) {
        return this._channel.mo1011trySendJP2dKIU(obj);
    }

    @Override // p007a4.X0, p007a4.H0
    public /* synthetic */ void cancel() {
        cancelInternal(new I0(cancellationExceptionMessage(), null, this));
    }

    @Override // p007a4.X0, p007a4.H0
    public final /* synthetic */ boolean cancel(Throwable th) {
        cancelInternal(new I0(cancellationExceptionMessage(), null, this));
        return true;
    }
}
