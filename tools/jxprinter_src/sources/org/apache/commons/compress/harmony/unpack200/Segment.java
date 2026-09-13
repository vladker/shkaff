package org.apache.commons.compress.harmony.unpack200;

import A3.AbstractC0157z;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TimeZone;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.CRC32;
import org.apache.commons.compress.harmony.unpack200.bytecode.Attribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPField;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPMethod;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassConstantPool;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFile;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.apache.commons.compress.harmony.unpack200.bytecode.InnerClassesAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.SourceFileAttribute;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Segment {
    public static final int LOG_LEVEL_QUIET = 0;
    public static final int LOG_LEVEL_STANDARD = 1;
    public static final int LOG_LEVEL_VERBOSE = 2;
    private AttrDefinitionBands attrDefinitionBands;
    private BcBands bcBands;
    private ClassBands classBands;
    private byte[][] classFilesContents;
    private CpBands cpBands;
    private boolean deflateHint;
    private boolean doPreRead;
    private FileBands fileBands;
    private boolean[] fileDeflate;
    private boolean[] fileIsClass;
    private SegmentHeader header;
    private IcBands icBands;
    private InputStream internalBuffer;
    private int logLevel;
    private PrintWriter logStream;
    private boolean overrideDeflateHint;

    private ClassFile buildClassFile(int i5) {
        ClassFile classFile = new ClassFile();
        int[] classVersionMajor = this.classBands.getClassVersionMajor();
        int[] classVersionMinor = this.classBands.getClassVersionMinor();
        if (classVersionMajor != null) {
            classFile.major = classVersionMajor[i5];
            classFile.minor = classVersionMinor[i5];
        } else {
            classFile.major = this.header.getDefaultClassMajorVersion();
            classFile.minor = this.header.getDefaultClassMinorVersion();
        }
        ClassConstantPool classConstantPool = classFile.pool;
        int i6 = this.classBands.getClassThisInts()[i5];
        String str = this.cpBands.getCpClass()[i6];
        int iLastIndexOf = str.lastIndexOf(PackagingURIHelper.FORWARD_SLASH_STRING) + 1;
        ArrayList arrayList = this.classBands.getClassAttributes()[i5];
        SourceFileAttribute sourceFileAttribute = null;
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            if (((Attribute) arrayList.get(i7)).isSourceFileAttribute()) {
                sourceFileAttribute = (SourceFileAttribute) arrayList.get(i7);
            }
        }
        if (sourceFileAttribute != null) {
            classFile.attributes = new Attribute[]{(Attribute) classConstantPool.add(sourceFileAttribute)};
        } else if (this.attrDefinitionBands.getAttributeDefinitionMap().getAttributeLayout(AttributeLayout.ATTRIBUTE_SOURCE_FILE, 0).matches(this.classBands.getRawClassFlags()[i5])) {
            int i8 = -1;
            for (int i9 = 0; i9 < str.length(); i9++) {
                if (str.charAt(i9) <= '$') {
                    i8 = i9;
                }
            }
            classFile.attributes = new Attribute[]{(Attribute) classConstantPool.add(new SourceFileAttribute(this.cpBands.cpUTF8Value((i8 <= -1 || iLastIndexOf > i8) ? str.substring(iLastIndexOf) + ".java" : str.substring(iLastIndexOf, i8) + ".java", false)))};
        } else {
            classFile.attributes = new Attribute[0];
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            Attribute attribute = (Attribute) arrayList.get(i10);
            if (!attribute.isSourceFileAttribute()) {
                arrayList2.add(attribute);
            }
        }
        Attribute[] attributeArr = classFile.attributes;
        Attribute[] attributeArr2 = new Attribute[arrayList2.size() + attributeArr.length];
        classFile.attributes = attributeArr2;
        System.arraycopy(attributeArr, 0, attributeArr2, 0, attributeArr.length);
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            Attribute attribute2 = (Attribute) arrayList2.get(i11);
            classConstantPool.add(attribute2);
            classFile.attributes[attributeArr.length + i11] = attribute2;
        }
        ClassFileEntry classFileEntryAdd = classConstantPool.add(this.cpBands.cpClassValue(i6));
        ClassFileEntry classFileEntryAdd2 = classConstantPool.add(this.cpBands.cpClassValue(this.classBands.getClassSuperInts()[i5]));
        int length = this.classBands.getClassInterfacesInts()[i5].length;
        ClassFileEntry[] classFileEntryArr = new ClassFileEntry[length];
        for (int i12 = 0; i12 < length; i12++) {
            classFileEntryArr[i12] = classConstantPool.add(this.cpBands.cpClassValue(this.classBands.getClassInterfacesInts()[i5][i12]));
        }
        int i13 = this.classBands.getClassFieldCount()[i5];
        ClassFileEntry[] classFileEntryArr2 = new ClassFileEntry[i13];
        for (int i14 = 0; i14 < i13; i14++) {
            int i15 = this.classBands.getFieldDescrInts()[i5][i14];
            classFileEntryArr2[i14] = classConstantPool.add(new CPField(this.cpBands.cpUTF8Value(this.cpBands.getCpDescriptorNameInts()[i15]), this.cpBands.cpSignatureValue(this.cpBands.getCpDescriptorTypeInts()[i15]), this.classBands.getFieldFlags()[i5][i14], this.classBands.getFieldAttributes()[i5][i14]));
        }
        int i16 = this.classBands.getClassMethodCount()[i5];
        ClassFileEntry[] classFileEntryArr3 = new ClassFileEntry[i16];
        for (int i17 = 0; i17 < i16; i17++) {
            int i18 = this.classBands.getMethodDescrInts()[i5][i17];
            classFileEntryArr3[i17] = classConstantPool.add(new CPMethod(this.cpBands.cpUTF8Value(this.cpBands.getCpDescriptorNameInts()[i18]), this.cpBands.cpSignatureValue(this.cpBands.getCpDescriptorTypeInts()[i18]), this.classBands.getMethodFlags()[i5][i17], this.classBands.getMethodAttributes()[i5][i17]));
        }
        classConstantPool.addNestedEntries();
        IcTuple[] icTupleArr = getClassBands().getIcLocal()[i5];
        boolean z6 = icTupleArr != null;
        InnerClassesAttribute innerClassesAttribute = new InnerClassesAttribute(AttributeLayout.ATTRIBUTE_INNER_CLASSES);
        IcTuple[] relevantIcTuples = getIcBands().getRelevantIcTuples(str, classConstantPool);
        List listComputeIcStored = computeIcStored(icTupleArr, relevantIcTuples);
        int i19 = 0;
        boolean z7 = false;
        while (i19 < listComputeIcStored.size()) {
            IcTuple icTuple = (IcTuple) listComputeIcStored.get(i19);
            boolean z8 = z6;
            int iThisClassIndex = icTuple.thisClassIndex();
            ClassFileEntry[] classFileEntryArr4 = classFileEntryArr;
            int iOuterClassIndex = icTuple.outerClassIndex();
            List list = listComputeIcStored;
            int iSimpleClassNameIndex = icTuple.simpleClassNameIndex();
            int i20 = i19;
            String strThisClassString = icTuple.thisClassString();
            ClassFileEntry[] classFileEntryArr5 = classFileEntryArr3;
            String strOuterClassString = icTuple.outerClassString();
            ClassFileEntry[] classFileEntryArr6 = classFileEntryArr2;
            String strSimpleClassName = icTuple.simpleClassName();
            int i21 = length;
            CPClass cPClassCpClassValue = iThisClassIndex != -1 ? this.cpBands.cpClassValue(iThisClassIndex) : this.cpBands.cpClassValue(strThisClassString);
            CPUTF8 cputf8CpUTF8Value = icTuple.isAnonymous() ? null : iSimpleClassNameIndex != -1 ? this.cpBands.cpUTF8Value(iSimpleClassNameIndex) : this.cpBands.cpUTF8Value(strSimpleClassName);
            innerClassesAttribute.addInnerClassesEntry(cPClassCpClassValue, icTuple.isMember() ? iOuterClassIndex != -1 ? this.cpBands.cpClassValue(iOuterClassIndex) : this.cpBands.cpClassValue(strOuterClassString) : null, cputf8CpUTF8Value, icTuple.f6722F);
            i19 = i20 + 1;
            z6 = z8;
            classFileEntryArr = classFileEntryArr4;
            listComputeIcStored = list;
            classFileEntryArr3 = classFileEntryArr5;
            classFileEntryArr2 = classFileEntryArr6;
            length = i21;
            z7 = true;
        }
        int i22 = length;
        ClassFileEntry[] classFileEntryArr7 = classFileEntryArr3;
        boolean z9 = z6;
        ClassFileEntry[] classFileEntryArr8 = classFileEntryArr;
        ClassFileEntry[] classFileEntryArr9 = classFileEntryArr2;
        if (z9 && icTupleArr.length == 0) {
            z7 = false;
        }
        if (!z9 && relevantIcTuples.length == 0) {
            z7 = false;
        }
        if (z7) {
            Attribute[] attributeArr3 = classFile.attributes;
            int length2 = attributeArr3.length;
            Attribute[] attributeArr4 = new Attribute[length2 + 1];
            for (int i23 = 0; i23 < attributeArr3.length; i23++) {
                attributeArr4[i23] = attributeArr3[i23];
            }
            attributeArr4[length2] = innerClassesAttribute;
            classFile.attributes = attributeArr4;
            classConstantPool.addWithNestedEntries(innerClassesAttribute);
        }
        classConstantPool.resolve(this);
        classFile.accessFlags = (int) this.classBands.getClassFlags()[i5];
        classFile.thisClass = classConstantPool.indexOf(classFileEntryAdd);
        classFile.superClass = classConstantPool.indexOf(classFileEntryAdd2);
        classFile.interfaces = new int[i22];
        for (int i24 = 0; i24 < i22; i24++) {
            classFile.interfaces[i24] = classConstantPool.indexOf(classFileEntryArr8[i24]);
        }
        classFile.fields = classFileEntryArr9;
        classFile.methods = classFileEntryArr7;
        return classFile;
    }

    private List computeIcStored(IcTuple[] icTupleArr, IcTuple[] icTupleArr2) {
        ArrayList arrayList = new ArrayList(icTupleArr2.length);
        ArrayList arrayList2 = new ArrayList(icTupleArr2.length);
        HashSet hashSet = new HashSet(icTupleArr2.length);
        if (icTupleArr != null) {
            for (int i5 = 0; i5 < icTupleArr.length; i5++) {
                if (hashSet.add(icTupleArr[i5])) {
                    arrayList.add(icTupleArr[i5]);
                }
            }
        }
        for (int i6 = 0; i6 < icTupleArr2.length; i6++) {
            if (hashSet.add(icTupleArr2[i6])) {
                arrayList.add(icTupleArr2[i6]);
            } else {
                arrayList2.add(icTupleArr2[i6]);
            }
        }
        for (int i7 = 0; i7 < arrayList2.size(); i7++) {
            arrayList.remove((IcTuple) arrayList2.get(i7));
        }
        return arrayList;
    }

    private void parseSegment() throws IOException {
        this.header.unpack();
        this.cpBands.unpack();
        this.attrDefinitionBands.unpack();
        this.icBands.unpack();
        this.classBands.unpack();
        this.bcBands.unpack();
        this.fileBands.unpack();
        int numberOfFiles = this.header.getNumberOfFiles();
        String[] fileName = this.fileBands.getFileName();
        int[] fileOptions = this.fileBands.getFileOptions();
        SegmentOptions options = this.header.getOptions();
        this.classFilesContents = new byte[numberOfFiles][];
        this.fileDeflate = new boolean[numberOfFiles];
        this.fileIsClass = new boolean[numberOfFiles];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        int i5 = 0;
        for (int i6 = 0; i6 < numberOfFiles; i6++) {
            String str = fileName[i6];
            boolean z6 = true;
            boolean z7 = str == null || str.equals("");
            boolean z8 = (fileOptions[i6] & 2) == 2 || z7;
            if (z8 && z7) {
                fileName[i6] = AbstractC0157z.s(new StringBuilder(), this.cpBands.getCpClass()[this.classBands.getClassThisInts()[i5]], ".class");
            }
            if (this.overrideDeflateHint) {
                this.fileDeflate[i6] = this.deflateHint;
            } else {
                boolean[] zArr = this.fileDeflate;
                if ((fileOptions[i6] & 1) != 1 && !options.shouldDeflate()) {
                    z6 = false;
                }
                zArr[i6] = z6;
            }
            this.fileIsClass[i6] = z8;
            if (z8) {
                buildClassFile(i5).write(dataOutputStream);
                dataOutputStream.flush();
                this.classFilesContents[i5] = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.reset();
                i5++;
            }
        }
    }

    private void readSegment(InputStream inputStream) {
        log(2, "-------");
        CpBands cpBands = new CpBands(this);
        this.cpBands = cpBands;
        cpBands.read(inputStream);
        AttrDefinitionBands attrDefinitionBands = new AttrDefinitionBands(this);
        this.attrDefinitionBands = attrDefinitionBands;
        attrDefinitionBands.read(inputStream);
        IcBands icBands = new IcBands(this);
        this.icBands = icBands;
        icBands.read(inputStream);
        ClassBands classBands = new ClassBands(this);
        this.classBands = classBands;
        classBands.read(inputStream);
        BcBands bcBands = new BcBands(this);
        this.bcBands = bcBands;
        bcBands.read(inputStream);
        FileBands fileBands = new FileBands(this);
        this.fileBands = fileBands;
        fileBands.read(inputStream);
        this.fileBands.processFileBits();
    }

    public AttrDefinitionBands getAttrDefinitionBands() {
        return this.attrDefinitionBands;
    }

    public ClassBands getClassBands() {
        return this.classBands;
    }

    public SegmentConstantPool getConstantPool() {
        return this.cpBands.getConstantPool();
    }

    public CpBands getCpBands() {
        return this.cpBands;
    }

    public IcBands getIcBands() {
        return this.icBands;
    }

    public SegmentHeader getSegmentHeader() {
        return this.header;
    }

    public void log(int i5, String str) {
        if (this.logLevel >= i5) {
            this.logStream.println(str);
        }
    }

    public void overrideDeflateHint(boolean z6) {
        this.overrideDeflateHint = true;
        this.deflateHint = z6;
    }

    public void setLogLevel(int i5) {
        this.logLevel = i5;
    }

    public void setLogStream(OutputStream outputStream) {
        this.logStream = new PrintWriter(outputStream);
    }

    public void setPreRead(boolean z6) {
        this.doPreRead = z6;
    }

    public void unpack(InputStream inputStream, JarOutputStream jarOutputStream) throws IOException {
        unpackRead(inputStream);
        unpackProcess();
        unpackWrite(jarOutputStream);
    }

    public void unpackProcess() throws IOException {
        InputStream inputStream = this.internalBuffer;
        if (inputStream != null) {
            readSegment(inputStream);
        }
        parseSegment();
    }

    public void unpackRead(InputStream inputStream) throws IOException {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        SegmentHeader segmentHeader = new SegmentHeader(this);
        this.header = segmentHeader;
        segmentHeader.read(inputStream);
        int archiveSize = ((int) this.header.getArchiveSize()) - this.header.getArchiveSizeOffset();
        if (!this.doPreRead || this.header.getArchiveSize() == 0) {
            readSegment(inputStream);
            return;
        }
        byte[] bArr = new byte[archiveSize];
        inputStream.read(bArr);
        this.internalBuffer = new BufferedInputStream(new ByteArrayInputStream(bArr));
    }

    public void unpackWrite(JarOutputStream jarOutputStream) throws IOException {
        writeJar(jarOutputStream);
        PrintWriter printWriter = this.logStream;
        if (printWriter != null) {
            printWriter.close();
        }
    }

    public void writeJar(JarOutputStream jarOutputStream) throws IOException {
        String[] fileName = this.fileBands.getFileName();
        int[] fileModtime = this.fileBands.getFileModtime();
        long[] fileSize = this.fileBands.getFileSize();
        byte[][] fileBits = this.fileBands.getFileBits();
        int numberOfFiles = this.header.getNumberOfFiles();
        long archiveModtime = this.header.getArchiveModtime();
        int i5 = 0;
        int i6 = 0;
        while (i5 < numberOfFiles) {
            String str = fileName[i5];
            long j6 = (((long) fileModtime[i5]) + archiveModtime) * 1000;
            boolean z6 = this.fileDeflate[i5];
            JarEntry jarEntry = new JarEntry(str);
            if (z6) {
                jarEntry.setMethod(8);
                fileName = fileName;
                fileModtime = fileModtime;
            } else {
                jarEntry.setMethod(0);
                CRC32 crc32 = new CRC32();
                if (this.fileIsClass[i5]) {
                    crc32.update(this.classFilesContents[i6]);
                    jarEntry.setSize(this.classFilesContents[i6].length);
                } else {
                    crc32.update(fileBits[i5]);
                    jarEntry.setSize(fileSize[i5]);
                }
                jarEntry.setCrc(crc32.getValue());
            }
            jarEntry.setTime(j6 - ((long) TimeZone.getDefault().getRawOffset()));
            jarOutputStream.putNextEntry(jarEntry);
            if (this.fileIsClass[i5]) {
                jarEntry.setSize(this.classFilesContents[i6].length);
                jarOutputStream.write(this.classFilesContents[i6]);
                i6++;
            } else {
                jarEntry.setSize(fileSize[i5]);
                jarOutputStream.write(fileBits[i5]);
            }
            i5++;
            fileName = fileName;
            fileModtime = fileModtime;
        }
    }
}
