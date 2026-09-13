package p084o4;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.E;
import p072m4.r;
import p072m4.v;
import p072m4.z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class H0 {
    public static final int hashCodeImpl(r rVar, r[] typeParams) {
        E.f(rVar, "<this>");
        E.f(typeParams, "typeParams");
        int iHashCode = (rVar.getSerialName().hashCode() * 31) + Arrays.hashCode(typeParams);
        Iterable<r> elementDescriptors = v.getElementDescriptors(rVar);
        Iterator<r> it = elementDescriptors.iterator();
        int iHashCode2 = 1;
        int i5 = 1;
        while (true) {
            int iHashCode3 = 0;
            if (!it.hasNext()) {
                break;
            }
            int i6 = i5 * 31;
            String serialName = it.next().getSerialName();
            if (serialName != null) {
                iHashCode3 = serialName.hashCode();
            }
            i5 = i6 + iHashCode3;
        }
        Iterator<r> it2 = elementDescriptors.iterator();
        while (it2.hasNext()) {
            int i7 = iHashCode2 * 31;
            z kind = it2.next().getKind();
            iHashCode2 = i7 + (kind != null ? kind.hashCode() : 0);
        }
        return (((iHashCode * 31) + i5) * 31) + iHashCode2;
    }
}
