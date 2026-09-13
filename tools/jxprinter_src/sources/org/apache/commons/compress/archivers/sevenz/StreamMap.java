package org.apache.commons.compress.archivers.sevenz;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class StreamMap {
    int[] fileFolderIndex;
    int[] folderFirstFileIndex;
    int[] folderFirstPackStreamIndex;
    long[] packStreamOffsets;

    public String toString() {
        StringBuilder sb = new StringBuilder("StreamMap with indices of ");
        sb.append(this.folderFirstPackStreamIndex.length);
        sb.append(" folders, offsets of ");
        sb.append(this.packStreamOffsets.length);
        sb.append(" packed streams, first files of ");
        sb.append(this.folderFirstFileIndex.length);
        sb.append(" folders and folder indices for ");
        return AbstractC0157z.l(" files", this.fileFolderIndex.length, sb);
    }
}
