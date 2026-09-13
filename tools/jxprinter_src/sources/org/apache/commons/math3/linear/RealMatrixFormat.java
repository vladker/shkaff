package org.apache.commons.math3.linear;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.commons.math3.exception.MathParseException;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.commons.math3.util.CompositeFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RealMatrixFormat {
    private static final String DEFAULT_COLUMN_SEPARATOR = ",";
    private static final String DEFAULT_PREFIX = "{";
    private static final String DEFAULT_ROW_PREFIX = "{";
    private static final String DEFAULT_ROW_SEPARATOR = ",";
    private static final String DEFAULT_ROW_SUFFIX = "}";
    private static final String DEFAULT_SUFFIX = "}";
    private final String columnSeparator;
    private final NumberFormat format;
    private final String prefix;
    private final String rowPrefix;
    private final String rowSeparator;
    private final String rowSuffix;
    private final String suffix;

    public RealMatrixFormat() {
        this(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, ",", ",", CompositeFormat.getDefaultNumberFormat());
    }

    public static Locale[] getAvailableLocales() {
        return NumberFormat.getAvailableLocales();
    }

    public static RealMatrixFormat getInstance() {
        return getInstance(Locale.getDefault());
    }

    public String format(RealMatrix realMatrix) {
        return format(realMatrix, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public String getColumnSeparator() {
        return this.columnSeparator;
    }

    public NumberFormat getFormat() {
        return this.format;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getRowPrefix() {
        return this.rowPrefix;
    }

    public String getRowSeparator() {
        return this.rowSeparator;
    }

    public String getRowSuffix() {
        return this.rowSuffix;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public RealMatrix parse(String str) {
        ParsePosition parsePosition = new ParsePosition(0);
        RealMatrix realMatrix = parse(str, parsePosition);
        if (parsePosition.getIndex() != 0) {
            return realMatrix;
        }
        throw new MathParseException(str, parsePosition.getErrorIndex(), Array2DRowRealMatrix.class);
    }

    public RealMatrixFormat(NumberFormat numberFormat) {
        this(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, ",", ",", numberFormat);
    }

    public static RealMatrixFormat getInstance(Locale locale) {
        return new RealMatrixFormat(CompositeFormat.getDefaultNumberFormat(locale));
    }

    public StringBuffer format(RealMatrix realMatrix, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        stringBuffer.append(this.prefix);
        int rowDimension = realMatrix.getRowDimension();
        for (int i5 = 0; i5 < rowDimension; i5++) {
            stringBuffer.append(this.rowPrefix);
            for (int i6 = 0; i6 < realMatrix.getColumnDimension(); i6++) {
                if (i6 > 0) {
                    stringBuffer.append(this.columnSeparator);
                }
                CompositeFormat.formatDouble(realMatrix.getEntry(i5, i6), this.format, stringBuffer, fieldPosition);
            }
            stringBuffer.append(this.rowSuffix);
            if (i5 < rowDimension - 1) {
                stringBuffer.append(this.rowSeparator);
            }
        }
        stringBuffer.append(this.suffix);
        return stringBuffer;
    }

    public RealMatrixFormat(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str, str2, str3, str4, str5, str6, CompositeFormat.getDefaultNumberFormat());
    }

    public RealMatrixFormat(String str, String str2, String str3, String str4, String str5, String str6, NumberFormat numberFormat) {
        this.prefix = str;
        this.suffix = str2;
        this.rowPrefix = str3;
        this.rowSuffix = str4;
        this.rowSeparator = str5;
        this.columnSeparator = str6;
        this.format = numberFormat;
        numberFormat.setGroupingUsed(false);
    }

    public RealMatrix parse(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        String strTrim = this.prefix.trim();
        String strTrim2 = this.suffix.trim();
        String strTrim3 = this.rowPrefix.trim();
        String strTrim4 = this.rowSuffix.trim();
        String strTrim5 = this.columnSeparator.trim();
        String strTrim6 = this.rowSeparator.trim();
        CompositeFormat.parseAndIgnoreWhitespace(str, parsePosition);
        if (!CompositeFormat.parseFixedstring(str, strTrim, parsePosition)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z6 = true;
        while (z6) {
            if (!arrayList2.isEmpty()) {
                CompositeFormat.parseAndIgnoreWhitespace(str, parsePosition);
                if (!CompositeFormat.parseFixedstring(str, strTrim5, parsePosition)) {
                    if (strTrim4.length() != 0 && !CompositeFormat.parseFixedstring(str, strTrim4, parsePosition)) {
                        return null;
                    }
                    CompositeFormat.parseAndIgnoreWhitespace(str, parsePosition);
                    if (CompositeFormat.parseFixedstring(str, strTrim6, parsePosition)) {
                        arrayList.add(arrayList2);
                        arrayList2 = new ArrayList();
                    } else {
                        z6 = false;
                    }
                }
            } else {
                CompositeFormat.parseAndIgnoreWhitespace(str, parsePosition);
                if (strTrim3.length() != 0 && !CompositeFormat.parseFixedstring(str, strTrim3, parsePosition)) {
                    return null;
                }
            }
            if (z6) {
                CompositeFormat.parseAndIgnoreWhitespace(str, parsePosition);
                Number number = CompositeFormat.parseNumber(str, this.format, parsePosition);
                if (number != null) {
                    arrayList2.add(number);
                } else {
                    if (!arrayList2.isEmpty()) {
                        parsePosition.setIndex(index);
                        return null;
                    }
                    z6 = false;
                }
            } else {
                continue;
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.add(arrayList2);
        }
        CompositeFormat.parseAndIgnoreWhitespace(str, parsePosition);
        if (!CompositeFormat.parseFixedstring(str, strTrim2, parsePosition)) {
            return null;
        }
        if (arrayList.isEmpty()) {
            parsePosition.setIndex(index);
            return null;
        }
        double[][] dArr = new double[arrayList.size()][];
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            List list = (List) obj;
            dArr[i5] = new double[list.size()];
            for (int i7 = 0; i7 < list.size(); i7++) {
                dArr[i5][i7] = ((Number) list.get(i7)).doubleValue();
            }
            i5++;
        }
        return MatrixUtils.createRealMatrix(dArr);
    }
}
