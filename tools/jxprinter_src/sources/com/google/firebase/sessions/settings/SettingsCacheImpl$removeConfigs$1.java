package com.google.firebase.sessions.settings;

import E3.g;
import G3.d;
import G3.f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@f(c = "com.google.firebase.sessions.settings.SettingsCacheImpl", f = "SettingsCache.kt", i = {}, l = {107}, m = "removeConfigs$com_google_firebase_firebase_sessions", n = {}, s = {})
public final class SettingsCacheImpl$removeConfigs$1 extends d {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingsCacheImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsCacheImpl$removeConfigs$1(SettingsCacheImpl settingsCacheImpl, g<? super SettingsCacheImpl$removeConfigs$1> gVar) {
        super(gVar);
        this.this$0 = settingsCacheImpl;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.removeConfigs$com_google_firebase_firebase_sessions(this);
    }
}
