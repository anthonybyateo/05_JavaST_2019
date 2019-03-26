package by.training.taskinfohandling.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Composite implements TextComponent {

    protected String text;
    protected List<TextComponent> childText;

    public Composite() {
        childText = new ArrayList<>();
    }

    public void add(TextComponent textComponent) {
        childText.add(textComponent);
    }

    public void remove(TextComponent textComponent) {
        childText.remove(textComponent);
    }

    public TextComponent getChild(int index) {

        return childText.get(index);
    }

    public void setText(final String textComponent) {
        this.text = textComponent;
    }
}
