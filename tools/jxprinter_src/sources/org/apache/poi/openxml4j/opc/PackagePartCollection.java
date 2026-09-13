package org.apache.poi.openxml4j.opc;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.ToIntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class PackagePartCollection implements Serializable {
    private static final long serialVersionUID = 2515031135957635517L;
    private final Set<String> registerPartNameStr = new HashSet();
    private final TreeMap<String, PackagePart> packagePartLookup = new TreeMap<>(new a());

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getUnusedPartIndex$0(Pattern pattern, String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$getUnusedPartIndex$1(V2.f fVar, V2.f fVar2) {
        fVar.getClass();
        fVar.setScanner(0, fVar2.c, fVar2, V2.f.f755o);
    }

    public boolean containsKey(PackagePartName packagePartName) {
        return packagePartName != null && this.packagePartLookup.containsKey(packagePartName.getName());
    }

    public PackagePart get(PackagePartName packagePartName) {
        if (packagePartName == null) {
            return null;
        }
        return this.packagePartLookup.get(packagePartName.getName());
    }

    public int getUnusedPartIndex(String str) throws InvalidFormatException {
        if (str == null || !str.contains("#")) {
            throw new InvalidFormatException("name template must not be null and contain an index char (#)");
        }
        final Pattern patternCompile = Pattern.compile(str.replace("#", "([0-9]+)"));
        return ((V2.f) this.packagePartLookup.keySet().stream().mapToInt(new ToIntFunction() { // from class: org.apache.poi.openxml4j.opc.b
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return PackagePartCollection.lambda$getUnusedPartIndex$0(patternCompile, (String) obj);
            }
        }).collect(new c(), new d(), new e())).g(1);
    }

    public PackagePart put(PackagePartName packagePartName, PackagePart packagePart) {
        String name = packagePartName.getName();
        StringBuilder sb = new StringBuilder();
        for (String str : name.split("(?=[/])")) {
            sb.append(str);
            if (this.registerPartNameStr.contains(sb.toString())) {
                throw new InvalidOperationException("You can't add a part with a part name derived from another part ! [M1.11]");
            }
        }
        this.registerPartNameStr.add(name);
        return this.packagePartLookup.put(name, packagePart);
    }

    public PackagePart remove(PackagePartName packagePartName) {
        if (packagePartName == null) {
            return null;
        }
        String name = packagePartName.getName();
        PackagePart packagePartRemove = this.packagePartLookup.remove(name);
        if (packagePartRemove != null) {
            this.registerPartNameStr.remove(name);
        }
        return packagePartRemove;
    }

    public int size() {
        return this.packagePartLookup.size();
    }

    public Collection<PackagePart> sortedValues() {
        return Collections.unmodifiableCollection(this.packagePartLookup.values());
    }
}
