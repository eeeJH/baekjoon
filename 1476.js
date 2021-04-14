// 예제 입력 1          예제 출력 1
// 1 16 16             16

// 예제 입력 2          예제 출력 2
// 1 1 1               1

// 예제 입력 3          예제 출력 3
// 1 2 3               5266

// 예제 입력 4          예제 출력 4
// 15 28 19            7980


// 방법 1
var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().split(' ');

var a15 = Number(input[0]);
var a28 = Number(input[1]);
var a19 = Number(input[2]);

var year = 0;

while(true){

    year++;

    if((year-a15)%15 === 0 && (year-a28)%28 === 0 && (year-a19)%19 === 0){
        break;
    }
}

console.log('답은 ?  ' + year);


// 방법 2
var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().split(' ');


var a15 = Number(input[0]);
var a28 = Number(input[1]);
var a19 = Number(input[2]);

var b15 = 0;
var b28 = 0;
var b19 = 0;

var year = 0;

for(year = 0;;year++) {


    console.log(year);


    if(b15 === a15 && b28 === a28 && b19 === a19){
        break;
    }

    b15++;
    b28++;
    b19++;


    if (b15 === 16) {
        b15 = 1;
    }

    if (b28 === 29) {
        b28 = 1;
    }

    if (b19 === 20) {
        b19 = 1;
    }
}


console.log('답은 ?  ' + year);


// 답은 맞는거 같은데 메모리 초과래요......
// ㅜㅜㅜ