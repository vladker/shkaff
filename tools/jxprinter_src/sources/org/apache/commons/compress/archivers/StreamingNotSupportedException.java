package org.apache.commons.compress.archivers;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class StreamingNotSupportedException extends ArchiveException {
    private static final long serialVersionUID = 1;
    private final String format;

    public StreamingNotSupportedException(String str) {
        super(AbstractC0157z.o("The ", str, " doesn't support streaming."));
        this.format = str;
    }

    public String getFormat() {
        return this.format;
    }
}
