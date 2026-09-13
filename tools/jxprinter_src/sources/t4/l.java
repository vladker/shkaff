package t4;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.C1348a;
import okhttp3.C1378y;
import okhttp3.InterfaceC1353f;
import okhttp3.InterfaceC1370p;
import okhttp3.X;
import okhttp3.r;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1348a f8694a;
    public final p075n1.a b;
    public final r c;
    public final List d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f8695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f8696g;

    public l(C1348a c1348a, p075n1.a aVar, InterfaceC1353f interfaceC1353f, r rVar) {
        List list = Collections.EMPTY_LIST;
        this.d = list;
        this.f8695f = list;
        this.f8696g = new ArrayList();
        this.f8694a = c1348a;
        this.b = aVar;
        this.c = rVar;
        C1378y c1378y = c1348a.f6553a;
        Proxy proxy = c1348a.proxy();
        if (proxy != null) {
            this.d = Collections.singletonList(proxy);
        } else {
            List<Proxy> listSelect = c1348a.f6555g.select(c1378y.k());
            this.d = (listSelect == null || listSelect.isEmpty()) ? p107s4.d.immutableList(Proxy.NO_PROXY) : p107s4.d.i(listSelect);
        }
        this.e = 0;
    }

    private Proxy nextProxy() throws SocketException, UnknownHostException {
        if (this.e < this.d.size()) {
            int i5 = this.e;
            this.e = i5 + 1;
            Proxy proxy = (Proxy) this.d.get(i5);
            resetNextInetSocketAddress(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f8694a.f6553a.d + "; exhausted proxy configurations: " + this.d);
    }

    private void resetNextInetSocketAddress(Proxy proxy) throws SocketException, UnknownHostException {
        String hostName;
        int port;
        this.f8695f = new ArrayList();
        Proxy.Type type = proxy.type();
        Proxy.Type type2 = Proxy.Type.DIRECT;
        C1348a c1348a = this.f8694a;
        if (type == type2 || proxy.type() == Proxy.Type.SOCKS) {
            C1378y c1378y = c1348a.f6553a;
            hostName = c1378y.d;
            port = c1378y.e;
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            InetAddress address = inetSocketAddress.getAddress();
            hostName = address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
            port = inetSocketAddress.getPort();
        }
        if (port < 1 || port > 65535) {
            throw new SocketException("No route to " + hostName + ParameterizedMessage.ERROR_MSG_SEPARATOR + port + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f8695f.add(InetSocketAddress.createUnresolved(hostName, port));
            return;
        }
        r rVar = this.c;
        rVar.getClass();
        ((F4.e) c1348a.b).getClass();
        List listLambda$static$0 = InterfaceC1370p.lambda$static$0(hostName);
        if (listLambda$static$0.isEmpty()) {
            throw new UnknownHostException(c1348a.b + " returned no addresses for " + hostName);
        }
        rVar.getClass();
        int size = listLambda$static$0.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f8695f.add(new InetSocketAddress((InetAddress) listLambda$static$0.get(i5), port));
        }
    }

    public k next() throws SocketException, UnknownHostException {
        boolean zContains;
        if (this.e >= this.d.size() && this.f8696g.isEmpty()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (this.e < this.d.size()) {
            Proxy proxyNextProxy = nextProxy();
            int size = this.f8695f.size();
            for (int i5 = 0; i5 < size; i5++) {
                X x6 = new X(this.f8694a, proxyNextProxy, (InetSocketAddress) this.f8695f.get(i5));
                p075n1.a aVar = this.b;
                synchronized (aVar) {
                    zContains = ((LinkedHashSet) aVar.b).contains(x6);
                }
                if (zContains) {
                    this.f8696g.add(x6);
                } else {
                    arrayList.add(x6);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.f8696g);
            this.f8696g.clear();
        }
        return new k(arrayList);
    }
}
