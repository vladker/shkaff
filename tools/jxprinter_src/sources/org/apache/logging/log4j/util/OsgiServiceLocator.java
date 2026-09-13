package org.apache.logging.log4j.util;

import java.lang.invoke.MethodHandles;
import java.util.function.Function;
import java.util.stream.Stream;
import org.apache.logging.log4j.status.StatusLogger;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class OsgiServiceLocator {
    private static final boolean OSGI_AVAILABLE = checkOsgiAvailable();

    private static boolean checkOsgiAvailable() {
        try {
            Class.forName("org.osgi.framework.Bundle");
            return true;
        } catch (ClassNotFoundException | LinkageError unused) {
            return false;
        } catch (Throwable th) {
            LowLevelLogUtil.logException("Unknown error checking for existence of class: org.osgi.framework.Bundle", th);
            return false;
        }
    }

    public static boolean isAvailable() {
        return OSGI_AVAILABLE;
    }

    public static <T> Stream<T> loadServices(Class<T> cls, MethodHandles.Lookup lookup) {
        return loadServices(cls, lookup, true);
    }

    public static <T> Stream<T> loadServices(Class<T> cls, MethodHandles.Lookup lookup, boolean z6) {
        Bundle bundle = FrameworkUtil.getBundle(lookup.lookupClass());
        if (bundle != null) {
            final BundleContext bundleContext = bundle.getBundleContext();
            try {
                return bundleContext.getServiceReferences(cls, (String) null).stream().map(new Function() { // from class: org.apache.logging.log4j.util.a
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return bundleContext.getService((ServiceReference) obj);
                    }
                });
            } catch (Throwable th) {
                if (z6) {
                    StatusLogger.getLogger().error("Unable to load OSGI services for service {}", cls, th);
                }
            }
        }
        return Stream.empty();
    }
}
