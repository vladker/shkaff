package org.apache.commons.compress.harmony.pack200;

import A3.AbstractC0157z;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.zip.GZIPOutputStream;
import kotlinx.serialization.json.internal.AbstractC1125a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Archive {
    private long currentSegmentSize;
    private JarFile jarFile;
    private final JarInputStream jarInputStream;
    private final PackingOptions options;
    private final OutputStream outputStream;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SegmentUnit {
        private final List classList;
        private final List fileList;
        private int byteAmount = 0;
        private int packedByteAmount = 0;

        public SegmentUnit(List list, List list2) {
            this.classList = list;
            this.fileList = list2;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.byteAmount += ((Pack200ClassReader) it.next()).b.length;
            }
            Iterator it2 = this.fileList.iterator();
            while (it2.hasNext()) {
                this.byteAmount += ((PackingFile) it2.next()).contents.length;
            }
        }

        public void addPackedByteAmount(int i5) {
            this.packedByteAmount += i5;
        }

        public int classListSize() {
            return this.classList.size();
        }

        public int fileListSize() {
            return this.fileList.size();
        }

        public int getByteAmount() {
            return this.byteAmount;
        }

        public List getClassList() {
            return this.classList;
        }

        public List getFileList() {
            return this.fileList;
        }

        public int getPackedByteAmount() {
            return this.packedByteAmount;
        }
    }

    public Archive(JarInputStream jarInputStream, OutputStream outputStream, PackingOptions packingOptions) {
        this.jarInputStream = jarInputStream;
        packingOptions = packingOptions == null ? new PackingOptions() : packingOptions;
        this.options = packingOptions;
        this.outputStream = new BufferedOutputStream(packingOptions.isGzip() ? new GZIPOutputStream(outputStream) : outputStream);
        PackingUtils.config(packingOptions);
    }

    private boolean addJarEntry(PackingFile packingFile, List list, List list2) {
        long segmentLimit = this.options.getSegmentLimit();
        if (segmentLimit != -1 && segmentLimit != 0) {
            long jEstimateSize = estimateSize(packingFile);
            long j6 = this.currentSegmentSize;
            if (jEstimateSize + j6 > segmentLimit && j6 > 0) {
                return false;
            }
            this.currentSegmentSize = j6 + jEstimateSize;
        }
        String name = packingFile.getName();
        if (name.endsWith(".class") && !this.options.isPassFile(name)) {
            Pack200ClassReader pack200ClassReader = new Pack200ClassReader(packingFile.contents);
            pack200ClassReader.setFileName(name);
            list.add(pack200ClassReader);
            packingFile.contents = new byte[0];
        }
        list2.add(packingFile);
        return true;
    }

    private void doNormalPack() throws Pack200Exception, IOException {
        PackingUtils.log("Start to perform a normal packing");
        JarInputStream jarInputStream = this.jarInputStream;
        List packingFileListFromJar = jarInputStream != null ? PackingUtils.getPackingFileListFromJar(jarInputStream, this.options.isKeepFileOrder()) : PackingUtils.getPackingFileListFromJar(this.jarFile, this.options.isKeepFileOrder());
        List listSplitIntoSegments = splitIntoSegments(packingFileListFromJar);
        int size = listSplitIntoSegments.size();
        int byteAmount = 0;
        int packedByteAmount = 0;
        for (int i5 = 0; i5 < size; i5++) {
            SegmentUnit segmentUnit = (SegmentUnit) listSplitIntoSegments.get(i5);
            new Segment().pack(segmentUnit, this.outputStream, this.options);
            byteAmount += segmentUnit.getByteAmount();
            packedByteAmount += segmentUnit.getPackedByteAmount();
        }
        StringBuilder sbT = AbstractC0157z.t(byteAmount, "Total: Packed ", " input bytes of ");
        sbT.append(packingFileListFromJar.size());
        sbT.append(" files into ");
        sbT.append(packedByteAmount);
        sbT.append(" bytes in ");
        AbstractC1125a.m(" segments", size, sbT);
        this.outputStream.close();
    }

    private void doZeroEffortPack() throws IOException {
        PackingUtils.log("Start to perform a zero-effort packing");
        JarInputStream jarInputStream = this.jarInputStream;
        if (jarInputStream != null) {
            PackingUtils.copyThroughJar(jarInputStream, this.outputStream);
        } else {
            PackingUtils.copyThroughJar(this.jarFile, this.outputStream);
        }
    }

    private long estimateSize(PackingFile packingFile) {
        String name = packingFile.getName();
        if (name.startsWith("META-INF") || name.startsWith("/META-INF")) {
            return 0L;
        }
        long length = packingFile.contents.length;
        return ((long) name.length()) + (length >= 0 ? length : 0L) + 5;
    }

    private List splitIntoSegments(List list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        long segmentLimit = this.options.getSegmentLimit();
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            PackingFile packingFile = (PackingFile) list.get(i5);
            if (!addJarEntry(packingFile, arrayList2, arrayList3)) {
                arrayList.add(new SegmentUnit(arrayList2, arrayList3));
                arrayList2 = new ArrayList();
                arrayList3 = new ArrayList();
                this.currentSegmentSize = 0L;
                addJarEntry(packingFile, arrayList2, arrayList3);
                this.currentSegmentSize = 0L;
            } else if (segmentLimit == 0 && estimateSize(packingFile) > 0) {
                arrayList.add(new SegmentUnit(arrayList2, arrayList3));
                arrayList2 = new ArrayList();
                arrayList3 = new ArrayList();
            }
        }
        if (arrayList2.size() <= 0 && arrayList3.size() <= 0) {
            return arrayList;
        }
        arrayList.add(new SegmentUnit(arrayList2, arrayList3));
        return arrayList;
    }

    public void pack() throws Pack200Exception, IOException {
        if (this.options.getEffort() == 0) {
            doZeroEffortPack();
        } else {
            doNormalPack();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PackingFile {
        private byte[] contents;
        private final boolean deflateHint;
        private final boolean isDirectory;
        private final long modtime;
        private final String name;

        public PackingFile(String str, byte[] bArr, long j6) {
            this.name = str;
            this.contents = bArr;
            this.modtime = j6;
            this.deflateHint = false;
            this.isDirectory = false;
        }

        public byte[] getContents() {
            return this.contents;
        }

        public long getModtime() {
            return this.modtime;
        }

        public String getName() {
            return this.name;
        }

        public boolean isDefalteHint() {
            return this.deflateHint;
        }

        public boolean isDirectory() {
            return this.isDirectory;
        }

        public void setContents(byte[] bArr) {
            this.contents = bArr;
        }

        public String toString() {
            return this.name;
        }

        public PackingFile(byte[] bArr, JarEntry jarEntry) {
            this.name = jarEntry.getName();
            this.contents = bArr;
            this.modtime = jarEntry.getTime();
            this.deflateHint = jarEntry.getMethod() == 8;
            this.isDirectory = jarEntry.isDirectory();
        }
    }

    public Archive(JarFile jarFile, OutputStream outputStream, PackingOptions packingOptions) {
        packingOptions = packingOptions == null ? new PackingOptions() : packingOptions;
        this.options = packingOptions;
        this.outputStream = new BufferedOutputStream(packingOptions.isGzip() ? new GZIPOutputStream(outputStream) : outputStream);
        this.jarFile = jarFile;
        this.jarInputStream = null;
        PackingUtils.config(packingOptions);
    }
}
