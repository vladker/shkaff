package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0499o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f3061a;
    public final List b;
    public final F0.e c;
    public final Pools.Pool d;
    public final String e;

    public C0499o(Class cls, Class cls2, Class cls3, List list, F0.e eVar, Pools.Pool pool) {
        this.f3061a = cls;
        this.b = list;
        this.c = eVar;
        this.d = pool;
        this.e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + VectorFormat.DEFAULT_SUFFIX;
    }

    @NonNull
    private O decodeResource(com.bumptech.glide.load.data.g gVar, int i5, int i6, @NonNull p126w0.v vVar) {
        Pools.Pool pool = this.d;
        List<Throwable> list = (List) L0.q.checkNotNull(pool.acquire());
        try {
            return decodeResourceWithList(gVar, i5, i6, vVar, list);
        } finally {
            pool.release(list);
        }
    }

    @NonNull
    private O decodeResourceWithList(com.bumptech.glide.load.data.g gVar, int i5, int i6, @NonNull p126w0.v vVar, List<Throwable> list) throws J {
        List list2 = this.b;
        int size = list2.size();
        O oDecode = null;
        for (int i7 = 0; i7 < size; i7++) {
            p126w0.x xVar = (p126w0.x) list2.get(i7);
            try {
                if (xVar.handles(gVar.rewindAndGet(), vVar)) {
                    oDecode = xVar.decode(gVar.rewindAndGet(), i5, i6, vVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + xVar, e);
                }
                list.add(e);
            }
            if (oDecode != null) {
                break;
            }
        }
        if (oDecode != null) {
            return oDecode;
        }
        throw new J(this.e, new ArrayList(list));
    }

    public O decode(com.bumptech.glide.load.data.g gVar, int i5, int i6, @NonNull p126w0.v vVar, InterfaceC0498n interfaceC0498n) {
        return this.c.transcode(((C0495k) interfaceC0498n).onResourceDecoded(decodeResource(gVar, i5, i6, vVar)), vVar);
    }

    public final String toString() {
        return "DecodePath{ dataClass=" + this.f3061a + ", decoders=" + this.b + ", transcoder=" + this.c + '}';
    }
}
