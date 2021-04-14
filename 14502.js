var fs = require('fs');
//const { BADFLAGS } = require('node:dns');
var input = fs.readFileSync('/dev/stdin', 'utf8').toString().trim().split('\n');
var data = input[0].toString().trim().split(' ');

var n, m;
var alist = Array.from(Array(8), () => new Array(8));


// 상하좌우
var dy = [-1, 1, 0, 0];
var dx = [0, 0, -1, 1];

n = Number(data[0]);
m = Number(data[1]);

function bfs() {
    var q = new Queue();
    var backup = Array.from(Array(8), () => new Array(8));
    var visited = Array.from(Array(8), () => Array(2).fill(0));

    for (var y = 0; y < n; y++) {
        for (var x = 0; x < m; x++) {
            backup[y][x] = alist[y][x];
            if (backup[y][x] == 2) {
                q.enqueue(y * 10 + x);
                visited[y][x] = 1;
            }
        }
    }

    while (q.size() != 0) {
        var cur = q.front(); q.dequeue();

        var cy = cur / 10;
        var cx = cur % 10;

        backup[cy][cx] = 2;

        for (var dir = 0; dir < 4; dir++) {
            var ny = cy + dy[dir];
            var nx = cx + dx[dir];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                continue;
            }

            if (visited[ny][nx] == 0 && backup[ny][nx] == 0) {
                visited[ny][nx] = 1;
                q.push(ny * 10 + nx);
            }
        }
    }

    var candi = 0;
    for (var y = 0; y < n; y++) {
        for (var x = 0; x < m; x++) {
            if (backup[y][x] == 0) {
                candi++;
            }
        }
    }

    if (ret < candi) {
        ret = candi;
    }
}


function pick_dfs(count, sy, sx) {
    if (count === 3) {
        //TODO something...
        bfs();
        return;
    }

    for (var y = sy; y < n; y++) {
        for (var x = sx; x < m; x++) {
            if (alist[y][x] === 0) {
                alist[y][x] = 1;
                pick_dfs(count + 1, y, x);
                alist[y][x] = 0;
            }
        }
        sx = 0;
    }
}


class Queue {
    constructor() {
        this._arr = [];
    }
    enqueue(item) {
        this._arr.push(item);
    }
    dequeue() {
        return this._arr.shift();
    }
    size() {
        return this._arr.length();
    }
    front() {
        return this._arr[0];
    }
}

for (var y = 0; y < n; y++) {

    var temp = input[y + 1].toString().trim().split(' ');

    for (var x = 0; x < m; x++) {
        alist[y][x] = Number(temp[y + 1][x]);
    }
}

pick_dfs(0, 0, 0);

console.log(ret);

// 못풀었습니다.