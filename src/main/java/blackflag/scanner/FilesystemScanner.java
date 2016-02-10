/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * TODO: document FilesystemScanner class
 *
 * @author Mark Crewson (mark.crewson@alea.ca)
 */
@Service
public class FilesystemScanner
    extends SimpleFileVisitor<Path>
{
    /* Constants --------------------------------------------------------- */
    
    private static final Logger logger = LoggerFactory.getLogger(FilesystemScanner.class);

    private static final String DEFAULT_SCANNER_EXTENSIONS = "epub,mobi";

    /* Internal data ----------------------------------------------------- */

    @Autowired
    private Environment env;

    private PathMatcher pathMatcher;

    /* SimpleFileVisitor implementation ---------------------------------- */

    @Override
    public FileVisitResult visitFile (Path file, BasicFileAttributes attrs)
        throws IOException
    {
        if (! pathMatcher.matches(file.getFileName()))
        {
            return FileVisitResult.CONTINUE;
        }

        File f = file.toFile();
        if (attrs.isSymbolicLink())
        {
            logger.info(f.getAbsolutePath() + " <- Symbolic Link");
        }
        else if (attrs.isRegularFile())
        {
            logger.info(f.getAbsolutePath());

            // do something with this file.
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed (Path file, IOException exc)
        throws IOException
    {
        logger.error(String.format("========== FAILED AT FILE: %s ==========", file.toFile().getAbsolutePath()));
        return FileVisitResult.CONTINUE;
    }

    /* Public methods ---------------------------------------------------- */

    @Scheduled(fixedRate = 15000)
    public void scan ()
    {
        String scannerpath = env.getProperty("scanner.directory");
        if (scannerpath == null)
        {
            logger.error("Cannot start filesystem scan. no directory specified.");
            return;
        }
        Path directory = Paths.get(scannerpath);
        if (! directory.toFile().isDirectory())
        {
            logger.error(String.format("Cannot start filesystem scan. Directory does not exist: %s", directory.toFile().getAbsolutePath()));
            return;
        }

        setupPathMatcher();

        logger.info("Starting filesystem scan...");
        try
        {
            Files.walkFileTree(directory, this);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /* Private methods ---------------------------------------------------- */

    private void setupPathMatcher ()
    {
        String extensions = env.getProperty("scanner.extensions");
        if (extensions == null)
        {
            extensions = DEFAULT_SCANNER_EXTENSIONS;
        }
        String[] exts = extensions.split(",");
        for (int i=0; i < exts.length; i++)
        {
            exts[i] = exts[i].trim();
        }
        String pattern = String.format("glob:*.{%s}", String.join(",", exts));
        logger.info(String.format("Should find any file matching this pattern -- %s", pattern));

        pathMatcher = FileSystems.getDefault().getPathMatcher(pattern);
    }

}

// THE END
