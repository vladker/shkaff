package org.apache.poi.ooxml;

import A3.AbstractC0157z;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.StreamHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.openxml4j.opc.internal.PackagePropertiesPart;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.PropertiesDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class POIXMLProperties {
    private static final PropertiesDocument NEW_CUST_INSTANCE;
    private static final org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.PropertiesDocument NEW_EXT_INSTANCE;
    private final CoreProperties core;
    private final CustomProperties cust;
    private PackagePart custPart;
    private final ExtendedProperties ext;
    private PackagePart extPart;
    private final OPCPackage pkg;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CoreProperties {
        private final PackagePropertiesPart part;

        public String getCategory() {
            return this.part.getCategoryProperty().orElse(null);
        }

        public String getContentStatus() {
            return this.part.getContentStatusProperty().orElse(null);
        }

        public String getContentType() {
            return this.part.getContentTypeProperty().orElse(null);
        }

        public Date getCreated() {
            return this.part.getCreatedProperty().orElse(null);
        }

        public String getCreator() {
            return this.part.getCreatorProperty().orElse(null);
        }

        public String getDescription() {
            return this.part.getDescriptionProperty().orElse(null);
        }

        public String getIdentifier() {
            return this.part.getIdentifierProperty().orElse(null);
        }

        public String getKeywords() {
            return this.part.getKeywordsProperty().orElse(null);
        }

        public String getLastModifiedByUser() {
            return this.part.getLastModifiedByProperty().orElse(null);
        }

        public Date getLastPrinted() {
            return this.part.getLastPrintedProperty().orElse(null);
        }

        public Date getModified() {
            return this.part.getModifiedProperty().orElse(null);
        }

        public String getRevision() {
            return this.part.getRevisionProperty().orElse(null);
        }

        public String getSubject() {
            return this.part.getSubjectProperty().orElse(null);
        }

        public String getTitle() {
            return this.part.getTitleProperty().orElse(null);
        }

        public PackagePropertiesPart getUnderlyingProperties() {
            return this.part;
        }

        public String getVersion() {
            return this.part.getVersionProperty().orElse(null);
        }

        public void setCategory(String str) {
            this.part.setCategoryProperty(str);
        }

        public void setContentStatus(String str) {
            this.part.setContentStatusProperty(str);
        }

        public void setContentType(String str) {
            this.part.setContentTypeProperty(str);
        }

        public void setCreated(Optional<Date> optional) {
            this.part.setCreatedProperty(optional);
        }

        public void setCreator(String str) {
            this.part.setCreatorProperty(str);
        }

        public void setDescription(String str) {
            this.part.setDescriptionProperty(str);
        }

        public void setIdentifier(String str) {
            this.part.setIdentifierProperty(str);
        }

        public void setKeywords(String str) {
            this.part.setKeywordsProperty(str);
        }

        public void setLastModifiedByUser(String str) {
            this.part.setLastModifiedByProperty(str);
        }

        public void setLastPrinted(Optional<Date> optional) {
            this.part.setLastPrintedProperty(optional);
        }

        public void setModified(Optional<Date> optional) {
            this.part.setModifiedProperty(optional);
        }

        public void setRevision(String str) {
            try {
                Long.valueOf(str);
                this.part.setRevisionProperty(str);
            } catch (NumberFormatException unused) {
            }
        }

        public void setSubjectProperty(String str) {
            this.part.setSubjectProperty(str);
        }

        public void setTitle(String str) {
            this.part.setTitleProperty(str);
        }

        public void setVersion(String str) {
            this.part.setVersionProperty(str);
        }

        private CoreProperties(PackagePropertiesPart packagePropertiesPart) {
            this.part = packagePropertiesPart;
        }

        public void setCreated(String str) {
            this.part.setCreatedProperty(str);
        }

        public void setLastPrinted(String str) {
            this.part.setLastPrintedProperty(str);
        }

        public void setModified(String str) {
            this.part.setModifiedProperty(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CustomProperties {
        public static final String FORMAT_ID = "{D5CDD505-2E9C-101B-9397-08002B2CF9AE}";
        private Integer lastPid;
        private final PropertiesDocument props;

        private CTProperty add(String str) {
            if (contains(str)) {
                throw new IllegalArgumentException("A property with this name already exists in the custom properties");
            }
            CTProperty cTPropertyAddNewProperty = this.props.getProperties().addNewProperty();
            cTPropertyAddNewProperty.setPid(nextPid());
            cTPropertyAddNewProperty.setFmtid(FORMAT_ID);
            cTPropertyAddNewProperty.setName(str);
            return cTPropertyAddNewProperty;
        }

        public void addProperty(String str, String str2) {
            add(str).setLpwstr(str2);
        }

        public boolean contains(String str) {
            Iterator<CTProperty> it = this.props.getProperties().getPropertyList().iterator();
            while (it.hasNext()) {
                if (it.next().getName().equals(str)) {
                    return true;
                }
            }
            return false;
        }

        public int getLastPid() {
            int pid = 1;
            for (CTProperty cTProperty : this.props.getProperties().getPropertyList()) {
                if (cTProperty.getPid() > pid) {
                    pid = cTProperty.getPid();
                }
            }
            return pid;
        }

        public CTProperty getProperty(String str) {
            for (CTProperty cTProperty : this.props.getProperties().getPropertyList()) {
                if (cTProperty.getName().equals(str)) {
                    return cTProperty;
                }
            }
            return null;
        }

        public CTProperties getUnderlyingProperties() {
            return this.props.getProperties();
        }

        public int nextPid() {
            Integer num = this.lastPid;
            int lastPid = (num == null ? getLastPid() : num.intValue()) + 1;
            this.lastPid = Integer.valueOf(lastPid);
            return lastPid;
        }

        private CustomProperties(PropertiesDocument propertiesDocument) {
            this.lastPid = null;
            this.props = propertiesDocument;
        }

        public void addProperty(String str, double d) {
            add(str).setR8(d);
        }

        public void addProperty(String str, int i5) {
            add(str).setI4(i5);
        }

        public void addProperty(String str, boolean z6) {
            add(str).setBool(z6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ExtendedProperties {
        private final org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.PropertiesDocument props;

        public String getAppVersion() {
            if (this.props.getProperties().isSetAppVersion()) {
                return this.props.getProperties().getAppVersion();
            }
            return null;
        }

        public String getApplication() {
            if (this.props.getProperties().isSetApplication()) {
                return this.props.getProperties().getApplication();
            }
            return null;
        }

        public int getCharacters() {
            if (this.props.getProperties().isSetCharacters()) {
                return this.props.getProperties().getCharacters();
            }
            return -1;
        }

        public int getCharactersWithSpaces() {
            if (this.props.getProperties().isSetCharactersWithSpaces()) {
                return this.props.getProperties().getCharactersWithSpaces();
            }
            return -1;
        }

        public String getCompany() {
            if (this.props.getProperties().isSetCompany()) {
                return this.props.getProperties().getCompany();
            }
            return null;
        }

        public int getHiddenSlides() {
            if (this.props.getProperties().isSetHiddenSlides()) {
                return this.props.getProperties().getHiddenSlides();
            }
            return -1;
        }

        public String getHyperlinkBase() {
            if (this.props.getProperties().isSetHyperlinkBase()) {
                return this.props.getProperties().getHyperlinkBase();
            }
            return null;
        }

        public int getLines() {
            if (this.props.getProperties().isSetLines()) {
                return this.props.getProperties().getLines();
            }
            return -1;
        }

        public int getMMClips() {
            if (this.props.getProperties().isSetMMClips()) {
                return this.props.getProperties().getMMClips();
            }
            return -1;
        }

        public String getManager() {
            if (this.props.getProperties().isSetManager()) {
                return this.props.getProperties().getManager();
            }
            return null;
        }

        public int getNotes() {
            if (this.props.getProperties().isSetNotes()) {
                return this.props.getProperties().getNotes();
            }
            return -1;
        }

        public int getPages() {
            if (this.props.getProperties().isSetPages()) {
                return this.props.getProperties().getPages();
            }
            return -1;
        }

        public int getParagraphs() {
            if (this.props.getProperties().isSetParagraphs()) {
                return this.props.getProperties().getParagraphs();
            }
            return -1;
        }

        public String getPresentationFormat() {
            if (this.props.getProperties().isSetPresentationFormat()) {
                return this.props.getProperties().getPresentationFormat();
            }
            return null;
        }

        public int getSlides() {
            if (this.props.getProperties().isSetSlides()) {
                return this.props.getProperties().getSlides();
            }
            return -1;
        }

        public String getTemplate() {
            if (this.props.getProperties().isSetTemplate()) {
                return this.props.getProperties().getTemplate();
            }
            return null;
        }

        public int getTotalTime() {
            if (this.props.getProperties().isSetTotalTime()) {
                return this.props.getProperties().getTotalTime();
            }
            return -1;
        }

        public org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties getUnderlyingProperties() {
            return this.props.getProperties();
        }

        public int getWords() {
            if (this.props.getProperties().isSetWords()) {
                return this.props.getProperties().getWords();
            }
            return -1;
        }

        public void setAppVersion(String str) {
            this.props.getProperties().setAppVersion(str);
        }

        public void setApplication(String str) {
            this.props.getProperties().setApplication(str);
        }

        public void setCharacters(int i5) {
            this.props.getProperties().setCharacters(i5);
        }

        public void setCharactersWithSpaces(int i5) {
            this.props.getProperties().setCharactersWithSpaces(i5);
        }

        public void setCompany(String str) {
            this.props.getProperties().setCompany(str);
        }

        public void setHiddenSlides(int i5) {
            this.props.getProperties().setHiddenSlides(i5);
        }

        public void setHyperlinkBase(String str) {
            this.props.getProperties().setHyperlinkBase(str);
        }

        public void setLines(int i5) {
            this.props.getProperties().setLines(i5);
        }

        public void setMMClips(int i5) {
            this.props.getProperties().setMMClips(i5);
        }

        public void setManager(String str) {
            this.props.getProperties().setManager(str);
        }

        public void setNotes(int i5) {
            this.props.getProperties().setNotes(i5);
        }

        public void setPages(int i5) {
            this.props.getProperties().setPages(i5);
        }

        public void setParagraphs(int i5) {
            this.props.getProperties().setParagraphs(i5);
        }

        public void setPresentationFormat(String str) {
            this.props.getProperties().setPresentationFormat(str);
        }

        public void setSlides(int i5) {
            this.props.getProperties().setSlides(i5);
        }

        public void setTemplate(String str) {
            this.props.getProperties().setTemplate(str);
        }

        public void setTotalTime(int i5) {
            this.props.getProperties().setTotalTime(i5);
        }

        public void setWords(int i5) {
            this.props.getProperties().setWords(i5);
        }

        private ExtendedProperties(org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.PropertiesDocument propertiesDocument) {
            this.props = propertiesDocument;
        }
    }

    static {
        org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.PropertiesDocument propertiesDocumentNewInstance = org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.PropertiesDocument.Factory.newInstance();
        NEW_EXT_INSTANCE = propertiesDocumentNewInstance;
        propertiesDocumentNewInstance.addNewProperties();
        PropertiesDocument propertiesDocumentNewInstance2 = PropertiesDocument.Factory.newInstance();
        NEW_CUST_INSTANCE = propertiesDocumentNewInstance2;
        propertiesDocumentNewInstance2.addNewProperties();
    }

    public POIXMLProperties(OPCPackage oPCPackage) throws IOException {
        this.pkg = oPCPackage;
        this.core = new CoreProperties((PackagePropertiesPart) oPCPackage.getPackageProperties());
        PackageRelationshipCollection relationshipsByType = oPCPackage.getRelationshipsByType(PackageRelationshipTypes.EXTENDED_PROPERTIES);
        if (relationshipsByType.size() == 1) {
            PackagePart part = oPCPackage.getPart(relationshipsByType.getRelationship(0));
            this.extPart = part;
            if (part == null) {
                this.ext = new ExtendedProperties((org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.PropertiesDocument) NEW_EXT_INSTANCE.copy());
            } else {
                InputStream inputStream = part.getInputStream();
                try {
                    this.ext = new ExtendedProperties(org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.PropertiesDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS));
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            }
        } else {
            this.extPart = null;
            this.ext = new ExtendedProperties((org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.PropertiesDocument) NEW_EXT_INSTANCE.copy());
        }
        PackageRelationshipCollection relationshipsByType2 = oPCPackage.getRelationshipsByType(PackageRelationshipTypes.CUSTOM_PROPERTIES);
        if (relationshipsByType2.size() != 1) {
            this.custPart = null;
            this.cust = new CustomProperties((PropertiesDocument) NEW_CUST_INSTANCE.copy());
            return;
        }
        PackagePart part2 = oPCPackage.getPart(relationshipsByType2.getRelationship(0));
        this.custPart = part2;
        if (part2 == null) {
            this.cust = new CustomProperties((PropertiesDocument) NEW_CUST_INSTANCE.copy());
            return;
        }
        InputStream inputStream2 = part2.getInputStream();
        try {
            this.cust = new CustomProperties(PropertiesDocument.Factory.parse(inputStream2, POIXMLTypeLoader.DEFAULT_XML_OPTIONS));
            if (inputStream2 != null) {
                inputStream2.close();
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        }
    }

    public void commit() {
        CustomProperties customProperties;
        ExtendedProperties extendedProperties;
        CustomProperties customProperties2;
        ExtendedProperties extendedProperties2;
        if (this.extPart == null && (extendedProperties2 = this.ext) != null && extendedProperties2.props != null && !NEW_EXT_INSTANCE.toString().equals(this.ext.props.toString())) {
            try {
                PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName("/docProps/app.xml");
                this.pkg.addRelationship(packagePartNameCreatePartName, TargetMode.INTERNAL, PackageRelationshipTypes.EXTENDED_PROPERTIES);
                this.extPart = this.pkg.createPart(packagePartNameCreatePartName, "application/vnd.openxmlformats-officedocument.extended-properties+xml");
            } catch (InvalidFormatException e) {
                throw new POIXMLException(e);
            }
        }
        if (this.custPart == null && (customProperties2 = this.cust) != null && customProperties2.props != null && !NEW_CUST_INSTANCE.toString().equals(this.cust.props.toString())) {
            try {
                PackagePartName packagePartNameCreatePartName2 = PackagingURIHelper.createPartName("/docProps/custom.xml");
                this.pkg.addRelationship(packagePartNameCreatePartName2, TargetMode.INTERNAL, PackageRelationshipTypes.CUSTOM_PROPERTIES);
                this.custPart = this.pkg.createPart(packagePartNameCreatePartName2, "application/vnd.openxmlformats-officedocument.custom-properties+xml");
            } catch (InvalidFormatException e6) {
                throw new POIXMLException(e6);
            }
        }
        if (this.extPart != null && (extendedProperties = this.ext) != null && extendedProperties.props != null) {
            OutputStream outputStream = this.extPart.getOutputStream();
            try {
                if (this.extPart.getSize() > 0) {
                    this.extPart.clear();
                }
                this.ext.props.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        if (this.custPart == null || (customProperties = this.cust) == null || customProperties.props == null) {
            return;
        }
        this.custPart.clear();
        OutputStream outputStream2 = this.custPart.getOutputStream();
        try {
            this.cust.props.save(outputStream2, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
            if (outputStream2 != null) {
                outputStream2.close();
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        }
    }

    public CoreProperties getCoreProperties() {
        return this.core;
    }

    public CustomProperties getCustomProperties() {
        return this.cust;
    }

    public ExtendedProperties getExtendedProperties() {
        return this.ext;
    }

    public String getThumbnailFilename() {
        PackagePart thumbnailPart = getThumbnailPart();
        if (thumbnailPart == null) {
            return null;
        }
        String name = thumbnailPart.getPartName().getName();
        return name.substring(name.lastIndexOf(47));
    }

    public InputStream getThumbnailImage() {
        PackagePart thumbnailPart = getThumbnailPart();
        if (thumbnailPart == null) {
            return null;
        }
        return thumbnailPart.getInputStream();
    }

    public PackagePart getThumbnailPart() {
        PackageRelationshipCollection relationshipsByType = this.pkg.getRelationshipsByType(PackageRelationshipTypes.THUMBNAIL);
        if (relationshipsByType.size() == 1) {
            return this.pkg.getPart(relationshipsByType.getRelationship(0));
        }
        return null;
    }

    public void setThumbnail(String str, InputStream inputStream) {
        PackagePart thumbnailPart = getThumbnailPart();
        if (thumbnailPart == null) {
            this.pkg.addThumbnail(str, inputStream);
            return;
        }
        String contentTypeFromFileExtension = ContentTypes.getContentTypeFromFileExtension(str);
        if (contentTypeFromFileExtension.equals(thumbnailPart.getContentType())) {
            StreamHelper.copyStream(inputStream, thumbnailPart.getOutputStream());
        } else {
            StringBuilder sbY = AbstractC0157z.y("Can't set a Thumbnail of type ", contentTypeFromFileExtension, " when existing one is of a different type ");
            sbY.append(thumbnailPart.getContentType());
            throw new IllegalArgumentException(sbY.toString());
        }
    }
}
