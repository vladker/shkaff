package okhttp3.internal.http2;

import A4.InterfaceC0170m;
import A4.InterfaceC0171n;
import A4.N;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Socket f6616a;
    public String b;
    public InterfaceC0171n c;
    public InterfaceC0170m d;
    public o e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6618g;

    public m socket(Socket socket) {
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        String hostName = remoteSocketAddress instanceof InetSocketAddress ? ((InetSocketAddress) remoteSocketAddress).getHostName() : remoteSocketAddress.toString();
        InterfaceC0171n interfaceC0171nBuffer = N.buffer(N.source(socket));
        InterfaceC0170m interfaceC0170mBuffer = N.buffer(N.sink(socket));
        this.f6616a = socket;
        this.b = hostName;
        this.c = interfaceC0171nBuffer;
        this.d = interfaceC0170mBuffer;
        return this;
    }
}
