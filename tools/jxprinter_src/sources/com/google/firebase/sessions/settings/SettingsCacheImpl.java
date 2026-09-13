package com.google.firebase.sessions.settings;

import E3.g;
import E3.q;
import F3.i;
import G3.b;
import G3.d;
import G3.f;
import G3.m;
import O3.p;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.datastore.core.DataStore;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.sessions.FirebaseSessions;
import com.google.firebase.sessions.TimeProvider;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.C1087a;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.InterfaceC1110y;
import p007a4.AbstractC0272e;
import p007a4.AbstractC0275f;
import p007a4.M;
import p007a4.N;
import p023d4.InterfaceC0612o;
import p023d4.InterfaceC0615p;
import p147z3.InterfaceC1927g;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class SettingsCacheImpl implements SettingsCache {
    private final q backgroundDispatcher;
    private final AtomicReference<SessionConfigs> sessionConfigsAtomicReference;
    private final DataStore<SessionConfigs> sessionConfigsDataStore;
    private final TimeProvider timeProvider;

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.SettingsCacheImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "com.google.firebase.sessions.settings.SettingsCacheImpl$1", f = "SettingsCache.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends m implements p {
        int label;

        /* JADX INFO: renamed from: com.google.firebase.sessions.settings.SettingsCacheImpl$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public /* synthetic */ class C01231 implements InterfaceC0615p, InterfaceC1110y {
            final /* synthetic */ AtomicReference<SessionConfigs> $tmp0;

            public C01231(AtomicReference<SessionConfigs> atomicReference) {
                this.$tmp0 = atomicReference;
            }

            public final Object emit(SessionConfigs sessionConfigs, g<? super Q> gVar) {
                Object objInvokeSuspend$set = AnonymousClass1.invokeSuspend$set(this.$tmp0, sessionConfigs, gVar);
                return objInvokeSuspend$set == i.getCOROUTINE_SUSPENDED() ? objInvokeSuspend$set : Q.INSTANCE;
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof InterfaceC0615p) && (obj instanceof InterfaceC1110y)) {
                    return E.a(getFunctionDelegate(), ((InterfaceC1110y) obj).getFunctionDelegate());
                }
                return false;
            }

            @Override // kotlin.jvm.internal.InterfaceC1110y
            public final InterfaceC1927g getFunctionDelegate() {
                return new C1087a(this.$tmp0);
            }

            public final int hashCode() {
                return getFunctionDelegate().hashCode();
            }

            @Override // p023d4.InterfaceC0615p
            public /* bridge */ /* synthetic */ Object emit(Object obj, g gVar) {
                return emit((SessionConfigs) obj, (g<? super Q>) gVar);
            }
        }

        public AnonymousClass1(g<? super AnonymousClass1> gVar) {
            super(2, gVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ Object invokeSuspend$set(AtomicReference atomicReference, SessionConfigs sessionConfigs, g gVar) {
            atomicReference.set(sessionConfigs);
            return Q.INSTANCE;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return SettingsCacheImpl.this.new AnonymousClass1(gVar);
        }

        @Override // O3.p
        public final Object invoke(M m6, g<? super Q> gVar) {
            return ((AnonymousClass1) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                v.throwOnFailure(obj);
                InterfaceC0612o data = SettingsCacheImpl.this.sessionConfigsDataStore.getData();
                C01231 c01231 = new C01231(SettingsCacheImpl.this.sessionConfigsAtomicReference);
                this.label = 1;
                if (data.collect(c01231, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
            }
            return Q.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.SettingsCacheImpl$updateConfigs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "com.google.firebase.sessions.settings.SettingsCacheImpl", f = "SettingsCache.kt", i = {}, l = {98}, m = "updateConfigs", n = {}, s = {})
    public static final class C05471 extends d {
        int label;
        /* synthetic */ Object result;

        public C05471(g<? super C05471> gVar) {
            super(gVar);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SettingsCacheImpl.this.updateConfigs(null, this);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.SettingsCacheImpl$updateConfigs$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "com.google.firebase.sessions.settings.SettingsCacheImpl$updateConfigs$2", f = "SettingsCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends m implements p {
        final /* synthetic */ SessionConfigs $sessionConfigs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SessionConfigs sessionConfigs, g<? super AnonymousClass2> gVar) {
            super(2, gVar);
            this.$sessionConfigs = sessionConfigs;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return new AnonymousClass2(this.$sessionConfigs, gVar);
        }

        @Override // O3.p
        public final Object invoke(SessionConfigs sessionConfigs, g<? super SessionConfigs> gVar) {
            return ((AnonymousClass2) create(sessionConfigs, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            i.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return this.$sessionConfigs;
        }
    }

    public SettingsCacheImpl(@Background q backgroundDispatcher, TimeProvider timeProvider, DataStore<SessionConfigs> sessionConfigsDataStore) {
        E.f(backgroundDispatcher, "backgroundDispatcher");
        E.f(timeProvider, "timeProvider");
        E.f(sessionConfigsDataStore, "sessionConfigsDataStore");
        this.backgroundDispatcher = backgroundDispatcher;
        this.timeProvider = timeProvider;
        this.sessionConfigsDataStore = sessionConfigsDataStore;
        this.sessionConfigsAtomicReference = new AtomicReference<>();
        AbstractC0272e.b(N.CoroutineScope(backgroundDispatcher), null, 3, new AnonymousClass1(null));
    }

    private final SessionConfigs getSessionConfigs() {
        if (this.sessionConfigsAtomicReference.get() == null) {
            AtomicReference<SessionConfigs> atomicReference = this.sessionConfigsAtomicReference;
            Object objRunBlocking$default = AbstractC0275f.runBlocking$default(null, new SettingsCacheImpl$sessionConfigs$1(this, null), 1, null);
            while (!atomicReference.compareAndSet(null, (SessionConfigs) objRunBlocking$default) && atomicReference.get() == null) {
            }
        }
        SessionConfigs sessionConfigs = this.sessionConfigsAtomicReference.get();
        E.e(sessionConfigs, "get(...)");
        return sessionConfigs;
    }

    @Override // com.google.firebase.sessions.settings.SettingsCache
    public boolean hasCacheExpired() {
        Long cacheUpdatedTimeSeconds = getSessionConfigs().getCacheUpdatedTimeSeconds();
        Integer cacheDurationSeconds = getSessionConfigs().getCacheDurationSeconds();
        return cacheUpdatedTimeSeconds == null || cacheDurationSeconds == null || this.timeProvider.currentTime().getSeconds() - cacheUpdatedTimeSeconds.longValue() >= ((long) cacheDurationSeconds.intValue());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @VisibleForTesting
    public final Object removeConfigs$com_google_firebase_firebase_sessions(g<Object> gVar) throws Throwable {
        SettingsCacheImpl$removeConfigs$1 settingsCacheImpl$removeConfigs$1;
        if (gVar instanceof SettingsCacheImpl$removeConfigs$1) {
            settingsCacheImpl$removeConfigs$1 = (SettingsCacheImpl$removeConfigs$1) gVar;
            int i5 = settingsCacheImpl$removeConfigs$1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                settingsCacheImpl$removeConfigs$1.label = i5 - Integer.MIN_VALUE;
            } else {
                settingsCacheImpl$removeConfigs$1 = new SettingsCacheImpl$removeConfigs$1(this, gVar);
            }
        } else {
            settingsCacheImpl$removeConfigs$1 = new SettingsCacheImpl$removeConfigs$1(this, gVar);
        }
        Object obj = settingsCacheImpl$removeConfigs$1.result;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = settingsCacheImpl$removeConfigs$1.label;
        try {
            if (i6 != 0) {
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
                return obj;
            }
            v.throwOnFailure(obj);
            DataStore<SessionConfigs> dataStore = this.sessionConfigsDataStore;
            SettingsCacheImpl$removeConfigs$2 settingsCacheImpl$removeConfigs$2 = new SettingsCacheImpl$removeConfigs$2(null);
            settingsCacheImpl$removeConfigs$1.label = 1;
            Object objUpdateData = dataStore.updateData(settingsCacheImpl$removeConfigs$2, settingsCacheImpl$removeConfigs$1);
            return objUpdateData == coroutine_suspended ? coroutine_suspended : objUpdateData;
        } catch (IOException e) {
            return b.boxInt(Log.w(FirebaseSessions.TAG, "Failed to remove config values: " + e));
        }
    }

    @Override // com.google.firebase.sessions.settings.SettingsCache
    public Integer sessionRestartTimeout() {
        return getSessionConfigs().getSessionTimeoutSeconds();
    }

    @Override // com.google.firebase.sessions.settings.SettingsCache
    public Double sessionSamplingRate() {
        return getSessionConfigs().getSessionSamplingRate();
    }

    @Override // com.google.firebase.sessions.settings.SettingsCache
    public Boolean sessionsEnabled() {
        return getSessionConfigs().getSessionsEnabled();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.google.firebase.sessions.settings.SettingsCache
    public Object updateConfigs(SessionConfigs sessionConfigs, g<? super Q> gVar) throws Throwable {
        C05471 c05471;
        if (gVar instanceof C05471) {
            c05471 = (C05471) gVar;
            int i5 = c05471.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c05471.label = i5 - Integer.MIN_VALUE;
            } else {
                c05471 = new C05471(gVar);
            }
        } else {
            c05471 = new C05471(gVar);
        }
        Object obj = c05471.result;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c05471.label;
        try {
            if (i6 == 0) {
                v.throwOnFailure(obj);
                DataStore<SessionConfigs> dataStore = this.sessionConfigsDataStore;
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(sessionConfigs, null);
                c05471.label = 1;
                if (dataStore.updateData(anonymousClass2, c05471) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
            }
        } catch (IOException e) {
            Log.w(FirebaseSessions.TAG, "Failed to update config values: " + e);
        }
        return Q.INSTANCE;
    }
}
