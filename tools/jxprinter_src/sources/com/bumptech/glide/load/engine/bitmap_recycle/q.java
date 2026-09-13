package com.bumptech.glide.load.engine.bitmap_recycle;

import L0.s;
import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class q implements l {
    public static final Bitmap.Config[] d;
    public static final Bitmap.Config[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Bitmap.Config[] f2998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Bitmap.Config[] f2999g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Bitmap.Config[] f3000h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f3001a = new p();
    public final g b = new g();
    public final HashMap c = new HashMap();

    static {
        Bitmap.Config[] configArr = (Bitmap.Config[]) Arrays.copyOf(new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null}, 3);
        configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        d = configArr;
        e = configArr;
        f2998f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f2999g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f3000h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String b(int i5, Bitmap.Config config) {
        return "[" + i5 + "](" + config + ")";
    }

    public final void a(Integer num, Bitmap bitmap) {
        NavigableMap navigableMapC = c(bitmap.getConfig());
        Integer num2 = (Integer) navigableMapC.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapC.remove(num);
                return;
            } else {
                navigableMapC.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + b(s.getBitmapByteSize(bitmap), bitmap.getConfig()) + ", this: " + this);
    }

    public final NavigableMap c(Bitmap.Config config) {
        HashMap map = this.c;
        NavigableMap navigableMap = (NavigableMap) map.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        map.put(config, treeMap);
        return treeMap;
    }

    public final void d(Bitmap bitmap) {
        int bitmapByteSize = s.getBitmapByteSize(bitmap);
        Bitmap.Config config = bitmap.getConfig();
        p pVar = this.f3001a;
        m mVarB = (m) pVar.f2982a.poll();
        if (mVarB == null) {
            mVarB = pVar.b();
        }
        o oVar = (o) mVarB;
        oVar.b = bitmapByteSize;
        oVar.c = config;
        this.b.a(oVar, bitmap);
        NavigableMap navigableMapC = c(bitmap.getConfig());
        Integer num = (Integer) navigableMapC.get(Integer.valueOf(oVar.b));
        navigableMapC.put(Integer.valueOf(oVar.b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    @Nullable
    public Bitmap get(int i5, int i6, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int bitmapByteSize = s.getBitmapByteSize(i5, i6, config);
        p pVar = this.f3001a;
        m mVarB = (m) pVar.f2982a.poll();
        if (mVarB == null) {
            mVarB = pVar.b();
        }
        o oVar = (o) mVarB;
        oVar.b = bitmapByteSize;
        oVar.c = config;
        if (Bitmap.Config.RGBA_F16.equals(config)) {
            configArr = e;
        } else {
            int i7 = n.f2996a[config.ordinal()];
            if (i7 == 1) {
                configArr = d;
            } else if (i7 == 2) {
                configArr = f2998f;
            } else if (i7 != 3) {
                configArr = i7 != 4 ? new Bitmap.Config[]{config} : f3000h;
            } else {
                configArr = f2999g;
            }
        }
        for (Bitmap.Config config2 : configArr) {
            Integer num = (Integer) c(config2).ceilingKey(Integer.valueOf(bitmapByteSize));
            if (num != null && num.intValue() <= bitmapByteSize * 8) {
                if (num.intValue() == bitmapByteSize && (config2 != null ? config2.equals(config) : config == null)) {
                    break;
                    break;
                }
                pVar.a(oVar);
                int iIntValue = num.intValue();
                m mVarB2 = (m) pVar.f2982a.poll();
                if (mVarB2 == null) {
                    mVarB2 = pVar.b();
                }
                oVar = (o) mVarB2;
                oVar.b = iIntValue;
                oVar.c = config2;
                break;
            }
        }
        Bitmap bitmap = (Bitmap) this.b.get(oVar);
        if (bitmap != null) {
            a(Integer.valueOf(oVar.b), bitmap);
            bitmap.reconfigure(i5, i6, config);
        }
        return bitmap;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    @Nullable
    public Bitmap removeLast() {
        Bitmap bitmap = (Bitmap) this.b.removeLast();
        if (bitmap != null) {
            a(Integer.valueOf(s.getBitmapByteSize(bitmap)), bitmap);
        }
        return bitmap;
    }

    public final String toString() {
        StringBuilder sbR = androidx.collection.a.r("SizeConfigStrategy{groupedMap=");
        sbR.append(this.b);
        sbR.append(", sortedSizes=(");
        HashMap map = this.c;
        for (Map.Entry entry : map.entrySet()) {
            sbR.append(entry.getKey());
            sbR.append('[');
            sbR.append(entry.getValue());
            sbR.append("], ");
        }
        if (!map.isEmpty()) {
            sbR.replace(sbR.length() - 2, sbR.length(), "");
        }
        sbR.append(")}");
        return sbR.toString();
    }
}
