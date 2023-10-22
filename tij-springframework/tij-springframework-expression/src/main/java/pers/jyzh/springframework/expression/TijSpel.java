package pers.jyzh.springframework.expression;

import lombok.Getter;
import lombok.Setter;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZhengYu
 * @version 1.0 2023/10/21 15:55
 **/
public class TijSpel {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser(new SpelParserConfiguration());

        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("k1", 8);
        context.setVariable("k2", "v2");
        context.setVariable("k3", "{\"id\":\"id\",\"name\":\"name\"}");
        context.setVariable("k4", User.mock());

        Object v1 = parser.parseExpression("#k2").getValue(context);
        Object v2 = parser.parseExpression("#k4.name").getValue(context);
        Object v3 = parser.parseExpression("#k4.hobbies[0]").getValue(context);
        System.out.println();
    }

    @Getter
    @Setter
    public static class User {
        private String id;
        private String name;
        private List<String> hobbies;

        public static User mock() {
            User user = new User();
            user.setId("id");
            user.setName("name");
            user.setHobbies(Arrays.asList("唱", "跳", "Rap", "篮球"));
            return user;
        }
    }
}
