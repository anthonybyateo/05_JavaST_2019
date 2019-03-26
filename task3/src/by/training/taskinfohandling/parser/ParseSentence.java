package by.training.taskinfohandling.parser;

import by.training.taskinfohandling.entity.Lexeme;
import by.training.taskinfohandling.entity.Sentence;
import by.training.taskinfohandling.entity.TextComponent;

public class ParseSentence implements BaseParser {

    private static final String SPLIT = "\\s+";
    private ParseLexeme next;

    public ParseSentence (final ParseLexeme nextParser) {
        this.next = nextParser;
    }

    @Override
    public TextComponent parseText(TextComponent textComponent) {

        Sentence sentence = (Sentence) textComponent;

        for (String lexeme : sentence.getValue().split(SPLIT)) {

            Lexeme lexemeComponent = new Lexeme();
            lexemeComponent.setText(lexeme);
            sentence.add(lexemeComponent);
            //next.parseText(lexemeComponent);
        }

        return textComponent;
    }
}
