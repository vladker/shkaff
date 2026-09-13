package org.apache.xmlbeans.impl.tool;

import com.sun.org.apache.xml.internal.resolver.CatalogManager;
import com.sun.org.apache.xml.internal.resolver.tools.CatalogResolver;
import org.apache.xmlbeans.impl.util.SuppressForbidden;
import org.xml.sax.EntityResolver;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
@SuppressForbidden("class is available in Java 8 and multi-release version handles newer official package namespace")
public class MavenPluginResolver {
    public static EntityResolver getResolver(String str) {
        if (str == null) {
            return null;
        }
        CatalogManager staticManager = CatalogManager.getStaticManager();
        staticManager.setCatalogFiles(str);
        return new CatalogResolver(staticManager);
    }
}
