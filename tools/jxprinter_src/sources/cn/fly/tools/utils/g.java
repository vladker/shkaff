package cn.fly.tools.utils;

import android.os.Parcelable;
import cn.fly.FlySDK;
import cn.fly.commons.n;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile g f1988a;
    private SharePrefrenceHelper b;

    private g() {
        if (this.b == null) {
            SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(FlySDK.getContext());
            this.b = sharePrefrenceHelper;
            sharePrefrenceHelper.a("dhp", 1);
            this.b.open("dhp", 1, n.a("016bAddJa=bacdMdQdffhfbgifffdfchdfjfg"));
        }
    }

    public static g a() {
        if (f1988a == null) {
            synchronized (g.class) {
                try {
                    if (f1988a == null) {
                        f1988a = new g();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1988a;
    }

    public static String b() {
        return "dhp_1";
    }

    public static boolean c() {
        if (FlySDK.getContext() != null) {
            return SharePrefrenceHelper.isMpfFileExist(FlySDK.getContext(), "dhp", 1);
        }
        return false;
    }

    public long d(String str) {
        return this.b.getLong(str);
    }

    public long e(String str) {
        return this.b.getLongThrowable(str);
    }

    public int f(String str) {
        return this.b.getInt(str);
    }

    public double g(String str) {
        return this.b.getDoubleThrowable(str);
    }

    public Object h(String str) {
        return this.b.getThrowable(str);
    }

    public void i(String str) {
        this.b.remove(str);
    }

    public String b(String str, String str2) {
        return this.b.getString(str, str2);
    }

    public <T extends Parcelable> T[] d(String str, Class<T> cls) {
        return (T[]) this.b.getParcelArrayThrowable(str, cls);
    }

    public String b(String str) {
        return this.b.getStringThrowable(str);
    }

    public String c(String str, String str2) {
        return this.b.getStringThrowable(str, str2);
    }

    public long b(String str, long j6) {
        return this.b.getLongThrowable(str, j6);
    }

    public boolean c(String str) {
        return this.b.getBooleanThrowable(str);
    }

    public int b(String str, int i5) {
        return this.b.getIntThrowable(str, i5);
    }

    public <T extends Parcelable> List<T> c(String str, Class<T> cls) {
        return this.b.getParcelListThrowable(str, cls);
    }

    public <T extends Parcelable> Map<String, T> b(String str, Class<T> cls) {
        return this.b.getParcelMapThrowable(str, cls);
    }

    public void a(String str, String str2) {
        this.b.putString(str, str2);
    }

    public Object b(String str, Object obj) {
        return this.b.getThrowable(str, obj);
    }

    public void a(String str, String str2, long j6) {
        this.b.putString(str, str2, j6);
    }

    public String a(String str) {
        return this.b.getString(str);
    }

    public void a(String str, Boolean bool) {
        this.b.putBoolean(str, bool);
    }

    public void a(String str, Boolean bool, long j6) {
        this.b.putBoolean(str, bool, j6);
    }

    public boolean a(String str, boolean z6) {
        return this.b.getBooleanThrowable(str, z6);
    }

    public void a(String str, Long l6) {
        this.b.putLong(str, l6);
    }

    public void a(String str, Long l6, long j6) {
        this.b.putLong(str, l6, j6);
    }

    public long a(String str, long j6) {
        return this.b.getLong(str, j6);
    }

    public void a(String str, Integer num) {
        this.b.putInt(str, num);
    }

    public void a(String str, Integer num, long j6) {
        this.b.putInt(str, num, j6);
    }

    public int a(String str, int i5) {
        return this.b.getInt(str, i5);
    }

    public void a(String str, Double d) {
        this.b.putDouble(str, d);
    }

    public void a(String str, Double d, long j6) {
        this.b.putDouble(str, d, j6);
    }

    public double a(String str, double d) {
        return this.b.getDoubleThrowable(str, d);
    }

    public void a(String str, Parcelable parcelable) {
        this.b.putParcel(str, parcelable);
    }

    public void a(String str, Parcelable parcelable, long j6) {
        this.b.putParcel(str, parcelable, j6);
    }

    public <T extends Parcelable> T a(String str, Class<T> cls) {
        return (T) this.b.getParcelThrowable(str, cls);
    }

    public <T> T a(String str, Class<T> cls, T t6) {
        return (T) this.b.getParcelThrowable(str, cls, t6);
    }

    public <T extends Parcelable> void a(String str, Map<String, T> map) {
        this.b.putParcelMap(str, map);
    }

    public <T extends Parcelable> void a(String str, Map<String, T> map, long j6) {
        this.b.putParcelMap(str, map, j6);
    }

    public <T extends Parcelable> Map<String, T> a(String str, Class<T> cls, Map<String, T> map) {
        return this.b.getParcelMapThrowable(str, cls, map);
    }

    public <T extends Parcelable> void a(String str, List<T> list) {
        this.b.putParcelList(str, list);
    }

    public <T extends Parcelable> void a(String str, List<T> list, long j6) {
        this.b.putParcelList(str, list, j6);
    }

    public <T extends Parcelable> List<T> a(String str, Class<T> cls, List<T> list) {
        return this.b.getParcelListThrowable(str, cls, list);
    }

    public <T extends Parcelable> void a(String str, T[] tArr) {
        this.b.putParcelArray(str, tArr);
    }

    public <T extends Parcelable> void a(String str, T[] tArr, long j6) {
        this.b.putParcelArray(str, tArr, j6);
    }

    public <T extends Parcelable> T[] a(String str, Class<T> cls, T[] tArr) {
        return (T[]) this.b.getParcelArrayThrowable(str, cls, tArr);
    }

    public void a(String str, Object obj) {
        this.b.put(str, obj);
    }

    public void a(String str, Object obj, long j6) {
        this.b.put(str, obj, j6);
    }
}
