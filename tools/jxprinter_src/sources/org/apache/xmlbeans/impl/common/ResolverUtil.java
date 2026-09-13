package org.apache.xmlbeans.impl.common;

import org.apache.xmlbeans.SystemProperties;
import org.xml.sax.EntityResolver;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class ResolverUtil {
    private static EntityResolver _entityResolver;

    static {
        try {
            String property = SystemProperties.getProperty("xmlbean.entityResolver");
            if (property != null) {
                _entityResolver = (EntityResolver) Class.forName(property).getDeclaredConstructor(null).newInstance(null);
            }
        } catch (Exception unused) {
            _entityResolver = null;
        }
    }

    public static EntityResolver getGlobalEntityResolver() {
        return _entityResolver;
    }

    public static EntityResolver resolverForCatalog(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("org.apache.xml.resolver.CatalogManager");
            Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
            cls.getMethod("setCatalogFiles", String.class).invoke(objNewInstance, str);
            return (EntityResolver) Class.forName("org.apache.xml.resolver.tools.CatalogResolver").getDeclaredConstructor(cls).newInstance(objNewInstance);
        } catch (Exception unused) {
            return null;
        }
    }
}
