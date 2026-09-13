package androidx.datastore.preferences.core;

import E3.g;
import F3.i;
import G3.f;
import G3.m;
import O3.p;
import androidx.datastore.core.DataStore;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferencesKt {

    /* JADX INFO: renamed from: androidx.datastore.preferences.core.PreferencesKt$edit$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.datastore.preferences.core.PreferencesKt$edit$2", f = "Preferences.kt", i = {}, l = {358}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends m implements p {
        final /* synthetic */ p $transform;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(p pVar, g<? super AnonymousClass2> gVar) {
            super(2, gVar);
            this.$transform = pVar;
        }

        @Override // G3.a
        public final g<Q> create(Object obj, g<?> gVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, gVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // O3.p
        public final Object invoke(Preferences preferences, g<? super Preferences> gVar) {
            return ((AnonymousClass2) create(preferences, gVar)).invokeSuspend(Q.INSTANCE);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 != 0) {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                v.throwOnFailure(obj);
                return mutablePreferences;
            }
            v.throwOnFailure(obj);
            MutablePreferences mutablePreferences2 = ((Preferences) this.L$0).toMutablePreferences();
            p pVar = this.$transform;
            this.L$0 = mutablePreferences2;
            this.label = 1;
            return pVar.invoke(mutablePreferences2, this) == coroutine_suspended ? coroutine_suspended : mutablePreferences2;
        }
    }

    public static final Object edit(DataStore<Preferences> dataStore, p pVar, g<? super Preferences> gVar) {
        return dataStore.updateData(new AnonymousClass2(pVar, null), gVar);
    }
}
