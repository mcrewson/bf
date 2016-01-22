/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.rest;

import blackflag.app.SystemMessageService;
import blackflag.data.SystemMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * TODO: document SystemMessageController class
 *
 * @author Mark Crewson (mark.crewson@alea.ca)
 */
@RestController
public class SystemMessageController
{
    /* Internal data ----------------------------------------------------- */

    @Autowired
    private SystemMessageService systemMessageService;

    /* Public methods ---------------------------------------------------- */

    @RequestMapping(value="/sysmsg", method=RequestMethod.POST)
    public SystemMessage createSystemMessage(@RequestBody SystemMessage sysmsg)
    {
        return systemMessageService.createSystemMessage(sysmsg.getReporter(),
                                                        sysmsg.getContent(),
                                                        sysmsg.getTimestamp());
    }

    @RequestMapping(value="/sysmsgs")
    public List<SystemMessage> getSystemMessages ()
    {
        return systemMessageService.getSystemMessages();
    }

}

// THE END
