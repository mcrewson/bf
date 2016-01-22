/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.data.persist;

import blackflag.data.Work;

public interface WorkMapper
{
    /* Public methods ---------------------------------------------------- */

    public Work getWorkById (int id);
    public Work getWorkByName (String name);

}

// THE END
