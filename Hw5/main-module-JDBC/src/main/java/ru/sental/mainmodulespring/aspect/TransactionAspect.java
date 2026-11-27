package ru.sental.mainmodulespring.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.sental.mainmodulespring.jdbc.ConnectionHolder;

@Aspect
@Component
@RequiredArgsConstructor
public class TransactionAspect {

    private final ConnectionHolder connectionHolder;

    @Around("@annotation(ru.sental.mainmodulespring.annotation.Transaction)")
    public Object aroundTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        connectionHolder.beginTransaction();
        try {
            Object result = joinPoint.proceed();
            connectionHolder.commitAndReset();
            return result;
        } catch (RuntimeException e) {
            connectionHolder.rollbackAndReset();
            throw e;
        }
    }
}
