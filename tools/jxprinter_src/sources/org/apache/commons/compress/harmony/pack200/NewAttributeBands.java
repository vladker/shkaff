package org.apache.commons.compress.harmony.pack200;

import A3.AbstractC0157z;
import androidx.exifinterface.media.ExifInterface;
import androidx.exifinterface.media.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractC1125a;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.objectweb.asm.Label;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NewAttributeBands extends BandSet {
    protected List attributeLayoutElements;
    private int[] backwardsCallCounts;
    private final CpBands cpBands;
    private final AttributeDefinitionBands.AttributeDefinition def;
    private Integral lastPIntegral;
    private boolean usedAtLeastOnce;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface AttributeLayoutElement {
        void addAttributeToBand(NewAttribute newAttribute, InputStream inputStream);

        void pack(OutputStream outputStream);

        void renumberBci(IntList intList, Map map);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Callable implements AttributeLayoutElement {
        private int backwardsCallableIndex;
        private final List body;
        private boolean isBackwardsCallable;

        public Callable(List list) {
            this.body = list;
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void addAttributeToBand(NewAttribute newAttribute, InputStream inputStream) {
            Iterator it = this.body.iterator();
            while (it.hasNext()) {
                ((AttributeLayoutElement) it.next()).addAttributeToBand(newAttribute, inputStream);
            }
        }

        public void addBackwardsCall() {
            int[] iArr = NewAttributeBands.this.backwardsCallCounts;
            int i5 = this.backwardsCallableIndex;
            iArr[i5] = iArr[i5] + 1;
        }

        public List getBody() {
            return this.body;
        }

        public boolean isBackwardsCallable() {
            return this.isBackwardsCallable;
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void pack(OutputStream outputStream) {
            Iterator it = this.body.iterator();
            while (it.hasNext()) {
                ((AttributeLayoutElement) it.next()).pack(outputStream);
            }
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void renumberBci(IntList intList, Map map) {
            Iterator it = this.body.iterator();
            while (it.hasNext()) {
                ((AttributeLayoutElement) it.next()).renumberBci(intList, map);
            }
        }

        public void setBackwardsCallable() {
            this.isBackwardsCallable = true;
        }

        public void setBackwardsCallableIndex(int i5) {
            this.backwardsCallableIndex = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public abstract class LayoutElement implements AttributeLayoutElement {
        public LayoutElement() {
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

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void addAttributeToBand(NewAttribute newAttribute, InputStream inputStream) {
            this.countElement.addAttributeToBand(newAttribute, inputStream);
            int iLatestValue = this.countElement.latestValue();
            for (int i5 = 0; i5 < iLatestValue; i5++) {
                Iterator it = this.layoutElements.iterator();
                while (it.hasNext()) {
                    ((AttributeLayoutElement) it.next()).addAttributeToBand(newAttribute, inputStream);
                }
            }
        }

        public Integral getCountElement() {
            return this.countElement;
        }

        public List getLayoutElements() {
            return this.layoutElements;
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void pack(OutputStream outputStream) {
            this.countElement.pack(outputStream);
            Iterator it = this.layoutElements.iterator();
            while (it.hasNext()) {
                ((AttributeLayoutElement) it.next()).pack(outputStream);
            }
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void renumberBci(IntList intList, Map map) {
            Iterator it = this.layoutElements.iterator();
            while (it.hasNext()) {
                ((AttributeLayoutElement) it.next()).renumberBci(intList, map);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Union extends LayoutElement {
        private final List defaultCaseBody;
        private final List unionCases;
        private final Integral unionTag;

        public Union(String str, List list, List list2) {
            super();
            this.unionTag = NewAttributeBands.this.new Integral(str);
            this.unionCases = list;
            this.defaultCaseBody = list2;
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void addAttributeToBand(NewAttribute newAttribute, InputStream inputStream) {
            this.unionTag.addAttributeToBand(newAttribute, inputStream);
            long jLatestValue = this.unionTag.latestValue();
            boolean z6 = true;
            for (int i5 = 0; i5 < this.unionCases.size(); i5++) {
                UnionCase unionCase = (UnionCase) this.unionCases.get(i5);
                if (unionCase.hasTag(jLatestValue)) {
                    unionCase.addAttributeToBand(newAttribute, inputStream);
                    z6 = false;
                }
            }
            if (z6) {
                for (int i6 = 0; i6 < this.defaultCaseBody.size(); i6++) {
                    ((LayoutElement) this.defaultCaseBody.get(i6)).addAttributeToBand(newAttribute, inputStream);
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

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void pack(OutputStream outputStream) {
            this.unionTag.pack(outputStream);
            Iterator it = this.unionCases.iterator();
            while (it.hasNext()) {
                ((UnionCase) it.next()).pack(outputStream);
            }
            Iterator it2 = this.defaultCaseBody.iterator();
            while (it2.hasNext()) {
                ((AttributeLayoutElement) it2.next()).pack(outputStream);
            }
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void renumberBci(IntList intList, Map map) {
            Iterator it = this.unionCases.iterator();
            while (it.hasNext()) {
                ((UnionCase) it.next()).renumberBci(intList, map);
            }
            Iterator it2 = this.defaultCaseBody.iterator();
            while (it2.hasNext()) {
                ((AttributeLayoutElement) it2.next()).renumberBci(intList, map);
            }
        }
    }

    public NewAttributeBands(int i5, CpBands cpBands, SegmentHeader segmentHeader, AttributeDefinitionBands.AttributeDefinition attributeDefinition) throws IOException {
        super(i5, segmentHeader);
        this.def = attributeDefinition;
        this.cpBands = cpBands;
        parseLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
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
        String underlyingString = this.def.layout.getUnderlyingString();
        if (this.attributeLayoutElements != null) {
            return;
        }
        this.attributeLayoutElements = new ArrayList();
        StringReader stringReader = new StringReader(underlyingString);
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

    /* JADX INFO: Access modifiers changed from: private */
    public int readInteger(int i5, InputStream inputStream) {
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            try {
                i6 = (i6 << 8) | inputStream.read();
            } catch (IOException unused) {
                throw new RuntimeException("Error reading unknown attribute");
            }
        }
        if (i5 == 1) {
            i6 = (byte) i6;
        }
        return i5 == 2 ? (short) i6 : i6;
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
                                    return new Integral("OS" + ((char) stringReader.read()), this.lastPIntegral);
                                }
                                stringReader.reset();
                                return new Integral("O" + ((char) stringReader.read()), this.lastPIntegral);
                            case 80:
                                stringReader.mark(1);
                                if (stringReader.read() == 79) {
                                    Integral integral = new Integral("PO" + ((char) stringReader.read()), this.lastPIntegral);
                                    this.lastPIntegral = integral;
                                    return integral;
                                }
                                stringReader.reset();
                                Integral integral2 = new Integral("P" + ((char) stringReader.read()));
                                this.lastPIntegral = integral2;
                                return integral2;
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
        for (int i5 = 0; i5 < this.attributeLayoutElements.size(); i5++) {
            AttributeLayoutElement attributeLayoutElement = (AttributeLayoutElement) this.attributeLayoutElements.get(i5);
            if (attributeLayoutElement instanceof Callable) {
                Callable callable = (Callable) attributeLayoutElement;
                List list = callable.body;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    resolveCallsForElement(i5, callable, (LayoutElement) list.get(i6));
                }
            }
        }
        int i7 = 0;
        for (int i8 = 0; i8 < this.attributeLayoutElements.size(); i8++) {
            AttributeLayoutElement attributeLayoutElement2 = (AttributeLayoutElement) this.attributeLayoutElements.get(i8);
            if (attributeLayoutElement2 instanceof Callable) {
                Callable callable2 = (Callable) attributeLayoutElement2;
                if (callable2.isBackwardsCallable) {
                    callable2.setBackwardsCallableIndex(i7);
                    i7++;
                }
            }
        }
        this.backwardsCallCounts = new int[i7];
    }

    private void resolveCallsForElement(int i5, Callable callable, LayoutElement layoutElement) {
        if (!(layoutElement instanceof Call)) {
            if (layoutElement instanceof Replication) {
                Iterator it = ((Replication) layoutElement).layoutElements.iterator();
                while (it.hasNext()) {
                    resolveCallsForElement(i5, callable, (LayoutElement) it.next());
                }
                return;
            }
            return;
        }
        Call call = (Call) layoutElement;
        int i6 = call.callableIndex;
        if (i6 == 0) {
            call.setCallable(callable);
            return;
        }
        if (i6 <= 0) {
            for (int i7 = i5 - 1; i7 >= 0; i7--) {
                AttributeLayoutElement attributeLayoutElement = (AttributeLayoutElement) this.attributeLayoutElements.get(i7);
                if ((attributeLayoutElement instanceof Callable) && (i6 = i6 + 1) == 0) {
                    call.setCallable((Callable) attributeLayoutElement);
                    return;
                }
            }
            return;
        }
        while (true) {
            i5++;
            if (i5 >= this.attributeLayoutElements.size()) {
                return;
            }
            AttributeLayoutElement attributeLayoutElement2 = (AttributeLayoutElement) this.attributeLayoutElements.get(i5);
            if ((attributeLayoutElement2 instanceof Callable) && (i6 = i6 - 1) == 0) {
                call.setCallable((Callable) attributeLayoutElement2);
                return;
            }
        }
    }

    public void addAttribute(NewAttribute newAttribute) {
        this.usedAtLeastOnce = true;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(newAttribute.getBytes());
        Iterator it = this.attributeLayoutElements.iterator();
        while (it.hasNext()) {
            ((AttributeLayoutElement) it.next()).addAttributeToBand(newAttribute, byteArrayInputStream);
        }
    }

    public String getAttributeName() {
        return this.def.name.getUnderlyingString();
    }

    public int getFlagIndex() {
        return this.def.index;
    }

    public boolean isUsedAtLeastOnce() {
        return this.usedAtLeastOnce;
    }

    public int[] numBackwardsCalls() {
        return this.backwardsCallCounts;
    }

    @Override // org.apache.commons.compress.harmony.pack200.BandSet
    public void pack(OutputStream outputStream) {
        Iterator it = this.attributeLayoutElements.iterator();
        while (it.hasNext()) {
            ((AttributeLayoutElement) it.next()).pack(outputStream);
        }
    }

    public void renumberBci(IntList intList, Map map) {
        Iterator it = this.attributeLayoutElements.iterator();
        while (it.hasNext()) {
            ((AttributeLayoutElement) it.next()).renumberBci(intList, map);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class UnionCase extends LayoutElement {
        private final List body;
        private final List tags;

        public UnionCase(List list) {
            super();
            this.tags = list;
            this.body = Collections.EMPTY_LIST;
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void addAttributeToBand(NewAttribute newAttribute, InputStream inputStream) {
            for (int i5 = 0; i5 < this.body.size(); i5++) {
                ((LayoutElement) this.body.get(i5)).addAttributeToBand(newAttribute, inputStream);
            }
        }

        public List getBody() {
            return this.body;
        }

        public boolean hasTag(long j6) {
            return this.tags.contains(Integer.valueOf((int) j6));
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void pack(OutputStream outputStream) {
            for (int i5 = 0; i5 < this.body.size(); i5++) {
                ((LayoutElement) this.body.get(i5)).pack(outputStream);
            }
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void renumberBci(IntList intList, Map map) {
            for (int i5 = 0; i5 < this.body.size(); i5++) {
                ((LayoutElement) this.body.get(i5)).renumberBci(intList, map);
            }
        }

        public UnionCase(List list, List list2) {
            super();
            this.tags = list;
            this.body = list2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Integral extends LayoutElement {
        private final List band;
        private final BHSDCodec defaultCodec;
        private Integral previousIntegral;
        private int previousPValue;
        private final String tag;

        public Integral(String str) {
            super();
            this.band = new ArrayList();
            this.tag = str;
            this.defaultCodec = NewAttributeBands.this.getCodec(str);
        }

        private void renumberOffsetBci(List list, IntList intList, Map map) {
            for (int size = this.band.size() - 1; size >= 0; size--) {
                Object obj = this.band.get(size);
                if (obj instanceof Integer) {
                    return;
                }
                if (obj instanceof Label) {
                    this.band.remove(size);
                    this.band.add(size, Integer.valueOf(intList.get(((Integer) map.get(obj)).intValue()) - ((Integer) list.get(size)).intValue()));
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:46:0x0128  */
        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void addAttributeToBand(NewAttribute newAttribute, InputStream inputStream) {
            int integer;
            int integer2;
            Label labelValueOf = null;
            if (this.tag.equals("B") || this.tag.equals("FB")) {
                integer = NewAttributeBands.this.readInteger(1, inputStream) & 255;
            } else if (this.tag.equals("SB")) {
                integer = NewAttributeBands.this.readInteger(1, inputStream);
            } else if (this.tag.equals("H") || this.tag.equals("FH")) {
                integer = NewAttributeBands.this.readInteger(2, inputStream) & 65535;
            } else if (this.tag.equals("SH")) {
                integer = NewAttributeBands.this.readInteger(2, inputStream);
            } else if (this.tag.equals("I") || this.tag.equals("FI") || this.tag.equals("SI")) {
                integer = NewAttributeBands.this.readInteger(4, inputStream);
            } else if (this.tag.equals(ExifInterface.GPS_MEASUREMENT_INTERRUPTED) || this.tag.equals("FV") || this.tag.equals("SV")) {
                integer = 0;
            } else {
                if (this.tag.startsWith("PO") || this.tag.startsWith("OS")) {
                    integer2 = NewAttributeBands.this.readInteger(getLength(this.tag.substring(2).toCharArray()[0]), inputStream) + this.previousIntegral.previousPValue;
                    labelValueOf = newAttribute.getLabel(integer2);
                    this.previousPValue = integer2;
                } else if (this.tag.startsWith("P")) {
                    integer2 = NewAttributeBands.this.readInteger(getLength(this.tag.substring(1).toCharArray()[0]), inputStream);
                    labelValueOf = newAttribute.getLabel(integer2);
                    this.previousPValue = integer2;
                } else if (this.tag.startsWith("O")) {
                    integer2 = NewAttributeBands.this.readInteger(getLength(this.tag.substring(1).toCharArray()[0]), inputStream) + this.previousIntegral.previousPValue;
                    labelValueOf = newAttribute.getLabel(integer2);
                    this.previousPValue = integer2;
                } else {
                    integer = 0;
                }
                integer = integer2;
            }
            if (labelValueOf == null) {
                labelValueOf = Integer.valueOf(integer);
            }
            this.band.add(labelValueOf);
        }

        public String getTag() {
            return this.tag;
        }

        public int latestValue() {
            return ((Integer) AbstractC0157z.f(1, this.band)).intValue();
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void pack(OutputStream outputStream) {
            PackingUtils.log("Writing new attribute bands...");
            NewAttributeBands newAttributeBands = NewAttributeBands.this;
            byte[] bArrEncodeBandInt = newAttributeBands.encodeBandInt(this.tag, newAttributeBands.integerListToArray(this.band), this.defaultCodec);
            StringBuilder sbI = AbstractC1125a.i(outputStream, bArrEncodeBandInt, "Wrote ");
            sbI.append(bArrEncodeBandInt.length);
            sbI.append(" bytes from ");
            sbI.append(this.tag);
            sbI.append("[");
            AbstractC1125a.o(this.band, sbI, "]");
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void renumberBci(IntList intList, Map map) {
            if (this.tag.startsWith("O") || this.tag.startsWith("PO")) {
                renumberOffsetBci(this.previousIntegral.band, intList, map);
                return;
            }
            if (this.tag.startsWith("P")) {
                for (int size = this.band.size() - 1; size >= 0; size--) {
                    Object obj = this.band.get(size);
                    if (obj instanceof Integer) {
                        return;
                    }
                    if (obj instanceof Label) {
                        this.band.remove(size);
                        this.band.add(size, Integer.valueOf(intList.get(((Integer) map.get(obj)).intValue())));
                    }
                }
            }
        }

        public Integral(String str, Integral integral) {
            super();
            this.band = new ArrayList();
            this.tag = str;
            this.defaultCodec = NewAttributeBands.this.getCodec(str);
            this.previousIntegral = integral;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Call extends LayoutElement {
        private Callable callable;
        private final int callableIndex;

        public Call(int i5) {
            super();
            this.callableIndex = i5;
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void addAttributeToBand(NewAttribute newAttribute, InputStream inputStream) {
            this.callable.addAttributeToBand(newAttribute, inputStream);
            if (this.callableIndex < 1) {
                this.callable.addBackwardsCall();
            }
        }

        public Callable getCallable() {
            return this.callable;
        }

        public int getCallableIndex() {
            return this.callableIndex;
        }

        public void setCallable(Callable callable) {
            this.callable = callable;
            if (this.callableIndex < 1) {
                callable.setBackwardsCallable();
            }
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void pack(OutputStream outputStream) {
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void renumberBci(IntList intList, Map map) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Reference extends LayoutElement {
        private List band;
        private boolean nullsAllowed;
        private final String tag;

        public Reference(String str) {
            super();
            this.nullsAllowed = false;
            this.tag = str;
            this.nullsAllowed = str.indexOf(78) != -1;
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void addAttributeToBand(NewAttribute newAttribute, InputStream inputStream) {
            int integer = NewAttributeBands.this.readInteger(4, inputStream);
            if (this.tag.startsWith("RC")) {
                this.band.add(NewAttributeBands.this.cpBands.getCPClass(newAttribute.readClass(integer)));
                return;
            }
            if (this.tag.startsWith("RU")) {
                this.band.add(NewAttributeBands.this.cpBands.getCPUtf8(newAttribute.readUTF8(integer)));
            } else if (this.tag.startsWith("RS")) {
                this.band.add(NewAttributeBands.this.cpBands.getCPSignature(newAttribute.readUTF8(integer)));
            } else {
                this.band.add(NewAttributeBands.this.cpBands.getConstant(newAttribute.readConst(integer)));
            }
        }

        public String getTag() {
            return this.tag;
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void pack(OutputStream outputStream) {
            int[] iArrCpEntryOrNullListToArray = this.nullsAllowed ? NewAttributeBands.this.cpEntryOrNullListToArray(this.band) : NewAttributeBands.this.cpEntryListToArray(this.band);
            byte[] bArrEncodeBandInt = NewAttributeBands.this.encodeBandInt(this.tag, iArrCpEntryOrNullListToArray, Codec.UNSIGNED5);
            StringBuilder sbI = AbstractC1125a.i(outputStream, bArrEncodeBandInt, "Wrote ");
            sbI.append(bArrEncodeBandInt.length);
            sbI.append(" bytes from ");
            sbI.append(this.tag);
            sbI.append("[");
            AbstractC1125a.m("]", iArrCpEntryOrNullListToArray.length, sbI);
        }

        @Override // org.apache.commons.compress.harmony.pack200.NewAttributeBands.AttributeLayoutElement
        public void renumberBci(IntList intList, Map map) {
        }
    }
}
