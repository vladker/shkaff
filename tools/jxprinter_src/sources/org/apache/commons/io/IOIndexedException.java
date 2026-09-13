package org.apache.commons.io;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class IOIndexedException extends IOException {
    private static final long serialVersionUID = 1;
    private final int index;

    public IOIndexedException(int i5, Throwable th) {
        super(toMessage(i5, th), th);
        this.index = i5;
    }

    public static String toMessage(int i5, Throwable th) {
        return String.format("%s #%,d: %s", th == null ? "Null" : th.getClass().getSimpleName(), Integer.valueOf(i5), th != null ? th.getMessage() : "Null");
    }

    public int getIndex() {
        return this.index;
    }
}
