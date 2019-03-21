package by.training.taskinfohandling.entity;

import java.util.ArrayList;
import java.util.List;

public class Composite implements TextComponent {

    private level;
    private ArrayList<TextComponent> components;

    public Composite() {
        components = new ArrayList<TextComponent>();
    }

    public void add(TextComponent component) {
        components.add(component);
    }

    public void remove(TextComponent component) {
        components.remove(component);
    }

    public Object getChild(int index) {

        return components.get(index);
    }

    @Override
    public String getValue() {
        List<Character> chars = new ArrayList<>();

        for (TextComponent component : components) {
            chars.addAll(component.getValue());
        }
        return chars;
    }
}
