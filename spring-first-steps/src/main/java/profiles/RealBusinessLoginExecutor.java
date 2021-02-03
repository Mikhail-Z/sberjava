package profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component()
@Profile("prod")
public class RealBusinessLoginExecutor implements BusinessLogicExecutor {
}
