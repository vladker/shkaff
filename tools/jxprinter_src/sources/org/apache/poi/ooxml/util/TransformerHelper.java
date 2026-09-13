package org.apache.poi.ooxml.util;

import javax.xml.transform.TransformerFactory;
import org.apache.poi.util.Removal;
import org.apache.poi.util.XMLHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Removal(version = "6.0.0")
@Deprecated
public final class TransformerHelper {
    private TransformerHelper() {
    }

    public static TransformerFactory getFactory() {
        return XMLHelper.getTransformerFactory();
    }
}
