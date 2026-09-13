package B3;

import A3.G;
import A3.I;
import A3.v0;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements Externalizable {
    public static final q Companion = new q();
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f98a;
    private Collection<?> collection;

    public r(Collection<?> collection, int i5) {
        E.f(collection, "collection");
        this.collection = collection;
        this.f98a = i5;
    }

    private final Object readResolve() {
        return this.collection;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput input) throws IOException {
        Collection<?> collectionBuild;
        E.f(input, "input");
        byte b = input.readByte();
        int i5 = b & 1;
        if ((b & (-2)) != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + ((int) b) + '.');
        }
        int i6 = input.readInt();
        if (i6 < 0) {
            throw new InvalidObjectException("Illegal size value: " + i6 + '.');
        }
        int i7 = 0;
        if (i5 == 0) {
            List listCreateListBuilder = G.createListBuilder(i6);
            while (i7 < i6) {
                listCreateListBuilder.add(input.readObject());
                i7++;
            }
            collectionBuild = G.build(listCreateListBuilder);
        } else {
            if (i5 != 1) {
                throw new InvalidObjectException("Unsupported collection type tag: " + i5 + '.');
            }
            Set setCreateSetBuilder = v0.createSetBuilder(i6);
            while (i7 < i6) {
                setCreateSetBuilder.add(input.readObject());
                i7++;
            }
            collectionBuild = v0.build(setCreateSetBuilder);
        }
        this.collection = collectionBuild;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput output) throws IOException {
        E.f(output, "output");
        output.writeByte(this.f98a);
        output.writeInt(this.collection.size());
        Iterator<?> it = this.collection.iterator();
        while (it.hasNext()) {
            output.writeObject(it.next());
        }
    }

    public r() {
        this(I.emptyList(), 0);
    }
}
