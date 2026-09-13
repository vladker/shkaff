package com.google.android.play.core.install;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.play.core.install.model.InstallErrorCode;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class InstallException extends ApiException {
    public InstallException(@InstallErrorCode int i5) {
        super(new Status(i5, String.format(Locale.getDefault(), "Install Error(%d): %s", Integer.valueOf(i5), com.google.android.play.core.install.model.zza.zza(i5))));
        if (i5 == 0) {
            throw new IllegalArgumentException("errorCode should not be 0.");
        }
    }

    @InstallErrorCode
    public int getErrorCode() {
        return super.getStatusCode();
    }
}
