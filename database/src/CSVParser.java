import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

public class CSVParser<T extends Entry> implements Parser<T> {
    private Supplier<T> supplier;
    private List<String> fieldsNames;

    CSVParser(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public void setFieldsNames(List<String> fieldsNames) {
        this.fieldsNames = fieldsNames;
    }

    @Override
    public T parse(String line) {
        var values = Arrays.asList(line.split(";"));
        var valueIter = values.iterator();
        var map = new HashMap<String, Object>();

        for (var fieldName : fieldsNames) {
            map.put(fieldName, valueIter.next());
        }

        T newT = supplier.get();
        newT.initialize(map);
        return newT;
    }
}
