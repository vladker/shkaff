package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.C0499o;
import com.bumptech.glide.load.engine.M;
import com.bumptech.glide.load.engine.O;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p144z0.T;
import p144z0.U;
import p144z0.X;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class v {

    @Deprecated
    public static final String BUCKET_GIF = "Animation";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X f3195a;
    public final H0.b b;
    public final H0.g c;
    public final H0.i d;
    public final com.bumptech.glide.load.data.j e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final F0.g f3196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final H0.c f3197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final H0.e f3198h = new H0.e();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final H0.d f3199i = new H0.d();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Pools.Pool f3200j;

    public v() {
        Pools.Pool poolThreadSafeList = M0.h.threadSafeList();
        this.f3200j = poolThreadSafeList;
        this.f3195a = new X((Pools.Pool<List<Throwable>>) poolThreadSafeList);
        this.b = new H0.b();
        this.c = new H0.g();
        this.d = new H0.i();
        this.e = new com.bumptech.glide.load.data.j();
        this.f3196f = new F0.g();
        this.f3197g = new H0.c();
        setResourceDecoderBucketPriorityList(Arrays.asList(BUCKET_GIF, "Bitmap", "BitmapDrawable"));
    }

    @NonNull
    private <Data, TResource, Transcode> List<C0499o> getDecodePaths(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        H0.g gVar = this.c;
        for (Class cls4 : gVar.getResourceClasses(cls, cls2)) {
            F0.g gVar2 = this.f3196f;
            for (Class cls5 : gVar2.getTranscodeClasses(cls4, cls3)) {
                arrayList.add(new C0499o(cls, cls4, cls5, gVar.getDecoders(cls, cls4), gVar2.get(cls4, cls5), this.f3200j));
            }
        }
        return arrayList;
    }

    @NonNull
    public <Data> v append(@NonNull Class<Data> cls, @NonNull p126w0.d dVar) {
        this.b.append(cls, dVar);
        return this;
    }

    @NonNull
    public List<p126w0.g> getImageHeaderParsers() {
        List<p126w0.g> parsers = this.f3197g.getParsers();
        if (parsers.isEmpty()) {
            throw new C0538r("Failed to find image header parser.");
        }
        return parsers;
    }

    @Nullable
    public <Data, TResource, Transcode> M getLoadPath(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        Class<Data> cls4;
        Class<TResource> cls5;
        Class<Transcode> cls6;
        H0.d dVar = this.f3199i;
        M m6 = dVar.get(cls, cls2, cls3);
        M m7 = null;
        if (dVar.isEmptyLoadPath(m6)) {
            return null;
        }
        if (m6 != null) {
            return m6;
        }
        List<C0499o> decodePaths = getDecodePaths(cls, cls2, cls3);
        if (decodePaths.isEmpty()) {
            cls4 = cls;
            cls5 = cls2;
            cls6 = cls3;
        } else {
            cls4 = cls;
            cls5 = cls2;
            cls6 = cls3;
            m7 = new M(cls4, cls5, cls6, decodePaths, this.f3200j);
        }
        dVar.put(cls4, cls5, cls6, m7);
        return m7;
    }

    @NonNull
    public <Model> List<T> getModelLoaders(@NonNull Model model) {
        return this.f3195a.getModelLoaders(model);
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> getRegisteredResourceClasses(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        H0.e eVar = this.f3198h;
        List<Class<?>> list = eVar.get(cls, cls2, cls3);
        List<Class<?>> list2 = list;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<Class<?>> it = this.f3195a.getDataClasses(cls).iterator();
            while (it.hasNext()) {
                for (Class cls4 : this.c.getResourceClasses(it.next(), cls2)) {
                    if (!this.f3196f.getTranscodeClasses(cls4, cls3).isEmpty() && !arrayList.contains(cls4)) {
                        arrayList.add(cls4);
                    }
                }
            }
            eVar.put(cls, cls2, cls3, Collections.unmodifiableList(arrayList));
            list2 = arrayList;
        }
        return list2;
    }

    @NonNull
    public <X> p126w0.y getResultEncoder(@NonNull O o6) {
        p126w0.y yVar = this.d.get(o6.getResourceClass());
        if (yVar != null) {
            return yVar;
        }
        throw new t(o6.getResourceClass());
    }

    @NonNull
    public <X> com.bumptech.glide.load.data.g getRewinder(@NonNull X x6) {
        return this.e.build(x6);
    }

    @NonNull
    public <X> p126w0.d getSourceEncoder(@NonNull X x6) {
        p126w0.d encoder = this.b.getEncoder(x6.getClass());
        if (encoder != null) {
            return encoder;
        }
        throw new u(x6.getClass());
    }

    public boolean isResourceEncoderAvailable(@NonNull O o6) {
        return this.d.get(o6.getResourceClass()) != null;
    }

    @NonNull
    public <Data> v prepend(@NonNull Class<Data> cls, @NonNull p126w0.d dVar) {
        this.b.prepend(cls, dVar);
        return this;
    }

    @NonNull
    @Deprecated
    public <Data> v register(@NonNull Class<Data> cls, @NonNull p126w0.d dVar) {
        return append(cls, dVar);
    }

    @NonNull
    public <Model, Data> v replace(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull U u6) {
        this.f3195a.replace(cls, cls2, u6);
        return this;
    }

    @NonNull
    public final v setResourceDecoderBucketPriorityList(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        arrayList.add("legacy_append");
        this.c.setBucketPriorityList(arrayList);
        return this;
    }

    @NonNull
    public <Data, TResource> v append(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull p126w0.x xVar) {
        append("legacy_append", cls, cls2, xVar);
        return this;
    }

    @NonNull
    public <Data, TResource> v prepend(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull p126w0.x xVar) {
        prepend("legacy_prepend_all", cls, cls2, xVar);
        return this;
    }

    @NonNull
    @Deprecated
    public <TResource> v register(@NonNull Class<TResource> cls, @NonNull p126w0.y yVar) {
        return append((Class) cls, yVar);
    }

    @NonNull
    public <Data, TResource> v append(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull p126w0.x xVar) {
        this.c.append(str, xVar, cls, cls2);
        return this;
    }

    @NonNull
    public <Data, TResource> v prepend(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull p126w0.x xVar) {
        this.c.prepend(str, xVar, cls, cls2);
        return this;
    }

    @NonNull
    public v register(@NonNull com.bumptech.glide.load.data.f fVar) {
        this.e.register(fVar);
        return this;
    }

    @NonNull
    public <TResource> v append(@NonNull Class<TResource> cls, @NonNull p126w0.y yVar) {
        this.d.append(cls, yVar);
        return this;
    }

    @NonNull
    public <TResource> v prepend(@NonNull Class<TResource> cls, @NonNull p126w0.y yVar) {
        this.d.prepend(cls, yVar);
        return this;
    }

    @NonNull
    public <TResource, Transcode> v register(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull F0.e eVar) {
        this.f3196f.register(cls, cls2, eVar);
        return this;
    }

    @NonNull
    public <Model, Data> v append(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull U u6) {
        this.f3195a.append(cls, cls2, u6);
        return this;
    }

    @NonNull
    public <Model, Data> v prepend(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull U u6) {
        this.f3195a.prepend(cls, cls2, u6);
        return this;
    }

    @NonNull
    public v register(@NonNull p126w0.g gVar) {
        this.f3197g.add(gVar);
        return this;
    }
}
