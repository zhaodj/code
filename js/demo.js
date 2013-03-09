function sort(arr){
	var largeArr=$.map(arr,function(v,idx){
		if(v===0){ 
			return {idx:idx,value:v};
		}
		return null;
	});
	var msArr=$.map(arr,function(v,idx){
		if(v===1){ 
			return {idx:idx,value:v};
		}
		return null;
	});
	var cal=calculate(largeArr.length,arr.length);
	var result=[],selectedIdx=[];
	for(var i=0;i<arr.length;i++){
		if(selectedIdx.indexOf(i)<0){
			if(arr[i]==0){
				result.push(arr[i]);
				cal.large--;
				selectedIdx.push(i);
			}else if(arr[i]==1){
				if(cal.medium>0&&cal.small>0){
					if(Math.random()>=0.5){
						result.push(getMedium());
					}
					else{
						result.push(getSmall());
					}
				}else if(cal.medium>0){
					result.push(getMedium());
				}else if(cal.small>0){
					result.push(getSmall());
				}
			}
		}
	}
	return result;
	function shift(){
		var item=msArr.shift();
		selectedIdx.push(item.idx);
		return item.value;
	}
	function getMedium(){
		cal.medium--;
		return [shift(),shift()];
	}
	function getSmall(){
		cal.small--;
		return [shift(),shift(),shift()];
	}

}

function calculate(largeNum,size){
	var ms=size-largeNum,maxMediumNum=parseInt(ms/2),result;
	if(ms==0){
		result = {large:largeNum,medium:0,small:0};
	}else if(maxMediumNum==0){
		result = {large:largeNum,medium:1,small:0};
	}else{
		for(var i=0;i<=maxMediumNum;i++){
			if((ms-2*i)%3==0){
				if(result==undefined||result.medium==0||result.small==0){
					result = {large:largeNum,medium:i,small:(ms-2*i)/3};
					console.log(result);
				}
			}
			continue;
		}
		if(result==undefined){
			result = {large:largeNum,medium:maxMediumNum,small:1};
		}
	}
	console.log(result);
	return result;
}
