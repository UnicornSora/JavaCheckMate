import java.util.List;

public class Page {

    String url;

    List<Dom> domList;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Dom> getDomList() {
        return domList;
    }

    public void setDomList(List<Dom> domList) {
        this.domList = domList;
    }

    public Dom getDomById(String id) {
        for (Dom dom : getDomList()) {
            if (dom.getId().equals(id)) {
                return dom;
            }
        }
        return null;
    }
}
