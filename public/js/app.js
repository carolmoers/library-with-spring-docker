$(document).ready(function() {
    $.ajax({
        url: "/books-list"
    }).then(function(data) {
       $('.books-list').append(data.content);
    });
});