package task01_05.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;


public interface LoggerAnnotation {
    void writeInfo(String message);
    void writeWarn(String message);
    void writeError(String message);

    UUID getUuid();
}
