package com.google.firebase.crashlytics.internal.common;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3484a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ d(Object obj, Object obj2, int i5) {
        this.f3484a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f3484a) {
            case 0:
                ((CrashlyticsController) this.b).lambda$openSession$1((String) this.c);
                break;
            case 1:
                ((CrashlyticsCore) this.b).lambda$setCustomKeys$6((Map) this.c);
                break;
            case 2:
                ((CrashlyticsCore) this.b).lambda$logFatalException$8((Throwable) this.c);
                break;
            default:
                ((CrashlyticsCore) this.b).lambda$setUserId$4((String) this.c);
                break;
        }
    }
}
