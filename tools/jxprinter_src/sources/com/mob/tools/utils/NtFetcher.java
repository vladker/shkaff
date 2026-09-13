package com.mob.tools.utils;

import android.content.Context;
import com.mob.tools.proguard.PublicMemberKeeper;

/* JADX INFO: loaded from: classes3.dex */
public class NtFetcher implements PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static NtFetcher f3678a;
    private final Context b;

    public NtFetcher(Context context) {
        this.b = context;
    }

    public static NtFetcher getInstance(Context context) {
        if (f3678a == null) {
            synchronized (NtFetcher.class) {
                try {
                    if (f3678a == null) {
                        f3678a = new NtFetcher(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f3678a;
    }

    public int getDtNtType() {
        return cn.fly.tools.utils.NtFetcher.getInstance(this.b).getDtNtType();
    }

    public String getNetworkTypeDesensitized() {
        return cn.fly.tools.utils.NtFetcher.getInstance(this.b).getNetworkTypeDesensitized();
    }

    public String getNtType() {
        return cn.fly.tools.utils.NtFetcher.getInstance(this.b).getNtType(false);
    }

    public void recycle() {
        cn.fly.tools.utils.NtFetcher.getInstance(this.b).recycle();
    }
}
