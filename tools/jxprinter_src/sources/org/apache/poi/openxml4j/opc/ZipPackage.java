package org.apache.poi.openxml4j.opc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.SimpleMessage;
import org.apache.logging.log4j.util.Supplier;
import org.apache.poi.UnsupportedFileFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.openxml4j.exceptions.ODFNotOfficeXmlFileException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;
import org.apache.poi.openxml4j.opc.internal.ContentTypeManager;
import org.apache.poi.openxml4j.opc.internal.EncryptedTempFilePackagePart;
import org.apache.poi.openxml4j.opc.internal.FileHelper;
import org.apache.poi.openxml4j.opc.internal.MemoryPackagePart;
import org.apache.poi.openxml4j.opc.internal.PartMarshaller;
import org.apache.poi.openxml4j.opc.internal.TempFilePackagePart;
import org.apache.poi.openxml4j.opc.internal.ZipContentTypeManager;
import org.apache.poi.openxml4j.opc.internal.ZipHelper;
import org.apache.poi.openxml4j.opc.internal.marshallers.ZipPartMarshaller;
import org.apache.poi.openxml4j.util.ZipArchiveThresholdInputStream;
import org.apache.poi.openxml4j.util.ZipEntrySource;
import org.apache.poi.openxml4j.util.ZipFileZipEntrySource;
import org.apache.poi.openxml4j.util.ZipInputStreamZipEntrySource;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.TempFile;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ZipPackage extends OPCPackage {
    private static final Logger LOG = LogManager.getLogger((Class<?>) ZipPackage.class);
    private static final String MIMETYPE = "mimetype";
    private static final String SETTINGS_XML = "settings.xml";
    private static boolean encryptTempFilePackageParts = false;
    private static boolean useTempFilePackageParts = false;
    private final ZipEntrySource zipArchive;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class EntryTriple implements Comparable<EntryTriple> {
        final String contentType;
        final PackagePartName partName;
        final ZipArchiveEntry zipArchiveEntry;

        public EntryTriple(ZipArchiveEntry zipArchiveEntry, ContentTypeManager contentTypeManager) {
            PackagePartName packagePartNameCreatePartName;
            this.zipArchiveEntry = zipArchiveEntry;
            String name = zipArchiveEntry.getName();
            if (!ZipPackage.ignoreEntry(zipArchiveEntry)) {
                try {
                    packagePartNameCreatePartName = ContentTypeManager.CONTENT_TYPES_PART_NAME.equalsIgnoreCase(name) ? null : PackagingURIHelper.createPartName(ZipHelper.getOPCNameFromZipItemName(name));
                } catch (Exception e) {
                    ZipPackage.LOG.atWarn().withThrowable(e).log("Entry {} is not valid, so this part won't be added to the package.", name);
                }
            }
            this.partName = packagePartNameCreatePartName;
            this.contentType = packagePartNameCreatePartName != null ? contentTypeManager.getContentType(packagePartNameCreatePartName) : null;
        }

        public void register(PackagePartCollection packagePartCollection) throws InvalidFormatException {
            if (this.contentType == null) {
                throw new InvalidFormatException("The part " + this.partName.getURI().getPath() + " does not have any content type ! Rule: Package require content types when retrieving a part from a package. [M.1.14]");
            }
            if (packagePartCollection.containsKey(this.partName)) {
                throw new InvalidFormatException("A part with the name '" + this.partName + "' already exists : Packages shall not contain equivalent part names and package implementers shall neither create nor recognize packages with equivalent part names. [M1.12]");
            }
            try {
                PackagePartName packagePartName = this.partName;
                packagePartCollection.put(packagePartName, new ZipPackagePart(ZipPackage.this, this.zipArchiveEntry, packagePartName, this.contentType, false));
            } catch (InvalidOperationException e) {
                throw new InvalidFormatException(e.getMessage(), e);
            }
        }

        @Override // java.lang.Comparable
        public int compareTo(EntryTriple entryTriple) {
            int iCompare = Integer.compare(ContentTypes.RELATIONSHIPS_PART.equals(this.contentType) ? -1 : 1, ContentTypes.RELATIONSHIPS_PART.equals(entryTriple.contentType) ? -1 : 1);
            return iCompare != 0 ? iCompare : this.partName.compareTo(entryTriple.partName);
        }
    }

    public ZipPackage() {
        super(OPCPackage.defaultPackageAccess);
        this.zipArchive = null;
        try {
            this.contentTypeManager = new ZipContentTypeManager(null, this);
        } catch (InvalidFormatException e) {
            LOG.atWarn().withThrowable(e).log("Could not parse ZipPackage");
        }
    }

    public static boolean encryptTempFilePackageParts() {
        return encryptTempFilePackageParts;
    }

    private synchronized String generateTempFileName(File file) {
        File file2;
        do {
            file2 = new File(file.getAbsoluteFile() + File.separator + "OpenXML4J" + System.nanoTime());
        } while (file2.exists());
        return FileHelper.getFilename(file2.getAbsoluteFile());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ignoreEntry(ZipArchiveEntry zipArchiveEntry) {
        String name = zipArchiveEntry.getName();
        return name.startsWith("[trash]") || name.endsWith(PackagingURIHelper.FORWARD_SLASH_STRING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getPartsImpl$0(ZipArchiveEntry zipArchiveEntry) {
        return !ignoreEntry(zipArchiveEntry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ EntryTriple lambda$getPartsImpl$1(ZipArchiveEntry zipArchiveEntry) {
        return new EntryTriple(zipArchiveEntry, this.contentTypeManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getPartsImpl$2(EntryTriple entryTriple) {
        return entryTriple.partName != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Message lambda$saveImpl$3(PackagePartName packagePartName) {
        return new SimpleMessage("Save part '" + ZipHelper.getZipItemNameFromOPCName(packagePartName.getName()) + "'");
    }

    private static ZipEntrySource openZipEntrySourceStream(File file) throws Throwable {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                return openZipEntrySourceStream(fileInputStream);
            } catch (UnsupportedFileFormatException e) {
                e = e;
                IOUtils.closeQuietly(fileInputStream);
                throw e;
            } catch (InvalidOperationException e6) {
                e = e6;
                IOUtils.closeQuietly(fileInputStream);
                throw e;
            } catch (Exception e7) {
                IOUtils.closeQuietly(fileInputStream);
                throw new InvalidOperationException("Failed to read the file input stream from file: '" + file + "'", e7);
            }
        } catch (FileNotFoundException e8) {
            throw new InvalidOperationException("Can't open the specified file input stream from file: '" + file + "'", e8);
        }
    }

    public static void setEncryptTempFilePackageParts(boolean z6) {
        encryptTempFilePackageParts = z6;
    }

    public static void setUseTempFilePackageParts(boolean z6) {
        useTempFilePackageParts = z6;
    }

    public static boolean useTempFilePackageParts() {
        return useTempFilePackageParts;
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public void closeImpl() {
        flush();
        String str = this.originalPackagePath;
        if (str == null || str.isEmpty()) {
            return;
        }
        File file = new File(this.originalPackagePath);
        if (!file.exists()) {
            throw new InvalidOperationException("Can't close a package not previously open with the open() method !");
        }
        File fileCreateTempFile = TempFile.createTempFile(generateTempFileName(FileHelper.getDirectory(file)), ".tmp");
        try {
            save(fileCreateTempFile);
            IOUtils.closeQuietly(this.zipArchive);
            try {
                FileHelper.copyFile(fileCreateTempFile, file);
            } finally {
                if (!fileCreateTempFile.delete()) {
                    LOG.atWarn().log("The temporary file: '{}' cannot be deleted ! Make sure that no other application use it.", file.getAbsolutePath());
                }
            }
        } catch (Throwable th) {
            IOUtils.closeQuietly(this.zipArchive);
            if (!fileCreateTempFile.delete()) {
                LOG.atWarn().log("The temporary file: '{}' cannot be deleted ! Make sure that no other application use it.", file.getAbsolutePath());
            }
            throw th;
        }
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public PackagePart createPartImpl(PackagePartName packagePartName, String str, boolean z6) {
        if (str == null) {
            throw new IllegalArgumentException("contentType");
        }
        if (packagePartName == null) {
            throw new IllegalArgumentException("partName");
        }
        try {
            if (useTempFilePackageParts) {
                return encryptTempFilePackageParts ? new EncryptedTempFilePackagePart(this, packagePartName, str, z6) : new TempFilePackagePart(this, packagePartName, str, z6);
            }
            return new MemoryPackagePart(this, packagePartName, str, z6);
        } catch (Exception e) {
            LOG.atWarn().withThrowable(e).log("Failed to create part {}", packagePartName);
            return null;
        }
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public PackagePartCollection getPartsImpl() throws InvalidFormatException {
        PackagePartCollection packagePartCollection = new PackagePartCollection();
        ZipEntrySource zipEntrySource = this.zipArchive;
        if (zipEntrySource != null) {
            ZipArchiveEntry entry = zipEntrySource.getEntry(ContentTypeManager.CONTENT_TYPES_PART_NAME);
            if (entry == null) {
                boolean z6 = this.zipArchive.getEntry(MIMETYPE) != null;
                boolean z7 = this.zipArchive.getEntry(SETTINGS_XML) != null;
                if (z6 && z7) {
                    throw new ODFNotOfficeXmlFileException("The supplied data appears to be in ODF (Open Document) Format. Formats like these (eg ODS, ODP) are not supported, try Apache ODFToolkit");
                }
                if (this.zipArchive.getEntries().hasMoreElements()) {
                    throw new InvalidFormatException("Package should contain a content type part [M1.13]");
                }
                throw new NotOfficeXmlFileException("No valid entries or contents found, this is not a valid OOXML (Office Open XML) file");
            }
            if (this.contentTypeManager != null) {
                throw new InvalidFormatException("ContentTypeManager can only be created once. This must be a cyclic relation?");
            }
            try {
                this.contentTypeManager = new ZipContentTypeManager(this.zipArchive.getInputStream(entry), this);
                final int i5 = 1;
                Stream map = Collections.list(this.zipArchive.getEntries()).stream().filter(new Predicate() { // from class: org.apache.poi.openxml4j.opc.f
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        switch (i5) {
                            case 0:
                                return ZipPackage.lambda$getPartsImpl$2((ZipPackage.EntryTriple) obj);
                            default:
                                return ZipPackage.lambda$getPartsImpl$0((ZipArchiveEntry) obj);
                        }
                    }
                }).map(new com.google.android.material.color.utilities.a(this, 4));
                final int i6 = 0;
                Iterator it = ((List) map.filter(new Predicate() { // from class: org.apache.poi.openxml4j.opc.f
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        switch (i6) {
                            case 0:
                                return ZipPackage.lambda$getPartsImpl$2((ZipPackage.EntryTriple) obj);
                            default:
                                return ZipPackage.lambda$getPartsImpl$0((ZipArchiveEntry) obj);
                        }
                    }
                }).sorted().collect(Collectors.toList())).iterator();
                while (it.hasNext()) {
                    ((EntryTriple) it.next()).register(packagePartCollection);
                }
            } catch (IOException e) {
                throw new InvalidFormatException(e.getMessage(), e);
            }
        }
        return packagePartCollection;
    }

    public ZipEntrySource getZipArchive() {
        return this.zipArchive;
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public boolean isClosed() {
        ZipEntrySource zipEntrySource = this.zipArchive;
        return zipEntrySource != null && zipEntrySource.isClosed();
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public void removePartImpl(PackagePartName packagePartName) {
        if (packagePartName == null) {
            throw new IllegalArgumentException("partUri");
        }
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public void revertImpl() {
        try {
            ZipEntrySource zipEntrySource = this.zipArchive;
            if (zipEntrySource != null) {
                zipEntrySource.close();
            }
        } catch (IOException unused) {
        }
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public void saveImpl(OutputStream outputStream) {
        throwExceptionIfReadOnly();
        ZipArchiveOutputStream zipArchiveOutputStream = outputStream instanceof ZipArchiveOutputStream ? (ZipArchiveOutputStream) outputStream : new ZipArchiveOutputStream(outputStream);
        try {
            if (getPartsByRelationshipType(PackageRelationshipTypes.CORE_PROPERTIES).isEmpty() && getPartsByRelationshipType(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376).isEmpty()) {
                LOG.atDebug().log("Save core properties part");
                getPackageProperties();
                addPackagePart(this.packageProperties);
                this.relationships.addRelationship(this.packageProperties.getPartName().getURI(), TargetMode.INTERNAL, PackageRelationshipTypes.CORE_PROPERTIES, null);
                if (!this.contentTypeManager.isContentTypeRegister(ContentTypes.CORE_PROPERTIES_PART)) {
                    this.contentTypeManager.addContentType(this.packageProperties.getPartName(), ContentTypes.CORE_PROPERTIES_PART);
                }
            }
            Logger logger = LOG;
            logger.atDebug().log("Save content types part");
            this.contentTypeManager.save(zipArchiveOutputStream);
            logger.atDebug().log("Save package relationships");
            ZipPartMarshaller.marshallRelationshipPart(getRelationships(), PackagingURIHelper.PACKAGE_RELATIONSHIPS_ROOT_PART_NAME, zipArchiveOutputStream);
            ArrayList<PackagePart> parts = getParts();
            int size = parts.size();
            int i5 = 0;
            while (i5 < size) {
                PackagePart packagePart = parts.get(i5);
                i5++;
                PackagePart packagePart2 = packagePart;
                if (!packagePart2.isRelationshipPart()) {
                    PackagePartName partName = packagePart2.getPartName();
                    LOG.atDebug().log((Supplier<Message>) new g(partName, 0));
                    PartMarshaller partMarshaller = this.partMarshallers.get(packagePart2._contentType);
                    if (partMarshaller == null) {
                        partMarshaller = this.defaultPartMarshaller;
                    }
                    if (!partMarshaller.marshall(packagePart2, zipArchiveOutputStream)) {
                        throw new OpenXML4JException("The part " + partName.getURI() + " failed to be saved in the stream with marshaller " + partMarshaller + ". Enable logging via Log4j 2 for more details.");
                    }
                }
            }
            zipArchiveOutputStream.finish();
        } catch (OpenXML4JRuntimeException e) {
            throw e;
        } catch (Exception e6) {
            throw new OpenXML4JRuntimeException("Fail to save: an error occurs while saving the package : " + e6.getMessage(), e6);
        }
    }

    public ZipPackage(InputStream inputStream, PackageAccess packageAccess) {
        super(packageAccess);
        ZipArchiveThresholdInputStream zipArchiveThresholdInputStreamOpenZipStream = ZipHelper.openZipStream(inputStream);
        try {
            this.zipArchive = new ZipInputStreamZipEntrySource(zipArchiveThresholdInputStreamOpenZipStream);
        } catch (IOException | RuntimeException e) {
            IOUtils.closeQuietly(zipArchiveThresholdInputStreamOpenZipStream);
            throw e;
        }
    }

    private static ZipEntrySource openZipEntrySourceStream(FileInputStream fileInputStream) throws Throwable {
        try {
            ZipArchiveThresholdInputStream zipArchiveThresholdInputStreamOpenZipStream = ZipHelper.openZipStream(fileInputStream);
            try {
                return openZipEntrySourceStream(zipArchiveThresholdInputStreamOpenZipStream);
            } catch (UnsupportedFileFormatException e) {
                e = e;
                IOUtils.closeQuietly(zipArchiveThresholdInputStreamOpenZipStream);
                throw e;
            } catch (InvalidOperationException e6) {
                e = e6;
                IOUtils.closeQuietly(zipArchiveThresholdInputStreamOpenZipStream);
                throw e;
            } catch (Exception e7) {
                IOUtils.closeQuietly(zipArchiveThresholdInputStreamOpenZipStream);
                throw new InvalidOperationException("Failed to read the zip entry source stream", e7);
            }
        } catch (IOException e8) {
            throw new InvalidOperationException("Could not open the file input stream", e8);
        }
    }

    public ZipPackage(String str, PackageAccess packageAccess) {
        this(new File(str), packageAccess);
    }

    public ZipPackage(File file, PackageAccess packageAccess) throws Throwable {
        ZipEntrySource zipEntrySourceOpenZipEntrySourceStream;
        super(packageAccess);
        try {
            zipEntrySourceOpenZipEntrySourceStream = new ZipFileZipEntrySource(ZipHelper.openZipFile(file));
        } catch (IOException e) {
            if (packageAccess != PackageAccess.WRITE) {
                LOG.atWarn().log("Error in zip file {} - falling back to stream processing (i.e. ignoring zip central directory)", file);
                zipEntrySourceOpenZipEntrySourceStream = openZipEntrySourceStream(file);
            } else {
                throw new InvalidOperationException("Can't open the specified file: '" + file + "'", e);
            }
        }
        this.zipArchive = zipEntrySourceOpenZipEntrySourceStream;
    }

    private static ZipEntrySource openZipEntrySourceStream(ZipArchiveThresholdInputStream zipArchiveThresholdInputStream) {
        try {
            return new ZipInputStreamZipEntrySource(zipArchiveThresholdInputStream);
        } catch (IOException e) {
            throw new InvalidOperationException("Could not open the specified zip entry source stream", e);
        }
    }

    public ZipPackage(ZipEntrySource zipEntrySource, PackageAccess packageAccess) {
        super(packageAccess);
        this.zipArchive = zipEntrySource;
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public void flushImpl() {
    }
}
