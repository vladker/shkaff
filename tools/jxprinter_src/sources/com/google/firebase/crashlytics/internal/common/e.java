package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.settings.SettingsProvider;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3485a;
    public final /* synthetic */ CrashlyticsCore b;
    public final /* synthetic */ SettingsProvider c;

    public /* synthetic */ e(CrashlyticsCore crashlyticsCore, SettingsProvider settingsProvider, int i5) {
        this.f3485a = i5;
        this.b = crashlyticsCore;
        this.c = settingsProvider;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3485a) {
            case 0:
                this.b.lambda$doBackgroundInitializationAsync$0(this.c);
                break;
            default:
                this.b.lambda$finishInitSynchronously$9(this.c);
                break;
        }
    }
}
