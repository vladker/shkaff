package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@QualifierMetadata({"com.google.android.datatransport.runtime.time.WallTime", "com.google.android.datatransport.runtime.time.Monotonic"})
@ScopeMetadata
@DaggerGenerated
public final class Uploader_Factory implements Factory<Uploader> {
    private final p141y3.a backendRegistryProvider;
    private final p141y3.a clientHealthMetricsStoreProvider;
    private final p141y3.a clockProvider;
    private final p141y3.a contextProvider;
    private final p141y3.a eventStoreProvider;
    private final p141y3.a executorProvider;
    private final p141y3.a guardProvider;
    private final p141y3.a uptimeClockProvider;
    private final p141y3.a workSchedulerProvider;

    public Uploader_Factory(p141y3.a aVar, p141y3.a aVar2, p141y3.a aVar3, p141y3.a aVar4, p141y3.a aVar5, p141y3.a aVar6, p141y3.a aVar7, p141y3.a aVar8, p141y3.a aVar9) {
        this.contextProvider = aVar;
        this.backendRegistryProvider = aVar2;
        this.eventStoreProvider = aVar3;
        this.workSchedulerProvider = aVar4;
        this.executorProvider = aVar5;
        this.guardProvider = aVar6;
        this.clockProvider = aVar7;
        this.uptimeClockProvider = aVar8;
        this.clientHealthMetricsStoreProvider = aVar9;
    }

    public static Uploader_Factory create(p141y3.a aVar, p141y3.a aVar2, p141y3.a aVar3, p141y3.a aVar4, p141y3.a aVar5, p141y3.a aVar6, p141y3.a aVar7, p141y3.a aVar8, p141y3.a aVar9) {
        return new Uploader_Factory(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static Uploader newInstance(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        return new Uploader(context, backendRegistry, eventStore, workScheduler, executor, synchronizationGuard, clock, clock2, clientHealthMetricsStore);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, p141y3.a
    public Uploader get() {
        return newInstance((Context) this.contextProvider.get(), (BackendRegistry) this.backendRegistryProvider.get(), (EventStore) this.eventStoreProvider.get(), (WorkScheduler) this.workSchedulerProvider.get(), (Executor) this.executorProvider.get(), (SynchronizationGuard) this.guardProvider.get(), (Clock) this.clockProvider.get(), (Clock) this.uptimeClockProvider.get(), (ClientHealthMetricsStore) this.clientHealthMetricsStoreProvider.get());
    }
}
