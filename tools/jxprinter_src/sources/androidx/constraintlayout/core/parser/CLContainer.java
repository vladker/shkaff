package androidx.constraintlayout.core.parser;

import A3.AbstractC0157z;
import androidx.annotation.NonNull;
import androidx.collection.a;
import java.util.ArrayList;
import java.util.Objects;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class CLContainer extends CLElement {
    ArrayList<CLElement> mElements;

    public CLContainer(char[] cArr) {
        super(cArr);
        this.mElements = new ArrayList<>();
    }

    public static CLElement allocate(char[] cArr) {
        return new CLContainer(cArr);
    }

    public void add(CLElement cLElement) {
        this.mElements.add(cLElement);
        if (CLParser.sDebug) {
            System.out.println("added element " + cLElement + " to " + this);
        }
    }

    public void clear() {
        this.mElements.clear();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CLContainer) {
            return this.mElements.equals(((CLContainer) obj).mElements);
        }
        return false;
    }

    public CLElement get(String str) throws CLParsingException {
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            CLElement cLElement = arrayList.get(i5);
            i5++;
            CLKey cLKey = (CLKey) cLElement;
            if (cLKey.content().equals(str)) {
                return cLKey.getValue();
            }
        }
        throw new CLParsingException(AbstractC0157z.o("no element for key <", str, ">"), this);
    }

    public CLArray getArray(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLArray) {
            return (CLArray) cLElement;
        }
        StringBuilder sbY = AbstractC0157z.y("no array found for key <", str, ">, found [");
        sbY.append(cLElement.getStrClass());
        sbY.append("] : ");
        sbY.append(cLElement);
        throw new CLParsingException(sbY.toString(), this);
    }

    public CLArray getArrayOrCreate(String str) {
        CLArray arrayOrNull = getArrayOrNull(str);
        if (arrayOrNull != null) {
            return arrayOrNull;
        }
        CLArray cLArray = new CLArray(new char[0]);
        put(str, cLArray);
        return cLArray;
    }

    public CLArray getArrayOrNull(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLArray) {
            return (CLArray) orNull;
        }
        return null;
    }

    public boolean getBoolean(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLToken) {
            return ((CLToken) cLElement).getBoolean();
        }
        StringBuilder sbY = AbstractC0157z.y("no boolean found for key <", str, ">, found [");
        sbY.append(cLElement.getStrClass());
        sbY.append("] : ");
        sbY.append(cLElement);
        throw new CLParsingException(sbY.toString(), this);
    }

    public float getFloat(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement != null) {
            return cLElement.getFloat();
        }
        StringBuilder sbY = AbstractC0157z.y("no float found for key <", str, ">, found [");
        sbY.append(cLElement.getStrClass());
        sbY.append("] : ");
        sbY.append(cLElement);
        throw new CLParsingException(sbY.toString(), this);
    }

    public float getFloatOrNaN(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLNumber) {
            return orNull.getFloat();
        }
        return Float.NaN;
    }

    public int getInt(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement != null) {
            return cLElement.getInt();
        }
        StringBuilder sbY = AbstractC0157z.y("no int found for key <", str, ">, found [");
        sbY.append(cLElement.getStrClass());
        sbY.append("] : ");
        sbY.append(cLElement);
        throw new CLParsingException(sbY.toString(), this);
    }

    public CLObject getObject(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLObject) {
            return (CLObject) cLElement;
        }
        StringBuilder sbY = AbstractC0157z.y("no object found for key <", str, ">, found [");
        sbY.append(cLElement.getStrClass());
        sbY.append("] : ");
        sbY.append(cLElement);
        throw new CLParsingException(sbY.toString(), this);
    }

    public CLObject getObjectOrNull(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLObject) {
            return (CLObject) orNull;
        }
        return null;
    }

    public CLElement getOrNull(String str) {
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            CLElement cLElement = arrayList.get(i5);
            i5++;
            CLKey cLKey = (CLKey) cLElement;
            if (cLKey.content().equals(str)) {
                return cLKey.getValue();
            }
        }
        return null;
    }

    public String getString(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLString) {
            return cLElement.content();
        }
        StringBuilder sbU = a.u("no string found for key <", str, ">, found [", cLElement != null ? cLElement.getStrClass() : null, "] : ");
        sbU.append(cLElement);
        throw new CLParsingException(sbU.toString(), this);
    }

    public String getStringOrNull(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLString) {
            return orNull.content();
        }
        return null;
    }

    public boolean has(String str) {
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            CLElement cLElement = arrayList.get(i5);
            i5++;
            CLElement cLElement2 = cLElement;
            if ((cLElement2 instanceof CLKey) && ((CLKey) cLElement2).content().equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int hashCode() {
        return Objects.hash(this.mElements, Integer.valueOf(super.hashCode()));
    }

    public ArrayList<String> names() {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<CLElement> arrayList2 = this.mElements;
        int size = arrayList2.size();
        int i5 = 0;
        while (i5 < size) {
            CLElement cLElement = arrayList2.get(i5);
            i5++;
            CLElement cLElement2 = cLElement;
            if (cLElement2 instanceof CLKey) {
                arrayList.add(((CLKey) cLElement2).content());
            }
        }
        return arrayList;
    }

    public void put(String str, CLElement cLElement) {
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            CLElement cLElement2 = arrayList.get(i5);
            i5++;
            CLKey cLKey = (CLKey) cLElement2;
            if (cLKey.content().equals(str)) {
                cLKey.set(cLElement);
                return;
            }
        }
        this.mElements.add((CLKey) CLKey.allocate(str, cLElement));
    }

    public void putNumber(String str, float f6) {
        put(str, new CLNumber(f6));
    }

    public void putString(String str, String str2) {
        CLString cLString = new CLString(str2.toCharArray());
        cLString.setStart(0L);
        cLString.setEnd(str2.length() - 1);
        put(str, cLString);
    }

    public void remove(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList<CLElement> arrayList2 = this.mElements;
        int size = arrayList2.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            CLElement cLElement = arrayList2.get(i6);
            i6++;
            CLElement cLElement2 = cLElement;
            if (((CLKey) cLElement2).content().equals(str)) {
                arrayList.add(cLElement2);
            }
        }
        int size2 = arrayList.size();
        while (i5 < size2) {
            Object obj = arrayList.get(i5);
            i5++;
            this.mElements.remove((CLElement) obj);
        }
    }

    public int size() {
        return this.mElements.size();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            CLElement cLElement = arrayList.get(i5);
            i5++;
            CLElement cLElement2 = cLElement;
            if (sb.length() > 0) {
                sb.append(VectorFormat.DEFAULT_SEPARATOR);
            }
            sb.append(cLElement2);
        }
        return super.toString() + " = <" + ((Object) sb) + " >";
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    @NonNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CLContainer mo968clone() {
        CLContainer cLContainer = (CLContainer) super.mo968clone();
        ArrayList<CLElement> arrayList = new ArrayList<>(this.mElements.size());
        ArrayList<CLElement> arrayList2 = this.mElements;
        int size = arrayList2.size();
        int i5 = 0;
        while (i5 < size) {
            CLElement cLElement = arrayList2.get(i5);
            i5++;
            CLElement cLElementMo968clone = cLElement.mo968clone();
            cLElementMo968clone.setContainer(cLContainer);
            arrayList.add(cLElementMo968clone);
        }
        cLContainer.mElements = arrayList;
        return cLContainer;
    }

    public String getStringOrNull(int i5) {
        CLElement orNull = getOrNull(i5);
        if (orNull instanceof CLString) {
            return orNull.content();
        }
        return null;
    }

    public CLElement getOrNull(int i5) {
        if (i5 < 0 || i5 >= this.mElements.size()) {
            return null;
        }
        return this.mElements.get(i5);
    }

    public float getFloat(int i5) throws CLParsingException {
        CLElement cLElement = get(i5);
        if (cLElement != null) {
            return cLElement.getFloat();
        }
        throw new CLParsingException(AbstractC0157z.k(i5, "no float at index "), this);
    }

    public int getInt(int i5) throws CLParsingException {
        CLElement cLElement = get(i5);
        if (cLElement != null) {
            return cLElement.getInt();
        }
        throw new CLParsingException(AbstractC0157z.k(i5, "no int at index "), this);
    }

    public CLArray getArray(int i5) throws CLParsingException {
        CLElement cLElement = get(i5);
        if (cLElement instanceof CLArray) {
            return (CLArray) cLElement;
        }
        throw new CLParsingException(AbstractC0157z.k(i5, "no array at index "), this);
    }

    public boolean getBoolean(int i5) throws CLParsingException {
        CLElement cLElement = get(i5);
        if (cLElement instanceof CLToken) {
            return ((CLToken) cLElement).getBoolean();
        }
        throw new CLParsingException(AbstractC0157z.k(i5, "no boolean at index "), this);
    }

    public CLObject getObject(int i5) throws CLParsingException {
        CLElement cLElement = get(i5);
        if (cLElement instanceof CLObject) {
            return (CLObject) cLElement;
        }
        throw new CLParsingException(AbstractC0157z.k(i5, "no object at index "), this);
    }

    public CLElement get(int i5) throws CLParsingException {
        if (i5 >= 0 && i5 < this.mElements.size()) {
            return this.mElements.get(i5);
        }
        throw new CLParsingException(AbstractC0157z.k(i5, "no element at index "), this);
    }

    public String getString(int i5) throws CLParsingException {
        CLElement cLElement = get(i5);
        if (cLElement instanceof CLString) {
            return cLElement.content();
        }
        throw new CLParsingException(AbstractC0157z.k(i5, "no string at index "), this);
    }
}
