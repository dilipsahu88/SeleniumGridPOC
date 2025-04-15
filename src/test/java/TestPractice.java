import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class TestPractice {

    @Test
    public void ArrayList() {

        ArrayList<String>  al = new ArrayList<String>();
        al.add("Dilip");
        al.add("Java");
        al.add("Testing");
        al.add("Dilip");

        System.out.println(al);
        //al.addFirst("hey");
        //System.out.print(al);
        //al.remove(1);
        //System.out.print(al);
        System.out.println(al.indexOf("Java"));
        al.remove("Dilip");
        System.out.println(al);
        Assert.assertTrue(al.contains("Testing"));
    }

    @Test
    public void HashSet() {

        HashSet<String> hs = new HashSet<String>();
        hs.add("Dilip");
        hs.add("Kumar");
        hs.add("Sahu");
        hs.add("Java");
        hs.add("Testing");

        //System.out.println(hs);

        Iterator<String> i =  hs.iterator();
//        System.out.println(i.next());
//        System.out.println(i.next());

//        while(i.hasNext())
//        {
//            System.out.println(i.next());
//        }

        for(String str: hs)
        {
            System.out.println(str);
        }

    }

    @Test
    public void HashMap() {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(0, "Hello");
        hm.put(1, "Dilip");
        hm.put(2, "Java");
        hm.put(3, "Testing");
        System.out.println(hm);
        System.out.println(hm.get(2));
        hm.remove(2);
        System.out.println(hm.get(2));

        Set sn = hm.entrySet();


    }


}
