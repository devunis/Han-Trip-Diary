
var myInfo={
    name:'이진경',
    age:23,
    school:'과기대',
    major:'컴퓨터공학',
    number:'01021227745',
    birthMonth: 6,
    birthDay:4
}

var print=(json)=>{
console.log(json.name)
    
}
print(myInfo)


console.log(`제 생일은 ${myInfo.birthMonth}입니다`)




// 화살표 함수 사용하기
// var 함수명=(매개변수 ex.name)=>{

// }
var array=[1,2,3,4,5,6,7,8,9,10,11,12]
for(var i=0; i <array.length; i++)
{
    if(array[i]==myInfo.birthMonth)
    {
    console.log(`내 생일 달은 ${array[i]}월 이다`)
    }
}



    


