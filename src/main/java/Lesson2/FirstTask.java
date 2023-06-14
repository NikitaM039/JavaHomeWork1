package Lesson2;

import java.util.HashMap;
import java.util.Map;
public class FirstTask {
    /*Дана строка sql-запроса "select * from students where ".
    Сформируйте часть WHERE этого запроса, используя StringBuilder.
    Данные для фильтрации приведены ниже в виде json-строки.
    Если значение null, то параметр не должен попадать в запрос.
    Параметры для фильтрации:
    {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}*/

    public static void main(String[] args) {
        String filterData = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        Map<String, String> filters = new HashMap<>();
        filters.put("name", "Ivanov");
        filters.put("country", "Russia");
        filters.put("city", "Moscow");
        filters.put("age", "null");

        StringBuilder whereClause = new StringBuilder("select * from students where ");

        for (Map.Entry<String, String> entry : filters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (value != null && !value.equals("null")) {
                whereClause.append(key).append(" = '").append(value).append("' AND ");
            }
        }

        int lastIndex = whereClause.lastIndexOf("AND");
        whereClause.delete(lastIndex, lastIndex + 3);

        System.out.println(whereClause.toString());
    }
}
