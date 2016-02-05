/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.data;

import org.apache.ibatis.type.Alias;

@Alias("SystemConfiguration")
public class SystemConfiguration
{
    /* Internal data ----------------------------------------------------- */

    private String parameter;
    private String value;

    /* Constructors ------------------------------------------------------ */

    public SystemConfiguration ()
    {
    }

    public SystemConfiguration (String parameter, String value)
    {
        this.parameter = parameter;
        this.value = value;
    }

    /* Attribute accessors ----------------------------------------------- */

    public String getParameter ()
    {
        return parameter;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

}

// THE END
