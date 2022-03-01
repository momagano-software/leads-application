package za.co.momagano.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restControllers() {
    }

    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void services() {
    }

    @Before("restControllers()")
    public void logRestControllerCalls(JoinPoint joinPoint) {
        logger.info("{}.{} called with arguments {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(value = "services()", returning = "returnedValue")
    public void logReturnedValuesInServices(JoinPoint joinPoint, Object returnedValue){
        logger.info("{}.{} returned {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                returnedValue);
    }

    @AfterThrowing(value = "services()", throwing = "exception")
    public void logExceptionsInServices(Throwable exception) {
        logger
                .error("Exception: ", exception);
    }

}
