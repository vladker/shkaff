package org.apache.poi.hpsf;

import androidx.collection.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.EmptyFileException;
import org.apache.poi.hpsf.wellknown.PropertyIDMap;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.util.CodePageUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.LittleEndianOutputStream;
import org.apache.poi.util.NotImplemented;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PropertySet {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int BYTE_ORDER_ASSERTION = 65534;
    static final int FORMAT_ASSERTION = 0;
    static final int OFFSET_HEADER = 28;
    public static final int OS_MACINTOSH = 1;
    public static final int OS_WIN16 = 0;
    public static final int OS_WIN32 = 2;
    private int byteOrder;
    private ClassID classID;
    private int format;
    private int osVersion;
    private final List<Section> sections;

    public PropertySet() {
        this.sections = new ArrayList();
        this.byteOrder = BYTE_ORDER_ASSERTION;
        this.format = 0;
        this.osVersion = 133636;
        this.classID = new ClassID();
        addSection(new Section());
    }

    private void init(byte[] bArr, int i5, int i6) {
        this.byteOrder = LittleEndian.getUShort(bArr, i5);
        this.format = LittleEndian.getUShort(bArr, i5 + 2);
        this.osVersion = (int) LittleEndian.getUInt(bArr, i5 + 4);
        this.classID = new ClassID(bArr, i5 + 8);
        int i7 = LittleEndian.getInt(bArr, i5 + 24);
        int i8 = i5 + 28;
        if (i7 < 0) {
            throw new HPSFRuntimeException(a.i(i7, "Section count ", " is negative."));
        }
        for (int i9 = 0; i9 < i7; i9++) {
            Section section = new Section(bArr, i8);
            i8 += 20;
            this.sections.add(section);
        }
    }

    public static boolean isPropertySetStream(InputStream inputStream) throws IOException {
        try {
            byte[] bArrPeekFirstNBytes = IOUtils.peekFirstNBytes(inputStream, 50);
            return isPropertySetStream(bArrPeekFirstNBytes, 0, bArrPeekFirstNBytes.length);
        } catch (EmptyFileException unused) {
            return false;
        }
    }

    public static boolean matchesSummary(ClassID classID, ClassID... classIDArr) {
        for (ClassID classID2 : classIDArr) {
            if (classID2.equals(classID) || classID2.equalsInverted(classID)) {
                return true;
            }
        }
        return false;
    }

    private static void putClassId(UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream, ClassID classID) {
        byte[] bArr = new byte[16];
        classID.write(bArr, 0);
        unsynchronizedByteArrayOutputStream.write(bArr, 0, 16);
    }

    private byte[] toBytes() {
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
        try {
            LittleEndianOutputStream littleEndianOutputStream = new LittleEndianOutputStream(unsynchronizedByteArrayOutputStream);
            try {
                int sectionCount = getSectionCount();
                littleEndianOutputStream.writeShort(getByteOrder());
                littleEndianOutputStream.writeShort(getFormat());
                littleEndianOutputStream.writeInt(getOSVersion());
                putClassId(unsynchronizedByteArrayOutputStream, getClassID());
                littleEndianOutputStream.writeInt(sectionCount);
                int[][] iArr = (int[][]) java.lang.reflect.Array.newInstance((Class<?>) Integer.TYPE, getSectionCount(), 2);
                Iterator<Section> it = getSections().iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    ClassID formatID = it.next().getFormatID();
                    if (formatID == null) {
                        throw new NoFormatIDException();
                    }
                    putClassId(unsynchronizedByteArrayOutputStream, formatID);
                    iArr[i5][0] = unsynchronizedByteArrayOutputStream.size();
                    littleEndianOutputStream.writeInt(-1);
                    i5++;
                }
                int i6 = 0;
                for (Section section : getSections()) {
                    iArr[i6][1] = unsynchronizedByteArrayOutputStream.size();
                    section.write(unsynchronizedByteArrayOutputStream);
                    i6++;
                }
                byte[] byteArray = unsynchronizedByteArrayOutputStream.toByteArray();
                for (int[] iArr2 : iArr) {
                    LittleEndian.putInt(byteArray, iArr2[0], iArr2[1]);
                }
                littleEndianOutputStream.close();
                unsynchronizedByteArrayOutputStream.close();
                return byteArray;
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

    public void addSection(Section section) {
        this.sections.add(section);
    }

    public void clearSections() {
        this.sections.clear();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PropertySet)) {
            return false;
        }
        PropertySet propertySet = (PropertySet) obj;
        int byteOrder = propertySet.getByteOrder();
        int byteOrder2 = getByteOrder();
        ClassID classID = propertySet.getClassID();
        ClassID classID2 = getClassID();
        int format = propertySet.getFormat();
        int format2 = getFormat();
        int oSVersion = propertySet.getOSVersion();
        int oSVersion2 = getOSVersion();
        int sectionCount = propertySet.getSectionCount();
        int sectionCount2 = getSectionCount();
        if (byteOrder == byteOrder2 && classID.equals(classID2) && format == format2 && oSVersion == oSVersion2 && sectionCount == sectionCount2) {
            return getSections().containsAll(propertySet.getSections());
        }
        return false;
    }

    public int getByteOrder() {
        return this.byteOrder;
    }

    public ClassID getClassID() {
        return this.classID;
    }

    public Section getFirstSection() {
        if (this.sections.isEmpty()) {
            throw new MissingSectionException("Property set does not contain any sections.");
        }
        return this.sections.get(0);
    }

    public int getFormat() {
        return this.format;
    }

    public int getOSVersion() {
        return this.osVersion;
    }

    public Property[] getProperties() {
        return getFirstSection().getProperties();
    }

    public Object getProperty(int i5) {
        return getFirstSection().getProperty(i5);
    }

    public boolean getPropertyBooleanValue(int i5) {
        return getFirstSection().getPropertyBooleanValue(i5);
    }

    public int getPropertyIntValue(int i5) {
        return getFirstSection().getPropertyIntValue(i5);
    }

    public PropertyIDMap getPropertySetIDMap() {
        return null;
    }

    public String getPropertyStringValue(int i5) {
        return getPropertyStringValue(getProperty(i5));
    }

    public int getSectionCount() {
        return this.sections.size();
    }

    public List<Section> getSections() {
        return Collections.unmodifiableList(this.sections);
    }

    @NotImplemented
    public int hashCode() {
        throw new UnsupportedOperationException("FIXME: Not yet implemented.");
    }

    public boolean isDocumentSummaryInformation() {
        return !this.sections.isEmpty() && matchesSummary(getFirstSection().getFormatID(), DocumentSummaryInformation.FORMAT_ID);
    }

    public boolean isSummaryInformation() {
        return !this.sections.isEmpty() && matchesSummary(getFirstSection().getFormatID(), SummaryInformation.FORMAT_ID);
    }

    public void remove1stProperty(long j6) {
        getFirstSection().removeProperty(j6);
    }

    public void set1stProperty(long j6, String str) {
        getFirstSection().setProperty((int) j6, str);
    }

    public void setByteOrder(int i5) {
        this.byteOrder = i5;
    }

    public void setClassID(ClassID classID) {
        this.classID = classID;
    }

    public void setFormat(int i5) {
        this.format = i5;
    }

    public void setOSVersion(int i5) {
        this.osVersion = i5;
    }

    public InputStream toInputStream() {
        return new UnsynchronizedByteArrayInputStream(toBytes());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int sectionCount = getSectionCount();
        sb.append(getClass().getName());
        sb.append("[byteOrder: ");
        sb.append(getByteOrder());
        sb.append(", classID: ");
        sb.append(getClassID());
        sb.append(", format: ");
        sb.append(getFormat());
        sb.append(", OSVersion: ");
        sb.append(getOSVersion());
        sb.append(", sectionCount: ");
        sb.append(sectionCount);
        sb.append(", sections: [\n");
        Iterator<Section> it = getSections().iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString(getPropertySetIDMap()));
        }
        sb.append("]]");
        return sb.toString();
    }

    public boolean wasNull() {
        return getFirstSection().wasNull();
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write(toBytes());
        outputStream.close();
    }

    public void set1stProperty(long j6, int i5) {
        getFirstSection().setProperty((int) j6, i5);
    }

    public static String getPropertyStringValue(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length;
            if (length == 0) {
                return "";
            }
            if (length == 1) {
                return Byte.toString(bArr[0]);
            }
            if (length == 2) {
                return Integer.toString(LittleEndian.getUShort(bArr));
            }
            if (length != 4) {
                try {
                    return CodePageUtil.getStringFromCodePage(bArr, 1252);
                } catch (UnsupportedEncodingException unused) {
                    return "";
                }
            }
            return Long.toString(LittleEndian.getUInt(bArr));
        }
        return obj.toString();
    }

    public static boolean isPropertySetStream(byte[] bArr, int i5, int i6) {
        LittleEndianByteArrayInputStream littleEndianByteArrayInputStream = new LittleEndianByteArrayInputStream(bArr, i5, i6);
        try {
            if (littleEndianByteArrayInputStream.readUShort() != BYTE_ORDER_ASSERTION || littleEndianByteArrayInputStream.readUShort() != 0) {
                return false;
            }
            littleEndianByteArrayInputStream.readUInt();
            return littleEndianByteArrayInputStream.skip(16L) == 16 && littleEndianByteArrayInputStream.readUInt() >= 0;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public void set1stProperty(long j6, boolean z6) {
        getFirstSection().setProperty((int) j6, z6);
    }

    public void write(DirectoryEntry directoryEntry, String str) {
        if (directoryEntry.hasEntry(str)) {
            directoryEntry.getEntry(str).delete();
        }
        directoryEntry.createDocument(str, toInputStream());
    }

    public void set1stProperty(long j6, byte[] bArr) {
        getFirstSection().setProperty((int) j6, bArr);
    }

    public PropertySet(InputStream inputStream) throws NoPropertySetStreamException {
        this.sections = new ArrayList();
        if (isPropertySetStream(inputStream)) {
            byte[] byteArray = IOUtils.toByteArray(inputStream);
            init(byteArray, 0, byteArray.length);
            return;
        }
        throw new NoPropertySetStreamException();
    }

    public PropertySet(byte[] bArr, int i5, int i6) throws NoPropertySetStreamException {
        this.sections = new ArrayList();
        if (isPropertySetStream(bArr, i5, i6)) {
            init(bArr, i5, i6);
            return;
        }
        throw new NoPropertySetStreamException();
    }

    public PropertySet(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public PropertySet(PropertySet propertySet) {
        this.sections = new ArrayList();
        setByteOrder(propertySet.getByteOrder());
        setFormat(propertySet.getFormat());
        setOSVersion(propertySet.getOSVersion());
        setClassID(propertySet.getClassID());
        Iterator<Section> it = propertySet.getSections().iterator();
        while (it.hasNext()) {
            this.sections.add(new Section(it.next()));
        }
    }
}
