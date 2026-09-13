package p060k4;

import A3.AbstractC0157z;
import A3.G;
import androidx.exifinterface.media.a;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends l {
    private final List<String> missingFields;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(List<String> missingFields, String str, Throwable th) {
        super(str, th);
        E.f(missingFields, "missingFields");
        this.missingFields = missingFields;
    }

    public final List<String> getMissingFields() {
        return this.missingFields;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(List<String> missingFields, String serialName) {
        String strS;
        E.f(missingFields, "missingFields");
        E.f(serialName, "serialName");
        if (missingFields.size() == 1) {
            strS = a.s(new StringBuilder("Field '"), missingFields.get(0), "' is required for type with serial name '", serialName, "', but it was missing");
        } else {
            strS = "Fields " + missingFields + " are required for type with serial name '" + serialName + "', but they were missing";
        }
        this(missingFields, strS, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(String missingField, String serialName) {
        this(G.listOf(missingField), androidx.collection.a.p("Field '", missingField, "' is required for type with serial name '", serialName, "', but it was missing"), null);
        E.f(missingField, "missingField");
        E.f(serialName, "serialName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(String missingField) {
        this(G.listOf(missingField), AbstractC0157z.o("Field '", missingField, "' is required, but it was missing"), null);
        E.f(missingField, "missingField");
    }
}
