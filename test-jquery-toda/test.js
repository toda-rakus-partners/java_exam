// 問1
// $(function() {
//     console.log('土田聖');
// })

// 問2
// $('#btn').on('click', () => {
//     $('#name').css("color", "red");
// });

// 問3
// $('#btn').on('click', () => {
//     alert($('#age').val());
// })

// 問4
// $('#btn').on('click', () => {
//     $('#btn').prop({disabled: true});
// }) 

// 問5
$('#select').on('change', () => {
    if ($('#select').val() == 1) {
        $('#result').text('System.out.println("Hello World");');
    } else if ($('#select').val() == 2) {
        $('#result').text('console.log("Hello World");');
    } else {
        $('#result').text("");
    }
})
