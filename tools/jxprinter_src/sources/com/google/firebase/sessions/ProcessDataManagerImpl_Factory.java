package com.google.firebase.sessions;

import android.content.Context;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
public final class ProcessDataManagerImpl_Factory implements Factory<ProcessDataManagerImpl> {
    private final p141y3.a appContextProvider;
    private final p141y3.a uuidGeneratorProvider;

    public ProcessDataManagerImpl_Factory(p141y3.a aVar, p141y3.a aVar2) {
        this.appContextProvider = aVar;
        this.uuidGeneratorProvider = aVar2;
    }

    public static ProcessDataManagerImpl_Factory create(p141y3.a aVar, p141y3.a aVar2) {
        return new ProcessDataManagerImpl_Factory(aVar, aVar2);
    }

    public static ProcessDataManagerImpl newInstance(Context context, UuidGenerator uuidGenerator) {
        return new ProcessDataManagerImpl(context, uuidGenerator);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p141y3.a
    public ProcessDataManagerImpl get() {
        return newInstance((Context) this.appContextProvider.get(), (UuidGenerator) this.uuidGeneratorProvider.get());
    }
}
