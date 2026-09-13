package kotlinx.serialization.json.internal;

import java.util.Iterator;
import org.apache.logging.log4j.util.Chars;
import p147z3.C1929i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class g0 extends AbstractC1126b {
    private final String source;

    public g0(String source) {
        kotlin.jvm.internal.E.f(source, "source");
        this.source = source;
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public String consumeKeyString() {
        h(Chars.DQUOTE);
        int i5 = this.currentPosition;
        int iD = X3.b0.d(getSource(), Chars.DQUOTE, i5, false, 4);
        if (iD == -1) {
            consumeStringLenient();
            fail$kotlinx_serialization_json((byte) 1, false);
            throw new C1929i();
        }
        for (int i6 = i5; i6 < iD; i6++) {
            if (getSource().charAt(i6) == '\\') {
                return consumeString(getSource(), this.currentPosition, i6);
            }
        }
        this.currentPosition = iD + 1;
        String strSubstring = getSource().substring(i5, iD);
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public void consumeStringChunked(boolean z6, O3.l consumeChunk) {
        kotlin.jvm.internal.E.f(consumeChunk, "consumeChunk");
        Iterator<T> it = X3.e0.chunked(z6 ? consumeStringLenient() : consumeString(), 16384).iterator();
        while (it.hasNext()) {
            consumeChunk.invoke(it.next());
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public boolean d() {
        int i5 = this.currentPosition;
        if (i5 == -1) {
            return false;
        }
        String source = getSource();
        while (i5 < source.length()) {
            char cCharAt = source.charAt(i5);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.currentPosition = i5;
                return AbstractC1126b.p(cCharAt);
            }
            i5++;
        }
        this.currentPosition = i5;
        return false;
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public byte f() {
        String source = getSource();
        int i5 = this.currentPosition;
        while (i5 != -1 && i5 < source.length()) {
            int i6 = i5 + 1;
            char cCharAt = source.charAt(i5);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.currentPosition = i6;
                return AbstractC1127c.a(cCharAt);
            }
            i5 = i6;
        }
        this.currentPosition = source.length();
        return (byte) 10;
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public void h(char c) {
        if (this.currentPosition == -1) {
            v(c);
            throw null;
        }
        String source = getSource();
        int i5 = this.currentPosition;
        while (i5 < source.length()) {
            int i6 = i5 + 1;
            char cCharAt = source.charAt(i5);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.currentPosition = i6;
                if (cCharAt == c) {
                    return;
                }
                v(c);
                throw null;
            }
            i5 = i6;
        }
        this.currentPosition = -1;
        v(c);
        throw null;
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public String peekLeadingMatchingValue(String keyToMatch, boolean z6) {
        kotlin.jvm.internal.E.f(keyToMatch, "keyToMatch");
        int i5 = this.currentPosition;
        try {
            if (f() == 6 && kotlin.jvm.internal.E.a(peekString(z6), keyToMatch)) {
                k();
                if (f() == 5) {
                    return peekString(z6);
                }
            }
            return null;
        } finally {
            this.currentPosition = i5;
            k();
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public final int r(int i5) {
        if (i5 < getSource().length()) {
            return i5;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public int s() {
        char cCharAt;
        int i5 = this.currentPosition;
        if (i5 == -1) {
            return i5;
        }
        String source = getSource();
        while (i5 < source.length() && ((cCharAt = source.charAt(i5)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
            i5++;
        }
        this.currentPosition = i5;
        return i5;
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public String getSource() {
        return this.source;
    }
}
