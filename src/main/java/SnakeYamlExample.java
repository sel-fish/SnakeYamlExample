import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeYamlExample {
    public static String filename = "/tmp/config.yml";
    public static Yaml yaml = new Yaml();

    public static void main(String[] args) {
        dumpYaml();
        loadYaml();
    }

    public static void loadYaml() {
        try {
            FileReader reader = new FileReader(filename);
            MyBean bean = yaml.loadAs(reader, MyBean.class);
            System.out.println("load from file ok");
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dumpYaml() {
        MyOtherBean otherBean1 = new MyOtherBean();
        otherBean1.setOtherbeanprop1("foo");
        otherBean1.setOtherbeanprop2("bar");

        Map<String, MyOtherBean> mymap = new HashMap<String, MyOtherBean>();
        mymap.put("foobar", otherBean1);

        MyOtherBean otherBean2 = new MyOtherBean();
        otherBean2.setOtherbeanprop1("foo");
        otherBean2.setOtherbeanprop2("bar");

        List<MyOtherBean> mylist = new ArrayList<MyOtherBean>();
        mylist.add(otherBean2);

        MyBean bean = new MyBean();
        bean.setMymap(mymap);
        bean.setMylist(mylist);

        String yamlContent = yaml.dumpAsMap(bean);
        System.out.println(yamlContent);
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(yamlContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
