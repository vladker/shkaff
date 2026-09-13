package p084o4;

import V3.c;
import androidx.collection.a;
import kotlin.jvm.internal.E;
import org.apache.logging.log4j.util.Chars;
import p060k4.l;
import p147z3.C1929i;

/* JADX INFO: renamed from: o4.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1301c {
    public static final Void throwSubtypeNotRegistered(String str, c baseClass) {
        String string;
        E.f(baseClass, "baseClass");
        String str2 = "in the polymorphic scope of '" + baseClass.getSimpleName() + Chars.QUOTE;
        if (str == null) {
            string = "Class discriminator was missing and no default serializers were registered " + str2 + '.';
        } else {
            StringBuilder sbU = a.u("Serializer for subclass '", str, "' is not found ", str2, ".\nCheck if class with serial name '");
            a.y(sbU, str, "' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class '", str, "' has to be '@Serializable', and the base class '");
            sbU.append(baseClass.getSimpleName());
            sbU.append("' has to be sealed and '@Serializable'.");
            string = sbU.toString();
        }
        throw new l(string);
    }

    public static final Void throwSubtypeNotRegistered(c subClass, c baseClass) {
        E.f(subClass, "subClass");
        E.f(baseClass, "baseClass");
        String simpleName = subClass.getSimpleName();
        if (simpleName == null) {
            simpleName = String.valueOf(subClass);
        }
        throwSubtypeNotRegistered(simpleName, baseClass);
        throw new C1929i();
    }
}
