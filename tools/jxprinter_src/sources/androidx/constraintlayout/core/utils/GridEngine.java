package androidx.constraintlayout.core.utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class GridEngine {
    private static final int DEFAULT_SIZE = 3;
    public static final int HORIZONTAL = 0;
    private static final int MAX_COLUMNS = 50;
    private static final int MAX_ROWS = 50;
    public static final int VERTICAL = 1;
    private int mColumns;
    private int mColumnsSet;
    private int[][] mConstraintMatrix;
    private int mNextAvailableIndex = 0;
    private int mNumWidgets;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private int mRows;
    private int mRowsSet;
    private String mStrSkips;
    private String mStrSpans;

    public GridEngine() {
    }

    private void addAllConstraintPositions() {
        for (int i5 = 0; i5 < this.mNumWidgets; i5++) {
            if (leftOfWidget(i5) == -1) {
                int nextPosition = getNextPosition();
                int rowByIndex = getRowByIndex(nextPosition);
                int colByIndex = getColByIndex(nextPosition);
                if (nextPosition == -1) {
                    return;
                } else {
                    addConstraintPosition(i5, rowByIndex, colByIndex, 1, 1);
                }
            }
        }
    }

    private void addConstraintPosition(int i5, int i6, int i7, int i8, int i9) {
        int[] iArr = this.mConstraintMatrix[i5];
        iArr[0] = i7;
        iArr[1] = i6;
        iArr[2] = (i7 + i9) - 1;
        iArr[3] = (i6 + i8) - 1;
    }

    private void fillConstraintMatrix(boolean z6) {
        int[][] spans;
        int[][] spans2;
        if (z6) {
            for (int i5 = 0; i5 < this.mPositionMatrix.length; i5++) {
                int i6 = 0;
                while (true) {
                    boolean[][] zArr = this.mPositionMatrix;
                    if (i6 < zArr[0].length) {
                        zArr[i5][i6] = true;
                        i6++;
                    }
                }
            }
            for (int i7 = 0; i7 < this.mConstraintMatrix.length; i7++) {
                int i8 = 0;
                while (true) {
                    int[][] iArr = this.mConstraintMatrix;
                    if (i8 < iArr[0].length) {
                        iArr[i7][i8] = -1;
                        i8++;
                    }
                }
            }
        }
        this.mNextAvailableIndex = 0;
        String str = this.mStrSkips;
        if (str != null && !str.trim().isEmpty() && (spans2 = parseSpans(this.mStrSkips)) != null) {
            handleSkips(spans2);
        }
        String str2 = this.mStrSpans;
        if (str2 != null && !str2.trim().isEmpty() && (spans = parseSpans(this.mStrSpans)) != null) {
            handleSpans(spans);
        }
        addAllConstraintPositions();
    }

    private int getColByIndex(int i5) {
        return this.mOrientation == 1 ? i5 / this.mRows : i5 % this.mColumns;
    }

    private int getNextPosition() {
        boolean z6 = false;
        int i5 = 0;
        while (!z6) {
            i5 = this.mNextAvailableIndex;
            if (i5 >= this.mRows * this.mColumns) {
                return -1;
            }
            int rowByIndex = getRowByIndex(i5);
            int colByIndex = getColByIndex(this.mNextAvailableIndex);
            boolean[] zArr = this.mPositionMatrix[rowByIndex];
            if (zArr[colByIndex]) {
                zArr[colByIndex] = false;
                z6 = true;
            }
            this.mNextAvailableIndex++;
        }
        return i5;
    }

    private int getRowByIndex(int i5) {
        return this.mOrientation == 1 ? i5 % this.mRows : i5 / this.mColumns;
    }

    private void handleSkips(int[][] iArr) {
        for (int i5 = 0; i5 < iArr.length; i5++) {
            int rowByIndex = getRowByIndex(iArr[i5][0]);
            int colByIndex = getColByIndex(iArr[i5][0]);
            int[] iArr2 = iArr[i5];
            if (!invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                return;
            }
        }
    }

    private void handleSpans(int[][] iArr) {
        for (int i5 = 0; i5 < iArr.length; i5++) {
            int rowByIndex = getRowByIndex(iArr[i5][0]);
            int colByIndex = getColByIndex(iArr[i5][0]);
            int[] iArr2 = iArr[i5];
            if (!invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                return;
            }
            int[] iArr3 = iArr[i5];
            addConstraintPosition(i5, rowByIndex, colByIndex, iArr3[1], iArr3[2]);
        }
    }

    private void initVariables() {
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.mRows, this.mColumns);
        this.mPositionMatrix = zArr;
        for (boolean[] zArr2 : zArr) {
            Arrays.fill(zArr2, true);
        }
        int i5 = this.mNumWidgets;
        if (i5 > 0) {
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i5, 4);
            this.mConstraintMatrix = iArr;
            for (int[] iArr2 : iArr) {
                Arrays.fill(iArr2, -1);
            }
        }
    }

    private boolean invalidatePositions(int i5, int i6, int i7, int i8) {
        for (int i9 = i5; i9 < i5 + i7; i9++) {
            for (int i10 = i6; i10 < i6 + i8; i10++) {
                boolean[][] zArr = this.mPositionMatrix;
                if (i9 < zArr.length && i10 < zArr[0].length) {
                    boolean[] zArr2 = zArr[i9];
                    if (zArr2[i10]) {
                        zArr2[i10] = false;
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isSpansValid(CharSequence charSequence) {
        return charSequence != null;
    }

    private int[][] parseSpans(String str) {
        if (!isSpansValid(str)) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, strArrSplit.length, 3);
        for (int i5 = 0; i5 < strArrSplit.length; i5++) {
            String[] strArrSplit2 = strArrSplit[i5].trim().split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            String[] strArrSplit3 = strArrSplit2[1].split("x");
            iArr[i5][0] = Integer.parseInt(strArrSplit2[0]);
            iArr[i5][1] = Integer.parseInt(strArrSplit3[0]);
            iArr[i5][2] = Integer.parseInt(strArrSplit3[1]);
        }
        return iArr;
    }

    private void updateActualRowsAndColumns() {
        int i5;
        int i6 = this.mRowsSet;
        if (i6 != 0 && (i5 = this.mColumnsSet) != 0) {
            this.mRows = i6;
            this.mColumns = i5;
            return;
        }
        int i7 = this.mColumnsSet;
        if (i7 > 0) {
            this.mColumns = i7;
            this.mRows = ((this.mNumWidgets + i7) - 1) / i7;
        } else if (i6 > 0) {
            this.mRows = i6;
            this.mColumns = ((this.mNumWidgets + i6) - 1) / i6;
        } else {
            int iSqrt = (int) (Math.sqrt(this.mNumWidgets) + 1.5d);
            this.mRows = iSqrt;
            this.mColumns = ((this.mNumWidgets + iSqrt) - 1) / iSqrt;
        }
    }

    public int bottomOfWidget(int i5) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i5 >= iArr.length) {
            return 0;
        }
        return iArr[i5][3];
    }

    public int leftOfWidget(int i5) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i5 >= iArr.length) {
            return 0;
        }
        return iArr[i5][0];
    }

    public int rightOfWidget(int i5) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i5 >= iArr.length) {
            return 0;
        }
        return iArr[i5][2];
    }

    public void setColumns(int i5) {
        if (i5 <= 50 && this.mColumnsSet != i5) {
            this.mColumnsSet = i5;
            updateActualRowsAndColumns();
        }
    }

    public void setNumWidgets(int i5) {
        if (i5 > this.mRows * this.mColumns) {
            return;
        }
        this.mNumWidgets = i5;
    }

    public void setOrientation(int i5) {
        if ((i5 == 0 || i5 == 1) && this.mOrientation != i5) {
            this.mOrientation = i5;
        }
    }

    public void setRows(int i5) {
        if (i5 <= 50 && this.mRowsSet != i5) {
            this.mRowsSet = i5;
            updateActualRowsAndColumns();
        }
    }

    public void setSkips(String str) {
        String str2 = this.mStrSkips;
        if (str2 == null || !str2.equals(str)) {
            this.mStrSkips = str;
        }
    }

    public void setSpans(CharSequence charSequence) {
        String str = this.mStrSpans;
        if (str == null || !str.equals(charSequence.toString())) {
            this.mStrSpans = charSequence.toString();
        }
    }

    public void setup() {
        boolean[][] zArr;
        int[][] iArr = this.mConstraintMatrix;
        boolean z6 = false;
        if (iArr != null && iArr.length == this.mNumWidgets && (zArr = this.mPositionMatrix) != null && zArr.length == this.mRows && zArr[0].length == this.mColumns) {
            z6 = true;
        }
        if (!z6) {
            initVariables();
        }
        fillConstraintMatrix(z6);
    }

    public int topOfWidget(int i5) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i5 >= iArr.length) {
            return 0;
        }
        return iArr[i5][1];
    }

    public GridEngine(int i5, int i6) {
        this.mRowsSet = i5;
        this.mColumnsSet = i6;
        if (i5 > 50) {
            this.mRowsSet = 3;
        }
        if (i6 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        initVariables();
    }

    public GridEngine(int i5, int i6, int i7) {
        this.mRowsSet = i5;
        this.mColumnsSet = i6;
        this.mNumWidgets = i7;
        if (i5 > 50) {
            this.mRowsSet = 3;
        }
        if (i6 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        int i8 = this.mRows;
        int i9 = this.mColumns;
        if (i7 > i8 * i9 || i7 < 1) {
            this.mNumWidgets = i8 * i9;
        }
        initVariables();
        fillConstraintMatrix(false);
    }
}
