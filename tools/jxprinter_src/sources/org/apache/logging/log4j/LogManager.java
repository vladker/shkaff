package org.apache.logging.log4j;

import java.net.URI;
import java.util.Map;
import java.util.TreeMap;
import org.apache.logging.log4j.internal.LogManagerStatus;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.message.StringFormatterMessageFactory;
import org.apache.logging.log4j.simple.SimpleLoggerContextFactory;
import org.apache.logging.log4j.spi.LoggerContext;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.apache.logging.log4j.spi.Provider;
import org.apache.logging.log4j.spi.Terminable;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.LoaderUtil;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.logging.log4j.util.ProviderUtil;
import org.apache.logging.log4j.util.StackLocatorUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LogManager {
    public static final String FACTORY_PROPERTY_NAME = "log4j2.loggerContextFactory";
    public static final String ROOT_LOGGER_NAME = "";
    private static volatile LoggerContextFactory factory;
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final String FQCN = LogManager.class.getName();

    static {
        String stringProperty = PropertiesUtil.getProperties().getStringProperty(FACTORY_PROPERTY_NAME);
        if (stringProperty != null) {
            try {
                factory = (LoggerContextFactory) LoaderUtil.newCheckedInstanceOf(stringProperty, LoggerContextFactory.class);
            } catch (ClassNotFoundException unused) {
                LOGGER.error("Unable to locate configured LoggerContextFactory {}", stringProperty);
            } catch (Exception e) {
                LOGGER.error("Unable to create configured LoggerContextFactory {}", stringProperty, e);
            }
        }
        if (factory == null) {
            TreeMap treeMap = new TreeMap();
            if (ProviderUtil.hasProviders()) {
                for (Provider provider : ProviderUtil.getProviders()) {
                    Class<? extends LoggerContextFactory> clsLoadLoggerContextFactory = provider.loadLoggerContextFactory();
                    if (clsLoadLoggerContextFactory != null) {
                        try {
                            treeMap.put(provider.getPriority(), clsLoadLoggerContextFactory.newInstance());
                        } catch (Exception e6) {
                            LOGGER.error("Unable to create class {} specified in provider URL {}", clsLoadLoggerContextFactory.getName(), provider.getUrl(), e6);
                        }
                    }
                }
                if (treeMap.isEmpty()) {
                    LOGGER.error("Log4j2 could not find a logging implementation. Please add log4j-core to the classpath. Using SimpleLogger to log to the console...");
                    factory = SimpleLoggerContextFactory.INSTANCE;
                } else if (treeMap.size() == 1) {
                    factory = (LoggerContextFactory) treeMap.get(treeMap.lastKey());
                } else {
                    StringBuilder sb = new StringBuilder("Multiple logging implementations found: \n");
                    for (Map.Entry entry : treeMap.entrySet()) {
                        sb.append("Factory: ");
                        sb.append(((LoggerContextFactory) entry.getValue()).getClass().getName());
                        sb.append(", Weighting: ");
                        sb.append(entry.getKey());
                        sb.append('\n');
                    }
                    factory = (LoggerContextFactory) treeMap.get(treeMap.lastKey());
                    sb.append("Using factory: ");
                    sb.append(factory.getClass().getName());
                    LOGGER.warn(sb.toString());
                }
            } else {
                LOGGER.error("Log4j2 could not find a logging implementation. Please add log4j-core to the classpath. Using SimpleLogger to log to the console...");
                factory = SimpleLoggerContextFactory.INSTANCE;
            }
        }
        LogManagerStatus.setInitialized(true);
    }

    private static Class<?> callerClass(Class<?> cls) {
        if (cls != null) {
            return cls;
        }
        Class<?> callerClass = StackLocatorUtil.getCallerClass(3);
        if (callerClass != null) {
            return callerClass;
        }
        throw new UnsupportedOperationException("No class provided, and an appropriate one cannot be found.");
    }

    public static boolean exists(String str) {
        return getContext().hasLogger(str);
    }

    public static LoggerContext getContext() {
        try {
            return factory.getContext(FQCN, null, null, true);
        } catch (IllegalStateException e) {
            LOGGER.warn(e.getMessage() + " Using SimpleLogger");
            return SimpleLoggerContextFactory.INSTANCE.getContext(FQCN, null, null, true);
        }
    }

    public static LoggerContextFactory getFactory() {
        return factory;
    }

    public static Logger getFormatterLogger() {
        return getFormatterLogger(StackLocatorUtil.getCallerClass(2));
    }

    public static Logger getLogger() {
        return getLogger(StackLocatorUtil.getCallerClass(2));
    }

    public static Logger getRootLogger() {
        return getLogger("");
    }

    public static void setFactory(LoggerContextFactory loggerContextFactory) {
        factory = loggerContextFactory;
    }

    public static void shutdown() {
        shutdown(false);
    }

    public static Logger getFormatterLogger(Class<?> cls) {
        if (cls == null) {
            cls = StackLocatorUtil.getCallerClass(2);
        }
        return getLogger(cls, (MessageFactory) StringFormatterMessageFactory.INSTANCE);
    }

    public static Logger getLogger(Class<?> cls) {
        Class<?> clsCallerClass = callerClass(cls);
        return getContext(clsCallerClass.getClassLoader(), false).getLogger(clsCallerClass);
    }

    public static void shutdown(boolean z6) {
        factory.shutdown(FQCN, null, z6, false);
    }

    public static Logger getFormatterLogger(Object obj) {
        return getLogger(obj != null ? obj.getClass() : StackLocatorUtil.getCallerClass(2), (MessageFactory) StringFormatterMessageFactory.INSTANCE);
    }

    public static void shutdown(boolean z6, boolean z7) {
        factory.shutdown(FQCN, null, z6, z7);
    }

    public static LoggerContext getContext(boolean z6) {
        boolean z7;
        try {
            z7 = z6;
            try {
                return factory.getContext(FQCN, null, null, z7, null, null);
            } catch (IllegalStateException e) {
                e = e;
                IllegalStateException illegalStateException = e;
                LOGGER.warn(illegalStateException.getMessage() + " Using SimpleLogger");
                return SimpleLoggerContextFactory.INSTANCE.getContext(FQCN, null, null, z7, null, null);
            }
        } catch (IllegalStateException e6) {
            e = e6;
            z7 = z6;
        }
    }

    public static Logger getFormatterLogger(String str) {
        return str == null ? getFormatterLogger(StackLocatorUtil.getCallerClass(2)) : getLogger(str, (MessageFactory) StringFormatterMessageFactory.INSTANCE);
    }

    public static Logger getLogger(Class<?> cls, MessageFactory messageFactory) {
        Class<?> clsCallerClass = callerClass(cls);
        return getContext(clsCallerClass.getClassLoader(), false).getLogger(clsCallerClass, messageFactory);
    }

    public static void shutdown(LoggerContext loggerContext) {
        if (loggerContext instanceof Terminable) {
            ((Terminable) loggerContext).terminate();
        }
    }

    public static Logger getLogger(MessageFactory messageFactory) {
        return getLogger(StackLocatorUtil.getCallerClass(2), messageFactory);
    }

    public static LoggerContext getContext(ClassLoader classLoader, boolean z6) {
        try {
            return factory.getContext(FQCN, classLoader, null, z6);
        } catch (IllegalStateException e) {
            LOGGER.warn(e.getMessage() + " Using SimpleLogger");
            return SimpleLoggerContextFactory.INSTANCE.getContext(FQCN, classLoader, null, z6);
        }
    }

    public static Logger getLogger(Object obj) {
        return getLogger(obj != null ? obj.getClass() : StackLocatorUtil.getCallerClass(2));
    }

    public static Logger getLogger(Object obj, MessageFactory messageFactory) {
        return getLogger(obj != null ? obj.getClass() : StackLocatorUtil.getCallerClass(2), messageFactory);
    }

    public static Logger getLogger(String str) {
        return str != null ? getContext(false).getLogger(str) : getLogger(StackLocatorUtil.getCallerClass(2));
    }

    public static LoggerContext getContext(ClassLoader classLoader, boolean z6, Object obj) {
        try {
            return factory.getContext(FQCN, classLoader, obj, z6);
        } catch (IllegalStateException e) {
            LOGGER.warn(e.getMessage() + " Using SimpleLogger");
            return SimpleLoggerContextFactory.INSTANCE.getContext(FQCN, classLoader, obj, z6);
        }
    }

    public static Logger getLogger(String str, MessageFactory messageFactory) {
        if (str != null) {
            return getContext(false).getLogger(str, messageFactory);
        }
        return getLogger(StackLocatorUtil.getCallerClass(2), messageFactory);
    }

    public static LoggerContext getContext(ClassLoader classLoader, boolean z6, URI uri) {
        ClassLoader classLoader2;
        boolean z7;
        URI uri2;
        try {
            classLoader2 = classLoader;
            z7 = z6;
            uri2 = uri;
            try {
                return factory.getContext(FQCN, classLoader2, null, z7, uri2, null);
            } catch (IllegalStateException e) {
                e = e;
                IllegalStateException illegalStateException = e;
                LOGGER.warn(illegalStateException.getMessage() + " Using SimpleLogger");
                return SimpleLoggerContextFactory.INSTANCE.getContext(FQCN, classLoader2, null, z7, uri2, null);
            }
        } catch (IllegalStateException e6) {
            e = e6;
            classLoader2 = classLoader;
            z7 = z6;
            uri2 = uri;
        }
    }

    public static Logger getLogger(String str, String str2) {
        return factory.getContext(str, null, null, false).getLogger(str2);
    }

    public static LoggerContext getContext(ClassLoader classLoader, boolean z6, Object obj, URI uri) {
        ClassLoader classLoader2;
        boolean z7;
        Object obj2;
        URI uri2;
        try {
            classLoader2 = classLoader;
            z7 = z6;
            obj2 = obj;
            uri2 = uri;
            try {
                return factory.getContext(FQCN, classLoader2, obj2, z7, uri2, null);
            } catch (IllegalStateException e) {
                e = e;
                IllegalStateException illegalStateException = e;
                LOGGER.warn(illegalStateException.getMessage() + " Using SimpleLogger");
                return SimpleLoggerContextFactory.INSTANCE.getContext(FQCN, classLoader2, obj2, z7, uri2, null);
            }
        } catch (IllegalStateException e6) {
            e = e6;
            classLoader2 = classLoader;
            z7 = z6;
            obj2 = obj;
            uri2 = uri;
        }
    }

    public static LoggerContext getContext(ClassLoader classLoader, boolean z6, Object obj, URI uri, String str) {
        ClassLoader classLoader2;
        boolean z7;
        Object obj2;
        URI uri2;
        String str2;
        try {
            classLoader2 = classLoader;
            z7 = z6;
            obj2 = obj;
            uri2 = uri;
            str2 = str;
            try {
                return factory.getContext(FQCN, classLoader2, obj2, z7, uri2, str2);
            } catch (IllegalStateException e) {
                e = e;
                IllegalStateException illegalStateException = e;
                LOGGER.warn(illegalStateException.getMessage() + " Using SimpleLogger");
                return SimpleLoggerContextFactory.INSTANCE.getContext(FQCN, classLoader2, obj2, z7, uri2, str2);
            }
        } catch (IllegalStateException e6) {
            e = e6;
            classLoader2 = classLoader;
            z7 = z6;
            obj2 = obj;
            uri2 = uri;
            str2 = str;
        }
    }

    public static LoggerContext getContext(String str, boolean z6) {
        try {
            return factory.getContext(str, null, null, z6);
        } catch (IllegalStateException e) {
            LOGGER.warn(e.getMessage() + " Using SimpleLogger");
            return SimpleLoggerContextFactory.INSTANCE.getContext(str, null, null, z6);
        }
    }

    public static LoggerContext getContext(String str, ClassLoader classLoader, boolean z6) {
        try {
            return factory.getContext(str, classLoader, null, z6);
        } catch (IllegalStateException e) {
            LOGGER.warn(e.getMessage() + " Using SimpleLogger");
            return SimpleLoggerContextFactory.INSTANCE.getContext(str, classLoader, null, z6);
        }
    }

    public static LoggerContext getContext(String str, ClassLoader classLoader, boolean z6, URI uri, String str2) {
        String str3;
        ClassLoader classLoader2;
        boolean z7;
        try {
            str3 = str;
            classLoader2 = classLoader;
            z7 = z6;
            try {
                return factory.getContext(str3, classLoader2, null, z7, uri, str2);
            } catch (IllegalStateException e) {
                e = e;
                IllegalStateException illegalStateException = e;
                LOGGER.warn(illegalStateException.getMessage() + " Using SimpleLogger");
                return SimpleLoggerContextFactory.INSTANCE.getContext(str3, classLoader2, null, z7);
            }
        } catch (IllegalStateException e6) {
            e = e6;
            str3 = str;
            classLoader2 = classLoader;
            z7 = z6;
        }
    }
}
