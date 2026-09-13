package p084o4;

import kotlin.jvm.internal.E;
import p072m4.r;

/* JADX INFO: renamed from: o4.t0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1335t0 extends X0 {
    public String composeName(String parentName, String childName) {
        E.f(parentName, "parentName");
        E.f(childName, "childName");
        if (parentName.length() == 0) {
            return childName;
        }
        return parentName + '.' + childName;
    }

    public String elementName(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return descriptor.getElementName(i5);
    }

    public final String nested(String nestedName) {
        E.f(nestedName, "nestedName");
        String str = (String) getCurrentTagOrNull();
        if (str == null) {
            str = "";
        }
        return composeName(str, nestedName);
    }

    @Override // p084o4.X0
    public final String getTag(r rVar, int i5) {
        E.f(rVar, "<this>");
        return nested(elementName(rVar, i5));
    }
}
