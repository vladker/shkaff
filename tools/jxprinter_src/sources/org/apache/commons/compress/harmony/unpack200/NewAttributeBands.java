package org.apache.commons.compress.harmony.unpack200;

import androidx.exifinterface.media.ExifInterface;
import androidx.exifinterface.media.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.compress.harmony.pack200.BHSDCodec;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.unpack200.bytecode.Attribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPDouble;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPFieldRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPFloat;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPInteger;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPInterfaceMethodRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPLong;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPMethodRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPNameAndType;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPString;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute;
import org.apache.logging.log4j.util.ProcessIdUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NewAttributeBands extends BandSet {
    private final AttributeLayout attributeLayout;
    protected List attributeLayoutElements;
    private int backwardsCallCount;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface AttributeLayoutElement {
        void addToAttribute(int i5, NewAttribute newAttribute);

        void readBands(InputStream inputStream, int i5);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Call extends LayoutElement {
        private Callable callable;
        private final int callableIndex;

        public Call(int i5) {
            super();
            this.callableIndex = i5;
        }

        @Override // org.apache.commons.compress.harmony.unpack200.NewAttributeBands.AttributeLayoutElement
        public void addToAttribute(int i5, NewAttribute newAttribute) {
            this.callable.addNextToAttribute(newAttribute);
        }

        public Callable getCallable() {
            return this.callable;
        }

        public int getCallableIndex() {
            return this.callableIndex;
        }

        @Override // org.apache.commons.compress.harmony.unpack200.NewAttributeBands.AttributeLayoutElement
        public void readBands(InputStream inputStream, int i5) {
            if (this.callableIndex > 0) {
                this.callable.addCount(i5);
            }
        }

        public void setCallable(Callable callable) {
            this.callable = callable;
            if (this.callableIndex < 1) {
                callable.setBackwardsCallable();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Callable implements AttributeLayoutElement {
        private final List body;
        private int count;
        private int index;
        private boolean isBackwardsCallable;
        private boolean isFirstCallable;

        public Callable(List list) {
            this.body = list;
        }

        public void addCount(int i5) {
            this.count += i5;
        }

        public void addNextToAttribute(NewAttribute newAttribute) {
            for (int i5 = 0; i5 < this.body.size(); i5++) {
                ((LayoutElement) this.body.get(i5)).addToAttribute(this.index, newAttribute);
            }
            this.index++;
        }

        @Override // org.apache.commons.compress.harmony.unpack200.NewAttributeBands.AttributeLayoutElement
        public void addToAttribute(int i5, NewAttribute newAttribute) {
            if (this.isFirstCallable) {
                for (int i6 = 0; i6 < this.body.size(); i6++) {
                    ((LayoutElement) this.body.get(i6)).addToAttribute(this.index, newAttribute);
                }
                this.index++;
            }
        }

        public List getBody() {
            return this.body;
        }

        public boolean isBackwardsCallable() {
            return this.isBackwardsCallable;
        }

        @Override // org.apache.commons.compress.harmony.unpack200.NewAttributeBands.AttributeLayoutElement
        public void readBands(InputStream inputStream, int i5) {
            int i6 = this.isFirstCallable ? i5 + this.count : this.count;
            for (int i7 = 0; i7 < this.body.size(); i7++) {
                ((LayoutElement) this.body.get(i7)).readBands(inputStream, i6);
            }
        }

        public void setBackwardsCallable() {
            this.isBackwardsCallable = true;
        }

        public void setFirstCallable(boolean z6) {
            this.isFirstCallable = z6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Integral extends LayoutElement {
        private int[] band;
        private final String tag;

        public Integral(String str) {
            super();
            this.tag = str;
        }

        @Override // org.apache.commons.compress.harmony.unpack200.NewAttributeBands.AttributeLayoutElement
        public void addToAttribute(int i5, NewAttribute newAttribute) {
            int i6;
            long j6 = this.band[i5];
            if (this.tag.equals("B") || this.tag.equals("FB")) {
                newAttribute.addInteger(1, j6);
                return;
            }
            if (this.tag.equals("SB")) {
                newAttribute.addInteger(1, (byte) j6);
                return;
            }
            if (this.tag.equals("H") || this.tag.equals("FH")) {
                newAttribute.addInteger(2, j6);
                return;
            }
            if (this.tag.equals("SH")) {
                newAttribute.addInteger(2, (short) j6);
                return;
            }
            if (this.tag.equals("I") || this.tag.equals("FI")) {
                newAttribute.addInteger(4, j6);
                return;
            }
            if (this.tag.equals("SI")) {
                newAttribute.addInteger(4, (int) j6);
                return;
            }
            if (this.tag.equals(ExifInterface.GPS_MEASUREMENT_INTERRUPTED) || this.tag.equals("FV") || this.tag.equals("SV")) {
                return;
            }
            if (this.tag.startsWith("PO")) {
                newAttribute.addBCOffset(getLength(this.tag.substring(2).toCharArray()[0]), (int) j6);
                return;
            }
            if (this.tag.startsWith("P")) {
                newAttribute.addBCIndex(getLength(this.tag.substring(1).toCharArray()[0]), (int) j6);
                return;
            }
            if (!this.tag.startsWith("OS")) {
                if (this.tag.startsWith("O")) {
                    newAttribute.addBCLength(getLength(this.tag.substring(1).toCharArray()[0]), (int) j6);
                    return;
                }
                return;
            }
            int length = getLength(this.tag.substring(2).toCharArray()[0]);
            if (length == 1) {
                i6 = (byte) j6;
            } else {
                if (length != 2) {
                    if (length == 4) {
                        i6 = (int) j6;
                    }
                    newAttribute.addBCLength(length, (int) j6);
                }
                i6 = (short) j6;
            }
            j6 = i6;
            newAttribute.addBCLength(length, (int) j6);
        }

        public String getTag() {
            return this.tag;
        }

        public long getValue(int i5) {
            return this.band[i5];
        }

        @Override // org.apache.commons.compress.harmony.unpack200.NewAttributeBands.AttributeLayoutElement
        public void readBands(InputStream inputStream, int i5) {
            this.band = NewAttributeBands.this.decodeBandInt(NewAttributeBands.this.attributeLayout.getName() + "_" + this.tag, inputStream, NewAttributeBands.this.getCodec(this.tag), i5);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public abstract class LayoutElement implements AttributeLayoutElement {
        private LayoutElement() {
        }

        public int getLength(char c) {
            if (c == 'B') {
                return 1;
            }
            if (c == 'V') {
                return 0;
            }
            if (c != 'H') {
                return c != 'I' ? 0 : 4;
            }
            return 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Reference extends LayoutElement {
        private Object band;
        private final int length;
        private final String tag;

        public Reference(String str) {
            super();
            this.tag = str;
            this.length = getLength(str.charAt(str.length() - 1));
        }

        @Override // org.apache.commons.compress.harmony.unpack200.NewAttributeBands.AttributeLayoutElement
        public void addToAttribute(int i5, NewAttribute newAttribute) {
            if (this.tag.startsWith("KI")) {
                newAttribute.addToBody(this.length, ((CPInteger[]) this.band)[i5]);
                return;
            }
            if (this.tag.startsWith("KJ")) {
                newAttribute.addToBody(this.length, ((CPLong[]) this.band)[i5]);
                return;
            }
            if (this.tag.startsWith("KF")) {
                newAttribute.addToBody(this.length, ((CPFloat[]) this.band)[i5]);
                return;
            }
            if (this.tag.startsWith("KD")) {
                newAttribute.addToBody(this.length, ((CPDouble[]) this.band)[i5]);
                return;
            }
            if (this.tag.startsWith("KS")) {
                newAttribute.addToBody(this.length, ((CPString[]) this.band)[i5]);
                return;
            }
            if (this.tag.startsWith("RC")) {
                newAttribute.addToBody(this.length, ((CPClass[]) this.band)[i5]);
                return;
            }
            if (this.tag.startsWith("RS")) {
                newAttribute.addToBody(this.length, ((CPUTF8[]) this.band)[i5]);
                return;
            }
            if (this.tag.startsWith("RD")) {
                newAttribute.addToBody(this.length, ((CPNameAndType[]) this.band)[i5]);
                return;
            }
            if (this.tag.startsWith("RF")) {
                newAttribute.addToBody(this.length, ((CPFieldRef[]) this.band)[i5]);
                return;
            }
            if (this.tag.startsWith("RM")) {
                newAttribute.addToBody(this.length, ((CPMethodRef[]) this.band)[i5]);
            } else if (this.tag.startsWith("RI")) {
                newAttribute.addToBody(this.length, ((CPInterfaceMethodRef[]) this.band)[i5]);
            } else if (this.tag.startsWith("RU")) {
                newAttribute.addToBody(this.length, ((CPUTF8[]) this.band)[i5]);
            }
        }

        public String getTag() {
            return this.tag;
        }

        @Override // org.apache.commons.compress.harmony.unpack200.NewAttributeBands.AttributeLayoutElement
        public void readBands(InputStream inputStream, int i5) {
            if (this.tag.startsWith("KI")) {
                NewAttributeBands newAttributeBands = NewAttributeBands.this;
                this.band = newAttributeBands.parseCPIntReferences(newAttributeBands.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i5);
                return;
            }
            if (this.tag.startsWith("KJ")) {
                NewAttributeBands newAttributeBands2 = NewAttributeBands.this;
                this.band = newAttributeBands2.parseCPLongReferences(newAttributeBands2.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i5);
                return;
            }
            if (this.tag.startsWith("KF")) {
                NewAttributeBands newAttributeBands3 = NewAttributeBands.this;
                this.band = newAttributeBands3.parseCPFloatReferences(newAttributeBands3.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i5);
                return;
            }
            if (this.tag.startsWith("KD")) {
                NewAttributeBands newAttributeBands4 = NewAttributeBands.this;
                this.band = newAttributeBands4.parseCPDoubleReferences(newAttributeBands4.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i5);
                return;
            }
            if (this.tag.startsWith("KS")) {
                NewAttributeBands newAttributeBands5 = NewAttributeBands.this;
                this.band = newAttributeBands5.parseCPStringReferences(newAttributeBands5.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i5);
                return;
            }
            if (this.tag.startsWith("RC")) {
                NewAttributeBands newAttributeBands6 = NewAttributeBands.this;
                this.band = newAttributeBands6.parseCPClassReferences(newAttributeBands6.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i5);
                return;
            }
            if (this.tag.startsWith("RS")) {
                NewAttributeBands newAttributeBands7 = NewAttributeBands.this;
                this.band = newAttributeBands7.parseCPSignatureReferences(newAttributeBands7.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i5);
                return;
            }
            if (this.tag.startsWith("RD")) {
                NewAttributeBands newAttributeBands8 = NewAttributeBands.this;
                this.band = newAttributeBands8.parseCPDescriptorReferences(newAttributeBands8.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i5);
                return;
            }
            if (this.tag.startsWith("RF")) {
                NewAttributeBands newAttributeBands9 = NewAttributeBands.this;
                this.band = newAttributeBands9.parseCPFieldRefReferences(newAttributeBands9.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i5);
                return;
            }
            if (this.tag.startsWith("RM")) {
                NewAttributeBands newAttributeBands10 = NewAttributeBands.this;
                this.band = newAttributeBands10.parseCPMethodRefReferences(newAttributeBands10.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i5);
            } else if (this.tag.startsWith("RI")) {
                NewAttributeBands newAttributeBands11 = NewAttributeBands.this;
                this.band = newAttributeBands11.parseCPInterfaceMethodRefReferences(newAttributeBands11.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i5);
            } else if (this.tag.startsWith("RU")) {
                NewAttributeBands newAttributeBands12 = NewAttributeBands.this;
                this.band = newAttributeBands12.parseCPUTF8References(newAttributeBands12.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i5);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Replication extends LayoutElement {
        private final Integral countElement;
        private final List layoutElements;

        public Replication(String str, String str2) throws IOException {
            super();
            this.layoutElements = new ArrayList();
            this.countElement = NewAttributeBands.this.new Integral(str);
            StringReader stringReader = new StringReader(str2);
            while (true) {
                LayoutElement nextLayoutElement = NewAttributeBands.this.readNextLayoutElement(stringReader);
                if (nextLayoutElement == null) {
                    return;
                } else {
                    this.layoutElements.add(nextLayoutElement);
                }
            }
        }

        @Override // org.apache.commons.compress.harmony.unpack200.NewAttributeBands.AttributeLayoutElement
        public void addToAttribute(int i5, NewAttribute newAttribute) {
            this.countElement.addToAttribute(i5, newAttribute);
            int value = 0;
            for (int i6 = 0; i6 < i5; i6++) {
                value = (int) (this.countElement.getValue(i6) + ((long) value));
            }
            long value2 = this.countElement.getValue(i5);
            for (int i7 = value; i7 < ((long) value) + value2; i7++) {
                for (int i8 = 0; i8 < this.layoutElements.size(); i8++) {
                    ((LayoutElement) this.layoutElements.get(i8)).addToAttribute(i7, newAttribute);
                }
            }
        }

        public Integral getCountElement() {
            return this.countElement;
        }

        public List getLayoutElements() {
            return this.layoutElements;
        }

        @Override // org.apache.commons.compress.harmony.unpack200.NewAttributeBands.AttributeLayoutElement
        public void readBands(InputStream inputStream, int i5) {
            this.countElement.readBands(inputStream, i5);
            int value = 0;
            for (int i6 = 0; i6 < i5; i6++) {
                value = (int) (this.countElement.getValue(i6) + ((long) value));
            }
            for (int i7 = 0; i7 < this.layoutElements.size(); i7++) {
                ((LayoutElement) this.layoutElements.get(i7)).readBands(inputStream, value);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Union extends LayoutElement {
        private int[] caseCounts;
        private final List defaultCaseBody;
        private int defaultCount;
        private final List unionCases;
        private final Integral unionTag;

        public Union(String str, List list, List list2) {
            super();
            this.unionTag = NewAttributeBands.this.new Integral(str);
            this.unionCases = list;
            this.defaultCaseBody = list2;
        }

        @Override // org.apache.commons.compress.harmony.unpack200.NewAttributeBands.AttributeLayoutElement
        public void addToAttribute(int i5, NewAttribute newAttribute) {
            this.unionTag.addToAttribute(i5, newAttribute);
            int[] iArr = this.unionTag.band;
            long value = this.unionTag.getValue(i5);
            int i6 = 0;
            boolean z6 = true;
            for (int i7 = 0; i7 < this.unionCases.size(); i7++) {
                UnionCase unionCase = (UnionCase) this.unionCases.get(i7);
                if (unionCase.hasTag(value)) {
                    for (int i8 = 0; i8 < i5; i8++) {
                        if (unionCase.hasTag(iArr[i8])) {
                            i6++;
                        }
                    }
                    unionCase.addToAttribute(i6, newAttribute);
                    z6 = false;
                }
            }
            if (z6) {
                int i9 = 0;
                for (int i10 = 0; i10 < i5; i10++) {
                    boolean z7 = false;
                    for (int i11 = 0; i11 < this.unionCases.size(); i11++) {
                        if (((UnionCase) this.unionCases.get(i11)).hasTag(iArr[i10])) {
                            z7 = true;
                        }
                    }
                    if (!z7) {
                        i9++;
                    }
                }
                if (this.defaultCaseBody != null) {
                    for (int i12 = 0; i12 < this.defaultCaseBody.size(); i12++) {
                        ((LayoutElement) this.defaultCaseBody.get(i12)).addToAttribute(i9, newAttribute);
                    }
                }
            }
        }

        public List getDefaultCaseBody() {
            return this.defaultCaseBody;
        }

        public List getUnionCases() {
            return this.unionCases;
        }

        public Integral getUnionTag() {
            return this.unionTag;
        }

        @Override // org.apache.commons.compress.harmony.unpack200.NewAttributeBands.AttributeLayoutElement
        public void readBands(InputStream inputStream, int i5) {
            this.unionTag.readBands(inputStream, i5);
            int[] iArr = this.unionTag.band;
            this.caseCounts = new int[this.unionCases.size()];
            for (int i6 = 0; i6 < this.caseCounts.length; i6++) {
                UnionCase unionCase = (UnionCase) this.unionCases.get(i6);
                for (int i7 : iArr) {
                    if (unionCase.hasTag(i7)) {
                        int[] iArr2 = this.caseCounts;
                        iArr2[i6] = iArr2[i6] + 1;
                    }
                }
                unionCase.readBands(inputStream, this.caseCounts[i6]);
            }
            for (int i8 : iArr) {
                boolean z6 = false;
                for (int i9 = 0; i9 < this.unionCases.size(); i9++) {
                    if (((UnionCase) this.unionCases.get(i9)).hasTag(i8)) {
                        z6 = true;
                    }
                }
                if (!z6) {
                    this.defaultCount++;
                }
            }
            if (this.defaultCaseBody != null) {
                for (int i10 = 0; i10 < this.defaultCaseBody.size(); i10++) {
                    ((LayoutElement) this.defaultCaseBody.get(i10)).readBands(inputStream, this.defaultCount);
                }
            }
        }
    }

    public NewAttributeBands(Segment segment, AttributeLayout attributeLayout) throws IOException {
        super(segment);
        this.attributeLayout = attributeLayout;
        parseLayout();
        attributeLayout.setBackwardsCallCount(this.backwardsCallCount);
    }

    private Attribute getOneAttribute(int i5, List list) {
        NewAttribute newAttribute = new NewAttribute(this.segment.getCpBands().cpUTF8Value(this.attributeLayout.getName()), this.attributeLayout.getIndex());
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((AttributeLayoutElement) list.get(i6)).addToAttribute(i5, newAttribute);
        }
        return newAttribute;
    }

    private StringReader getStreamUpToMatchingBracket(StringReader stringReader) {
        StringBuffer stringBuffer = new StringBuffer();
        int i5 = -1;
        while (i5 != 0) {
            char c = (char) stringReader.read();
            if (c == ']') {
                i5++;
            }
            if (c == '[') {
                i5--;
            }
            if (i5 != 0) {
                stringBuffer.append(c);
            }
        }
        return new StringReader(stringBuffer.toString());
    }

    private void parseLayout() throws IOException {
        if (this.attributeLayoutElements != null) {
            return;
        }
        this.attributeLayoutElements = new ArrayList();
        StringReader stringReader = new StringReader(this.attributeLayout.getLayout());
        while (true) {
            AttributeLayoutElement nextAttributeElement = readNextAttributeElement(stringReader);
            if (nextAttributeElement == null) {
                resolveCalls();
                return;
            }
            this.attributeLayoutElements.add(nextAttributeElement);
        }
    }

    private List readBody(StringReader stringReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            LayoutElement nextLayoutElement = readNextLayoutElement(stringReader);
            if (nextLayoutElement == null) {
                return arrayList;
            }
            arrayList.add(nextLayoutElement);
        }
    }

    private AttributeLayoutElement readNextAttributeElement(StringReader stringReader) throws IOException {
        stringReader.mark(1);
        int i5 = stringReader.read();
        if (i5 == -1) {
            return null;
        }
        if (i5 == 91) {
            return new Callable(readBody(getStreamUpToMatchingBracket(stringReader)));
        }
        stringReader.reset();
        return readNextLayoutElement(stringReader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LayoutElement readNextLayoutElement(StringReader stringReader) throws IOException {
        int i5 = stringReader.read();
        List body = null;
        if (i5 == -1) {
            return null;
        }
        if (i5 == 40) {
            int iIntValue = readNumber(stringReader).intValue();
            stringReader.read();
            return new Call(iIntValue);
        }
        if (i5 != 66) {
            if (i5 != 70) {
                if (i5 != 75) {
                    if (i5 != 86 && i5 != 72 && i5 != 73) {
                        switch (i5) {
                            case 78:
                                char c = (char) stringReader.read();
                                stringReader.read();
                                return new Replication(a.h("", c), readUpToMatchingBracket(stringReader));
                            case 79:
                                stringReader.mark(1);
                                if (stringReader.read() == 83) {
                                    return new Integral("OS" + ((char) stringReader.read()));
                                }
                                stringReader.reset();
                                return new Integral("O" + ((char) stringReader.read()));
                            case 80:
                                stringReader.mark(1);
                                if (stringReader.read() == 79) {
                                    return new Integral("PO" + ((char) stringReader.read()));
                                }
                                stringReader.reset();
                                return new Integral("P" + ((char) stringReader.read()));
                            default:
                                switch (i5) {
                                    case 82:
                                        break;
                                    case 83:
                                        break;
                                    case 84:
                                        String string = "" + ((char) stringReader.read());
                                        if (string.equals(ExifInterface.LATITUDE_SOUTH)) {
                                            StringBuilder sbR = androidx.collection.a.r(string);
                                            sbR.append((char) stringReader.read());
                                            string = sbR.toString();
                                        }
                                        ArrayList arrayList = new ArrayList();
                                        while (true) {
                                            UnionCase nextUnionCase = readNextUnionCase(stringReader);
                                            if (nextUnionCase == null) {
                                                stringReader.read();
                                                stringReader.read();
                                                stringReader.read();
                                                stringReader.mark(1);
                                                if (((char) stringReader.read()) != ']') {
                                                    stringReader.reset();
                                                    body = readBody(getStreamUpToMatchingBracket(stringReader));
                                                }
                                                return new Union(string, arrayList, body);
                                            }
                                            arrayList.add(nextUnionCase);
                                        }
                                        break;
                                    default:
                                        return null;
                                }
                                break;
                        }
                    }
                }
                StringBuilder sb = new StringBuilder("");
                sb.append((char) i5);
                sb.append((char) stringReader.read());
                char c6 = (char) stringReader.read();
                sb.append(c6);
                if (c6 == 'N') {
                    sb.append((char) stringReader.read());
                }
                return new Reference(sb.toString());
            }
            return new Integral(new String(new char[]{(char) i5, (char) stringReader.read()}));
        }
        return new Integral(new String(new char[]{(char) i5}));
    }

    private UnionCase readNextUnionCase(StringReader stringReader) throws IOException {
        Integer number;
        stringReader.mark(2);
        stringReader.read();
        if (((char) stringReader.read()) == ')') {
            stringReader.reset();
            return null;
        }
        stringReader.reset();
        stringReader.read();
        ArrayList arrayList = new ArrayList();
        do {
            number = readNumber(stringReader);
            if (number != null) {
                arrayList.add(number);
                stringReader.read();
            }
        } while (number != null);
        stringReader.read();
        stringReader.mark(1);
        if (((char) stringReader.read()) == ']') {
            return new UnionCase(arrayList);
        }
        stringReader.reset();
        return new UnionCase(arrayList, readBody(getStreamUpToMatchingBracket(stringReader)));
    }

    private Integer readNumber(StringReader stringReader) throws IOException {
        stringReader.mark(1);
        int i5 = 0;
        boolean z6 = ((char) stringReader.read()) == '-';
        if (!z6) {
            stringReader.reset();
        }
        stringReader.mark(100);
        while (true) {
            int i6 = stringReader.read();
            if (i6 == -1 || !Character.isDigit((char) i6)) {
                break;
            }
            i5++;
        }
        stringReader.reset();
        if (i5 == 0) {
            return null;
        }
        char[] cArr = new char[i5];
        if (stringReader.read(cArr) == i5) {
            return Integer.valueOf(Integer.parseInt((z6 ? ProcessIdUtil.DEFAULT_PROCESSID : "").concat(new String(cArr))));
        }
        throw new IOException("Error reading from the input stream");
    }

    private String readUpToMatchingBracket(StringReader stringReader) {
        StringBuffer stringBuffer = new StringBuffer();
        int i5 = -1;
        while (i5 != 0) {
            char c = (char) stringReader.read();
            if (c == ']') {
                i5++;
            }
            if (c == '[') {
                i5--;
            }
            if (i5 != 0) {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }

    private void resolveCalls() {
        int iResolveCallsForElement = 0;
        for (int i5 = 0; i5 < this.attributeLayoutElements.size(); i5++) {
            AttributeLayoutElement attributeLayoutElement = (AttributeLayoutElement) this.attributeLayoutElements.get(i5);
            if (attributeLayoutElement instanceof Callable) {
                Callable callable = (Callable) attributeLayoutElement;
                if (i5 == 0) {
                    callable.setFirstCallable(true);
                }
                List list = callable.body;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    iResolveCallsForElement += resolveCallsForElement(i5, callable, (LayoutElement) list.get(i6));
                }
            }
        }
        this.backwardsCallCount = iResolveCallsForElement;
    }

    private int resolveCallsForElement(int i5, Callable callable, LayoutElement layoutElement) {
        int iResolveCallsForElement = 0;
        if (layoutElement instanceof Call) {
            Call call = (Call) layoutElement;
            int i6 = call.callableIndex;
            if (i6 == 0) {
                call.setCallable(callable);
                return 1;
            }
            if (i6 <= 0) {
                for (int i7 = i5 - 1; i7 >= 0; i7--) {
                    AttributeLayoutElement attributeLayoutElement = (AttributeLayoutElement) this.attributeLayoutElements.get(i7);
                    if ((attributeLayoutElement instanceof Callable) && (i6 = i6 + 1) == 0) {
                        call.setCallable((Callable) attributeLayoutElement);
                        return 1;
                    }
                }
                return 1;
            }
            for (int i8 = i5 + 1; i8 < this.attributeLayoutElements.size(); i8++) {
                AttributeLayoutElement attributeLayoutElement2 = (AttributeLayoutElement) this.attributeLayoutElements.get(i8);
                if ((attributeLayoutElement2 instanceof Callable) && (i6 = i6 - 1) == 0) {
                    call.setCallable((Callable) attributeLayoutElement2);
                    return 0;
                }
            }
        } else if (layoutElement instanceof Replication) {
            Iterator it = ((Replication) layoutElement).layoutElements.iterator();
            while (it.hasNext()) {
                iResolveCallsForElement += resolveCallsForElement(i5, callable, (LayoutElement) it.next());
            }
        }
        return iResolveCallsForElement;
    }

    public int getBackwardsCallCount() {
        return this.backwardsCallCount;
    }

    public BHSDCodec getCodec(String str) {
        if (str.indexOf(79) >= 0) {
            return Codec.BRANCH5;
        }
        if (str.indexOf(80) >= 0) {
            return Codec.BCI5;
        }
        if (str.indexOf(83) < 0 || str.indexOf("KS") >= 0 || str.indexOf("RS") >= 0) {
            return str.indexOf(66) >= 0 ? Codec.BYTE1 : Codec.UNSIGNED5;
        }
        return Codec.SIGNED5;
    }

    public List parseAttributes(InputStream inputStream, int i5) {
        for (int i6 = 0; i6 < this.attributeLayoutElements.size(); i6++) {
            ((AttributeLayoutElement) this.attributeLayoutElements.get(i6)).readBands(inputStream, i5);
        }
        ArrayList arrayList = new ArrayList(i5);
        for (int i7 = 0; i7 < i5; i7++) {
            arrayList.add(getOneAttribute(i7, this.attributeLayoutElements));
        }
        return arrayList;
    }

    public void setBackwardsCalls(int[] iArr) throws IOException {
        parseLayout();
        int i5 = 0;
        for (int i6 = 0; i6 < this.attributeLayoutElements.size(); i6++) {
            AttributeLayoutElement attributeLayoutElement = (AttributeLayoutElement) this.attributeLayoutElements.get(i6);
            if (attributeLayoutElement instanceof Callable) {
                Callable callable = (Callable) attributeLayoutElement;
                if (callable.isBackwardsCallable()) {
                    callable.addCount(iArr[i5]);
                    i5++;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class UnionCase extends LayoutElement {
        private List body;
        private final List tags;

        public UnionCase(List list) {
            super();
            this.tags = list;
        }

        @Override // org.apache.commons.compress.harmony.unpack200.NewAttributeBands.AttributeLayoutElement
        public void addToAttribute(int i5, NewAttribute newAttribute) {
            if (this.body != null) {
                for (int i6 = 0; i6 < this.body.size(); i6++) {
                    ((LayoutElement) this.body.get(i6)).addToAttribute(i5, newAttribute);
                }
            }
        }

        public List getBody() {
            List list = this.body;
            return list == null ? Collections.EMPTY_LIST : list;
        }

        public boolean hasTag(long j6) {
            return this.tags.contains(Integer.valueOf((int) j6));
        }

        @Override // org.apache.commons.compress.harmony.unpack200.NewAttributeBands.AttributeLayoutElement
        public void readBands(InputStream inputStream, int i5) {
            if (this.body != null) {
                for (int i6 = 0; i6 < this.body.size(); i6++) {
                    ((LayoutElement) this.body.get(i6)).readBands(inputStream, i5);
                }
            }
        }

        public UnionCase(List list, List list2) {
            super();
            this.tags = list;
            this.body = list2;
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.BandSet
    public void unpack() {
    }

    @Override // org.apache.commons.compress.harmony.unpack200.BandSet
    public void read(InputStream inputStream) {
    }
}
