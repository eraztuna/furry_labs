import java.util.*;

public class EntryData {
    Map<String, String> values = new HashMap<>();

    public void addField(String fieldName, String fieldValue) {
        values.put(fieldName, fieldValue);
    }

    public void addFields(List<String> fieldsNames,
                          List<String> fieldsValues) {
        Iterator<String> namesIterator = fieldsNames.iterator();
        Iterator<String> valuesIterator = fieldsValues.iterator();

        while (namesIterator.hasNext() && valuesIterator.hasNext()) {
            addField(namesIterator.next(), valuesIterator.next());
        }
    }

    public String getFieldValue(String fieldName) {
        return values.get(fieldName);
    }

}
