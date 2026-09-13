package org.apache.poi.poifs.filesystem;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class DocumentFactoryHelper {
    private DocumentFactoryHelper() {
    }

    public static InputStream getDecryptedStream(final POIFSFileSystem pOIFSFileSystem, String str) {
        return new FilterInputStream(getDecryptedStream(pOIFSFileSystem.getRoot(), str)) { // from class: org.apache.poi.poifs.filesystem.DocumentFactoryHelper.1
            @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                pOIFSFileSystem.close();
                super.close();
            }
        };
    }

    @Removal(version = "4.0")
    @Deprecated
    public static boolean hasOOXMLHeader(InputStream inputStream) {
        return FileMagic.valueOf(inputStream) == FileMagic.OOXML;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0021  */
    public static InputStream getDecryptedStream(DirectoryNode directoryNode, String str) throws IOException {
        boolean z6;
        if (directoryNode.hasEntry(ExtractorFactory.OOXML_PACKAGE)) {
            return directoryNode.createDocumentInputStream(ExtractorFactory.OOXML_PACKAGE);
        }
        Decryptor decryptor = Decryptor.getInstance(new EncryptionInfo(directoryNode));
        boolean z7 = true;
        if (str != null) {
            try {
                if (decryptor.verifyPassword(str)) {
                    z6 = true;
                } else {
                    z6 = false;
                }
            } catch (GeneralSecurityException e) {
                throw new IOException(e);
            }
        } else {
            z6 = false;
        }
        if (z6 || !decryptor.verifyPassword(Decryptor.DEFAULT_PASSWORD)) {
            z7 = z6;
        }
        if (z7) {
            return decryptor.getDataStream(directoryNode);
        }
        if (str != null) {
            throw new EncryptedDocumentException("Password incorrect");
        }
        throw new EncryptedDocumentException("The supplied spreadsheet is protected, but no password was supplied");
    }
}
