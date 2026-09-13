package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends com.bumptech.glide.request.target.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f3144a;
    public final int b;
    public final long c;
    public Bitmap d;

    public j(Handler handler, int i5, long j6) {
        this.f3144a = handler;
        this.b = i5;
        this.c = j6;
    }

    @Override // com.bumptech.glide.request.target.c, com.bumptech.glide.request.target.k
    public void onLoadCleared(@Nullable Drawable drawable) {
        this.d = null;
    }

    @Override // com.bumptech.glide.request.target.c, com.bumptech.glide.request.target.k
    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable J0.d dVar) {
        this.d = bitmap;
        Handler handler = this.f3144a;
        handler.sendMessageAtTime(handler.obtainMessage(1, this), this.c);
    }
}
