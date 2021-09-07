package com.binance.trader.support.business.concretes;

import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.account.NewOrderResponse;
import com.binance.api.client.domain.account.Order;
import com.binance.api.client.domain.account.request.AllOrdersRequest;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;
import com.binance.api.client.exception.BinanceApiException;
import com.binance.trader.support.business.abstracts.OrderService;

import java.util.List;

import static com.binance.api.client.domain.account.NewOrder.limitBuy;
import static com.binance.api.client.domain.account.NewOrder.marketBuy;
import static com.binance.trader.support.api.controller.UsersController.client;

public class OrderManager implements OrderService {




    //  Acik siparişlerin listedi döner.
    @Override
    public List<Order> gettingListOfOpenOrders(String symbol) {

        List<Order> openOrders = client.getOpenOrders(new OrderRequest(symbol));

        return openOrders;
    }


    // Verilen limitteki siparişleri listeler.
    @Override
    public List<Order> gettingListOfAllOrdersWithLimit(String symbol, int limit) {

        List<Order> allOrders = client.getAllOrders(new AllOrdersRequest(symbol).limit(limit));

        return allOrders;
    }


    // Belirli siparişin durumunu döner.
    @Override
    public Order getStatusOfaParticularOrder(String symbol, long orderId) {

        Order order = client.getOrderStatus(new OrderStatusRequest(symbol, orderId));

        return order;
    }


    // Bir siparişi iptal etme.
    @Override
    public String cancelingAnOrder(String symbol, long orderId) {

        try {
            client.cancelOrder(new CancelOrderRequest(symbol, orderId));
        } catch (BinanceApiException e) {
            return e.getError().getMsg();
        }

        return ("Success");
    }


    // Test LIMIT siparişi verme.
    @Override
    public void placingTestLimitOrder(String symbol, TimeInForce timeInForce, String quantity, String price) {

        client.newOrderTest(limitBuy(symbol, timeInForce, quantity, price));
    }


    // Test MARKET siparişi verme.
    @Override
    public void placingTestMarketOrder(String symbol, String quantity) {

        client.newOrderTest(marketBuy(symbol, quantity));
    }


    // Gerçek LIMIT siparişi verme.
    @Override
    public NewOrderResponse placingRealLimitOrder(String symbol, TimeInForce timeInForce, String quantity, String price) {

        NewOrderResponse newOrderResponse = client.newOrder(limitBuy(symbol, timeInForce,  quantity, price));
        return newOrderResponse;
    }
}
