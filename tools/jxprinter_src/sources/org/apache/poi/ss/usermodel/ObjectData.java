package org.apache.poi.ss.usermodel;

import org.apache.poi.poifs.filesystem.DirectoryEntry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ObjectData extends SimpleShape {
    default String getContentType() {
        return "binary/octet-stream";
    }

    DirectoryEntry getDirectory();

    String getFileName();

    String getOLE2ClassName();

    byte[] getObjectData();

    PictureData getPictureData();

    boolean hasDirectoryEntry();
}
