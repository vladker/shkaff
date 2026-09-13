package p056k0;

import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5465a;
    private List<d> columnInfos;
    private String fileUrl;

    public e(String fileUrl, int i5, List<d> columnInfos) {
        E.f(fileUrl, "fileUrl");
        E.f(columnInfos, "columnInfos");
        this.fileUrl = fileUrl;
        this.f5465a = i5;
        this.columnInfos = columnInfos;
    }

    public final String component1() {
        return this.fileUrl;
    }

    public final List<d> component3() {
        return this.columnInfos;
    }

    public final e copy(String fileUrl, int i5, List<d> columnInfos) {
        E.f(fileUrl, "fileUrl");
        E.f(columnInfos, "columnInfos");
        return new e(fileUrl, i5, columnInfos);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return E.a(this.fileUrl, eVar.fileUrl) && this.f5465a == eVar.f5465a && E.a(this.columnInfos, eVar.columnInfos);
    }

    public final List<d> getColumnInfos() {
        return this.columnInfos;
    }

    public final String getFileUrl() {
        return this.fileUrl;
    }

    public final int hashCode() {
        return this.columnInfos.hashCode() + ((Integer.hashCode(this.f5465a) + (this.fileUrl.hashCode() * 31)) * 31);
    }

    public final void setColumnInfos(List<d> list) {
        E.f(list, "<set-?>");
        this.columnInfos = list;
    }

    public final void setFileUrl(String str) {
        E.f(str, "<set-?>");
        this.fileUrl = str;
    }

    public String toString() {
        return "ExcelInfo(fileUrl=" + this.fileUrl + ", rowCount=" + this.f5465a + ", columnInfos=" + this.columnInfos + ")";
    }
}
