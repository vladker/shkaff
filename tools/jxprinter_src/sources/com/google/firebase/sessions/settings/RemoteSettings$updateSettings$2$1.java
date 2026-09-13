package com.google.firebase.sessions.settings;

import E3.g;
import F3.i;
import G3.b;
import G3.f;
import G3.m;
import O3.p;
import android.util.Log;
import com.google.firebase.sessions.FirebaseSessions;
import kotlin.jvm.internal.E;
import org.json.JSONException;
import org.json.JSONObject;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@f(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1", f = "RemoteSettings.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
public final class RemoteSettings$updateSettings$2$1 extends m implements p {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RemoteSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteSettings$updateSettings$2$1(RemoteSettings remoteSettings, g<? super RemoteSettings$updateSettings$2$1> gVar) {
        super(2, gVar);
        this.this$0 = remoteSettings;
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(this.this$0, gVar);
        remoteSettings$updateSettings$2$1.L$0 = obj;
        return remoteSettings$updateSettings$2$1;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Boolean bool;
        Double d;
        Integer num;
        Integer num2;
        Double d6;
        Boolean bool2;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            v.throwOnFailure(obj);
            JSONObject jSONObject = (JSONObject) this.L$0;
            Log.d(FirebaseSessions.TAG, "Fetched settings: " + jSONObject);
            Integer num3 = null;
            if (jSONObject.has("app_quality")) {
                Object obj2 = jSONObject.get("app_quality");
                E.d(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject jSONObject2 = (JSONObject) obj2;
                try {
                    bool2 = jSONObject2.has("sessions_enabled") ? (Boolean) jSONObject2.get("sessions_enabled") : null;
                    try {
                        d6 = jSONObject2.has("sampling_rate") ? (Double) jSONObject2.get("sampling_rate") : null;
                        try {
                            num2 = jSONObject2.has("session_timeout_seconds") ? (Integer) jSONObject2.get("session_timeout_seconds") : null;
                            try {
                                if (jSONObject2.has("cache_duration")) {
                                    num3 = (Integer) jSONObject2.get("cache_duration");
                                }
                            } catch (JSONException e) {
                                e = e;
                                b.boxInt(Log.e(FirebaseSessions.TAG, "Error parsing the configs remotely fetched: ", e));
                            }
                        } catch (JSONException e6) {
                            e = e6;
                            num2 = null;
                        }
                    } catch (JSONException e7) {
                        e = e7;
                        num2 = null;
                        d6 = null;
                    }
                } catch (JSONException e8) {
                    e = e8;
                    num2 = null;
                    d6 = null;
                    bool2 = null;
                }
                num = num2;
                d = d6;
                bool = bool2;
            } else {
                bool = null;
                d = null;
                num = null;
            }
            SettingsCache settingsCache = this.this$0.settingsCache;
            SessionConfigs sessionConfigs = new SessionConfigs(bool, d, num, b.boxInt(num3 != null ? num3.intValue() : RemoteSettings.Companion.getDefaultCacheDuration()), b.boxLong(this.this$0.timeProvider.currentTime().getSeconds()));
            this.label = 1;
            if (settingsCache.updateConfigs(sessionConfigs, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
        }
        return Q.INSTANCE;
    }

    @Override // O3.p
    public final Object invoke(JSONObject jSONObject, g<? super Q> gVar) {
        return ((RemoteSettings$updateSettings$2$1) create(jSONObject, gVar)).invokeSuspend(Q.INSTANCE);
    }
}
