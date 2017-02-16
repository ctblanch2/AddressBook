/**
 * Created by cameronblanchard on 2/16/2017.
 */
$(()=>{
    $.ajax({url: "/rest/listAddressBooks", success: function(result){
        bookList = $("<ul></ul>");
        $.each(result, (book) => {
            element = $('<li></li>');
            li = $('<a></a>');
            li.value = book.name + " " + book.id;
            element.append(li);
            bookList.append($('<li></li>'));
            console.log(book);
        })
        $('body').append(bookList);
    }});
});