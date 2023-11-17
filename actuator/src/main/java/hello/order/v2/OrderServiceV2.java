package hello.order.v2;

import hello.order.OrderService;
import io.micrometer.core.annotation.Counted;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderServiceV2 implements OrderService {

    private final AtomicInteger stock = new AtomicInteger(100);

    @Override
    @Counted("my.order")
    public void order() {
        log.info("주문");
        stock.decrementAndGet();
    }

    @Override
    @Counted("my.order")
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet();

    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
