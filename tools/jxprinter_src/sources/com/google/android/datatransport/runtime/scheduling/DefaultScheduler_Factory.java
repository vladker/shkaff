package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import p141y3.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@QualifierMetadata
@ScopeMetadata
@DaggerGenerated
public final class DefaultScheduler_Factory implements Factory<DefaultScheduler> {
    private final a backendRegistryProvider;
    private final a eventStoreProvider;
    private final a executorProvider;
    private final a guardProvider;
    private final a workSchedulerProvider;

    public DefaultScheduler_Factory(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        this.executorProvider = aVar;
        this.backendRegistryProvider = aVar2;
        this.workSchedulerProvider = aVar3;
        this.eventStoreProvider = aVar4;
        this.guardProvider = aVar5;
    }

    public static DefaultScheduler_Factory create(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        return new DefaultScheduler_Factory(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static DefaultScheduler newInstance(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        return new DefaultScheduler(executor, backendRegistry, workScheduler, eventStore, synchronizationGuard);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, p141y3.a
    public DefaultScheduler get() {
        return newInstance((Executor) this.executorProvider.get(), (BackendRegistry) this.backendRegistryProvider.get(), (WorkScheduler) this.workSchedulerProvider.get(), (EventStore) this.eventStoreProvider.get(), (SynchronizationGuard) this.guardProvider.get());
    }
}
