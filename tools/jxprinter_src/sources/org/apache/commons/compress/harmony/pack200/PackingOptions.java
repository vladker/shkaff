package org.apache.commons.compress.harmony.pack200;

import A3.AbstractC0157z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.java.util.jar.Pack200;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.objectweb.asm.Attribute;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PackingOptions {
    public static final String ERROR = "error";
    public static final String KEEP = "keep";
    public static final String PASS = "pass";
    public static final String STRIP = "strip";
    private Map classAttributeActions;
    private Map codeAttributeActions;
    private Map fieldAttributeActions;
    private String logFile;
    private Map methodAttributeActions;
    private List passFiles;
    private Attribute[] unknownAttributeTypes;
    private boolean gzip = true;
    private boolean stripDebug = false;
    private boolean keepFileOrder = true;
    private long segmentLimit = 1000000;
    private int effort = 5;
    private String deflateHint = "keep";
    private String modificationTime = "keep";
    private String unknownAttributeAction = "pass";
    private boolean verbose = false;

    private void addOrUpdateAttributeActions(List list, Map map, int i5) {
        NewAttribute passAttribute;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (String str : map.keySet()) {
            String str2 = (String) map.get(str);
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    if ("error".equals(str2)) {
                        passAttribute = new NewAttribute.ErrorAttribute(str, i5);
                    } else if ("strip".equals(str2)) {
                        passAttribute = new NewAttribute.StripAttribute(str, i5);
                    } else {
                        passAttribute = "pass".equals(str2) ? new NewAttribute.PassAttribute(str, i5) : new NewAttribute(str, str2, i5);
                    }
                    list.add(passAttribute);
                    break;
                }
                NewAttribute newAttribute = (NewAttribute) it.next();
                if (newAttribute.type.equals(str)) {
                    newAttribute.addContext(i5);
                    break;
                }
            }
        }
    }

    public void addClassAttributeAction(String str, String str2) {
        if (this.classAttributeActions == null) {
            this.classAttributeActions = new HashMap();
        }
        this.classAttributeActions.put(str, str2);
    }

    public void addCodeAttributeAction(String str, String str2) {
        if (this.codeAttributeActions == null) {
            this.codeAttributeActions = new HashMap();
        }
        this.codeAttributeActions.put(str, str2);
    }

    public void addFieldAttributeAction(String str, String str2) {
        if (this.fieldAttributeActions == null) {
            this.fieldAttributeActions = new HashMap();
        }
        this.fieldAttributeActions.put(str, str2);
    }

    public void addMethodAttributeAction(String str, String str2) {
        if (this.methodAttributeActions == null) {
            this.methodAttributeActions = new HashMap();
        }
        this.methodAttributeActions.put(str, str2);
    }

    public void addPassFile(String str) {
        if (this.passFiles == null) {
            this.passFiles = new ArrayList();
        }
        String property = System.getProperty("file.separator");
        if (property.equals("\\")) {
            property = property.concat("\\");
        }
        this.passFiles.add(str.replaceAll(property, PackagingURIHelper.FORWARD_SLASH_STRING));
    }

    public String getDeflateHint() {
        return this.deflateHint;
    }

    public int getEffort() {
        return this.effort;
    }

    public String getLogFile() {
        return this.logFile;
    }

    public String getModificationTime() {
        return this.modificationTime;
    }

    public long getSegmentLimit() {
        return this.segmentLimit;
    }

    public String getUnknownAttributeAction() {
        return this.unknownAttributeAction;
    }

    public Attribute[] getUnknownAttributePrototypes() {
        if (this.unknownAttributeTypes == null) {
            ArrayList arrayList = new ArrayList();
            addOrUpdateAttributeActions(arrayList, this.classAttributeActions, 0);
            addOrUpdateAttributeActions(arrayList, this.methodAttributeActions, 2);
            addOrUpdateAttributeActions(arrayList, this.fieldAttributeActions, 1);
            addOrUpdateAttributeActions(arrayList, this.codeAttributeActions, 3);
            this.unknownAttributeTypes = (Attribute[]) arrayList.toArray(new Attribute[0]);
        }
        return this.unknownAttributeTypes;
    }

    public String getUnknownClassAttributeAction(String str) {
        Map map = this.classAttributeActions;
        if (map == null) {
            return this.unknownAttributeAction;
        }
        String str2 = (String) map.get(str);
        return str2 == null ? this.unknownAttributeAction : str2;
    }

    public String getUnknownCodeAttributeAction(String str) {
        Map map = this.codeAttributeActions;
        if (map == null) {
            return this.unknownAttributeAction;
        }
        String str2 = (String) map.get(str);
        return str2 == null ? this.unknownAttributeAction : str2;
    }

    public String getUnknownFieldAttributeAction(String str) {
        Map map = this.fieldAttributeActions;
        if (map == null) {
            return this.unknownAttributeAction;
        }
        String str2 = (String) map.get(str);
        return str2 == null ? this.unknownAttributeAction : str2;
    }

    public String getUnknownMethodAttributeAction(String str) {
        Map map = this.methodAttributeActions;
        if (map == null) {
            return this.unknownAttributeAction;
        }
        String str2 = (String) map.get(str);
        return str2 == null ? this.unknownAttributeAction : str2;
    }

    public boolean isGzip() {
        return this.gzip;
    }

    public boolean isKeepDeflateHint() {
        return "keep".equals(this.deflateHint);
    }

    public boolean isKeepFileOrder() {
        return this.keepFileOrder;
    }

    public boolean isPassFile(String str) {
        List<String> list = this.passFiles;
        if (list == null) {
            return false;
        }
        for (String strConcat : list) {
            if (str.equals(strConcat)) {
                return true;
            }
            if (!strConcat.endsWith(".class")) {
                if (!strConcat.endsWith(PackagingURIHelper.FORWARD_SLASH_STRING)) {
                    strConcat = strConcat.concat(PackagingURIHelper.FORWARD_SLASH_STRING);
                }
                return str.startsWith(strConcat);
            }
        }
        return false;
    }

    public boolean isStripDebug() {
        return this.stripDebug;
    }

    public boolean isVerbose() {
        return this.verbose;
    }

    public void removePassFile(String str) {
        this.passFiles.remove(str);
    }

    public void setDeflateHint(String str) {
        if (!"keep".equals(str) && !"true".equals(str) && !"false".equals(str)) {
            throw new IllegalArgumentException(AbstractC0157z.o("Bad argument: -H ", str, " ? deflate hint should be either true, false or keep (default)"));
        }
        this.deflateHint = str;
    }

    public void setEffort(int i5) {
        this.effort = i5;
    }

    public void setGzip(boolean z6) {
        this.gzip = z6;
    }

    public void setKeepFileOrder(boolean z6) {
        this.keepFileOrder = z6;
    }

    public void setLogFile(String str) {
        this.logFile = str;
    }

    public void setModificationTime(String str) {
        if (!"keep".equals(str) && !Pack200.Packer.LATEST.equals(str)) {
            throw new IllegalArgumentException(AbstractC0157z.o("Bad argument: -m ", str, " ? transmit modtimes should be either latest or keep (default)"));
        }
        this.modificationTime = str;
    }

    public void setQuiet(boolean z6) {
        this.verbose = !z6;
    }

    public void setSegmentLimit(long j6) {
        this.segmentLimit = j6;
    }

    public void setStripDebug(boolean z6) {
        this.stripDebug = z6;
    }

    public void setUnknownAttributeAction(String str) {
        this.unknownAttributeAction = str;
        if (!"pass".equals(str) && !"error".equals(str) && !"strip".equals(str)) {
            throw new RuntimeException(AbstractC0157z.n("Incorrect option for -U, ", str));
        }
    }

    public void setVerbose(boolean z6) {
        this.verbose = z6;
    }
}
