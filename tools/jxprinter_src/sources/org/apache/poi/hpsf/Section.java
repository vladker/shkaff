package org.apache.poi.hpsf;

import A3.AbstractC0157z;
import androidx.exifinterface.media.a;
import com.alibaba.android.arouter.utils.Consts;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.compress.compressors.bzip2.BZip2Constants;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hpsf.wellknown.PropertyIDMap;
import org.apache.poi.util.CodePageUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.LittleEndianOutputStream;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Section {
    private static final Logger LOG = LogManager.getLogger((Class<?>) Section.class);
    private final long _offset;
    private Map<Long, String> dictionary;
    private ClassID formatID;
    private final Map<Long, Property> properties;
    private final UnsynchronizedByteArrayOutputStream sectionBytes;
    private transient boolean wasNull;

    public Section() {
        this.sectionBytes = new UnsynchronizedByteArrayOutputStream();
        this.properties = new LinkedHashMap();
        this._offset = -1L;
    }

    private int calcSize() throws IOException {
        this.sectionBytes.reset();
        write(this.sectionBytes);
        padSectionBytes();
        return this.sectionBytes.size();
    }

    private void padSectionBytes() {
        int size = 3 & (4 - (this.sectionBytes.size() & 3));
        this.sectionBytes.write(new byte[]{0, 0, 0}, 0, size);
    }

    private static int propLen(TreeBidiMap<Long, Long> treeBidiMap, Long l6, long j6) {
        Long l7 = (Long) treeBidiMap.nextKey(l6);
        long jLongValue = l6.longValue();
        if (l7 != null) {
            j6 = l7.longValue();
        }
        return Math.toIntExact(j6 - jLongValue);
    }

    private boolean readDictionary(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream, int i5, int i6) {
        HashMap map = new HashMap();
        long uInt = littleEndianByteArrayInputStream.readUInt();
        long j6 = -1;
        boolean z6 = false;
        int i7 = 0;
        while (i7 < uInt) {
            String strK = a.k("The property set's dictionary contains bogus data. All dictionary entries starting with the one with ID ", j6, " will be ignored.");
            long uInt2 = littleEndianByteArrayInputStream.readUInt();
            long uInt3 = littleEndianByteArrayInputStream.readUInt();
            int i8 = i6 == -1 ? 1252 : i6;
            int intExact = Math.toIntExact((uInt3 - 1) * ((long) (i8 == 1200 ? 2 : 1)));
            if (intExact > 16777215) {
                LOG.atWarn().log(strK);
            } else {
                try {
                    byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(intExact, CodePageString.getMaxRecordLength());
                    littleEndianByteArrayInputStream.readFully(bArrSafelyAllocate, 0, intExact);
                    String stringFromCodePage = CodePageUtil.getStringFromCodePage(bArrSafelyAllocate, 0, intExact, i8);
                    IOUtils.skipFully(littleEndianByteArrayInputStream, i8 == 1200 ? ((4 - ((intExact + 2) & 3)) & 3) + 2 : 1);
                    map.put(Long.valueOf(uInt2), stringFromCodePage);
                    i7++;
                    j6 = uInt2;
                } catch (IOException | RuntimeException e) {
                    LOG.atWarn().withThrowable(e).log(strK);
                }
            }
            z6 = true;
        }
        setDictionary(map);
        return !z6;
    }

    private void writeDictionary(OutputStream outputStream, int i5) throws IOException {
        byte[] bArr = new byte[4];
        Map<Long, String> dictionary = getDictionary();
        LittleEndian.putUInt(dictionary.size(), outputStream);
        int i6 = 4;
        for (Map.Entry<Long, String> entry : dictionary.entrySet()) {
            LittleEndian.putUInt(entry.getKey().longValue(), outputStream);
            String strS = AbstractC0157z.s(new StringBuilder(), entry.getValue(), WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR);
            byte[] bytesInCodePage = CodePageUtil.getBytesInCodePage(strS, i5);
            LittleEndian.putUInt(i5 == 1200 ? strS.length() : bytesInCodePage.length, outputStream);
            outputStream.write(bytesInCodePage);
            int length = i6 + 8 + bytesInCodePage.length;
            int i7 = i5 == 1200 ? (4 - (length & 3)) & 3 : 0;
            outputStream.write(bArr, 0, i7);
            i6 = length + i7;
        }
        outputStream.write(bArr, 0, (4 - (i6 & 3)) & 3);
    }

    public void clear() {
        for (Property property : getProperties()) {
            removeProperty(property.getID());
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Section)) {
            return false;
        }
        Section section = (Section) obj;
        if (!section.getFormatID().equals(getFormatID())) {
            return false;
        }
        HashSet<Long> hashSet = new HashSet(this.properties.keySet());
        hashSet.addAll(section.properties.keySet());
        hashSet.remove(0L);
        hashSet.remove(1L);
        for (Long l6 : hashSet) {
            Property property = this.properties.get(l6);
            Property property2 = section.properties.get(l6);
            if (property == null || !property.equals(property2)) {
                return false;
            }
        }
        Map<Long, String> dictionary = getDictionary();
        Map<Long, String> dictionary2 = section.getDictionary();
        if (dictionary == null && dictionary2 == null) {
            return true;
        }
        return dictionary != null && dictionary.equals(dictionary2);
    }

    public int getCodepage() {
        Integer num = (Integer) getProperty(1L);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public Map<Long, String> getDictionary() {
        if (this.dictionary == null) {
            this.dictionary = (Map) getProperty(0L);
        }
        return this.dictionary;
    }

    public ClassID getFormatID() {
        return this.formatID;
    }

    public long getOffset() {
        return this._offset;
    }

    public String getPIDString(long j6) {
        Map<Long, String> dictionary = getDictionary();
        if (dictionary == null || !dictionary.containsKey(Long.valueOf(j6))) {
            ClassID formatID = getFormatID();
            if (SummaryInformation.FORMAT_ID.equals(formatID)) {
                dictionary = PropertyIDMap.getSummaryInformationProperties();
            } else if (DocumentSummaryInformation.FORMAT_ID[0].equals(formatID)) {
                dictionary = PropertyIDMap.getDocumentSummaryInformationProperties();
            }
        }
        return (dictionary == null || !dictionary.containsKey(Long.valueOf(j6))) ? PropertyIDMap.UNDEFINED : dictionary.get(Long.valueOf(j6));
    }

    public Property[] getProperties() {
        return (Property[]) this.properties.values().toArray(new Property[0]);
    }

    public Object getProperty(long j6) {
        boolean zContainsKey = this.properties.containsKey(Long.valueOf(j6));
        this.wasNull = !zContainsKey;
        if (zContainsKey) {
            return this.properties.get(Long.valueOf(j6)).getValue();
        }
        return null;
    }

    public boolean getPropertyBooleanValue(int i5) {
        Boolean bool = (Boolean) getProperty(i5);
        return bool != null && bool.booleanValue();
    }

    public int getPropertyCount() {
        return this.properties.size();
    }

    public int getPropertyIntValue(long j6) {
        Object property = getProperty(j6);
        if (property == null) {
            return 0;
        }
        if ((property instanceof Long) || (property instanceof Integer)) {
            return ((Number) property).intValue();
        }
        throw new HPSFRuntimeException("This property is not an integer type, but " + property.getClass().getName() + Consts.DOT);
    }

    public int getSize() {
        int size = this.sectionBytes.size();
        if (size > 0) {
            return size;
        }
        try {
            return calcSize();
        } catch (HPSFRuntimeException e) {
            throw e;
        } catch (Exception e6) {
            throw new HPSFRuntimeException(e6);
        }
    }

    public int hashCode() {
        return Arrays.deepHashCode(new Object[]{getFormatID(), getProperties()});
    }

    public void removeProperty(long j6) {
        if (this.properties.remove(Long.valueOf(j6)) != null) {
            this.sectionBytes.reset();
        }
    }

    public void setCodepage(int i5) {
        setProperty(1, 2L, Integer.valueOf(i5));
    }

    public void setDictionary(Map<Long, String> map) {
        if (map == null) {
            removeProperty(0L);
            this.dictionary = null;
            return;
        }
        if (this.dictionary == null) {
            this.dictionary = new TreeMap();
        }
        this.dictionary.putAll(map);
        if (getCodepage() == -1) {
            setCodepage(1252);
        }
        setProperty(0, -1L, map);
    }

    public void setFormatID(ClassID classID) {
        this.formatID = classID;
    }

    public void setProperties(Property[] propertyArr) {
        this.properties.clear();
        for (Property property : propertyArr) {
            setProperty(property);
        }
    }

    public void setProperty(int i5, String str) {
        setProperty(i5, 30L, str);
    }

    public void setPropertyBooleanValue(int i5, boolean z6) {
        setProperty(i5, 11L, Boolean.valueOf(z6));
    }

    public String toString() {
        return toString(null);
    }

    public boolean wasNull() {
        return this.wasNull;
    }

    public int write(OutputStream outputStream) throws IOException {
        if (this.sectionBytes.size() > 0) {
            this.sectionBytes.writeTo(outputStream);
            return this.sectionBytes.size();
        }
        int codepage = getCodepage();
        if (codepage == -1) {
            LOG.atWarn().log("The codepage property is not set although a dictionary is present. Defaulting to ISO-8859-1.");
            codepage = 1252;
        }
        int[][] iArr = (int[][]) java.lang.reflect.Array.newInstance((Class<?>) Integer.TYPE, this.properties.size(), 2);
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
        try {
            LittleEndianOutputStream littleEndianOutputStream = new LittleEndianOutputStream(unsynchronizedByteArrayOutputStream);
            try {
                littleEndianOutputStream.writeInt(-1);
                littleEndianOutputStream.writeInt(this.properties.size());
                Iterator<Property> it = this.properties.values().iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    littleEndianOutputStream.writeUInt(it.next().getID());
                    iArr[i5][0] = unsynchronizedByteArrayOutputStream.size();
                    littleEndianOutputStream.writeInt(-1);
                    i5++;
                }
                int i6 = 0;
                for (Property property : this.properties.values()) {
                    int i7 = i6 + 1;
                    iArr[i6][1] = unsynchronizedByteArrayOutputStream.size();
                    if (property.getID() != 0) {
                        property.write(unsynchronizedByteArrayOutputStream, codepage);
                    } else {
                        writeDictionary(unsynchronizedByteArrayOutputStream, codepage);
                    }
                    i6 = i7;
                }
                byte[] byteArray = unsynchronizedByteArrayOutputStream.toByteArray();
                LittleEndian.putInt(byteArray, 0, unsynchronizedByteArrayOutputStream.size());
                for (int[] iArr2 : iArr) {
                    LittleEndian.putUInt(byteArray, iArr2[0], iArr2[1]);
                }
                outputStream.write(byteArray);
                int size = unsynchronizedByteArrayOutputStream.size();
                littleEndianOutputStream.close();
                unsynchronizedByteArrayOutputStream.close();
                return size;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        littleEndianOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                try {
                    unsynchronizedByteArrayOutputStream.close();
                } catch (Throwable th6) {
                    th4.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    public void setFormatID(byte[] bArr) {
        ClassID formatID = getFormatID();
        if (formatID == null) {
            formatID = new ClassID();
            setFormatID(formatID);
        }
        formatID.setBytes(bArr);
    }

    public void setProperty(int i5, int i6) {
        setProperty(i5, 3L, Integer.valueOf(i6));
    }

    public String toString(PropertyIDMap propertyIDMap) {
        StringBuilder sb = new StringBuilder("\n\n\n");
        Property[] properties = getProperties();
        sb.append(getClass().getName());
        sb.append("[formatID: ");
        sb.append(getFormatID());
        sb.append(", offset: ");
        sb.append(getOffset());
        sb.append(", propertyCount: ");
        sb.append(getPropertyCount());
        sb.append(", size: ");
        sb.append(getSize());
        sb.append(", properties: [\n");
        int codepage = getCodepage();
        if (codepage == -1) {
            codepage = 1252;
        }
        for (Property property : properties) {
            sb.append(property.toString(codepage, propertyIDMap));
            sb.append(",\n");
        }
        sb.append("]]");
        return sb.toString();
    }

    public void setProperty(int i5, long j6) {
        setProperty(i5, 20L, Long.valueOf(j6));
    }

    public void setProperty(int i5, boolean z6) {
        setProperty(i5, 11L, Boolean.valueOf(z6));
    }

    public Section(Section section) {
        this.sectionBytes = new UnsynchronizedByteArrayOutputStream();
        this.properties = new LinkedHashMap();
        this._offset = -1L;
        setFormatID(section.getFormatID());
        for (Property property : section.properties.values()) {
            this.properties.put(Long.valueOf(property.getID()), new Property(property));
        }
        setDictionary(section.getDictionary());
    }

    public void setProperty(int i5, long j6, Object obj) {
        setProperty(new Property(i5, j6, obj));
    }

    public void setProperty(Property property) {
        Property property2 = this.properties.get(Long.valueOf(property.getID()));
        if (property2 == null || !property2.equals(property)) {
            this.properties.put(Long.valueOf(property.getID()), property);
            this.sectionBytes.reset();
        }
    }

    public void setProperty(int i5, Object obj) {
        if (obj instanceof String) {
            setProperty(i5, (String) obj);
            return;
        }
        if (obj instanceof Long) {
            setProperty(i5, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Integer) {
            setProperty(i5, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            setProperty(i5, ((Short) obj).intValue());
            return;
        }
        if (obj instanceof Boolean) {
            setProperty(i5, ((Boolean) obj).booleanValue());
        } else {
            if (obj instanceof java.util.Date) {
                setProperty(i5, 64L, obj);
                return;
            }
            throw new HPSFRuntimeException("HPSF does not support properties of type " + obj.getClass().getName() + Consts.DOT);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Section(byte[] bArr, int i5) throws IOException {
        int uShort;
        this.sectionBytes = new UnsynchronizedByteArrayOutputStream();
        this.properties = new LinkedHashMap();
        this.formatID = new ClassID(bArr, i5);
        int uInt = (int) LittleEndian.getUInt(bArr, i5 + 16);
        if (bArr[uInt] == 0) {
            int i6 = 0;
            while (i6 < 3 && bArr[uInt] == 0) {
                i6++;
                uInt++;
            }
            int i7 = 0;
            while (i7 < 3 && (bArr[uInt + 3] != 0 || bArr[uInt + 7] != 0 || bArr[uInt + 11] != 0)) {
                i7++;
                uInt--;
            }
        }
        long j6 = uInt;
        this._offset = j6;
        LittleEndianByteArrayInputStream littleEndianByteArrayInputStream = new LittleEndianByteArrayInputStream(bArr, uInt);
        int iMin = (int) Math.min(littleEndianByteArrayInputStream.readUInt(), ((long) bArr.length) - j6);
        int uInt2 = (int) littleEndianByteArrayInputStream.readUInt();
        TreeBidiMap treeBidiMap = new TreeBidiMap();
        for (int i8 = 0; i8 < uInt2; i8++) {
            treeBidiMap.put(Long.valueOf(littleEndianByteArrayInputStream.readUInt()), Long.valueOf(littleEndianByteArrayInputStream.readUInt()));
        }
        long j7 = 1;
        Long l6 = (Long) treeBidiMap.getKey((Object) 1L);
        if (l6 != null) {
            littleEndianByteArrayInputStream.setReadIndex(Math.toIntExact(l6.longValue() + this._offset));
            long uInt3 = littleEndianByteArrayInputStream.readUInt();
            if (uInt3 == 2) {
                uShort = littleEndianByteArrayInputStream.readUShort();
                setCodepage(uShort);
            } else {
                throw new HPSFRuntimeException(a.k("Value type of property ID 1 is not VT_I2 but ", uInt3, Consts.DOT));
            }
        } else {
            uShort = -1;
        }
        int i9 = uShort;
        for (Map.Entry entry : treeBidiMap.entrySet()) {
            Long l7 = (Long) entry.getKey();
            long jLongValue = l7.longValue();
            long jLongValue2 = ((Long) entry.getValue()).longValue();
            if (jLongValue2 != j7) {
                long j8 = j7;
                int iPropLen = propLen(treeBidiMap, l7, iMin);
                littleEndianByteArrayInputStream.setReadIndex(Math.toIntExact(this._offset + jLongValue));
                if (jLongValue2 == 0) {
                    littleEndianByteArrayInputStream.mark(BZip2Constants.BASEBLOCKSIZE);
                    if (!readDictionary(littleEndianByteArrayInputStream, iPropLen, i9)) {
                        littleEndianByteArrayInputStream.reset();
                        try {
                            setProperty(new Property(Math.max(31L, ((Long) treeBidiMap.inverseBidiMap().lastKey()).longValue()) + j8, littleEndianByteArrayInputStream, iPropLen, i9));
                        } catch (RuntimeException unused) {
                            LOG.atInfo().log("Dictionary fallback failed - ignoring property");
                        }
                    }
                } else {
                    setProperty(new Property(jLongValue2, littleEndianByteArrayInputStream, iPropLen, i9));
                }
                j7 = j8;
            }
        }
        this.sectionBytes.write(bArr, Math.toIntExact(this._offset), iMin);
        padSectionBytes();
    }
}
