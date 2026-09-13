package org.apache.xmlbeans.impl.schema;

import A3.AbstractC0157z;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.xmlbeans.ResourceLoader;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.apache.xmlbeans.impl.common.SystemCache;
import org.apache.xmlbeans.impl.common.XBeanDebug;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SchemaTypeLoaderImpl extends SchemaTypeLoaderBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Map<QName, Object> _attributeCache;
    private Map<QName, Object> _attributeGroupCache;
    private Map<QName, Object> _attributeTypeCache;
    private final ClassLoader _classLoader;
    private Map<String, SchemaTypeSystemImpl> _classLoaderTypeSystems;
    private Map<String, Object> _classnameCache;
    private Map<String, SchemaTypeSystemImpl> _classpathTypeSystems;
    private Map<QName, Object> _documentCache;
    private Map<QName, Object> _elementCache;
    private Map<QName, Object> _idConstraintCache;
    private final String _metadataPath;
    private Map<QName, Object> _modelGroupCache;
    private final ResourceLoader _resourceLoader;
    private final SchemaTypeLoader[] _searchPath;
    private Map<QName, Object> _typeCache;
    public static String METADATA_PACKAGE_LOAD = SchemaTypeSystemImpl.METADATA_PACKAGE_GEN;
    private static final Object CACHED_NOT_FOUND = new Object();
    private static final String[] basePackage = {"org.apache.xmlbeans.metadata", "schemaorg_apache_xmlbeans"};
    private static final String[] baseSchemas = {"sXMLCONFIG", "sXMLLANG", "sXMLSCHEMA", "sXMLTOOLS"};
    private static final SchemaTypeLoader[] EMPTY_SCHEMATYPELOADER_ARRAY = new SchemaTypeLoader[0];

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SchemaTypeLoaderCache extends SystemCache {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final ThreadLocal<List<SoftReference<SchemaTypeLoaderImpl>>> _cachedTypeSystems;

        private SchemaTypeLoaderCache() {
            this._cachedTypeSystems = ThreadLocal.withInitial(new d(0));
        }

        @Override // org.apache.xmlbeans.impl.common.SystemCache
        public void addToTypeLoaderCache(SchemaTypeLoader schemaTypeLoader, ClassLoader classLoader) {
            List<SoftReference<SchemaTypeLoaderImpl>> list = this._cachedTypeSystems.get();
            if (list.size() <= 0) {
                list.add(new SoftReference<>((SchemaTypeLoaderImpl) schemaTypeLoader));
                return;
            }
            SoftReference<SchemaTypeLoaderImpl> softReference = list.get(0);
            list.set(0, new SoftReference<>((SchemaTypeLoaderImpl) schemaTypeLoader));
            list.add(softReference);
        }

        @Override // org.apache.xmlbeans.impl.common.SystemCache
        public void clearThreadLocals() {
            this._cachedTypeSystems.remove();
            super.clearThreadLocals();
        }

        @Override // org.apache.xmlbeans.impl.common.SystemCache
        public SchemaTypeLoader getFromTypeLoaderCache(ClassLoader classLoader) {
            SchemaTypeLoaderImpl schemaTypeLoaderImpl;
            List<SoftReference<SchemaTypeLoaderImpl>> list = this._cachedTypeSystems.get();
            int i5 = 0;
            while (true) {
                if (i5 >= list.size()) {
                    i5 = -1;
                    schemaTypeLoaderImpl = null;
                    break;
                }
                schemaTypeLoaderImpl = list.get(i5).get();
                if (schemaTypeLoaderImpl == null) {
                    list.remove(i5);
                    i5--;
                } else if (schemaTypeLoaderImpl._classLoader == classLoader) {
                    break;
                }
                i5++;
            }
            if (i5 > 0) {
                SoftReference<SchemaTypeLoaderImpl> softReference = list.get(0);
                list.set(0, list.get(i5));
                list.set(i5, softReference);
            }
            return schemaTypeLoaderImpl;
        }
    }

    static {
        SystemCache.set(new SchemaTypeLoaderCache());
    }

    private SchemaTypeLoaderImpl(SchemaTypeLoader[] schemaTypeLoaderArr, ResourceLoader resourceLoader, ClassLoader classLoader, String str) {
        this._searchPath = schemaTypeLoaderArr == null ? EMPTY_SCHEMATYPELOADER_ARRAY : schemaTypeLoaderArr;
        this._resourceLoader = resourceLoader;
        this._classLoader = classLoader;
        if (str != null) {
            this._metadataPath = str;
        } else {
            this._metadataPath = isPath30(classLoader) ? METADATA_PACKAGE_LOAD : "schema" + METADATA_PACKAGE_LOAD.replace(PackagingURIHelper.FORWARD_SLASH_STRING, "_");
        }
        initCaches();
    }

    public static SchemaTypeLoader build(SchemaTypeLoader[] schemaTypeLoaderArr, ResourceLoader resourceLoader, ClassLoader classLoader) {
        return build(schemaTypeLoaderArr, resourceLoader, classLoader, null);
    }

    public static String crackEntry(ResourceLoader resourceLoader, String str) {
        InputStream resourceAsStream = resourceLoader.getResourceAsStream(str);
        if (resourceAsStream == null) {
            return null;
        }
        return crackPointer(resourceAsStream);
    }

    public static String crackPointer(InputStream inputStream) {
        return SchemaTypeSystemImpl.crackPointer(inputStream);
    }

    public static SchemaTypeLoaderImpl getContextTypeLoader() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        SchemaTypeLoaderImpl schemaTypeLoaderImpl = (SchemaTypeLoaderImpl) SystemCache.get().getFromTypeLoaderCache(contextClassLoader);
        if (schemaTypeLoaderImpl != null) {
            return schemaTypeLoaderImpl;
        }
        SchemaTypeLoaderImpl schemaTypeLoaderImpl2 = new SchemaTypeLoaderImpl(new SchemaTypeLoader[]{BuiltinSchemaTypeSystem.get()}, null, contextClassLoader, null);
        SystemCache.get().addToTypeLoaderCache(schemaTypeLoaderImpl2, contextClassLoader);
        return schemaTypeLoaderImpl2;
    }

    private void initCaches() {
        this._classpathTypeSystems = Collections.synchronizedMap(new HashMap());
        this._classLoaderTypeSystems = Collections.synchronizedMap(new HashMap());
        this._elementCache = Collections.synchronizedMap(new HashMap());
        this._attributeCache = Collections.synchronizedMap(new HashMap());
        this._modelGroupCache = Collections.synchronizedMap(new HashMap());
        this._attributeGroupCache = Collections.synchronizedMap(new HashMap());
        this._idConstraintCache = Collections.synchronizedMap(new HashMap());
        this._typeCache = Collections.synchronizedMap(new HashMap());
        this._documentCache = Collections.synchronizedMap(new HashMap());
        this._attributeTypeCache = Collections.synchronizedMap(new HashMap());
        this._classnameCache = Collections.synchronizedMap(new HashMap());
    }

    private static boolean isPath30(ClassLoader classLoader) {
        String strS = AbstractC0157z.s(new StringBuilder(), METADATA_PACKAGE_LOAD, "/system");
        if (classLoader == null) {
            classLoader = SchemaDocument.class.getClassLoader();
        }
        return classLoader.getResource(strS) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SchemaTypeSystemImpl lambda$getTypeSystemOnClasspath$0(String str) {
        return new SchemaTypeSystemImpl(this._resourceLoader, str, this);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaAttributeGroup.Ref findAttributeGroupRef(QName qName) {
        Object obj = this._attributeGroupCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaAttributeGroup.Ref refFindAttributeGroupRef = (SchemaAttributeGroup.Ref) obj;
        if (refFindAttributeGroupRef == null) {
            for (SchemaTypeLoader schemaTypeLoader : this._searchPath) {
                refFindAttributeGroupRef = schemaTypeLoader.findAttributeGroupRef(qName);
                if (refFindAttributeGroupRef != null) {
                    break;
                }
            }
            if (refFindAttributeGroupRef == null) {
                SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(this._metadataPath + "/attributegroup/", qName);
                if (schemaTypeSystemImplTypeSystemForComponent != null) {
                    refFindAttributeGroupRef = schemaTypeSystemImplTypeSystemForComponent.findAttributeGroupRef(qName);
                }
            }
            this._attributeGroupCache.put(qName, refFindAttributeGroupRef == null ? CACHED_NOT_FOUND : refFindAttributeGroupRef);
        }
        return refFindAttributeGroupRef;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute.Ref findAttributeRef(QName qName) {
        Object obj = this._attributeCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaGlobalAttribute.Ref refFindAttributeRef = (SchemaGlobalAttribute.Ref) obj;
        if (refFindAttributeRef == null) {
            for (SchemaTypeLoader schemaTypeLoader : this._searchPath) {
                refFindAttributeRef = schemaTypeLoader.findAttributeRef(qName);
                if (refFindAttributeRef != null) {
                    break;
                }
            }
            if (refFindAttributeRef == null) {
                SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(this._metadataPath + "/attribute/", qName);
                if (schemaTypeSystemImplTypeSystemForComponent != null) {
                    refFindAttributeRef = schemaTypeSystemImplTypeSystemForComponent.findAttributeRef(qName);
                }
            }
            this._attributeCache.put(qName, refFindAttributeRef == null ? CACHED_NOT_FOUND : refFindAttributeRef);
        }
        return refFindAttributeRef;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findAttributeTypeRef(QName qName) {
        Object obj = this._attributeTypeCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaType.Ref refFindAttributeTypeRef = (SchemaType.Ref) obj;
        if (refFindAttributeTypeRef == null) {
            for (SchemaTypeLoader schemaTypeLoader : this._searchPath) {
                refFindAttributeTypeRef = schemaTypeLoader.findAttributeTypeRef(qName);
                if (refFindAttributeTypeRef != null) {
                    break;
                }
            }
            if (refFindAttributeTypeRef == null) {
                SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(this._metadataPath + "/attribute/", qName);
                if (schemaTypeSystemImplTypeSystemForComponent != null) {
                    refFindAttributeTypeRef = schemaTypeSystemImplTypeSystemForComponent.findAttributeTypeRef(qName);
                }
            }
            this._attributeTypeCache.put(qName, refFindAttributeTypeRef == null ? CACHED_NOT_FOUND : refFindAttributeTypeRef);
        }
        return refFindAttributeTypeRef;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findDocumentTypeRef(QName qName) {
        Object obj = this._documentCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaType.Ref refFindDocumentTypeRef = (SchemaType.Ref) obj;
        if (refFindDocumentTypeRef == null) {
            for (SchemaTypeLoader schemaTypeLoader : this._searchPath) {
                refFindDocumentTypeRef = schemaTypeLoader.findDocumentTypeRef(qName);
                if (refFindDocumentTypeRef != null) {
                    break;
                }
            }
            if (refFindDocumentTypeRef == null) {
                SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(this._metadataPath + "/element/", qName);
                if (schemaTypeSystemImplTypeSystemForComponent != null) {
                    refFindDocumentTypeRef = schemaTypeSystemImplTypeSystemForComponent.findDocumentTypeRef(qName);
                }
            }
            this._documentCache.put(qName, refFindDocumentTypeRef == null ? CACHED_NOT_FOUND : refFindDocumentTypeRef);
        }
        return refFindDocumentTypeRef;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement.Ref findElementRef(QName qName) {
        Object obj = this._elementCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaGlobalElement.Ref refFindElementRef = (SchemaGlobalElement.Ref) obj;
        if (refFindElementRef == null) {
            for (SchemaTypeLoader schemaTypeLoader : this._searchPath) {
                refFindElementRef = schemaTypeLoader.findElementRef(qName);
                if (refFindElementRef != null) {
                    break;
                }
            }
            if (refFindElementRef == null) {
                SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(this._metadataPath + "/element/", qName);
                if (schemaTypeSystemImplTypeSystemForComponent != null) {
                    refFindElementRef = schemaTypeSystemImplTypeSystemForComponent.findElementRef(qName);
                }
            }
            this._elementCache.put(qName, refFindElementRef == null ? CACHED_NOT_FOUND : refFindElementRef);
        }
        return refFindElementRef;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName qName) {
        Object obj = this._idConstraintCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaIdentityConstraint.Ref refFindIdentityConstraintRef = (SchemaIdentityConstraint.Ref) obj;
        if (refFindIdentityConstraintRef == null) {
            for (SchemaTypeLoader schemaTypeLoader : this._searchPath) {
                refFindIdentityConstraintRef = schemaTypeLoader.findIdentityConstraintRef(qName);
                if (refFindIdentityConstraintRef != null) {
                    break;
                }
            }
            if (refFindIdentityConstraintRef == null) {
                SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(this._metadataPath + "/identityconstraint/", qName);
                if (schemaTypeSystemImplTypeSystemForComponent != null) {
                    refFindIdentityConstraintRef = schemaTypeSystemImplTypeSystemForComponent.findIdentityConstraintRef(qName);
                }
            }
            this._idConstraintCache.put(qName, refFindIdentityConstraintRef == null ? CACHED_NOT_FOUND : refFindIdentityConstraintRef);
        }
        return refFindIdentityConstraintRef;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaModelGroup.Ref findModelGroupRef(QName qName) {
        Object obj = this._modelGroupCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaModelGroup.Ref refFindModelGroupRef = (SchemaModelGroup.Ref) obj;
        if (refFindModelGroupRef == null) {
            for (SchemaTypeLoader schemaTypeLoader : this._searchPath) {
                refFindModelGroupRef = schemaTypeLoader.findModelGroupRef(qName);
                if (refFindModelGroupRef != null) {
                    break;
                }
            }
            if (refFindModelGroupRef == null) {
                SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(this._metadataPath + "/modelgroup/", qName);
                if (schemaTypeSystemImplTypeSystemForComponent != null) {
                    refFindModelGroupRef = schemaTypeSystemImplTypeSystemForComponent.findModelGroupRef(qName);
                }
            }
            this._modelGroupCache.put(qName, refFindModelGroupRef == null ? CACHED_NOT_FOUND : refFindModelGroupRef);
        }
        return refFindModelGroupRef;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findTypeRef(QName qName) {
        Object obj = this._typeCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaType.Ref refFindTypeRef = (SchemaType.Ref) obj;
        if (refFindTypeRef == null) {
            for (SchemaTypeLoader schemaTypeLoader : this._searchPath) {
                refFindTypeRef = schemaTypeLoader.findTypeRef(qName);
                if (refFindTypeRef != null) {
                    break;
                }
            }
            if (refFindTypeRef == null) {
                SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForComponent = typeSystemForComponent(this._metadataPath + "/type/", qName);
                if (schemaTypeSystemImplTypeSystemForComponent != null) {
                    refFindTypeRef = schemaTypeSystemImplTypeSystemForComponent.findTypeRef(qName);
                }
            }
            this._typeCache.put(qName, refFindTypeRef == null ? CACHED_NOT_FOUND : refFindTypeRef);
        }
        return refFindTypeRef;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public InputStream getSourceAsStream(String str) {
        InputStream resourceAsStream;
        ClassLoader classLoader;
        if (!str.startsWith(PackagingURIHelper.FORWARD_SLASH_STRING)) {
            str = PackagingURIHelper.FORWARD_SLASH_STRING.concat(str);
        }
        ResourceLoader resourceLoader = this._resourceLoader;
        if (resourceLoader != null) {
            resourceAsStream = resourceLoader.getResourceAsStream(this._metadataPath + "/src" + str);
        } else {
            resourceAsStream = null;
        }
        if (resourceAsStream != null || (classLoader = this._classLoader) == null) {
            return resourceAsStream;
        }
        return classLoader.getResourceAsStream(this._metadataPath + "/src" + str);
    }

    public SchemaTypeSystemImpl getTypeSystemOnClassloader(String str) {
        Logger logger = XBeanDebug.LOG;
        logger.atTrace().log("Finding type system {} on classloader", str);
        SchemaTypeSystemImpl schemaTypeSystemImpl = this._classLoaderTypeSystems.get(str);
        if (schemaTypeSystemImpl != null) {
            return schemaTypeSystemImpl;
        }
        logger.atTrace().log("Type system {}} not cached - consulting field", str);
        SchemaTypeSystemImpl schemaTypeSystemImplForName = SchemaTypeSystemImpl.forName(str, this._classLoader);
        this._classLoaderTypeSystems.put(str, schemaTypeSystemImplForName);
        return schemaTypeSystemImplForName;
    }

    public SchemaTypeSystemImpl getTypeSystemOnClasspath(String str) {
        return this._classpathTypeSystems.computeIfAbsent(str, new a(this, 1));
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public boolean isNamespaceDefined(String str) {
        for (SchemaTypeLoader schemaTypeLoader : this._searchPath) {
            if (schemaTypeLoader.isNamespaceDefined(str)) {
                return true;
            }
        }
        return typeSystemForComponent(AbstractC0157z.s(new StringBuilder(), this._metadataPath, "/namespace/"), new QName(str, Sax2Dom.XMLNS_PREFIX)) != null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType typeForClassname(String str) {
        String strReplace = str.replace('$', '.');
        Object obj = this._classnameCache.get(strReplace);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaType schemaTypeTypeForClassname = (SchemaType) obj;
        if (schemaTypeTypeForClassname == null) {
            for (SchemaTypeLoader schemaTypeLoader : this._searchPath) {
                schemaTypeTypeForClassname = schemaTypeLoader.typeForClassname(strReplace);
                if (schemaTypeTypeForClassname != null) {
                    break;
                }
            }
            if (schemaTypeTypeForClassname == null) {
                SchemaTypeSystemImpl schemaTypeSystemImplTypeSystemForClassname = typeSystemForClassname(this._metadataPath + "/javaname/", strReplace);
                if (schemaTypeSystemImplTypeSystemForClassname != null) {
                    schemaTypeTypeForClassname = schemaTypeSystemImplTypeSystemForClassname.typeForClassname(strReplace);
                }
            }
            this._classnameCache.put(strReplace, schemaTypeTypeForClassname == null ? CACHED_NOT_FOUND : schemaTypeTypeForClassname);
        }
        return schemaTypeTypeForClassname;
    }

    public SchemaTypeSystemImpl typeSystemForClassname(String str, String str2) {
        String strCrackEntry;
        String strCrackEntry2;
        StringBuilder sbR = androidx.collection.a.r(str);
        sbR.append(str2.replace('.', '/'));
        sbR.append(".xsb");
        String string = sbR.toString();
        ResourceLoader resourceLoader = this._resourceLoader;
        if (resourceLoader != null && (strCrackEntry2 = crackEntry(resourceLoader, string)) != null) {
            return getTypeSystemOnClasspath(strCrackEntry2);
        }
        ClassLoader classLoader = this._classLoader;
        if (classLoader == null || (strCrackEntry = crackEntry(classLoader, string)) == null) {
            return null;
        }
        return getTypeSystemOnClassloader(strCrackEntry);
    }

    public SchemaTypeSystemImpl typeSystemForComponent(String str, QName qName) {
        StringBuilder sbR = androidx.collection.a.r(str);
        sbR.append(QNameHelper.hexsafedir(qName));
        sbR.append(".xsb");
        String string = sbR.toString();
        ResourceLoader resourceLoader = this._resourceLoader;
        String strCrackEntry = resourceLoader != null ? crackEntry(resourceLoader, string) : null;
        ClassLoader classLoader = this._classLoader;
        if (classLoader != null) {
            strCrackEntry = crackEntry(classLoader, string);
        }
        if (strCrackEntry != null) {
            return (SchemaTypeSystemImpl) typeSystemForName(strCrackEntry);
        }
        return null;
    }

    public SchemaTypeSystem typeSystemForName(String str) {
        SchemaTypeSystemImpl typeSystemOnClassloader;
        SchemaTypeSystemImpl typeSystemOnClasspath;
        if (this._resourceLoader != null && (typeSystemOnClasspath = getTypeSystemOnClasspath(str)) != null) {
            return typeSystemOnClasspath;
        }
        if (this._classLoader == null || (typeSystemOnClassloader = getTypeSystemOnClassloader(str)) == null) {
            return null;
        }
        return typeSystemOnClassloader;
    }

    public static SchemaTypeLoader build(SchemaTypeLoader[] schemaTypeLoaderArr, ResourceLoader resourceLoader, ClassLoader classLoader, String str) {
        SubLoaderList subLoaderList = new SubLoaderList();
        subLoaderList.add(schemaTypeLoaderArr);
        ClassLoader classLoader2 = classLoader == null ? SchemaDocument.class.getClassLoader() : classLoader;
        for (String str2 : basePackage) {
            for (String str3 : baseSchemas) {
                try {
                    subLoaderList.add((SchemaTypeLoader) Class.forName(androidx.exifinterface.media.a.A(str2, ".system.", str3, ".TypeSystemHolder"), true, classLoader2).getDeclaredField("typeSystem").get(null));
                } catch (ClassNotFoundException unused) {
                } catch (Exception e) {
                    throw new XmlRuntimeException(e);
                }
            }
        }
        return new SchemaTypeLoaderImpl(subLoaderList.toArray(), resourceLoader, classLoader, str);
    }

    public static String crackEntry(ClassLoader classLoader, String str) {
        InputStream resourceAsStream = classLoader.getResourceAsStream(str);
        if (resourceAsStream == null) {
            return null;
        }
        return crackPointer(resourceAsStream);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SubLoaderList {
        private final Map<SchemaTypeLoader, Object> seen;
        private final List<SchemaTypeLoader> theList;

        private SubLoaderList() {
            this.theList = new ArrayList();
            this.seen = new IdentityHashMap();
        }

        public void add(SchemaTypeLoader[] schemaTypeLoaderArr) {
            if (schemaTypeLoaderArr == null) {
                return;
            }
            for (SchemaTypeLoader schemaTypeLoader : schemaTypeLoaderArr) {
                if (schemaTypeLoader instanceof SchemaTypeLoaderImpl) {
                    SchemaTypeLoaderImpl schemaTypeLoaderImpl = (SchemaTypeLoaderImpl) schemaTypeLoader;
                    if (schemaTypeLoaderImpl._classLoader == null && schemaTypeLoaderImpl._resourceLoader == null) {
                        add(schemaTypeLoaderImpl._searchPath);
                    } else {
                        add(schemaTypeLoaderImpl);
                    }
                } else {
                    add(schemaTypeLoader);
                }
            }
        }

        public SchemaTypeLoader[] toArray() {
            return (SchemaTypeLoader[]) this.theList.toArray(SchemaTypeLoaderImpl.EMPTY_SCHEMATYPELOADER_ARRAY);
        }

        public void add(SchemaTypeLoader schemaTypeLoader) {
            if (schemaTypeLoader == null || this.seen.containsKey(schemaTypeLoader)) {
                return;
            }
            this.theList.add(schemaTypeLoader);
            this.seen.put(schemaTypeLoader, null);
        }
    }
}
