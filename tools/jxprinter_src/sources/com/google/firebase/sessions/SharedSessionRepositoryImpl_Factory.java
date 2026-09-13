package com.google.firebase.sessions;

import E3.q;
import androidx.datastore.core.DataStore;
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
public final class SharedSessionRepositoryImpl_Factory implements Factory<SharedSessionRepositoryImpl> {
    private final p141y3.a backgroundDispatcherProvider;
    private final p141y3.a processDataManagerProvider;
    private final p141y3.a sessionDataStoreProvider;
    private final p141y3.a sessionFirelogPublisherProvider;
    private final p141y3.a sessionGeneratorProvider;
    private final p141y3.a sessionsSettingsProvider;
    private final p141y3.a timeProvider;

    public SharedSessionRepositoryImpl_Factory(p141y3.a aVar, p141y3.a aVar2, p141y3.a aVar3, p141y3.a aVar4, p141y3.a aVar5, p141y3.a aVar6, p141y3.a aVar7) {
        this.sessionsSettingsProvider = aVar;
        this.sessionGeneratorProvider = aVar2;
        this.sessionFirelogPublisherProvider = aVar3;
        this.timeProvider = aVar4;
        this.sessionDataStoreProvider = aVar5;
        this.processDataManagerProvider = aVar6;
        this.backgroundDispatcherProvider = aVar7;
    }

    public static SharedSessionRepositoryImpl_Factory create(p141y3.a aVar, p141y3.a aVar2, p141y3.a aVar3, p141y3.a aVar4, p141y3.a aVar5, p141y3.a aVar6, p141y3.a aVar7) {
        return new SharedSessionRepositoryImpl_Factory(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static SharedSessionRepositoryImpl newInstance(SessionsSettings sessionsSettings, SessionGenerator sessionGenerator, SessionFirelogPublisher sessionFirelogPublisher, TimeProvider timeProvider, DataStore<SessionData> dataStore, ProcessDataManager processDataManager, q qVar) {
        return new SharedSessionRepositoryImpl(sessionsSettings, sessionGenerator, sessionFirelogPublisher, timeProvider, dataStore, processDataManager, qVar);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p141y3.a
    public SharedSessionRepositoryImpl get() {
        return newInstance((SessionsSettings) this.sessionsSettingsProvider.get(), (SessionGenerator) this.sessionGeneratorProvider.get(), (SessionFirelogPublisher) this.sessionFirelogPublisherProvider.get(), (TimeProvider) this.timeProvider.get(), (DataStore) this.sessionDataStoreProvider.get(), (ProcessDataManager) this.processDataManagerProvider.get(), (q) this.backgroundDispatcherProvider.get());
    }
}
