package org.apache.poi.ooxml.util;

import java.util.Locale;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.openxmlformats.schemas.drawingml.x2006.chart.STDepthPercent;
import org.openxmlformats.schemas.drawingml.x2006.chart.STGapAmount;
import org.openxmlformats.schemas.drawingml.x2006.chart.STHPercent;
import org.openxmlformats.schemas.drawingml.x2006.chart.STHoleSize;
import org.openxmlformats.schemas.drawingml.x2006.chart.STOverlap;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate32;
import org.openxmlformats.schemas.drawingml.x2006.main.STPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveFixedPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositivePercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextBulletSizePercent;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextFontScalePercentOrPercentString;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextPoint;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextSpacingPercentOrPercentString;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STOnOff;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumberOrPercent;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMeasurementOrPercent;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STSignedHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STSignedTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextScale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class POIXMLUnits {
    public static long parseLength(STCoordinate32 sTCoordinate32) {
        return parseLengthInner(sTCoordinate32, 1.0d);
    }

    private static long parseLengthInner(XmlAnySimpleType xmlAnySimpleType, double d) {
        double d6;
        String lowerCase = xmlAnySimpleType.getStringValue().toLowerCase(Locale.ROOT);
        double d7 = Double.parseDouble(lowerCase.replaceAll("(mm|cm|in|pt|pc|pi)", ""));
        if (!lowerCase.endsWith("mm")) {
            if (!lowerCase.endsWith("cm")) {
                if (!lowerCase.endsWith("in")) {
                    if (lowerCase.endsWith("pc") || lowerCase.endsWith("pi")) {
                        d7 *= 0.16599999368190765d;
                    } else {
                        d6 = lowerCase.endsWith("pt") ? d7 * 12700.0d : d7 * d;
                    }
                }
                return (long) d6;
            }
            d6 = d7 * 914400.0d;
            return (long) d6;
        }
        d7 /= 10.0d;
        d7 /= 2.5399999618530273d;
        d6 = d7 * 914400.0d;
        return (long) d6;
    }

    public static boolean parseOnOff(CTOnOff cTOnOff) {
        if (cTOnOff == null) {
            return false;
        }
        if (cTOnOff.isSetVal()) {
            return parseOnOff(cTOnOff.xgetVal());
        }
        return true;
    }

    public static int parsePercent(STPositivePercentage sTPositivePercentage) {
        return parsePercentInner(sTPositivePercentage, 1);
    }

    private static int parsePercentInner(XmlAnySimpleType xmlAnySimpleType, int i5) {
        String stringValue = xmlAnySimpleType.getStringValue();
        return stringValue.endsWith("%") ? Integer.parseInt(stringValue.substring(0, stringValue.length() - 1)) * 1000 : Integer.parseInt(stringValue) * i5;
    }

    public static long parseLength(STCoordinate sTCoordinate) {
        return parseLengthInner(sTCoordinate, 1.0d);
    }

    public static int parsePercent(STPositiveFixedPercentage sTPositiveFixedPercentage) {
        return parsePercentInner(sTPositiveFixedPercentage, 1);
    }

    public static long parseLength(STTextPoint sTTextPoint) {
        return parseLengthInner(sTTextPoint, 127.0d);
    }

    public static boolean parseOnOff(STOnOff sTOnOff) {
        if (sTOnOff == null) {
            return false;
        }
        String stringValue = sTOnOff.getStringValue();
        return "true".equalsIgnoreCase(stringValue) || "on".equalsIgnoreCase(stringValue) || "x".equalsIgnoreCase(stringValue) || "1".equals(stringValue);
    }

    public static int parsePercent(STPercentage sTPercentage) {
        return parsePercentInner(sTPercentage, 1);
    }

    public static long parseLength(STTwipsMeasure sTTwipsMeasure) {
        return parseLengthInner(sTTwipsMeasure, 635.0d);
    }

    public static int parsePercent(STTextBulletSizePercent sTTextBulletSizePercent) {
        return parsePercentInner(sTTextBulletSizePercent, 1);
    }

    public static long parseLength(STSignedTwipsMeasure sTSignedTwipsMeasure) {
        return parseLengthInner(sTSignedTwipsMeasure, 635.0d);
    }

    public static int parsePercent(STTextSpacingPercentOrPercentString sTTextSpacingPercentOrPercentString) {
        return parsePercentInner(sTTextSpacingPercentOrPercentString, 1);
    }

    public static long parseLength(STHpsMeasure sTHpsMeasure) {
        return parseLengthInner(sTHpsMeasure, 25400.0d);
    }

    public static int parsePercent(STTextFontScalePercentOrPercentString sTTextFontScalePercentOrPercentString) {
        return parsePercentInner(sTTextFontScalePercentOrPercentString, 1);
    }

    public static long parseLength(STSignedHpsMeasure sTSignedHpsMeasure) {
        return parseLengthInner(sTSignedHpsMeasure, 25400.0d);
    }

    public static int parsePercent(STDecimalNumberOrPercent sTDecimalNumberOrPercent) {
        return parsePercentInner(sTDecimalNumberOrPercent, 1000);
    }

    public static long parseLength(STMeasurementOrPercent sTMeasurementOrPercent) {
        if (sTMeasurementOrPercent.getStringValue().endsWith("%")) {
            return -1L;
        }
        return parseLengthInner(sTMeasurementOrPercent, 635.0d);
    }

    public static int parsePercent(STTextScale sTTextScale) {
        return parsePercentInner(sTTextScale, 1000);
    }

    public static int parsePercent(STGapAmount sTGapAmount) {
        return parsePercentInner(sTGapAmount, 1000);
    }

    public static int parsePercent(STOverlap sTOverlap) {
        return parsePercentInner(sTOverlap, 1000);
    }

    public static int parsePercent(STDepthPercent sTDepthPercent) {
        return parsePercentInner(sTDepthPercent, 1000);
    }

    public static int parsePercent(STHPercent sTHPercent) {
        return parsePercentInner(sTHPercent, 1000);
    }

    public static int parsePercent(STHoleSize sTHoleSize) {
        return parsePercentInner(sTHoleSize, 1);
    }
}
