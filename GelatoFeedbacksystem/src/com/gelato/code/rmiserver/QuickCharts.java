/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gelato.code.rmiserver;

import io.quickchart.QuickChart;

/**
 * this class is to generate chart URLs
 * @author Nipuna Thathsara
 */
public class QuickCharts {
    
    /**
     * this method will send a request for doughnut chart and returns the generated url for the Favorite ice cream 
     * https://quickchart.io/documentation/(the base code is available in here)
     * @param data
     * @return 
     */
     public static String geticecreamChart(String [][] data)
    {
        QuickChart chart = new QuickChart();
		chart.setWidth(500);
		chart.setHeight(300);
		chart.setConfig("{\n" +
                "  type: 'doughnut',\n" +
                "  data: {\n" +
                "    datasets: [\n" +
                "      {\n" +
                "        data: ["+Integer.parseInt(data[0][1])+", "+Integer.parseInt(data[1][1])+","+Integer.parseInt(data[2][1])+" ,"+Integer.parseInt(data[3][1])+""
                        + " ,"+Integer.parseInt(data[4][1])+" ], \n" +
                "        backgroundColor: [ 'rgb(255, 99, 132)', 'rgb(255, 159, 64)','rgb(255, 205, 86)', 'rgb(75, 192, 192)', 'rgb(54, 162, 235)', 'rgb(180, 109, 222)' ],\n" +
                "      },\n" +
                "    ],\n" +
                "    labels: ['"+data[0][0]+"', '"+data[1][0]+"', '"+data[2][0]+"','"+data[3][0]+"','"+data[4][0]+"'],\n" +
                "  },\n" +
                "  options: {\n" +
                "    plugins: {\n" +
                "      datalabels: {\n" +
                "        formatter: (value) => {\n" +
                "          return value + '%';\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}"
		);
                

		System.out.println(chart.getShortUrl());
                String url = chart.getShortUrl();
                
                return url;
    }
    /**
     * this method will send a request for doughnut chart and returns the generated url for the other food people like rather than ice cream
     * @param data
     * @return 
     */
    public static String getOtherfoodChart(String [][] data)
    {
        QuickChart chart = new QuickChart();
		chart.setWidth(500);
		chart.setHeight(300);
		chart.setConfig("{\n" +
                "  type: 'doughnut',\n" +
                "  data: {\n" +
                "    datasets: [\n" +
                "      {\n" +
                "        data: ["+Integer.parseInt(data[0][1])+", "+Integer.parseInt(data[1][1])+",  "+Integer.parseInt(data[2][1])+"],\n" +
                "        backgroundColor: [ 'rgb(255, 99, 132)', 'rgb(255, 159, 64)', 'rgb(164,235,52)'],\n" +
                "      },\n" +
                "    ],\n" +
                "    labels: ['"+data[0][0]+"', '"+data[1][0]+"', '"+data[2][0]+"'],\n" +
                "  },\n" +
                "  options: {\n" +
                "    plugins: {\n" +
                "      datalabels: {\n" +
                "        formatter: (value) => {\n" +
                "          return value + '%';\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}"
		);
                

		System.out.println(chart.getShortUrl());
                String url = chart.getShortUrl();
                
                return url;
    }
    /**
     * this method will send a request for doughnut chart and returns the generated url for the Ratings for the food in the shop
     * @param data
     * @return 
     */
    public static String getRatingfoodChart(String [][] data)
    {
        QuickChart chart = new QuickChart();
		chart.setWidth(500);
		chart.setHeight(300);
		chart.setConfig("{\n" +
                "  type: 'doughnut',\n" +
                "  data: {\n" +
                "    datasets: [\n" +
                "      {\n" +
                "        data: ["+Integer.parseInt(data[0][1])+", "+Integer.parseInt(data[1][1])+",  "+Integer.parseInt(data[2][1])+"],\n" +
                "        backgroundColor: [ 'rgb(255, 99, 132)', 'rgb(255, 159, 64)','rgb(164,235,52)' ],\n" +
                "      },\n" +
                "    ],\n" +
                "    labels: ['"+data[0][0]+"', '"+data[1][0]+"','"+data[2][0]+"'],\n" +
                "  },\n" +
                "  options: {\n" +
                "    plugins: {\n" +
                "      datalabels: {\n" +
                "        formatter: (value) => {\n" +
                "          return value + '%';\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}"
		);
                

		System.out.println(chart.getShortUrl());
                String url = chart.getShortUrl();
                
                return url;
    }
   /**
    * this method will send a request for doughnut chart and returns the generated url for the Opinion on the food in the shop
    * @param data
    * @return 
    */
     public static String getOpinionChart(String [][] data)
    {
        QuickChart chart = new QuickChart();
		chart.setWidth(500);
		chart.setHeight(300);
		chart.setConfig("{\n" +
                "  type: 'doughnut',\n" +
                "  data: {\n" +
                "    datasets: [\n" +
                "      {\n" +
                "        data: ["+Integer.parseInt(data[0][1])+", "+Integer.parseInt(data[1][1])+", ],\n" +
                "        backgroundColor: [ 'rgb(255, 99, 132)', 'rgb(255, 159, 64)', ],\n" +
                "      },\n" +
                "    ],\n" +
                "    labels: ['"+data[0][0]+"', '"+data[1][0]+"',],\n" +
                "  },\n" +
                "  options: {\n" +
                "    plugins: {\n" +
                "      datalabels: {\n" +
                "        formatter: (value) => {\n" +
                "          return value + '%';\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}"
		);
                

		System.out.println(chart.getShortUrl());
                String url = chart.getShortUrl();
                
                return url;
    }
    
    
}

  
   

