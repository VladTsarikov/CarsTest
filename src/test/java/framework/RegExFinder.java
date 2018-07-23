package framework;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExFinder extends BaseEntity{
    private static String pageSource;
    private static Pattern pattern;
    private static Matcher matcher;
    private static List<String> values;

    public static  List<String> findByRegularExp(String regExp){
        pageSource = driver.getPageSource();

        pattern = Pattern.compile(regExp);
        matcher = pattern.matcher(pageSource);
        values = new ArrayList<>();

        while(matcher.find()) {
            values.add(matcher.group(1));
        }
        return values;
    }

}
