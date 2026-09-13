package com.google.firebase.sessions;

import E3.q;
import android.content.Context;
import androidx.datastore.core.DataStore;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({"com.google.firebase.annotations.concurrent.Blocking"})
@DaggerGenerated
public final class FirebaseSessionsComponent_MainModule_Companion_SessionDataStoreFactory implements Factory<DataStore<SessionData>> {
    private final p141y3.a appContextProvider;
    private final p141y3.a blockingDispatcherProvider;
    private final p141y3.a sessionDataSerializerProvider;

    public FirebaseSessionsComponent_MainModule_Companion_SessionDataStoreFactory(p141y3.a aVar, p141y3.a aVar2, p141y3.a aVar3) {
        this.appContextProvider = aVar;
        this.blockingDispatcherProvider = aVar2;
        this.sessionDataSerializerProvider = aVar3;
    }

    public static FirebaseSessionsComponent_MainModule_Companion_SessionDataStoreFactory create(p141y3.a aVar, p141y3.a aVar2, p141y3.a aVar3) {
        return new FirebaseSessionsComponent_MainModule_Companion_SessionDataStoreFactory(aVar, aVar2, aVar3);
    }

    public static DataStore<SessionData> sessionDataStore(Context context, q qVar, SessionDataSerializer sessionDataSerializer) {
        return (DataStore) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.Companion.sessionDataStore(context, qVar, sessionDataSerializer));
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p141y3.a
    public DataStore<SessionData> get() {
        return sessionDataStore((Context) this.appContextProvider.get(), (q) this.blockingDispatcherProvider.get(), (SessionDataSerializer) this.sessionDataSerializerProvider.get());
    }
}
