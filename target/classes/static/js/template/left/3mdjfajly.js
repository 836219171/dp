// 矛盾纠纷案件来源
    // commons.leftQuery({}).then(function(res){
function mdjfajly(res){
    var arr = [];
    var edits = [];
    var data = res[0].blockThree.resultOne;
    edits = data;
    for(var i in data){
        for(var j in data[i]){
            arr.push(data[i][j]);
        }  
    }
    paixun(arr,edits)
}
function paixun(arr,edit){
    var max = '';
    var arrArray = [];
    var editArray = [];
    function show(a,b){
        return a-b;
    }
    arrArray = arr.sort(show);
    for(var i in edit){
        for(var j in edit[i]){
            if(edit[i][j] == arrArray[0]){
                editArray.unshift(j)
            } else if(edit[i][j] == arrArray[1]){
                if(editArray.length == 1){
                    editArray.push(j)
                } else {
                    editArray.splice(1,0,j)
                }
            } else {
                if(editArray.length == 0){
                    max = j;
                } else if(editArray.length == 1){
                    max = j;
                } else {
                    max = j;
                }
            }
        }
    }
    editArray.push(max);
    // console.log(editArray)
    $(".mdjfajly .first .ball span").html(arrArray[0]);
    $(".mdjfajly .first .line span").html(editArray[0]);
    $(".mdjfajly .second .ball span").html(arrArray[2]);
    $(".mdjfajly .second .line span").html(editArray[2]);
    $(".mdjfajly .three .ball span").html(arrArray[1]);
    $(".mdjfajly .three .line span").html(editArray[1]);
}