package cn.fly;

import cn.fly.tools.proguard.PublicMemberKeeper;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RHolder implements PublicMemberKeeper {
    private static volatile RHolder d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f1197a;
    protected int b;
    protected int c;

    public static RHolder getInstance() {
        if (d == null) {
            synchronized (RHolder.class) {
                try {
                    if (d == null) {
                        d = new RHolder();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public int getActivityThemeId() {
        return this.f1197a;
    }

    public int getDialogLayoutId() {
        return this.b;
    }

    public int getDialogThemeId() {
        return this.c;
    }

    public RHolder setActivityThemeId(int i5) {
        this.f1197a = i5;
        return d;
    }

    public RHolder setDialogLayoutId(int i5) {
        this.b = i5;
        return d;
    }

    public RHolder setDialogThemeId(int i5) {
        this.c = i5;
        return d;
    }
}
