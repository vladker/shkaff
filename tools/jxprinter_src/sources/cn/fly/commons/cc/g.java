package cn.fly.commons.cc;

import cn.fly.FlySDK;
import cn.fly.tools.utils.SharePrefrenceHelper;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharePrefrenceHelper f1372a;

    public g(String str, int i5) {
        SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(FlySDK.getContext());
        this.f1372a = sharePrefrenceHelper;
        sharePrefrenceHelper.open(str, i5);
    }

    public void a(String str, long j6) {
        this.f1372a.putLong(str, Long.valueOf(j6));
    }

    public long b(String str, long j6) {
        return this.f1372a.getLong(str, j6);
    }

    public void a(String str, int i5) {
        this.f1372a.putInt(str, Integer.valueOf(i5));
    }

    public int b(String str, int i5) {
        return this.f1372a.getInt(str, i5);
    }

    public void a(String str, boolean z6) {
        this.f1372a.putBoolean(str, Boolean.valueOf(z6));
    }

    public boolean b(String str, boolean z6) {
        return this.f1372a.getBoolean(str, z6);
    }

    public void a(String str, String str2) {
        if (str2 == null) {
            this.f1372a.remove(str);
        } else {
            this.f1372a.putString(str, str2);
        }
    }

    public String b(String str, String str2) {
        return this.f1372a.getString(str, str2);
    }

    public void a(String str, Object obj) {
        this.f1372a.put(str, obj);
    }

    public Object a(String str) {
        return this.f1372a.get(str);
    }

    public void a() {
        this.f1372a.clear();
    }
}
