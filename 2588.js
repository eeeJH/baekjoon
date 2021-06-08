var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().split('\n');
var a = Number(input[0]);
var b = Number(input[1]);
var c = Number(input[1][2]);
var d = Number(input[1][1]);
var e = Number(input[1][0]);

console.log(a * c);
console.log(a * d);
console.log(a * e);
console.log(a * b);