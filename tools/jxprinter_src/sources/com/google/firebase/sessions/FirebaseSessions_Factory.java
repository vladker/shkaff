package com.google.firebase.sessions;

import E3.q;
import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import com.google.firebase.sessions.settings.SessionsSettings;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({"com.google.firebase.annotations.concurrent.Background"})
@DaggerGenerated
public final class FirebaseSessions_Factory implements Factory<FirebaseSessions> {
    private final p141y3.a backgroundDispatcherProvider;
    private final p141y3.a firebaseAppProvider;
    private final p141y3.a sessionsActivityLifecycleCallbacksProvider;
    private final p141y3.a settingsProvider;

    public FirebaseSessions_Factory(p141y3.a aVar, p141y3.a aVar2, p141y3.a aVar3, p141y3.a aVar4) {
        this.firebaseAppProvider = aVar;
        this.settingsProvider = aVar2;
        this.backgroundDispatcherProvider = aVar3;
        this.sessionsActivityLifecycleCallbacksProvider = aVar4;
    }

    public static FirebaseSessions_Factory create(p141y3.a aVar, p141y3.a aVar2, p141y3.a aVar3, p141y3.a aVar4) {
        return new FirebaseSessions_Factory(aVar, aVar2, aVar3, aVar4);
    }

    public static FirebaseSessions newInstance(FirebaseApp firebaseApp, SessionsSettings sessionsSettings, q qVar, SessionsActivityLifecycleCallbacks sessionsActivityLifecycleCallbacks) {
        return new FirebaseSessions(firebaseApp, sessionsSettings, qVar, sessionsActivityLifecycleCallbacks);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p141y3.a
    public FirebaseSessions get() {
        return newInstance((FirebaseApp) this.firebaseAppProvider.get(), (SessionsSettings) this.settingsProvider.get(), (q) this.backgroundDispatcherProvider.get(), (SessionsActivityLifecycleCallbacks) this.sessionsActivityLifecycleCallbacksProvider.get());
    }
}
