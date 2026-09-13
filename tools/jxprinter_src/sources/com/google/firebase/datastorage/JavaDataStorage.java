package com.google.firebase.datastorage;

import A3.G;
import A3.k0;
import E3.g;
import F3.i;
import G3.b;
import G3.f;
import G3.m;
import O3.l;
import O3.p;
import V3.o;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.SharedPreferencesMigrationKt;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import androidx.datastore.preferences.core.PreferencesKt;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.U;
import p007a4.AbstractC0275f;
import p007a4.M;
import p023d4.AbstractC0618q;
import p023d4.InterfaceC0612o;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaDataStorage {
    static final /* synthetic */ o[] $$delegatedProperties;
    private final Context context;
    private final DataStore<Preferences> dataStore;
    private final R3.a dataStore$delegate;
    private final ThreadLocal<Boolean> editLock;
    private final String name;

    /* JADX INFO: renamed from: com.google.firebase.datastorage.JavaDataStorage$contains$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "com.google.firebase.datastorage.JavaDataStorage$contains$1", f = "JavaDataStorage.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends m implements p {
        final /* synthetic */ Preferences.Key<T> $key;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Preferences.Key<T> key, g<? super AnonymousClass1> gVar) {
            super(2, gVar);
            this.$key = key;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return JavaDataStorage.this.new AnonymousClass1(this.$key, gVar);
        }

        @Override // O3.p
        public final Object invoke(M m6, g<? super Boolean> gVar) {
            return ((AnonymousClass1) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                v.throwOnFailure(obj);
                InterfaceC0612o data = JavaDataStorage.this.dataStore.getData();
                this.label = 1;
                obj = AbstractC0618q.firstOrNull(data, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
            }
            Preferences preferences = (Preferences) obj;
            return b.boxBoolean(preferences != null ? preferences.contains(this.$key) : false);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.datastorage.JavaDataStorage$editSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "com.google.firebase.datastorage.JavaDataStorage$editSync$1", f = "JavaDataStorage.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05391 extends m implements p {
        final /* synthetic */ l $transform;
        int label;

        /* JADX INFO: renamed from: com.google.firebase.datastorage.JavaDataStorage$editSync$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        @f(c = "com.google.firebase.datastorage.JavaDataStorage$editSync$1$1", f = "JavaDataStorage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C01181 extends m implements p {
            final /* synthetic */ l $transform;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01181(l lVar, g<? super C01181> gVar) {
                super(2, gVar);
                this.$transform = lVar;
            }

            @Override // G3.a
            public final g<Q> create(Object obj, g<?> gVar) {
                C01181 c01181 = new C01181(this.$transform, gVar);
                c01181.L$0 = obj;
                return c01181;
            }

            @Override // O3.p
            public final Object invoke(MutablePreferences mutablePreferences, g<? super Q> gVar) {
                return ((C01181) create(mutablePreferences, gVar)).invokeSuspend(Q.INSTANCE);
            }

            @Override // G3.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                i.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
                this.$transform.invoke((MutablePreferences) this.L$0);
                return Q.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C05391(l lVar, g<? super C05391> gVar) {
            super(2, gVar);
            this.$transform = lVar;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return JavaDataStorage.this.new C05391(this.$transform, gVar);
        }

        @Override // O3.p
        public final Object invoke(M m6, g<? super Preferences> gVar) {
            return ((C05391) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            try {
                if (i5 == 0) {
                    v.throwOnFailure(obj);
                    if (E.a(JavaDataStorage.this.editLock.get(), b.boxBoolean(true))) {
                        throw new IllegalStateException("Don't call JavaDataStorage.edit() from within an existing edit() callback.\nThis causes deadlocks, and is generally indicative of a code smell.\nInstead, either pass around the initial `MutablePreferences` instance, or don't do everything in a single callback. ");
                    }
                    JavaDataStorage.this.editLock.set(b.boxBoolean(true));
                    DataStore dataStore = JavaDataStorage.this.dataStore;
                    C01181 c01181 = new C01181(this.$transform, null);
                    this.label = 1;
                    obj = PreferencesKt.edit(dataStore, c01181, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj);
                }
                Preferences preferences = (Preferences) obj;
                JavaDataStorage.this.editLock.set(b.boxBoolean(false));
                return preferences;
            } catch (Throwable th) {
                JavaDataStorage.this.editLock.set(b.boxBoolean(false));
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.datastorage.JavaDataStorage$getAllSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "com.google.firebase.datastorage.JavaDataStorage$getAllSync$1", f = "JavaDataStorage.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05401 extends m implements p {
        int label;

        public C05401(g<? super C05401> gVar) {
            super(2, gVar);
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return JavaDataStorage.this.new C05401(gVar);
        }

        @Override // O3.p
        public final Object invoke(M m6, g<? super Map<Preferences.Key<?>, ? extends Object>> gVar) {
            return ((C05401) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Map<Preferences.Key<?>, Object> mapAsMap;
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                v.throwOnFailure(obj);
                InterfaceC0612o data = JavaDataStorage.this.dataStore.getData();
                this.label = 1;
                obj = AbstractC0618q.firstOrNull(data, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
            }
            Preferences preferences = (Preferences) obj;
            return (preferences == null || (mapAsMap = preferences.asMap()) == null) ? k0.emptyMap() : mapAsMap;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.datastorage.JavaDataStorage$getSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "com.google.firebase.datastorage.JavaDataStorage$getSync$1", f = "JavaDataStorage.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05411 extends m implements p {
        final /* synthetic */ T $defaultValue;
        final /* synthetic */ Preferences.Key<T> $key;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C05411(Preferences.Key<T> key, T t6, g<? super C05411> gVar) {
            super(2, gVar);
            this.$key = key;
            this.$defaultValue = t6;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return JavaDataStorage.this.new C05411(this.$key, this.$defaultValue, gVar);
        }

        @Override // O3.p
        public final Object invoke(M m6, g<? super T> gVar) {
            return ((C05411) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object obj2;
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                v.throwOnFailure(obj);
                InterfaceC0612o data = JavaDataStorage.this.dataStore.getData();
                this.label = 1;
                obj = AbstractC0618q.firstOrNull(data, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
            }
            Preferences preferences = (Preferences) obj;
            return (preferences == null || (obj2 = preferences.get(this.$key)) == null) ? this.$defaultValue : obj2;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.datastorage.JavaDataStorage$putSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "com.google.firebase.datastorage.JavaDataStorage$putSync$1", f = "JavaDataStorage.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05421 extends m implements p {
        final /* synthetic */ Preferences.Key<T> $key;
        final /* synthetic */ T $value;
        int label;

        /* JADX INFO: renamed from: com.google.firebase.datastorage.JavaDataStorage$putSync$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        @f(c = "com.google.firebase.datastorage.JavaDataStorage$putSync$1$1", f = "JavaDataStorage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C01191 extends m implements p {
            final /* synthetic */ Preferences.Key<T> $key;
            final /* synthetic */ T $value;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01191(Preferences.Key<T> key, T t6, g<? super C01191> gVar) {
                super(2, gVar);
                this.$key = key;
                this.$value = t6;
            }

            @Override // G3.a
            public final g<Q> create(Object obj, g<?> gVar) {
                C01191 c01191 = new C01191(this.$key, this.$value, gVar);
                c01191.L$0 = obj;
                return c01191;
            }

            @Override // O3.p
            public final Object invoke(MutablePreferences mutablePreferences, g<? super Q> gVar) {
                return ((C01191) create(mutablePreferences, gVar)).invokeSuspend(Q.INSTANCE);
            }

            @Override // G3.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                i.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
                ((MutablePreferences) this.L$0).set(this.$key, this.$value);
                return Q.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C05421(Preferences.Key<T> key, T t6, g<? super C05421> gVar) {
            super(2, gVar);
            this.$key = key;
            this.$value = t6;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return JavaDataStorage.this.new C05421(this.$key, this.$value, gVar);
        }

        @Override // O3.p
        public final Object invoke(M m6, g<? super Preferences> gVar) {
            return ((C05421) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 != 0) {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.throwOnFailure(obj);
                return obj;
            }
            v.throwOnFailure(obj);
            DataStore dataStore = JavaDataStorage.this.dataStore;
            C01191 c01191 = new C01191(this.$key, this.$value, null);
            this.label = 1;
            Object objEdit = PreferencesKt.edit(dataStore, c01191, this);
            return objEdit == coroutine_suspended ? coroutine_suspended : objEdit;
        }
    }

    static {
        N n6 = new N(JavaDataStorage.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0);
        U.f5690a.getClass();
        $$delegatedProperties = new o[]{n6};
    }

    public JavaDataStorage(Context context, String name) {
        E.f(context, "context");
        E.f(name, "name");
        this.context = context;
        this.name = name;
        this.editLock = new ThreadLocal<>();
        final int i5 = 0;
        final int i6 = 1;
        this.dataStore$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default(name, new ReplaceFileCorruptionHandler(new l(this) { // from class: com.google.firebase.datastorage.a
            public final /* synthetic */ JavaDataStorage b;

            {
                this.b = this;
            }

            @Override // O3.l
            public final Object invoke(Object obj) {
                switch (i5) {
                    case 0:
                        return JavaDataStorage.dataStore_delegate$lambda$0(this.b, (CorruptionException) obj);
                    default:
                        return JavaDataStorage.dataStore_delegate$lambda$1(this.b, (Context) obj);
                }
            }
        }), new l(this) { // from class: com.google.firebase.datastorage.a
            public final /* synthetic */ JavaDataStorage b;

            {
                this.b = this;
            }

            @Override // O3.l
            public final Object invoke(Object obj) {
                switch (i6) {
                    case 0:
                        return JavaDataStorage.dataStore_delegate$lambda$0(this.b, (CorruptionException) obj);
                    default:
                        return JavaDataStorage.dataStore_delegate$lambda$1(this.b, (Context) obj);
                }
            }
        }, null, 8, null);
        this.dataStore = getDataStore(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Preferences dataStore_delegate$lambda$0(JavaDataStorage javaDataStorage, CorruptionException ex) {
        E.f(ex, "ex");
        Log.w(U.a(JavaDataStorage.class).getSimpleName(), "CorruptionException in " + javaDataStorage.name + " DataStore running in process " + Process.myPid(), ex);
        return PreferencesFactory.createEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List dataStore_delegate$lambda$1(JavaDataStorage javaDataStorage, Context it) {
        E.f(it, "it");
        return G.listOf(SharedPreferencesMigrationKt.SharedPreferencesMigration$default(it, javaDataStorage.name, null, 4, null));
    }

    private final DataStore<Preferences> getDataStore(Context context) {
        return (DataStore) this.dataStore$delegate.getValue(context, $$delegatedProperties[0]);
    }

    public final <T> boolean contains(Preferences.Key<T> key) {
        E.f(key, "key");
        return ((Boolean) AbstractC0275f.runBlocking$default(null, new AnonymousClass1(key, null), 1, null)).booleanValue();
    }

    public final Preferences editSync(l transform) {
        E.f(transform, "transform");
        return (Preferences) AbstractC0275f.runBlocking$default(null, new C05391(transform, null), 1, null);
    }

    public final Map<Preferences.Key<?>, Object> getAllSync() {
        return (Map) AbstractC0275f.runBlocking$default(null, new C05401(null), 1, null);
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getName() {
        return this.name;
    }

    public final <T> T getSync(Preferences.Key<T> key, T t6) {
        E.f(key, "key");
        return (T) AbstractC0275f.runBlocking$default(null, new C05411(key, t6, null), 1, null);
    }

    public final <T> Preferences putSync(Preferences.Key<T> key, T t6) {
        E.f(key, "key");
        return (Preferences) AbstractC0275f.runBlocking$default(null, new C05421(key, t6, null), 1, null);
    }
}
