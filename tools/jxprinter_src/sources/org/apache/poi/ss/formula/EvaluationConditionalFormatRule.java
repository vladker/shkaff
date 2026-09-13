package org.apache.poi.ss.formula;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.AggregateFunction;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.ConditionFilterData;
import org.apache.poi.ss.usermodel.ConditionFilterType;
import org.apache.poi.ss.usermodel.ConditionType;
import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.ExcelNumberFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EvaluationConditionalFormatRule implements Comparable<EvaluationConditionalFormatRule> {
    private final DecimalFormat decimalTextFormat;
    private final ConditionalFormatting formatting;
    private final int formattingIndex;
    private final String formula1;
    private final String formula2;
    private final String lowerText;
    private final Map<CellRangeAddress, Set<ValueAndFormat>> meaningfulRegionValues = new HashMap();
    private final ExcelNumberFormat numberFormat;
    private final OperatorEnum operator;
    private final int priority;
    private final CellRangeAddress[] regions;
    private final ConditionalFormattingRule rule;
    private final int ruleIndex;
    private final Sheet sheet;
    private final String text;
    private CellRangeAddress topLeftRegion;
    private final ConditionType type;
    private final WorkbookEvaluator workbookEvaluator;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.EvaluationConditionalFormatRule$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[ConditionFilterType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType = iArr2;
            try {
                iArr2[ConditionFilterType.FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.TOP_10.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.UNIQUE_VALUES.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.DUPLICATE_VALUES.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.ABOVE_AVERAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.CONTAINS_TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.NOT_CONTAINS_TEXT.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.BEGINS_WITH.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.ENDS_WITH.ordinal()] = 9;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.CONTAINS_BLANKS.ordinal()] = 10;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.NOT_CONTAINS_BLANKS.ordinal()] = 11;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.CONTAINS_ERRORS.ordinal()] = 12;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.NOT_CONTAINS_ERRORS.ordinal()] = 13;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[ConditionFilterType.TIME_PERIOD.ordinal()] = 14;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ValueAndFormat implements Comparable<ValueAndFormat> {
        private final DecimalFormat decimalTextFormat;
        private final String format;
        private final String string;
        private final Double value;

        public ValueAndFormat(Double d, String str, DecimalFormat decimalFormat) {
            this.value = d;
            this.format = str;
            this.string = null;
            this.decimalTextFormat = decimalFormat;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ValueAndFormat)) {
                return false;
            }
            ValueAndFormat valueAndFormat = (ValueAndFormat) obj;
            return Objects.equals(this.value, valueAndFormat.value) && Objects.equals(this.format, valueAndFormat.format) && Objects.equals(this.string, valueAndFormat.string);
        }

        public String getString() {
            return this.string;
        }

        public Double getValue() {
            return this.value;
        }

        public int hashCode() {
            return Objects.hash(this.string, this.value, this.format);
        }

        public boolean isNumber() {
            return this.value != null;
        }

        public String toString() {
            return isNumber() ? this.decimalTextFormat.format(getValue().doubleValue()) : getString();
        }

        @Override // java.lang.Comparable
        public int compareTo(ValueAndFormat valueAndFormat) {
            Double d = this.value;
            if (d == null && valueAndFormat.value != null) {
                return 1;
            }
            Double d6 = valueAndFormat.value;
            if (d6 == null && d != null) {
                return -1;
            }
            int iCompareTo = d == null ? 0 : d.compareTo(d6);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            String str = this.string;
            if (str == null && valueAndFormat.string != null) {
                return 1;
            }
            String str2 = valueAndFormat.string;
            if (str2 == null && str != null) {
                return -1;
            }
            if (str == null) {
                return 0;
            }
            return str.compareTo(str2);
        }

        public ValueAndFormat(String str, String str2) {
            this.value = null;
            this.format = str2;
            this.string = str;
            this.decimalTextFormat = null;
        }
    }

    public EvaluationConditionalFormatRule(WorkbookEvaluator workbookEvaluator, Sheet sheet, ConditionalFormatting conditionalFormatting, int i5, ConditionalFormattingRule conditionalFormattingRule, int i6, CellRangeAddress[] cellRangeAddressArr) {
        this.workbookEvaluator = workbookEvaluator;
        this.sheet = sheet;
        this.formatting = conditionalFormatting;
        this.rule = conditionalFormattingRule;
        this.formattingIndex = i5;
        this.ruleIndex = i6;
        this.priority = conditionalFormattingRule.getPriority();
        this.regions = cellRangeAddressArr;
        for (CellRangeAddress cellRangeAddress : cellRangeAddressArr) {
            if (this.topLeftRegion == null) {
                this.topLeftRegion = cellRangeAddress;
            } else if (cellRangeAddress.getFirstColumn() < this.topLeftRegion.getFirstColumn() || cellRangeAddress.getFirstRow() < this.topLeftRegion.getFirstRow()) {
                this.topLeftRegion = cellRangeAddress;
            }
        }
        this.formula1 = conditionalFormattingRule.getFormula1();
        this.formula2 = conditionalFormattingRule.getFormula2();
        String text = conditionalFormattingRule.getText();
        this.text = text;
        this.lowerText = text == null ? null : text.toLowerCase(LocaleUtil.getUserLocale());
        this.numberFormat = conditionalFormattingRule.getNumberFormat();
        this.operator = OperatorEnum.values()[conditionalFormattingRule.getComparisonOperation()];
        this.type = conditionalFormattingRule.getConditionType();
        DecimalFormat decimalFormat = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        this.decimalTextFormat = decimalFormat;
        decimalFormat.setMaximumFractionDigits(340);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:35:0x00a2 A[RETURN] */
    private boolean checkFilter(Cell cell, CellReference cellReference, CellRangeAddress cellRangeAddress) {
        ConditionFilterType conditionFilterType = this.rule.getConditionFilterType();
        if (conditionFilterType != null) {
            ValueAndFormat cellValue = getCellValue(cell);
            switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$ConditionFilterType[conditionFilterType.ordinal()]) {
                case 2:
                    if (cellValue.isNumber()) {
                        final int i5 = 0;
                        return getMeaningfulValues(cellRangeAddress, false, new Function(this) { // from class: org.apache.poi.ss.formula.b
                            public final /* synthetic */ EvaluationConditionalFormatRule b;

                            {
                                this.b = this;
                            }

                            @Override // java.util.function.Function
                            public final Object apply(Object obj) {
                                switch (i5) {
                                    case 0:
                                        return this.b.evaluateTop10((List) obj);
                                    case 1:
                                        return this.b.evaluateUniqueValues((List) obj);
                                    case 2:
                                        return this.b.evaluateDuplicateValues((List) obj);
                                    default:
                                        return this.b.evaluateAboveAverage((List) obj);
                                }
                            }
                        }).contains(cellValue);
                    }
                    break;
                case 3:
                    final int i6 = 1;
                    return getMeaningfulValues(cellRangeAddress, true, new Function(this) { // from class: org.apache.poi.ss.formula.b
                        public final /* synthetic */ EvaluationConditionalFormatRule b;

                        {
                            this.b = this;
                        }

                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            switch (i6) {
                                case 0:
                                    return this.b.evaluateTop10((List) obj);
                                case 1:
                                    return this.b.evaluateUniqueValues((List) obj);
                                case 2:
                                    return this.b.evaluateDuplicateValues((List) obj);
                                default:
                                    return this.b.evaluateAboveAverage((List) obj);
                            }
                        }
                    }).contains(cellValue);
                case 4:
                    final int i7 = 2;
                    return getMeaningfulValues(cellRangeAddress, true, new Function(this) { // from class: org.apache.poi.ss.formula.b
                        public final /* synthetic */ EvaluationConditionalFormatRule b;

                        {
                            this.b = this;
                        }

                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            switch (i7) {
                                case 0:
                                    return this.b.evaluateTop10((List) obj);
                                case 1:
                                    return this.b.evaluateUniqueValues((List) obj);
                                case 2:
                                    return this.b.evaluateDuplicateValues((List) obj);
                                default:
                                    return this.b.evaluateAboveAverage((List) obj);
                            }
                        }
                    }).contains(cellValue);
                case 5:
                    ConditionFilterData filterConfiguration = this.rule.getFilterConfiguration();
                    final int i8 = 3;
                    ArrayList arrayList = new ArrayList(getMeaningfulValues(cellRangeAddress, false, new Function(this) { // from class: org.apache.poi.ss.formula.b
                        public final /* synthetic */ EvaluationConditionalFormatRule b;

                        {
                            this.b = this;
                        }

                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            switch (i8) {
                                case 0:
                                    return this.b.evaluateTop10((List) obj);
                                case 1:
                                    return this.b.evaluateUniqueValues((List) obj);
                                case 2:
                                    return this.b.evaluateDuplicateValues((List) obj);
                                default:
                                    return this.b.evaluateAboveAverage((List) obj);
                            }
                        }
                    }));
                    Double value = cellValue.isNumber() ? cellValue.getValue() : null;
                    if (value != null) {
                        double dDoubleValue = ((ValueAndFormat) arrayList.get(0)).value.doubleValue();
                        double dDoubleValue2 = ((ValueAndFormat) arrayList.get(1)).value.doubleValue();
                        if (filterConfiguration.getStdDev() > 0) {
                            dDoubleValue += ((double) (filterConfiguration.getAboveAverage() ? 1 : -1)) * dDoubleValue2 * ((double) filterConfiguration.getStdDev());
                        }
                        Double dValueOf = Double.valueOf(dDoubleValue);
                        return (filterConfiguration.getAboveAverage() ? filterConfiguration.getEqualAverage() ? OperatorEnum.GREATER_OR_EQUAL : OperatorEnum.GREATER_THAN : filterConfiguration.getEqualAverage() ? OperatorEnum.LESS_OR_EQUAL : OperatorEnum.LESS_THAN).isValid(value, dValueOf, null);
                    }
                    break;
                case 6:
                    if (this.text != null && cellValue.toString().toLowerCase(LocaleUtil.getUserLocale()).contains(this.lowerText)) {
                        return true;
                    }
                    break;
                case 7:
                    if (this.text == null || !cellValue.toString().toLowerCase(LocaleUtil.getUserLocale()).contains(this.lowerText)) {
                        return true;
                    }
                    break;
                case 8:
                    return cellValue.toString().toLowerCase(LocaleUtil.getUserLocale()).startsWith(this.lowerText);
                case 9:
                    return cellValue.toString().toLowerCase(LocaleUtil.getUserLocale()).endsWith(this.lowerText);
                case 10:
                    try {
                        return StringUtil.isBlank(cellValue.getString());
                    } catch (Exception unused) {
                    }
                    break;
                case 11:
                    try {
                        return StringUtil.isNotBlank(cellValue.getString());
                    } catch (Exception unused2) {
                    }
                    break;
                case 12:
                    if (cell != null && DataValidationEvaluator.isType(cell, CellType.ERROR)) {
                        return true;
                    }
                    break;
                case 13:
                    if (cell == null || !DataValidationEvaluator.isType(cell, CellType.ERROR)) {
                        return true;
                    }
                    break;
                case 14:
                    return checkFormula(cellReference, cellRangeAddress);
            }
        }
        return false;
    }

    private boolean checkFormula(CellReference cellReference, CellRangeAddress cellRangeAddress) {
        ValueEval valueEvalUnwrapEval = unwrapEval(this.workbookEvaluator.evaluate(this.rule.getFormula1(), cellReference, cellRangeAddress));
        if (valueEvalUnwrapEval instanceof BlankEval) {
            return true;
        }
        if (valueEvalUnwrapEval instanceof ErrorEval) {
            return false;
        }
        if (valueEvalUnwrapEval instanceof BoolEval) {
            return ((BoolEval) valueEvalUnwrapEval).getBooleanValue();
        }
        return (valueEvalUnwrapEval instanceof NumberEval) && ((NumberEval) valueEvalUnwrapEval).getNumberValue() != 0.0d;
    }

    private boolean checkValue(Cell cell, CellRangeAddress cellRangeAddress) {
        if (cell == null || DataValidationEvaluator.isType(cell, CellType.BLANK) || DataValidationEvaluator.isType(cell, CellType.ERROR)) {
            return false;
        }
        CellType cellType = CellType.STRING;
        if (DataValidationEvaluator.isType(cell, cellType) && (cell.getStringCellValue() == null || cell.getStringCellValue().isEmpty())) {
            return false;
        }
        ValueEval valueEvalUnwrapEval = unwrapEval(this.workbookEvaluator.evaluate(this.rule.getFormula1(), ConditionalFormattingEvaluator.getRef(cell), cellRangeAddress));
        String formula2 = this.rule.getFormula2();
        BlankEval blankEval = BlankEval.instance;
        ValueEval valueEvalUnwrapEval2 = (formula2 == null || formula2.length() <= 0) ? blankEval : unwrapEval(this.workbookEvaluator.evaluate(formula2, ConditionalFormattingEvaluator.getRef(cell), cellRangeAddress));
        if (DataValidationEvaluator.isType(cell, CellType.BOOLEAN) && ((valueEvalUnwrapEval == blankEval || (valueEvalUnwrapEval instanceof BoolEval)) && (valueEvalUnwrapEval2 == blankEval || (valueEvalUnwrapEval2 instanceof BoolEval)))) {
            return this.operator.isValid(Boolean.valueOf(cell.getBooleanCellValue()), valueEvalUnwrapEval == blankEval ? null : Boolean.valueOf(((BoolEval) valueEvalUnwrapEval).getBooleanValue()), valueEvalUnwrapEval2 != blankEval ? Boolean.valueOf(((BoolEval) valueEvalUnwrapEval2).getBooleanValue()) : null);
        }
        if (DataValidationEvaluator.isType(cell, CellType.NUMERIC) && ((valueEvalUnwrapEval == blankEval || (valueEvalUnwrapEval instanceof NumberEval)) && (valueEvalUnwrapEval2 == blankEval || (valueEvalUnwrapEval2 instanceof NumberEval)))) {
            return this.operator.isValid(Double.valueOf(cell.getNumericCellValue()), valueEvalUnwrapEval == blankEval ? null : Double.valueOf(((NumberEval) valueEvalUnwrapEval).getNumberValue()), valueEvalUnwrapEval2 != blankEval ? Double.valueOf(((NumberEval) valueEvalUnwrapEval2).getNumberValue()) : null);
        }
        if (DataValidationEvaluator.isType(cell, cellType) && ((valueEvalUnwrapEval == blankEval || (valueEvalUnwrapEval instanceof StringEval)) && (valueEvalUnwrapEval2 == blankEval || (valueEvalUnwrapEval2 instanceof StringEval)))) {
            return this.operator.isValid(cell.getStringCellValue(), valueEvalUnwrapEval == blankEval ? null : ((StringEval) valueEvalUnwrapEval).getStringValue(), valueEvalUnwrapEval2 != blankEval ? ((StringEval) valueEvalUnwrapEval2).getStringValue() : null);
        }
        return this.operator.isValidForIncompatibleTypes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set<ValueAndFormat> evaluateAboveAverage(List<ValueAndFormat> list) {
        ValueEval[] valueEvalArr = new ValueEval[list.size()];
        double dDoubleValue = 0.0d;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ValueAndFormat valueAndFormat = list.get(i5);
            dDoubleValue += valueAndFormat.value.doubleValue();
            valueEvalArr[i5] = new NumberEval(valueAndFormat.value.doubleValue());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(1);
        linkedHashSet.add(new ValueAndFormat(Double.valueOf(list.isEmpty() ? 0.0d : dDoubleValue / ((double) list.size())), null, this.decimalTextFormat));
        linkedHashSet.add(new ValueAndFormat(Double.valueOf(list.size() > 1 ? ((NumberEval) AggregateFunction.STDEV.evaluate(valueEvalArr, 0, 0)).getNumberValue() : 0.0d), null, this.decimalTextFormat));
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set<ValueAndFormat> evaluateTop10(List<ValueAndFormat> list) {
        ConditionFilterData filterConfiguration = this.rule.getFilterConfiguration();
        if (filterConfiguration.getBottom()) {
            Collections.sort(list);
        } else {
            list.sort(Collections.reverseOrder());
        }
        int intExact = Math.toIntExact(filterConfiguration.getRank());
        if (filterConfiguration.getPercent()) {
            intExact = (list.size() * intExact) / 100;
        }
        return list.size() <= intExact ? new HashSet(list) : new HashSet(list.subList(0, intExact));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set<ValueAndFormat> evaluateUniqueValues(List<ValueAndFormat> list) {
        Collections.sort(list);
        HashSet hashSet = new HashSet();
        int i5 = 0;
        while (i5 < list.size()) {
            ValueAndFormat valueAndFormat = list.get(i5);
            if ((i5 >= list.size() - 1 || !valueAndFormat.equals(list.get(i5 + 1))) && !(i5 > 0 && i5 == list.size() - 1 && valueAndFormat.equals(list.get(i5 - 1)))) {
                hashSet.add(valueAndFormat);
            } else {
                i5++;
            }
            i5++;
        }
        return hashSet;
    }

    private ValueAndFormat getCellValue(Cell cell) {
        if (cell != null) {
            String dataFormatString = cell.getCellStyle().getDataFormatString();
            CellType cellType = cell.getCellType();
            if (cellType == CellType.FORMULA) {
                cellType = cell.getCachedFormulaResultType();
            }
            int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()];
            if (i5 == 1) {
                return new ValueAndFormat(Double.valueOf(cell.getNumericCellValue()), dataFormatString, this.decimalTextFormat);
            }
            if (i5 == 2 || i5 == 3) {
                return new ValueAndFormat(cell.getStringCellValue(), dataFormatString);
            }
        }
        return new ValueAndFormat("", "");
    }

    private Set<ValueAndFormat> getMeaningfulValues(CellRangeAddress cellRangeAddress, boolean z6, Function<List<ValueAndFormat>, Set<ValueAndFormat>> function) {
        Set<ValueAndFormat> set = this.meaningfulRegionValues.get(cellRangeAddress);
        if (set != null) {
            return set;
        }
        ArrayList arrayList = new ArrayList(((cellRangeAddress.getLastRow() - cellRangeAddress.getFirstRow()) + 1) * ((cellRangeAddress.getLastColumn() - cellRangeAddress.getFirstColumn()) + 1));
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= cellRangeAddress.getLastRow(); firstRow++) {
            Row row = this.sheet.getRow(firstRow);
            if (row != null) {
                for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= cellRangeAddress.getLastColumn(); firstColumn++) {
                    ValueAndFormat cellValue = getCellValue(row.getCell(firstColumn));
                    if (z6 || cellValue.isNumber()) {
                        arrayList.add(cellValue);
                    }
                }
            }
        }
        Set<ValueAndFormat> setApply = function.apply(arrayList);
        this.meaningfulRegionValues.put(cellRangeAddress, setApply);
        return setApply;
    }

    private ValueEval unwrapEval(ValueEval valueEval) {
        while (valueEval instanceof RefEval) {
            RefEval refEval = (RefEval) valueEval;
            valueEval = refEval.getInnerValueEval(refEval.getFirstSheetIndex());
        }
        return valueEval;
    }

    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        EvaluationConditionalFormatRule evaluationConditionalFormatRule = (EvaluationConditionalFormatRule) obj;
        return getSheet().getSheetName().equalsIgnoreCase(evaluationConditionalFormatRule.getSheet().getSheetName()) && getFormattingIndex() == evaluationConditionalFormatRule.getFormattingIndex() && getRuleIndex() == evaluationConditionalFormatRule.getRuleIndex();
    }

    public Set<ValueAndFormat> evaluateDuplicateValues(List<ValueAndFormat> list) {
        Collections.sort(list);
        HashSet hashSet = new HashSet();
        int i5 = 0;
        while (i5 < list.size()) {
            ValueAndFormat valueAndFormat = list.get(i5);
            if ((i5 < list.size() - 1 && valueAndFormat.equals(list.get(i5 + 1))) || (i5 > 0 && i5 == list.size() - 1 && valueAndFormat.equals(list.get(i5 - 1)))) {
                hashSet.add(valueAndFormat);
                i5++;
            }
            i5++;
        }
        return hashSet;
    }

    public ConditionalFormatting getFormatting() {
        return this.formatting;
    }

    public int getFormattingIndex() {
        return this.formattingIndex;
    }

    public String getFormula1() {
        return this.formula1;
    }

    public String getFormula2() {
        return this.formula2;
    }

    public ExcelNumberFormat getNumberFormat() {
        return this.numberFormat;
    }

    public OperatorEnum getOperator() {
        return this.operator;
    }

    public int getPriority() {
        return this.priority;
    }

    public CellRangeAddress[] getRegions() {
        return this.regions;
    }

    public ConditionalFormattingRule getRule() {
        return this.rule;
    }

    public int getRuleIndex() {
        return this.ruleIndex;
    }

    public Sheet getSheet() {
        return this.sheet;
    }

    public String getText() {
        return this.text;
    }

    public ConditionType getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(this.sheet.getSheetName(), Integer.valueOf(this.formattingIndex), Integer.valueOf(this.ruleIndex));
    }

    public boolean matches(CellReference cellReference) {
        CellRangeAddress cellRangeAddress;
        CellRangeAddress[] cellRangeAddressArr = this.regions;
        int length = cellRangeAddressArr.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                cellRangeAddress = null;
                break;
            }
            cellRangeAddress = cellRangeAddressArr[i5];
            if (cellRangeAddress.isInRange(cellReference)) {
                break;
            }
            i5++;
        }
        if (cellRangeAddress == null) {
            return false;
        }
        ConditionType conditionType = getRule().getConditionType();
        if (conditionType.equals(ConditionType.COLOR_SCALE) || conditionType.equals(ConditionType.DATA_BAR) || conditionType.equals(ConditionType.ICON_SET)) {
            return true;
        }
        Row row = this.sheet.getRow(cellReference.getRow());
        Cell cell = row != null ? row.getCell(cellReference.getCol()) : null;
        if (conditionType.equals(ConditionType.CELL_VALUE_IS)) {
            if (cell == null) {
                return false;
            }
            return checkValue(cell, this.topLeftRegion);
        }
        if (conditionType.equals(ConditionType.FORMULA)) {
            return checkFormula(cellReference, this.topLeftRegion);
        }
        if (conditionType.equals(ConditionType.FILTER)) {
            return checkFilter(cell, cellReference, this.topLeftRegion);
        }
        return false;
    }

    @Override // java.lang.Comparable
    public int compareTo(EvaluationConditionalFormatRule evaluationConditionalFormatRule) {
        int iCompareToIgnoreCase = getSheet().getSheetName().compareToIgnoreCase(evaluationConditionalFormatRule.getSheet().getSheetName());
        if (iCompareToIgnoreCase != 0) {
            return iCompareToIgnoreCase;
        }
        int iCompare = Integer.compare(getPriority(), evaluationConditionalFormatRule.getPriority());
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompare2 = Integer.compare(getFormattingIndex(), evaluationConditionalFormatRule.getFormattingIndex());
        return iCompare2 != 0 ? iCompare2 : Integer.compare(getRuleIndex(), evaluationConditionalFormatRule.getRuleIndex());
    }
}
