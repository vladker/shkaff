package org.apache.xmlbeans.impl.regex;

import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
final class IntStack {
    private int[] fData;
    private int fDepth;

    private void ensureCapacity(int i5) {
        int[] iArr = this.fData;
        if (iArr == null) {
            this.fData = new int[32];
        } else if (iArr.length <= i5) {
            int[] iArr2 = new int[iArr.length * 2];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.fData = iArr2;
        }
    }

    public void clear() {
        this.fDepth = 0;
    }

    public int elementAt(int i5) {
        return this.fData[i5];
    }

    public int peek() {
        return this.fData[this.fDepth - 1];
    }

    public int pop() {
        int[] iArr = this.fData;
        int i5 = this.fDepth - 1;
        this.fDepth = i5;
        return iArr[i5];
    }

    public void print() {
        System.out.print('(');
        System.out.print(this.fDepth);
        System.out.print(") {");
        for (int i5 = 0; i5 < this.fDepth; i5++) {
            if (i5 == 3) {
                System.out.print(" ...");
                break;
            }
            System.out.print(Chars.SPACE);
            System.out.print(this.fData[i5]);
            if (i5 < this.fDepth - 1) {
                System.out.print(',');
            }
        }
        System.out.print(" }");
        System.out.println();
    }

    public void push(int i5) {
        ensureCapacity(this.fDepth + 1);
        int[] iArr = this.fData;
        int i6 = this.fDepth;
        this.fDepth = i6 + 1;
        iArr[i6] = i5;
    }

    public int size() {
        return this.fDepth;
    }
}
