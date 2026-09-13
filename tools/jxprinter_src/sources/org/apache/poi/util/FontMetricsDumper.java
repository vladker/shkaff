package org.apache.poi.util;

import A3.AbstractC0157z;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FontMetricsDumper {
    @SuppressForbidden("command line tool")
    public static void main(String[] strArr) throws IOException {
        Properties properties = new Properties();
        for (Font font : GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()) {
            String fontName = font.getFontName();
            FontMetrics fontMetrics = Toolkit.getDefaultToolkit().getFontMetrics(new Font(fontName, 1, 10));
            properties.setProperty(AbstractC0157z.o("font.", fontName, ".height"), fontMetrics.getHeight() + "");
            StringBuilder sb = new StringBuilder();
            for (char c = 'a'; c <= 'z'; c = (char) (c + 1)) {
                sb.append(c);
                sb.append(", ");
            }
            for (char c6 = 'A'; c6 <= 'Z'; c6 = (char) (c6 + 1)) {
                sb.append(c6);
                sb.append(", ");
            }
            for (char c7 = '0'; c7 <= '9'; c7 = (char) (c7 + 1)) {
                sb.append(c7);
                sb.append(", ");
            }
            StringBuilder sb2 = new StringBuilder();
            for (char c8 = 'a'; c8 <= 'z'; c8 = (char) (c8 + 1)) {
                sb2.append(fontMetrics.getWidths()[c8]);
                sb2.append(", ");
            }
            for (char c9 = 'A'; c9 <= 'Z'; c9 = (char) (c9 + 1)) {
                sb2.append(fontMetrics.getWidths()[c9]);
                sb2.append(", ");
            }
            for (char c10 = '0'; c10 <= '9'; c10 = (char) (c10 + 1)) {
                sb2.append(fontMetrics.getWidths()[c10]);
                sb2.append(", ");
            }
            properties.setProperty(AbstractC0157z.o("font.", fontName, ".characters"), sb.toString());
            properties.setProperty("font." + fontName + ".widths", sb2.toString());
        }
        FileOutputStream fileOutputStream = new FileOutputStream("font_metrics.properties");
        try {
            properties.store(fileOutputStream, "Font Metrics");
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileOutputStream.close();
                    throw th2;
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                    throw th2;
                }
            }
        }
    }
}
