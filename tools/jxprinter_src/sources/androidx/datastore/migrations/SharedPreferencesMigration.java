package androidx.datastore.migrations;

import A3.T;
import E3.g;
import F3.i;
import G3.b;
import G3.d;
import G3.f;
import G3.m;
import O3.a;
import O3.p;
import O3.q;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.datastore.core.DataMigration;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class SharedPreferencesMigration<T> implements DataMigration<T> {
    private final Context context;
    private final Set<String> keySet;
    private final q migrate;
    private final String name;
    private final InterfaceC1934n sharedPrefs$delegate;
    private final p shouldRunMigration;

    /* JADX INFO: renamed from: androidx.datastore.migrations.SharedPreferencesMigration$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.migrations.SharedPreferencesMigration$1", f = "SharedPreferencesMigration.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends m implements p {
        int label;

        public AnonymousClass1(g<? super AnonymousClass1> gVar) {
            super(2, gVar);
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return new AnonymousClass1(gVar);
        }

        @Override // O3.p
        public final Object invoke(T t6, g<? super Boolean> gVar) {
            return ((AnonymousClass1) create(t6, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            i.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return b.boxBoolean(true);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.migrations.SharedPreferencesMigration$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.migrations.SharedPreferencesMigration$2", f = "SharedPreferencesMigration.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends m implements p {
        int label;

        public AnonymousClass2(g<? super AnonymousClass2> gVar) {
            super(2, gVar);
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return new AnonymousClass2(gVar);
        }

        @Override // O3.p
        public final Object invoke(T t6, g<? super Boolean> gVar) {
            return ((AnonymousClass2) create(t6, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            i.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return b.boxBoolean(true);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.migrations.SharedPreferencesMigration$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.migrations.SharedPreferencesMigration$3", f = "SharedPreferencesMigration.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends m implements p {
        int label;

        public AnonymousClass3(g<? super AnonymousClass3> gVar) {
            super(2, gVar);
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            return new AnonymousClass3(gVar);
        }

        @Override // O3.p
        public final Object invoke(T t6, g<? super Boolean> gVar) {
            return ((AnonymousClass3) create(t6, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            i.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return b.boxBoolean(true);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.migrations.SharedPreferencesMigration$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AnonymousClass4 extends F implements a {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $sharedPreferencesName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Context context, String str) {
            super(0);
            this.$context = context;
            this.$sharedPreferencesName = str;
        }

        @Override // O3.a
        public final SharedPreferences invoke() {
            SharedPreferences sharedPreferences = this.$context.getSharedPreferences(this.$sharedPreferencesName, 0);
            E.e(sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
            return sharedPreferences;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @RequiresApi(24)
    public static final class Api24Impl {
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @DoNotInline
        public static final boolean deleteSharedPreferences(Context context, String name) {
            E.f(context, "context");
            E.f(name, "name");
            return context.deleteSharedPreferences(name);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.migrations.SharedPreferencesMigration", f = "SharedPreferencesMigration.android.kt", i = {0}, l = {151}, m = "shouldMigrate", n = {"this"}, s = {"L$0"})
    public static final class C03451 extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SharedPreferencesMigration<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03451(SharedPreferencesMigration<T> sharedPreferencesMigration, g<? super C03451> gVar) {
            super(gVar);
            this.this$0 = sharedPreferencesMigration;
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.shouldMigrate(null, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(a produceSharedPreferences, q migrate) {
        this(produceSharedPreferences, (Set) null, (p) null, migrate, 6, (AbstractC1107v) null);
        E.f(produceSharedPreferences, "produceSharedPreferences");
        E.f(migrate, "migrate");
    }

    private final void deleteSharedPreferences(Context context, String str) {
        Api24Impl.deleteSharedPreferences(context, str);
    }

    private final SharedPreferences getSharedPrefs() {
        return (SharedPreferences) this.sharedPrefs$delegate.getValue();
    }

    private final File getSharedPrefsBackup(File file) {
        return new File(file.getPath() + ".bak");
    }

    private final File getSharedPrefsFile(Context context, String str) {
        return new File(new File(context.getApplicationInfo().dataDir, "shared_prefs"), androidx.collection.a.n(str, ".xml"));
    }

    @Override // androidx.datastore.core.DataMigration
    public Object cleanUp(g<? super Q> gVar) throws IOException {
        Context context;
        String str;
        SharedPreferences.Editor editorEdit = getSharedPrefs().edit();
        Set<String> set = this.keySet;
        if (set == null) {
            editorEdit.clear();
        } else {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                editorEdit.remove((String) it.next());
            }
        }
        if (!editorEdit.commit()) {
            throw new IOException("Unable to delete migrated keys from SharedPreferences.");
        }
        if (getSharedPrefs().getAll().isEmpty() && (context = this.context) != null && (str = this.name) != null) {
            deleteSharedPreferences(context, str);
        }
        Set<String> set2 = this.keySet;
        if (set2 != null) {
            set2.clear();
        }
        return Q.INSTANCE;
    }

    @Override // androidx.datastore.core.DataMigration
    public Object migrate(T t6, g<? super T> gVar) {
        return this.migrate.invoke(new SharedPreferencesView(getSharedPrefs(), this.keySet), t6, gVar);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x006c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.datastore.core.DataMigration
    public Object shouldMigrate(T t6, g<? super Boolean> gVar) throws Throwable {
        C03451 c03451;
        SharedPreferencesMigration<T> sharedPreferencesMigration;
        if (gVar instanceof C03451) {
            c03451 = (C03451) gVar;
            int i5 = c03451.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c03451.label = i5 - Integer.MIN_VALUE;
            } else {
                c03451 = new C03451(this, gVar);
            }
        } else {
            c03451 = new C03451(this, gVar);
        }
        Object objInvoke = c03451.result;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c03451.label;
        boolean z6 = true;
        if (i6 == 0) {
            v.throwOnFailure(objInvoke);
            p pVar = this.shouldRunMigration;
            c03451.L$0 = this;
            c03451.label = 1;
            objInvoke = pVar.invoke(t6, c03451);
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            sharedPreferencesMigration = this;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sharedPreferencesMigration = (SharedPreferencesMigration) c03451.L$0;
            v.throwOnFailure(objInvoke);
        }
        if (!((Boolean) objInvoke).booleanValue()) {
            return b.boxBoolean(false);
        }
        Set<String> set = sharedPreferencesMigration.keySet;
        if (set == null) {
            Map<String, ?> all = sharedPreferencesMigration.getSharedPrefs().getAll();
            E.e(all, "sharedPrefs.all");
            if (all.isEmpty()) {
                z6 = false;
            }
        } else {
            SharedPreferences sharedPrefs = sharedPreferencesMigration.getSharedPrefs();
            if (set == null || !set.isEmpty()) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    if (sharedPrefs.contains((String) it.next())) {
                    }
                }
                z6 = false;
            } else {
                z6 = false;
            }
        }
        return b.boxBoolean(z6);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(a produceSharedPreferences, Set<String> keysToMigrate, q migrate) {
        this(produceSharedPreferences, keysToMigrate, (p) null, migrate, 4, (AbstractC1107v) null);
        E.f(produceSharedPreferences, "produceSharedPreferences");
        E.f(keysToMigrate, "keysToMigrate");
        E.f(migrate, "migrate");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(Context context, String sharedPreferencesName, q migrate) {
        this(context, sharedPreferencesName, null, null, migrate, 12, null);
        E.f(context, "context");
        E.f(sharedPreferencesName, "sharedPreferencesName");
        E.f(migrate, "migrate");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(Context context, String sharedPreferencesName, Set<String> keysToMigrate, q migrate) {
        this(context, sharedPreferencesName, keysToMigrate, null, migrate, 8, null);
        E.f(context, "context");
        E.f(sharedPreferencesName, "sharedPreferencesName");
        E.f(keysToMigrate, "keysToMigrate");
        E.f(migrate, "migrate");
    }

    private SharedPreferencesMigration(a aVar, Set<String> set, p pVar, q qVar, Context context, String str) {
        this.shouldRunMigration = pVar;
        this.migrate = qVar;
        this.context = context;
        this.name = str;
        this.sharedPrefs$delegate = AbstractC1935o.lazy(aVar);
        this.keySet = set == SharedPreferencesMigration_androidKt.getMIGRATE_ALL_KEYS() ? null : T.toMutableSet(set);
    }

    public /* synthetic */ SharedPreferencesMigration(a aVar, Set set, p pVar, q qVar, Context context, String str, int i5, AbstractC1107v abstractC1107v) {
        this(aVar, (Set<String>) set, (i5 & 4) != 0 ? new AnonymousClass1(null) : pVar, qVar, context, str);
    }

    public /* synthetic */ SharedPreferencesMigration(a aVar, Set set, p pVar, q qVar, int i5, AbstractC1107v abstractC1107v) {
        this(aVar, (Set<String>) ((i5 & 2) != 0 ? SharedPreferencesMigration_androidKt.getMIGRATE_ALL_KEYS() : set), (i5 & 4) != 0 ? new AnonymousClass2(null) : pVar, qVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(a produceSharedPreferences, Set<String> keysToMigrate, p shouldRunMigration, q migrate) {
        this(produceSharedPreferences, keysToMigrate, shouldRunMigration, migrate, (Context) null, (String) null);
        E.f(produceSharedPreferences, "produceSharedPreferences");
        E.f(keysToMigrate, "keysToMigrate");
        E.f(shouldRunMigration, "shouldRunMigration");
        E.f(migrate, "migrate");
    }

    public /* synthetic */ SharedPreferencesMigration(Context context, String str, Set set, p pVar, q qVar, int i5, AbstractC1107v abstractC1107v) {
        this(context, str, (i5 & 4) != 0 ? SharedPreferencesMigration_androidKt.getMIGRATE_ALL_KEYS() : set, (i5 & 8) != 0 ? new AnonymousClass3(null) : pVar, qVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(Context context, String sharedPreferencesName, Set<String> keysToMigrate, p shouldRunMigration, q migrate) {
        this(new AnonymousClass4(context, sharedPreferencesName), keysToMigrate, shouldRunMigration, migrate, context, sharedPreferencesName);
        E.f(context, "context");
        E.f(sharedPreferencesName, "sharedPreferencesName");
        E.f(keysToMigrate, "keysToMigrate");
        E.f(shouldRunMigration, "shouldRunMigration");
        E.f(migrate, "migrate");
    }
}
