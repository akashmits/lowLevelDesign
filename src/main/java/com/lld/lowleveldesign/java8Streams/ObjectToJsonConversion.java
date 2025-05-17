package com.lld.lowleveldesign.java8Streams;

import java.util.Map;

public class ObjectToJsonConversion {

    public  static String jsonStringify(Object o){
        if(o ==  null){
            return "null";
        }
        else if(o instanceof  String){
            return "\""+o+ "\"";
        } else if(o instanceof Integer || o instanceof Boolean)
            return o.toString();
        else if (o instanceof Object[]){
            Object [] oo= (Object[]) o;
            StringBuilder sb= new StringBuilder();
            sb.append("[");
            for(int i=0;i<oo.length;i++){
                sb.append(jsonStringify(oo[i]));
                if(i != oo.length-1){
                    sb.append(",");
                }
            }
            sb.append("]");
            return sb.toString();
        }else if(o instanceof Map){
            Map<?,?> map =(Map<?, ?>) o;
            int i=0;
            StringBuilder sb= new StringBuilder();
            sb.append("{");
            for(Map.Entry<?,?> entry : map.entrySet()){
                sb.append(jsonStringify(entry.getKey()));
                sb.append(":");
                sb.append(jsonStringify(entry.getValue()));

                if(i< map.size()-1){
                    sb.append(",");
                }
                    ++i;
            }
            sb.append("}");
                return sb.toString();
        }

        return "";
    }

    public static void main(String [] arg){
        String jsonString = jsonStringify("Hello World!");
        System.out.println(jsonString);  // Outputs: "Hello World!
    }
}
