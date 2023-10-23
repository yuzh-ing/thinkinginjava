package pers.jyzh.springframework.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.core.ResolvableType;

/**
 * @author ZhengYu
 * @version 1.0 2023/10/23 15:03
 **/
public class TijResolvableType {

  private HashMap<Integer, List<String>> mp;

  public static void main(String[] args) throws Exception {
    ResolvableType rt1 = ResolvableType.forClass(List.class);
    ResolvableType rt2 = ResolvableType.forRawClass(ArrayList.class);

    List<List<String>>[] arr = new List[0];
    ResolvableType rt3 = ResolvableType.forInstance(arr);

    System.out.println();
  }
}
