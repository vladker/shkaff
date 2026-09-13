package org.apache.poi.poifs.filesystem;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.fragment.app.FragmentTransaction;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import org.apache.poi.poifs.dev.POIFSViewable;
import org.apache.poi.poifs.property.DocumentProperty;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class POIFSDocument implements POIFSViewable, Iterable<ByteBuffer> {
    private int _block_size;
    private POIFSFileSystem _filesystem;
    private DocumentProperty _property;
    private POIFSStream _stream;

    public POIFSDocument(DocumentNode documentNode) {
        this((DocumentProperty) documentNode.getProperty(), ((DirectoryNode) documentNode.getParent()).getFileSystem());
    }

    private int store(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        bufferedInputStream.mark(4096);
        if (IOUtils.skipFully(bufferedInputStream, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            this._stream = new POIFSStream(this._filesystem.getMiniStore());
            this._block_size = this._filesystem.getMiniStore().getBlockStoreBlockSize();
        } else {
            this._stream = new POIFSStream(this._filesystem);
            this._block_size = this._filesystem.getBlockStoreBlockSize();
        }
        bufferedInputStream.reset();
        OutputStream outputStream = this._stream.getOutputStream();
        try {
            long jCopy = IOUtils.copy(bufferedInputStream, outputStream);
            int i5 = this._block_size;
            int i6 = (int) (jCopy % ((long) i5));
            if (i6 != 0 && i6 != i5) {
                byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(i5 - i6, POIFSFileSystem.getMaxRecordLength());
                Arrays.fill(bArrSafelyAllocate, (byte) -1);
                outputStream.write(bArrSafelyAllocate);
            }
            if (outputStream != null) {
                outputStream.close();
            }
            return Math.toIntExact(jCopy);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public void free() {
        this._stream.free();
        this._property.setStartBlock(-2);
    }

    public Iterator<ByteBuffer> getBlockIterator() {
        return (getSize() > 0 ? this._stream : Collections.EMPTY_LIST).iterator();
    }

    public int getDocumentBlockSize() {
        return this._block_size;
    }

    public DocumentProperty getDocumentProperty() {
        return this._property;
    }

    public POIFSFileSystem getFileSystem() {
        return this._filesystem;
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public String getShortDescription() {
        return "Document: \"" + this._property.getName() + "\" size = " + getSize();
    }

    public int getSize() {
        return this._property.getSize();
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Object[] getViewableArray() {
        String strDump;
        if (getSize() > 0) {
            byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(getSize(), POIFSFileSystem.getMaxRecordLength());
            int i5 = 0;
            for (ByteBuffer byteBuffer : this._stream) {
                int iMin = Math.min(this._block_size, bArrSafelyAllocate.length - i5);
                byteBuffer.get(bArrSafelyAllocate, i5, iMin);
                i5 += iMin;
            }
            strDump = HexDump.dump(bArrSafelyAllocate, 0L, 0);
        } else {
            strDump = "<NO DATA>";
        }
        return new String[]{strDump};
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Iterator<Object> getViewableIterator() {
        return Collections.emptyIterator();
    }

    @Override // java.lang.Iterable
    public Iterator<ByteBuffer> iterator() {
        return getBlockIterator();
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public boolean preferArray() {
        return true;
    }

    public void replaceContents(InputStream inputStream) {
        free();
        int iStore = store(inputStream);
        this._property.setStartBlock(this._stream.getStartBlock());
        this._property.updateSize(iStore);
    }

    public POIFSDocument(DocumentProperty documentProperty, POIFSFileSystem pOIFSFileSystem) {
        this._property = documentProperty;
        this._filesystem = pOIFSFileSystem;
        if (documentProperty.getSize() < 4096) {
            this._stream = new POIFSStream(this._filesystem.getMiniStore(), documentProperty.getStartBlock());
            this._block_size = this._filesystem.getMiniStore().getBlockStoreBlockSize();
        } else {
            this._stream = new POIFSStream(this._filesystem, documentProperty.getStartBlock());
            this._block_size = this._filesystem.getBlockStoreBlockSize();
        }
    }

    public POIFSDocument(String str, POIFSFileSystem pOIFSFileSystem, InputStream inputStream) {
        this._filesystem = pOIFSFileSystem;
        DocumentProperty documentProperty = new DocumentProperty(str, store(inputStream));
        this._property = documentProperty;
        documentProperty.setStartBlock(this._stream.getStartBlock());
        this._property.setDocument(this);
    }

    public POIFSDocument(String str, int i5, POIFSFileSystem pOIFSFileSystem, POIFSWriterListener pOIFSWriterListener) throws IOException {
        this._filesystem = pOIFSFileSystem;
        if (i5 < 4096) {
            this._stream = new POIFSStream(pOIFSFileSystem.getMiniStore());
            this._block_size = this._filesystem.getMiniStore().getBlockStoreBlockSize();
        } else {
            this._stream = new POIFSStream(pOIFSFileSystem);
            this._block_size = this._filesystem.getBlockStoreBlockSize();
        }
        DocumentProperty documentProperty = new DocumentProperty(str, i5);
        this._property = documentProperty;
        documentProperty.setStartBlock(this._stream.getStartBlock());
        this._property.setDocument(this);
        DocumentOutputStream documentOutputStream = new DocumentOutputStream(this, i5);
        try {
            POIFSDocumentPath pOIFSDocumentPath = new POIFSDocumentPath(str.split("\\\\"));
            pOIFSWriterListener.processPOIFSWriterEvent(new POIFSWriterEvent(documentOutputStream, pOIFSDocumentPath, pOIFSDocumentPath.getComponent(pOIFSDocumentPath.length() - 1), i5));
            documentOutputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    documentOutputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
