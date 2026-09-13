package org.apache.logging.log4j.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PropertyFilePropertySource extends PropertiesPropertySource {
    public PropertyFilePropertySource(String str) {
        this(str, true);
    }

    private static Properties loadPropertiesFile(String str, boolean z6) {
        Properties properties = new Properties();
        for (URL url : LoaderUtil.findResources(str, z6)) {
            try {
                InputStream inputStreamOpenStream = url.openStream();
                try {
                    properties.load(inputStreamOpenStream);
                    if (inputStreamOpenStream != null) {
                        inputStreamOpenStream.close();
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (inputStreamOpenStream != null) {
                            try {
                                inputStreamOpenStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (IOException e) {
                LowLevelLogUtil.logException("Unable to read " + url, e);
            }
        }
        return properties;
    }

    public PropertyFilePropertySource(String str, boolean z6) {
        super(loadPropertiesFile(str, z6));
    }
}
