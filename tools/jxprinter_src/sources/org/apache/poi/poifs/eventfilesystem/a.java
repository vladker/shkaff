package org.apache.poi.poifs.eventfilesystem;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements POIFSReaderListener {
    @Override // org.apache.poi.poifs.eventfilesystem.POIFSReaderListener
    public final void processPOIFSReaderEvent(POIFSReaderEvent pOIFSReaderEvent) {
        POIFSReader.readEntry(pOIFSReaderEvent);
    }
}
