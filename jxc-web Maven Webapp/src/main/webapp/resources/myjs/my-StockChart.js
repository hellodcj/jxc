Highcharts.theme = {
//	colors: ["#DDDF0D", "#7798BF", "#55BF3B", "#DF5353", "#aaeeee", "#ff0066", "#eeaaee",
//		"#55BF3B", "#DF5353", "#7798BF", "#aaeeee"],
//	chart: {
//		backgroundColor: {
//			linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
//			stops: [
//				[0, 'rgb(96, 96, 96)'],
//				[1, 'rgb(16, 16, 16)']
//			]
//		},
//		borderWidth: 0,
//		borderRadius: 0,
//		plotBackgroundColor: null,
//		plotShadow: false,
//		plotBorderWidth: 0
//	},
//	title: {
//		style: {
//			color: '#FFF',
//			font: '16px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
//		}
//	},
//	subtitle: {
//		style: {
//			color: '#DDD',
//			font: '12px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
//		}
//	},
//	xAxis: {
//		gridLineWidth: 0,
//		lineColor: '#999',
//		tickColor: '#999',
//		labels: {
//			style: {
//				color: '#999',
//				fontWeight: 'bold'
//			}
//		},
//		title: {
//			style: {
//				color: '#AAA',
//				font: 'bold 12px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
//			}
//		}
//	},
//	yAxis: {
//		alternateGridColor: null,
//		minorTickInterval: null,
//		gridLineColor: 'rgba(255, 255, 255, .1)',
//		minorGridLineColor: 'rgba(255,255,255,0.07)',
//		lineWidth: 0,
//		tickWidth: 0,
//		labels: {
//			style: {
//				color: '#999',
//				fontWeight: 'bold'
//			}
//		},
//		title: {
//			style: {
//				color: '#AAA',
//				font: 'bold 12px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
//			}
//		}
//	},
//	legend: {
//		itemStyle: {
//			color: '#CCC'
//		},
//		itemHoverStyle: {
//			color: '#FFF'
//		},
//		itemHiddenStyle: {
//			color: '#333'
//		}
//	},
//	labels: {
//		style: {
//			color: '#CCC'
//		}
//	},
//	tooltip: {
//		backgroundColor: {
//			linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
//			stops: [
//				[0, 'rgba(96, 96, 96, .8)'],
//				[1, 'rgba(16, 16, 16, .8)']
//			]
//		},
//		borderWidth: 0,
//		style: {
//			color: '#FFF'
//		}
//	},
//
//
//	plotOptions: {
//		series: {
//			shadow: true
//		},
//		line: {
//			dataLabels: {
//				color: '#CCC'
//			},
//			marker: {
//				lineColor: '#333'
//			}
//		},
//		spline: {
//			marker: {
//				lineColor: '#333'
//			}
//		},
//		scatter: {
//			marker: {
//				lineColor: '#333'
//			}
//		},
//		candlestick: {
//			lineColor: 'white'
//		}
//	},
//
//	toolbar: {
//		itemStyle: {
//			color: '#CCC'
//		}
//	},
//
//	navigation: {
//		buttonOptions: {
//			symbolStroke: '#DDDDDD',
//			hoverSymbolStroke: '#FFFFFF',
//			theme: {
//				fill: {
//					linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
//					stops: [
//						[0.4, '#606060'],
//						[0.6, '#333333']
//					]
//				},
//				stroke: '#000000'
//			}
//		}
//	},
//
//	// scroll charts
//	rangeSelector: {
//		enabled:false
//	},
//
//	navigator: {
//		handles: {
//			backgroundColor: '#666',
//			borderColor: '#AAA'
//		},
//		outlineColor: '#CCC',
//		maskFill: 'rgba(16, 16, 16, 0.5)',
//		series: {
//			color: '#7798BF',
//			lineColor: '#A6C7ED'
//		}
//	},
//
//	scrollbar: {
//		barBackgroundColor: {
//				linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
//				stops: [
//					[0.4, '#888'],
//					[0.6, '#555']
//				]
//			},
//		barBorderColor: '#CCC',
//		buttonArrowColor: '#CCC',
//		buttonBackgroundColor: {
//				linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
//				stops: [
//					[0.4, '#888'],
//					[0.6, '#555']
//				]
//			},
//		buttonBorderColor: '#CCC',
//		rifleColor: '#FFF',
//		trackBackgroundColor: {
//			linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
//			stops: [
//				[0, '#000'],
//				[1, '#333']
//			]
//		},
//		trackBorderColor: '#666'
//	},
//
//	// special colors for some of the demo examples
//	legendBackgroundColor: 'rgba(48, 48, 48, 0.8)',
//	legendBackgroundColorSolid: 'rgb(70, 70, 70)',
//	dataLabelsColor: '#444',
//	textColor: '#E0E0E0',
//	maskColor: 'rgba(255,255,255,0.3)',
	global: { useUTC: false } ,
	lang : {
		shortMonths : [ '1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月',
				'10月', '11月', '12月' ],
		months : [ '1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月',
				'11月', '12月' ],
		rangeSelectorFrom : '从',
		rangeSelectorTo : '到',
		rangeSelectorZoom : '日期区间',
		weekdays : [ '星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六' ]
	}
};

// Apply the theme
var highchartsOptions = Highcharts.setOptions(Highcharts.theme);

var chart;

