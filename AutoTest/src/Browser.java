import java.util.List;

public class Browser {

    String name;

    List<Page> pageList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Page> getPageList() {
        return pageList;
    }

    public void setPageList(List<Page> pageList) {
        this.pageList = pageList;
    }

    public Page enterPage(String url) throws Exception {
        for (Page page : getPageList()) {
            if (page.getUrl().equals(url)) {
                AutoTestTool.autoAction(actionSout(), "Enter page", page.getUrl());
                return page;
            }
        }
        return null;
    }

    public void input(Dom dom) throws Exception {
        AutoTestTool.autoAction(actionSout(), "Input", dom.getValue(), "into", dom.getId());
    }

    public void click(Dom dom) throws Exception {
        AutoTestTool.autoAction(actionSout(), "Click", dom.getId());
    }

    public void getById(Dom dom) throws Exception {
        AutoTestTool.autoAction(actionSout(), "Get text of", dom.getId());
    }

    public String actionSout() {
        String s = "[" + getName() + "]";
        return s;
    }
}
