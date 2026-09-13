package kotlinx.serialization.json.internal;

import A3.AbstractC0151t;
import org.apache.logging.log4j.util.Chars;
import p147z3.C1929i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class a0 extends AbstractC1126b {
    private final char[] buffer;
    private final InterfaceC1145v reader;
    private final C1132h source;
    protected int threshold;

    public a0(InterfaceC1145v reader, char[] buffer) {
        kotlin.jvm.internal.E.f(reader, "reader");
        kotlin.jvm.internal.E.f(buffer, "buffer");
        this.buffer = buffer;
        this.threshold = 128;
        this.source = new C1132h(buffer);
        w(0);
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public final void c(int i5, int i6) {
        getEscapedString().append(getSource().getBuffer$kotlinx_serialization_json(), i5, i6 - i5);
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public String consumeKeyString() {
        h(Chars.DQUOTE);
        int i5 = this.currentPosition;
        C1132h source = getSource();
        int i6 = source.f5739a;
        int i7 = i5;
        while (true) {
            if (i7 >= i6) {
                i7 = -1;
                break;
            }
            if (source.charAt(i7) == '\"') {
                break;
            }
            i7++;
        }
        if (i7 == -1) {
            int iR = r(i5);
            if (iR != -1) {
                return consumeString(getSource(), this.currentPosition, iR);
            }
            fail$kotlinx_serialization_json((byte) 1, true);
            throw new C1929i();
        }
        for (int i8 = i5; i8 < i7; i8++) {
            if (getSource().charAt(i8) == '\\') {
                return consumeString(getSource(), this.currentPosition, i8);
            }
        }
        this.currentPosition = i7 + 1;
        return substring(i5, i7);
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public boolean d() {
        l();
        int i5 = this.currentPosition;
        while (true) {
            int iR = r(i5);
            if (iR == -1) {
                this.currentPosition = iR;
                return false;
            }
            char cCharAt = getSource().charAt(iR);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.currentPosition = iR;
                return AbstractC1126b.p(cCharAt);
            }
            i5 = iR + 1;
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public byte f() {
        l();
        C1132h source = getSource();
        int i5 = this.currentPosition;
        while (true) {
            int iR = r(i5);
            if (iR == -1) {
                this.currentPosition = iR;
                return (byte) 10;
            }
            int i6 = iR + 1;
            byte bA = AbstractC1127c.a(source.charAt(iR));
            if (bA != 3) {
                this.currentPosition = i6;
                return bA;
            }
            i5 = i6;
        }
    }

    public final char[] getBuffer() {
        return this.buffer;
    }

    public final InterfaceC1145v getReader() {
        return null;
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public void h(char c) {
        l();
        C1132h source = getSource();
        int i5 = this.currentPosition;
        while (true) {
            int iR = r(i5);
            if (iR == -1) {
                this.currentPosition = iR;
                v(c);
                throw null;
            }
            int i6 = iR + 1;
            char cCharAt = source.charAt(iR);
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
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public final void l() {
        int i5 = getSource().f5739a - this.currentPosition;
        if (i5 > this.threshold) {
            return;
        }
        w(i5);
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public String peekLeadingMatchingValue(String keyToMatch, boolean z6) {
        kotlin.jvm.internal.E.f(keyToMatch, "keyToMatch");
        return null;
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public final int r(int i5) {
        if (i5 < getSource().f5739a) {
            return i5;
        }
        this.currentPosition = i5;
        l();
        return (this.currentPosition != 0 || getSource().length() == 0) ? -1 : 0;
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public int s() {
        int iR;
        char cCharAt;
        int i5 = this.currentPosition;
        while (true) {
            iR = r(i5);
            if (iR == -1 || !((cCharAt = getSource().charAt(iR)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
                break;
            }
            i5 = iR + 1;
        }
        this.currentPosition = iR;
        return iR;
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public String substring(int i5, int i6) {
        return getSource().substring(i5, i6);
    }

    public final void w(int i5) {
        char[] buffer$kotlinx_serialization_json = getSource().getBuffer$kotlinx_serialization_json();
        if (i5 != 0) {
            int i6 = this.currentPosition;
            AbstractC0151t.copyInto(buffer$kotlinx_serialization_json, buffer$kotlinx_serialization_json, 0, i6, i6 + i5);
        }
        if (i5 != getSource().f5739a) {
            throw null;
        }
        this.currentPosition = 0;
    }

    public final void x() {
        C1136l.INSTANCE.release(this.buffer);
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public C1132h getSource() {
        return this.source;
    }
}
