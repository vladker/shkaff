package com.google.firebase.sessions;

import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
public final class SessionsActivityLifecycleCallbacks_Factory implements Factory<SessionsActivityLifecycleCallbacks> {
    private final p141y3.a sharedSessionRepositoryProvider;

    public SessionsActivityLifecycleCallbacks_Factory(p141y3.a aVar) {
        this.sharedSessionRepositoryProvider = aVar;
    }

    public static SessionsActivityLifecycleCallbacks_Factory create(p141y3.a aVar) {
        return new SessionsActivityLifecycleCallbacks_Factory(aVar);
    }

    public static SessionsActivityLifecycleCallbacks newInstance(SharedSessionRepository sharedSessionRepository) {
        return new SessionsActivityLifecycleCallbacks(sharedSessionRepository);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p141y3.a
    public SessionsActivityLifecycleCallbacks get() {
        return newInstance((SharedSessionRepository) this.sharedSessionRepositoryProvider.get());
    }
}
