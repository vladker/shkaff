package com.mob;

import com.mob.tools.network.NetCommunicator;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class MobCommunicator implements PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NetCommunicator f3610a;

    public static class NetworkError extends Exception implements PublicMemberKeeper {
        private static final long serialVersionUID = -8447657431687664787L;

        public NetworkError(String str) {
            super(str);
        }
    }

    public MobCommunicator(int i5, String str, String str2) {
        this.f3610a = new NetCommunicator(i5, str, str2);
    }

    public static HashMap<String, String> getCommonDefaultHeaders() {
        return NetCommunicator.getCommonDefaultHeaders();
    }

    public <T> void request(HashMap<String, Object> map, String str, boolean z6, Callback<T> callback) {
        request(true, null, map, str, z6, callback);
    }

    public <T> T requestSynchronized(HashMap<String, Object> map, String str, boolean z6) {
        return (T) requestSynchronized((HashMap<String, String>) null, map, str, z6);
    }

    public void setThreadPool(ThreadPoolExecutor threadPoolExecutor) {
        this.f3610a.setThreadPool(threadPoolExecutor);
    }

    public <T> void request(HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z6, Callback<T> callback) {
        request(true, map, map2, str, z6, callback);
    }

    public <T> T requestSynchronized(HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z6) {
        return (T) requestSynchronized(true, map, map2, str, z6);
    }

    public <T> void request(boolean z6, HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z7, final Callback<T> callback) {
        if (callback == null) {
            this.f3610a.request(z6, map, map2, str, z7, null);
        } else {
            this.f3610a.request(z6, map, map2, str, z7, new NetCommunicator.Callback<T>() { // from class: com.mob.MobCommunicator.1
                @Override // com.mob.tools.network.NetCommunicator.Callback
                public void onResultError(Throwable th) {
                    callback.onResultError(th);
                }

                @Override // com.mob.tools.network.NetCommunicator.Callback
                public void onResultOk(T t6) {
                    callback.onResultOk(t6);
                }
            });
        }
    }

    public <T> T requestSynchronized(String str, String str2, boolean z6) {
        return (T) requestSynchronized((HashMap<String, String>) null, str, str2, z6);
    }

    public <T> T requestSynchronized(HashMap<String, String> map, String str, String str2, boolean z6) {
        return (T) requestSynchronized(true, map, str, str2, z6);
    }

    public <T> T requestSynchronized(boolean z6, HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z7) {
        return (T) this.f3610a.requestSynchronized(z6, map, map2, str, z7);
    }

    public <T> T requestSynchronized(boolean z6, HashMap<String, String> map, String str, String str2, boolean z7) {
        return (T) this.f3610a.requestSynchronized(z6, map, str, str2, z7);
    }

    public static class Callback<T> implements PublicMemberKeeper {
        public void onResultError(Throwable th) {
        }

        public void onResultOk(T t6) {
        }
    }
}
