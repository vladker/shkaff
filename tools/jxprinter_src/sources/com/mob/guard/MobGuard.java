package com.mob.guard;

import android.content.Context;
import com.mob.mcl.MobMCL;
import com.mob.mgs.MobMGS;
import com.mob.mgs.impl.a;
import com.mob.tools.proguard.PublicMemberKeeper;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class MobGuard implements PublicMemberKeeper {
    public static String getGuardId() {
        try {
            return MobMCL.getSuid();
        } catch (Throwable th) {
            a.a().a(th);
            return null;
        }
    }

    public static void setOnAppActiveListener(final OnAppActiveListener onAppActiveListener) {
        if (onAppActiveListener != null) {
            MobMGS.setOnAppActiveListener(new com.mob.mgs.OnAppActiveListener() { // from class: com.mob.guard.MobGuard.2
                public void onAppActive(Context context, int i5) {
                    OnAppActiveListener onAppActiveListener2 = onAppActiveListener;
                    if (onAppActiveListener2 != null) {
                        onAppActiveListener2.onAppActive(context, i5);
                    }
                }
            });
        }
    }

    public static void getGuardId(final OnIdChangeListener onIdChangeListener) {
        if (onIdChangeListener != null) {
            MobMCL.getSuid(new com.mob.mgs.OnIdChangeListener() { // from class: com.mob.guard.MobGuard.1
                @Override // com.mob.mgs.OnIdChangeListener
                public void onChanged(String str, String str2) {
                    OnIdChangeListener onIdChangeListener2 = onIdChangeListener;
                    if (onIdChangeListener2 != null) {
                        onIdChangeListener2.onChanged(str, str2);
                    }
                }
            });
        }
    }
}
