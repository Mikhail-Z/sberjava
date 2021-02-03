package profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component()
@Profile("dev")
public class NoopBusinessLogicExecutor implements BusinessLogicExecutor {
}
