package by.training.taskthread.parser;

import by.training.taskthread.exception.NotIntegerArgumentException;
import by.training.taskthread.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ParserData {
    static final Logger LOGGER = LogManager.getLogger(ParserData.class);
    private static final String SPLIT = "\\s";

    public List<Integer> parseArguments(final List<String> lines) {

        List<Integer> durationList = new ArrayList<>();
        Validation validation = new Validation();


        for (int i = 0; i < lines.size(); i++) {
            for (String str : lines.get(i).split(SPLIT)) {
                if (validation.checkDataType(str)) {
                    durationList.add(Integer.parseInt(str));
                } else {
                    try {
                        throw new NotIntegerArgumentException();
                    } catch (NotIntegerArgumentException e) {
                        LOGGER.warn("Illegal arguments");
                    }
                }
            }
        }
        return durationList;
    }
}
