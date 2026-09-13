package com.bumptech.glide;

import androidx.tracing.Trace;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class w implements L0.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3201a;
    public final /* synthetic */ c b;
    public final /* synthetic */ List c;
    public final /* synthetic */ G0.a d;

    public w(c cVar, List list, G0.a aVar) {
        this.b = cVar;
        this.c = list;
        this.d = aVar;
    }

    @Override // L0.k
    public final Object get() {
        if (this.f3201a) {
            throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
        }
        Trace.beginSection("Glide registry");
        this.f3201a = true;
        try {
            return x.createAndInitRegistry(this.b, this.c, this.d);
        } finally {
            this.f3201a = false;
            Trace.endSection();
        }
    }
}
