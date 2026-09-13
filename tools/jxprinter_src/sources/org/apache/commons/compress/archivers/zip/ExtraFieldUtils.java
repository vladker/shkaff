package org.apache.commons.compress.archivers.zip;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ExtraFieldUtils {
    static final ZipExtraField[] EMPTY_ZIP_EXTRA_FIELD_ARRAY;
    private static final int WORD = 4;
    private static final Map<ZipShort, Class<?>> implementations = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class UnparseableExtraField implements UnparseableExtraFieldBehavior {
        public static final int READ_KEY = 2;
        public static final int SKIP_KEY = 1;
        public static final int THROW_KEY = 0;
        private final int key;
        public static final UnparseableExtraField THROW = new UnparseableExtraField(0);
        public static final UnparseableExtraField SKIP = new UnparseableExtraField(1);
        public static final UnparseableExtraField READ = new UnparseableExtraField(2);

        private UnparseableExtraField(int i5) {
            this.key = i5;
        }

        public int getKey() {
            return this.key;
        }

        @Override // org.apache.commons.compress.archivers.zip.UnparseableExtraFieldBehavior
        public ZipExtraField onUnparseableExtraField(byte[] bArr, int i5, int i6, boolean z6, int i7) throws ZipException {
            int i8 = this.key;
            if (i8 == 0) {
                StringBuilder sbS = androidx.collection.a.s("Bad extra field starting at ", i5, i7, ".  Block length of ", " bytes exceeds remaining data of ");
                sbS.append(i6 - 4);
                sbS.append(" bytes.");
                throw new ZipException(sbS.toString());
            }
            if (i8 == 1) {
                return null;
            }
            if (i8 != 2) {
                throw new ZipException("Unknown UnparseableExtraField key: " + this.key);
            }
            UnparseableExtraFieldData unparseableExtraFieldData = new UnparseableExtraFieldData();
            if (z6) {
                unparseableExtraFieldData.parseFromLocalFileData(bArr, i5, i6);
                return unparseableExtraFieldData;
            }
            unparseableExtraFieldData.parseFromCentralDirectoryData(bArr, i5, i6);
            return unparseableExtraFieldData;
        }
    }

    static {
        register(AsiExtraField.class);
        register(X5455_ExtendedTimestamp.class);
        register(X7875_NewUnix.class);
        register(JarMarker.class);
        register(UnicodePathExtraField.class);
        register(UnicodeCommentExtraField.class);
        register(Zip64ExtendedInformationExtraField.class);
        register(X000A_NTFS.class);
        register(X0014_X509Certificates.class);
        register(X0015_CertificateIdForFile.class);
        register(X0016_CertificateIdForCentralDirectory.class);
        register(X0017_StrongEncryptionHeader.class);
        register(X0019_EncryptionRecipientCertificateList.class);
        register(ResourceAlignmentExtraField.class);
        EMPTY_ZIP_EXTRA_FIELD_ARRAY = new ZipExtraField[0];
    }

    public static ZipExtraField createExtraField(ZipShort zipShort) {
        ZipExtraField zipExtraFieldCreateExtraFieldNoDefault = createExtraFieldNoDefault(zipShort);
        if (zipExtraFieldCreateExtraFieldNoDefault != null) {
            return zipExtraFieldCreateExtraFieldNoDefault;
        }
        UnrecognizedExtraField unrecognizedExtraField = new UnrecognizedExtraField();
        unrecognizedExtraField.setHeaderId(zipShort);
        return unrecognizedExtraField;
    }

    public static ZipExtraField createExtraFieldNoDefault(ZipShort zipShort) {
        Class<?> cls = implementations.get(zipShort);
        if (cls != null) {
            return (ZipExtraField) cls.newInstance();
        }
        return null;
    }

    public static ZipExtraField fillExtraField(ZipExtraField zipExtraField, byte[] bArr, int i5, int i6, boolean z6) throws ZipException {
        try {
            if (z6) {
                zipExtraField.parseFromLocalFileData(bArr, i5, i6);
                return zipExtraField;
            }
            zipExtraField.parseFromCentralDirectoryData(bArr, i5, i6);
            return zipExtraField;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ((ZipException) new ZipException("Failed to parse corrupt ZIP extra field of type " + Integer.toHexString(zipExtraField.getHeaderId().getValue())).initCause(e));
        }
    }

    public static byte[] mergeCentralDirectoryData(ZipExtraField[] zipExtraFieldArr) {
        byte[] centralDirectoryData;
        int length = zipExtraFieldArr.length;
        boolean z6 = length > 0 && (zipExtraFieldArr[length + (-1)] instanceof UnparseableExtraFieldData);
        int i5 = z6 ? length - 1 : length;
        int value = i5 * 4;
        for (ZipExtraField zipExtraField : zipExtraFieldArr) {
            value += zipExtraField.getCentralDirectoryLength().getValue();
        }
        byte[] bArr = new byte[value];
        int length2 = 0;
        for (int i6 = 0; i6 < i5; i6++) {
            System.arraycopy(zipExtraFieldArr[i6].getHeaderId().getBytes(), 0, bArr, length2, 2);
            System.arraycopy(zipExtraFieldArr[i6].getCentralDirectoryLength().getBytes(), 0, bArr, length2 + 2, 2);
            length2 += 4;
            byte[] centralDirectoryData2 = zipExtraFieldArr[i6].getCentralDirectoryData();
            if (centralDirectoryData2 != null) {
                System.arraycopy(centralDirectoryData2, 0, bArr, length2, centralDirectoryData2.length);
                length2 += centralDirectoryData2.length;
            }
        }
        if (z6 && (centralDirectoryData = zipExtraFieldArr[length - 1].getCentralDirectoryData()) != null) {
            System.arraycopy(centralDirectoryData, 0, bArr, length2, centralDirectoryData.length);
        }
        return bArr;
    }

    public static byte[] mergeLocalFileDataData(ZipExtraField[] zipExtraFieldArr) {
        byte[] localFileDataData;
        int length = zipExtraFieldArr.length;
        boolean z6 = length > 0 && (zipExtraFieldArr[length + (-1)] instanceof UnparseableExtraFieldData);
        int i5 = z6 ? length - 1 : length;
        int value = i5 * 4;
        for (ZipExtraField zipExtraField : zipExtraFieldArr) {
            value += zipExtraField.getLocalFileDataLength().getValue();
        }
        byte[] bArr = new byte[value];
        int length2 = 0;
        for (int i6 = 0; i6 < i5; i6++) {
            System.arraycopy(zipExtraFieldArr[i6].getHeaderId().getBytes(), 0, bArr, length2, 2);
            System.arraycopy(zipExtraFieldArr[i6].getLocalFileDataLength().getBytes(), 0, bArr, length2 + 2, 2);
            length2 += 4;
            byte[] localFileDataData2 = zipExtraFieldArr[i6].getLocalFileDataData();
            if (localFileDataData2 != null) {
                System.arraycopy(localFileDataData2, 0, bArr, length2, localFileDataData2.length);
                length2 += localFileDataData2.length;
            }
        }
        if (z6 && (localFileDataData = zipExtraFieldArr[length - 1].getLocalFileDataData()) != null) {
            System.arraycopy(localFileDataData, 0, bArr, length2, localFileDataData.length);
        }
        return bArr;
    }

    public static ZipExtraField[] parse(byte[] bArr) {
        return parse(bArr, true, UnparseableExtraField.THROW);
    }

    public static void register(Class<?> cls) {
        try {
            implementations.put(((ZipExtraField) cls.newInstance()).getHeaderId(), cls);
        } catch (ClassCastException unused) {
            throw new RuntimeException(cls + " doesn't implement ZipExtraField");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException(cls + "'s no-arg constructor is not public");
        } catch (InstantiationException unused3) {
            throw new RuntimeException(cls + " is not a concrete class");
        }
    }

    public static ZipExtraField[] parse(byte[] bArr, boolean z6) {
        return parse(bArr, z6, UnparseableExtraField.THROW);
    }

    public static ZipExtraField[] parse(byte[] bArr, boolean z6, final UnparseableExtraField unparseableExtraField) {
        return parse(bArr, z6, new ExtraFieldParsingBehavior() { // from class: org.apache.commons.compress.archivers.zip.ExtraFieldUtils.1
            @Override // org.apache.commons.compress.archivers.zip.ExtraFieldParsingBehavior
            public ZipExtraField createExtraField(ZipShort zipShort) {
                return ExtraFieldUtils.createExtraField(zipShort);
            }

            @Override // org.apache.commons.compress.archivers.zip.ExtraFieldParsingBehavior
            public ZipExtraField fill(ZipExtraField zipExtraField, byte[] bArr2, int i5, int i6, boolean z7) {
                return ExtraFieldUtils.fillExtraField(zipExtraField, bArr2, i5, i6, z7);
            }

            @Override // org.apache.commons.compress.archivers.zip.UnparseableExtraFieldBehavior
            public ZipExtraField onUnparseableExtraField(byte[] bArr2, int i5, int i6, boolean z7, int i7) {
                return unparseableExtraField.onUnparseableExtraField(bArr2, i5, i6, z7, i7);
            }
        });
    }

    public static ZipExtraField[] parse(byte[] bArr, boolean z6, ExtraFieldParsingBehavior extraFieldParsingBehavior) throws ZipException {
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i5 = 0;
        while (i5 <= length - 4) {
            ZipShort zipShort = new ZipShort(bArr, i5);
            int value = new ZipShort(bArr, i5 + 2).getValue();
            int i6 = i5 + 4;
            if (i6 + value > length) {
                ZipExtraField zipExtraFieldOnUnparseableExtraField = extraFieldParsingBehavior.onUnparseableExtraField(bArr, i5, length - i5, z6, value);
                if (zipExtraFieldOnUnparseableExtraField == null) {
                    break;
                }
                arrayList.add(zipExtraFieldOnUnparseableExtraField);
                break;
            }
            byte[] bArr2 = bArr;
            boolean z7 = z6;
            ExtraFieldParsingBehavior extraFieldParsingBehavior2 = extraFieldParsingBehavior;
            try {
                ZipExtraField zipExtraFieldCreateExtraField = extraFieldParsingBehavior2.createExtraField(zipShort);
                Objects.requireNonNull(zipExtraFieldCreateExtraField, "createExtraField must not return null");
                ZipExtraField zipExtraFieldFill = extraFieldParsingBehavior2.fill(zipExtraFieldCreateExtraField, bArr2, i6, value, z7);
                Objects.requireNonNull(zipExtraFieldFill, "fill must not return null");
                arrayList.add(zipExtraFieldFill);
                i5 += value + 4;
                extraFieldParsingBehavior = extraFieldParsingBehavior2;
                bArr = bArr2;
                z6 = z7;
            } catch (IllegalAccessException | InstantiationException e) {
                throw ((ZipException) new ZipException(e.getMessage()).initCause(e));
            }
        }
        return (ZipExtraField[]) arrayList.toArray(EMPTY_ZIP_EXTRA_FIELD_ARRAY);
    }
}
