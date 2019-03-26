package by.training.taskinfohandling.parser;

import by.training.taskinfohandling.entity.*;

public class ParseText implements BaseParser {

    private static final String SPLIT = "\\n";
    private ParseParagraph next;

    public ParseText(final ParseParagraph nextParser) {
        this.next = nextParser;
    }

    @Override
    public TextComponent parseText(TextComponent textComponent) {

        Text text = (Text) textComponent;

        for (String paragraph : text.getValue().split(SPLIT)) {

            Paragraph paragraphComponent = new Paragraph();
            paragraphComponent.setText(paragraph);
            text.add(paragraphComponent);
            next.parseText(paragraphComponent);
        }

        return textComponent;
    }
}
