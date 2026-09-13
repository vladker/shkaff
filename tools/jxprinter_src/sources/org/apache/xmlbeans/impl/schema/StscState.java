package org.apache.xmlbeans.impl.schema;

import A3.AbstractC0157z;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import javax.xml.namespace.QName;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.io.IOUtils;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.xmlbeans.BindingConfig;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ResolverUtil;
import org.apache.xmlbeans.impl.util.HexBin;
import org.apache.xmlbeans.impl.values.XmlStringImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.xml.sax.EntityResolver;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class StscState {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final XmlValueRef[] FACETS_LIST;
    private static final XmlValueRef[] FACETS_NONE;
    static final XmlValueRef[] FACETS_UNION;
    private static final XmlValueRef[] FACETS_WS_COLLAPSE;
    static final boolean[] FIXED_FACETS_LIST;
    private static final boolean[] FIXED_FACETS_NONE;
    static final boolean[] FIXED_FACETS_UNION;
    private static final boolean[] FIXED_FACETS_WS;
    private static final String PROJECT_URL_PREFIX = "project://local";
    private static final ThreadLocal<StscStack> tl_stscStack;
    private boolean _allowPartial;
    private final List<SchemaAnnotation> _annotations;
    private final Map<QName, SchemaAttributeGroup> _attributeGroups;
    private final Map<QName, SchemaType> _attributeTypes;
    private URI _baseURI;
    private Map<QName, QName> _compatMap;
    private BindingConfig _config;
    private final Map<String, SchemaContainer> _containers;
    private SchemaDependencies _dependencies;
    private byte[] _digest;
    private final Map<QName, SchemaType> _documentTypes;
    private boolean _doingDownloads;
    private EntityResolver _entityResolver;
    private Collection<XmlError> _errorListener;
    private String _givenStsName;
    private final Map<QName, SchemaGlobalAttribute> _globalAttributes;
    private final Map<QName, SchemaGlobalElement> _globalElements;
    private final Map<QName, SchemaType> _globalTypes;
    private final Map<QName, SchemaIdentityConstraint> _idConstraints;
    private SchemaTypeLoader _importingLoader;
    private boolean _mdefAll;
    private final Set<String> _mdefNamespaces;
    private final Map<String, SchemaComponent> _misspelledNames;
    private final Map<QName, SchemaModelGroup> _modelGroups;
    private final Set<String> _namespaces;
    private boolean _noAnn;
    private boolean _noDigest;
    private boolean _noPvr;
    private boolean _noUpa;
    private final Set<SchemaComponent> _processingGroups;
    private int _recoveredErrors;
    private final Map<SchemaAttributeGroupImpl, SchemaAttributeGroupImpl> _redefinedAttributeGroups;
    private final Map<SchemaTypeImpl, SchemaTypeImpl> _redefinedGlobalTypes;
    private final Map<SchemaModelGroupImpl, SchemaModelGroupImpl> _redefinedModelGroups;
    private final SchemaTypeLoader _s4sloader;
    private File _schemasDir;
    private final Map<String, String> _sourceForUri;
    private SchemaTypeSystemImpl _target;
    private final Map<String, SchemaType> _typesByClassname;
    private static final XmlValueRef XMLSTR_PRESERVE = buildString("preserve");
    private static final XmlValueRef XMLSTR_REPLACE = buildString("preserve");
    private static final XmlValueRef XMLSTR_COLLAPSE = buildString("preserve");
    static final SchemaType[] EMPTY_ST_ARRAY = new SchemaType[0];

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class StscStack {
        StscState current;
        List<StscState> stack;

        private StscStack() {
            this.stack = new ArrayList();
        }

        public final void pop() {
            this.current = (StscState) AbstractC0157z.f(1, this.stack);
            androidx.exifinterface.media.a.w(1, this.stack);
        }

        public final StscState push() {
            this.stack.add(this.current);
            StscState stscState = new StscState();
            this.current = stscState;
            return stscState;
        }
    }

    static {
        XmlValueRef[] xmlValueRefArr = new XmlValueRef[12];
        FACETS_NONE = xmlValueRefArr;
        boolean[] zArr = new boolean[12];
        FIXED_FACETS_NONE = zArr;
        boolean[] zArr2 = new boolean[12];
        FIXED_FACETS_WS = zArr2;
        XmlValueRef[] xmlValueRefArr2 = {null, null, null, null, null, null, null, null, null, build_wsstring(3), null, null};
        FACETS_WS_COLLAPSE = xmlValueRefArr2;
        FACETS_UNION = xmlValueRefArr;
        FIXED_FACETS_UNION = zArr;
        FACETS_LIST = xmlValueRefArr2;
        FIXED_FACETS_LIST = zArr2;
        tl_stscStack = new ThreadLocal<>();
    }

    private void addContainer(SchemaContainer schemaContainer) {
        this._containers.put(schemaContainer.getNamespace(), schemaContainer);
        final int i5 = 0;
        schemaContainer.globalElements().forEach(new Consumer(this) { // from class: org.apache.xmlbeans.impl.schema.o
            public final /* synthetic */ StscState b;

            {
                this.b = this;
            }

            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                switch (i5) {
                    case 0:
                        this.b.lambda$addContainer$0((SchemaGlobalElement) obj);
                        break;
                    case 1:
                        this.b.lambda$addContainer$1((SchemaGlobalAttribute) obj);
                        break;
                    case 2:
                        this.b.lambda$addContainer$2((SchemaModelGroup) obj);
                        break;
                    case 3:
                        this.b.lambda$addContainer$3((SchemaAttributeGroup) obj);
                        break;
                    default:
                        this.b.lambda$addContainer$4((SchemaIdentityConstraint) obj);
                        break;
                }
            }
        });
        final int i6 = 1;
        schemaContainer.globalAttributes().forEach(new Consumer(this) { // from class: org.apache.xmlbeans.impl.schema.o
            public final /* synthetic */ StscState b;

            {
                this.b = this;
            }

            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                switch (i6) {
                    case 0:
                        this.b.lambda$addContainer$0((SchemaGlobalElement) obj);
                        break;
                    case 1:
                        this.b.lambda$addContainer$1((SchemaGlobalAttribute) obj);
                        break;
                    case 2:
                        this.b.lambda$addContainer$2((SchemaModelGroup) obj);
                        break;
                    case 3:
                        this.b.lambda$addContainer$3((SchemaAttributeGroup) obj);
                        break;
                    default:
                        this.b.lambda$addContainer$4((SchemaIdentityConstraint) obj);
                        break;
                }
            }
        });
        final int i7 = 2;
        schemaContainer.modelGroups().forEach(new Consumer(this) { // from class: org.apache.xmlbeans.impl.schema.o
            public final /* synthetic */ StscState b;

            {
                this.b = this;
            }

            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                switch (i7) {
                    case 0:
                        this.b.lambda$addContainer$0((SchemaGlobalElement) obj);
                        break;
                    case 1:
                        this.b.lambda$addContainer$1((SchemaGlobalAttribute) obj);
                        break;
                    case 2:
                        this.b.lambda$addContainer$2((SchemaModelGroup) obj);
                        break;
                    case 3:
                        this.b.lambda$addContainer$3((SchemaAttributeGroup) obj);
                        break;
                    default:
                        this.b.lambda$addContainer$4((SchemaIdentityConstraint) obj);
                        break;
                }
            }
        });
        final int i8 = 3;
        schemaContainer.attributeGroups().forEach(new Consumer(this) { // from class: org.apache.xmlbeans.impl.schema.o
            public final /* synthetic */ StscState b;

            {
                this.b = this;
            }

            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                switch (i8) {
                    case 0:
                        this.b.lambda$addContainer$0((SchemaGlobalElement) obj);
                        break;
                    case 1:
                        this.b.lambda$addContainer$1((SchemaGlobalAttribute) obj);
                        break;
                    case 2:
                        this.b.lambda$addContainer$2((SchemaModelGroup) obj);
                        break;
                    case 3:
                        this.b.lambda$addContainer$3((SchemaAttributeGroup) obj);
                        break;
                    default:
                        this.b.lambda$addContainer$4((SchemaIdentityConstraint) obj);
                        break;
                }
            }
        });
        schemaContainer.globalTypes().forEach(mapTypes(this._globalTypes, false));
        schemaContainer.documentTypes().forEach(mapTypes(this._documentTypes, true));
        schemaContainer.attributeTypes().forEach(mapTypes(this._attributeTypes, true));
        final int i9 = 4;
        schemaContainer.identityConstraints().forEach(new Consumer(this) { // from class: org.apache.xmlbeans.impl.schema.o
            public final /* synthetic */ StscState b;

            {
                this.b = this;
            }

            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                switch (i9) {
                    case 0:
                        this.b.lambda$addContainer$0((SchemaGlobalElement) obj);
                        break;
                    case 1:
                        this.b.lambda$addContainer$1((SchemaGlobalAttribute) obj);
                        break;
                    case 2:
                        this.b.lambda$addContainer$2((SchemaModelGroup) obj);
                        break;
                    case 3:
                        this.b.lambda$addContainer$3((SchemaAttributeGroup) obj);
                        break;
                    default:
                        this.b.lambda$addContainer$4((SchemaIdentityConstraint) obj);
                        break;
                }
            }
        });
        this._annotations.addAll(schemaContainer.annotations());
        this._namespaces.add(schemaContainer.getNamespace());
        schemaContainer.unsetImmutable();
    }

    public static void addError(Collection<XmlError> collection, String str, int i5, XmlObject xmlObject) {
        collection.add(XmlError.forObject(str, 0, xmlObject));
    }

    public static void addInfo(Collection<XmlError> collection, String str) {
        collection.add(XmlError.forMessage(str, 2));
    }

    public static void addWarning(Collection<XmlError> collection, String str, int i5, XmlObject xmlObject) {
        collection.add(XmlError.forObject(str, 1, xmlObject));
    }

    private static Set<String> buildDefaultMdefNamespaces() {
        return new HashSet(Collections.singletonList("http://www.openuri.org/2002/04/soap/conversation/"));
    }

    public static XmlValueRef buildString(String str) {
        if (str == null) {
            return null;
        }
        try {
            XmlStringImpl xmlStringImpl = new XmlStringImpl();
            xmlStringImpl.setStringValue(str);
            xmlStringImpl.setImmutable();
            return new XmlValueRef(xmlStringImpl);
        } catch (XmlValueOutOfRangeException unused) {
            return null;
        }
    }

    public static XmlValueRef build_wsstring(int i5) {
        if (i5 == 1) {
            return XMLSTR_PRESERVE;
        }
        if (i5 == 2) {
            return XMLSTR_REPLACE;
        }
        if (i5 != 3) {
            return null;
        }
        return XMLSTR_COLLAPSE;
    }

    public static void clearThreadLocals() {
        tl_stscStack.remove();
    }

    private QName compatName(QName qName, String str) {
        QName qName2;
        if (qName.getNamespaceURI().length() == 0 && str != null && str.length() > 0) {
            qName = new QName(str, qName.getLocalPart());
        }
        Map<QName, QName> map = this._compatMap;
        return (map == null || (qName2 = map.get(qName)) == null) ? qName : qName2;
    }

    private static String crunchName(QName qName) {
        return qName.getLocalPart().toLowerCase(Locale.ROOT);
    }

    public static void end() {
        ThreadLocal<StscStack> threadLocal = tl_stscStack;
        StscStack stscStack = threadLocal.get();
        stscStack.pop();
        if (stscStack.stack.size() == 0) {
            threadLocal.remove();
        }
    }

    public static StscState get() {
        return tl_stscStack.get().current;
    }

    private boolean ignoreMdef(QName qName) {
        return this._mdefNamespaces.contains(qName.getNamespaceURI());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addContainer$0(SchemaGlobalElement schemaGlobalElement) {
        this._globalElements.put(schemaGlobalElement.getName(), schemaGlobalElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addContainer$1(SchemaGlobalAttribute schemaGlobalAttribute) {
        this._globalAttributes.put(schemaGlobalAttribute.getName(), schemaGlobalAttribute);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addContainer$2(SchemaModelGroup schemaModelGroup) {
        this._modelGroups.put(schemaModelGroup.getName(), schemaModelGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addContainer$3(SchemaAttributeGroup schemaAttributeGroup) {
        this._attributeGroups.put(schemaAttributeGroup.getName(), schemaAttributeGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addContainer$4(SchemaIdentityConstraint schemaIdentityConstraint) {
        this._idConstraints.put(schemaIdentityConstraint.getName(), schemaIdentityConstraint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mapTypes$5(boolean z6, Map map, SchemaType schemaType) {
        map.put(z6 ? schemaType.getProperties()[0].getName() : schemaType.getName(), schemaType);
        if (schemaType.getFullJavaName() != null) {
            addClassname(schemaType.getFullJavaName(), schemaType);
        }
    }

    private Consumer<SchemaType> mapTypes(final Map<QName, SchemaType> map, final boolean z6) {
        return new Consumer() { // from class: org.apache.xmlbeans.impl.schema.p
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f7381a.lambda$mapTypes$5(z6, map, (SchemaType) obj);
            }
        };
    }

    public static StscState start() {
        ThreadLocal<StscStack> threadLocal = tl_stscStack;
        StscStack stscStack = threadLocal.get();
        if (stscStack == null) {
            stscStack = new StscStack();
            threadLocal.set(stscStack);
        }
        return stscStack.push();
    }

    public void addAnnotation(SchemaAnnotationImpl schemaAnnotationImpl, String str) {
        if (schemaAnnotationImpl != null) {
            SchemaContainer container = getContainer(str);
            this._annotations.add(schemaAnnotationImpl);
            container.addAnnotation(schemaAnnotationImpl);
        }
    }

    public void addAttributeGroup(SchemaAttributeGroupImpl schemaAttributeGroupImpl, SchemaAttributeGroupImpl schemaAttributeGroupImpl2) {
        if (schemaAttributeGroupImpl != null) {
            QName name = schemaAttributeGroupImpl.getName();
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (schemaAttributeGroupImpl2 != null) {
                if (!this._redefinedAttributeGroups.containsKey(schemaAttributeGroupImpl2)) {
                    this._redefinedAttributeGroups.put(schemaAttributeGroupImpl2, schemaAttributeGroupImpl);
                    container.addRedefinedAttributeGroup(schemaAttributeGroupImpl.getRef());
                    return;
                } else {
                    if (ignoreMdef(name)) {
                        return;
                    }
                    if (this._mdefAll) {
                        warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"attribute group", QNameHelper.pretty(name), this._redefinedAttributeGroups.get(schemaAttributeGroupImpl2).getSourceName()}, schemaAttributeGroupImpl.getParseObject());
                        return;
                    } else {
                        error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"attribute group", QNameHelper.pretty(name), this._redefinedAttributeGroups.get(schemaAttributeGroupImpl2).getSourceName()}, schemaAttributeGroupImpl.getParseObject());
                        return;
                    }
                }
            }
            if (!this._attributeGroups.containsKey(name)) {
                this._attributeGroups.put(schemaAttributeGroupImpl.getName(), schemaAttributeGroupImpl);
                addSpelling(schemaAttributeGroupImpl.getName(), schemaAttributeGroupImpl);
                container.addAttributeGroup(schemaAttributeGroupImpl.getRef());
            } else {
                if (ignoreMdef(name)) {
                    return;
                }
                if (this._mdefAll) {
                    warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"attribute group", QNameHelper.pretty(name), this._attributeGroups.get(name).getSourceName()}, schemaAttributeGroupImpl.getParseObject());
                } else {
                    error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"attribute group", QNameHelper.pretty(name), this._attributeGroups.get(name).getSourceName()}, schemaAttributeGroupImpl.getParseObject());
                }
            }
        }
    }

    public void addAttributeType(SchemaTypeImpl schemaTypeImpl, QName qName) {
        if (!this._attributeTypes.containsKey(qName)) {
            this._attributeTypes.put(qName, schemaTypeImpl);
            getContainer(qName.getNamespaceURI()).addAttributeType(schemaTypeImpl.getRef());
        } else {
            if (ignoreMdef(qName)) {
                return;
            }
            if (this._mdefAll) {
                warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global attribute", QNameHelper.pretty(qName), this._attributeTypes.get(qName).getSourceName()}, schemaTypeImpl.getParseObject());
            } else {
                error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global attribute", QNameHelper.pretty(qName), this._attributeTypes.get(qName).getSourceName()}, schemaTypeImpl.getParseObject());
            }
        }
    }

    public void addClassname(String str, SchemaType schemaType) {
        this._typesByClassname.put(str, schemaType);
    }

    public void addDocumentType(SchemaTypeImpl schemaTypeImpl, QName qName) {
        if (!this._documentTypes.containsKey(qName)) {
            this._documentTypes.put(qName, schemaTypeImpl);
            getContainer(qName.getNamespaceURI()).addDocumentType(schemaTypeImpl.getRef());
        } else {
            if (ignoreMdef(qName)) {
                return;
            }
            if (this._mdefAll) {
                warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global element", QNameHelper.pretty(qName), this._documentTypes.get(qName).getSourceName()}, schemaTypeImpl.getParseObject());
            } else {
                error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global element", QNameHelper.pretty(qName), this._documentTypes.get(qName).getSourceName()}, schemaTypeImpl.getParseObject());
            }
        }
    }

    public void addGlobalAttribute(SchemaGlobalAttributeImpl schemaGlobalAttributeImpl) {
        if (schemaGlobalAttributeImpl != null) {
            QName name = schemaGlobalAttributeImpl.getName();
            this._globalAttributes.put(name, schemaGlobalAttributeImpl);
            addSpelling(name, schemaGlobalAttributeImpl);
            getContainer(name.getNamespaceURI()).addGlobalAttribute(schemaGlobalAttributeImpl.getRef());
        }
    }

    public void addGlobalElement(SchemaGlobalElementImpl schemaGlobalElementImpl) {
        if (schemaGlobalElementImpl != null) {
            QName name = schemaGlobalElementImpl.getName();
            this._globalElements.put(name, schemaGlobalElementImpl);
            getContainer(name.getNamespaceURI()).addGlobalElement(schemaGlobalElementImpl.getRef());
            addSpelling(name, schemaGlobalElementImpl);
        }
    }

    public void addGlobalType(SchemaTypeImpl schemaTypeImpl, SchemaTypeImpl schemaTypeImpl2) {
        if (schemaTypeImpl != null) {
            QName name = schemaTypeImpl.getName();
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (schemaTypeImpl2 != null) {
                if (!this._redefinedGlobalTypes.containsKey(schemaTypeImpl2)) {
                    this._redefinedGlobalTypes.put(schemaTypeImpl2, schemaTypeImpl);
                    container.addRedefinedType(schemaTypeImpl.getRef());
                    return;
                } else {
                    if (ignoreMdef(name)) {
                        return;
                    }
                    if (this._mdefAll) {
                        warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global type", QNameHelper.pretty(name), this._redefinedGlobalTypes.get(schemaTypeImpl2).getSourceName()}, schemaTypeImpl.getParseObject());
                        return;
                    } else {
                        error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global type", QNameHelper.pretty(name), this._redefinedGlobalTypes.get(schemaTypeImpl2).getSourceName()}, schemaTypeImpl.getParseObject());
                        return;
                    }
                }
            }
            if (!this._globalTypes.containsKey(name)) {
                this._globalTypes.put(name, schemaTypeImpl);
                container.addGlobalType(schemaTypeImpl.getRef());
                addSpelling(name, schemaTypeImpl);
            } else {
                if (ignoreMdef(name)) {
                    return;
                }
                if (this._mdefAll) {
                    warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global type", QNameHelper.pretty(name), this._globalTypes.get(name).getSourceName()}, schemaTypeImpl.getParseObject());
                } else {
                    error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global type", QNameHelper.pretty(name), this._globalTypes.get(name).getSourceName()}, schemaTypeImpl.getParseObject());
                }
            }
        }
    }

    public void addIdConstraint(SchemaIdentityConstraintImpl schemaIdentityConstraintImpl) {
        if (schemaIdentityConstraintImpl != null) {
            QName name = schemaIdentityConstraintImpl.getName();
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (this._idConstraints.containsKey(name)) {
                if (ignoreMdef(name)) {
                    return;
                }
                warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"identity constraint", QNameHelper.pretty(name), this._idConstraints.get(name).getSourceName()}, schemaIdentityConstraintImpl.getParseObject());
            } else {
                this._idConstraints.put(name, schemaIdentityConstraintImpl);
                addSpelling(schemaIdentityConstraintImpl.getName(), schemaIdentityConstraintImpl);
                container.addIdentityConstraint(schemaIdentityConstraintImpl.getRef());
            }
        }
    }

    public void addModelGroup(SchemaModelGroupImpl schemaModelGroupImpl, SchemaModelGroupImpl schemaModelGroupImpl2) {
        if (schemaModelGroupImpl != null) {
            QName name = schemaModelGroupImpl.getName();
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (schemaModelGroupImpl2 != null) {
                if (!this._redefinedModelGroups.containsKey(schemaModelGroupImpl2)) {
                    this._redefinedModelGroups.put(schemaModelGroupImpl2, schemaModelGroupImpl);
                    container.addRedefinedModelGroup(schemaModelGroupImpl.getRef());
                    return;
                } else {
                    if (ignoreMdef(name)) {
                        return;
                    }
                    if (this._mdefAll) {
                        warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"model group", QNameHelper.pretty(name), this._redefinedModelGroups.get(schemaModelGroupImpl2).getSourceName()}, schemaModelGroupImpl.getParseObject());
                        return;
                    } else {
                        error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"model group", QNameHelper.pretty(name), this._redefinedModelGroups.get(schemaModelGroupImpl2).getSourceName()}, schemaModelGroupImpl.getParseObject());
                        return;
                    }
                }
            }
            if (!this._modelGroups.containsKey(name)) {
                this._modelGroups.put(schemaModelGroupImpl.getName(), schemaModelGroupImpl);
                addSpelling(schemaModelGroupImpl.getName(), schemaModelGroupImpl);
                container.addModelGroup(schemaModelGroupImpl.getRef());
            } else {
                if (ignoreMdef(name)) {
                    return;
                }
                if (this._mdefAll) {
                    warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"model group", QNameHelper.pretty(name), this._modelGroups.get(name).getSourceName()}, schemaModelGroupImpl.getParseObject());
                } else {
                    error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"model group", QNameHelper.pretty(name), this._modelGroups.get(name).getSourceName()}, schemaModelGroupImpl.getParseObject());
                }
            }
        }
    }

    public void addNamespace(String str) {
        this._namespaces.add(str);
    }

    public void addNewContainer(String str) {
        if (this._containers.containsKey(str)) {
            return;
        }
        SchemaContainer schemaContainer = new SchemaContainer(str);
        schemaContainer.setTypeSystem(sts());
        addNamespace(str);
        this._containers.put(str, schemaContainer);
    }

    public void addSchemaDigest(byte[] bArr) {
        if (this._noDigest) {
            return;
        }
        if (bArr == null) {
            this._noDigest = true;
            this._digest = null;
            return;
        }
        if (this._digest == null) {
            this._digest = new byte[16];
        }
        int length = this._digest.length;
        if (bArr.length < length) {
            length = bArr.length;
        }
        for (int i5 = 0; i5 < length; i5++) {
            byte[] bArr2 = this._digest;
            bArr2[i5] = (byte) (bArr2[i5] ^ bArr[i5]);
        }
    }

    public void addSourceUri(String str, String str2) {
        if (str == null) {
            return;
        }
        if (str2 == null) {
            str2 = computeSavedFilename(str);
        }
        this._sourceForUri.put(str, str2);
    }

    public void addSpelling(QName qName, SchemaComponent schemaComponent) {
        this._misspelledNames.put(crunchName(qName), schemaComponent);
    }

    public boolean allowPartial() {
        return this._allowPartial;
    }

    public List<SchemaAnnotation> annotations() {
        return this._annotations;
    }

    public SchemaAttributeGroup[] attributeGroups() {
        return (SchemaAttributeGroup[]) this._attributeGroups.values().toArray(new SchemaAttributeGroup[0]);
    }

    public SchemaType[] attributeTypes() {
        return (SchemaType[]) this._attributeTypes.values().toArray(new SchemaType[0]);
    }

    public String computeSavedFilename(String str) {
        return relativize(str, true);
    }

    public SchemaType[] documentTypes() {
        return (SchemaType[]) this._documentTypes.values().toArray(new SchemaType[0]);
    }

    public void error(String str, int i5, XmlObject xmlObject) {
        addError(this._errorListener, str, i5, xmlObject);
    }

    public SchemaAttributeGroupImpl findAttributeGroup(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaAttributeGroupImpl schemaAttributeGroupImpl = (SchemaAttributeGroupImpl) this._attributeGroups.get(qNameCompatName);
        boolean z6 = false;
        if (schemaAttributeGroupImpl == null && (schemaAttributeGroupImpl = (SchemaAttributeGroupImpl) this._importingLoader.findAttributeGroup(qNameCompatName)) != null) {
            z6 = true;
        }
        if (!z6 && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaAttributeGroupImpl;
    }

    public SchemaTypeImpl findAttributeType(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) this._attributeTypes.get(qNameCompatName);
        boolean z6 = false;
        if (schemaTypeImpl == null && (schemaTypeImpl = (SchemaTypeImpl) this._importingLoader.findAttributeType(qNameCompatName)) != null) {
            z6 = true;
        }
        if (!z6 && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaTypeImpl;
    }

    public SchemaTypeImpl findDocumentType(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) this._documentTypes.get(qNameCompatName);
        boolean z6 = false;
        if (schemaTypeImpl == null && (schemaTypeImpl = (SchemaTypeImpl) this._importingLoader.findDocumentType(qNameCompatName)) != null) {
            z6 = true;
        }
        if (!z6 && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaTypeImpl;
    }

    public SchemaGlobalAttributeImpl findGlobalAttribute(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = (SchemaGlobalAttributeImpl) this._globalAttributes.get(qNameCompatName);
        boolean z6 = false;
        if (schemaGlobalAttributeImpl == null && (schemaGlobalAttributeImpl = (SchemaGlobalAttributeImpl) this._importingLoader.findAttribute(qNameCompatName)) != null) {
            z6 = true;
        }
        if (!z6 && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaGlobalAttributeImpl;
    }

    public SchemaGlobalElementImpl findGlobalElement(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaGlobalElementImpl schemaGlobalElementImpl = (SchemaGlobalElementImpl) this._globalElements.get(qNameCompatName);
        boolean z6 = false;
        if (schemaGlobalElementImpl == null && (schemaGlobalElementImpl = (SchemaGlobalElementImpl) this._importingLoader.findElement(qNameCompatName)) != null) {
            z6 = true;
        }
        if (!z6 && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaGlobalElementImpl;
    }

    public SchemaTypeImpl findGlobalType(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) this._globalTypes.get(qNameCompatName);
        boolean z6 = false;
        if (schemaTypeImpl == null && (schemaTypeImpl = (SchemaTypeImpl) this._importingLoader.findType(qNameCompatName)) != null) {
            z6 = true;
        }
        if (!z6 && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaTypeImpl;
    }

    public SchemaIdentityConstraintImpl findIdConstraint(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        if (str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return (SchemaIdentityConstraintImpl) this._idConstraints.get(qNameCompatName);
    }

    public SchemaModelGroupImpl findModelGroup(QName qName, String str, String str2) {
        QName qNameCompatName = compatName(qName, str);
        SchemaModelGroupImpl schemaModelGroupImpl = (SchemaModelGroupImpl) this._modelGroups.get(qNameCompatName);
        boolean z6 = false;
        if (schemaModelGroupImpl == null && (schemaModelGroupImpl = (SchemaModelGroupImpl) this._importingLoader.findModelGroup(qNameCompatName)) != null) {
            z6 = true;
        }
        if (!z6 && str2 != null) {
            registerDependency(str2, qNameCompatName.getNamespaceURI());
        }
        return schemaModelGroupImpl;
    }

    public SchemaAttributeGroupImpl findRedefinedAttributeGroup(QName qName, String str, SchemaAttributeGroupImpl schemaAttributeGroupImpl) {
        QName name = schemaAttributeGroupImpl.getName();
        QName qNameCompatName = compatName(qName, str);
        if (qNameCompatName.equals(name)) {
            return this._redefinedAttributeGroups.get(schemaAttributeGroupImpl);
        }
        SchemaAttributeGroupImpl schemaAttributeGroupImpl2 = (SchemaAttributeGroupImpl) this._attributeGroups.get(qNameCompatName);
        return schemaAttributeGroupImpl2 == null ? (SchemaAttributeGroupImpl) this._importingLoader.findAttributeGroup(qNameCompatName) : schemaAttributeGroupImpl2;
    }

    public SchemaTypeImpl findRedefinedGlobalType(QName qName, String str, SchemaTypeImpl schemaTypeImpl) {
        QName name = schemaTypeImpl.getName();
        QName qNameCompatName = compatName(qName, str);
        if (qNameCompatName.equals(name)) {
            return this._redefinedGlobalTypes.get(schemaTypeImpl);
        }
        SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) this._globalTypes.get(qNameCompatName);
        return schemaTypeImpl2 == null ? (SchemaTypeImpl) this._importingLoader.findType(qNameCompatName) : schemaTypeImpl2;
    }

    public SchemaModelGroupImpl findRedefinedModelGroup(QName qName, String str, SchemaModelGroupImpl schemaModelGroupImpl) {
        QName name = schemaModelGroupImpl.getName();
        QName qNameCompatName = compatName(qName, str);
        if (qNameCompatName.equals(name)) {
            return this._redefinedModelGroups.get(schemaModelGroupImpl);
        }
        SchemaModelGroupImpl schemaModelGroupImpl2 = (SchemaModelGroupImpl) this._modelGroups.get(qNameCompatName);
        return schemaModelGroupImpl2 == null ? (SchemaModelGroupImpl) this._importingLoader.findModelGroup(qNameCompatName) : schemaModelGroupImpl2;
    }

    public SchemaComponent findSpelling(QName qName) {
        return this._misspelledNames.get(crunchName(qName));
    }

    public void finishProcessing(SchemaComponent schemaComponent) {
        this._processingGroups.remove(schemaComponent);
    }

    public BindingConfig getBindingConfig() {
        return this._config;
    }

    public SchemaContainer getContainer(String str) {
        return this._containers.get(str);
    }

    public Map<String, SchemaContainer> getContainerMap() {
        return Collections.unmodifiableMap(this._containers);
    }

    public SchemaComponent[] getCurrentProcessing() {
        return (SchemaComponent[]) this._processingGroups.toArray(new SchemaComponent[0]);
    }

    public SchemaDependencies getDependencies() {
        return this._dependencies;
    }

    public EntityResolver getEntityResolver() {
        return this._entityResolver;
    }

    public Collection<XmlError> getErrorListener() {
        return this._errorListener;
    }

    public String getJavaPrefix(String str) {
        BindingConfig bindingConfig = this._config;
        if (bindingConfig == null) {
            return null;
        }
        return bindingConfig.lookupPrefixForNamespace(str);
    }

    public String getJavaSuffix(String str) {
        BindingConfig bindingConfig = this._config;
        if (bindingConfig == null) {
            return null;
        }
        return bindingConfig.lookupSuffixForNamespace(str);
    }

    public String getJavaname(QName qName, int i5) {
        BindingConfig bindingConfig = this._config;
        if (bindingConfig == null) {
            return null;
        }
        return bindingConfig.lookupJavanameForQName(qName, i5);
    }

    public String[] getNamespaces() {
        return (String[]) this._namespaces.toArray(new String[0]);
    }

    public String getPackageOverride(String str) {
        BindingConfig bindingConfig = this._config;
        if (bindingConfig == null) {
            return null;
        }
        return bindingConfig.lookupPackageForNamespace(str);
    }

    public int getRecovered() {
        return this._recoveredErrors;
    }

    public SchemaTypeLoader getS4SLoader() {
        return this._s4sloader;
    }

    public File getSchemasDir() {
        return this._schemasDir;
    }

    public SchemaGlobalAttribute[] globalAttributes() {
        return (SchemaGlobalAttribute[]) this._globalAttributes.values().toArray(new SchemaGlobalAttribute[0]);
    }

    public SchemaGlobalElement[] globalElements() {
        return (SchemaGlobalElement[]) this._globalElements.values().toArray(new SchemaGlobalElement[0]);
    }

    public SchemaType[] globalTypes() {
        return (SchemaType[]) this._globalTypes.values().toArray(new SchemaType[0]);
    }

    public SchemaIdentityConstraintImpl[] idConstraints() {
        return (SchemaIdentityConstraintImpl[]) this._idConstraints.values().toArray(new SchemaIdentityConstraintImpl[0]);
    }

    public void info(String str) {
        addInfo(this._errorListener, str);
    }

    public void initFromTypeSystem(SchemaTypeSystemImpl schemaTypeSystemImpl, Set<String> set) {
        for (SchemaContainer schemaContainer : schemaTypeSystemImpl.containers()) {
            if (!set.contains(schemaContainer.getNamespace())) {
                addContainer(schemaContainer);
            }
        }
    }

    public boolean isFileProcessed(String str) {
        return this._dependencies.isFileRepresented(str);
    }

    public boolean isProcessing(SchemaComponent schemaComponent) {
        return this._processingGroups.contains(schemaComponent);
    }

    public boolean linkerDefinesNamespace(String str) {
        return this._importingLoader.isNamespaceDefined(str);
    }

    public SchemaModelGroup[] modelGroups() {
        return (SchemaModelGroup[]) this._modelGroups.values().toArray(new SchemaModelGroup[0]);
    }

    public boolean noAnn() {
        return this._noAnn;
    }

    public boolean noPvr() {
        return this._noPvr;
    }

    public boolean noUpa() {
        return this._noUpa;
    }

    public void notFoundError(QName qName, int i5, XmlObject xmlObject, boolean z6) {
        String str;
        String str2;
        String strPretty;
        String str3;
        QName name;
        String sourceName;
        String strPretty2 = QNameHelper.pretty(qName);
        if (z6) {
            this._recoveredErrors++;
        }
        String str4 = "element";
        if (i5 == 0) {
            str = "type";
        } else if (i5 == 1) {
            str = "element";
        } else if (i5 == 3) {
            str = "attribute";
        } else if (i5 == 4) {
            str = "attribute group";
        } else if (i5 != 5) {
            str = i5 != 6 ? "definition" : "model group";
        } else {
            str = "identity constraint";
        }
        SchemaComponent schemaComponentFindSpelling = findSpelling(qName);
        if (schemaComponentFindSpelling == null || (name = schemaComponentFindSpelling.getName()) == null) {
            str2 = null;
            strPretty = null;
            str3 = null;
        } else {
            int componentType = schemaComponentFindSpelling.getComponentType();
            if (componentType == 0) {
                str4 = "type";
                sourceName = schemaComponentFindSpelling.getSourceName();
            } else if (componentType == 1) {
                sourceName = schemaComponentFindSpelling.getSourceName();
            } else if (componentType != 3) {
                if (componentType == 4) {
                    str4 = "attribute group";
                } else if (componentType != 6) {
                    sourceName = null;
                    str4 = null;
                } else {
                    str4 = "model group";
                }
                sourceName = null;
            } else {
                sourceName = schemaComponentFindSpelling.getSourceName();
                str4 = "attribute";
            }
            if (sourceName != null) {
                sourceName = sourceName.substring(sourceName.lastIndexOf(47) + 1);
            }
            if (name.equals(qName)) {
                str3 = sourceName;
                str2 = str4;
                strPretty = null;
            } else {
                str3 = sourceName;
                str2 = str4;
                strPretty = QNameHelper.pretty(name);
            }
        }
        if (str2 == null) {
            error(XmlErrorCodes.SCHEMA_QNAME_RESOLVE, new Object[]{str, strPretty2}, xmlObject);
        } else {
            error(XmlErrorCodes.SCHEMA_QNAME_RESOLVE$HELP, new Object[]{str, strPretty2, str2, Integer.valueOf(strPretty == null ? 0 : 1), strPretty, Integer.valueOf(str3 == null ? 0 : 1), str3}, xmlObject);
        }
    }

    public void recover(String str, Object[] objArr, XmlObject xmlObject) {
        addError(this._errorListener, str, objArr, xmlObject);
        this._recoveredErrors++;
    }

    public SchemaAttributeGroup[] redefinedAttributeGroups() {
        return (SchemaAttributeGroup[]) this._redefinedAttributeGroups.values().toArray(new SchemaAttributeGroup[0]);
    }

    public SchemaType[] redefinedGlobalTypes() {
        return (SchemaType[]) this._redefinedGlobalTypes.values().toArray(new SchemaType[0]);
    }

    public SchemaModelGroup[] redefinedModelGroups() {
        return (SchemaModelGroup[]) this._redefinedModelGroups.values().toArray(new SchemaModelGroup[0]);
    }

    public void registerContribution(String str, String str2) {
        this._dependencies.registerContribution(str, str2);
    }

    public void registerDependency(String str, String str2) {
        this._dependencies.registerDependency(str, str2);
    }

    public String relativize(String str) {
        return relativize(str, false);
    }

    public void setBaseUri(URI uri) {
        this._baseURI = uri;
    }

    public void setBindingConfig(BindingConfig bindingConfig) {
        this._config = bindingConfig;
    }

    public void setDependencies(SchemaDependencies schemaDependencies) {
        this._dependencies = schemaDependencies;
    }

    public void setErrorListener(Collection<XmlError> collection) {
        this._errorListener = collection;
    }

    public void setGivenTypeSystemName(String str) {
        this._givenStsName = str;
    }

    public void setImportingTypeLoader(SchemaTypeLoader schemaTypeLoader) {
        this._importingLoader = schemaTypeLoader;
    }

    public void setOptions(XmlOptions xmlOptions) {
        if (xmlOptions == null) {
            return;
        }
        this._allowPartial = xmlOptions.isCompilePartialTypesystem();
        this._compatMap = xmlOptions.getCompileSubstituteNames();
        this._noUpa = xmlOptions.isCompileNoUpaRule() || !"true".equals(SystemProperties.getProperty("xmlbean.uniqueparticleattribution", "true"));
        this._noPvr = xmlOptions.isCompileNoPvrRule() || !"true".equals(SystemProperties.getProperty("xmlbean.particlerestriction", "true"));
        this._noAnn = xmlOptions.isCompileNoAnnotations() || !"true".equals(SystemProperties.getProperty("xmlbean.schemaannotations", "true"));
        this._doingDownloads = xmlOptions.isCompileDownloadUrls() || "true".equals(SystemProperties.getProperty("xmlbean.downloadurls", "false"));
        EntityResolver entityResolver = xmlOptions.getEntityResolver();
        this._entityResolver = entityResolver;
        if (entityResolver == null) {
            this._entityResolver = ResolverUtil.getGlobalEntityResolver();
        }
        if (this._entityResolver != null) {
            this._doingDownloads = true;
        }
        Set<String> compileMdefNamespaces = xmlOptions.getCompileMdefNamespaces();
        if (compileMdefNamespaces != null) {
            this._mdefNamespaces.addAll(compileMdefNamespaces);
            if (this._mdefNamespaces.contains("##local")) {
                this._mdefNamespaces.remove("##local");
                this._mdefNamespaces.add("");
            }
            if (this._mdefNamespaces.contains("##any")) {
                this._mdefNamespaces.remove("##any");
                this._mdefAll = true;
            }
        }
    }

    public void setSchemasDir(File file) {
        this._schemasDir = file;
    }

    public void setTargetSchemaTypeSystem(SchemaTypeSystemImpl schemaTypeSystemImpl) {
        this._target = schemaTypeSystemImpl;
    }

    public boolean shouldDownloadURI(String str) {
        if (this._doingDownloads) {
            return true;
        }
        if (str == null) {
            return false;
        }
        try {
            URI uri = new URI(str);
            if (!uri.getScheme().equalsIgnoreCase(ArchiveStreamFactory.JAR) && !uri.getScheme().equalsIgnoreCase(ArchiveStreamFactory.ZIP)) {
                return uri.getScheme().equalsIgnoreCase(Constants.FILE);
            }
            String schemeSpecificPart = uri.getSchemeSpecificPart();
            int iLastIndexOf = schemeSpecificPart.lastIndexOf(33);
            if (iLastIndexOf > 0) {
                schemeSpecificPart = schemeSpecificPart.substring(0, iLastIndexOf);
            }
            return shouldDownloadURI(schemeSpecificPart);
        } catch (Exception unused) {
            return false;
        }
    }

    public Map<String, String> sourceCopyMap() {
        return Collections.unmodifiableMap(this._sourceForUri);
    }

    public String sourceNameForUri(String str) {
        return this._sourceForUri.get(str);
    }

    public void startProcessing(SchemaComponent schemaComponent) {
        this._processingGroups.add(schemaComponent);
    }

    public SchemaTypeSystemImpl sts() {
        byte[] bArr;
        SchemaTypeSystemImpl schemaTypeSystemImpl = this._target;
        if (schemaTypeSystemImpl != null) {
            return schemaTypeSystemImpl;
        }
        String strConcat = this._givenStsName;
        if (strConcat == null && (bArr = this._digest) != null) {
            strConcat = "s".concat(new String(HexBin.encode(bArr), StandardCharsets.ISO_8859_1));
        }
        SchemaTypeSystemImpl schemaTypeSystemImpl2 = new SchemaTypeSystemImpl(strConcat);
        this._target = schemaTypeSystemImpl2;
        return schemaTypeSystemImpl2;
    }

    public Map<String, SchemaType> typesByClassname() {
        return Collections.unmodifiableMap(this._typesByClassname);
    }

    public void warning(String str, int i5, XmlObject xmlObject) {
        addWarning(this._errorListener, str, i5, xmlObject);
    }

    private StscState() {
        this._digest = null;
        this._noDigest = false;
        this._allowPartial = false;
        this._recoveredErrors = 0;
        this._containers = new LinkedHashMap();
        this._redefinedGlobalTypes = new LinkedHashMap();
        this._redefinedModelGroups = new LinkedHashMap();
        this._redefinedAttributeGroups = new LinkedHashMap();
        this._globalTypes = new LinkedHashMap();
        this._globalElements = new LinkedHashMap();
        this._globalAttributes = new LinkedHashMap();
        this._modelGroups = new LinkedHashMap();
        this._attributeGroups = new LinkedHashMap();
        this._documentTypes = new LinkedHashMap();
        this._attributeTypes = new LinkedHashMap();
        this._typesByClassname = new LinkedHashMap();
        this._misspelledNames = new HashMap();
        this._processingGroups = new LinkedHashSet();
        this._idConstraints = new LinkedHashMap();
        this._namespaces = new HashSet();
        this._annotations = new ArrayList();
        this._mdefNamespaces = buildDefaultMdefNamespaces();
        this._sourceForUri = new HashMap();
        this._baseURI = URI.create("project://local/");
        this._s4sloader = XmlBeans.typeLoaderForClassLoader(SchemaDocument.class.getClassLoader());
    }

    private String relativize(String str, boolean z6) {
        if (str == null) {
            return null;
        }
        if (str.startsWith(PackagingURIHelper.FORWARD_SLASH_STRING)) {
            str = PROJECT_URL_PREFIX + str.replace(IOUtils.DIR_SEPARATOR_WINDOWS, '/');
        } else {
            int iIndexOf = str.indexOf(58);
            if (iIndexOf <= 1 || !str.substring(0, iIndexOf).matches("^\\w+$")) {
                str = "project://local/" + str.replace(IOUtils.DIR_SEPARATOR_WINDOWS, '/');
            }
        }
        URI uri = this._baseURI;
        if (uri != null) {
            try {
                URI uriRelativize = uri.relativize(new URI(str));
                if (!uriRelativize.isAbsolute()) {
                    return uriRelativize.toString();
                }
                str = uriRelativize.toString();
            } catch (URISyntaxException unused) {
            }
        }
        if (!z6) {
            return str;
        }
        int iLastIndexOf = str.lastIndexOf(47);
        String strHexsafe = QNameHelper.hexsafe(iLastIndexOf == -1 ? "" : str.substring(0, iLastIndexOf));
        int i5 = iLastIndexOf + 1;
        int iIndexOf2 = str.indexOf(63, i5);
        if (iIndexOf2 == -1) {
            return androidx.exifinterface.media.a.j(str, i5, AbstractC0157z.x(strHexsafe, PackagingURIHelper.FORWARD_SLASH_STRING));
        }
        String strHexsafe2 = QNameHelper.hexsafe(str.substring(iIndexOf2));
        if (strHexsafe2.startsWith(QNameHelper.URI_SHA1_PREFIX)) {
            StringBuilder sbX = AbstractC0157z.x(strHexsafe, PackagingURIHelper.FORWARD_SLASH_STRING);
            sbX.append(str.substring(i5, iIndexOf2));
            return sbX.toString();
        }
        StringBuilder sbX2 = AbstractC0157z.x(strHexsafe, PackagingURIHelper.FORWARD_SLASH_STRING);
        sbX2.append(str.substring(i5, iIndexOf2));
        sbX2.append(strHexsafe2);
        return sbX2.toString();
    }

    public void error(String str, Object[] objArr, XmlObject xmlObject) {
        addError(this._errorListener, str, objArr, xmlObject);
    }

    public void info(String str, Object[] objArr) {
        addInfo(this._errorListener, str, objArr);
    }

    public void warning(String str, Object[] objArr, XmlObject xmlObject) {
        if (!XmlErrorCodes.RESERVED_TYPE_NAME.equals(str) || xmlObject.documentProperties().getSourceName() == null || xmlObject.documentProperties().getSourceName().indexOf("XMLSchema.xsd") <= 0) {
            addWarning(this._errorListener, str, objArr, xmlObject);
        }
    }

    public static void addError(Collection<XmlError> collection, String str, Object[] objArr, XmlObject xmlObject) {
        collection.add(XmlError.forObject(str, objArr, 0, xmlObject));
    }

    public static void addInfo(Collection<XmlError> collection, String str, Object[] objArr) {
        collection.add(XmlError.forMessage(str, objArr, 2));
    }

    public static void addWarning(Collection<XmlError> collection, String str, Object[] objArr, XmlObject xmlObject) {
        collection.add(XmlError.forObject(str, objArr, 1, xmlObject));
    }

    public static void addError(Collection<XmlError> collection, String str, Object[] objArr, File file) {
        collection.add(XmlError.forLocation(str, objArr, 0, file.toURI().toString(), 0, 0, 0));
    }

    public static void addError(Collection<XmlError> collection, String str, Object[] objArr, URL url) {
        collection.add(XmlError.forLocation(str, objArr, 0, url.toString(), 0, 0, 0));
    }
}
