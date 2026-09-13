package com.bumptech.glide.load.engine.cache;

import L0.n;
import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.O;
import p126w0.q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends n implements h {
    public g e;

    @Override // com.bumptech.glide.load.engine.cache.h
    @Nullable
    public /* bridge */ /* synthetic */ O put(@NonNull q qVar, @Nullable O o6) {
        return (O) super.put((Object) qVar, (Object) o6);
    }

    @Override // com.bumptech.glide.load.engine.cache.h
    @Nullable
    public /* bridge */ /* synthetic */ O remove(@NonNull q qVar) {
        return (O) super.remove((Object) qVar);
    }

    @Override // com.bumptech.glide.load.engine.cache.h
    public void setResourceRemovedListener(@NonNull g gVar) {
        this.e = gVar;
    }

    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i5) {
        long j6;
        if (i5 >= 40) {
            a(0L);
        } else if (i5 >= 20 || i5 == 15) {
            synchronized (this) {
                j6 = this.c;
            }
            a(j6 / 2);
        }
    }

    @Override // L0.n
    public int getSize(@Nullable O o6) {
        return o6 == null ? super.getSize((Object) null) : o6.getSize();
    }

    @Override // L0.n
    public void onItemEvicted(@NonNull q qVar, @Nullable O o6) {
        g gVar = this.e;
        if (gVar == null || o6 == null) {
            return;
        }
        gVar.onResourceRemoved(o6);
    }
}
