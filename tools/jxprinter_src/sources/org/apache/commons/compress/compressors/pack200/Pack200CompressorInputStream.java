package org.apache.commons.compress.compressors.pack200;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.jar.JarOutputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.java.util.jar.Pack200;
import org.apache.commons.compress.utils.CloseShieldFilterInputStream;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Pack200CompressorInputStream extends CompressorInputStream {
    private static final byte[] CAFE_DOOD;
    private static final int SIG_LENGTH;
    private final InputStream originalInput;
    private final StreamBridge streamBridge;

    static {
        byte[] bArr = {-54, -2, -48, 13};
        CAFE_DOOD = bArr;
        SIG_LENGTH = bArr.length;
    }

    public Pack200CompressorInputStream(InputStream inputStream) {
        this(inputStream, Pack200Strategy.IN_MEMORY);
    }

    public static boolean matches(byte[] bArr, int i5) {
        if (i5 < SIG_LENGTH) {
            return false;
        }
        for (int i6 = 0; i6 < SIG_LENGTH; i6++) {
            if (bArr[i6] != CAFE_DOOD[i6]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.streamBridge.getInput().available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.streamBridge.stop();
        } finally {
            InputStream inputStream = this.originalInput;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i5) {
        try {
            this.streamBridge.getInput().mark(i5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        try {
            return this.streamBridge.getInput().markSupported();
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        return this.streamBridge.getInput().read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.streamBridge.getInput().reset();
    }

    @Override // java.io.InputStream
    public long skip(long j6) {
        return IOUtils.skip(this.streamBridge.getInput(), j6);
    }

    public Pack200CompressorInputStream(InputStream inputStream, Pack200Strategy pack200Strategy) {
        this(inputStream, null, pack200Strategy, null);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return this.streamBridge.getInput().read(bArr);
    }

    public Pack200CompressorInputStream(InputStream inputStream, Map<String, String> map) {
        this(inputStream, Pack200Strategy.IN_MEMORY, map);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) {
        return this.streamBridge.getInput().read(bArr, i5, i6);
    }

    public Pack200CompressorInputStream(InputStream inputStream, Pack200Strategy pack200Strategy, Map<String, String> map) {
        this(inputStream, null, pack200Strategy, map);
    }

    public Pack200CompressorInputStream(File file) {
        this(file, Pack200Strategy.IN_MEMORY);
    }

    public Pack200CompressorInputStream(File file, Pack200Strategy pack200Strategy) {
        this(null, file, pack200Strategy, null);
    }

    public Pack200CompressorInputStream(File file, Map<String, String> map) {
        this(file, Pack200Strategy.IN_MEMORY, map);
    }

    public Pack200CompressorInputStream(File file, Pack200Strategy pack200Strategy, Map<String, String> map) {
        this(null, file, pack200Strategy, map);
    }

    private Pack200CompressorInputStream(InputStream inputStream, File file, Pack200Strategy pack200Strategy, Map<String, String> map) throws IOException {
        this.originalInput = inputStream;
        StreamBridge streamBridgeNewStreamBridge = pack200Strategy.newStreamBridge();
        this.streamBridge = streamBridgeNewStreamBridge;
        JarOutputStream jarOutputStream = new JarOutputStream(streamBridgeNewStreamBridge);
        try {
            Pack200.Unpacker unpackerNewUnpacker = Pack200.newUnpacker();
            if (map != null) {
                unpackerNewUnpacker.properties().putAll(map);
            }
            if (file == null) {
                unpackerNewUnpacker.unpack(new CloseShieldFilterInputStream(inputStream), jarOutputStream);
            } else {
                unpackerNewUnpacker.unpack(file, jarOutputStream);
            }
            jarOutputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    jarOutputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
