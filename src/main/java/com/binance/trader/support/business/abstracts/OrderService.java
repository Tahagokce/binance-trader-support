package com.binance.trader.support.business.abstracts;

import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.account.NewOrderResponse;
import com.binance.api.client.domain.account.Order;
import java.util.List;

public interface OrderService {


    List<Order> gettingListOfOpenOrders(String symbol);

    List<Order> gettingListOfAllOrdersWithLimit(String symbol, int limit);

    Order getStatusOfaParticularOrder (String symbol, long orderId );

    String cancelingAnOrder(String symbol, long orderId);

    void placingTestLimitOrder(String symbol,TimeInForce timeInForce,String quantity, String price);

    void placingTestMarketOrder(String symbol,String quantity );

    NewOrderResponse placingRealLimitOrder(String symbol,TimeInForce timeInForce,String quantity,String price);



}
