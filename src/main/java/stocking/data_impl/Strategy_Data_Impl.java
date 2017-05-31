package stocking.data_impl;

import net.sf.json.JSONArray;
import stocking.data_service.Strategy_Data_Service;
import stocking.po.StrategyPO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xjwhhh on 2017/5/31.
 */
public class Strategy_Data_Impl implements Strategy_Data_Service {
    Tools tools = new Tools();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public StrategyPO traceBack(String type, Date start, Date end, int form, int hold, String isPla, JSONArray stocks) {
        String startDate = formatter.format(start);
        String endDate = formatter.format(end);
        try {
            List<String> commands = new LinkedList<String>();
            commands.add("python");
            commands.add(tools.getProjectPath("src\\main\\java\\stocking\\python_Impl\\TraceBack.py"));
            commands.add(type);//策略类型
            commands.add(startDate);//开始日期
            commands.add(endDate);//结束日期
            commands.add(String.valueOf(form));//形成期
            commands.add(String.valueOf(hold));//持有期
            commands.add(isPla);//是否为板块
            commands.add(tools.jsonArrayToString(stocks));//股票列表转成的string

            ProcessBuilder processBuilder = new ProcessBuilder(commands);
            Process pr = processBuilder.start();
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(pr.getInputStream(), "gbk"));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                //TODO 返回的数据的处理
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}