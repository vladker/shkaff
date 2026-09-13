package org.apache.xmlbeans.impl.tool;

import A3.AbstractC0157z;
import com.alibaba.android.arouter.utils.Consts;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.apache.xmlbeans.impl.util.HexBin;
import org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry;
import org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseSchemaResourceManager extends SchemaImportResolver {
    private static final String USER_AGENT = "XMLBeans/" + XmlBeans.getVersion() + " (" + XmlBeans.getTitle() + ")";
    private String _defaultCopyDirectory;
    private DownloadedSchemasDocument _importsDoc;
    private final Map<String, SchemaResource> _resourceForFilename = new HashMap();
    private final Map<String, SchemaResource> _resourceForURL = new HashMap();
    private final Map<String, SchemaResource> _resourceForNamespace = new HashMap();
    private final Map<String, SchemaResource> _resourceForDigest = new HashMap();
    private final Map<DownloadedSchemaEntry, SchemaResource> _resourceForCacheEntry = new HashMap();
    private Set<SchemaResource> _redownloadSet = new HashSet();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class SchemaResource implements SchemaImportResolver.SchemaResource {
        DownloadedSchemaEntry _cacheEntry;

        public SchemaResource(DownloadedSchemaEntry downloadedSchemaEntry) {
            this._cacheEntry = downloadedSchemaEntry;
        }

        public void addSchemaLocation(String str) {
            this._cacheEntry.addSchemaLocation(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SchemaResource) {
                return getFilename().equals(((SchemaResource) obj).getFilename());
            }
            return false;
        }

        public String getFilename() {
            return this._cacheEntry.getFilename();
        }

        @Override // org.apache.xmlbeans.impl.tool.SchemaImportResolver.SchemaResource
        public String getNamespace() {
            return this._cacheEntry.getNamespace();
        }

        @Override // org.apache.xmlbeans.impl.tool.SchemaImportResolver.SchemaResource
        public SchemaDocument.Schema getSchema() {
            if (!BaseSchemaResourceManager.this.fileExists(getFilename())) {
                BaseSchemaResourceManager.this.redownloadResource(this);
            }
            try {
                return SchemaDocument.Factory.parse(BaseSchemaResourceManager.this.inputStreamForFile(getFilename())).getSchema();
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // org.apache.xmlbeans.impl.tool.SchemaImportResolver.SchemaResource
        public String getSchemaLocation() {
            if (this._cacheEntry.sizeOfSchemaLocationArray() > 0) {
                return this._cacheEntry.getSchemaLocationArray(0);
            }
            return null;
        }

        public String[] getSchemaLocationArray() {
            return this._cacheEntry.getSchemaLocationArray();
        }

        public String getSha1() {
            return this._cacheEntry.getSha1();
        }

        public int hashCode() {
            return getFilename().hashCode();
        }

        public void setFilename(String str) {
            this._cacheEntry.setFilename(str);
        }

        public void setNamespace(String str) {
            this._cacheEntry.setNamespace(str);
        }
    }

    private DownloadedSchemaEntry addNewEntry() {
        return this._importsDoc.getDownloadedSchemas().addNewEntry();
    }

    private SchemaResource copyOrIdentifyDuplicateURL(String str, String str2) {
        try {
            String strUniqueFilenameForURI = uniqueFilenameForURI(str);
            try {
                DigestInputStream digestInputStream = digestInputStream(new URL(str).openStream());
                writeInputStreamToFile(digestInputStream, strUniqueFilenameForURI);
                String strBytesToString = HexBin.bytesToString(digestInputStream.getMessageDigest().digest());
                SchemaResource schemaResource = this._resourceForDigest.get(strBytesToString);
                if (schemaResource != null) {
                    deleteFile(strUniqueFilenameForURI);
                    schemaResource.addSchemaLocation(str);
                    if (!this._resourceForURL.containsKey(str)) {
                        this._resourceForURL.put(str, schemaResource);
                    }
                    return schemaResource;
                }
                warning("Downloaded " + str + " to " + strUniqueFilenameForURI);
                DownloadedSchemaEntry downloadedSchemaEntryAddNewEntry = addNewEntry();
                downloadedSchemaEntryAddNewEntry.setFilename(strUniqueFilenameForURI);
                downloadedSchemaEntryAddNewEntry.setSha1(strBytesToString);
                if (str2 != null) {
                    downloadedSchemaEntryAddNewEntry.setNamespace(str2);
                }
                downloadedSchemaEntryAddNewEntry.addSchemaLocation(str);
                return updateResource(downloadedSchemaEntryAddNewEntry);
            } catch (Exception e) {
                StringBuilder sbY = AbstractC0157z.y("Could not copy remote resource ", str, ParameterizedMessage.ERROR_MSG_SEPARATOR);
                sbY.append(e.getMessage());
                warning(sbY.toString());
                return null;
            }
        } catch (IOException e6) {
            StringBuilder sbY2 = AbstractC0157z.y("Could not create local file for ", str, ParameterizedMessage.ERROR_MSG_SEPARATOR);
            sbY2.append(e6.getMessage());
            warning(sbY2.toString());
            return null;
        } catch (URISyntaxException e7) {
            StringBuilder sbY3 = AbstractC0157z.y("Invalid URI '", str, "':");
            sbY3.append(e7.getMessage());
            warning(sbY3.toString());
            return null;
        }
    }

    private void deleteResourcesInSet(Set<SchemaResource> set, boolean z6) {
        HashSet hashSet = new HashSet();
        Iterator<SchemaResource> it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next()._cacheEntry);
        }
        DownloadedSchemasDocument.DownloadedSchemas downloadedSchemas = this._importsDoc.getDownloadedSchemas();
        int i5 = 0;
        while (i5 < downloadedSchemas.sizeOfEntryArray()) {
            DownloadedSchemaEntry entryArray = downloadedSchemas.getEntryArray(i5);
            if (hashSet.contains(entryArray) == z6) {
                SchemaResource schemaResource = this._resourceForCacheEntry.get(entryArray);
                if (schemaResource != null) {
                    warning("Removing obsolete cache entry for " + schemaResource.getFilename());
                    this._resourceForCacheEntry.remove(entryArray);
                    if (schemaResource == this._resourceForFilename.get(schemaResource.getFilename())) {
                        this._resourceForFilename.remove(schemaResource.getFilename());
                    }
                    if (schemaResource == this._resourceForDigest.get(schemaResource.getSha1())) {
                        this._resourceForDigest.remove(schemaResource.getSha1());
                    }
                    if (schemaResource == this._resourceForNamespace.get(schemaResource.getNamespace())) {
                        this._resourceForNamespace.remove(schemaResource.getNamespace());
                    }
                    for (String str : schemaResource.getSchemaLocationArray()) {
                        if (schemaResource == this._resourceForURL.get(str)) {
                            this._resourceForURL.remove(str);
                        }
                    }
                }
                downloadedSchemas.removeEntry(i5);
                i5--;
            }
            i5++;
        }
    }

    private static DigestInputStream digestInputStream(InputStream inputStream) {
        try {
            return new DigestInputStream(inputStream, MessageDigest.getInstance("SHA"));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private SchemaResource fetchFromCache(String str, String str2) {
        SchemaResource schemaResource;
        SchemaResource schemaResource2;
        if (str2 != null && (schemaResource2 = this._resourceForURL.get(str2)) != null) {
            return schemaResource2;
        }
        if (str == null || (schemaResource = this._resourceForNamespace.get(str)) == null) {
            return null;
        }
        return schemaResource;
    }

    private void redownloadEntries(SchemaResource[] schemaResourceArr) {
        for (SchemaResource schemaResource : schemaResourceArr) {
            redownloadResource(schemaResource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void redownloadResource(SchemaResource schemaResource) {
        Set<SchemaResource> set = this._redownloadSet;
        if (set != null) {
            if (set.contains(schemaResource)) {
                return;
            } else {
                this._redownloadSet.add(schemaResource);
            }
        }
        String filename = schemaResource.getFilename();
        String schemaLocation = schemaResource.getSchemaLocation();
        if (schemaLocation == null || filename == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            URLConnection uRLConnectionOpenConnection = new URL(schemaLocation).openConnection();
            uRLConnectionOpenConnection.addRequestProperty(HttpHeaders.USER_AGENT, USER_AGENT);
            uRLConnectionOpenConnection.addRequestProperty(HttpHeaders.ACCEPT, "application/xml, text/xml, */*");
            DigestInputStream digestInputStream = digestInputStream(uRLConnectionOpenConnection.getInputStream());
            IOUtil.copyCompletely(digestInputStream, byteArrayOutputStream);
            if (HexBin.bytesToString(digestInputStream.getMessageDigest().digest()).equals(schemaResource.getSha1()) && fileExists(filename)) {
                warning(androidx.collection.a.p("Resource ", filename, " is unchanged from ", schemaLocation, Consts.DOT));
                return;
            }
            try {
                writeInputStreamToFile(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), filename);
                warning("Refreshed " + filename + " from " + schemaLocation);
            } catch (IOException e) {
                StringBuilder sbU = androidx.collection.a.u("Could not write to file ", filename, " for ", schemaLocation, ParameterizedMessage.ERROR_MSG_SEPARATOR);
                sbU.append(e.getMessage());
                warning(sbU.toString());
            }
        } catch (Exception e6) {
            StringBuilder sbY = AbstractC0157z.y("Could not copy remote resource ", schemaLocation, ParameterizedMessage.ERROR_MSG_SEPARATOR);
            sbY.append(e6.getMessage());
            warning(sbY.toString());
        }
    }

    private String shaDigestForFile(String str) throws IOException {
        DigestInputStream digestInputStream = digestInputStream(inputStreamForFile(str));
        byte[] bArr = new byte[4096];
        for (int i5 = 1; i5 > 0; i5 = digestInputStream.read(bArr)) {
        }
        digestInputStream.close();
        return HexBin.bytesToString(digestInputStream.getMessageDigest().digest());
    }

    private String uniqueFilenameForURI(String str) throws IOException {
        String rawPath = new URI(str).getRawPath();
        int iLastIndexOf = rawPath.lastIndexOf(47);
        int i5 = 1;
        if (iLastIndexOf >= 0) {
            rawPath = rawPath.substring(iLastIndexOf + 1);
        }
        if (rawPath.endsWith(".xsd")) {
            rawPath = androidx.collection.a.g(4, 0, rawPath);
        }
        if (rawPath.length() == 0) {
            rawPath = "schema";
        }
        String str2 = rawPath;
        while (i5 < 1000) {
            String strS = androidx.exifinterface.media.a.s(new StringBuilder(), this._defaultCopyDirectory, PackagingURIHelper.FORWARD_SLASH_STRING, str2, ".xsd");
            if (!fileExists(strS)) {
                return strS;
            }
            i5++;
            str2 = rawPath + i5;
        }
        throw new IOException(AbstractC0157z.o("Problem with filename ", rawPath, ".xsd"));
    }

    private SchemaResource updateResource(DownloadedSchemaEntry downloadedSchemaEntry) {
        String filename = downloadedSchemaEntry.getFilename();
        if (filename == null) {
            return null;
        }
        SchemaResource schemaResource = new SchemaResource(downloadedSchemaEntry);
        this._resourceForCacheEntry.put(downloadedSchemaEntry, schemaResource);
        if (!this._resourceForFilename.containsKey(filename)) {
            this._resourceForFilename.put(filename, schemaResource);
        }
        String sha1 = schemaResource.getSha1();
        if (sha1 != null && !this._resourceForDigest.containsKey(sha1)) {
            this._resourceForDigest.put(sha1, schemaResource);
        }
        String namespace = schemaResource.getNamespace();
        if (namespace != null && !this._resourceForNamespace.containsKey(namespace)) {
            this._resourceForNamespace.put(namespace, schemaResource);
        }
        for (String str : schemaResource.getSchemaLocationArray()) {
            if (!this._resourceForURL.containsKey(str)) {
                this._resourceForURL.put(str, schemaResource);
            }
        }
        return schemaResource;
    }

    public abstract void deleteFile(String str);

    public abstract boolean fileExists(String str);

    public abstract String[] getAllXSDFilenames();

    public String getDefaultSchemaDir() {
        return "./schema";
    }

    public String getIndexFilename() {
        return "./xsdownload.xml";
    }

    public final void init() {
        if (fileExists(getIndexFilename())) {
            try {
                this._importsDoc = DownloadedSchemasDocument.Factory.parse(inputStreamForFile(getIndexFilename()));
            } catch (IOException unused) {
                this._importsDoc = null;
            } catch (Exception e) {
                throw new IllegalStateException("Problem reading xsdownload.xml: please fix or delete this file", e);
            }
        }
        if (this._importsDoc == null) {
            try {
                this._importsDoc = DownloadedSchemasDocument.Factory.parse("<dls:downloaded-schemas xmlns:dls='http://www.bea.com/2003/01/xmlbean/xsdownload' defaultDirectory='" + getDefaultSchemaDir() + "'/>");
            } catch (Exception e6) {
                throw new IllegalStateException(e6);
            }
        }
        String defaultDirectory = this._importsDoc.getDownloadedSchemas().getDefaultDirectory();
        if (defaultDirectory == null) {
            defaultDirectory = getDefaultSchemaDir();
        }
        this._defaultCopyDirectory = defaultDirectory;
        for (DownloadedSchemaEntry downloadedSchemaEntry : this._importsDoc.getDownloadedSchemas().getEntryArray()) {
            updateResource(downloadedSchemaEntry);
        }
    }

    public abstract InputStream inputStreamForFile(String str);

    @Override // org.apache.xmlbeans.impl.tool.SchemaImportResolver
    public SchemaImportResolver.SchemaResource lookupResource(String str, String str2) {
        SchemaResource schemaResourceFetchFromCache = fetchFromCache(str, str2);
        if (schemaResourceFetchFromCache != null) {
            if (this._redownloadSet != null) {
                redownloadResource(schemaResourceFetchFromCache);
            }
            return schemaResourceFetchFromCache;
        }
        if (str2 == null) {
            warning("No cached schema for namespace '" + str + "', and no url specified");
            return null;
        }
        SchemaResource schemaResourceCopyOrIdentifyDuplicateURL = copyOrIdentifyDuplicateURL(str2, str);
        Set<SchemaResource> set = this._redownloadSet;
        if (set != null) {
            set.add(schemaResourceCopyOrIdentifyDuplicateURL);
        }
        return schemaResourceCopyOrIdentifyDuplicateURL;
    }

    public final void process(String[] strArr, String[] strArr2, boolean z6, boolean z7, boolean z8) {
        this._redownloadSet = z7 ? new HashSet() : null;
        if (strArr2.length > 0) {
            syncCacheWithLocalXsdFiles(strArr2, true);
        } else if (z6) {
            syncCacheWithLocalXsdFiles(getAllXSDFilenames(), false);
        }
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            SchemaResource schemaResource = (SchemaResource) lookupResource(null, str);
            if (schemaResource != null) {
                hashSet.add(schemaResource);
            }
        }
        for (String str2 : strArr2) {
            SchemaResource schemaResource2 = this._resourceForFilename.get(str2);
            if (schemaResource2 != null) {
                hashSet.add(schemaResource2);
            }
        }
        SchemaResource[] schemaResourceArr = (SchemaResource[]) hashSet.toArray(new SchemaResource[0]);
        if (z7) {
            redownloadEntries(schemaResourceArr);
        }
        if (z8) {
            resolveImports(schemaResourceArr);
        }
        this._redownloadSet = null;
    }

    public final void processAll(boolean z6, boolean z7, boolean z8) {
        this._redownloadSet = z7 ? new HashSet() : null;
        String[] allXSDFilenames = getAllXSDFilenames();
        if (z6) {
            syncCacheWithLocalXsdFiles(allXSDFilenames, false);
        }
        SchemaResource[] schemaResourceArr = (SchemaResource[]) this._resourceForFilename.values().toArray(new SchemaResource[0]);
        if (z7) {
            redownloadEntries(schemaResourceArr);
        }
        if (z8) {
            resolveImports(schemaResourceArr);
        }
        this._redownloadSet = null;
    }

    @Override // org.apache.xmlbeans.impl.tool.SchemaImportResolver
    public void reportActualNamespace(SchemaImportResolver.SchemaResource schemaResource, String str) {
        SchemaResource schemaResource2 = (SchemaResource) schemaResource;
        String namespace = schemaResource2.getNamespace();
        if (namespace != null && this._resourceForNamespace.get(namespace) == schemaResource2) {
            this._resourceForNamespace.remove(namespace);
        }
        if (!this._resourceForNamespace.containsKey(str)) {
            this._resourceForNamespace.put(str, schemaResource2);
        }
        schemaResource2.setNamespace(str);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0081 A[PHI: r6
  0x0081: PHI (r6v4 java.lang.String) = (r6v3 java.lang.String), (r6v5 java.lang.String), (r6v5 java.lang.String), (r6v5 java.lang.String) binds: [B:22:0x0080, B:32:0x0081, B:12:0x0037, B:14:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x009b  */
    /* JADX WARN: Instruction removed from duplicated block: B:23:0x0081, please report this as an issue */
    public final void syncCacheWithLocalXsdFiles(String[] strArr, boolean z6) {
        String strShaDigestForFile;
        DownloadedSchemaEntry downloadedSchemaEntryAddNewEntry;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (String str : strArr) {
            SchemaResource schemaResource = this._resourceForFilename.get(str);
            if (schemaResource == null) {
                try {
                    strShaDigestForFile = shaDigestForFile(str);
                    try {
                        SchemaResource schemaResource2 = this._resourceForDigest.get(strShaDigestForFile);
                        if (schemaResource2 != null) {
                            String filename = schemaResource2.getFilename();
                            if (fileExists(filename)) {
                                downloadedSchemaEntryAddNewEntry = addNewEntry();
                                downloadedSchemaEntryAddNewEntry.setFilename(str);
                                warning("Caching information on new local file " + str);
                                if (strShaDigestForFile != null) {
                                    downloadedSchemaEntryAddNewEntry.setSha1(strShaDigestForFile);
                                }
                                hashSet.add(updateResource(downloadedSchemaEntryAddNewEntry));
                            } else {
                                warning("File " + str + " is a rename of " + filename);
                                schemaResource2.setFilename(str);
                                hashSet.add(schemaResource2);
                                if (this._resourceForFilename.get(filename) == schemaResource2) {
                                    this._resourceForFilename.remove(filename);
                                }
                                if (this._resourceForFilename.containsKey(str)) {
                                    this._resourceForFilename.put(str, schemaResource2);
                                }
                            }
                        } else {
                            downloadedSchemaEntryAddNewEntry = addNewEntry();
                            downloadedSchemaEntryAddNewEntry.setFilename(str);
                            warning("Caching information on new local file " + str);
                            if (strShaDigestForFile != null) {
                                downloadedSchemaEntryAddNewEntry.setSha1(strShaDigestForFile);
                            }
                            hashSet.add(updateResource(downloadedSchemaEntryAddNewEntry));
                        }
                    } catch (IOException unused) {
                    }
                } catch (IOException unused2) {
                    strShaDigestForFile = null;
                }
            } else if (fileExists(str)) {
                hashSet.add(schemaResource);
            } else {
                hashSet2.add(schemaResource);
            }
        }
        if (z6) {
            deleteResourcesInSet(hashSet2, true);
        } else {
            deleteResourcesInSet(hashSet, false);
        }
    }

    public abstract void warning(String str);

    public final void writeCache() {
        writeInputStreamToFile(this._importsDoc.newInputStream(new XmlOptions().setSavePrettyPrint()), getIndexFilename());
    }

    public abstract void writeInputStreamToFile(InputStream inputStream, String str);
}
