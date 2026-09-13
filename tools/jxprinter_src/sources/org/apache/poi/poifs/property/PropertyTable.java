package org.apache.poi.poifs.property;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.filesystem.BATManaged;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.poifs.filesystem.POIFSStream;
import org.apache.poi.poifs.storage.HeaderBlock;
import org.apache.poi.util.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class PropertyTable implements BATManaged {
    private static final Logger LOG = LogManager.getLogger((Class<?>) PropertyTable.class);
    private final POIFSBigBlockSize _bigBigBlockSize;
    private final HeaderBlock _header_block;
    private final List<Property> _properties;

    public PropertyTable(HeaderBlock headerBlock) {
        this._properties = new ArrayList();
        this._header_block = headerBlock;
        this._bigBigBlockSize = headerBlock.getBigBlockSize();
        addProperty(new RootProperty());
    }

    private boolean isValidIndex(int i5) {
        if (!Property.isValidIndex(i5)) {
            return false;
        }
        if (i5 >= 0 && i5 < this._properties.size()) {
            return true;
        }
        LOG.atWarn().log("Property index {} outside the valid range 0..{}", Unbox.box(i5), Unbox.box(this._properties.size()));
        return false;
    }

    private void populatePropertyTree(DirectoryProperty directoryProperty) {
        int childIndex = directoryProperty.getChildIndex();
        if (Property.isValidIndex(childIndex)) {
            Stack stack = new Stack();
            stack.push(this._properties.get(childIndex));
            while (!stack.empty()) {
                Property property = (Property) stack.pop();
                if (property != null) {
                    directoryProperty.addChild(property);
                    if (property.isDirectory()) {
                        populatePropertyTree((DirectoryProperty) property);
                    }
                    int previousChildIndex = property.getPreviousChildIndex();
                    if (isValidIndex(previousChildIndex)) {
                        stack.push(this._properties.get(previousChildIndex));
                    }
                    int nextChildIndex = property.getNextChildIndex();
                    if (isValidIndex(nextChildIndex)) {
                        stack.push(this._properties.get(nextChildIndex));
                    }
                }
            }
        }
    }

    public void addProperty(Property property) {
        this._properties.add(property);
    }

    @Override // org.apache.poi.poifs.filesystem.BATManaged
    public int countBlocks() {
        long size = ((long) this._properties.size()) * 128;
        long bigBlockSize = this._bigBigBlockSize.getBigBlockSize();
        int i5 = (int) (size / bigBlockSize);
        return size % bigBlockSize != 0 ? i5 + 1 : i5;
    }

    public RootProperty getRoot() {
        return (RootProperty) this._properties.get(0);
    }

    public int getStartBlock() {
        return this._header_block.getPropertyStart();
    }

    public void preWrite() {
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        int i6 = 0;
        for (Property property : this._properties) {
            if (property != null) {
                property.setIndex(i6);
                arrayList.add(property);
                i6++;
            }
        }
        int size = arrayList.size();
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            ((Property) obj).preWrite();
        }
    }

    public void removeProperty(Property property) {
        this._properties.remove(property);
    }

    @Override // org.apache.poi.poifs.filesystem.BATManaged
    public void setStartBlock(int i5) {
        this._header_block.setPropertyStart(i5);
    }

    public void write(POIFSStream pOIFSStream) {
        OutputStream outputStream = pOIFSStream.getOutputStream();
        for (Property property : this._properties) {
            if (property != null) {
                property.writeData(outputStream);
            }
        }
        outputStream.close();
        if (getStartBlock() != pOIFSStream.getStartBlock()) {
            setStartBlock(pOIFSStream.getStartBlock());
        }
    }

    public PropertyTable(HeaderBlock headerBlock, POIFSFileSystem pOIFSFileSystem) {
        this(headerBlock, new POIFSStream(pOIFSFileSystem, headerBlock.getPropertyStart()));
    }

    public PropertyTable(HeaderBlock headerBlock, Iterable<ByteBuffer> iterable) {
        byte[] bArrArray;
        this._properties = new ArrayList();
        this._header_block = headerBlock;
        this._bigBigBlockSize = headerBlock.getBigBlockSize();
        for (ByteBuffer byteBuffer : iterable) {
            if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0 && byteBuffer.array().length == this._bigBigBlockSize.getBigBlockSize()) {
                bArrArray = byteBuffer.array();
            } else {
                byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(this._bigBigBlockSize.getBigBlockSize(), POIFSFileSystem.getMaxRecordLength());
                int length = bArrSafelyAllocate.length;
                if (byteBuffer.remaining() < this._bigBigBlockSize.getBigBlockSize()) {
                    LOG.atWarn().log("Short Property Block, {} bytes instead of the expected {}", Unbox.box(byteBuffer.remaining()), Unbox.box(this._bigBigBlockSize.getBigBlockSize()));
                    length = byteBuffer.remaining();
                }
                byteBuffer.get(bArrSafelyAllocate, 0, length);
                bArrArray = bArrSafelyAllocate;
            }
            PropertyFactory.convertToProperties(bArrArray, this._properties);
        }
        if (this._properties.get(0) != null) {
            populatePropertyTree((DirectoryProperty) this._properties.get(0));
        }
    }
}
