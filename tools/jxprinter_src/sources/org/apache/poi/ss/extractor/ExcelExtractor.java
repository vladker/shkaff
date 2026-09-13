package org.apache.poi.ss.extractor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ExcelExtractor {
    String getText();

    void setFormulasNotResults(boolean z6);

    void setIncludeCellComments(boolean z6);

    void setIncludeHeadersFooters(boolean z6);

    void setIncludeSheetNames(boolean z6);
}
