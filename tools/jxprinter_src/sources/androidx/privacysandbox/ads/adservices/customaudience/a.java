package androidx.privacysandbox.ads.adservices.customaudience;

import android.adservices.measurement.DeletionRequest;
import android.adservices.measurement.MeasurementManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ android.adservices.customaudience.CustomAudience.Builder a() {
        return new android.adservices.customaudience.CustomAudience.Builder();
    }

    public static /* synthetic */ android.adservices.customaudience.TrustedBiddingData.Builder f() {
        return new android.adservices.customaudience.TrustedBiddingData.Builder();
    }

    public static /* synthetic */ DeletionRequest.Builder j() {
        return new DeletionRequest.Builder();
    }

    public static /* bridge */ /* synthetic */ MeasurementManager p(Object obj) {
        return (MeasurementManager) obj;
    }

    public static /* bridge */ /* synthetic */ Class s() {
        return MeasurementManager.class;
    }
}
