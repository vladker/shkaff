package org.apache.logging.log4j.util;

import androidx.core.location.LocationRequestCompat;
import io.flutter.plugin.platform.PlatformPlugin;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.status.StatusLogger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ServiceLoaderUtil {
    private static final MethodType LOAD_CLASS_CLASSLOADER = MethodType.methodType(ServiceLoader.class, Class.class, ClassLoader.class);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ServiceLoaderSpliterator<S> implements Spliterator<S> {
        private final Logger logger;
        private final Iterator<S> serviceIterator;
        private final String serviceName;

        public ServiceLoaderSpliterator(Class<S> cls, MethodHandles.Lookup lookup, ClassLoader classLoader, boolean z6) {
            this.serviceIterator = ServiceLoaderUtil.callServiceLoader(lookup, cls, classLoader, z6).iterator();
            this.logger = z6 ? StatusLogger.getLogger() : null;
            this.serviceName = cls.toString();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return PlatformPlugin.DEFAULT_SYSTEM_UI;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super S> consumer) {
            while (this.serviceIterator.hasNext()) {
                try {
                    consumer.accept(this.serviceIterator.next());
                    return true;
                } catch (ServiceConfigurationError e) {
                    Logger logger = this.logger;
                    if (logger != null) {
                        logger.warn("Unable to load service class for service {}", this.serviceName, e);
                    }
                }
            }
            return false;
        }

        @Override // java.util.Spliterator
        public Spliterator<S> trySplit() {
            return null;
        }
    }

    private ServiceLoaderUtil() {
    }

    public static <T> Iterable<T> callServiceLoader(MethodHandles.Lookup lookup, Class<T> cls, ClassLoader classLoader, boolean z6) {
        try {
            return (ServiceLoader) lookup.findStatic(ServiceLoader.class, "load", LOAD_CLASS_CLASSLOADER).invokeExact(cls, classLoader);
        } catch (Throwable th) {
            if (z6) {
                StatusLogger.getLogger().error("Unable to load services for service {}", cls, th);
            }
            return Collections.EMPTY_LIST;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$loadServices$0(Set set, Object obj) {
        return set.add(obj.getClass());
    }

    public static <T> Stream<T> loadClassloaderServices(Class<T> cls, MethodHandles.Lookup lookup, ClassLoader classLoader, boolean z6) {
        return StreamSupport.stream(new ServiceLoaderSpliterator(cls, lookup, classLoader, z6), false);
    }

    public static <T> Stream<T> loadServices(Class<T> cls, MethodHandles.Lookup lookup) {
        return loadServices(cls, lookup, false);
    }

    public static <T> Stream<T> loadServices(Class<T> cls, MethodHandles.Lookup lookup, boolean z6) {
        return loadServices(cls, lookup, z6, true);
    }

    public static <T> Stream<T> loadServices(Class<T> cls, MethodHandles.Lookup lookup, boolean z6, boolean z7) {
        ClassLoader threadContextClassLoader;
        ClassLoader classLoader = lookup.lookupClass().getClassLoader();
        Stream streamLoadClassloaderServices = loadClassloaderServices(cls, lookup, classLoader, z7);
        if (z6 && (threadContextClassLoader = LoaderUtil.getThreadContextClassLoader()) != classLoader) {
            streamLoadClassloaderServices = Stream.concat(streamLoadClassloaderServices, loadClassloaderServices(cls, lookup, threadContextClassLoader, z7));
        }
        if (OsgiServiceLocator.isAvailable()) {
            streamLoadClassloaderServices = Stream.concat(streamLoadClassloaderServices, OsgiServiceLocator.loadServices(cls, lookup, z7));
        }
        final HashSet hashSet = new HashSet();
        return streamLoadClassloaderServices.filter(new Predicate() { // from class: org.apache.logging.log4j.util.i
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ServiceLoaderUtil.lambda$loadServices$0(hashSet, obj);
            }
        });
    }
}
