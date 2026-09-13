package org.apache.logging.log4j.spi;

import java.net.URI;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface LoggerContextFactory {
    LoggerContext getContext(String str, ClassLoader classLoader, Object obj, boolean z6);

    LoggerContext getContext(String str, ClassLoader classLoader, Object obj, boolean z6, URI uri, String str2);

    default boolean hasContext(String str, ClassLoader classLoader, boolean z6) {
        return false;
    }

    default boolean isClassLoaderDependent() {
        return true;
    }

    void removeContext(LoggerContext loggerContext);

    default void shutdown(String str, ClassLoader classLoader, boolean z6, boolean z7) {
        if (hasContext(str, classLoader, z6)) {
            LoggerContext context = getContext(str, classLoader, null, z6);
            if (context instanceof Terminable) {
                ((Terminable) context).terminate();
            }
        }
    }
}
