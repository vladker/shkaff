package p084o4;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.E;
import p060k4.b;

/* JADX INFO: renamed from: o4.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1346z extends AbstractC1344y {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC1346z(b element) {
        super(element);
        E.f(element, "element");
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: collectionSize, reason: merged with bridge method [inline-methods] */
    public int d(Collection<Object> collection) {
        E.f(collection, "<this>");
        return collection.size();
    }

    @Override // p084o4.AbstractC1297a
    public Iterator<Object> collectionIterator(Collection<Object> collection) {
        E.f(collection, "<this>");
        return collection.iterator();
    }
}
