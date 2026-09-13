package org.apache.poi.ss.usermodel;

import A3.AbstractC0157z;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.android.arouter.utils.Consts;
import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Chars;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.format.CellFormatResult;
import org.apache.poi.ss.formula.ConditionalFormattingEvaluator;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DataFormatter {
    private static final Logger LOG;
    private static final String defaultFractionFractionPartFormat = "#/##";
    private static final String defaultFractionWholePartFormat = "#";
    private static final String invalidDateTimeString;
    private DateFormatSymbols dateSymbols;
    private DecimalFormatSymbols decimalSymbols;
    private DateFormat defaultDateformat;
    private Format defaultNumFormat;
    private boolean emulateCSV;
    private final Map<String, Format> formats;
    private Format generalNumberFormat;
    private Locale locale;
    private boolean localeIsAdapting;
    private final PropertyChangeSupport pcs;
    private boolean use4DigitYearsInAllDateFormats;
    private boolean useCachedValuesForFormulaCells;
    private static final Pattern numPattern = Pattern.compile("[0#]+");
    private static final Pattern daysAsText = Pattern.compile("([d]{3,})", 2);
    private static final Pattern amPmPattern = Pattern.compile("(([AP])[M/P]*)", 2);
    private static final Pattern rangeConditionalPattern = Pattern.compile(".*\\[\\s*(>|>=|<|<=|=)\\s*[0-9]*\\.*[0-9].*");
    private static final Pattern localePatternGroup = Pattern.compile("(\\[\\$[^-\\]]*-[0-9A-Z]+])");
    private static final Pattern colorPattern = Pattern.compile("(\\[BLACK])|(\\[BLUE])|(\\[CYAN])|(\\[GREEN])|(\\[MAGENTA])|(\\[RED])|(\\[WHITE])|(\\[YELLOW])|(\\[COLOR\\s*\\d])|(\\[COLOR\\s*[0-5]\\d])", 2);
    private static final Pattern fractionPattern = Pattern.compile("(?:([#\\d]+)\\s+)?(#+)\\s*/\\s*([#\\d]+)");
    private static final Pattern fractionStripper = Pattern.compile("(\"[^\"]*\")|([^ ?#\\d/]+)");
    private static final Pattern alternateGrouping = Pattern.compile("([#0]([^.#0])[#0]{3})");

    /* JADX INFO: renamed from: org.apache.poi.ss.usermodel.DataFormatter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

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
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BLANK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class CellFormatResultWrapper extends Format {
        private final CellFormatResult result;

        public /* synthetic */ CellFormatResultWrapper(DataFormatter dataFormatter, CellFormatResult cellFormatResult, AnonymousClass1 anonymousClass1) {
            this(cellFormatResult);
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            if (DataFormatter.this.emulateCSV) {
                stringBuffer.append(this.result.text);
                return stringBuffer;
            }
            stringBuffer.append(this.result.text.trim());
            return stringBuffer;
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            return null;
        }

        private CellFormatResultWrapper(CellFormatResult cellFormatResult) {
            this.result = cellFormatResult;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ConstantStringFormat extends Format {
        private static final DecimalFormat df = DataFormatter.createIntegerOnlyFormat("##########");
        private final String str;

        public ConstantStringFormat(String str) {
            this.str = str;
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            stringBuffer.append(this.str);
            return stringBuffer;
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            return df.parseObject(str, parsePosition);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class InternalDecimalFormatWithScale extends Format {
        private final DecimalFormat df;
        private final BigDecimal divider;
        private static final Pattern endsWithCommas = Pattern.compile("(,+)$");
        private static final BigDecimal ONE_THOUSAND = BigDecimal.valueOf(1000L);

        public InternalDecimalFormatWithScale(String str, DecimalFormatSymbols decimalFormatSymbols) {
            DecimalFormat decimalFormat = new DecimalFormat(trimTrailingCommas(str), decimalFormatSymbols);
            this.df = decimalFormat;
            DataFormatter.setExcelStyleRoundingMode(decimalFormat);
            Matcher matcher = endsWithCommas.matcher(str);
            if (!matcher.find()) {
                this.divider = null;
                return;
            }
            String strGroup = matcher.group(1);
            BigDecimal bigDecimalMultiply = BigDecimal.ONE;
            for (int i5 = 0; i5 < strGroup.length(); i5++) {
                bigDecimalMultiply = bigDecimalMultiply.multiply(ONE_THOUSAND);
            }
            this.divider = bigDecimalMultiply;
        }

        private Object scaleInput(Object obj) {
            BigDecimal bigDecimal = this.divider;
            if (bigDecimal == null) {
                return obj;
            }
            if (obj instanceof BigDecimal) {
                return ((BigDecimal) obj).divide(bigDecimal, RoundingMode.HALF_UP);
            }
            if (obj instanceof Double) {
                return Double.valueOf(((Double) obj).doubleValue() / this.divider.doubleValue());
            }
            throw new UnsupportedOperationException();
        }

        private static String trimTrailingCommas(String str) {
            return str.replaceAll(",+$", "");
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            return this.df.format(scaleInput(obj), stringBuffer, fieldPosition);
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < 255; i5++) {
            sb.append('#');
        }
        invalidDateTimeString = sb.toString();
        LOG = LogManager.getLogger((Class<?>) DataFormatter.class);
    }

    public DataFormatter() {
        this(false);
    }

    private void checkForLocaleChange() {
        checkForLocaleChange(LocaleUtil.getUserLocale());
    }

    private String cleanFormatForNumber(String str) {
        StringBuilder sb = new StringBuilder(str.replace("\\%", "'%'"));
        int i5 = 0;
        if (this.emulateCSV) {
            int i6 = 0;
            while (i6 < sb.length()) {
                char cCharAt = sb.charAt(i6);
                if ((cCharAt == '_' || cCharAt == '*' || cCharAt == '?') && (i6 <= 0 || sb.charAt(i6 - 1) != '\\')) {
                    if (cCharAt == '?') {
                        sb.setCharAt(i6, Chars.SPACE);
                    } else if (i6 < sb.length() - 1) {
                        if (cCharAt == '_') {
                            sb.setCharAt(i6 + 1, Chars.SPACE);
                        } else {
                            sb.deleteCharAt(i6 + 1);
                        }
                        sb.deleteCharAt(i6);
                        i6--;
                    }
                }
                i6++;
            }
        } else {
            int i7 = 0;
            while (i7 < sb.length()) {
                char cCharAt2 = sb.charAt(i7);
                if ((cCharAt2 == '_' || cCharAt2 == '*') && (i7 <= 0 || sb.charAt(i7 - 1) != '\\')) {
                    if (i7 < sb.length() - 1) {
                        sb.deleteCharAt(i7 + 1);
                    }
                    sb.deleteCharAt(i7);
                    i7--;
                }
                i7++;
            }
        }
        while (i5 < sb.length()) {
            char cCharAt3 = sb.charAt(i5);
            if (cCharAt3 == '\\' || cCharAt3 == '\"') {
                sb.deleteCharAt(i5);
            } else {
                if ((cCharAt3 == '+' || cCharAt3 == '-') && i5 > 0 && sb.charAt(i5 - 1) == 'E') {
                    sb.deleteCharAt(i5);
                }
                i5++;
            }
            i5--;
            i5++;
        }
        return sb.toString();
    }

    private Format createDateFormat(String str, double d) {
        char c;
        String strReplace = adjustTo4DigitYearsIfConfigured(str).replace("\\-", ProcessIdUtil.DEFAULT_PROCESSID).replace("\\,", ",").replace("\\.", Consts.DOT).replace("\\ ", " ").replace("\\/", PackagingURIHelper.FORWARD_SLASH_STRING).replace(";@", "").replace("\"/\"", PackagingURIHelper.FORWARD_SLASH_STRING).replace("\"\"", "'").replace("\\T", "'T'");
        Matcher matcher = amPmPattern.matcher(strReplace);
        boolean z6 = false;
        boolean z7 = false;
        while (matcher.find()) {
            strReplace = matcher.replaceAll("@");
            matcher = amPmPattern.matcher(strReplace);
            z7 = true;
        }
        String strReplace2 = strReplace.replace('@', 'a');
        Matcher matcher2 = daysAsText.matcher(strReplace2);
        if (matcher2.find()) {
            strReplace2 = matcher2.replaceAll(matcher2.group(0).toUpperCase(Locale.ROOT).replace('D', 'E'));
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = strReplace2.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        boolean z8 = false;
        boolean z9 = true;
        while (i5 < charArray.length) {
            char c6 = charArray[i5];
            if (c6 == '\'') {
                sb.append(c6);
                do {
                    i5++;
                    if (i5 >= charArray.length) {
                        break;
                    }
                    c = charArray[i5];
                    sb.append(c);
                } while (c != '\'');
            } else if (c6 != '[' || z8) {
                if (c6 == ']' && z8) {
                    sb.append(c6);
                    z8 = z6;
                } else if (z8) {
                    if (c6 == 'h' || c6 == 'H') {
                        sb.append('H');
                    } else if (c6 == 'm' || c6 == 'M') {
                        sb.append('m');
                    } else if (c6 == 's' || c6 == 'S') {
                        sb.append('s');
                    } else {
                        sb.append(c6);
                    }
                } else if (c6 == 'h' || c6 == 'H') {
                    if (z7) {
                        sb.append('h');
                    } else {
                        sb.append('H');
                    }
                    z9 = false;
                } else if (c6 != 'm' && c6 != 'M') {
                    if (c6 == 's' || c6 == 'S') {
                        sb.append('s');
                        int size = arrayList.size();
                        int i6 = 0;
                        while (i6 < size) {
                            Object obj = arrayList.get(i6);
                            i6++;
                            int iIntValue = ((Integer) obj).intValue();
                            if (sb.charAt(iIntValue) == 'M') {
                                sb.replace(iIntValue, iIntValue + 1, "m");
                            }
                        }
                        arrayList.clear();
                    } else if (Character.isLetter(c6)) {
                        arrayList.clear();
                        if (c6 == 'y' || c6 == 'Y') {
                            sb.append('y');
                        } else if (c6 == 'd' || c6 == 'D') {
                            sb.append('d');
                        } else {
                            sb.append(c6);
                        }
                    } else {
                        if (Character.isWhitespace(c6)) {
                            arrayList.clear();
                        }
                        sb.append(c6);
                    }
                    z9 = true;
                } else if (z9) {
                    sb.append('M');
                    arrayList.add(Integer.valueOf(sb.length() - 1));
                } else {
                    sb.append('m');
                }
                i5++;
                z6 = false;
            } else {
                sb.append(c6);
                z9 = z6;
                z8 = true;
            }
            i5++;
            z6 = false;
        }
        String string = sb.toString();
        try {
            return new ExcelStyleDateFormatter(string, this.dateSymbols);
        } catch (IllegalArgumentException e) {
            LOG.atDebug().withThrowable(e).log("Formatting failed for format {}, falling back", string);
            return getDefaultFormat(d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DecimalFormat createIntegerOnlyFormat(String str) {
        DecimalFormat decimalFormat = new DecimalFormat(str, DecimalFormatSymbols.getInstance(Locale.ROOT));
        decimalFormat.setParseIntegerOnly(true);
        return decimalFormat;
    }

    private Format createNumberFormat(String str, double d) {
        char cCharAt;
        String strCleanFormatForNumber = cleanFormatForNumber(str);
        DecimalFormatSymbols decimalFormatSymbols = this.decimalSymbols;
        Matcher matcher = alternateGrouping.matcher(strCleanFormatForNumber);
        if (matcher.find() && (cCharAt = matcher.group(2).charAt(0)) != ',') {
            decimalFormatSymbols = DecimalFormatSymbols.getInstance(this.locale);
            decimalFormatSymbols.setGroupingSeparator(cCharAt);
            String strGroup = matcher.group(1);
            strCleanFormatForNumber = strCleanFormatForNumber.replace(strGroup, strGroup.replace(cCharAt, ','));
        }
        try {
            return new InternalDecimalFormatWithScale(strCleanFormatForNumber, decimalFormatSymbols);
        } catch (IllegalArgumentException e) {
            LOG.atDebug().withThrowable(e).log("Formatting failed for format {}, falling back", str);
            return getDefaultFormat(d);
        }
    }

    private Format getFormat(Cell cell, ConditionalFormattingEvaluator conditionalFormattingEvaluator) {
        ExcelNumberFormat excelNumberFormatFrom;
        if (cell == null || (excelNumberFormatFrom = ExcelNumberFormat.from(cell, conditionalFormattingEvaluator)) == null) {
            return null;
        }
        int idx = excelNumberFormatFrom.getIdx();
        String format = excelNumberFormatFrom.getFormat();
        if (StringUtil.isBlank(format)) {
            return null;
        }
        return getFormat(cell.getNumericCellValue(), idx, format, isDate1904(cell));
    }

    private String getFormattedDateString(Cell cell, ConditionalFormattingEvaluator conditionalFormattingEvaluator) {
        String strPerformDateFormatting;
        if (cell == null) {
            return null;
        }
        Format format = getFormat(cell, conditionalFormattingEvaluator);
        if (format == null) {
            if (this.defaultDateformat == null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", DateFormatSymbols.getInstance(LocaleUtil.getUserLocale()));
                simpleDateFormat.setTimeZone(LocaleUtil.getUserTimeZone());
                format = simpleDateFormat;
            } else {
                format = this.defaultNumFormat;
            }
        }
        synchronized (format) {
            try {
                if (format instanceof ExcelStyleDateFormatter) {
                    ((ExcelStyleDateFormatter) format).setDateToBeFormatted(cell.getNumericCellValue());
                }
                strPerformDateFormatting = performDateFormatting(cell.getDateCellValue(), format);
            } catch (Throwable th) {
                throw th;
            }
        }
        return strPerformDateFormatting;
    }

    private String getFormattedNumberString(Cell cell, ConditionalFormattingEvaluator conditionalFormattingEvaluator) {
        String str;
        if (cell == null) {
            return null;
        }
        Format format = getFormat(cell, conditionalFormattingEvaluator);
        double numericCellValue = cell.getNumericCellValue();
        if (format == null) {
            return Double.toString(numericCellValue);
        }
        try {
            str = format.format(BigDecimal.valueOf(numericCellValue));
        } catch (NumberFormatException unused) {
            str = format.format(Double.valueOf(numericCellValue));
        }
        return str.replaceFirst("E(\\d)", "E+$1");
    }

    private boolean isDate1904(Cell cell) {
        if (cell == null || !(cell.getSheet().getWorkbook() instanceof Date1904Support)) {
            return false;
        }
        return ((Date1904Support) cell.getSheet().getWorkbook()).isDate1904();
    }

    private String performDateFormatting(Date date, Format format) {
        String str;
        if (format == null) {
            format = this.defaultDateformat;
        }
        synchronized (format) {
            str = format.format(date);
        }
        return str;
    }

    public static void setExcelStyleRoundingMode(DecimalFormat decimalFormat) {
        setExcelStyleRoundingMode(decimalFormat, RoundingMode.HALF_UP);
    }

    public void addFormat(String str, Format format) {
        this.formats.put(str, format);
    }

    public String adjustTo4DigitYearsIfConfigured(String str) {
        int iIndexOf;
        if (this.use4DigitYearsInAllDateFormats && (iIndexOf = str.indexOf("yy")) >= 0) {
            int iIndexOf2 = str.indexOf("yyy");
            if (str.indexOf("yyyy") == iIndexOf) {
                int i5 = iIndexOf + 4;
                String strSubstring = str.substring(0, i5);
                String strSubstring2 = str.substring(i5);
                StringBuilder sbR = androidx.collection.a.r(strSubstring);
                sbR.append(adjustTo4DigitYearsIfConfigured(strSubstring2));
                return sbR.toString();
            }
            if (iIndexOf2 != iIndexOf) {
                int i6 = iIndexOf + 2;
                String strSubstring3 = str.substring(0, i6);
                String strSubstring4 = str.substring(i6);
                StringBuilder sbX = AbstractC0157z.x(strSubstring3, "yy");
                sbX.append(adjustTo4DigitYearsIfConfigured(strSubstring4));
                return sbX.toString();
            }
        }
        return str;
    }

    public Format createFormat(Cell cell) {
        return createFormat(cell.getNumericCellValue(), cell.getCellStyle().getDataFormat(), cell.getCellStyle().getDataFormatString());
    }

    public String formatCellValue(Cell cell) {
        return formatCellValue(cell, null);
    }

    public String formatRawCellContents(double d, int i5, String str) {
        return formatRawCellContents(d, i5, str, false);
    }

    public Format getDefaultFormat(Cell cell) {
        return getDefaultFormat(cell.getNumericCellValue());
    }

    public PropertyChangeSupport getLocaleChangedObservable() {
        return this.pcs;
    }

    public boolean isEmulateCSV() {
        return this.emulateCSV;
    }

    public void setDefaultNumberFormat(Format format) {
        for (Map.Entry<String, Format> entry : this.formats.entrySet()) {
            if (entry.getValue() == this.generalNumberFormat) {
                entry.setValue(format);
            }
        }
        this.defaultNumFormat = format;
    }

    public void setEmulateCSV(boolean z6) {
        this.emulateCSV = z6;
    }

    public void setUse4DigitYearsInAllDateFormats(boolean z6) {
        this.use4DigitYearsInAllDateFormats = z6;
    }

    public void setUseCachedValuesForFormulaCells(boolean z6) {
        this.useCachedValuesForFormulaCells = z6;
    }

    public void updateLocale(Locale locale) {
        if (!this.localeIsAdapting || locale.equals(this.locale)) {
            return;
        }
        this.locale = locale;
        this.dateSymbols = DateFormatSymbols.getInstance(locale);
        this.decimalSymbols = DecimalFormatSymbols.getInstance(this.locale);
        this.generalNumberFormat = new ExcelGeneralNumberFormat(this.locale);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", this.dateSymbols);
        this.defaultDateformat = simpleDateFormat;
        simpleDateFormat.setTimeZone(LocaleUtil.getUserTimeZone());
        this.formats.clear();
        Format format = ZipPlusFourFormat.instance;
        addFormat("00000\\-0000", format);
        addFormat("00000-0000", format);
        Format format2 = PhoneFormat.instance;
        addFormat("[<=9999999]###\\-####;\\(###\\)\\ ###\\-####", format2);
        addFormat("[<=9999999]###-####;(###) ###-####", format2);
        addFormat("###\\-####;\\(###\\)\\ ###\\-####", format2);
        addFormat("###-####;(###) ###-####", format2);
        Format format3 = SSNFormat.instance;
        addFormat("000\\-00\\-0000", format3);
        addFormat("000-00-0000", format3);
    }

    public boolean use4DigitYearsInAllDateFormats() {
        return this.use4DigitYearsInAllDateFormats;
    }

    public boolean useCachedValuesForFormulaCells() {
        return this.useCachedValuesForFormulaCells;
    }

    public DataFormatter(boolean z6) {
        this(LocaleUtil.getUserLocale(), true, z6);
    }

    private void checkForLocaleChange(Locale locale) {
        if (this.localeIsAdapting && !locale.equals(this.locale)) {
            updateLocale(locale);
            this.pcs.firePropertyChange("locale", this.locale, locale);
        }
    }

    private Format getDefaultFormat(double d) {
        checkForLocaleChange();
        Format format = this.defaultNumFormat;
        return format != null ? format : this.generalNumberFormat;
    }

    public static void setExcelStyleRoundingMode(DecimalFormat decimalFormat, RoundingMode roundingMode) {
        decimalFormat.setRoundingMode(roundingMode);
    }

    public String formatCellValue(Cell cell, FormulaEvaluator formulaEvaluator) {
        return formatCellValue(cell, formulaEvaluator, null);
    }

    public String formatRawCellContents(double d, int i5, String str, boolean z6) {
        checkForLocaleChange();
        if (DateUtil.isADateFormat(i5, str)) {
            if (DateUtil.isValidExcelDate(d)) {
                Format format = getFormat(d, i5, str, z6);
                if (format instanceof ExcelStyleDateFormatter) {
                    ((ExcelStyleDateFormatter) format).setDateToBeFormatted(d);
                }
                return performDateFormatting(DateUtil.getJavaDate(d, z6), format);
            }
            if (this.emulateCSV) {
                return invalidDateTimeString;
            }
        }
        Format format2 = getFormat(d, i5, str, z6);
        if (format2 == null) {
            return String.valueOf(d);
        }
        String text = NumberToTextConverter.toText(d);
        String str2 = text.indexOf(69) > -1 ? format2.format(Double.valueOf(d)) : format2.format(new BigDecimal(text));
        String lowerCase = str.toLowerCase(Locale.ROOT);
        return ((lowerCase.contains("general") || lowerCase.contains("e+0")) && str2.contains(ExifInterface.LONGITUDE_EAST) && !str2.contains("E-")) ? str2.replaceFirst(ExifInterface.LONGITUDE_EAST, "E+") : str2;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ZipPlusFourFormat extends Format {
        public static final Format instance = new ZipPlusFourFormat();
        private static final DecimalFormat df = DataFormatter.createIntegerOnlyFormat("000000000");

        private ZipPlusFourFormat() {
        }

        public static String format(Number number) {
            String str = df.format(number);
            return str.substring(0, 5) + '-' + str.substring(5, 9);
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            return df.parseObject(str, parsePosition);
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            stringBuffer.append(format((Number) obj));
            return stringBuffer;
        }
    }

    public DataFormatter(Locale locale) {
        this(locale, false);
    }

    public String formatCellValue(Cell cell, FormulaEvaluator formulaEvaluator, ConditionalFormattingEvaluator conditionalFormattingEvaluator) {
        checkForLocaleChange();
        if (cell == null) {
            return "";
        }
        CellType cellType = cell.getCellType();
        if (cellType == CellType.FORMULA) {
            if (formulaEvaluator == null) {
                if (this.useCachedValuesForFormulaCells) {
                    try {
                        cellType = cell.getCachedFormulaResultType();
                    } catch (Exception unused) {
                        return cell.getCellFormula();
                    }
                } else {
                    return cell.getCellFormula();
                }
            } else {
                cellType = formulaEvaluator.evaluateFormulaCell(cell);
            }
        }
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()];
        if (i5 == 1) {
            if (DateUtil.isCellDateFormatted(cell, conditionalFormattingEvaluator)) {
                return getFormattedDateString(cell, conditionalFormattingEvaluator);
            }
            return getFormattedNumberString(cell, conditionalFormattingEvaluator);
        }
        if (i5 == 2) {
            return cell.getRichStringCellValue().getString();
        }
        if (i5 == 3) {
            return cell.getBooleanCellValue() ? "TRUE" : "FALSE";
        }
        if (i5 == 4) {
            return "";
        }
        if (i5 == 5) {
            return FormulaError.forInt(cell.getErrorCellValue()).getString();
        }
        throw new RuntimeException("Unexpected celltype (" + cellType + ")");
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SSNFormat extends Format {
        public static final Format instance = new SSNFormat();
        private static final DecimalFormat df = DataFormatter.createIntegerOnlyFormat("000000000");

        private SSNFormat() {
        }

        public static String format(Number number) {
            String str = df.format(number);
            return str.substring(0, 3) + '-' + str.substring(3, 5) + '-' + str.substring(5, 9);
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            return df.parseObject(str, parsePosition);
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            stringBuffer.append(format((Number) obj));
            return stringBuffer;
        }
    }

    public DataFormatter(Locale locale, boolean z6) {
        this(locale, false, z6);
    }

    private Format createFormat(double d, int i5, String str) {
        String strGroup;
        int iIndexOf;
        checkForLocaleChange();
        int i6 = 0;
        if (str != null) {
            Matcher matcher = colorPattern.matcher(str);
            while (matcher.find() && (iIndexOf = str.indexOf((strGroup = matcher.group()))) != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(str.substring(0, iIndexOf));
                String strJ = androidx.exifinterface.media.a.j(str, strGroup.length() + iIndexOf, sb);
                if (strJ.equals(str)) {
                    break;
                }
                matcher = colorPattern.matcher(strJ);
                str = strJ;
            }
        }
        if (str != null) {
            Matcher matcher2 = localePatternGroup.matcher(str);
            while (matcher2.find()) {
                String strGroup2 = matcher2.group();
                String strSubstring = strGroup2.substring(strGroup2.indexOf(36) + 1, strGroup2.indexOf(45));
                if (strSubstring.indexOf(36) > -1) {
                    strSubstring = strSubstring.substring(0, strSubstring.indexOf(36)) + IOUtils.DIR_SEPARATOR_WINDOWS + strSubstring.substring(strSubstring.indexOf(36));
                }
                str = matcher2.replaceAll(strSubstring);
                matcher2 = localePatternGroup.matcher(str);
            }
        }
        if (StringUtil.isBlank(str)) {
            return getDefaultFormat(d);
        }
        if (!"General".equalsIgnoreCase(str) && !"@".equals(str)) {
            if (DateUtil.isADateFormat(i5, str) && DateUtil.isValidExcelDate(d)) {
                return createDateFormat(str, d);
            }
            if (!str.contains("#/") && !str.contains("?/")) {
                if (numPattern.matcher(str).find()) {
                    return createNumberFormat(str, d);
                }
                if (this.emulateCSV) {
                    return new ConstantStringFormat(cleanFormatForNumber(str));
                }
                return null;
            }
            String[] strArrSplit = str.split(";");
            int length = strArrSplit.length;
            while (true) {
                String str2 = defaultFractionWholePartFormat;
                if (i6 < length) {
                    Matcher matcher3 = fractionPattern.matcher(fractionStripper.matcher(strArrSplit[i6].replace("?", defaultFractionWholePartFormat)).replaceAll(" ").replaceAll(" +", " "));
                    if (matcher3.find()) {
                        if (matcher3.group(1) == null) {
                            str2 = "";
                        }
                        return new FractionFormat(str2, matcher3.group(3));
                    }
                    i6++;
                } else {
                    return new FractionFormat(defaultFractionWholePartFormat, defaultFractionFractionPartFormat);
                }
            }
        } else {
            return this.generalNumberFormat;
        }
    }

    public DataFormatter(Locale locale, boolean z6, boolean z7) {
        this.formats = new HashMap();
        this.emulateCSV = false;
        this.use4DigitYearsInAllDateFormats = false;
        this.useCachedValuesForFormulaCells = false;
        this.localeIsAdapting = true;
        this.pcs = new PropertyChangeSupport(this);
        checkForLocaleChange(locale);
        this.localeIsAdapting = z6;
        this.emulateCSV = z7;
    }

    private Format getFormat(double d, int i5, String str, boolean z6) {
        Object objValueOf;
        checkForLocaleChange();
        String strReplace = str.replace("\\%", "'%'");
        if (strReplace.contains(";") && (strReplace.indexOf(59) != strReplace.lastIndexOf(59) || rangeConditionalPattern.matcher(strReplace).matches())) {
            try {
                CellFormat cellFormat = CellFormat.getInstance(this.locale, strReplace);
                if (d != 0.0d && DateUtil.isADateFormat(i5, strReplace)) {
                    objValueOf = DateUtil.getJavaDate(d, z6);
                } else {
                    objValueOf = Double.valueOf(d);
                }
                return new CellFormatResultWrapper(this, cellFormat.apply(objValueOf), null);
            } catch (Exception e) {
                LOG.atWarn().withThrowable(e).log("Formatting failed for format {}, falling back", strReplace);
            }
        }
        if (this.emulateCSV && d == 0.0d && strReplace.contains(defaultFractionWholePartFormat) && !strReplace.contains("0")) {
            strReplace = strReplace.replace(defaultFractionWholePartFormat, "");
        }
        Format format = this.formats.get(strReplace);
        if (format != null) {
            return format;
        }
        if (!"General".equalsIgnoreCase(strReplace) && !"@".equals(strReplace)) {
            Format formatCreateFormat = createFormat(d, i5, strReplace);
            this.formats.put(strReplace, formatCreateFormat);
            return formatCreateFormat;
        }
        return this.generalNumberFormat;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class PhoneFormat extends Format {
        public static final Format instance = new PhoneFormat();
        private static final DecimalFormat df = DataFormatter.createIntegerOnlyFormat("##########");

        private PhoneFormat() {
        }

        public static String format(Number number) {
            String str = df.format(number);
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            if (length <= 4) {
                return str;
            }
            int i5 = length - 4;
            String strSubstring = str.substring(i5, length);
            int i6 = length - 7;
            String strSubstring2 = str.substring(Math.max(0, i6), i5);
            String strSubstring3 = str.substring(Math.max(0, length - 10), Math.max(0, i6));
            if (StringUtil.isNotBlank(strSubstring3)) {
                sb.append('(');
                sb.append(strSubstring3);
                sb.append(") ");
            }
            if (StringUtil.isNotBlank(strSubstring2)) {
                sb.append(strSubstring2);
                sb.append('-');
            }
            sb.append(strSubstring);
            return sb.toString();
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            return df.parseObject(str, parsePosition);
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            stringBuffer.append(format((Number) obj));
            return stringBuffer;
        }
    }
}
