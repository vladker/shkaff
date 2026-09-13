package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pools.Pool f2963a;
    public final List b;
    public final String c;

    public M(Class cls, Class cls2, Class cls3, List list, Pools.Pool pool) {
        this.f2963a = pool;
        this.b = (List) L0.q.checkNotEmpty(list);
        this.c = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + VectorFormat.DEFAULT_SUFFIX;
    }

    private O loadWithExceptionList(com.bumptech.glide.load.data.g gVar, @NonNull p126w0.v vVar, int i5, int i6, InterfaceC0498n interfaceC0498n, List<Throwable> list) throws J {
        List list2 = this.b;
        int size = list2.size();
        O oDecode = null;
        for (int i7 = 0; i7 < size; i7++) {
            try {
                oDecode = ((C0499o) list2.get(i7)).decode(gVar, i5, i6, vVar, interfaceC0498n);
            } catch (J e) {
                list.add(e);
            }
            if (oDecode != null) {
                break;
            }
        }
        if (oDecode != null) {
            return oDecode;
        }
        throw new J(this.c, new ArrayList(list));
    }

    public O load(com.bumptech.glide.load.data.g gVar, @NonNull p126w0.v vVar, int i5, int i6, InterfaceC0498n interfaceC0498n) {
        Pools.Pool pool = this.f2963a;
        List<Throwable> list = (List) L0.q.checkNotNull(pool.acquire());
        try {
            return loadWithExceptionList(gVar, vVar, i5, i6, interfaceC0498n, list);
        } finally {
            pool.release(list);
        }
    }

    public final String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.b.toArray()) + '}';
    }
}
