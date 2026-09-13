package org.apache.poi.poifs.filesystem;

import A3.AbstractC0157z;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.poifs.dev.POIFSViewable;
import org.apache.poi.poifs.property.DirectoryProperty;
import org.apache.poi.poifs.property.DocumentProperty;
import org.apache.poi.poifs.property.Property;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DirectoryNode extends EntryNode implements DirectoryEntry, POIFSViewable, Iterable<Entry> {
    private final Map<String, Entry> _byname;
    private final ArrayList<Entry> _entries;
    private final POIFSFileSystem _filesystem;
    private final POIFSDocumentPath _path;

    public DirectoryNode(DirectoryProperty directoryProperty, POIFSFileSystem pOIFSFileSystem, DirectoryNode directoryNode) {
        super(directoryProperty, directoryNode);
        this._byname = new HashMap();
        this._entries = new ArrayList<>();
        this._filesystem = pOIFSFileSystem;
        if (directoryNode == null) {
            this._path = new POIFSDocumentPath();
        } else {
            this._path = new POIFSDocumentPath(directoryNode._path, new String[]{directoryProperty.getName()});
        }
        Iterator<Property> children = directoryProperty.getChildren();
        while (children.hasNext()) {
            Property next = children.next();
            Entry directoryNode2 = next.isDirectory() ? new DirectoryNode((DirectoryProperty) next, this._filesystem, this) : new DocumentNode((DocumentProperty) next, this);
            this._entries.add(directoryNode2);
            this._byname.put(directoryNode2.getName(), directoryNode2);
        }
    }

    public boolean changeName(String str, String str2) {
        EntryNode entryNode = (EntryNode) this._byname.get(str);
        if (entryNode == null) {
            return false;
        }
        boolean zChangeName = ((DirectoryProperty) getProperty()).changeName(entryNode.getProperty(), str2);
        if (zChangeName) {
            this._byname.remove(str);
            this._byname.put(entryNode.getProperty().getName(), entryNode);
        }
        return zChangeName;
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public DirectoryEntry createDirectory(String str) {
        DirectoryProperty directoryProperty = new DirectoryProperty(str);
        DirectoryNode directoryNode = new DirectoryNode(directoryProperty, this._filesystem, this);
        this._filesystem.addDirectory(directoryProperty);
        ((DirectoryProperty) getProperty()).addChild(directoryProperty);
        this._entries.add(directoryNode);
        this._byname.put(str, directoryNode);
        return directoryNode;
    }

    public DocumentEntry createDocument(POIFSDocument pOIFSDocument) {
        DocumentProperty documentProperty = pOIFSDocument.getDocumentProperty();
        DocumentNode documentNode = new DocumentNode(documentProperty, this);
        ((DirectoryProperty) getProperty()).addChild(documentProperty);
        this._filesystem.addDocument(pOIFSDocument);
        this._entries.add(documentNode);
        this._byname.put(documentProperty.getName(), documentNode);
        return documentNode;
    }

    public DocumentInputStream createDocumentInputStream(String str) {
        return createDocumentInputStream(getEntry(str));
    }

    public DocumentEntry createOrUpdateDocument(String str, InputStream inputStream) {
        if (!hasEntry(str)) {
            return createDocument(str, inputStream);
        }
        DocumentNode documentNode = (DocumentNode) getEntry(str);
        new POIFSDocument(documentNode).replaceContents(inputStream);
        return documentNode;
    }

    public boolean deleteEntry(EntryNode entryNode) {
        boolean zDeleteChild = ((DirectoryProperty) getProperty()).deleteChild(entryNode.getProperty());
        if (!zDeleteChild) {
            return zDeleteChild;
        }
        this._entries.remove(entryNode);
        this._byname.remove(entryNode.getName());
        try {
            this._filesystem.remove(entryNode);
            return zDeleteChild;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public Iterator<Entry> getEntries() {
        return this._entries.iterator();
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public Entry getEntry(String str) throws FileNotFoundException {
        Entry entry = str != null ? this._byname.get(str) : null;
        if (entry != null) {
            return entry;
        }
        if (this._byname.containsKey("Workbook")) {
            throw new IllegalArgumentException("The document is really a XLS file");
        }
        if (this._byname.containsKey("PowerPoint Document")) {
            throw new IllegalArgumentException("The document is really a PPT file");
        }
        if (this._byname.containsKey("VisioDocument")) {
            throw new IllegalArgumentException("The document is really a VSD file");
        }
        StringBuilder sbY = AbstractC0157z.y("no such entry: \"", str, "\", had: ");
        sbY.append(this._byname.keySet());
        throw new FileNotFoundException(sbY.toString());
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public int getEntryCount() {
        return this._entries.size();
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public Set<String> getEntryNames() {
        return this._byname.keySet();
    }

    public POIFSFileSystem getFileSystem() {
        return this._filesystem;
    }

    public POIFSDocumentPath getPath() {
        return this._path;
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public String getShortDescription() {
        return getName();
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public ClassID getStorageClsid() {
        return getProperty().getStorageClsid();
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Object[] getViewableArray() {
        return new Object[0];
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Iterator<Object> getViewableIterator() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getProperty());
        arrayList.addAll(this._entries);
        return arrayList.iterator();
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public boolean hasEntry(String str) {
        return str != null && this._byname.containsKey(str);
    }

    @Override // org.apache.poi.poifs.filesystem.EntryNode
    public boolean isDeleteOK() {
        return isEmpty();
    }

    @Override // org.apache.poi.poifs.filesystem.EntryNode, org.apache.poi.poifs.filesystem.Entry
    public boolean isDirectoryEntry() {
        return true;
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public boolean isEmpty() {
        return this._entries.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<Entry> iterator() {
        return getEntries();
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public boolean preferArray() {
        return false;
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public void setStorageClsid(ClassID classID) {
        getProperty().setStorageClsid(classID);
    }

    @Override // java.lang.Iterable
    public Spliterator<Entry> spliterator() {
        return this._entries.spliterator();
    }

    public DocumentInputStream createDocumentInputStream(Entry entry) throws IOException {
        if (entry.isDocumentEntry()) {
            return new DocumentInputStream((DocumentEntry) entry);
        }
        throw new IOException("Entry '" + entry.getName() + "' is not a DocumentEntry");
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public DocumentEntry createDocument(String str, InputStream inputStream) {
        return createDocument(new POIFSDocument(str, this._filesystem, inputStream));
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public DocumentEntry createDocument(String str, int i5, POIFSWriterListener pOIFSWriterListener) {
        return createDocument(new POIFSDocument(str, i5, this._filesystem, pOIFSWriterListener));
    }
}
