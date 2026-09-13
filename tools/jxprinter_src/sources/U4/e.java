package U4;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface e extends a {
    String charset();

    String contentType();

    @Override // U4.a
    /* synthetic */ String cookie(String str);

    @Override // U4.a
    /* synthetic */ String header(String str);

    org.jsoup.nodes.i parse();
}
