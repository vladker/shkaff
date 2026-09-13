package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: renamed from: com.android.billingclient.api.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0419l {
    @NonNull
    @AnyThread
    public static C0417k newBuilder(@NonNull Context context) {
        return new C0417k(context);
    }

    @AnyThread
    public abstract void acknowledgePurchase(@NonNull C0401c c0401c, @NonNull InterfaceC0403d interfaceC0403d);

    @AnyThread
    public abstract void consumeAsync(@NonNull J j6, @NonNull K k6);

    @AnyThread
    @KeepForSdk
    public abstract void createAlternativeBillingOnlyReportingDetailsAsync(@NonNull InterfaceC0411h interfaceC0411h);

    @AnyThread
    public abstract void createBillingProgramReportingDetailsAsync(@NonNull F f6, @NonNull D d);

    @AnyThread
    @Deprecated
    public abstract void createExternalOfferReportingDetailsAsync(@NonNull V v6);

    @AnyThread
    public abstract void endConnection();

    @AnyThread
    public abstract void getBillingChoiceInfoAsync(@NonNull X x6, @NonNull InterfaceC0415j interfaceC0415j);

    @AnyThread
    public abstract void getBillingConfigAsync(@NonNull Z z6, @NonNull InterfaceC0427p interfaceC0427p);

    @AnyThread
    public abstract int getConnectionState();

    @AnyThread
    @KeepForSdk
    public abstract void isAlternativeBillingOnlyAvailableAsync(@NonNull InterfaceC0405e interfaceC0405e);

    @AnyThread
    public abstract void isBillingProgramAvailableAsync(int i5, @NonNull InterfaceC0444y interfaceC0444y);

    @AnyThread
    @Deprecated
    public abstract void isExternalOfferAvailableAsync(@NonNull S s6);

    @NonNull
    @AnyThread
    public abstract H isFeatureSupported(@NonNull String str);

    @AnyThread
    public abstract boolean isReady();

    @NonNull
    @UiThread
    public abstract H launchBillingFlow(@NonNull Activity activity, @NonNull C0442x c0442x);

    @UiThread
    public abstract void launchExternalLink(@NonNull Activity activity, @NonNull C0410g0 c0410g0, @NonNull InterfaceC0412h0 interfaceC0412h0);

    @AnyThread
    public abstract void queryProductDetailsAsync(@NonNull C0443x0 c0443x0, @NonNull InterfaceC0426o0 interfaceC0426o0);

    @AnyThread
    public abstract void queryPurchasesAsync(@NonNull A0 a6, @NonNull InterfaceC0433s0 interfaceC0433s0);

    @NonNull
    @UiThread
    public abstract H showAlternativeBillingOnlyInformationDialog(@NonNull Activity activity, @NonNull InterfaceC0407f interfaceC0407f);

    @UiThread
    public abstract void showBillingProgramInformationDialog(@NonNull Activity activity, @NonNull B b, @NonNull InterfaceC0446z interfaceC0446z);

    @NonNull
    @UiThread
    @Deprecated
    public abstract H showExternalOfferInformationDialog(@NonNull Activity activity, @NonNull T t6);

    @NonNull
    @UiThread
    public abstract H showInAppMessages(@NonNull Activity activity, @NonNull C0400b0 c0400b0, @NonNull InterfaceC0402c0 interfaceC0402c0);

    @AnyThread
    public abstract void startConnection(@NonNull InterfaceC0423n interfaceC0423n);
}
