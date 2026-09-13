package org.apache.logging.log4j.util;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.Provider;
import org.apache.logging.log4j.status.StatusLogger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ProviderUtil {
    private static final String API_VERSION = "Log4jAPIVersion";
    protected static final String PROVIDER_RESOURCE = "META-INF/log4j-provider.properties";
    private static volatile ProviderUtil instance;
    protected static final Collection<Provider> PROVIDERS = new HashSet();
    protected static final Lock STARTUP_LOCK = new ReentrantLock();
    private static final String[] COMPATIBLE_API_VERSIONS = {"2.6.0"};
    private static final Logger LOGGER = StatusLogger.getLogger();

    private ProviderUtil() {
        Stream streamFilter = ServiceLoaderUtil.loadServices(Provider.class, MethodHandles.lookup(), false).filter(new h(1));
        Collection<Provider> collection = PROVIDERS;
        collection.getClass();
        streamFilter.forEach(new f(collection, 2));
        for (LoaderUtil.UrlResource urlResource : LoaderUtil.findUrlResources(PROVIDER_RESOURCE, false)) {
            loadProvider(urlResource.getUrl(), urlResource.getClassLoader());
        }
    }

    public static void addProvider(Provider provider) {
        PROVIDERS.add(provider);
        LOGGER.debug("Loaded Provider {}", provider);
    }

    public static ClassLoader findClassLoader() {
        return LoaderUtil.getThreadContextClassLoader();
    }

    public static Iterable<Provider> getProviders() {
        lazyInit();
        return PROVIDERS;
    }

    public static boolean hasProviders() {
        lazyInit();
        return !PROVIDERS.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$loadProviders$1(Provider provider) {
        return validVersion(provider.getVersions());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(Provider provider) {
        return validVersion(provider.getVersions());
    }

    public static void lazyInit() {
        if (instance == null) {
            try {
                STARTUP_LOCK.lockInterruptibly();
                try {
                    if (instance == null) {
                        instance = new ProviderUtil();
                    }
                } finally {
                    STARTUP_LOCK.unlock();
                }
            } catch (InterruptedException e) {
                LOGGER.fatal("Interrupted before Log4j Providers could be loaded.", (Throwable) e);
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void loadProvider(URL url, ClassLoader classLoader) {
        try {
            Properties propertiesLoadClose = PropertiesUtil.loadClose(url.openStream(), url);
            if (validVersion(propertiesLoadClose.getProperty(API_VERSION))) {
                Provider provider = new Provider(propertiesLoadClose, url, classLoader);
                PROVIDERS.add(provider);
                LOGGER.debug("Loaded Provider {}", provider);
            }
        } catch (IOException e) {
            LOGGER.error("Unable to open {}", url, e);
        }
    }

    public static void loadProviders(ClassLoader classLoader) {
        Stream streamFilter = ServiceLoaderUtil.loadClassloaderServices(Provider.class, MethodHandles.lookup(), classLoader, true).filter(new h(0));
        Collection<Provider> collection = PROVIDERS;
        collection.getClass();
        streamFilter.forEach(new f(collection, 2));
    }

    private static boolean validVersion(String str) {
        for (String str2 : COMPATIBLE_API_VERSIONS) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public static void loadProviders(Enumeration<URL> enumeration, ClassLoader classLoader) {
        if (enumeration != null) {
            while (enumeration.hasMoreElements()) {
                loadProvider(enumeration.nextElement(), classLoader);
            }
        }
    }
}
