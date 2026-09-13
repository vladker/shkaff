package org.apache.commons.collections4.sequence;

import java.util.List;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.functors.DefaultEquator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SequencesComparator<T> {
    private final Equator<? super T> equator;
    private final List<T> sequence1;
    private final List<T> sequence2;
    private final int[] vDown;
    private final int[] vUp;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Snake {
        private final int diag;
        private final int end;
        private final int start;

        public Snake(int i5, int i6, int i7) {
            this.start = i5;
            this.end = i6;
            this.diag = i7;
        }

        public int getDiag() {
            return this.diag;
        }

        public int getEnd() {
            return this.end;
        }

        public int getStart() {
            return this.start;
        }
    }

    public SequencesComparator(List<T> list, List<T> list2) {
        this(list, list2, DefaultEquator.defaultEquator());
    }

    private void buildScript(int i5, int i6, int i7, int i8, EditScript<T> editScript) {
        Snake middleSnake = getMiddleSnake(i5, i6, i7, i8);
        if (middleSnake != null && ((middleSnake.getStart() != i6 || middleSnake.getDiag() != i6 - i8) && (middleSnake.getEnd() != i5 || middleSnake.getDiag() != i5 - i7))) {
            buildScript(i5, middleSnake.getStart(), i7, middleSnake.getStart() - middleSnake.getDiag(), editScript);
            for (int start = middleSnake.getStart(); start < middleSnake.getEnd(); start++) {
                editScript.append(new KeepCommand<>(this.sequence1.get(start)));
            }
            buildScript(middleSnake.getEnd(), i6, middleSnake.getEnd() - middleSnake.getDiag(), i8, editScript);
            return;
        }
        int i9 = i5;
        int i10 = i7;
        while (true) {
            if (i9 >= i6 && i10 >= i8) {
                return;
            }
            if (i9 < i6 && i10 < i8 && this.equator.equate(this.sequence1.get(i9), this.sequence2.get(i10))) {
                editScript.append(new KeepCommand<>(this.sequence1.get(i9)));
                i9++;
            } else if (i6 - i5 > i8 - i7) {
                editScript.append(new DeleteCommand<>(this.sequence1.get(i9)));
                i9++;
            } else {
                editScript.append(new InsertCommand<>(this.sequence2.get(i10)));
            }
            i10++;
        }
    }

    private Snake buildSnake(int i5, int i6, int i7, int i8) {
        int i9 = i5;
        while (true) {
            int i10 = i9 - i6;
            if (i10 >= i8 || i9 >= i7 || !this.equator.equate(this.sequence1.get(i9), this.sequence2.get(i10))) {
                break;
            }
            i9++;
        }
        return new Snake(i5, i9, i6);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c8  */
    private Snake getMiddleSnake(int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11 = i5;
        int i12 = i6 - i11;
        int i13 = i8 - i7;
        if (i12 == 0 || i13 == 0) {
            return null;
        }
        int i14 = i12 - i13;
        int i15 = i13 + i12;
        if (i15 % 2 != 0) {
            i15++;
        }
        int i16 = i15 / 2;
        int i17 = i16 + 1;
        this.vDown[i17] = i11;
        this.vUp[i17] = i6 + 1;
        int i18 = 0;
        while (i18 <= i16) {
            int i19 = -i18;
            for (int i20 = i19; i20 <= i18; i20 += 2) {
                int i21 = i20 + i16;
                if (i20 == i19) {
                    int[] iArr = this.vDown;
                    iArr[i21] = iArr[i21 + 1];
                } else {
                    if (i20 != i18) {
                        int[] iArr2 = this.vDown;
                        if (iArr2[i21 - 1] < iArr2[i21 + 1]) {
                            int[] iArr3 = this.vDown;
                            iArr3[i21] = iArr3[i21 + 1];
                        }
                    }
                    int[] iArr4 = this.vDown;
                    iArr4[i21] = iArr4[i21 - 1] + 1;
                }
                int i22 = this.vDown[i21];
                for (int i23 = ((i22 - i11) + i7) - i20; i22 < i6 && i23 < i8 && this.equator.equate(this.sequence1.get(i22), this.sequence2.get(i23)); i23++) {
                    i22++;
                    this.vDown[i21] = i22;
                }
                if (i14 % 2 != 0 && i14 - i18 <= i20 && i20 <= i14 + i18 && (i10 = this.vUp[i21 - i14]) <= this.vDown[i21]) {
                    return buildSnake(i10, (i20 + i11) - i7, i6, i8);
                }
            }
            int i24 = i14 - i18;
            int i25 = i24;
            while (true) {
                int i26 = i14 + i18;
                if (i25 <= i26) {
                    int i27 = (i25 + i16) - i14;
                    if (i25 == i24) {
                        int[] iArr5 = this.vUp;
                        iArr5[i27] = iArr5[i27 + 1] - 1;
                    } else {
                        if (i25 != i26) {
                            int[] iArr6 = this.vUp;
                            if (iArr6[i27 + 1] <= iArr6[i27 - 1]) {
                                int[] iArr7 = this.vUp;
                                iArr7[i27] = iArr7[i27 + 1] - 1;
                            }
                        }
                        int[] iArr8 = this.vUp;
                        iArr8[i27] = iArr8[i27 - 1];
                    }
                    int i28 = this.vUp[i27] - 1;
                    int i29 = ((i28 - i11) + i7) - i25;
                    while (i28 >= i11 && i29 >= i7 && this.equator.equate(this.sequence1.get(i28), this.sequence2.get(i29))) {
                        this.vUp[i27] = i28;
                        i29--;
                        i11 = i5;
                        i28--;
                    }
                    if (i14 % 2 == 0 && i19 <= i25 && i25 <= i18 && (i9 = this.vUp[i27]) <= this.vDown[i27 + i14]) {
                        return buildSnake(i9, (i25 + i5) - i7, i6, i8);
                    }
                    i25 += 2;
                    i11 = i5;
                }
            }
            i18++;
            i11 = i5;
        }
        throw new RuntimeException("Internal Error");
    }

    public EditScript<T> getScript() {
        EditScript<T> editScript = new EditScript<>();
        buildScript(0, this.sequence1.size(), 0, this.sequence2.size(), editScript);
        return editScript;
    }

    public SequencesComparator(List<T> list, List<T> list2, Equator<? super T> equator) {
        this.sequence1 = list;
        this.sequence2 = list2;
        this.equator = equator;
        int size = list2.size() + list.size() + 2;
        this.vDown = new int[size];
        this.vUp = new int[size];
    }
}
