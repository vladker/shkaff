package androidx.constraintlayout.core.utils;

import I4.a;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class GridCore extends VirtualLayout {
    private static final int DEFAULT_SIZE = 3;
    public static final int HORIZONTAL = 0;
    private static final int MAX_COLUMNS = 50;
    private static final int MAX_ROWS = 50;
    public static final int SPANS_RESPECT_WIDGET_ORDER = 2;
    public static final int SUB_GRID_BY_COL_ROW = 1;
    public static final int VERTICAL = 1;
    private ConstraintWidget[] mBoxWidgets;
    private String mColumnWeights;
    private int mColumns;
    private int mColumnsSet;
    private int[][] mConstraintMatrix;
    ConstraintWidgetContainer mContainer;
    private int mFlags;
    private float mHorizontalGaps;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private String mRowWeights;
    private int mRows;
    private int mRowsSet;
    private String mSkips;
    private int[][] mSpanMatrix;
    private String mSpans;
    private float mVerticalGaps;
    private boolean mExtraSpaceHandled = false;
    private int mNextAvailableIndex = 0;
    Set<String> mSpanIds = new HashSet();
    private int mSpanIndex = 0;

    public GridCore() {
        updateActualRowsAndColumns();
        initMatrices();
    }

    private void addConstraints() {
        setBoxWidgetVerticalChains();
        setBoxWidgetHorizontalChains();
        arrangeWidgets();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0066  */
    private void arrangeWidgets() {
        int[][] iArr;
        int i5;
        for (int i6 = 0; i6 < this.mWidgetsCount; i6++) {
            if (!this.mSpanIds.contains(this.mWidgets[i6].stringId)) {
                int nextPosition = getNextPosition();
                int rowByIndex = getRowByIndex(nextPosition);
                int colByIndex = getColByIndex(nextPosition);
                if (nextPosition == -1) {
                    return;
                }
                if (!isSpansRespectWidgetOrder() || (iArr = this.mSpanMatrix) == null || (i5 = this.mSpanIndex) >= iArr.length) {
                    connectWidget(this.mWidgets[i6], rowByIndex, colByIndex, 1, 1);
                } else {
                    int[] iArr2 = iArr[i5];
                    if (iArr2[0] == nextPosition) {
                        this.mPositionMatrix[rowByIndex][colByIndex] = true;
                        if (invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                            ConstraintWidget constraintWidget = this.mWidgets[i6];
                            int[] iArr3 = this.mSpanMatrix[this.mSpanIndex];
                            connectWidget(constraintWidget, rowByIndex, colByIndex, iArr3[1], iArr3[2]);
                            this.mSpanIndex++;
                        }
                    } else {
                        connectWidget(this.mWidgets[i6], rowByIndex, colByIndex, 1, 1);
                    }
                }
            }
        }
    }

    private void clearHorizontalAttributes(ConstraintWidget constraintWidget) {
        constraintWidget.setHorizontalWeight(-1.0f);
        constraintWidget.mLeft.reset();
        constraintWidget.mRight.reset();
    }

    private void clearVerticalAttributes(ConstraintWidget constraintWidget) {
        constraintWidget.setVerticalWeight(-1.0f);
        constraintWidget.mTop.reset();
        constraintWidget.mBottom.reset();
        constraintWidget.mBaseline.reset();
    }

    private void connectWidget(ConstraintWidget constraintWidget, int i5, int i6, int i7, int i8) {
        constraintWidget.mLeft.connect(this.mBoxWidgets[i6].mLeft, 0);
        constraintWidget.mTop.connect(this.mBoxWidgets[i5].mTop, 0);
        constraintWidget.mRight.connect(this.mBoxWidgets[(i6 + i8) - 1].mRight, 0);
        constraintWidget.mBottom.connect(this.mBoxWidgets[(i5 + i7) - 1].mBottom, 0);
    }

    private void createBoxes() {
        int iMax = Math.max(this.mRows, this.mColumns);
        ConstraintWidget[] constraintWidgetArr = this.mBoxWidgets;
        int i5 = 0;
        if (constraintWidgetArr == null) {
            this.mBoxWidgets = new ConstraintWidget[iMax];
            while (true) {
                ConstraintWidget[] constraintWidgetArr2 = this.mBoxWidgets;
                if (i5 >= constraintWidgetArr2.length) {
                    return;
                }
                constraintWidgetArr2[i5] = makeNewWidget();
                i5++;
            }
        } else {
            if (iMax == constraintWidgetArr.length) {
                return;
            }
            ConstraintWidget[] constraintWidgetArr3 = new ConstraintWidget[iMax];
            while (i5 < iMax) {
                ConstraintWidget[] constraintWidgetArr4 = this.mBoxWidgets;
                if (i5 < constraintWidgetArr4.length) {
                    constraintWidgetArr3[i5] = constraintWidgetArr4[i5];
                } else {
                    constraintWidgetArr3[i5] = makeNewWidget();
                }
                i5++;
            }
            while (true) {
                ConstraintWidget[] constraintWidgetArr5 = this.mBoxWidgets;
                if (iMax >= constraintWidgetArr5.length) {
                    this.mBoxWidgets = constraintWidgetArr3;
                    return;
                } else {
                    this.mContainer.remove(constraintWidgetArr5[iMax]);
                    iMax++;
                }
            }
        }
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
        String str = this.mSkips;
        if (str != null && !str.trim().isEmpty() && (spans2 = parseSpans(this.mSkips, false)) != null) {
            handleSkips(spans2);
        }
        String str2 = this.mSpans;
        if (str2 == null || str2.trim().isEmpty() || (spans = parseSpans(this.mSpans, true)) == null) {
            return;
        }
        handleSpans(spans);
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
        for (int[] iArr2 : iArr) {
            if (!invalidatePositions(getRowByIndex(iArr2[0]), getColByIndex(iArr2[0]), iArr2[1], iArr2[2])) {
                return;
            }
        }
    }

    private void handleSpans(int[][] iArr) {
        if (!isSpansRespectWidgetOrder()) {
            for (int i5 = 0; i5 < iArr.length; i5++) {
                int rowByIndex = getRowByIndex(iArr[i5][0]);
                int colByIndex = getColByIndex(iArr[i5][0]);
                int[] iArr2 = iArr[i5];
                if (!invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                    break;
                }
                ConstraintWidget constraintWidget = this.mWidgets[i5];
                int[] iArr3 = iArr[i5];
                connectWidget(constraintWidget, rowByIndex, colByIndex, iArr3[1], iArr3[2]);
                this.mSpanIds.add(this.mWidgets[i5].stringId);
            }
        }
    }

    private void initMatrices() {
        boolean[][] zArr;
        int[][] iArr = this.mConstraintMatrix;
        boolean z6 = false;
        if (iArr != null && iArr.length == this.mWidgetsCount && (zArr = this.mPositionMatrix) != null && zArr.length == this.mRows && zArr[0].length == this.mColumns) {
            z6 = true;
        }
        if (!z6) {
            initVariables();
        }
        fillConstraintMatrix(z6);
    }

    private void initVariables() {
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.mRows, this.mColumns);
        this.mPositionMatrix = zArr;
        for (boolean[] zArr2 : zArr) {
            Arrays.fill(zArr2, true);
        }
        int i5 = this.mWidgetsCount;
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

    private boolean isSpansRespectWidgetOrder() {
        return (this.mFlags & 2) > 0;
    }

    private boolean isSubGridByColRow() {
        return (this.mFlags & 1) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$parseSpans$0(String str, String str2) {
        return Integer.parseInt(str.split(ParameterizedMessage.ERROR_MSG_SEPARATOR)[0]) - Integer.parseInt(str2.split(ParameterizedMessage.ERROR_MSG_SEPARATOR)[0]);
    }

    private ConstraintWidget makeNewWidget() {
        ConstraintWidget constraintWidget = new ConstraintWidget();
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        constraintWidget.stringId = String.valueOf(constraintWidget.hashCode());
        return constraintWidget;
    }

    private int[][] parseSpans(String str, boolean z6) {
        try {
            String[] strArrSplit = str.split(",");
            Arrays.sort(strArrSplit, new a(3));
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, strArrSplit.length, 3);
            if (this.mRows != 1 && this.mColumns != 1) {
                for (int i5 = 0; i5 < strArrSplit.length; i5++) {
                    String[] strArrSplit2 = strArrSplit[i5].trim().split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
                    String[] strArrSplit3 = strArrSplit2[1].split("x");
                    iArr[i5][0] = Integer.parseInt(strArrSplit2[0]);
                    if (isSubGridByColRow()) {
                        iArr[i5][1] = Integer.parseInt(strArrSplit3[1]);
                        iArr[i5][2] = Integer.parseInt(strArrSplit3[0]);
                    } else {
                        iArr[i5][1] = Integer.parseInt(strArrSplit3[0]);
                        iArr[i5][2] = Integer.parseInt(strArrSplit3[1]);
                    }
                }
                return iArr;
            }
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < strArrSplit.length; i8++) {
                String[] strArrSplit4 = strArrSplit[i8].trim().split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
                iArr[i8][0] = Integer.parseInt(strArrSplit4[0]);
                int[] iArr2 = iArr[i8];
                iArr2[1] = 1;
                iArr2[2] = 1;
                if (this.mColumns == 1) {
                    iArr2[1] = Integer.parseInt(strArrSplit4[1]);
                    i6 += iArr[i8][1];
                    if (z6) {
                        i6--;
                    }
                }
                if (this.mRows == 1) {
                    iArr[i8][2] = Integer.parseInt(strArrSplit4[1]);
                    i7 += iArr[i8][2];
                    if (z6) {
                        i7--;
                    }
                }
            }
            if (i6 != 0 && !this.mExtraSpaceHandled) {
                setRows(this.mRows + i6);
            }
            if (i7 != 0 && !this.mExtraSpaceHandled) {
                setColumns(this.mColumns + i7);
            }
            this.mExtraSpaceHandled = true;
            return iArr;
        } catch (Exception unused) {
            return null;
        }
    }

    private float[] parseWeights(int i5, String str) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        float[] fArr = new float[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 < strArrSplit.length) {
                try {
                    fArr[i6] = Float.parseFloat(strArrSplit[i6]);
                } catch (Exception e) {
                    System.err.println("Error parsing `" + strArrSplit[i6] + "`: " + e.getMessage());
                    fArr[i6] = 1.0f;
                }
            } else {
                fArr[i6] = 1.0f;
            }
        }
        return fArr;
    }

    private void setBoxWidgetHorizontalChains() {
        int i5;
        int iMax = Math.max(this.mRows, this.mColumns);
        ConstraintWidget constraintWidget = this.mBoxWidgets[0];
        float[] weights = parseWeights(this.mColumns, this.mColumnWeights);
        if (this.mColumns == 1) {
            clearHorizontalAttributes(constraintWidget);
            constraintWidget.mLeft.connect(this.mLeft, 0);
            constraintWidget.mRight.connect(this.mRight, 0);
            return;
        }
        int i6 = 0;
        while (true) {
            i5 = this.mColumns;
            if (i6 >= i5) {
                break;
            }
            ConstraintWidget constraintWidget2 = this.mBoxWidgets[i6];
            clearHorizontalAttributes(constraintWidget2);
            if (weights != null) {
                constraintWidget2.setHorizontalWeight(weights[i6]);
            }
            if (i6 > 0) {
                constraintWidget2.mLeft.connect(this.mBoxWidgets[i6 - 1].mRight, 0);
            } else {
                constraintWidget2.mLeft.connect(this.mLeft, 0);
            }
            if (i6 < this.mColumns - 1) {
                constraintWidget2.mRight.connect(this.mBoxWidgets[i6 + 1].mLeft, 0);
            } else {
                constraintWidget2.mRight.connect(this.mRight, 0);
            }
            if (i6 > 0) {
                constraintWidget2.mLeft.mMargin = (int) this.mHorizontalGaps;
            }
            i6++;
        }
        while (i5 < iMax) {
            ConstraintWidget constraintWidget3 = this.mBoxWidgets[i5];
            clearHorizontalAttributes(constraintWidget3);
            constraintWidget3.mLeft.connect(this.mLeft, 0);
            constraintWidget3.mRight.connect(this.mRight, 0);
            i5++;
        }
    }

    private void setBoxWidgetVerticalChains() {
        int i5;
        int iMax = Math.max(this.mRows, this.mColumns);
        ConstraintWidget constraintWidget = this.mBoxWidgets[0];
        float[] weights = parseWeights(this.mRows, this.mRowWeights);
        if (this.mRows == 1) {
            clearVerticalAttributes(constraintWidget);
            constraintWidget.mTop.connect(this.mTop, 0);
            constraintWidget.mBottom.connect(this.mBottom, 0);
            return;
        }
        int i6 = 0;
        while (true) {
            i5 = this.mRows;
            if (i6 >= i5) {
                break;
            }
            ConstraintWidget constraintWidget2 = this.mBoxWidgets[i6];
            clearVerticalAttributes(constraintWidget2);
            if (weights != null) {
                constraintWidget2.setVerticalWeight(weights[i6]);
            }
            if (i6 > 0) {
                constraintWidget2.mTop.connect(this.mBoxWidgets[i6 - 1].mBottom, 0);
            } else {
                constraintWidget2.mTop.connect(this.mTop, 0);
            }
            if (i6 < this.mRows - 1) {
                constraintWidget2.mBottom.connect(this.mBoxWidgets[i6 + 1].mTop, 0);
            } else {
                constraintWidget2.mBottom.connect(this.mBottom, 0);
            }
            if (i6 > 0) {
                constraintWidget2.mTop.mMargin = (int) this.mVerticalGaps;
            }
            i6++;
        }
        while (i5 < iMax) {
            ConstraintWidget constraintWidget3 = this.mBoxWidgets[i5];
            clearVerticalAttributes(constraintWidget3);
            constraintWidget3.mTop.connect(this.mTop, 0);
            constraintWidget3.mBottom.connect(this.mBottom, 0);
            i5++;
        }
    }

    private void setupGrid(boolean z6) {
        int[][] spans;
        if (this.mRows < 1 || this.mColumns < 1) {
            return;
        }
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
            this.mSpanIds.clear();
        }
        this.mNextAvailableIndex = 0;
        String str = this.mSkips;
        if (str != null && !str.trim().isEmpty() && (spans = parseSpans(this.mSkips, false)) != null) {
            handleSkips(spans);
        }
        String str2 = this.mSpans;
        if (str2 != null && !str2.trim().isEmpty()) {
            this.mSpanMatrix = parseSpans(this.mSpans, true);
        }
        createBoxes();
        int[][] iArr = this.mSpanMatrix;
        if (iArr != null) {
            handleSpans(iArr);
        }
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
            this.mRows = ((this.mWidgetsCount + i7) - 1) / i7;
        } else if (i6 > 0) {
            this.mRows = i6;
            this.mColumns = ((this.mWidgetsCount + i6) - 1) / i6;
        } else {
            int iSqrt = (int) (Math.sqrt(this.mWidgetsCount) + 1.5d);
            this.mRows = iSqrt;
            this.mColumns = ((this.mWidgetsCount + iSqrt) - 1) / iSqrt;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(@Nullable LinearSystem linearSystem, boolean z6) {
        super.addToSolver(linearSystem, z6);
        addConstraints();
    }

    @Nullable
    public String getColumnWeights() {
        return this.mColumnWeights;
    }

    @Nullable
    public ConstraintWidgetContainer getContainer() {
        return this.mContainer;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public float getHorizontalGaps() {
        return this.mHorizontalGaps;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    @Nullable
    public String getRowWeights() {
        return this.mRowWeights;
    }

    public float getVerticalGaps() {
        return this.mVerticalGaps;
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int i5, int i6, int i7, int i8) {
        super.measure(i5, i6, i7, i8);
        this.mContainer = (ConstraintWidgetContainer) getParent();
        setupGrid(false);
        this.mContainer.add(this.mBoxWidgets);
    }

    public void setColumnWeights(@NonNull String str) {
        String str2 = this.mColumnWeights;
        if (str2 == null || !str2.equals(str)) {
            this.mColumnWeights = str;
        }
    }

    public void setColumns(int i5) {
        if (i5 <= 50 && this.mColumnsSet != i5) {
            this.mColumnsSet = i5;
            updateActualRowsAndColumns();
            initVariables();
        }
    }

    public void setContainer(@NonNull ConstraintWidgetContainer constraintWidgetContainer) {
        this.mContainer = constraintWidgetContainer;
    }

    public void setFlags(int i5) {
        this.mFlags = i5;
    }

    public void setHorizontalGaps(float f6) {
        if (f6 >= 0.0f && this.mHorizontalGaps != f6) {
            this.mHorizontalGaps = f6;
        }
    }

    public void setOrientation(int i5) {
        if ((i5 == 0 || i5 == 1) && this.mOrientation != i5) {
            this.mOrientation = i5;
        }
    }

    public void setRowWeights(@NonNull String str) {
        String str2 = this.mRowWeights;
        if (str2 == null || !str2.equals(str)) {
            this.mRowWeights = str;
        }
    }

    public void setRows(int i5) {
        if (i5 <= 50 && this.mRowsSet != i5) {
            this.mRowsSet = i5;
            updateActualRowsAndColumns();
            initVariables();
        }
    }

    public void setSkips(@NonNull String str) {
        String str2 = this.mSkips;
        if (str2 == null || !str2.equals(str)) {
            this.mExtraSpaceHandled = false;
            this.mSkips = str;
        }
    }

    public void setSpans(@NonNull CharSequence charSequence) {
        String str = this.mSpans;
        if (str == null || !str.equals(charSequence.toString())) {
            this.mExtraSpaceHandled = false;
            this.mSpans = charSequence.toString();
        }
    }

    public void setVerticalGaps(float f6) {
        if (f6 >= 0.0f && this.mVerticalGaps != f6) {
            this.mVerticalGaps = f6;
        }
    }

    public GridCore(int i5, int i6) {
        this.mRowsSet = i5;
        this.mColumnsSet = i6;
        if (i5 > 50) {
            this.mRowsSet = 3;
        }
        if (i6 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        initMatrices();
    }
}
