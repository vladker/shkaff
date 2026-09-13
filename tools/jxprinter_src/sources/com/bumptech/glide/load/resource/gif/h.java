package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends D0.f {
    @Override // D0.f, com.bumptech.glide.load.engine.O
    @NonNull
    public Class<f> getResourceClass() {
        return f.class;
    }

    @Override // com.bumptech.glide.load.engine.O
    public final int getSize() {
        n nVar = ((f) this.f161a).f3137a.frameLoader;
        return ((com.bumptech.glide.gifdecoder.f) nVar.f3146a).b() + nVar.f3155n;
    }

    @Override // D0.f, com.bumptech.glide.load.engine.K
    public final void initialize() {
        ((f) this.f161a).b().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.O
    public final void recycle() {
        f fVar = (f) this.f161a;
        fVar.stop();
        fVar.d = true;
        n nVar = fVar.f3137a.frameLoader;
        A a6 = nVar.d;
        nVar.c.clear();
        Bitmap bitmap = nVar.f3153l;
        if (bitmap != null) {
            nVar.e.b(bitmap);
            nVar.f3153l = null;
        }
        nVar.f3147f = false;
        j jVar = nVar.f3150i;
        if (jVar != null) {
            a6.clear(jVar);
            nVar.f3150i = null;
        }
        j jVar2 = nVar.f3152k;
        if (jVar2 != null) {
            a6.clear(jVar2);
            nVar.f3152k = null;
        }
        j jVar3 = nVar.f3154m;
        if (jVar3 != null) {
            a6.clear(jVar3);
            nVar.f3154m = null;
        }
        ((com.bumptech.glide.gifdecoder.f) nVar.f3146a).a();
        nVar.f3151j = true;
    }
}
