package classwork.da.externalize;

import classwork.entity.externalize.Fallback;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.Externalizable;
import java.io.File;
import java.io.IOException;
import java.io.ObjectStreamClass;
public class ExternalizeReader {

    public Fallback read(String url) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        final Fallback fallback = mapper.readValue(new File(url), Fallback.class);
        return fallback;
    }
    
}
