/**
 * @param {number} n
 * @return {number}
 */
var fib = function(n) {
    const g = gen();
    while(n>0){
        g.next();
        n--;
    }
    return g.next().value;
};

function* gen(){
    let a = 0;
    let b = 1;
    while(true){
        yield a;
        [a,b] = [b,a+b];
    }
}