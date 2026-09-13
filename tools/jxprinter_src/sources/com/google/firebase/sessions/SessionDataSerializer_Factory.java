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
public final class SessionDataSerializer_Factory implements Factory<SessionDataSerializer> {
    private final p141y3.a sessionGeneratorProvider;

    public SessionDataSerializer_Factory(p141y3.a aVar) {
        this.sessionGeneratorProvider = aVar;
    }

    public static SessionDataSerializer_Factory create(p141y3.a aVar) {
        return new SessionDataSerializer_Factory(aVar);
    }

    public static SessionDataSerializer newInstance(SessionGenerator sessionGenerator) {
        return new SessionDataSerializer(sessionGenerator);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p141y3.a
    public SessionDataSerializer get() {
        return newInstance((SessionGenerator) this.sessionGeneratorProvider.get());
    }
}
