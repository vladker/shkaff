package com.mob;

import android.app.Application;
import cn.fly.FlySDK;
import com.mob.tools.proguard.ProtectedMemberKeeper;

/* JADX INFO: loaded from: classes3.dex */
public class MobApplication extends Application implements ProtectedMemberKeeper {
    public String getAppSecret() {
        return null;
    }

    public String getAppkey() {
        return null;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        FlySDK.init(this, getAppkey(), getAppSecret());
    }
}
