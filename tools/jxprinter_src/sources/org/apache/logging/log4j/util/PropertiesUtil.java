package org.apache.logging.log4j.util;

import com.alibaba.android.arouter.utils.Consts;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.nio.charset.Charset;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class PropertiesUtil {
    private static final String LOG4J_SYSTEM_PROPERTIES_FILE_NAME = "log4j2.system.properties";
    private final Environment environment;
    private static final String LOG4J_PROPERTIES_FILE_NAME = "log4j2.component.properties";
    private static final PropertiesUtil LOG4J_PROPERTIES = new PropertiesUtil(LOG4J_PROPERTIES_FILE_NAME, false);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Environment {
        private final Map<String, String> literal;
        private final Map<String, String> normalized;
        private final Set<PropertySource> sources;
        private final Map<List<CharSequence>, String> tokenized;

        /* JADX INFO: Access modifiers changed from: private */
        public boolean containsKey(final String str) {
            final List<CharSequence> list = PropertySource.Util.tokenize(str);
            return this.normalized.containsKey(str) || this.literal.containsKey(str) || this.tokenized.containsKey(list) || this.sources.stream().anyMatch(new Predicate() { // from class: org.apache.logging.log4j.util.g
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return PropertiesUtil.Environment.lambda$containsKey$4(list, str, (PropertySource) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String get(String str) {
            if (this.normalized.containsKey(str)) {
                return this.normalized.get(str);
            }
            if (this.literal.containsKey(str)) {
                return this.literal.get(str);
            }
            List<CharSequence> list = PropertySource.Util.tokenize(str);
            for (PropertySource propertySource : this.sources) {
                String string = Objects.toString(propertySource.getNormalForm(list), null);
                if (string != null && propertySource.containsProperty(string)) {
                    return propertySource.getProperty(string);
                }
                if (propertySource.containsProperty(str)) {
                    return propertySource.getProperty(str);
                }
            }
            return this.tokenized.get(list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$containsKey$4(List list, String str, PropertySource propertySource) {
            CharSequence normalForm = propertySource.getNormalForm(list);
            if (propertySource.containsProperty(str)) {
                return true;
            }
            return normalForm != null && propertySource.containsProperty(normalForm.toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$new$0(String str, String str2) {
            if (System.getProperty(str) == null) {
                System.setProperty(str, str2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$null$2(String str, List list, PropertySource propertySource) {
            String property;
            String property2 = propertySource.getProperty(str);
            if (property2 != null) {
                this.literal.putIfAbsent(str, property2);
                if (!list.isEmpty()) {
                    this.tokenized.putIfAbsent(list, property2);
                }
            }
            CharSequence normalForm = propertySource.getNormalForm(list);
            if (normalForm == null || (property = propertySource.getProperty(normalForm.toString())) == null) {
                return;
            }
            this.normalized.putIfAbsent(str, property);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Collection lambda$reload$1(Collection collection, Collection collection2) {
            collection.addAll(collection2);
            return collection;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$reload$3(final String str) {
            final List<CharSequence> list = PropertySource.Util.tokenize(str);
            this.sources.forEach(new Consumer() { // from class: org.apache.logging.log4j.util.b
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f6945a.lambda$null$2(str, list, (PropertySource) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void reload() {
            this.literal.clear();
            this.normalized.clear();
            this.tokenized.clear();
            HashSet hashSet = new HashSet();
            this.sources.stream().map(new d()).reduce(hashSet, new e());
            hashSet.stream().filter(new com.appdev.standard.page.mine.b()).forEach(new f(this, 0));
        }

        private Environment(PropertySource propertySource) {
            this.sources = new TreeSet(new PropertySource.Comparator());
            this.literal = new ConcurrentHashMap();
            this.normalized = new ConcurrentHashMap();
            this.tokenized = new ConcurrentHashMap();
            try {
                new PropertyFilePropertySource(PropertiesUtil.LOG4J_SYSTEM_PROPERTIES_FILE_NAME, false).forEach(new c());
            } catch (SecurityException unused) {
            }
            this.sources.add(propertySource);
            Stream streamLoadServices = ServiceLoaderUtil.loadServices(PropertySource.class, MethodHandles.lookup(), false, false);
            Set<PropertySource> set = this.sources;
            set.getClass();
            streamLoadServices.forEach(new f(set, 1));
            reload();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum TimeUnit {
        NANOS("ns,nano,nanos,nanosecond,nanoseconds", ChronoUnit.NANOS),
        MICROS("us,micro,micros,microsecond,microseconds", ChronoUnit.MICROS),
        MILLIS("ms,milli,millis,millsecond,milliseconds", ChronoUnit.MILLIS),
        SECONDS("s,second,seconds", ChronoUnit.SECONDS),
        MINUTES("m,minute,minutes", ChronoUnit.MINUTES),
        HOURS("h,hour,hours", ChronoUnit.HOURS),
        DAYS("d,day,days", ChronoUnit.DAYS);

        private final String[] descriptions;
        private final ChronoUnit timeUnit;

        TimeUnit(String str, ChronoUnit chronoUnit) {
            this.descriptions = str.split(",");
            this.timeUnit = chronoUnit;
        }

        public static Duration getDuration(String str) {
            String strTrim = str.trim();
            ChronoUnit chronoUnit = ChronoUnit.MILLIS;
            long j6 = 0;
            for (TimeUnit timeUnit : values()) {
                for (String str2 : timeUnit.descriptions) {
                    if (strTrim.endsWith(str2)) {
                        chronoUnit = timeUnit.timeUnit;
                        j6 = Long.parseLong(strTrim.substring(0, strTrim.length() - str2.length()));
                    }
                }
            }
            return Duration.of(j6, chronoUnit);
        }

        public ChronoUnit getTimeUnit() {
            return this.timeUnit;
        }
    }

    public PropertiesUtil(Properties properties) {
        this(new PropertiesPropertySource(properties));
    }

    public static Properties extractSubset(Properties properties, String str) {
        Properties properties2 = new Properties();
        if (str != null && str.length() != 0) {
            if (str.charAt(str.length() - 1) != '.') {
                str = str.concat(Consts.DOT);
            }
            ArrayList arrayList = new ArrayList();
            for (String str2 : properties.stringPropertyNames()) {
                if (str2.startsWith(str)) {
                    properties2.setProperty(str2.substring(str.length()), properties.getProperty(str2));
                    arrayList.add(str2);
                }
            }
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                properties.remove((String) obj);
            }
        }
        return properties2;
    }

    public static ResourceBundle getCharsetsResourceBundle() {
        return ResourceBundle.getBundle("Log4j-charsets");
    }

    public static PropertiesUtil getProperties() {
        return LOG4J_PROPERTIES;
    }

    public static Properties getSystemProperties() {
        try {
            return new Properties(System.getProperties());
        } catch (SecurityException e) {
            LowLevelLogUtil.logException("Unable to access system properties.", e);
            return new Properties();
        }
    }

    public static Properties loadClose(InputStream inputStream, Object obj) {
        Properties properties = new Properties();
        try {
            try {
                if (inputStream != null) {
                    try {
                        properties.load(inputStream);
                        inputStream.close();
                        return properties;
                    } catch (IOException e) {
                        LowLevelLogUtil.logException("Unable to read " + obj, e);
                        inputStream.close();
                    }
                }
            } catch (IOException e6) {
                LowLevelLogUtil.logException(androidx.collection.a.l(obj, "Unable to close "), e6);
            }
            return properties;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e7) {
                LowLevelLogUtil.logException(androidx.collection.a.l(obj, "Unable to close "), e7);
            }
            throw th;
        }
    }

    public static Map<String, Properties> partitionOnCommonPrefixes(Properties properties) {
        return partitionOnCommonPrefixes(properties, false);
    }

    public boolean getBooleanProperty(String str) {
        return getBooleanProperty(str, false);
    }

    public Charset getCharsetProperty(String str) {
        return getCharsetProperty(str, Charset.defaultCharset());
    }

    public double getDoubleProperty(String str, double d) {
        String stringProperty = getStringProperty(str);
        if (stringProperty != null) {
            try {
                return Double.parseDouble(stringProperty);
            } catch (Exception unused) {
            }
        }
        return d;
    }

    public Duration getDurationProperty(String str, Duration duration) {
        String stringProperty = getStringProperty(str);
        return stringProperty != null ? TimeUnit.getDuration(stringProperty) : duration;
    }

    public int getIntegerProperty(String str, int i5) {
        String stringProperty = getStringProperty(str);
        if (stringProperty != null) {
            try {
                return Integer.parseInt(stringProperty.trim());
            } catch (Exception unused) {
            }
        }
        return i5;
    }

    public long getLongProperty(String str, long j6) {
        String stringProperty = getStringProperty(str);
        if (stringProperty != null) {
            try {
                return Long.parseLong(stringProperty);
            } catch (Exception unused) {
            }
        }
        return j6;
    }

    public String getStringProperty(String[] strArr, String str, Supplier<String> supplier) {
        for (String str2 : strArr) {
            String stringProperty = getStringProperty(str2 + str);
            if (stringProperty != null) {
                return stringProperty;
            }
        }
        if (supplier != null) {
            return supplier.get();
        }
        return null;
    }

    public boolean hasProperty(String str) {
        return this.environment.containsKey(str);
    }

    public boolean isOsWindows() {
        return getStringProperty("os.name", "").startsWith("Windows");
    }

    public void reload() {
        this.environment.reload();
    }

    public PropertiesUtil(String str) {
        this(str, true);
    }

    public static Map<String, Properties> partitionOnCommonPrefixes(Properties properties, boolean z6) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (String str : properties.stringPropertyNames()) {
            int iIndexOf = str.indexOf(46);
            if (iIndexOf >= 0) {
                String strSubstring = str.substring(0, iIndexOf);
                if (!concurrentHashMap.containsKey(strSubstring)) {
                    concurrentHashMap.put(strSubstring, new Properties());
                }
                ((Properties) concurrentHashMap.get(strSubstring)).setProperty(str.substring(iIndexOf + 1), properties.getProperty(str));
            } else if (z6) {
                if (!concurrentHashMap.containsKey(str)) {
                    concurrentHashMap.put(str, new Properties());
                }
                ((Properties) concurrentHashMap.get(str)).setProperty("", properties.getProperty(str));
            }
        }
        return concurrentHashMap;
    }

    public boolean getBooleanProperty(String str, boolean z6) {
        String stringProperty = getStringProperty(str);
        return stringProperty == null ? z6 : "true".equalsIgnoreCase(stringProperty);
    }

    public Charset getCharsetProperty(String str, Charset charset) {
        String stringProperty = getStringProperty(str);
        if (stringProperty == null) {
            return charset;
        }
        if (Charset.isSupported(stringProperty)) {
            return Charset.forName(stringProperty);
        }
        ResourceBundle charsetsResourceBundle = getCharsetsResourceBundle();
        if (charsetsResourceBundle.containsKey(str)) {
            String string = charsetsResourceBundle.getString(str);
            if (Charset.isSupported(string)) {
                return Charset.forName(string);
            }
        }
        StringBuilder sbU = androidx.collection.a.u("Unable to get Charset '", stringProperty, "' for property '", str, "', using default ");
        sbU.append(charset);
        sbU.append(" and continuing.");
        LowLevelLogUtil.log(sbU.toString());
        return charset;
    }

    private PropertiesUtil(String str, boolean z6) {
        this(new PropertyFilePropertySource(str, z6));
    }

    public Duration getDurationProperty(String[] strArr, String str, Supplier<Duration> supplier) {
        for (String str2 : strArr) {
            if (hasProperty(str2 + str)) {
                return getDurationProperty(str2 + str, null);
            }
        }
        if (supplier != null) {
            return supplier.get();
        }
        return null;
    }

    public Integer getIntegerProperty(String[] strArr, String str, Supplier<Integer> supplier) {
        for (String str2 : strArr) {
            if (hasProperty(str2 + str)) {
                return Integer.valueOf(getIntegerProperty(str2 + str, 0));
            }
        }
        if (supplier != null) {
            return supplier.get();
        }
        return null;
    }

    public Long getLongProperty(String[] strArr, String str, Supplier<Long> supplier) {
        for (String str2 : strArr) {
            if (hasProperty(str2 + str)) {
                return Long.valueOf(getLongProperty(str2 + str, 0L));
            }
        }
        if (supplier != null) {
            return supplier.get();
        }
        return null;
    }

    public PropertiesUtil(PropertySource propertySource) {
        this.environment = new Environment(propertySource);
    }

    public boolean getBooleanProperty(String str, boolean z6, boolean z7) {
        String stringProperty = getStringProperty(str);
        if (stringProperty == null) {
            return z6;
        }
        return stringProperty.isEmpty() ? z7 : "true".equalsIgnoreCase(stringProperty);
    }

    public String getStringProperty(String str) {
        return this.environment.get(str);
    }

    public String getStringProperty(String str, String str2) {
        String stringProperty = getStringProperty(str);
        return stringProperty == null ? str2 : stringProperty;
    }

    public Boolean getBooleanProperty(String[] strArr, String str, Supplier<Boolean> supplier) {
        for (String str2 : strArr) {
            if (hasProperty(str2 + str)) {
                return Boolean.valueOf(getBooleanProperty(str2 + str));
            }
        }
        if (supplier != null) {
            return supplier.get();
        }
        return null;
    }
}
