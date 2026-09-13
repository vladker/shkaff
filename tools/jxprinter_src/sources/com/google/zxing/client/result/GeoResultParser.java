package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class GeoResultParser extends ResultParser {
    private static final Pattern GEO_URL_PATTERN = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    @Override // com.google.zxing.client.result.ResultParser
    public GeoParsedResult parse(Result result) {
        Matcher matcher = GEO_URL_PATTERN.matcher(ResultParser.getMassagedText(result));
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(4);
        try {
            double d = Double.parseDouble(matcher.group(1));
            if (d <= 90.0d && d >= -90.0d) {
                double d6 = Double.parseDouble(matcher.group(2));
                if (d6 <= 180.0d && d6 >= -180.0d) {
                    double d7 = 0.0d;
                    if (matcher.group(3) != null) {
                        double d8 = Double.parseDouble(matcher.group(3));
                        if (d8 < 0.0d) {
                            return null;
                        }
                        d7 = d8;
                    }
                    return new GeoParsedResult(d, d6, d7, strGroup);
                }
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }
}
