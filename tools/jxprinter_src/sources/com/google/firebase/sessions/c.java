package com.google.firebase.sessions;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements O3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3510a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i5) {
        this.f3510a = i5;
        this.b = obj;
    }

    @Override // O3.a
    public final Object invoke() {
        switch (this.f3510a) {
            case 0:
                return FirebaseSessionsComponent.MainModule.Companion.sessionConfigsDataStore$lambda$2((Context) this.b);
            case 1:
                return FirebaseSessionsComponent.MainModule.Companion.sessionDataStore$lambda$5((Context) this.b);
            default:
                return ProcessDataManagerImpl.myUuid_delegate$lambda$1((UuidGenerator) this.b);
        }
    }
}
