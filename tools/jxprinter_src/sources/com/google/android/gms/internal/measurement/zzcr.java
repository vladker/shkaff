package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzcr extends IInterface {
    void beginAdUnitExposure(String str, long j6);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j6);

    void endAdUnitExposure(String str, long j6);

    void generateEventId(zzcu zzcuVar);

    void getAppInstanceId(zzcu zzcuVar);

    void getCachedAppInstanceId(zzcu zzcuVar);

    void getConditionalUserProperties(String str, String str2, zzcu zzcuVar);

    void getCurrentScreenClass(zzcu zzcuVar);

    void getCurrentScreenName(zzcu zzcuVar);

    void getGmpAppId(zzcu zzcuVar);

    void getMaxUserProperties(String str, zzcu zzcuVar);

    void getSessionId(zzcu zzcuVar);

    void getTestFlag(zzcu zzcuVar, int i5);

    void getUserProperties(String str, String str2, boolean z6, zzcu zzcuVar);

    void initForTests(Map map);

    void initialize(IObjectWrapper iObjectWrapper, zzdd zzddVar, long j6);

    void isDataCollectionEnabled(zzcu zzcuVar);

    void logEvent(String str, String str2, Bundle bundle, boolean z6, boolean z7, long j6);

    void logEventAndBundle(String str, String str2, Bundle bundle, zzcu zzcuVar, long j6);

    void logHealthData(int i5, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3);

    void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j6);

    void onActivityCreatedByScionActivityInfo(zzdf zzdfVar, Bundle bundle, long j6);

    void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j6);

    void onActivityDestroyedByScionActivityInfo(zzdf zzdfVar, long j6);

    void onActivityPaused(IObjectWrapper iObjectWrapper, long j6);

    void onActivityPausedByScionActivityInfo(zzdf zzdfVar, long j6);

    void onActivityResumed(IObjectWrapper iObjectWrapper, long j6);

    void onActivityResumedByScionActivityInfo(zzdf zzdfVar, long j6);

    void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcu zzcuVar, long j6);

    void onActivitySaveInstanceStateByScionActivityInfo(zzdf zzdfVar, zzcu zzcuVar, long j6);

    void onActivityStarted(IObjectWrapper iObjectWrapper, long j6);

    void onActivityStartedByScionActivityInfo(zzdf zzdfVar, long j6);

    void onActivityStopped(IObjectWrapper iObjectWrapper, long j6);

    void onActivityStoppedByScionActivityInfo(zzdf zzdfVar, long j6);

    void performAction(Bundle bundle, zzcu zzcuVar, long j6);

    void registerOnMeasurementEventListener(zzda zzdaVar);

    void resetAnalyticsData(long j6);

    void retrieveAndUploadBatches(zzcx zzcxVar);

    void setConditionalUserProperty(Bundle bundle, long j6);

    void setConsent(Bundle bundle, long j6);

    void setConsentThirdParty(Bundle bundle, long j6);

    void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j6);

    void setCurrentScreenByScionActivityInfo(zzdf zzdfVar, String str, String str2, long j6);

    void setDataCollectionEnabled(boolean z6);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(zzda zzdaVar);

    void setInstanceIdProvider(zzdc zzdcVar);

    void setMeasurementEnabled(boolean z6, long j6);

    void setMinimumSessionDuration(long j6);

    void setSessionTimeoutDuration(long j6);

    void setSgtmDebugInfo(Intent intent);

    void setUserId(String str, long j6);

    void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z6, long j6);

    void unregisterOnMeasurementEventListener(zzda zzdaVar);
}
