package org.apache.poi.hpsf;

import A3.AbstractC0157z;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.util.CodePageUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CustomProperties implements Map<String, Object> {
    private static final Logger LOG = LogManager.getLogger((Class<?>) CustomProperties.class);
    private final HashMap<Long, CustomProperty> props = new HashMap<>();
    private final TreeBidiMap<Long, String> dictionary = new TreeBidiMap<>();
    private boolean isPure = true;
    private int codepage = -1;

    private void checkCodePage(String str) {
        String strCodepageToEncoding;
        int codepage = getCodepage();
        if (codepage == -1) {
            codepage = 1252;
        }
        if (codepage == 1200) {
            return;
        }
        try {
            strCodepageToEncoding = CodePageUtil.codepageToEncoding(codepage, false);
        } catch (UnsupportedEncodingException unused) {
            LOG.atError().log("Codepage '{}' can't be found.", Unbox.box(codepage));
            strCodepageToEncoding = "";
        }
        if (strCodepageToEncoding.isEmpty() || !Charset.forName(strCodepageToEncoding).newEncoder().canEncode(str)) {
            LOG.atDebug().log("Charset '{}' can't encode '{}' - switching to unicode.", strCodepageToEncoding, str);
            setCodepage(1200);
        }
    }

    @Override // java.util.Map
    public void clear() {
        this.props.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return ((obj instanceof Long) && this.dictionary.containsKey(obj)) || this.dictionary.containsValue(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (obj instanceof CustomProperty) {
            return this.props.containsValue(obj);
        }
        Iterator<CustomProperty> it = this.props.values().iterator();
        while (it.hasNext()) {
            if (it.next().getValue() == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.props.size());
        for (CustomProperty customProperty : this.props.values()) {
            linkedHashMap.put(customProperty.getName(), customProperty.getValue());
        }
        return Collections.unmodifiableSet(linkedHashMap.entrySet());
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof CustomProperties) && this.props.equals(((CustomProperties) obj).props);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        CustomProperty customProperty = this.props.get((Long) this.dictionary.getKey(obj));
        if (customProperty != null) {
            return customProperty.getValue();
        }
        return null;
    }

    public int getCodepage() {
        return this.codepage;
    }

    public Map<Long, String> getDictionary() {
        return this.dictionary;
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.props.hashCode();
    }

    public Set<Long> idSet() {
        return Collections.unmodifiableSet(this.dictionary.keySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.props.isEmpty();
    }

    public boolean isPure() {
        return this.isPure;
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return Collections.unmodifiableSet(this.dictionary.values());
    }

    public Set<String> nameSet() {
        return Collections.unmodifiableSet(this.dictionary.values());
    }

    public List<CustomProperty> properties() {
        ArrayList arrayList = new ArrayList(this.props.size());
        arrayList.addAll(this.props.values());
        return Collections.unmodifiableList(arrayList);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        for (Map.Entry<? extends String, ? extends Object> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public void setCodepage(int i5) {
        this.codepage = i5;
    }

    public void setPure(boolean z6) {
        this.isPure = z6;
    }

    @Override // java.util.Map
    public int size() {
        return this.props.size();
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        ArrayList arrayList = new ArrayList(this.props.size());
        Iterator<CustomProperty> it = this.props.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    public CustomProperty put(String str, CustomProperty customProperty) {
        if (str == null) {
            this.isPure = false;
            return null;
        }
        if (str.equals(customProperty.getName())) {
            checkCodePage(str);
            this.props.remove(this.dictionary.getKey((Object) str));
            this.dictionary.put(Long.valueOf(customProperty.getID()), str);
            return this.props.put(Long.valueOf(customProperty.getID()), customProperty);
        }
        StringBuilder sbY = AbstractC0157z.y("Parameter \"name\" (", str, ") and custom property's name (");
        sbY.append(customProperty.getName());
        sbY.append(") do not match.");
        throw new IllegalArgumentException(sbY.toString());
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.props.remove((Long) this.dictionary.removeValue(obj));
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0047  */
    /* JADX WARN: Code duplicated, block: B:32:0x004b  */
    /* JADX WARN: Code duplicated, block: B:35:0x005f  */
    @Override // java.util.Map
    public Object put(String str, Object obj) {
        int i5;
        if (obj instanceof String) {
            i5 = 30;
        } else if (obj instanceof Short) {
            i5 = 2;
        } else if (obj instanceof Integer) {
            i5 = 3;
        } else if (obj instanceof Long) {
            i5 = 20;
        } else if (obj instanceof Float) {
            i5 = 4;
        } else if (obj instanceof Double) {
            i5 = 5;
        } else if (obj instanceof Boolean) {
            i5 = 11;
        } else if (obj instanceof BigInteger) {
            BigInteger bigInteger = (BigInteger) obj;
            if (bigInteger.bitLength() <= 64 && bigInteger.compareTo(BigInteger.ZERO) >= 0) {
                i5 = 21;
            } else {
                if (obj instanceof java.util.Date) {
                    throw new IllegalStateException("unsupported datatype - currently String,Short,Integer,Long,Float,Double,Boolean,BigInteger(unsigned long),Date can be processed.");
                }
                i5 = 64;
            }
        } else {
            if (obj instanceof java.util.Date) {
                throw new IllegalStateException("unsupported datatype - currently String,Short,Integer,Long,Float,Double,Boolean,BigInteger(unsigned long),Date can be processed.");
            }
            i5 = 64;
        }
        return put(new CustomProperty(new Property(-1L, i5, obj), str));
    }

    private Object put(CustomProperty customProperty) {
        String name = customProperty.getName();
        Long l6 = name == null ? null : (Long) this.dictionary.getKey((Object) name);
        if (l6 != null) {
            customProperty.setID(l6.longValue());
        } else {
            customProperty.setID(Math.max(this.dictionary.isEmpty() ? 0L : ((Long) this.dictionary.lastKey()).longValue(), 31L) + 1);
        }
        return put(name, customProperty);
    }
}
