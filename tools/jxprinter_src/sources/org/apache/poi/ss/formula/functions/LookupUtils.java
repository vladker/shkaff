package org.apache.poi.ss.formula.functions;

import A3.AbstractC0157z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class LookupUtils {
    private static Map<Integer, MatchMode> matchModeMap = new HashMap();
    private static Map<Integer, SearchMode> searchModeMap = new HashMap();

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.functions.LookupUtils$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$formula$functions$LookupUtils$MatchMode;

        static {
            int[] iArr = new int[MatchMode.values().length];
            $SwitchMap$org$apache$poi$ss$formula$functions$LookupUtils$MatchMode = iArr;
            try {
                iArr[MatchMode.ExactMatchFallbackToLargerValue.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$functions$LookupUtils$MatchMode[MatchMode.ExactMatchFallbackToSmallerValue.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class BinarySearchIndexes {
        private int _highIx;
        private int _lowIx = -1;

        public BinarySearchIndexes(int i5) {
            this._highIx = i5;
        }

        public int getHighIx() {
            return this._highIx;
        }

        public int getLowIx() {
            return this._lowIx;
        }

        public int getMidIx() {
            int i5 = this._highIx;
            int i6 = this._lowIx;
            int i7 = i5 - i6;
            if (i7 < 2) {
                return -1;
            }
            return (i7 / 2) + i6;
        }

        public void narrowSearch(int i5, boolean z6) {
            if (z6) {
                this._highIx = i5;
            } else {
                this._lowIx = i5;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class BooleanLookupComparer extends LookupValueComparerBase {
        private final boolean _value;

        public BooleanLookupComparer(BoolEval boolEval) {
            super(boolEval);
            this._value = boolEval.getBooleanValue();
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparerBase
        public CompareResult compareSameType(ValueEval valueEval) {
            boolean booleanValue = ((BoolEval) valueEval).getBooleanValue();
            boolean z6 = this._value;
            if (z6 == booleanValue) {
                return CompareResult.EQUAL;
            }
            return z6 ? CompareResult.GREATER_THAN : CompareResult.LESS_THAN;
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparerBase
        public String getValueAsString() {
            return String.valueOf(this._value);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ColumnVector implements ValueVector {
        private final int _columnIndex;
        private final int _size;
        private final TwoDEval _tableArray;

        public ColumnVector(TwoDEval twoDEval, int i5) {
            this._columnIndex = i5;
            int width = twoDEval.getWidth() - 1;
            if (i5 < 0 || i5 > width) {
                throw new IllegalArgumentException(androidx.collection.a.m("Specified column index (", i5, width, ") is outside the allowed range (0..", ")"));
            }
            this._tableArray = twoDEval;
            this._size = twoDEval.getHeight();
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public ValueEval getItem(int i5) {
            if (i5 <= this._size) {
                return this._tableArray.getValue(i5, this._columnIndex);
            }
            StringBuilder sbT = AbstractC0157z.t(i5, "Specified index (", ") is outside the allowed range (0..");
            sbT.append(this._size - 1);
            sbT.append(")");
            throw new ArrayIndexOutOfBoundsException(sbT.toString());
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public int getSize() {
            return this._size;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface LookupValueComparer {
        CompareResult compareTo(ValueEval valueEval);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class LookupValueComparerBase implements LookupValueComparer {
        private final Class<? extends ValueEval> _targetClass;

        public LookupValueComparerBase(ValueEval valueEval) {
            if (valueEval == null) {
                throw new RuntimeException("targetValue cannot be null");
            }
            this._targetClass = valueEval.getClass();
        }

        public abstract CompareResult compareSameType(ValueEval valueEval);

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparer
        public final CompareResult compareTo(ValueEval valueEval) {
            if (valueEval != null) {
                return this._targetClass != valueEval.getClass() ? CompareResult.TYPE_MISMATCH : compareSameType(valueEval);
            }
            throw new RuntimeException("compare to value cannot be null");
        }

        public abstract String getValueAsString();

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getName());
            sb.append(" [");
            return AbstractC0157z.s(sb, getValueAsString(), "]");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum MatchMode {
        ExactMatch(0),
        ExactMatchFallbackToSmallerValue(-1),
        ExactMatchFallbackToLargerValue(1),
        WildcardMatch(2);

        private final int intValue;

        MatchMode(int i5) {
            this.intValue = i5;
        }

        public int getIntValue() {
            return this.intValue;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class NumberLookupComparer extends LookupValueComparerBase {
        private final double _value;

        public NumberLookupComparer(NumberEval numberEval) {
            super(numberEval);
            this._value = numberEval.getNumberValue();
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparerBase
        public CompareResult compareSameType(ValueEval valueEval) {
            return CompareResult.valueOf(Double.compare(this._value, ((NumberEval) valueEval).getNumberValue()));
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparerBase
        public String getValueAsString() {
            return String.valueOf(this._value);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class RowVector implements ValueVector {
        private final int _rowIndex;
        private final int _size;
        private final TwoDEval _tableArray;

        public RowVector(TwoDEval twoDEval, int i5) {
            this._rowIndex = i5;
            int height = twoDEval.getHeight() - 1;
            if (i5 < 0 || i5 > height) {
                throw new IllegalArgumentException(androidx.collection.a.m("Specified row index (", i5, height, ") is outside the allowed range (0..", ")"));
            }
            this._tableArray = twoDEval;
            this._size = twoDEval.getWidth();
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public ValueEval getItem(int i5) {
            if (i5 <= this._size) {
                return this._tableArray.getValue(this._rowIndex, i5);
            }
            StringBuilder sbT = AbstractC0157z.t(i5, "Specified index (", ") is outside the allowed range (0..");
            sbT.append(this._size - 1);
            sbT.append(")");
            throw new ArrayIndexOutOfBoundsException(sbT.toString());
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public int getSize() {
            return this._size;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum SearchMode {
        IterateForward(1),
        IterateBackward(-1),
        BinarySearchForward(2),
        BinarySearchBackward(-2);

        private final int intValue;

        SearchMode(int i5) {
            this.intValue = i5;
        }

        public int getIntValue() {
            return this.intValue;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SheetVector implements ValueVector {
        private final RefEval _re;
        private final int _size;

        public SheetVector(RefEval refEval) {
            this._size = refEval.getNumberOfSheets();
            this._re = refEval;
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public ValueEval getItem(int i5) {
            if (i5 < this._size) {
                return this._re.getInnerValueEval(this._re.getFirstSheetIndex() + i5);
            }
            StringBuilder sbT = AbstractC0157z.t(i5, "Specified index (", ") is outside the allowed range (0..");
            sbT.append(this._size - 1);
            sbT.append(")");
            throw new ArrayIndexOutOfBoundsException(sbT.toString());
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public int getSize() {
            return this._size;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class StringLookupComparer extends LookupValueComparerBase {
        protected final boolean _isMatchFunction;
        protected final boolean _matchExact;
        protected final String _value;
        protected final Pattern _wildCardPattern;

        public StringLookupComparer(StringEval stringEval, boolean z6, boolean z7) {
            super(stringEval);
            String stringValue = stringEval.getStringValue();
            this._value = stringValue;
            this._wildCardPattern = Countif.StringMatcher.getWildCardPattern(stringValue);
            this._matchExact = z6;
            this._isMatchFunction = z7;
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparerBase
        public CompareResult compareSameType(ValueEval valueEval) {
            String strConvertToString = convertToString(valueEval);
            Pattern pattern = this._wildCardPattern;
            return (pattern == null || (!this._isMatchFunction && this._matchExact)) ? CompareResult.valueOf(this._value.compareToIgnoreCase(strConvertToString)) : CompareResult.valueOf(pattern.matcher(strConvertToString).matches());
        }

        public String convertToString(ValueEval valueEval) {
            return ((StringEval) valueEval).getStringValue();
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparerBase
        public String getValueAsString() {
            return this._value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class TolerantStringLookupComparer extends StringLookupComparer {
        public TolerantStringLookupComparer(ValueEval valueEval, boolean z6, boolean z7) {
            super(convertToStringEval(valueEval), z6, z7);
        }

        public static StringEval convertToStringEval(ValueEval valueEval) {
            return valueEval instanceof StringEval ? (StringEval) valueEval : new StringEval(OperandResolver.coerceValueToString(valueEval));
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.StringLookupComparer
        public String convertToString(ValueEval valueEval) {
            return OperandResolver.coerceValueToString(valueEval);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ValueVector {
        ValueEval getItem(int i5);

        int getSize();

        default Iterator<Integer> indexIterator() {
            return new Iterator<Integer>() { // from class: org.apache.poi.ss.formula.functions.LookupUtils.ValueVector.1
                private int pos = 0;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos < ValueVector.this.getSize();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.Iterator
                public Integer next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    int i5 = this.pos;
                    this.pos = i5 + 1;
                    return Integer.valueOf(i5);
                }
            };
        }

        default Iterator<Integer> reverseIndexIterator() {
            return new Iterator<Integer>() { // from class: org.apache.poi.ss.formula.functions.LookupUtils.ValueVector.2
                private int pos;

                {
                    this.pos = ValueVector.this.getSize() - 1;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.pos > 0;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.Iterator
                public Integer next() {
                    int i5 = this.pos - 1;
                    this.pos = i5;
                    if (i5 >= 0) {
                        return Integer.valueOf(i5);
                    }
                    throw new NoSuchElementException();
                }
            };
        }
    }

    static {
        for (MatchMode matchMode : MatchMode.values()) {
            matchModeMap.put(Integer.valueOf(matchMode.getIntValue()), matchMode);
        }
        for (SearchMode searchMode : SearchMode.values()) {
            searchModeMap.put(Integer.valueOf(searchMode.getIntValue()), searchMode);
        }
    }

    private static int binarySearchIndexOfValue(LookupValueComparer lookupValueComparer, ValueVector valueVector, MatchMode matchMode, boolean z6) {
        HashSet hashSet = new HashSet();
        BinarySearchIndexes binarySearchIndexes = new BinarySearchIndexes(valueVector.getSize());
        int i5 = -1;
        ValueEval valueEval = null;
        while (true) {
            int midIx = binarySearchIndexes.getMidIx();
            if (midIx < 0 || hashSet.contains(Integer.valueOf(midIx))) {
                break;
            }
            hashSet.add(Integer.valueOf(midIx));
            ValueEval item = valueVector.getItem(midIx);
            CompareResult compareResultCompareTo = lookupValueComparer.compareTo(item);
            if (compareResultCompareTo.isEqual()) {
                return midIx;
            }
            int i6 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$formula$functions$LookupUtils$MatchMode[matchMode.ordinal()];
            if (i6 == 1 ? !(!compareResultCompareTo.isLessThan() || (valueEval != null && !createTolerantLookupComparer(item, true, true).compareTo(valueEval).isLessThan())) : !(i6 != 2 || !compareResultCompareTo.isGreaterThan() || (valueEval != null && !createTolerantLookupComparer(item, true, true).compareTo(valueEval).isGreaterThan()))) {
                i5 = midIx;
                valueEval = item;
            }
            if (compareResultCompareTo.isTypeMismatch()) {
                int iHandleMidValueTypeMismatch = handleMidValueTypeMismatch(lookupValueComparer, valueVector, binarySearchIndexes, midIx, z6);
                if (iHandleMidValueTypeMismatch >= 0) {
                    return iHandleMidValueTypeMismatch;
                }
            } else if (z6) {
                binarySearchIndexes.narrowSearch(midIx, compareResultCompareTo.isGreaterThan());
            } else {
                binarySearchIndexes.narrowSearch(midIx, compareResultCompareTo.isLessThan());
            }
        }
        return i5;
    }

    public static ValueVector createColumnVector(TwoDEval twoDEval, int i5) {
        return new ColumnVector(twoDEval, i5);
    }

    public static LookupValueComparer createLookupComparer(ValueEval valueEval, boolean z6, boolean z7) {
        if (valueEval == BlankEval.instance) {
            return new NumberLookupComparer(NumberEval.ZERO);
        }
        if (valueEval instanceof StringEval) {
            return new StringLookupComparer((StringEval) valueEval, z6, z7);
        }
        if (valueEval instanceof NumberEval) {
            return new NumberLookupComparer((NumberEval) valueEval);
        }
        if (valueEval instanceof BoolEval) {
            return new BooleanLookupComparer((BoolEval) valueEval);
        }
        throw new IllegalArgumentException("Bad lookup value type (" + valueEval.getClass().getName() + ")");
    }

    public static ValueVector createRowVector(TwoDEval twoDEval, int i5) {
        return new RowVector(twoDEval, i5);
    }

    private static LookupValueComparer createTolerantLookupComparer(ValueEval valueEval, boolean z6, boolean z7) {
        if (valueEval == BlankEval.instance) {
            return new TolerantStringLookupComparer(new StringEval(""), z6, z7);
        }
        if (valueEval instanceof BoolEval) {
            return new BooleanLookupComparer((BoolEval) valueEval);
        }
        return (z6 && (valueEval instanceof NumberEval)) ? new NumberLookupComparer((NumberEval) valueEval) : new TolerantStringLookupComparer(valueEval, z6, z7);
    }

    public static ValueVector createVector(TwoDEval twoDEval) {
        if (twoDEval.isColumn()) {
            return createColumnVector(twoDEval, 0);
        }
        if (twoDEval.isRow()) {
            return createRowVector(twoDEval, 0);
        }
        return null;
    }

    private static int findLastIndexInRunOfEqualValues(LookupValueComparer lookupValueComparer, ValueVector valueVector, int i5, int i6) {
        do {
            i5++;
            if (i5 >= i6) {
                return i6 - 1;
            }
        } while (lookupValueComparer.compareTo(valueVector.getItem(i5)).isEqual());
        return i5 - 1;
    }

    private static int handleMidValueTypeMismatch(LookupValueComparer lookupValueComparer, ValueVector valueVector, BinarySearchIndexes binarySearchIndexes, int i5, boolean z6) {
        CompareResult compareResultCompareTo;
        int highIx = binarySearchIndexes.getHighIx();
        int i6 = i5;
        do {
            i6++;
            if (i6 == highIx) {
                binarySearchIndexes.narrowSearch(i5, true);
                return -1;
            }
            compareResultCompareTo = lookupValueComparer.compareTo(valueVector.getItem(i6));
            if (compareResultCompareTo.isLessThan() && !z6 && i6 == highIx - 1) {
                binarySearchIndexes.narrowSearch(i5, true);
                return -1;
            }
            if (compareResultCompareTo.isGreaterThan() && z6 && i6 == highIx - 1) {
                binarySearchIndexes.narrowSearch(i5, true);
                return -1;
            }
        } while (compareResultCompareTo.isTypeMismatch());
        if (compareResultCompareTo.isEqual()) {
            return i6;
        }
        if (z6) {
            binarySearchIndexes.narrowSearch(i6, compareResultCompareTo.isGreaterThan());
        } else {
            binarySearchIndexes.narrowSearch(i6, compareResultCompareTo.isLessThan());
        }
        return -1;
    }

    public static int lookupFirstIndexOfValue(ValueEval valueEval, ValueVector valueVector, boolean z6) throws EvaluationException {
        LookupValueComparer lookupValueComparerCreateLookupComparer = createLookupComparer(valueEval, z6, false);
        int iPerformBinarySearch = z6 ? performBinarySearch(valueVector, lookupValueComparerCreateLookupComparer) : lookupFirstIndexOfValue(lookupValueComparerCreateLookupComparer, valueVector, MatchMode.ExactMatch);
        if (iPerformBinarySearch >= 0) {
            return iPerformBinarySearch;
        }
        throw new EvaluationException(ErrorEval.NA);
    }

    private static int lookupIndexOfValue(LookupValueComparer lookupValueComparer, ValueVector valueVector, MatchMode matchMode, boolean z6) {
        Iterator<Integer> itReverseIndexIterator = z6 ? valueVector.reverseIndexIterator() : valueVector.indexIterator();
        int i5 = -1;
        ValueEval valueEval = null;
        while (itReverseIndexIterator.hasNext()) {
            int iIntValue = itReverseIndexIterator.next().intValue();
            ValueEval item = valueVector.getItem(iIntValue);
            CompareResult compareResultCompareTo = lookupValueComparer.compareTo(item);
            if (compareResultCompareTo.isEqual()) {
                return iIntValue;
            }
            int i6 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$formula$functions$LookupUtils$MatchMode[matchMode.ordinal()];
            if (i6 != 1) {
                if (i6 == 2 && compareResultCompareTo.isGreaterThan() && (valueEval == null || createTolerantLookupComparer(item, true, true).compareTo(valueEval).isGreaterThan())) {
                    i5 = iIntValue;
                    valueEval = item;
                }
            } else if (compareResultCompareTo.isLessThan() && (valueEval == null || createTolerantLookupComparer(item, true, true).compareTo(valueEval).isLessThan())) {
                i5 = iIntValue;
                valueEval = item;
            }
        }
        return i5;
    }

    private static int lookupLastIndexOfValue(LookupValueComparer lookupValueComparer, ValueVector valueVector, MatchMode matchMode) {
        return lookupIndexOfValue(lookupValueComparer, valueVector, matchMode, true);
    }

    public static MatchMode matchMode(int i5) {
        MatchMode matchMode = matchModeMap.get(Integer.valueOf(i5));
        if (matchMode != null) {
            return matchMode;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "unknown match mode "));
    }

    private static int performBinarySearch(ValueVector valueVector, LookupValueComparer lookupValueComparer) {
        BinarySearchIndexes binarySearchIndexes = new BinarySearchIndexes(valueVector.getSize());
        while (true) {
            int midIx = binarySearchIndexes.getMidIx();
            if (midIx < 0) {
                return binarySearchIndexes.getLowIx();
            }
            CompareResult compareResultCompareTo = lookupValueComparer.compareTo(valueVector.getItem(midIx));
            if (compareResultCompareTo.isTypeMismatch()) {
                midIx = handleMidValueTypeMismatch(lookupValueComparer, valueVector, binarySearchIndexes, midIx, false);
                if (midIx < 0) {
                    continue;
                } else {
                    compareResultCompareTo = lookupValueComparer.compareTo(valueVector.getItem(midIx));
                }
            }
            if (compareResultCompareTo.isEqual()) {
                return findLastIndexInRunOfEqualValues(lookupValueComparer, valueVector, midIx, binarySearchIndexes.getHighIx());
            }
            binarySearchIndexes.narrowSearch(midIx, compareResultCompareTo.isLessThan());
        }
    }

    public static boolean resolveRangeLookupArg(ValueEval valueEval, int i5, int i6) throws EvaluationException {
        ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i5, i6);
        if (singleValue == MissingArgEval.instance || (singleValue instanceof BlankEval)) {
            return false;
        }
        if (singleValue instanceof BoolEval) {
            return ((BoolEval) singleValue).getBooleanValue();
        }
        if (!(singleValue instanceof StringEval)) {
            if (singleValue instanceof NumericValueEval) {
                return 0.0d != ((NumericValueEval) singleValue).getNumberValue();
            }
            throw new RuntimeException("Unexpected eval type (" + singleValue + ")");
        }
        String stringValue = ((StringEval) singleValue).getStringValue();
        if (stringValue.length() < 1) {
            throw EvaluationException.invalidValue();
        }
        Boolean bool = Countif.parseBoolean(stringValue);
        if (bool != null) {
            return bool.booleanValue();
        }
        throw EvaluationException.invalidValue();
    }

    public static int resolveRowOrColIndexArg(ValueEval valueEval, int i5, int i6) throws EvaluationException {
        if (valueEval == null) {
            throw new IllegalArgumentException("argument must not be null");
        }
        try {
            ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i5, (short) i6);
            if ((singleValue instanceof StringEval) && OperandResolver.parseDouble(((StringEval) singleValue).getStringValue()) == null) {
                throw EvaluationException.invalidRef();
            }
            int iCoerceValueToInt = OperandResolver.coerceValueToInt(singleValue);
            if (iCoerceValueToInt >= 1) {
                return iCoerceValueToInt - 1;
            }
            throw EvaluationException.invalidValue();
        } catch (EvaluationException unused) {
            throw EvaluationException.invalidRef();
        }
    }

    public static TwoDEval resolveTableArrayArg(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof TwoDEval) {
            return (TwoDEval) valueEval;
        }
        if (valueEval instanceof RefEval) {
            return ((RefEval) valueEval).offset(0, 0, 0, 0);
        }
        throw EvaluationException.invalidValue();
    }

    public static SearchMode searchMode(int i5) {
        SearchMode searchMode = searchModeMap.get(Integer.valueOf(i5));
        if (searchMode != null) {
            return searchMode;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "unknown search mode "));
    }

    public static int xlookupIndexOfValue(ValueEval valueEval, ValueVector valueVector, MatchMode matchMode, SearchMode searchMode) throws EvaluationException {
        int iLookupLastIndexOfValue;
        if ((valueEval instanceof StringEval) && (matchMode == MatchMode.ExactMatchFallbackToLargerValue || matchMode == MatchMode.ExactMatchFallbackToSmallerValue)) {
            String stringValue = ((StringEval) valueEval).getStringValue();
            StringBuilder sb = new StringBuilder(stringValue.length());
            boolean z6 = false;
            for (char c : stringValue.toCharArray()) {
                if (c == '*' || c == '?' || c == '~') {
                    z6 = true;
                } else {
                    sb.append(c);
                }
                if (z6) {
                    break;
                }
            }
            if (z6) {
                valueEval = new StringEval(sb.toString());
            }
        }
        LookupValueComparer lookupValueComparerCreateTolerantLookupComparer = createTolerantLookupComparer(valueEval, matchMode != MatchMode.WildcardMatch, true);
        if (searchMode == SearchMode.BinarySearchForward) {
            iLookupLastIndexOfValue = binarySearchIndexOfValue(lookupValueComparerCreateTolerantLookupComparer, valueVector, matchMode, false);
        } else if (searchMode == SearchMode.BinarySearchBackward) {
            iLookupLastIndexOfValue = binarySearchIndexOfValue(lookupValueComparerCreateTolerantLookupComparer, valueVector, matchMode, true);
        } else {
            iLookupLastIndexOfValue = searchMode == SearchMode.IterateBackward ? lookupLastIndexOfValue(lookupValueComparerCreateTolerantLookupComparer, valueVector, matchMode) : lookupFirstIndexOfValue(lookupValueComparerCreateTolerantLookupComparer, valueVector, matchMode);
        }
        if (iLookupLastIndexOfValue >= 0) {
            return iLookupLastIndexOfValue;
        }
        throw new EvaluationException(ErrorEval.NA);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class CompareResult {
        private final boolean _isEqual;
        private final boolean _isGreaterThan;
        private final boolean _isLessThan;
        private final boolean _isTypeMismatch;
        public static final CompareResult TYPE_MISMATCH = new CompareResult(true, 0);
        public static final CompareResult LESS_THAN = new CompareResult(false, -1);
        public static final CompareResult EQUAL = new CompareResult(false, 0);
        public static final CompareResult GREATER_THAN = new CompareResult(false, 1);

        private CompareResult(boolean z6, int i5) {
            if (z6) {
                this._isTypeMismatch = true;
                this._isLessThan = false;
                this._isEqual = false;
                this._isGreaterThan = false;
                return;
            }
            this._isTypeMismatch = false;
            this._isLessThan = i5 < 0;
            this._isEqual = i5 == 0;
            this._isGreaterThan = i5 > 0;
        }

        private String formatAsString() {
            if (this._isTypeMismatch) {
                return "TYPE_MISMATCH";
            }
            if (this._isLessThan) {
                return "LESS_THAN";
            }
            if (this._isEqual) {
                return "EQUAL";
            }
            return this._isGreaterThan ? "GREATER_THAN" : "??error??";
        }

        public static CompareResult valueOf(int i5) {
            if (i5 < 0) {
                return LESS_THAN;
            }
            return i5 > 0 ? GREATER_THAN : EQUAL;
        }

        public boolean isEqual() {
            return this._isEqual;
        }

        public boolean isGreaterThan() {
            return this._isGreaterThan;
        }

        public boolean isLessThan() {
            return this._isLessThan;
        }

        public boolean isTypeMismatch() {
            return this._isTypeMismatch;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            androidx.collection.a.w(CompareResult.class, sb, " [");
            return AbstractC0157z.s(sb, formatAsString(), "]");
        }

        public static CompareResult valueOf(boolean z6) {
            if (z6) {
                return EQUAL;
            }
            return LESS_THAN;
        }
    }

    public static ValueVector createVector(RefEval refEval) {
        return new SheetVector(refEval);
    }

    private static int lookupFirstIndexOfValue(LookupValueComparer lookupValueComparer, ValueVector valueVector, MatchMode matchMode) {
        return lookupIndexOfValue(lookupValueComparer, valueVector, matchMode, false);
    }
}
