package by.training.taskinfohandling.entity;


public class СharacterLeaf implements TextComponent {

    private char ch;

    public СharacterLeaf(final char aChar) {
        this.ch = aChar;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    @Override
    public String getValue() {

        return String.valueOf(ch);
    }
}
