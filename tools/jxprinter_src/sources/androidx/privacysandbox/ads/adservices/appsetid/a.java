package androidx.privacysandbox.ads.adservices.appsetid;

import android.adservices.common.AdData;
import android.adservices.customaudience.CustomAudienceManager;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.customaudience.LeaveCustomAudienceRequest;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ Class D() {
        return CustomAudienceManager.class;
    }

    public static /* bridge */ /* synthetic */ android.adservices.appsetid.AppSetId b(Object obj) {
        return (android.adservices.appsetid.AppSetId) obj;
    }

    public static /* bridge */ /* synthetic */ android.adservices.appsetid.AppSetIdManager d(Object obj) {
        return (android.adservices.appsetid.AppSetIdManager) obj;
    }

    public static /* synthetic */ AdData.Builder e() {
        return new AdData.Builder();
    }

    public static /* bridge */ /* synthetic */ CustomAudienceManager t(Object obj) {
        return (CustomAudienceManager) obj;
    }

    public static /* synthetic */ JoinCustomAudienceRequest.Builder u() {
        return new JoinCustomAudienceRequest.Builder();
    }

    public static /* synthetic */ LeaveCustomAudienceRequest.Builder v() {
        return new LeaveCustomAudienceRequest.Builder();
    }

    public static /* bridge */ /* synthetic */ Class y() {
        return android.adservices.appsetid.AppSetIdManager.class;
    }
}
