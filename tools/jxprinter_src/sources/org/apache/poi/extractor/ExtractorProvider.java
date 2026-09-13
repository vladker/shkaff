package org.apache.poi.extractor;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.FileMagic;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ExtractorProvider {
    boolean accepts(FileMagic fileMagic);

    POITextExtractor create(File file, String str);

    POITextExtractor create(InputStream inputStream, String str);

    POITextExtractor create(DirectoryNode directoryNode, String str);

    default void identifyEmbeddedResources(POIOLE2TextExtractor pOIOLE2TextExtractor, List<Entry> list, List<InputStream> list2) {
        throw new IllegalArgumentException("Error checking for Scratchpad embedded resources");
    }
}
