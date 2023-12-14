package pers.jyzh.springboot.web.validation;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @author ZhengYu
 * @version 1.0 2023/12/6 13:56
 **/
@Getter
@Setter
public class TijValidationRequest {
  @NotEmpty
  private String strNotBlank;
}
