package B3;

import A3.AbstractC0157z;
import A3.j0;
import A3.k0;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class t implements Externalizable {
    public static final s Companion = new s();
    private static final long serialVersionUID = 0;
    private Map<?, ?> map;

    public t(Map<?, ?> map) {
        E.f(map, "map");
        this.map = map;
    }

    private final Object readResolve() {
        return this.map;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput input) throws IOException {
        E.f(input, "input");
        byte b = input.readByte();
        if (b != 0) {
            throw new InvalidObjectException(AbstractC0157z.k(b, "Unsupported flags value: "));
        }
        int i5 = input.readInt();
        if (i5 < 0) {
            throw new InvalidObjectException("Illegal size value: " + i5 + '.');
        }
        Map mapCreateMapBuilder = j0.createMapBuilder(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            mapCreateMapBuilder.put(input.readObject(), input.readObject());
        }
        this.map = j0.build(mapCreateMapBuilder);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput output) throws IOException {
        E.f(output, "output");
        output.writeByte(0);
        output.writeInt(this.map.size());
        for (Map.Entry<?, ?> entry : this.map.entrySet()) {
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
        }
    }

    public t() {
        this(k0.emptyMap());
    }
}
