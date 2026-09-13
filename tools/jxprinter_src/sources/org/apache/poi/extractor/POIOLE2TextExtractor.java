package org.apache.poi.extractor;

import org.apache.poi.POIDocument;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hpsf.extractor.HPSFPropertiesExtractor;
import org.apache.poi.poifs.filesystem.DirectoryEntry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface POIOLE2TextExtractor extends POITextExtractor {
    default DocumentSummaryInformation getDocSummaryInformation() {
        return getDocument().getDocumentSummaryInformation();
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    POIDocument getDocument();

    @Override // org.apache.poi.extractor.POITextExtractor
    default POITextExtractor getMetadataTextExtractor() {
        return new HPSFPropertiesExtractor(this);
    }

    default DirectoryEntry getRoot() {
        return getDocument().getDirectory();
    }

    default SummaryInformation getSummaryInformation() {
        return getDocument().getSummaryInformation();
    }
}
