package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.apache.commons.compress.harmony.unpack200.Segment;
import org.apache.commons.compress.harmony.unpack200.SegmentConstantPool;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class OperandManager {
    int[] bcByte;
    int bcByteIndex;
    int[] bcCaseCount;
    int bcCaseCountIndex;
    int[] bcCaseValue;
    int bcCaseValueIndex;
    int[] bcClassRef;
    int bcClassRefIndex;
    int[] bcDoubleRef;
    int bcDoubleRefIndex;
    int[] bcFieldRef;
    int bcFieldRefIndex;
    int[] bcFloatRef;
    int bcFloatRefIndex;
    int[] bcIMethodRef;
    int bcIMethodRefIndex;
    int[] bcInitRef;
    int bcInitRefIndex;
    int[] bcIntRef;
    int bcIntRefIndex;
    int[] bcLabel;
    int bcLabelIndex;
    int[] bcLocal;
    int bcLocalIndex;
    int[] bcLongRef;
    int bcLongRefIndex;
    int[] bcMethodRef;
    int bcMethodRefIndex;
    int[] bcShort;
    int bcShortIndex;
    int[] bcStringRef;
    int bcStringRefIndex;
    int[] bcSuperField;
    int bcSuperFieldIndex;
    int[] bcSuperMethod;
    int bcSuperMethodIndex;
    int[] bcThisField;
    int bcThisFieldIndex;
    int[] bcThisMethod;
    int bcThisMethodIndex;
    String currentClass;
    String newClass;
    Segment segment;
    String superClass;
    int wideByteCodeIndex;
    int[] wideByteCodes;

    public OperandManager(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, int[] iArr7, int[] iArr8, int[] iArr9, int[] iArr10, int[] iArr11, int[] iArr12, int[] iArr13, int[] iArr14, int[] iArr15, int[] iArr16, int[] iArr17, int[] iArr18, int[] iArr19, int[] iArr20, int[] iArr21) {
        this.bcCaseCount = iArr;
        this.bcCaseValue = iArr2;
        this.bcByte = iArr3;
        this.bcShort = iArr4;
        this.bcLocal = iArr5;
        this.bcLabel = iArr6;
        this.bcIntRef = iArr7;
        this.bcFloatRef = iArr8;
        this.bcLongRef = iArr9;
        this.bcDoubleRef = iArr10;
        this.bcStringRef = iArr11;
        this.bcClassRef = iArr12;
        this.bcFieldRef = iArr13;
        this.bcMethodRef = iArr14;
        this.bcIMethodRef = iArr15;
        this.bcThisField = iArr16;
        this.bcSuperField = iArr17;
        this.bcThisMethod = iArr18;
        this.bcSuperMethod = iArr19;
        this.bcInitRef = iArr20;
        this.wideByteCodes = iArr21;
    }

    public String getCurrentClass() {
        String str = this.currentClass;
        if (str != null) {
            return str;
        }
        throw new Error("Current class not set yet");
    }

    public String getNewClass() {
        String str = this.newClass;
        if (str != null) {
            return str;
        }
        throw new Error("New class not set yet");
    }

    public String getSuperClass() {
        String str = this.superClass;
        if (str != null) {
            return str;
        }
        throw new Error("SuperClass not set yet");
    }

    public SegmentConstantPool globalConstantPool() {
        return this.segment.getConstantPool();
    }

    public int nextByte() {
        int[] iArr = this.bcByte;
        int i5 = this.bcByteIndex;
        this.bcByteIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextCaseCount() {
        int[] iArr = this.bcCaseCount;
        int i5 = this.bcCaseCountIndex;
        this.bcCaseCountIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextCaseValues() {
        int[] iArr = this.bcCaseValue;
        int i5 = this.bcCaseValueIndex;
        this.bcCaseValueIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextClassRef() {
        int[] iArr = this.bcClassRef;
        int i5 = this.bcClassRefIndex;
        this.bcClassRefIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextDoubleRef() {
        int[] iArr = this.bcDoubleRef;
        int i5 = this.bcDoubleRefIndex;
        this.bcDoubleRefIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextFieldRef() {
        int[] iArr = this.bcFieldRef;
        int i5 = this.bcFieldRefIndex;
        this.bcFieldRefIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextFloatRef() {
        int[] iArr = this.bcFloatRef;
        int i5 = this.bcFloatRefIndex;
        this.bcFloatRefIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextIMethodRef() {
        int[] iArr = this.bcIMethodRef;
        int i5 = this.bcIMethodRefIndex;
        this.bcIMethodRefIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextInitRef() {
        int[] iArr = this.bcInitRef;
        int i5 = this.bcInitRefIndex;
        this.bcInitRefIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextIntRef() {
        int[] iArr = this.bcIntRef;
        int i5 = this.bcIntRefIndex;
        this.bcIntRefIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextLabel() {
        int[] iArr = this.bcLabel;
        int i5 = this.bcLabelIndex;
        this.bcLabelIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextLocal() {
        int[] iArr = this.bcLocal;
        int i5 = this.bcLocalIndex;
        this.bcLocalIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextLongRef() {
        int[] iArr = this.bcLongRef;
        int i5 = this.bcLongRefIndex;
        this.bcLongRefIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextMethodRef() {
        int[] iArr = this.bcMethodRef;
        int i5 = this.bcMethodRefIndex;
        this.bcMethodRefIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextShort() {
        int[] iArr = this.bcShort;
        int i5 = this.bcShortIndex;
        this.bcShortIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextStringRef() {
        int[] iArr = this.bcStringRef;
        int i5 = this.bcStringRefIndex;
        this.bcStringRefIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextSuperFieldRef() {
        int[] iArr = this.bcSuperField;
        int i5 = this.bcSuperFieldIndex;
        this.bcSuperFieldIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextSuperMethodRef() {
        int[] iArr = this.bcSuperMethod;
        int i5 = this.bcSuperMethodIndex;
        this.bcSuperMethodIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextThisFieldRef() {
        int[] iArr = this.bcThisField;
        int i5 = this.bcThisFieldIndex;
        this.bcThisFieldIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextThisMethodRef() {
        int[] iArr = this.bcThisMethod;
        int i5 = this.bcThisMethodIndex;
        this.bcThisMethodIndex = i5 + 1;
        return iArr[i5];
    }

    public int nextWideByteCode() {
        int[] iArr = this.wideByteCodes;
        int i5 = this.wideByteCodeIndex;
        this.wideByteCodeIndex = i5 + 1;
        return iArr[i5];
    }

    public void setCurrentClass(String str) {
        this.currentClass = str;
    }

    public void setNewClass(String str) {
        this.newClass = str;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    public void setSuperClass(String str) {
        this.superClass = str;
    }
}
