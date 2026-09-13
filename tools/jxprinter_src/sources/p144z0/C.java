package p144z0;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C implements B {
    @Override // p144z0.B
    public final Class getDataClass() {
        return InputStream.class;
    }

    @Override // p144z0.B
    public void close(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // p144z0.B
    public InputStream open(File file) {
        return new FileInputStream(file);
    }
}
