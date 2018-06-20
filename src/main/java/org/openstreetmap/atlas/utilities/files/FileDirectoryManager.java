package org.openstreetmap.atlas.utilities.files;

import org.openstreetmap.atlas.exception.CoreException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileDirectoryManager {
    public static void createAndCheckIsDirectory(Path outputPath) {
        try
        {
            if (Files.isDirectory(outputPath))
            {
                throw new CoreException("{} is a directory.  Aborting", outputPath);
            }
            Files.createDirectories(outputPath.getParent());
        }
        catch (final IOException exception)
        {
            throw new CoreException("Error when creating directories {}",
                    outputPath.getParent(), exception);
        }
    }
}
