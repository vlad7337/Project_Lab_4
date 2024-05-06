package core.main;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Composite implements Function {
    private final ArrayList<Function> terms;

    public ArrayList<Function> terms() {
        return terms;
    }

    public Composite() {
        terms = new ArrayList<>();
    }

    public Composite(Function... terms) {
        this.terms = new ArrayList<>(Arrays.asList(terms));
    }

    public Composite(ArrayList<Function> terms) {
        this.terms = terms;
    }

}