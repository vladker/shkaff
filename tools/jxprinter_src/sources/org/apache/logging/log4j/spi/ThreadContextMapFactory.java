package org.apache.logging.log4j.spi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.Constants;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.logging.log4j.util.ProviderUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ThreadContextMapFactory {
    private static final String GC_FREE_THREAD_CONTEXT_KEY = "log4j2.garbagefree.threadContextMap";
    private static boolean GcFreeThreadContextKey = false;
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final String THREAD_CONTEXT_KEY = "log4j2.threadContextMap";
    private static String ThreadContextMapName;

    static {
        initPrivate();
    }

    private ThreadContextMapFactory() {
    }

    private static ThreadContextMap createDefaultThreadContextMap() {
        if (Constants.ENABLE_THREADLOCALS) {
            return GcFreeThreadContextKey ? new GarbageFreeSortedArrayThreadContextMap() : new CopyOnWriteSortedArrayThreadContextMap();
        }
        return new DefaultThreadContextMap(true);
    }

    public static ThreadContextMap createThreadContextMap() {
        Class<? extends ThreadContextMap> clsLoadThreadContextMap;
        ClassLoader classLoaderFindClassLoader = ProviderUtil.findClassLoader();
        String str = ThreadContextMapName;
        ThreadContextMap threadContextMapCreateDefaultThreadContextMap = null;
        if (str != null) {
            try {
                Class<?> clsLoadClass = classLoaderFindClassLoader.loadClass(str);
                if (ThreadContextMap.class.isAssignableFrom(clsLoadClass)) {
                    threadContextMapCreateDefaultThreadContextMap = (ThreadContextMap) clsLoadClass.newInstance();
                }
            } catch (ClassNotFoundException unused) {
                LOGGER.error("Unable to locate configured ThreadContextMap {}", ThreadContextMapName);
            } catch (Exception e) {
                LOGGER.error("Unable to create configured ThreadContextMap {}", ThreadContextMapName, e);
            }
        }
        if (threadContextMapCreateDefaultThreadContextMap == null && ProviderUtil.hasProviders() && LogManager.getFactory() != null) {
            String name = LogManager.getFactory().getClass().getName();
            for (Provider provider : ProviderUtil.getProviders()) {
                if (name.equals(provider.getClassName()) && (clsLoadThreadContextMap = provider.loadThreadContextMap()) != null) {
                    try {
                        threadContextMapCreateDefaultThreadContextMap = clsLoadThreadContextMap.newInstance();
                        break;
                    } catch (Exception e6) {
                        LOGGER.error("Unable to locate or load configured ThreadContextMap {}", provider.getThreadContextMap(), e6);
                        threadContextMapCreateDefaultThreadContextMap = createDefaultThreadContextMap();
                    }
                }
            }
        }
        return threadContextMapCreateDefaultThreadContextMap == null ? createDefaultThreadContextMap() : threadContextMapCreateDefaultThreadContextMap;
    }

    public static void init() {
        CopyOnWriteSortedArrayThreadContextMap.init();
        GarbageFreeSortedArrayThreadContextMap.init();
        DefaultThreadContextMap.init();
        initPrivate();
    }

    private static void initPrivate() {
        PropertiesUtil properties = PropertiesUtil.getProperties();
        ThreadContextMapName = properties.getStringProperty(THREAD_CONTEXT_KEY);
        GcFreeThreadContextKey = properties.getBooleanProperty(GC_FREE_THREAD_CONTEXT_KEY);
    }
}
