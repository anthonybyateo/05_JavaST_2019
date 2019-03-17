package by.training.taskinfohandling.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class FileReader {

    /**
     *
     */
    static final Logger LOGGER = LogManager.getLogger(FileReader.class);

    /**
     *
     * @param filePath
     * @return
     */
    public String readData(final String filePath) {
        Path path = Paths.get(filePath);

        byte[] encoded = new byte[0];

        try {
            encoded = Files.readAllBytes(path);
        } catch (IOException e) {
            LOGGER.error("II/O error occurs reading from the stream");
        }

        return new String(encoded);
    }
}
