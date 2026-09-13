package A2;

import F3.i;
import G3.m;
import O3.p;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import p007a4.M;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f25a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(g gVar, E3.g gVar2) {
        super(2, gVar2);
        this.f25a = gVar;
    }

    @Override // G3.a
    public final E3.g<Q> create(Object obj, E3.g<?> gVar) {
        return new d(this.f25a, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, E3.g<? super u> gVar) {
        return ((d) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        g gVar = this.f25a;
        i.getCOROUTINE_SUSPENDED();
        v.throwOnFailure(obj);
        try {
            OutputStream outputStream = gVar.outputStream;
            if (outputStream != null) {
                outputStream.close();
            }
            InputStream inputStream = gVar.inputStream;
            if (inputStream != null) {
                inputStream.close();
            }
            Socket socket = gVar.mSocket;
            if (socket != null) {
                socket.close();
            }
            gVar.outputStream = null;
            gVar.inputStream = null;
            gVar.mSocket = null;
            return u.a(u.m1361constructorimpl(Q.INSTANCE));
        } catch (IOException e) {
            e.printStackTrace();
            return u.a(u.m1361constructorimpl(v.createFailure(e)));
        }
    }
}
