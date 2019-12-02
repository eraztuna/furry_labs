import org.json.JSONObject;

import java.util.function.Supplier;

public class JSONParser<T extends Entry> implements Parser<T> {
    private Supplier<T> supplier;

    JSONParser(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    @Override
    public T parse(String line) {
        var jo = new JSONObject(line);
        T newT = supplier.get();
        newT.initialize(jo.toMap());
        return newT;
    }
}
