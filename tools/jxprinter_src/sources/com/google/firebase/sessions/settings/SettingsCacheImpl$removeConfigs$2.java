package com.google.firebase.sessions.settings;

import E3.g;
import F3.i;
import G3.f;
import G3.m;
import O3.p;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@f(c = "com.google.firebase.sessions.settings.SettingsCacheImpl$removeConfigs$2", f = "SettingsCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SettingsCacheImpl$removeConfigs$2 extends m implements p {
    int label;

    public SettingsCacheImpl$removeConfigs$2(g<? super SettingsCacheImpl$removeConfigs$2> gVar) {
        super(2, gVar);
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        return new SettingsCacheImpl$removeConfigs$2(gVar);
    }

    @Override // O3.p
    public final Object invoke(SessionConfigs sessionConfigs, g<? super SessionConfigs> gVar) {
        return ((SettingsCacheImpl$removeConfigs$2) create(sessionConfigs, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        i.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.throwOnFailure(obj);
        return SessionConfigsSerializer.INSTANCE.getDefaultValue();
    }
}
