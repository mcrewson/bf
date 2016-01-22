/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.data.persist;

import blackflag.data.MediaType;
import java.util.List;

public interface MediaTypeMapper
{
    /* Public methods ---------------------------------------------------- */

    public List<MediaType> getMediaTypes ();

    public MediaType getMediaTypeById (int id);
    public MediaType getMediaTypeByName (String name);

}

// THE END
