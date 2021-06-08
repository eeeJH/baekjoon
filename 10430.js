var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().split(' ');
var a = Number(input[0]);
var b = Number(input[1]);
var c = Number(input[2]);

console.log((a + b) % c);
console.log(((a % c) + (b % c)) % c);
console.log((a * b) % c);
console.log(((a % c) * (b % c)) % c);