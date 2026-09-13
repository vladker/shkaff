package org.apache.poi.ss.format;

import com.alibaba.android.arouter.utils.Consts;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CellDateFormatter extends CellFormatter {
    private static final Calendar EXCEL_EPOCH_CAL = LocaleUtil.getLocaleCalendar(1904, 0, 1);
    private static final int NUM_MILLISECONDS_IN_DAY = 86400000;
    private static CellDateFormatter SIMPLE_DATE_FORMATTER;
    private boolean amPmUpper;
    private final DateFormat dateFmt;
    private String sFmt;
    private boolean showAmPm;
    private boolean showM;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class DatePartHandler implements CellFormatPart.PartHandler {
        private int hLen;
        private int mLen;
        private int mStart = -1;
        private int hStart = -1;

        public DatePartHandler() {
        }

        public void finish(StringBuffer stringBuffer) {
            if (this.hStart < 0 || CellDateFormatter.this.showAmPm) {
                return;
            }
            for (int i5 = 0; i5 < this.hLen; i5++) {
                stringBuffer.setCharAt(this.hStart + i5, 'H');
            }
        }

        @Override // org.apache.poi.ss.format.CellFormatPart.PartHandler
        public String handlePart(Matcher matcher, String str, CellFormatType cellFormatType, StringBuffer stringBuffer) {
            int length = stringBuffer.length();
            switch (str.charAt(0)) {
                case '0':
                    this.mStart = -1;
                    int length2 = str.length();
                    CellDateFormatter.this.sFmt = "%0" + (length2 + 2) + Consts.DOT + length2 + "f";
                    return str.replace('0', 'S');
                case 'A':
                case 'P':
                case 'a':
                case 'p':
                    if (str.length() <= 1) {
                        return null;
                    }
                    this.mStart = -1;
                    CellDateFormatter.this.showAmPm = true;
                    CellDateFormatter.this.showM = StringUtil.toLowerCase(str.charAt(1)).equals("m");
                    CellDateFormatter cellDateFormatter = CellDateFormatter.this;
                    cellDateFormatter.amPmUpper = cellDateFormatter.showM || StringUtil.isUpperCase(str.charAt(0));
                    return "a";
                case 'D':
                case 'd':
                    this.mStart = -1;
                    return str.length() <= 2 ? str.toLowerCase(Locale.ROOT) : str.toLowerCase(Locale.ROOT).replace('d', 'E');
                case 'H':
                case 'h':
                    this.mStart = -1;
                    this.hStart = length;
                    this.hLen = str.length();
                    return str.toLowerCase(Locale.ROOT);
                case 'M':
                case 'm':
                    this.mStart = length;
                    this.mLen = str.length();
                    return this.hStart >= 0 ? str.toLowerCase(Locale.ROOT) : str.toUpperCase(Locale.ROOT);
                case 'S':
                case 's':
                    if (this.mStart >= 0) {
                        for (int i5 = 0; i5 < this.mLen; i5++) {
                            stringBuffer.setCharAt(this.mStart + i5, 'm');
                        }
                        this.mStart = -1;
                    }
                    return str.toLowerCase(Locale.ROOT);
                case 'Y':
                case 'y':
                    this.mStart = -1;
                    if (str.length() == 1) {
                        str = "yy";
                    } else if (str.length() == 3) {
                        str = "yyyy";
                    }
                    return str.toLowerCase(Locale.ROOT);
                default:
                    return null;
            }
        }

        public void updatePositions(int i5, int i6) {
            int i7 = this.hStart;
            if (i5 < i7) {
                this.hStart = i7 + i6;
            }
            int i8 = this.mStart;
            if (i5 < i8) {
                this.mStart = i8 + i6;
            }
        }
    }

    public CellDateFormatter(String str) {
        this(LocaleUtil.getUserLocale(), str);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x000e */
    @Override // org.apache.poi.ss.format.CellFormatter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void formatValue(java.lang.StringBuffer r18, java.lang.Object r19) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.ss.format.CellDateFormatter.formatValue(java.lang.StringBuffer, java.lang.Object):void");
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void simpleValue(StringBuffer stringBuffer, Object obj) {
        CellDateFormatter cellDateFormatter = SIMPLE_DATE_FORMATTER;
        if (cellDateFormatter == null) {
            synchronized (CellDateFormatter.class) {
                try {
                    cellDateFormatter = SIMPLE_DATE_FORMATTER;
                    if (cellDateFormatter == null) {
                        cellDateFormatter = new CellDateFormatter("mm/d/y");
                        SIMPLE_DATE_FORMATTER = cellDateFormatter;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        cellDateFormatter.formatValue(stringBuffer, obj);
    }

    public CellDateFormatter(Locale locale, String str) {
        super(str);
        DatePartHandler datePartHandler = new DatePartHandler();
        StringBuffer format = CellFormatPart.parseFormat(str, CellFormatType.DATE, datePartHandler);
        datePartHandler.finish(format);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format.toString(), locale);
        this.dateFmt = simpleDateFormat;
        simpleDateFormat.setTimeZone(LocaleUtil.getUserTimeZone());
    }
}
