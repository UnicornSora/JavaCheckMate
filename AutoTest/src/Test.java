import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        try {
            Browser browser = new Browser();
            browser.setName("FireFox");
            Page page = new Page();
            page.setUrl("baidu");
            Dom dom = new Dom();
            dom.setId("domId");
            dom.setValue("domValue");
            List<Dom> doms = new ArrayList<>();
            doms.add(dom);
            page.setDomList(doms);
            List<Page> pages = new ArrayList<>();
            pages.add(page);
            browser.setPageList(pages);
            Page page1 = browser.enterPage("baidu");
            Dom dom1 = page1.getDomById("domId");
            browser.input(dom1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
