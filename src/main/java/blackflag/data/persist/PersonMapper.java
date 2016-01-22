/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.data.persist;

import blackflag.data.Person;

public interface PersonMapper
{
    /* Public methods ---------------------------------------------------- */

    public Person getPersonById (int id);
    public Person getPersonByName (String name);
}

// THE END
