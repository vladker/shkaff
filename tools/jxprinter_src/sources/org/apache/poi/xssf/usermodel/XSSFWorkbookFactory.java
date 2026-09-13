package org.apache.poi.xssf.usermodel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentFactoryHelper;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookProvider;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class XSSFWorkbookFactory implements WorkbookProvider {
    public static XSSFWorkbook createWorkbook(OPCPackage oPCPackage) {
        try {
            return new XSSFWorkbook(oPCPackage);
        } catch (RuntimeException e) {
            oPCPackage.revert();
            throw e;
        }
    }

    @Override // org.apache.poi.ss.usermodel.WorkbookProvider
    public boolean accepts(FileMagic fileMagic) {
        return fileMagic == FileMagic.OOXML;
    }

    @Override // org.apache.poi.ss.usermodel.WorkbookProvider
    public XSSFWorkbook create() {
        return new XSSFWorkbook();
    }

    @Override // org.apache.poi.ss.usermodel.WorkbookProvider
    public XSSFWorkbook create(DirectoryNode directoryNode, String str) throws IOException {
        InputStream decryptedStream = DocumentFactoryHelper.getDecryptedStream(directoryNode, str);
        try {
            XSSFWorkbook xSSFWorkbookCreate = create(decryptedStream);
            if (decryptedStream != null) {
                decryptedStream.close();
            }
            return xSSFWorkbookCreate;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (decryptedStream != null) {
                    try {
                        decryptedStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.WorkbookProvider
    public Workbook create(InputStream inputStream, String str) {
        InputStream inputStreamPrepareToCheckMagic = FileMagic.prepareToCheckMagic(inputStream);
        FileMagic fileMagicValueOf = FileMagic.valueOf(inputStreamPrepareToCheckMagic);
        if (fileMagicValueOf == FileMagic.OLE2) {
            POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(inputStreamPrepareToCheckMagic);
            try {
                InputStream decryptedStream = DocumentFactoryHelper.getDecryptedStream(pOIFSFileSystem.getRoot(), str);
                try {
                    XSSFWorkbook xSSFWorkbookCreate = create(decryptedStream);
                    if (decryptedStream != null) {
                        decryptedStream.close();
                    }
                    pOIFSFileSystem.close();
                    return xSSFWorkbookCreate;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (decryptedStream != null) {
                            try {
                                decryptedStream.close();
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
                        pOIFSFileSystem.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                    throw th5;
                }
            }
        }
        if (fileMagicValueOf == FileMagic.OOXML) {
            return create(inputStreamPrepareToCheckMagic);
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.WorkbookProvider
    public XSSFWorkbook create(InputStream inputStream) throws IOException {
        try {
            return createWorkbook(OPCPackage.open(inputStream));
        } catch (InvalidFormatException e) {
            throw new IOException(e);
        }
    }

    @Override // org.apache.poi.ss.usermodel.WorkbookProvider
    public XSSFWorkbook create(File file, String str, boolean z6) throws IOException {
        if (FileMagic.valueOf(file) == FileMagic.OLE2) {
            POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(file, true);
            try {
                InputStream decryptedStream = DocumentFactoryHelper.getDecryptedStream(pOIFSFileSystem.getRoot(), str);
                try {
                    XSSFWorkbook xSSFWorkbookCreate = create(decryptedStream);
                    if (decryptedStream != null) {
                        decryptedStream.close();
                    }
                    pOIFSFileSystem.close();
                    return xSSFWorkbookCreate;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (decryptedStream != null) {
                            try {
                                decryptedStream.close();
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
                        pOIFSFileSystem.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                    throw th5;
                }
            }
        }
        try {
            return createWorkbook(OPCPackage.open(file, z6 ? PackageAccess.READ : PackageAccess.READ_WRITE));
        } catch (InvalidFormatException e) {
            throw new IOException(e);
        }
    }
}
