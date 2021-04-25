package models;

public class FormData {
    private final String arbit;
    private final String value;

    public FormData(String arbit, String value) {
        this.arbit = arbit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "FormData{" +
                "arbit='" + arbit + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
