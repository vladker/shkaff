package org.apache.poi.ooxml.extractor;

import A3.AbstractC0157z;
import org.apache.poi.extractor.POITextExtractor;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.POIXMLProperties;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.util.ZipSecureFile;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface POIXMLTextExtractor extends POITextExtractor {
    default void checkMaxTextSize(CharSequence charSequence, String str) {
        if (str == null) {
            return;
        }
        int length = str.length() + charSequence.length();
        if (length <= ZipSecureFile.getMaxTextSize()) {
            return;
        }
        StringBuilder sbT = AbstractC0157z.t(length, "The text would exceed the max allowed overall size of extracted text. By default this is prevented as some documents may exhaust available memory and it may indicate that the file is used to inflate memory usage and thus could pose a security risk. You can adjust this limit via ZipSecureFile.setMaxTextSize() if you need to work with files which have a lot of text. Size: ", ", limit: MAX_TEXT_SIZE: ");
        sbT.append(ZipSecureFile.getMaxTextSize());
        throw new IllegalStateException(sbT.toString());
    }

    @Override // org.apache.poi.extractor.POITextExtractor, java.io.Closeable, java.lang.AutoCloseable
    default void close() {
        OPCPackage oPCPackage;
        if (!isCloseFilesystem() || (oPCPackage = getPackage()) == null) {
            return;
        }
        oPCPackage.revert();
    }

    default POIXMLProperties.CoreProperties getCoreProperties() {
        return getDocument().getProperties().getCoreProperties();
    }

    default POIXMLProperties.CustomProperties getCustomProperties() {
        return getDocument().getProperties().getCustomProperties();
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    POIXMLDocument getDocument();

    default POIXMLProperties.ExtendedProperties getExtendedProperties() {
        return getDocument().getProperties().getExtendedProperties();
    }

    default OPCPackage getPackage() {
        POIXMLDocument document = getDocument();
        if (document != null) {
            return document.getPackage();
        }
        return null;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    default POIXMLPropertiesTextExtractor getMetadataTextExtractor() {
        return new POIXMLPropertiesTextExtractor(getDocument());
    }
}
