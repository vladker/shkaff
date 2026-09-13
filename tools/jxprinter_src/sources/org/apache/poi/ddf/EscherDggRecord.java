package org.apache.poi.ddf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class EscherDggRecord extends EscherRecord {
    public static final short RECORD_ID = EscherRecordTypes.DGG.typeID;
    private int field_1_shapeIdMax;
    private int field_3_numShapesSaved;
    private int field_4_drawingsSaved;
    private final List<FileIdCluster> field_5_fileIdClusters;
    private int maxDgId;

    public EscherDggRecord() {
        this.field_5_fileIdClusters = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return super.getGenericProperties();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$2() {
        return this.field_5_fileIdClusters;
    }

    private void sortCluster() {
        this.field_5_fileIdClusters.sort(new I4.a(24));
    }

    public FileIdCluster addCluster(int i5, int i6) {
        return addCluster(i5, i6, true);
    }

    public int allocateShapeId(EscherDgRecord escherDgRecord, boolean z6) {
        FileIdCluster fileIdClusterAddCluster;
        short drawingGroupId = escherDgRecord.getDrawingGroupId();
        this.field_3_numShapesSaved++;
        Iterator<FileIdCluster> it = this.field_5_fileIdClusters.iterator();
        int i5 = 1;
        while (true) {
            if (!it.hasNext()) {
                fileIdClusterAddCluster = null;
                break;
            }
            fileIdClusterAddCluster = it.next();
            if (fileIdClusterAddCluster.getDrawingGroupId() == drawingGroupId && fileIdClusterAddCluster.getNumShapeIdsUsed() < 1024) {
                break;
            }
            i5++;
        }
        if (fileIdClusterAddCluster == null) {
            fileIdClusterAddCluster = addCluster(drawingGroupId, 0, z6);
            this.maxDgId = Math.max(this.maxDgId, (int) drawingGroupId);
        }
        int numShapeIdsUsed = fileIdClusterAddCluster.getNumShapeIdsUsed() + (i5 * 1024);
        fileIdClusterAddCluster.incrementUsedShapeId();
        escherDgRecord.setNumShapes(escherDgRecord.getNumShapes() + 1);
        escherDgRecord.setLastMSOSPID(numShapeIdsUsed);
        this.field_1_shapeIdMax = Math.max(this.field_1_shapeIdMax, numShapeIdsUsed + 1);
        return numShapeIdsUsed;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i5, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i5);
        int i6 = i5 + 8;
        this.field_1_shapeIdMax = LittleEndian.getInt(bArr, i6);
        this.field_3_numShapesSaved = LittleEndian.getInt(bArr, i5 + 16);
        this.field_4_drawingsSaved = LittleEndian.getInt(bArr, i5 + 20);
        this.field_5_fileIdClusters.clear();
        int i7 = (header - 16) / 8;
        int i8 = 16;
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = i6 + i8;
            int i11 = LittleEndian.getInt(bArr, i10);
            this.field_5_fileIdClusters.add(new FileIdCluster(i11, LittleEndian.getInt(bArr, i10 + 4)));
            this.maxDgId = Math.max(this.maxDgId, i11);
            i8 += 8;
        }
        int i12 = header - i8;
        if (i12 == 0) {
            return i8 + 8;
        }
        throw new RecordFormatException(androidx.collection.a.i(i12, "Expecting no remaining data but got ", " byte(s)."));
    }

    public short findNewDrawingGroupId() {
        V2.f fVar = new V2.f();
        fVar.j(0);
        Iterator<FileIdCluster> it = this.field_5_fileIdClusters.iterator();
        while (it.hasNext()) {
            fVar.j(it.next().getDrawingGroupId());
        }
        return (short) fVar.g(0);
    }

    public int getDrawingsSaved() {
        return this.field_4_drawingsSaved;
    }

    public FileIdCluster[] getFileIdClusters() {
        return (FileIdCluster[]) this.field_5_fileIdClusters.toArray(new FileIdCluster[0]);
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ddf.o
            public final /* synthetic */ EscherDggRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return this.b.lambda$getGenericProperties$2();
                    case 2:
                        return Integer.valueOf(this.b.getShapeIdMax());
                    case 3:
                        return Integer.valueOf(this.b.getNumIdClusters());
                    case 4:
                        return Integer.valueOf(this.b.getNumShapesSaved());
                    default:
                        return Integer.valueOf(this.b.getDrawingsSaved());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ddf.o
            public final /* synthetic */ EscherDggRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return this.b.lambda$getGenericProperties$2();
                    case 2:
                        return Integer.valueOf(this.b.getShapeIdMax());
                    case 3:
                        return Integer.valueOf(this.b.getNumIdClusters());
                    case 4:
                        return Integer.valueOf(this.b.getNumShapesSaved());
                    default:
                        return Integer.valueOf(this.b.getDrawingsSaved());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.ddf.o
            public final /* synthetic */ EscherDggRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return this.b.lambda$getGenericProperties$2();
                    case 2:
                        return Integer.valueOf(this.b.getShapeIdMax());
                    case 3:
                        return Integer.valueOf(this.b.getNumIdClusters());
                    case 4:
                        return Integer.valueOf(this.b.getNumShapesSaved());
                    default:
                        return Integer.valueOf(this.b.getDrawingsSaved());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.ddf.o
            public final /* synthetic */ EscherDggRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return this.b.lambda$getGenericProperties$2();
                    case 2:
                        return Integer.valueOf(this.b.getShapeIdMax());
                    case 3:
                        return Integer.valueOf(this.b.getNumIdClusters());
                    case 4:
                        return Integer.valueOf(this.b.getNumShapesSaved());
                    default:
                        return Integer.valueOf(this.b.getDrawingsSaved());
                }
            }
        };
        final int i9 = 4;
        Supplier supplier5 = new Supplier(this) { // from class: org.apache.poi.ddf.o
            public final /* synthetic */ EscherDggRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return this.b.lambda$getGenericProperties$2();
                    case 2:
                        return Integer.valueOf(this.b.getShapeIdMax());
                    case 3:
                        return Integer.valueOf(this.b.getNumIdClusters());
                    case 4:
                        return Integer.valueOf(this.b.getNumShapesSaved());
                    default:
                        return Integer.valueOf(this.b.getDrawingsSaved());
                }
            }
        };
        final int i10 = 5;
        return GenericRecordUtil.getGenericProperties("base", supplier, "fileIdClusters", supplier2, "shapeIdMax", supplier3, "numIdClusters", supplier4, "numShapesSaved", supplier5, "drawingsSaved", new Supplier(this) { // from class: org.apache.poi.ddf.o
            public final /* synthetic */ EscherDggRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return this.b.lambda$getGenericProperties$2();
                    case 2:
                        return Integer.valueOf(this.b.getShapeIdMax());
                    case 3:
                        return Integer.valueOf(this.b.getNumIdClusters());
                    case 4:
                        return Integer.valueOf(this.b.getNumShapesSaved());
                    default:
                        return Integer.valueOf(this.b.getDrawingsSaved());
                }
            }
        });
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.DGG;
    }

    public int getMaxDrawingGroupId() {
        return this.maxDgId;
    }

    public int getNumIdClusters() {
        if (this.field_5_fileIdClusters.isEmpty()) {
            return 0;
        }
        return this.field_5_fileIdClusters.size() + 1;
    }

    public int getNumShapesSaved() {
        return this.field_3_numShapesSaved;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return EscherRecordTypes.DGG.recordName;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return (this.field_5_fileIdClusters.size() * 8) + 24;
    }

    public int getShapeIdMax() {
        return this.field_1_shapeIdMax;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i5, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i5, getRecordId(), this);
        LittleEndian.putShort(bArr, i5, getOptions());
        LittleEndian.putShort(bArr, i5 + 2, getRecordId());
        LittleEndian.putInt(bArr, i5 + 4, getRecordSize() - 8);
        LittleEndian.putInt(bArr, i5 + 8, this.field_1_shapeIdMax);
        LittleEndian.putInt(bArr, i5 + 12, getNumIdClusters());
        LittleEndian.putInt(bArr, i5 + 16, this.field_3_numShapesSaved);
        LittleEndian.putInt(bArr, i5 + 20, this.field_4_drawingsSaved);
        int i6 = i5 + 24;
        for (FileIdCluster fileIdCluster : this.field_5_fileIdClusters) {
            LittleEndian.putInt(bArr, i6, fileIdCluster.getDrawingGroupId());
            LittleEndian.putInt(bArr, i6 + 4, fileIdCluster.getNumShapeIdsUsed());
            i6 += 8;
        }
        escherSerializationListener.afterRecordSerialize(i6, getRecordId(), getRecordSize(), this);
        return getRecordSize();
    }

    public void setDrawingsSaved(int i5) {
        this.field_4_drawingsSaved = i5;
    }

    public void setFileIdClusters(FileIdCluster[] fileIdClusterArr) {
        this.field_5_fileIdClusters.clear();
        if (fileIdClusterArr != null) {
            this.field_5_fileIdClusters.addAll(Arrays.asList(fileIdClusterArr));
        }
    }

    public void setNumShapesSaved(int i5) {
        this.field_3_numShapesSaved = i5;
    }

    public void setShapeIdMax(int i5) {
        this.field_1_shapeIdMax = i5;
    }

    public FileIdCluster addCluster(int i5, int i6, boolean z6) {
        FileIdCluster fileIdCluster = new FileIdCluster(i5, i6);
        this.field_5_fileIdClusters.add(fileIdCluster);
        this.maxDgId = Math.min(this.maxDgId, i5);
        if (z6) {
            sortCluster();
        }
        return fileIdCluster;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FileIdCluster implements GenericRecord {
        private int field_1_drawingGroupId;
        private int field_2_numShapeIdsUsed;

        public FileIdCluster(FileIdCluster fileIdCluster) {
            this.field_1_drawingGroupId = fileIdCluster.field_1_drawingGroupId;
            this.field_2_numShapeIdsUsed = fileIdCluster.field_2_numShapeIdsUsed;
        }

        public static /* synthetic */ int access$100(FileIdCluster fileIdCluster, FileIdCluster fileIdCluster2) {
            return compareFileIdCluster(fileIdCluster, fileIdCluster2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int compareFileIdCluster(FileIdCluster fileIdCluster, FileIdCluster fileIdCluster2) {
            int drawingGroupId = fileIdCluster.getDrawingGroupId() - fileIdCluster2.getDrawingGroupId();
            return drawingGroupId != 0 ? drawingGroupId : fileIdCluster2.getNumShapeIdsUsed() - fileIdCluster.getNumShapeIdsUsed();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void incrementUsedShapeId() {
            this.field_2_numShapeIdsUsed++;
        }

        public int getDrawingGroupId() {
            return this.field_1_drawingGroupId;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            final int i5 = 0;
            final int i6 = 1;
            return GenericRecordUtil.getGenericProperties("drawingGroupId", new Supplier(this) { // from class: org.apache.poi.ddf.p
                public final /* synthetic */ EscherDggRecord.FileIdCluster b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    int drawingGroupId;
                    switch (i5) {
                        case 0:
                            drawingGroupId = this.b.getDrawingGroupId();
                            break;
                        default:
                            drawingGroupId = this.b.getNumShapeIdsUsed();
                            break;
                    }
                    return Integer.valueOf(drawingGroupId);
                }
            }, "numShapeIdUsed", new Supplier(this) { // from class: org.apache.poi.ddf.p
                public final /* synthetic */ EscherDggRecord.FileIdCluster b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    int drawingGroupId;
                    switch (i6) {
                        case 0:
                            drawingGroupId = this.b.getDrawingGroupId();
                            break;
                        default:
                            drawingGroupId = this.b.getNumShapeIdsUsed();
                            break;
                    }
                    return Integer.valueOf(drawingGroupId);
                }
            });
        }

        public int getNumShapeIdsUsed() {
            return this.field_2_numShapeIdsUsed;
        }

        public FileIdCluster(int i5, int i6) {
            this.field_1_drawingGroupId = i5;
            this.field_2_numShapeIdsUsed = i6;
        }
    }

    public EscherDggRecord(EscherDggRecord escherDggRecord) {
        super(escherDggRecord);
        ArrayList arrayList = new ArrayList();
        this.field_5_fileIdClusters = arrayList;
        this.field_1_shapeIdMax = escherDggRecord.field_1_shapeIdMax;
        this.field_3_numShapesSaved = escherDggRecord.field_3_numShapesSaved;
        this.field_4_drawingsSaved = escherDggRecord.field_4_drawingsSaved;
        escherDggRecord.field_5_fileIdClusters.stream().map(new com.google.android.material.color.utilities.g(11)).forEach(new l(arrayList, 1));
        this.maxDgId = escherDggRecord.maxDgId;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.Duplicatable
    public EscherDggRecord copy() {
        return new EscherDggRecord(this);
    }
}
