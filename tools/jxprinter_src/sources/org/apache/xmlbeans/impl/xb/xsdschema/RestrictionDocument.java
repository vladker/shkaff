package org.apache.xmlbeans.impl.xb.xsdschema;

import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface RestrictionDocument extends XmlObject {
    public static final DocumentFactory<RestrictionDocument> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Restriction extends Annotated {
        public static final ElementFactory<Restriction> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<Restriction> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "restrictionad11elemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        NoFixedFacet addNewEnumeration();

        NumFacet addNewFractionDigits();

        NumFacet addNewLength();

        Facet addNewMaxExclusive();

        Facet addNewMaxInclusive();

        NumFacet addNewMaxLength();

        Facet addNewMinExclusive();

        Facet addNewMinInclusive();

        NumFacet addNewMinLength();

        PatternDocument.Pattern addNewPattern();

        LocalSimpleType addNewSimpleType();

        TotalDigitsDocument.TotalDigits addNewTotalDigits();

        WhiteSpaceDocument.WhiteSpace addNewWhiteSpace();

        QName getBase();

        NoFixedFacet getEnumerationArray(int i5);

        NoFixedFacet[] getEnumerationArray();

        List<NoFixedFacet> getEnumerationList();

        NumFacet getFractionDigitsArray(int i5);

        NumFacet[] getFractionDigitsArray();

        List<NumFacet> getFractionDigitsList();

        NumFacet getLengthArray(int i5);

        NumFacet[] getLengthArray();

        List<NumFacet> getLengthList();

        Facet getMaxExclusiveArray(int i5);

        Facet[] getMaxExclusiveArray();

        List<Facet> getMaxExclusiveList();

        Facet getMaxInclusiveArray(int i5);

        Facet[] getMaxInclusiveArray();

        List<Facet> getMaxInclusiveList();

        NumFacet getMaxLengthArray(int i5);

        NumFacet[] getMaxLengthArray();

        List<NumFacet> getMaxLengthList();

        Facet getMinExclusiveArray(int i5);

        Facet[] getMinExclusiveArray();

        List<Facet> getMinExclusiveList();

        Facet getMinInclusiveArray(int i5);

        Facet[] getMinInclusiveArray();

        List<Facet> getMinInclusiveList();

        NumFacet getMinLengthArray(int i5);

        NumFacet[] getMinLengthArray();

        List<NumFacet> getMinLengthList();

        PatternDocument.Pattern getPatternArray(int i5);

        PatternDocument.Pattern[] getPatternArray();

        List<PatternDocument.Pattern> getPatternList();

        LocalSimpleType getSimpleType();

        TotalDigitsDocument.TotalDigits getTotalDigitsArray(int i5);

        TotalDigitsDocument.TotalDigits[] getTotalDigitsArray();

        List<TotalDigitsDocument.TotalDigits> getTotalDigitsList();

        WhiteSpaceDocument.WhiteSpace getWhiteSpaceArray(int i5);

        WhiteSpaceDocument.WhiteSpace[] getWhiteSpaceArray();

        List<WhiteSpaceDocument.WhiteSpace> getWhiteSpaceList();

        NoFixedFacet insertNewEnumeration(int i5);

        NumFacet insertNewFractionDigits(int i5);

        NumFacet insertNewLength(int i5);

        Facet insertNewMaxExclusive(int i5);

        Facet insertNewMaxInclusive(int i5);

        NumFacet insertNewMaxLength(int i5);

        Facet insertNewMinExclusive(int i5);

        Facet insertNewMinInclusive(int i5);

        NumFacet insertNewMinLength(int i5);

        PatternDocument.Pattern insertNewPattern(int i5);

        TotalDigitsDocument.TotalDigits insertNewTotalDigits(int i5);

        WhiteSpaceDocument.WhiteSpace insertNewWhiteSpace(int i5);

        boolean isSetBase();

        boolean isSetSimpleType();

        void removeEnumeration(int i5);

        void removeFractionDigits(int i5);

        void removeLength(int i5);

        void removeMaxExclusive(int i5);

        void removeMaxInclusive(int i5);

        void removeMaxLength(int i5);

        void removeMinExclusive(int i5);

        void removeMinInclusive(int i5);

        void removeMinLength(int i5);

        void removePattern(int i5);

        void removeTotalDigits(int i5);

        void removeWhiteSpace(int i5);

        void setBase(QName qName);

        void setEnumerationArray(int i5, NoFixedFacet noFixedFacet);

        void setEnumerationArray(NoFixedFacet[] noFixedFacetArr);

        void setFractionDigitsArray(int i5, NumFacet numFacet);

        void setFractionDigitsArray(NumFacet[] numFacetArr);

        void setLengthArray(int i5, NumFacet numFacet);

        void setLengthArray(NumFacet[] numFacetArr);

        void setMaxExclusiveArray(int i5, Facet facet);

        void setMaxExclusiveArray(Facet[] facetArr);

        void setMaxInclusiveArray(int i5, Facet facet);

        void setMaxInclusiveArray(Facet[] facetArr);

        void setMaxLengthArray(int i5, NumFacet numFacet);

        void setMaxLengthArray(NumFacet[] numFacetArr);

        void setMinExclusiveArray(int i5, Facet facet);

        void setMinExclusiveArray(Facet[] facetArr);

        void setMinInclusiveArray(int i5, Facet facet);

        void setMinInclusiveArray(Facet[] facetArr);

        void setMinLengthArray(int i5, NumFacet numFacet);

        void setMinLengthArray(NumFacet[] numFacetArr);

        void setPatternArray(int i5, PatternDocument.Pattern pattern);

        void setPatternArray(PatternDocument.Pattern[] patternArr);

        void setSimpleType(LocalSimpleType localSimpleType);

        void setTotalDigitsArray(int i5, TotalDigitsDocument.TotalDigits totalDigits);

        void setTotalDigitsArray(TotalDigitsDocument.TotalDigits[] totalDigitsArr);

        void setWhiteSpaceArray(int i5, WhiteSpaceDocument.WhiteSpace whiteSpace);

        void setWhiteSpaceArray(WhiteSpaceDocument.WhiteSpace[] whiteSpaceArr);

        int sizeOfEnumerationArray();

        int sizeOfFractionDigitsArray();

        int sizeOfLengthArray();

        int sizeOfMaxExclusiveArray();

        int sizeOfMaxInclusiveArray();

        int sizeOfMaxLengthArray();

        int sizeOfMinExclusiveArray();

        int sizeOfMinInclusiveArray();

        int sizeOfMinLengthArray();

        int sizeOfPatternArray();

        int sizeOfTotalDigitsArray();

        int sizeOfWhiteSpaceArray();

        void unsetBase();

        void unsetSimpleType();

        XmlQName xgetBase();

        void xsetBase(XmlQName xmlQName);
    }

    static {
        DocumentFactory<RestrictionDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "restriction0049doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Restriction addNewRestriction();

    Restriction getRestriction();

    void setRestriction(Restriction restriction);
}
