/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.app;

import blackflag.data.SystemMessage;
import blackflag.data.persist.SystemMessageMapper;

import java.util.List;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemMessageService
{
    /* Internal data ----------------------------------------------------- */

    @Autowired
    private SystemMessageMapper systemMessageMapper;

    /* Public methods ---------------------------------------------------- */

    public SystemMessage createSystemMessage (String reporter, String content, LocalDateTime timestamp)
    {
        SystemMessage sysmsg = new SystemMessage(reporter, content, timestamp);
        systemMessageMapper.createSystemMessage(sysmsg);
        return sysmsg;
    }

    public List<SystemMessage> getSystemMessages ()
    {
        return systemMessageMapper.getSystemMessages();
    }

}

// THE END
