<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<div class="widget-box">
	<div class="widget-header header-color-pink">
		<h5><i class="icon-table"></i>销售趋势--折线图</h5>
	</div>
	<div class="widget-body">
		<div class="widget-main no-padding" id="container">
		</div>
	</div>
	</div>

<script type="text/javascript">

$(function () {
	var x = "${graghData.xAxis}";
	var y = JSON.parse("${graghData.yAxis}");
	x= x.substring(1,x.length-1).split(',');
	
    $('#container').highcharts({
        title: {
            text: '近30天销售趋势',
            x: -20 //center
        },
        xAxis: {
            categories: x,
            labels : {
				step : 7
			}
        },
        yAxis: {
            title: {
                text: '销售金额'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '元'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: '销售金额',
            data: y
        }]
    });
});
</script>