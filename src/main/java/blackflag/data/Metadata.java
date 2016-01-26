/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.data;

import org.apache.ibatis.type.Alias;

/**
 * TODO: document Metadata class
 *
 * @author Mark Crewson (mark.crewson@alea.ca)
 */
@Alias("Metadata")
public class Metadata
{
    /* Internal data ----------------------------------------------------- */

    private int id;
    private String key;
    private String value;

    /* Attribute accessors ----------------------------------------------- */

    public int getId ()
    {
        return id;
    }

    public void setId ()
    {
        this.id = id;
    }

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

}

// THE END
