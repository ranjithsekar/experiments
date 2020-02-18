package rs.xpath.controller;

import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.xsoup.Xsoup;

@Controller
@Slf4j
public class XpathController {

  @GetMapping("/")
  public String welcome(Map<String, Object> model) {
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
      @RequestParam("url2") String url2, Map<String, Object> model) throws Exception {
    log.info("Url 1: " + url1);
    log.info("Url 2: " + url2);
    System.out.println("element: " + element);

    String src1 = Jsoup.connect(url1)
        .get()
        .html();

    Document document1 = Jsoup.parse(src1);
    List<String> result1 = Xsoup.compile("//" + element)
        .evaluate(document1)
        .list();

    model.put("url1EleSize", result1.size());
    model.put("result1", result1);

    String src2 = Jsoup.connect(url2)
        .get()
        .html();

    Document document2 = Jsoup.parse(src2);
    List<String> result2 = Xsoup.compile("//" + element)
        .evaluate(document2)
        .list();

    model.put("url2EleSize", result2.size());
    model.put("result2", result2);
    return "home";
  }
}