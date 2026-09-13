package org.apache.poi.ss.formula.atp;

import A3.AbstractC0157z;
import androidx.collection.a;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.NotImplementedFunctionException;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
import org.apache.poi.ss.formula.functions.AverageIf;
import org.apache.poi.ss.formula.functions.Averageifs;
import org.apache.poi.ss.formula.functions.BesselJ;
import org.apache.poi.ss.formula.functions.Bin2Dec;
import org.apache.poi.ss.formula.functions.CeilingMath;
import org.apache.poi.ss.formula.functions.CeilingPrecise;
import org.apache.poi.ss.formula.functions.Complex;
import org.apache.poi.ss.formula.functions.Countifs;
import org.apache.poi.ss.formula.functions.Covar;
import org.apache.poi.ss.formula.functions.Days;
import org.apache.poi.ss.formula.functions.Dec2Bin;
import org.apache.poi.ss.formula.functions.Dec2Hex;
import org.apache.poi.ss.formula.functions.Delta;
import org.apache.poi.ss.formula.functions.DollarDe;
import org.apache.poi.ss.formula.functions.DollarFr;
import org.apache.poi.ss.formula.functions.EDate;
import org.apache.poi.ss.formula.functions.EOMonth;
import org.apache.poi.ss.formula.functions.FactDouble;
import org.apache.poi.ss.formula.functions.FloorMath;
import org.apache.poi.ss.formula.functions.FloorPrecise;
import org.apache.poi.ss.formula.functions.Forecast;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.functions.Gcd;
import org.apache.poi.ss.formula.functions.Hex2Dec;
import org.apache.poi.ss.formula.functions.ImReal;
import org.apache.poi.ss.formula.functions.Imaginary;
import org.apache.poi.ss.formula.functions.Lcm;
import org.apache.poi.ss.formula.functions.Maxifs;
import org.apache.poi.ss.formula.functions.Minifs;
import org.apache.poi.ss.formula.functions.NormDist;
import org.apache.poi.ss.formula.functions.NormInv;
import org.apache.poi.ss.formula.functions.NormSDist;
import org.apache.poi.ss.formula.functions.NormSInv;
import org.apache.poi.ss.formula.functions.NumberValueFunction;
import org.apache.poi.ss.formula.functions.Oct2Dec;
import org.apache.poi.ss.formula.functions.Poisson;
import org.apache.poi.ss.formula.functions.Quotient;
import org.apache.poi.ss.formula.functions.Single;
import org.apache.poi.ss.formula.functions.Sqrtpi;
import org.apache.poi.ss.formula.functions.Sumifs;
import org.apache.poi.ss.formula.functions.TDist2t;
import org.apache.poi.ss.formula.functions.TDistLt;
import org.apache.poi.ss.formula.functions.TDistRt;
import org.apache.poi.ss.formula.functions.TextFunction;
import org.apache.poi.ss.formula.functions.WeekNum;
import org.apache.poi.ss.formula.udf.UDFFinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class AnalysisToolPak implements UDFFinder {
    public static final UDFFinder instance = new AnalysisToolPak();
    private final Map<String, FreeRefFunction> _functionsByName = createFunctionsMap();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class NotImplemented implements FreeRefFunction {
        private final String _functionName;

        public NotImplemented(String str) {
            this._functionName = str;
        }

        @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
        public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
            throw new NotImplementedFunctionException(this._functionName);
        }
    }

    private AnalysisToolPak() {
    }

    private Map<String, FreeRefFunction> createFunctionsMap() {
        HashMap map = new HashMap(127);
        r(map, "ACCRINT", null);
        r(map, "ACCRINTM", null);
        r(map, "AMORDEGRC", null);
        r(map, "AMORLINC", null);
        r(map, "AVERAGEIF", AverageIf.instance);
        r(map, "AVERAGEIFS", Averageifs.instance);
        r(map, "BAHTTEXT", null);
        r(map, "BESSELI", null);
        r(map, "BESSELJ", BesselJ.instance);
        r(map, "BESSELK", null);
        r(map, "BESSELY", null);
        r(map, "BIN2DEC", Bin2Dec.instance);
        r(map, "BIN2HEX", null);
        r(map, "BIN2OCT", null);
        r(map, "COMPLEX", Complex.instance);
        r(map, "CEILING.MATH", CeilingMath.instance);
        r(map, "CEILING.PRECISE", CeilingPrecise.instance);
        r(map, "CONCAT", TextFunction.CONCAT);
        r(map, "CONVERT", null);
        r(map, "COUNTIFS", Countifs.instance);
        r(map, "COUPDAYBS", null);
        r(map, "COUPDAYS", null);
        r(map, "COUPDAYSNC", null);
        r(map, "COUPNCD", null);
        r(map, "COUPNUM", null);
        r(map, "COUPPCD", null);
        r(map, "COVARIANCE.P", Covar.instanceP);
        r(map, "COVARIANCE.S", Covar.instanceS);
        r(map, "CUBEKPIMEMBER", null);
        r(map, "CUBEMEMBER", null);
        r(map, "CUBEMEMBERPROPERTY", null);
        r(map, "CUBERANKEDMEMBER", null);
        r(map, "CUBESET", null);
        r(map, "CUBESETCOUNT", null);
        r(map, "CUBEVALUE", null);
        r(map, "CUMIPMT", null);
        r(map, "CUMPRINC", null);
        r(map, "DAYS", Days.instance);
        r(map, "DEC2BIN", Dec2Bin.instance);
        r(map, "DEC2HEX", Dec2Hex.instance);
        r(map, "DEC2OCT", null);
        r(map, "DELTA", Delta.instance);
        r(map, "DISC", null);
        r(map, "DOLLARDE", DollarDe.instance);
        r(map, "DOLLARFR", DollarFr.instance);
        r(map, "DURATION", null);
        r(map, "EDATE", EDate.instance);
        r(map, "EFFECT", null);
        r(map, "EOMONTH", EOMonth.instance);
        r(map, "ERF", null);
        r(map, "ERFC", null);
        r(map, "FACTDOUBLE", FactDouble.instance);
        r(map, "FLOOR.MATH", FloorMath.instance);
        r(map, "FLOOR.PRECISE", FloorPrecise.instance);
        r(map, "FORECAST.LINEAR", Forecast.instance);
        r(map, "FVSCHEDULE", null);
        r(map, "GCD", Gcd.instance);
        r(map, "GESTEP", null);
        r(map, "HEX2BIN", null);
        r(map, "HEX2DEC", Hex2Dec.instance);
        r(map, "HEX2OCT", null);
        r(map, "IFERROR", IfError.instance);
        r(map, "IFNA", IfNa.instance);
        r(map, "IFS", Ifs.instance);
        r(map, "IMABS", null);
        r(map, "IMAGINARY", Imaginary.instance);
        r(map, "IMARGUMENT", null);
        r(map, "IMCONJUGATE", null);
        r(map, "IMCOS", null);
        r(map, "IMDIV", null);
        r(map, "IMEXP", null);
        r(map, "IMLN", null);
        r(map, "IMLOG10", null);
        r(map, "IMLOG2", null);
        r(map, "IMPOWER", null);
        r(map, "IMPRODUCT", null);
        r(map, "IMREAL", ImReal.instance);
        r(map, "IMSIN", null);
        r(map, "IMSQRT", null);
        r(map, "IMSUB", null);
        r(map, "IMSUM", null);
        r(map, "INTRATE", null);
        r(map, "ISEVEN", ParityFunction.IS_EVEN);
        r(map, "ISODD", ParityFunction.IS_ODD);
        r(map, "JIS", null);
        r(map, "LCM", Lcm.instance);
        r(map, "MAXIFS", Maxifs.instance);
        r(map, "MDURATION", null);
        r(map, "MINIFS", Minifs.instance);
        r(map, "MROUND", MRound.instance);
        r(map, "MULTINOMIAL", null);
        r(map, "NETWORKDAYS", NetworkdaysFunction.instance);
        r(map, "NOMINAL", null);
        r(map, "NORM.DIST", NormDist.instance);
        r(map, "NORM.S.DIST", NormSDist.instance);
        r(map, "NORM.INV", NormInv.instance);
        r(map, "NORM.S.INV", NormSInv.instance);
        r(map, "NUMBERVALUE", NumberValueFunction.instance);
        r(map, "OCT2BIN", null);
        r(map, "OCT2DEC", Oct2Dec.instance);
        r(map, "OCT2HEX", null);
        r(map, "ODDFPRICE", null);
        r(map, "ODDFYIELD", null);
        r(map, "ODDLPRICE", null);
        r(map, "ODDLYIELD", null);
        r(map, "PERCENTRANK.EXC", PercentRankExcFunction.instance);
        r(map, "PERCENTRANK.INC", PercentRankIncFunction.instance);
        r(map, "POISSON.DIST", Poisson.instance);
        r(map, "PRICE", null);
        r(map, "PRICEDISC", null);
        r(map, "PRICEMAT", null);
        r(map, "QUOTIENT", Quotient.instance);
        r(map, "RANDBETWEEN", RandBetween.instance);
        r(map, "RECEIVED", null);
        r(map, "RTD", null);
        r(map, "SERIESSUM", null);
        r(map, "SINGLE", Single.instance);
        r(map, "SQRTPI", Sqrtpi.instance);
        r(map, "STDEV.S", Stdevs.instance);
        r(map, "STDEV.P", Stdevp.instance);
        r(map, "SUMIFS", Sumifs.instance);
        r(map, "SWITCH", Switch.instance);
        r(map, "TBILLEQ", null);
        r(map, "TBILLPRICE", null);
        r(map, "TBILLYIELD", null);
        r(map, "T.DIST", TDistLt.instance);
        r(map, "T.DIST.2T", TDist2t.instance);
        r(map, "T.DIST.RT", TDistRt.instance);
        r(map, "TEXTJOIN", TextJoinFunction.instance);
        r(map, "WEEKNUM", WeekNum.instance);
        r(map, "WORKDAY", WorkdayFunction.instance);
        r(map, "WORKDAY.INTL", WorkdayIntlFunction.instance);
        r(map, "XIRR", null);
        r(map, "XLOOKUP", XLookupFunction.instance);
        r(map, "XMATCH", XMatchFunction.instance);
        r(map, "XNPV", null);
        r(map, "YEARFRAC", YearFrac.instance);
        r(map, "YIELD", null);
        r(map, "YIELDDISC", null);
        r(map, "YIELDMAT", null);
        r(map, "VAR.S", Vars.instance);
        r(map, "VAR.P", Varp.instance);
        return map;
    }

    public static Collection<String> getNotSupportedFunctionNames() {
        AnalysisToolPak analysisToolPak = (AnalysisToolPak) instance;
        TreeSet treeSet = new TreeSet();
        for (Map.Entry<String, FreeRefFunction> entry : analysisToolPak._functionsByName.entrySet()) {
            if (entry.getValue() instanceof NotImplemented) {
                treeSet.add(entry.getKey());
            }
        }
        return Collections.unmodifiableCollection(treeSet);
    }

    public static Collection<String> getSupportedFunctionNames() {
        AnalysisToolPak analysisToolPak = (AnalysisToolPak) instance;
        TreeSet treeSet = new TreeSet();
        for (Map.Entry<String, FreeRefFunction> entry : analysisToolPak._functionsByName.entrySet()) {
            FreeRefFunction value = entry.getValue();
            if (value != null && !(value instanceof NotImplemented)) {
                treeSet.add(entry.getKey());
            }
        }
        return Collections.unmodifiableCollection(treeSet);
    }

    public static boolean isATPFunction(String str) {
        return ((AnalysisToolPak) instance)._functionsByName.containsKey(str);
    }

    private static void r(Map<String, FreeRefFunction> map, String str, FreeRefFunction freeRefFunction) {
        if (freeRefFunction == null) {
            freeRefFunction = new NotImplemented(str);
        }
        map.put(str, freeRefFunction);
    }

    public static void registerFunction(String str, FreeRefFunction freeRefFunction) {
        AnalysisToolPak analysisToolPak = (AnalysisToolPak) instance;
        if (!isATPFunction(str)) {
            if (FunctionMetadataRegistry.getFunctionByName(str) == null) {
                throw new IllegalArgumentException(a.n(str, " is not a function from the Excel Analysis Toolpack."));
            }
            throw new IllegalArgumentException(a.n(str, " is a built-in Excel function. Use FunctionEval.registerFunction(String name, Function func) instead."));
        }
        FreeRefFunction freeRefFunctionFindFunction = analysisToolPak.findFunction(str);
        if (freeRefFunctionFindFunction != null && !(freeRefFunctionFindFunction instanceof NotImplemented)) {
            throw new IllegalArgumentException(AbstractC0157z.o("POI already implements ", str, ". You cannot override POI's implementations of Excel functions"));
        }
        analysisToolPak._functionsByName.put(str, freeRefFunction);
    }

    @Override // org.apache.poi.ss.formula.udf.UDFFinder
    public FreeRefFunction findFunction(String str) {
        if (str.startsWith("_xlfn.")) {
            str = str.substring(6);
        }
        return this._functionsByName.get(str.toUpperCase(Locale.ROOT));
    }
}
