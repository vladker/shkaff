package com.google.android.gms.common.moduleinstall.internal;

import android.os.IInterface;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface zae extends IInterface {
    void zab(Status status);

    void zac(Status status, @Nullable ModuleInstallIntentResponse moduleInstallIntentResponse);

    void zad(Status status, @Nullable ModuleInstallResponse moduleInstallResponse);

    void zae(Status status, @Nullable ModuleAvailabilityResponse moduleAvailabilityResponse);
}