function destroyChart() {
	if(chart) {
		chart.destroy();
		chart = null;
	}
}
function addPoint(data, options) {
	series = chart.series[0];
	var datalen = series.xData.length; // series.data.length 有可能会是0的情况，实际有点
	//if(chart.series[0].xData[chart.series[0].xData.length - 1] != data[0])
	if(datalen<60) {
		series.addPoint(data, true, false);
	} else {
		series.addPoint(data, true, true);
	}


}
function addData(data, options, hor, destroy) {
	if(data.length == 0) return;
	if(destroy) destroyChart();
	var min = null, max = null;
	if(data[0].params) { // 设置Y刻度
		min = -2, max = 2;
		if(data[0].params.sensor.type == 0) {
			var des = data[0].params.st.rangedes;
			// 避免当值为min的情况，曲线看不到
			min = parseInt(des.split('~')[0]) - 1;
			max = parseInt(des.split('~')[1]) + 1;
		}
	}
	if(chart) {
		chart.addSeries(data[0]);
	} else {
		var yAix = {
			min: min-1,
			max: max,
			title : {
				text : options.ytitle
			},
			tickPixelInterval:15,
			lineWidth: 2,
	    	labels: {
	    		align: 'right',
	    		x: -3,
	    		y: 6
	    	} ,
			plotLines : hor
		}, tooltip =  {
				valueDecimals : 2,
				xDateFormat : '%Y-%m-%d %H:%M:%S',
		};
		if(data[0].step) { // 开关量
			//data[0].params.sensor
			var high = data[0].params.sensor.highdes,
				low = data[0].params.sensor.lowdes,
				normal = data[0].params.sensor.normal;
			yAix = {
				tickPositions: [-2, 0, 1, 3],
				labels: {
		    		formatter: function() {
		    			if(this.value == 0) return low;
		    			if(this.value == 1) return high;
		    			return '';
		    		}
		    	}
			};
			tooltip = {
				xDateFormat : '%Y-%m-%d %H:%M:%S',
				useHTML: true,
				formatter: function() {
					return '<b>'+ Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'</b>' +
	    			'<br/>'+(this.y == 0 ? low : ('<font color="red">'+high+'</font>'));
				}
			};
		}
		makeData(data, options, hor, min, max, yAix, tooltip);
	}
}
function removeData(name) {
	if(chart) {
		var datas = chart.series;
		var removes = [];
		for(var i = 0; i < datas.length; i ++) {
			var item = datas[i];
			if(item.name == name) {
				removes.push(item);
			}
		}
		try {
			for(var i = 0; i < removes.length; i ++) {
				removes[i].remove();
			}
			if(chart.series.length == 0 || (chart.series.length == 1 && chart.series[0].name == 'Navigator')) {
				destroyChart();
			}
		} catch(e) {}
	}
}
// options {title,ytitle}
function makeData(data, options, hor, min, max, yAix, tooltip) {
	// Create the chart
	chart = new Highcharts.StockChart({
		chart : {
			type:(options.type==null?'line':options.type),
			renderTo : document.getElementById(options.div),
			zoomType: 'x',
			height:480
		},
		credits : {
			enabled : false
		},
		title : {
			text : options.title
		},
		rangeSelector : {
			enabled: false
		},
		series : data,
		tooltip : tooltip,/*{
			valueDecimals : 2,
			xDateFormat : '%Y-%m-%d %H:%M:%S',
		}*/
		xAxis : {
			// events : {
			// afterSetExtremes : afterSetExtremes
			// },
			title : {
				text : '日期/时间'
			},
			type : 'datetime',
			maxPadding : 0.05,
			minPadding : 0.05,
			tickWidth : 1,// 刻度的宽度
			lineWidth : 1,// 自定义x轴宽度
			//gridLineWidth : 1,// 默认是0，即在图上没有纵轴间隔线
			lineColor : '#990000',
			tickPixelInterval:80,
			//tickInterval: 5,隔几个点显示x坐标
			minRange: 60 * 1000,
			// x轴时间的格式化
			dateTimeLabelFormats : {
				second : '%H时<br/>%M分%S秒',
				minute : '%H时<br/>%M分%S秒',
				hour : '%H时<br/>%M分%S秒',
				day : '%m-%d',
				week : '%m-%d',
				month : '%Y-%m',
				year : '%Y'
			}
		},

		yAxis : yAix,/*{
			min: min-1,
			max: max,
			title : {
				text : options.ytitle
			},
			tickPixelInterval:15,
			lineWidth: 2,
	    	labels: {
	    		align: 'right',
	    		x: -3,
	    		y: 6
	    	} ,
			plotLines : hor
		}*/
		legend : {
			enabled: typeof options.range == 'undefined' ? true : false,
	    	align: 'center',
        	backgroundColor: '#FCFFC5',
        	borderColor: 'black',
        	borderWidth: 2,
	    	//layout: 'vertical',
	    	verticalAlign: 'top',
	    	y: 30,
	    	shadow: true
		},
		  navigator: {
			  	enabled: true,/*typeof options.range == 'undefined' ? true : false,*/
		    	outlineWidth:0.5,
	            xAxis : {
	                dateTimeLabelFormats : {
					second : '%H:%M:%S',
					minute : '%d<br/>%H:%M',
					hour : '%d<br/>%H:%M',
					day : '%m-%d',
					week : '%m-%d',
					month : '%Y-%m',
					year : '%Y'
				}
	            }
		    },
 		    exporting: {
		    	enabled: false
		    }

	});

}