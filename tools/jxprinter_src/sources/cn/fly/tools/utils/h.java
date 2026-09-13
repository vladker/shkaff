package cn.fly.tools.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public class h {
    private static volatile h c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f1989a;
    private final SharedPreferences.Editor b;

    public h(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        this.f1989a = sharedPreferences;
        this.b = sharedPreferences.edit();
    }

    public static h a(Context context) {
        if (c == null) {
            synchronized (h.class) {
                try {
                    if (c == null) {
                        c = new h(context, "common_nsp");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    public String b(String str, String str2) {
        return this.f1989a.getString(str, str2);
    }

    public int b(String str, int i5) {
        return this.f1989a.getInt(str, i5);
    }

    public long b(String str, long j6) {
        return this.f1989a.getLong(str, j6);
    }

    public double b(String str, double d) {
        long j6 = this.f1989a.getLong(str, -1L);
        return j6 != -1 ? Double.longBitsToDouble(j6) : d;
    }

    public void b() {
        this.b.clear().apply();
    }

    public void a(String str, String str2) {
        this.b.putString(str, str2).apply();
    }

    public void a(String str, int i5) {
        this.b.putInt(str, i5).apply();
    }

    public void a(String str, long j6) {
        this.b.putLong(str, j6).apply();
    }

    public void a(String str, double d) {
        this.b.putLong(str, Double.doubleToRawLongBits(d)).apply();
    }

    public boolean a() {
        return this.b.commit();
    }

    public void a(String str) {
        this.b.remove(str).apply();
    }
}
