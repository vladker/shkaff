package L3;

import W3.InterfaceC0233q;
import java.io.BufferedReader;
import java.util.Iterator;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class v implements InterfaceC0233q {
    private final BufferedReader reader;

    public v(BufferedReader reader) {
        E.f(reader, "reader");
        this.reader = reader;
    }

    @Override // W3.InterfaceC0233q
    public Iterator<String> iterator() {
        return new u(this);
    }
}
