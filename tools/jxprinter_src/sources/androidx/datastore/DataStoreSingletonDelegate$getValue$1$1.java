package androidx.datastore;

import A4.U;
import A4.V;
import O3.a;
import android.content.Context;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreSingletonDelegate$getValue$1$1 extends F implements a {
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ DataStoreSingletonDelegate<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreSingletonDelegate$getValue$1$1(Context context, DataStoreSingletonDelegate<T> dataStoreSingletonDelegate) {
        super(0);
        this.$applicationContext = context;
        this.this$0 = dataStoreSingletonDelegate;
    }

    @Override // O3.a
    public final V invoke() {
        U u6 = V.Companion;
        Context applicationContext = this.$applicationContext;
        E.e(applicationContext, "applicationContext");
        String absolutePath = DataStoreFile.dataStoreFile(applicationContext, ((DataStoreSingletonDelegate) this.this$0).fileName).getAbsolutePath();
        E.e(absolutePath, "applicationContext.dataS…le(fileName).absolutePath");
        return u6.get(absolutePath, false);
    }
}
