/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.data.persist;

import blackflag.data.File;
import java.util.List;

public interface FileMapper
{
    /* Public methods ---------------------------------------------------- */

    public List<File> getFilesByName (String name);
    public List<File> getFilesByTruncdigest (String truncdigest);
    
    public File getFileByNameAndLocation (String name, String location);
    public File getFileByDigest (String digest);

}

// THE END
