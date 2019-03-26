package by.training.taskinfohandling.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {

    private Level level;
    private ArrayList<Component> components;

    public TextComposite(final Level levelText) {
        this.level = levelText;
        components = new ArrayList<Component>();
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    public Object getChild(int index) {

        return components.get(index);
    }

    @Override
    public String getValue() {
        List<Character> chars = new ArrayList<>();

        for (Component component : components) {
            chars.addAll(component.getValue());
        }
        return chars;
    }


}
