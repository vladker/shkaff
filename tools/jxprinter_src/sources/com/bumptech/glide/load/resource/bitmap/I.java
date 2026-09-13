package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class I implements p126w0.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0524t f3090a;

    public I(C0524t c0524t) {
        this.f3090a = c0524t;
    }

    private boolean isSafeToTryDecoding(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        String str = Build.MANUFACTURER;
        return !("HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= 536870912;
    }

    @Override // p126w0.x
    @Nullable
    public com.bumptech.glide.load.engine.O decode(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i5, int i6, @NonNull p126w0.v vVar) {
        return this.f3090a.decode(parcelFileDescriptor, i5, i6, vVar);
    }

    @Override // p126w0.x
    public boolean handles(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull p126w0.v vVar) {
        return isSafeToTryDecoding(parcelFileDescriptor) && !"robolectric".equals(Build.FINGERPRINT);
    }
}
