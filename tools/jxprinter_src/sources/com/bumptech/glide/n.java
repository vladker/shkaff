package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface n {
    @NonNull
    @CheckResult
    Object load(@Nullable Bitmap bitmap);

    @NonNull
    @CheckResult
    Object load(@Nullable Drawable drawable);

    @NonNull
    @CheckResult
    Object load(@Nullable Uri uri);

    @NonNull
    @CheckResult
    Object load(@Nullable File file);

    @NonNull
    @CheckResult
    Object load(@Nullable @DrawableRes @RawRes Integer num);

    @NonNull
    @CheckResult
    Object load(@Nullable Object obj);

    @NonNull
    @CheckResult
    Object load(@Nullable String str);

    @CheckResult
    @Deprecated
    Object load(@Nullable URL url);

    @NonNull
    @CheckResult
    Object load(@Nullable byte[] bArr);
}
