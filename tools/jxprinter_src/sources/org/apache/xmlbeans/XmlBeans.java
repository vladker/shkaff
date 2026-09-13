package org.apache.xmlbeans;

import A3.AbstractC0157z;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
import org.apache.xmlbeans.impl.schema.PathResourceLoader;
import org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeSystemCompiler;
import org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl;
import org.apache.xmlbeans.impl.store.Locale;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class XmlBeans {
    private static final String HOLDER_CLASS_NAME = "TypeSystemHolder";
    public static final SchemaType NO_TYPE;
    private static final String TYPE_SYSTEM_FIELD = "typeSystem";
    private static String XMLBEANS_TITLE = "org.apache.xmlbeans";
    private static String XMLBEANS_VENDOR = "Apache Software Foundation";
    private static String XMLBEANS_VERSION = "unknown";
    private static final ThreadLocal _threadLocalLoaderQNameCache;

    static {
        Package r6 = XmlBeans.class.getPackage();
        if (r6 != null && r6.getImplementationVersion() != null) {
            XMLBEANS_TITLE = r6.getImplementationTitle();
            XMLBEANS_VERSION = r6.getImplementationVersion();
            XMLBEANS_VENDOR = r6.getImplementationVendor();
        }
        _threadLocalLoaderQNameCache = new ThreadLocal() { // from class: org.apache.xmlbeans.XmlBeans.1
            @Override // java.lang.ThreadLocal
            public Object initialValue() {
                return new SoftReference(new QNameCache(32));
            }
        };
        NO_TYPE = getNoType();
    }

    private XmlBeans() {
    }

    private static RuntimeException causedException(RuntimeException runtimeException, Throwable th) {
        runtimeException.initCause(th);
        return runtimeException;
    }

    public static void clearThreadLocals() {
        _threadLocalLoaderQNameCache.remove();
    }

    public static String compilePath(String str) {
        return compilePath(str, null);
    }

    public static String compileQuery(String str) {
        return compileQuery(str, null);
    }

    public static SchemaTypeSystem compileXmlBeans(String str, SchemaTypeSystem schemaTypeSystem, XmlObject[] xmlObjectArr, BindingConfig bindingConfig, SchemaTypeLoader schemaTypeLoader, Filer filer, XmlOptions xmlOptions) {
        if (schemaTypeLoader == null) {
            schemaTypeLoader = getContextTypeLoader();
        }
        return SchemaTypeSystemCompiler.compile(str, schemaTypeSystem, xmlObjectArr, bindingConfig, schemaTypeLoader, filer, xmlOptions);
    }

    public static SchemaTypeSystem compileXsd(XmlObject[] xmlObjectArr, SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        return compileXmlBeans(null, null, xmlObjectArr, null, schemaTypeLoader, null, xmlOptions);
    }

    public static SchemaTypeSystem getBuiltinTypeSystem() {
        return BuiltinSchemaTypeSystem.get();
    }

    public static SchemaTypeLoader getContextTypeLoader() {
        return SchemaTypeLoaderImpl.getContextTypeLoader();
    }

    private static SchemaType getNoType() {
        return BuiltinSchemaTypeSystem.getNoType();
    }

    public static QName getQName(String str) {
        return getQNameCache().getName("", str);
    }

    public static QNameCache getQNameCache() {
        ThreadLocal threadLocal = _threadLocalLoaderQNameCache;
        QNameCache qNameCache = (QNameCache) ((SoftReference) threadLocal.get()).get();
        if (qNameCache != null) {
            return qNameCache;
        }
        QNameCache qNameCache2 = new QNameCache(32);
        threadLocal.set(new SoftReference(qNameCache2));
        return qNameCache2;
    }

    public static String getTitle() {
        return XMLBEANS_TITLE;
    }

    public static String getVendor() {
        return XMLBEANS_VENDOR;
    }

    public static String getVersion() {
        return XMLBEANS_VERSION;
    }

    public static SchemaTypeLoader loadXsd(XmlObject... xmlObjectArr) {
        return loadXsd(xmlObjectArr, null);
    }

    public static XmlCursor nodeToCursor(Node node) {
        return Locale.nodeToCursor(node);
    }

    public static XmlObject nodeToXmlObject(Node node) {
        return Locale.nodeToXmlObject(node);
    }

    public static XMLStreamReader nodeToXmlStreamReader(Node node) {
        return Locale.nodeToXmlStream(node);
    }

    public static ResourceLoader resourceLoaderForPath(File[] fileArr) {
        return new PathResourceLoader(fileArr);
    }

    public static Node streamToNode(XMLStreamReader xMLStreamReader) {
        return Locale.streamToNode(xMLStreamReader);
    }

    public static SchemaType typeForClass(Class cls) {
        if (cls != null && XmlObject.class.isAssignableFrom(cls)) {
            try {
                Field field = cls.getField("type");
                if (field == null) {
                    return null;
                }
                return (SchemaType) field.get(null);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static SchemaTypeLoader typeLoaderForClassLoader(ClassLoader classLoader) {
        return SchemaTypeLoaderImpl.build(null, null, classLoader);
    }

    public static SchemaTypeLoader typeLoaderForResource(ResourceLoader resourceLoader) {
        return SchemaTypeLoaderImpl.build(null, resourceLoader, null);
    }

    public static SchemaTypeLoader typeLoaderUnion(SchemaTypeLoader... schemaTypeLoaderArr) {
        return schemaTypeLoaderArr.length == 1 ? schemaTypeLoaderArr[0] : SchemaTypeLoaderImpl.build(schemaTypeLoaderArr, null, null);
    }

    public static SchemaTypeSystem typeSystemForClassLoader(ClassLoader classLoader, String str) {
        if (classLoader == null) {
            try {
                classLoader = Thread.currentThread().getContextClassLoader();
            } catch (ClassNotFoundException e) {
                throw causedException(new RuntimeException(AbstractC0157z.o("Cannot load SchemaTypeSystem. Unable to load class with name ", str, ".TypeSystemHolder. Make sure the generated binary files are on the classpath.")), e);
            } catch (IllegalAccessException e6) {
                throw causedException(new RuntimeException(AbstractC0157z.o("Field typeSystem on class ", str, ".TypeSystemHolderis not accessible. Please verify the version of xmlbeans.jar is correct.")), e6);
            } catch (NoSuchFieldException e7) {
                throw causedException(new RuntimeException(AbstractC0157z.o("Cannot find field typeSystem on class ", str, ".TypeSystemHolder. Please verify the version of xmlbeans.jar is correct.")), e7);
            }
        }
        SchemaTypeSystem schemaTypeSystem = (SchemaTypeSystem) classLoader.loadClass(str + ".TypeSystemHolder").getDeclaredField(TYPE_SYSTEM_FIELD).get(null);
        if (schemaTypeSystem != null) {
            return schemaTypeSystem;
        }
        throw new RuntimeException("SchemaTypeSystem is null for field typeSystem on class with name " + str + ".TypeSystemHolder. Please verify the version of xmlbeans.jar is correct.");
    }

    public static String compilePath(String str, XmlOptions xmlOptions) {
        return getContextTypeLoader().compilePath(str, xmlOptions);
    }

    public static String compileQuery(String str, XmlOptions xmlOptions) {
        return getContextTypeLoader().compileQuery(str, xmlOptions);
    }

    public static SchemaTypeSystem compileXsd(SchemaTypeSystem schemaTypeSystem, XmlObject[] xmlObjectArr, SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        return compileXmlBeans(null, schemaTypeSystem, xmlObjectArr, null, schemaTypeLoader, null, xmlOptions);
    }

    public static QName getQName(String str, String str2) {
        return getQNameCache().getName(str, str2);
    }

    public static SchemaTypeLoader loadXsd(XmlObject[] xmlObjectArr, XmlOptions xmlOptions) {
        SchemaTypeSystemImpl schemaTypeSystemImplCompile = SchemaTypeSystemCompiler.compile(null, null, xmlObjectArr, null, getContextTypeLoader(), null, xmlOptions);
        if (schemaTypeSystemImplCompile == null) {
            return null;
        }
        return typeLoaderUnion(schemaTypeSystemImplCompile, getContextTypeLoader());
    }
}
