package org.apache.poi.hpsf;

import androidx.collection.a;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.apache.poi.hpsf.wellknown.PropertyIDMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DocumentSummaryInformation extends PropertySet {
    public static final String DEFAULT_STREAM_NAME = "\u0005DocumentSummaryInformation";
    public static final ClassID[] FORMAT_ID = {ClassIDPredefined.DOC_SUMMARY.getClassID(), ClassIDPredefined.USER_PROPERTIES.getClassID()};

    public DocumentSummaryInformation() {
        getFirstSection().setFormatID(ClassIDPredefined.DOC_SUMMARY.getClassID());
    }

    private void ensureSection2() {
        if (getSectionCount() < 2) {
            Section section = new Section();
            section.setFormatID(ClassIDPredefined.USER_PROPERTIES.getClassID());
            addSection(section);
        }
    }

    private void notYetImplemented(String str) {
        throw new UnsupportedOperationException(a.n(str, " is not yet implemented."));
    }

    public int getApplicationVersion() {
        return getPropertyIntValue(23);
    }

    public int getByteCount() {
        return getPropertyIntValue(4);
    }

    public String getCategory() {
        return getPropertyStringValue(2);
    }

    public int getCharCountWithSpaces() {
        return getPropertyIntValue(17);
    }

    public String getCompany() {
        return getPropertyStringValue(15);
    }

    public String getContentStatus() {
        return getPropertyStringValue(27);
    }

    public String getContentType() {
        return getPropertyStringValue(26);
    }

    public CustomProperties getCustomProperties() {
        if (getSectionCount() < 2) {
            return null;
        }
        CustomProperties customProperties = new CustomProperties();
        Section section = getSections().get(1);
        Map<Long, String> dictionary = section.getDictionary();
        int i5 = 0;
        for (Property property : section.getProperties()) {
            long id = property.getID();
            if (id == 1) {
                customProperties.setCodepage(((Integer) property.getValue()).intValue());
            } else if (id > 1) {
                i5++;
                CustomProperty customProperty = new CustomProperty(property, dictionary.get(Long.valueOf(id)));
                customProperties.put(customProperty.getName(), customProperty);
            }
        }
        if (customProperties.size() != i5) {
            customProperties.setPure(false);
        }
        return customProperties;
    }

    public byte[] getDocparts() {
        notYetImplemented("Reading byte arrays");
        return (byte[]) getProperty(13);
    }

    public String getDocumentVersion() {
        return getPropertyStringValue(29);
    }

    public byte[] getHeadingPair() {
        notYetImplemented("Reading byte arrays ");
        return (byte[]) getProperty(12);
    }

    public int getHiddenCount() {
        return getPropertyIntValue(9);
    }

    public boolean getHyperlinksChanged() {
        return getPropertyBooleanValue(22);
    }

    public String getLanguage() {
        return getPropertyStringValue(28);
    }

    public int getLineCount() {
        return getPropertyIntValue(5);
    }

    public boolean getLinksDirty() {
        return getPropertyBooleanValue(16);
    }

    public int getMMClipCount() {
        return getPropertyIntValue(10);
    }

    public String getManager() {
        return getPropertyStringValue(14);
    }

    public int getNoteCount() {
        return getPropertyIntValue(8);
    }

    public int getParCount() {
        return getPropertyIntValue(6);
    }

    public String getPresentationFormat() {
        return getPropertyStringValue(3);
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public PropertyIDMap getPropertySetIDMap() {
        return PropertyIDMap.getDocumentSummaryInformationProperties();
    }

    public boolean getScale() {
        return getPropertyBooleanValue(11);
    }

    public int getSlideCount() {
        return getPropertyIntValue(7);
    }

    public byte[] getVBADigitalSignature() {
        Object property = getProperty(24);
        if (property instanceof byte[]) {
            return (byte[]) property;
        }
        return null;
    }

    public void removeApplicationVersion() {
        remove1stProperty(23L);
    }

    public void removeByteCount() {
        remove1stProperty(4L);
    }

    public void removeCategory() {
        remove1stProperty(2L);
    }

    public void removeCharCountWithSpaces() {
        remove1stProperty(17L);
    }

    public void removeCompany() {
        remove1stProperty(15L);
    }

    public void removeContentStatus() {
        remove1stProperty(27L);
    }

    public void removeContentType() {
        remove1stProperty(26L);
    }

    public void removeCustomProperties() {
        if (getSectionCount() < 2) {
            throw new HPSFRuntimeException("Illegal internal format of Document SummaryInformation stream: second section is missing.");
        }
        LinkedList<Section> linkedList = new LinkedList(getSections());
        clearSections();
        int i5 = 0;
        for (Section section : linkedList) {
            int i6 = i5 + 1;
            if (i5 != 1) {
                addSection(section);
            }
            i5 = i6;
        }
    }

    public void removeDocparts() {
        remove1stProperty(13L);
    }

    public void removeDocumentVersion() {
        remove1stProperty(29L);
    }

    public void removeHeadingPair() {
        remove1stProperty(12L);
    }

    public void removeHiddenCount() {
        remove1stProperty(9L);
    }

    public void removeHyperlinksChanged() {
        remove1stProperty(22L);
    }

    public void removeLanguage() {
        remove1stProperty(28L);
    }

    public void removeLineCount() {
        remove1stProperty(5L);
    }

    public void removeLinksDirty() {
        remove1stProperty(16L);
    }

    public void removeMMClipCount() {
        remove1stProperty(10L);
    }

    public void removeManager() {
        remove1stProperty(14L);
    }

    public void removeNoteCount() {
        remove1stProperty(8L);
    }

    public void removeParCount() {
        remove1stProperty(6L);
    }

    public void removePresentationFormat() {
        remove1stProperty(3L);
    }

    public void removeScale() {
        remove1stProperty(11L);
    }

    public void removeSlideCount() {
        remove1stProperty(7L);
    }

    public void removeVBADigitalSignature() {
        remove1stProperty(24L);
    }

    public void setApplicationVersion(int i5) {
        set1stProperty(23L, i5);
    }

    public void setByteCount(int i5) {
        set1stProperty(4L, i5);
    }

    public void setCategory(String str) {
        getFirstSection().setProperty(2, str);
    }

    public void setCharCountWithSpaces(int i5) {
        set1stProperty(17L, i5);
    }

    public void setCompany(String str) {
        set1stProperty(15L, str);
    }

    public void setContentStatus(String str) {
        set1stProperty(27L, str);
    }

    public void setContentType(String str) {
        set1stProperty(26L, str);
    }

    public void setCustomProperties(CustomProperties customProperties) {
        ensureSection2();
        Section section = getSections().get(1);
        Map<Long, String> dictionary = customProperties.getDictionary();
        int codepage = customProperties.getCodepage();
        if (codepage < 0) {
            codepage = section.getCodepage();
        }
        if (codepage < 0) {
            codepage = 1252;
        }
        customProperties.setCodepage(codepage);
        section.setCodepage(codepage);
        section.setDictionary(dictionary);
        Iterator<CustomProperty> it = customProperties.properties().iterator();
        while (it.hasNext()) {
            section.setProperty(it.next());
        }
    }

    public void setDocparts(byte[] bArr) {
        notYetImplemented("Writing byte arrays");
    }

    public void setDocumentVersion(String str) {
        set1stProperty(29L, str);
    }

    public void setHeadingPair(byte[] bArr) {
        notYetImplemented("Writing byte arrays ");
    }

    public void setHiddenCount(int i5) {
        set1stProperty(9L, i5);
    }

    public void setHyperlinksChanged(boolean z6) {
        set1stProperty(22L, z6);
    }

    public void setLanguage(String str) {
        set1stProperty(28L, str);
    }

    public void setLineCount(int i5) {
        set1stProperty(5L, i5);
    }

    public void setLinksDirty(boolean z6) {
        set1stProperty(16L, z6);
    }

    public void setMMClipCount(int i5) {
        set1stProperty(10L, i5);
    }

    public void setManager(String str) {
        set1stProperty(14L, str);
    }

    public void setNoteCount(int i5) {
        set1stProperty(8L, i5);
    }

    public void setParCount(int i5) {
        set1stProperty(6L, i5);
    }

    public void setPresentationFormat(String str) {
        getFirstSection().setProperty(3, str);
    }

    public void setScale(boolean z6) {
        set1stProperty(11L, z6);
    }

    public void setSlideCount(int i5) {
        set1stProperty(7L, i5);
    }

    public void setVBADigitalSignature(byte[] bArr) {
        set1stProperty(24L, bArr);
    }

    public DocumentSummaryInformation(PropertySet propertySet) throws UnexpectedPropertySetTypeException {
        super(propertySet);
        if (!isDocumentSummaryInformation()) {
            throw new UnexpectedPropertySetTypeException("Not a ".concat(getClass().getName()));
        }
    }

    public DocumentSummaryInformation(InputStream inputStream) {
        super(inputStream);
    }
}
