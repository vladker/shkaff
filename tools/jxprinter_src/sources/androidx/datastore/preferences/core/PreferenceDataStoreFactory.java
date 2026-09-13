package androidx.datastore.preferences.core;

import A3.I;
import A4.V;
import O3.a;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.FileStorage;
import androidx.datastore.core.Storage;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;
import p007a4.C0276f0;
import p007a4.H0;
import p007a4.M;
import p007a4.N;
import p007a4.n1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceDataStoreFactory {
    public static final PreferenceDataStoreFactory INSTANCE = new PreferenceDataStoreFactory();

    /* JADX INFO: renamed from: androidx.datastore.preferences.core.PreferenceDataStoreFactory$createWithPath$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AnonymousClass1 extends F implements a {
        final /* synthetic */ a $produceFile;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(a aVar) {
            super(0);
            this.$produceFile = aVar;
        }

        @Override // O3.a
        public final File invoke() {
            return ((V) this.$produceFile.invoke()).toFile();
        }
    }

    private PreferenceDataStoreFactory() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DataStore create$default(PreferenceDataStoreFactory preferenceDataStoreFactory, Storage storage, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, M m6, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i5 & 4) != 0) {
            list = I.emptyList();
        }
        if ((i5 & 8) != 0) {
            m6 = N.CoroutineScope(Actual_jvmAndroidKt.ioDispatcher().plus(n1.m930SupervisorJob((H0) null)));
        }
        return preferenceDataStoreFactory.create((Storage<Preferences>) storage, (ReplaceFileCorruptionHandler<Preferences>) replaceFileCorruptionHandler, (List<? extends DataMigration<Preferences>>) list, m6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DataStore createWithPath$default(PreferenceDataStoreFactory preferenceDataStoreFactory, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, M m6, a aVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i5 & 2) != 0) {
            list = I.emptyList();
        }
        if ((i5 & 4) != 0) {
            m6 = N.CoroutineScope(Actual_jvmAndroidKt.ioDispatcher().plus(n1.m930SupervisorJob((H0) null)));
        }
        return preferenceDataStoreFactory.createWithPath(replaceFileCorruptionHandler, list, m6, aVar);
    }

    public final DataStore<Preferences> create(a produceFile) {
        E.f(produceFile, "produceFile");
        return create$default(this, (ReplaceFileCorruptionHandler) null, (List) null, (M) null, produceFile, 7, (Object) null);
    }

    public final DataStore<Preferences> createWithPath(a produceFile) {
        E.f(produceFile, "produceFile");
        return createWithPath$default(this, null, null, null, produceFile, 7, null);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage) {
        E.f(storage, "storage");
        return create$default(this, storage, (ReplaceFileCorruptionHandler) null, (List) null, (M) null, 14, (Object) null);
    }

    public final DataStore<Preferences> createWithPath(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, a produceFile) {
        E.f(produceFile, "produceFile");
        return createWithPath$default(this, replaceFileCorruptionHandler, null, null, produceFile, 6, null);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler) {
        E.f(storage, "storage");
        return create$default(this, storage, replaceFileCorruptionHandler, (List) null, (M) null, 12, (Object) null);
    }

    public final DataStore<Preferences> createWithPath(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> migrations, a produceFile) {
        E.f(migrations, "migrations");
        E.f(produceFile, "produceFile");
        return createWithPath$default(this, replaceFileCorruptionHandler, migrations, null, produceFile, 4, null);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> migrations) {
        E.f(storage, "storage");
        E.f(migrations, "migrations");
        return create$default(this, storage, replaceFileCorruptionHandler, migrations, (M) null, 8, (Object) null);
    }

    public final DataStore<Preferences> createWithPath(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> migrations, M scope, a produceFile) {
        E.f(migrations, "migrations");
        E.f(scope, "scope");
        E.f(produceFile, "produceFile");
        return create(replaceFileCorruptionHandler, migrations, scope, new AnonymousClass1(produceFile));
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, a produceFile) {
        E.f(produceFile, "produceFile");
        return create$default(this, replaceFileCorruptionHandler, (List) null, (M) null, produceFile, 6, (Object) null);
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> migrations, a produceFile) {
        E.f(migrations, "migrations");
        E.f(produceFile, "produceFile");
        return create$default(this, replaceFileCorruptionHandler, migrations, (M) null, produceFile, 4, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DataStore create$default(PreferenceDataStoreFactory preferenceDataStoreFactory, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, M m6, a aVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i5 & 2) != 0) {
            list = I.emptyList();
        }
        if ((i5 & 4) != 0) {
            m6 = N.CoroutineScope(C0276f0.getIO().plus(n1.m930SupervisorJob((H0) null)));
        }
        return preferenceDataStoreFactory.create((ReplaceFileCorruptionHandler<Preferences>) replaceFileCorruptionHandler, (List<? extends DataMigration<Preferences>>) list, m6, aVar);
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> migrations, M scope, a produceFile) {
        E.f(migrations, "migrations");
        E.f(scope, "scope");
        E.f(produceFile, "produceFile");
        return new PreferenceDataStore(create(new FileStorage(PreferencesFileSerializer.INSTANCE, null, new PreferenceDataStoreFactory$create$delegate$1(produceFile), 2, null), replaceFileCorruptionHandler, migrations, scope));
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> migrations, M scope) {
        E.f(storage, "storage");
        E.f(migrations, "migrations");
        E.f(scope, "scope");
        return new PreferenceDataStore(DataStoreFactory.INSTANCE.create(storage, replaceFileCorruptionHandler, migrations, scope));
    }
}
