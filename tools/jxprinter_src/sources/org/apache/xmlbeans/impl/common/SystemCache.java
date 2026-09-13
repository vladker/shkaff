package org.apache.xmlbeans.impl.common;

import A3.AbstractC0157z;
import androidx.collection.a;
import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationTargetException;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SystemCache {
    private static SystemCache INSTANCE = initCache();
    private ThreadLocal<SoftReference> tl_saxLoaders = new ThreadLocal<>();

    public static synchronized SystemCache get() {
        return INSTANCE;
    }

    private static SystemCache initCache() {
        String property = SystemProperties.getProperty("xmlbean.systemcacheimpl");
        if (property == null) {
            return new SystemCache();
        }
        String strO = AbstractC0157z.o("Could not instantiate class ", property, " as specified by \"xmlbean.systemcacheimpl\". ");
        try {
            return (SystemCache) Class.forName(property).getDeclaredConstructor(null).newInstance(null);
        } catch (ClassCastException unused) {
            throw new ClassCastException(a.n(strO, "Class does not derive from SystemCache."));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(a.n(strO, "Class was not found."), e);
        } catch (IllegalAccessException e6) {
            throw new RuntimeException(a.n(strO, "A public empty constructor may be missing."), e6);
        } catch (InstantiationException e7) {
            e = e7;
            throw new RuntimeException(a.n(strO, "An empty constructor may be missing."), e);
        } catch (NoSuchMethodException e8) {
            e = e8;
            throw new RuntimeException(a.n(strO, "An empty constructor may be missing."), e);
        } catch (InvocationTargetException e9) {
            e = e9;
            throw new RuntimeException(a.n(strO, "An empty constructor may be missing."), e);
        }
    }

    public static synchronized void set(SystemCache systemCache) {
        INSTANCE = systemCache;
    }

    public void clearThreadLocals() {
        this.tl_saxLoaders.remove();
    }

    public SchemaTypeLoader getFromTypeLoaderCache(ClassLoader classLoader) {
        return null;
    }

    public Object getSaxLoader() {
        SoftReference softReference = this.tl_saxLoaders.get();
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public void setSaxLoader(Object obj) {
        this.tl_saxLoaders.set(new SoftReference(obj));
    }

    public void addToTypeLoaderCache(SchemaTypeLoader schemaTypeLoader, ClassLoader classLoader) {
    }
}
