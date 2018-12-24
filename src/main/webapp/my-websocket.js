$(function () {

    var ws = null;

    $('#connectButton').on('click', function(event) {
       ws = new WebSocket('ws://localhost:8080/chat');
       ws.onmessage = function (message) {
           $('#messages').append('<div>' + message.data + '</div>');
       };
       ws.onerror = function () {
           $('#messages').append('<div>ERROR</div>');
       };
    });

    $('#sendButton').click(function (event) {
        ws.send($('#message').val());
        $('#message').val('');
    });
});
