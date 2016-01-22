/* vim:set ts=4 sw=4 et nowrap syntax=java ff=unix:
 * 
 * $Id$
 */

package blackflag.rest;

import blackflag.data.MediaType;
import blackflag.data.persist.MediaTypeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${urls.api_prefix}/mediatype")
public class MediaTypeController
{
    /* Constants --------------------------------------------------------- */
    /* Class methods ----------------------------------------------------- */
    /* Internal data ----------------------------------------------------- */
    
    @Autowired
    private MediaTypeMapper mediaTypeMapper;

    /* Constructors ------------------------------------------------------ */
    /* Attribute accessors ----------------------------------------------- */
    /* Object overrides -------------------------------------------------- */
    /* XXX implementation ------------------------------------------------ */
    /* Public methods ---------------------------------------------------- */

    @RequestMapping(method=RequestMethod.GET)
    public List<MediaType> getMediaTypes ()
    {
        return mediaTypeMapper.getMediaTypes();
    }

    @RequestMapping(path="/{name}", method = RequestMethod.GET)
    public MediaType getMediaType (@PathVariable String name)
    {
        return mediaTypeMapper.getMediaTypeByName(name);
    }

    /* Abstract methods -------------------------------------------------- */
    /* Internal methods -------------------------------------------------- */
    /* Internal classes -------------------------------------------------- */

}

// THE END
