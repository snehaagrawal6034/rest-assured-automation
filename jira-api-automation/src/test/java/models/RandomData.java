package models;

import java.util.Objects;

public class RandomData {
    public final String arbit;
    public final String value;

    public RandomData(String arbit, String value) {
        this.arbit = arbit;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomData that = (RandomData) o;
        return Objects.equals(arbit, that.arbit) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arbit, value);
    }

    @Override
    public String toString() {
        return "RandomData{" +
                "arbit='" + arbit + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
