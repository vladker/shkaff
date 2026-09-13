package p084o4;

import A3.T;
import com.alibaba.android.arouter.utils.Consts;
import kotlin.jvm.internal.E;
import p072m4.r;

/* JADX INFO: renamed from: o4.s0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1333s0 extends W0 {
    public String composeName(String parentName, String childName) {
        E.f(parentName, "parentName");
        E.f(childName, "childName");
        if (parentName.length() == 0) {
            return childName;
        }
        return parentName + '.' + childName;
    }

    @Override // p084o4.W0, p078n4.f, p089p4.k
    public abstract /* synthetic */ int decodeElementIndex(r rVar);

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

    public final String renderTagStack() {
        return getTagStack$kotlinx_serialization_core().isEmpty() ? "$" : T.g(getTagStack$kotlinx_serialization_core(), Consts.DOT, "$.", null, null, 60);
    }

    @Override // p084o4.W0
    public final String getTag(r rVar, int i5) {
        E.f(rVar, "<this>");
        return nested(elementName(rVar, i5));
    }
}
