package okhttp3.internal.http2;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class q extends p107s4.b {
    public final /* synthetic */ int b = 0;
    public final /* synthetic */ r c;
    public final /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(r rVar, Object[] objArr, A a6) {
        super("OkHttp %s stream %d", objArr);
        this.c = rVar;
        this.d = a6;
    }

    @Override // p107s4.b
    public final void a() {
        int i5;
        A[] aArr;
        long j6;
        switch (this.b) {
            case 0:
                A a6 = (A) this.d;
                r rVar = this.c;
                try {
                    rVar.c.b.onStream(a6);
                    return;
                } catch (IOException e) {
                    p130w4.i.f8835a.log(4, "Http2Connection.Listener failure for " + rVar.c.d, e);
                    try {
                        a6.close(EnumC1358b.PROTOCOL_ERROR, e);
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
            default:
                r rVar2 = this.c;
                F f6 = (F) this.d;
                synchronized (rVar2.c.f6639w) {
                    synchronized (rVar2.c) {
                        try {
                            int iA = rVar2.c.f6637u.a();
                            F f7 = rVar2.c.f6637u;
                            f7.getClass();
                            for (int i6 = 0; i6 < 10; i6++) {
                                if (((1 << i6) & f6.f6594a) != 0) {
                                    f7.b(i6, f6.b[i6]);
                                }
                            }
                            int iA2 = rVar2.c.f6637u.a();
                            aArr = null;
                            if (iA2 == -1 || iA2 == iA) {
                                j6 = 0;
                            } else {
                                j6 = iA2 - iA;
                                if (!rVar2.c.c.isEmpty()) {
                                    aArr = (A[]) rVar2.c.c.values().toArray(new A[rVar2.c.c.size()]);
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    try {
                        s sVar = rVar2.c;
                        sVar.f6639w.applyAndAckSettings(sVar.f6637u);
                    } catch (IOException e6) {
                        rVar2.c.failConnection(e6);
                    }
                    break;
                }
                if (aArr != null) {
                    for (A a7 : aArr) {
                        synchronized (a7) {
                            a7.b += j6;
                            if (j6 > 0) {
                                a7.notifyAll();
                            }
                        }
                    }
                }
                s.f6620z.execute(new i(rVar2, new Object[]{rVar2.c.d}));
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(r rVar, Object[] objArr, F f6) {
        super("OkHttp %s ACK Settings", objArr);
        this.c = rVar;
        this.d = f6;
    }
}
