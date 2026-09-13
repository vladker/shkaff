package org.apache.poi.ss.format;

import com.google.android.material.color.utilities.g;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CellFormat {
    private static final String INVALID_VALUE_FOR_FORMAT = "###############################################################################################################################################################################################################################################################";
    private static final String QUOTE = "\"";
    private final String format;
    private final int formatPartCount;
    private final Locale locale;
    private final CellFormatPart negNumFmt;
    private final CellFormatPart posNumFmt;
    private final CellFormatPart textFmt;
    private final CellFormatPart zeroNumFmt;
    private static final Logger LOG = LogManager.getLogger((Class<?>) CellFormat.class);
    private static final Pattern ONE_PART = Pattern.compile(CellFormatPart.FORMAT_PAT.pattern() + "(;|$)", 6);
    private static final Map<Locale, Map<String, CellFormat>> formatCache = new WeakHashMap();

    /* JADX INFO: renamed from: org.apache.poi.ss.format.CellFormat$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.BLANK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static CellFormat createGeneralFormat(final Locale locale) {
        return new CellFormat(locale, "General") { // from class: org.apache.poi.ss.format.CellFormat.1
            @Override // org.apache.poi.ss.format.CellFormat
            public CellFormatResult apply(Object obj) {
                return new CellFormatResult(true, new CellGeneralFormatter(locale).format(obj), null);
            }
        };
    }

    private CellFormatPart getApplicableFormatPart(Object obj) {
        if (!(obj instanceof Number)) {
            throw new IllegalArgumentException("value must be a Number");
        }
        double dDoubleValue = ((Number) obj).doubleValue();
        int i5 = this.formatPartCount;
        if (i5 == 1) {
            return (!this.posNumFmt.hasCondition() || (this.posNumFmt.hasCondition() && this.posNumFmt.applies(Double.valueOf(dDoubleValue)))) ? this.posNumFmt : new CellFormatPart(this.locale, "General");
        }
        if (i5 == 2) {
            if ((this.posNumFmt.hasCondition() || dDoubleValue < 0.0d) && !(this.posNumFmt.hasCondition() && this.posNumFmt.applies(Double.valueOf(dDoubleValue)))) {
                return (!this.negNumFmt.hasCondition() || (this.negNumFmt.hasCondition() && this.negNumFmt.applies(Double.valueOf(dDoubleValue)))) ? this.negNumFmt : new CellFormatPart("\"###############################################################################################################################################################################################################################################################\"");
            }
            return this.posNumFmt;
        }
        if ((this.posNumFmt.hasCondition() || dDoubleValue <= 0.0d) && !(this.posNumFmt.hasCondition() && this.posNumFmt.applies(Double.valueOf(dDoubleValue)))) {
            return ((this.negNumFmt.hasCondition() || dDoubleValue >= 0.0d) && !(this.negNumFmt.hasCondition() && this.negNumFmt.applies(Double.valueOf(dDoubleValue)))) ? this.zeroNumFmt : this.negNumFmt;
        }
        return this.posNumFmt;
    }

    public static CellFormat getInstance(String str) {
        return getInstance(LocaleUtil.getUserLocale(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$getInstance$0(Locale locale) {
        return new WeakHashMap();
    }

    public static CellType ultimateType(Cell cell) {
        CellType cellType = cell.getCellType();
        return cellType == CellType.FORMULA ? cell.getCachedFormulaResultType() : cellType;
    }

    public CellFormatResult apply(Object obj) {
        if (obj instanceof Number) {
            double dDoubleValue = ((Number) obj).doubleValue();
            return (dDoubleValue >= 0.0d || ((this.formatPartCount != 2 || this.posNumFmt.hasCondition() || this.negNumFmt.hasCondition()) && ((this.formatPartCount != 3 || this.negNumFmt.hasCondition()) && (this.formatPartCount != 4 || this.negNumFmt.hasCondition())))) ? getApplicableFormatPart(Double.valueOf(dDoubleValue)).apply(Double.valueOf(dDoubleValue)) : this.negNumFmt.apply(Double.valueOf(-dDoubleValue));
        }
        if (!(obj instanceof Date)) {
            return this.textFmt.apply(obj);
        }
        double excelDate = DateUtil.getExcelDate((Date) obj);
        if (DateUtil.isValidExcelDate(excelDate)) {
            return getApplicableFormatPart(Double.valueOf(excelDate)).apply(obj);
        }
        throw new IllegalArgumentException("value " + excelDate + " of date " + obj + " is not a valid Excel date");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CellFormat) {
            return this.format.equals(((CellFormat) obj).format);
        }
        return false;
    }

    public int hashCode() {
        return this.format.hashCode();
    }

    private CellFormat(Locale locale, String str) {
        this.locale = locale;
        this.format = str;
        CellFormatPart cellFormatPart = new CellFormatPart(locale, "@");
        Matcher matcher = ONE_PART.matcher(str);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            try {
                String strGroup = matcher.group();
                arrayList.add(new CellFormatPart(locale, strGroup.endsWith(";") ? strGroup.substring(0, strGroup.length() - 1) : strGroup));
            } catch (RuntimeException e) {
                LOG.log(Level.WARN, "Invalid format: " + CellFormatter.quote(matcher.group()), (Throwable) e);
                arrayList.add(null);
            }
        }
        int size = arrayList.size();
        this.formatPartCount = size;
        if (size == 1) {
            this.posNumFmt = (CellFormatPart) arrayList.get(0);
            this.negNumFmt = null;
            this.zeroNumFmt = null;
            this.textFmt = cellFormatPart;
            return;
        }
        if (size == 2) {
            this.posNumFmt = (CellFormatPart) arrayList.get(0);
            this.negNumFmt = (CellFormatPart) arrayList.get(1);
            this.zeroNumFmt = null;
            this.textFmt = cellFormatPart;
            return;
        }
        if (size != 3) {
            this.posNumFmt = (CellFormatPart) arrayList.get(0);
            this.negNumFmt = (CellFormatPart) arrayList.get(1);
            this.zeroNumFmt = (CellFormatPart) arrayList.get(2);
            this.textFmt = (CellFormatPart) arrayList.get(3);
            return;
        }
        this.posNumFmt = (CellFormatPart) arrayList.get(0);
        this.negNumFmt = (CellFormatPart) arrayList.get(1);
        this.zeroNumFmt = (CellFormatPart) arrayList.get(2);
        this.textFmt = cellFormatPart;
    }

    public static synchronized CellFormat getInstance(Locale locale, String str) {
        CellFormat cellFormatCreateGeneralFormat;
        try {
            Map<String, CellFormat> mapComputeIfAbsent = formatCache.computeIfAbsent(locale, new g(26));
            cellFormatCreateGeneralFormat = mapComputeIfAbsent.get(str);
            if (cellFormatCreateGeneralFormat == null) {
                cellFormatCreateGeneralFormat = (str.equals("General") || str.equals("@")) ? createGeneralFormat(locale) : new CellFormat(locale, str);
                mapComputeIfAbsent.put(str, cellFormatCreateGeneralFormat);
            }
        } catch (Throwable th) {
            throw th;
        }
        return cellFormatCreateGeneralFormat;
    }

    private CellFormatResult apply(Date date, double d) {
        return getApplicableFormatPart(Double.valueOf(d)).apply(date);
    }

    public CellFormatResult apply(Cell cell) {
        int i5 = AnonymousClass2.$SwitchMap$org$apache$poi$ss$usermodel$CellType[ultimateType(cell).ordinal()];
        if (i5 == 1) {
            return apply("");
        }
        if (i5 == 2) {
            return apply(Boolean.valueOf(cell.getBooleanCellValue()));
        }
        if (i5 != 3) {
            if (i5 != 4) {
                return apply("?");
            }
            return apply(cell.getStringCellValue());
        }
        double numericCellValue = cell.getNumericCellValue();
        if (getApplicableFormatPart(Double.valueOf(numericCellValue)).getCellFormatType() == CellFormatType.DATE) {
            if (DateUtil.isValidExcelDate(numericCellValue)) {
                return apply(cell.getDateCellValue(), numericCellValue);
            }
            return apply(INVALID_VALUE_FOR_FORMAT);
        }
        return apply(Double.valueOf(numericCellValue));
    }

    public CellFormatResult apply(JLabel jLabel, Object obj) {
        CellFormatResult cellFormatResultApply = apply(obj);
        jLabel.setText(cellFormatResultApply.text);
        Color color = cellFormatResultApply.textColor;
        if (color != null) {
            jLabel.setForeground(color);
        }
        return cellFormatResultApply;
    }

    private CellFormatResult apply(JLabel jLabel, Date date, double d) {
        CellFormatResult cellFormatResultApply = apply(date, d);
        jLabel.setText(cellFormatResultApply.text);
        Color color = cellFormatResultApply.textColor;
        if (color != null) {
            jLabel.setForeground(color);
        }
        return cellFormatResultApply;
    }

    public CellFormatResult apply(JLabel jLabel, Cell cell) {
        int i5 = AnonymousClass2.$SwitchMap$org$apache$poi$ss$usermodel$CellType[ultimateType(cell).ordinal()];
        if (i5 == 1) {
            return apply(jLabel, "");
        }
        if (i5 == 2) {
            return apply(jLabel, Boolean.valueOf(cell.getBooleanCellValue()));
        }
        if (i5 != 3) {
            if (i5 != 4) {
                return apply(jLabel, "?");
            }
            return apply(jLabel, cell.getStringCellValue());
        }
        double numericCellValue = cell.getNumericCellValue();
        if (getApplicableFormatPart(Double.valueOf(numericCellValue)).getCellFormatType() == CellFormatType.DATE) {
            if (DateUtil.isValidExcelDate(numericCellValue)) {
                return apply(jLabel, cell.getDateCellValue(), numericCellValue);
            }
            return apply(jLabel, INVALID_VALUE_FOR_FORMAT);
        }
        return apply(jLabel, Double.valueOf(numericCellValue));
    }
}
