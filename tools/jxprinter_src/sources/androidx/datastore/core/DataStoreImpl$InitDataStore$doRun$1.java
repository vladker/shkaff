package androidx.datastore.core;

import E3.g;
import G3.d;
import G3.f;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.datastore.core.DataStoreImpl$InitDataStore", f = "DataStoreImpl.kt", i = {0, 1}, l = {Videoio.CAP_PROP_XI_BINNING_PATTERN, Videoio.CAP_PROP_XI_DECIMATION_PATTERN}, m = "doRun", n = {"this", "this"}, s = {"L$0", "L$0"})
public final class DataStoreImpl$InitDataStore$doRun$1 extends d {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataStoreImpl<T>.InitDataStore this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$InitDataStore$doRun$1(DataStoreImpl<T>.InitDataStore initDataStore, g<? super DataStoreImpl$InitDataStore$doRun$1> gVar) {
        super(gVar);
        this.this$0 = initDataStore;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doRun(this);
    }
}
