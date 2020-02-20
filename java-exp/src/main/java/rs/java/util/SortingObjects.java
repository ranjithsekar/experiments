package rs.java.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class SortingObjects {

  public static void main(String[] args) {
    List<ActivityFeeds> result = null;
    List<ActivityFeeds> origList = getActivityFeeds1();// Arrays.asList(new
                                                       // String[]
                                                       // {"1","2","3","4","5","6","7","8","9","10"});
    int recordsPerPage = 2;
    int offSet = 3;
    String searchStr = "gary";
    String searchBy = "RECORD";

    // apply filter
    switch (searchBy) {
    case "RECORD":
      result = origList.stream()
          .filter(e -> StringUtils.containsIgnoreCase(e.getOwner(), searchStr))
          .collect(Collectors.toList());
      break;

    default:
      break;
    }

    // origList.forEach(System.out::println);

    // List<ActivityFeeds> filtered =
    // origList.stream().skip(offSet).limit(recordsPerPage).collect(Collectors.toList());
    // System.out.println("result size: "+result.size());
    result.forEach(System.out::println);
  }

  public static void sorting(List<ActivityFeeds> origList) {
    List<ActivityFeeds> currentList = new ArrayList<>();
    System.out.println("ORIG LIST");
    origList.forEach(System.out::println);

    System.out.println("\nSORTED BY NAME LIST");
    currentList = origList.stream()
        .sorted(Comparator.comparing(ActivityFeeds::getRecord))
        .collect(Collectors.toList());
    currentList.forEach(System.out::println);
    System.out.println("\nSORTED1 BY NAME LIST");
    currentList = origList.stream()
        .sorted(Comparator.comparing(ActivityFeeds::getRecord)
            .reversed())
        .collect(Collectors.toList());
    currentList.forEach(System.out::println);
  }

  public static List<ActivityFeeds> getActivityFeeds1() {
    List<ActivityFeeds> actFeeds = new ArrayList<>();
    ActivityFeeds feed = new ActivityFeeds();
    feed.setRecord("title1");
    feed.setOwner("Ranjith");
    feed.setTriggerEvents("Refusal");
    feed.setActivityDate(new Date());
    feed.setNotificationFrequency("Monthly");
    actFeeds.add(feed);

    feed = new ActivityFeeds();
    feed.setRecord("title2");
    feed.setOwner("Sekar");
    feed.setTriggerEvents("Withnjawal");
    feed.setActivityDate(new Date());
    feed.setNotificationFrequency("Weekly");
    actFeeds.add(feed);

    feed = new ActivityFeeds();
    feed.setRecord("TITLE3");
    feed.setOwner("John");
    feed.setTriggerEvents("Withdrawal");
    feed.setActivityDate(new Date());
    feed.setNotificationFrequency("Wenjly");
    actFeeds.add(feed);

    feed = new ActivityFeeds();
    feed.setRecord("title4");
    feed.setOwner("Winjiam");
    feed.setTriggerEvents("Refusal");
    feed.setActivityDate(new Date());
    feed.setNotificationFrequency("Weekly");
    actFeeds.add(feed);

    feed = new ActivityFeeds();
    feed.setRecord("title5");
    feed.setOwner("Smith");
    feed.setTriggerEvents("Other");
    feed.setActivityDate(new Date());
    feed.setNotificationFrequency("Monthly");
    actFeeds.add(feed);

    feed = new ActivityFeeds();
    feed.setRecord("tinje6");
    feed.setOwner("GARY");
    feed.setTriggerEvents("Assignment");
    feed.setActivityDate(new Date());
    feed.setNotificationFrequency("Monthly");
    actFeeds.add(feed);

    feed = new ActivityFeeds();
    feed.setRecord("title7");
    feed.setOwner("Gary");
    feed.setTriggerEvents("Assignment");
    feed.setActivityDate(new Date());
    feed.setNotificationFrequency("Monthly");
    actFeeds.add(feed);

    feed = new ActivityFeeds();
    feed.setRecord("title8");
    feed.setOwner("Gary");
    feed.setTriggerEvents("Assignment");
    feed.setActivityDate(new Date());
    feed.setNotificationFrequency("Monthly");
    actFeeds.add(feed);

    feed = new ActivityFeeds();
    feed.setRecord("title9");
    feed.setOwner("Gary");
    feed.setTriggerEvents("Assignment");
    feed.setActivityDate(new Date());
    feed.setNotificationFrequency("Monthly");
    actFeeds.add(feed);

    feed = new ActivityFeeds();
    feed.setRecord("title10");
    feed.setOwner("Gary");
    feed.setTriggerEvents("Assignment");
    feed.setActivityDate(new Date());
    feed.setNotificationFrequency("Monthly");
    actFeeds.add(feed);

    return actFeeds;
  }
}
