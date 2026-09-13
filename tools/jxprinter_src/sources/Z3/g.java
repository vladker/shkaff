package Z3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements Externalizable {
    public static final f Companion = new f();
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f900a;
    public long b;

    private final Object readResolve() {
        return c.Companion.fromLongs(this.f900a, this.b);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput input) {
        E.f(input, "input");
        this.f900a = input.readLong();
        this.b = input.readLong();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput output) throws IOException {
        E.f(output, "output");
        output.writeLong(this.f900a);
        output.writeLong(this.b);
    }
}
