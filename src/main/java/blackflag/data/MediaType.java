/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.data;

import org.apache.ibatis.type.Alias;
import java.util.List;

@Alias("MediaType")
public class MediaType
{
    /* Internal data ----------------------------------------------------- */

    private int id;
    private String name;
    private MediaType parent_type;

    /* Attribute accessors ----------------------------------------------- */

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public MediaType getParentType ()
    {
        return parent_type;
    }

    public void setParentType (MediaType parent_type)
    {
        this.parent_type = parent_type;
    }

}

// THE END
