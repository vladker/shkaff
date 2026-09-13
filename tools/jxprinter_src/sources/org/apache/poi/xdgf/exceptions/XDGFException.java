package org.apache.poi.xdgf.exceptions;

import A3.AbstractC0157z;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDGFException {
    public static POIXMLException error(String str, Object obj) {
        return new POIXMLException(obj + ": " + str);
    }

    public static POIXMLException wrap(POIXMLDocumentPart pOIXMLDocumentPart, POIXMLException pOIXMLException) {
        String str = pOIXMLDocumentPart.getPackagePart().getPartName() + ": " + pOIXMLException.getMessage();
        Throwable cause = pOIXMLException.getCause();
        POIXMLException cause2 = pOIXMLException;
        if (cause != null) {
            cause2 = pOIXMLException.getCause();
        }
        return new POIXMLException(str, cause2);
    }

    public static POIXMLException error(String str, Object obj, Throwable th) {
        return new POIXMLException(obj + ": " + str, th);
    }

    public static POIXMLException wrap(String str, POIXMLException pOIXMLException) {
        StringBuilder sbX = AbstractC0157z.x(str, ": ");
        sbX.append(pOIXMLException.getMessage());
        String string = sbX.toString();
        Throwable cause = pOIXMLException.getCause();
        POIXMLException cause2 = pOIXMLException;
        if (cause != null) {
            cause2 = pOIXMLException.getCause();
        }
        return new POIXMLException(string, cause2);
    }
}
