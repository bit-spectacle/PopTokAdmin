/**
 * 
 */

// parameter 받기
$.urlParam = function(name){
    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
    if (results==null){
       return "";
    }
    else{
       return results[1] || "";
    }
}


// Byte 기준으로 string 자르기
// parameter : str - 대상 문자열
// limitByte - 잘라낼 기준이 되는 Byte수
function cutByte(str, limitByte)
{
    var byteCnt = 0;
    var cutStr = '';

    for(var i=0; i<str.length; i++) 
    {
        if(str.charAt(i) >= ' ' && str.charAt(i) <= '~' ) 
        	byteCnt++;
        else byteCnt += 2;

        if(byteCnt > limitByte) 
        	return cutStr + "..";
        else 
        	cutStr += str.charAt(i);
    }
    
    return cutStr;
}
