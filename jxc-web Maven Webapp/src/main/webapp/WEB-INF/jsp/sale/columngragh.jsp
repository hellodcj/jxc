<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<div class="widget-box">
	<div class="widget-header header-color-pink">
		<h5><i class="icon-table"></i>销售趋势--柱状图图</h5>
	</div>
	<div class="widget-body">
		<div class="widget-main no-padding" id="container">
		</div>
	</div>
	</div>

<script type="text/javascript">

$(function () {
	var x = "${graghData.yesterdaySale}";
	var y = "${graghData.lastWeekSale}";
	var z = "${graghData.lastMonthSale}";
	var xArray=new Array();
	var yArray=new Array();
	var zArray=new Array();
	xArray.push(parseFloat(x));
	yArray.push(parseFloat(y));
	zArray.push(parseFloat(z));
    $('#container').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: ''
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: [
                ''
            ]
        },
        yAxis: {
            min: 0,
            title: {
                text: '金额 (元)'
            }
        },
        tooltip: {
        	formatter: function() {  
                return '<b>'+ this.series.name +'</b><br/>'+  
                this.x +': '+ this.y+"元";  
        	}
        	
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: '昨日销售额',
            data: xArray

        }, {
            name: '近一个星期，日均销售额',
            data: yArray

        }, {
            name: '近一个月，日均销售额',
            data: zArray
        }]
    });
});
</script>