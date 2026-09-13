package org.apache.xmlbeans.impl.common;

import java.io.InputStream;
import org.apache.xmlbeans.ResourceLoader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class DefaultClassLoaderResourceLoader implements ResourceLoader {
    @Override // org.apache.xmlbeans.ResourceLoader
    public InputStream getResourceAsStream(String str) {
        InputStream resourceAsStream;
        try {
            resourceAsStream = getResourceAsStream(Thread.currentThread().getContextClassLoader(), str);
        } catch (SecurityException unused) {
            resourceAsStream = null;
        }
        if (resourceAsStream == null) {
            resourceAsStream = getResourceAsStream(DefaultClassLoaderResourceLoader.class.getClassLoader(), str);
        }
        return resourceAsStream == null ? DefaultClassLoaderResourceLoader.class.getResourceAsStream(str) : resourceAsStream;
    }

    private InputStream getResourceAsStream(ClassLoader classLoader, String str) {
        if (classLoader == null) {
            return null;
        }
        return classLoader.getResourceAsStream(str);
    }

    @Override // org.apache.xmlbeans.ResourceLoader
    public void close() {
    }
}
