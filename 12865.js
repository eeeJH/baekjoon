// 백준에서는 런타임 에러가 난다. 왜그럴까?
// 

var fs = require('fs');
var input = fs.readFileSync('/dev/stdin', 'utf8').toString().trim().split('\n');

var n = input[0][0];
var k = input[0][1];

var nList = [];
var i = 1;
for (i; i < n; i++) {
    nList.push(input[i]);
}

// nList 를 작은수부터 정렬한다. 첫번째 기준 무게 정렬, 두번째 기준 가치 정렬

// 1st sort
nList.sort(function (a, b) {
    return (a[0] - b[0]) || (a[1] - b[1]);
});

// 입력 데이터를 처리했다.
// 이제부터 문제해결
// 최대값을 result 라고 하자.
var result = 0;

// 가치합을 totalValue 라고 하자.
var totalValue = 0;

// 총 무게를 totalW 라고 하자.
var totalW = 0;

// 무게를 하나씩 더하면서 무게를 측정하자.
// i는 재사용하자.
for (i = 0; i < n; i++) {

    // 기준이 될 물건의 무게와 가치를 정하자.
    var j = i;

    // j는 i보다 작아야한다. i가 1씩 증가
    for (j; j < n; j++) {

        totalW += nList[j][0];

        if (totalW > k) {
            totalValue = 0;
            totalW = 0;
            break;
        } else {
            totalValue += nList[j][1];

            if (result < totalValue) {
                result = totalValue;
            }
        }
    }
}
