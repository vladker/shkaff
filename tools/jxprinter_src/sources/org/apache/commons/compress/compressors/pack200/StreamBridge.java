package org.apache.commons.compress.compressors.pack200;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
abstract class StreamBridge extends FilterOutputStream {
    private InputStream input;
    private final Object inputLock;

    public StreamBridge(OutputStream outputStream) {
        super(outputStream);
        this.inputLock = new Object();
    }

    public InputStream getInput() {
        synchronized (this.inputLock) {
            try {
                if (this.input == null) {
                    this.input = getInputView();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.input;
    }

    public abstract InputStream getInputView();

    public void stop() throws IOException {
        close();
        synchronized (this.inputLock) {
            try {
                InputStream inputStream = this.input;
                if (inputStream != null) {
                    inputStream.close();
                    this.input = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public StreamBridge() {
        this(null);
    }
}
