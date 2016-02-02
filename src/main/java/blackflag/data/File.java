/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.data;

import org.apache.ibatis.type.Alias;
import java.time.LocalDateTime;

@Alias("File")
public class File
{
    /* Internal data ----------------------------------------------------- */

    private String name;
    private String location;
    private LocalDateTime timestamp;
    private String truncdigest;
    private String digest;

    /* Attribute accessors ----------------------------------------------- */

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getLocation ()
    {
        return location;
    }

    public void setLocation (String name)
    {
        this.location = location;
    }

    public LocalDateTime getTimestamp ()
    {
        return timestamp;
    }

    public void setTimestamp (LocalDateTime timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getTruncdigest ()
    {
        return truncdigest;
    }

    public void setTruncdigest (String truncdigest)
    {
        this.truncdigest = truncdigest;
    }

    public String getDigest ()
    {
        return digest;
    }

    public void setDigest (String digest)
    {
        this.digest = digest;
    }

}

// THE END
