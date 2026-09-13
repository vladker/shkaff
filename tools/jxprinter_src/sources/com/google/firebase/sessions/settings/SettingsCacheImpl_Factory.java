package com.google.firebase.sessions.settings;

import E3.q;
import androidx.datastore.core.DataStore;
import com.google.firebase.sessions.TimeProvider;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import p141y3.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({"com.google.firebase.annotations.concurrent.Background"})
@DaggerGenerated
public final class SettingsCacheImpl_Factory implements Factory<SettingsCacheImpl> {
    private final a backgroundDispatcherProvider;
    private final a sessionConfigsDataStoreProvider;
    private final a timeProvider;

    public SettingsCacheImpl_Factory(a aVar, a aVar2, a aVar3) {
        this.backgroundDispatcherProvider = aVar;
        this.timeProvider = aVar2;
        this.sessionConfigsDataStoreProvider = aVar3;
    }

    public static SettingsCacheImpl_Factory create(a aVar, a aVar2, a aVar3) {
        return new SettingsCacheImpl_Factory(aVar, aVar2, aVar3);
    }

    public static SettingsCacheImpl newInstance(q qVar, TimeProvider timeProvider, DataStore<SessionConfigs> dataStore) {
        return new SettingsCacheImpl(qVar, timeProvider, dataStore);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p141y3.a
    public SettingsCacheImpl get() {
        return newInstance((q) this.backgroundDispatcherProvider.get(), (TimeProvider) this.timeProvider.get(), (DataStore) this.sessionConfigsDataStoreProvider.get());
    }
}
