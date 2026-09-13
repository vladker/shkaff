package org.apache.xmlbeans.impl.schema;

import A3.AbstractC0157z;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.io.IOUtils;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.apache.xmlbeans.impl.common.XmlEncodingSniffer;
import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class StscImporter {
    private static final String PROJECT_URL_PREFIX = "project://local";

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SchemaToProcess {
        private final String chameleonNamespace;
        private List<SchemaToProcess> includes;
        private Set<SchemaToProcess> indirectIncludedBy;
        private Set<SchemaToProcess> indirectIncludes;
        private List<RedefineDocument.Redefine> redefineObjects;
        private List<SchemaToProcess> redefines;
        private final SchemaDocument.Schema schema;

        public SchemaToProcess(SchemaDocument.Schema schema, String str) {
            this.schema = schema;
            this.chameleonNamespace = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addInclude(SchemaToProcess schemaToProcess) {
            if (this.includes == null) {
                this.includes = new ArrayList();
            }
            this.includes.add(schemaToProcess);
        }

        private void addIndirectIncludes(SchemaToProcess schemaToProcess) {
            if (this.indirectIncludes == null) {
                this.indirectIncludes = new HashSet();
            }
            this.indirectIncludes.add(schemaToProcess);
            if (schemaToProcess.indirectIncludedBy == null) {
                schemaToProcess.indirectIncludedBy = new HashSet();
            }
            schemaToProcess.indirectIncludedBy.add(this);
            addIndirectIncludesHelper(this, schemaToProcess);
            Set<SchemaToProcess> set = this.indirectIncludedBy;
            if (set != null) {
                for (SchemaToProcess schemaToProcess2 : set) {
                    schemaToProcess2.indirectIncludes.add(schemaToProcess);
                    schemaToProcess.indirectIncludedBy.add(schemaToProcess2);
                    addIndirectIncludesHelper(schemaToProcess2, schemaToProcess);
                }
            }
        }

        private static void addIndirectIncludesHelper(SchemaToProcess schemaToProcess, SchemaToProcess schemaToProcess2) {
            Set<SchemaToProcess> set = schemaToProcess2.indirectIncludes;
            if (set != null) {
                for (SchemaToProcess schemaToProcess3 : set) {
                    schemaToProcess.indirectIncludes.add(schemaToProcess3);
                    schemaToProcess3.indirectIncludedBy.add(schemaToProcess);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addRedefine(SchemaToProcess schemaToProcess, RedefineDocument.Redefine redefine) {
            if (this.redefines == null || this.redefineObjects == null) {
                this.redefines = new ArrayList();
                this.redefineObjects = new ArrayList();
            }
            this.redefines.add(schemaToProcess);
            this.redefineObjects.add(redefine);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void buildIndirectReferences() {
            List<SchemaToProcess> list = this.includes;
            if (list != null) {
                Iterator<SchemaToProcess> it = list.iterator();
                while (it.hasNext()) {
                    addIndirectIncludes(it.next());
                }
            }
            List<SchemaToProcess> list2 = this.redefines;
            if (list2 != null) {
                Iterator<SchemaToProcess> it2 = list2.iterator();
                while (it2.hasNext()) {
                    addIndirectIncludes(it2.next());
                }
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SchemaToProcess)) {
                return false;
            }
            SchemaToProcess schemaToProcess = (SchemaToProcess) obj;
            return Objects.equals(this.chameleonNamespace, schemaToProcess.chameleonNamespace) && this.schema == schemaToProcess.schema;
        }

        public String getChameleonNamespace() {
            return this.chameleonNamespace;
        }

        public List<RedefineDocument.Redefine> getRedefineObjects() {
            return this.redefineObjects;
        }

        public List<SchemaToProcess> getRedefines() {
            return this.redefines;
        }

        public SchemaDocument.Schema getSchema() {
            return this.schema;
        }

        public String getSourceName() {
            return this.schema.documentProperties().getSourceName();
        }

        public int hashCode() {
            int iHashCode = this.schema.hashCode() * 29;
            String str = this.chameleonNamespace;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public boolean indirectIncludes(SchemaToProcess schemaToProcess) {
            Set<SchemaToProcess> set = this.indirectIncludes;
            return set != null && set.contains(schemaToProcess);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String baseURLForDoc(XmlObject xmlObject) {
        String sourceName = xmlObject.documentProperties().getSourceName();
        if (sourceName == null) {
            return null;
        }
        if (sourceName.startsWith(PackagingURIHelper.FORWARD_SLASH_STRING)) {
            return PROJECT_URL_PREFIX + sourceName.replace(IOUtils.DIR_SEPARATOR_WINDOWS, '/');
        }
        int iIndexOf = sourceName.indexOf(58);
        if (iIndexOf > 1 && sourceName.substring(0, iIndexOf).matches("^\\w+$")) {
            return sourceName;
        }
        return "project://local/" + sourceName.replace(IOUtils.DIR_SEPARATOR_WINDOWS, '/');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static URI parseURI(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new URI(str);
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    public static URI resolve(URI uri, String str) {
        URI uri2 = new URI(str);
        URI uriResolve = uri.resolve(uri2);
        if (!uri2.equals(uriResolve) || uri2.isAbsolute() || (!uri.getScheme().equals(ArchiveStreamFactory.JAR) && !uri.getScheme().equals(ArchiveStreamFactory.ZIP))) {
            if (Constants.FILE.equals(uriResolve.getScheme()) && !str.equals(uriResolve.getPath()) && uri.getPath().startsWith("//") && !uriResolve.getPath().startsWith("//")) {
                try {
                    return new URI(Constants.FILE, null, "///".concat(uriResolve.getPath()), uriResolve.getQuery(), uriResolve.getFragment());
                } catch (URISyntaxException unused) {
                }
            }
            return uriResolve;
        }
        String string = uri.toString();
        String strConcat = string.substring(0, string.lastIndexOf(47)) + PackagingURIHelper.FORWARD_SLASH_STRING + uri2;
        int iLastIndexOf = strConcat.lastIndexOf("!/");
        if (iLastIndexOf > 0) {
            for (int iIndexOf = strConcat.indexOf("/..", iLastIndexOf); iIndexOf > 0; iIndexOf = strConcat.indexOf("/..", iLastIndexOf)) {
                int iLastIndexOf2 = strConcat.lastIndexOf(PackagingURIHelper.FORWARD_SLASH_STRING, iIndexOf - 1);
                if (iLastIndexOf2 >= iLastIndexOf) {
                    strConcat = strConcat.substring(0, iLastIndexOf2).concat(strConcat.substring(iIndexOf + 3));
                }
            }
        }
        return URI.create(strConcat);
    }

    public static SchemaToProcess[] resolveImportsAndIncludes(SchemaDocument.Schema[] schemaArr, boolean z6) {
        return new DownloadTable(schemaArr).resolveImportsAndIncludes(z6);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DownloadTable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Map<NsLocPair, SchemaDocument.Schema> schemaByNsLocPair = new HashMap();
        private final Map<DigestKey, SchemaDocument.Schema> schemaByDigestKey = new HashMap();
        private final LinkedList<SchemaToProcess> scanNeeded = new LinkedList<>();
        private final Set<SchemaDocument.Schema> emptyNamespaceSchemas = new HashSet();
        private final Map<SchemaToProcess, SchemaToProcess> scannedAlready = new HashMap();
        private final Set<String> failedDownloads = new HashSet();

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class DigestKey {
            byte[] _digest;
            int _hashCode;

            public DigestKey(byte[] bArr) {
                this._digest = bArr;
                for (int i5 = 0; i5 < 4 && i5 < bArr.length; i5++) {
                    int i6 = this._hashCode << 8;
                    this._hashCode = i6;
                    this._hashCode = i6 + bArr[i5];
                }
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof DigestKey) {
                    return Arrays.equals(this._digest, ((DigestKey) obj)._digest);
                }
                return false;
            }

            public int hashCode() {
                return this._hashCode;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class NsLocPair {
            private final String locationURL;
            private final String namespaceURI;

            public NsLocPair(String str, String str2) {
                this.namespaceURI = str;
                this.locationURL = str2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof NsLocPair)) {
                    return false;
                }
                NsLocPair nsLocPair = (NsLocPair) obj;
                if (Objects.equals(this.locationURL, nsLocPair.locationURL)) {
                    return Objects.equals(this.namespaceURI, nsLocPair.namespaceURI);
                }
                return false;
            }

            public String getLocationURL() {
                return this.locationURL;
            }

            public String getNamespaceURI() {
                return this.namespaceURI;
            }

            public int hashCode() {
                String str = this.namespaceURI;
                int iHashCode = (str != null ? str.hashCode() : 0) * 29;
                String str2 = this.locationURL;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }
        }

        public DownloadTable(SchemaDocument.Schema[] schemaArr) {
            for (SchemaDocument.Schema schema : schemaArr) {
                String targetNamespace = schema.getTargetNamespace();
                addSuccessfulDownload(new NsLocPair(targetNamespace, StscImporter.baseURLForDoc(schema)), schema);
                if (targetNamespace != null) {
                    addScanNeeded(new SchemaToProcess(schema, null));
                } else {
                    addEmptyNamespaceSchema(schema);
                }
            }
        }

        private void addEmptyNamespaceSchema(SchemaDocument.Schema schema) {
            this.emptyNamespaceSchemas.add(schema);
        }

        private void addFailedDownload(String str) {
            this.failedDownloads.add(str);
        }

        private SchemaToProcess addScanNeeded(SchemaToProcess schemaToProcess) {
            if (this.scannedAlready.containsKey(schemaToProcess)) {
                return this.scannedAlready.get(schemaToProcess);
            }
            this.scannedAlready.put(schemaToProcess, schemaToProcess);
            this.scanNeeded.add(schemaToProcess);
            return schemaToProcess;
        }

        private void addSuccessfulDownload(NsLocPair nsLocPair, SchemaDocument.Schema schema) {
            byte[] messageDigest = schema.documentProperties().getMessageDigest();
            if (messageDigest == null) {
                StscState.get().addSchemaDigest(null);
            } else {
                if (!this.schemaByDigestKey.containsKey(new DigestKey(messageDigest))) {
                    this.schemaByDigestKey.put(new DigestKey(messageDigest), schema);
                    StscState.get().addSchemaDigest(messageDigest);
                }
            }
            this.schemaByNsLocPair.put(nsLocPair, schema);
            NsLocPair nsLocPair2 = new NsLocPair(nsLocPair.getNamespaceURI(), null);
            if (!this.schemaByNsLocPair.containsKey(nsLocPair2)) {
                this.schemaByNsLocPair.put(nsLocPair2, schema);
            }
            NsLocPair nsLocPair3 = new NsLocPair(null, nsLocPair.getLocationURL());
            if (this.schemaByNsLocPair.containsKey(nsLocPair3)) {
                return;
            }
            this.schemaByNsLocPair.put(nsLocPair3, schema);
        }

        private static ByteArrayInputStream copy(InputStream inputStream) throws IOException {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                try {
                    int i5 = inputStream.read(bArr, 0, 1024);
                    if (i5 <= 0) {
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        byteArrayOutputStream.close();
                        return byteArrayInputStream;
                    }
                    byteArrayOutputStream.write(bArr, 0, i5);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            }
        }

        private static Reader copySchemaSource(String str, Reader reader, StscState stscState) {
            if (stscState.getSchemasDir() != null) {
                File file = new File(stscState.getSchemasDir(), stscState.sourceNameForUri(str));
                if (!file.exists()) {
                    try {
                        IOUtil.createDir(new File(file.getParent()), null);
                        CharArrayReader charArrayReaderCopy = copy(reader);
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), new XmlEncodingSniffer(charArrayReaderCopy, null).getXmlEncoding());
                        try {
                            IOUtil.copyCompletely(charArrayReaderCopy, outputStreamWriter);
                            outputStreamWriter.close();
                            charArrayReaderCopy.reset();
                            return charArrayReaderCopy;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                try {
                                    outputStreamWriter.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                                throw th2;
                            }
                        }
                    } catch (IOException e) {
                        System.err.println("IO Error " + e);
                        return reader;
                    }
                }
            }
            return reader;
        }

        public static XmlObject downloadDocument(SchemaTypeLoader schemaTypeLoader, String str, String str2) {
            StscState stscState = StscState.get();
            EntityResolver entityResolver = stscState.getEntityResolver();
            if (entityResolver != null) {
                try {
                    InputSource inputSourceResolveEntity = entityResolver.resolveEntity(str, str2);
                    if (inputSourceResolveEntity != null) {
                        stscState.addSourceUri(str2, null);
                        Reader characterStream = inputSourceResolveEntity.getCharacterStream();
                        if (characterStream != null) {
                            Reader readerCopySchemaSource = copySchemaSource(str2, characterStream, stscState);
                            XmlOptions xmlOptions = new XmlOptions();
                            xmlOptions.setLoadLineNumbers();
                            xmlOptions.setDocumentSourceName(str2);
                            return schemaTypeLoader.parse(readerCopySchemaSource, (SchemaType) null, xmlOptions);
                        }
                        InputStream byteStream = inputSourceResolveEntity.getByteStream();
                        if (byteStream != null) {
                            InputStream inputStreamCopySchemaSource = copySchemaSource(str2, byteStream, stscState);
                            String encoding = inputSourceResolveEntity.getEncoding();
                            XmlOptions xmlOptions2 = new XmlOptions();
                            xmlOptions2.setLoadLineNumbers();
                            xmlOptions2.setLoadMessageDigest();
                            xmlOptions2.setDocumentSourceName(str2);
                            if (encoding != null) {
                                xmlOptions2.setCharacterEncoding(encoding);
                            }
                            return schemaTypeLoader.parse(inputStreamCopySchemaSource, (SchemaType) null, xmlOptions2);
                        }
                        String systemId = inputSourceResolveEntity.getSystemId();
                        if (systemId == null) {
                            throw new IOException(androidx.collection.a.p("EntityResolver unable to resolve ", str2, " (for namespace ", str, ")"));
                        }
                        copySchemaSource(str2, stscState, false);
                        XmlOptions xmlOptions3 = new XmlOptions();
                        xmlOptions3.setLoadLineNumbers();
                        xmlOptions3.setLoadMessageDigest();
                        xmlOptions3.setDocumentSourceName(str2);
                        return schemaTypeLoader.parse(new URL(systemId), (SchemaType) null, xmlOptions3);
                    }
                } catch (SAXException e) {
                    throw new XmlException(e);
                }
            }
            stscState.addSourceUri(str2, null);
            copySchemaSource(str2, stscState, false);
            XmlOptions xmlOptions4 = new XmlOptions();
            xmlOptions4.setLoadLineNumbers();
            xmlOptions4.setLoadMessageDigest();
            return schemaTypeLoader.parse(new URL(str2), (SchemaType) null, xmlOptions4);
        }

        private SchemaDocument.Schema downloadSchema(XmlObject xmlObject, String str, String str2) {
            SchemaDocument.Schema schema;
            SchemaDocument.Schema schema2;
            if (str2 == null) {
                return null;
            }
            StscState stscState = StscState.get();
            URI uri = StscImporter.parseURI(StscImporter.baseURLForDoc(xmlObject));
            if (uri != null) {
                try {
                    str2 = StscImporter.resolve(uri, str2).toString();
                } catch (URISyntaxException e) {
                    stscState.error("Could not find resource - invalid location URL: " + e.getMessage(), 56, xmlObject);
                    return null;
                }
            }
            if (stscState.isFileProcessed(str2)) {
                return null;
            }
            if (str != null && (schema2 = this.schemaByNsLocPair.get(new NsLocPair(str, str2))) != null) {
                return schema2;
            }
            if (str != null && !str.equals("")) {
                if (!stscState.shouldDownloadURI(str2) && (schema = this.schemaByNsLocPair.get(new NsLocPair(str, null))) != null) {
                    return schema;
                }
                if (stscState.linkerDefinesNamespace(str)) {
                    return null;
                }
            }
            SchemaDocument.Schema schema3 = this.schemaByNsLocPair.get(new NsLocPair(null, str2));
            if (schema3 != null) {
                return schema3;
            }
            if (previouslyFailedToDownload(str2)) {
                return null;
            }
            if (!stscState.shouldDownloadURI(str2)) {
                stscState.error(AbstractC0157z.o("Could not load resource \"", str2, "\" (network downloads disabled)."), 56, xmlObject);
                addFailedDownload(str2);
                return null;
            }
            try {
                XmlObject xmlObjectDownloadDocument = downloadDocument(stscState.getS4SLoader(), str, str2);
                SchemaDocument.Schema schemaFindMatchByDigest = findMatchByDigest(xmlObjectDownloadDocument);
                String strRelativize = stscState.relativize(str2);
                if (schemaFindMatchByDigest == null) {
                    XmlOptions xmlOptions = new XmlOptions();
                    xmlOptions.setErrorListener(stscState.getErrorListener());
                    if ((xmlObjectDownloadDocument instanceof SchemaDocument) && xmlObjectDownloadDocument.validate(xmlOptions)) {
                        schemaFindMatchByDigest = ((SchemaDocument) xmlObjectDownloadDocument).getSchema();
                        stscState.info("Loading referenced file " + strRelativize);
                    }
                    stscState.error("Referenced document is not a valid schema", 56, xmlObject);
                    addFailedDownload(str2);
                    return null;
                }
                String strRelativize2 = stscState.relativize(schemaFindMatchByDigest.documentProperties().getSourceName());
                if (strRelativize2 != null) {
                    stscState.info(strRelativize + " is the same as " + strRelativize2 + " (ignoring the duplicate file)");
                } else {
                    stscState.info(strRelativize + " is the same as another schema");
                }
                addSuccessfulDownload(new NsLocPair(emptyStringIfNull(schemaFindMatchByDigest.getTargetNamespace()), str2), schemaFindMatchByDigest);
                return schemaFindMatchByDigest;
            } catch (MalformedURLException unused) {
                stscState.error(AbstractC0157z.o("URL \"", str2, "\" is not well-formed"), 56, xmlObject);
            } catch (IOException e6) {
                stscState.error(e6.toString(), 56, xmlObject);
            } catch (XmlException e7) {
                stscState.error("Problem parsing referenced XML resource - " + e7.getMessage(), 56, xmlObject);
            }
        }

        private static String emptyStringIfNull(String str) {
            return str == null ? "" : str;
        }

        private boolean fetchRemainingEmptyNamespaceSchemas() {
            if (this.emptyNamespaceSchemas.isEmpty()) {
                return false;
            }
            Iterator<SchemaDocument.Schema> it = this.emptyNamespaceSchemas.iterator();
            while (it.hasNext()) {
                addScanNeeded(new SchemaToProcess(it.next(), null));
            }
            this.emptyNamespaceSchemas.clear();
            return true;
        }

        private SchemaDocument.Schema findMatchByDigest(XmlObject xmlObject) {
            byte[] messageDigest = xmlObject.documentProperties().getMessageDigest();
            if (messageDigest == null) {
                return null;
            }
            return this.schemaByDigestKey.get(new DigestKey(messageDigest));
        }

        private boolean hasNextToScan() {
            return !this.scanNeeded.isEmpty();
        }

        private SchemaToProcess nextToScan() {
            return this.scanNeeded.removeFirst();
        }

        private static boolean nullableStringsMatch(String str, String str2) {
            if (str == null && str2 == null) {
                return true;
            }
            if (str == null || str2 == null) {
                return false;
            }
            return str.equals(str2);
        }

        private boolean previouslyFailedToDownload(String str) {
            return this.failedDownloads.contains(str);
        }

        private void usedEmptyNamespaceSchema(SchemaDocument.Schema schema) {
            this.emptyNamespaceSchemas.remove(schema);
        }

        public SchemaToProcess[] resolveImportsAndIncludes(boolean z6) {
            StscState stscState;
            StscState stscState2 = StscState.get();
            ArrayList arrayList = new ArrayList();
            boolean z7 = false;
            while (true) {
                if (!hasNextToScan()) {
                    stscState = stscState2;
                    if (!fetchRemainingEmptyNamespaceSchemas()) {
                        break;
                    }
                } else {
                    SchemaToProcess schemaToProcessNextToScan = nextToScan();
                    String sourceName = schemaToProcessNextToScan.getSourceName();
                    stscState2.addSourceUri(sourceName, null);
                    arrayList.add(schemaToProcessNextToScan);
                    copySchemaSource(sourceName, stscState2, z6);
                    for (ImportDocument.Import r13 : schemaToProcessNextToScan.getSchema().getImportArray()) {
                        SchemaDocument.Schema schemaDownloadSchema = downloadSchema(r13, emptyStringIfNull(r13.getNamespace()), r13.getSchemaLocation());
                        if (schemaDownloadSchema != null) {
                            if (nullableStringsMatch(schemaDownloadSchema.getTargetNamespace(), r13.getNamespace())) {
                                addScanNeeded(new SchemaToProcess(schemaDownloadSchema, null));
                            } else {
                                StscState.get().error("Imported schema has a target namespace \"" + schemaDownloadSchema.getTargetNamespace() + "\" that does not match the specified \"" + r13.getNamespace() + "\"", 4, r13);
                            }
                        }
                    }
                    IncludeDocument.Include[] includeArray = schemaToProcessNextToScan.getSchema().getIncludeArray();
                    String chameleonNamespace = schemaToProcessNextToScan.getChameleonNamespace();
                    if (chameleonNamespace == null) {
                        chameleonNamespace = emptyStringIfNull(schemaToProcessNextToScan.getSchema().getTargetNamespace());
                    }
                    int length = includeArray.length;
                    int i5 = 0;
                    while (i5 < length) {
                        IncludeDocument.Include include = includeArray[i5];
                        SchemaDocument.Schema schemaDownloadSchema2 = downloadSchema(include, null, include.getSchemaLocation());
                        if (schemaDownloadSchema2 != null) {
                            if (emptyStringIfNull(schemaDownloadSchema2.getTargetNamespace()).equals(chameleonNamespace)) {
                                schemaToProcessNextToScan.addInclude(addScanNeeded(new SchemaToProcess(schemaDownloadSchema2, null)));
                            } else if (schemaDownloadSchema2.getTargetNamespace() != null) {
                                StscState.get().error("Included schema has a target namespace \"" + schemaDownloadSchema2.getTargetNamespace() + "\" that does not match the source namespace \"" + chameleonNamespace + "\"", 4, include);
                            } else {
                                schemaToProcessNextToScan.addInclude(addScanNeeded(new SchemaToProcess(schemaDownloadSchema2, chameleonNamespace)));
                                usedEmptyNamespaceSchema(schemaDownloadSchema2);
                            }
                        }
                        i5++;
                        stscState2 = stscState2;
                    }
                    stscState = stscState2;
                    RedefineDocument.Redefine[] redefineArray = schemaToProcessNextToScan.getSchema().getRedefineArray();
                    String chameleonNamespace2 = schemaToProcessNextToScan.getChameleonNamespace();
                    if (chameleonNamespace2 == null) {
                        chameleonNamespace2 = emptyStringIfNull(schemaToProcessNextToScan.getSchema().getTargetNamespace());
                    }
                    for (RedefineDocument.Redefine redefine : redefineArray) {
                        SchemaDocument.Schema schemaDownloadSchema3 = downloadSchema(redefine, null, redefine.getSchemaLocation());
                        if (schemaDownloadSchema3 != null) {
                            if (emptyStringIfNull(schemaDownloadSchema3.getTargetNamespace()).equals(chameleonNamespace2)) {
                                schemaToProcessNextToScan.addRedefine(addScanNeeded(new SchemaToProcess(schemaDownloadSchema3, null)), redefine);
                                z7 = true;
                            } else if (schemaDownloadSchema3.getTargetNamespace() != null) {
                                StscState.get().error("Redefined schema has a target namespace \"" + schemaDownloadSchema3.getTargetNamespace() + "\" that does not match the source namespace \"" + chameleonNamespace2 + "\"", 4, redefine);
                            } else {
                                schemaToProcessNextToScan.addRedefine(addScanNeeded(new SchemaToProcess(schemaDownloadSchema3, chameleonNamespace2)), redefine);
                                usedEmptyNamespaceSchema(schemaDownloadSchema3);
                                z7 = true;
                            }
                        }
                    }
                }
                stscState2 = stscState;
            }
            if (z7) {
                int size = arrayList.size();
                int i6 = 0;
                while (i6 < size) {
                    Object obj = arrayList.get(i6);
                    i6++;
                    ((SchemaToProcess) obj).buildIndirectReferences();
                }
            }
            return (SchemaToProcess[]) arrayList.toArray(new SchemaToProcess[0]);
        }

        private static CharArrayReader copy(Reader reader) {
            char[] cArr = new char[1024];
            CharArrayWriter charArrayWriter = new CharArrayWriter();
            while (true) {
                try {
                    int i5 = reader.read(cArr, 0, 1024);
                    if (i5 > 0) {
                        charArrayWriter.write(cArr, 0, i5);
                    } else {
                        CharArrayReader charArrayReader = new CharArrayReader(charArrayWriter.toCharArray());
                        charArrayWriter.close();
                        return charArrayReader;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            charArrayWriter.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            }
        }

        private static InputStream copySchemaSource(String str, InputStream inputStream, StscState stscState) {
            if (stscState.getSchemasDir() != null) {
                File file = new File(stscState.getSchemasDir(), stscState.sourceNameForUri(str));
                if (!file.exists()) {
                    try {
                        IOUtil.createDir(new File(file.getParent()), null);
                        ByteArrayInputStream byteArrayInputStreamCopy = copy(inputStream);
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            IOUtil.copyCompletely(byteArrayInputStreamCopy, fileOutputStream);
                            fileOutputStream.close();
                            byteArrayInputStreamCopy.reset();
                            return byteArrayInputStreamCopy;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                                throw th2;
                            }
                        }
                    } catch (IOException e) {
                        System.err.println("IO Error " + e);
                        return inputStream;
                    }
                }
            }
            return inputStream;
        }

        private static void copySchemaSource(String str, StscState stscState, boolean z6) {
            if (stscState.getSchemasDir() != null) {
                File file = new File(stscState.getSchemasDir(), stscState.sourceNameForUri(str));
                if (z6 || !file.exists()) {
                    InputStream inputStreamOpenStream = null;
                    try {
                        try {
                            IOUtil.createDir(new File(file.getParent()), null);
                            try {
                                inputStreamOpenStream = new URL(str).openStream();
                            } catch (FileNotFoundException e) {
                                if (z6 && file.exists()) {
                                    file.delete();
                                } else {
                                    throw e;
                                }
                            }
                            if (inputStreamOpenStream != null) {
                                IOUtil.copyCompletely(inputStreamOpenStream, new FileOutputStream(file));
                            }
                            if (inputStreamOpenStream == null) {
                                return;
                            }
                        } catch (IOException e6) {
                            System.err.println("IO Error " + e6);
                            if (0 == 0) {
                                return;
                            }
                        }
                        try {
                            inputStreamOpenStream.close();
                        } catch (Exception unused) {
                        }
                    } catch (Throwable th) {
                        if (0 != 0) {
                            try {
                                inputStreamOpenStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                }
            }
        }
    }
}
