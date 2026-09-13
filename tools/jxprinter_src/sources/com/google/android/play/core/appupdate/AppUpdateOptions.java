package com.google.android.play.core.appupdate;

import androidx.annotation.NonNull;
import com.google.android.play.core.install.model.AppUpdateType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AppUpdateOptions {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class Builder {
        @NonNull
        public abstract AppUpdateOptions build();

        @NonNull
        public abstract Builder setAllowAssetPackDeletion(boolean z6);

        @NonNull
        public abstract Builder setAppUpdateType(@AppUpdateType int i5);
    }

    @NonNull
    public static AppUpdateOptions defaultOptions(@AppUpdateType int i5) {
        return newBuilder(i5).build();
    }

    @NonNull
    public static Builder newBuilder(@AppUpdateType int i5) {
        zzv zzvVar = new zzv();
        zzvVar.setAppUpdateType(i5);
        zzvVar.setAllowAssetPackDeletion(false);
        return zzvVar;
    }

    public abstract boolean allowAssetPackDeletion();

    @AppUpdateType
    public abstract int appUpdateType();
}
