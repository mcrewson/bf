/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.data.persist;

import blackflag.data.Metadata;
import java.util.List;

public interface MetadataMapper
{
    /* Public methods ---------------------------------------------------- */

    public Metadata getMetadataById(int id);

    public List<Metadata> getAllMetadataForPerson (int person_id);
    public Metadata getMetadataForPersonByKey (int person_id, String key);

    public List<Metadata> getAllMetadataForWork (int work_id);
    public Metadata getMetadataForWorkByKey (int work_id, String key);

}

// THE END
