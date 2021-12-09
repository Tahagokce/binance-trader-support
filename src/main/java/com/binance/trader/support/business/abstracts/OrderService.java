package com.binance.trader.support.business.abstracts;

import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.account.NewOrderResponse;
import com.binance.api.client.domain.account.Order;
import com.core.utilities.results.DataResult;

import java.util.List;

public interface OrderService {
    DataResult<List<Order>> gettingListOfOpenOrders(String symbol);

    DataResult<List<Order>> gettingListOfAllOrdersWithLimit(String symbol, int limit);

    DataResult<Order> getStatusOfaParticularOrder (String symbol, long orderId );

    DataResult<String> cancelingAnOrder(String symbol, long orderId);

    void placingTestLimitOrder(String symbol,TimeInForce timeInForce,String quantity, String price);

    void placingTestMarketOrder(String symbol,String quantity );

    DataResult<NewOrderResponse> placingRealLimitOrder(String symbol,TimeInForce timeInForce,String quantity,String price);



}
