package com.google.firebase.sessions.settings;

import A3.k0;
import E3.g;
import G3.d;
import G3.f;
import X3.G;
import Y3.a;
import Y3.e;
import android.os.Build;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.FirebaseSessions;
import com.google.firebase.sessions.InstallationId;
import com.google.firebase.sessions.TimeProvider;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import p049i4.b;
import p049i4.i;
import p147z3.A;
import p147z3.C1938s;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RemoteSettings implements SettingsProvider {
    private static final Companion Companion = new Companion(null);
    private static final int defaultCacheDuration;
    private static final G sanitizeRegex;
    private final ApplicationInfo appInfo;
    private final CrashlyticsSettingsFetcher configsFetcher;
    private final b fetchInProgress;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final SettingsCache settingsCache;
    private final TimeProvider timeProvider;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }

        public final int getDefaultCacheDuration() {
            return RemoteSettings.defaultCacheDuration;
        }

        public final G getSanitizeRegex() {
            return RemoteSettings.sanitizeRegex;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "com.google.firebase.sessions.settings.RemoteSettings", f = "RemoteSettings.kt", i = {0, 0, 1, 1, 2}, l = {165, 78, 95}, m = "updateSettings", n = {"this", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
    public static final class AnonymousClass1 extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(g<? super AnonymousClass1> gVar) {
            super(gVar);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteSettings.this.updateSettings(this);
        }
    }

    static {
        a aVar = Y3.b.Companion;
        defaultCacheDuration = (int) Y3.b.m920toLongimpl(Y3.d.toDuration(24, e.HOURS), e.SECONDS);
        sanitizeRegex = new G(PackagingURIHelper.FORWARD_SLASH_STRING);
    }

    public RemoteSettings(TimeProvider timeProvider, FirebaseInstallationsApi firebaseInstallationsApi, ApplicationInfo appInfo, CrashlyticsSettingsFetcher configsFetcher, SettingsCache settingsCache) {
        E.f(timeProvider, "timeProvider");
        E.f(firebaseInstallationsApi, "firebaseInstallationsApi");
        E.f(appInfo, "appInfo");
        E.f(configsFetcher, "configsFetcher");
        E.f(settingsCache, "settingsCache");
        this.timeProvider = timeProvider;
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.appInfo = appInfo;
        this.configsFetcher = configsFetcher;
        this.settingsCache = settingsCache;
        this.fetchInProgress = i.Mutex(false);
    }

    private final String sanitize(String str) {
        return sanitizeRegex.replace(str, "");
    }

    @VisibleForTesting
    public final Object clearCachedSettings$com_google_firebase_firebase_sessions(g<? super Q> gVar) {
        Object objUpdateConfigs = this.settingsCache.updateConfigs(SessionConfigsSerializer.INSTANCE.getDefaultValue(), gVar);
        return objUpdateConfigs == F3.i.getCOROUTINE_SUSPENDED() ? objUpdateConfigs : Q.INSTANCE;
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Double getSamplingRate() {
        return this.settingsCache.sessionSamplingRate();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Boolean getSessionEnabled() {
        return this.settingsCache.sessionsEnabled();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    /* JADX INFO: renamed from: getSessionRestartTimeout-FghU774 */
    public Y3.b mo1016getSessionRestartTimeoutFghU774() {
        Integer numSessionRestartTimeout = this.settingsCache.sessionRestartTimeout();
        if (numSessionRestartTimeout == null) {
            return null;
        }
        a aVar = Y3.b.Companion;
        return new Y3.b(Y3.d.toDuration(numSessionRestartTimeout.intValue(), e.SECONDS));
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public boolean isSettingsStale() {
        return this.settingsCache.hasCacheExpired();
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00ca A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:21:0x004a, B:47:0x00bc, B:49:0x00ca, B:52:0x00d7), top: B:63:0x004a }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00d7 A[Catch: all -> 0x004f, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:21:0x004a, B:47:0x00bc, B:49:0x00ca, B:52:0x00d7), top: B:63:0x004a }] */
    /* JADX WARN: Code duplicated, block: B:55:0x014e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Instruction removed from duplicated block: B:52:0x00d7, please report this as an issue */
    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Object updateSettings(g<? super Q> gVar) throws Throwable {
        AnonymousClass1 anonymousClass1;
        b bVar;
        RemoteSettings remoteSettings;
        b bVar2;
        Throwable th;
        b bVar3;
        RemoteSettings remoteSettings2;
        String fid;
        Map<String, String> mapMapOf;
        CrashlyticsSettingsFetcher crashlyticsSettingsFetcher;
        RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1;
        RemoteSettings$updateSettings$2$2 remoteSettings$updateSettings$2$2;
        if (gVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) gVar;
            int i5 = anonymousClass1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i5 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(gVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(gVar);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = anonymousClass1.label;
        try {
            if (i6 == 0) {
                v.throwOnFailure(obj);
                if (!((p049i4.g) this.fetchInProgress).c() && !this.settingsCache.hasCacheExpired()) {
                    return Q.INSTANCE;
                }
                b bVar4 = this.fetchInProgress;
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = bVar4;
                anonymousClass1.label = 1;
                bVar = (p049i4.g) bVar4;
                if (bVar.lock(null, anonymousClass1) != coroutine_suspended) {
                    remoteSettings = this;
                }
                return coroutine_suspended;
            }
            if (i6 != 1) {
                if (i6 == 2) {
                    bVar3 = (b) anonymousClass1.L$1;
                    remoteSettings2 = (RemoteSettings) anonymousClass1.L$0;
                    try {
                        v.throwOnFailure(obj);
                        fid = ((InstallationId) obj).getFid();
                        if (E.a(fid, "")) {
                            Log.w(FirebaseSessions.TAG, "Error getting Firebase Installation ID. Skipping this Session Event.");
                            Q q6 = Q.INSTANCE;
                            ((p049i4.g) bVar3).unlock(null);
                            return q6;
                        }
                        C1938s c1938s = A.to("X-Crashlytics-Installation-ID", fid);
                        C1938s c1938s2 = A.to("X-Crashlytics-Device-Model", remoteSettings2.sanitize(Build.MANUFACTURER + Build.MODEL));
                        String INCREMENTAL = Build.VERSION.INCREMENTAL;
                        E.e(INCREMENTAL, "INCREMENTAL");
                        C1938s c1938s3 = A.to("X-Crashlytics-OS-Build-Version", remoteSettings2.sanitize(INCREMENTAL));
                        String RELEASE = Build.VERSION.RELEASE;
                        E.e(RELEASE, "RELEASE");
                        mapMapOf = k0.mapOf(c1938s, c1938s2, c1938s3, A.to("X-Crashlytics-OS-Display-Version", remoteSettings2.sanitize(RELEASE)), A.to("X-Crashlytics-API-Client-Version", remoteSettings2.appInfo.getSessionSdkVersion()));
                        Log.d(FirebaseSessions.TAG, "Fetching settings from server.");
                        crashlyticsSettingsFetcher = remoteSettings2.configsFetcher;
                        remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(remoteSettings2, null);
                        remoteSettings$updateSettings$2$2 = new RemoteSettings$updateSettings$2$2(null);
                        anonymousClass1.L$0 = bVar3;
                        anonymousClass1.L$1 = null;
                        anonymousClass1.label = 3;
                        if (crashlyticsSettingsFetcher.doConfigFetch(mapMapOf, remoteSettings$updateSettings$2$1, remoteSettings$updateSettings$2$2, anonymousClass1) != coroutine_suspended) {
                            bVar2 = bVar3;
                            ((p049i4.g) bVar2).unlock(null);
                            return Q.INSTANCE;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th2) {
                        th = th2;
                        bVar2 = bVar3;
                    }
                } else {
                    if (i6 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    bVar2 = (b) anonymousClass1.L$0;
                    try {
                        v.throwOnFailure(obj);
                        ((p049i4.g) bVar2).unlock(null);
                        return Q.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                ((p049i4.g) bVar2).unlock(null);
                throw th;
            }
            b bVar5 = (b) anonymousClass1.L$1;
            remoteSettings = (RemoteSettings) anonymousClass1.L$0;
            v.throwOnFailure(obj);
            bVar = bVar5;
            if (!remoteSettings.settingsCache.hasCacheExpired()) {
                Log.d(FirebaseSessions.TAG, "Remote settings cache not expired. Using cached values.");
                Q q7 = Q.INSTANCE;
                ((p049i4.g) bVar).unlock(null);
                return q7;
            }
            InstallationId.Companion companion = InstallationId.Companion;
            FirebaseInstallationsApi firebaseInstallationsApi = remoteSettings.firebaseInstallationsApi;
            anonymousClass1.L$0 = remoteSettings;
            anonymousClass1.L$1 = bVar;
            anonymousClass1.label = 2;
            Object objCreate = companion.create(firebaseInstallationsApi, anonymousClass1);
            if (objCreate != coroutine_suspended) {
                bVar3 = bVar;
                obj = objCreate;
                remoteSettings2 = remoteSettings;
                fid = ((InstallationId) obj).getFid();
                if (E.a(fid, "")) {
                    Log.w(FirebaseSessions.TAG, "Error getting Firebase Installation ID. Skipping this Session Event.");
                    Q q8 = Q.INSTANCE;
                    ((p049i4.g) bVar3).unlock(null);
                    return q8;
                }
                C1938s c1938s4 = A.to("X-Crashlytics-Installation-ID", fid);
                C1938s c1938s5 = A.to("X-Crashlytics-Device-Model", remoteSettings2.sanitize(Build.MANUFACTURER + Build.MODEL));
                String INCREMENTAL2 = Build.VERSION.INCREMENTAL;
                E.e(INCREMENTAL2, "INCREMENTAL");
                C1938s c1938s6 = A.to("X-Crashlytics-OS-Build-Version", remoteSettings2.sanitize(INCREMENTAL2));
                String RELEASE2 = Build.VERSION.RELEASE;
                E.e(RELEASE2, "RELEASE");
                mapMapOf = k0.mapOf(c1938s4, c1938s5, c1938s6, A.to("X-Crashlytics-OS-Display-Version", remoteSettings2.sanitize(RELEASE2)), A.to("X-Crashlytics-API-Client-Version", remoteSettings2.appInfo.getSessionSdkVersion()));
                Log.d(FirebaseSessions.TAG, "Fetching settings from server.");
                crashlyticsSettingsFetcher = remoteSettings2.configsFetcher;
                remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(remoteSettings2, null);
                remoteSettings$updateSettings$2$2 = new RemoteSettings$updateSettings$2$2(null);
                anonymousClass1.L$0 = bVar3;
                anonymousClass1.L$1 = null;
                anonymousClass1.label = 3;
                if (crashlyticsSettingsFetcher.doConfigFetch(mapMapOf, remoteSettings$updateSettings$2$1, remoteSettings$updateSettings$2$2, anonymousClass1) != coroutine_suspended) {
                    bVar2 = bVar3;
                    ((p049i4.g) bVar2).unlock(null);
                    return Q.INSTANCE;
                }
            }
            return coroutine_suspended;
        } catch (Throwable th4) {
            bVar2 = bVar;
            th = th4;
        }
    }
}
