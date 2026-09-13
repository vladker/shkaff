package M3;

import A3.C;
import W3.InterfaceC0233q;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Iterator;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements InterfaceC0233q {
    private final p[] options;
    private final Path start;

    public o(Path start, p[] options) {
        E.f(start, "start");
        E.f(options, "options");
        this.start = start;
        this.options = options;
    }

    public static final boolean a(o oVar) {
        return C.contains(oVar.options, p.f483a);
    }

    public static final LinkOption[] b(o oVar) {
        oVar.getClass();
        return j.INSTANCE.toLinkOptions(oVar.d());
    }

    public final boolean d() {
        return C.contains(this.options, p.c);
    }

    @Override // W3.InterfaceC0233q
    public Iterator<Path> iterator() {
        E3.g gVar = null;
        return C.contains(this.options, p.b) ? W3.t.iterator(new n(this, gVar, 0)) : W3.t.iterator(new n(this, gVar, 1));
    }
}
