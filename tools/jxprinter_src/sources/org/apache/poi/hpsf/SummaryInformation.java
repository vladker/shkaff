package org.apache.poi.hpsf;

import java.io.InputStream;
import org.apache.poi.hpsf.wellknown.PropertyIDMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class SummaryInformation extends PropertySet {
    public static final String DEFAULT_STREAM_NAME = "\u0005SummaryInformation";
    public static final ClassID FORMAT_ID = ClassIDPredefined.SUMMARY_PROPERTIES.getClassID();

    public SummaryInformation() {
        getFirstSection().setFormatID(FORMAT_ID);
    }

    public String getApplicationName() {
        return getPropertyStringValue(18);
    }

    public String getAuthor() {
        return getPropertyStringValue(4);
    }

    public int getCharCount() {
        return getPropertyIntValue(16);
    }

    public String getComments() {
        return getPropertyStringValue(6);
    }

    public java.util.Date getCreateDateTime() {
        return (java.util.Date) getProperty(12);
    }

    public long getEditTime() {
        java.util.Date date = (java.util.Date) getProperty(10);
        if (date == null) {
            return 0L;
        }
        return Filetime.dateToFileTime(date);
    }

    public String getKeywords() {
        return getPropertyStringValue(5);
    }

    public String getLastAuthor() {
        return getPropertyStringValue(8);
    }

    public java.util.Date getLastPrinted() {
        return (java.util.Date) getProperty(11);
    }

    public java.util.Date getLastSaveDateTime() {
        return (java.util.Date) getProperty(13);
    }

    public int getPageCount() {
        return getPropertyIntValue(14);
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public PropertyIDMap getPropertySetIDMap() {
        return PropertyIDMap.getSummaryInformationProperties();
    }

    public String getRevNumber() {
        return getPropertyStringValue(9);
    }

    public int getSecurity() {
        return getPropertyIntValue(19);
    }

    public String getSubject() {
        return getPropertyStringValue(3);
    }

    public String getTemplate() {
        return getPropertyStringValue(7);
    }

    public byte[] getThumbnail() {
        return (byte[]) getProperty(17);
    }

    public Thumbnail getThumbnailThumbnail() {
        byte[] thumbnail = getThumbnail();
        if (thumbnail == null) {
            return null;
        }
        return new Thumbnail(thumbnail);
    }

    public String getTitle() {
        return getPropertyStringValue(2);
    }

    public int getWordCount() {
        return getPropertyIntValue(15);
    }

    public void removeApplicationName() {
        remove1stProperty(18L);
    }

    public void removeAuthor() {
        remove1stProperty(4L);
    }

    public void removeCharCount() {
        remove1stProperty(16L);
    }

    public void removeComments() {
        remove1stProperty(6L);
    }

    public void removeCreateDateTime() {
        remove1stProperty(12L);
    }

    public void removeEditTime() {
        remove1stProperty(10L);
    }

    public void removeKeywords() {
        remove1stProperty(5L);
    }

    public void removeLastAuthor() {
        remove1stProperty(8L);
    }

    public void removeLastPrinted() {
        remove1stProperty(11L);
    }

    public void removeLastSaveDateTime() {
        remove1stProperty(13L);
    }

    public void removePageCount() {
        remove1stProperty(14L);
    }

    public void removeRevNumber() {
        remove1stProperty(9L);
    }

    public void removeSecurity() {
        remove1stProperty(19L);
    }

    public void removeSubject() {
        remove1stProperty(3L);
    }

    public void removeTemplate() {
        remove1stProperty(7L);
    }

    public void removeThumbnail() {
        remove1stProperty(17L);
    }

    public void removeTitle() {
        remove1stProperty(2L);
    }

    public void removeWordCount() {
        remove1stProperty(15L);
    }

    public void setApplicationName(String str) {
        set1stProperty(18L, str);
    }

    public void setAuthor(String str) {
        set1stProperty(4L, str);
    }

    public void setCharCount(int i5) {
        set1stProperty(16L, i5);
    }

    public void setComments(String str) {
        set1stProperty(6L, str);
    }

    public void setCreateDateTime(java.util.Date date) {
        getFirstSection().setProperty(12, 64L, date);
    }

    public void setEditTime(long j6) {
        getFirstSection().setProperty(10, 64L, Filetime.filetimeToDate(j6));
    }

    public void setKeywords(String str) {
        set1stProperty(5L, str);
    }

    public void setLastAuthor(String str) {
        set1stProperty(8L, str);
    }

    public void setLastPrinted(java.util.Date date) {
        getFirstSection().setProperty(11, 64L, date);
    }

    public void setLastSaveDateTime(java.util.Date date) {
        getFirstSection().setProperty(13, 64L, date);
    }

    public void setPageCount(int i5) {
        set1stProperty(14L, i5);
    }

    public void setRevNumber(String str) {
        set1stProperty(9L, str);
    }

    public void setSecurity(int i5) {
        set1stProperty(19L, i5);
    }

    public void setSubject(String str) {
        set1stProperty(3L, str);
    }

    public void setTemplate(String str) {
        set1stProperty(7L, str);
    }

    public void setThumbnail(byte[] bArr) {
        getFirstSection().setProperty(17, 30L, bArr);
    }

    public void setTitle(String str) {
        set1stProperty(2L, str);
    }

    public void setWordCount(int i5) {
        set1stProperty(15L, i5);
    }

    public SummaryInformation(PropertySet propertySet) throws UnexpectedPropertySetTypeException {
        super(propertySet);
        if (!isSummaryInformation()) {
            throw new UnexpectedPropertySetTypeException("Not a ".concat(SummaryInformation.class.getName()));
        }
    }

    public SummaryInformation(InputStream inputStream) {
        super(inputStream);
    }
}
