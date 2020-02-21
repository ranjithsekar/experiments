package rs.xpath.model;

import org.jsoup.nodes.Element;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class XPathResult {
  private Element element;
  private String xpath;
}
