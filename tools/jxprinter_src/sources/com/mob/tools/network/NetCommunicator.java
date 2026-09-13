package com.mob.tools.network;

import com.mob.commons.MobProduct;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.HashonHelper;
import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes3.dex */
public final class NetCommunicator implements PublicMemberKeeper {
    public static final String KEY_DUID = "duid";
    public static final String KEY_DUID_PREVIOUS = "duidPrevious";
    public static final String KEY_IS_MODIFIED = "isModified";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cn.fly.tools.network.NetCommunicator f3653a;

    public static class NetworkError extends Exception implements PublicMemberKeeper {
        private static final long serialVersionUID = -8447657431687664787L;

        public NetworkError(String str) {
            super(str);
        }
    }

    public static class a<T> extends cn.fly.tools.network.NetCommunicator.Callback<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Callback f3654a;

        public a(Callback callback) {
            this.f3654a = callback;
        }

        @Override // cn.fly.tools.network.NetCommunicator.Callback
        public void onResultError(Throwable th) {
            if (th instanceof cn.fly.tools.network.NetCommunicator.NetworkError) {
                this.f3654a.onResultError(new NetworkError(th.getMessage()));
            } else {
                this.f3654a.onResultError(th);
            }
        }

        @Override // cn.fly.tools.network.NetCommunicator.Callback
        public void onResultOk(T t6) {
            this.f3654a.onResultOk(t6);
        }
    }

    public NetCommunicator(int i5, String str, String str2) {
        this.f3653a = new cn.fly.tools.network.NetCommunicator(i5, str, str2);
    }

    private String a(HashMap<String, Object> map) {
        if (map == null) {
            return "{}";
        }
        String strFromHashMap = HashonHelper.fromHashMap(map);
        return strFromHashMap.length() == 0 ? "{}" : strFromHashMap;
    }

    public static String checkHttpRequestUrl(String str) {
        return cn.fly.tools.network.NetCommunicator.checkHRU(str);
    }

    public static String dynamicModifyUrl(String str) {
        return cn.fly.tools.network.NetCommunicator.dynaMU(str);
    }

    public static HashMap<String, String> getCommonDefaultHeaders() {
        return cn.fly.tools.network.NetCommunicator.getCommonDefaultHeaders();
    }

    public static synchronized String getDUID(MobProduct mobProduct) {
        return cn.fly.tools.network.NetCommunicator.getDUID(mobProduct);
    }

    public static synchronized HashMap<String, Object> getDUIDWithModifyInfo(MobProduct mobProduct) {
        return cn.fly.tools.network.NetCommunicator.getDUIDWithModifyInfo(mobProduct);
    }

    public void addTcpIntercept(String str) {
        try {
            this.f3653a.addTcpIntercept(str);
        } catch (Throwable unused) {
        }
    }

    public void removeTcpIntercept(String str) {
        try {
            this.f3653a.removeTcpIntercept(str);
        } catch (Throwable unused) {
        }
    }

    public <T> void request(HashMap<String, Object> map, String str, boolean z6, Callback<T> callback) {
        request(true, null, map, str, z6, callback);
    }

    public <T> T requestSynchronized(HashMap<String, Object> map, String str, boolean z6) throws NetworkError {
        try {
            return (T) this.f3653a.requestSynchronized((HashMap<String, String>) null, map, str, z6);
        } catch (cn.fly.tools.network.NetCommunicator.NetworkError e) {
            throw new NetworkError(e.getMessage());
        }
    }

    public String requestSynchronizedGet(String str, HashMap<String, Object> map, HashMap<String, String> map2) {
        return this.f3653a.requestSynchronizedGet(str, map, map2);
    }

    public <T> T requestWithoutEncode(boolean z6, HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z7) throws NetworkError {
        try {
            return (T) this.f3653a.requestSynchronized(z6, map, map2, str, z7);
        } catch (cn.fly.tools.network.NetCommunicator.NetworkError e) {
            throw new NetworkError(e.getMessage());
        }
    }

    public void setThreadPool(ThreadPoolExecutor threadPoolExecutor) {
        this.f3653a.setThreadPool(threadPoolExecutor);
    }

    public <T> void request(HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z6, Callback<T> callback) {
        request(true, map, map2, str, z6, callback);
    }

    public NetCommunicator(int i5, String str, String str2, NetworkHelper.NetworkTimeOut networkTimeOut) {
        this.f3653a = new cn.fly.tools.network.NetCommunicator(i5, str, str2, NetworkHelper.getTimeoutWrapper(networkTimeOut));
    }

    public <T> void request(boolean z6, HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z7, Callback<T> callback) {
        this.f3653a.request(z6, map, map2, str, z7, new a(callback));
    }

    public <T> T requestSynchronized(HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z6) throws NetworkError {
        try {
            return (T) this.f3653a.requestSynchronized(true, map, map2, str, z6);
        } catch (cn.fly.tools.network.NetCommunicator.NetworkError e) {
            throw new NetworkError(e.getMessage());
        }
    }

    public <T> T requestSynchronized(String str, String str2, boolean z6) throws NetworkError {
        try {
            return (T) this.f3653a.requestSynchronized((HashMap<String, String>) null, str, str2, z6);
        } catch (cn.fly.tools.network.NetCommunicator.NetworkError e) {
            throw new NetworkError(e.getMessage());
        }
    }

    public <T> T requestSynchronized(HashMap<String, String> map, String str, String str2, boolean z6) {
        return (T) requestSynchronized(true, map, str, str2, z6);
    }

    public <T> T requestSynchronized(boolean z6, HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z7) throws NetworkError {
        try {
            return (T) this.f3653a.requestSynchronized(z6, map, a(map2), str, z7);
        } catch (cn.fly.tools.network.NetCommunicator.NetworkError e) {
            throw new NetworkError(e.getMessage());
        }
    }

    public <T> T requestSynchronized(boolean z6, HashMap<String, String> map, String str, String str2, boolean z7) throws NetworkError {
        try {
            return (T) this.f3653a.requestSynchronized(z6, map, str, str2, z7);
        } catch (cn.fly.tools.network.NetCommunicator.NetworkError e) {
            throw new NetworkError(e.getMessage());
        }
    }

    public static class Callback<T> implements PublicMemberKeeper {
        public void onResultError(Throwable th) {
        }

        public void onResultOk(T t6) {
        }
    }
}
