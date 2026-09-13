package kotlinx.serialization.json.internal;

import p147z3.C1929i;
import p147z3.C1938s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class c0 extends a0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(InterfaceC1145v reader, char[] buffer) {
        super(reader, buffer);
        kotlin.jvm.internal.E.f(reader, "reader");
        kotlin.jvm.internal.E.f(buffer, "buffer");
    }

    @Override // kotlinx.serialization.json.internal.a0, kotlinx.serialization.json.internal.AbstractC1126b
    public final boolean d() {
        l();
        int iS = s();
        if (iS >= getSource().f5739a || iS == -1) {
            return false;
        }
        return AbstractC1126b.p(getSource().charAt(iS));
    }

    @Override // kotlinx.serialization.json.internal.a0, kotlinx.serialization.json.internal.AbstractC1126b
    public final byte f() {
        l();
        C1132h source = getSource();
        int iS = s();
        if (iS >= source.f5739a || iS == -1) {
            return (byte) 10;
        }
        this.currentPosition = iS + 1;
        return AbstractC1127c.a(source.charAt(iS));
    }

    @Override // kotlinx.serialization.json.internal.a0, kotlinx.serialization.json.internal.AbstractC1126b
    public final void h(char c) {
        l();
        C1132h source = getSource();
        int iS = s();
        if (iS >= source.f5739a || iS == -1) {
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
        l();
        C1132h source = getSource();
        int iS = s();
        if (iS >= source.f5739a || iS == -1) {
            return (byte) 10;
        }
        this.currentPosition = iS;
        return AbstractC1127c.a(source.charAt(iS));
    }

    @Override // kotlinx.serialization.json.internal.a0, kotlinx.serialization.json.internal.AbstractC1126b
    public final int s() {
        int iR;
        int i5;
        C1938s c1938s;
        int i6 = this.currentPosition;
        while (true) {
            iR = r(i6);
            if (iR == -1) {
                break;
            }
            char cCharAt = getSource().charAt(iR);
            if (cCharAt == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t') {
                i6 = iR + 1;
            } else {
                if (cCharAt != '/' || (i5 = iR + 1) >= getSource().f5739a) {
                    break;
                }
                int iR2 = iR + 2;
                char cCharAt2 = getSource().charAt(i5);
                if (cCharAt2 == '*') {
                    boolean z6 = false;
                    while (true) {
                        if (iR != -1) {
                            int iE = X3.b0.e(getSource(), "*/", iR2, false, 4);
                            if (iE != -1) {
                                c1938s = p147z3.A.to(Integer.valueOf(iE + 2), Boolean.TRUE);
                                break;
                            }
                            if (getSource().charAt(getSource().f5739a - 1) != '*') {
                                iR2 = r(getSource().f5739a);
                            } else {
                                int i7 = getSource().f5739a - 1;
                                if (getSource().f5739a - i7 > this.threshold) {
                                    iR2 = i7;
                                } else {
                                    this.currentPosition = i7;
                                    l();
                                    iR2 = (this.currentPosition != 0 || getSource().f5739a == 0) ? -1 : 0;
                                }
                                if (!z6) {
                                    z6 = true;
                                }
                            }
                            iR = iR2;
                        }
                        this.currentPosition = getSource().f5739a;
                        AbstractC1126b.n(this, "Expected end of the block comment: \"*/\", but had EOF instead", 0, null, 6);
                        throw new C1929i();
                    }
                }
                if (cCharAt2 == '/') {
                    while (true) {
                        if (iR != -1) {
                            int iD = X3.b0.d(getSource(), '\n', iR2, false, 4);
                            if (iD != -1) {
                                c1938s = p147z3.A.to(Integer.valueOf(iD + 1), Boolean.TRUE);
                                break;
                            }
                            iR2 = r(getSource().f5739a);
                            iR = iR2;
                        } else {
                            c1938s = p147z3.A.to(-1, Boolean.TRUE);
                            break;
                        }
                    }
                } else {
                    c1938s = p147z3.A.to(Integer.valueOf(iR), Boolean.FALSE);
                }
                int iIntValue = ((Number) c1938s.f9134a).intValue();
                if (!((Boolean) c1938s.b).booleanValue()) {
                    iR = iIntValue;
                    break;
                }
                i6 = iIntValue;
            }
        }
        this.currentPosition = iR;
        return iR;
    }
}
