package stocking.data_impl;

import stocking.data_service.*;
import stocking.po.CustomerPO;
import stocking.po.StockPO;
import stocking.po.MarketPO;

/**
 * Created by dell on 2017/5/21.
 */
public class DataFactory_Data_Impl implements DataFactory_Data_Service {
    private static DataFactory_Data_Service factoryDataService;

    private DataFactory_Data_Impl() {

    }

    public static DataFactory_Data_Service getInstance() {
        if (factoryDataService == null) {
            return new DataFactory_Data_Impl();
        } else {
            return factoryDataService;
        }
    }

    public Customer_Data_Service customer() {
        return new Customer_Data_Impl();
    }

    public SingleSearch_Data_Service singleSearch() {
        return new SingleSearch_Data_Impl();
    }

    public OverallSearch_Data_Service overall() {
        return new OverallSearch_Data_Impl();
    }

    public Strategy_Data_Service strategy() {
        return new Strategy_Data_Impl();
    }

    public BGraph_Data_Service bGraph() {
        return new BGraph_Data_Impl();
    }

    public CustomerCollection_Data_Service customerCollection() {
        return null;
    }

    @Override
    public GetNews_Data_Service getNews() {
        return null;
    }

}
