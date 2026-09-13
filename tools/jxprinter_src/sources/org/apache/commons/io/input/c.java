package org.apache.commons.io.input;

import java.io.Closeable;
import java.io.IOException;
import org.apache.commons.io.function.IOConsumer;
import org.apache.commons.io.output.ProxyOutputStream;
import org.apache.commons.io.output.ProxyWriter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements IOConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6729a;
    public final /* synthetic */ Closeable b;

    public /* synthetic */ c(Closeable closeable, int i5) {
        this.f6729a = i5;
        this.b = closeable;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) throws IOException {
        switch (this.f6729a) {
            case 0:
                ((ProxyInputStream) this.b).handleIOException((IOException) obj);
                break;
            case 1:
                ((ProxyOutputStream) this.b).handleIOException((IOException) obj);
                break;
            default:
                ((ProxyWriter) this.b).handleIOException((IOException) obj);
                break;
        }
    }
}
