package pers.jyzh.springboot.web.enpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhengYu
 * @version 1.0 2023/10/11 17:35
 **/
@RestController
public class About {
  @Autowired
  private ApplicationContext appCtx;

  @GetMapping("/about")
  public String about() {
    return appCtx.getEnvironment().getProperty("spring.profiles.active");
  }
}
