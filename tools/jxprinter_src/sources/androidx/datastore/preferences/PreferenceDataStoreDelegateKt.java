package androidx.datastore.preferences;

import A3.I;
import O3.l;
import R3.a;
import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.core.Preferences;
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
public final class PreferenceDataStoreDelegateKt {

    /* JADX INFO: renamed from: androidx.datastore.preferences.PreferenceDataStoreDelegateKt$preferencesDataStore$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AnonymousClass1 extends F implements l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // O3.l
        public final List<DataMigration<Preferences>> invoke(Context it) {
            E.f(it, "it");
            return I.emptyList();
        }
    }

    public static final a preferencesDataStore(String name, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, l produceMigrations, M scope) {
        E.f(name, "name");
        E.f(produceMigrations, "produceMigrations");
        E.f(scope, "scope");
        return new PreferenceDataStoreSingletonDelegate(name, replaceFileCorruptionHandler, produceMigrations, scope);
    }

    public static /* synthetic */ a preferencesDataStore$default(String str, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, l lVar, M m6, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i5 & 4) != 0) {
            lVar = AnonymousClass1.INSTANCE;
        }
        if ((i5 & 8) != 0) {
            m6 = N.CoroutineScope(C0276f0.getIO().plus(n1.m930SupervisorJob((H0) null)));
        }
        return preferencesDataStore(str, replaceFileCorruptionHandler, lVar, m6);
    }
}
