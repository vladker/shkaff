package cn.fly.tcp.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Socket f1539a;
    public final d b;
    public SocketAddress c;
    public final AtomicBoolean d;
    final Map<c, Long> e;

    /* JADX INFO: renamed from: cn.fly.tcp.impl.a$a, reason: collision with other inner class name */
    public class C0020a extends Thread {
        public C0020a(String str) {
            super(str);
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            a.this.a();
        }
    }

    public a(Socket socket, d dVar) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.d = atomicBoolean;
        this.e = new WeakHashMap();
        this.f1539a = socket;
        this.b = dVar;
        atomicBoolean.getAndSet(true);
        dVar.a(this);
        new C0020a("mlp-worker").start();
    }

    public c a(e eVar) {
        c cVar = new c();
        synchronized (this.e) {
            this.e.put(cVar, Long.valueOf(eVar.c));
        }
        try {
            OutputStream outputStream = this.f1539a.getOutputStream();
            outputStream.write(eVar.a());
            outputStream.flush();
            return cVar;
        } catch (Throwable th) {
            this.b.a(this, th);
            return null;
        }
    }

    public void a() {
        try {
            InputStream inputStream = this.f1539a.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[8096];
            while (true) {
                int i5 = inputStream.read(bArr);
                if (-1 == i5) {
                    return;
                }
                byteArrayOutputStream.write(bArr, 0, i5);
                if (i5 < 8096) {
                    byteArrayOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(byteArray);
                    int iB = 0;
                    while (byteBufferWrap.hasRemaining() && byteBufferWrap.get() != 1) {
                        iB++;
                    }
                    List<e> listA = e.a((ByteBuffer) ((Buffer) new Object[]{byteBufferWrap}[0]).position(iB));
                    Iterator<e> it = listA.iterator();
                    while (it.hasNext()) {
                        iB += it.next().b();
                    }
                    a(listA);
                    byteArrayOutputStream.reset();
                    if (byteArray.length - iB > 0) {
                        byteArrayOutputStream.write(byteArray, iB, byteArray.length - iB);
                    }
                }
            }
        } catch (Throwable th) {
            this.b.a(this, th);
            a(true);
        }
    }

    public void a(List<e> list) {
        for (e eVar : list) {
            if (this.b != null && eVar.b >= 9001) {
                cn.fly.tcp.a.c.a().b("rcv type: pu5h");
                this.b.a(this, eVar);
            }
            if (eVar.b < 9001) {
                cn.fly.tcp.a.c.a().b("rcv type: non-pu5h");
                for (Map.Entry<c, Long> entry : this.e.entrySet()) {
                    if (entry.getValue().equals(Long.valueOf(eVar.c))) {
                        entry.getKey().a(eVar);
                        break;
                    }
                }
            }
        }
    }

    public void a(boolean z6) {
        if (this.d.getAndSet(false)) {
            try {
                this.f1539a.close();
                this.b.a(this, z6);
            } catch (Throwable unused) {
            }
            this.d.getAndSet(false);
            this.e.clear();
        }
    }
}
