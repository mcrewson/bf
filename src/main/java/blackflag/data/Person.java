/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.data;

import org.apache.ibatis.type.Alias;

@Alias("Person")
public class Person
{
    /* Internal data ----------------------------------------------------- */
    
    private int id;
    private String name;
    private String sorted_name;

    /* Object overrides -------------------------------------------------- */

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getSortedName ()
    {
        return sorted_name;
    }

    public void setSortedName (String sorted_name)
    {
        this.sorted_name = sorted_name;
    }

}

// THE END
