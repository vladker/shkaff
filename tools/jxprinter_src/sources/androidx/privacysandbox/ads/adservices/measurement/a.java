package androidx.privacysandbox.ads.adservices.measurement;

import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;
import android.net.Uri;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ void A() {
    }

    public static /* synthetic */ void C() {
    }

    public static /* synthetic */ void D() {
    }

    public static /* synthetic */ android.adservices.measurement.WebSourceParams.Builder c(Uri uri) {
        return new android.adservices.measurement.WebSourceParams.Builder(uri);
    }

    public static /* synthetic */ android.adservices.measurement.WebSourceRegistrationRequest.Builder f(List list, Uri uri) {
        return new android.adservices.measurement.WebSourceRegistrationRequest.Builder(list, uri);
    }

    public static /* synthetic */ android.adservices.measurement.WebTriggerParams.Builder i(Uri uri) {
        return new android.adservices.measurement.WebTriggerParams.Builder(uri);
    }

    public static /* synthetic */ android.adservices.measurement.WebTriggerRegistrationRequest.Builder k(List list, Uri uri) {
        return new android.adservices.measurement.WebTriggerRegistrationRequest.Builder(list, uri);
    }

    public static /* synthetic */ GetTopicsRequest.Builder m() {
        return new GetTopicsRequest.Builder();
    }

    public static /* bridge */ /* synthetic */ GetTopicsResponse q(Object obj) {
        return (GetTopicsResponse) obj;
    }

    public static /* bridge */ /* synthetic */ Topic r(Object obj) {
        return (Topic) obj;
    }

    public static /* bridge */ /* synthetic */ TopicsManager t(Object obj) {
        return (TopicsManager) obj;
    }

    public static /* bridge */ /* synthetic */ Class u() {
        return TopicsManager.class;
    }

    public static /* synthetic */ void w() {
    }
}
