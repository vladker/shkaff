package cn.fly.commons.cc;

import android.net.ConnectivityManager;
import android.net.Network;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class n implements t<n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m f1376a;

    private ConnectivityManager.NetworkCallback a() {
        return new ConnectivityManager.NetworkCallback() { // from class: cn.fly.commons.cc.n.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                super.onAvailable(network);
                ArrayList<Object> arrayList = new ArrayList<>();
                arrayList.add(network);
                n.this.f1376a.a(cn.fly.commons.o.a("011_dk2eXfdddTdYdi6gd2ff0gf"), arrayList);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                super.onLost(network);
                ArrayList<Object> arrayList = new ArrayList<>();
                arrayList.add(network);
                n.this.f1376a.a(cn.fly.commons.o.a("006Udk,eZfedkfiUi"), arrayList);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                super.onUnavailable();
            }
        };
    }

    public void a(m mVar) {
        this.f1376a = mVar;
    }

    @Override // cn.fly.commons.cc.t
    public boolean a(n nVar, Class<n> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        Object obj;
        if ("setHandler".equals(str) && objArr.length == 1 && (obj = objArr[0]) != null && (obj instanceof m)) {
            nVar.a((m) obj);
        } else {
            if (!cn.fly.commons.o.a("0196diMeSdiDiBegYfiYfgdkdjehed;dgg?ffJdc-eh").equals(str) || objArr.length != 0) {
                return false;
            }
            objArr2[0] = nVar.a();
        }
        return true;
    }
}
