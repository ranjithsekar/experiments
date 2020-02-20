package rs.java.util;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ActivityFeeds {
  private String record;
  private String owner;
  private String triggerEvents;
  private Date activityDate;
  private String notificationFrequency;
}