package kotlinx.serialization.json.internal;

import A3.AbstractC0157z;
import org.apache.logging.log4j.util.Chars;
import p147z3.C1929i;
import p147z3.C1937q;

/* JADX INFO: renamed from: kotlinx.serialization.json.internal.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractC1126b {
    public int currentPosition;
    private String peekedString;
    public final K path = new K();
    private StringBuilder escapedString = new StringBuilder();

    public static /* synthetic */ void n(AbstractC1126b abstractC1126b, String str, int i5, String str2, int i6) {
        if ((i6 & 2) != 0) {
            i5 = abstractC1126b.currentPosition;
        }
        if ((i6 & 4) != 0) {
            str2 = "";
        }
        abstractC1126b.fail(str, i5, str2);
    }

    public static boolean p(char c) {
        return (c == ',' || c == ':' || c == ']' || c == '}') ? false : true;
    }

    public final int a(int i5, int i6) {
        c(i5, i6);
        int iR = r(i6 + 1);
        if (iR == -1) {
            throw AbstractC1125a.k(this, "Expected escape sequence to continue, got EOF", 0, null, 6);
        }
        int i7 = iR + 1;
        char cCharAt = getSource().charAt(iR);
        if (cCharAt == 'u') {
            return b(getSource(), i7);
        }
        char c = cCharAt < 'u' ? C1137m.ESCAPE_2_CHAR[cCharAt] : (char) 0;
        if (c != 0) {
            this.escapedString.append(c);
            return i7;
        }
        throw AbstractC1125a.k(this, "Invalid escaped char '" + cCharAt + Chars.QUOTE, 0, null, 6);
    }

    public final int b(CharSequence charSequence, int i5) {
        int i6 = i5 + 4;
        if (i6 < charSequence.length()) {
            this.escapedString.append((char) (o(charSequence, i5 + 3) + (o(charSequence, i5) << 12) + (o(charSequence, i5 + 1) << 8) + (o(charSequence, i5 + 2) << 4)));
            return i6;
        }
        this.currentPosition = i5;
        l();
        if (this.currentPosition + 4 < charSequence.length()) {
            return b(charSequence, this.currentPosition);
        }
        throw AbstractC1125a.k(this, "Unexpected EOF during unicode escape", 0, null, 6);
    }

    public void c(int i5, int i6) {
        this.escapedString.append(getSource(), i5, i6);
    }

    public abstract String consumeKeyString();

    public final String consumeString() {
        String str = this.peekedString;
        if (str == null) {
            return consumeKeyString();
        }
        kotlin.jvm.internal.E.c(str);
        this.peekedString = null;
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0040  */
    /* JADX WARN: Code duplicated, block: B:22:0x004f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0051  */
    /* JADX WARN: Code duplicated, block: B:24:0x0059  */
    /* JADX WARN: Code duplicated, block: B:27:0x0067  */
    /* JADX WARN: Code duplicated, block: B:30:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x006a A[SYNTHETIC] */
    public void consumeStringChunked(boolean z6, O3.l consumeChunk) {
        int i5;
        int iR;
        kotlin.jvm.internal.E.f(consumeChunk, "consumeChunk");
        byte bQ = q();
        if (!z6 || bQ == 0) {
            if (!z6) {
                h(Chars.DQUOTE);
            }
            int iR2 = this.currentPosition;
            char cCharAt = getSource().charAt(iR2);
            boolean z7 = false;
            int i6 = iR2;
            while (true) {
                if (z6) {
                    if (AbstractC1127c.a(cCharAt) != 0) {
                        break;
                    }
                    if (z6 && cCharAt == '\\') {
                        iR = r(a(iR2, i6));
                        z7 = true;
                        i5 = iR;
                    } else {
                        int i7 = i6 + 1;
                        i5 = iR2;
                        iR = i7;
                    }
                    if (iR >= getSource().length()) {
                        if (z7) {
                            consumeChunk.invoke(j(i5, iR));
                        } else {
                            consumeChunk.invoke(substring(i5, iR));
                        }
                        iR2 = r(iR);
                        if (iR2 != -1) {
                            throw AbstractC1125a.k(this, "EOF", iR2, null, 4);
                        }
                        i6 = iR2;
                        z7 = false;
                    } else {
                        int i8 = i5;
                        i6 = iR;
                        iR2 = i8;
                    }
                    cCharAt = getSource().charAt(i6);
                } else {
                    if (cCharAt == '\"') {
                        break;
                    }
                    if (z6) {
                        int i9 = i6 + 1;
                        i5 = iR2;
                        iR = i9;
                    } else {
                        int i10 = i6 + 1;
                        i5 = iR2;
                        iR = i10;
                    }
                    if (iR >= getSource().length()) {
                        if (z7) {
                            consumeChunk.invoke(j(i5, iR));
                        } else {
                            consumeChunk.invoke(substring(i5, iR));
                        }
                        iR2 = r(iR);
                        if (iR2 != -1) {
                            throw AbstractC1125a.k(this, "EOF", iR2, null, 4);
                        }
                        i6 = iR2;
                        z7 = false;
                    } else {
                        int i11 = i5;
                        i6 = iR;
                        iR2 = i11;
                    }
                    cCharAt = getSource().charAt(i6);
                }
            }
            if (z7) {
                consumeChunk.invoke(j(iR2, i6));
            } else {
                consumeChunk.invoke(substring(iR2, i6));
            }
            this.currentPosition = i6;
            if (z6) {
                return;
            }
            h(Chars.DQUOTE);
        }
    }

    public final String consumeStringLenient() {
        String str = this.peekedString;
        if (str != null) {
            kotlin.jvm.internal.E.c(str);
            this.peekedString = null;
            return str;
        }
        int iS = s();
        if (iS >= getSource().length() || iS == -1) {
            throw AbstractC1125a.k(this, "EOF", iS, null, 4);
        }
        byte bA = AbstractC1127c.a(getSource().charAt(iS));
        if (bA == 1) {
            return consumeString();
        }
        if (bA != 0) {
            throw AbstractC1125a.k(this, "Expected beginning of the string, but got " + getSource().charAt(iS), 0, null, 6);
        }
        boolean z6 = false;
        while (AbstractC1127c.a(getSource().charAt(iS)) == 0) {
            iS++;
            if (iS >= getSource().length()) {
                c(this.currentPosition, iS);
                int iR = r(iS);
                if (iR == -1) {
                    this.currentPosition = iS;
                    return j(0, 0);
                }
                iS = iR;
                z6 = true;
            }
        }
        String strSubstring = !z6 ? substring(this.currentPosition, iS) : j(this.currentPosition, iS);
        this.currentPosition = iS;
        return strSubstring;
    }

    public final String consumeStringLenientNotNull() {
        String strConsumeStringLenient = consumeStringLenient();
        if (!kotlin.jvm.internal.E.a(strConsumeStringLenient, AbstractC1127c.NULL) || getSource().charAt(this.currentPosition - 1) == '\"') {
            return strConsumeStringLenient;
        }
        throw AbstractC1125a.k(this, "Unexpected 'null' value instead of string literal", 0, null, 6);
    }

    public abstract boolean d();

    public final void e(int i5, String str) {
        if (getSource().length() - i5 < str.length()) {
            throw AbstractC1125a.k(this, "Unexpected end of boolean literal", 0, null, 6);
        }
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (str.charAt(i6) != (getSource().charAt(i5 + i6) | Chars.SPACE)) {
                throw AbstractC1125a.k(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + Chars.QUOTE, 0, null, 6);
            }
        }
        this.currentPosition = str.length() + i5;
    }

    public abstract byte f();

    public final Void fail(String message, int i5, String hint) {
        kotlin.jvm.internal.E.f(message, "message");
        kotlin.jvm.internal.E.f(hint, "hint");
        String strConcat = hint.length() == 0 ? "" : "\n".concat(hint);
        StringBuilder sbX = AbstractC0157z.x(message, " at path: ");
        sbX.append(this.path.getPath());
        sbX.append(strConcat);
        throw E.JsonDecodingException(i5, sbX.toString(), getSource());
    }

    public final Void fail$kotlinx_serialization_json(byte b, boolean z6) {
        String str = AbstractC1127c.tokenDescription(b);
        int i5 = z6 ? this.currentPosition - 1 : this.currentPosition;
        throw AbstractC1125a.k(this, androidx.collection.a.p("Expected ", str, ", but had '", (this.currentPosition == getSource().length() || i5 < 0) ? "EOF" : String.valueOf(getSource().charAt(i5)), "' instead"), i5, null, 4);
    }

    public final void failOnUnknownKey(String key) {
        kotlin.jvm.internal.E.f(key, "key");
        fail("Encountered an unknown key '" + key + Chars.QUOTE, X3.b0.g(key, 0, 6, substring(0, this.currentPosition)), AbstractC1127c.ignoreUnknownKeysHint);
        throw new C1929i();
    }

    public final byte g(byte b) {
        byte bF = f();
        if (bF == b) {
            return bF;
        }
        fail$kotlinx_serialization_json(b, true);
        throw new C1929i();
    }

    public final StringBuilder getEscapedString() {
        return this.escapedString;
    }

    public abstract CharSequence getSource();

    public abstract void h(char c);

    public final long i() {
        boolean z6;
        boolean z7;
        double dPow;
        int iR = r(s());
        int i5 = 0;
        if (iR >= getSource().length() || iR == -1) {
            throw AbstractC1125a.k(this, "EOF", 0, null, 6);
        }
        if (getSource().charAt(iR) == '\"') {
            iR++;
            if (iR == getSource().length()) {
                throw AbstractC1125a.k(this, "EOF", 0, null, 6);
            }
            z6 = true;
        } else {
            z6 = false;
        }
        int i6 = iR;
        int i7 = 0;
        boolean z8 = false;
        boolean z9 = false;
        long j6 = 0;
        long j7 = 0;
        while (true) {
            if (i6 == getSource().length()) {
                z6 = z6;
                z7 = z8;
                break;
            }
            char cCharAt = getSource().charAt(i6);
            if ((cCharAt != 'e' && cCharAt != 'E') || z8) {
                z6 = z6;
                if (cCharAt == '-' && z8) {
                    if (i6 == iR) {
                        throw AbstractC1125a.k(this, "Unexpected symbol '-' in numeric literal", i5, null, 6);
                    }
                    i6++;
                    i7 = i5;
                } else if (cCharAt != '+' || !z8) {
                    z7 = z8;
                    if (cCharAt != '-') {
                        if (AbstractC1127c.a(cCharAt) != 0) {
                            break;
                        }
                        i6++;
                        int i8 = cCharAt - '0';
                        if (i8 < 0 || i8 >= 10) {
                            throw AbstractC1125a.k(this, "Unexpected symbol '" + cCharAt + "' in numeric literal", i5, null, 6);
                        }
                        if (z7) {
                            j6 = (j6 * ((long) 10)) + ((long) i8);
                            z8 = z7;
                        } else {
                            j7 = (j7 * ((long) 10)) - ((long) i8);
                            if (j7 > 0) {
                                throw AbstractC1125a.k(this, "Numeric value overflow", 0, null, 6);
                            }
                            z6 = z6;
                            z8 = z7;
                            i5 = 0;
                        }
                    } else {
                        if (i6 != iR) {
                            throw AbstractC1125a.k(this, "Unexpected symbol '-' in numeric literal", i5, null, 6);
                        }
                        i6++;
                        z6 = z6;
                        z8 = z7;
                        z9 = true;
                    }
                } else {
                    if (i6 == iR) {
                        throw AbstractC1125a.k(this, "Unexpected symbol '+' in numeric literal", i5, null, 6);
                    }
                    i6++;
                    z6 = z6;
                    i7 = 1;
                }
            } else {
                if (i6 == iR) {
                    throw AbstractC1125a.k(this, "Unexpected symbol " + cCharAt + " in numeric literal", i5, null, 6);
                }
                i6++;
                i7 = 1;
                z8 = true;
            }
        }
        boolean z10 = i6 != iR;
        if (iR == i6 || (z9 && iR == i6 - 1)) {
            throw AbstractC1125a.k(this, "Expected numeric literal", 0, null, 6);
        }
        if (z6) {
            if (!z10) {
                throw AbstractC1125a.k(this, "EOF", 0, null, 6);
            }
            if (getSource().charAt(i6) != '\"') {
                throw AbstractC1125a.k(this, "Expected closing quotation mark", 0, null, 6);
            }
            i6++;
        }
        this.currentPosition = i6;
        if (z7) {
            double d = j7;
            if (i7 == 0) {
                dPow = Math.pow(10.0d, -j6);
            } else {
                if (i7 != 1) {
                    throw new C1937q();
                }
                dPow = Math.pow(10.0d, j6);
            }
            double d6 = d * dPow;
            if (d6 > 9.223372036854776E18d || d6 < -9.223372036854776E18d) {
                throw AbstractC1125a.k(this, "Numeric value overflow", 0, null, 6);
            }
            if (Math.floor(d6) != d6) {
                throw AbstractC1125a.k(this, "Can't convert " + d6 + " to Long", 0, null, 6);
            }
            j7 = (long) d6;
        }
        if (z9) {
            return j7;
        }
        if (j7 != Long.MIN_VALUE) {
            return -j7;
        }
        throw AbstractC1125a.k(this, "Numeric value overflow", 0, null, 6);
    }

    public final String j(int i5, int i6) {
        c(i5, i6);
        String string = this.escapedString.toString();
        kotlin.jvm.internal.E.e(string, "toString(...)");
        this.escapedString.setLength(0);
        return string;
    }

    public final void k() {
        this.peekedString = null;
    }

    public final void m() {
        if (f() == 10) {
            return;
        }
        throw AbstractC1125a.k(this, "Expected EOF after parsing, but had " + getSource().charAt(this.currentPosition - 1) + " instead", 0, null, 6);
    }

    public final int o(CharSequence charSequence, int i5) {
        char cCharAt = charSequence.charAt(i5);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        throw AbstractC1125a.k(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, null, 6);
    }

    public abstract String peekLeadingMatchingValue(String str, boolean z6);

    public final String peekString(boolean z6) {
        String strConsumeString;
        byte bQ = q();
        if (z6) {
            if (bQ != 1 && bQ != 0) {
                return null;
            }
            strConsumeString = consumeStringLenient();
        } else {
            if (bQ != 1) {
                return null;
            }
            strConsumeString = consumeString();
        }
        this.peekedString = strConsumeString;
        return strConsumeString;
    }

    public byte q() {
        CharSequence source = getSource();
        int i5 = this.currentPosition;
        while (true) {
            int iR = r(i5);
            if (iR == -1) {
                this.currentPosition = iR;
                return (byte) 10;
            }
            char cCharAt = source.charAt(iR);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                this.currentPosition = iR;
                return AbstractC1127c.a(cCharAt);
            }
            i5 = iR + 1;
        }
    }

    public abstract int r(int i5);

    public final void require$kotlinx_serialization_json(boolean z6, int i5, O3.a message) {
        kotlin.jvm.internal.E.f(message, "message");
        if (!z6) {
            throw AbstractC1125a.k(this, (String) message.invoke(), i5, null, 4);
        }
    }

    public abstract int s();

    public final void setEscapedString(StringBuilder sb) {
        kotlin.jvm.internal.E.f(sb, "<set-?>");
        this.escapedString = sb;
    }

    public String substring(int i5, int i6) {
        return getSource().subSequence(i5, i6).toString();
    }

    public final boolean t() {
        int iS = s();
        CharSequence source = getSource();
        if (iS >= source.length() || iS == -1 || source.charAt(iS) != ',') {
            return false;
        }
        this.currentPosition++;
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("JsonReader(source='");
        sb.append((Object) getSource());
        sb.append("', currentPosition=");
        return AbstractC0157z.p(sb, this.currentPosition, ')');
    }

    public final boolean u(boolean z6) {
        int iR = r(s());
        int length = getSource().length() - iR;
        if (length >= 4 && iR != -1) {
            for (int i5 = 0; i5 < 4; i5++) {
                if (AbstractC1127c.NULL.charAt(i5) == getSource().charAt(iR + i5)) {
                }
            }
            if (length <= 4 || AbstractC1127c.a(getSource().charAt(iR + 4)) != 0) {
                if (z6) {
                    this.currentPosition = iR + 4;
                }
                return true;
            }
        }
        return false;
    }

    public final void v(char c) {
        int i5 = this.currentPosition;
        if (i5 > 0 && c == '\"') {
            try {
                this.currentPosition = i5 - 1;
                String strConsumeStringLenient = consumeStringLenient();
                this.currentPosition = i5;
                if (kotlin.jvm.internal.E.a(strConsumeStringLenient, AbstractC1127c.NULL)) {
                    fail("Expected string literal but 'null' literal was found", this.currentPosition - 1, AbstractC1127c.coerceInputValuesHint);
                    throw new C1929i();
                }
            } catch (Throwable th) {
                this.currentPosition = i5;
                throw th;
            }
        }
        fail$kotlinx_serialization_json(AbstractC1127c.a(c), true);
        throw new C1929i();
    }

    public final String consumeString(CharSequence source, int i5, int i6) {
        String strJ;
        kotlin.jvm.internal.E.f(source, "source");
        char cCharAt = source.charAt(i6);
        boolean z6 = false;
        while (cCharAt != '\"') {
            if (cCharAt == '\\') {
                i5 = r(a(i5, i6));
                if (i5 == -1) {
                    throw AbstractC1125a.k(this, "Unexpected EOF", i5, null, 4);
                }
            } else {
                i6++;
                if (i6 >= source.length()) {
                    c(i5, i6);
                    i5 = r(i6);
                    if (i5 == -1) {
                        throw AbstractC1125a.k(this, "Unexpected EOF", i5, null, 4);
                    }
                } else {
                    continue;
                }
                cCharAt = source.charAt(i6);
            }
            i6 = i5;
            z6 = true;
            cCharAt = source.charAt(i6);
        }
        if (!z6) {
            strJ = substring(i5, i6);
        } else {
            strJ = j(i5, i6);
        }
        this.currentPosition = i6 + 1;
        return strJ;
    }

    public void l() {
    }
}
