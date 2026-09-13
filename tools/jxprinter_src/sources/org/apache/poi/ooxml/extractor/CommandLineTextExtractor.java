package org.apache.poi.ooxml.extractor;

import java.io.File;
import java.io.IOException;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.extractor.POITextExtractor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class CommandLineTextExtractor {
    public static final String DIVIDER = "=======================";

    private CommandLineTextExtractor() {
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length < 1) {
            System.err.println("Use:");
            System.err.println("   CommandLineTextExtractor <filename> [filename] [filename]");
            System.exit(1);
        }
        for (String str : strArr) {
            System.out.println(DIVIDER);
            File file = new File(str);
            System.out.println(file);
            POITextExtractor pOITextExtractorCreateExtractor = ExtractorFactory.createExtractor(file);
            try {
                POITextExtractor metadataTextExtractor = pOITextExtractorCreateExtractor.getMetadataTextExtractor();
                System.out.println("   =======================");
                String text = metadataTextExtractor.getText();
                System.out.println(text);
                System.out.println("   =======================");
                String text2 = pOITextExtractorCreateExtractor.getText();
                System.out.println(text2);
                System.out.println(DIVIDER);
                System.out.println("Had " + text.length() + " characters of metadata and " + text2.length() + " characters of text");
                pOITextExtractorCreateExtractor.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (pOITextExtractorCreateExtractor != null) {
                        try {
                            pOITextExtractorCreateExtractor.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
    }
}
