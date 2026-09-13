package com.google.firebase.sessions.settings;

import E3.g;
import F3.i;
import G3.f;
import G3.m;
import O3.p;
import p007a4.M;
import p023d4.AbstractC0618q;
import p023d4.InterfaceC0612o;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@f(c = "com.google.firebase.sessions.settings.SettingsCacheImpl$sessionConfigs$1", f = "SettingsCache.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
public final class SettingsCacheImpl$sessionConfigs$1 extends m implements p {
    int label;
    final /* synthetic */ SettingsCacheImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsCacheImpl$sessionConfigs$1(SettingsCacheImpl settingsCacheImpl, g<? super SettingsCacheImpl$sessionConfigs$1> gVar) {
        super(2, gVar);
        this.this$0 = settingsCacheImpl;
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        return new SettingsCacheImpl$sessionConfigs$1(this.this$0, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, g<? super SessionConfigs> gVar) {
        return ((SettingsCacheImpl$sessionConfigs$1) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 != 0) {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return obj;
        }
        v.throwOnFailure(obj);
        InterfaceC0612o data = this.this$0.sessionConfigsDataStore.getData();
        this.label = 1;
        Object objFirst = AbstractC0618q.first(data, this);
        return objFirst == coroutine_suspended ? coroutine_suspended : objFirst;
    }
}
