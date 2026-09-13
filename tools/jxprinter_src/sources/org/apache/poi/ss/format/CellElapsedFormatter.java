package org.apache.poi.ss.format;

import A3.AbstractC0157z;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CellElapsedFormatter extends CellFormatter {
    private static final double HOUR__FACTOR = 0.041666666666666664d;
    private static final double MIN__FACTOR = 6.944444444444444E-4d;
    private static final Pattern PERCENTS = Pattern.compile("%");
    private static final double SEC__FACTOR = 1.1574074074074073E-5d;
    private final String printfFmt;
    private final List<TimeSpec> specs;
    private TimeSpec topmost;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class ElapsedPartHandler implements CellFormatPart.PartHandler {
        private ElapsedPartHandler() {
        }

        @Override // org.apache.poi.ss.format.CellFormatPart.PartHandler
        public String handlePart(Matcher matcher, String str, CellFormatType cellFormatType, StringBuffer stringBuffer) {
            int length = stringBuffer.length();
            char cCharAt = str.charAt(0);
            if (cCharAt == '\n') {
                return "%n";
            }
            if (cCharAt == '\"') {
                str = androidx.collection.a.g(1, 1, str);
            } else {
                if (cCharAt != '*') {
                    if (cCharAt != '0') {
                        if (cCharAt == '_') {
                            return null;
                        }
                        if (cCharAt != 'h' && cCharAt != 'm' && cCharAt != 's') {
                            if (cCharAt != '[') {
                                if (cCharAt == '\\') {
                                    str = str.substring(1);
                                }
                            } else if (str.length() >= 3) {
                                if (CellElapsedFormatter.this.topmost != null) {
                                    throw new IllegalArgumentException("Duplicate '[' times in format");
                                }
                                String lowerCase = str.toLowerCase(Locale.ROOT);
                                int length2 = lowerCase.length();
                                CellElapsedFormatter cellElapsedFormatter = CellElapsedFormatter.this;
                                cellElapsedFormatter.topmost = cellElapsedFormatter.assignSpec(lowerCase.charAt(1), length, length2 - 2);
                                return lowerCase.substring(1, length2 - 1);
                            }
                        }
                    }
                    String lowerCase2 = str.toLowerCase(Locale.ROOT);
                    CellElapsedFormatter.this.assignSpec(lowerCase2.charAt(0), length, lowerCase2.length());
                    return lowerCase2;
                }
                if (str.length() > 1) {
                    str = CellFormatPart.expandChar(str);
                }
            }
            return CellElapsedFormatter.PERCENTS.matcher(str).replaceAll("%%");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class TimeSpec {
        final double factor;
        final int len;
        double modBy = 0.0d;
        final int pos;
        final char type;

        public TimeSpec(char c, int i5, int i6, double d) {
            this.type = c;
            this.pos = i5;
            this.len = i6;
            this.factor = d;
        }

        public long valueFor(double d) {
            double d6 = this.modBy;
            double d7 = d6 == 0.0d ? d / this.factor : (d / this.factor) % d6;
            return this.type == '0' ? Math.round(d7) : (long) d7;
        }
    }

    public CellElapsedFormatter(String str) {
        super(str);
        ArrayList arrayList = new ArrayList();
        this.specs = arrayList;
        StringBuffer format = CellFormatPart.parseFormat(str, CellFormatType.ELAPSED, new ElapsedPartHandler());
        ListIterator listIterator = arrayList.listIterator(arrayList.size());
        while (listIterator.hasPrevious()) {
            TimeSpec timeSpec = (TimeSpec) listIterator.previous();
            int i5 = timeSpec.pos;
            format.replace(i5, timeSpec.len + i5, AbstractC0157z.l("d", timeSpec.len, new StringBuilder("%0")));
            char c = timeSpec.type;
            if (c != this.topmost.type) {
                timeSpec.modBy = modFor(c, timeSpec.len);
            }
        }
        this.printfFmt = format.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TimeSpec assignSpec(char c, int i5, int i6) {
        TimeSpec timeSpec = new TimeSpec(c, i5, i6, factorFor(c, i6));
        this.specs.add(timeSpec);
        return timeSpec;
    }

    private static double factorFor(char c, int i5) {
        if (c == '0') {
            return SEC__FACTOR / Math.pow(10.0d, i5);
        }
        if (c == 'h') {
            return HOUR__FACTOR;
        }
        if (c == 'm') {
            return MIN__FACTOR;
        }
        if (c == 's') {
            return SEC__FACTOR;
        }
        throw new IllegalArgumentException(androidx.exifinterface.media.a.h("Uknown elapsed time spec: ", c));
    }

    private static double modFor(char c, int i5) {
        if (c == '0') {
            return Math.pow(10.0d, i5);
        }
        if (c == 'h') {
            return 24.0d;
        }
        if (c == 'm' || c == 's') {
            return 60.0d;
        }
        throw new IllegalArgumentException(androidx.exifinterface.media.a.h("Uknown elapsed time spec: ", c));
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void formatValue(StringBuffer stringBuffer, Object obj) {
        double dDoubleValue = ((Number) obj).doubleValue();
        if (dDoubleValue < 0.0d) {
            stringBuffer.append('-');
            dDoubleValue = -dDoubleValue;
        }
        Long[] lArr = new Long[this.specs.size()];
        for (int i5 = 0; i5 < this.specs.size(); i5++) {
            lArr[i5] = Long.valueOf(this.specs.get(i5).valueFor(dDoubleValue));
        }
        Formatter formatter = new Formatter(stringBuffer, Locale.ROOT);
        try {
            formatter.format(this.printfFmt, lArr);
            formatter.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    formatter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void simpleValue(StringBuffer stringBuffer, Object obj) {
        formatValue(stringBuffer, obj);
    }
}
