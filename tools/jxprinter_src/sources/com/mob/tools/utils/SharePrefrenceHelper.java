package com.mob.tools.utils;

import android.content.Context;
import android.os.Parcelable;
import cn.fly.tools.utils.FlyPersistence;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SharePrefrenceHelper implements PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cn.fly.tools.utils.SharePrefrenceHelper f3684a;

    public SharePrefrenceHelper(Context context) {
        this.f3684a = new cn.fly.tools.utils.SharePrefrenceHelper(context);
    }

    public static boolean isMobSpFileExist(Context context, String str, int i5) {
        return cn.fly.tools.utils.SharePrefrenceHelper.isMbSpFileExist(context, str, i5);
    }

    public static boolean isMpfFileExist(Context context, String str, int i5) {
        return cn.fly.tools.utils.SharePrefrenceHelper.isMpfFileExist(context, str, i5);
    }

    public void clear() {
        this.f3684a.clear();
    }

    public Object get(String str) {
        return get(str, null);
    }

    @Deprecated
    public HashMap<String, Object> getAll() {
        return this.f3684a.getAll();
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBooleanThrowable(String str) {
        return getBooleanThrowable(str, false);
    }

    public double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    public double getDoubleThrowable(String str) {
        return getDoubleThrowable(str, 0.0d);
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public int getIntThrowable(String str) {
        return getIntThrowable(str, 0);
    }

    public long getLong(String str) {
        return getLong(str, 0L);
    }

    public long getLongThrowable(String str) {
        return getLongThrowable(str, 0L);
    }

    @Deprecated
    public Object getObj(String str, Object obj) {
        return this.f3684a.getObj(str, obj);
    }

    public <T extends Parcelable> T getParcel(String str, Class<T> cls) {
        return (T) getParcel(str, cls, null);
    }

    public <T extends Parcelable> T[] getParcelArray(String str, Class<T> cls) {
        return (T[]) getParcelArray(str, cls, null);
    }

    public <T extends Parcelable> T[] getParcelArrayThrowable(String str, Class<T> cls) {
        return (T[]) getParcelArrayThrowable(str, cls, null);
    }

    public <T extends Parcelable> List<T> getParcelList(String str, Class<T> cls) {
        return getParcelList(str, cls, null);
    }

    public <T extends Parcelable> List<T> getParcelListThrowable(String str, Class<T> cls) {
        return getParcelListThrowable(str, cls, null);
    }

    public <T extends Parcelable> Map<String, T> getParcelMap(String str, Class<T> cls) {
        return getParcelMap(str, cls, null);
    }

    public <T extends Parcelable> Map<String, T> getParcelMapThrowable(String str, Class<T> cls) {
        return getParcelMapThrowable(str, cls, null);
    }

    public <T extends Parcelable> T getParcelThrowable(String str, Class<T> cls) {
        return (T) getParcelThrowable(str, cls, null);
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public String getStringThrowable(String str) throws MobPersistence.NoValidDataException {
        try {
            return this.f3684a.getStringThrowable(str, "");
        } catch (FlyPersistence.NoValidDataException unused) {
            throw new MobPersistence.NoValidDataException();
        }
    }

    public Object getThrowable(String str) {
        return getThrowable(str, null);
    }

    public void open(String str) {
        open(str, 0);
    }

    public void put(String str, Object obj) {
        put(str, obj, 0L);
    }

    @Deprecated
    public void putAll(HashMap<String, Object> map) {
        this.f3684a.putAll(map);
    }

    public void putBoolean(String str, Boolean bool) {
        putBoolean(str, bool, 0L);
    }

    public void putDouble(String str, Double d) {
        putDouble(str, d, 0L);
    }

    public void putInt(String str, Integer num) {
        putInt(str, num, 0L);
    }

    public void putLong(String str, Long l6) {
        putLong(str, l6, 0L);
    }

    @Deprecated
    public void putObj(String str, Object obj) {
        this.f3684a.putObj(str, obj);
    }

    public void putParcel(String str, Parcelable parcelable) {
        putParcel(str, parcelable, 0L);
    }

    public <T extends Parcelable> void putParcelArray(String str, T[] tArr) {
        putParcelArray(str, tArr, 0L);
    }

    public <T extends Parcelable> void putParcelList(String str, List<T> list) {
        putParcelList(str, list, 0L);
    }

    public <T extends Parcelable> void putParcelMap(String str, Map<String, T> map) {
        putParcelMap(str, map, 0L);
    }

    public void putString(String str, String str2) {
        putString(str, str2, 0L);
    }

    public void remove(String str) {
        this.f3684a.remove(str);
    }

    public Object get(String str, Object obj) {
        try {
            return getThrowable(str, obj);
        } catch (MobPersistence.NoValidDataException unused) {
            return obj;
        }
    }

    public boolean getBoolean(String str, boolean z6) {
        return this.f3684a.getBoolean(str, z6);
    }

    public boolean getBooleanThrowable(String str, boolean z6) throws MobPersistence.NoValidDataException {
        try {
            return this.f3684a.getBooleanThrowable(str, z6);
        } catch (FlyPersistence.NoValidDataException unused) {
            throw new MobPersistence.NoValidDataException();
        }
    }

    public double getDouble(String str, double d) {
        return this.f3684a.getDouble(str, d);
    }

    public double getDoubleThrowable(String str, double d) throws MobPersistence.NoValidDataException {
        try {
            return this.f3684a.getDoubleThrowable(str, d);
        } catch (FlyPersistence.NoValidDataException unused) {
            throw new MobPersistence.NoValidDataException();
        }
    }

    public int getInt(String str, int i5) {
        return this.f3684a.getInt(str, i5);
    }

    public int getIntThrowable(String str, int i5) throws MobPersistence.NoValidDataException {
        try {
            return this.f3684a.getIntThrowable(str, i5);
        } catch (FlyPersistence.NoValidDataException unused) {
            throw new MobPersistence.NoValidDataException();
        }
    }

    public long getLong(String str, long j6) {
        return this.f3684a.getLong(str, j6);
    }

    public long getLongThrowable(String str, long j6) throws MobPersistence.NoValidDataException {
        try {
            return this.f3684a.getLongThrowable(str, j6);
        } catch (FlyPersistence.NoValidDataException unused) {
            throw new MobPersistence.NoValidDataException();
        }
    }

    public <T extends Parcelable> T getParcel(String str, Class<T> cls, T t6) {
        return (T) this.f3684a.getParcel(str, cls, t6);
    }

    public <T extends Parcelable> T[] getParcelArray(String str, Class<T> cls, T[] tArr) {
        return (T[]) this.f3684a.getParcelArray(str, cls, tArr);
    }

    public <T extends Parcelable> T[] getParcelArrayThrowable(String str, Class<T> cls, T[] tArr) throws MobPersistence.NoValidDataException {
        try {
            return (T[]) this.f3684a.getParcelArrayThrowable(str, cls, tArr);
        } catch (FlyPersistence.NoValidDataException unused) {
            throw new MobPersistence.NoValidDataException();
        }
    }

    public <T extends Parcelable> List<T> getParcelList(String str, Class<T> cls, List<T> list) {
        return this.f3684a.getParcelList(str, cls, list);
    }

    public <T extends Parcelable> List<T> getParcelListThrowable(String str, Class<T> cls, List<T> list) throws MobPersistence.NoValidDataException {
        try {
            return this.f3684a.getParcelListThrowable(str, cls, list);
        } catch (FlyPersistence.NoValidDataException unused) {
            throw new MobPersistence.NoValidDataException();
        }
    }

    public <T extends Parcelable> Map<String, T> getParcelMap(String str, Class<T> cls, Map<String, T> map) {
        try {
            return getParcelMapThrowable(str, cls, map);
        } catch (MobPersistence.NoValidDataException unused) {
            return map;
        }
    }

    public <T extends Parcelable> Map<String, T> getParcelMapThrowable(String str, Class<T> cls, Map<String, T> map) throws MobPersistence.NoValidDataException {
        try {
            return this.f3684a.getParcelMapThrowable(str, cls, map);
        } catch (FlyPersistence.NoValidDataException unused) {
            throw new MobPersistence.NoValidDataException();
        }
    }

    public <T> T getParcelThrowable(String str, Class<T> cls, T t6) throws MobPersistence.NoValidDataException {
        try {
            return (T) this.f3684a.getParcelThrowable(str, cls, t6);
        } catch (FlyPersistence.NoValidDataException unused) {
            throw new MobPersistence.NoValidDataException();
        }
    }

    public String getString(String str, String str2) {
        return this.f3684a.getString(str, str2);
    }

    public Object getThrowable(String str, Object obj) throws MobPersistence.NoValidDataException {
        try {
            return this.f3684a.getThrowable(str, obj);
        } catch (FlyPersistence.NoValidDataException unused) {
            throw new MobPersistence.NoValidDataException();
        }
    }

    public void open(String str, int i5) {
        open(str, i5, null);
    }

    public void put(String str, Object obj, long j6) {
        this.f3684a.put(str, obj, j6);
    }

    public void putBoolean(String str, Boolean bool, long j6) {
        this.f3684a.putBoolean(str, bool, j6);
    }

    public void putDouble(String str, Double d, long j6) {
        this.f3684a.putDouble(str, d, j6);
    }

    public void putInt(String str, Integer num, long j6) {
        this.f3684a.putInt(str, num, j6);
    }

    public void putLong(String str, Long l6, long j6) {
        this.f3684a.putLong(str, l6, j6);
    }

    public void putParcel(String str, Parcelable parcelable, long j6) {
        this.f3684a.putParcel(str, parcelable, j6);
    }

    public <T extends Parcelable> void putParcelArray(String str, T[] tArr, long j6) {
        this.f3684a.putParcelArray(str, tArr, j6);
    }

    public <T extends Parcelable> void putParcelList(String str, List<T> list, long j6) {
        this.f3684a.putParcelList(str, list, j6);
    }

    public <T extends Parcelable> void putParcelMap(String str, Map<String, T> map, long j6) {
        this.f3684a.putParcelMap(str, map, j6);
    }

    public void putString(String str, String str2, long j6) {
        this.f3684a.putString(str, str2, j6);
    }

    public String getStringThrowable(String str, String str2) throws MobPersistence.NoValidDataException {
        try {
            return this.f3684a.getStringThrowable(str, str2);
        } catch (FlyPersistence.NoValidDataException unused) {
            throw new MobPersistence.NoValidDataException();
        }
    }

    public void open(String str, int i5, String str2) {
        this.f3684a.open(str, i5, str2);
    }
}
