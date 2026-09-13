package org.apache.poi.poifs.filesystem;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;
import org.apache.poi.hpsf.ClassID;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface DirectoryEntry extends Entry, Iterable<Entry> {
    DirectoryEntry createDirectory(String str);

    DocumentEntry createDocument(String str, int i5, POIFSWriterListener pOIFSWriterListener);

    DocumentEntry createDocument(String str, InputStream inputStream);

    Iterator<Entry> getEntries();

    Entry getEntry(String str);

    int getEntryCount();

    Set<String> getEntryNames();

    ClassID getStorageClsid();

    boolean hasEntry(String str);

    boolean isEmpty();

    void setStorageClsid(ClassID classID);
}
