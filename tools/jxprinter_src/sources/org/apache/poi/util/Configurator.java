package org.apache.poi.util;

import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Configurator {
    private static final Logger LOG = LogManager.getLogger((Class<?>) Configurator.class);

    public static int getIntValue(String str, int i5) {
        String property = System.getProperty(str);
        if (property != null && !"".equals(property) && !AbstractC1127c.NULL.equals(property)) {
            try {
                return Integer.parseInt(property);
            } catch (Exception unused) {
                LOG.atError().log("System property -D{} does not contains a valid integer: {}", str, property);
            }
        }
        return i5;
    }
}
