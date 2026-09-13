package com.google.firebase.installations;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3507a;
    public final /* synthetic */ FirebaseInstallations b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ a(FirebaseInstallations firebaseInstallations, boolean z6, int i5) {
        this.f3507a = i5;
        this.b = firebaseInstallations;
        this.c = z6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3507a) {
            case 0:
                this.b.lambda$doRegistrationOrRefresh$3(this.c);
                break;
            default:
                this.b.lambda$getToken$2(this.c);
                break;
        }
    }
}
