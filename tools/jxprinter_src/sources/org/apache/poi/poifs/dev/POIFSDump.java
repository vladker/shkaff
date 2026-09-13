package org.apache.poi.poifs.dev;

import androidx.collection.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.DocumentNode;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.poifs.filesystem.POIFSStream;
import org.apache.poi.util.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class POIFSDump {
    private POIFSDump() {
    }

    public static void dump(DirectoryEntry directoryEntry, File file) throws IOException {
        Iterator<Entry> entries = directoryEntry.getEntries();
        while (entries.hasNext()) {
            Entry next = entries.next();
            if (next instanceof DocumentNode) {
                DocumentNode documentNode = (DocumentNode) next;
                DocumentInputStream documentInputStream = new DocumentInputStream(documentNode);
                byte[] byteArray = IOUtils.toByteArray(documentInputStream);
                documentInputStream.close();
                FileOutputStream fileOutputStream = new FileOutputStream(new File(file, documentNode.getName().trim()));
                try {
                    fileOutputStream.write(byteArray);
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } else if (next instanceof DirectoryEntry) {
                DirectoryEntry directoryEntry2 = (DirectoryEntry) next;
                File file2 = new File(file, next.getName());
                if (!file2.exists() && !file2.mkdirs()) {
                    throw new IOException(a.k(file2, "Could not create directory "));
                }
                dump(directoryEntry2, file2);
            } else {
                System.err.println("Skipping unsupported POIFS entry: " + next);
            }
        }
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length == 0) {
            System.err.println("Must specify at least one file to dump");
            System.exit(1);
        }
        boolean z6 = false;
        boolean z7 = false;
        for (String str : strArr) {
            if (str.equalsIgnoreCase("-dumprops") || str.equalsIgnoreCase("-dump-props") || str.equalsIgnoreCase("-dump-properties")) {
                z6 = true;
            } else if (str.equalsIgnoreCase("-dumpmini") || str.equalsIgnoreCase("-dump-mini") || str.equalsIgnoreCase("-dump-ministream") || str.equalsIgnoreCase("-dump-mini-stream")) {
                z7 = true;
            } else {
                System.out.println("Dumping ".concat(str));
                FileInputStream fileInputStream = new FileInputStream(str);
                try {
                    POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(fileInputStream);
                    try {
                        DirectoryNode root = pOIFSFileSystem.getRoot();
                        File file = new File(new File(new File(str).getName() + "_dump"), root.getName());
                        if (!file.exists() && !file.mkdirs()) {
                            throw new IOException("Could not create directory " + file);
                        }
                        dump(root, file);
                        if (z6) {
                            dump(pOIFSFileSystem, pOIFSFileSystem.getHeaderBlock().getPropertyStart(), "properties", file);
                        }
                        if (z7) {
                            int startBlock = pOIFSFileSystem.getPropertyTable().getRoot().getStartBlock();
                            if (startBlock == -2) {
                                System.err.println("No Mini Stream in file");
                            } else {
                                dump(pOIFSFileSystem, startBlock, "mini-stream", file);
                            }
                        }
                        pOIFSFileSystem.close();
                        fileInputStream.close();
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
                            fileInputStream.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
            }
        }
    }

    public static void dump(POIFSFileSystem pOIFSFileSystem, int i5, String str, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str));
        try {
            POIFSStream pOIFSStream = new POIFSStream(pOIFSFileSystem, i5);
            byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(pOIFSFileSystem.getBigBlockSize(), POIFSFileSystem.getMaxRecordLength());
            for (ByteBuffer byteBuffer : pOIFSStream) {
                int iRemaining = byteBuffer.remaining();
                byteBuffer.get(bArrSafelyAllocate);
                fileOutputStream.write(bArrSafelyAllocate, 0, iRemaining);
            }
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
