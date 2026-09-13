package cn.fly.tcp.impl;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    a f1553a;
    final d b;
    final AtomicLong c = new AtomicLong();

    public f(d dVar) {
        this.b = dVar;
    }

    public void a() {
        a aVar = this.f1553a;
        if (aVar != null) {
            aVar.a(false);
        }
    }

    public boolean b() {
        a aVar = this.f1553a;
        return aVar != null && aVar.d.get();
    }

    public void a(SocketAddress socketAddress, boolean z6, boolean z7, int i5) throws IOException {
        a aVar = this.f1553a;
        if (aVar != null) {
            if (!socketAddress.equals(aVar.c)) {
                this.f1553a.a(false);
            } else if (b()) {
                return;
            }
        }
        Socket socket = new Socket();
        socket.setKeepAlive(z6);
        socket.setTcpNoDelay(z7);
        socket.connect(socketAddress, i5);
        a aVar2 = new a(socket, this.b);
        this.f1553a = aVar2;
        aVar2.c = socketAddress;
    }

    public c a(e eVar) {
        if (eVar.c == 0) {
            eVar.c = this.c.incrementAndGet();
        }
        return this.f1553a.a(eVar);
    }
}
