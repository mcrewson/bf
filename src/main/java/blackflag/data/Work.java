/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.data;

import org.apache.ibatis.type.Alias;
import java.util.List;

@Alias("Work")
public class Work
{
    /* Constants --------------------------------------------------------- */
    /* Class methods ----------------------------------------------------- */
    /* Internal data ----------------------------------------------------- */

    private int id;
    private String name;
    private MediaType media_type;
    private List<Person> creators;
    private List<Metadata> metadata;

    /* Public methods ---------------------------------------------------- */

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

    public MediaType getMediaType ()
    {
        return media_type;
    }

    public void setMediaType (MediaType media_type)
    {
        this.media_type = media_type;
    }

    public List<Person> getCreators ()
    {
        return creators;
    }

    public void setCreators (List<Person> creators)
    {
        this.creators = creators;
    }

    public List<Metadata> getMetadata ()
    {
        return metadata;
    }

    public void setMetadata (List<Metadata> metadata)
    {
        this.metadata = metadata;
    }

}

// THE END
