package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import java.io.PrintStream;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class KeyFrameArray {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CustomArray {
        private static final int EMPTY = 999;
        int mCount;
        int[] mKeys = new int[101];
        CustomAttribute[] mValues = new CustomAttribute[101];

        public CustomArray() {
            clear();
        }

        public void append(int i5, CustomAttribute customAttribute) {
            if (this.mValues[i5] != null) {
                remove(i5);
            }
            this.mValues[i5] = customAttribute;
            int[] iArr = this.mKeys;
            int i6 = this.mCount;
            this.mCount = i6 + 1;
            iArr[i6] = i5;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.mKeys, 999);
            Arrays.fill(this.mValues, (Object) null);
            this.mCount = 0;
        }

        public void dump() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.mKeys, this.mCount)));
            System.out.print("K: [");
            int i5 = 0;
            while (i5 < this.mCount) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append(i5 == 0 ? "" : ", ");
                sb.append(valueAt(i5));
                printStream.print(sb.toString());
                i5++;
            }
            System.out.println("]");
        }

        public int keyAt(int i5) {
            return this.mKeys[i5];
        }

        public void remove(int i5) {
            this.mValues[i5] = null;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                int i8 = this.mCount;
                if (i6 >= i8) {
                    this.mCount = i8 - 1;
                    return;
                }
                int[] iArr = this.mKeys;
                if (i5 == iArr[i6]) {
                    iArr[i6] = 999;
                    i7++;
                }
                if (i6 != i7) {
                    iArr[i6] = iArr[i7];
                }
                i7++;
                i6++;
            }
        }

        public int size() {
            return this.mCount;
        }

        public CustomAttribute valueAt(int i5) {
            return this.mValues[this.mKeys[i5]];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CustomVar {
        private static final int EMPTY = 999;
        int mCount;
        int[] mKeys = new int[101];
        CustomVariable[] mValues = new CustomVariable[101];

        public CustomVar() {
            clear();
        }

        public void append(int i5, CustomVariable customVariable) {
            if (this.mValues[i5] != null) {
                remove(i5);
            }
            this.mValues[i5] = customVariable;
            int[] iArr = this.mKeys;
            int i6 = this.mCount;
            this.mCount = i6 + 1;
            iArr[i6] = i5;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.mKeys, 999);
            Arrays.fill(this.mValues, (Object) null);
            this.mCount = 0;
        }

        public void dump() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.mKeys, this.mCount)));
            System.out.print("K: [");
            int i5 = 0;
            while (i5 < this.mCount) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append(i5 == 0 ? "" : ", ");
                sb.append(valueAt(i5));
                printStream.print(sb.toString());
                i5++;
            }
            System.out.println("]");
        }

        public int keyAt(int i5) {
            return this.mKeys[i5];
        }

        public void remove(int i5) {
            this.mValues[i5] = null;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                int i8 = this.mCount;
                if (i6 >= i8) {
                    this.mCount = i8 - 1;
                    return;
                }
                int[] iArr = this.mKeys;
                if (i5 == iArr[i6]) {
                    iArr[i6] = 999;
                    i7++;
                }
                if (i6 != i7) {
                    iArr[i6] = iArr[i7];
                }
                i7++;
                i6++;
            }
        }

        public int size() {
            return this.mCount;
        }

        public CustomVariable valueAt(int i5) {
            return this.mValues[this.mKeys[i5]];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FloatArray {
        private static final int EMPTY = 999;
        int mCount;
        int[] mKeys = new int[101];
        float[][] mValues = new float[101][];

        public FloatArray() {
            clear();
        }

        public void append(int i5, float[] fArr) {
            if (this.mValues[i5] != null) {
                remove(i5);
            }
            this.mValues[i5] = fArr;
            int[] iArr = this.mKeys;
            int i6 = this.mCount;
            this.mCount = i6 + 1;
            iArr[i6] = i5;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.mKeys, 999);
            Arrays.fill(this.mValues, (Object) null);
            this.mCount = 0;
        }

        public void dump() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.mKeys, this.mCount)));
            System.out.print("K: [");
            int i5 = 0;
            while (i5 < this.mCount) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append(i5 == 0 ? "" : ", ");
                sb.append(Arrays.toString(valueAt(i5)));
                printStream.print(sb.toString());
                i5++;
            }
            System.out.println("]");
        }

        public int keyAt(int i5) {
            return this.mKeys[i5];
        }

        public void remove(int i5) {
            this.mValues[i5] = null;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                int i8 = this.mCount;
                if (i6 >= i8) {
                    this.mCount = i8 - 1;
                    return;
                }
                int[] iArr = this.mKeys;
                if (i5 == iArr[i6]) {
                    iArr[i6] = 999;
                    i7++;
                }
                if (i6 != i7) {
                    iArr[i6] = iArr[i7];
                }
                i7++;
                i6++;
            }
        }

        public int size() {
            return this.mCount;
        }

        public float[] valueAt(int i5) {
            return this.mValues[this.mKeys[i5]];
        }
    }
}
