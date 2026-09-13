package org.apache.logging.log4j.util;

import A3.AbstractC0157z;
import java.io.IOException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class LoaderUtil {
    private static final ClassLoader[] EMPTY_CLASS_LOADER_ARRAY = new ClassLoader[0];
    private static final boolean GET_CLASS_LOADER_DISABLED;
    public static final String IGNORE_TCCL_PROPERTY = "log4j.ignoreTCL";
    private static final SecurityManager SECURITY_MANAGER;
    private static final PrivilegedAction<ClassLoader> TCCL_GETTER;
    private static Boolean ignoreTCCL;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ThreadContextClassLoaderGetter implements PrivilegedAction<ClassLoader> {
        private ThreadContextClassLoaderGetter() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.security.PrivilegedAction
        public ClassLoader run() {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                return contextClassLoader;
            }
            ClassLoader classLoader = LoaderUtil.class.getClassLoader();
            return (classLoader != null || LoaderUtil.GET_CLASS_LOADER_DISABLED) ? classLoader : ClassLoader.getSystemClassLoader();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class UrlResource {
        private final ClassLoader classLoader;
        private final URL url;

        public UrlResource(ClassLoader classLoader, URL url) {
            this.classLoader = classLoader;
            this.url = url;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UrlResource urlResource = (UrlResource) obj;
            ClassLoader classLoader = this.classLoader;
            if (classLoader == null ? urlResource.classLoader != null : !classLoader.equals(urlResource.classLoader)) {
                return false;
            }
            URL url = this.url;
            URL url2 = urlResource.url;
            return url == null ? url2 == null : url.equals(url2);
        }

        public ClassLoader getClassLoader() {
            return this.classLoader;
        }

        public URL getUrl() {
            return this.url;
        }

        public int hashCode() {
            return Objects.hashCode(this.url) + Objects.hashCode(this.classLoader);
        }
    }

    static {
        boolean z6 = false;
        SecurityManager securityManager = System.getSecurityManager();
        SECURITY_MANAGER = securityManager;
        TCCL_GETTER = new ThreadContextClassLoaderGetter();
        if (securityManager == null) {
            GET_CLASS_LOADER_DISABLED = false;
            return;
        }
        try {
            securityManager.checkPermission(new RuntimePermission("getClassLoader"));
        } catch (SecurityException unused) {
            z6 = true;
        }
        GET_CLASS_LOADER_DISABLED = z6;
    }

    private LoaderUtil() {
    }

    public static Collection<URL> findResources(String str) {
        return findResources(str, true);
    }

    public static Collection<UrlResource> findUrlResources(String str, boolean z6) {
        ClassLoader[] classLoaderArr = {z6 ? getThreadContextClassLoader() : null, LoaderUtil.class.getClassLoader(), GET_CLASS_LOADER_DISABLED ? null : ClassLoader.getSystemClassLoader()};
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i5 = 0; i5 < 3; i5++) {
            ClassLoader classLoader = classLoaderArr[i5];
            if (classLoader != null) {
                try {
                    Enumeration<URL> resources = classLoader.getResources(str);
                    while (resources.hasMoreElements()) {
                        linkedHashSet.add(new UrlResource(classLoader, resources.nextElement()));
                    }
                } catch (IOException e) {
                    LowLevelLogUtil.logException(e);
                }
            }
        }
        return linkedHashSet;
    }

    public static ClassLoader getThreadContextClassLoader() {
        if (GET_CLASS_LOADER_DISABLED) {
            return LoaderUtil.class.getClassLoader();
        }
        return SECURITY_MANAGER == null ? TCCL_GETTER.run() : (ClassLoader) AccessController.doPrivileged(TCCL_GETTER);
    }

    public static boolean isClassAvailable(String str) {
        try {
            return loadClass(str) != null;
        } catch (ClassNotFoundException | LinkageError unused) {
            return false;
        } catch (Throwable th) {
            LowLevelLogUtil.logException(AbstractC0157z.n("Unknown error checking for existence of class: ", str), th);
            return false;
        }
    }

    private static boolean isIgnoreTccl() {
        if (ignoreTCCL == null) {
            String stringProperty = PropertiesUtil.getProperties().getStringProperty(IGNORE_TCCL_PROPERTY, null);
            ignoreTCCL = Boolean.valueOf((stringProperty == null || "false".equalsIgnoreCase(stringProperty.trim())) ? false : true);
        }
        return ignoreTCCL.booleanValue();
    }

    public static Class<?> loadClass(String str) {
        if (isIgnoreTccl()) {
            return Class.forName(str);
        }
        try {
            ClassLoader threadContextClassLoader = getThreadContextClassLoader();
            if (threadContextClassLoader != null) {
                return threadContextClassLoader.loadClass(str);
            }
        } catch (Throwable unused) {
        }
        return Class.forName(str);
    }

    public static <T> T newCheckedInstanceOf(String str, Class<T> cls) {
        return cls.cast(newInstanceOf(str));
    }

    public static <T> T newCheckedInstanceOfProperty(String str, Class<T> cls) {
        String stringProperty = PropertiesUtil.getProperties().getStringProperty(str);
        if (stringProperty == null) {
            return null;
        }
        return (T) newCheckedInstanceOf(stringProperty, cls);
    }

    public static <T> T newInstanceOf(Class<T> cls) {
        try {
            return cls.getConstructor(null).newInstance(null);
        } catch (NoSuchMethodException unused) {
            return cls.newInstance();
        }
    }

    public static Collection<URL> findResources(String str, boolean z6) {
        Collection<UrlResource> collectionFindUrlResources = findUrlResources(str, z6);
        LinkedHashSet linkedHashSet = new LinkedHashSet(collectionFindUrlResources.size());
        Iterator<UrlResource> it = collectionFindUrlResources.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next().getUrl());
        }
        return linkedHashSet;
    }

    public static <T> T newInstanceOf(String str) {
        return (T) newInstanceOf(loadClass(str));
    }
}
