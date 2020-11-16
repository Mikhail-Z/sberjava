import java.util.ArrayList;
import java.util.List;

public class SerializedGameHistory implements GameHistory {
    private List<String> fields;

    public SerializedGameHistory() {
        this.fields = new ArrayList<String>();
    }

    public void add(Field newField) {
        fields.add(newField.toString());
    }

    public boolean contains(Field field) {
        return fields.contains(field.toString());
    }
}
