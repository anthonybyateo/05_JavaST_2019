package by.training.taskinfohandling.parser;

import by.training.taskinfohandling.entity.Paragraph;
import by.training.taskinfohandling.entity.Sentence;
import by.training.taskinfohandling.entity.TextComponent;

public class ParseParagraph implements BaseParser {

    private static final String SPLIT = "(\\.|\\!|\\?)\\s+";
    private ParseSentence next;

    public ParseParagraph (final ParseSentence nextParser) {
        this.next = nextParser;
    }

    @Override
    public TextComponent parseText(TextComponent textComponent) {

        Paragraph paragraph = (Paragraph) textComponent;

        for (String sentence : paragraph.getValue().split(SPLIT)) {

            Sentence sentenceComponent = new Sentence();
            sentenceComponent.setText(sentence);
            paragraph.add(sentenceComponent);
            next.parseText(sentenceComponent);
        }

        return textComponent;
    }
}
