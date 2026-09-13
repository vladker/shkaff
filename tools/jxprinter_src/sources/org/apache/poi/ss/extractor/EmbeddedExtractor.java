package org.apache.poi.ss.extractor;

import androidx.collection.a;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hpsf.ClassIDPredefined;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.Ole10Native;
import org.apache.poi.poifs.filesystem.Ole10NativeException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.ObjectData;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Shape;
import org.apache.poi.ss.usermodel.ShapeContainer;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EmbeddedExtractor implements Iterable<EmbeddedExtractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String CONTENT_TYPE_BYTES = "binary/octet-stream";
    private static final String CONTENT_TYPE_DOC = "application/msword";
    private static final String CONTENT_TYPE_PDF = "application/pdf";
    private static final String CONTENT_TYPE_XLS = "application/vnd.ms-excel";
    private static final int DEFAULT_MAX_RECORD_LENGTH = 1000000;
    private static final Logger LOG = LogManager.getLogger((Class<?>) EmbeddedExtractor.class);
    private static int MAX_RECORD_LENGTH = 1000000;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class BiffExtractor extends EmbeddedExtractor {
        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public boolean canExtract(DirectoryNode directoryNode) {
            return canExtractExcel(directoryNode) || canExtractWord(directoryNode);
        }

        public boolean canExtractExcel(DirectoryNode directoryNode) {
            ClassIDPredefined classIDPredefinedLookup = ClassIDPredefined.lookup(directoryNode.getStorageClsid());
            return ClassIDPredefined.EXCEL_V7 == classIDPredefinedLookup || ClassIDPredefined.EXCEL_V8 == classIDPredefinedLookup || directoryNode.hasEntry("Workbook");
        }

        public boolean canExtractWord(DirectoryNode directoryNode) {
            ClassIDPredefined classIDPredefinedLookup = ClassIDPredefined.lookup(directoryNode.getStorageClsid());
            return ClassIDPredefined.WORD_V7 == classIDPredefinedLookup || ClassIDPredefined.WORD_V8 == classIDPredefinedLookup || directoryNode.hasEntry("WordDocument");
        }

        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public EmbeddedData extract(DirectoryNode directoryNode) {
            EmbeddedData embeddedDataExtract = super.extract(directoryNode);
            if (canExtractExcel(directoryNode)) {
                embeddedDataExtract.setFilename(directoryNode.getName() + ".xls");
                embeddedDataExtract.setContentType(EmbeddedExtractor.CONTENT_TYPE_XLS);
                return embeddedDataExtract;
            }
            if (canExtractWord(directoryNode)) {
                embeddedDataExtract.setFilename(directoryNode.getName() + ".doc");
                embeddedDataExtract.setContentType(EmbeddedExtractor.CONTENT_TYPE_DOC);
            }
            return embeddedDataExtract;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FsExtractor extends EmbeddedExtractor {
        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public boolean canExtract(DirectoryNode directoryNode) {
            return true;
        }

        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public EmbeddedData extract(DirectoryNode directoryNode) {
            EmbeddedData embeddedDataExtract = super.extract(directoryNode);
            embeddedDataExtract.setFilename(directoryNode.getName() + ".ole");
            return embeddedDataExtract;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class OOXMLExtractor extends EmbeddedExtractor {
        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public boolean canExtract(DirectoryNode directoryNode) {
            return directoryNode.hasEntry("package");
        }

        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public EmbeddedData extract(DirectoryNode directoryNode) {
            String contentType;
            String fileExtension;
            ClassIDPredefined classIDPredefinedLookup = ClassIDPredefined.lookup(directoryNode.getStorageClsid());
            if (classIDPredefinedLookup != null) {
                contentType = classIDPredefinedLookup.getContentType();
                fileExtension = classIDPredefinedLookup.getFileExtension();
            } else {
                contentType = null;
                fileExtension = null;
            }
            if (contentType == null || fileExtension == null) {
                contentType = "application/zip";
                fileExtension = ".zip";
            }
            DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream("package");
            byte[] byteArray = IOUtils.toByteArray(documentInputStreamCreateDocumentInputStream);
            documentInputStreamCreateDocumentInputStream.close();
            return new EmbeddedData(directoryNode.getName() + fileExtension, byteArray, contentType);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Ole10Extractor extends EmbeddedExtractor {
        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public boolean canExtract(DirectoryNode directoryNode) {
            return ClassIDPredefined.lookup(directoryNode.getStorageClsid()) == ClassIDPredefined.OLE_V1_PACKAGE;
        }

        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public EmbeddedData extract(DirectoryNode directoryNode) throws IOException {
            try {
                Ole10Native ole10NativeCreateFromEmbeddedOleObject = Ole10Native.createFromEmbeddedOleObject(directoryNode);
                return new EmbeddedData(ole10NativeCreateFromEmbeddedOleObject.getFileName(), ole10NativeCreateFromEmbeddedOleObject.getDataBuffer(), EmbeddedExtractor.CONTENT_TYPE_BYTES);
            } catch (Ole10NativeException e) {
                throw new IOException(e);
            }
        }
    }

    private static int[] computeFailure(byte[] bArr) {
        int[] iArr = new int[bArr.length];
        int i5 = 0;
        for (int i6 = 1; i6 < bArr.length; i6++) {
            while (i5 > 0 && bArr[i5] != bArr[i6]) {
                i5 = iArr[i5 - 1];
            }
            if (bArr[i5] == bArr[i6]) {
                i5++;
            }
            iArr[i6] = i5;
        }
        return iArr;
    }

    public static void copyNodes(DirectoryNode directoryNode, DirectoryNode directoryNode2) throws IOException {
        for (Entry entry : directoryNode) {
            if (entry instanceof DirectoryNode) {
                DirectoryNode directoryNode3 = (DirectoryNode) entry;
                DirectoryNode directoryNode4 = (DirectoryNode) directoryNode2.createDirectory(directoryNode3.getName());
                directoryNode4.setStorageClsid(directoryNode3.getStorageClsid());
                copyNodes(directoryNode3, directoryNode4);
            } else {
                DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream(entry);
                try {
                    directoryNode2.createDocument(entry.getName(), documentInputStreamCreateDocumentInputStream);
                    if (documentInputStreamCreateDocumentInputStream != null) {
                        documentInputStreamCreateDocumentInputStream.close();
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (documentInputStreamCreateDocumentInputStream != null) {
                            try {
                                documentInputStreamCreateDocumentInputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            }
        }
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(byte[] bArr, int i5, byte[] bArr2) {
        int[] iArrComputeFailure = computeFailure(bArr2);
        if (bArr.length == 0) {
            return -1;
        }
        int i6 = 0;
        while (i5 < bArr.length) {
            while (i6 > 0 && bArr2[i6] != bArr[i5]) {
                i6 = iArrComputeFailure[i6 - 1];
            }
            if (bArr2[i6] == bArr[i5]) {
                i6++;
            }
            if (i6 == bArr2.length) {
                return (i5 - bArr2.length) + 1;
            }
            i5++;
        }
        return -1;
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    public boolean canExtract(DirectoryNode directoryNode) {
        return false;
    }

    public EmbeddedData extract(Picture picture) {
        return null;
    }

    public List<EmbeddedData> extractAll(Sheet sheet) {
        Drawing<?> drawingPatriarch = sheet.getDrawingPatriarch();
        if (drawingPatriarch == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        extractAll(drawingPatriarch, arrayList);
        return arrayList;
    }

    public EmbeddedData extractOne(DirectoryNode directoryNode) {
        for (EmbeddedExtractor embeddedExtractor : this) {
            if (embeddedExtractor.canExtract(directoryNode)) {
                return embeddedExtractor.extract(directoryNode);
            }
        }
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator<EmbeddedExtractor> iterator() {
        return Arrays.asList(new Ole10Extractor(), new PdfExtractor(), new BiffExtractor(), new OOXMLExtractor(), new FsExtractor()).iterator();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PdfExtractor extends EmbeddedExtractor {
        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public boolean canExtract(DirectoryNode directoryNode) {
            return ClassIDPredefined.PDF.equals(directoryNode.getStorageClsid()) || directoryNode.hasEntry("CONTENTS");
        }

        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public EmbeddedData extract(DirectoryNode directoryNode) {
            UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
            try {
                DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream("CONTENTS");
                try {
                    IOUtils.copy(documentInputStreamCreateDocumentInputStream, unsynchronizedByteArrayOutputStream);
                    EmbeddedData embeddedData = new EmbeddedData(directoryNode.getName() + ".pdf", unsynchronizedByteArrayOutputStream.toByteArray(), EmbeddedExtractor.CONTENT_TYPE_PDF);
                    if (documentInputStreamCreateDocumentInputStream != null) {
                        documentInputStreamCreateDocumentInputStream.close();
                    }
                    unsynchronizedByteArrayOutputStream.close();
                    return embeddedData;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (documentInputStreamCreateDocumentInputStream != null) {
                            try {
                                documentInputStreamCreateDocumentInputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
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

        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public boolean canExtract(Picture picture) {
            PictureData pictureData = picture.getPictureData();
            return pictureData != null && pictureData.getPictureType() == 2;
        }

        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public EmbeddedData extract(Picture picture) {
            int iIndexOf;
            PictureData pictureData = picture.getPictureData();
            if (pictureData == null || pictureData.getPictureType() != 2) {
                return null;
            }
            byte[] data = pictureData.getData();
            Charset charset = LocaleUtil.CHARSET_1252;
            int iIndexOf2 = EmbeddedExtractor.indexOf(data, 0, "%PDF-".getBytes(charset));
            if (iIndexOf2 == -1 || (iIndexOf = EmbeddedExtractor.indexOf(data, iIndexOf2, "%%EOF".getBytes(charset))) == -1) {
                return null;
            }
            byte[] bArrSafelyClone = IOUtils.safelyClone(data, iIndexOf2, (iIndexOf - iIndexOf2) + 6, EmbeddedExtractor.MAX_RECORD_LENGTH);
            String strTrim = picture.getShapeName().trim();
            if (!StringUtil.endsWithIgnoreCase(strTrim, ".pdf")) {
                strTrim = a.n(strTrim, ".pdf");
            }
            return new EmbeddedData(strTrim, bArrSafelyClone, EmbeddedExtractor.CONTENT_TYPE_PDF);
        }
    }

    public boolean canExtract(Picture picture) {
        return false;
    }

    public EmbeddedData extract(DirectoryNode directoryNode) {
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        try {
            POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem();
            try {
                copyNodes(directoryNode, pOIFSFileSystem.getRoot());
                pOIFSFileSystem.writeFilesystem(unsynchronizedByteArrayOutputStream);
                EmbeddedData embeddedData = new EmbeddedData(directoryNode.getName(), unsynchronizedByteArrayOutputStream.toByteArray(), CONTENT_TYPE_BYTES);
                pOIFSFileSystem.close();
                unsynchronizedByteArrayOutputStream.close();
                return embeddedData;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        pOIFSFileSystem.close();
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

    public EmbeddedData extractOne(Picture picture) {
        for (EmbeddedExtractor embeddedExtractor : this) {
            if (embeddedExtractor.canExtract(picture)) {
                return embeddedExtractor.extract(picture);
            }
        }
        return null;
    }

    public void extractAll(ShapeContainer<?> shapeContainer, List<EmbeddedData> list) {
        Iterator<?> it = shapeContainer.iterator();
        while (it.hasNext()) {
            Shape shape = (Shape) it.next();
            EmbeddedData embeddedDataExtractOne = null;
            if (shape instanceof ObjectData) {
                ObjectData objectData = (ObjectData) shape;
                try {
                    if (objectData.hasDirectoryEntry()) {
                        embeddedDataExtractOne = extractOne((DirectoryNode) objectData.getDirectory());
                    } else {
                        embeddedDataExtractOne = new EmbeddedData(objectData.getFileName(), objectData.getObjectData(), objectData.getContentType());
                    }
                } catch (Exception e) {
                    LOG.atWarn().withThrowable(e).log("Entry not found / readable - ignoring OLE embedding");
                }
            } else if (shape instanceof Picture) {
                embeddedDataExtractOne = extractOne((Picture) shape);
            } else if (shape instanceof ShapeContainer) {
                extractAll((ShapeContainer) shape, list);
            }
            if (embeddedDataExtractOne != null) {
                embeddedDataExtractOne.setShape(shape);
                String filename = embeddedDataExtractOne.getFilename();
                String strSubstring = (filename == null || filename.lastIndexOf(46) == -1) ? ".bin" : filename.substring(filename.lastIndexOf(46));
                if ((filename == null || filename.isEmpty() || filename.startsWith("MBD") || filename.startsWith("Root Entry")) && (filename = shape.getShapeName()) != null) {
                    filename = a.n(filename, strSubstring);
                }
                if (filename == null || filename.isEmpty()) {
                    filename = "picture_" + list.size() + strSubstring;
                }
                embeddedDataExtractOne.setFilename(filename.trim());
                list.add(embeddedDataExtractOne);
            }
        }
    }
}
