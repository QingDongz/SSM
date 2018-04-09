package cn.summerwaves.util;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import java.util.List;

public class JsonPropertyFilter {


    public JSONArray jsonPropertyFilter(final List list, final List<String> filter) {

        JsonConfig jsonConfig = new JsonConfig();

        jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
            // 重写内部的允许字段通过的方法
            @Override
            public boolean apply(Object source, String name, Object value) {
                return filter.contains(name);
            }
        });
        // 设置json的属性的过滤器
        // 创建属性过滤器的内部内部对象
        JSONArray jsonArray = JSONArray.fromObject(list,
                jsonConfig);
        return jsonArray;

    }
}