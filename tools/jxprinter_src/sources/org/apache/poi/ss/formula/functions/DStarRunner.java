package org.apache.poi.ss.formula.functions;

import java.util.function.Supplier;
import java.util.regex.Pattern;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.StringValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.util.NumberComparer;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class DStarRunner implements Function3Arg {
    private final DStarAlgorithmEnum algoType;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.functions.DStarRunner$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator;

        static {
            int[] iArr = new int[operator.values().length];
            $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator = iArr;
            try {
                iArr[operator.largerThan.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[operator.largerEqualThan.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[operator.smallerThan.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[operator.smallerEqualThan.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[operator.equal.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DGET' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class DStarAlgorithmEnum {
        private static final /* synthetic */ DStarAlgorithmEnum[] $VALUES;
        public static final DStarAlgorithmEnum DAVERAGE;
        public static final DStarAlgorithmEnum DCOUNT;
        public static final DStarAlgorithmEnum DCOUNTA;
        public static final DStarAlgorithmEnum DGET;
        public static final DStarAlgorithmEnum DMAX;
        public static final DStarAlgorithmEnum DMIN;
        public static final DStarAlgorithmEnum DPRODUCT;
        public static final DStarAlgorithmEnum DSTDEV;
        public static final DStarAlgorithmEnum DSTDEVP;
        public static final DStarAlgorithmEnum DSUM;
        public static final DStarAlgorithmEnum DVAR;
        public static final DStarAlgorithmEnum DVARP;
        private final Supplier<IDStarAlgorithm> implSupplier;

        static {
            final int i5 = 0;
            DStarAlgorithmEnum dStarAlgorithmEnum = new DStarAlgorithmEnum("DGET", 0, new Supplier() { // from class: org.apache.poi.ss.formula.functions.c
                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i5) {
                        case 0:
                            return new DGet();
                        case 1:
                            return new DStdevp();
                        case 2:
                            return new DVar();
                        case 3:
                            return new DVarp();
                        case 4:
                            return new DProduct();
                        case 5:
                            return new DMin();
                        case 6:
                            return new DMax();
                        case 7:
                            return new DSum();
                        case 8:
                            return new DCount();
                        case 9:
                            return new DCountA();
                        case 10:
                            return new DAverage();
                        default:
                            return new DStdev();
                    }
                }
            });
            DGET = dStarAlgorithmEnum;
            final int i6 = 5;
            DStarAlgorithmEnum dStarAlgorithmEnum2 = new DStarAlgorithmEnum("DMIN", 1, new Supplier() { // from class: org.apache.poi.ss.formula.functions.c
                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i6) {
                        case 0:
                            return new DGet();
                        case 1:
                            return new DStdevp();
                        case 2:
                            return new DVar();
                        case 3:
                            return new DVarp();
                        case 4:
                            return new DProduct();
                        case 5:
                            return new DMin();
                        case 6:
                            return new DMax();
                        case 7:
                            return new DSum();
                        case 8:
                            return new DCount();
                        case 9:
                            return new DCountA();
                        case 10:
                            return new DAverage();
                        default:
                            return new DStdev();
                    }
                }
            });
            DMIN = dStarAlgorithmEnum2;
            final int i7 = 6;
            DStarAlgorithmEnum dStarAlgorithmEnum3 = new DStarAlgorithmEnum("DMAX", 2, new Supplier() { // from class: org.apache.poi.ss.formula.functions.c
                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i7) {
                        case 0:
                            return new DGet();
                        case 1:
                            return new DStdevp();
                        case 2:
                            return new DVar();
                        case 3:
                            return new DVarp();
                        case 4:
                            return new DProduct();
                        case 5:
                            return new DMin();
                        case 6:
                            return new DMax();
                        case 7:
                            return new DSum();
                        case 8:
                            return new DCount();
                        case 9:
                            return new DCountA();
                        case 10:
                            return new DAverage();
                        default:
                            return new DStdev();
                    }
                }
            });
            DMAX = dStarAlgorithmEnum3;
            final int i8 = 7;
            DStarAlgorithmEnum dStarAlgorithmEnum4 = new DStarAlgorithmEnum("DSUM", 3, new Supplier() { // from class: org.apache.poi.ss.formula.functions.c
                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i8) {
                        case 0:
                            return new DGet();
                        case 1:
                            return new DStdevp();
                        case 2:
                            return new DVar();
                        case 3:
                            return new DVarp();
                        case 4:
                            return new DProduct();
                        case 5:
                            return new DMin();
                        case 6:
                            return new DMax();
                        case 7:
                            return new DSum();
                        case 8:
                            return new DCount();
                        case 9:
                            return new DCountA();
                        case 10:
                            return new DAverage();
                        default:
                            return new DStdev();
                    }
                }
            });
            DSUM = dStarAlgorithmEnum4;
            final int i9 = 8;
            DStarAlgorithmEnum dStarAlgorithmEnum5 = new DStarAlgorithmEnum("DCOUNT", 4, new Supplier() { // from class: org.apache.poi.ss.formula.functions.c
                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i9) {
                        case 0:
                            return new DGet();
                        case 1:
                            return new DStdevp();
                        case 2:
                            return new DVar();
                        case 3:
                            return new DVarp();
                        case 4:
                            return new DProduct();
                        case 5:
                            return new DMin();
                        case 6:
                            return new DMax();
                        case 7:
                            return new DSum();
                        case 8:
                            return new DCount();
                        case 9:
                            return new DCountA();
                        case 10:
                            return new DAverage();
                        default:
                            return new DStdev();
                    }
                }
            });
            DCOUNT = dStarAlgorithmEnum5;
            final int i10 = 9;
            DStarAlgorithmEnum dStarAlgorithmEnum6 = new DStarAlgorithmEnum("DCOUNTA", 5, new Supplier() { // from class: org.apache.poi.ss.formula.functions.c
                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i10) {
                        case 0:
                            return new DGet();
                        case 1:
                            return new DStdevp();
                        case 2:
                            return new DVar();
                        case 3:
                            return new DVarp();
                        case 4:
                            return new DProduct();
                        case 5:
                            return new DMin();
                        case 6:
                            return new DMax();
                        case 7:
                            return new DSum();
                        case 8:
                            return new DCount();
                        case 9:
                            return new DCountA();
                        case 10:
                            return new DAverage();
                        default:
                            return new DStdev();
                    }
                }
            });
            DCOUNTA = dStarAlgorithmEnum6;
            final int i11 = 10;
            DStarAlgorithmEnum dStarAlgorithmEnum7 = new DStarAlgorithmEnum("DAVERAGE", 6, new Supplier() { // from class: org.apache.poi.ss.formula.functions.c
                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i11) {
                        case 0:
                            return new DGet();
                        case 1:
                            return new DStdevp();
                        case 2:
                            return new DVar();
                        case 3:
                            return new DVarp();
                        case 4:
                            return new DProduct();
                        case 5:
                            return new DMin();
                        case 6:
                            return new DMax();
                        case 7:
                            return new DSum();
                        case 8:
                            return new DCount();
                        case 9:
                            return new DCountA();
                        case 10:
                            return new DAverage();
                        default:
                            return new DStdev();
                    }
                }
            });
            DAVERAGE = dStarAlgorithmEnum7;
            final int i12 = 11;
            DStarAlgorithmEnum dStarAlgorithmEnum8 = new DStarAlgorithmEnum("DSTDEV", 7, new Supplier() { // from class: org.apache.poi.ss.formula.functions.c
                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i12) {
                        case 0:
                            return new DGet();
                        case 1:
                            return new DStdevp();
                        case 2:
                            return new DVar();
                        case 3:
                            return new DVarp();
                        case 4:
                            return new DProduct();
                        case 5:
                            return new DMin();
                        case 6:
                            return new DMax();
                        case 7:
                            return new DSum();
                        case 8:
                            return new DCount();
                        case 9:
                            return new DCountA();
                        case 10:
                            return new DAverage();
                        default:
                            return new DStdev();
                    }
                }
            });
            DSTDEV = dStarAlgorithmEnum8;
            final int i13 = 1;
            DStarAlgorithmEnum dStarAlgorithmEnum9 = new DStarAlgorithmEnum("DSTDEVP", 8, new Supplier() { // from class: org.apache.poi.ss.formula.functions.c
                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i13) {
                        case 0:
                            return new DGet();
                        case 1:
                            return new DStdevp();
                        case 2:
                            return new DVar();
                        case 3:
                            return new DVarp();
                        case 4:
                            return new DProduct();
                        case 5:
                            return new DMin();
                        case 6:
                            return new DMax();
                        case 7:
                            return new DSum();
                        case 8:
                            return new DCount();
                        case 9:
                            return new DCountA();
                        case 10:
                            return new DAverage();
                        default:
                            return new DStdev();
                    }
                }
            });
            DSTDEVP = dStarAlgorithmEnum9;
            final int i14 = 2;
            DStarAlgorithmEnum dStarAlgorithmEnum10 = new DStarAlgorithmEnum("DVAR", 9, new Supplier() { // from class: org.apache.poi.ss.formula.functions.c
                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i14) {
                        case 0:
                            return new DGet();
                        case 1:
                            return new DStdevp();
                        case 2:
                            return new DVar();
                        case 3:
                            return new DVarp();
                        case 4:
                            return new DProduct();
                        case 5:
                            return new DMin();
                        case 6:
                            return new DMax();
                        case 7:
                            return new DSum();
                        case 8:
                            return new DCount();
                        case 9:
                            return new DCountA();
                        case 10:
                            return new DAverage();
                        default:
                            return new DStdev();
                    }
                }
            });
            DVAR = dStarAlgorithmEnum10;
            final int i15 = 3;
            DStarAlgorithmEnum dStarAlgorithmEnum11 = new DStarAlgorithmEnum("DVARP", 10, new Supplier() { // from class: org.apache.poi.ss.formula.functions.c
                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i15) {
                        case 0:
                            return new DGet();
                        case 1:
                            return new DStdevp();
                        case 2:
                            return new DVar();
                        case 3:
                            return new DVarp();
                        case 4:
                            return new DProduct();
                        case 5:
                            return new DMin();
                        case 6:
                            return new DMax();
                        case 7:
                            return new DSum();
                        case 8:
                            return new DCount();
                        case 9:
                            return new DCountA();
                        case 10:
                            return new DAverage();
                        default:
                            return new DStdev();
                    }
                }
            });
            DVARP = dStarAlgorithmEnum11;
            final int i16 = 4;
            DStarAlgorithmEnum dStarAlgorithmEnum12 = new DStarAlgorithmEnum("DPRODUCT", 11, new Supplier() { // from class: org.apache.poi.ss.formula.functions.c
                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i16) {
                        case 0:
                            return new DGet();
                        case 1:
                            return new DStdevp();
                        case 2:
                            return new DVar();
                        case 3:
                            return new DVarp();
                        case 4:
                            return new DProduct();
                        case 5:
                            return new DMin();
                        case 6:
                            return new DMax();
                        case 7:
                            return new DSum();
                        case 8:
                            return new DCount();
                        case 9:
                            return new DCountA();
                        case 10:
                            return new DAverage();
                        default:
                            return new DStdev();
                    }
                }
            });
            DPRODUCT = dStarAlgorithmEnum12;
            $VALUES = new DStarAlgorithmEnum[]{dStarAlgorithmEnum, dStarAlgorithmEnum2, dStarAlgorithmEnum3, dStarAlgorithmEnum4, dStarAlgorithmEnum5, dStarAlgorithmEnum6, dStarAlgorithmEnum7, dStarAlgorithmEnum8, dStarAlgorithmEnum9, dStarAlgorithmEnum10, dStarAlgorithmEnum11, dStarAlgorithmEnum12};
        }

        private DStarAlgorithmEnum(String str, int i5, Supplier supplier) {
            super(str, i5);
            this.implSupplier = supplier;
        }

        public static DStarAlgorithmEnum valueOf(String str) {
            return (DStarAlgorithmEnum) Enum.valueOf(DStarAlgorithmEnum.class, str);
        }

        public static DStarAlgorithmEnum[] values() {
            return (DStarAlgorithmEnum[]) $VALUES.clone();
        }

        public IDStarAlgorithm newInstance() {
            return this.implSupplier.get();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum operator {
        largerThan,
        largerEqualThan,
        smallerThan,
        smallerEqualThan,
        equal
    }

    public DStarRunner(DStarAlgorithmEnum dStarAlgorithmEnum) {
        this.algoType = dStarAlgorithmEnum;
    }

    private static boolean fulfillsConditions(AreaEval areaEval, int i5, AreaEval areaEval2) throws EvaluationException {
        int height = areaEval2.getHeight();
        for (int i6 = 1; i6 < height; i6++) {
            int width = areaEval2.getWidth();
            for (int i7 = 0; i7 < width; i7++) {
                ValueEval valueEvalResolveReference = resolveReference(areaEval2, i6, i7);
                if (!(valueEvalResolveReference instanceof BlankEval)) {
                    ValueEval valueEvalResolveReference2 = resolveReference(areaEval2, 0, i7);
                    if (!(valueEvalResolveReference2 instanceof StringValueEval)) {
                        throw new EvaluationException(ErrorEval.VALUE_INVALID);
                    }
                    if (getColumnForName(valueEvalResolveReference2, areaEval) == -1) {
                        if (OperandResolver.coerceValueToString(valueEvalResolveReference).isEmpty()) {
                            throw new EvaluationException(ErrorEval.VALUE_INVALID);
                        }
                        throw new NotImplementedException("D* function with formula conditions");
                    }
                    if (!testNormalCondition(resolveReference(areaEval, i5, getColumnForName(valueEvalResolveReference2, areaEval)), valueEvalResolveReference)) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    private static int getColumnForName(ValueEval valueEval, AreaEval areaEval) {
        if (!(valueEval instanceof NumericValueEval)) {
            return getColumnForString(areaEval, OperandResolver.coerceValueToString(valueEval));
        }
        int iCoerceValueToInt = OperandResolver.coerceValueToInt(valueEval) - 1;
        if (iCoerceValueToInt < 0 || iCoerceValueToInt >= areaEval.getWidth()) {
            return -1;
        }
        return iCoerceValueToInt;
    }

    private static int getColumnForString(AreaEval areaEval, String str) {
        int width = areaEval.getWidth();
        for (int i5 = 0; i5 < width; i5++) {
            ValueEval valueEvalResolveReference = resolveReference(areaEval, 0, i5);
            if (!(valueEvalResolveReference instanceof BlankEval) && !(valueEvalResolveReference instanceof ErrorEval) && str.equalsIgnoreCase(OperandResolver.coerceValueToString(valueEvalResolveReference))) {
                return i5;
            }
        }
        return -1;
    }

    private static Double getNumberFromValueEval(ValueEval valueEval) {
        if (valueEval instanceof NumericValueEval) {
            return Double.valueOf(((NumericValueEval) valueEval).getNumberValue());
        }
        if (valueEval instanceof StringValueEval) {
            try {
                return Double.valueOf(Double.parseDouble(((StringValueEval) valueEval).getStringValue()));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    private static ValueEval resolveReference(AreaEval areaEval, int i5, int i6) {
        try {
            return OperandResolver.getSingleValue(areaEval.getValue(i5, i6), areaEval.getFirstRow() + i5, areaEval.getFirstColumn() + i6);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static boolean testNormalCondition(ValueEval valueEval, ValueEval valueEval2) {
        if (!(valueEval2 instanceof StringEval)) {
            if (!(valueEval2 instanceof NumericValueEval)) {
                return (valueEval2 instanceof ErrorEval) && (valueEval instanceof ErrorEval) && ((ErrorEval) valueEval2).getErrorCode() == ((ErrorEval) valueEval).getErrorCode();
            }
            double numberValue = ((NumericValueEval) valueEval2).getNumberValue();
            Double numberFromValueEval = getNumberFromValueEval(valueEval);
            return numberFromValueEval != null && numberValue == numberFromValueEval.doubleValue();
        }
        String stringValue = ((StringEval) valueEval2).getStringValue();
        if (stringValue.startsWith("<")) {
            String strSubstring = stringValue.substring(1);
            if (strSubstring.startsWith("=")) {
                return testNumericCondition(valueEval, operator.smallerEqualThan, strSubstring.substring(1));
            }
            return testNumericCondition(valueEval, operator.smallerThan, strSubstring);
        }
        if (stringValue.startsWith(">")) {
            String strSubstring2 = stringValue.substring(1);
            if (strSubstring2.startsWith("=")) {
                return testNumericCondition(valueEval, operator.largerEqualThan, strSubstring2.substring(1));
            }
            return testNumericCondition(valueEval, operator.largerThan, strSubstring2);
        }
        if (!stringValue.startsWith("=")) {
            if (stringValue.isEmpty()) {
                return valueEval instanceof StringEval;
            }
            String lowerCase = (valueEval instanceof BlankEval ? "" : OperandResolver.coerceValueToString(valueEval)).toLowerCase(LocaleUtil.getUserLocale());
            String lowerCase2 = stringValue.toLowerCase(LocaleUtil.getUserLocale());
            Pattern wildCardPattern = Countif.StringMatcher.getWildCardPattern(lowerCase2);
            return wildCardPattern == null ? lowerCase.startsWith(lowerCase2) : wildCardPattern.matcher(lowerCase).matches();
        }
        String strSubstring3 = stringValue.substring(1);
        if (strSubstring3.isEmpty()) {
            return valueEval instanceof BlankEval;
        }
        try {
            try {
                Integer.parseInt(strSubstring3);
            } catch (NumberFormatException unused) {
                return strSubstring3.equalsIgnoreCase(valueEval instanceof BlankEval ? "" : OperandResolver.coerceValueToString(valueEval));
            }
        } catch (NumberFormatException unused2) {
            Double.parseDouble(strSubstring3);
        }
        return testNumericCondition(valueEval, operator.equal, strSubstring3);
    }

    private static boolean testNumericCondition(ValueEval valueEval, operator operatorVar, String str) throws EvaluationException {
        double d;
        if (!(valueEval instanceof NumericValueEval)) {
            return false;
        }
        double numberValue = ((NumericValueEval) valueEval).getNumberValue();
        try {
            try {
                d = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
        } catch (NumberFormatException unused2) {
            d = Double.parseDouble(str);
        }
        int iCompare = NumberComparer.compare(numberValue, d);
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[operatorVar.ordinal()];
        if (i5 == 1) {
            return iCompare > 0;
        }
        if (i5 == 2) {
            return iCompare >= 0;
        }
        if (i5 == 3) {
            return iCompare < 0;
        }
        if (i5 != 4) {
            return i5 == 5 && iCompare == 0;
        }
        return iCompare <= 0;
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        return valueEvalArr.length == 3 ? evaluate(i5, i6, valueEvalArr[0], valueEvalArr[1], valueEvalArr[2]) : ErrorEval.VALUE_INVALID;
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        int columnForName;
        if ((valueEval instanceof AreaEval) && (valueEval3 instanceof AreaEval)) {
            AreaEval areaEval = (AreaEval) valueEval;
            AreaEval areaEval2 = (AreaEval) valueEval3;
            IDStarAlgorithm iDStarAlgorithmNewInstance = this.algoType.newInstance();
            int i7 = -1;
            try {
                ValueEval singleValue = OperandResolver.getSingleValue(valueEval2, i5, i6);
                if (singleValue instanceof NumericValueEval) {
                    columnForName = ((int) Math.round(((NumericValueEval) singleValue).getNumberValue())) - 1;
                } else {
                    columnForName = getColumnForName(singleValue, areaEval);
                }
                if (columnForName == -1) {
                    try {
                        if (!iDStarAlgorithmNewInstance.allowEmptyMatchField()) {
                            return ErrorEval.VALUE_INVALID;
                        }
                    } catch (EvaluationException e) {
                        i7 = columnForName;
                        e = e;
                        if (!iDStarAlgorithmNewInstance.allowEmptyMatchField()) {
                            return e.getErrorEval();
                        }
                        columnForName = i7;
                    } catch (Exception unused) {
                        i7 = columnForName;
                        if (!iDStarAlgorithmNewInstance.allowEmptyMatchField()) {
                            return ErrorEval.VALUE_INVALID;
                        }
                        columnForName = i7;
                    }
                }
            } catch (EvaluationException e6) {
                e = e6;
            } catch (Exception unused2) {
            }
            int height = areaEval.getHeight();
            for (int i8 = 1; i8 < height; i8++) {
                try {
                    if (fulfillsConditions(areaEval, i8, areaEval2)) {
                        ValueEval valueEvalResolveReference = resolveReference(areaEval, i8, columnForName);
                        if (columnForName < 0 && iDStarAlgorithmNewInstance.allowEmptyMatchField() && !(valueEvalResolveReference instanceof NumericValueEval)) {
                            valueEvalResolveReference = NumberEval.ZERO;
                        }
                        if (!iDStarAlgorithmNewInstance.processMatch(valueEvalResolveReference)) {
                            break;
                        }
                    }
                } catch (EvaluationException unused3) {
                    return ErrorEval.VALUE_INVALID;
                }
            }
            return iDStarAlgorithmNewInstance.getResult();
        }
        return ErrorEval.VALUE_INVALID;
    }
}
