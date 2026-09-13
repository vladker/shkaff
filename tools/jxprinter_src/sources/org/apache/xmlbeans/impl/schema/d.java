package org.apache.xmlbeans.impl.schema;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class d implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7370a;

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7370a) {
            case 0:
                return new ArrayList();
            default:
                return new LinkedHashMap();
        }
    }
}
