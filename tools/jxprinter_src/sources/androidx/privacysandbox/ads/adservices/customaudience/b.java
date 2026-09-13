package androidx.privacysandbox.ads.adservices.customaudience;

import android.adservices.signals.UpdateSignalsRequest;
import android.adservices.topics.EncryptedTopic;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static /* synthetic */ android.adservices.customaudience.FetchAndJoinCustomAudienceRequest.Builder a(Uri uri) {
        return new android.adservices.customaudience.FetchAndJoinCustomAudienceRequest.Builder(uri);
    }

    public static /* synthetic */ UpdateSignalsRequest.Builder c(Uri uri) {
        return new UpdateSignalsRequest.Builder(uri);
    }

    public static /* bridge */ /* synthetic */ EncryptedTopic e(Object obj) {
        return (EncryptedTopic) obj;
    }

    public static /* synthetic */ void i() {
    }

    public static /* synthetic */ void l() {
    }
}
