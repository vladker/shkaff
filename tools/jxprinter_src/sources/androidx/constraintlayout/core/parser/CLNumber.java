package androidx.constraintlayout.core.parser;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class CLNumber extends CLElement {
    float mValue;

    public CLNumber(char[] cArr) {
        super(cArr);
        this.mValue = Float.NaN;
    }

    public static CLElement allocate(char[] cArr) {
        return new CLNumber(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CLNumber) {
            float f6 = getFloat();
            float f7 = ((CLNumber) obj).getFloat();
            if ((Float.isNaN(f6) && Float.isNaN(f7)) || f6 == f7) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public float getFloat() {
        if (Float.isNaN(this.mValue) && hasContent()) {
            this.mValue = Float.parseFloat(content());
        }
        return this.mValue;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int getInt() {
        if (Float.isNaN(this.mValue) && hasContent()) {
            this.mValue = Integer.parseInt(content());
        }
        return (int) this.mValue;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        float f6 = this.mValue;
        return iHashCode + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0);
    }

    public boolean isInt() {
        float f6 = getFloat();
        return ((float) ((int) f6)) == f6;
    }

    public void putValue(float f6) {
        this.mValue = f6;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i5, int i6) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i5);
        float f6 = getFloat();
        int i7 = (int) f6;
        if (i7 == f6) {
            sb.append(i7);
        } else {
            sb.append(f6);
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        float f6 = getFloat();
        int i5 = (int) f6;
        if (i5 == f6) {
            return AbstractC0157z.k(i5, "");
        }
        return "" + f6;
    }

    public CLNumber(float f6) {
        super(null);
        this.mValue = f6;
    }
}
