/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.data;

import org.apache.ibatis.type.Alias;
import java.time.LocalDateTime;

@Alias("SystemMessage")
public class SystemMessage
{
    /* Internal data ----------------------------------------------------- */

    private String reporter;
    private String content;
    private LocalDateTime timestamp;

    /* Constructors ------------------------------------------------------ */

    public SystemMessage ()
    {
    }

    public SystemMessage (String reporter, String content, LocalDateTime timestamp)
    {
        setReporter(reporter);
        setContent(content);
        setTimestamp(timestamp);
    }

    /* Attribute accessors ----------------------------------------------- */

    public String getReporter ()
    {
        return reporter;
    }

    public void setReporter (String reporter)
    {
        this.reporter = reporter;
    }

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public LocalDateTime getTimestamp ()
    {
        return timestamp;
    }

    public void setTimestamp (LocalDateTime timestamp)
    {
        this.timestamp = timestamp;
    }

}

// THE END
