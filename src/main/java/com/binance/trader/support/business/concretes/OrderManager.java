package com.binance.trader.support.business.concretes;

import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.BinanceApiSwapRestClient;
import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.account.NewOrderResponse;
import com.binance.api.client.domain.account.Order;
import com.binance.api.client.domain.account.request.AllOrdersRequest;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;
import com.binance.api.client.exception.BinanceApiException;
import com.binance.trader.support.business.abstracts.OrderService;
import com.core.utilities.results.DataResult;
import com.core.utilities.results.ErrorDataResult;
import com.core.utilities.results.SuccessDataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.binance.api.client.domain.account.NewOrder.limitBuy;
import static com.binance.api.client.domain.account.NewOrder.marketBuy;

@Service
@RequiredArgsConstructor
public class OrderManager implements OrderService {
    private final BinanceApiRestClient binanceApiRestClient;

    //  Acik siparişlerin listedi döner.
    @Override
    public DataResult<List<Order>> gettingListOfOpenOrders(String symbol) {

        List<Order> openOrders = binanceApiRestClient.getOpenOrders(new OrderRequest(symbol));

        return new SuccessDataResult<List<Order>>(openOrders);
    }


    // Verilen limitteki siparişleri listeler.
    @Override
    public DataResult<List<Order>> gettingListOfAllOrdersWithLimit(String symbol, int limit) {

        List<Order> allOrders = binanceApiRestClient.getAllOrders(new AllOrdersRequest(symbol).limit(limit));

        return new SuccessDataResult<List<Order>>(allOrders);
    }


    // Belirli siparişin durumunu döner.
    @Override
    public DataResult<Order> getStatusOfaParticularOrder(String symbol, long orderId) {

        Order order = binanceApiRestClient.getOrderStatus(new OrderStatusRequest(symbol, orderId));

        return new SuccessDataResult<Order>(order);
    }


    // Bir siparişi iptal etme.
    @Override
    public DataResult<String> cancelingAnOrder(String symbol, long orderId) {

        try {
            binanceApiRestClient.cancelOrder(new CancelOrderRequest(symbol, orderId));
        } catch (BinanceApiException e) {
            return new ErrorDataResult<String>(e.getError().getMsg().toString(), "hata");
        }

        return new SuccessDataResult<String>("Başarılı", "başarılı");
    }


    // Test LIMIT siparişi verme.
    @Override
    public void placingTestLimitOrder(String symbol, TimeInForce timeInForce, String quantity, String price) {

        binanceApiRestClient.newOrderTest(limitBuy(symbol, timeInForce, quantity, price));

    }


    // Test MARKET siparişi verme.
    @Override
    public void placingTestMarketOrder(String symbol, String quantity) {

        binanceApiRestClient.newOrderTest(marketBuy(symbol, quantity));
    }


    // Gerçek LIMIT siparişi verme.
    @Override
    public DataResult<NewOrderResponse> placingRealLimitOrder(String symbol, TimeInForce timeInForce, String quantity, String price) {

        NewOrderResponse newOrderResponse = binanceApiRestClient.newOrder(limitBuy(symbol, timeInForce, quantity, price));
        return new SuccessDataResult<NewOrderResponse>(newOrderResponse);
    }
}