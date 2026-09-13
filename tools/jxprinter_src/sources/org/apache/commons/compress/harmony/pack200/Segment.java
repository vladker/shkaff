package org.apache.commons.compress.harmony.pack200;

import A3.AbstractC0157z;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractC1125a;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Segment implements ClassVisitor {
    private AttributeDefinitionBands attributeDefinitionBands;
    private BcBands bcBands;
    private ClassBands classBands;
    private CpBands cpBands;
    private Pack200ClassReader currentClassReader;
    private FileBands fileBands;
    private IcBands icBands;
    private Attribute[] nonStandardAttributePrototypes;
    private PackingOptions options;
    private SegmentHeader segmentHeader;
    private boolean stripDebug;
    private final SegmentFieldVisitor fieldVisitor = new SegmentFieldVisitor();
    private final SegmentMethodVisitor methodVisitor = new SegmentMethodVisitor();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PassException extends RuntimeException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addValueAndTag(Object obj, List list, List list2) {
        if (obj instanceof Integer) {
            list.add("I");
            list2.add(obj);
            return;
        }
        if (obj instanceof Double) {
            list.add("D");
            list2.add(obj);
            return;
        }
        if (obj instanceof Float) {
            list.add("F");
            list2.add(obj);
            return;
        }
        if (obj instanceof Long) {
            list.add("J");
            list2.add(obj);
            return;
        }
        if (obj instanceof Byte) {
            list.add("B");
            list2.add(Integer.valueOf(((Byte) obj).intValue()));
            return;
        }
        if (obj instanceof Character) {
            list.add("C");
            list2.add(Integer.valueOf(((Character) obj).charValue()));
            return;
        }
        if (obj instanceof Short) {
            list.add(ExifInterface.LATITUDE_SOUTH);
            list2.add(Integer.valueOf(((Short) obj).intValue()));
            return;
        }
        if (obj instanceof Boolean) {
            list.add("Z");
            list2.add(Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0));
        } else if (obj instanceof String) {
            list.add("s");
            list2.add(obj);
        } else if (obj instanceof Type) {
            list.add("c");
            list2.add(((Type) obj).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void passCurrentClass() {
        throw new PassException();
    }

    private void processClasses(Archive.SegmentUnit segmentUnit, Attribute[] attributeArr) throws Pack200Exception {
        Archive.PackingFile packingFile;
        this.segmentHeader.setClass_count(segmentUnit.classListSize());
        for (Pack200ClassReader pack200ClassReader : segmentUnit.getClassList()) {
            this.currentClassReader = pack200ClassReader;
            try {
                pack200ClassReader.accept(this, attributeArr, this.stripDebug ? 2 : 0);
            } catch (PassException unused) {
                this.classBands.removeCurrentClass();
                String fileName = pack200ClassReader.getFileName();
                this.options.addPassFile(fileName);
                this.cpBands.addCPUtf8(fileName);
                Iterator it = segmentUnit.getFileList().iterator();
                do {
                    if (!it.hasNext()) {
                        throw new Pack200Exception(AbstractC0157z.n("Error passing file ", fileName));
                    }
                    packingFile = (Archive.PackingFile) it.next();
                } while (!packingFile.getName().equals(fileName));
                packingFile.setContents(pack200ClassReader.b);
            }
        }
    }

    public AttributeDefinitionBands getAttrBands() {
        return this.attributeDefinitionBands;
    }

    public ClassBands getClassBands() {
        return this.classBands;
    }

    public CpBands getCpBands() {
        return this.cpBands;
    }

    public Pack200ClassReader getCurrentClassReader() {
        return this.currentClassReader;
    }

    public IcBands getIcBands() {
        return this.icBands;
    }

    public SegmentHeader getSegmentHeader() {
        return this.segmentHeader;
    }

    public boolean lastConstantHadWideIndex() {
        return this.currentClassReader.lastConstantHadWideIndex();
    }

    public void pack(Archive.SegmentUnit segmentUnit, OutputStream outputStream, PackingOptions packingOptions) throws Pack200Exception, IOException {
        this.options = packingOptions;
        this.stripDebug = packingOptions.isStripDebug();
        int effort = packingOptions.getEffort();
        this.nonStandardAttributePrototypes = packingOptions.getUnknownAttributePrototypes();
        PackingUtils.log("Start to pack a new segment with " + segmentUnit.fileListSize() + " files including " + segmentUnit.classListSize() + " classes");
        PackingUtils.log("Initialize a header for the segment");
        SegmentHeader segmentHeader = new SegmentHeader();
        this.segmentHeader = segmentHeader;
        segmentHeader.setFile_count(segmentUnit.fileListSize());
        this.segmentHeader.setHave_all_code_flags(this.stripDebug ^ true);
        if (!packingOptions.isKeepDeflateHint()) {
            this.segmentHeader.setDeflate_hint("true".equals(packingOptions.getDeflateHint()));
        }
        PackingUtils.log("Setup constant pool bands for the segment");
        this.cpBands = new CpBands(this, effort);
        PackingUtils.log("Setup attribute definition bands for the segment");
        this.attributeDefinitionBands = new AttributeDefinitionBands(this, effort, this.nonStandardAttributePrototypes);
        PackingUtils.log("Setup internal class bands for the segment");
        this.icBands = new IcBands(this.segmentHeader, this.cpBands, effort);
        PackingUtils.log("Setup class bands for the segment");
        this.classBands = new ClassBands(this, segmentUnit.classListSize(), effort, this.stripDebug);
        PackingUtils.log("Setup byte code bands for the segment");
        this.bcBands = new BcBands(this.cpBands, this, effort);
        PackingUtils.log("Setup file bands for the segment");
        this.fileBands = new FileBands(this.cpBands, this.segmentHeader, packingOptions, segmentUnit, effort);
        processClasses(segmentUnit, this.nonStandardAttributePrototypes);
        this.cpBands.finaliseBands();
        this.attributeDefinitionBands.finaliseBands();
        this.icBands.finaliseBands();
        this.classBands.finaliseBands();
        this.bcBands.finaliseBands();
        this.fileBands.finaliseBands();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PackingUtils.log("Packing...");
        int iNumClassesProcessed = this.classBands.numClassesProcessed();
        this.segmentHeader.setClass_count(iNumClassesProcessed);
        this.cpBands.pack(byteArrayOutputStream);
        if (iNumClassesProcessed > 0) {
            this.attributeDefinitionBands.pack(byteArrayOutputStream);
            this.icBands.pack(byteArrayOutputStream);
            this.classBands.pack(byteArrayOutputStream);
            this.bcBands.pack(byteArrayOutputStream);
        }
        this.fileBands.pack(byteArrayOutputStream);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        this.segmentHeader.pack(byteArrayOutputStream2);
        byteArrayOutputStream2.writeTo(outputStream);
        byteArrayOutputStream.writeTo(outputStream);
        segmentUnit.addPackedByteAmount(byteArrayOutputStream2.size());
        segmentUnit.addPackedByteAmount(byteArrayOutputStream.size());
        PackingUtils.log("Wrote total of " + segmentUnit.getPackedByteAmount() + " bytes");
        StringBuilder sb = new StringBuilder("Transmitted ");
        sb.append(segmentUnit.fileListSize());
        sb.append(" files of ");
        sb.append(segmentUnit.getByteAmount());
        sb.append(" input bytes in a segment of ");
        AbstractC1125a.m(" bytes", segmentUnit.getPackedByteAmount(), sb);
    }

    public void visit(int i5, int i6, String str, String str2, String str3, String[] strArr) {
        this.bcBands.setCurrentClass(str, str3);
        this.segmentHeader.addMajorVersion(i5);
        this.classBands.addClass(i5, i6, str, str2, str3, strArr);
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z6) {
        return new SegmentAnnotationVisitor(0, str, z6);
    }

    public void visitAttribute(Attribute attribute) {
        if (attribute.isUnknown()) {
            String unknownAttributeAction = this.options.getUnknownAttributeAction();
            if (unknownAttributeAction.equals("pass")) {
                passCurrentClass();
                return;
            } else {
                if (unknownAttributeAction.equals("error")) {
                    throw new Error("Unknown attribute encountered");
                }
                return;
            }
        }
        if (!(attribute instanceof NewAttribute)) {
            throw new RuntimeException("Unexpected attribute encountered: " + attribute.type);
        }
        NewAttribute newAttribute = (NewAttribute) attribute;
        if (newAttribute.isUnknown(0)) {
            String unknownClassAttributeAction = this.options.getUnknownClassAttributeAction(newAttribute.type);
            if (unknownClassAttributeAction.equals("pass")) {
                passCurrentClass();
            } else if (unknownClassAttributeAction.equals("error")) {
                throw new Error("Unknown attribute encountered");
            }
        }
        this.classBands.addClassAttribute(newAttribute);
    }

    public void visitEnd() {
        this.classBands.endOfClass();
    }

    public FieldVisitor visitField(int i5, String str, String str2, String str3, Object obj) {
        this.classBands.addField(i5, str, str2, str3, obj);
        return this.fieldVisitor;
    }

    public void visitInnerClass(String str, String str2, String str3, int i5) {
        this.icBands.addInnerClass(str, str2, str3, i5);
    }

    public MethodVisitor visitMethod(int i5, String str, String str2, String str3, String[] strArr) {
        this.classBands.addMethod(i5, str, str2, str3, strArr);
        return this.methodVisitor;
    }

    public void visitOuterClass(String str, String str2, String str3) {
        this.classBands.addEnclosingMethod(str, str2, str3);
    }

    public void visitSource(String str, String str2) {
        if (this.stripDebug) {
            return;
        }
        this.classBands.addSourceFile(str);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class SegmentAnnotationVisitor implements AnnotationVisitor {

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        private final List f6719T;
        private final List caseArrayN;
        private int context;
        private String desc;
        private final List nameRU;
        private final List nestNameRU;
        private final List nestPairN;
        private final List nestTypeRS;
        private int parameter;
        private final List values;
        private boolean visible;

        public SegmentAnnotationVisitor(int i5, String str, boolean z6) {
            this.context = -1;
            this.parameter = -1;
            this.nameRU = new ArrayList();
            this.f6719T = new ArrayList();
            this.values = new ArrayList();
            this.caseArrayN = new ArrayList();
            this.nestTypeRS = new ArrayList();
            this.nestNameRU = new ArrayList();
            this.nestPairN = new ArrayList();
            this.context = i5;
            this.desc = str;
            this.visible = z6;
        }

        public void visit(String str, Object obj) {
            if (str == null) {
                str = "";
            }
            this.nameRU.add(str);
            Segment.this.addValueAndTag(obj, this.f6719T, this.values);
        }

        public AnnotationVisitor visitAnnotation(String str, String str2) {
            this.f6719T.add("@");
            if (str == null) {
                str = "";
            }
            this.nameRU.add(str);
            this.nestTypeRS.add(str2);
            this.nestPairN.add(0);
            return new AnnotationVisitor() { // from class: org.apache.commons.compress.harmony.pack200.Segment.SegmentAnnotationVisitor.1
                public void visit(String str3, Object obj) {
                    SegmentAnnotationVisitor.this.nestPairN.add(Integer.valueOf(((Integer) SegmentAnnotationVisitor.this.nestPairN.remove(SegmentAnnotationVisitor.this.nestPairN.size() - 1)).intValue() + 1));
                    SegmentAnnotationVisitor.this.nestNameRU.add(str3);
                    SegmentAnnotationVisitor segmentAnnotationVisitor = SegmentAnnotationVisitor.this;
                    Segment.this.addValueAndTag(obj, segmentAnnotationVisitor.f6719T, SegmentAnnotationVisitor.this.values);
                }

                public AnnotationVisitor visitAnnotation(String str3, String str4) {
                    throw new RuntimeException("Not yet supported");
                }

                public AnnotationVisitor visitArray(String str3) {
                    throw new RuntimeException("Not yet supported");
                }

                public void visitEnum(String str3, String str4, String str5) {
                    SegmentAnnotationVisitor.this.nestPairN.add(Integer.valueOf(((Integer) SegmentAnnotationVisitor.this.nestPairN.remove(SegmentAnnotationVisitor.this.nestPairN.size() - 1)).intValue() + 1));
                    SegmentAnnotationVisitor.this.f6719T.add("e");
                    SegmentAnnotationVisitor.this.nestNameRU.add(str3);
                    SegmentAnnotationVisitor.this.values.add(str4);
                    SegmentAnnotationVisitor.this.values.add(str5);
                }

                public void visitEnd() {
                }
            };
        }

        public AnnotationVisitor visitArray(String str) {
            this.f6719T.add("[");
            if (str == null) {
                str = "";
            }
            this.nameRU.add(str);
            this.caseArrayN.add(0);
            return Segment.this.new ArrayVisitor(this.caseArrayN, this.f6719T, this.nameRU, this.values);
        }

        public void visitEnd() {
            if (this.desc == null) {
                Segment.this.classBands.addAnnotationDefault(this.nameRU, this.f6719T, this.values, this.caseArrayN, this.nestTypeRS, this.nestNameRU, this.nestPairN);
            } else if (this.parameter != -1) {
                Segment.this.classBands.addParameterAnnotation(this.parameter, this.desc, this.visible, this.nameRU, this.f6719T, this.values, this.caseArrayN, this.nestTypeRS, this.nestNameRU, this.nestPairN);
            } else {
                Segment.this.classBands.addAnnotation(this.context, this.desc, this.visible, this.nameRU, this.f6719T, this.values, this.caseArrayN, this.nestTypeRS, this.nestNameRU, this.nestPairN);
            }
        }

        public void visitEnum(String str, String str2, String str3) {
            this.f6719T.add("e");
            if (str == null) {
                str = "";
            }
            this.nameRU.add(str);
            this.values.add(str2);
            this.values.add(str3);
        }

        public SegmentAnnotationVisitor(int i5) {
            this.context = -1;
            this.parameter = -1;
            this.nameRU = new ArrayList();
            this.f6719T = new ArrayList();
            this.values = new ArrayList();
            this.caseArrayN = new ArrayList();
            this.nestTypeRS = new ArrayList();
            this.nestNameRU = new ArrayList();
            this.nestPairN = new ArrayList();
            this.context = i5;
        }

        public SegmentAnnotationVisitor(int i5, int i6, String str, boolean z6) {
            this.context = -1;
            this.parameter = -1;
            this.nameRU = new ArrayList();
            this.f6719T = new ArrayList();
            this.values = new ArrayList();
            this.caseArrayN = new ArrayList();
            this.nestTypeRS = new ArrayList();
            this.nestNameRU = new ArrayList();
            this.nestPairN = new ArrayList();
            this.context = i5;
            this.parameter = i6;
            this.desc = str;
            this.visible = z6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class ArrayVisitor implements AnnotationVisitor {

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        private final List f6718T;
        private final List caseArrayN;
        private final int indexInCaseArrayN;
        private final List nameRU;
        private final List values;

        public ArrayVisitor(List list, List list2, List list3, List list4) {
            this.caseArrayN = list;
            this.f6718T = list2;
            this.nameRU = list3;
            this.values = list4;
            this.indexInCaseArrayN = list.size() - 1;
        }

        public void visit(String str, Object obj) {
            this.caseArrayN.add(this.indexInCaseArrayN, Integer.valueOf(((Integer) this.caseArrayN.remove(this.indexInCaseArrayN)).intValue() + 1));
            Segment.this.addValueAndTag(obj, this.f6718T, this.values);
        }

        public AnnotationVisitor visitAnnotation(String str, String str2) {
            throw new RuntimeException("Not yet supported");
        }

        public AnnotationVisitor visitArray(String str) {
            this.f6718T.add("[");
            if (str == null) {
                str = "";
            }
            this.nameRU.add(str);
            this.caseArrayN.add(0);
            return Segment.this.new ArrayVisitor(this.caseArrayN, this.f6718T, this.nameRU, this.values);
        }

        public void visitEnum(String str, String str2, String str3) {
            List list = this.caseArrayN;
            this.caseArrayN.add(Integer.valueOf(((Integer) list.remove(list.size() - 1)).intValue() + 1));
            this.f6718T.add("e");
            this.values.add(str2);
            this.values.add(str3);
        }

        public void visitEnd() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class SegmentFieldVisitor implements FieldVisitor {
        public SegmentFieldVisitor() {
        }

        public AnnotationVisitor visitAnnotation(String str, boolean z6) {
            return Segment.this.new SegmentAnnotationVisitor(1, str, z6);
        }

        public void visitAttribute(Attribute attribute) {
            if (attribute.isUnknown()) {
                String unknownAttributeAction = Segment.this.options.getUnknownAttributeAction();
                if (unknownAttributeAction.equals("pass")) {
                    Segment.this.passCurrentClass();
                    return;
                } else {
                    if (unknownAttributeAction.equals("error")) {
                        throw new Error("Unknown attribute encountered");
                    }
                    return;
                }
            }
            if (!(attribute instanceof NewAttribute)) {
                throw new RuntimeException("Unexpected attribute encountered: " + attribute.type);
            }
            NewAttribute newAttribute = (NewAttribute) attribute;
            if (newAttribute.isUnknown(1)) {
                String unknownFieldAttributeAction = Segment.this.options.getUnknownFieldAttributeAction(newAttribute.type);
                if (unknownFieldAttributeAction.equals("pass")) {
                    Segment.this.passCurrentClass();
                } else if (unknownFieldAttributeAction.equals("error")) {
                    throw new Error("Unknown attribute encountered");
                }
            }
            Segment.this.classBands.addFieldAttribute(newAttribute);
        }

        public void visitEnd() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class SegmentMethodVisitor implements MethodVisitor {
        public SegmentMethodVisitor() {
        }

        public AnnotationVisitor visitAnnotation(String str, boolean z6) {
            return Segment.this.new SegmentAnnotationVisitor(2, str, z6);
        }

        public AnnotationVisitor visitAnnotationDefault() {
            return Segment.this.new SegmentAnnotationVisitor(2);
        }

        public void visitAttribute(Attribute attribute) {
            if (attribute.isUnknown()) {
                String unknownAttributeAction = Segment.this.options.getUnknownAttributeAction();
                if (unknownAttributeAction.equals("pass")) {
                    Segment.this.passCurrentClass();
                    return;
                } else {
                    if (unknownAttributeAction.equals("error")) {
                        throw new Error("Unknown attribute encountered");
                    }
                    return;
                }
            }
            if (!(attribute instanceof NewAttribute)) {
                throw new RuntimeException("Unexpected attribute encountered: " + attribute.type);
            }
            NewAttribute newAttribute = (NewAttribute) attribute;
            if (attribute.isCodeAttribute()) {
                if (newAttribute.isUnknown(3)) {
                    String unknownCodeAttributeAction = Segment.this.options.getUnknownCodeAttributeAction(newAttribute.type);
                    if (unknownCodeAttributeAction.equals("pass")) {
                        Segment.this.passCurrentClass();
                    } else if (unknownCodeAttributeAction.equals("error")) {
                        throw new Error("Unknown attribute encountered");
                    }
                }
                Segment.this.classBands.addCodeAttribute(newAttribute);
                return;
            }
            if (newAttribute.isUnknown(2)) {
                String unknownMethodAttributeAction = Segment.this.options.getUnknownMethodAttributeAction(newAttribute.type);
                if (unknownMethodAttributeAction.equals("pass")) {
                    Segment.this.passCurrentClass();
                } else if (unknownMethodAttributeAction.equals("error")) {
                    throw new Error("Unknown attribute encountered");
                }
            }
            Segment.this.classBands.addMethodAttribute(newAttribute);
        }

        public void visitCode() {
            Segment.this.classBands.addCode();
        }

        public void visitEnd() {
            Segment.this.classBands.endOfMethod();
            Segment.this.bcBands.visitEnd();
        }

        public void visitFieldInsn(int i5, String str, String str2, String str3) {
            Segment.this.bcBands.visitFieldInsn(i5, str, str2, str3);
        }

        public void visitIincInsn(int i5, int i6) {
            Segment.this.bcBands.visitIincInsn(i5, i6);
        }

        public void visitInsn(int i5) {
            Segment.this.bcBands.visitInsn(i5);
        }

        public void visitIntInsn(int i5, int i6) {
            Segment.this.bcBands.visitIntInsn(i5, i6);
        }

        public void visitJumpInsn(int i5, Label label) {
            Segment.this.bcBands.visitJumpInsn(i5, label);
        }

        public void visitLabel(Label label) {
            Segment.this.bcBands.visitLabel(label);
        }

        public void visitLdcInsn(Object obj) {
            Segment.this.bcBands.visitLdcInsn(obj);
        }

        public void visitLineNumber(int i5, Label label) {
            if (Segment.this.stripDebug) {
                return;
            }
            Segment.this.classBands.addLineNumber(i5, label);
        }

        public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i5) {
            if (Segment.this.stripDebug) {
                return;
            }
            Segment.this.classBands.addLocalVariable(str, str2, str3, label, label2, i5);
        }

        public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
            Segment.this.bcBands.visitLookupSwitchInsn(label, iArr, labelArr);
        }

        public void visitMaxs(int i5, int i6) {
            Segment.this.classBands.addMaxStack(i5, i6);
        }

        public void visitMethodInsn(int i5, String str, String str2, String str3) {
            Segment.this.bcBands.visitMethodInsn(i5, str, str2, str3);
        }

        public void visitMultiANewArrayInsn(String str, int i5) {
            Segment.this.bcBands.visitMultiANewArrayInsn(str, i5);
        }

        public AnnotationVisitor visitParameterAnnotation(int i5, String str, boolean z6) {
            return Segment.this.new SegmentAnnotationVisitor(2, i5, str, z6);
        }

        public void visitTableSwitchInsn(int i5, int i6, Label label, Label[] labelArr) {
            Segment.this.bcBands.visitTableSwitchInsn(i5, i6, label, labelArr);
        }

        public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
            Segment.this.classBands.addHandler(label, label2, label3, str);
        }

        public void visitTypeInsn(int i5, String str) {
            Segment.this.bcBands.visitTypeInsn(i5, str);
        }

        public void visitVarInsn(int i5, int i6) {
            Segment.this.bcBands.visitVarInsn(i5, i6);
        }

        public void visitFrame(int i5, int i6, Object[] objArr, int i7, Object[] objArr2) {
        }
    }
}
