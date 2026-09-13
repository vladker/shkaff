package com.google.firebase.crashlytics.internal.common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3487a;
    public final /* synthetic */ CrashlyticsCore b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public /* synthetic */ g(CrashlyticsCore crashlyticsCore, String str, String str2, int i5) {
        this.f3487a = i5;
        this.b = crashlyticsCore;
        this.c = str;
        this.d = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3487a) {
            case 0:
                this.b.lambda$setCustomKey$5(this.c, this.d);
                break;
            default:
                this.b.lambda$setInternalKey$7(this.c, this.d);
                break;
        }
    }
}
