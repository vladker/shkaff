package org.apache.poi.ss.format;

import java.util.Locale;
import java.util.regex.Matcher;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CellTextFormatter extends CellFormatter {
    static final CellFormatter SIMPLE_TEXT = new CellTextFormatter("@");
    private final String desc;
    private final int[] textPos;

    public CellTextFormatter(String str) {
        super(str);
        final int[] iArr = new int[1];
        String string = CellFormatPart.parseFormat(str, CellFormatType.TEXT, new CellFormatPart.PartHandler() { // from class: org.apache.poi.ss.format.b
            @Override // org.apache.poi.ss.format.CellFormatPart.PartHandler
            public final String handlePart(Matcher matcher, String str2, CellFormatType cellFormatType, StringBuffer stringBuffer) {
                return CellTextFormatter.lambda$new$0(iArr, matcher, str2, cellFormatType, stringBuffer);
            }
        }).toString();
        this.desc = string;
        this.textPos = new int[iArr[0]];
        int length = string.length() - 1;
        int i5 = 0;
        while (true) {
            int[] iArr2 = this.textPos;
            if (i5 >= iArr2.length) {
                return;
            }
            iArr2[i5] = this.desc.lastIndexOf(0, length);
            length = this.textPos[i5] - 1;
            i5++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$0(int[] iArr, Matcher matcher, String str, CellFormatType cellFormatType, StringBuffer stringBuffer) {
        if (!str.equals("@")) {
            return null;
        }
        iArr[0] = iArr[0] + 1;
        return WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR;
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void formatValue(StringBuffer stringBuffer, Object obj) {
        int length = stringBuffer.length();
        String string = obj.toString();
        if (obj instanceof Boolean) {
            string = string.toUpperCase(Locale.ROOT);
        }
        stringBuffer.append(this.desc);
        for (int i5 : this.textPos) {
            int i6 = i5 + length;
            stringBuffer.replace(i6, i6 + 1, string);
        }
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void simpleValue(StringBuffer stringBuffer, Object obj) {
        SIMPLE_TEXT.formatValue(stringBuffer, obj);
    }
}
