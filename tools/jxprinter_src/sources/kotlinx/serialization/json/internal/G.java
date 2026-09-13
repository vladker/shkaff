package kotlinx.serialization.json.internal;

import java.util.Iterator;
import p089p4.AbstractC1519d;
import p089p4.EnumC1517b;
import p147z3.C1929i;
import p147z3.C1937q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class G {
    public static final <T> Iterator<T> JsonIterator(EnumC1517b mode, AbstractC1519d json, a0 lexer, p060k4.a deserializer) {
        EnumC1517b enumC1517b;
        kotlin.jvm.internal.E.f(mode, "mode");
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(lexer, "lexer");
        kotlin.jvm.internal.E.f(deserializer, "deserializer");
        int iOrdinal = mode.ordinal();
        if (iOrdinal == 0) {
            enumC1517b = EnumC1517b.f7756a;
        } else if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                throw new C1937q();
            }
            if (lexer.q() == 8) {
                lexer.g((byte) 8);
                enumC1517b = EnumC1517b.b;
            } else {
                enumC1517b = EnumC1517b.f7756a;
            }
        } else {
            if (lexer.q() != 8) {
                lexer.fail$kotlinx_serialization_json((byte) 8, true);
                throw new C1929i();
            }
            lexer.g((byte) 8);
            enumC1517b = EnumC1517b.b;
        }
        int iOrdinal2 = enumC1517b.ordinal();
        if (iOrdinal2 == 0) {
            return new H(json, lexer, deserializer);
        }
        if (iOrdinal2 == 1) {
            return new F(json, lexer, deserializer);
        }
        if (iOrdinal2 != 2) {
            throw new C1937q();
        }
        throw new IllegalStateException("AbstractJsonLexer.determineFormat must be called beforehand.");
    }
}
