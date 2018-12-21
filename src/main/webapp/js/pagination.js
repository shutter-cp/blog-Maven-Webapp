/**
 * htmlsl  分页需要重复的前段代码
 * htmlsr  分页需要重复的后段代码
 * objs    分页元素的id的"#??"或者class的".??"
 * steps   步长，每次分页显示几个
 * numbers 一共有多少页
 * 
 * 
 * inits 初始化
 * pageLeft 往前翻
 * pageRight 往后翻
 */
pageInaTion = function(htmlsl,htmlsr,objs,steps,numbers){
	var obj = {};
	obj.htmlsl = htmlsl;
	obj.htmlsr = htmlsr;
	obj.steps = steps;
	obj.numbers = numbers;
	obj.objs = objs;
	
	var i = 1;
	
	//初始化
	obj.inits = function(){
		var pageHtml = '';
		if(numbers>=steps){
			for(;i<=steps;i++){
				pageHtml += htmlsl+ i+ htmlsr;
			}
		}else{
			for(;i<=numbers;i++){
				pageHtml += htmlsl+ i+ htmlsr;
			}
		}
		$(objs).html("");
		$(objs).html(pageHtml);
	}
	
	//往前翻
	obj.pageLeft = function(){
		pageHtml = '';
		var temp = i%steps -1;
		if(temp!=0){
			if(i>steps){
				i = i - temp -steps;
				for(var y=i;i<y+steps;i++){
					pageHtml += htmlsl+ i+ htmlsr;
				}
				$(objs).html("");
				$(objs).html(pageHtml);
			}
		}else{
			if((i-(steps*2))>0){
				i = i-10;
				for(var y=i;i<y+steps;i++){
					pageHtml += htmlsl+ i+ htmlsr;
				}
				$(objs).html("");
				$(objs).html(pageHtml);
			}
		}
	}
	
	//往后翻
	obj.pageRight = function(){
		pageHtml = '';
		if(i+steps<=numbers){
			for(var y=i;i<y+steps;i++){
				pageHtml += htmlsl+ i+ htmlsr;
			}
			$(objs).html("");
			$(objs).html(pageHtml);
		}else if(i+steps>numbers&&i-1<numbers){
			for(;i<=numbers;i++){
				pageHtml += htmlsl+ i+ htmlsr;
			}
			//i--;
			$(objs).html("");
			$(objs).html(pageHtml);
		}
	}
	return obj;
}