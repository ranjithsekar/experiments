package rs.xpath.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import rs.xpath.model.XPathResult;
import us.codecraft.xsoup.Xsoup;

@Controller
@Slf4j
public class XpathController {

  @Value("classpath:xpaths.properties")
  Resource resource;

  @GetMapping("/")
  public String home(Map<String, Object> model) throws IOException {
    List<String> xpaths = Files.readAllLines(Paths.get(resource.getFile().getAbsolutePath()));

    Map<String, String> xpathMap = new HashMap<>();

    xpaths.forEach(e -> {
      List<String> xpathValues = Arrays.asList(e.split("="));
      xpathMap.put(xpathValues.get(0), StringUtils.stripStart(String.join("", xpathValues), xpathValues.get(0)));
    });
    log.info(String.join(",", xpathMap.values()));
    model.put("inputXpaths", xpathMap.values());

    return "home";
  }

  @GetMapping("/login1")
  public String login1(Map<String, Object> model) {
    return "login1";
  }

  @GetMapping("/login2")
  public String login2(Map<String, Object> model) {
    return "login2";
  }

  @PostMapping("/compare")
  public String compare(@RequestParam("element") String element, @RequestParam("url1") String url1,
      Map<String, Object> model) throws Exception {

    // PAGE 1
    String src1 = Jsoup.connect(url1).get().html();
    Document document1 = Jsoup.parse(src1);
    List<Element> elements1 = Xsoup.compile("//" + element).evaluate(document1).getElements();

    List<XPathResult> result1 = new ArrayList<>();
    elements1.forEach(e -> {
      List<String> tagNames = e.parents().stream().map(f -> f.tagName()).collect(Collectors.toList());
      Collections.reverse(tagNames);
      result1.add(new XPathResult(e, String.join("/", tagNames) + "/" + e.tagName()));
    });

    model.put("url1EleSize", elements1.size());
    model.put("result1", result1);

    return "home";
  }
}
