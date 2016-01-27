/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.data.persist;

import blackflag.data.Person;
import blackflag.data.Work;
import java.util.List;

public interface WorkMapper
{
    /* Public methods ---------------------------------------------------- */

    public Work getWorkById (int id);
    public Work getWorkByName (String name);

    public List<Person> getWorkCreators (int id);

}

// THE END
