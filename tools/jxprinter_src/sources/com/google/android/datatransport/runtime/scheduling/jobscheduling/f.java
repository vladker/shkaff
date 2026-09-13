package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements SynchronizationGuard.CriticalSection, Deferred.DeferredHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f3301a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ f(Uploader uploader, Iterable iterable, TransportContext transportContext, long j6) {
        this.b = uploader;
        this.c = iterable;
        this.d = transportContext;
        this.f3301a = j6;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        return ((Uploader) this.b).lambda$logAndUpdateState$4((Iterable) this.c, (TransportContext) this.d, this.f3301a);
    }

    @Override // com.google.firebase.inject.Deferred.DeferredHandler
    public void handle(Provider provider) {
        CrashlyticsNativeComponentDeferredProxy.lambda$prepareNativeSession$1((String) this.b, (String) this.c, this.f3301a, (StaticSessionData) this.d, provider);
    }

    public /* synthetic */ f(String str, String str2, long j6, StaticSessionData staticSessionData) {
        this.b = str;
        this.c = str2;
        this.f3301a = j6;
        this.d = staticSessionData;
    }
}
