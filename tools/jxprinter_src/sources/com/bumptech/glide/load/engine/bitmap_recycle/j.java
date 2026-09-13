package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements a {

    @VisibleForTesting
    static final int MAX_OVER_SIZE_MULTIPLE = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f2987a;
    public final i b;
    public final HashMap c;
    public final HashMap d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2988f;

    @VisibleForTesting
    public j() {
        this.f2987a = new g();
        this.b = new i();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = 4194304;
    }

    @Nullable
    private <T> T getArrayForKey(h hVar) {
        return (T) this.f2987a.get(hVar);
    }

    public final void a(int i5, Class cls) {
        NavigableMap navigableMapF = f(cls);
        Integer num = (Integer) navigableMapF.get(Integer.valueOf(i5));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapF.remove(Integer.valueOf(i5));
                return;
            } else {
                navigableMapF.put(Integer.valueOf(i5), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i5 + ", this: " + this);
    }

    public final void b(int i5) {
        while (this.f2988f > i5) {
            Object objRemoveLast = this.f2987a.removeLast();
            L0.q.checkNotNull(objRemoveLast);
            e eVarD = d(objRemoveLast.getClass());
            this.f2988f -= eVarD.b() * eVarD.a(objRemoveLast);
            a(eVarD.a(objRemoveLast), objRemoveLast.getClass());
            if (Log.isLoggable(eVarD.c(), 2)) {
                Log.v(eVarD.c(), "evicted: " + eVarD.a(objRemoveLast));
            }
        }
    }

    public final synchronized Object c(int i5, Class cls) {
        h hVar;
        int i6;
        try {
            Integer num = (Integer) f(cls).ceilingKey(Integer.valueOf(i5));
            if (num == null || ((i6 = this.f2988f) != 0 && this.e / i6 < 2 && num.intValue() > i5 * 8)) {
                i iVar = this.b;
                m mVarB = (m) iVar.f2982a.poll();
                if (mVarB == null) {
                    mVarB = iVar.b();
                }
                hVar = (h) mVarB;
                hVar.b = i5;
                hVar.c = cls;
            } else {
                i iVar2 = this.b;
                int iIntValue = num.intValue();
                m mVarB2 = (m) iVar2.f2982a.poll();
                if (mVarB2 == null) {
                    mVarB2 = iVar2.b();
                }
                hVar = (h) mVarB2;
                hVar.b = iIntValue;
                hVar.c = cls;
            }
        } catch (Throwable th) {
            throw th;
        }
        return e(hVar, cls);
    }

    public final e d(Class cls) {
        e eVar;
        HashMap map = this.d;
        e eVar2 = (e) map.get(cls);
        if (eVar2 != null) {
            return eVar2;
        }
        if (cls.equals(int[].class)) {
            eVar = new e(1);
        } else {
            if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: ".concat(cls.getSimpleName()));
            }
            eVar = new e(0);
        }
        map.put(cls, eVar);
        return eVar;
    }

    public final Object e(h hVar, Class cls) {
        e eVarD = d(cls);
        Object arrayForKey = getArrayForKey(hVar);
        if (arrayForKey != null) {
            this.f2988f -= eVarD.b() * eVarD.a(arrayForKey);
            a(eVarD.a(arrayForKey), cls);
        }
        if (arrayForKey != null) {
            return arrayForKey;
        }
        if (Log.isLoggable(eVarD.c(), 2)) {
            Log.v(eVarD.c(), "Allocated " + hVar.b + " bytes");
        }
        int i5 = hVar.b;
        switch (eVarD.f2983a) {
            case 0:
                return new byte[i5];
            default:
                return new int[i5];
        }
    }

    public final NavigableMap f(Class cls) {
        HashMap map = this.c;
        NavigableMap navigableMap = (NavigableMap) map.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        map.put(cls, treeMap);
        return treeMap;
    }

    public final synchronized void g(Object obj) {
        Class<?> cls = obj.getClass();
        e eVarD = d(cls);
        int iA = eVarD.a(obj);
        int iB = eVarD.b() * iA;
        if (iB <= this.e / 2) {
            i iVar = this.b;
            m mVarB = (m) iVar.f2982a.poll();
            if (mVarB == null) {
                mVarB = iVar.b();
            }
            h hVar = (h) mVarB;
            hVar.b = iA;
            hVar.c = cls;
            this.f2987a.a(hVar, obj);
            NavigableMap navigableMapF = f(cls);
            Integer num = (Integer) navigableMapF.get(Integer.valueOf(hVar.b));
            Integer numValueOf = Integer.valueOf(hVar.b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapF.put(numValueOf, Integer.valueOf(iIntValue));
            this.f2988f += iB;
            b(this.e);
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    @Deprecated
    public <T> void put(T t6, Class<T> cls) {
        g(t6);
    }

    public j(int i5) {
        this.f2987a = new g();
        this.b = new i();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = i5;
    }
}
