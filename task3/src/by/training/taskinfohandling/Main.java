package by.training.taskinfohandling;

import by.training.taskinfohandling.entity.*;
import by.training.taskinfohandling.parser.ParseLexeme;
import by.training.taskinfohandling.parser.ParseParagraph;
import by.training.taskinfohandling.parser.ParseSentence;
import by.training.taskinfohandling.parser.ParseText;
import by.training.taskinfohandling.reader.FileReader;

public class Main {

    public static void main(String[] args) {
        FileReader reader = new FileReader();
        String str = " ";

        str = reader.readData("data/lab3-text.txt");

        Text text = new Text();
        text.setText(str);

        ParseLexeme parseLexeme = new ParseLexeme();
        ParseSentence parseSentence = new ParseSentence(parseLexeme);
        ParseParagraph parseParagraph = new ParseParagraph(parseSentence);
        ParseText parseText = new ParseText(parseParagraph);

        Text text1 = (Text) parseText.parseText(text);
        Paragraph paragraph = (Paragraph) text1.getChild(0);
        System.out.println(paragraph.getChild(0).getValue());
    }
}
