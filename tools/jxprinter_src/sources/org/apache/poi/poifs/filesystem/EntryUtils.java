package org.apache.poi.poifs.filesystem;

import java.io.EOFException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.apache.poi.hpsf.NoPropertySetStreamException;
import org.apache.poi.hpsf.PropertySet;
import org.apache.poi.hpsf.PropertySetFactory;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class EntryUtils {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DirectoryDelegate implements POIDelegate {
        final DirectoryEntry dir;

        public DirectoryDelegate(DirectoryEntry directoryEntry) {
            this.dir = directoryEntry;
        }

        private Map<String, POIDelegate> entries() {
            final int i5 = 1;
            final int i6 = 0;
            return (Map) StreamSupport.stream(this.dir.spliterator(), false).collect(Collectors.toMap(new Function() { // from class: org.apache.poi.poifs.filesystem.a
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Entry entry = (Entry) obj;
                    switch (i5) {
                        case 0:
                            return EntryUtils.DirectoryDelegate.toDelegate(entry);
                        default:
                            return entry.getName();
                    }
                }
            }, new Function() { // from class: org.apache.poi.poifs.filesystem.a
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Entry entry = (Entry) obj;
                    switch (i6) {
                        case 0:
                            return EntryUtils.DirectoryDelegate.toDelegate(entry);
                        default:
                            return entry.getName();
                    }
                }
            }));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static POIDelegate toDelegate(Entry entry) {
            return entry.isDirectoryEntry() ? new DirectoryDelegate((DirectoryEntry) entry) : new DocumentDelegate((DocumentEntry) entry);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof DirectoryDelegate)) {
                return false;
            }
            DirectoryDelegate directoryDelegate = (DirectoryDelegate) obj;
            if (this == directoryDelegate) {
                return true;
            }
            if (Objects.equals(this.dir.getName(), directoryDelegate.dir.getName()) && this.dir.getEntryCount() == directoryDelegate.dir.getEntryCount() && this.dir.getStorageClsid().equals(directoryDelegate.dir.getStorageClsid())) {
                return entries().equals(directoryDelegate.entries());
            }
            return false;
        }

        public int hashCode() {
            return this.dir.getName().hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DocumentDelegate implements POIDelegate {
        final DocumentEntry doc;

        public DocumentDelegate(DocumentEntry documentEntry) {
            this.doc = documentEntry;
        }

        private static boolean isEqual(DocumentInputStream documentInputStream, DocumentInputStream documentInputStream2) {
            byte[] bArr = new byte[4096];
            byte[] bArr2 = new byte[4096];
            while (true) {
                try {
                    int i5 = documentInputStream.read(bArr);
                    if (i5 > 0) {
                        documentInputStream2.readFully(bArr2, 0, i5);
                        for (int i6 = 0; i6 < i5; i6++) {
                            if (bArr[i6] != bArr2[i6]) {
                                return false;
                            }
                        }
                    } else if (documentInputStream2.read() < 0) {
                        return true;
                    }
                } catch (EOFException | RuntimeException unused) {
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof DocumentDelegate)) {
                return false;
            }
            DocumentDelegate documentDelegate = (DocumentDelegate) obj;
            if (this == documentDelegate) {
                return true;
            }
            if (!Objects.equals(this.doc.getName(), documentDelegate.doc.getName())) {
                return false;
            }
            try {
                DocumentInputStream documentInputStream = new DocumentInputStream(this.doc);
                try {
                    DocumentInputStream documentInputStream2 = new DocumentInputStream(documentDelegate.doc);
                    try {
                        boolean zEquals = (PropertySet.isPropertySetStream(documentInputStream) && PropertySet.isPropertySetStream(documentInputStream2)) ? PropertySetFactory.create(documentInputStream).equals(PropertySetFactory.create(documentInputStream2)) : isEqual(documentInputStream, documentInputStream2);
                        documentInputStream2.close();
                        documentInputStream.close();
                        return zEquals;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                documentInputStream2.close();
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
                            documentInputStream.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
            } catch (IOException | NoPropertySetStreamException e) {
                throw new RuntimeException(e);
            }
        }

        public int hashCode() {
            return this.doc.getName().hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface POIDelegate {
    }

    private EntryUtils() {
    }

    public static boolean areDirectoriesIdentical(DirectoryEntry directoryEntry, DirectoryEntry directoryEntry2) {
        return new DirectoryDelegate(directoryEntry).equals(new DirectoryDelegate(directoryEntry2));
    }

    public static boolean areDocumentsIdentical(DocumentEntry documentEntry, DocumentEntry documentEntry2) throws IOException {
        try {
            return new DocumentDelegate(documentEntry).equals(new DocumentDelegate(documentEntry2));
        } catch (RuntimeException e) {
            if (e.getCause() instanceof IOException) {
                throw ((IOException) e.getCause());
            }
            throw e;
        }
    }

    @Internal
    public static void copyNodeRecursively(Entry entry, DirectoryEntry directoryEntry) {
        if (!entry.isDirectoryEntry()) {
            DocumentEntry documentEntry = (DocumentEntry) entry;
            DocumentInputStream documentInputStream = new DocumentInputStream(documentEntry);
            directoryEntry.createDocument(documentEntry.getName(), documentInputStream);
            documentInputStream.close();
            return;
        }
        DirectoryEntry directoryEntry2 = (DirectoryEntry) entry;
        DirectoryEntry directoryEntryCreateDirectory = directoryEntry.createDirectory(entry.getName());
        directoryEntryCreateDirectory.setStorageClsid(directoryEntry2.getStorageClsid());
        Iterator<Entry> entries = directoryEntry2.getEntries();
        while (entries.hasNext()) {
            copyNodeRecursively(entries.next(), directoryEntryCreateDirectory);
        }
    }

    public static void copyNodes(DirectoryEntry directoryEntry, DirectoryEntry directoryEntry2) {
        Iterator<Entry> it = directoryEntry.iterator();
        while (it.hasNext()) {
            copyNodeRecursively(it.next(), directoryEntry2);
        }
    }

    public static void copyNodes(POIFSFileSystem pOIFSFileSystem, POIFSFileSystem pOIFSFileSystem2) {
        copyNodes(pOIFSFileSystem.getRoot(), pOIFSFileSystem2.getRoot());
    }

    public static void copyNodes(POIFSFileSystem pOIFSFileSystem, POIFSFileSystem pOIFSFileSystem2, List<String> list) {
        copyNodes(new FilteringDirectoryNode(pOIFSFileSystem.getRoot(), list), new FilteringDirectoryNode(pOIFSFileSystem2.getRoot(), list));
    }
}
