package cn.fly.tools.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.text.TextUtils;
import cn.fly.commons.C0396r;
import cn.fly.commons.CSCenter;
import cn.fly.commons.m;
import cn.fly.tools.FlyLog;
import cn.fly.tools.proguard.PublicMemberKeeper;

/* JADX INFO: loaded from: classes.dex */
public class NtFetcher implements PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static NtFetcher f1930a;
    private Context b;
    private BroadcastReceiver c;
    private String d;
    private Integer e;

    public NtFetcher(Context context) {
        this.b = context;
        a();
    }

    private boolean b(int i5) {
        return i5 == 20;
    }

    private boolean c(int i5) {
        return i5 == 13;
    }

    private boolean d(int i5) {
        switch (i5) {
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            case 4:
            case 7:
            case 11:
            default:
                return false;
        }
    }

    private void e() {
        this.c = new BroadcastReceiver() { // from class: cn.fly.tools.utils.NtFetcher.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equalsIgnoreCase(m.a("036fgRfeflfmfkfefn^ghk5fn8e?fm0ggCfngfijgigiikgfheggimggheknfjgfhmhfgikfik"))) {
                        NtFetcher.this.c();
                    }
                } catch (Throwable th) {
                    FlyLog.getInstance().d(th);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(m.a("036fg=feflfmfkfefn5ghkKfn,e?fmLggQfngfijgigiikgfheggimggheknfjgfhmhfgikfik"));
        C0396r.a(this.c, intentFilter);
    }

    private void f() {
        BroadcastReceiver broadcastReceiver = this.c;
        if (broadcastReceiver != null) {
            C0396r.a(broadcastReceiver);
            this.c = null;
        }
    }

    private String g() {
        return (DH.SyncMtd.checkPermission(m.a("035fgVfeflfmfkfefn@lh5flfhfkhkhkfkfm1gSfnilikhfhnfjinhmijgiikfjgnhehfheik")) && CSCenter.getInstance().isPhoneStateDataEnable()) ? h() : getNetworkTypeDesensitized();
    }

    public static NtFetcher getInstance(Context context) {
        if (f1930a == null) {
            synchronized (NtFetcher.class) {
                try {
                    if (f1930a == null) {
                        f1930a = new NtFetcher(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1930a;
    }

    private String h() {
        Object systemServiceSafe;
        NetworkInfo activeNetworkInfo;
        try {
            if (DH.SyncMtd.checkPermission(m.a("039fgOfeflfmfkfefn7lh$flfhfkhkhkfkfmJgGfnhfgfgfikgngnfjgiikheihijilkefjgnhehfheik")) && (systemServiceSafe = DH.SyncMtd.getSystemServiceSafe("connectivity")) != null && (activeNetworkInfo = ((ConnectivityManager) systemServiceSafe).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    int iB = cn.fly.tools.b.e.a(this.b).b();
                    if (a(iB)) {
                        return m.a("002Mjkkf");
                    }
                    if (c(iB)) {
                        return m.a("002(jnkf");
                    }
                    return m.a(d(iB) ? "002Blhkf" : "002Njgkf");
                }
                if (type == 1) {
                    return m.a("004Phifkghfk");
                }
                switch (type) {
                    case 6:
                        return m.a("005)hifkfhNfLgk");
                    case 7:
                        return m.a("0091hh2iJfi1hkBfmfmFkj");
                    case 8:
                        return m.a("005Ifefifhfhge");
                    case 9:
                        return m.a("008hkjhJflKghk");
                    default:
                        return String.valueOf(type);
                }
            }
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
        }
        return m.a("004g@fmUgh");
    }

    public synchronized int getDtNtType() {
        try {
            if (this.e == null) {
                this.e = Integer.valueOf(d());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.e.intValue();
    }

    @SuppressLint({"MissingPermission"})
    public String getNetworkTypeDesensitized() {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo = null;
        try {
            if (DH.SyncMtd.checkPermission(m.a("039fg^feflfmfkfefnMlh4flfhfkhkhkfkfm'gUfnhfgfgfikgngnfjgiikheihijilkefjgnhehfheik")) && (connectivityManager = (ConnectivityManager) DH.SyncMtd.getSystemServiceSafe("connectivity")) != null) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
                if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
                    String strA = m.a("0042hifkghfk");
                    FlyLog.getInstance().d("networkInfo: " + networkInfo2, new Object[0]);
                    return strA;
                }
                NetworkInfo networkInfo3 = connectivityManager.getNetworkInfo(0);
                if (networkInfo3 != null && networkInfo3.getState() == NetworkInfo.State.CONNECTED) {
                    String subtypeName = networkInfo3.getSubtypeName();
                    if (m.a("0027giil").equalsIgnoreCase(subtypeName)) {
                        String strA2 = m.a("002Hjkkf");
                        FlyLog.getInstance().d("networkInfo: " + networkInfo3, new Object[0]);
                        return strA2;
                    }
                    if (m.a("003>hgheik").equalsIgnoreCase(subtypeName)) {
                        String strA3 = m.a("002Vjnkf");
                        FlyLog.getInstance().d("networkInfo: " + networkInfo3, new Object[0]);
                        return strA3;
                    }
                    if (a(subtypeName)) {
                        String strA4 = m.a("002Slhkf");
                        FlyLog.getInstance().d("networkInfo: " + networkInfo3, new Object[0]);
                        return strA4;
                    }
                    if (!b(subtypeName)) {
                        FlyLog.getInstance().d("networkInfo: " + networkInfo3, new Object[0]);
                        return subtypeName;
                    }
                    String strA5 = m.a("0026jgkf");
                    FlyLog.getInstance().d("networkInfo: " + networkInfo3, new Object[0]);
                    return strA5;
                }
                NetworkInfo networkInfo4 = connectivityManager.getNetworkInfo(7);
                if (networkInfo4 != null && networkInfo4.getState() == NetworkInfo.State.CONNECTED) {
                    String strA6 = m.a("0097hh!i>fi]hkWfmfmQkj");
                    FlyLog.getInstance().d("networkInfo: " + networkInfo4, new Object[0]);
                    return strA6;
                }
                NetworkInfo networkInfo5 = connectivityManager.getNetworkInfo(8);
                if (networkInfo5 != null && networkInfo5.getState() == NetworkInfo.State.CONNECTED) {
                    String strA7 = m.a("005>fefifhfhge");
                    FlyLog.getInstance().d("networkInfo: " + networkInfo5, new Object[0]);
                    return strA7;
                }
                NetworkInfo networkInfo6 = connectivityManager.getNetworkInfo(9);
                if (networkInfo6 != null && networkInfo6.getState() == NetworkInfo.State.CONNECTED) {
                    String strA8 = m.a("008hkjhLfl*ghk");
                    FlyLog.getInstance().d("networkInfo: " + networkInfo6, new Object[0]);
                    return strA8;
                }
                networkInfo = connectivityManager.getNetworkInfo(6);
                if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    String strA9 = m.a("005OhifkfhQf3gk");
                    FlyLog.getInstance().d("networkInfo: " + networkInfo, new Object[0]);
                    return strA9;
                }
            }
            FlyLog.getInstance().d("networkInfo: " + networkInfo, new Object[0]);
        } catch (Throwable th) {
            try {
                FlyLog.getInstance().e(th);
                FlyLog.getInstance().d("networkInfo: " + ((Object) null), new Object[0]);
            } catch (Throwable th2) {
                FlyLog.getInstance().d("networkInfo: " + ((Object) null), new Object[0]);
                throw th2;
            }
        }
        return m.a("004g@fmHgh");
    }

    public synchronized String getNtType(boolean z6) {
        if (TextUtils.isEmpty(this.d) || z6) {
            this.d = g();
        }
        return this.d;
    }

    public void recycle() {
        f();
    }

    @SuppressLint({"MissingPermission"})
    private void a() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) DH.SyncMtd.getSystemServiceSafe("connectivity");
            if (DH.SyncMtd.getOSVersionIntForFly() >= 26 && DH.SyncMtd.checkPermission(m.a("039fgPfeflfmfkfefnHlh]flfhfkhkhkfkfmFg5fnhfgfgfikgngnfjgiikheihijilkefjgnhehfheik"))) {
                connectivityManager.registerDefaultNetworkCallback(b());
            } else if (DH.SyncMtd.getOSVersionIntForFly() < 21 || !DH.SyncMtd.checkPermission(m.a("039fg@feflfmfkfefnElh;flfhfkhkhkfkfmGg;fnhfgfgfikgngnfjgiikheihijilkefjgnhehfheik"))) {
                e();
            } else {
                connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), b());
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
    }

    @TargetApi(21)
    private ConnectivityManager.NetworkCallback b() {
        return new ConnectivityManager.NetworkCallback() { // from class: cn.fly.tools.utils.NtFetcher.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                super.onAvailable(network);
                NtFetcher.this.c();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                super.onCapabilitiesChanged(network, networkCapabilities);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
                super.onLinkPropertiesChanged(network, linkProperties);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLosing(Network network, int i5) {
                super.onLosing(network, i5);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                super.onLost(network);
                NtFetcher.this.c();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                super.onUnavailable();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.d = g();
        this.e = Integer.valueOf(d());
    }

    private int d() {
        if (DH.SyncMtd.getSystemServiceSafe("phone") != null && DH.SyncMtd.checkPermission(m.a("035fg$feflfmfkfefnJlh;flfhfkhkhkfkfmLg.fnilikhfhnfjinhmijgiikfjgnhehfheik"))) {
            return DH.SyncMtd.getOSVersionIntForFly() >= 24 ? cn.fly.tools.b.e.a(this.b).c() : cn.fly.tools.b.e.a(this.b).b();
        }
        return -1;
    }

    private boolean b(Object obj) {
        Object serviceState;
        if (obj != null && DH.SyncMtd.checkPermission(m.a("035fg;feflfmfkfefn2lhDflfhfkhkhkfkfmDgSfnilikhfhnfjinhmijgiikfjgnhehfheik")) && DH.SyncMtd.getOSVersionIntForFly() >= 26) {
            if (CSCenter.getInstance().isPhoneStateDataEnable()) {
                serviceState = ReflectHelper.invokeInstanceMethodNoThrow(obj, m.a("015Pgl4hkMgn(h+flfffkDehRgnVkfkh"), null, new Object[0]);
            } else {
                serviceState = CSCenter.getInstance().getServiceState();
            }
            if (serviceState != null && ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(serviceState, m.a("0106gl$hk'giflgn5kfkh"), 0, new Object[0])).intValue() == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean b(String str) {
        return m.a("004Igghnikgi").equalsIgnoreCase(str) | ((m.a("004Kgfhnjehf").equalsIgnoreCase(str) | m.a("004Zikhnkfik").equalsIgnoreCase(str)) | m.a("0043kfinilgn").equalsIgnoreCase(str));
    }

    private boolean a(int i5) {
        Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe("phone");
        if (systemServiceSafe == null) {
            return false;
        }
        if (a(systemServiceSafe) || b(systemServiceSafe)) {
            return true;
        }
        return b(i5);
    }

    private boolean a(Object obj) {
        Object serviceState;
        if (obj != null && DH.SyncMtd.checkPermission(m.a("035fg9feflfmfkfefn>lhJflfhfkhkhkfkfm@g;fnilikhfhnfjinhmijgiikfjgnhehfheik"))) {
            if (CSCenter.getInstance().isPhoneStateDataEnable()) {
                String manufacturerForFly = DH.SyncMtd.getManufacturerForFly();
                serviceState = null;
                if (!TextUtils.isEmpty(manufacturerForFly) && ((manufacturerForFly.contains(m.a("006jLfiEf0hiGhFfk")) || manufacturerForFly.contains(m.a("006JhmfiGf hiBh]fk")) || manufacturerForFly.contains(m.a("006:hmgmhfihikgg"))) && DH.SyncMtd.getOSVersionIntForFly() >= 29)) {
                    serviceState = ReflectHelper.invokeInstanceMethodNoThrow(obj, m.a("015Ogl4hkLgn2h6flfffkPehJgnCkfkh"), null, new Object[0]);
                }
            } else {
                serviceState = CSCenter.getInstance().getServiceState();
            }
            if (serviceState != null && ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(serviceState, m.a("016%gl'hk%hmhigi=hk$hifmflgjhege=lh"), 0, new Object[0])).intValue() == 20) {
                return true;
            }
        }
        return false;
    }

    private boolean a(String str) {
        return m.a("005)hmgninhfin").equalsIgnoreCase(str) | (((((((m.a("006=ikimhnijfjhj").equalsIgnoreCase(str) | m.a("006>ikimhnijfjhf").equalsIgnoreCase(str)) | m.a("005!hmgnhninhf").equalsIgnoreCase(str)) | m.a("0041hmgninhf").equalsIgnoreCase(str)) | m.a("005Qhmgngminhf").equalsIgnoreCase(str)) | m.a("004Dgmjehegn").equalsIgnoreCase(str)) | m.a("005'ikhmilinhn").equalsIgnoreCase(str)) | m.a("006-ikimhnijfjhl").equalsIgnoreCase(str));
    }
}
