package A2;

import F3.i;
import G3.m;
import O3.p;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.InetSocketAddress;
import java.net.Socket;
import kotlin.jvm.internal.E;
import org.apache.poi.xddf.usermodel.Angles;
import p007a4.M;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f27a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, E3.g gVar2) {
        super(2, gVar2);
        this.f27a = gVar;
    }

    @Override // G3.a
    public final E3.g<Q> create(Object obj, E3.g<?> gVar) {
        return new f(this.f27a, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, E3.g<? super u> gVar) {
        return ((f) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        i.getCOROUTINE_SUSPENDED();
        v.throwOnFailure(obj);
        g gVar = this.f27a;
        InetSocketAddress inetSocketAddress = new InetSocketAddress(gVar.device.getIp(), gVar.device.f28a);
        try {
            gVar.mSocket = new Socket();
            Socket socket = gVar.mSocket;
            E.c(socket);
            socket.setSoTimeout(Angles.OOXML_DEGREE);
            Socket socket2 = gVar.mSocket;
            E.c(socket2);
            socket2.connect(inetSocketAddress, 5000);
            Socket socket3 = gVar.mSocket;
            E.c(socket3);
            gVar.outputStream = socket3.getOutputStream();
            Socket socket4 = gVar.mSocket;
            E.c(socket4);
            gVar.inputStream = socket4.getInputStream();
            Log.v("wifitest", FirebaseAnalytics.Param.SUCCESS);
            return u.a(u.m1361constructorimpl(Q.INSTANCE));
        } catch (Exception e) {
            e.printStackTrace();
            return u.a(u.m1361constructorimpl(v.createFailure(e)));
        }
    }
}
