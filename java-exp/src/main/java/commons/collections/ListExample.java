package commons.collections;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.ListUtils;

public class ListExample {

  public static void main(String[] args) {
    List<String> list = new ArrayList<String>();
    List<String> list1 = new ArrayList<String>();
    list1.add("one-1");
    list1.add("one-2");
    list1.add("one-3");

    List<String> list2 = new ArrayList<String>();
    list1.add("two-1");
    list1.add("two-2");
    list1.add("two-3");

    List<String> list3 = new ArrayList<String>();
    List<String> list4 = new ArrayList<String>();
    list1.add("four-1");
    list1.add("four-2");
    list1.add("four-3");

    List<String> result = (List<String>) mergeList(list, list1, list2, list3, list4);
    System.out.println(result.size());

  }

  public static List<String> mergeList(List<String>... lists) {
    List<String> resultList = new ArrayList<String>();

    for (List<String> list : lists) {
      if (null != list && list.size() > 0) {
        resultList = ListUtils.union(resultList, list);
      }
    }

    return resultList;
  }
}
