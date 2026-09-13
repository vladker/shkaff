package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.common.AdFilters;
import android.adservices.common.AdTechIdentifier;
import android.adservices.common.FrequencyCapFilters;
import android.adservices.common.KeyedFrequencyCap;
import java.time.Duration;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ void A() {
    }

    public static /* synthetic */ void C() {
    }

    public static /* synthetic */ android.adservices.adselection.PersistAdSelectionResultRequest.Builder a() {
        return new android.adservices.adselection.PersistAdSelectionResultRequest.Builder();
    }

    public static /* synthetic */ android.adservices.adselection.ReportEventRequest.Builder b(long j6, String str, String str2, int i5) {
        return new android.adservices.adselection.ReportEventRequest.Builder(j6, str, str2, i5);
    }

    public static /* synthetic */ android.adservices.adselection.ReportImpressionRequest e(long j6) {
        return new android.adservices.adselection.ReportImpressionRequest(j6);
    }

    public static /* synthetic */ android.adservices.adselection.UpdateAdCounterHistogramRequest.Builder f(long j6, int i5, AdTechIdentifier adTechIdentifier) {
        return new android.adservices.adselection.UpdateAdCounterHistogramRequest.Builder(j6, i5, adTechIdentifier);
    }

    public static /* synthetic */ AdFilters.Builder k() {
        return new AdFilters.Builder();
    }

    public static /* synthetic */ FrequencyCapFilters.Builder n() {
        return new FrequencyCapFilters.Builder();
    }

    public static /* synthetic */ KeyedFrequencyCap.Builder q(int i5, int i6, Duration duration) {
        return new KeyedFrequencyCap.Builder(i5, i6, duration);
    }

    public static /* synthetic */ void w() {
    }
}
