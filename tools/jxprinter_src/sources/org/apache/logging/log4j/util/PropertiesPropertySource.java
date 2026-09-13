package org.apache.logging.log4j.util;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PropertiesPropertySource implements PropertySource {
    private static final int DEFAULT_PRIORITY = 200;
    private static final String PREFIX = "log4j2.";
    private final int priority;
    private final Properties properties;

    public PropertiesPropertySource(Properties properties) {
        this(properties, 200);
    }

    @Override // org.apache.logging.log4j.util.PropertySource
    public boolean containsProperty(String str) {
        return getProperty(str) != null;
    }

    @Override // org.apache.logging.log4j.util.PropertySource
    public void forEach(BiConsumer<String, String> biConsumer) {
        for (Map.Entry entry : this.properties.entrySet()) {
            biConsumer.accept((String) entry.getKey(), (String) entry.getValue());
        }
    }

    @Override // org.apache.logging.log4j.util.PropertySource
    public CharSequence getNormalForm(Iterable<? extends CharSequence> iterable) {
        return PREFIX + ((Object) PropertySource.Util.joinAsCamelCase(iterable));
    }

    @Override // org.apache.logging.log4j.util.PropertySource
    public int getPriority() {
        return this.priority;
    }

    @Override // org.apache.logging.log4j.util.PropertySource
    public String getProperty(String str) {
        return this.properties.getProperty(str);
    }

    @Override // org.apache.logging.log4j.util.PropertySource
    public Collection<String> getPropertyNames() {
        return this.properties.stringPropertyNames();
    }

    public PropertiesPropertySource(Properties properties, int i5) {
        this.properties = properties;
        this.priority = i5;
    }
}
