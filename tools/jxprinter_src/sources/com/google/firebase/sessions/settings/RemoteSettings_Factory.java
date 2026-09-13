package com.google.firebase.sessions.settings;

import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.TimeProvider;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import p141y3.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
public final class RemoteSettings_Factory implements Factory<RemoteSettings> {
    private final a appInfoProvider;
    private final a configsFetcherProvider;
    private final a firebaseInstallationsApiProvider;
    private final a settingsCacheProvider;
    private final a timeProvider;

    public RemoteSettings_Factory(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        this.timeProvider = aVar;
        this.firebaseInstallationsApiProvider = aVar2;
        this.appInfoProvider = aVar3;
        this.configsFetcherProvider = aVar4;
        this.settingsCacheProvider = aVar5;
    }

    public static RemoteSettings_Factory create(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        return new RemoteSettings_Factory(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static RemoteSettings newInstance(TimeProvider timeProvider, FirebaseInstallationsApi firebaseInstallationsApi, ApplicationInfo applicationInfo, CrashlyticsSettingsFetcher crashlyticsSettingsFetcher, SettingsCache settingsCache) {
        return new RemoteSettings(timeProvider, firebaseInstallationsApi, applicationInfo, crashlyticsSettingsFetcher, settingsCache);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p141y3.a
    public RemoteSettings get() {
        return newInstance((TimeProvider) this.timeProvider.get(), (FirebaseInstallationsApi) this.firebaseInstallationsApiProvider.get(), (ApplicationInfo) this.appInfoProvider.get(), (CrashlyticsSettingsFetcher) this.configsFetcherProvider.get(), (SettingsCache) this.settingsCacheProvider.get());
    }
}
