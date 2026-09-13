package org.apache.poi.hpsf;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CustomProperty extends Property {
    private String name;

    public CustomProperty() {
        this.name = null;
    }

    @Override // org.apache.poi.hpsf.Property
    public boolean equals(Object obj) {
        return (obj instanceof CustomProperty) && equalsContents(obj);
    }

    public boolean equalsContents(Object obj) {
        boolean zEquals;
        CustomProperty customProperty = (CustomProperty) obj;
        String name = customProperty.getName();
        String name2 = getName();
        if (name == null) {
            zEquals = name2 == null;
        } else {
            zEquals = name.equals(name2);
        }
        return zEquals && customProperty.getID() == getID() && customProperty.getType() == getType() && customProperty.getValue().equals(getValue());
    }

    public String getName() {
        return this.name;
    }

    @Override // org.apache.poi.hpsf.Property
    public int hashCode() {
        return Objects.hash(this.name, Long.valueOf(getID()));
    }

    public void setName(String str) {
        this.name = str;
    }

    public CustomProperty(Property property) {
        this(property, null);
    }

    public CustomProperty(Property property, String str) {
        super(property);
        this.name = str;
    }
}
