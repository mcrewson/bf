/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * TODO: document FilesystemScanner class
 *
 * @author Mark Crewson (mark.crewson@alea.ca)
 */
@Service
public class FilesystemScanner
    extends SimpleFileVisitor<Path>
{
    /* Internal data ----------------------------------------------------- */

    @Value("${scanner.directory}")
    private String directory;

    @Value("#{'${scanner.extensions}'.split(',')}")
    private List<String> extensions;

    /* SimpleFileVisitor implementation ---------------------------------- */

    @Override
    public FileVisitResult visitFile (Path file, BasicFileAttributes attrs)
        throws IOException
    {
        File f = file.toFile();
        String extension = getExtension(f.getName());
        if (!extensions.contains(extension.toLowerCase()))
        {
            return FileVisitResult.CONTINUE;
        }
        if (attrs.isSymbolicLink())
        {
            //logger.debug(f.getAbsolutePath() + " <- Symbolic Link");
        }
        else if (attrs.isRegularFile())
        {
            //logger.debug(f.getAbsolutePath());

            // do something with this file.
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed (Path file, IOException exc)
        throws IOException
    {
        //logger.error(String.format("========== FAILED AT FILE: %s ==========", file.toFile().getAbsolutePath()));
        return FileVisitResult.CONTINUE;
    }

    /* Public methods ---------------------------------------------------- */

    public void scan ()
    {
        try
        {
            Files.walkFileTree(Paths.get(directory), this);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /* Private methods ---------------------------------------------------- */

    private static int indexOfLastSeparator (final String filename)
    {
        if (filename == null) {
            return -1;
        }
        final int lastUnixPos = filename.lastIndexOf('/');
        final int lastWindowsPos = filename.lastIndexOf('\\');
        return Math.max(lastUnixPos, lastWindowsPos);
    }

    private static int indexOfExtension (final String filename)
    {
        if (filename == null) {
            return -1;
        }
        final int extensionPos = filename.lastIndexOf(".");
        final int lastSeparator = indexOfLastSeparator(filename);
        return lastSeparator > extensionPos ? -1 : extensionPos;
    }

    protected static String getExtension (final String filename)
    {
        if (filename == null)
        {
            return null;
        }
        final int index = indexOfExtension(filename);
        if (index == -1)
        {
            return "";
        }
        else
        {
            return filename.substring(index + 1);
        }
    }

}

// THE END
