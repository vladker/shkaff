package org.apache.logging.log4j.util;

import java.util.Collection;
import java.util.Map;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EnvironmentPropertySource implements PropertySource {
    private static final int DEFAULT_PRIORITY = 100;
    private static final String PREFIX = "LOG4J_";

    private void logException(SecurityException securityException) {
        LowLevelLogUtil.logException("The system environment variables are not available to Log4j due to security restrictions: " + securityException, securityException);
    }

    @Override // org.apache.logging.log4j.util.PropertySource
    public boolean containsProperty(String str) {
        try {
            return System.getenv().containsKey(str);
        } catch (SecurityException e) {
            logException(e);
            return super.containsProperty(str);
        }
    }

    @Override // org.apache.logging.log4j.util.PropertySource
    public void forEach(BiConsumer<String, String> biConsumer) {
        try {
            for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
                String key = entry.getKey();
                if (key.startsWith(PREFIX)) {
                    biConsumer.accept(key.substring(6), entry.getValue());
                }
            }
        } catch (SecurityException e) {
            logException(e);
        }
    }

    @Override // org.apache.logging.log4j.util.PropertySource
    public CharSequence getNormalForm(Iterable<? extends CharSequence> iterable) {
        StringBuilder sb = new StringBuilder("LOG4J");
        for (CharSequence charSequence : iterable) {
            sb.append(NameUtil.USCORE);
            for (int i5 = 0; i5 < charSequence.length(); i5++) {
                sb.append(Character.toUpperCase(charSequence.charAt(i5)));
            }
        }
        return sb.toString();
    }

    @Override // org.apache.logging.log4j.util.PropertySource
    public int getPriority() {
        return 100;
    }

    @Override // org.apache.logging.log4j.util.PropertySource
    public String getProperty(String str) {
        try {
            return System.getenv(str);
        } catch (SecurityException e) {
            logException(e);
            return super.getProperty(str);
        }
    }

    @Override // org.apache.logging.log4j.util.PropertySource
    public Collection<String> getPropertyNames() {
        try {
            return System.getenv().keySet();
        } catch (SecurityException e) {
            logException(e);
            return super.getPropertyNames();
        }
    }
}
