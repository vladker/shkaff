package androidx.constraintlayout.core.parser;

import kotlinx.serialization.json.internal.AbstractC1127c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class CLToken extends CLElement {
    int mIndex;
    char[] mTokenFalse;
    char[] mTokenNull;
    char[] mTokenTrue;
    Type mType;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    public CLToken(char[] cArr) {
        super(cArr);
        this.mIndex = 0;
        this.mType = Type.UNKNOWN;
        this.mTokenTrue = "true".toCharArray();
        this.mTokenFalse = "false".toCharArray();
        this.mTokenNull = AbstractC1127c.NULL.toCharArray();
    }

    public static CLElement allocate(char[] cArr) {
        return new CLToken(cArr);
    }

    public boolean getBoolean() throws CLParsingException {
        Type type = this.mType;
        if (type == Type.TRUE) {
            return true;
        }
        if (type == Type.FALSE) {
            return false;
        }
        throw new CLParsingException("this token is not a boolean: <" + content() + ">", this);
    }

    public Type getType() {
        return this.mType;
    }

    public boolean isNull() throws CLParsingException {
        if (this.mType == Type.NULL) {
            return true;
        }
        throw new CLParsingException("this token is not a null: <" + content() + ">", this);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i5, int i6) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i5);
        sb.append(content());
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        if (!CLParser.sDebug) {
            return content();
        }
        return "<" + content() + ">";
    }

    public boolean validate(char c, long j6) {
        int iOrdinal = this.mType.ordinal();
        boolean z6 = false;
        if (iOrdinal == 0) {
            char[] cArr = this.mTokenTrue;
            int i5 = this.mIndex;
            if (cArr[i5] == c) {
                this.mType = Type.TRUE;
            } else if (this.mTokenFalse[i5] == c) {
                this.mType = Type.FALSE;
            } else if (this.mTokenNull[i5] == c) {
                this.mType = Type.NULL;
            }
            z6 = true;
        } else if (iOrdinal == 1) {
            char[] cArr2 = this.mTokenTrue;
            int i6 = this.mIndex;
            z6 = cArr2[i6] == c;
            if (z6 && i6 + 1 == cArr2.length) {
                setEnd(j6);
            }
        } else if (iOrdinal == 2) {
            char[] cArr3 = this.mTokenFalse;
            int i7 = this.mIndex;
            z6 = cArr3[i7] == c;
            if (z6 && i7 + 1 == cArr3.length) {
                setEnd(j6);
            }
        } else if (iOrdinal == 3) {
            char[] cArr4 = this.mTokenNull;
            int i8 = this.mIndex;
            z6 = cArr4[i8] == c;
            if (z6 && i8 + 1 == cArr4.length) {
                setEnd(j6);
            }
        }
        this.mIndex++;
        return z6;
    }
}
