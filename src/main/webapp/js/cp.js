/*发起post请求*/
/*post('pages/statisticsJsp/excel.action', {html :prnhtml,cm1:'sdsddsd',cm2:'haha'});*/
function post(URL, PARAMS){
     var temp = document.createElement("form");
     temp.action = URL;
     temp.method = "post";
     temp.style.display = "none";
     for (var x in PARAMS)
     {
         var opt = document.createElement("textarea");
         opt.name = x;
         opt.value = PARAMS[x];
         temp.appendChild(opt);
     }
     document.body.appendChild(temp);
     temp.submit();
     document.getElementById("rollback").submit();
     return temp;
 }

/*返回上一级*/
function goBack(){
	window.location.href = document.referrer;
	window.history.back(-1);
}

