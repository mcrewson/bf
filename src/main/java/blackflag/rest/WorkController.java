/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.rest;

import blackflag.data.Work;
import blackflag.data.persist.MetadataMapper;
import blackflag.data.persist.WorkMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${urls.api_prefix}/work")
public class WorkController
{
    /* Internal data ----------------------------------------------------- */

    @Autowired
    private WorkMapper workMapper;

    @Autowired
    private MetadataMapper metadataMapper;

    /* Public methods ---------------------------------------------------- */

    @RequestMapping(path="/{name}", method = RequestMethod.GET)
    public Work getWork (@PathVariable String name)
    {
        Work w = workMapper.getWorkByName(name);
        w.setCreators(workMapper.getWorkCreators(w.getId()));
        w.setMetadata(metadataMapper.getAllMetadataForWork(w.getId()));
        return w;
    }

}

// THE END
