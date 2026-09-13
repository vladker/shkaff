package org.apache.xmlbeans.impl.regex;

import androidx.exifinterface.media.a;
import java.text.CharacterIterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Match implements Cloneable {
    int[] beginpos = null;
    int[] endpos = null;
    int nofgroups = 0;
    CharacterIterator ciSource = null;
    String strSource = null;
    char[] charSource = null;

    public synchronized Object clone() {
        Match match;
        try {
            match = new Match();
            int i5 = this.nofgroups;
            if (i5 > 0) {
                match.setNumberOfGroups(i5);
                CharacterIterator characterIterator = this.ciSource;
                if (characterIterator != null) {
                    match.setSource(characterIterator);
                }
                String str = this.strSource;
                if (str != null) {
                    match.setSource(str);
                }
                for (int i6 = 0; i6 < this.nofgroups; i6++) {
                    match.setBeginning(i6, getBeginning(i6));
                    match.setEnd(i6, getEnd(i6));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return match;
    }

    public int getBeginning(int i5) {
        int[] iArr = this.beginpos;
        if (iArr == null) {
            throw new IllegalStateException("A result is not set.");
        }
        if (i5 >= 0 && this.nofgroups > i5) {
            return iArr[i5];
        }
        throw new IllegalArgumentException(a.i(": ", this.nofgroups, i5, new StringBuilder("The parameter must be less than ")));
    }

    public String getCapturedText(int i5) {
        int[] iArr = this.beginpos;
        if (iArr == null) {
            throw new IllegalStateException("match() has never been called.");
        }
        if (i5 < 0 || this.nofgroups <= i5) {
            throw new IllegalArgumentException(a.i(": ", this.nofgroups, i5, new StringBuilder("The parameter must be less than ")));
        }
        int i6 = iArr[i5];
        int i7 = this.endpos[i5];
        if (i6 < 0 || i7 < 0) {
            return null;
        }
        CharacterIterator characterIterator = this.ciSource;
        if (characterIterator != null) {
            return REUtil.substring(characterIterator, i6, i7);
        }
        String str = this.strSource;
        return str != null ? str.substring(i6, i7) : new String(this.charSource, i6, i7 - i6);
    }

    public int getEnd(int i5) {
        int[] iArr = this.endpos;
        if (iArr == null) {
            throw new IllegalStateException("A result is not set.");
        }
        if (i5 >= 0 && this.nofgroups > i5) {
            return iArr[i5];
        }
        throw new IllegalArgumentException(a.i(": ", this.nofgroups, i5, new StringBuilder("The parameter must be less than ")));
    }

    public int getNumberOfGroups() {
        int i5 = this.nofgroups;
        if (i5 > 0) {
            return i5;
        }
        throw new IllegalStateException("A result is not set.");
    }

    public void setBeginning(int i5, int i6) {
        this.beginpos[i5] = i6;
    }

    public void setEnd(int i5, int i6) {
        this.endpos[i5] = i6;
    }

    public void setNumberOfGroups(int i5) {
        int i6 = this.nofgroups;
        this.nofgroups = i5;
        if (i6 <= 0 || i6 < i5 || i5 * 2 < i6) {
            this.beginpos = new int[i5];
            this.endpos = new int[i5];
        }
        for (int i7 = 0; i7 < i5; i7++) {
            this.beginpos[i7] = -1;
            this.endpos[i7] = -1;
        }
    }

    public void setSource(CharacterIterator characterIterator) {
        this.ciSource = characterIterator;
        this.strSource = null;
        this.charSource = null;
    }

    public void setSource(String str) {
        this.ciSource = null;
        this.strSource = str;
        this.charSource = null;
    }

    public void setSource(char[] cArr) {
        this.ciSource = null;
        this.strSource = null;
        this.charSource = cArr;
    }
}
