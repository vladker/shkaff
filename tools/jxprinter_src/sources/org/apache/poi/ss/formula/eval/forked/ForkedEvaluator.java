package org.apache.poi.ss.formula.eval.forked;

import com.google.android.material.color.utilities.g;
import java.util.stream.Stream;
import o5.i;
import org.apache.poi.ss.formula.CollaboratingWorkbooksEnvironment;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.IStabilityClassifier;
import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ForkedEvaluator {
    private final WorkbookEvaluator _evaluator;
    private final ForkedEvaluationWorkbook _sewb;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.eval.forked.ForkedEvaluator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.NUMERIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BLANK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private ForkedEvaluator(EvaluationWorkbook evaluationWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        ForkedEvaluationWorkbook forkedEvaluationWorkbook = new ForkedEvaluationWorkbook(evaluationWorkbook);
        this._sewb = forkedEvaluationWorkbook;
        this._evaluator = new WorkbookEvaluator(forkedEvaluationWorkbook, iStabilityClassifier, uDFFinder);
    }

    public static ForkedEvaluator create(Workbook workbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        return new ForkedEvaluator(workbook.createEvaluationWorkbook(), iStabilityClassifier, uDFFinder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ WorkbookEvaluator[] lambda$setupEnvironment$1(int i5) {
        return new WorkbookEvaluator[i5];
    }

    public static void setupEnvironment(String[] strArr, ForkedEvaluator[] forkedEvaluatorArr) {
        CollaboratingWorkbooksEnvironment.setup(strArr, (WorkbookEvaluator[]) Stream.of((Object[]) forkedEvaluatorArr).map(new g(27)).toArray(new i(6)));
    }

    public void copyUpdatedCells(Workbook workbook) {
        this._sewb.copyUpdatedCells(workbook);
    }

    public ValueEval evaluate(String str, int i5, int i6) {
        EvaluationCell evaluationCell = this._sewb.getEvaluationCell(str, i5, i6);
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[evaluationCell.getCellType().ordinal()]) {
            case 1:
                return BoolEval.valueOf(evaluationCell.getBooleanCellValue());
            case 2:
                return ErrorEval.valueOf(evaluationCell.getErrorCellValue());
            case 3:
                return this._evaluator.evaluate(evaluationCell);
            case 4:
                return new NumberEval(evaluationCell.getNumericCellValue());
            case 5:
                return new StringEval(evaluationCell.getStringCellValue());
            case 6:
                return null;
            default:
                throw new IllegalStateException("Bad cell type (" + evaluationCell.getCellType() + ")");
        }
    }

    public void updateCell(String str, int i5, int i6, ValueEval valueEval) {
        ForkedEvaluationCell orCreateUpdatableCell = this._sewb.getOrCreateUpdatableCell(str, i5, i6);
        orCreateUpdatableCell.setValue(valueEval);
        this._evaluator.notifyUpdateCell(orCreateUpdatableCell);
    }
}
