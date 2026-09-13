package kotlinx.serialization.json.internal;

import java.util.Iterator;
import p089p4.AbstractC1519d;
import p147z3.C1929i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class F implements Iterator, P3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5726a;
    public boolean b;
    private final p060k4.a deserializer;
    private final AbstractC1519d json;
    private final a0 lexer;

    public F(AbstractC1519d json, a0 lexer, p060k4.a deserializer) {
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(lexer, "lexer");
        kotlin.jvm.internal.E.f(deserializer, "deserializer");
        this.json = json;
        this.lexer = lexer;
        this.deserializer = deserializer;
        this.f5726a = true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.b) {
            return false;
        }
        if (this.lexer.q() != 9) {
            if (this.lexer.q() != 10 || this.b) {
                return true;
            }
            this.lexer.fail$kotlinx_serialization_json((byte) 9, true);
            throw new C1929i();
        }
        this.b = true;
        this.lexer.g((byte) 9);
        if (this.lexer.q() == 10) {
            return false;
        }
        if (this.lexer.q() != 8) {
            this.lexer.m();
            return false;
        }
        AbstractC1126b.n(this.lexer, "There is a start of the new array after the one parsed to sequence. ARRAY_WRAPPED mode doesn't merge consecutive arrays.\nIf you need to parse a stream of arrays, please use WHITESPACE_SEPARATED mode instead.", 0, null, 6);
        throw new C1929i();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f5726a) {
            this.f5726a = false;
        } else {
            this.lexer.h(',');
        }
        return new d0(this.json, m0.OBJ, this.lexer, this.deserializer.getDescriptor(), null).decodeSerializableValue(this.deserializer);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
