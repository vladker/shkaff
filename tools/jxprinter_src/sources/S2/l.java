package S2;

import A3.C0133b0;
import A3.I;
import W3.InterfaceC0233q;
import androidx.datastore.core.CorruptionException;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.E;
import kotlinx.serialization.json.internal.j0;
import org.apache.xmlbeans.impl.common.NameUtil;
import p007a4.AbstractC0309w0;
import p007a4.F;
import p072m4.C1241a;
import p084o4.C0;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class l implements O3.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f641a;

    public /* synthetic */ l(int i5) {
        this.f641a = i5;
    }

    @Override // O3.l
    public final Object invoke(Object obj) {
        p060k4.b nullable;
        switch (this.f641a) {
            case 0:
                U2.f updateRequest = (U2.f) obj;
                E.f(updateRequest, "$this$updateRequest");
                return U2.f.a(updateRequest, null, null, 45);
            case 1:
                InterfaceC0233q it = (InterfaceC0233q) obj;
                E.f(it, "it");
                return it.iterator();
            case 2:
                Iterable it2 = (Iterable) obj;
                E.f(it2, "it");
                return it2.iterator();
            case 3:
                return obj;
            case 4:
                C0133b0 it3 = (C0133b0) obj;
                E.f(it3, "it");
                return it3.b;
            case 5:
                return Boolean.valueOf(obj == null);
            case 6:
                String line = (String) obj;
                E.f(line, "line");
                return line;
            case 7:
                CharSequence it4 = (CharSequence) obj;
                E.f(it4, "it");
                return it4.toString();
            case 8:
                CharSequence it5 = (CharSequence) obj;
                E.f(it5, "it");
                return it5.toString();
            case 9:
                CharSequence it6 = (CharSequence) obj;
                E.f(it6, "it");
                return it6.toString();
            case 10:
                E3.o oVar = (E3.o) obj;
                if (oVar instanceof F) {
                    return (F) oVar;
                }
                return null;
            case 11:
                E3.o oVar2 = (E3.o) obj;
                if (oVar2 instanceof AbstractC0309w0) {
                    return (AbstractC0309w0) oVar2;
                }
                return null;
            case 12:
                return FirebaseSessionsComponent.MainModule.Companion.sessionConfigsDataStore$lambda$0((CorruptionException) obj);
            case 13:
                Byte b = (Byte) obj;
                b.byteValue();
                return String.format("%02x", Arrays.copyOf(new Object[]{b}, 1));
            case 14:
                V3.c it7 = (V3.c) obj;
                E.f(it7, "it");
                p060k4.b bVarSerializerOrNull = p060k4.p.serializerOrNull(it7);
                if (bVarSerializerOrNull != null) {
                    return bVarSerializerOrNull;
                }
                if (C0.isInterface(it7)) {
                    return new p060k4.e(it7);
                }
                return null;
            case 15:
                V3.c it8 = (V3.c) obj;
                E.f(it8, "it");
                p060k4.b bVarSerializerOrNull2 = p060k4.p.serializerOrNull(it8);
                if (bVarSerializerOrNull2 == null) {
                    bVarSerializerOrNull2 = C0.isInterface(it8) ? new p060k4.e(it8) : null;
                }
                if (bVarSerializerOrNull2 == null || (nullable = p066l4.a.getNullable(bVarSerializerOrNull2)) == null) {
                    return null;
                }
                return nullable;
            case 16:
                E.f((C1241a) obj, "<this>");
                return Q.INSTANCE;
            case 17:
                C1241a buildSerialDescriptor = (C1241a) obj;
                E.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
                buildSerialDescriptor.element("JsonPrimitive", new p089p4.p(new d(7)), I.emptyList(), false);
                buildSerialDescriptor.element("JsonNull", new p089p4.p(new d(8)), I.emptyList(), false);
                buildSerialDescriptor.element("JsonLiteral", new p089p4.p(new d(9)), I.emptyList(), false);
                buildSerialDescriptor.element("JsonObject", new p089p4.p(new d(10)), I.emptyList(), false);
                buildSerialDescriptor.element("JsonArray", new p089p4.p(new d(11)), I.emptyList(), false);
                return Q.INSTANCE;
            default:
                Map.Entry entry = (Map.Entry) obj;
                E.f(entry, "<destruct>");
                String str = (String) entry.getKey();
                p089p4.m mVar = (p089p4.m) entry.getValue();
                StringBuilder sb = new StringBuilder();
                j0.printQuoted(sb, str);
                sb.append(NameUtil.COLON);
                sb.append(mVar);
                String string = sb.toString();
                E.e(string, "toString(...)");
                return string;
        }
    }
}
