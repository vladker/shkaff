package p089p4;

import kotlin.jvm.internal.E;
import kotlinx.serialization.json.internal.j0;
import p072m4.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7768a;
    private final r coerceToInlineType;
    private final String content;

    public s(Object body, boolean z6, r rVar) {
        E.f(body, "body");
        this.f7768a = z6;
        this.coerceToInlineType = rVar;
        this.content = body.toString();
        if (rVar != null && !rVar.isInline()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        return this.f7768a == sVar.f7768a && E.a(getContent(), sVar.getContent());
    }

    public final r getCoerceToInlineType$kotlinx_serialization_json() {
        return this.coerceToInlineType;
    }

    @Override // p089p4.E
    public String getContent() {
        return this.content;
    }

    public int hashCode() {
        return getContent().hashCode() + (Boolean.hashCode(this.f7768a) * 31);
    }

    @Override // p089p4.E
    public String toString() {
        if (!this.f7768a) {
            return getContent();
        }
        StringBuilder sb = new StringBuilder();
        j0.printQuoted(sb, getContent());
        String string = sb.toString();
        E.e(string, "toString(...)");
        return string;
    }
}
