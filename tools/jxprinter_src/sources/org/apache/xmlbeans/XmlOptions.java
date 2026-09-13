package org.apache.xmlbeans;

import java.io.Serializable;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.store.Saaj;
import org.xml.sax.EntityResolver;
import org.xml.sax.XMLReader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XmlOptions implements Serializable {
    public static final int DEFAULT_ENTITY_EXPANSION_LIMIT = 2048;
    private static final XmlOptions EMPTY_OPTIONS;
    private static final long serialVersionUID = 1;
    private Map<XmlOptionsKeys, Object> _map;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum BeanMethod {
        GET,
        XGET,
        IS_SET,
        IS_NIL,
        IS_NIL_IDX,
        SET,
        SET_NIL,
        SET_NIL_IDX,
        XSET,
        UNSET,
        GET_ARRAY,
        XGET_ARRAY,
        GET_IDX,
        XGET_IDX,
        XSET_ARRAY,
        XSET_IDX,
        SIZE_OF_ARRAY,
        SET_ARRAY,
        SET_IDX,
        INSERT_IDX,
        INSERT_NEW_IDX,
        ADD,
        ADD_NEW,
        REMOVE_IDX,
        GET_LIST,
        XGET_LIST,
        SET_LIST,
        INSTANCE_TYPE
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum XmlOptionsKeys {
        SAVE_NAMESPACES_FIRST,
        SAVE_SYNTHETIC_DOCUMENT_ELEMENT,
        SAVE_PRETTY_PRINT,
        SAVE_PRETTY_PRINT_INDENT,
        SAVE_PRETTY_PRINT_OFFSET,
        SAVE_AGGRESSIVE_NAMESPACES,
        SAVE_USE_DEFAULT_NAMESPACE,
        SAVE_IMPLICIT_NAMESPACES,
        SAVE_SUGGESTED_PREFIXES,
        SAVE_FILTER_PROCINST,
        SAVE_USE_OPEN_FRAGMENT,
        SAVE_OUTER,
        SAVE_INNER,
        SAVE_NO_XML_DECL,
        SAVE_SUBSTITUTE_CHARACTERS,
        SAVE_OPTIMIZE_FOR_SPEED,
        SAVE_CDATA_LENGTH_THRESHOLD,
        SAVE_CDATA_ENTITY_COUNT_THRESHOLD,
        SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES,
        LOAD_REPLACE_DOCUMENT_ELEMENT,
        LOAD_STRIP_WHITESPACE,
        LOAD_STRIP_COMMENTS,
        LOAD_STRIP_PROCINSTS,
        LOAD_LINE_NUMBERS,
        LOAD_LINE_NUMBERS_END_ELEMENT,
        LOAD_SAVE_CDATA_BOOKMARKS,
        LOAD_SUBSTITUTE_NAMESPACES,
        LOAD_TRIM_TEXT_BUFFER,
        LOAD_ADDITIONAL_NAMESPACES,
        LOAD_MESSAGE_DIGEST,
        LOAD_USE_DEFAULT_RESOLVER,
        LOAD_USE_XMLREADER,
        XQUERY_CURRENT_NODE_VAR,
        XQUERY_VARIABLE_MAP,
        CHARACTER_ENCODING,
        ERROR_LISTENER,
        DOCUMENT_TYPE,
        DOCUMENT_SOURCE_NAME,
        COMPILE_SUBSTITUTE_NAMES,
        COMPILE_NO_VALIDATION,
        COMPILE_NO_UPA_RULE,
        COMPILE_NO_PVR_RULE,
        COMPILE_NO_ANNOTATIONS,
        COMPILE_DOWNLOAD_URLS,
        COMPILE_MDEF_NAMESPACES,
        COMPILE_PARTIAL_TYPESYSTEM,
        COMPILE_PARTIAL_METHODS,
        COMPILE_ANNOTATION_JAVADOC,
        VALIDATE_ON_SET,
        VALIDATE_TREAT_LAX_AS_SKIP,
        VALIDATE_STRICT,
        VALIDATE_TEXT_ONLY,
        UNSYNCHRONIZED,
        ENTITY_RESOLVER,
        BASE_URI,
        SCHEMA_CODE_PRINTER,
        GENERATE_JAVA_VERSION,
        USE_SAME_LOCALE,
        COPY_USE_NEW_SYNC_DOMAIN,
        LOAD_ENTITY_BYTES_LIMIT,
        ENTITY_EXPANSION_LIMIT,
        LOAD_DTD_GRAMMAR,
        LOAD_EXTERNAL_DTD,
        DISALLOW_DOCTYPE_DECLARATION,
        SAAJ_IMPL,
        LOAD_USE_LOCALE_CHAR_UTIL,
        XPATH_USE_SAXON,
        XPATH_USE_XMLBEANS,
        ATTRIBUTE_VALIDATION_COMPAT_MODE
    }

    static {
        XmlOptions xmlOptions = new XmlOptions();
        EMPTY_OPTIONS = xmlOptions;
        xmlOptions._map = Collections.unmodifiableMap(xmlOptions._map);
    }

    public XmlOptions() {
        this._map = new HashMap();
    }

    public static XmlOptions maskNull(XmlOptions xmlOptions) {
        return xmlOptions == null ? EMPTY_OPTIONS : xmlOptions;
    }

    private XmlOptions set(XmlOptionsKeys xmlOptionsKeys) {
        return set(xmlOptionsKeys, true);
    }

    public boolean disallowDocTypeDeclaration() {
        Boolean bool = (Boolean) get(XmlOptionsKeys.DISALLOW_DOCTYPE_DECLARATION);
        return bool != null && bool.booleanValue();
    }

    public Object get(XmlOptionsKeys xmlOptionsKeys) {
        return this._map.get(xmlOptionsKeys);
    }

    public URI getBaseURI() {
        return (URI) get(XmlOptionsKeys.BASE_URI);
    }

    public String getCharacterEncoding() {
        return (String) get(XmlOptionsKeys.CHARACTER_ENCODING);
    }

    public Set<String> getCompileMdefNamespaces() {
        return (Set) get(XmlOptionsKeys.COMPILE_MDEF_NAMESPACES);
    }

    public Set<BeanMethod> getCompilePartialMethod() {
        return (Set) get(XmlOptionsKeys.COMPILE_PARTIAL_METHODS);
    }

    public Map<QName, QName> getCompileSubstituteNames() {
        return (Map) get(XmlOptionsKeys.COMPILE_SUBSTITUTE_NAMES);
    }

    public String getDocumentSourceName() {
        return (String) get(XmlOptionsKeys.DOCUMENT_SOURCE_NAME);
    }

    public SchemaType getDocumentType() {
        return (SchemaType) get(XmlOptionsKeys.DOCUMENT_TYPE);
    }

    public int getEntityExpansionLimit() {
        Integer num = (Integer) get(XmlOptionsKeys.ENTITY_EXPANSION_LIMIT);
        if (num == null) {
            return 2048;
        }
        return num.intValue();
    }

    public EntityResolver getEntityResolver() {
        return (EntityResolver) get(XmlOptionsKeys.ENTITY_RESOLVER);
    }

    public Collection<XmlError> getErrorListener() {
        return (Collection) get(XmlOptionsKeys.ERROR_LISTENER);
    }

    public Map<String, String> getLoadAdditionalNamespaces() {
        return (Map) get(XmlOptionsKeys.LOAD_ADDITIONAL_NAMESPACES);
    }

    public Integer getLoadEntityBytesLimit() {
        return (Integer) get(XmlOptionsKeys.LOAD_ENTITY_BYTES_LIMIT);
    }

    public QName getLoadReplaceDocumentElement() {
        return (QName) get(XmlOptionsKeys.LOAD_REPLACE_DOCUMENT_ELEMENT);
    }

    public Map<String, String> getLoadSubstituteNamespaces() {
        return (Map) get(XmlOptionsKeys.LOAD_SUBSTITUTE_NAMESPACES);
    }

    public XMLReader getLoadUseXMLReader() {
        return (XMLReader) get(XmlOptionsKeys.LOAD_USE_XMLREADER);
    }

    public Saaj getSaaj() {
        return (Saaj) get(XmlOptionsKeys.SAAJ_IMPL);
    }

    public Integer getSaveCDataEntityCountThreshold() {
        return (Integer) get(XmlOptionsKeys.SAVE_CDATA_ENTITY_COUNT_THRESHOLD);
    }

    public Integer getSaveCDataLengthThreshold() {
        return (Integer) get(XmlOptionsKeys.SAVE_CDATA_LENGTH_THRESHOLD);
    }

    public String getSaveFilterProcinst() {
        return (String) get(XmlOptionsKeys.SAVE_FILTER_PROCINST);
    }

    public Map<String, String> getSaveImplicitNamespaces() {
        return (Map) get(XmlOptionsKeys.SAVE_IMPLICIT_NAMESPACES);
    }

    public Integer getSavePrettyPrintIndent() {
        return (Integer) get(XmlOptionsKeys.SAVE_PRETTY_PRINT_INDENT);
    }

    public Integer getSavePrettyPrintOffset() {
        return (Integer) get(XmlOptionsKeys.SAVE_PRETTY_PRINT_OFFSET);
    }

    public XmlOptionCharEscapeMap getSaveSubstituteCharacters() {
        return (XmlOptionCharEscapeMap) get(XmlOptionsKeys.SAVE_SUBSTITUTE_CHARACTERS);
    }

    public Map<String, String> getSaveSuggestedPrefixes() {
        return (Map) get(XmlOptionsKeys.SAVE_SUGGESTED_PREFIXES);
    }

    public QName getSaveSyntheticDocumentElement() {
        return (QName) get(XmlOptionsKeys.SAVE_SYNTHETIC_DOCUMENT_ELEMENT);
    }

    public SchemaCodePrinter getSchemaCodePrinter() {
        return (SchemaCodePrinter) get(XmlOptionsKeys.SCHEMA_CODE_PRINTER);
    }

    public Object getUseSameLocale() {
        return get(XmlOptionsKeys.USE_SAME_LOCALE);
    }

    public String getXqueryCurrentNodeVar() {
        return (String) get(XmlOptionsKeys.XQUERY_CURRENT_NODE_VAR);
    }

    public Map<String, Object> getXqueryVariables() {
        return (Map) get(XmlOptionsKeys.XQUERY_VARIABLE_MAP);
    }

    public boolean hasOption(XmlOptionsKeys xmlOptionsKeys) {
        return this._map.containsKey(xmlOptionsKeys);
    }

    public boolean isAttributeValidationCompatMode() {
        Boolean bool = (Boolean) get(XmlOptionsKeys.ATTRIBUTE_VALIDATION_COMPAT_MODE);
        return bool != null && bool.booleanValue();
    }

    public boolean isCompileAnnotationAsJavadoc() {
        Boolean bool = (Boolean) get(XmlOptionsKeys.COMPILE_ANNOTATION_JAVADOC);
        return bool != null && bool.booleanValue();
    }

    public boolean isCompileDownloadUrls() {
        return hasOption(XmlOptionsKeys.COMPILE_DOWNLOAD_URLS);
    }

    public boolean isCompileNoAnnotations() {
        return hasOption(XmlOptionsKeys.COMPILE_NO_ANNOTATIONS);
    }

    public boolean isCompileNoPvrRule() {
        return hasOption(XmlOptionsKeys.COMPILE_NO_PVR_RULE);
    }

    public boolean isCompileNoUpaRule() {
        return hasOption(XmlOptionsKeys.COMPILE_NO_UPA_RULE);
    }

    public boolean isCompileNoValidation() {
        return hasOption(XmlOptionsKeys.COMPILE_NO_VALIDATION);
    }

    public boolean isCompilePartialTypesystem() {
        Boolean bool = (Boolean) get(XmlOptionsKeys.COMPILE_PARTIAL_TYPESYSTEM);
        return bool != null && bool.booleanValue();
    }

    public boolean isCopyUseNewSynchronizationDomain() {
        Boolean bool = (Boolean) get(XmlOptionsKeys.COPY_USE_NEW_SYNC_DOMAIN);
        return bool != null && bool.booleanValue();
    }

    public boolean isLoadDTDGrammar() {
        Boolean bool = (Boolean) get(XmlOptionsKeys.LOAD_DTD_GRAMMAR);
        return bool != null && bool.booleanValue();
    }

    public boolean isLoadExternalDTD() {
        Boolean bool = (Boolean) get(XmlOptionsKeys.LOAD_EXTERNAL_DTD);
        return bool != null && bool.booleanValue();
    }

    public boolean isLoadLineNumbers() {
        return hasOption(XmlOptionsKeys.LOAD_LINE_NUMBERS);
    }

    public boolean isLoadLineNumbersEndElement() {
        return hasOption(XmlOptionsKeys.LOAD_LINE_NUMBERS_END_ELEMENT);
    }

    public boolean isLoadMessageDigest() {
        return hasOption(XmlOptionsKeys.LOAD_MESSAGE_DIGEST);
    }

    public boolean isLoadStripComments() {
        return hasOption(XmlOptionsKeys.LOAD_STRIP_COMMENTS);
    }

    public boolean isLoadStripProcinsts() {
        return hasOption(XmlOptionsKeys.LOAD_STRIP_PROCINSTS);
    }

    public boolean isLoadTrimTextBuffer() {
        return hasOption(XmlOptionsKeys.LOAD_TRIM_TEXT_BUFFER);
    }

    public boolean isLoadUseDefaultResolver() {
        return hasOption(XmlOptionsKeys.LOAD_USE_DEFAULT_RESOLVER);
    }

    public boolean isLoadUseLocaleCharUtil() {
        Boolean bool = (Boolean) get(XmlOptionsKeys.LOAD_USE_LOCALE_CHAR_UTIL);
        return bool != null && bool.booleanValue();
    }

    public boolean isSaveAggressiveNamespaces() {
        return hasOption(XmlOptionsKeys.SAVE_AGGRESSIVE_NAMESPACES);
    }

    public boolean isSaveInner() {
        return hasOption(XmlOptionsKeys.SAVE_INNER);
    }

    public boolean isSaveNamespacesFirst() {
        return hasOption(XmlOptionsKeys.SAVE_NAMESPACES_FIRST);
    }

    public boolean isSaveNoXmlDecl() {
        return hasOption(XmlOptionsKeys.SAVE_NO_XML_DECL);
    }

    public boolean isSaveOptimizeForSpeed() {
        Boolean bool = (Boolean) get(XmlOptionsKeys.SAVE_OPTIMIZE_FOR_SPEED);
        return bool != null && bool.booleanValue();
    }

    public boolean isSaveOuter() {
        return hasOption(XmlOptionsKeys.SAVE_OUTER);
    }

    public boolean isSavePrettyPrint() {
        return hasOption(XmlOptionsKeys.SAVE_PRETTY_PRINT);
    }

    public boolean isSaveSaxNoNSDeclsInAttributes() {
        return hasOption(XmlOptionsKeys.SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES);
    }

    public boolean isSaveUseOpenFrag() {
        return hasOption(XmlOptionsKeys.SAVE_USE_OPEN_FRAGMENT);
    }

    public boolean isSetLoadStripWhitespace() {
        return hasOption(XmlOptionsKeys.LOAD_STRIP_WHITESPACE);
    }

    public boolean isUnsynchronized() {
        return hasOption(XmlOptionsKeys.UNSYNCHRONIZED);
    }

    public boolean isUseCDataBookmarks() {
        return hasOption(XmlOptionsKeys.LOAD_SAVE_CDATA_BOOKMARKS);
    }

    public boolean isUseDefaultNamespace() {
        return hasOption(XmlOptionsKeys.SAVE_USE_DEFAULT_NAMESPACE);
    }

    public boolean isValidateOnSet() {
        return hasOption(XmlOptionsKeys.VALIDATE_ON_SET);
    }

    public boolean isValidateStrict() {
        return hasOption(XmlOptionsKeys.VALIDATE_STRICT);
    }

    public boolean isValidateTextOnly() {
        return hasOption(XmlOptionsKeys.VALIDATE_TEXT_ONLY);
    }

    public boolean isValidateTreatLaxAsSkip() {
        return hasOption(XmlOptionsKeys.VALIDATE_TREAT_LAX_AS_SKIP);
    }

    public boolean isXPathUseSaxon() {
        Boolean bool = (Boolean) get(XmlOptionsKeys.XPATH_USE_SAXON);
        return bool != null && bool.booleanValue();
    }

    public boolean isXPathUseXmlBeans() {
        Boolean bool = (Boolean) get(XmlOptionsKeys.XPATH_USE_XMLBEANS);
        return bool != null && bool.booleanValue();
    }

    public void remove(XmlOptionsKeys xmlOptionsKeys) {
        this._map.remove(xmlOptionsKeys);
    }

    public XmlOptions setAttributeValidationCompatMode(boolean z6) {
        return set(XmlOptionsKeys.ATTRIBUTE_VALIDATION_COMPAT_MODE, z6);
    }

    public XmlOptions setBaseURI(URI uri) {
        return set(XmlOptionsKeys.BASE_URI, uri);
    }

    public XmlOptions setCharacterEncoding(String str) {
        return set(XmlOptionsKeys.CHARACTER_ENCODING, str);
    }

    public XmlOptions setCompileAnnotationAsJavadoc() {
        return setCompileAnnotationAsJavadoc(true);
    }

    public XmlOptions setCompileDownloadUrls() {
        return setCompileDownloadUrls(true);
    }

    public XmlOptions setCompileMdefNamespaces(Set<String> set) {
        return set(XmlOptionsKeys.COMPILE_MDEF_NAMESPACES, set);
    }

    public XmlOptions setCompileNoAnnotations() {
        return setCompileNoAnnotations(true);
    }

    public XmlOptions setCompileNoPvrRule() {
        return setCompileNoPvrRule(true);
    }

    public XmlOptions setCompileNoUpaRule() {
        return setCompileNoUpaRule(true);
    }

    public XmlOptions setCompileNoValidation() {
        return set(XmlOptionsKeys.COMPILE_NO_VALIDATION);
    }

    public void setCompilePartialMethod(Set<BeanMethod> set) {
        if (set == null || set.isEmpty()) {
            remove(XmlOptionsKeys.COMPILE_PARTIAL_METHODS);
        } else {
            set(XmlOptionsKeys.COMPILE_PARTIAL_METHODS, set);
        }
    }

    public XmlOptions setCompilePartialTypesystem() {
        return setCompilePartialTypesystem(true);
    }

    public XmlOptions setCompileSubstituteNames(Map<QName, QName> map) {
        return set(XmlOptionsKeys.COMPILE_SUBSTITUTE_NAMES, map);
    }

    public XmlOptions setCopyUseNewSynchronizationDomain(boolean z6) {
        return set(XmlOptionsKeys.COPY_USE_NEW_SYNC_DOMAIN, z6);
    }

    public XmlOptions setDisallowDocTypeDeclaration(boolean z6) {
        return set(XmlOptionsKeys.DISALLOW_DOCTYPE_DECLARATION, z6);
    }

    public XmlOptions setDocumentSourceName(String str) {
        return set(XmlOptionsKeys.DOCUMENT_SOURCE_NAME, str);
    }

    public XmlOptions setDocumentType(SchemaType schemaType) {
        return set(XmlOptionsKeys.DOCUMENT_TYPE, schemaType);
    }

    public XmlOptions setEntityExpansionLimit(int i5) {
        return set(XmlOptionsKeys.ENTITY_EXPANSION_LIMIT, i5);
    }

    public XmlOptions setEntityResolver(EntityResolver entityResolver) {
        return set(XmlOptionsKeys.ENTITY_RESOLVER, entityResolver);
    }

    public XmlOptions setErrorListener(Collection<XmlError> collection) {
        return set(XmlOptionsKeys.ERROR_LISTENER, collection);
    }

    public XmlOptions setLoadAdditionalNamespaces(Map<String, String> map) {
        return set(XmlOptionsKeys.LOAD_ADDITIONAL_NAMESPACES, map);
    }

    public XmlOptions setLoadDTDGrammar(boolean z6) {
        return set(XmlOptionsKeys.LOAD_DTD_GRAMMAR, z6);
    }

    public XmlOptions setLoadEntityBytesLimit(int i5) {
        return set(XmlOptionsKeys.LOAD_ENTITY_BYTES_LIMIT, i5);
    }

    public XmlOptions setLoadExternalDTD(boolean z6) {
        return set(XmlOptionsKeys.LOAD_EXTERNAL_DTD, z6);
    }

    public XmlOptions setLoadLineNumbers() {
        return setLoadLineNumbers(true);
    }

    public XmlOptions setLoadLineNumbersEndElement() {
        return setLoadLineNumbersEndElement(true);
    }

    public XmlOptions setLoadMessageDigest() {
        return setLoadMessageDigest(true);
    }

    public XmlOptions setLoadReplaceDocumentElement(QName qName) {
        return set(XmlOptionsKeys.LOAD_REPLACE_DOCUMENT_ELEMENT, qName);
    }

    public XmlOptions setLoadStripComments() {
        return setLoadStripComments(true);
    }

    public XmlOptions setLoadStripProcinsts() {
        return setLoadStripProcinsts(true);
    }

    public XmlOptions setLoadStripWhitespace() {
        return setLoadStripWhitespace(true);
    }

    public XmlOptions setLoadSubstituteNamespaces(Map<String, String> map) {
        return set(XmlOptionsKeys.LOAD_SUBSTITUTE_NAMESPACES, map);
    }

    public XmlOptions setLoadTrimTextBuffer() {
        return setLoadTrimTextBuffer(true);
    }

    public XmlOptions setLoadUseDefaultResolver() {
        return setLoadUseDefaultResolver(true);
    }

    public XmlOptions setLoadUseLocaleCharUtil(boolean z6) {
        return set(XmlOptionsKeys.LOAD_USE_LOCALE_CHAR_UTIL, z6);
    }

    public XmlOptions setLoadUseXMLReader(XMLReader xMLReader) {
        return set(XmlOptionsKeys.LOAD_USE_XMLREADER, xMLReader);
    }

    public XmlOptions setSaaj(Saaj saaj) {
        return set(XmlOptionsKeys.SAAJ_IMPL, saaj);
    }

    public XmlOptions setSaveAggressiveNamespaces() {
        return setSaveAggressiveNamespaces(true);
    }

    public XmlOptions setSaveCDataEntityCountThreshold(int i5) {
        return set(XmlOptionsKeys.SAVE_CDATA_ENTITY_COUNT_THRESHOLD, i5);
    }

    public XmlOptions setSaveCDataLengthThreshold(int i5) {
        return set(XmlOptionsKeys.SAVE_CDATA_LENGTH_THRESHOLD, i5);
    }

    public XmlOptions setSaveFilterProcinst(String str) {
        return set(XmlOptionsKeys.SAVE_FILTER_PROCINST, str);
    }

    public XmlOptions setSaveImplicitNamespaces(Map<String, String> map) {
        return set(XmlOptionsKeys.SAVE_IMPLICIT_NAMESPACES, map);
    }

    public XmlOptions setSaveInner() {
        return setSaveInner(true);
    }

    public XmlOptions setSaveNamespacesFirst() {
        return setSaveNamespacesFirst(true);
    }

    public XmlOptions setSaveNoXmlDecl() {
        return setSaveNoXmlDecl(true);
    }

    public XmlOptions setSaveOptimizeForSpeed(boolean z6) {
        return set(XmlOptionsKeys.SAVE_OPTIMIZE_FOR_SPEED, z6);
    }

    public XmlOptions setSaveOuter() {
        return setSaveOuter(true);
    }

    public XmlOptions setSavePrettyPrint() {
        return setSavePrettyPrint(true);
    }

    public XmlOptions setSavePrettyPrintIndent(int i5) {
        return set(XmlOptionsKeys.SAVE_PRETTY_PRINT_INDENT, i5);
    }

    public XmlOptions setSavePrettyPrintOffset(int i5) {
        return set(XmlOptionsKeys.SAVE_PRETTY_PRINT_OFFSET, i5);
    }

    public XmlOptions setSaveSaxNoNSDeclsInAttributes() {
        return setSaveSaxNoNSDeclsInAttributes(true);
    }

    public XmlOptions setSaveSubstituteCharacters(XmlOptionCharEscapeMap xmlOptionCharEscapeMap) {
        return set(XmlOptionsKeys.SAVE_SUBSTITUTE_CHARACTERS, xmlOptionCharEscapeMap);
    }

    public XmlOptions setSaveSuggestedPrefixes(Map<String, String> map) {
        return set(XmlOptionsKeys.SAVE_SUGGESTED_PREFIXES, map);
    }

    public XmlOptions setSaveSyntheticDocumentElement(QName qName) {
        return set(XmlOptionsKeys.SAVE_SYNTHETIC_DOCUMENT_ELEMENT, qName);
    }

    public XmlOptions setSaveUseOpenFrag() {
        return setSaveUseOpenFrag(true);
    }

    public XmlOptions setSchemaCodePrinter(SchemaCodePrinter schemaCodePrinter) {
        return set(XmlOptionsKeys.SCHEMA_CODE_PRINTER, schemaCodePrinter);
    }

    public XmlOptions setUnsynchronized() {
        return setUnsynchronized(true);
    }

    public XmlOptions setUseCDataBookmarks() {
        return set(XmlOptionsKeys.LOAD_SAVE_CDATA_BOOKMARKS);
    }

    public XmlOptions setUseDefaultNamespace() {
        return setUseDefaultNamespace(true);
    }

    public XmlOptions setUseSameLocale(Object obj) {
        return set(XmlOptionsKeys.USE_SAME_LOCALE, obj);
    }

    public XmlOptions setValidateOnSet() {
        return setValidateOnSet(true);
    }

    public XmlOptions setValidateStrict() {
        return setValidateStrict(true);
    }

    public XmlOptions setValidateTextOnly() {
        return setValidateTextOnly(true);
    }

    public XmlOptions setValidateTreatLaxAsSkip() {
        return setValidateTreatLaxAsSkip(true);
    }

    public XmlOptions setXPathUseSaxon() {
        return setXPathUseSaxon(true);
    }

    public XmlOptions setXPathUseXmlBeans() {
        return setXPathUseSaxon(true);
    }

    public XmlOptions setXqueryCurrentNodeVar(String str) {
        return set(XmlOptionsKeys.XQUERY_CURRENT_NODE_VAR, str);
    }

    public XmlOptions setXqueryVariables(Map<String, Object> map) {
        return set(XmlOptionsKeys.XQUERY_VARIABLE_MAP, map);
    }

    private XmlOptions set(XmlOptionsKeys xmlOptionsKeys, Object obj) {
        this._map.put(xmlOptionsKeys, obj);
        return this;
    }

    public XmlOptions setCompileAnnotationAsJavadoc(boolean z6) {
        return set(XmlOptionsKeys.COMPILE_ANNOTATION_JAVADOC, z6);
    }

    public XmlOptions setCompileDownloadUrls(boolean z6) {
        return set(XmlOptionsKeys.COMPILE_DOWNLOAD_URLS, z6);
    }

    public XmlOptions setCompileNoAnnotations(boolean z6) {
        return set(XmlOptionsKeys.COMPILE_NO_ANNOTATIONS, z6);
    }

    public XmlOptions setCompileNoPvrRule(boolean z6) {
        return set(XmlOptionsKeys.COMPILE_NO_PVR_RULE, z6);
    }

    public XmlOptions setCompileNoUpaRule(boolean z6) {
        return set(XmlOptionsKeys.COMPILE_NO_UPA_RULE, z6);
    }

    public XmlOptions setCompilePartialTypesystem(boolean z6) {
        return set(XmlOptionsKeys.COMPILE_PARTIAL_TYPESYSTEM, z6);
    }

    public XmlOptions setLoadLineNumbers(boolean z6) {
        return set(XmlOptionsKeys.LOAD_LINE_NUMBERS, z6);
    }

    public XmlOptions setLoadLineNumbersEndElement(boolean z6) {
        setLoadLineNumbers(true);
        return set(XmlOptionsKeys.LOAD_LINE_NUMBERS_END_ELEMENT, z6);
    }

    public XmlOptions setLoadMessageDigest(boolean z6) {
        return set(XmlOptionsKeys.LOAD_MESSAGE_DIGEST, z6);
    }

    public XmlOptions setLoadStripComments(boolean z6) {
        return set(XmlOptionsKeys.LOAD_STRIP_COMMENTS, z6);
    }

    public XmlOptions setLoadStripProcinsts(boolean z6) {
        return set(XmlOptionsKeys.LOAD_STRIP_PROCINSTS, z6);
    }

    public XmlOptions setLoadStripWhitespace(boolean z6) {
        return set(XmlOptionsKeys.LOAD_STRIP_WHITESPACE, z6);
    }

    public XmlOptions setLoadTrimTextBuffer(boolean z6) {
        return set(XmlOptionsKeys.LOAD_TRIM_TEXT_BUFFER, z6);
    }

    public XmlOptions setLoadUseDefaultResolver(boolean z6) {
        return set(XmlOptionsKeys.LOAD_USE_DEFAULT_RESOLVER, z6);
    }

    public XmlOptions setSaveAggressiveNamespaces(boolean z6) {
        return set(XmlOptionsKeys.SAVE_AGGRESSIVE_NAMESPACES, z6);
    }

    public XmlOptions setSaveInner(boolean z6) {
        return set(XmlOptionsKeys.SAVE_INNER, z6);
    }

    public XmlOptions setSaveNamespacesFirst(boolean z6) {
        return set(XmlOptionsKeys.SAVE_NAMESPACES_FIRST, z6);
    }

    public XmlOptions setSaveNoXmlDecl(boolean z6) {
        return set(XmlOptionsKeys.SAVE_NO_XML_DECL, z6);
    }

    public XmlOptions setSaveOuter(boolean z6) {
        return set(XmlOptionsKeys.SAVE_OUTER, z6);
    }

    public XmlOptions setSavePrettyPrint(boolean z6) {
        return set(XmlOptionsKeys.SAVE_PRETTY_PRINT, z6);
    }

    public XmlOptions setSaveSaxNoNSDeclsInAttributes(boolean z6) {
        return set(XmlOptionsKeys.SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES, z6);
    }

    public XmlOptions setSaveUseOpenFrag(boolean z6) {
        return set(XmlOptionsKeys.SAVE_USE_OPEN_FRAGMENT, z6);
    }

    public XmlOptions setUnsynchronized(boolean z6) {
        return set(XmlOptionsKeys.UNSYNCHRONIZED, z6);
    }

    public XmlOptions setUseDefaultNamespace(boolean z6) {
        return set(XmlOptionsKeys.SAVE_USE_DEFAULT_NAMESPACE, z6);
    }

    public XmlOptions setValidateOnSet(boolean z6) {
        return set(XmlOptionsKeys.VALIDATE_ON_SET, z6);
    }

    public XmlOptions setValidateStrict(boolean z6) {
        return set(XmlOptionsKeys.VALIDATE_STRICT, z6);
    }

    public XmlOptions setValidateTextOnly(boolean z6) {
        return set(XmlOptionsKeys.VALIDATE_TEXT_ONLY, z6);
    }

    public XmlOptions setValidateTreatLaxAsSkip(boolean z6) {
        return set(XmlOptionsKeys.VALIDATE_TREAT_LAX_AS_SKIP, z6);
    }

    public XmlOptions setXPathUseSaxon(boolean z6) {
        return set(XmlOptionsKeys.XPATH_USE_SAXON, z6);
    }

    public XmlOptions setXPathUseXmlBeans(boolean z6) {
        return set(XmlOptionsKeys.XPATH_USE_XMLBEANS, z6);
    }

    public XmlOptions(XmlOptions xmlOptions) {
        HashMap map = new HashMap();
        this._map = map;
        if (xmlOptions != null) {
            map.putAll(xmlOptions._map);
        }
    }

    private XmlOptions set(XmlOptionsKeys xmlOptionsKeys, int i5) {
        return set(xmlOptionsKeys, Integer.valueOf(i5));
    }

    private XmlOptions set(XmlOptionsKeys xmlOptionsKeys, boolean z6) {
        if (z6) {
            set(xmlOptionsKeys, Boolean.TRUE);
            return this;
        }
        remove(xmlOptionsKeys);
        return this;
    }
}
