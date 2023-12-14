package pers.jyzh.springboot.web.validation;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.jyzh.common.http.TijResponse;

/**
 * @author ZhengYu
 * @version 1.0 2023/12/6 13:55
 **/
@RestController
@RequestMapping("/v1/validation")
public class ValidationController {

  @PostMapping
  public TijResponse<Void> normal(@RequestBody @Validated TijValidationRequest request) {
    return TijResponse.success();
  }
}
