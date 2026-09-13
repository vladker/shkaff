package org.apache.poi.sl.usermodel;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;
import org.apache.poi.util.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ObjectShape<S extends Shape<S, P>, P extends TextParagraph<S, P, ? extends TextRun>> extends Shape<S, P>, PlaceableShape<S, P> {
    String getFullName();

    ObjectData getObjectData();

    PictureData getPictureData();

    String getProgId();

    default InputStream readObjectData() {
        String oleEntry;
        String progId = getProgId();
        if (progId == null) {
            throw new IllegalStateException("Ole object hasn't been initialized or provided in the source xml. use updateObjectData() first or check the corresponding slideXXX.xml");
        }
        ObjectMetaData.Application applicationLookup = ObjectMetaData.Application.lookup(progId);
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
        try {
            InputStream inputStreamPrepareToCheckMagic = FileMagic.prepareToCheckMagic(readObjectDataRaw());
            try {
                if (FileMagic.valueOf(inputStreamPrepareToCheckMagic) == FileMagic.OLE2) {
                    POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(inputStreamPrepareToCheckMagic);
                    String str = null;
                    if (applicationLookup == null) {
                        oleEntry = null;
                    } else {
                        try {
                            oleEntry = applicationLookup.getMetaData().getOleEntry();
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
                    }
                    String[] strArr = {oleEntry, ExtractorFactory.OOXML_PACKAGE, "Contents", "CONTENTS", "CONTENTSV30"};
                    DirectoryNode root = pOIFSFileSystem.getRoot();
                    for (int i5 = 0; i5 < 5; i5++) {
                        String str2 = strArr[i5];
                        if (root.hasEntry(str2)) {
                            str = str2;
                            break;
                        }
                    }
                    if (str == null) {
                        pOIFSFileSystem.writeFilesystem(unsynchronizedByteArrayOutputStream);
                    } else {
                        DocumentInputStream documentInputStreamCreateDocumentInputStream = pOIFSFileSystem.createDocumentInputStream(str);
                        try {
                            IOUtils.copy(documentInputStreamCreateDocumentInputStream, unsynchronizedByteArrayOutputStream);
                            if (documentInputStreamCreateDocumentInputStream != null) {
                                documentInputStreamCreateDocumentInputStream.close();
                            }
                        } catch (Throwable th4) {
                            try {
                                throw th4;
                            } catch (Throwable th5) {
                                if (documentInputStreamCreateDocumentInputStream != null) {
                                    try {
                                        documentInputStreamCreateDocumentInputStream.close();
                                    } catch (Throwable th6) {
                                        th4.addSuppressed(th6);
                                    }
                                }
                                throw th5;
                            }
                        }
                    }
                    pOIFSFileSystem.close();
                } else {
                    IOUtils.copy(inputStreamPrepareToCheckMagic, unsynchronizedByteArrayOutputStream);
                }
                InputStream inputStream = unsynchronizedByteArrayOutputStream.toInputStream();
                if (inputStreamPrepareToCheckMagic != null) {
                    inputStreamPrepareToCheckMagic.close();
                }
                unsynchronizedByteArrayOutputStream.close();
                return inputStream;
            } catch (Throwable th7) {
                try {
                    throw th7;
                } catch (Throwable th8) {
                    if (inputStreamPrepareToCheckMagic != null) {
                        try {
                            inputStreamPrepareToCheckMagic.close();
                        } catch (Throwable th9) {
                            th7.addSuppressed(th9);
                        }
                    }
                    throw th8;
                }
            }
        } catch (Throwable th10) {
            try {
                throw th10;
            } catch (Throwable th11) {
                try {
                    unsynchronizedByteArrayOutputStream.close();
                } catch (Throwable th12) {
                    th10.addSuppressed(th12);
                }
                throw th11;
            }
        }
    }

    default InputStream readObjectDataRaw() {
        return getObjectData().getInputStream();
    }

    OutputStream updateObjectData(ObjectMetaData.Application application, ObjectMetaData objectMetaData);
}
