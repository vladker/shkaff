package kotlinx.serialization.json.internal;

import org.apache.logging.log4j.util.Chars;
import p089p4.AbstractC1519d;

/* JADX INFO: renamed from: kotlinx.serialization.json.internal.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1148y extends p078n4.a {
    private final AbstractC1126b lexer;
    private final p095q4.g serializersModule;

    public C1148y(AbstractC1126b lexer, AbstractC1519d json) {
        kotlin.jvm.internal.E.f(lexer, "lexer");
        kotlin.jvm.internal.E.f(json, "json");
        this.lexer = lexer;
        this.serializersModule = json.getSerializersModule();
    }

    @Override // p078n4.a, p078n4.j
    public final byte b() {
        AbstractC1126b abstractC1126b = this.lexer;
        String strConsumeStringLenient = abstractC1126b.consumeStringLenient();
        try {
            return X3.g0.toUByte(strConsumeStringLenient);
        } catch (IllegalArgumentException unused) {
            throw AbstractC1125a.k(abstractC1126b, "Failed to parse type 'UByte' for input '" + strConsumeStringLenient + Chars.QUOTE, 0, null, 6);
        }
    }

    @Override // p078n4.a, p078n4.j
    public final long c() {
        AbstractC1126b abstractC1126b = this.lexer;
        String strConsumeStringLenient = abstractC1126b.consumeStringLenient();
        try {
            return X3.g0.toULong(strConsumeStringLenient);
        } catch (IllegalArgumentException unused) {
            throw AbstractC1125a.k(abstractC1126b, "Failed to parse type 'ULong' for input '" + strConsumeStringLenient + Chars.QUOTE, 0, null, 6);
        }
    }

    @Override // p078n4.a, p078n4.j
    public final short d() {
        AbstractC1126b abstractC1126b = this.lexer;
        String strConsumeStringLenient = abstractC1126b.consumeStringLenient();
        try {
            return X3.g0.toUShort(strConsumeStringLenient);
        } catch (IllegalArgumentException unused) {
            throw AbstractC1125a.k(abstractC1126b, "Failed to parse type 'UShort' for input '" + strConsumeStringLenient + Chars.QUOTE, 0, null, 6);
        }
    }

    @Override // p078n4.a, p078n4.f, p089p4.k
    public int decodeElementIndex(p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        throw new IllegalStateException("unsupported");
    }

    @Override // p078n4.a, p078n4.j
    public final int f() {
        AbstractC1126b abstractC1126b = this.lexer;
        String strConsumeStringLenient = abstractC1126b.consumeStringLenient();
        try {
            return X3.g0.toUInt(strConsumeStringLenient);
        } catch (IllegalArgumentException unused) {
            throw AbstractC1125a.k(abstractC1126b, "Failed to parse type 'UInt' for input '" + strConsumeStringLenient + Chars.QUOTE, 0, null, 6);
        }
    }

    @Override // p078n4.a, p078n4.j, p078n4.f, p089p4.k
    public p095q4.g getSerializersModule() {
        return this.serializersModule;
    }
}
