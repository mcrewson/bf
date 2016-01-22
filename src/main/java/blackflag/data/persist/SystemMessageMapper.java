/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.data.persist;

import blackflag.data.SystemMessage;

import java.util.List;

public interface SystemMessageMapper
{
    /* Public methods ---------------------------------------------------- */

    public void createSystemMessage (SystemMessage systemMessage);
    public List<SystemMessage> getSystemMessages ();
}

// THE END
