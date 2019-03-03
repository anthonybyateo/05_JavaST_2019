package by.training.taskobject.parser;

import by.training.taskobject.exception.NotDoubleArgumentException;
import by.training.taskobject.validation.Validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public final class ParserData {

    static final Logger LOGGER = LogManager.getLogger(ParserData.class);
    private static final String SPLIT = "\\s|;|,";

    public List<Double> parseArguments(final List<String> lines) {
        List<Double> coordinateList = new ArrayList<>();
        List<Double> fourCoordinateList = new ArrayList<>();
        Validation validation = new Validation();


        for (int i = 0; i < lines.size(); i++) {
            for (String str : lines.get(i).split(SPLIT)) {
                if (validation.checkDataType(str)) {
                    fourCoordinateList.add(Double.parseDouble(str));

                } else {
                    fourCoordinateList.clear();
                    try {
                        throw new NotDoubleArgumentException("Illegal arguments");
                    } catch (NotDoubleArgumentException e) {
                        LOGGER.warn("Illegal arguments");
                    }
                    break;
                }
            }
            coordinateList.addAll(fourCoordinateList);
        }
        return coordinateList;
    }
}
