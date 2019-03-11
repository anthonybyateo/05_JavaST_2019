package by.training.taskthread.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public List<String> readData(final String filePath) throws
            IOException {
        Path path = Paths.get(filePath);
        try (Stream<String> lineStream = Files.lines(path)) {

            return lineStream.collect(Collectors.toList());
        }
    }
}