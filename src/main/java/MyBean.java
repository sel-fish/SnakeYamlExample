import java.util.List;
import java.util.Map;

public class MyBean {

    private Map<String, MyOtherBean> mymap;
    private List<MyOtherBean> mylist;

    public Map<String, MyOtherBean> getMymap() {
        return mymap;
    }

    public List<MyOtherBean> getMylist() {
        return mylist;
    }

    public void setMymap(Map<String, MyOtherBean> mymap) {
        this.mymap = mymap;
    }

    public void setMylist(List<MyOtherBean> mylist) {
        this.mylist = mylist;
    }
}
