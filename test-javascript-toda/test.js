// 問１
// console.log('土田聖');

// 問2
// let firstName = 'Sho';
// let lastName = 'Toda';

// console.log(firstName + " " + lastName);

// 問3
// function keisan () {
//     let syoukei = (200*3) + (250*4);
//     let syouhizei = syoukei * 0.1;
//     let sum = syoukei + syouhizei;
    
//     console.log('小計');
//     console.log(syoukei);
//     console.log('消費税');
//     console.log(syouhizei);
//     console.log('合計金額');
//     console.log(sum);
// }

// keisan();

// 問4
// let testScore = 101;

// if (testScore >= 0 && testScore <= 79) {
//     console.log('追試です');
// } else if (testScore >= 80 && testScore <= 100) {
//     console.log('合格です');
// } else {
//     console.log('存在しない点数です');
// }

// 問5
// let sum = 0;
// for (let i = 1; i <= 100; i++) {
//     sum += i;
// }

// console.log(sum);

// 問6
function add(num1, num2) {
    return num1 + "+" + num2 + "=" + (num1 + num2);
}

function sub(num1, num2) {
    return num1 + "-" + num2 + "=" + (num1 - num2);
}

function multi(num1, num2) {
    return num1 + "*" + num2 + "=" + (num1 * num2);
}

function div(num1, num2) {
    return num1 + "/" + num2 + "=" + (num1 / num2);
}

console.log(add(5, 3));
console.log(sub(5, 3));
console.log(multi(5, 3));
console.log(div(5, 3));
