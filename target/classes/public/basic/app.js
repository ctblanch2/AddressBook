/**
 * Created by cameronblanchard on 2/16/2017.
 */

var book = (function book() {

    function init() {
        $('body').append($('<div id="div-list"</div>'));
        $('body').append($('<div id="div-buddyList"</div>'));
        $('body').append($('<button type="button">Add Buddies</button>').click(showBuddyDialog));
        $('body').append($('<div id="div-addBuddy"><p>Please select an address book</p></div>'));
        $("#div-addBuddy").dialog({
            autoOpen : false, modal : true, show : "blind", hide : "blind"
        });

    }

    function showBuddyDialog() {
        $('#div-addBuddy').dialog("open");
    }

    function removeBuddy(bookId, name){
        $.ajax({url: "/rest/removeBuddy", data: {id:bookId, name: name}, success: function(result){
            showBookNoEvent(bookId);
        }});
    }

    function addBuddy(id){
        var name = $('#nameField').val();
        var number = $('#numberField').val();
        var address = $('#addressField').val();
        console.log(name,number,address);

        $.ajax({url: "/rest/addBuddy", data: {id:id, name:name, number:number, address:address}, success: function(result){
            showBookNoEvent(id);
        }});
    }

    function addBuddyPanel(id) {
        $('#div-addBuddy').empty();
        $('#div-addBuddy').append($('<label>Name:<input id="nameField" type="text"></input></label>'))
                          .append($('<label>Number:<input id="numberField" type="text"></input></label>'))
                          .append($('<label>Address:<input id="addressField" type="text"></input></label>'))
                          .append($('<button type="button">Add Buddy</button>').click(addBuddy.bind(this, id)));
    }

    function showBookNoEvent(id) {
        $.ajax({url: "/rest/getBuddies", data: {id: id}, success: function(result){
            var table = $('<table></table>');
            var firstRow = $('<tr></tr>')
                .append($('<th>Name</th>'))
                .append($('<th>Number</th>'))
                .append($('<th>Address</th>'));
            table.append(firstRow);

            $.each(result, (index, buddy) => {
                var removeButton = $('<button type="button">Remove</button>')
                                    .click(removeBuddy.bind(this, id, buddy.name));

                var row  = $('<tr></tr>')
                    .append($('<td>' + buddy.name + '</td>'))
                    .append($('<td>' + buddy.number + '</td>'))
                    .append($('<td>' + buddy.address + '</td>'))
                    .append($('<td></td>').append(removeButton));
                table.append(row);
            });

            $('#div-buddyList').empty();
            $('#div-buddyList').append(table);
            addBuddyPanel(id);
        }});
    }

    function showBook(id, event) {
        event.preventDefault();
        showBookNoEvent(id);
    }

    function createBook(event) {
        event.preventDefault();
        var name = $('#addressBookName').val();
        $.ajax({url: "/rest/createAddressBook", data: { name: name }, success: function(result){
            listBooks();
        }});
    }

    function listBooks() {
        $.ajax({url: "/rest/listAddressBooks", success: function(result){
            bookList = $("<ul></ul>");

            $.each(result, (id, book) => {
                element = $('<li></li>');
                link = $('<a href=""></a>').text(book.name || book.id);
                link.click(showBook.bind(this,book.id));
                element.append(link);
                bookList.append(element);

            })

            $('#div-list').empty();
            $('#div-list').append(bookList);
        }});
    }

    return {
        createBook: createBook,
        listBooks: listBooks,
        init: init
    }
})();

$(()=>{
    book.init();
    $('#createAddressBook').click(book.createBook);
    book.listBooks();
});

