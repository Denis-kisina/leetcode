package com.denis.kisina.practice.amazon;

import java.util.Objects;

public class PairString {
    String first;
    String second;

    public PairString(String first, String second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairString that = (PairString) o;
        return first.equals(that.first) &&
                second.equals(that.second);
    }

    @Override
    public String toString() {
        return first + second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
