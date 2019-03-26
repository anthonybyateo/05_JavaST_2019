package by.training.taskinfohandling.parser;

import by.training.taskinfohandling.entity.Lexeme;
import by.training.taskinfohandling.entity.TextComponent;

public class ParseLexeme implements BaseParser {

    private static final String SPLIT_WORD = "";
    private static final String SPLIT_EXPRESSION = "";
    private static final String SPLIT_PUNCTUATION = "";

    @Override
    public TextComponent parseText(TextComponent textComponent) {

        Lexeme lexeme = (Lexeme) textComponent;

        return textComponent;
    }
}
