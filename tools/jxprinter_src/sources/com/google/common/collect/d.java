package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.net.MediaType;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3411a;

    public /* synthetic */ d(int i5) {
        this.f3411a = i5;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f3411a) {
            case 0:
                return TreeBasedTable.lambda$createColumnKeyIterator$0((Map) obj);
            case 1:
                return MediaType.lambda$computeToString$0((String) obj);
            default:
                return ImmutableMultiset.copyOf((Collection) obj);
        }
    }
}
