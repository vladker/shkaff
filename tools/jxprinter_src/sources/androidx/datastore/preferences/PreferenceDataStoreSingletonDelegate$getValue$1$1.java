package androidx.datastore.preferences;

import O3.a;
import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceDataStoreSingletonDelegate$getValue$1$1 extends F implements a {
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ PreferenceDataStoreSingletonDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreferenceDataStoreSingletonDelegate$getValue$1$1(Context context, PreferenceDataStoreSingletonDelegate preferenceDataStoreSingletonDelegate) {
        super(0);
        this.$applicationContext = context;
        this.this$0 = preferenceDataStoreSingletonDelegate;
    }

    @Override // O3.a
    public final File invoke() {
        Context applicationContext = this.$applicationContext;
        E.e(applicationContext, "applicationContext");
        return PreferenceDataStoreFile.preferencesDataStoreFile(applicationContext, this.this$0.name);
    }
}
