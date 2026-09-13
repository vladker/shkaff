package kotlinx.serialization.json.internal;

import p147z3.C1929i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class i0 extends g0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(String source) {
        super(source);
        kotlin.jvm.internal.E.f(source, "source");
    }

    @Override // kotlinx.serialization.json.internal.g0, kotlinx.serialization.json.internal.AbstractC1126b
    public final boolean d() {
        int iS = s();
        if (iS >= getSource().length() || iS == -1) {
            return false;
        }
        return AbstractC1126b.p(getSource().charAt(iS));
    }

    @Override // kotlinx.serialization.json.internal.g0, kotlinx.serialization.json.internal.AbstractC1126b
    public final byte f() {
        String source = getSource();
        int iS = s();
        if (iS >= source.length() || iS == -1) {
            return (byte) 10;
        }
        this.currentPosition = iS + 1;
        return AbstractC1127c.a(source.charAt(iS));
    }

    @Override // kotlinx.serialization.json.internal.g0, kotlinx.serialization.json.internal.AbstractC1126b
    public final void h(char c) {
        String source = getSource();
        int iS = s();
        if (iS >= source.length() || iS == -1) {
            this.currentPosition = -1;
            v(c);
            throw null;
        }
        char cCharAt = source.charAt(iS);
        this.currentPosition = iS + 1;
        if (cCharAt == c) {
            return;
        }
        v(c);
        throw null;
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1126b
    public final byte q() {
        String source = getSource();
        int iS = s();
        if (iS >= source.length() || iS == -1) {
            return (byte) 10;
        }
        this.currentPosition = iS;
        return AbstractC1127c.a(source.charAt(iS));
    }

    @Override // kotlinx.serialization.json.internal.g0, kotlinx.serialization.json.internal.AbstractC1126b
    public final int s() {
        int i5;
        int iD = this.currentPosition;
        if (iD == -1) {
            return iD;
        }
        String source = getSource();
        while (iD < source.length()) {
            char cCharAt = source.charAt(iD);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                if (cCharAt != '/' || (i5 = iD + 1) >= source.length()) {
                    break;
                }
                char cCharAt2 = source.charAt(i5);
                if (cCharAt2 == '*') {
                    int iE = X3.b0.e(source, "*/", iD + 2, false, 4);
                    if (iE == -1) {
                        this.currentPosition = source.length();
                        AbstractC1126b.n(this, "Expected end of the block comment: \"*/\", but had EOF instead", 0, null, 6);
                        throw new C1929i();
                    }
                    iD = iE + 2;
                } else {
                    if (cCharAt2 != '/') {
                        break;
                    }
                    iD = X3.b0.d(source, '\n', iD + 2, false, 4);
                    if (iD == -1) {
                        iD = source.length();
                    }
                }
            }
            iD++;
        }
        this.currentPosition = iD;
        return iD;
    }
}
