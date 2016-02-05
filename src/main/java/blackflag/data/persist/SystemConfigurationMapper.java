/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.data.persist;

import blackflag.data.SystemConfiguration;
import java.util.List;

public interface SystemConfigurationMapper
{
    /* Public methods ---------------------------------------------------- */

    public SystemConfiguration getSystemConfiguration (String parameter);

    public List<SystemConfiguration> getAllSystemConfigurations ();

    public void updateSystemConfiguration (String parameter, String value);

}

// THE END
