package org.apache.logging.log4j.message;

import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6943a;

    public /* synthetic */ c(int i5) {
        this.f6943a = i5;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f6943a) {
            case 0:
                return ParameterFormatter.lambda$static$0();
            default:
                return ThreadDumpMessage.lambda$initFactory$0();
        }
    }
}
