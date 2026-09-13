package org.apache.poi.ss.formula;

import A3.AbstractC0157z;
import com.alibaba.android.arouter.utils.Consts;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Chars;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.constant.ErrorConstant;
import org.apache.poi.ss.formula.function.FunctionMetadata;
import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
import org.apache.poi.ss.formula.ptg.AbstractFunctionPtg;
import org.apache.poi.ss.formula.ptg.AddPtg;
import org.apache.poi.ss.formula.ptg.Area3DPxg;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.ArrayPtg;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.BoolPtg;
import org.apache.poi.ss.formula.ptg.ConcatPtg;
import org.apache.poi.ss.formula.ptg.DividePtg;
import org.apache.poi.ss.formula.ptg.EqualPtg;
import org.apache.poi.ss.formula.ptg.ErrPtg;
import org.apache.poi.ss.formula.ptg.FuncPtg;
import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.apache.poi.ss.formula.ptg.GreaterEqualPtg;
import org.apache.poi.ss.formula.ptg.GreaterThanPtg;
import org.apache.poi.ss.formula.ptg.IntPtg;
import org.apache.poi.ss.formula.ptg.IntersectionPtg;
import org.apache.poi.ss.formula.ptg.LessEqualPtg;
import org.apache.poi.ss.formula.ptg.LessThanPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.MissingArgPtg;
import org.apache.poi.ss.formula.ptg.MultiplyPtg;
import org.apache.poi.ss.formula.ptg.NamePtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.NameXPxg;
import org.apache.poi.ss.formula.ptg.NotEqualPtg;
import org.apache.poi.ss.formula.ptg.NumberPtg;
import org.apache.poi.ss.formula.ptg.OperandPtg;
import org.apache.poi.ss.formula.ptg.OperationPtg;
import org.apache.poi.ss.formula.ptg.ParenthesisPtg;
import org.apache.poi.ss.formula.ptg.PercentPtg;
import org.apache.poi.ss.formula.ptg.PowerPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.RangePtg;
import org.apache.poi.ss.formula.ptg.RefPtg;
import org.apache.poi.ss.formula.ptg.StringPtg;
import org.apache.poi.ss.formula.ptg.SubtractPtg;
import org.apache.poi.ss.formula.ptg.UnaryMinusPtg;
import org.apache.poi.ss.formula.ptg.UnaryPlusPtg;
import org.apache.poi.ss.formula.ptg.UnionPtg;
import org.apache.poi.ss.formula.ptg.ValueOperatorPtg;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Table;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class FormulaParser {
    private static final char CR = '\r';
    private static final char LF = '\n';
    private static final char TAB = '\t';
    private static final String specAll = "All";
    private static final String specData = "Data";
    private static final String specHeaders = "Headers";
    private static final String specThisRow = "This Row";
    private static final String specTotals = "Totals";
    private final FormulaParsingWorkbook _book;
    private final int _formulaLength;
    private final String _formulaString;
    private boolean _inIntersection;
    private int _pointer = 0;
    private ParseNode _rootNode;
    private final int _rowIndex;
    private final int _sheetIndex;
    private final SpreadsheetVersion _ssVersion;
    private int look;
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) FormulaParser.class);
    private static final Pattern CELL_REF_PATTERN = Pattern.compile("(\\$?[A-Za-z]+)?(\\$?[0-9]+)?");

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.FormulaParser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$SpreadsheetVersion;

        static {
            int[] iArr = new int[SpreadsheetVersion.values().length];
            $SwitchMap$org$apache$poi$ss$SpreadsheetVersion = iArr;
            try {
                iArr[SpreadsheetVersion.EXCEL97.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$SpreadsheetVersion[SpreadsheetVersion.EXCEL2007.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SimpleRangePart {
        private final String _rep;
        private final Type _type;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public enum Type {
            CELL,
            ROW,
            COLUMN;

            public static Type get(boolean z6, boolean z7) {
                if (z6) {
                    return z7 ? CELL : COLUMN;
                }
                if (z7) {
                    return ROW;
                }
                throw new IllegalArgumentException("must have either letters or numbers");
            }
        }

        public SimpleRangePart(String str, boolean z6, boolean z7) {
            this._rep = str;
            this._type = Type.get(z6, z7);
        }

        public CellReference getCellReference() {
            if (this._type == Type.CELL) {
                return new CellReference(this._rep);
            }
            throw new IllegalStateException("Not applicable to this reference-type, expected CELL, but had " + this._type);
        }

        public String getRep() {
            return this._rep;
        }

        public boolean isCell() {
            return this._type == Type.CELL;
        }

        public boolean isColumn() {
            return this._type == Type.COLUMN;
        }

        public boolean isCompatibleForArea(SimpleRangePart simpleRangePart) {
            return this._type == simpleRangePart._type;
        }

        public boolean isRow() {
            return this._type == Type.ROW;
        }

        public boolean isRowOrColumn() {
            return this._type != Type.CELL;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            androidx.collection.a.w(SimpleRangePart.class, sb, " [");
            return AbstractC0157z.s(sb, this._rep, "]");
        }
    }

    private FormulaParser(String str, FormulaParsingWorkbook formulaParsingWorkbook, int i5, int i6) {
        this._formulaString = str;
        this._book = formulaParsingWorkbook;
        this._ssVersion = formulaParsingWorkbook == null ? SpreadsheetVersion.EXCEL97 : formulaParsingWorkbook.getSpreadsheetVersion();
        this._formulaLength = str.length();
        this._sheetIndex = i5;
        this._rowIndex = i6;
    }

    private ParseNode[] Arguments() {
        ArrayList arrayList = new ArrayList(2);
        SkipWhite();
        if (this.look == 41) {
            return ParseNode.EMPTY_ARRAY;
        }
        while (true) {
            boolean z6 = true;
            while (true) {
                SkipWhite();
                if (isArgumentDelimiter(this.look)) {
                    break;
                }
                arrayList.add(intersectionExpression());
                SkipWhite();
                if (!isArgumentDelimiter(this.look)) {
                    throw expected("',' or ')'");
                }
                z6 = false;
            }
            if (z6) {
                arrayList.add(new ParseNode(MissingArgPtg.instance));
            }
            if (this.look == 41) {
                ParseNode[] parseNodeArr = new ParseNode[arrayList.size()];
                arrayList.toArray(parseNodeArr);
                return parseNodeArr;
            }
            Match(44);
        }
    }

    private void GetChar() {
        if (!IsWhite(this.look)) {
            this._inIntersection = false;
        } else if (this.look == 32) {
            this._inIntersection = true;
        }
        int i5 = this._pointer;
        int i6 = this._formulaLength;
        if (i5 <= i6) {
            if (i5 < i6) {
                this.look = this._formulaString.codePointAt(i5);
            } else {
                this.look = 0;
                this._inIntersection = false;
            }
            this._pointer = Character.charCount(this.look) + this._pointer;
            return;
        }
        throw new RuntimeException("Parsed past the end of the formula, pos: " + this._pointer + ", length: " + this._formulaLength + ", formula: " + this._formulaString);
    }

    private String GetNum() {
        StringBuilder sb = new StringBuilder();
        while (IsDigit(this.look)) {
            sb.appendCodePoint(this.look);
            GetChar();
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }

    private static boolean IsAlpha(int i5) {
        return Character.isLetter(i5) || i5 == 36 || i5 == 95;
    }

    private static boolean IsDigit(int i5) {
        return Character.isDigit(i5);
    }

    private static boolean IsWhite(int i5) {
        return i5 == 32 || i5 == 9 || i5 == 13 || i5 == 10;
    }

    private void Match(int i5) {
        if (this.look == i5) {
            GetChar();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("'");
        StringBuilder sbAppendCodePoint = sb.appendCodePoint(i5);
        sbAppendCodePoint.append("'");
        throw expected(sbAppendCodePoint.toString());
    }

    private void SkipWhite() {
        while (IsWhite(this.look)) {
            GetChar();
        }
    }

    private ParseNode Term() {
        Ptg ptg;
        ParseNode parseNodePowerFactor = powerFactor();
        while (true) {
            SkipWhite();
            int i5 = this.look;
            if (i5 == 42) {
                Match(42);
                ptg = MultiplyPtg.instance;
            } else {
                if (i5 != 47) {
                    return parseNodePowerFactor;
                }
                Match(47);
                ptg = DividePtg.instance;
            }
            parseNodePowerFactor = new ParseNode(ptg, parseNodePowerFactor, powerFactor());
        }
    }

    private void addName(String str) {
        Name nameCreateName = this._book.createName();
        nameCreateName.setFunction(true);
        nameCreateName.setNameName(str);
        nameCreateName.setSheetIndex(this._sheetIndex);
    }

    private ParseNode additiveExpression() {
        Ptg ptg;
        ParseNode parseNodeTerm = Term();
        while (true) {
            SkipWhite();
            int i5 = this.look;
            if (i5 == 43) {
                Match(43);
                ptg = AddPtg.instance;
            } else {
                if (i5 != 45) {
                    return parseNodeTerm;
                }
                Match(45);
                ptg = SubtractPtg.instance;
            }
            parseNodeTerm = new ParseNode(ptg, parseNodeTerm, Term());
        }
    }

    private static ParseNode augmentWithMemPtg(ParseNode parseNode) {
        return new ParseNode(needsMemFunc(parseNode) ? new MemFuncPtg(parseNode.getEncodedSize()) : new MemAreaPtg(parseNode.getEncodedSize()), parseNode);
    }

    private void checkRowLengths(Object[][] objArr, int i5) {
        for (int i6 = 0; i6 < objArr.length; i6++) {
            int length = objArr[i6].length;
            if (length != i5) {
                StringBuilder sbS = androidx.collection.a.s("Array row ", i6, length, " has length ", " but row 0 has length ");
                sbS.append(i5);
                throw new FormulaParseException(sbS.toString());
            }
        }
    }

    private static void checkValidRangeOperand(String str, int i5, ParseNode parseNode) {
        if (isValidRangeOperand(parseNode)) {
            return;
        }
        throw new FormulaParseException("The " + str + " of the range operator ':' at position " + i5 + " is not a proper reference.");
    }

    private ParseNode comparisonExpression() {
        ParseNode parseNodeConcatExpression = concatExpression();
        while (true) {
            SkipWhite();
            switch (this.look) {
                case 60:
                case 61:
                case 62:
                    parseNodeConcatExpression = new ParseNode(getComparisonToken(), parseNodeConcatExpression, concatExpression());
                    break;
                default:
                    return parseNodeConcatExpression;
            }
        }
    }

    private ParseNode concatExpression() {
        ParseNode parseNodeAdditiveExpression = additiveExpression();
        while (true) {
            SkipWhite();
            if (this.look != 38) {
                return parseNodeAdditiveExpression;
            }
            Match(38);
            parseNodeAdditiveExpression = new ParseNode(ConcatPtg.instance, parseNodeAdditiveExpression, additiveExpression());
        }
    }

    private static Double convertArrayNumber(Ptg ptg, boolean z6) {
        double value;
        if (ptg instanceof IntPtg) {
            value = ((IntPtg) ptg).getValue();
        } else {
            if (!(ptg instanceof NumberPtg)) {
                throw new RuntimeException("Unexpected ptg (" + ptg.getClass().getName() + ")");
            }
            value = ((NumberPtg) ptg).getValue();
        }
        if (!z6) {
            value = -value;
        }
        return Double.valueOf(value);
    }

    private AreaReference createAreaRef(SimpleRangePart simpleRangePart, SimpleRangePart simpleRangePart2) {
        if (simpleRangePart.isCompatibleForArea(simpleRangePart2)) {
            if (simpleRangePart.isRow()) {
                return AreaReference.getWholeRow(this._ssVersion, simpleRangePart.getRep(), simpleRangePart2.getRep());
            }
            return simpleRangePart.isColumn() ? AreaReference.getWholeColumn(this._ssVersion, simpleRangePart.getRep(), simpleRangePart2.getRep()) : new AreaReference(simpleRangePart.getCellReference(), simpleRangePart2.getCellReference(), this._ssVersion);
        }
        StringBuilder sb = new StringBuilder("has incompatible parts: '");
        sb.append(simpleRangePart.getRep());
        sb.append("' and '");
        throw new FormulaParseException(AbstractC0157z.s(sb, simpleRangePart2.getRep(), "'."));
    }

    private ParseNode createAreaRefParseNode(SheetIdentifier sheetIdentifier, SimpleRangePart simpleRangePart, SimpleRangePart simpleRangePart2) {
        Ptg areaPtg;
        if (simpleRangePart2 == null) {
            CellReference cellReference = simpleRangePart.getCellReference();
            areaPtg = sheetIdentifier == null ? new RefPtg(cellReference) : this._book.get3DReferencePtg(cellReference, sheetIdentifier);
        } else {
            AreaReference areaReferenceCreateAreaRef = createAreaRef(simpleRangePart, simpleRangePart2);
            areaPtg = sheetIdentifier == null ? new AreaPtg(areaReferenceCreateAreaRef) : this._book.get3DReferencePtg(areaReferenceCreateAreaRef, sheetIdentifier);
        }
        return new ParseNode(areaPtg);
    }

    private RuntimeException expected(String str) {
        String strR;
        if (this.look == 61 && StringUtil.isBlank(this._formulaString.substring(0, this._pointer - 1))) {
            strR = AbstractC0157z.s(new StringBuilder("The specified formula '"), this._formulaString, "' starts with an equals sign which is not allowed.");
        } else {
            StringBuilder sb = new StringBuilder("Parse error near char ");
            sb.append(this._pointer - 1);
            sb.append(" '");
            StringBuilder sbAppendCodePoint = sb.appendCodePoint(this.look);
            sbAppendCodePoint.append("'");
            sbAppendCodePoint.append(" in specified formula '");
            strR = androidx.exifinterface.media.a.r(sbAppendCodePoint, this._formulaString, "'. Expected ", str);
        }
        return new FormulaParseException(strR);
    }

    private ParseNode function(String str) {
        Ptg nameXPtg = null;
        if (!AbstractFunctionPtg.isBuiltInFunctionName(str)) {
            FormulaParsingWorkbook formulaParsingWorkbook = this._book;
            if (formulaParsingWorkbook == null) {
                throw new IllegalStateException(AbstractC0157z.o("Need book to evaluate name '", str, "'"));
            }
            EvaluationName name = formulaParsingWorkbook.getName(str, this._sheetIndex);
            if (name == null) {
                nameXPtg = this._book.getNameXPtg(str, null);
                if (nameXPtg == null) {
                    LOGGER.atWarn().log("FormulaParser.function: Name '{}' is completely unknown in the current workbook.", str);
                    int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$SpreadsheetVersion[this._book.getSpreadsheetVersion().ordinal()];
                    if (i5 == 1) {
                        addName(str);
                        nameXPtg = this._book.getName(str, this._sheetIndex).createPtg();
                    } else {
                        if (i5 != 2) {
                            throw new IllegalStateException("Unexpected spreadsheet version: " + this._book.getSpreadsheetVersion().name());
                        }
                        nameXPtg = new NameXPxg(str);
                    }
                }
            } else {
                if (!name.isFunctionName()) {
                    throw new FormulaParseException(AbstractC0157z.o("Attempt to use name '", str, "' as a function, but defined name in workbook does not refer to a function"));
                }
                nameXPtg = name.createPtg();
            }
        }
        Match(40);
        ParseNode[] parseNodeArrArguments = Arguments();
        Match(41);
        return getFunction(str, nameXPtg, parseNodeArrArguments);
    }

    private String getBookName() {
        StringBuilder sb = new StringBuilder();
        GetChar();
        while (true) {
            int i5 = this.look;
            if (i5 == 93) {
                GetChar();
                return sb.toString();
            }
            sb.appendCodePoint(i5);
            GetChar();
        }
    }

    private Ptg getComparisonToken() {
        int i5 = this.look;
        if (i5 == 61) {
            Match(i5);
            return EqualPtg.instance;
        }
        boolean z6 = i5 == 62;
        Match(i5);
        if (z6) {
            if (this.look != 61) {
                return GreaterThanPtg.instance;
            }
            Match(61);
            return GreaterEqualPtg.instance;
        }
        int i6 = this.look;
        if (i6 == 61) {
            Match(61);
            return LessEqualPtg.instance;
        }
        if (i6 != 62) {
            return LessThanPtg.instance;
        }
        Match(62);
        return NotEqualPtg.instance;
    }

    private ParseNode getFunction(String str, Ptg ptg, ParseNode[] parseNodeArr) {
        FunctionMetadata functionByName = FunctionMetadataRegistry.getFunctionByName(str.toUpperCase(Locale.ROOT));
        int length = parseNodeArr.length;
        if (functionByName == null) {
            if (ptg == null) {
                throw new IllegalStateException("NamePtg must be supplied for external functions");
            }
            int i5 = length + 1;
            ParseNode[] parseNodeArr2 = new ParseNode[i5];
            parseNodeArr2[0] = new ParseNode(ptg);
            System.arraycopy(parseNodeArr, 0, parseNodeArr2, 1, length);
            return new ParseNode(FuncVarPtg.create(str, i5), parseNodeArr2);
        }
        if (ptg != null) {
            throw new IllegalStateException("NamePtg no applicable to internal functions");
        }
        boolean zHasFixedArgsLength = functionByName.hasFixedArgsLength();
        int index = functionByName.getIndex();
        if (index == 4 && parseNodeArr.length == 1) {
            return new ParseNode(AttrPtg.getSumSingle(), parseNodeArr);
        }
        validateNumArgs(parseNodeArr.length, functionByName);
        return new ParseNode(!zHasFixedArgsLength ? FuncVarPtg.create(str, length) : FuncPtg.create(index), parseNodeArr);
    }

    private static Ptg getNumberPtgFromString(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (str2 == null) {
            sb.append(str);
            if (str3 != null) {
                sb.append('E');
                sb.append(str3);
            }
            String string = sb.toString();
            try {
                int i5 = Integer.parseInt(string);
                return IntPtg.isInRange(i5) ? new IntPtg(i5) : new NumberPtg(string);
            } catch (NumberFormatException unused) {
                return new NumberPtg(string);
            }
        }
        if (str != null) {
            sb.append(str);
        }
        sb.append('.');
        sb.append(str2);
        if (str3 != null) {
            sb.append('E');
            sb.append(str3);
        }
        return new NumberPtg(sb.toString());
    }

    private Ptg[] getRPNPtg(FormulaType formulaType) {
        new OperandClassTransformer(formulaType).transformFormula(this._rootNode);
        return ParseNode.toTokenArray(this._rootNode);
    }

    private ParseNode intersectionExpression() {
        ParseNode parseNodeComparisonExpression = comparisonExpression();
        boolean z6 = false;
        while (true) {
            SkipWhite();
            if (!this._inIntersection) {
                break;
            }
            try {
                z6 = true;
                parseNodeComparisonExpression = new ParseNode(IntersectionPtg.instance, parseNodeComparisonExpression, comparisonExpression());
            } catch (FormulaParseException unused) {
                resetPointer(this._pointer);
            }
        }
        return z6 ? augmentWithMemPtg(parseNodeComparisonExpression) : parseNodeComparisonExpression;
    }

    private static boolean isArgumentDelimiter(int i5) {
        return i5 == 44 || i5 == 41;
    }

    private static boolean isUnquotedSheetNameChar(int i5) {
        return Character.isLetterOrDigit(i5) || i5 > 128 || i5 == 32 || i5 == 46 || i5 == 95;
    }

    private boolean isValidCellReference(String str) {
        boolean z6 = CellReference.classifyCellReference(str, this._ssVersion) == CellReference.NameType.CELL;
        if (!z6 || FunctionMetadataRegistry.getFunctionByName(str.toUpperCase(Locale.ROOT)) == null) {
            return z6;
        }
        int i5 = this._pointer;
        resetPointer(str.length() + i5);
        SkipWhite();
        boolean z7 = this.look != 40;
        resetPointer(i5);
        return z7;
    }

    private static boolean isValidDefinedNameChar(int i5) {
        return Character.isLetterOrDigit(i5) || i5 > 128 || i5 == 46 || i5 == 63 || i5 == 92 || i5 == 95;
    }

    private static boolean isValidRangeOperand(ParseNode parseNode) {
        Ptg token = parseNode.getToken();
        if (token instanceof OperandPtg) {
            return true;
        }
        if (token instanceof AbstractFunctionPtg) {
            byte defaultOperandClass = ((AbstractFunctionPtg) token).getDefaultOperandClass();
            return defaultOperandClass == 0 || 32 == defaultOperandClass;
        }
        if (token instanceof ValueOperatorPtg) {
            return false;
        }
        if (token instanceof OperationPtg) {
            return true;
        }
        if (token instanceof ParenthesisPtg) {
            return isValidRangeOperand(parseNode.getChildren()[0]);
        }
        return token == ErrPtg.REF_INVALID;
    }

    private static boolean needsMemFunc(ParseNode parseNode) {
        Ptg token = parseNode.getToken();
        if ((token instanceof AbstractFunctionPtg) || (token instanceof ExternSheetReferenceToken) || (token instanceof NamePtg) || (token instanceof NameXPtg)) {
            return true;
        }
        if (!(token instanceof OperationPtg) && !(token instanceof ParenthesisPtg)) {
            return false;
        }
        for (ParseNode parseNode2 : parseNode.getChildren()) {
            if (needsMemFunc(parseNode2)) {
                return true;
            }
        }
        return false;
    }

    public static Ptg[] parse(String str, FormulaParsingWorkbook formulaParsingWorkbook, FormulaType formulaType, int i5, int i6) {
        FormulaParser formulaParser = new FormulaParser(str, formulaParsingWorkbook, i5, i6);
        formulaParser.parse();
        return formulaParser.getRPNPtg(formulaType);
    }

    private ParseNode parseArray() {
        ArrayList arrayList = new ArrayList();
        while (true) {
            arrayList.add(parseArrayRow());
            int i5 = this.look;
            if (i5 == 125) {
                Object[][] objArr = new Object[arrayList.size()][];
                arrayList.toArray(objArr);
                checkRowLengths(objArr, objArr[0].length);
                return new ParseNode(new ArrayPtg(objArr));
            }
            if (i5 != 59) {
                throw expected("'}' or ';'");
            }
            Match(59);
        }
    }

    private Object parseArrayItem() {
        SkipWhite();
        int i5 = this.look;
        if (i5 == 34) {
            return parseStringLiteral();
        }
        if (i5 == 35) {
            return ErrorConstant.valueOf(parseErrorLiteral());
        }
        if (i5 != 45) {
            return (i5 == 70 || i5 == 84 || i5 == 102 || i5 == 116) ? parseBooleanLiteral() : convertArrayNumber(parseNumber(), true);
        }
        Match(45);
        SkipWhite();
        return convertArrayNumber(parseNumber(), false);
    }

    private Object[] parseArrayRow() {
        int i5;
        ArrayList arrayList = new ArrayList();
        while (true) {
            arrayList.add(parseArrayItem());
            SkipWhite();
            i5 = this.look;
            if (i5 != 44) {
                break;
            }
            Match(44);
        }
        if (i5 != 59 && i5 != 125) {
            throw expected("'}' or ','");
        }
        Object[] objArr = new Object[arrayList.size()];
        arrayList.toArray(objArr);
        return objArr;
    }

    private String parseAsColumnQuantifier() {
        if (this.look != 91) {
            return null;
        }
        GetChar();
        int i5 = this.look;
        if (i5 == 35) {
            return null;
        }
        if (i5 == 64) {
            GetChar();
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i6 = this.look;
            if (i6 == 93) {
                Match(93);
                return sb.toString();
            }
            sb.appendCodePoint(i6);
            GetChar();
        }
    }

    private String parseAsName() {
        int i5;
        StringBuilder sb = new StringBuilder();
        if (!Character.isLetter(this.look) && (i5 = this.look) != 95 && i5 != 92) {
            throw expected("number, string, defined name, or data table");
        }
        while (isValidDefinedNameChar(this.look)) {
            sb.appendCodePoint(this.look);
            GetChar();
        }
        SkipWhite();
        return sb.toString();
    }

    private String parseAsSpecialQuantifier() {
        if (this.look != 91) {
            return null;
        }
        GetChar();
        if (this.look != 35) {
            return null;
        }
        GetChar();
        String asName = parseAsName();
        if (asName.equals("This")) {
            asName = asName + Chars.SPACE + parseAsName();
        }
        Match(93);
        return asName;
    }

    private Boolean parseBooleanLiteral() {
        String unquotedIdentifier = parseUnquotedIdentifier();
        if ("TRUE".equalsIgnoreCase(unquotedIdentifier)) {
            return Boolean.TRUE;
        }
        if ("FALSE".equalsIgnoreCase(unquotedIdentifier)) {
            return Boolean.FALSE;
        }
        throw expected("'TRUE' or 'FALSE'");
    }

    private int parseErrorLiteral() {
        Match(35);
        String unquotedIdentifier = parseUnquotedIdentifier();
        if (unquotedIdentifier == null) {
            throw expected("remainder of error constant literal");
        }
        String upperCase = unquotedIdentifier.toUpperCase(Locale.ROOT);
        char cCharAt = upperCase.charAt(0);
        if (cCharAt == 'D') {
            FormulaError formulaError = FormulaError.DIV0;
            if (!upperCase.equals("DIV")) {
                throw expected(formulaError.getString());
            }
            Match(47);
            Match(48);
            Match(33);
            return formulaError.getCode();
        }
        if (cCharAt != 'N') {
            if (cCharAt == 'R') {
                FormulaError formulaError2 = FormulaError.REF;
                if (!upperCase.equals(formulaError2.name())) {
                    throw expected(formulaError2.getString());
                }
                Match(33);
                return formulaError2.getCode();
            }
            if (cCharAt != 'V') {
                throw expected("#VALUE!, #REF!, #DIV/0!, #NAME?, #NUM!, #NULL! or #N/A");
            }
            FormulaError formulaError3 = FormulaError.VALUE;
            if (!upperCase.equals(formulaError3.name())) {
                throw expected(formulaError3.getString());
            }
            Match(33);
            return formulaError3.getCode();
        }
        FormulaError formulaError4 = FormulaError.NAME;
        if (upperCase.equals(formulaError4.name())) {
            Match(63);
            return formulaError4.getCode();
        }
        FormulaError formulaError5 = FormulaError.NUM;
        if (upperCase.equals(formulaError5.name())) {
            Match(33);
            return formulaError5.getCode();
        }
        FormulaError formulaError6 = FormulaError.NULL;
        if (upperCase.equals(formulaError6.name())) {
            Match(33);
            return formulaError6.getCode();
        }
        FormulaError formulaError7 = FormulaError.NA;
        if (!upperCase.equals("N")) {
            throw expected("#NAME?, #NUM!, #NULL! or #N/A");
        }
        Match(47);
        int i5 = this.look;
        if (i5 != 65 && i5 != 97) {
            throw expected(formulaError7.getString());
        }
        Match(i5);
        return formulaError7.getCode();
    }

    private ParseNode parseNonRange(int i5) {
        resetPointer(i5);
        if (Character.isDigit(this.look)) {
            return new ParseNode(parseNumber());
        }
        if (this.look == 34) {
            return new ParseNode(new StringPtg(parseStringLiteral()));
        }
        String asName = parseAsName();
        int i6 = this.look;
        if (i6 == 40) {
            return function(asName);
        }
        if (i6 == 91) {
            return parseStructuredReference(asName);
        }
        if (asName.equalsIgnoreCase("TRUE") || asName.equalsIgnoreCase("FALSE")) {
            return new ParseNode(BoolPtg.valueOf(asName.equalsIgnoreCase("TRUE")));
        }
        FormulaParsingWorkbook formulaParsingWorkbook = this._book;
        if (formulaParsingWorkbook == null) {
            throw new IllegalStateException(AbstractC0157z.o("Need book to evaluate name '", asName, "'"));
        }
        EvaluationName name = formulaParsingWorkbook.getName(asName, this._sheetIndex);
        if (name == null) {
            throw new FormulaParseException(AbstractC0157z.o("Specified named range '", asName, "' does not exist in the current workbook."));
        }
        if (name.isRange()) {
            return new ParseNode(name.createPtg());
        }
        throw new FormulaParseException(AbstractC0157z.o("Specified name '", asName, "' is not a range as expected."));
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    private Ptg parseNumber() {
        String strGetNum;
        String str;
        String strGetNum2;
        String strGetNum3 = GetNum();
        String strConcat = null;
        if (this.look == 46) {
            GetChar();
            strGetNum = GetNum();
        } else {
            strGetNum = null;
        }
        if (this.look == 69) {
            GetChar();
            int i5 = this.look;
            if (i5 == 43) {
                GetChar();
            } else {
                if (i5 == 45) {
                    GetChar();
                    str = ProcessIdUtil.DEFAULT_PROCESSID;
                }
                strGetNum2 = GetNum();
                if (strGetNum2 != null) {
                    throw expected("Integer");
                }
                strConcat = str.concat(strGetNum2);
            }
            str = "";
            strGetNum2 = GetNum();
            if (strGetNum2 != null) {
                throw expected("Integer");
            }
            strConcat = str.concat(strGetNum2);
        }
        if (strGetNum3 == null && strGetNum == null) {
            throw expected("Integer");
        }
        return getNumberPtgFromString(strGetNum3, strGetNum, strConcat);
    }

    private ParseNode parseRangeExpression() {
        ParseNode rangeable = parseRangeable();
        boolean z6 = false;
        while (this.look == 58) {
            int i5 = this._pointer;
            GetChar();
            ParseNode rangeable2 = parseRangeable();
            checkValidRangeOperand("LHS", i5, rangeable);
            checkValidRangeOperand("RHS", i5, rangeable2);
            z6 = true;
            rangeable = new ParseNode(RangePtg.instance, new ParseNode[]{rangeable, rangeable2});
        }
        return z6 ? augmentWithMemPtg(rangeable) : rangeable;
    }

    private ParseNode parseRangeable() {
        int i5;
        String str;
        SkipWhite();
        int i6 = this._pointer;
        SheetIdentifier sheetName = parseSheetName(false);
        if (sheetName == null) {
            resetPointer(i6);
        } else {
            SkipWhite();
            i6 = this._pointer;
        }
        SimpleRangePart simpleRangePart = parseSimpleRangePart();
        if (simpleRangePart == null) {
            if (sheetName == null) {
                return parseNonRange(i6);
            }
            if (this.look == 35) {
                return new ParseNode(ErrPtg.valueOf(parseErrorLiteral()));
            }
            String asName = parseAsName();
            if (asName.length() == 0) {
                throw new FormulaParseException(AbstractC0157z.l(Consts.DOT, this._pointer, new StringBuilder("Cell reference or Named Range expected after sheet name at index ")));
            }
            Ptg nameXPtg = this._book.getNameXPtg(asName, sheetName);
            if (nameXPtg != null) {
                return new ParseNode(nameXPtg);
            }
            StringBuilder sbY = AbstractC0157z.y("Specified name '", asName, "' for sheet ");
            sbY.append(sheetName.asFormulaString());
            sbY.append(" not found");
            throw new FormulaParseException(sbY.toString());
        }
        boolean zIsWhite = IsWhite(this.look);
        if (zIsWhite) {
            SkipWhite();
        }
        int i7 = this.look;
        if (i7 == 58) {
            int i8 = this._pointer;
            GetChar();
            SkipWhite();
            SimpleRangePart simpleRangePart2 = parseSimpleRangePart();
            SimpleRangePart simpleRangePart3 = (simpleRangePart2 == null || simpleRangePart.isCompatibleForArea(simpleRangePart2)) ? simpleRangePart2 : null;
            if (simpleRangePart3 == null) {
                resetPointer(i8);
                if (!simpleRangePart.isCell()) {
                    if (sheetName != null) {
                        str = "'" + sheetName.getSheetIdentifier().getName() + '!';
                    } else {
                        str = "";
                    }
                    throw new FormulaParseException(AbstractC0157z.s(androidx.collection.a.r(str), simpleRangePart.getRep(), "' is not a proper reference."));
                }
            }
            return createAreaRefParseNode(sheetName, simpleRangePart, simpleRangePart3);
        }
        if (i7 != 46) {
            if (simpleRangePart.isCell() && isValidCellReference(simpleRangePart.getRep())) {
                return createAreaRefParseNode(sheetName, simpleRangePart, null);
            }
            if (sheetName == null) {
                return parseNonRange(i6);
            }
            throw new FormulaParseException(AbstractC0157z.l(Consts.DOT, this._pointer, new StringBuilder("Second part of cell reference expected after sheet name at index ")));
        }
        GetChar();
        int i9 = 1;
        while (true) {
            i5 = this.look;
            if (i5 != 46) {
                break;
            }
            i9++;
            GetChar();
        }
        boolean zIsWhite2 = IsWhite(i5);
        SkipWhite();
        SimpleRangePart simpleRangePart4 = parseSimpleRangePart();
        String strSubstring = this._formulaString.substring(i6 - 1, this._pointer - 1);
        if (simpleRangePart4 == null) {
            if (sheetName == null) {
                return parseNonRange(i6);
            }
            throw new FormulaParseException(AbstractC0157z.l(Consts.DOT, this._pointer, new StringBuilder("Complete area reference expected after sheet name at index ")));
        }
        if (zIsWhite || zIsWhite2) {
            if (simpleRangePart.isRowOrColumn() || simpleRangePart4.isRowOrColumn()) {
                throw new FormulaParseException(AbstractC0157z.o("Dotted range (full row or column) expression '", strSubstring, "' must not contain whitespace."));
            }
            return createAreaRefParseNode(sheetName, simpleRangePart, simpleRangePart4);
        }
        if (i9 == 1 && simpleRangePart.isRow() && simpleRangePart4.isRow()) {
            return parseNonRange(i6);
        }
        if ((simpleRangePart.isRowOrColumn() || simpleRangePart4.isRowOrColumn()) && i9 != 2) {
            throw new FormulaParseException(AbstractC0157z.o("Dotted range (full row or column) expression '", strSubstring, "' must have exactly 2 dots."));
        }
        return createAreaRefParseNode(sheetName, simpleRangePart, simpleRangePart4);
    }

    private SheetIdentifier parseSheetName(boolean z6) {
        String bookName = this.look == 91 ? getBookName() : null;
        int i5 = this.look;
        if (i5 != 39 && !z6) {
            if (i5 != 95 && !Character.isLetter(i5)) {
                if (this.look != 33 || bookName == null) {
                    return null;
                }
                GetChar();
                return new SheetIdentifier(bookName, null);
            }
            StringBuilder sb = new StringBuilder();
            while (isUnquotedSheetNameChar(this.look)) {
                sb.appendCodePoint(this.look);
                GetChar();
            }
            if (this.look == 39) {
                GetChar();
            }
            NameIdentifier nameIdentifier = new NameIdentifier(sb.toString(), false);
            SkipWhite();
            int i6 = this.look;
            if (i6 == 33) {
                GetChar();
                return new SheetIdentifier(bookName, nameIdentifier);
            }
            if (i6 == 58) {
                return parseSheetRange(bookName, nameIdentifier, false);
            }
            return null;
        }
        if (!z6) {
            Match(39);
        }
        if (this.look == 91) {
            bookName = getBookName();
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z7 = this.look == 39;
        while (!z7) {
            sb2.appendCodePoint(this.look);
            GetChar();
            int i7 = this.look;
            if (i7 == 39) {
                GetChar();
                if (this.look == 39) {
                    GetChar();
                } else {
                    z7 = true;
                }
            } else if (i7 == 58) {
                z7 = true;
            }
        }
        NameIdentifier nameIdentifier2 = new NameIdentifier(sb2.toString(), true);
        SkipWhite();
        int i8 = this.look;
        if (i8 == 33) {
            GetChar();
            return new SheetIdentifier(bookName, nameIdentifier2);
        }
        if (i8 == 58) {
            return parseSheetRange(bookName, nameIdentifier2, true);
        }
        return null;
    }

    private SheetIdentifier parseSheetRange(String str, NameIdentifier nameIdentifier, boolean z6) {
        GetChar();
        SheetIdentifier sheetName = parseSheetName(z6);
        if (sheetName != null) {
            return new SheetRangeIdentifier(str, nameIdentifier, sheetName.getSheetIdentifier());
        }
        return null;
    }

    private ParseNode parseSimpleFactor() {
        int i5;
        SkipWhite();
        int i6 = this.look;
        if (i6 == 34) {
            return new ParseNode(new StringPtg(parseStringLiteral()));
        }
        if (i6 == 35) {
            return new ParseNode(ErrPtg.valueOf(parseErrorLiteral()));
        }
        if (i6 == 40) {
            Match(40);
            ParseNode parseNodeUnionExpression = unionExpression();
            Match(41);
            return new ParseNode(ParenthesisPtg.instance, parseNodeUnionExpression);
        }
        if (i6 == 43) {
            Match(43);
            return parseUnary(true);
        }
        if (i6 == 45) {
            Match(45);
            return parseUnary(false);
        }
        if (i6 == 123) {
            Match(123);
            ParseNode array = parseArray();
            Match(125);
            return array;
        }
        if (IsAlpha(i6) || Character.isDigit(this.look) || (i5 = this.look) == 39 || i5 == 91 || i5 == 95 || i5 == 92) {
            return parseRangeExpression();
        }
        if (i5 == 46) {
            return new ParseNode(parseNumber());
        }
        throw expected("cell ref or constant literal");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0077, code lost:
    
        if (r5 <= r8._ssVersion.getMaxRows()) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.apache.poi.ss.formula.FormulaParser.SimpleRangePart parseSimpleRangePart() {
        /*
            r8 = this;
            int r0 = r8._pointer
            r1 = 1
            int r0 = r0 - r1
            r2 = 0
            r3 = r2
        L6:
            int r4 = r8._formulaLength
            if (r0 >= r4) goto L2b
            java.lang.String r4 = r8._formulaString
            char r4 = r4.charAt(r0)
            boolean r5 = java.lang.Character.isDigit(r4)
            if (r5 == 0) goto L18
            r2 = r1
            goto L28
        L18:
            boolean r5 = java.lang.Character.isLetter(r4)
            if (r5 == 0) goto L20
            r3 = r1
            goto L28
        L20:
            r5 = 36
            if (r4 == r5) goto L28
            r5 = 95
            if (r4 != r5) goto L2b
        L28:
            int r0 = r0 + 1
            goto L6
        L2b:
            int r4 = r8._pointer
            int r5 = r4 + (-1)
            r6 = 0
            if (r0 > r5) goto L33
            return r6
        L33:
            java.lang.String r5 = r8._formulaString
            int r4 = r4 - r1
            java.lang.String r4 = r5.substring(r4, r0)
            java.util.regex.Pattern r5 = org.apache.poi.ss.formula.FormulaParser.CELL_REF_PATTERN
            java.util.regex.Matcher r5 = r5.matcher(r4)
            boolean r5 = r5.matches()
            if (r5 != 0) goto L47
            return r6
        L47:
            if (r3 == 0) goto L52
            if (r2 == 0) goto L52
            boolean r5 = r8.isValidCellReference(r4)
            if (r5 != 0) goto L7a
            return r6
        L52:
            java.lang.String r5 = ""
            java.lang.String r7 = "$"
            if (r3 == 0) goto L65
            java.lang.String r5 = r4.replace(r7, r5)
            org.apache.poi.ss.SpreadsheetVersion r7 = r8._ssVersion
            boolean r5 = org.apache.poi.ss.util.CellReference.isColumnWithinRange(r5, r7)
            if (r5 != 0) goto L7a
            return r6
        L65:
            if (r2 == 0) goto L84
            java.lang.String r5 = r4.replace(r7, r5)     // Catch: java.lang.NumberFormatException -> L84
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.NumberFormatException -> L84
            if (r5 < r1) goto L84
            org.apache.poi.ss.SpreadsheetVersion r7 = r8._ssVersion
            int r7 = r7.getMaxRows()
            if (r5 <= r7) goto L7a
            goto L84
        L7a:
            int r0 = r0 + r1
            r8.resetPointer(r0)
            org.apache.poi.ss.formula.FormulaParser$SimpleRangePart r0 = new org.apache.poi.ss.formula.FormulaParser$SimpleRangePart
            r0.<init>(r4, r3, r2)
            return r0
        L84:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.ss.formula.FormulaParser.parseSimpleRangePart():org.apache.poi.ss.formula.FormulaParser$SimpleRangePart");
    }

    private String parseStringLiteral() {
        Match(34);
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (this.look == 34) {
                GetChar();
                if (this.look != 34) {
                    return sb.toString();
                }
            }
            sb.appendCodePoint(this.look);
            GetChar();
        }
    }

    public static Area3DPxg parseStructuredReference(String str, FormulaParsingWorkbook formulaParsingWorkbook, int i5) {
        Ptg[] ptgArr = parse(str, formulaParsingWorkbook, FormulaType.CELL, -1, i5);
        if (ptgArr.length == 1) {
            Ptg ptg = ptgArr[0];
            if (ptg instanceof Area3DPxg) {
                return (Area3DPxg) ptg;
            }
        }
        throw new IllegalStateException("Illegal structured reference, had length: " + ptgArr.length);
    }

    private ParseNode parseUnary(boolean z6) {
        boolean z7 = IsDigit(this.look) || this.look == 46;
        ParseNode parseNodePowerFactor = powerFactor();
        if (z7) {
            Ptg token = parseNodePowerFactor.getToken();
            if (token instanceof NumberPtg) {
                if (!z6) {
                    return new ParseNode(new NumberPtg(-((NumberPtg) token).getValue()));
                }
            } else if (token instanceof IntPtg) {
                if (!z6) {
                    return new ParseNode(new NumberPtg(-((IntPtg) token).getValue()));
                }
            }
            return parseNodePowerFactor;
        }
        return new ParseNode(z6 ? UnaryPlusPtg.instance : UnaryMinusPtg.instance, parseNodePowerFactor);
    }

    private String parseUnquotedIdentifier() {
        if (this.look == 39) {
            throw expected("unquoted identifier");
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!Character.isLetterOrDigit(this.look) && this.look != 46) {
                break;
            }
            sb.appendCodePoint(this.look);
            GetChar();
        }
        if (sb.length() < 1) {
            return null;
        }
        return sb.toString();
    }

    private ParseNode percentFactor() {
        ParseNode simpleFactor = parseSimpleFactor();
        while (true) {
            SkipWhite();
            if (this.look != 37) {
                return simpleFactor;
            }
            Match(37);
            simpleFactor = new ParseNode(PercentPtg.instance, simpleFactor);
        }
    }

    private ParseNode powerFactor() {
        ParseNode parseNodePercentFactor = percentFactor();
        while (true) {
            SkipWhite();
            if (this.look != 94) {
                return parseNodePercentFactor;
            }
            Match(94);
            parseNodePercentFactor = new ParseNode(PowerPtg.instance, parseNodePercentFactor, percentFactor());
        }
    }

    private void resetPointer(int i5) {
        this._pointer = i5;
        if (i5 <= this._formulaLength) {
            this.look = this._formulaString.codePointAt(i5 - Character.charCount(this.look));
        } else {
            this.look = 0;
        }
    }

    private ParseNode unionExpression() {
        ParseNode parseNodeIntersectionExpression = intersectionExpression();
        boolean z6 = false;
        while (true) {
            SkipWhite();
            if (this.look != 44) {
                break;
            }
            GetChar();
            z6 = true;
            parseNodeIntersectionExpression = new ParseNode(UnionPtg.instance, parseNodeIntersectionExpression, intersectionExpression());
        }
        return z6 ? augmentWithMemPtg(parseNodeIntersectionExpression) : parseNodeIntersectionExpression;
    }

    private void validateNumArgs(int i5, FunctionMetadata functionMetadata) {
        String str;
        FormulaParsingWorkbook formulaParsingWorkbook;
        String string;
        if (i5 < functionMetadata.getMinParams()) {
            String str2 = "Too few arguments to function '" + functionMetadata.getName() + "'. ";
            if (functionMetadata.hasFixedArgsLength()) {
                StringBuilder sbX = AbstractC0157z.x(str2, "Expected ");
                sbX.append(functionMetadata.getMinParams());
                string = sbX.toString();
            } else {
                StringBuilder sbX2 = AbstractC0157z.x(str2, "At least ");
                sbX2.append(functionMetadata.getMinParams());
                sbX2.append(" were expected");
                string = sbX2.toString();
            }
            throw new FormulaParseException(string + " but got " + i5 + Consts.DOT);
        }
        int maxParams = (!functionMetadata.hasUnlimitedVarags() || (formulaParsingWorkbook = this._book) == null) ? functionMetadata.getMaxParams() : formulaParsingWorkbook.getSpreadsheetVersion().getMaxFunctionArgs();
        if (i5 > maxParams) {
            String str3 = "Too many arguments to function '" + functionMetadata.getName() + "'. ";
            if (functionMetadata.hasFixedArgsLength()) {
                str = str3 + "Expected " + maxParams;
            } else {
                str = str3 + "At most " + maxParams + " were expected";
            }
            throw new FormulaParseException(str + " but got " + i5 + Consts.DOT);
        }
    }

    public static Ptg[] parse(String str, FormulaParsingWorkbook formulaParsingWorkbook, FormulaType formulaType, int i5) {
        return parse(str, formulaParsingWorkbook, formulaType, i5, -1);
    }

    private void parse() {
        this._pointer = 0;
        GetChar();
        this._rootNode = unionExpression();
        if (this._pointer > this._formulaLength) {
            return;
        }
        StringBuilder sb = new StringBuilder("Unused input [");
        sb.append(this._formulaString.substring(this._pointer - 1));
        sb.append("] after attempting to parse the formula [");
        throw new FormulaParseException(AbstractC0157z.s(sb, this._formulaString, "]"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:118:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:122:0x01da A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:123:0x01dc A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:127:0x01e7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:128:0x01e9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:130:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:132:0x01f1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:133:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:135:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:137:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:138:0x0200 A[DONT_INVERT, PHI: r7
  0x0200: PHI (r7v7 int) = (r7v6 int), (r7v8 int) binds: [B:131:0x01ef, B:137:0x01ff] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:139:0x0202 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:141:0x0206 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:142:0x0208 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:145:0x020e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:146:0x0210 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:150:0x0226 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:151:0x0228  */
    /* JADX WARN: Code duplicated, block: B:152:0x022b  */
    /* JADX WARN: Code duplicated, block: B:154:0x0233  */
    /* JADX WARN: Code duplicated, block: B:157:0x023f  */
    /* JADX WARN: Code duplicated, block: B:167:0x0283  */
    /* JADX WARN: Code duplicated, block: B:178:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:182:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:184:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:193:0x009e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:194:0x0060 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:38:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:44:0x00bd A[LOOP:0: B:7:0x0035->B:44:0x00bd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x014f  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private ParseNode parseStructuredReference(String str) {
        byte b;
        int i5;
        int i6;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        int i7;
        boolean z10;
        boolean z11;
        String asColumnQuantifier;
        int i8;
        int i9;
        String str2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        byte b6;
        if (this._ssVersion.equals(SpreadsheetVersion.EXCEL2007)) {
            Table table = this._book.getTable(str);
            if (table != null) {
                String sheetName = table.getSheetName();
                int startColIndex = table.getStartColIndex();
                int endColIndex = table.getEndColIndex();
                int startRowIndex = table.getStartRowIndex();
                int endRowIndex = table.getEndRowIndex();
                int i15 = this._pointer;
                GetChar();
                int i16 = 0;
                boolean z12 = false;
                boolean z13 = false;
                boolean z14 = false;
                boolean z15 = false;
                boolean z16 = false;
                while (true) {
                    int i17 = this._pointer;
                    String asSpecialQuantifier = parseAsSpecialQuantifier();
                    b = 4;
                    i5 = startColIndex;
                    i6 = endColIndex;
                    int i18 = i16;
                    z6 = z12;
                    z7 = z13;
                    z8 = z14;
                    z9 = z15;
                    if (asSpecialQuantifier == null) {
                        resetPointer(i17);
                        i7 = i18;
                    } else {
                        switch (asSpecialQuantifier.hashCode()) {
                            case -1835006106:
                                if (asSpecialQuantifier.equals(specHeaders)) {
                                    b6 = 0;
                                }
                                switch (b6) {
                                    case 0:
                                        z9 = true;
                                        break;
                                    case 1:
                                        z6 = true;
                                        break;
                                    case 2:
                                        z16 = true;
                                        break;
                                    case 3:
                                        z8 = true;
                                        break;
                                    case 4:
                                        z7 = true;
                                        break;
                                    default:
                                        throw new FormulaParseException("Unknown special quantifier ".concat(asSpecialQuantifier));
                                }
                                i7 = i18 + 1;
                                if (this.look == 44) {
                                    GetChar();
                                    i16 = i7;
                                    startColIndex = i5;
                                    endColIndex = i6;
                                    z12 = z6;
                                    z13 = z7;
                                    z14 = z8;
                                    z15 = z9;
                                }
                                break;
                            case -1784055345:
                                if (asSpecialQuantifier.equals(specTotals)) {
                                    b6 = 1;
                                }
                                switch (b6) {
                                    case 0:
                                        z9 = true;
                                        break;
                                    case 1:
                                        z6 = true;
                                        break;
                                    case 2:
                                        z16 = true;
                                        break;
                                    case 3:
                                        z8 = true;
                                        break;
                                    case 4:
                                        z7 = true;
                                        break;
                                    default:
                                        throw new FormulaParseException("Unknown special quantifier ".concat(asSpecialQuantifier));
                                }
                                i7 = i18 + 1;
                                if (this.look == 44) {
                                    GetChar();
                                    i16 = i7;
                                    startColIndex = i5;
                                    endColIndex = i6;
                                    z12 = z6;
                                    z13 = z7;
                                    z14 = z8;
                                    z15 = z9;
                                }
                                break;
                            case 65921:
                                if (asSpecialQuantifier.equals(specAll)) {
                                    b6 = 2;
                                }
                                switch (b6) {
                                    case 0:
                                        z9 = true;
                                        break;
                                    case 1:
                                        z6 = true;
                                        break;
                                    case 2:
                                        z16 = true;
                                        break;
                                    case 3:
                                        z8 = true;
                                        break;
                                    case 4:
                                        z7 = true;
                                        break;
                                    default:
                                        throw new FormulaParseException("Unknown special quantifier ".concat(asSpecialQuantifier));
                                }
                                i7 = i18 + 1;
                                if (this.look == 44) {
                                    GetChar();
                                    i16 = i7;
                                    startColIndex = i5;
                                    endColIndex = i6;
                                    z12 = z6;
                                    z13 = z7;
                                    z14 = z8;
                                    z15 = z9;
                                }
                                break;
                            case 2122698:
                                if (asSpecialQuantifier.equals(specData)) {
                                    b6 = 3;
                                }
                                switch (b6) {
                                    case 0:
                                        z9 = true;
                                        break;
                                    case 1:
                                        z6 = true;
                                        break;
                                    case 2:
                                        z16 = true;
                                        break;
                                    case 3:
                                        z8 = true;
                                        break;
                                    case 4:
                                        z7 = true;
                                        break;
                                    default:
                                        throw new FormulaParseException("Unknown special quantifier ".concat(asSpecialQuantifier));
                                }
                                i7 = i18 + 1;
                                if (this.look == 44) {
                                    GetChar();
                                    i16 = i7;
                                    startColIndex = i5;
                                    endColIndex = i6;
                                    z12 = z6;
                                    z13 = z7;
                                    z14 = z8;
                                    z15 = z9;
                                }
                                break;
                            case 1291583832:
                                if (asSpecialQuantifier.equals(specThisRow)) {
                                    b6 = 4;
                                }
                                switch (b6) {
                                    case 0:
                                        z9 = true;
                                        break;
                                    case 1:
                                        z6 = true;
                                        break;
                                    case 2:
                                        z16 = true;
                                        break;
                                    case 3:
                                        z8 = true;
                                        break;
                                    case 4:
                                        z7 = true;
                                        break;
                                    default:
                                        throw new FormulaParseException("Unknown special quantifier ".concat(asSpecialQuantifier));
                                }
                                i7 = i18 + 1;
                                if (this.look == 44) {
                                    GetChar();
                                    i16 = i7;
                                    startColIndex = i5;
                                    endColIndex = i6;
                                    z12 = z6;
                                    z13 = z7;
                                    z14 = z8;
                                    z15 = z9;
                                }
                                break;
                        }
                        b6 = -1;
                        switch (b6) {
                            case 0:
                                z9 = true;
                                break;
                            case 1:
                                z6 = true;
                                break;
                            case 2:
                                z16 = true;
                                break;
                            case 3:
                                z8 = true;
                                break;
                            case 4:
                                z7 = true;
                                break;
                            default:
                                throw new FormulaParseException("Unknown special quantifier ".concat(asSpecialQuantifier));
                        }
                        i7 = i18 + 1;
                        if (this.look == 44) {
                            GetChar();
                            i16 = i7;
                            startColIndex = i5;
                            endColIndex = i6;
                            z12 = z6;
                            z13 = z7;
                            z14 = z8;
                            z15 = z9;
                        }
                    }
                }
                boolean z17 = z9;
                SkipWhite();
                int i19 = i7;
                if (this.look == 64) {
                    GetChar();
                    z10 = true;
                } else {
                    z10 = false;
                }
                int i20 = this._pointer;
                String asColumnQuantifier2 = parseAsColumnQuantifier();
                boolean z18 = z10;
                if (asColumnQuantifier2 == null) {
                    resetPointer(i20);
                    z11 = z17;
                    asColumnQuantifier = null;
                    i8 = 0;
                } else {
                    int i21 = this.look;
                    z11 = z17;
                    if (i21 == 44) {
                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal: you should not use ',' with column quantifiers"));
                    }
                    if (i21 == 58) {
                        GetChar();
                        asColumnQuantifier = parseAsColumnQuantifier();
                        if (asColumnQuantifier == null) {
                            throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal: the string after ':' must be column quantifier"));
                        }
                        i8 = 2;
                    } else {
                        asColumnQuantifier = null;
                        i8 = 1;
                    }
                }
                if (i8 == 0 && i19 == 0) {
                    resetPointer(i15);
                    int i22 = this._pointer;
                    asColumnQuantifier2 = parseAsColumnQuantifier();
                    if (asColumnQuantifier2 != null) {
                        i8++;
                    } else {
                        resetPointer(i22);
                        String asSpecialQuantifier2 = parseAsSpecialQuantifier();
                        if (asSpecialQuantifier2 != null) {
                            switch (asSpecialQuantifier2.hashCode()) {
                                case -1835006106:
                                    if (!asSpecialQuantifier2.equals(specHeaders)) {
                                        b = -1;
                                    } else {
                                        b = 0;
                                    }
                                    break;
                                case -1784055345:
                                    if (!asSpecialQuantifier2.equals(specTotals)) {
                                        b = -1;
                                    } else {
                                        b = 1;
                                    }
                                    break;
                                case 65921:
                                    if (!asSpecialQuantifier2.equals(specAll)) {
                                        b = -1;
                                    } else {
                                        b = 2;
                                    }
                                    break;
                                case 2122698:
                                    if (!asSpecialQuantifier2.equals(specData)) {
                                        b = -1;
                                    } else {
                                        b = 3;
                                    }
                                    break;
                                case 1291583832:
                                    if (!asSpecialQuantifier2.equals(specThisRow)) {
                                        b = -1;
                                    }
                                    break;
                                default:
                                    b = -1;
                                    break;
                            }
                            switch (b) {
                                case 0:
                                    z11 = true;
                                    break;
                                case 1:
                                    z6 = true;
                                    break;
                                case 2:
                                    z16 = true;
                                    break;
                                case 3:
                                    z8 = true;
                                    break;
                                case 4:
                                    z7 = true;
                                    break;
                                default:
                                    throw new FormulaParseException("Unknown special quantifier ".concat(asSpecialQuantifier2));
                            }
                            i9 = i19 + 1;
                        } else {
                            throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                        }
                    }
                    str2 = asColumnQuantifier2;
                    if (!z6 && table.getTotalsRowCount() == 0) {
                        return new ParseNode(ErrPtg.REF_INVALID);
                    }
                    if ((!z18 || z7) && ((i10 = this._rowIndex) < startRowIndex || endRowIndex < i10)) {
                        if (i10 >= 0) {
                            return new ParseNode(ErrPtg.VALUE_INVALID);
                        }
                        throw new FormulaParseException("Formula contained [#This Row] or [@] structured reference but this row < 0. Row index must be specified for row-referencing structured references.");
                    }
                    if (i9 > 0) {
                        if (i9 == 1 || !z16) {
                            if (z8 || !z11) {
                                if (z8 || !z6) {
                                    i14 = 1;
                                    if (i9 != 1) {
                                        if (i9 != i14 && z11) {
                                            endRowIndex = startRowIndex;
                                        } else if (i9 != i14 && z6) {
                                            startRowIndex = endRowIndex;
                                        } else if ((i9 != i14 && z7) || z18) {
                                            startRowIndex = this._rowIndex;
                                            endRowIndex = startRowIndex;
                                        } else {
                                            throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                        }
                                    } else if (z8) {
                                        startRowIndex++;
                                        if (table.getTotalsRowCount() > 0) {
                                            i11 = endRowIndex - 1;
                                            endRowIndex = i11;
                                        }
                                    } else {
                                        i14 = 1;
                                        if (i9 != i14) {
                                            if (i9 != i14) {
                                            }
                                            if (i9 != i14) {
                                                throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                            }
                                            throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                            startRowIndex = this._rowIndex;
                                            endRowIndex = startRowIndex;
                                        } else {
                                            if (i9 != i14) {
                                            }
                                            if (i9 != i14) {
                                                throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                            }
                                            throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                            startRowIndex = this._rowIndex;
                                            endRowIndex = startRowIndex;
                                        }
                                    }
                                } else {
                                    startRowIndex++;
                                }
                            } else if (table.getTotalsRowCount() > 0) {
                                endRowIndex--;
                            }
                        }
                    } else if (z18) {
                        startRowIndex = this._rowIndex;
                        endRowIndex = startRowIndex;
                    } else {
                        startRowIndex++;
                        if (table.getTotalsRowCount() > 0) {
                            i11 = endRowIndex - 1;
                            endRowIndex = i11;
                        }
                    }
                    if (i8 == 2) {
                        if (str2 == null && asColumnQuantifier != null) {
                            int iFindColumnIndex = table.findColumnIndex(str2);
                            int iFindColumnIndex2 = table.findColumnIndex(asColumnQuantifier);
                            if (iFindColumnIndex == -1 || iFindColumnIndex2 == -1) {
                                StringBuilder sbU = androidx.collection.a.u("One of the columns ", str2, ", ", asColumnQuantifier, " doesn't exist in table ");
                                sbU.append(table.getName());
                                throw new FormulaParseException(sbU.toString());
                            }
                            i12 = i5 + iFindColumnIndex;
                            i13 = i5 + iFindColumnIndex2;
                        } else {
                            StringBuilder sbU2 = androidx.collection.a.u("Cannot parse column: ", str2, " and ", asColumnQuantifier, " with formula ");
                            sbU2.append(this._formulaString);
                            throw new IllegalStateException(sbU2.toString());
                        }
                    } else if (i8 == 1 || z18) {
                        i12 = i5;
                        i13 = i6;
                    } else if (str2 != null) {
                        int iFindColumnIndex3 = table.findColumnIndex(str2);
                        if (iFindColumnIndex3 == -1) {
                            StringBuilder sbY = AbstractC0157z.y("The column ", str2, " doesn't exist in table ");
                            sbY.append(table.getName());
                            throw new FormulaParseException(sbY.toString());
                        }
                        i12 = i5 + iFindColumnIndex3;
                        i13 = i12;
                    } else {
                        StringBuilder sbY2 = AbstractC0157z.y("Cannot parse column: ", str2, " with formula ");
                        sbY2.append(this._formulaString);
                        throw new IllegalStateException(sbY2.toString());
                    }
                    return new ParseNode(this._book.get3DReferencePtg(new AreaReference(new CellReference(startRowIndex, i12), new CellReference(endRowIndex, i13), this._ssVersion), new SheetIdentifier(null, new NameIdentifier(sheetName, true))));
                }
                Match(93);
                i9 = i19;
                str2 = asColumnQuantifier2;
                if (!z6) {
                }
                if (z18) {
                    if (i10 >= 0) {
                        return new ParseNode(ErrPtg.VALUE_INVALID);
                    }
                    throw new FormulaParseException("Formula contained [#This Row] or [@] structured reference but this row < 0. Row index must be specified for row-referencing structured references.");
                }
                if (i10 >= 0) {
                    return new ParseNode(ErrPtg.VALUE_INVALID);
                }
                throw new FormulaParseException("Formula contained [#This Row] or [@] structured reference but this row < 0. Row index must be specified for row-referencing structured references.");
                if (i9 > 0) {
                    if (i9 == 1) {
                        if (z8) {
                            if (z8) {
                                i14 = 1;
                                if (i9 != 1) {
                                    if (i9 != i14) {
                                        if (i9 != i14) {
                                        }
                                        if (i9 != i14) {
                                            throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                        }
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                        startRowIndex = this._rowIndex;
                                        endRowIndex = startRowIndex;
                                    } else {
                                        if (i9 != i14) {
                                        }
                                        if (i9 != i14) {
                                            throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                        }
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                        startRowIndex = this._rowIndex;
                                        endRowIndex = startRowIndex;
                                    }
                                } else if (z8) {
                                    startRowIndex++;
                                    if (table.getTotalsRowCount() > 0) {
                                        i11 = endRowIndex - 1;
                                        endRowIndex = i11;
                                    }
                                } else {
                                    i14 = 1;
                                    if (i9 != i14) {
                                        if (i9 != i14) {
                                        }
                                        if (i9 != i14) {
                                            throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                        }
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                        startRowIndex = this._rowIndex;
                                        endRowIndex = startRowIndex;
                                    } else {
                                        if (i9 != i14) {
                                        }
                                        if (i9 != i14) {
                                            throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                        }
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                        startRowIndex = this._rowIndex;
                                        endRowIndex = startRowIndex;
                                    }
                                }
                            } else {
                                i14 = 1;
                                if (i9 != 1) {
                                    if (i9 != i14) {
                                        if (i9 != i14) {
                                        }
                                        if (i9 != i14) {
                                            throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                        }
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                        startRowIndex = this._rowIndex;
                                        endRowIndex = startRowIndex;
                                    } else {
                                        if (i9 != i14) {
                                        }
                                        if (i9 != i14) {
                                            throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                        }
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                        startRowIndex = this._rowIndex;
                                        endRowIndex = startRowIndex;
                                    }
                                } else if (z8) {
                                    startRowIndex++;
                                    if (table.getTotalsRowCount() > 0) {
                                        i11 = endRowIndex - 1;
                                        endRowIndex = i11;
                                    }
                                } else {
                                    i14 = 1;
                                    if (i9 != i14) {
                                        if (i9 != i14) {
                                        }
                                        if (i9 != i14) {
                                            throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                        }
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                        startRowIndex = this._rowIndex;
                                        endRowIndex = startRowIndex;
                                    } else {
                                        if (i9 != i14) {
                                        }
                                        if (i9 != i14) {
                                            throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                        }
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                        startRowIndex = this._rowIndex;
                                        endRowIndex = startRowIndex;
                                    }
                                }
                            }
                        } else if (z8) {
                            i14 = 1;
                            if (i9 != 1) {
                                if (i9 != i14) {
                                    if (i9 != i14) {
                                    }
                                    if (i9 != i14) {
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    }
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    startRowIndex = this._rowIndex;
                                    endRowIndex = startRowIndex;
                                } else {
                                    if (i9 != i14) {
                                    }
                                    if (i9 != i14) {
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    }
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    startRowIndex = this._rowIndex;
                                    endRowIndex = startRowIndex;
                                }
                            } else if (z8) {
                                startRowIndex++;
                                if (table.getTotalsRowCount() > 0) {
                                    i11 = endRowIndex - 1;
                                    endRowIndex = i11;
                                }
                            } else {
                                i14 = 1;
                                if (i9 != i14) {
                                    if (i9 != i14) {
                                    }
                                    if (i9 != i14) {
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    }
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    startRowIndex = this._rowIndex;
                                    endRowIndex = startRowIndex;
                                } else {
                                    if (i9 != i14) {
                                    }
                                    if (i9 != i14) {
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    }
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    startRowIndex = this._rowIndex;
                                    endRowIndex = startRowIndex;
                                }
                            }
                        } else {
                            i14 = 1;
                            if (i9 != 1) {
                                if (i9 != i14) {
                                    if (i9 != i14) {
                                    }
                                    if (i9 != i14) {
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    }
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    startRowIndex = this._rowIndex;
                                    endRowIndex = startRowIndex;
                                } else {
                                    if (i9 != i14) {
                                    }
                                    if (i9 != i14) {
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    }
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    startRowIndex = this._rowIndex;
                                    endRowIndex = startRowIndex;
                                }
                            } else if (z8) {
                                startRowIndex++;
                                if (table.getTotalsRowCount() > 0) {
                                    i11 = endRowIndex - 1;
                                    endRowIndex = i11;
                                }
                            } else {
                                i14 = 1;
                                if (i9 != i14) {
                                    if (i9 != i14) {
                                    }
                                    if (i9 != i14) {
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    }
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    startRowIndex = this._rowIndex;
                                    endRowIndex = startRowIndex;
                                } else {
                                    if (i9 != i14) {
                                    }
                                    if (i9 != i14) {
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    }
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    startRowIndex = this._rowIndex;
                                    endRowIndex = startRowIndex;
                                }
                            }
                        }
                    } else if (z8) {
                        if (z8) {
                            i14 = 1;
                            if (i9 != 1) {
                                if (i9 != i14) {
                                    if (i9 != i14) {
                                    }
                                    if (i9 != i14) {
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    }
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    startRowIndex = this._rowIndex;
                                    endRowIndex = startRowIndex;
                                } else {
                                    if (i9 != i14) {
                                    }
                                    if (i9 != i14) {
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    }
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    startRowIndex = this._rowIndex;
                                    endRowIndex = startRowIndex;
                                }
                            } else if (z8) {
                                startRowIndex++;
                                if (table.getTotalsRowCount() > 0) {
                                    i11 = endRowIndex - 1;
                                    endRowIndex = i11;
                                }
                            } else {
                                i14 = 1;
                                if (i9 != i14) {
                                    if (i9 != i14) {
                                    }
                                    if (i9 != i14) {
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    }
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    startRowIndex = this._rowIndex;
                                    endRowIndex = startRowIndex;
                                } else {
                                    if (i9 != i14) {
                                    }
                                    if (i9 != i14) {
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    }
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    startRowIndex = this._rowIndex;
                                    endRowIndex = startRowIndex;
                                }
                            }
                        } else {
                            i14 = 1;
                            if (i9 != 1) {
                                if (i9 != i14) {
                                    if (i9 != i14) {
                                    }
                                    if (i9 != i14) {
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    }
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    startRowIndex = this._rowIndex;
                                    endRowIndex = startRowIndex;
                                } else {
                                    if (i9 != i14) {
                                    }
                                    if (i9 != i14) {
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    }
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    startRowIndex = this._rowIndex;
                                    endRowIndex = startRowIndex;
                                }
                            } else if (z8) {
                                startRowIndex++;
                                if (table.getTotalsRowCount() > 0) {
                                    i11 = endRowIndex - 1;
                                    endRowIndex = i11;
                                }
                            } else {
                                i14 = 1;
                                if (i9 != i14) {
                                    if (i9 != i14) {
                                    }
                                    if (i9 != i14) {
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    }
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    startRowIndex = this._rowIndex;
                                    endRowIndex = startRowIndex;
                                } else {
                                    if (i9 != i14) {
                                    }
                                    if (i9 != i14) {
                                        throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    }
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                    startRowIndex = this._rowIndex;
                                    endRowIndex = startRowIndex;
                                }
                            }
                        }
                    } else if (z8) {
                        i14 = 1;
                        if (i9 != 1) {
                            if (i9 != i14) {
                                if (i9 != i14) {
                                }
                                if (i9 != i14) {
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                }
                                throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                startRowIndex = this._rowIndex;
                                endRowIndex = startRowIndex;
                            } else {
                                if (i9 != i14) {
                                }
                                if (i9 != i14) {
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                }
                                throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                startRowIndex = this._rowIndex;
                                endRowIndex = startRowIndex;
                            }
                        } else if (z8) {
                            startRowIndex++;
                            if (table.getTotalsRowCount() > 0) {
                                i11 = endRowIndex - 1;
                                endRowIndex = i11;
                            }
                        } else {
                            i14 = 1;
                            if (i9 != i14) {
                                if (i9 != i14) {
                                }
                                if (i9 != i14) {
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                }
                                throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                startRowIndex = this._rowIndex;
                                endRowIndex = startRowIndex;
                            } else {
                                if (i9 != i14) {
                                }
                                if (i9 != i14) {
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                }
                                throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                startRowIndex = this._rowIndex;
                                endRowIndex = startRowIndex;
                            }
                        }
                    } else {
                        i14 = 1;
                        if (i9 != 1) {
                            if (i9 != i14) {
                                if (i9 != i14) {
                                }
                                if (i9 != i14) {
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                }
                                throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                startRowIndex = this._rowIndex;
                                endRowIndex = startRowIndex;
                            } else {
                                if (i9 != i14) {
                                }
                                if (i9 != i14) {
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                }
                                throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                startRowIndex = this._rowIndex;
                                endRowIndex = startRowIndex;
                            }
                        } else if (z8) {
                            startRowIndex++;
                            if (table.getTotalsRowCount() > 0) {
                                i11 = endRowIndex - 1;
                                endRowIndex = i11;
                            }
                        } else {
                            i14 = 1;
                            if (i9 != i14) {
                                if (i9 != i14) {
                                }
                                if (i9 != i14) {
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                }
                                throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                startRowIndex = this._rowIndex;
                                endRowIndex = startRowIndex;
                            } else {
                                if (i9 != i14) {
                                }
                                if (i9 != i14) {
                                    throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                }
                                throw new FormulaParseException(AbstractC0157z.s(new StringBuilder("The formula "), this._formulaString, " is illegal"));
                                startRowIndex = this._rowIndex;
                                endRowIndex = startRowIndex;
                            }
                        }
                    }
                } else if (z18) {
                    startRowIndex = this._rowIndex;
                    endRowIndex = startRowIndex;
                } else {
                    startRowIndex++;
                    if (table.getTotalsRowCount() > 0) {
                        i11 = endRowIndex - 1;
                        endRowIndex = i11;
                    }
                }
                if (i8 == 2) {
                    if (str2 == null) {
                    }
                    StringBuilder sbU3 = androidx.collection.a.u("Cannot parse column: ", str2, " and ", asColumnQuantifier, " with formula ");
                    sbU3.append(this._formulaString);
                    throw new IllegalStateException(sbU3.toString());
                }
                if (i8 == 1) {
                    i12 = i5;
                    i13 = i6;
                } else {
                    i12 = i5;
                    i13 = i6;
                }
                return new ParseNode(this._book.get3DReferencePtg(new AreaReference(new CellReference(startRowIndex, i12), new CellReference(endRowIndex, i13), this._ssVersion), new SheetIdentifier(null, new NameIdentifier(sheetName, true))));
            }
            throw new FormulaParseException(AbstractC0157z.o("Illegal table name: '", str, "'"));
        }
        throw new FormulaParseException("Structured references work only on XSSF (Excel 2007+)!");
    }
}
