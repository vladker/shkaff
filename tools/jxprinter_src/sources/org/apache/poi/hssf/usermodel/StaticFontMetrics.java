package org.apache.poi.hssf.usermodel;

import com.alibaba.android.arouter.utils.Consts;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class StaticFontMetrics {
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) StaticFontMetrics.class);
    private static final Map<String, FontDetails> fontDetailsMap = new HashMap();
    private static Properties fontMetricsProps;

    private StaticFontMetrics() {
    }

    public static synchronized FontDetails getFontDetails(Font font) {
        FontDetails fontDetailsCreate;
        if (fontMetricsProps == null) {
            try {
                fontMetricsProps = loadMetrics();
            } catch (IOException e) {
                throw new RuntimeException("Could not load font metrics", e);
            }
        }
        String name = font.getName();
        String str = font.isPlain() ? "plain" : "";
        if (font.isBold()) {
            str = str + "bold";
        }
        if (font.isItalic()) {
            str = str + "italic";
        }
        String strBuildFontHeightProperty = FontDetails.buildFontHeightProperty(name);
        String strBuildFontHeightProperty2 = FontDetails.buildFontHeightProperty(name + Consts.DOT + str);
        if (fontMetricsProps.get(strBuildFontHeightProperty) == null && fontMetricsProps.get(strBuildFontHeightProperty2) != null) {
            name = name + Consts.DOT + str;
        }
        Map<String, FontDetails> map = fontDetailsMap;
        fontDetailsCreate = map.get(name);
        if (fontDetailsCreate == null) {
            fontDetailsCreate = FontDetails.create(name, fontMetricsProps);
            map.put(name, fontDetailsCreate);
        }
        return fontDetailsCreate;
    }

    private static Properties loadMetrics() throws IOException {
        File file;
        SecurityException e;
        File file2 = null;
        try {
            String property = System.getProperty("font.metrics.filename");
            if (property != null) {
                file = new File(property);
                try {
                    if (file.exists()) {
                        file2 = file;
                    } else {
                        LOGGER.atWarn().log("font_metrics.properties not found at path {}", file.getAbsolutePath());
                    }
                } catch (SecurityException e6) {
                    e = e6;
                    LOGGER.atWarn().withThrowable(e).log("Can't access font.metrics.filename system property");
                }
            }
        } catch (SecurityException e7) {
            file = null;
            e = e7;
        }
        InputStream fileInputStream = file2 != null ? new FileInputStream(file2) : FontDetails.class.getResourceAsStream("/font_metrics.properties");
        try {
            if (fileInputStream == null) {
                throw new IOException("font_metrics.properties not found in classpath");
            }
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            return properties;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
