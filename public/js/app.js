$(document).ready(function() {
    $.ajax({
        url: "/books-list"
    }).then(function(data) {
        var html = "";

        for(var key in data){
            var book = data[key];
            html += "<div class='book'>" +
              "<h4>" + book.code + ". " + book.title + "</h4>" +
             "<div>"+ book.author + " - " + book.yearPublished +"</div>" +
            "</div>";
        }
        $('.books-list').append(html);
    });
});