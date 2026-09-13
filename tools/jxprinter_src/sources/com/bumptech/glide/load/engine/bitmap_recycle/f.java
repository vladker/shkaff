package com.bumptech.glide.load.engine.bitmap_recycle;

import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2984a;
    public ArrayList b;
    public f d = this;
    public f c = this;

    public f(m mVar) {
        this.f2984a = mVar;
    }

    @Nullable
    public Object removeLast() {
        ArrayList arrayList = this.b;
        int size = arrayList != null ? arrayList.size() : 0;
        if (size > 0) {
            return this.b.remove(size - 1);
        }
        return null;
    }
}
