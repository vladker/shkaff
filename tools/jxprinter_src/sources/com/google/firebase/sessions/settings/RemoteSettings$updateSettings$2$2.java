package com.google.firebase.sessions.settings;

import E3.g;
import F3.i;
import G3.f;
import G3.m;
import O3.p;
import android.util.Log;
import com.google.firebase.sessions.FirebaseSessions;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@f(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2", f = "RemoteSettings.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RemoteSettings$updateSettings$2$2 extends m implements p {
    /* synthetic */ Object L$0;
    int label;

    public RemoteSettings$updateSettings$2$2(g<? super RemoteSettings$updateSettings$2$2> gVar) {
        super(2, gVar);
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        RemoteSettings$updateSettings$2$2 remoteSettings$updateSettings$2$2 = new RemoteSettings$updateSettings$2$2(gVar);
        remoteSettings$updateSettings$2$2.L$0 = obj;
        return remoteSettings$updateSettings$2$2;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        i.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.throwOnFailure(obj);
        Log.e(FirebaseSessions.TAG, "Error failed to fetch the remote configs: " + ((String) this.L$0));
        return Q.INSTANCE;
    }

    @Override // O3.p
    public final Object invoke(String str, g<? super Q> gVar) {
        return ((RemoteSettings$updateSettings$2$2) create(str, gVar)).invokeSuspend(Q.INSTANCE);
    }
}
