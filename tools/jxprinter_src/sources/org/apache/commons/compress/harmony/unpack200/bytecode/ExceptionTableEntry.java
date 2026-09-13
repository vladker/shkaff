package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ExceptionTableEntry {
    private final CPClass catchType;
    private int catchTypeIndex;
    private final int endPC;
    private int endPcRenumbered;
    private final int handlerPC;
    private int handlerPcRenumbered;
    private final int startPC;
    private int startPcRenumbered;

    public ExceptionTableEntry(int i5, int i6, int i7, CPClass cPClass) {
        this.startPC = i5;
        this.endPC = i6;
        this.handlerPC = i7;
        this.catchType = cPClass;
    }

    public CPClass getCatchType() {
        return this.catchType;
    }

    public void renumber(List list) {
        this.startPcRenumbered = ((Integer) list.get(this.startPC)).intValue();
        int i5 = this.startPC + this.endPC;
        this.endPcRenumbered = ((Integer) list.get(i5)).intValue();
        this.handlerPcRenumbered = ((Integer) list.get(i5 + this.handlerPC)).intValue();
    }

    public void resolve(ClassConstantPool classConstantPool) {
        CPClass cPClass = this.catchType;
        if (cPClass == null) {
            this.catchTypeIndex = 0;
        } else {
            cPClass.resolve(classConstantPool);
            this.catchTypeIndex = classConstantPool.indexOf(this.catchType);
        }
    }

    public void write(DataOutputStream dataOutputStream) {
        dataOutputStream.writeShort(this.startPcRenumbered);
        dataOutputStream.writeShort(this.endPcRenumbered);
        dataOutputStream.writeShort(this.handlerPcRenumbered);
        dataOutputStream.writeShort(this.catchTypeIndex);
    }
}
