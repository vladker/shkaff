package org.apache.poi.ss.format;

import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class CellNumberStringMod implements Comparable<CellNumberStringMod> {
    public static final int AFTER = 2;
    public static final int BEFORE = 1;
    public static final int REPLACE = 3;
    private CellNumberFormatter.Special end;
    private boolean endInclusive;
    private final int op;
    private final CellNumberFormatter.Special special;
    private boolean startInclusive;
    private CharSequence toAdd;

    public CellNumberStringMod(CellNumberFormatter.Special special, CharSequence charSequence, int i5) {
        this.special = special;
        this.toAdd = charSequence;
        this.op = i5;
    }

    public boolean equals(Object obj) {
        return (obj instanceof CellNumberStringMod) && compareTo((CellNumberStringMod) obj) == 0;
    }

    public CellNumberFormatter.Special getEnd() {
        return this.end;
    }

    public int getOp() {
        return this.op;
    }

    public CellNumberFormatter.Special getSpecial() {
        return this.special;
    }

    public CharSequence getToAdd() {
        return this.toAdd;
    }

    public int hashCode() {
        return this.special.hashCode() + this.op;
    }

    public boolean isEndInclusive() {
        return this.endInclusive;
    }

    public boolean isStartInclusive() {
        return this.startInclusive;
    }

    @Override // java.lang.Comparable
    public int compareTo(CellNumberStringMod cellNumberStringMod) {
        int i5 = this.special.pos - cellNumberStringMod.special.pos;
        return i5 != 0 ? i5 : this.op - cellNumberStringMod.op;
    }

    public CellNumberStringMod(CellNumberFormatter.Special special, boolean z6, CellNumberFormatter.Special special2, boolean z7, char c) {
        this(special, z6, special2, z7);
        this.toAdd = c + "";
    }

    public CellNumberStringMod(CellNumberFormatter.Special special, boolean z6, CellNumberFormatter.Special special2, boolean z7) {
        this.special = special;
        this.startInclusive = z6;
        this.end = special2;
        this.endInclusive = z7;
        this.op = 3;
        this.toAdd = "";
    }
}
