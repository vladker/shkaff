package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zam;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zag {
    final zad zaa;
    protected int zab;

    public zag(Uri uri, int i5) {
        this.zab = 0;
        this.zaa = new zad(uri);
        this.zab = i5;
    }

    public abstract void zaa(@Nullable Drawable drawable, boolean z6, boolean z7, boolean z8);

    public final void zab(Context context, zam zamVar, boolean z6) {
        int i5 = this.zab;
        zaa(i5 != 0 ? context.getResources().getDrawable(i5) : null, z6, false, false);
    }

    public final void zac(Context context, Bitmap bitmap, boolean z6) {
        Asserts.checkNotNull(bitmap);
        zaa(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
