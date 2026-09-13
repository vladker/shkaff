package org.apache.xmlbeans.impl.schema;

import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class h implements Consumer {
    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        ((SchemaContainer) obj).setImmutable();
    }
}
