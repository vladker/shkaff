package org.apache.commons.compress.harmony.pack200;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractC1125a;
import org.objectweb.asm.Attribute;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AttributeDefinitionBands extends BandSet {
    public static final int CONTEXT_CLASS = 0;
    public static final int CONTEXT_CODE = 3;
    public static final int CONTEXT_FIELD = 1;
    public static final int CONTEXT_METHOD = 2;
    private final List attributeDefinitions;
    private final List classAttributeLayouts;
    private final List codeAttributeLayouts;
    private final CpBands cpBands;
    private final List fieldAttributeLayouts;
    private final List methodAttributeLayouts;
    private final Segment segment;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class AttributeDefinition {
        public int contextType;
        public int index;
        public CPUTF8 layout;
        public CPUTF8 name;

        public AttributeDefinition(int i5, int i6, CPUTF8 cputf8, CPUTF8 cputf9) {
            this.index = i5;
            this.contextType = i6;
            this.name = cputf8;
            this.layout = cputf9;
        }
    }

    public AttributeDefinitionBands(Segment segment, int i5, Attribute[] attributeArr) {
        super(i5, segment.getSegmentHeader());
        this.classAttributeLayouts = new ArrayList();
        this.methodAttributeLayouts = new ArrayList();
        this.fieldAttributeLayouts = new ArrayList();
        this.codeAttributeLayouts = new ArrayList();
        this.attributeDefinitions = new ArrayList();
        this.cpBands = segment.getCpBands();
        this.segment = segment;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        for (Attribute attribute : attributeArr) {
            NewAttribute newAttribute = (NewAttribute) attribute;
            if (!(newAttribute instanceof NewAttribute.ErrorAttribute) && !(newAttribute instanceof NewAttribute.PassAttribute) && !(newAttribute instanceof NewAttribute.StripAttribute)) {
                if (newAttribute.isContextClass()) {
                    map.put(newAttribute.type, newAttribute.getLayout());
                }
                if (newAttribute.isContextMethod()) {
                    map2.put(newAttribute.type, newAttribute.getLayout());
                }
                if (newAttribute.isContextField()) {
                    map3.put(newAttribute.type, newAttribute.getLayout());
                }
                if (newAttribute.isContextCode()) {
                    map4.put(newAttribute.type, newAttribute.getLayout());
                }
            }
        }
        if (map.size() > 7) {
            this.segmentHeader.setHave_class_flags_hi(true);
        }
        if (map2.size() > 6) {
            this.segmentHeader.setHave_method_flags_hi(true);
        }
        if (map3.size() > 10) {
            this.segmentHeader.setHave_field_flags_hi(true);
        }
        if (map4.size() > 15) {
            this.segmentHeader.setHave_code_flags_hi(true);
        }
        int[] iArr = {25, 26, 27, 28, 29, 30, 31};
        addAttributeDefinitions(map, map.size() > 7 ? addHighIndices(iArr) : iArr, 0);
        int[] iArr2 = {26, 27, 28, 29, 30, 31};
        addAttributeDefinitions(map2, this.methodAttributeLayouts.size() > 6 ? addHighIndices(iArr2) : iArr2, 2);
        int[] iArr3 = {18, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        addAttributeDefinitions(map3, this.fieldAttributeLayouts.size() > 10 ? addHighIndices(iArr3) : iArr3, 1);
        int[] iArr4 = {17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        addAttributeDefinitions(map4, this.codeAttributeLayouts.size() > 15 ? addHighIndices(iArr4) : iArr4, 3);
    }

    private void addAttributeDefinitions(Map map, int[] iArr, int i5) {
        for (String str : map.keySet()) {
            AttributeDefinition attributeDefinition = new AttributeDefinition(iArr[0], i5, this.cpBands.getCPUtf8(str), this.cpBands.getCPUtf8((String) map.get(str)));
            this.attributeDefinitions.add(attributeDefinition);
            if (i5 == 0) {
                this.classAttributeLayouts.add(attributeDefinition);
            } else if (i5 == 1) {
                this.fieldAttributeLayouts.add(attributeDefinition);
            } else if (i5 == 2) {
                this.methodAttributeLayouts.add(attributeDefinition);
            } else if (i5 == 3) {
                this.codeAttributeLayouts.add(attributeDefinition);
            }
        }
    }

    private int[] addHighIndices(int[] iArr) {
        int i5 = 32;
        int length = iArr.length + 32;
        int[] iArr2 = new int[length];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            iArr2[i6] = iArr[i6];
        }
        for (int length2 = iArr.length; length2 < length; length2++) {
            iArr2[length2] = i5;
            i5++;
        }
        return iArr2;
    }

    private void addSyntheticDefinitions() {
        boolean zIsAnySyntheticClasses = this.segment.getClassBands().isAnySyntheticClasses();
        boolean zIsAnySyntheticMethods = this.segment.getClassBands().isAnySyntheticMethods();
        boolean zIsAnySyntheticFields = this.segment.getClassBands().isAnySyntheticFields();
        if (zIsAnySyntheticClasses || zIsAnySyntheticMethods || zIsAnySyntheticFields) {
            CPUTF8 cPUtf8 = this.cpBands.getCPUtf8("Synthetic");
            CPUTF8 cPUtf9 = this.cpBands.getCPUtf8("");
            if (zIsAnySyntheticClasses) {
                this.attributeDefinitions.add(new AttributeDefinition(12, 0, cPUtf8, cPUtf9));
            }
            if (zIsAnySyntheticMethods) {
                this.attributeDefinitions.add(new AttributeDefinition(12, 2, cPUtf8, cPUtf9));
            }
            if (zIsAnySyntheticFields) {
                this.attributeDefinitions.add(new AttributeDefinition(12, 1, cPUtf8, cPUtf9));
            }
        }
    }

    public void finaliseBands() {
        addSyntheticDefinitions();
        this.segmentHeader.setAttribute_definition_count(this.attributeDefinitions.size());
    }

    public List getClassAttributeLayouts() {
        return this.classAttributeLayouts;
    }

    public List getCodeAttributeLayouts() {
        return this.codeAttributeLayouts;
    }

    public List getFieldAttributeLayouts() {
        return this.fieldAttributeLayouts;
    }

    public List getMethodAttributeLayouts() {
        return this.methodAttributeLayouts;
    }

    @Override // org.apache.commons.compress.harmony.pack200.BandSet
    public void pack(OutputStream outputStream) {
        PackingUtils.log("Writing attribute definition bands...");
        int size = this.attributeDefinitions.size();
        int[] iArr = new int[size];
        int size2 = this.attributeDefinitions.size();
        int[] iArr2 = new int[size2];
        int size3 = this.attributeDefinitions.size();
        int[] iArr3 = new int[size3];
        for (int i5 = 0; i5 < size3; i5++) {
            AttributeDefinition attributeDefinition = (AttributeDefinition) this.attributeDefinitions.get(i5);
            iArr[i5] = attributeDefinition.contextType | ((attributeDefinition.index + 1) << 2);
            iArr2[i5] = attributeDefinition.name.getIndex();
            iArr3[i5] = attributeDefinition.layout.getIndex();
        }
        byte[] bArrEncodeBandInt = encodeBandInt("attributeDefinitionHeader", iArr, Codec.BYTE1);
        AbstractC1125a.n(AbstractC1125a.i(outputStream, bArrEncodeBandInt, "Wrote "), bArrEncodeBandInt.length, " bytes from attributeDefinitionHeader[", size, "]");
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        byte[] bArrEncodeBandInt2 = encodeBandInt("attributeDefinitionName", iArr2, bHSDCodec);
        AbstractC1125a.n(AbstractC1125a.i(outputStream, bArrEncodeBandInt2, "Wrote "), bArrEncodeBandInt2.length, " bytes from attributeDefinitionName[", size2, "]");
        byte[] bArrEncodeBandInt3 = encodeBandInt("attributeDefinitionLayout", iArr3, bHSDCodec);
        AbstractC1125a.n(AbstractC1125a.i(outputStream, bArrEncodeBandInt3, "Wrote "), bArrEncodeBandInt3.length, " bytes from attributeDefinitionLayout[", size3, "]");
    }
}
