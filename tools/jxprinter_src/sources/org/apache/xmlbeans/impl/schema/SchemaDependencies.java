package org.apache.xmlbeans.impl.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SchemaDependencies {
    private final Map<String, List<String>> _contributions = new HashMap();
    private final Map<String, Set<String>> _dependencies = new HashMap();

    public SchemaDependencies() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getNamespacesTouched$3(Set set, Map.Entry entry) {
        Stream stream = ((List) entry.getValue()).stream();
        set.getClass();
        return stream.anyMatch(new c(set, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isFileRepresented$2(String str, List list) {
        return list.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$registerContribution$1(String str) {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Set lambda$registerDependency$0(String str) {
        return new HashSet();
    }

    public Set<String> computeTransitiveClosure(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        HashSet hashSet = new HashSet(list);
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            Set<String> set = this._dependencies.get(arrayList.get(i5));
            if (set != null) {
                for (String str : set) {
                    if (!hashSet.contains(str)) {
                        arrayList.add(str);
                        hashSet.add(str);
                    }
                }
            }
        }
        return hashSet;
    }

    public List<String> getFilesTouched(Set<String> set) {
        Stream<String> stream = set.stream();
        Map<String, List<String>> map = this._contributions;
        map.getClass();
        return (List) stream.map(new a(map, 0)).filter(new b(0)).flatMap(new l(15)).collect(Collectors.toList());
    }

    public List<String> getNamespacesTouched(Set<String> set) {
        return (List) this._contributions.entrySet().stream().filter(new c(set, 0)).map(new l(16)).collect(Collectors.toList());
    }

    public boolean isFileRepresented(String str) {
        return this._contributions.values().stream().anyMatch(new c(str, 2));
    }

    public void registerContribution(String str, String str2) {
        this._contributions.computeIfAbsent(str, new l(14)).add(str2);
    }

    public void registerDependency(String str, String str2) {
        this._dependencies.computeIfAbsent(str2, new l(17)).add(str);
    }

    public SchemaDependencies(SchemaDependencies schemaDependencies, Set<String> set) {
        for (String str : schemaDependencies._dependencies.keySet()) {
            if (!set.contains(str)) {
                HashSet hashSet = new HashSet();
                this._dependencies.put(str, hashSet);
                for (String str2 : schemaDependencies._dependencies.get(str)) {
                    if (!set.contains(str2)) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        for (String str3 : schemaDependencies._contributions.keySet()) {
            if (!set.contains(str3)) {
                ArrayList arrayList = new ArrayList();
                this._contributions.put(str3, arrayList);
                arrayList.addAll(schemaDependencies._contributions.get(str3));
            }
        }
    }
}
