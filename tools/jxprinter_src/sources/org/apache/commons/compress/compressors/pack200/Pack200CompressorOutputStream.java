package org.apache.commons.compress.compressors.pack200;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.jar.JarInputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.java.util.jar.Pack200;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Pack200CompressorOutputStream extends CompressorOutputStream {
    private boolean finished;
    private final OutputStream originalOutput;
    private final Map<String, String> properties;
    private final StreamBridge streamBridge;

    public Pack200CompressorOutputStream(OutputStream outputStream) {
        this(outputStream, Pack200Strategy.IN_MEMORY);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            finish();
            try {
                this.streamBridge.stop();
            } finally {
                this.originalOutput.close();
            }
        } catch (Throwable th) {
            try {
                this.streamBridge.stop();
                throw th;
            } finally {
                this.originalOutput.close();
            }
        }
    }

    public void finish() throws IOException {
        if (this.finished) {
            return;
        }
        this.finished = true;
        Pack200.Packer packerNewPacker = Pack200.newPacker();
        if (this.properties != null) {
            packerNewPacker.properties().putAll(this.properties);
        }
        JarInputStream jarInputStream = new JarInputStream(this.streamBridge.getInput());
        try {
            packerNewPacker.pack(jarInputStream, this.originalOutput);
            jarInputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    jarInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i5) throws IOException {
        this.streamBridge.write(i5);
    }

    public Pack200CompressorOutputStream(OutputStream outputStream, Pack200Strategy pack200Strategy) {
        this(outputStream, pack200Strategy, null);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.streamBridge.write(bArr);
    }

    public Pack200CompressorOutputStream(OutputStream outputStream, Map<String, String> map) {
        this(outputStream, Pack200Strategy.IN_MEMORY, map);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) throws IOException {
        this.streamBridge.write(bArr, i5, i6);
    }

    public Pack200CompressorOutputStream(OutputStream outputStream, Pack200Strategy pack200Strategy, Map<String, String> map) {
        this.originalOutput = outputStream;
        this.streamBridge = pack200Strategy.newStreamBridge();
        this.properties = map;
    }
}
