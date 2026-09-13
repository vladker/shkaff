package org.apache.commons.io.output;

import java.io.Writer;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TeeWriter extends ProxyCollectionWriter {
    public TeeWriter(Collection<Writer> collection) {
        super(collection);
    }

    public TeeWriter(Writer... writerArr) {
        super(writerArr);
    }
}
