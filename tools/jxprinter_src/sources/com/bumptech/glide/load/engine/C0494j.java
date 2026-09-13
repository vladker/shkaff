package com.bumptech.glide.load.engine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0494j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3017a = new ArrayList();
    public final ArrayList b = new ArrayList();
    public com.bumptech.glide.j c;
    public Object d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Class f3019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public C0505v f3020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public p126w0.v f3021i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map f3022j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Class f3023k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f3024l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f3025m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public p126w0.q f3026n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bumptech.glide.o f3027o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AbstractC0501q f3028p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f3029q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3030r;

    public final ArrayList a() {
        boolean z6 = this.f3025m;
        ArrayList arrayList = this.b;
        if (!z6) {
            this.f3025m = true;
            arrayList.clear();
            ArrayList arrayListB = b();
            int size = arrayListB.size();
            for (int i5 = 0; i5 < size; i5++) {
                p144z0.S s6 = (p144z0.S) arrayListB.get(i5);
                p126w0.q qVar = s6.f9063a;
                List list = s6.b;
                if (!arrayList.contains(qVar)) {
                    arrayList.add(s6.f9063a);
                }
                for (int i6 = 0; i6 < list.size(); i6++) {
                    if (!arrayList.contains(list.get(i6))) {
                        arrayList.add(list.get(i6));
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList b() {
        boolean z6 = this.f3024l;
        ArrayList arrayList = this.f3017a;
        if (!z6) {
            this.f3024l = true;
            arrayList.clear();
            List<p144z0.T> modelLoaders = this.c.getRegistry().getModelLoaders(this.d);
            int size = modelLoaders.size();
            for (int i5 = 0; i5 < size; i5++) {
                p144z0.S sBuildLoadData = modelLoaders.get(i5).buildLoadData(this.d, this.e, this.f3018f, this.f3021i);
                if (sBuildLoadData != null) {
                    arrayList.add(sBuildLoadData);
                }
            }
        }
        return arrayList;
    }

    public final p126w0.z c(Class cls) {
        p126w0.z zVar = (p126w0.z) this.f3022j.get(cls);
        if (zVar == null) {
            for (Map.Entry entry : this.f3022j.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    zVar = (p126w0.z) entry.getValue();
                    break;
                }
            }
        }
        if (zVar != null) {
            return zVar;
        }
        if (!this.f3022j.isEmpty() || !this.f3029q) {
            return B0.e.get();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    public List<p144z0.T> getModelLoaders(File file) {
        return this.c.getRegistry().getModelLoaders(file);
    }

    public <X> p126w0.d getSourceEncoder(X x6) {
        return this.c.getRegistry().getSourceEncoder(x6);
    }
}
