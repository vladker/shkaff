package p089p4;

import kotlin.jvm.internal.E;
import kotlinx.serialization.json.internal.C1144u;
import kotlinx.serialization.json.internal.N;
import kotlinx.serialization.json.internal.O;
import kotlinx.serialization.json.internal.d0;
import kotlinx.serialization.json.internal.g0;
import kotlinx.serialization.json.internal.h0;
import kotlinx.serialization.json.internal.k0;
import kotlinx.serialization.json.internal.l0;
import kotlinx.serialization.json.internal.m0;
import p060k4.a;
import p060k4.m;
import p060k4.s;
import p095q4.g;
import p095q4.i;

/* JADX INFO: renamed from: p4.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1519d implements s {
    public static final C1518c Default = new C1518c(new j(false, false, false, false, false, true, "    ", false, false, "type", false, true, null, false, false, false, EnumC1516a.b), i.EmptySerializersModule());
    private final C1144u _schemaCache = new C1144u();
    private final j configuration;
    private final g serializersModule;

    public AbstractC1519d(j jVar, g gVar) {
        this.configuration = jVar;
        this.serializersModule = gVar;
    }

    public final <T> T decodeFromJsonElement(a deserializer, m element) {
        E.f(deserializer, "deserializer");
        E.f(element, "element");
        return (T) k0.readJson(this, element, deserializer);
    }

    public final <T> T decodeFromString(String string) {
        E.f(string, "string");
        getSerializersModule();
        E.l();
        throw null;
    }

    public final <T> m encodeToJsonElement(m serializer, T t6) {
        E.f(serializer, "serializer");
        return l0.writeJson(this, t6, serializer);
    }

    @Override // p060k4.s
    public final <T> String encodeToString(m serializer, T t6) {
        E.f(serializer, "serializer");
        O o6 = new O();
        try {
            N.encodeByWriter(this, o6, serializer, t6);
            return o6.toString();
        } finally {
            o6.b();
        }
    }

    public final j getConfiguration() {
        return this.configuration;
    }

    @Override // p060k4.s, p060k4.j
    public g getSerializersModule() {
        return this.serializersModule;
    }

    public final C1144u get_schemaCache$kotlinx_serialization_json() {
        return this._schemaCache;
    }

    public final m parseToJsonElement(String string) {
        E.f(string, "string");
        return (m) decodeFromString(o.INSTANCE, string);
    }

    @Override // p060k4.s
    public final <T> T decodeFromString(a deserializer, String string) {
        E.f(deserializer, "deserializer");
        E.f(string, "string");
        g0 g0VarStringJsonLexer = h0.StringJsonLexer(this, string);
        T t6 = (T) new d0(this, m0.OBJ, g0VarStringJsonLexer, deserializer.getDescriptor(), null).decodeSerializableValue(deserializer);
        g0VarStringJsonLexer.m();
        return t6;
    }

    public static /* synthetic */ void get_schemaCache$kotlinx_serialization_json$annotations() {
    }
}
